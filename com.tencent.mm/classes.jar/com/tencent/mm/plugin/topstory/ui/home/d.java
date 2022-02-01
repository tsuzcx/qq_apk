package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;

public final class d
{
  boolean srI;
  private dcn yOb;
  private c yOc;
  private TopStoryWebView yOd;
  private com.tencent.mm.plugin.topstory.ui.webview.e yOe;
  public HashMap<Integer, dco> yOf;
  public HashMap<Integer, String> yOg;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.srI = false;
    this.yOf = new HashMap();
    this.yOg = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(dcn paramdcn, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.yOf.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (dco)this.yOf.get(Integer.valueOf(paramInt));
      ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((dco)localObject).EtZ), Integer.valueOf(((dco)localObject).EcG), Integer.valueOf(((dco)localObject).Eua), Long.valueOf(System.currentTimeMillis()) });
      if (((dco)localObject).EtZ + ((dco)localObject).EcG * 1000 > System.currentTimeMillis())
      {
        this.yOc.dQc();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((dco)localObject).gKr;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((dco)localObject).EtZ + ((dco)localObject).Eua * 1000 > System.currentTimeMillis())
      {
        this.yOc.dQc();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((dco)localObject).gKr;
      }
      for (;;)
      {
        paramdcn.EtX.addAll(((dco)localObject).EcI);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.yOc.a(paramdcn, false, false, 0);
        localObject = str;
        break;
        this.yOc.dQc();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.yOc.dQc();
      localObject = str;
      if (paramBoolean)
      {
        this.yOc.a(paramdcn, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean dOA()
  {
    AppMethodBeat.i(126064);
    if (this.yOf.containsKey(Integer.valueOf(100)))
    {
      dco localdco = (dco)this.yOf.get(Integer.valueOf(100));
      long l = localdco.EtZ;
      if (localdco.EcG * 1000 + l > System.currentTimeMillis())
      {
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
        AppMethodBeat.o(126064);
        return false;
      }
    }
    ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
    AppMethodBeat.o(126064);
    return true;
  }
  
  public final void a(dcn paramdcn, boolean paramBoolean)
  {
    AppMethodBeat.i(126061);
    int i;
    if (!this.srI)
    {
      this.srI = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdcn, "startCreateWB", System.currentTimeMillis());
      this.yOb = paramdcn;
      this.yOc = new c();
      if (paramdcn.cJR > 0) {
        break label251;
      }
      i = 100;
      String str = a(paramdcn, i, paramBoolean);
      this.yOd = new TopStoryWebView(aj.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.webview.b();
      com.tencent.mm.plugin.topstory.ui.webview.d locald = new com.tencent.mm.plugin.topstory.ui.webview.d(paramdcn, this.yOc);
      this.yOe = new com.tencent.mm.plugin.topstory.ui.webview.e(this.yOd, paramdcn, this.yOc);
      this.yOd.a((com.tencent.mm.plugin.topstory.ui.webview.b)localObject, locald);
      this.yOd.addJavascriptInterface(this.yOe, "topStoryJSApi");
      if (this.yOc.ySK == null) {
        break label259;
      }
      localObject = (String)this.yOg.get(Integer.valueOf(i));
      this.yOc.y(str, (String)localObject, dOA());
      this.yOd.loadDataWithBaseURL(paramdcn.url, new String(this.yOc.ySK), "text/html", "utf-8", null);
      this.yOc.ySK = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdcn, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.yOe.asL("");
      }
      AppMethodBeat.o(126061);
      return;
      label251:
      i = paramdcn.cJR;
      break;
      label259:
      this.yOd.loadUrl(paramdcn.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramdcn, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.yOc, this.yOd, this.yOe, this.yOb);
    this.yOc = null;
    this.yOd = null;
    this.yOe = null;
    this.yOb = null;
    this.srI = false;
    AppMethodBeat.o(126062);
  }
  
  public final void ca(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.yOg.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(h.dNV());
      if (!locale.exists()) {
        locale.mkdirs();
      }
      i.f(h.dNV() + paramInt, paramString, paramString.length);
      ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      AppMethodBeat.o(126065);
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
      AppMethodBeat.o(126065);
    }
  }
  
  /* Error */
  public final void cb(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 306
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 312	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 306
    //   18: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc 68
    //   26: ldc_w 314
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_1
    //   36: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_2
    //   43: aastore
    //   44: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: new 6	com/tencent/mm/plugin/topstory/ui/home/d$1
    //   50: dup
    //   51: aload_0
    //   52: iload_1
    //   53: aload_2
    //   54: invokespecial 317	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   57: ldc_w 319
    //   60: invokestatic 324	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   63: ldc_w 306
    //   66: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -48 -> 21
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	d
    //   0	77	1	paramInt	int
    //   0	77	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	21	72	finally
    //   24	69	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */