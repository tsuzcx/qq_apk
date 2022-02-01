package com.tencent.mm.plugin.qqmail.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.pluginsdk.ui.tools.p.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private c.a NiX;
  private c.a NlH;
  private ReadMailUI.a NlI;
  private p.a NlJ;
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama)
  {
    super(paramd);
    AppMethodBeat.i(266916);
    this.NlJ = new p.a()
    {
      public final void gEh()
      {
        AppMethodBeat.i(266915);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(266915);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(266911);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(266911);
      }
    };
    this.NiX = parama;
    this.NlH = new c.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(266917);
        ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
        AppMethodBeat.o(266917);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(266914);
        ReadMailProxy.this.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(266914);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(266909);
        boolean bool = ((Boolean)ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
        AppMethodBeat.o(266909);
        return bool;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(266910);
        ReadMailProxy.this.CLIENT_CALL("onSuccess", new Object[] { paramAnonymousString, paramAnonymousMap });
        AppMethodBeat.o(266910);
      }
    };
    AppMethodBeat.o(266916);
  }
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama, ReadMailUI.a parama1)
  {
    super(paramd);
    AppMethodBeat.i(266919);
    this.NlJ = new p.a()
    {
      public final void gEh()
      {
        AppMethodBeat.i(266915);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(266915);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(266911);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(266911);
      }
    };
    this.NiX = parama;
    this.NlI = parama1;
    this.NlH = new c.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122815);
        ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
        AppMethodBeat.o(122815);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122814);
        ReadMailProxy.this.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(122814);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(122812);
        boolean bool = ((Boolean)ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
        AppMethodBeat.o(122812);
        return bool;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(122813);
        ReadMailProxy.this.CLIENT_CALL("onSuccess", new Object[] { paramAnonymousString, paramAnonymousMap });
        AppMethodBeat.o(122813);
      }
    };
    AppMethodBeat.o(266919);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(final long paramLong)
  {
    AppMethodBeat.i(122835);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266912);
        ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().cancel(paramLong);
        AppMethodBeat.o(266912);
      }
    });
    AppMethodBeat.o(122835);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(122840);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(paramLong);
    AppMethodBeat.o(122840);
  }
  
  @com.tencent.mm.remoteservice.f
  public long downloadQQMailApp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122844);
    try
    {
      paramString1 = new URL(paramString1);
      new URI(paramString1.getProtocol(), paramString1.getUserInfo(), paramString1.getHost(), paramString1.getPort(), paramString1.getPath(), paramString1.getQuery(), paramString1.getRef()).toURL();
      paramString1 = new Intent();
      paramString1.putExtra("rawUrl", "https://wx.mail.qq.com/list/readtemplate?name=wxplugin_push.html");
      c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
      AppMethodBeat.o(122844);
      return -1L;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
        Log.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
      }
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long get(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122833);
    c.b localb = new c.b();
    localb.fromBundle(paramBundle);
    long l = ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().a(paramString, 0, paramMap, localb, this.NlH);
    AppMethodBeat.o(122833);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(122846);
    String str = new com.tencent.mm.b.p(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null))).toString();
    AppMethodBeat.o(122846);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public double getMailAppDownloadProgress(long paramLong)
  {
    AppMethodBeat.i(122851);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.duv().kS(paramLong);
    if (localFileDownloadTaskInfo.uWn <= 0L)
    {
      AppMethodBeat.o(122851);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.xom / localFileDownloadTaskInfo.uWn;
    AppMethodBeat.o(122851);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(122850);
    int i = com.tencent.mm.plugin.downloader.model.f.duv().kS(paramLong).status;
    AppMethodBeat.o(122850);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(122848);
    String str = com.tencent.mm.k.i.aRD().getMailAppEnterUlAndroid();
    AppMethodBeat.o(122848);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(122849);
    String str = com.tencent.mm.k.i.aRD().aRv();
    AppMethodBeat.o(122849);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(122837);
    String str = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong).field_content;
    AppMethodBeat.o(122837);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(122855);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acJa, Integer.valueOf(-1));
    AppMethodBeat.o(122855);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(122854);
    com.tencent.mm.pluginsdk.ui.tools.p.a(this.NlJ);
    AppMethodBeat.o(122854);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUserBindEmail()
  {
    AppMethodBeat.i(122841);
    String str = z.getUserBindEmail();
    AppMethodBeat.o(122841);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isSDCardAvailable()
  {
    AppMethodBeat.i(122836);
    boolean bool = com.tencent.mm.kernel.h.baE().isSDCardAvailable();
    AppMethodBeat.o(122836);
    return bool;
  }
  
  @e
  public void onComplete()
  {
    AppMethodBeat.i(122827);
    if (this.NiX != null) {
      this.NiX.onComplete();
    }
    AppMethodBeat.o(122827);
  }
  
  @e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(122826);
    if (this.NiX != null) {
      this.NiX.onError(paramInt, paramString);
    }
    AppMethodBeat.o(122826);
  }
  
  @e
  public boolean onReady()
  {
    AppMethodBeat.i(122824);
    if (this.NiX == null)
    {
      AppMethodBeat.o(122824);
      return true;
    }
    boolean bool = this.NiX.onReady();
    AppMethodBeat.o(122824);
    return bool;
  }
  
  @e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122825);
    if (this.NiX != null) {
      this.NiX.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(122825);
  }
  
  @com.tencent.mm.remoteservice.f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122834);
    c.b localb = new c.b();
    localb.fromBundle(paramBundle);
    long l = ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().a(paramString, paramMap, localb, this.NlH);
    AppMethodBeat.o(122834);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(122845);
    int i = com.tencent.mm.plugin.downloader.model.f.duv().kR(paramLong);
    AppMethodBeat.o(122845);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public void replaceMsgContent(final long paramLong, String paramString)
  {
    AppMethodBeat.i(122838);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122820);
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
        localcc.setContent(localcc.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.xMf + "</digest>"));
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramLong, localcc);
        AppMethodBeat.o(122820);
      }
    });
    AppMethodBeat.o(122838);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122852);
    com.tencent.mm.plugin.report.service.h.OAn.b(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(122852);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(122853);
    com.tencent.mm.plugin.report.service.h.OAn.b(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(122853);
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer showMailAppRecommend()
  {
    AppMethodBeat.i(122847);
    if (ChannelUtil.channelId == 1)
    {
      AppMethodBeat.o(122847);
      return Integer.valueOf(0);
    }
    int i = com.tencent.mm.k.i.aRD().aRu();
    AppMethodBeat.o(122847);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */