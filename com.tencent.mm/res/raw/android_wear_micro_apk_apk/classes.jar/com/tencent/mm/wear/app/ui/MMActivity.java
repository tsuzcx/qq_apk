package com.tencent.mm.wear.app.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import android.view.autofill.AutofillManager;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;

public abstract class MMActivity
  extends Activity
{
  private static String aio = "";
  private static int aip;
  private static int aiq;
  private static boolean air;
  private static e ait;
  private int agB;
  private String agi;
  private BroadcastReceiver ais = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
        MMActivity.this.finish();
      }
    }
  };
  
  public static void A(Context paramContext)
  {
    d.c("MicroMsg.MMActivity", "Update language=%s", new Object[] { h.mO().mI() });
    com.tencent.mm.sdk.platformtools.e.a(paramContext, com.tencent.mm.sdk.platformtools.e.C(h.mO().mI()));
  }
  
  public static boolean isRect()
  {
    return ait == e.aiw;
  }
  
  public static boolean isRound()
  {
    return (!isRect()) && (ait != e.aiv);
  }
  
  public static void nM()
  {
    Object localObject = MMApplication.getContext().getPackageManager();
    AudioManager localAudioManager = (AudioManager)MMApplication.getContext().getSystemService("audio");
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (((PackageManager)localObject).hasSystemFeature("android.hardware.audio.output")))
    {
      localObject = localAudioManager.getDevices(2);
      int j = localObject.length;
      i = 0;
      if (i < j) {
        if (localObject[i].getType() != 2) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      air = bool;
      return;
      i += 1;
      break;
    }
  }
  
  public static String nN()
  {
    if (q.D(aio))
    {
      SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0);
      aio = (localSharedPreferences.getString("key_dp_metrics", "") + "\n" + localSharedPreferences.getString("key_dp_2_px", "")).trim();
    }
    return aio;
  }
  
  public static int nO()
  {
    return aip;
  }
  
  public static int nP()
  {
    return aiq;
  }
  
  public static boolean nR()
  {
    return air;
  }
  
  public final void f(Intent paramIntent)
  {
    paramIntent.putExtra("key_talker", this.agi);
    paramIntent.putExtra("key_notification_id", this.agB);
    startActivity(paramIntent);
  }
  
  public final void g(Intent paramIntent)
  {
    paramIntent.putExtra("key_talker", this.agi);
    paramIntent.putExtra("key_notification_id", this.agB);
    startActivityForResult(paramIntent, 0);
  }
  
  public final String getUsername()
  {
    return this.agi;
  }
  
  public final int nQ()
  {
    return this.agB;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.c("MicroMsg.MMActivity", "OnCreate Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
    SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0);
    paramBundle = getResources().getDisplayMetrics();
    aip = paramBundle.heightPixels;
    aiq = paramBundle.widthPixels;
    e locale = e.cq(localSharedPreferences.getInt("key_shape", e.aiv.value()));
    ait = locale;
    if (locale == e.aiv) {
      getWindow().getDecorView().findViewById(16908290).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          if (paramAnonymousWindowInsets.isRound())
          {
            MMActivity.a(e.aix);
            if ((MMActivity.nS() == 320) && (MMActivity.nT() == 290)) {
              MMActivity.a(e.aiy);
            }
          }
          for (;;)
          {
            MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0).edit().putInt("key_shape", MMActivity.nU().value()).commit();
            return paramAnonymousWindowInsets;
            if ((MMActivity.nS() == 360) && (MMActivity.nT() == 325))
            {
              MMActivity.a(e.aiz);
              continue;
              MMActivity.a(e.aiw);
            }
          }
        }
      });
    }
    if (!localSharedPreferences.contains("key_dp_metrics"))
    {
      paramBundle = String.format("DisplayMetrics density=%f densityDpi=%d xdpi=%f ydpi=%f widthPx=%d heightPx=%d", new Object[] { Float.valueOf(paramBundle.density), Integer.valueOf(paramBundle.densityDpi), Float.valueOf(paramBundle.xdpi), Float.valueOf(paramBundle.ydpi), Integer.valueOf(paramBundle.widthPixels), Integer.valueOf(paramBundle.heightPixels) });
      localSharedPreferences.edit().putString("key_dp_metrics", paramBundle).commit();
      d.c("MicroMsg.MMActivity", paramBundle, new Object[0]);
      if (localSharedPreferences.contains("key_dp_2_px")) {
        break label443;
      }
      paramBundle = String.format("Dp2Px 1dp=%dpx 2dp=%dpx 3dp=%dpx 4dp=%dpx 5dp=%dpx", new Object[] { Integer.valueOf(getResources().getDimensionPixelSize(2131296287)), Integer.valueOf(getResources().getDimensionPixelSize(2131296288)), Integer.valueOf(getResources().getDimensionPixelSize(2131296289)), Integer.valueOf(getResources().getDimensionPixelSize(2131296290)), Integer.valueOf(getResources().getDimensionPixelSize(2131296291)) });
      localSharedPreferences.edit().putString("key_dp_2_px", paramBundle).commit();
    }
    for (;;)
    {
      d.c("MicroMsg.MMActivity", paramBundle, new Object[0]);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.ais, paramBundle);
      this.agi = getIntent().getStringExtra("key_talker");
      this.agB = getIntent().getIntExtra("key_notification_id", 0);
      return;
      paramBundle = localSharedPreferences.getString("key_dp_metrics", "");
      break;
      label443:
      paramBundle = localSharedPreferences.getString("key_dp_2_px", "");
    }
  }
  
  protected void onDestroy()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      AutofillManager localAutofillManager = (AutofillManager)getSystemService(AutofillManager.class);
      if (localAutofillManager != null) {
        localAutofillManager.cancel();
      }
    }
    unregisterReceiver(this.ais);
    d.c("MicroMsg.MMActivity", "OnDestory Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
    super.onDestroy();
  }
  
  protected void onPause()
  {
    d.c("MicroMsg.MMActivity", "OnPause Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    d.c("MicroMsg.MMActivity", "OnRestart Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
  }
  
  protected void onResume()
  {
    super.onResume();
    d.c("MicroMsg.MMActivity", "OnResume Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    d.c("MicroMsg.MMActivity", "OnSaveInstanceState Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
  }
  
  protected void onStart()
  {
    super.onStart();
    d.c("MicroMsg.MMActivity", "OnStart Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
  }
  
  protected void onStop()
  {
    d.c("MicroMsg.MMActivity", "OnStop Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.MMActivity
 * JD-Core Version:    0.7.0.1
 */