package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.i.a;
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
  private int IEZ = 7;
  int JJO = 1000;
  private IBinder OGA = null;
  private int OGB = 0;
  private int OGC = 8;
  private String OGD = null;
  private boolean OGx = false;
  private b OGy = null;
  private String OGz = "";
  private int cFH = 1;
  private Context context = this;
  Thread tpF;
  
  public abstract void aUB(String paramString);
  
  public IBinder onBind(Intent paramIntent)
  {
    this.OGA = new a.a()
    {
      public final void M(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(146674);
        RubbishBinService.a(RubbishBinService.this, paramAnonymousInt2);
        RubbishBinService.b(RubbishBinService.this, paramAnonymousInt1);
        RubbishBinService.a(RubbishBinService.this, paramAnonymousString);
        RubbishBinService.a(RubbishBinService.this).setName("rubbish_executor");
        switch (RubbishBinService.b(RubbishBinService.this))
        {
        default: 
          RubbishBinService.c(RubbishBinService.this, 1);
        }
        for (;;)
        {
          if (!RubbishBinService.a(RubbishBinService.this).isAlive()) {
            RubbishBinService.a(RubbishBinService.this).start();
          }
          AppMethodBeat.o(146674);
          return;
          RubbishBinService.c(RubbishBinService.this, RubbishBinService.b(RubbishBinService.this));
        }
      }
    };
    return this.OGA;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.OGy == null) {
      this.OGy = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.OGy);
    this.tpF = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.OGD);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.OGB = paramIntent.getIntExtra("exec_time", 0);
      this.JJO = paramIntent.getIntExtra("interval", -1);
      this.OGD = paramIntent.getStringExtra("exec_tag");
    }
    if (this.OGD == null) {
      this.OGD = "Default";
    }
    this.tpF.setName("rubbish_executor");
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.OGD);
    switch (this.OGB)
    {
    }
    for (this.cFH = 1; this.JJO == -1; this.cFH = this.OGB)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.tpF.isAlive())
    {
      this.tpF = new Thread(this);
      this.tpF.setName("rubbish_executor");
      this.tpF.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", g.aQe());
    Object localObject = Calendar.getInstance().getTime();
    localObject = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    localSharedPreferences.edit().putInt("RubbishCount", this.OGB).apply();
    localSharedPreferences.edit().putString("RubbishTag", this.OGD).apply();
    this.OGB = localSharedPreferences.getInt("RubbishCount", this.OGB);
    Log.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { localObject, Integer.valueOf(this.OGB), this.OGD });
    for (;;)
    {
      if (this.cFH == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.OGB -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.OGB).apply();
        Log.i("RubbishBinService", "e!");
        aUB(this.OGD);
        h.OAn.b(17910, new Object[] { a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.OGD, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.OGB == 0) && (this.cFH != -1));
      try
      {
        Thread.sleep(this.JJO);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */