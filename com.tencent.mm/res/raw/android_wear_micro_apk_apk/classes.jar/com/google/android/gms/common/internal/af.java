package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class af
{
  private static final Object Kp = new Object();
  private static af Kq;
  
  public static af h(Context paramContext)
  {
    synchronized (Kp)
    {
      if (Kq == null) {
        Kq = new ah(paramContext.getApplicationContext());
      }
      return Kq;
    }
  }
  
  protected abstract void a(ag paramag, ServiceConnection paramServiceConnection);
  
  protected abstract boolean a(ag paramag, ServiceConnection paramServiceConnection, String paramString);
  
  public final boolean a(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return a(new ag(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public final void b(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    a(new ag(paramString1, paramString2), paramServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.af
 * JD-Core Version:    0.7.0.1
 */