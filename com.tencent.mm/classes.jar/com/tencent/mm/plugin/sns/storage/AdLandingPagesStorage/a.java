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
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile b JTk;
  public a Kkq;
  public volatile boolean Kkr;
  private IntentFilter Kks;
  ConcurrentHashMap<String, d> Kkt;
  public ConcurrentHashMap<String, e> Kku;
  public m Kkv;
  MMHandler Kkw;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.Kkt = new ConcurrentHashMap();
    this.Kku = new ConcurrentHashMap();
    this.Kkv = new m()
    {
      public final void Hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.JTk != null) {
          a.this.JTk.stopped(paramAnonymousLong);
        }
        a.this.aU(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void Hq(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.JTk != null) {
          a.this.JTk.paused(paramAnonymousLong);
        }
        a.this.a(4001004, paramAnonymousLong, null);
        a.this.aU(6, paramAnonymousLong);
        a.this.Kkw.removeMessages(10008);
        a.this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void Hr(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.Kkw.removeMessages(10008);
        a.this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(199029);
        Log.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong1)));
        if (a.this.JTk != null)
        {
          paramAnonymousString = f.cPZ().Ix(paramAnonymousLong1);
          if ((paramAnonymousString.uih >= 0L) && (paramAnonymousString.rKZ > 0L))
          {
            a.this.JTk.progress(paramAnonymousLong1, (int)(paramAnonymousString.uih * 100L / paramAnonymousString.rKZ));
            a.this.Kkw.removeMessages(10008);
            a.this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(199029);
      }
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.JTk != null) {
          a.this.JTk.failed(paramAnonymousLong);
        }
        a.this.a(4001006, paramAnonymousLong, null);
        a.this.aU(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.JTk != null)
        {
          a.this.JTk.succeed(paramAnonymousLong);
          a.this.Kkw.removeMessages(10008);
          a.this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.a(4001009, paramAnonymousLong, null);
        a.this.a(4001010, paramAnonymousLong, new a.c(2));
        a.this.aU(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void m(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        if (a.this.JTk != null) {
          a.this.JTk.start(paramAnonymousLong);
        }
        a.this.a(4001001, paramAnonymousLong, null);
        a.this.aU(1, paramAnonymousLong);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
      
      public final void n(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.JTk != null) {
          a.this.JTk.resumed(paramAnonymousLong);
        }
        a.this.a(4001005, paramAnonymousLong, null);
        a.this.aU(7, paramAnonymousLong);
        a.this.Kkw.removeMessages(10008);
        a.this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
    };
    this.Kkq = new a((byte)0);
    this.Kks = new IntentFilter();
    this.Kks.addAction("android.intent.action.PACKAGE_ADDED");
    this.Kks.addAction("android.intent.action.PACKAGE_REMOVED");
    this.Kks.addDataScheme("package");
    this.Kkw = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96291);
        if (paramAnonymousMessage.what == 10008) {
          Log.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
        }
        try
        {
          MMApplicationContext.getContext().unregisterReceiver(a.this.Kkq);
          a.this.Kkr = false;
          AppMethodBeat.o(96291);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          for (;;)
          {
            Log.e("MicroMsg.AdDownloadApkMgr", "unregister package receiver, exp=" + paramAnonymousMessage.toString());
          }
        }
      }
    };
    AppMethodBeat.o(96295);
  }
  
  public static boolean bN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96297);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(96297);
      return false;
    }
    boolean bool = q.u(paramContext, paramString);
    AppMethodBeat.o(96297);
    return bool;
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.cPZ().asZ(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (u.agG(paramString.path)))
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
    paramString = f.cPZ().asZ(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      AppMethodBeat.o(96298);
      return l;
    }
    AppMethodBeat.o(96298);
    return 9223372036854775807L;
  }
  
  private static String s(Object... paramVarArgs)
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
  
  public final void a(int paramInt, long paramLong, c paramc)
  {
    AppMethodBeat.i(269789);
    Object localObject = ((d)com.tencent.mm.kernel.h.ae(d.class)).bbS().IQ(paramLong);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject).field_rawAppId)))
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "fileDownloadInfo or field_rawAppId is null");
      AppMethodBeat.o(269789);
      return;
    }
    e locale = (e)this.Kku.get(((com.tencent.mm.plugin.downloader.g.a)localObject).field_rawAppId);
    if (locale == null)
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid = " + ((com.tencent.mm.plugin.downloader.g.a)localObject).field_rawAppId);
      AppMethodBeat.o(269789);
      return;
    }
    localObject = new com.tencent.mm.plugin.sns.data.b(locale.uxInfo, locale.owd, locale.enterScene, locale.adExtInfo, locale.aid, locale.nTp, locale.pId, locale.JPL);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269789);
      return;
      com.tencent.mm.plugin.sns.ad.d.b.a((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(269789);
      return;
      com.tencent.mm.plugin.sns.ad.d.b.b((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(269789);
      return;
      com.tencent.mm.plugin.sns.ad.d.b.c((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(269789);
      return;
      com.tencent.mm.plugin.sns.ad.d.b.d((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(269789);
      return;
      com.tencent.mm.plugin.sns.ad.d.b.f((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(269789);
      return;
      if (paramc != null) {
        ((com.tencent.mm.plugin.sns.data.b)localObject).JPJ = paramc.JPJ;
      }
      locale.JSg = System.currentTimeMillis();
      com.tencent.mm.plugin.sns.ad.d.b.e((com.tencent.mm.plugin.sns.data.b)localObject);
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(96299);
    this.Kkt.put(paramString, paramd);
    Log.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      MMApplicationContext.getContext().registerReceiver(this.Kkq, this.Kks);
      this.Kkr = true;
      this.Kkw.removeMessages(10008);
      this.Kkw.sendEmptyMessageDelayed(10008, 300000L);
      AppMethodBeat.o(96299);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.AdDownloadApkMgr", "register package receiver, exp=" + paramString.toString());
      }
    }
  }
  
  public final void aU(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)com.tencent.mm.kernel.h.ae(d.class)).bbS().IQ(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(96300);
      return;
    }
    cu(paramInt, locala.field_rawAppId);
    AppMethodBeat.o(96300);
  }
  
  public final void cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(96303);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)com.tencent.mm.kernel.h.ae(d.class)).bbS().asU(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + paramString + ", op=" + paramInt);
      if (paramInt != 9) {
        l.a(l.JQH, paramString, paramInt, 0, "");
      }
      AppMethodBeat.o(96303);
      return;
    }
    g(paramInt, paramString, locala.field_packageName, locala.field_downloadUrl);
    AppMethodBeat.o(96303);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96302);
    System.currentTimeMillis();
    e locale = (e)this.Kku.get(paramString1);
    if (locale == null) {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(paramString1)));
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    long l;
    if (locale == null)
    {
      paramString2 = "";
      l = System.currentTimeMillis() / 1000L;
      if (locale != null) {
        break label247;
      }
    }
    label247:
    for (str = "";; str = locale.uxInfo)
    {
      paramString1 = s(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(l), str });
      Log.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      Log.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      com.tencent.mm.plugin.report.service.h.IzE.b(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
      paramString2 = locale.aid + "." + locale.nTp + "." + str + ".0.20.0";
      break;
    }
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
        Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, action=".concat(String.valueOf(paramContext)));
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!Util.isNullOrNil(paramContext)) && (a.this.Kkt.containsKey(paramContext)))
          {
            ((a.d)a.this.Kkt.remove(paramContext)).aZE(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          Log.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
          AppMethodBeat.o(96293);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!Util.isNullOrNil(paramContext)) && (a.this.Kkt.containsKey(paramContext)))
          {
            ((a.d)a.this.Kkt.remove(paramContext)).aZF(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          Log.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
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
    
    public abstract void start(long paramLong);
    
    public abstract void stopped(long paramLong);
    
    public abstract void succeed(long paramLong);
  }
  
  public static final class c
  {
    public int JPJ;
    
    public c(int paramInt)
    {
      this.JPJ = paramInt;
    }
  }
  
  public static abstract interface d
  {
    public abstract void aZE(String paramString);
    
    public abstract void aZF(String paramString);
  }
  
  public static final class e
    implements Serializable
  {
    public int JPL;
    public long JSg;
    public String adExtInfo;
    public String aid;
    public int enterScene;
    public String nTp;
    public String owd;
    public String pId;
    public String uxInfo;
    
    public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
    {
      this.aid = paramString1;
      this.nTp = paramString2;
      this.uxInfo = paramString3;
      this.owd = paramString4;
      this.enterScene = paramInt1;
      this.adExtInfo = paramString5;
      this.pId = paramString6;
      this.JPL = paramInt2;
    }
  }
  
  public static final class f
  {
    public static final a Kky;
    
    static
    {
      AppMethodBeat.i(96294);
      Kky = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */