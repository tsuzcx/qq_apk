package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fnu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;

public class d
{
  boolean JjV;
  private fnt TLc;
  private c TLd;
  private WebSearchWebView TLe;
  private e TLf;
  public HashMap<Integer, fnu> TLg;
  public HashMap<Integer, String> TLh;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.JjV = false;
    this.TLg = new HashMap();
    this.TLh = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(fnt paramfnt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126063);
    String str = "";
    Object localObject;
    if (this.TLg.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (fnu)this.TLg.get(Integer.valueOf(paramInt));
      Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((fnu)localObject).abNM), Integer.valueOf(((fnu)localObject).abqR), Integer.valueOf(((fnu)localObject).abNN), Long.valueOf(cn.bDw()) });
      if (((fnu)localObject).abNM + ((fnu)localObject).abqR * 1000 > cn.bDw())
      {
        this.TLd.hOV();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((fnu)localObject).nUB;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126063);
      return localObject;
      if (((fnu)localObject).abNM + ((fnu)localObject).abNN * 1000 > cn.bDw())
      {
        this.TLd.hOV();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((fnu)localObject).nUB;
      }
      for (;;)
      {
        paramfnt.abNH.addAll(((fnu)localObject).abqT);
        localObject = i.agtt;
        paramInt = i.a(b.a.agqN, 0);
        localObject = str;
        if (paramInt == 1) {
          break;
        }
        if (paramInt != 2) {
          break label263;
        }
        this.TLd.a(paramfnt, false, false, 0);
        localObject = str;
        break;
        this.TLd.hOV();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      label263:
      localObject = str;
      if (paramBoolean)
      {
        this.TLd.a(paramfnt, false, false, 0);
        localObject = str;
        continue;
        this.TLd.hOV();
        localObject = str;
        if (paramBoolean)
        {
          this.TLd.a(paramfnt, false, false, 0);
          localObject = str;
        }
      }
    }
  }
  
  private boolean hNs()
  {
    AppMethodBeat.i(126064);
    if (this.TLg.containsKey(Integer.valueOf(100)))
    {
      fnu localfnu = (fnu)this.TLg.get(Integer.valueOf(100));
      long l = localfnu.abNM;
      if (localfnu.abqR * 1000 + l > cn.bDw())
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
  
  public final void a(fnt paramfnt, boolean paramBoolean, LinkedList<aem> paramLinkedList)
  {
    AppMethodBeat.i(271780);
    int i;
    if (!this.JjV)
    {
      this.JjV = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramfnt, "startCreateWB", cn.bDw());
      this.TLc = paramfnt;
      this.TLd = new c();
      if (paramfnt.channelId > 0) {
        break label251;
      }
      i = 100;
      String str = a(paramfnt, i, paramBoolean);
      this.TLe = new WebSearchWebView(MMApplicationContext.getContext());
      com.tencent.mm.plugin.topstory.ui.c.b localb = new com.tencent.mm.plugin.topstory.ui.c.b();
      com.tencent.mm.plugin.topstory.ui.c.d locald = new com.tencent.mm.plugin.topstory.ui.c.d(paramfnt);
      this.TLf = new e(this.TLe, paramfnt, this.TLd, paramLinkedList);
      this.TLe.a(localb, locald);
      this.TLe.addJavascriptInterface(this.TLf, "topStoryJSApi");
      if (this.TLd.TPM == null) {
        break label260;
      }
      paramLinkedList = (String)this.TLh.get(Integer.valueOf(i));
      this.TLd.I(str, paramLinkedList, hNs());
      this.TLe.loadDataWithBaseURL(paramfnt.url, new String(this.TLd.TPM), "text/html", "utf-8", null);
      this.TLd.TPM = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramfnt, "endCreateWBWithLoadData", cn.bDw());
    }
    for (;;)
    {
      if (g.aoK(i)) {
        this.TLf.beD("");
      }
      AppMethodBeat.o(271780);
      return;
      label251:
      i = paramfnt.channelId;
      break;
      label260:
      this.TLe.loadUrl(paramfnt.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramfnt, "endCreateWBWithLoadURL", cn.bDw());
    }
  }
  
  public final void ds(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.TLh.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      u localu = new u(g.hMK());
      if (!localu.jKS()) {
        localu.jKY();
      }
      y.f(g.hMK() + paramInt, paramString, paramString.length);
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
  public final void dt(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 313
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 319	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 313
    //   18: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc 68
    //   26: ldc_w 321
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
    //   54: invokespecial 324	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   57: ldc_w 326
    //   60: invokestatic 332	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   63: ldc_w 313
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
  
  public final void n(b paramb)
  {
    AppMethodBeat.i(126062);
    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.TLd, this.TLe, this.TLf, this.TLc);
    this.TLd = null;
    this.TLe = null;
    this.TLf = null;
    this.TLc = null;
    this.JjV = false;
    AppMethodBeat.o(126062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */