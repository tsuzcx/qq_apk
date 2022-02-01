package com.tencent.mm.plugin.monitor;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.LogLogic.ICallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PluginIllegalLogs
  extends f
  implements com.tencent.mm.plugin.monitor.a.a
{
  private Map<String, a> Lfr;
  private HandlerThread Lfs;
  private Handler Lft;
  
  public PluginIllegalLogs()
  {
    AppMethodBeat.i(266624);
    this.Lfr = PluginIllegalLogs..ExternalSyntheticBackport0.m("连续出现8个中文", new a("[\\u4e00-\\u9fa5]{8}"));
    this.Lfs = new HandlerThread("PluginIllegalLogs");
    this.Lft = null;
    AppMethodBeat.o(266624);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(266650);
    LogLogic.setCallBack(new LogLogic.ICallBack()
    {
      private final int Lfu;
      private final int Lfv;
      private NotificationManager Lfw;
      private Set<String> Lfx;
      private Handler mainHandler;
      
      public final void hitLogRuleCallback(final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final int paramAnonymousInt, final String paramAnonymousString4)
      {
        AppMethodBeat.i(266654);
        final PluginIllegalLogs.a locala = (PluginIllegalLogs.a)PluginIllegalLogs.this.Lfr.get(paramAnonymousString1);
        if (locala == null)
        {
          AppMethodBeat.o(266654);
          return;
        }
        PluginIllegalLogs.this.Lft.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266648);
            Object localObject1 = h.OAn;
            Object localObject2 = paramAnonymousString1;
            String str1 = locala.LfD;
            String str2 = paramAnonymousString2;
            String str3 = paramAnonymousString3;
            int i = paramAnonymousInt;
            if (paramAnonymousString4.length() > 5120) {}
            for (localObject1 = paramAnonymousString4.substring(0, 5120);; localObject1 = paramAnonymousString4)
            {
              localObject1 = h.w(new Object[] { localObject2, str1, str2, str3, Integer.valueOf(i), localObject1, new Integer(locala.level) });
              localObject2 = h.OAn;
              h.d(25046, (String)localObject1, true, true);
              AppMethodBeat.o(266648);
              return;
            }
          }
        });
        this.mainHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266653);
            Object localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append("规则:").append(paramAnonymousString1).append("\ntag:").append(paramAnonymousString2).append("\n文件:").append(paramAnonymousString3).append(":").append(paramAnonymousInt).append("\n日志:").append(paramAnonymousString4);
            PluginIllegalLogs.1.a(PluginIllegalLogs.1.this).add(((StringBuffer)localObject1).toString());
            if (PluginIllegalLogs.1.a(PluginIllegalLogs.1.this).size() > 100) {
              PluginIllegalLogs.1.a(PluginIllegalLogs.1.this).remove(Integer.valueOf(0));
            }
            localObject1 = MMApplicationContext.getContext();
            Object localObject2 = new Intent((Context)localObject1, IllegalLogsActivity.class);
            MultiProcessMMKV.getMMKV("xlog_illegal.txt").encode(MMApplicationContext.getProcessName(), PluginIllegalLogs.1.a(PluginIllegalLogs.1.this));
            ((Intent)localObject2).putExtra("process", MMApplicationContext.getProcessName());
            localObject2 = PendingIntent.getActivity((Context)localObject1, hashCode(), (Intent)localObject2, 134217728);
            if (PluginIllegalLogs.1.b(PluginIllegalLogs.1.this) == null) {
              PluginIllegalLogs.1.a(PluginIllegalLogs.1.this, (NotificationManager)((Context)localObject1).getSystemService("notification"));
            }
            if (Build.VERSION.SDK_INT >= 26) {}
            for (localObject1 = new Notification.Builder((Context)localObject1, PluginIllegalLogs.1.iV((Context)localObject1));; localObject1 = new Notification.Builder((Context)localObject1))
            {
              ((Notification.Builder)localObject1).setContentTitle("日志规范化");
              ((Notification.Builder)localObject1).setContentText(paramAnonymousString1 + ":" + paramAnonymousString4);
              ((Notification.Builder)localObject1).setSmallIcon(com.tencent.mm.bq.a.guX());
              ((Notification.Builder)localObject1).setContentIntent((PendingIntent)localObject2);
              PluginIllegalLogs.1.b(PluginIllegalLogs.1.this).notify(hashCode(), ((Notification.Builder)localObject1).build());
              AppMethodBeat.o(266653);
              return;
            }
          }
        });
        AppMethodBeat.o(266654);
      }
    });
    if (!this.Lfr.isEmpty())
    {
      this.Lfs.start();
      this.Lft = new Handler(this.Lfs.getLooper());
    }
    paramg = this.Lfr.entrySet().iterator();
    while (paramg.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramg.next();
      LogLogic.addLogRule(((a)localEntry.getValue()).level, (String)localEntry.getKey(), ((a)localEntry.getValue()).LfD);
    }
    AppMethodBeat.o(266650);
  }
  
  public void installed()
  {
    AppMethodBeat.i(266642);
    super.installed();
    alias(com.tencent.mm.plugin.monitor.a.a.class);
    AppMethodBeat.o(266642);
  }
  
  public String name()
  {
    return "plugin-illegalLogs";
  }
  
  final class a
  {
    public String LfD;
    public int level = 2;
    
    public a(String paramString)
    {
      this.LfD = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.PluginIllegalLogs
 * JD-Core Version:    0.7.0.1
 */