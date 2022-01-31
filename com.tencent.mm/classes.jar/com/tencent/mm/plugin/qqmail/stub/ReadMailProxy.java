package com.tencent.mm.plugin.qqmail.stub;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy
  extends a
{
  private v.a pJU;
  private v.a pKJ;
  private ReadMailUI.b pKK;
  private ReadMailUI.c pKL;
  private m pKM;
  private j.a pKN;
  
  public ReadMailProxy(d paramd, v.a parama)
  {
    super(paramd);
    AppMethodBeat.i(68096);
    this.pKM = new ReadMailProxy.1(this);
    this.pKN = new ReadMailProxy.2(this);
    this.pJU = parama;
    this.pKJ = new ReadMailProxy.3(this);
    AppMethodBeat.o(68096);
  }
  
  public ReadMailProxy(d paramd, v.a parama, ReadMailUI.b paramb, ReadMailUI.c paramc)
  {
    super(paramd);
    AppMethodBeat.i(68097);
    this.pKM = new ReadMailProxy.1(this);
    this.pKN = new ReadMailProxy.2(this);
    this.pJU = parama;
    this.pKK = paramb;
    this.pKL = paramc;
    this.pKJ = new ReadMailProxy.4(this);
    AppMethodBeat.o(68097);
  }
  
  @com.tencent.mm.remoteservice.f
  public void addDownloadCallback()
  {
    AppMethodBeat.i(68116);
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.c(this.pKM);
    AppMethodBeat.o(68116);
  }
  
  @com.tencent.mm.remoteservice.f
  public void cancel(long paramLong)
  {
    AppMethodBeat.i(68109);
    new ak().post(new ReadMailProxy.5(this, paramLong));
    AppMethodBeat.o(68109);
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteMsgById(long paramLong)
  {
    AppMethodBeat.i(68114);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kC(paramLong);
    AppMethodBeat.o(68114);
  }
  
  @com.tencent.mm.remoteservice.f
  public long downloadQQMailApp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68118);
    try
    {
      paramString1 = new URL(paramString1);
      paramString1 = new URI(paramString1.getProtocol(), paramString1.getUserInfo(), paramString1.getHost(), paramString1.getPort(), paramString1.getPath(), paramString1.getQuery(), paramString1.getRef()).toURL();
      g.a locala = new g.a();
      locala.JJ(paramString1.toString());
      locala.JL("qqmail.apk");
      locala.JM(paramString2);
      locala.gr(true);
      locala.tV(1);
      l = com.tencent.mm.plugin.downloader.model.f.bjl().a(locala.kYR);
      AppMethodBeat.o(68118);
      return l;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[] { paramString1.toString() });
        ab.printErrStackTrace("MicroMsg.ReadMailProxy", paramString1, "", new Object[0]);
        long l = -1L;
      }
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long get(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(68107);
    v.c localc = new v.c();
    localc.fromBundle(paramBundle);
    long l = ac.cdQ().b(paramString, paramMap, localc, this.pKJ);
    AppMethodBeat.o(68107);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getBindUin()
  {
    AppMethodBeat.i(68120);
    String str = new p(bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(9, null))).toString();
    AppMethodBeat.o(68120);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Map getCookie()
  {
    AppMethodBeat.i(68113);
    Map localMap = ac.cdQ().getCookie();
    AppMethodBeat.o(68113);
    return localMap;
  }
  
  @com.tencent.mm.remoteservice.f
  public double getMailAppDownloadProgress(long paramLong)
  {
    AppMethodBeat.i(68125);
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bjl().iA(paramLong);
    if (localFileDownloadTaskInfo.jyU <= 0L)
    {
      AppMethodBeat.o(68125);
      return 0.0D;
    }
    double d = 1.0D * localFileDownloadTaskInfo.kYX / localFileDownloadTaskInfo.jyU;
    AppMethodBeat.o(68125);
    return d;
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer getMailAppDownloadStatus(long paramLong)
  {
    AppMethodBeat.i(68124);
    int i = com.tencent.mm.plugin.downloader.model.f.bjl().iA(paramLong).status;
    AppMethodBeat.o(68124);
    return Integer.valueOf(i);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(68122);
    String str = com.tencent.mm.m.g.Nr().getMailAppEnterUlAndroid();
    AppMethodBeat.o(68122);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMailAppRedirectUrlAndroid()
  {
    AppMethodBeat.i(68123);
    String str = com.tencent.mm.m.g.Nr().Nh();
    AppMethodBeat.o(68123);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getMsgContent(long paramLong)
  {
    AppMethodBeat.i(68111);
    String str = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramLong).field_content;
    AppMethodBeat.o(68111);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getUneradMailCountFromConfig()
  {
    AppMethodBeat.i(68129);
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyG, Integer.valueOf(-1));
    AppMethodBeat.o(68129);
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public void getUnreadMailCount()
  {
    AppMethodBeat.i(68128);
    com.tencent.mm.pluginsdk.ui.tools.j.a(this.pKN);
    AppMethodBeat.o(68128);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUserBindEmail()
  {
    AppMethodBeat.i(68115);
    String str = r.getUserBindEmail();
    AppMethodBeat.o(68115);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isSDCardAvailable()
  {
    AppMethodBeat.i(68110);
    boolean bool = com.tencent.mm.kernel.g.RL().isSDCardAvailable();
    AppMethodBeat.o(68110);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onComplete()
  {
    AppMethodBeat.i(68101);
    if (this.pJU != null) {
      this.pJU.onComplete();
    }
    AppMethodBeat.o(68101);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(68100);
    if (this.pJU != null) {
      this.pJU.onError(paramInt, paramString);
    }
    AppMethodBeat.o(68100);
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean onReady()
  {
    AppMethodBeat.i(68098);
    if (this.pJU == null)
    {
      AppMethodBeat.o(68098);
      return true;
    }
    boolean bool = this.pJU.onReady();
    AppMethodBeat.o(68098);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void onSuccess(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(68099);
    if (this.pJU != null) {
      this.pJU.onSuccess(paramString, paramMap);
    }
    AppMethodBeat.o(68099);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFailed(long paramLong)
  {
    AppMethodBeat.i(68106);
    if (this.pKK != null) {
      ab.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(68106);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskFinished(long paramLong)
  {
    AppMethodBeat.i(68105);
    if (this.pKK != null) {
      ab.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(68105);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(68104);
    if (this.pKK != null) {
      ab.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(68104);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(68103);
    if (this.pKK != null) {
      ab.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(68103);
  }
  
  @com.tencent.mm.remoteservice.e
  public void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(68102);
    if (this.pKK != null)
    {
      ReadMailUI.b localb = this.pKK;
      ab.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
      ReadMailUI.a(localb.pOX, ah.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mp()));
      if (ReadMailUI.o(localb.pOX) != null) {
        ReadMailUI.o(localb.pOX).edit().putString("qqmail_downloadpath", paramString).commit();
      }
    }
    AppMethodBeat.o(68102);
  }
  
  @com.tencent.mm.remoteservice.f
  public long post(String paramString, Map paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(68108);
    v.c localc = new v.c();
    localc.fromBundle(paramBundle);
    long l = ac.cdQ().a(paramString, paramMap, localc, this.pKJ);
    AppMethodBeat.o(68108);
    return l;
  }
  
  @com.tencent.mm.remoteservice.f
  public void removeDownloadCallback()
  {
    AppMethodBeat.i(68117);
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.bjh();
    AppMethodBeat.o(68117);
  }
  
  @com.tencent.mm.remoteservice.f
  public int removeDownloadQQMailAppTask(long paramLong)
  {
    AppMethodBeat.i(68119);
    int i = com.tencent.mm.plugin.downloader.model.f.bjl().iz(paramLong);
    AppMethodBeat.o(68119);
    return i;
  }
  
  @com.tencent.mm.remoteservice.f
  public void replaceMsgContent(long paramLong, String paramString)
  {
    AppMethodBeat.i(68112);
    new ak().post(new ReadMailProxy.6(this, paramLong, paramString));
    AppMethodBeat.o(68112);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68126);
    com.tencent.mm.plugin.report.service.h.qsU.e(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68126);
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportKvStates(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68127);
    com.tencent.mm.plugin.report.service.h.qsU.e(paramInt1, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(68127);
  }
  
  @com.tencent.mm.remoteservice.f
  public Integer showMailAppRecommend()
  {
    AppMethodBeat.i(68121);
    if (com.tencent.mm.sdk.platformtools.g.bWu == 1)
    {
      AppMethodBeat.o(68121);
      return Integer.valueOf(0);
    }
    int i = bo.getInt(com.tencent.mm.m.g.Nr().R("MailApp", "ShowMailAppRecommend"), 0);
    AppMethodBeat.o(68121);
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy
 * JD-Core Version:    0.7.0.1
 */