package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
  implements b.b, b
{
  private d KjZ;
  private String PUA;
  private a PUz;
  private long efY;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(310834);
    this.KjZ = d.bJl();
    this.efY = paramLong;
    this.PUz = parama;
    this.PUA = paramString;
    AppMethodBeat.o(310834);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(310827);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(310827);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(310827);
      return parama;
    }
    finally
    {
      for (;;)
      {
        Log.e("GeoServerRequester", "there is something wrong in makeRequester");
        parama = null;
      }
    }
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    AppMethodBeat.i(310861);
    Log.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.KjZ.a(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.PUz != null) {
          this.PUz.CLIENT_CALL(this.PUA, new Object[] { Long.valueOf(this.efY), paramBundle });
        }
      }
      finally
      {
        Log.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(310861);
      return false;
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(310826);
          try
          {
            c.a(c.this).a(c.this);
            return;
          }
          finally
          {
            AppMethodBeat.o(310826);
          }
        }
      });
    }
  }
  
  public final boolean onGetLocation(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return false;
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(310845);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString)) {
        this.KjZ.a(this, false);
      }
      for (;;)
      {
        l.kK(12, 10);
        AppMethodBeat.o(310845);
        return;
        this.KjZ.a(this, false, true);
      }
      return;
    }
    finally
    {
      Log.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(310845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c
 * JD-Core Version:    0.7.0.1
 */