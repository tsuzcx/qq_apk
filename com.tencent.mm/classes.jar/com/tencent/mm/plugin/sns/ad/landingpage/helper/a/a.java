package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements b, AdLandingPagesProxy.e, c
{
  private Reference<Context> PUt;
  private a PUu;
  private volatile boolean PUv;
  private String PUw;
  private Runnable PUx;
  private MMHandler qse;
  
  private a(Context paramContext, a parama)
  {
    AppMethodBeat.i(310836);
    this.PUx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310833);
        try
        {
          a.a(a.this);
          return;
        }
        finally
        {
          AppMethodBeat.o(310833);
        }
      }
    };
    this.PUt = new WeakReference(paramContext);
    this.qse = new MMHandler(Looper.getMainLooper());
    this.PUu = parama;
    AppMethodBeat.o(310836);
  }
  
  public static b a(Context paramContext, a parama)
  {
    AppMethodBeat.i(310829);
    if (paramContext == null)
    {
      AppMethodBeat.o(310829);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(310829);
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(310848);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(310848);
      return;
    }
    this.qse.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310837);
        try
        {
          a.a(a.this, paramInt, paramString, paramDouble1, paramDouble3, this.oEJ, this.oEK);
          return;
        }
        finally
        {
          AppMethodBeat.o(310837);
        }
      }
    });
    AppMethodBeat.o(310848);
  }
  
  private void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(310856);
    try
    {
      Log.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.PUv)
      {
        this.PUv = true;
        if (this.PUu != null)
        {
          ArrayMap localArrayMap = new ArrayMap();
          localArrayMap.put("ret", Integer.valueOf(paramInt));
          localArrayMap.put("err_msg", paramString);
          if (paramInt == 0)
          {
            localArrayMap.put("latitude", Double.valueOf(paramDouble1));
            localArrayMap.put("longitude", Double.valueOf(paramDouble2));
            localArrayMap.put("speed", Double.valueOf(paramDouble3));
            localArrayMap.put("accuracy", Double.valueOf(paramDouble4));
          }
          this.PUu.aS(localArrayMap);
        }
        this.qse.removeCallbacks(this.PUx);
      }
      AppMethodBeat.o(310856);
      return;
    }
    finally
    {
      Log.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(310856);
    }
  }
  
  private void start(String paramString)
  {
    AppMethodBeat.i(310841);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(310841);
  }
  
  public final void h(int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void onCallback(Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(310897);
    if ((paramObject instanceof Bundle)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject = (Bundle)paramObject;
        paramObject.setClassLoader(getClass().getClassLoader());
        bool = h.getBoolean(paramObject, "result", false);
        double d1 = h.h(paramObject, "latitude");
        double d2 = h.h(paramObject, "longitude");
        double d3 = h.h(paramObject, "accuracy");
        double d4 = h.h(paramObject, "speed");
        if (bool)
        {
          break label118;
          a(i, paramObject, d1, d2, d4, d3);
          AppMethodBeat.o(310897);
          return;
        }
        i = 2;
        break label118;
      }
      finally {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(310897);
      return;
      label118:
      if (bool) {
        paramObject = "get_location:ok";
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(310880);
    int j;
    if (paramInt == 1)
    {
      j = 1;
      paramInt = j;
      if (paramArrayOfInt == null) {}
    }
    int k;
    int i;
    try
    {
      k = paramArrayOfInt.length;
      i = 0;
    }
    finally
    {
      AppMethodBeat.o(310880);
      return;
    }
    if (paramInt != 0)
    {
      start(this.PUw);
      AppMethodBeat.o(310880);
      return;
    }
    a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
    AppMethodBeat.o(310880);
    return;
    for (;;)
    {
      paramInt = j;
      if (i >= k) {
        break;
      }
      if (paramArrayOfInt[i] != 0)
      {
        paramInt = 0;
        break;
      }
      i += 1;
    }
  }
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(310887);
    try
    {
      Log.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.qse.removeCallbacks(this.PUx);
      this.qse.postDelayed(this.PUx, 20000L);
      this.PUw = paramString;
      Context localContext = (Context)this.PUt.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        return;
        if (!com.tencent.mm.pluginsdk.permission.b.s(localContext, "android.permission.ACCESS_FINE_LOCATION"))
        {
          com.tencent.mm.pluginsdk.permission.b.a(1, this, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310887);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aS(Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */