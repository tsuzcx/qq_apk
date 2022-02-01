package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
  implements b.b, b
{
  private long uYG;
  d vhB;
  private a yXx;
  private String yXy;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(197593);
    this.vhB = d.aHQ();
    this.uYG = paramLong;
    this.yXx = parama;
    this.yXy = paramString;
    AppMethodBeat.o(197593);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(197592);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(197592);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(197592);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        ad.e("GeoServerRequester", "there is something wrong in makeRequester");
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
    AppMethodBeat.i(197595);
    ad.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.vhB.c(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.yXx != null) {
          this.yXx.CLIENT_CALL(this.yXy, new Object[] { Long.valueOf(this.uYG), paramBundle });
        }
      }
      catch (Throwable paramBundle)
      {
        ad.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(197595);
      return false;
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197591);
          try
          {
            c.this.vhB.c(c.this);
            AppMethodBeat.o(197591);
            return;
          }
          catch (Throwable localThrowable)
          {
            AppMethodBeat.o(197591);
          }
        }
      });
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(197594);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString))
      {
        this.vhB.b(this, false);
        AppMethodBeat.o(197594);
        return;
      }
      this.vhB.a(this, false);
      AppMethodBeat.o(197594);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(197594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c
 * JD-Core Version:    0.7.0.1
 */