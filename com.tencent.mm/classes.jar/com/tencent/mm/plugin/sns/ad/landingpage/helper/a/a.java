package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.g;
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
  private Reference<Context> Duf;
  private a Dug;
  private volatile boolean Duh;
  private String Dui;
  private Runnable Duj;
  private MMHandler kAn;
  
  private a(Context paramContext, a parama)
  {
    AppMethodBeat.i(202016);
    this.Duj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202013);
        try
        {
          a.this.a(3, "get_location:timeout", 0.0D, 0.0D, 0.0D, 0.0D);
          AppMethodBeat.o(202013);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(202013);
        }
      }
    };
    this.Duf = new WeakReference(paramContext);
    this.kAn = new MMHandler(Looper.getMainLooper());
    this.Dug = parama;
    AppMethodBeat.o(202016);
  }
  
  public static b a(Context paramContext, a parama)
  {
    AppMethodBeat.i(202015);
    if (paramContext == null)
    {
      AppMethodBeat.o(202015);
      return null;
    }
    try
    {
      paramContext = new a(paramContext, parama);
      AppMethodBeat.o(202015);
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
    AppMethodBeat.i(202017);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    AdLandingPagesProxy.getInstance().geoLocation(str, this);
    AppMethodBeat.o(202017);
  }
  
  final void a(final int paramInt, final String paramString, final double paramDouble1, double paramDouble2, final double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(202021);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramInt, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(202021);
      return;
    }
    this.kAn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202014);
        try
        {
          a.this.b(paramInt, paramString, paramDouble1, paramDouble3, this.iVH, this.iVI);
          AppMethodBeat.o(202014);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(202014);
        }
      }
    });
    AppMethodBeat.o(202021);
  }
  
  final void b(int paramInt, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(202022);
    try
    {
      Log.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(paramDouble1)));
      if (!this.Duh)
      {
        this.Duh = true;
        if (this.Dug != null)
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
          this.Dug.aH(localArrayMap);
        }
        this.kAn.removeCallbacks(this.Duj);
      }
      AppMethodBeat.o(202022);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("GeoClientRequester", "the do Callback has something wrong");
      AppMethodBeat.o(202022);
    }
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(202018);
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
        AppMethodBeat.o(202018);
        return;
      }
      if (paramInt != 0)
      {
        start(this.Dui);
        AppMethodBeat.o(202018);
        return;
      }
      a(1, "get_location:no_permission", 0.0D, 0.0D, 0.0D, 0.0D);
      AppMethodBeat.o(202018);
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
  
  public final void bn(Object paramObject)
  {
    int i = 0;
    AppMethodBeat.i(202020);
    if ((paramObject instanceof Bundle)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramObject = (Bundle)paramObject;
        paramObject.setClassLoader(getClass().getClassLoader());
        bool = g.getBoolean(paramObject, "result", false);
        double d1 = g.h(paramObject, "latitude");
        double d2 = g.h(paramObject, "longitude");
        double d3 = g.h(paramObject, "accuracy");
        double d4 = g.h(paramObject, "speed");
        if (bool)
        {
          break label118;
          a(i, paramObject, d1, d2, d4, d3);
          AppMethodBeat.o(202020);
        }
        else
        {
          i = 2;
        }
      }
      catch (Throwable paramObject) {}
      paramObject = "get_location:failed";
      continue;
      AppMethodBeat.o(202020);
      return;
      label118:
      if (bool) {
        paramObject = "get_location:ok";
      }
    }
  }
  
  public final void h(int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void request(String paramString)
  {
    AppMethodBeat.i(202019);
    try
    {
      Log.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(paramString)));
      this.kAn.removeCallbacks(this.Duj);
      this.kAn.postDelayed(this.Duj, 20000L);
      this.Dui = paramString;
      Context localContext = (Context)this.Duf.get();
      int i;
      if (localContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          start(paramString);
        }
        AppMethodBeat.o(202019);
        return;
        if (!com.tencent.mm.pluginsdk.permission.b.n(localContext, "android.permission.ACCESS_FINE_LOCATION"))
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
      AppMethodBeat.o(202019);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aH(Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */