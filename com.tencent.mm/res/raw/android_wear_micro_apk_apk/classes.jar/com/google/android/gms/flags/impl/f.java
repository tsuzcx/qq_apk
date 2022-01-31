package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.cl;
import java.util.concurrent.Callable;

public final class f
{
  private static SharedPreferences LT = null;
  
  public static SharedPreferences r(Context paramContext)
  {
    try
    {
      if (LT == null) {
        LT = (SharedPreferences)cl.a(new Callable() {});
      }
      paramContext = LT;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.flags.impl.f
 * JD-Core Version:    0.7.0.1
 */