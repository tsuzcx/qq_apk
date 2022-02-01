package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.cl;

@DynamiteApi
public class FlagProviderImpl
  extends cj
{
  private boolean NA = false;
  private SharedPreferences NB;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!this.NA) {
      return paramBoolean;
    }
    return ((Boolean)cl.a(new b.1(this.NB, paramString, Boolean.valueOf(paramBoolean)))).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.NA) {
      return paramInt1;
    }
    return ((Integer)cl.a(new c.1(this.NB, paramString, Integer.valueOf(paramInt1)))).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!this.NA) {
      return paramLong;
    }
    return ((Long)cl.a(new d.1(this.NB, paramString, Long.valueOf(paramLong)))).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!this.NA) {
      return paramString2;
    }
    return (String)cl.a(new e.1(this.NB, paramString1, paramString2));
  }
  
  public void init(a parama)
  {
    parama = (Context)d.a(parama);
    if (this.NA) {
      return;
    }
    try
    {
      this.NB = f.s(parama.createPackageContext("com.google.android.gms", 0));
      this.NA = true;
      return;
    }
    catch (PackageManager.NameNotFoundException parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.flags.impl.FlagProviderImpl
 * JD-Core Version:    0.7.0.1
 */