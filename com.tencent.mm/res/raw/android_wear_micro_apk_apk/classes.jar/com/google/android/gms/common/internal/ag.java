package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class ag
{
  private final String Kr;
  private final String Ks;
  private final ComponentName Kt;
  
  public ag(String paramString1, String paramString2)
  {
    this.Kr = d.l(paramString1);
    this.Ks = d.l(paramString2);
    this.Kt = null;
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
    } while ((b.b(this.Kr, paramObject.Kr)) && (b.b(this.Kt, paramObject.Kt)));
    return false;
  }
  
  public final ComponentName getComponentName()
  {
    return this.Kt;
  }
  
  public final String getPackage()
  {
    return this.Ks;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.Kr, this.Kt });
  }
  
  public final Intent hx()
  {
    if (this.Kr != null) {
      return new Intent(this.Kr).setPackage(this.Ks);
    }
    return new Intent().setComponent(this.Kt);
  }
  
  public final String toString()
  {
    if (this.Kr == null) {
      return this.Kt.flattenToString();
    }
    return this.Kr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ag
 * JD-Core Version:    0.7.0.1
 */