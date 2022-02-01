package com.tencent.mm.plugin.sns.ad.c.a.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements b, AdLandingPagesProxy.e, com.tencent.mm.pluginsdk.permission.c
{
  private ao jdu;
  private Reference<Context> xId;
  private a xIe;
  private volatile boolean xIf;
  private String xIg;
  private Runnable xIh;
  
  private a(Context paramContext, a parama)
  {
    AppMethodBeat.i(199943);
    this.xIh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199940);
        try
        {
          a.this.a(3, "get_location:timeout", 0.0D, 0.0D, 0.0D, 0.0D);
          AppMethodBeat.o(199940);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(199940);
        }
      }
    };
    this.xId = new WeakReference(paramContext);
    this.jdu = new ao(Looper.getMainLooper());
    this.xIe = parama;
    AppMethodBeat.o(199943);
  }
  
  public static b a(Context paramContext, a parama)
  {
    AppMethodBeat.i(199942);
    if (paramContext == null)
    {
      AppMethodBeat.o(199942);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(199942);
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
    AppMethodBeat.i(199944);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(199944);
  }
  
  final void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(199948);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(199948);
      return;
    }
    this.jdu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199941);
        try
        {
          a.this.b(paramInt, paramString, paramDouble1, paramDouble3, this.hFm, this.hFn);
          AppMethodBeat.o(199941);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(199941);
        }
      }
    });
    AppMethodBeat.o(199948);
  }
  
  final void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(199949);
    try
    {
      ac.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.xIf)
      {
        this.xIf = true;
        if (this.xIe != null)
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
          this.xIe.az(localArrayMap);
        }
        this.jdu.removeCallbacks(this.xIh);
      }
      AppMethodBeat.o(199949);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(199949);
    }
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(199945);
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
        AppMethodBeat.o(199945);
        return;
      }
      if (paramInt != 0)
      {
        start(this.xIg);
        AppMethodBeat.o(199945);
        return;
      }
      a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
      AppMethodBeat.o(199945);
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
  
  public final void bc(Object paramObject)
  {
    AppMethodBeat.i(199947);
    if ((paramObject instanceof Bundle)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject = (Bundle)paramObject;
        paramObject.setClassLoader(getClass().getClassLoader());
        bool = com.tencent.mm.plugin.sns.ad.e.c.m(paramObject, "result");
        double d1 = com.tencent.mm.plugin.sns.ad.e.c.h(paramObject, "latitude");
        double d2 = com.tencent.mm.plugin.sns.ad.e.c.h(paramObject, "longitude");
        double d3 = com.tencent.mm.plugin.sns.ad.e.c.h(paramObject, "accuracy");
        double d4 = com.tencent.mm.plugin.sns.ad.e.c.h(paramObject, "speed");
        int i;
        if (bool)
        {
          i = 0;
          break label117;
          a(i, paramObject, d1, d2, d4, d3);
          AppMethodBeat.o(199947);
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable paramObject) {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(199947);
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
    AppMethodBeat.i(199946);
    try
    {
      ac.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.jdu.removeCallbacks(this.xIh);
      this.jdu.postDelayed(this.xIh, 20000L);
      this.xIg = paramString;
      Context localContext = (Context)this.xId.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        AppMethodBeat.o(199946);
        return;
        if (!com.tencent.mm.pluginsdk.permission.b.o(localContext, "android.permission.ACCESS_COARSE_LOCATION"))
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
      AppMethodBeat.o(199946);
    }
  }
  
  public static abstract interface a
  {
    public abstract void az(Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */