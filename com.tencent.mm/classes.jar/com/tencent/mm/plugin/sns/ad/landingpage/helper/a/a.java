package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements b, AdLandingPagesProxy.e, c
{
  private ap jwD;
  private Reference<Context> yXr;
  private a.a yXs;
  private volatile boolean yXt;
  private String yXu;
  private Runnable yXv;
  
  private a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(197584);
    this.yXv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197581);
        try
        {
          a.this.a(3, "get_location:timeout", 0.0D, 0.0D, 0.0D, 0.0D);
          AppMethodBeat.o(197581);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(197581);
        }
      }
    };
    this.yXr = new WeakReference(paramContext);
    this.jwD = new ap(Looper.getMainLooper());
    this.yXs = parama;
    AppMethodBeat.o(197584);
  }
  
  public static b a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(197583);
    if (paramContext == null)
    {
      AppMethodBeat.o(197583);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(197583);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private void start(String paramString)
  {
    AppMethodBeat.i(197585);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(197585);
  }
  
  final void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(197589);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(197589);
      return;
    }
    this.jwD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197582);
        try
        {
          a.this.b(paramInt, paramString, paramDouble1, paramDouble3, this.hXR, this.hXS);
          AppMethodBeat.o(197582);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(197582);
        }
      }
    });
    AppMethodBeat.o(197589);
  }
  
  final void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(197590);
    try
    {
      ad.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.yXt)
      {
        this.yXt = true;
        if (this.yXs != null)
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
          this.yXs.aC(localArrayMap);
        }
        this.jwD.removeCallbacks(this.yXv);
      }
      AppMethodBeat.o(197590);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(197590);
    }
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(197586);
    int j;
    if ((paramInt != 1) || (paramArrayOfInt != null))
    {
      try
      {
        j = paramArrayOfInt.length;
        paramInt = 0;
      }
      catch (Throwable paramArrayOfInt)
      {
        AppMethodBeat.o(197586);
        return;
      }
      if (paramInt != 0)
      {
        start(this.yXu);
        AppMethodBeat.o(197586);
        return;
      }
      a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
      AppMethodBeat.o(197586);
    }
    label94:
    for (;;)
    {
      paramInt = 1;
      break;
      for (;;)
      {
        if (paramInt >= j) {
          break label94;
        }
        if (paramArrayOfInt[paramInt] != 0)
        {
          paramInt = i;
          break;
        }
        paramInt += 1;
      }
    }
  }
  
  public final void be(Object paramObject)
  {
    AppMethodBeat.i(197588);
    if ((paramObject instanceof Bundle)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject = (Bundle)paramObject;
        paramObject.setClassLoader(getClass().getClassLoader());
        bool = d.l(paramObject, "result");
        double d1 = d.g(paramObject, "latitude");
        double d2 = d.g(paramObject, "longitude");
        double d3 = d.g(paramObject, "accuracy");
        double d4 = d.g(paramObject, "speed");
        int i;
        if (bool)
        {
          i = 0;
          break label117;
          a(i, paramObject, d1, d2, d4, d3);
          AppMethodBeat.o(197588);
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable paramObject) {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(197588);
      return;
      label117:
      if (bool) {
        paramObject = "get_location:ok";
      }
    }
  }
  
  public final void h(int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(197587);
    try
    {
      ad.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.jwD.removeCallbacks(this.yXv);
      this.jwD.postDelayed(this.yXv, 20000L);
      this.yXu = paramString;
      Context localContext = (Context)this.yXr.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        AppMethodBeat.o(197587);
        return;
        if (!com.tencent.mm.pluginsdk.permission.b.n(localContext, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          com.tencent.mm.pluginsdk.permission.b.a(1, this, new String[] { "android.permission.ACCESS_COARSE_LOCATION" });
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(197587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */