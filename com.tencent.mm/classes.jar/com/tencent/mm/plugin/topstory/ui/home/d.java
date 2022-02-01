package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.plugin.topstory.ui.webview.e;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public final class d
{
  private dom BLb;
  private c BLc;
  private TopStoryWebView BLd;
  private e BLe;
  public HashMap<Integer, don> BLf;
  public HashMap<Integer, String> BLg;
  boolean uNN;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.uNN = false;
    this.BLf = new HashMap();
    this.BLg = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(dom paramdom, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.BLf.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (don)this.BLf.get(Integer.valueOf(paramInt));
      ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((don)localObject).HVt), Integer.valueOf(((don)localObject).HDj), Integer.valueOf(((don)localObject).HVu), Long.valueOf(System.currentTimeMillis()) });
      if (((don)localObject).HVt + ((don)localObject).HDj * 1000 > System.currentTimeMillis())
      {
        this.BLc.euz();
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((don)localObject).hFS;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((don)localObject).HVt + ((don)localObject).HVu * 1000 > System.currentTimeMillis())
      {
        this.BLc.euz();
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((don)localObject).hFS;
      }
      for (;;)
      {
        paramdom.HVr.addAll(((don)localObject).HDl);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.BLc.a(paramdom, false, false, 0);
        localObject = str;
        break;
        this.BLc.euz();
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.BLc.euz();
      localObject = str;
      if (paramBoolean)
      {
        this.BLc.a(paramdom, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean esZ()
  {
    AppMethodBeat.i(126064);
    if (this.BLf.containsKey(Integer.valueOf(100)))
    {
      don localdon = (don)this.BLf.get(Integer.valueOf(100));
      long l = localdon.HVt;
      if (localdon.HDj * 1000 + l > System.currentTimeMillis())
      {
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
        AppMethodBeat.o(126064);
        return false;
      }
    }
    ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
    AppMethodBeat.o(126064);
    return true;
  }
  
  public final void a(dom paramdom, boolean paramBoolean)
  {
    AppMethodBeat.i(126061);
    int i;
    if (!this.uNN)
    {
      this.uNN = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdom, "startCreateWB", System.currentTimeMillis());
      this.BLb = paramdom;
      this.BLc = new c();
      if (paramdom.cSM > 0) {
        break label251;
      }
      i = 100;
      String str = a(paramdom, i, paramBoolean);
      this.BLd = new TopStoryWebView(ak.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.webview.b();
      com.tencent.mm.plugin.topstory.ui.webview.d locald = new com.tencent.mm.plugin.topstory.ui.webview.d(paramdom, this.BLc);
      this.BLe = new e(this.BLd, paramdom, this.BLc);
      this.BLd.a((com.tencent.mm.plugin.topstory.ui.webview.b)localObject, locald);
      this.BLd.addJavascriptInterface(this.BLe, "topStoryJSApi");
      if (this.BLc.BPJ == null) {
        break label259;
      }
      localObject = (String)this.BLg.get(Integer.valueOf(i));
      this.BLc.y(str, (String)localObject, esZ());
      this.BLd.loadDataWithBaseURL(paramdom.url, new String(this.BLc.BPJ), "text/html", "utf-8", null);
      this.BLc.BPJ = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdom, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.BLe.aEs("");
      }
      AppMethodBeat.o(126061);
      return;
      label251:
      i = paramdom.cSM;
      break;
      label259:
      this.BLd.loadUrl(paramdom.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramdom, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.BLc, this.BLd, this.BLe, this.BLb);
    this.BLc = null;
    this.BLd = null;
    this.BLe = null;
    this.BLb = null;
    this.uNN = false;
    AppMethodBeat.o(126062);
  }
  
  public final void cl(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.BLg.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      k localk = new k(h.est());
      if (!localk.exists()) {
        localk.mkdirs();
      }
      o.f(h.est() + paramInt, paramString, paramString.length);
      ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      AppMethodBeat.o(126065);
      return;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
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
    //   9: invokestatic 310	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
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
    //   44: invokestatic 95	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */