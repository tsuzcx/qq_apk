package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

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
  private a Dul;
  private String Dum;
  private long cqY;
  d yNv;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(202025);
    this.yNv = d.bca();
    this.cqY = paramLong;
    this.Dul = parama;
    this.Dum = paramString;
    AppMethodBeat.o(202025);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(202024);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(202024);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(202024);
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
    AppMethodBeat.i(202027);
    Log.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.yNv.c(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.Dul != null) {
          this.Dul.CLIENT_CALL(this.Dum, new Object[] { Long.valueOf(this.cqY), paramBundle });
        }
      }
      catch (Throwable paramBundle)
      {
        Log.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(202027);
      return false;
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202023);
          try
          {
            c.this.yNv.c(c.this);
            AppMethodBeat.o(202023);
            return;
          }
          catch (Throwable localThrowable)
          {
            AppMethodBeat.o(202023);
          }
        }
      });
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(202026);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString))
      {
        this.yNv.b(this, false);
        AppMethodBeat.o(202026);
        return;
      }
      this.yNv.a(this, false);
      AppMethodBeat.o(202026);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(202026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c
 * JD-Core Version:    0.7.0.1
 */