package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class ag
{
  private final String Mg;
  private final String Mh;
  private final ComponentName Mi;
  
  public ag(String paramString1, String paramString2)
  {
    this.Mg = d.l(paramString1);
    this.Mh = d.l(paramString2);
    this.Mi = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ag)) {
        return false;
      }
      paramObject = (ag)paramObject;
    } while ((b.c(this.Mg, paramObject.Mg)) && (b.c(this.Mi, paramObject.Mi)));
    return false;
  }
  
  public final ComponentName getComponentName()
  {
    return this.Mi;
  }
  
  public final String getPackage()
  {
    return this.Mh;
  }
  
  public final Intent hH()
  {
    if (this.Mg != null) {
      return new Intent(this.Mg).setPackage(this.Mh);
    }
    return new Intent().setComponent(this.Mi);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.Mg, this.Mi });
  }
  
  public final String toString()
  {
    if (this.Mg == null) {
      return this.Mi.flattenToString();
    }
    return this.Mg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ag
 * JD-Core Version:    0.7.0.1
 */