package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.a.a;

public abstract interface ci
  extends IInterface
{
  public abstract boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract int getIntFlagValue(String paramString, int paramInt1, int paramInt2);
  
  public abstract long getLongFlagValue(String paramString, long paramLong, int paramInt);
  
  public abstract String getStringFlagValue(String paramString1, String paramString2, int paramInt);
  
  public abstract void init(a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ci
 * JD-Core Version:    0.7.0.1
 */