package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlot", "()Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"})
public abstract class f<T>
{
  final long[] Iws;
  private final long Iwt;
  private final int hTC;
  private final String iqJ;
  
  private f(long paramLong)
  {
    this.Iwt = paramLong;
    this.hTC = 3;
    StringBuilder localStringBuilder = new StringBuilder("_slots_id");
    if (this.Iwt == 900L) {}
    for (Object localObject = "";; localObject = "_" + this.Iwt)
    {
      this.iqJ = ((String)localObject + '_');
      int j = this.hTC;
      localObject = new long[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = -1L;
        i += 1;
      }
    }
    this.Iws = ((long[])localObject);
  }
  
  private final String aaY(int paramInt)
  {
    return getPrefix() + paramInt % this.hTC;
  }
  
  private final long fnN()
  {
    return System.currentTimeMillis() / (this.Iwt * 1000L);
  }
  
  final int Dp(long paramLong)
  {
    return (int)((paramLong % this.hTC + this.hTC) % 3L);
  }
  
  public final T aRy(String paramString)
  {
    p.h(paramString, "key");
    fnO();
    long l = fnN();
    a locala = new a(this);
    Object localObject = locala.M(l, paramString);
    if (localObject != null) {
      paramString = localObject;
    }
    do
    {
      return paramString;
      localObject = locala.M(l - 1L, paramString);
      paramString = localObject;
    } while (localObject != null);
    return null;
  }
  
  protected abstract void bV(String paramString, long paramLong);
  
  protected abstract boolean bW(String paramString, long paramLong);
  
  protected abstract T bX(String paramString, long paramLong);
  
  public final void clearAll()
  {
    int i = 0;
    int j = this.hTC;
    if (j >= 0) {
      for (;;)
      {
        d(-1L, a(this, aaY(i)));
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  protected abstract void d(long paramLong, T paramT);
  
  protected abstract boolean e(T paramT, String paramString);
  
  public final void fnO()
  {
    long l2 = fnN();
    long l1 = l2 - 1L;
    long l3 = l2 + 1L;
    if (l1 <= l3) {
      for (;;)
      {
        int i = Dp(l1);
        String str = aaY(i);
        if (this.Iws[i] != l1)
        {
          if (!bW(str, l1))
          {
            d(l1, a(this, str));
            if (l1 == l2) {
              bV(str, l1);
            }
          }
          this.Iws[i] = l1;
        }
        if (l1 == l3) {
          break;
        }
        l1 += 1L;
      }
    }
  }
  
  public final T fnP()
  {
    fnO();
    long l = fnN();
    return bX(aaY(Dp(l)), l);
  }
  
  protected String getPrefix()
  {
    return this.iqJ;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"checkSlot", "T", "slotId", "", "key", "", "invoke", "(JLjava/lang/String;)Ljava/lang/Object;"})
  static final class a
    extends q
    implements m<Long, String, T>
  {
    a(f paramf)
    {
      super();
    }
    
    public final T M(long paramLong, String paramString)
    {
      AppMethodBeat.i(156369);
      p.h(paramString, "key");
      int i = this.Iwu.Dp(paramLong);
      Object localObject = this.Iwu.bX(f.a(this.Iwu, i), paramLong);
      if (this.Iwu.e(localObject, paramString))
      {
        this.Iwu.Iws[i] = -1L;
        AppMethodBeat.o(156369);
        return localObject;
      }
      AppMethodBeat.o(156369);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */