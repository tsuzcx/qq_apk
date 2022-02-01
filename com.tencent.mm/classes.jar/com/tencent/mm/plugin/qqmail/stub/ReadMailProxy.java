package com.tencent.mm.plugin.qqmail.stub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.pluginsdk.ui.tools.q.a;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends com.tencent.mm.remoteservice.a
{
  private c.a Hlk;
  private c.a HnU;
  private ReadMailUI.a HnV;
  private q.a HnW;
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama)
  {
    super(paramd);
    AppMethodBeat.i(249801);
    this.HnW = new q.a()
    {
      public final void XN()
      {
        AppMethodBeat.i(250048);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(250048);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(250047);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(250047);
      }
    };
    this.Hlk = parama;
    this.HnU = new c.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(249988);
        ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
        AppMethodBeat.o(249988);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(249987);
        ReadMailProxy.this.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(249987);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(249985);
        boolean bool = ((Boolean)ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
        AppMethodBeat.o(249985);
        return bool;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(249986);
        ReadMailProxy.this.CLIENT_CALL("onSuccess", new Object[] { paramAnonymousString, paramAnonymousMap });
        AppMethodBeat.o(249986);
      }
    };
    AppMethodBeat.o(249801);
  }
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama, ReadMailUI.a parama1)
  {
    super(paramd);
    AppMethodBeat.i(249802);
    this.HnW = new q.a()
    {
      public final void XN()
      {
        AppMethodBeat.i(250048);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(250048);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(250047);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(250047);
      }
    };
    this.Hlk = parama;
    this.HnV = parama1;
    this.HnU = new c.a()
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
    AppMethodBeat.o(249802);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(final long paramLong)
  {
    AppMethodBeat.i(122835);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250413);
        ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().cancel(paramLong);
        AppMethodBeat.o(250413);
      }
    });
    AppMethodBeat.o(122835);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(122840);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(paramLong);
    AppMethodBeat.o(122840);
  }
  
  @com.tencent.mm.remoteservice.f
  public long downloadQQMailApp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122844);
    try
    {
      paramString1 = new URL(paramString1);
      URL localURL = new URI(paramString1.getProtocol(), paramString1.getUserInfo(), paramString1.getHost(), paramString1.getPort(), paramString1.getPath(), paramString1.getQuery(), paramString1.getRef()).toURL();
      paramString1 = new Intent();
      paramString1.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
      paramString1.putExtra("task_name", "QQ 邮箱");
      paramString1.putExtra("title", "QQ 邮箱");
      paramString1.putExtra("task_url", localURL.toString());
      paramString1.putExtra("file_md5", paramString2);
      paramString1.putExtra("fileType", 1);
      paramString1.putExtra("package_name", "com.tencent.androidqqmail");
      paramString2 = MMApplicationContext.getContext();
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramString2, paramString1.aFh(), "com/tencent/mm/plugin/qqmail/stub/ReadMailProxy", "downloadQQMailApp", "(Ljava/lang/String;Ljava/lang/String;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString2.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString2, "com/tencent/mm/plugin/qqmail/stub/ReadMailProxy", "downloadQQMailApp", "(Ljava/lang/String;Ljava/lang/String;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    long l = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().a(paramString, 0, paramMap, localb, this.HnU);
    AppMethodBeat.o(122833);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(122846);
    String str = new p(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null))).toString();
    AppMethodBeat.o(122846);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public double getMailAppDownloadProgress(long paramLong)
  {
    AppMethodBeat.i(122851);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cPZ().Ix(paramLong);
    if (localFileDownloadTaskInfo.rKZ <= 0L)
    {
      AppMethodBeat.o(122851);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.uih / localFileDownloadTaskInfo.rKZ;
    AppMethodBeat.o(122851);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(122850);
    int i = com.tencent.mm.plugin.downloader.model.f.cPZ().Ix(paramLong).status;
    AppMethodBeat.o(122850);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(122848);
    String str = com.tencent.mm.n.h.axd().getMailAppEnterUlAndroid();
    AppMethodBeat.o(122848);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(122849);
    String str = com.tencent.mm.n.h.axd().awV();
    AppMethodBeat.o(122849);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(122837);
    String str = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong).field_content;
    AppMethodBeat.o(122837);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(122855);
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhG, Integer.valueOf(-1));
    AppMethodBeat.o(122855);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(122854);
    q.a(this.HnW);
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
    boolean bool = com.tencent.mm.kernel.h.aHG().isSDCardAvailable();
    AppMethodBeat.o(122836);
    return bool;
  }
  
  @e
  public void onComplete()
  {
    AppMethodBeat.i(122827);
    if (this.Hlk != null) {
      this.Hlk.onComplete();
    }
    AppMethodBeat.o(122827);
  }
  
  @e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(122826);
    if (this.Hlk != null) {
      this.Hlk.onError(paramInt, paramString);
    }
    AppMethodBeat.o(122826);
  }
  
  @e
  public boolean onReady()
  {
    AppMethodBeat.i(122824);
    if (this.Hlk == null)
    {
      AppMethodBeat.o(122824);
      return true;
    }
    boolean bool = this.Hlk.onReady();
    AppMethodBeat.o(122824);
    return bool;
  }
  
  @e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122825);
    if (this.Hlk != null) {
      this.Hlk.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(122825);
  }
  
  @com.tencent.mm.remoteservice.f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122834);
    c.b localb = new c.b();
    localb.fromBundle(paramBundle);
    long l = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().a(paramString, paramMap, localb, this.HnU);
    AppMethodBeat.o(122834);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(122845);
    int i = com.tencent.mm.plugin.downloader.model.f.cPZ().Iw(paramLong);
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
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
        localca.setContent(localca.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.uDN + "</digest>"));
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramLong, localca);
        AppMethodBeat.o(122820);
      }
    });
    AppMethodBeat.o(122838);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122852);
    com.tencent.mm.plugin.report.service.h.IzE.a(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(122852);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(122853);
    com.tencent.mm.plugin.report.service.h.IzE.a(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
    int i = com.tencent.mm.n.h.axd().awU();
    AppMethodBeat.o(122847);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */