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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile b xPu;
  public a yhD;
  public volatile boolean yhE;
  private IntentFilter yhF;
  ConcurrentHashMap<String, c> yhG;
  public ConcurrentHashMap<String, d> yhH;
  public m yhI;
  ao yhJ;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.yhG = new ConcurrentHashMap();
    this.yhH = new ConcurrentHashMap();
    this.yhI = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.xPu != null) {
          a.this.xPu.failed(paramAnonymousLong);
        }
        a.this.at(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.xPu != null)
        {
          a.this.xPu.succeed(paramAnonymousLong);
          a.this.yhJ.removeMessages(10008);
          a.this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.at(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.xPu != null) {
          a.this.xPu.resumed(paramAnonymousLong);
        }
        a.this.at(7, paramAnonymousLong);
        a.this.yhJ.removeMessages(10008);
        a.this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.xPu != null) {
          a.this.xPu.paused(paramAnonymousLong);
        }
        a.this.at(6, paramAnonymousLong);
        a.this.yhJ.removeMessages(10008);
        a.this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.xPu != null) {
          a.this.xPu.stopped(paramAnonymousLong);
        }
        a.this.at(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        a.this.at(1, paramAnonymousLong);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
      
      public final void qN(long paramAnonymousLong)
      {
        AppMethodBeat.i(96288);
        ac.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.xPu != null)
        {
          FileDownloadTaskInfo localFileDownloadTaskInfo = f.bXJ().rT(paramAnonymousLong);
          if ((localFileDownloadTaskInfo.oJm >= 0L) && (localFileDownloadTaskInfo.mSs > 0L))
          {
            a.this.xPu.progress(paramAnonymousLong, (int)(localFileDownloadTaskInfo.oJm * 100L / localFileDownloadTaskInfo.mSs));
            a.this.yhJ.removeMessages(10008);
            a.this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(96288);
      }
      
      public final void qO(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        ac.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.yhJ.removeMessages(10008);
        a.this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
    };
    this.yhD = new a((byte)0);
    this.yhF = new IntentFilter();
    this.yhF.addAction("android.intent.action.PACKAGE_ADDED");
    this.yhF.addAction("android.intent.action.PACKAGE_REMOVED");
    this.yhF.addDataScheme("package");
    this.yhJ = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96291);
        if (paramAnonymousMessage.what == 10008) {
          ac.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
        }
        try
        {
          ai.getContext().unregisterReceiver(a.this.yhD);
          a.this.yhE = false;
          AppMethodBeat.o(96291);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          for (;;)
          {
            ac.e("MicroMsg.AdDownloadApkMgr", "unregister package receiver, exp=" + paramAnonymousMessage.toString());
          }
        }
      }
    };
    AppMethodBeat.o(96295);
  }
  
  public static boolean bd(Context paramContext, String paramString)
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
    d locald = (d)this.yhH.get(paramString1);
    if (locald == null) {
      ac.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(paramString1)));
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    if (locald == null) {}
    for (paramString2 = "";; paramString2 = locald.yeO + "." + locald.jyU + "." + str + ".0.20.0")
    {
      paramString1 = t(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(System.currentTimeMillis() / 1000L), locald.dtx });
      ac.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      ac.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      h.wUl.a(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
    }
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.bXJ().WB(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (com.tencent.mm.vfs.i.eA(paramString.path)))
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
    paramString = f.bXJ().WB(paramString);
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
    this.yhG.put(paramString, paramc);
    ac.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      ai.getContext().registerReceiver(this.yhD, this.yhF);
      this.yhE = true;
      this.yhJ.removeMessages(10008);
      this.yhJ.sendEmptyMessageDelayed(10008, 300000L);
      AppMethodBeat.o(96299);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.AdDownloadApkMgr", "register package receiver, exp=" + paramString.toString());
      }
    }
  }
  
  public final void at(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.ab(d.class)).awH().so(paramLong);
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
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.ab(d.class)).awH().Ww(paramString);
    if (locala == null)
    {
      ac.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + paramString + ", op=" + paramInt);
      if (paramInt != 9) {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNf, paramString, paramInt, 0, "");
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
        ac.i("MicroMsg.AdDownloadApkMgr", "onReceive, action=".concat(String.valueOf(paramContext)));
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          ac.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!bs.isNullOrNil(paramContext)) && (a.this.yhG.containsKey(paramContext)))
          {
            ((a.c)a.this.yhG.remove(paramContext)).atq(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          ac.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
          AppMethodBeat.o(96293);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          ac.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!bs.isNullOrNil(paramContext)) && (a.this.yhG.containsKey(paramContext)))
          {
            ((a.c)a.this.yhG.remove(paramContext)).atr(paramContext);
            AppMethodBeat.o(96293);
            return;
          }
          ac.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(paramContext)));
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
    public abstract void atq(String paramString);
    
    public abstract void atr(String paramString);
  }
  
  public static final class d
    implements Serializable
  {
    public String dtx;
    public String jyU;
    public String yeO;
    
    public d(String paramString1, String paramString2, String paramString3)
    {
      this.yeO = paramString1;
      this.jyU = paramString2;
      this.dtx = paramString3;
    }
  }
  
  public static final class e
  {
    public static final a yhL;
    
    static
    {
      AppMethodBeat.i(96294);
      yhL = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */