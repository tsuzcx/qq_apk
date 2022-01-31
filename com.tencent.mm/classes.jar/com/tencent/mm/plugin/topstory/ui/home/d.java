package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.a;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.byc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private byb pEd;
  private com.tencent.mm.plugin.topstory.ui.webview.b pEe;
  private TopStoryWebView pEf;
  private com.tencent.mm.plugin.topstory.ui.webview.d pEg;
  boolean pEh = false;
  public HashMap<Integer, byc> pEi = new HashMap();
  HashMap<Integer, String> pEj = new HashMap();
  
  public final void a(b paramb)
  {
    y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", new Object[] { Integer.valueOf(paramb.hashCode()) });
    paramb.a(this.pEe, this.pEf, this.pEg, this.pEd);
    this.pEe = null;
    this.pEf = null;
    this.pEg = null;
    this.pEd = null;
    this.pEh = false;
  }
  
  public final void aL(int paramInt, String paramString)
  {
    this.pEj.put(Integer.valueOf(paramInt), paramString);
    try
    {
      paramString = paramString.getBytes("utf-8");
      File localFile = new File(g.bNf());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      e.b(g.bNf() + paramInt, paramString, paramString.length);
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramString.length) });
      return;
    }
    catch (IOException paramString)
    {
      y.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", paramString, "putNegDataCache", new Object[0]);
    }
  }
  
  /* Error */
  public final void aM(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 136	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 37
    //   16: ldc 138
    //   18: iconst_2
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_2
    //   32: aastore
    //   33: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: new 140	com/tencent/mm/plugin/topstory/ui/home/d$1
    //   39: dup
    //   40: aload_0
    //   41: iload_1
    //   42: aload_2
    //   43: invokespecial 143	com/tencent/mm/plugin/topstory/ui/home/d$1:<init>	(Lcom/tencent/mm/plugin/topstory/ui/home/d;ILjava/lang/String;)V
    //   46: ldc 145
    //   48: invokestatic 151	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   51: goto -40 -> 11
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	d
    //   0	59	1	paramInt	int
    //   0	59	2	paramString	String
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   14	51	54	finally
  }
  
  public final void b(byb parambyb)
  {
    int i;
    String str;
    Object localObject1;
    label176:
    Object localObject2;
    Object localObject3;
    if (!this.pEh)
    {
      this.pEh = true;
      com.tencent.mm.plugin.topstory.ui.d.c(parambyb, "startCreateWB", System.currentTimeMillis());
      this.pEd = parambyb;
      this.pEe = new com.tencent.mm.plugin.topstory.ui.webview.b();
      if (parambyb.bvj > 0) {
        break label575;
      }
      i = 100;
      str = "";
      if (!this.pEi.containsKey(Integer.valueOf(i))) {
        break label670;
      }
      localObject1 = (byc)this.pEi.get(Integer.valueOf(i));
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", new Object[] { Long.valueOf(((byc)localObject1).tOf), Integer.valueOf(((byc)localObject1).tDg), Integer.valueOf(((byc)localObject1).tOg), Long.valueOf(System.currentTimeMillis()) });
      if (((byc)localObject1).tOf + ((byc)localObject1).tDg * 1000 <= System.currentTimeMillis()) {
        break label583;
      }
      this.pEe.bOF();
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
      str = ((byc)localObject1).kVs;
      this.pEf = new TopStoryWebView(ae.getContext());
      localObject1 = new a();
      localObject2 = new c(parambyb, this.pEe);
      this.pEg = new com.tencent.mm.plugin.topstory.ui.webview.d(this.pEf, parambyb, this.pEe);
      this.pEf.a((a)localObject1, (c)localObject2);
      this.pEf.addJavascriptInterface(this.pEg, "topStoryJSApi");
      if (this.pEe.pIh == null) {
        break label707;
      }
      localObject2 = (String)this.pEj.get(Integer.valueOf(i));
      localObject1 = this.pEe;
      if (!this.pEi.containsKey(Integer.valueOf(100))) {
        break label689;
      }
      localObject3 = (byc)this.pEi.get(Integer.valueOf(100));
      if (((byc)localObject3).tOf + ((byc)localObject3).tDg * 1000 <= System.currentTimeMillis()) {
        break label689;
      }
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
      i = 0;
      label354:
      if ((!bk.bl(str)) && (((com.tencent.mm.plugin.topstory.ui.webview.b)localObject1).pIh != null)) {
        localObject3 = new JSONObject();
      }
    }
    for (;;)
    {
      label670:
      label689:
      try
      {
        ((JSONObject)localObject3).put("json", str);
        ((JSONObject)localObject3).put("newQuery", true);
        ((JSONObject)localObject3).put("isCache", true);
        if (i == 0) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject3).put("recType", i);
        if (!bk.bl((String)localObject2)) {
          ((JSONObject)localObject3).put("filterDocidList", new JSONArray((String)localObject2));
        }
      }
      catch (Exception localException)
      {
        label575:
        label583:
        continue;
      }
      ((com.tencent.mm.plugin.topstory.ui.webview.b)localObject1).pIh = new String(((com.tencent.mm.plugin.topstory.ui.webview.b)localObject1).pIh).replace("'###preloadObjFeedsData###'", ((JSONObject)localObject3).toString() + "\n").getBytes();
      y.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.topstory.ui.webview.b)localObject1).pIh.length) });
      this.pEf.loadDataWithBaseURL(parambyb.url, new String(this.pEe.pIh), "text/html", "utf-8", null);
      this.pEe.pIh = null;
      com.tencent.mm.plugin.topstory.ui.d.c(parambyb, "endCreateWBWithLoadData", System.currentTimeMillis());
      return;
      i = parambyb.bvj;
      break;
      if (((byc)localObject1).tOf + ((byc)localObject1).tOg * 1000 > System.currentTimeMillis())
      {
        this.pEe.bOF();
        y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
        str = ((byc)localObject1).kVs;
        parambyb.tOe.addAll(((byc)localObject1).tDi);
        this.pEe.a(parambyb, false);
        break label176;
      }
      this.pEe.bOF();
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
      continue;
      this.pEe.bOF();
      this.pEe.a(parambyb, false);
      break label176;
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
      i = 1;
      break label354;
      i = 0;
    }
    label707:
    this.pEf.loadUrl(parambyb.url);
    com.tencent.mm.plugin.topstory.ui.d.c(parambyb, "endCreateWBWithLoadURL", System.currentTimeMillis());
  }
  
  public final void bNo()
  {
    File localFile = new File(g.bNf());
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
          int k = bk.getInt(localFile.getName(), -1);
          if (k > 0) {}
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = e.c(localFile.getAbsolutePath(), 0, -1);
              String str = new String(arrayOfByte, "utf-8");
              this.pEj.put(Integer.valueOf(k), str);
              y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
            }
            catch (Exception localException)
            {
              y.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException, "loadNegDataCache %s", new Object[] { localFile.getAbsoluteFile() });
              continue;
            }
            y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { localFile.getAbsolutePath() });
          }
        }
      }
      else
      {
        y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { localFile.getAbsolutePath() });
      }
      return;
    }
    y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { localFile.getAbsolutePath() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.d
 * JD-Core Version:    0.7.0.1
 */