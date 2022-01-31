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
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;

public abstract class MMActivity
  extends Activity
{
  private static String aeM = "";
  private static int aeN;
  private static int aeO;
  private static boolean aeP;
  private static e aeR;
  private String acH;
  private int ada;
  private BroadcastReceiver aeQ = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
        MMActivity.this.finish();
      }
    }
  };
  
  public static boolean isRect()
  {
    return aeR == e.aeU;
  }
  
  public static boolean isRound()
  {
    return (!isRect()) && (aeR != e.aeT);
  }
  
  public static void mZ()
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
      aeP = bool;
      return;
      i += 1;
      break;
    }
  }
  
  public static String na()
  {
    if (q.D(aeM))
    {
      SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0);
      aeM = (localSharedPreferences.getString("key_dp_metrics", "") + "\n" + localSharedPreferences.getString("key_dp_2_px", "")).trim();
    }
    return aeM;
  }
  
  public static int nb()
  {
    return aeN;
  }
  
  public static int nc()
  {
    return aeO;
  }
  
  public static boolean ne()
  {
    return aeP;
  }
  
  public static void z(Context paramContext)
  {
    d.c("MicroMsg.MMActivity", "Update language=%s", new Object[] { h.mb().lV() });
    com.tencent.mm.sdk.platformtools.e.a(paramContext, com.tencent.mm.sdk.platformtools.e.C(h.mb().lV()));
  }
  
  public final void d(Intent paramIntent)
  {
    paramIntent.putExtra("key_talker", this.acH);
    paramIntent.putExtra("key_notification_id", this.ada);
    startActivity(paramIntent);
  }
  
  public final void e(Intent paramIntent)
  {
    paramIntent.putExtra("key_talker", this.acH);
    paramIntent.putExtra("key_notification_id", this.ada);
    startActivityForResult(paramIntent, 0);
  }
  
  public final String getUsername()
  {
    return this.acH;
  }
  
  public final int nd()
  {
    return this.ada;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.c("MicroMsg.MMActivity", "OnCreate Name=%s, HashCode=%d, TaskId=%d", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()) });
    SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0);
    paramBundle = getResources().getDisplayMetrics();
    aeN = paramBundle.heightPixels;
    aeO = paramBundle.widthPixels;
    e locale = e.bU(localSharedPreferences.getInt("key_shape", e.aeT.value()));
    aeR = locale;
    if (locale == e.aeT) {
      getWindow().getDecorView().findViewById(16908290).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          if (paramAnonymousWindowInsets.isRound())
          {
            MMActivity.a(e.aeV);
            if ((MMActivity.nf() == 320) && (MMActivity.ng() == 290)) {
              MMActivity.a(e.aeW);
            }
          }
          for (;;)
          {
            MMApplication.getContext().getSharedPreferences("ui_core_shared_pre_name", 0).edit().putInt("key_shape", MMActivity.nh().value()).commit();
            return paramAnonymousWindowInsets;
            if ((MMActivity.nf() == 360) && (MMActivity.ng() == 325))
            {
              MMActivity.a(e.aeX);
              continue;
              MMActivity.a(e.aeU);
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
      registerReceiver(this.aeQ, paramBundle);
      this.acH = getIntent().getStringExtra("key_talker");
      this.ada = getIntent().getIntExtra("key_notification_id", 0);
      return;
      paramBundle = localSharedPreferences.getString("key_dp_metrics", "");
      break;
      label443:
      paramBundle = localSharedPreferences.getString("key_dp_2_px", "");
    }
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.aeQ);
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