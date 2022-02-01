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
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public volatile b DGp;
  public a DXh;
  public volatile boolean DXi;
  private IntentFilter DXj;
  ConcurrentHashMap<String, c> DXk;
  public ConcurrentHashMap<String, d> DXl;
  public m DXm;
  MMHandler DXn;
  
  private a()
  {
    AppMethodBeat.i(96295);
    this.DXk = new ConcurrentHashMap();
    this.DXl = new ConcurrentHashMap();
    this.DXm = new m()
    {
      public final void Bd(long paramAnonymousLong)
      {
        AppMethodBeat.i(96286);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.DGp != null) {
          a.this.DGp.stopped(paramAnonymousLong);
        }
        a.this.aH(2, paramAnonymousLong);
        AppMethodBeat.o(96286);
      }
      
      public final void Be(long paramAnonymousLong)
      {
        AppMethodBeat.i(96287);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.DGp != null) {
          a.this.DGp.paused(paramAnonymousLong);
        }
        a.this.aH(6, paramAnonymousLong);
        a.this.DXn.removeMessages(10008);
        a.this.DXn.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96287);
      }
      
      public final void Bf(long paramAnonymousLong)
      {
        AppMethodBeat.i(96290);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        a.this.DXn.removeMessages(10008);
        a.this.DXn.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96290);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(202828);
        Log.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong1)));
        if (a.this.DGp != null)
        {
          paramAnonymousString = f.cBv().Co(paramAnonymousLong1);
          if ((paramAnonymousString.qJe >= 0L) && (paramAnonymousString.oJj > 0L))
          {
            a.this.DGp.progress(paramAnonymousLong1, (int)(paramAnonymousString.qJe * 100L / paramAnonymousString.oJj));
            a.this.DXn.removeMessages(10008);
            a.this.DXn.sendEmptyMessageDelayed(10008, 300000L);
          }
        }
        AppMethodBeat.o(202828);
      }
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96285);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + paramAnonymousLong + ", errCode=" + paramAnonymousInt);
        if (a.this.DGp != null) {
          a.this.DGp.failed(paramAnonymousLong);
        }
        a.this.aH(8, paramAnonymousLong);
        AppMethodBeat.o(96285);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(96284);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.DGp != null)
        {
          a.this.DGp.succeed(paramAnonymousLong);
          a.this.DXn.removeMessages(10008);
          a.this.DXn.sendEmptyMessageDelayed(10008, 300000L);
        }
        a.this.aH(3, paramAnonymousLong);
        AppMethodBeat.o(96284);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96283);
        a.this.aH(1, paramAnonymousLong);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(paramAnonymousLong)));
        AppMethodBeat.o(96283);
      }
      
      public final void l(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(96289);
        Log.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(paramAnonymousLong)));
        if (a.this.DGp != null) {
          a.this.DGp.resumed(paramAnonymousLong);
        }
        a.this.aH(7, paramAnonymousLong);
        a.this.DXn.removeMessages(10008);
        a.this.DXn.sendEmptyMessageDelayed(10008, 300000L);
        AppMethodBeat.o(96289);
      }
    };
    this.DXh = new a((byte)0);
    this.DXj = new IntentFilter();
    this.DXj.addAction("android.intent.action.PACKAGE_ADDED");
    this.DXj.addAction("android.intent.action.PACKAGE_REMOVED");
    this.DXj.addDataScheme("package");
    this.DXn = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(96291);
        if (paramAnonymousMessage.what == 10008) {
          Log.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
        }
        try
        {
          MMApplicationContext.getContext().unregisterReceiver(a.this.DXh);
          a.this.DXi = false;
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
  
  public static boolean bz(Context paramContext, String paramString)
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
  
  private void g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96302);
    System.currentTimeMillis();
    d locald = (d)this.DXl.get(paramString1);
    if (locald == null) {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(paramString1)));
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
    for (str = "";; str = locald.uxInfo)
    {
      paramString1 = s(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2, Long.valueOf(l), str });
      Log.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      Log.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(paramString2)));
      h.CyF.a(14542, paramString1, true, false);
      AppMethodBeat.o(96302);
      return;
      paramString2 = locald.aid + "." + locald.kZe + "." + str + ".0.20.0";
      break;
    }
  }
  
  public static boolean isApkExist(String paramString)
  {
    AppMethodBeat.i(96296);
    paramString = f.cBv().alg(paramString);
    if ((paramString != null) && (paramString.status == 3) && (!TextUtils.isEmpty(paramString.path)) && (s.YS(paramString.path)))
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
    paramString = f.cBv().alg(paramString);
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
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(96299);
    this.DXk.put(paramString, paramc);
    Log.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
    try
    {
      MMApplicationContext.getContext().registerReceiver(this.DXh, this.DXj);
      this.DXi = true;
      this.DXn.removeMessages(10008);
      this.DXn.sendEmptyMessageDelayed(10008, 300000L);
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
  
  public final void aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96300);
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.af(d.class)).aSU().CH(paramLong);
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
    com.tencent.mm.plugin.downloader.g.a locala = ((d)g.af(d.class)).aSU().alb(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + paramString + ", op=" + paramInt);
      if (paramInt != 9) {
        j.b(j.DDY, paramString, paramInt, 0, "");
      }
      AppMethodBeat.o(96303);
      return;
    }
    g(paramInt, paramString, locala.field_packageName, locala.field_downloadUrl);
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
        Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, action=".concat(String.valueOf(paramContext)));
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(paramContext)));
          if ((!Util.isNullOrNil(paramContext)) && (a.this.DXk.containsKey(paramContext)))
          {
            ((a.c)a.this.DXk.remove(paramContext)).aOJ(paramContext);
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
          if ((!Util.isNullOrNil(paramContext)) && (a.this.DXk.containsKey(paramContext)))
          {
            ((a.c)a.this.DXk.remove(paramContext)).aOK(paramContext);
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
    
    public abstract void stopped(long paramLong);
    
    public abstract void succeed(long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void aOJ(String paramString);
    
    public abstract void aOK(String paramString);
  }
  
  public static final class d
    implements Serializable
  {
    public String aid;
    public String kZe;
    public String uxInfo;
    
    public d(String paramString1, String paramString2, String paramString3)
    {
      this.aid = paramString1;
      this.kZe = paramString2;
      this.uxInfo = paramString3;
    }
  }
  
  public static final class e
  {
    public static final a DXp;
    
    static
    {
      AppMethodBeat.i(96294);
      DXp = new a((byte)0);
      AppMethodBeat.o(96294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */