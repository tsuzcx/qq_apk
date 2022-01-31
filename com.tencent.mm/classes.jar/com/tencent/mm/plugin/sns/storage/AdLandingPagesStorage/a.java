package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile a.b rcJ;
  public a.a rrp;
  public volatile boolean rrq;
  private IntentFilter rrr;
  ConcurrentHashMap<String, a.c> rrs;
  public ConcurrentHashMap<String, a.d> rrt;
  public m rru;
  private ak rrv;
  
  private a()
  {
    AppMethodBeat.i(36930);
    this.rrs = new ConcurrentHashMap();
    this.rrt = new ConcurrentHashMap();
    this.rru = new a.1(this);
    this.rrp = new a.a(this, (byte)0);
    this.rrr = new IntentFilter();
    this.rrr.addAction("android.intent.action.PACKAGE_ADDED");
    this.rrr.addAction("android.intent.action.PACKAGE_REMOVED");
    this.rrr.addDataScheme("package");
    this.rrv = new a.2(this, Looper.getMainLooper());
    AppMethodBeat.o(36930);
  }
  
  private void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36935);
    System.currentTimeMillis();
    a.d locald = (a.d)this.rrt.get(paramString1);
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    if (locald == null) {}
    for (paramString2 = "";; paramString2 = locald.rpv + "." + locald.heu + "." + str + ".0.20.0")
    {
      paramString1 = q(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2 });
      ab.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      ab.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      h.qsU.a(14542, paramString1, true, false);
      AppMethodBeat.o(36935);
      return;
    }
  }
  
  private static String q(Object... paramVarArgs)
  {
    AppMethodBeat.i(36934);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(36934);
    return paramVarArgs;
  }
  
  public static long queryIdByAppid(String paramString)
  {
    AppMethodBeat.i(36931);
    paramString = f.bjl().JH(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      AppMethodBeat.o(36931);
      return l;
    }
    AppMethodBeat.o(36931);
    return 9223372036854775807L;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(36932);
    this.rrs.put(paramString, paramc);
    ab.i("MicroMsg.AdDownloadApkMgr", "register package receiver");
    ah.getContext().registerReceiver(this.rrp, this.rrr);
    this.rrq = true;
    this.rrv.removeMessages(10008);
    this.rrv.sendEmptyMessageDelayed(10008, 300000L);
    AppMethodBeat.o(36932);
  }
  
  public final void ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(36933);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.E(d.class)).YG().iU(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(36933);
      return;
    }
    reportDownloadInfo(paramInt, locala.field_appId);
    AppMethodBeat.o(36933);
  }
  
  public final void reportDownloadInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(36936);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.E(d.class)).YG().JD(paramString);
    if (locala == null)
    {
      ab.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
      AppMethodBeat.o(36936);
      return;
    }
    f(paramInt, paramString, locala.field_packageName, locala.field_downloadUrl);
    AppMethodBeat.o(36936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */