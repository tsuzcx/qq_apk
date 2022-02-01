package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
  implements b.b, b
{
  private long vkv;
  d vtI;
  private a znZ;
  private String zoa;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(219054);
    this.vtI = d.aIh();
    this.vkv = paramLong;
    this.znZ = parama;
    this.zoa = paramString;
    AppMethodBeat.o(219054);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(219053);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(219053);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(219053);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        ae.e("GeoServerRequester", "there is something wrong in makeRequester");
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
    AppMethodBeat.i(219056);
    ae.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.vtI.c(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.znZ != null) {
          this.znZ.CLIENT_CALL(this.zoa, new Object[] { Long.valueOf(this.vkv), paramBundle });
        }
      }
      catch (Throwable paramBundle)
      {
        ae.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(219056);
      return false;
      new aq(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219052);
          try
          {
            c.this.vtI.c(c.this);
            AppMethodBeat.o(219052);
            return;
          }
          catch (Throwable localThrowable)
          {
            AppMethodBeat.o(219052);
          }
        }
      });
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(219055);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString))
      {
        this.vtI.b(this, false);
        AppMethodBeat.o(219055);
        return;
      }
      this.vtI.a(this, false);
      AppMethodBeat.o(219055);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(219055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c
 * JD-Core Version:    0.7.0.1
 */