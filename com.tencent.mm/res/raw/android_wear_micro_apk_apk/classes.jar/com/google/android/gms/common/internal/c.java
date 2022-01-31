package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class c
{
  private final List<String> IZ;
  private final Object Ja;
  
  private c(Object paramObject)
  {
    this.Ja = d.u(paramObject);
    this.IZ = new ArrayList();
  }
  
  public final c a(String paramString, Object paramObject)
  {
    List localList = this.IZ;
    paramString = (String)d.u(paramString);
    paramObject = String.valueOf(String.valueOf(paramObject));
    localList.add(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + "=" + paramObject);
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.Ja.getClass().getSimpleName()).append('{');
    int j = this.IZ.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.IZ.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.c
 * JD-Core Version:    0.7.0.1
 */