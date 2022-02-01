package com.tencent.mm.plugin.qqmail.stub;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private w.a vVN;
  private ReadMailUI.b vVO;
  private ReadMailUI.c vVP;
  private com.tencent.mm.plugin.downloader.model.m vVQ;
  private m.a vVR;
  private w.a vVd;
  
  public ReadMailProxy(d paramd, w.a parama)
  {
    super(paramd);
    AppMethodBeat.i(122822);
    this.vVQ = new ReadMailProxy.1(this);
    this.vVR = new m.a()
    {
      public final void drR()
      {
        AppMethodBeat.i(122811);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(122811);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(122810);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(122810);
      }
    };
    this.vVd = parama;
    this.vVN = new w.a()
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
    this.vVQ = new ReadMailProxy.1(this);
    this.vVR = new m.a()
    {
      public final void drR()
      {
        AppMethodBeat.i(122811);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        AppMethodBeat.o(122811);
      }
      
      public final void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(122810);
        ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(122810);
      }
    };
    this.vVd = parama;
    this.vVO = paramb;
    this.vVP = paramc;
    this.vVN = new w.a()
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
    com.tencent.mm.plugin.downloader.model.f.bXJ();
    com.tencent.mm.plugin.downloader.model.c.c(this.vVQ);
    AppMethodBeat.o(122842);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(final long paramLong)
  {
    AppMethodBeat.i(122835);
    new ao().post(new Runnable()
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
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vQ(paramLong);
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
      locala.WD(paramString1.toString());
      locala.WF("qqmail.apk");
      locala.WG(paramString2);
      locala.jF(true);
      locala.AG(1);
      l = com.tencent.mm.plugin.downloader.model.f.bXJ().a(locala.oJg);
      AppMethodBeat.o(122844);
      return l;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
        ac.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
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
    long l = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().b(paramString, paramMap, localc, this.vVN);
    AppMethodBeat.o(122833);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(122846);
    String str = new p(bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null))).toString();
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
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bXJ().rT(paramLong);
    if (localFileDownloadTaskInfo.mSs <= 0L)
    {
      AppMethodBeat.o(122851);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.oJm / localFileDownloadTaskInfo.mSs;
    AppMethodBeat.o(122851);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(122850);
    int i = com.tencent.mm.plugin.downloader.model.f.bXJ().rT(paramLong).status;
    AppMethodBeat.o(122850);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(122848);
    String str = com.tencent.mm.m.g.ZZ().getMailAppEnterUlAndroid();
    AppMethodBeat.o(122848);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(122849);
    String str = com.tencent.mm.m.g.ZZ().ZR();
    AppMethodBeat.o(122849);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(122837);
    String str = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong).field_content;
    AppMethodBeat.o(122837);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(122855);
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEP, Integer.valueOf(-1));
    AppMethodBeat.o(122855);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(122854);
    com.tencent.mm.pluginsdk.ui.tools.m.a(this.vVR);
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
    boolean bool = com.tencent.mm.kernel.g.agR().isSDCardAvailable();
    AppMethodBeat.o(122836);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onComplete()
  {
    AppMethodBeat.i(122827);
    if (this.vVd != null) {
      this.vVd.onComplete();
    }
    AppMethodBeat.o(122827);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(122826);
    if (this.vVd != null) {
      this.vVd.onError(paramInt, paramString);
    }
    AppMethodBeat.o(122826);
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean onReady()
  {
    AppMethodBeat.i(122824);
    if (this.vVd == null)
    {
      AppMethodBeat.o(122824);
      return true;
    }
    boolean bool = this.vVd.onReady();
    AppMethodBeat.o(122824);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122825);
    if (this.vVd != null) {
      this.vVd.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(122825);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFailed(long paramLong)
  {
    AppMethodBeat.i(122832);
    if (this.vVO != null) {
      ac.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122832);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFinished(long paramLong)
  {
    AppMethodBeat.i(122831);
    if (this.vVO != null) {
      ac.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122831);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(122830);
    if (this.vVO != null) {
      ac.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122830);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(122829);
    if (this.vVO != null) {
      ac.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(122829);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(122828);
    if (this.vVO != null)
    {
      ReadMailUI.b localb = this.vVO;
      ac.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
      ReadMailUI.a(localb.vZW, ai.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.YK()));
      if (ReadMailUI.o(localb.vZW) != null) {
        ReadMailUI.o(localb.vZW).edit().putString("qqmail_downloadpath", paramString).commit();
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
    long l = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().a(paramString, paramMap, localc, this.vVN);
    AppMethodBeat.o(122834);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public void removeDownloadCallback()
  {
    AppMethodBeat.i(122843);
    com.tencent.mm.plugin.downloader.model.f.bXJ();
    com.tencent.mm.plugin.downloader.model.c.bXD();
    AppMethodBeat.o(122843);
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(122845);
    int i = com.tencent.mm.plugin.downloader.model.f.bXJ().rS(paramLong);
    AppMethodBeat.o(122845);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public void replaceMsgContent(long paramLong, String paramString)
  {
    AppMethodBeat.i(122838);
    new ao().post(new ReadMailProxy.6(this, paramLong, paramString));
    AppMethodBeat.o(122838);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122852);
    com.tencent.mm.plugin.report.service.h.wUl.f(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(122852);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(122853);
    com.tencent.mm.plugin.report.service.h.wUl.f(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(122853);
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer showMailAppRecommend()
  {
    AppMethodBeat.i(122847);
    if (i.cGY == 1)
    {
      AppMethodBeat.o(122847);
      return Integer.valueOf(0);
    }
    int i = bs.getInt(com.tencent.mm.m.g.ZZ().ag("MailApp", "ShowMailAppRecommend"), 0);
    AppMethodBeat.o(122847);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */