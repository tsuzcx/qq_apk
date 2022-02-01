package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlot", "()Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"})
public abstract class d<T>
{
  final boolean[] Gqt;
  private final long Gqu;
  private final String hUu;
  private final int hyq;
  
  private d(long paramLong)
  {
    this.Gqu = paramLong;
    this.hyq = 3;
    StringBuilder localStringBuilder = new StringBuilder("_slots_id");
    if (this.Gqu == 900L) {}
    for (Object localObject = "";; localObject = "_" + this.Gqu)
    {
      this.hUu = ((String)localObject + '_');
      int j = this.hyq;
      localObject = new boolean[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = 0;
        i += 1;
      }
    }
    this.Gqt = ((boolean[])localObject);
  }
  
  private final String Yn(int paramInt)
  {
    return getPrefix() + paramInt % this.hyq;
  }
  
  private final long eUp()
  {
    return System.currentTimeMillis() / (this.Gqu * 1000L);
  }
  
  final int Ab(long paramLong)
  {
    return (int)((paramLong % this.hyq + this.hyq) % 3L);
  }
  
  public final T aKv(String paramString)
  {
    k.h(paramString, "key");
    eUq();
    long l = eUp();
    a locala = new a(this);
    Object localObject = locala.G(l, paramString);
    if (localObject != null) {
      paramString = localObject;
    }
    do
    {
      return paramString;
      localObject = locala.G(l - 1L, paramString);
      paramString = localObject;
    } while (localObject != null);
    return null;
  }
  
  protected abstract void bQ(String paramString, long paramLong);
  
  protected abstract boolean bR(String paramString, long paramLong);
  
  protected abstract T bS(String paramString, long paramLong);
  
  protected abstract void c(long paramLong, T paramT);
  
  public final void clearAll()
  {
    int i = 0;
    int j = this.hyq;
    if (j >= 0) {
      for (;;)
      {
        c(-1L, a(this, Yn(i)));
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  protected abstract boolean e(T paramT, String paramString);
  
  public final void eUq()
  {
    long l2 = eUp();
    long l1 = l2 - 1L;
    long l3 = l2 + 1L;
    if (l1 <= l3) {
      for (;;)
      {
        int i = Ab(l1);
        String str = Yn(i);
        if ((this.Gqt[i] == 0) && (!bR(str, l1)))
        {
          c(l1, a(this, str));
          this.Gqt[i] = true;
          if (l1 == l2) {
            bQ(str, l1);
          }
        }
        if (l1 == l3) {
          break;
        }
        l1 += 1L;
      }
    }
  }
  
  public final T eUr()
  {
    eUq();
    long l = eUp();
    return bS(Yn(Ab(l)), l);
  }
  
  protected String getPrefix()
  {
    return this.hUu;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"checkSlot", "T", "slotId", "", "key", "", "invoke", "(JLjava/lang/String;)Ljava/lang/Object;"})
  static final class a
    extends d.g.b.l
    implements m<Long, String, T>
  {
    a(d paramd)
    {
      super();
    }
    
    public final T G(long paramLong, String paramString)
    {
      AppMethodBeat.i(156369);
      k.h(paramString, "key");
      int i = this.Gqv.Ab(paramLong);
      Object localObject = this.Gqv.bS(d.a(this.Gqv, i), paramLong);
      if (this.Gqv.e(localObject, paramString))
      {
        this.Gqv.Gqt[i] = false;
        AppMethodBeat.o(156369);
        return localObject;
      }
      AppMethodBeat.o(156369);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */