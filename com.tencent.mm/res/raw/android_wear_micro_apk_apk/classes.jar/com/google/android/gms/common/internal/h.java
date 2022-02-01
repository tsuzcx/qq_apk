package com.google.android.gms.common.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;

public final class h
  extends e<az>
{
  private static final h KZ = new h();
  
  private h()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View b(Context paramContext, int paramInt1, int paramInt2)
  {
    return KZ.c(paramContext, paramInt1, paramInt2);
  }
  
  private View c(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      zzah localzzah = new zzah(paramInt1, paramInt2);
      a locala = d.F(paramContext);
      paramContext = (View)d.a(((az)r(paramContext)).a(locala, localzzah));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new f(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.h
 * JD-Core Version:    0.7.0.1
 */