package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.a.e;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;

public final class d
{
  private eii GlH;
  private com.tencent.mm.plugin.topstory.ui.a.c GlI;
  private WebSearchWebView GlJ;
  private e GlK;
  public HashMap<Integer, eij> GlL;
  public HashMap<Integer, String> GlM;
  boolean ygl;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.ygl = false;
    this.GlL = new HashMap();
    this.GlM = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(eii parameii, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.GlL.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (eij)this.GlL.get(Integer.valueOf(paramInt));
      Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((eij)localObject).NhD), Integer.valueOf(((eij)localObject).MOb), Integer.valueOf(((eij)localObject).NhE), Long.valueOf(System.currentTimeMillis()) });
      if (((eij)localObject).NhD + ((eij)localObject).MOb * 1000 > System.currentTimeMillis())
      {
        this.GlI.fzT();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((eij)localObject).iAc;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((eij)localObject).NhD + ((eij)localObject).NhE * 1000 > System.currentTimeMillis())
      {
        this.GlI.fzT();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((eij)localObject).iAc;
      }
      for (;;)
      {
        parameii.NhB.addAll(((eij)localObject).MOd);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.GlI.a(parameii, false, false, 0);
        localObject = str;
        break;
        this.GlI.fzT();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.GlI.fzT();
      localObject = str;
      if (paramBoolean)
      {
        this.GlI.a(parameii, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean fyw()
  {
    AppMethodBeat.i(126064);
    if (this.GlL.containsKey(Integer.valueOf(100)))
    {
      eij localeij = (eij)this.GlL.get(Integer.valueOf(100));
      long l = localeij.NhD;
      if (localeij.MOb * 1000 + l > System.currentTimeMillis())
      {
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
        AppMethodBeat.o(126064);
        return false;
      }
    }
    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
    AppMethodBeat.o(126064);
    return true;
  }
  
  public final void a(eii parameii, boolean paramBoolean)
  {
    AppMethodBeat.i(126061);
    int i;
    if (!this.ygl)
    {
      this.ygl = true;
      com.tencent.mm.plugin.topstory.ui.c.c(parameii, "startCreateWB", System.currentTimeMillis());
      this.GlH = parameii;
      this.GlI = new com.tencent.mm.plugin.topstory.ui.a.c();
      if (parameii.channelId > 0) {
        break label251;
      }
      i = 100;
      String str = a(parameii, i, paramBoolean);
      this.GlJ = new WebSearchWebView(MMApplicationContext.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.a.b();
      com.tencent.mm.plugin.topstory.ui.a.d locald = new com.tencent.mm.plugin.topstory.ui.a.d(parameii, this.GlI);
      this.GlK = new e(this.GlJ, parameii, this.GlI);
      this.GlJ.a((x)localObject, locald);
      this.GlJ.addJavascriptInterface(this.GlK, "topStoryJSApi");
      if (this.GlI.Gqp == null) {
        break label259;
      }
      localObject = (String)this.GlM.get(Integer.valueOf(i));
      this.GlI.A(str, (String)localObject, fyw());
      this.GlJ.loadDataWithBaseURL(parameii.url, new String(this.GlI.Gqp), "text/html", "utf-8", null);
      this.GlI.Gqp = null;
      com.tencent.mm.plugin.topstory.ui.c.c(parameii, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.GlK.aTI("");
      }
      AppMethodBeat.o(126061);
      return;
      label251:
      i = parameii.channelId;
      break;
      label259:
      this.GlJ.loadUrl(parameii.url);
      com.tencent.mm.plugin.topstory.ui.c.c(parameii, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.GlI, this.GlJ, this.GlK, this.GlH);
    this.GlI = null;
    this.GlJ = null;
    this.GlK = null;
    this.GlH = null;
    this.ygl = false;
    AppMethodBeat.o(126062);
  }
  
  public final void cC(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.GlM.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      o localo = new o(h.fxT());
      if (!localo.exists()) {
        localo.mkdirs();
      }
      s.f(h.fxT() + paramInt, paramString, paramString.length);
      Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      AppMethodBeat.o(126065);
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
      AppMethodBeat.o(126065);
    }
  }
  
  /* Error */
  public final void cD(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 306
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 312	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
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
    //   44: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: new 6	com/tencent/mm/plugin/topstory/ui/home/d$1
    //   50: dup
    //   51: aload_0
    //   52: iload_1
    //   53: aload_2
    //   54: invokespecial 317	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   57: ldc_w 319
    //   60: invokestatic 325	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */