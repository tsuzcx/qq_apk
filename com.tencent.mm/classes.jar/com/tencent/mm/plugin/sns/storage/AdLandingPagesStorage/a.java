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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile b wCZ;
  public a wUP;
  public volatile boolean wUQ;
  private IntentFilter wUR;
  ConcurrentHashMap<String, c> wUS;
  public ConcurrentHashMap<String, d> wUT;
  public m wUU;
  ap wUV;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.wUS = new ConcurrentHashMap();
    this.wUT = new ConcurrentHashMap();
    this.wUU = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.wCZ != null) {
          a.this.wCZ.failed(paramAnonymousLong);
        }
        a.this.au(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.wCZ != null)
        {
          a.this.wCZ.succeed(paramAnonymousLong);
          a.this.wUV.removeMessages(10008);
          a.this.wUV.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.au(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.wCZ != null) {
          a.this.wCZ.resumed(paramAnonymousLong);
        }
        a.this.au(7, paramAnonymousLong);
        a.this.wUV.removeMessages(10008);
        a.this.wUV.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
      
      public final void mZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(96288);
        ad.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.wCZ != null)
        {
          FileDownloadTaskInfo localFileDownloadTaskInfo = f.bQt().oh(paramAnonymousLong);
          if ((localFileDownloadTaskInfo.ofL >= 0L) && (localFileDownloadTaskInfo.mqq > 0L))
          {
            a.this.wCZ.progress(paramAnonymousLong, (int)(localFileDownloadTaskInfo.ofL * 100L / localFileDownloadTaskInfo.mqq));
            a.this.wUV.removeMessages(10008);
            a.this.wUV.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(96288);
      }
      
      public final void na(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.wUV.removeMessages(10008);
        a.this.wUV.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.wCZ != null) {
          a.this.wCZ.paused(paramAnonymousLong);
        }
        a.this.au(6, paramAnonymousLong);
        a.this.wUV.removeMessages(10008);
        a.this.wUV.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.wCZ != null) {
          a.this.wCZ.stopped(paramAnonymousLong);
        }
        a.this.au(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        a.this.au(1, paramAnonymousLong);
        ad.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
    };
    this.wUP = new a((byte)0);
    this.wUR = new IntentFilter();
    this.wUR.addAction("android.intent.action.PACKAGE_ADDED");
    this.wUR.addAction("android.intent.action.PACKAGE_REMOVED");
    this.wUR.addDataScheme("package");
    this.wUV = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96291);
        if (paramAnonymousMessage.what == 10008) {
          ad.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
        }
        try
        {
          aj.getContext().unregisterReceiver(a.this.wUP);
          a.this.wUQ = false;
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
  
  public static boolean bc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96297);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(96297);
      return false;
    }
    boolean bool = q.t(paramContext, paramString);
    AppMethodBeat.o(96297);
    return bool;
  }
  
  private void f(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96302);
    System.currentTimeMillis();
    d locald = (d)this.wUT.get(paramString1);
    if (locald == null) {
      ad.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(paramString1)));
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    if (locald == null) {}
    for (paramString2 = "";; paramString2 = locald.wSi + "." + locald.iYE + "." + str + ".0.20.0")
    {
      paramString1 = r(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(System.currentTimeMillis() / 1000L), locald.dvK });
      ad.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      ad.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      h.vKh.a(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
    }
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.bQt().Sp(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (com.tencent.mm.vfs.i.eK(paramString.path)))
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
    paramString = f.bQt().Sp(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      AppMethodBeat.o(96298);
      return l;
    }
    AppMethodBeat.o(96298);
    return 9223372036854775807L;
  }
  
  private static String r(Object... paramVarArgs)
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
    this.wUS.put(paramString, paramc);
    ad.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      aj.getContext().registerReceiver(this.wUP, this.wUR);
      this.wUQ = true;
      this.wUV.removeMessages(10008);
      this.wUV.sendEmptyMessageDelayed(10008, 300000L);
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
  
  public final void au(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.ab(d.class)).apS().oC(paramLong);
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
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.ab(d.class)).apS().Sk(paramString);
    if (locala == null)
    {
      ad.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=".concat(String.valueOf(paramString)));
      com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAL, paramString, paramInt, 0, "");
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
          if ((!bt.isNullOrNil(paramContext)) && (a.this.wUS.containsKey(paramContext)))
          {
            ((a.c)a.this.wUS.remove(paramContext)).aoe(paramContext);
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
          if ((!bt.isNullOrNil(paramContext)) && (a.this.wUS.containsKey(paramContext)))
          {
            ((a.c)a.this.wUS.remove(paramContext)).aof(paramContext);
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
    public abstract void aoe(String paramString);
    
    public abstract void aof(String paramString);
  }
  
  public static final class d
    implements Serializable
  {
    public String dvK;
    public String iYE;
    public String wSi;
    
    public d(String paramString1, String paramString2, String paramString3)
    {
      this.wSi = paramString1;
      this.iYE = paramString2;
      this.dvK = paramString3;
    }
  }
  
  public static final class e
  {
    public static final a wUX;
    
    static
    {
      AppMethodBeat.i(96294);
      wUX = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */