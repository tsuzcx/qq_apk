package com.google.android.gms.wearable;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class n
{
  private final HashMap<String, Object> Sr = new HashMap();
  
  public final void a(String paramString, Asset paramAsset)
  {
    this.Sr.put(paramString, paramAsset);
  }
  
  public final void a(String paramString, n paramn)
  {
    this.Sr.put(paramString, paramn);
  }
  
  public final void a(String paramString, ArrayList<n> paramArrayList)
  {
    this.Sr.put(paramString, paramArrayList);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof n)) {
      return false;
    }
    paramObject = (n)paramObject;
    if (this.Sr.size() != paramObject.Sr.size()) {
      return false;
    }
    Iterator localIterator = this.Sr.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = get((String)localObject2);
      localObject2 = paramObject.get((String)localObject2);
      if ((localObject1 instanceof Asset))
      {
        if (!(localObject2 instanceof Asset)) {
          return false;
        }
        localObject1 = (Asset)localObject1;
        localObject2 = (Asset)localObject2;
        boolean bool;
        if ((localObject1 == null) || (localObject2 == null)) {
          if (localObject1 == localObject2) {
            bool = true;
          }
        }
        while (!bool)
        {
          return false;
          bool = false;
          continue;
          if (!TextUtils.isEmpty(((Asset)localObject1).kp())) {
            bool = ((Asset)localObject1).kp().equals(((Asset)localObject2).kp());
          } else {
            bool = Arrays.equals(((Asset)localObject1).getData(), ((Asset)localObject2).getData());
          }
        }
      }
      else if ((localObject1 instanceof String[]))
      {
        if (!(localObject2 instanceof String[])) {
          return false;
        }
        if (!Arrays.equals((String[])localObject1, (String[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof long[]))
      {
        if (!(localObject2 instanceof long[])) {
          return false;
        }
        if (!Arrays.equals((long[])localObject1, (long[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof float[]))
      {
        if (!(localObject2 instanceof float[])) {
          return false;
        }
        if (!Arrays.equals((float[])localObject1, (float[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof byte[]))
      {
        if (!(localObject2 instanceof byte[])) {
          return false;
        }
        if (!Arrays.equals((byte[])localObject1, (byte[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 == null) || (localObject2 == null))
      {
        if (localObject1 != localObject2) {
          return false;
        }
      }
      else if (!localObject1.equals(localObject2))
      {
        return false;
      }
    }
    return true;
  }
  
  public final <T> T get(String paramString)
  {
    return this.Sr.get(paramString);
  }
  
  public final int hashCode()
  {
    return this.Sr.hashCode() * 29;
  }
  
  public final Set<String> keySet()
  {
    return this.Sr.keySet();
  }
  
  public final void putBoolean(String paramString, boolean paramBoolean)
  {
    this.Sr.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public final void putByte(String paramString, byte paramByte)
  {
    this.Sr.put(paramString, Byte.valueOf(paramByte));
  }
  
  public final void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.Sr.put(paramString, paramArrayOfByte);
  }
  
  public final void putDouble(String paramString, double paramDouble)
  {
    this.Sr.put(paramString, Double.valueOf(paramDouble));
  }
  
  public final void putFloat(String paramString, float paramFloat)
  {
    this.Sr.put(paramString, Float.valueOf(paramFloat));
  }
  
  public final void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    this.Sr.put(paramString, paramArrayOfFloat);
  }
  
  public final void putInt(String paramString, int paramInt)
  {
    this.Sr.put(paramString, Integer.valueOf(paramInt));
  }
  
  public final void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.Sr.put(paramString, paramArrayList);
  }
  
  public final void putLong(String paramString, long paramLong)
  {
    this.Sr.put(paramString, Long.valueOf(paramLong));
  }
  
  public final void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    this.Sr.put(paramString, paramArrayOfLong);
  }
  
  public final void putString(String paramString1, String paramString2)
  {
    this.Sr.put(paramString1, paramString2);
  }
  
  public final void putStringArray(String paramString, String[] paramArrayOfString)
  {
    this.Sr.put(paramString, paramArrayOfString);
  }
  
  public final void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    this.Sr.put(paramString, paramArrayList);
  }
  
  public final String toString()
  {
    return this.Sr.toString();
  }
  
  public final Asset u(String paramString)
  {
    Object localObject = this.Sr.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      Asset localAsset = (Asset)localObject;
      return localAsset;
    }
    catch (ClassCastException localClassCastException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Key ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" expected ");
      localStringBuilder.append("Asset");
      localStringBuilder.append(" but value was a ");
      localStringBuilder.append(localObject.getClass().getName());
      localStringBuilder.append(".  The default value ");
      localStringBuilder.append("<null>");
      localStringBuilder.append(" was returned.");
      Log.w("DataMap", localStringBuilder.toString());
      Log.w("DataMap", "Attempt to cast generated internal exception:", localClassCastException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.n
 * JD-Core Version:    0.7.0.1
 */