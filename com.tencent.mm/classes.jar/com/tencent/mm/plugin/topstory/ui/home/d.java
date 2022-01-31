package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public final class d
{
  private c thA;
  private TopStoryWebView thB;
  private com.tencent.mm.plugin.topstory.ui.webview.e thC;
  boolean thD;
  public HashMap<Integer, ckp> thE;
  HashMap<Integer, String> thF;
  private cko thz;
  
  public d()
  {
    AppMethodBeat.i(1701);
    this.thD = false;
    this.thE = new HashMap();
    this.thF = new HashMap();
    AppMethodBeat.o(1701);
  }
  
  private String a(cko paramcko, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(1704);
    String str = "";
    Object localObject;
    if (this.thE.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (ckp)this.thE.get(Integer.valueOf(paramInt));
      ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((ckp)localObject).xUA), Integer.valueOf(((ckp)localObject).xFw), Integer.valueOf(((ckp)localObject).xUB), Long.valueOf(System.currentTimeMillis()) });
      if (((ckp)localObject).xUA + ((ckp)localObject).xFw * 1000 > System.currentTimeMillis())
      {
        this.thA.cKw();
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
        localObject = ((ckp)localObject).ntu;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(1704);
      return localObject;
      if (((ckp)localObject).xUA + ((ckp)localObject).xUB * 1000 > System.currentTimeMillis())
      {
        this.thA.cKw();
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((ckp)localObject).ntu;
      }
      for (;;)
      {
        paramcko.xUz.addAll(((ckp)localObject).xFy);
        localObject = str;
        if (!paramBoolean) {
          break;
        }
        this.thA.a(paramcko, false, false, 0);
        localObject = str;
        break;
        this.thA.cKw();
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      }
      this.thA.cKw();
      localObject = str;
      if (paramBoolean)
      {
        this.thA.a(paramcko, false, false, 0);
        localObject = str;
      }
    }
  }
  
  private boolean cIX()
  {
    AppMethodBeat.i(1705);
    if (this.thE.containsKey(Integer.valueOf(100)))
    {
      ckp localckp = (ckp)this.thE.get(Integer.valueOf(100));
      long l = localckp.xUA;
      if (localckp.xFw * 1000 + l > System.currentTimeMillis())
      {
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
        AppMethodBeat.o(1705);
        return false;
      }
    }
    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
    AppMethodBeat.o(1705);
    return true;
  }
  
  public final void a(cko paramcko, boolean paramBoolean)
  {
    AppMethodBeat.i(1702);
    int i;
    if (!this.thD)
    {
      this.thD = true;
      com.tencent.mm.plugin.topstory.ui.d.c(paramcko, "startCreateWB", System.currentTimeMillis());
      this.thz = paramcko;
      this.thA = new c();
      if (paramcko.bWu > 0) {
        break label253;
      }
      i = 100;
      String str = a(paramcko, i, paramBoolean);
      this.thB = new TopStoryWebView(ah.getContext());
      Object localObject = new com.tencent.mm.plugin.topstory.ui.webview.b();
      com.tencent.mm.plugin.topstory.ui.webview.d locald = new com.tencent.mm.plugin.topstory.ui.webview.d(paramcko, this.thA);
      this.thC = new com.tencent.mm.plugin.topstory.ui.webview.e(this.thB, paramcko, this.thA);
      this.thB.a((com.tencent.mm.plugin.topstory.ui.webview.b)localObject, locald);
      this.thB.addJavascriptInterface(this.thC, "topStoryJSApi");
      if (this.thA.tlW == null) {
        break label261;
      }
      localObject = (String)this.thF.get(Integer.valueOf(i));
      this.thA.y(str, (String)localObject, cIX());
      this.thB.loadDataWithBaseURL(paramcko.url, new String(this.thA.tlW), "text/html", "utf-8", null);
      this.thA.tlW = null;
      com.tencent.mm.plugin.topstory.ui.d.c(paramcko, "endCreateWBWithLoadData", System.currentTimeMillis());
    }
    for (;;)
    {
      if (100 == i) {
        this.thC.aes("");
      }
      AppMethodBeat.o(1702);
      return;
      label253:
      i = paramcko.bWu;
      break;
      label261:
      this.thB.loadUrl(paramcko.url);
      com.tencent.mm.plugin.topstory.ui.d.c(paramcko, "endCreateWBWithLoadURL", System.currentTimeMillis());
    }
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(1703);
    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.thA, this.thB, this.thC, this.thz);
    this.thA = null;
    this.thB = null;
    this.thC = null;
    this.thz = null;
    this.thD = false;
    AppMethodBeat.o(1703);
  }
  
  public final void bp(int paramInt, String paramString)
  {
    AppMethodBeat.i(1706);
    this.thF.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      File localFile = new File(g.cIy());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      com.tencent.mm.vfs.e.b(g.cIy() + paramInt, paramString, paramString.length);
      ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      AppMethodBeat.o(1706);
      return;
    }
    catch (IOException paramString)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
      AppMethodBeat.o(1706);
    }
  }
  
  /* Error */
  public final void bq(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 1707
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokestatic 302	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +12 -> 24
    //   15: sipush 1707
    //   18: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc 64
    //   26: ldc_w 304
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_1
    //   36: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_2
    //   43: aastore
    //   44: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: new 306	com/tencent/mm/plugin/topstory/ui/home/d$1
    //   50: dup
    //   51: aload_0
    //   52: iload_1
    //   53: aload_2
    //   54: invokespecial 309	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   57: ldc_w 311
    //   60: invokestatic 317	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   63: sipush 1707
    //   66: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void cIY()
  {
    AppMethodBeat.i(1708);
    File localFile = new File(g.cIy());
    if (localFile.exists())
    {
      File[] arrayOfFile = localFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          localFile = arrayOfFile[i];
          int k = bo.getInt(localFile.getName(), -1);
          if (k > 0) {}
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = com.tencent.mm.vfs.e.i(localFile.getAbsolutePath(), 0, -1);
              String str = new String(arrayOfByte, "utf-8");
              this.thF.put(Integer.valueOf(k), str);
              ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
            }
            catch (Exception localException)
            {
              ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException, "loadNegDataCache %s", new Object[] { localFile.getAbsoluteFile() });
              continue;
            }
            ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { localFile.getAbsolutePath() });
          }
        }
        AppMethodBeat.o(1708);
        return;
      }
      ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { localFile.getAbsolutePath() });
      AppMethodBeat.o(1708);
      return;
    }
    ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { localFile.getAbsolutePath() });
    AppMethodBeat.o(1708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */