package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.cl;
import java.util.concurrent.Callable;

public final class f
{
  private static SharedPreferences NI = null;
  
  public static SharedPreferences s(Context paramContext)
  {
    try
    {
      if (NI == null) {
        NI = (SharedPreferences)cl.a(new Callable() {});
      }
      paramContext = NI;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.flags.impl.f
 * JD-Core Version:    0.7.0.1
 */