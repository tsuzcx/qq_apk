package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public final class d
{
  private dnp BtD;
  private c BtE;
  private TopStoryWebView BtF;
  private com.tencent.mm.plugin.topstory.ui.webview.e BtG;
  public HashMap<Integer, dnq> BtH;
  public HashMap<Integer, String> BtI;
  boolean uCi;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.uCi = false;
    this.BtH = new HashMap();
    this.BtI = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(dnp paramdnp, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.BtH.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (dnq)this.BtH.get(Integer.valueOf(paramInt));
      ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((dnq)localObject).HBG), Integer.valueOf(((dnq)localObject).HjJ), Integer.valueOf(((dnq)localObject).HBH), Long.valueOf(System.currentTimeMillis()) });
      if (((dnq)localObject).HBG + ((dnq)localObject).HjJ * 1000 > System.currentTimeMillis())
      {
        this.BtE.eqS();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((dnq)localObject).hDa;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((dnq)localObject).HBG + ((dnq)localObject).HBH * 1000 > System.currentTimeMillis())
      {
        this.BtE.eqS();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((dnq)localObject).hDa;
      }
      for (;;)
      {
        paramdnp.HBE.addAll(((dnq)localObject).HjL);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.BtE.a(paramdnp, false, false, 0);
        localObject = str;
        break;
        this.BtE.eqS();
        ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.BtE.eqS();
      localObject = str;
      if (paramBoolean)
      {
        this.BtE.a(paramdnp, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean eps()
  {
    AppMethodBeat.i(126064);
    if (this.BtH.containsKey(Integer.valueOf(100)))
    {
      dnq localdnq = (dnq)this.BtH.get(Integer.valueOf(100));
      long l = localdnq.HBG;
      if (localdnq.HjJ * 1000 + l > System.currentTimeMillis())
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
  
  public final void a(dnp paramdnp, boolean paramBoolean)
  {
    AppMethodBeat.i(126061);
    int i;
    if (!this.uCi)
    {
      this.uCi = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdnp, "startCreateWB", System.currentTimeMillis());
      this.BtD = paramdnp;
      this.BtE = new c();
      if (paramdnp.cSc > 0) {
        break label251;
      }
      i = 100;
      String str = a(paramdnp, i, paramBoolean);
      this.BtF = new TopStoryWebView(aj.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.webview.b();
      com.tencent.mm.plugin.topstory.ui.webview.d locald = new com.tencent.mm.plugin.topstory.ui.webview.d(paramdnp, this.BtE);
      this.BtG = new com.tencent.mm.plugin.topstory.ui.webview.e(this.BtF, paramdnp, this.BtE);
      this.BtF.a((com.tencent.mm.plugin.topstory.ui.webview.b)localObject, locald);
      this.BtF.addJavascriptInterface(this.BtG, "topStoryJSApi");
      if (this.BtE.Byl == null) {
        break label259;
      }
      localObject = (String)this.BtI.get(Integer.valueOf(i));
      this.BtE.y(str, (String)localObject, eps());
      this.BtF.loadDataWithBaseURL(paramdnp.url, new String(this.BtE.Byl), "text/html", "utf-8", null);
      this.BtE.Byl = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdnp, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.BtG.aCZ("");
      }
      AppMethodBeat.o(126061);
      return;
      label251:
      i = paramdnp.cSc;
      break;
      label259:
      this.BtF.loadUrl(paramdnp.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramdnp, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.BtE, this.BtF, this.BtG, this.BtD);
    this.BtE = null;
    this.BtF = null;
    this.BtG = null;
    this.BtD = null;
    this.uCi = false;
    AppMethodBeat.o(126062);
  }
  
  public final void cl(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.BtI.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(h.eoM());
      if (!locale.exists()) {
        locale.mkdirs();
      }
      i.f(h.eoM() + paramInt, paramString, paramString.length);
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
  public final void cm(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 304
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 310	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 304
    //   18: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc 66
    //   26: ldc_w 312
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_1
    //   36: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_2
    //   43: aastore
    //   44: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: new 314	com/tencent/mm/plugin/topstory/ui/home/d$1
    //   50: dup
    //   51: aload_0
    //   52: iload_1
    //   53: aload_2
    //   54: invokespecial 317	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   57: ldc_w 319
    //   60: invokestatic 324	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   63: ldc_w 304
    //   66: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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