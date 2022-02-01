package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class RubbishBinService
  extends Service
  implements Runnable
{
  private boolean Czr = false;
  private b Czs = null;
  private String Czt = "";
  private IBinder Czu = null;
  private int Czv = 8;
  private Context context = this;
  private String hjA = null;
  int hjw = 1000;
  private int hjx = 0;
  Thread hjy;
  private int repeatMode = 1;
  private int xGO = 7;
  
  public IBinder onBind(Intent paramIntent)
  {
    this.Czu = new a.a()
    {
      public final void F(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
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
    return this.Czu;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.Czs == null) {
      this.Czs = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.Czs);
    this.hjy = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.hjA);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.hjx = paramIntent.getIntExtra("exec_time", 0);
      this.hjw = paramIntent.getIntExtra("interval", -1);
      this.hjA = paramIntent.getStringExtra("exec_tag");
    }
    if (this.hjA == null) {
      this.hjA = "Default";
    }
    this.hjy.setName(this.hjA);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.hjA);
    switch (this.hjx)
    {
    }
    for (this.repeatMode = 1; this.hjw == -1; this.repeatMode = this.hjx)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.hjy.isAlive())
    {
      this.hjy = new Thread(this);
      this.hjy.setName(this.hjA);
      this.hjy.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", g.aps());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("RubbishTag", "N/A");
    if (!str2.equals(str1))
    {
      localSharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((!this.Czr) && (((String)localObject).equals(this.hjA)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("RubbishCount", this.hjx) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("RubbishCount", this.hjx).apply();
    }
    localSharedPreferences.edit().putString("RubbishTag", this.hjA).apply();
    this.hjx = localSharedPreferences.getInt("RubbishCount", this.hjx);
    Log.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.hjx), this.hjA });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.hjx -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.hjx).apply();
        Log.i("RubbishBinService", "e!");
        h.CyF.a(17910, new Object[] { a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.hjA, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.hjx == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.hjw);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */