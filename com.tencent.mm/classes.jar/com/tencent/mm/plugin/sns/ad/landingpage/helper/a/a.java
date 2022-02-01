package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements b, AdLandingPagesProxy.e, c
{
  private aq jzz;
  private Reference<Context> znT;
  private a.a znU;
  private volatile boolean znV;
  private String znW;
  private Runnable znX;
  
  private a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(219045);
    this.znX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219042);
        try
        {
          a.this.a(3, "get_location:timeout", 0.0D, 0.0D, 0.0D, 0.0D);
          AppMethodBeat.o(219042);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(219042);
        }
      }
    };
    this.znT = new WeakReference(paramContext);
    this.jzz = new aq(Looper.getMainLooper());
    this.znU = parama;
    AppMethodBeat.o(219045);
  }
  
  public static b a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(219044);
    if (paramContext == null)
    {
      AppMethodBeat.o(219044);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(219044);
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
    AppMethodBeat.i(219046);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(219046);
  }
  
  final void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(219050);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(219050);
      return;
    }
    this.jzz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219043);
        try
        {
          a.this.b(paramInt, paramString, paramDouble1, paramDouble3, this.iaJ, this.iaK);
          AppMethodBeat.o(219043);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(219043);
        }
      }
    });
    AppMethodBeat.o(219050);
  }
  
  final void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(219051);
    try
    {
      ae.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.znV)
      {
        this.znV = true;
        if (this.znU != null)
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
          this.znU.aI(localArrayMap);
        }
        this.jzz.removeCallbacks(this.znX);
      }
      AppMethodBeat.o(219051);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(219051);
    }
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(219047);
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
        AppMethodBeat.o(219047);
        return;
      }
      if (paramInt != 0)
      {
        start(this.znW);
        AppMethodBeat.o(219047);
        return;
      }
      a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
      AppMethodBeat.o(219047);
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
    AppMethodBeat.i(219049);
    if ((paramObject instanceof Bundle)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject = (Bundle)paramObject;
        paramObject.setClassLoader(getClass().getClassLoader());
        bool = e.l(paramObject, "result");
        double d1 = e.g(paramObject, "latitude");
        double d2 = e.g(paramObject, "longitude");
        double d3 = e.g(paramObject, "accuracy");
        double d4 = e.g(paramObject, "speed");
        int i;
        if (bool)
        {
          i = 0;
          break label117;
          a(i, paramObject, d1, d2, d4, d3);
          AppMethodBeat.o(219049);
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable paramObject) {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(219049);
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
    AppMethodBeat.i(219048);
    try
    {
      ae.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.jzz.removeCallbacks(this.znX);
      this.jzz.postDelayed(this.znX, 20000L);
      this.znW = paramString;
      Context localContext = (Context)this.znT.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        AppMethodBeat.o(219048);
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
      AppMethodBeat.o(219048);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */