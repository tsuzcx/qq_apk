package com.tencent.mm.sdk.platformtools;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "T", "", "soltSeconds", "", "SLOT_SIZE", "", "(JI)V", "currentSlotId", "getCurrentSlotId", "()J", "lastCurrentId", "getLastCurrentId", "setLastCurrentId", "(J)V", "prefix", "", "getPrefix", "()Ljava/lang/String;", "verifiedCache", "", "key", "getKey", "(I)Ljava/lang/String;", "toSlot", "getToSlot", "(J)I", "clearAll", "", "clearSlot", "slotId", "slot", "(JLjava/lang/Object;)V", "containsKey", "", "(Ljava/lang/Object;Ljava/lang/String;)Z", "findSlot", "(Ljava/lang/String;)Ljava/lang/Object;", "getSlotByKey", "slotKey", "(Ljava/lang/String;J)Ljava/lang/Object;", "getSlotForWrite", "()Ljava/lang/Object;", "remarkSlot", "verifyAllSlot", "verifySlot", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseSlotManager<T>
{
  private final int SLOT_SIZE;
  private long lastCurrentId;
  private final String prefix;
  private final long soltSeconds;
  private final long[] verifiedCache;
  
  public BaseSlotManager()
  {
    this(0L, 0, 3, null);
  }
  
  public BaseSlotManager(long paramLong, int paramInt)
  {
    this.soltSeconds = paramLong;
    this.SLOT_SIZE = paramInt;
    StringBuilder localStringBuilder = new StringBuilder("_slots_id");
    if (this.soltSeconds == 900L) {}
    for (Object localObject = "";; localObject = s.X("_", Long.valueOf(this.soltSeconds)))
    {
      this.prefix = ((String)localObject + '_');
      paramInt = 0;
      int i = this.SLOT_SIZE;
      localObject = new long[i];
      while (paramInt < i)
      {
        localObject[paramInt] = -1L;
        paramInt += 1;
      }
    }
    this.verifiedCache = ((long[])localObject);
    this.lastCurrentId = getCurrentSlotId();
  }
  
  private static final <T> T findSlot$checkSlot(BaseSlotManager<T> paramBaseSlotManager, long paramLong, String paramString)
  {
    int i = paramBaseSlotManager.getToSlot(paramLong);
    Object localObject = paramBaseSlotManager.getSlotByKey(paramBaseSlotManager.getKey(i), paramLong);
    if (paramBaseSlotManager.containsKey(localObject, paramString))
    {
      paramBaseSlotManager.verifiedCache[i] = -1L;
      return localObject;
    }
    return null;
  }
  
  private final long getCurrentSlotId()
  {
    return MMSlotKt.now() / (this.soltSeconds * 1000L);
  }
  
  private final String getKey(int paramInt)
  {
    return s.X(getPrefix(), Integer.valueOf(paramInt % this.SLOT_SIZE));
  }
  
  private final int getToSlot(long paramLong)
  {
    return (int)((paramLong % this.SLOT_SIZE + this.SLOT_SIZE) % 3L);
  }
  
  public final void clearAll()
  {
    int j = this.SLOT_SIZE;
    int i;
    if (j >= 0) {
      i = 0;
    }
    for (;;)
    {
      clearSlot(-1L, getSlotByKey$default(this, getKey(i), 0L, 2, null));
      if (i == j) {
        return;
      }
      i += 1;
    }
  }
  
  protected abstract void clearSlot(long paramLong, T paramT);
  
  protected abstract boolean containsKey(T paramT, String paramString);
  
  public final T findSlot(String paramString)
  {
    s.u(paramString, "key");
    verifyAllSlot();
    long l = getCurrentSlotId();
    Object localObject = findSlot$checkSlot(this, l, paramString);
    if (localObject != null) {
      paramString = localObject;
    }
    do
    {
      return paramString;
      localObject = findSlot$checkSlot(this, l - 1L, paramString);
      paramString = localObject;
    } while (localObject != null);
    return null;
  }
  
  public final long getLastCurrentId()
  {
    return this.lastCurrentId;
  }
  
  protected String getPrefix()
  {
    return this.prefix;
  }
  
  protected abstract T getSlotByKey(String paramString, long paramLong);
  
  public final T getSlotForWrite()
  {
    verifyAllSlot();
    long l = getCurrentSlotId();
    return getSlotByKey(getKey(getToSlot(l)), l);
  }
  
  protected abstract void remarkSlot(String paramString, long paramLong);
  
  public final void setLastCurrentId(long paramLong)
  {
    this.lastCurrentId = paramLong;
  }
  
  public final void verifyAllSlot()
  {
    long l2 = getCurrentSlotId();
    int i;
    long l1;
    long l3;
    if (this.lastCurrentId != l2)
    {
      i = 1;
      this.lastCurrentId = l2;
      l1 = l2 - 1L;
      l3 = l2 + 1L;
      if (l1 > l3) {}
    }
    for (;;)
    {
      int j = getToSlot(l1);
      String str = getKey(j);
      if ((i != 0) || (this.verifiedCache[j] != l1))
      {
        if (!verifySlot(str, l1))
        {
          clearSlot(l1, getSlotByKey$default(this, str, 0L, 2, null));
          if (l1 == l2) {
            remarkSlot(str, l1);
          }
        }
        this.verifiedCache[j] = l1;
      }
      if (l1 == l3)
      {
        return;
        i = 0;
        break;
      }
      l1 += 1L;
    }
  }
  
  protected abstract boolean verifySlot(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BaseSlotManager
 * JD-Core Version:    0.7.0.1
 */