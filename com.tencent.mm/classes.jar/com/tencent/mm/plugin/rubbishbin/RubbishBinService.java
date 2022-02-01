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
  private int CKR = 7;
  int DSE = 1000;
  private boolean IAq = false;
  private b IAr = null;
  private String IAs = "";
  private IBinder IAt = null;
  private int IAu = 0;
  private int IAv = 8;
  private String IAw = null;
  private int aLK = 1;
  private Context context = this;
  Thread qkF;
  
  public abstract void aXa(String paramString);
  
  public IBinder onBind(Intent paramIntent)
  {
    this.IAt = new a.a()
    {
      public final void G(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
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
    return this.IAt;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.context = this;
    if (this.IAr == null) {
      this.IAr = new b(this);
    }
    Thread.setDefaultUncaughtExceptionHandler(this.IAr);
    this.qkF = new Thread(this);
    JNIExceptionHandlerImpl.initJNIExceptionHandler(this, this.IAw);
    JNIExceptionHandler.init();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.IAu = paramIntent.getIntExtra("exec_time", 0);
      this.DSE = paramIntent.getIntExtra("interval", -1);
      this.IAw = paramIntent.getStringExtra("exec_tag");
    }
    if (this.IAw == null) {
      this.IAw = "Default";
    }
    this.qkF.setName("rubbish_executor");
    JNIExceptionHandler.INSTANCE.setReportExecutionTag(this.IAw);
    switch (this.IAu)
    {
    }
    for (this.aLK = 1; this.DSE == -1; this.aLK = this.IAu)
    {
      stopSelf();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (!this.qkF.isAlive())
    {
      this.qkF = new Thread(this);
      this.qkF.setName("rubbish_executor");
      this.qkF.start();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("system_config_prefs", g.avK());
    Object localObject = Calendar.getInstance().getTime();
    localObject = new SimpleDateFormat("yyyyMMdd").format((Date)localObject);
    localSharedPreferences.edit().putInt("RubbishCount", this.IAu).apply();
    localSharedPreferences.edit().putString("RubbishTag", this.IAw).apply();
    this.IAu = localSharedPreferences.getInt("RubbishCount", this.IAu);
    Log.i("RubbishBinService", "[sunny]dt:%s,cnt:%d,t:%s", new Object[] { localObject, Integer.valueOf(this.IAu), this.IAw });
    for (;;)
    {
      if (this.aLK == 0) {
        stopSelf();
      }
      do
      {
        stopSelf();
        return;
        this.IAu -= 1;
        localSharedPreferences.edit().putInt("RubbishCount", this.IAu).apply();
        Log.i("RubbishBinService", "e!");
        aXa(this.IAw);
        h.IzE.a(17910, new Object[] { a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION, this.IAw, Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.nanoTime()) });
      } while ((this.IAu == 0) && (this.aLK != -1));
      try
      {
        Thread.sleep(this.DSE);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.RubbishBinService
 * JD-Core Version:    0.7.0.1
 */