package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.sns.ad.d.c;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  ConcurrentHashMap<String, d> QIA;
  public ConcurrentHashMap<String, e> QIB;
  public m QIC;
  MMHandler QID;
  public a QIx;
  public volatile boolean QIy;
  private IntentFilter QIz;
  public volatile b Qqm;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.QIA = new ConcurrentHashMap();
    this.QIB = new ConcurrentHashMap();
    this.QIC = new m()
    {
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(306760);
        Log.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong1)));
        if (a.this.Qqm != null)
        {
          paramAnonymousString = f.duv().kS(paramAnonymousLong1);
          if ((paramAnonymousString.xom >= 0L) && (paramAnonymousString.uWn > 0L))
          {
            a.this.Qqm.progress(paramAnonymousLong1, (int)(paramAnonymousString.xom * 100L / paramAnonymousString.uWn));
            a.this.QID.removeMessages(10008);
            a.this.QID.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(306760);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.Qqm != null)
        {
          a.this.Qqm.succeed(paramAnonymousLong);
          a.this.QID.removeMessages(10008);
          a.this.QID.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.a(4001009, paramAnonymousLong, null);
        a.this.a(4001010, paramAnonymousLong, new a.c(2));
        a.this.bb(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void c(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.Qqm != null) {
          a.this.Qqm.failed(paramAnonymousLong);
        }
        a.this.a(4001006, paramAnonymousLong, null);
        a.this.bb(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void jF(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.Qqm != null) {
          a.this.Qqm.stopped(paramAnonymousLong);
        }
        a.this.bb(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void jG(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.Qqm != null) {
          a.this.Qqm.paused(paramAnonymousLong);
        }
        a.this.a(4001004, paramAnonymousLong, null);
        a.this.bb(6, paramAnonymousLong);
        a.this.QID.removeMessages(10008);
        a.this.QID.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void jH(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.QID.removeMessages(10008);
        a.this.QID.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
      
      public final void v(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        if (a.this.Qqm != null) {
          a.this.Qqm.start(paramAnonymousLong);
        }
        a.this.a(4001001, paramAnonymousLong, null);
        a.this.bb(1, paramAnonymousLong);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
      
      public final void w(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.Qqm != null) {
          a.this.Qqm.resumed(paramAnonymousLong);
        }
        a.this.a(4001005, paramAnonymousLong, null);
        a.this.bb(7, paramAnonymousLong);
        a.this.QID.removeMessages(10008);
        a.this.QID.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
    };
    this.QIx = new a((byte)0);
    this.QIz = new IntentFilter();
    this.QIz.addAction("android.intent.action.PACKAGE_ADDED");
    this.QIz.addAction("android.intent.action.PACKAGE_REMOVED");
    this.QIz.addDataScheme("package");
    this.QID = new a.2(this, Looper.getMainLooper());
    AppMethodBeat.o(96295);
  }
  
  public static boolean bR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(96297);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(96297);
      return false;
    }
    boolean bool = u.y(paramContext, paramString);
    AppMethodBeat.o(96297);
    return bool;
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.duv().amO(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (y.ZC(paramString.path)))
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
    paramString = f.duv().amO(paramString);
    if (paramString != null)
    {
      long l = paramString.id;
      AppMethodBeat.o(96298);
      return l;
    }
    AppMethodBeat.o(96298);
    return 9223372036854775807L;
  }
  
  private static String u(Object... paramVarArgs)
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
    AppMethodBeat.i(306756);
    Object localObject = ((d)com.tencent.mm.kernel.h.ax(d.class)).bzH().ll(paramLong);
    if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.f.a)localObject).field_rawAppId)))
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "fileDownloadInfo or field_rawAppId is null");
      AppMethodBeat.o(306756);
      return;
    }
    e locale = (e)this.QIB.get(((com.tencent.mm.plugin.downloader.f.a)localObject).field_rawAppId);
    if (locale == null)
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid = " + ((com.tencent.mm.plugin.downloader.f.a)localObject).field_rawAppId);
      AppMethodBeat.o(306756);
      return;
    }
    localObject = new com.tencent.mm.plugin.sns.data.b(locale.uxInfo, locale.rzx, locale.enterScene, locale.adExtInfo, locale.aid, locale.qTb, locale.pId, locale.Qms);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(306756);
      return;
      c.a((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(306756);
      return;
      c.b((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(306756);
      return;
      c.c((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(306756);
      return;
      c.d((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(306756);
      return;
      c.f((com.tencent.mm.plugin.sns.data.b)localObject);
      AppMethodBeat.o(306756);
      return;
      if (paramc != null) {
        ((com.tencent.mm.plugin.sns.data.b)localObject).Qmq = paramc.Qmq;
      }
      locale.QoS = System.currentTimeMillis();
      c.e((com.tencent.mm.plugin.sns.data.b)localObject);
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(96299);
    this.QIA.put(paramString, paramd);
    Log.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      MMApplicationContext.getContext().registerReceiver(this.QIx, this.QIz);
      this.QIy = true;
      this.QID.removeMessages(10008);
      this.QID.sendEmptyMessageDelayed(10008, 300000L);
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
  
  public final void bb(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.f.a locala = ((d)com.tencent.mm.kernel.h.ax(d.class)).bzH().ll(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(96300);
      return;
    }
    dg(paramInt, locala.field_rawAppId);
    AppMethodBeat.o(96300);
  }
  
  public final void dg(int paramInt, String paramString)
  {
    AppMethodBeat.i(96303);
    com.tencent.mm.plugin.downloader.f.a locala = ((d)com.tencent.mm.kernel.h.ax(d.class)).bzH().amJ(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + paramString + ", op=" + paramInt);
      if (paramInt != 9) {
        l.a(l.Qnn, paramString, paramInt, 0, "");
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
    e locale = (e)this.QIB.get(paramString1);
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
      paramString1 = u(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(l), str });
      Log.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      Log.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      com.tencent.mm.plugin.report.service.h.OAn.b(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
      paramString2 = locale.aid + "." + locale.qTb + "." + str + ".0.20.0";
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
          if ((!Util.isNullOrNil(paramContext)) && (a.this.QIA.containsKey(paramContext)))
          {
            ((a.d)a.this.QIA.remove(paramContext)).aXR(paramContext);
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
          if ((!Util.isNullOrNil(paramContext)) && (a.this.QIA.containsKey(paramContext)))
          {
            ((a.d)a.this.QIA.remove(paramContext)).aXS(paramContext);
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
    public int Qmq;
    
    public c(int paramInt)
    {
      this.Qmq = paramInt;
    }
  }
  
  public static abstract interface d
  {
    public abstract void aXR(String paramString);
    
    public abstract void aXS(String paramString);
  }
  
  public static final class e
    implements Serializable
  {
    public int Qms;
    public long QoS;
    public String adExtInfo;
    public String aid;
    public int enterScene;
    public String pId;
    public String qTb;
    public String rzx;
    public String uxInfo;
    
    public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
    {
      this.aid = paramString1;
      this.qTb = paramString2;
      this.uxInfo = paramString3;
      this.rzx = paramString4;
      this.enterScene = paramInt1;
      this.adExtInfo = paramString5;
      this.pId = paramString6;
      this.Qms = paramInt2;
    }
  }
  
  public static final class f
  {
    public static final a QIF;
    
    static
    {
      AppMethodBeat.i(96294);
      QIF = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */