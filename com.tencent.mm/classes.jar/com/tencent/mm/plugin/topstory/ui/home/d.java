package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;

public class d
{
  boolean Dqn;
  private esk MYt;
  private c MYu;
  private WebSearchWebView MYv;
  private e MYw;
  public HashMap<Integer, esl> MYx;
  public HashMap<Integer, String> MYy;
  
  public d()
  {
    AppMethodBeat.i(126060);
    this.Dqn = false;
    this.MYx = new HashMap();
    this.MYy = new HashMap();
    AppMethodBeat.o(126060);
  }
  
  private String a(esk paramesk, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(206843);
    String str = "";
    Object localObject;
    if (this.MYx.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (esl)this.MYx.get(Integer.valueOf(paramInt));
      Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((esl)localObject).Uuj), Integer.valueOf(((esl)localObject).TZU), Integer.valueOf(((esl)localObject).Uuk), Long.valueOf(System.currentTimeMillis()) });
      if (((esl)localObject).Uuj + ((esl)localObject).TZU * 1000 > System.currentTimeMillis())
      {
        this.MYu.grU();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((esl)localObject).lpy;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206843);
      return localObject;
      if (((esl)localObject).Uuj + ((esl)localObject).Uuk * 1000 > System.currentTimeMillis())
      {
        this.MYu.grU();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((esl)localObject).lpy;
      }
      for (;;)
      {
        paramesk.Uuh.addAll(((esl)localObject).TZW);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.MYu.a(paramesk, false, false, 0, paramString);
        localObject = str;
        break;
        this.MYu.grU();
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.MYu.grU();
      localObject = str;
      if (paramBoolean)
      {
        this.MYu.a(paramesk, false, false, 0, paramString);
        localObject = str;
      }
    }
  }
  
  private boolean gqt()
  {
    AppMethodBeat.i(126064);
    if (this.MYx.containsKey(Integer.valueOf(100)))
    {
      esl localesl = (esl)this.MYx.get(Integer.valueOf(100));
      long l = localesl.Uuj;
      if (localesl.TZU * 1000 + l > System.currentTimeMillis())
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
  
  public final void a(esk paramesk, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(206838);
    a(paramesk, paramBoolean, paramString, null);
    AppMethodBeat.o(206838);
  }
  
  public final void a(esk paramesk, boolean paramBoolean, String paramString, LinkedList<aci> paramLinkedList)
  {
    AppMethodBeat.i(206842);
    int i;
    if (!this.Dqn)
    {
      this.Dqn = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramesk, "startCreateWB", System.currentTimeMillis());
      this.MYt = paramesk;
      this.MYu = new c();
      if (paramesk.channelId > 0) {
        break label256;
      }
      i = 100;
      paramString = a(paramesk, i, paramBoolean, paramString);
      this.MYv = new WebSearchWebView(MMApplicationContext.getContext());
      com.tencent.mm.plugin.topstory.ui.c.b localb = new com.tencent.mm.plugin.topstory.ui.c.b();
      com.tencent.mm.plugin.topstory.ui.c.d locald = new com.tencent.mm.plugin.topstory.ui.c.d(paramesk, this.MYu);
      this.MYw = new e(this.MYv, paramesk, this.MYu, paramLinkedList);
      this.MYv.a(localb, locald);
      this.MYv.addJavascriptInterface(this.MYw, "topStoryJSApi");
      if (this.MYu.Ndb == null) {
        break label265;
      }
      paramLinkedList = (String)this.MYy.get(Integer.valueOf(i));
      this.MYu.C(paramString, paramLinkedList, gqt());
      this.MYv.loadDataWithBaseURL(paramesk.url, new String(this.MYu.Ndb), "text/html", "utf-8", null);
      this.MYu.Ndb = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramesk, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.MYw.bfg("");
      }
      AppMethodBeat.o(206842);
      return;
      label256:
      i = paramesk.channelId;
      break;
      label265:
      this.MYv.loadUrl(paramesk.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramesk, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126062);
    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.MYu, this.MYv, this.MYw, this.MYt);
    this.MYu = null;
    this.MYv = null;
    this.MYw = null;
    this.MYt = null;
    this.Dqn = false;
    AppMethodBeat.o(126062);
  }
  
  public final void cD(int paramInt, String paramString)
  {
    AppMethodBeat.i(126065);
    this.MYy.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      q localq = new q(h.gpO());
      if (!localq.ifE()) {
        localq.ifL();
      }
      u.H(h.gpO() + paramInt, paramString);
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
  public final void cE(final int paramInt, final String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */