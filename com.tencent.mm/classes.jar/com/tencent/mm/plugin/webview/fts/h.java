package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class h
{
  public final List<Map<Object, b>> WBg;
  private final MMHandler tiG;
  
  public h(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(295592);
    this.WBg = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.WBg.add(new HashMap());
      i += 1;
    }
    this.tiG = paramMMHandler;
    AppMethodBeat.o(295592);
  }
  
  public static String aHT(String paramString)
  {
    AppMethodBeat.i(295598);
    paramString = bjD(paramString) + "_" + bjE(paramString) + "_" + bjF(paramString);
    AppMethodBeat.o(295598);
    return paramString;
  }
  
  private static String bjD(String paramString)
  {
    AppMethodBeat.i(295603);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(295603);
      return "";
    }
    try
    {
      paramString = new JSONObject(paramString).optString("action");
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(295603);
        return "";
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(295603);
      return "";
    }
    AppMethodBeat.o(295603);
    return paramString;
  }
  
  private static String bjE(String paramString)
  {
    AppMethodBeat.i(295611);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(295611);
      return "";
    }
    try
    {
      paramString = new JSONObject(paramString).optString("req_key");
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(295611);
        return "";
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(295611);
      return "";
    }
    AppMethodBeat.o(295611);
    return paramString;
  }
  
  private static String bjF(String paramString)
  {
    AppMethodBeat.i(295614);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(295614);
      return "";
    }
    try
    {
      paramString = new JSONObject(paramString).optString("sessionid64");
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(295614);
        return "";
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(295614);
      return "";
    }
    AppMethodBeat.o(295614);
    return paramString;
  }
  
  public final void N(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(295618);
    if (paramObject == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_doCgiReq tag is null");
      AppMethodBeat.o(295618);
      return;
    }
    this.tiG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295575);
        Log.i("MicroMsg.WebSearch.PGetController", "step_doCgiReq type:%s, reqTag:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
        h.b localb2 = (h.b)((Map)h.this.WBg.get(paramInt)).get(paramObject);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.WBg.get(paramInt)).put(paramObject, localb1);
        }
        localb1.WBn = true;
        AppMethodBeat.o(295575);
      }
    });
    AppMethodBeat.o(295618);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final a parama)
  {
    AppMethodBeat.i(295624);
    this.tiG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295570);
        Log.i("MicroMsg.WebSearch.PGetController", "step_cgiEnd type:%s reqTag:%s cgiResult:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb = (h.b)((Map)h.this.WBg.get(paramInt)).get(paramObject1);
        if (localb == null)
        {
          Log.e("MicroMsg.WebSearch.PGetController", "step_cgiEnd weird null");
          AppMethodBeat.o(295570);
          return;
        }
        localb.WBr = paramObject2;
        localb.WBp = true;
        if (localb.WBo)
        {
          if (parama != null) {
            parama.handleCallback(localb);
          }
          ((Map)h.this.WBg.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(295570);
      }
    });
    AppMethodBeat.o(295624);
  }
  
  public final void a(final int paramInt, final Object paramObject1, final Object paramObject2, final Runnable paramRunnable, final a parama)
  {
    AppMethodBeat.i(295622);
    if (paramObject1 == null)
    {
      Log.e("MicroMsg.WebSearch.PGetController", "step_getJsApi tag is null");
      AppMethodBeat.o(295622);
      return;
    }
    this.tiG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295568);
        Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
        h.b localb2 = (h.b)((Map)h.this.WBg.get(paramInt)).get(paramObject1);
        h.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new h.b();
          ((Map)h.this.WBg.get(paramInt)).put(paramObject1, localb1);
        }
        localb1.WBo = true;
        localb1.WBq = paramObject2;
        if (!localb1.WBn)
        {
          paramRunnable.run();
          h.this.N(paramInt, paramObject1);
          AppMethodBeat.o(295568);
          return;
        }
        if (localb1.WBp)
        {
          Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi preget hit type:%s, reqTag:%s, jsParams:%s", new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
          if (parama != null) {
            parama.handleCallback(localb1);
          }
          ((Map)h.this.WBg.get(paramInt)).remove(paramObject1);
        }
        AppMethodBeat.o(295568);
      }
    });
    AppMethodBeat.o(295622);
  }
  
  static abstract interface a
  {
    public abstract void handleCallback(h.b paramb);
  }
  
  public static final class b
  {
    boolean WBn;
    boolean WBo;
    boolean WBp;
    public Object WBq;
    public Object WBr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */