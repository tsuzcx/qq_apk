package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlot", "()Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"})
public abstract class e<T>
{
  final boolean[] Ich;
  private final long Ici;
  private final int hQK;
  private final String inP;
  
  private e(long paramLong)
  {
    this.Ici = paramLong;
    this.hQK = 3;
    StringBuilder localStringBuilder = new StringBuilder("_slots_id");
    if (this.Ici == 900L) {}
    for (Object localObject = "";; localObject = "_" + this.Ici)
    {
      this.inP = ((String)localObject + '_');
      int j = this.hQK;
      localObject = new boolean[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = 0;
        i += 1;
      }
    }
    this.Ich = ((boolean[])localObject);
  }
  
  private final String aas(int paramInt)
  {
    return getPrefix() + paramInt % this.hQK;
  }
  
  private final long fjT()
  {
    return System.currentTimeMillis() / (this.Ici * 1000L);
  }
  
  final int CR(long paramLong)
  {
    return (int)((paramLong % this.hQK + this.hQK) % 3L);
  }
  
  public final T aQb(String paramString)
  {
    p.h(paramString, "key");
    fjU();
    long l = fjT();
    a locala = new a(this);
    Object localObject = locala.L(l, paramString);
    if (localObject != null) {
      paramString = localObject;
    }
    do
    {
      return paramString;
      localObject = locala.L(l - 1L, paramString);
      paramString = localObject;
    } while (localObject != null);
    return null;
  }
  
  protected abstract void bU(String paramString, long paramLong);
  
  protected abstract boolean bV(String paramString, long paramLong);
  
  protected abstract T bW(String paramString, long paramLong);
  
  protected abstract void c(long paramLong, T paramT);
  
  public final void clearAll()
  {
    int i = 0;
    int j = this.hQK;
    if (j >= 0) {
      for (;;)
      {
        c(-1L, a(this, aas(i)));
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  protected abstract boolean e(T paramT, String paramString);
  
  public final void fjU()
  {
    long l2 = fjT();
    long l1 = l2 - 1L;
    long l3 = l2 + 1L;
    if (l1 <= l3) {
      for (;;)
      {
        int i = CR(l1);
        String str = aas(i);
        if ((this.Ich[i] == 0) && (!bV(str, l1)))
        {
          c(l1, a(this, str));
          this.Ich[i] = true;
          if (l1 == l2) {
            bU(str, l1);
          }
        }
        if (l1 == l3) {
          break;
        }
        l1 += 1L;
      }
    }
  }
  
  public final T fjV()
  {
    fjU();
    long l = fjT();
    return bW(aas(CR(l)), l);
  }
  
  protected String getPrefix()
  {
    return this.inP;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"checkSlot", "T", "slotId", "", "key", "", "invoke", "(JLjava/lang/String;)Ljava/lang/Object;"})
  static final class a
    extends q
    implements m<Long, String, T>
  {
    a(e parame)
    {
      super();
    }
    
    public final T L(long paramLong, String paramString)
    {
      AppMethodBeat.i(156369);
      p.h(paramString, "key");
      int i = this.Icj.CR(paramLong);
      Object localObject = this.Icj.bW(e.a(this.Icj, i), paramLong);
      if (this.Icj.e(localObject, paramString))
      {
        this.Icj.Ich[i] = false;
        AppMethodBeat.o(156369);
        return localObject;
      }
      AppMethodBeat.o(156369);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.e
 * JD-Core Version:    0.7.0.1
 */