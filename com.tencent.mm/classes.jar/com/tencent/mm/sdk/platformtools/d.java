package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlot", "()Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"})
public abstract class d<T>
{
  final boolean[] ETg;
  private final long ETh;
  private final int gXR;
  private final String htS;
  
  private d(long paramLong)
  {
    this.ETh = paramLong;
    this.gXR = 3;
    StringBuilder localStringBuilder = new StringBuilder("_slots_id");
    if (this.ETh == 900L) {}
    for (Object localObject = "";; localObject = "_" + this.ETh)
    {
      this.htS = ((String)localObject + '_');
      int j = this.gXR;
      localObject = new boolean[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = 0;
        i += 1;
      }
    }
    this.ETg = ((boolean[])localObject);
  }
  
  private final String We(int paramInt)
  {
    return getPrefix() + paramInt % this.gXR;
  }
  
  private final long eEV()
  {
    return System.currentTimeMillis() / (this.ETh * 1000L);
  }
  
  public final T aFe(String paramString)
  {
    k.h(paramString, "key");
    eEW();
    long l = eEV();
    a locala = new a(this);
    Object localObject = locala.I(l, paramString);
    if (localObject != null) {
      paramString = localObject;
    }
    do
    {
      return paramString;
      localObject = locala.I(l - 1L, paramString);
      paramString = localObject;
    } while (localObject != null);
    return null;
  }
  
  protected abstract void bO(String paramString, long paramLong);
  
  protected abstract boolean bP(String paramString, long paramLong);
  
  protected abstract T bQ(String paramString, long paramLong);
  
  protected abstract void c(long paramLong, T paramT);
  
  public final void clearAll()
  {
    int i = 0;
    int j = this.gXR;
    if (j >= 0) {
      for (;;)
      {
        c(-1L, a(this, We(i)));
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  protected abstract boolean e(T paramT, String paramString);
  
  public final void eEW()
  {
    long l2 = eEV();
    long l1 = l2 - 1L;
    long l3 = l2 + 1L;
    if (l1 <= l3) {
      for (;;)
      {
        int i = vy(l1);
        String str = We(i);
        if ((this.ETg[i] == 0) && (!bP(str, l1)))
        {
          c(l1, a(this, str));
          this.ETg[i] = true;
          if (l1 == l2) {
            bO(str, l1);
          }
        }
        if (l1 == l3) {
          break;
        }
        l1 += 1L;
      }
    }
  }
  
  public final T eEX()
  {
    eEW();
    long l = eEV();
    return bQ(We(vy(l)), l);
  }
  
  protected String getPrefix()
  {
    return this.htS;
  }
  
  final int vy(long paramLong)
  {
    return (int)((paramLong % this.gXR + this.gXR) % 3L);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"checkSlot", "T", "slotId", "", "key", "", "invoke", "(JLjava/lang/String;)Ljava/lang/Object;"})
  static final class a
    extends d.g.b.l
    implements m<Long, String, T>
  {
    a(d paramd)
    {
      super();
    }
    
    public final T I(long paramLong, String paramString)
    {
      AppMethodBeat.i(156369);
      k.h(paramString, "key");
      int i = this.ETi.vy(paramLong);
      Object localObject = this.ETi.bQ(d.a(this.ETi, i), paramLong);
      if (this.ETi.e(localObject, paramString))
      {
        this.ETi.ETg[i] = false;
        AppMethodBeat.o(156369);
        return localObject;
      }
      AppMethodBeat.o(156369);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */