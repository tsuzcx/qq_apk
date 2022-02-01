package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzacs
{
  protected static <O, I> I a(zzacs.zza<I, O> paramzza, Object paramObject)
  {
    Object localObject = paramObject;
    if (zzacs.zza.a(paramzza) != null) {
      localObject = paramzza.convertBack(paramObject);
    }
    return localObject;
  }
  
  public abstract Map<String, zzacs.zza<?, ?>> ju();
  
  protected abstract boolean jv();
  
  public String toString()
  {
    Map localMap = ju();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      zzacs.zza localzza = (zzacs.zza)localMap.get((String)localIterator.next());
      if (localzza.jy() == 11)
      {
        if (localzza.jz()) {
          throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
      }
      jv();
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacs
 * JD-Core Version:    0.7.0.1
 */