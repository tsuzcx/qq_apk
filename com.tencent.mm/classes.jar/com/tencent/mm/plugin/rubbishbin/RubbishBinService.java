package com.tencent.mm.plugin.rubbishbin;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class RubbishBinService
  extends Service
  implements Runnable
{
  private Context context = this;
  int gwI = 1000;
  private int gwJ = 0;
  Thread gwK;
  private String gwM = null;
  private int repeatMode = 1;
  private int uow = 7;
  private boolean yyt = false;
  private b yyu = null;
  private String yyv = "";
  private IBinder yyw = null;
  private int yyx = 8;
  
  public IBinder onBind(Intent paramIntent)
  {
    this.yyw = new a.a()
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
    return this.yyw;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.yyu == null) {
      this.yyu = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.yyu);
    this.gwK = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.gwM);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.gwJ = paramIntent.getIntExtra("exec_time", 0);
      this.gwI = paramIntent.getIntExtra("interval", -1);
      this.gwM = paramIntent.getStringExtra("exec_tag");
    }
    if (this.gwM == null) {
      this.gwM = "Default";
    }
    this.gwK.setName(this.gwM);
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.gwM);
    switch (this.gwJ)
    {
    }
    for (this.repeatMode = 1; this.gwI == -1; this.repeatMode = this.gwJ)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.gwK.isAlive())
    {
      this.gwK = new Thread(this);
      this.gwK.setName(this.gwM);
      this.gwK.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv());
    Object localObject = Calendar.getInstance().getTime();
    String str1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    String str2 = localSharedPreferences.getString("LastExecDate", "00000000");
    localObject = localSharedPreferences.getString("RubbishTag", "N/A");
    if (!str2.equals(str1))
    {
      localSharedPreferences.edit().putString("RubbishTag", "N/A").putString("LastExecDate", str1).apply();
      localObject = "N/A";
    }
    if ((!this.yyt) && (((String)localObject).equals(this.gwM)) && (this.repeatMode != -1))
    {
      if (localSharedPreferences.getInt("RubbishCount", this.gwJ) <= 0)
      {
        this.repeatMode = 0;
        stopSelf();
      }
    }
    else {
      localSharedPreferences.edit().putInt("RubbishCount", this.gwJ).apply();
    }
    localSharedPreferences.edit().putString("RubbishTag", this.gwM).apply();
    this.gwJ = localSharedPreferences.getInt("RubbishCount", this.gwJ);
    ae.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { str1, Integer.valueOf(this.gwJ), this.gwM });
    for (;;)
    {
      if (this.repeatMode == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.gwJ -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.gwJ).apply();
        ae.i("RubbishBinService", "e!");
        com.tencent.mm.plugin.report.service.g.yxI.f(17910, new Object[] { a.hju, j.hju, this.gwM, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.gwJ == 0) && (this.repeatMode != -1));
      try
      {
        Thread.sleep(this.gwI);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */