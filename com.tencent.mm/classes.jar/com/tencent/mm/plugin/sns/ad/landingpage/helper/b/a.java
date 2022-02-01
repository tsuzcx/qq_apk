package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.h;
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
  private Reference<Context> JDu;
  private a.a JDv;
  private volatile boolean JDw;
  private String JDx;
  private Runnable JDy;
  private MMHandler ntw;
  
  private a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(216864);
    this.JDy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198356);
        try
        {
          a.a(a.this);
          AppMethodBeat.o(198356);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(198356);
        }
      }
    };
    this.JDu = new WeakReference(paramContext);
    this.ntw = new MMHandler(Looper.getMainLooper());
    this.JDv = parama;
    AppMethodBeat.o(216864);
  }
  
  public static b a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(216861);
    if (paramContext == null)
    {
      AppMethodBeat.o(216861);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(216861);
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
  
  private void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(216879);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(216879);
      return;
    }
    this.ntw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268822);
        try
        {
          a.a(a.this, paramInt, paramString, paramDouble1, paramDouble3, this.lMc, this.lMd);
          AppMethodBeat.o(268822);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(268822);
        }
      }
    });
    AppMethodBeat.o(216879);
  }
  
  private void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(216884);
    try
    {
      Log.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.JDw)
      {
        this.JDw = true;
        if (this.JDv != null)
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
          this.JDv.aB(localArrayMap);
        }
        this.ntw.removeCallbacks(this.JDy);
      }
      AppMethodBeat.o(216884);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(216884);
    }
  }
  
  private void start(String paramString)
  {
    AppMethodBeat.i(216866);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(216866);
  }
  
  public final void aH(Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(216875);
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
          AppMethodBeat.o(216875);
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable paramObject) {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(216875);
      return;
      label118:
      if (bool) {
        paramObject = "get_location:ok";
      }
    }
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(216869);
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
        AppMethodBeat.o(216869);
        return;
      }
      if (paramInt != 0)
      {
        start(this.JDx);
        AppMethodBeat.o(216869);
        return;
      }
      a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
      AppMethodBeat.o(216869);
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
  
  public final void i(int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(216872);
    try
    {
      Log.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.ntw.removeCallbacks(this.JDy);
      this.ntw.postDelayed(this.JDy, 20000L);
      this.JDx = paramString;
      Context localContext = (Context)this.JDu.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        AppMethodBeat.o(216872);
        return;
        if (!com.tencent.mm.pluginsdk.permission.b.o(localContext, "android.permission.ACCESS_FINE_LOCATION"))
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
    catch (Throwable paramString)
    {
      AppMethodBeat.o(216872);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a
 * JD-Core Version:    0.7.0.1
 */