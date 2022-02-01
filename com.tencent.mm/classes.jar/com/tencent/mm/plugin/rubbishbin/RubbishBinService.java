package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class RubbishBinService
  extends Service
  implements Runnable
{
  private Context context = this;
  int gub = 1000;
  private int guc = 0;
  Thread gud;
  private String guf = null;
  private int repeatMode = 1;
  private int udo = 7;
  private boolean yiC = false;
  private b yiD = null;
  private String yiE = "";
  private IBinder yiF = null;
  private int yiG = 8;
  
  public IBinder onBind(Intent paramIntent)
  {
    this.yiF = new a.a()
    {
      public final void G(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(146674);
        RubbishBinService.a(RubbishBinService.this, paramAnonymousInt2);
        RubbishBinService.b(RubbishBinService.this, paramAnonymousInt1);
        RubbishBinService.a(RubbishBinService.this, paramAnonymousString);
        RubbishBinService.b(RubbishBinService.this).setName(RubbishBinService.a(RubbishBinService.this));
        switch (RubbishBinService.c(RubbishBinService.this))
        {
        default: 
          RubbishBinService.c(RubbishBinService.this, 1);
        }
        for (;;)
        {
          if (!RubbishBinService.b(RubbishBinService.this).isAlive()) {
            RubbishBinService.b(RubbishBinService.this).start();
          }
          AppMethodBeat.o(146674);
          return;
          RubbishBinService.c(RubbishBinService.this, RubbishBinService.c(RubbishBinService.this));
        }
      }
    };
    return this.yiF;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.yiD == null) {
      this.yiD = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.yiD);
    this.gud = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.guf);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.guc = paramIntent.getIntExtra("exec_time", 0);
      this.gub = paramIntent.getIntExtra("interval", -1);
      this.guf = paramIntent.getStringExtra("exec_tag");
    }
    if (this.guf == null) {
      this.guf = "Default";
    }
    this.gud.setName(this.guf);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.guf);
    switch (this.guc)
    {
    }
    for (this.repeatMode = 1; this.gub == -1; this.repeatMode = this.guc)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.gud.isAlive())
    {
      this.gud = new Thread(this);
      this.gud.setName(this.guf);
      this.gud.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abm());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("RubbishTag", "N/A");
    if (!str2.equals(str1))
    {
      localSharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((!this.yiC) && (((String)localObject).equals(this.guf)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("RubbishCount", this.guc) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("RubbishCount", this.guc).apply();
    }
    localSharedPreferences.edit().putString("RubbishTag", this.guf).apply();
    this.guc = localSharedPreferences.getInt("RubbishCount", this.guc);
    ad.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.guc), this.guf });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.guc -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.guc).apply();
        ad.i("RubbishBinService", "e!");
        com.tencent.mm.plugin.report.service.g.yhR.f(17910, new Object[] { a.hgG, i.hgG, this.guf, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.guc == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.gub);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */