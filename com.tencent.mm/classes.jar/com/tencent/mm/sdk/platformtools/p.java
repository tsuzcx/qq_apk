package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;

public final class p
{
  public ArrayMap<String, Object> ueu = null;
  public boolean uev = false;
  
  private static void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was a ");
    localStringBuilder.append(paramObject1.getClass().getName());
    localStringBuilder.append(".  The default value ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(" was returned.");
    y.w("MicroMsg.ImmutableBundle", localStringBuilder.toString());
    y.w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", new Object[] { paramClassCastException });
  }
  
  public final boolean Zd(String paramString)
  {
    Object localObject = this.ueu.get(paramString);
    if (localObject == null) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "Boolean", Boolean.valueOf(false), localClassCastException);
    }
    return false;
  }
  
  public final String getString(String paramString)
  {
    Object localObject = this.ueu.get(paramString);
    try
    {
      String str = (String)localObject;
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      a(paramString, localObject, "String", "<null>", localClassCastException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.p
 * JD-Core Version:    0.7.0.1
 */