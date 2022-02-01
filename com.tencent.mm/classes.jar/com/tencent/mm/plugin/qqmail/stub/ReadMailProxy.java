package com.tencent.mm.plugin.qqmail.stub;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.plugin.qqmail.b.w.c;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.pluginsdk.ui.tools.m.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private w.a uMX;
  private ReadMailUI.b uMY;
  private ReadMailUI.c uMZ;
  private w.a uMn;
  private com.tencent.mm.plugin.downloader.model.m uNa;
  private m.a uNb;
  
  public ReadMailProxy(d paramd, w.a parama)
  {
    super(paramd);
    AppMethodBeat.i(122822);
    this.uNa = new ReadMailProxy.1(this);
    this.uNb = new ReadMailProxy.2(this);
    this.uMn = parama;
    this.uMX = new w.a()
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
    AppMethodBeat.o(122822);
  }
  
  public ReadMailProxy(d paramd, w.a parama, ReadMailUI.b paramb, ReadMailUI.c paramc)
  {
    super(paramd);
    AppMethodBeat.i(122823);
    this.uNa = new ReadMailProxy.1(this);
    this.uNb = new ReadMailProxy.2(this);
    this.uMn = parama;
    this.uMY = paramb;
    this.uMZ = paramc;
    this.uMX = new w.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122819);
        ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
        AppMethodBeat.o(122819);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122818);
        ReadMailProxy.this.CLIENT_CALL("onError", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        AppMethodBeat.o(122818);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(122816);
        boolean bool = ((Boolean)ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
        AppMethodBeat.o(122816);
        return bool;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(122817);
        ReadMailProxy.this.CLIENT_CALL("onSuccess", new Object[] { paramAnonymousString, paramAnonymousMap });
        AppMethodBeat.o(122817);
      }
    };
    AppMethodBeat.o(122823);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addDownloadCallback()
  {
    AppMethodBeat.i(122842);
    com.tencent.mm.plugin.downloader.model.f.bQt();
    com.tencent.mm.plugin.downloader.model.c.c(this.uNa);
    AppMethodBeat.o(122842);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(final long paramLong)
  {
    AppMethodBeat.i(122835);
    new ap().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122820);
        ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().cancel(paramLong);
        AppMethodBeat.o(122820);
      }
    });
    AppMethodBeat.o(122835);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(122840);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rn(paramLong);
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
      locala.Sr(paramString1.toString());
      locala.St("qqmail.apk");
      locala.Su(paramString2);
      locala.jc(true);
      locala.zO(1);
      l = com.tencent.mm.plugin.downloader.model.f.bQt().a(locala.ofF);
      AppMethodBeat.o(122844);
      return l;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
        ad.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
        long l = -1L;
      }
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long get(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122833);
    w.c localc = new w.c();
    localc.fromBundle(paramBundle);
    long l = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().b(paramString, paramMap, localc, this.uMX);
    AppMethodBeat.o(122833);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(122846);
    String str = new p(bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null))).toString();
    AppMethodBeat.o(122846);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Map getCookie()
  {
    AppMethodBeat.i(122839);
    Map localMap = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().getCookie();
    AppMethodBeat.o(122839);
    return localMap;
  }
  
  @com.tencent.mm.remoteservice.f
  public double getMailAppDownloadProgress(long paramLong)
  {
    AppMethodBeat.i(122851);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bQt().oh(paramLong);
    if (localFileDownloadTaskInfo.mqq <= 0L)
    {
      AppMethodBeat.o(122851);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.ofL / localFileDownloadTaskInfo.mqq;
    AppMethodBeat.o(122851);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(122850);
    int i = com.tencent.mm.plugin.downloader.model.f.bQt().oh(paramLong).status;
    AppMethodBeat.o(122850);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(122848);
    String str = com.tencent.mm.m.g.Ze().getMailAppEnterUlAndroid();
    AppMethodBeat.o(122848);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(122849);
    String str = com.tencent.mm.m.g.Ze().YU();
    AppMethodBeat.o(122849);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(122837);
    String str = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong).field_content;
    AppMethodBeat.o(122837);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(122855);
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhb, Integer.valueOf(-1));
    AppMethodBeat.o(122855);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(122854);
    com.tencent.mm.pluginsdk.ui.tools.m.a(this.uNb);
    AppMethodBeat.o(122854);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUserBindEmail()
  {
    AppMethodBeat.i(122841);
    String str = u.getUserBindEmail();
    AppMethodBeat.o(122841);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isSDCardAvailable()
  {
    AppMethodBeat.i(122836);
    boolean bool = com.tencent.mm.kernel.g.afB().isSDCardAvailable();
    AppMethodBeat.o(122836);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onComplete()
  {
    AppMethodBeat.i(122827);
    if (this.uMn != null) {
      this.uMn.onComplete();
    }
    AppMethodBeat.o(122827);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(122826);
    if (this.uMn != null) {
      this.uMn.onError(paramInt, paramString);
    }
    AppMethodBeat.o(122826);
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean onReady()
  {
    AppMethodBeat.i(122824);
    if (this.uMn == null)
    {
      AppMethodBeat.o(122824);
      return true;
    }
    boolean bool = this.uMn.onReady();
    AppMethodBeat.o(122824);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122825);
    if (this.uMn != null) {
      this.uMn.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(122825);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFailed(long paramLong)
  {
    AppMethodBeat.i(122832);
    if (this.uMY != null) {
      ad.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122832);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFinished(long paramLong)
  {
    AppMethodBeat.i(122831);
    if (this.uMY != null) {
      ad.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122831);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(122830);
    if (this.uMY != null) {
      ad.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122830);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(122829);
    if (this.uMY != null) {
      ad.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122829);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(122828);
    if (this.uMY != null)
    {
      ReadMailUI.b localb = this.uMY;
      ad.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
      ReadMailUI.a(localb.uRh, aj.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.XN()));
      if (ReadMailUI.o(localb.uRh) != null) {
        ReadMailUI.o(localb.uRh).edit().putString("qqmail_downloadpath", paramString).commit();
      }
    }
    AppMethodBeat.o(122828);
  }
  
  @com.tencent.mm.remoteservice.f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(122834);
    w.c localc = new w.c();
    localc.fromBundle(paramBundle);
    long l = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().a(paramString, paramMap, localc, this.uMX);
    AppMethodBeat.o(122834);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public void removeDownloadCallback()
  {
    AppMethodBeat.i(122843);
    com.tencent.mm.plugin.downloader.model.f.bQt();
    com.tencent.mm.plugin.downloader.model.c.bQn();
    AppMethodBeat.o(122843);
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(122845);
    int i = com.tencent.mm.plugin.downloader.model.f.bQt().og(paramLong);
    AppMethodBeat.o(122845);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public void replaceMsgContent(long paramLong, String paramString)
  {
    AppMethodBeat.i(122838);
    new ap().post(new ReadMailProxy.6(this, paramLong, paramString));
    AppMethodBeat.o(122838);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122852);
    com.tencent.mm.plugin.report.service.h.vKh.f(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(122852);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(122853);
    com.tencent.mm.plugin.report.service.h.vKh.f(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(122853);
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer showMailAppRecommend()
  {
    AppMethodBeat.i(122847);
    if (i.cJR == 1)
    {
      AppMethodBeat.o(122847);
      return Integer.valueOf(0);
    }
    int i = bt.getInt(com.tencent.mm.m.g.Ze().ad("MailApp", "ShowMailAppRecommend"), 0);
    AppMethodBeat.o(122847);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */