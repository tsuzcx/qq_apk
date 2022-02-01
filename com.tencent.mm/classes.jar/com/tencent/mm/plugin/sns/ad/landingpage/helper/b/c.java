package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
  implements b.b, b
{
  private d Ert;
  private a JDA;
  private String JDB;
  private long coM;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(268664);
    this.Ert = d.blq();
    this.coM = paramLong;
    this.JDA = parama;
    this.JDB = paramString;
    AppMethodBeat.o(268664);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(268663);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(268663);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(268663);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        Log.e("GeoServerRequester", "there is something wrong in makeRequester");
        parama = null;
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    return false;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    AppMethodBeat.i(268671);
    Log.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.Ert.b(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.JDA != null) {
          this.JDA.CLIENT_CALL(this.JDB, new Object[] { Long.valueOf(this.coM), paramBundle });
        }
      }
      catch (Throwable paramBundle)
      {
        Log.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(268671);
      return false;
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198383);
          try
          {
            c.a(c.this).b(c.this);
            AppMethodBeat.o(198383);
            return;
          }
          catch (Throwable localThrowable)
          {
            AppMethodBeat.o(198383);
          }
        }
      });
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(268666);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString))
      {
        this.Ert.b(this, false);
        AppMethodBeat.o(268666);
        return;
      }
      this.Ert.a(this, false);
      AppMethodBeat.o(268666);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(268666);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.c
 * JD-Core Version:    0.7.0.1
 */