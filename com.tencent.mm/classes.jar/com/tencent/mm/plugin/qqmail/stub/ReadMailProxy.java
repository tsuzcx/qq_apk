package com.tencent.mm.plugin.qqmail.stub;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.a.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private v.a neF;
  private v.a nfu;
  private ReadMailUI.b nfv;
  private ReadMailUI.c nfw;
  private k nfx = new ReadMailProxy.1(this);
  private i.a nfy = new ReadMailProxy.2(this);
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, v.a parama)
  {
    super(paramd);
    this.neF = parama;
    this.nfu = new ReadMailProxy.3(this);
  }
  
  public ReadMailProxy(com.tencent.mm.remoteservice.d paramd, v.a parama, ReadMailUI.b paramb, ReadMailUI.c paramc)
  {
    super(paramd);
    this.neF = parama;
    this.nfv = paramb;
    this.nfw = paramc;
    this.nfu = new ReadMailProxy.4(this);
  }
  
  @f
  public void addDownloadCallback()
  {
    com.tencent.mm.plugin.downloader.model.d.aFP();
    b.c(this.nfx);
  }
  
  @f
  public void cancel(long paramLong)
  {
    new ah().post(new ReadMailProxy.5(this, paramLong));
  }
  
  @f
  public void deleteMsgById(long paramLong)
  {
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fe(paramLong);
  }
  
  @f
  public long downloadQQMailApp(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new URL(paramString1);
      paramString1 = new URI(paramString1.getProtocol(), paramString1.getUserInfo(), paramString1.getHost(), paramString1.getPort(), paramString1.getPath(), paramString1.getQuery(), paramString1.getRef()).toURL();
      e.a locala = new e.a();
      locala.zN(paramString1.toString());
      locala.zP("qqmail.apk");
      locala.zQ(paramString2);
      locala.eO(true);
      locala.pE(1);
      long l = com.tencent.mm.plugin.downloader.model.d.aFP().a(locala.iPG);
      return l;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
      y.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
    }
    return -1L;
  }
  
  @f
  public long get(String paramString, Map paramMap, Bundle paramBundle)
  {
    v.c localc = new v.c();
    localc.fromBundle(paramBundle);
    return ac.btF().b(paramString, paramMap, localc, this.nfu);
  }
  
  @f
  public String getBindUin()
  {
    return new o(bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(9, null))).toString();
  }
  
  @f
  public Map getCookie()
  {
    return ac.btF().getCookie();
  }
  
  @f
  public double getMailAppDownloadProgress(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.d.aFP().dd(paramLong);
    if (localFileDownloadTaskInfo.hFz <= 0L) {
      return 0.0D;
    }
    return 1.0D * localFileDownloadTaskInfo.iPM / localFileDownloadTaskInfo.hFz;
  }
  
  @f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    return Integer.valueOf(com.tencent.mm.plugin.downloader.model.d.aFP().dd(paramLong).status);
  }
  
  @f
  public String getMailAppEnterUlAndroid()
  {
    return com.tencent.mm.m.g.AB().getMailAppEnterUlAndroid();
  }
  
  @f
  public String getMailAppRedirectUrlAndroid()
  {
    return com.tencent.mm.m.g.AB().Ar();
  }
  
  @f
  public String getMsgContent(long paramLong)
  {
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong).field_content;
  }
  
  @f
  public Object getUneradMailCountFromConfig()
  {
    return com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoK, Integer.valueOf(-1));
  }
  
  @f
  public void getUnreadMailCount()
  {
    i.a(this.nfy);
  }
  
  @f
  public String getUserBindEmail()
  {
    return q.getUserBindEmail();
  }
  
  @f
  public boolean isSDCardAvailable()
  {
    return com.tencent.mm.kernel.g.DP().isSDCardAvailable();
  }
  
  @com.tencent.mm.remoteservice.e
  public void onComplete()
  {
    if (this.neF != null) {
      this.neF.onComplete();
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onError(int paramInt, String paramString)
  {
    if (this.neF != null) {
      this.neF.onError(paramInt, paramString);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean onReady()
  {
    if (this.neF == null) {
      return true;
    }
    return this.neF.onReady();
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    if (this.neF != null) {
      this.neF.onSuccess(paramString, paramMap);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFailed(long paramLong)
  {
    if (this.nfv != null) {
      y.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFinished(long paramLong)
  {
    if (this.nfv != null) {
      y.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskPaused(long paramLong)
  {
    if (this.nfv != null) {
      y.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskRemoved(long paramLong)
  {
    if (this.nfv != null) {
      y.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskStarted(long paramLong, String paramString)
  {
    if (this.nfv != null)
    {
      ReadMailUI.b localb = this.nfv;
      y.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
      ReadMailUI.a(localb.njK, ae.getContext().getSharedPreferences("QQMAIL", 4));
      if (ReadMailUI.o(localb.njK) != null) {
        ReadMailUI.o(localb.njK).edit().putString("qqmail_downloadpath", paramString).commit();
      }
    }
  }
  
  @f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    v.c localc = new v.c();
    localc.fromBundle(paramBundle);
    return ac.btF().a(paramString, paramMap, localc, this.nfu);
  }
  
  @f
  public void removeDownloadCallback()
  {
    com.tencent.mm.plugin.downloader.model.d.aFP();
    b.aFK();
  }
  
  @f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    return com.tencent.mm.plugin.downloader.model.d.aFP().dc(paramLong);
  }
  
  @f
  public void replaceMsgContent(long paramLong, String paramString)
  {
    new ah().post(new ReadMailProxy.6(this, paramLong, paramString));
  }
  
  @f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    h.nFQ.f(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
  }
  
  @f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    h.nFQ.f(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  @f
  public Integer showMailAppRecommend()
  {
    if (com.tencent.mm.sdk.platformtools.e.bvj == 1) {
      return Integer.valueOf(0);
    }
    return Integer.valueOf(bk.getInt(com.tencent.mm.m.g.AB().H("MailApp", "ShowMailAppRecommend"), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */