package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class RubbishBinService
  extends Service
  implements Runnable
{
  private Context context = this;
  private int rXG = 7;
  private int repeatMode = 1;
  int sDU = 1000;
  private boolean vKV = false;
  private b vKW = null;
  Thread vKX;
  private String vKY = "";
  private IBinder vKZ = null;
  private int vLa = 0;
  private int vLb = 8;
  private String vLc = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    this.vKZ = new a.a()
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
    return this.vKZ;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.vKW == null) {
      this.vKW = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.vKW);
    this.vKX = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.vLc);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.vLa = paramIntent.getIntExtra("exec_time", 0);
      this.sDU = paramIntent.getIntExtra("interval", -1);
      this.vLc = paramIntent.getStringExtra("exec_tag");
    }
    if (this.vLc == null) {
      this.vLc = "Default";
    }
    this.vKX.setName(this.vLc);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.vLc);
    switch (this.vLa)
    {
    }
    for (this.repeatMode = 1; this.sDU == -1; this.repeatMode = this.vLa)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.vKX.isAlive()) {
      com.tencent.e.h.Iye.aS(this);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", g.XN());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("RubbishTag", "N/A");
    if (!str2.equals(str1))
    {
      localSharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((!this.vKV) && (((String)localObject).equals(this.vLc)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("RubbishCount", this.vLa) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("RubbishCount", this.vLa).apply();
    }
    localSharedPreferences.edit().putString("RubbishTag", this.vLc).apply();
    this.vLa = localSharedPreferences.getInt("RubbishCount", this.vLa);
    ad.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.vLa), this.vLc });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.vLa -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.vLa).apply();
        ad.i("RubbishBinService", "e!");
        com.tencent.mm.plugin.report.service.h.vKh.f(17910, new Object[] { a.glW, com.tencent.mm.sdk.platformtools.h.glW, this.vLc, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.vLa == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.sDU);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */