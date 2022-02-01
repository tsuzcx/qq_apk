package com.tencent.mm.plugin.sns.ad.c.a.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class c
  implements b.b, b
{
  private long tVX;
  d ueS;
  private a xIj;
  private String xIk;
  
  private c(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(199952);
    this.ueS = d.aEL();
    this.tVX = paramLong;
    this.xIj = parama;
    this.xIk = paramString;
    AppMethodBeat.o(199952);
  }
  
  public static b a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(199951);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(199951);
      return null;
    }
    try
    {
      parama = new c(parama, paramString, paramLong);
      AppMethodBeat.o(199951);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        ac.e("GeoServerRequester", "there is something wrong in makeRequester");
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
    AppMethodBeat.i(199954);
    ac.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(paramFloat1)));
    for (;;)
    {
      try
      {
        if (Looper.myLooper() == null) {
          continue;
        }
        this.ueS.c(this);
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", paramBoolean);
        paramBundle.putDouble("latitude", paramFloat2);
        paramBundle.putDouble("longitude", paramFloat1);
        paramBundle.putDouble("speed", paramDouble1);
        paramBundle.putDouble("accuracy", paramDouble2);
        if (this.xIj != null) {
          this.xIj.CLIENT_CALL(this.xIk, new Object[] { Long.valueOf(this.tVX), paramBundle });
        }
      }
      catch (Throwable paramBundle)
      {
        ac.e("GeoServerRequester", "there is something wrong in onGetLocation");
        continue;
      }
      AppMethodBeat.o(199954);
      return false;
      new ao(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199950);
          try
          {
            c.this.ueS.c(c.this);
            AppMethodBeat.o(199950);
            return;
          }
          catch (Throwable localThrowable)
          {
            AppMethodBeat.o(199950);
          }
        }
      });
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(199953);
    try
    {
      if ("GCJ02".equalsIgnoreCase(paramString))
      {
        this.ueS.b(this, false);
        AppMethodBeat.o(199953);
        return;
      }
      this.ueS.a(this, false);
      AppMethodBeat.o(199953);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("GeoServerRequester", "there is something wrong in request");
      AppMethodBeat.o(199953);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */