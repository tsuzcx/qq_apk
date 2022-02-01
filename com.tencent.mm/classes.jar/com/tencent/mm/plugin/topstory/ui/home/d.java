package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public final class d
{
  private dia AbS;
  private c AbT;
  private TopStoryWebView AbU;
  private com.tencent.mm.plugin.topstory.ui.webview.e AbV;
  public HashMap<Integer, dib> AbW;
  public HashMap<Integer, String> AbX;
  boolean tzz;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.tzz = false;
    this.AbW = new HashMap();
    this.AbX = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(dia paramdia, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.AbW.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (dib)this.AbW.get(Integer.valueOf(paramInt));
      ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((dib)localObject).FRa), Integer.valueOf(((dib)localObject).FzB), Integer.valueOf(((dib)localObject).FRb), Long.valueOf(System.currentTimeMillis()) });
      if (((dib)localObject).FRa + ((dib)localObject).FzB * 1000 > System.currentTimeMillis())
      {
        this.AbT.eeB();
        ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((dib)localObject).hkR;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((dib)localObject).FRa + ((dib)localObject).FRb * 1000 > System.currentTimeMillis())
      {
        this.AbT.eeB();
        ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((dib)localObject).hkR;
      }
      for (;;)
      {
        paramdia.FQY.addAll(((dib)localObject).FzD);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.AbT.a(paramdia, false, false, 0);
        localObject = str;
        break;
        this.AbT.eeB();
        ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.AbT.eeB();
      localObject = str;
      if (paramBoolean)
      {
        this.AbT.a(paramdia, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean eda()
  {
    AppMethodBeat.i(126064);
    if (this.AbW.containsKey(Integer.valueOf(100)))
    {
      dib localdib = (dib)this.AbW.get(Integer.valueOf(100));
      long l = localdib.FRa;
      if (localdib.FzB * 1000 + l > System.currentTimeMillis())
      {
        ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
        AppMethodBeat.o(126064);
        return false;
      }
    }
    ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
    AppMethodBeat.o(126064);
    return true;
  }
  
  public final void a(dia paramdia, boolean paramBoolean)
  {
    AppMethodBeat.i(126061);
    int i;
    if (!this.tzz)
    {
      this.tzz = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdia, "startCreateWB", System.currentTimeMillis());
      this.AbS = paramdia;
      this.AbT = new c();
      if (paramdia.cGY > 0) {
        break label251;
      }
      i = 100;
      String str = a(paramdia, i, paramBoolean);
      this.AbU = new TopStoryWebView(ai.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.webview.b();
      com.tencent.mm.plugin.topstory.ui.webview.d locald = new com.tencent.mm.plugin.topstory.ui.webview.d(paramdia, this.AbT);
      this.AbV = new com.tencent.mm.plugin.topstory.ui.webview.e(this.AbU, paramdia, this.AbT);
      this.AbU.a((com.tencent.mm.plugin.topstory.ui.webview.b)localObject, locald);
      this.AbU.addJavascriptInterface(this.AbV, "topStoryJSApi");
      if (this.AbT.Agz == null) {
        break label259;
      }
      localObject = (String)this.AbX.get(Integer.valueOf(i));
      this.AbT.y(str, (String)localObject, eda());
      this.AbU.loadDataWithBaseURL(paramdia.url, new String(this.AbT.Agz), "text/html", "utf-8", null);
      this.AbT.Agz = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramdia, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.AbV.axU("");
      }
      AppMethodBeat.o(126061);
      return;
      label251:
      i = paramdia.cGY;
      break;
      label259:
      this.AbU.loadUrl(paramdia.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramdia, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.AbT, this.AbU, this.AbV, this.AbS);
    this.AbT = null;
    this.AbU = null;
    this.AbV = null;
    this.AbS = null;
    this.tzz = false;
    AppMethodBeat.o(126062);
  }
  
  public final void ce(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.AbX.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(h.ecv());
      if (!locale.exists()) {
        locale.mkdirs();
      }
      i.f(h.ecv() + paramInt, paramString, paramString.length);
      ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      AppMethodBeat.o(126065);
      return;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
      AppMethodBeat.o(126065);
    }
  }
  
  /* Error */
  public final void cf(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 304
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 310	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   44: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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