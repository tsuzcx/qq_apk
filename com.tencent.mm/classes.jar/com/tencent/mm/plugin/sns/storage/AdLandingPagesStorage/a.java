package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile b zfo;
  public a zxK;
  public volatile boolean zxL;
  private IntentFilter zxM;
  ConcurrentHashMap<String, c> zxN;
  public ConcurrentHashMap<String, d> zxO;
  public m zxP;
  ap zxQ;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.zxN = new ConcurrentHashMap();
    this.zxO = new ConcurrentHashMap();
    this.zxP = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.zfo != null) {
          a.this.zfo.failed(paramAnonymousLong);
        }
        a.this.aA(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(197884);
        ad.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong1)));
        if (a.this.zfo != null)
        {
          paramAnonymousString = f.ccl().tS(paramAnonymousLong1);
          if ((paramAnonymousString.pmT >= 0L) && (paramAnonymousString.nsQ > 0L))
          {
            a.this.zfo.progress(paramAnonymousLong1, (int)(paramAnonymousString.pmT * 100L / paramAnonymousString.nsQ));
            a.this.zxQ.removeMessages(10008);
            a.this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(197884);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.zfo != null)
        {
          a.this.zfo.succeed(paramAnonymousLong);
          a.this.zxQ.removeMessages(10008);
          a.this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.aA(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        a.this.aA(1, paramAnonymousLong);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.zfo != null) {
          a.this.zfo.resumed(paramAnonymousLong);
        }
        a.this.aA(7, paramAnonymousLong);
        a.this.zxQ.removeMessages(10008);
        a.this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
      
      public final void sL(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.zfo != null) {
          a.this.zfo.stopped(paramAnonymousLong);
        }
        a.this.aA(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void sM(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.zfo != null) {
          a.this.zfo.paused(paramAnonymousLong);
        }
        a.this.aA(6, paramAnonymousLong);
        a.this.zxQ.removeMessages(10008);
        a.this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void sN(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.zxQ.removeMessages(10008);
        a.this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
    };
    this.zxK = new a((byte)0);
    this.zxM = new IntentFilter();
    this.zxM.addAction("android.intent.action.PACKAGE_ADDED");
    this.zxM.addAction("android.intent.action.PACKAGE_REMOVED");
    this.zxM.addDataScheme("package");
    this.zxQ = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96291);
        if (paramAnonymousMessage.what == 10008) {
          ad.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
        }
        try
        {
          aj.getContext().unregisterReceiver(a.this.zxK);
          a.this.zxL = false;
          AppMethodBeat.o(96291);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          for (;;)
          {
            ad.e("MicroMsg.AdDownloadApkMgr", "unregister package receiver, exp=" + paramAnonymousMessage.toString());
          }
        }
      }
    };
    AppMethodBeat.o(96295);
  }
  
  public static boolean bg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96297);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(96297);
      return false;
    }
    boolean bool = q.s(paramContext, paramString);
    AppMethodBeat.o(96297);
    return bool;
  }
  
  private void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96302);
    System.currentTimeMillis();
    d locald = (d)this.zxO.get(paramString1);
    if (locald == null) {
      ad.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(paramString1)));
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    long l;
    if (locald == null)
    {
      paramString2 = "";
      l = System.currentTimeMillis() / 1000L;
      if (locald != null) {
        break label235;
      }
    }
    label235:
    for (str = "";; str = locald.dFy)
    {
      paramString1 = t(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(l), str });
      ad.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      ad.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      com.tencent.mm.plugin.report.service.g.yhR.a(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
      paramString2 = locald.zuP + "." + locald.jSR + "." + str + ".0.20.0";
      break;
    }
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.ccl().aai(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (com.tencent.mm.vfs.i.fv(paramString.path)))
    {
      AppMethodBeat.o(96296);
      return true;
    }
    AppMethodBeat.o(96296);
    return false;
  }
  
  public static long queryIdByAppid(String paramString)
  {
    AppMethodBeat.i(96298);
    paramString = f.ccl().aai(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      AppMethodBeat.o(96298);
      return l;
    }
    AppMethodBeat.o(96298);
    return 9223372036854775807L;
  }
  
  private static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(96301);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i]));
      if (i != 5) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(96301);
    return paramVarArgs;
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(96299);
    this.zxN.put(paramString, paramc);
    ad.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      aj.getContext().registerReceiver(this.zxK, this.zxM);
      this.zxL = true;
      this.zxQ.removeMessages(10008);
      this.zxQ.sendEmptyMessageDelayed(10008, 300000L);
      AppMethodBeat.o(96299);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.AdDownloadApkMgr", "register package receiver, exp=" + paramString.toString());
      }
    }
  }
  
  public final void aA(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)com.tencent.mm.kernel.g.ab(d.class)).azw().um(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(96300);
      return;
    }
    reportDownloadInfo(paramInt, locala.field_rawAppId);
    AppMethodBeat.o(96300);
  }
  
  public final void reportDownloadInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(96303);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)com.tencent.mm.kernel.g.ab(d.class)).azw().aad(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + paramString + ", op=" + paramInt);
      if (paramInt != 9) {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zcY, paramString, paramInt, 0, "");
      }
      AppMethodBeat.o(96303);
      return;
    }
    f(paramInt, paramString, locala.field_packageName, locala.field_downloadUrl);
    AppMethodBeat.o(96303);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(96293);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        ad.i("MicroMsg.AdDownloadApkMgr", "onReceive, action=".concat(String.valueOf(paramContext)));
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          ad.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!bt.isNullOrNil(paramContext)) && (a.this.zxN.containsKey(paramContext)))
          {
            ((a.c)a.this.zxN.remove(paramContext)).ayv(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          ad.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
          AppMethodBeat.o(96293);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          ad.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!bt.isNullOrNil(paramContext)) && (a.this.zxN.containsKey(paramContext)))
          {
            ((a.c)a.this.zxN.remove(paramContext)).ayw(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          ad.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
        }
      }
      AppMethodBeat.o(96293);
    }
  }
  
  public static abstract interface b
  {
    public abstract void failed(long paramLong);
    
    public abstract void paused(long paramLong);
    
    public abstract void progress(long paramLong, int paramInt);
    
    public abstract void resumed(long paramLong);
    
    public abstract void stopped(long paramLong);
    
    public abstract void succeed(long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void ayv(String paramString);
    
    public abstract void ayw(String paramString);
  }
  
  public static final class d
    implements Serializable
  {
    public String dFy;
    public String jSR;
    public String zuP;
    
    public d(String paramString1, String paramString2, String paramString3)
    {
      this.zuP = paramString1;
      this.jSR = paramString2;
      this.dFy = paramString3;
    }
  }
  
  public static final class e
  {
    public static final a zxS;
    
    static
    {
      AppMethodBeat.i(96294);
      zxS = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */