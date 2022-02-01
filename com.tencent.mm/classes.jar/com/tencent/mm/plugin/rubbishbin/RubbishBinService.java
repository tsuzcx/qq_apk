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
import com.tencent.mm.sdk.platformtools.ac;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class RubbishBinService
  extends Service
  implements Runnable
{
  private Context context = this;
  int gaC = 1000;
  private int gaD = 0;
  Thread gaE;
  private String gaG = null;
  private int repeatMode = 1;
  private int tfy = 7;
  private boolean wUZ = false;
  private b wVa = null;
  private String wVb = "";
  private IBinder wVc = null;
  private int wVd = 8;
  
  public IBinder onBind(Intent paramIntent)
  {
    this.wVc = new a.a()
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
    return this.wVc;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.wVa == null) {
      this.wVa = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.wVa);
    this.gaE = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.gaG);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.gaD = paramIntent.getIntExtra("exec_time", 0);
      this.gaC = paramIntent.getIntExtra("interval", -1);
      this.gaG = paramIntent.getStringExtra("exec_tag");
    }
    if (this.gaG == null) {
      this.gaG = "Default";
    }
    this.gaE.setName(this.gaG);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.gaG);
    switch (this.gaD)
    {
    }
    for (this.repeatMode = 1; this.gaC == -1; this.repeatMode = this.gaD)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.gaE.isAlive()) {
      com.tencent.e.h.JZN.aV(this);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", g.YK());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("RubbishTag", "N/A");
    if (!str2.equals(str1))
    {
      localSharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((!this.wUZ) && (((String)localObject).equals(this.gaG)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("RubbishCount", this.gaD) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("RubbishCount", this.gaD).apply();
    }
    localSharedPreferences.edit().putString("RubbishTag", this.gaG).apply();
    this.gaD = localSharedPreferences.getInt("RubbishCount", this.gaD);
    ac.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.gaD), this.gaG });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.gaD -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.gaD).apply();
        ac.i("RubbishBinService", "e!");
        com.tencent.mm.plugin.report.service.h.wUl.f(17910, new Object[] { a.gMJ, com.tencent.mm.sdk.platformtools.h.gMJ, this.gaG, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.gaD == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.gaC);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */