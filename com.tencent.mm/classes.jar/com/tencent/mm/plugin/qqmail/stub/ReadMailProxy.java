package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.pluginsdk.ui.tools.o.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private c.a BqR;
  private c.a BtA;
  private ReadMailUI.a BtB;
  private o.a BtC;
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama)
  {
    super(paramd);
    AppMethodBeat.i(198675);
    this.BtC = new o.a()
    {
      public final void eGv()
      {
        AppMethodBeat.i(198669);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(198669);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(198668);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(198668);
      }
    };
    this.BqR = parama;
    this.BtA = new c.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(198673);
        ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
        AppMethodBeat.o(198673);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(198672);
        ReadMailProxy.this.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(198672);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(198670);
        boolean bool = ((Boolean)ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
        AppMethodBeat.o(198670);
        return bool;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(198671);
        ReadMailProxy.this.CLIENT_CALL("onSuccess", new Object[] { paramAnonymousString, paramAnonymousMap });
        AppMethodBeat.o(198671);
      }
    };
    AppMethodBeat.o(198675);
  }
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, c.a parama, ReadMailUI.a parama1)
  {
    super(paramd);
    AppMethodBeat.i(198676);
    this.BtC = new o.a()
    {
      public final void eGv()
      {
        AppMethodBeat.i(198669);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(198669);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(198668);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(198668);
      }
    };
    this.BqR = parama;
    this.BtB = parama1;
    this.BtA = new c.a()
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
    AppMethodBeat.o(198676);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(final long paramLong)
  {
    AppMethodBeat.i(122835);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198674);
        ((k)g.ah(k.class)).getNormalMailAppService().cancel(paramLong);
        AppMethodBeat.o(198674);
      }
    });
    AppMethodBeat.o(122835);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(122840);
    ((l)g.af(l.class)).eiy().Hc(paramLong);
    AppMethodBeat.o(122840);
  }
  
  @com.tencent.mm.remoteservice.f
  public long downloadQQMailApp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122844);
    try
    {
      paramString1 = new URL(paramString1);
      paramString1 = new URI(paramString1.getProtocol(), paramString1.getUserInfo(), paramString1.getHost(), paramString1.getPort(), paramString1.getPath(), paramString1.getQuery(), paramString1.getRef()).toURL();
      g.a locala = new g.a();
      locala.alj(paramString1.toString());
      locala.all("qqmail.apk");
      locala.setFileMD5(paramString2);
      locala.kS(true);
      locala.Fl(1);
      l = com.tencent.mm.plugin.downloader.model.f.cBv().a(locala.qIY);
      AppMethodBeat.o(122844);
      return l;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
        Log.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
        long l = -1L;
      }
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long get(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122833);
    c.b localb = new c.b();
    localb.fromBundle(paramBundle);
    long l = ((k)g.ah(k.class)).getNormalMailAppService().a(paramString, 0, paramMap, localb, this.BtA);
    AppMethodBeat.o(122833);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(122846);
    String str = new p(Util.nullAsNil((Integer)g.aAh().azQ().get(9, null))).toString();
    AppMethodBeat.o(122846);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public double getMailAppDownloadProgress(long paramLong)
  {
    AppMethodBeat.i(122851);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.cBv().Co(paramLong);
    if (localFileDownloadTaskInfo.oJj <= 0L)
    {
      AppMethodBeat.o(122851);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.qJe / localFileDownloadTaskInfo.oJj;
    AppMethodBeat.o(122851);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(122850);
    int i = com.tencent.mm.plugin.downloader.model.f.cBv().Co(paramLong).status;
    AppMethodBeat.o(122850);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(122848);
    String str = com.tencent.mm.n.h.aqK().getMailAppEnterUlAndroid();
    AppMethodBeat.o(122848);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(122849);
    String str = com.tencent.mm.n.h.aqK().aqC();
    AppMethodBeat.o(122849);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(122837);
    String str = ((l)g.af(l.class)).eiy().Hb(paramLong).field_content;
    AppMethodBeat.o(122837);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(122855);
    Object localObject = g.aAh().azQ().get(ar.a.NTG, Integer.valueOf(-1));
    AppMethodBeat.o(122855);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(122854);
    o.a(this.BtC);
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
    boolean bool = g.aAh().isSDCardAvailable();
    AppMethodBeat.o(122836);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onComplete()
  {
    AppMethodBeat.i(122827);
    if (this.BqR != null) {
      this.BqR.onComplete();
    }
    AppMethodBeat.o(122827);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(122826);
    if (this.BqR != null) {
      this.BqR.onError(paramInt, paramString);
    }
    AppMethodBeat.o(122826);
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean onReady()
  {
    AppMethodBeat.i(122824);
    if (this.BqR == null)
    {
      AppMethodBeat.o(122824);
      return true;
    }
    boolean bool = this.BqR.onReady();
    AppMethodBeat.o(122824);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122825);
    if (this.BqR != null) {
      this.BqR.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(122825);
  }
  
  @com.tencent.mm.remoteservice.f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122834);
    c.b localb = new c.b();
    localb.fromBundle(paramBundle);
    long l = ((k)g.ah(k.class)).getNormalMailAppService().a(paramString, paramMap, localb, this.BtA);
    AppMethodBeat.o(122834);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(122845);
    int i = com.tencent.mm.plugin.downloader.model.f.cBv().Cn(paramLong);
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
        ca localca = ((l)g.af(l.class)).eiy().Hb(paramLong);
        localca.setContent(localca.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.raN + "</digest>"));
        ((l)g.af(l.class)).eiy().a(paramLong, localca);
        AppMethodBeat.o(122820);
      }
    });
    AppMethodBeat.o(122838);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122852);
    com.tencent.mm.plugin.report.service.h.CyF.a(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(122852);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(122853);
    com.tencent.mm.plugin.report.service.h.CyF.a(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
    int i = com.tencent.mm.n.h.aqK().aqB();
    AppMethodBeat.o(122847);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */