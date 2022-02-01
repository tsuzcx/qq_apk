package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public class PermissionActivity
  extends AppCompatActivity
{
  private String[] XUi;
  private boolean XUj;
  private String XUk;
  private String XUl;
  private int hPm;
  private Intent intent;
  private String key;
  private int scene;
  
  public Resources getResources()
  {
    AppMethodBeat.i(244620);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(244620);
    return localResources;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151874);
    Log.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.scene == 2)
    {
      paramIntent = b.bqb(this.key);
      if (paramIntent != null) {
        paramIntent.aiW(paramInt2);
      }
      finish();
      AppMethodBeat.o(151874);
      return;
    }
    if (this.scene == 3)
    {
      if (paramInt2 == -1)
      {
        paramIntent = this.intent;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(151874);
        return;
        Toast.makeText(MMApplicationContext.getContext(), c.h.no_install_unknow_app_permission, 1).show();
      }
    }
    if (this.scene == 4)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        boolean bool = com.tencent.mm.booter.c.cN(this);
        if (bool)
        {
          if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("954_84_first", true))
          {
            f.Ozc.idkeyStat(954L, 84L, 1L, false);
            MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("954_84_first", false);
          }
          com.tencent.mm.booter.c.es(true);
        }
        Log.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    else {
      finish();
    }
    AppMethodBeat.o(151874);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151871);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("scene")))
    {
      finish();
      AppMethodBeat.o(151871);
      return;
    }
    getWindow().addFlags(67108864);
    paramBundle = getWindow();
    paramBundle.setGravity(51);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.height = 1;
    localLayoutParams.width = 1;
    paramBundle.setAttributes(localLayoutParams);
    this.XUj = true;
    this.scene = getIntent().getIntExtra("scene", 1);
    this.key = getIntent().getStringExtra("key");
    if (this.scene == 1)
    {
      this.XUi = getIntent().getStringArrayExtra("permission");
      this.hPm = getIntent().getIntExtra("requestCode", 0);
      if (!Util.isNullOrNil(this.XUi))
      {
        Log.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", new Object[] { Integer.valueOf(this.scene), this.XUi.toString(), Integer.valueOf(this.hPm) });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 2)
    {
      this.intent = getIntent().getSelector();
      this.XUk = getIntent().getStringExtra("reasonTitle");
      this.XUl = getIntent().getStringExtra("reasonMsg");
      if ((!Util.isNullOrNil(this.XUk)) && (!Util.isNullOrNil(this.XUl)))
      {
        Log.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", new Object[] { Integer.valueOf(this.scene), this.XUk, this.XUl });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 3)
    {
      this.intent = getIntent().getSelector();
      if (this.intent != null)
      {
        Log.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", new Object[] { Integer.valueOf(this.scene), this.intent.toString() });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 4)
    {
      Log.i("MicroMsg.PermissionActivity", "scene: %d", new Object[] { Integer.valueOf(this.scene) });
    }
    AppMethodBeat.o(151871);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(151875);
    Log.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    if (this.scene == 1) {
      b.bqa(this.key);
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(151875);
      return;
      if (this.scene == 2) {
        b.bqb(this.key);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(151873);
    Log.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt), paramArrayOfString.toString(), paramArrayOfInt.toString() });
    if (this.scene == 1)
    {
      c localc = b.bqa(this.key);
      if (localc != null) {
        localc.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    finish();
    AppMethodBeat.o(151873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151872);
    Log.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    super.onResume();
    if (this.XUj)
    {
      if (this.scene == 1) {
        b.a(this, this.XUi, this.hPm);
      }
      for (;;)
      {
        this.XUj = false;
        AppMethodBeat.o(151872);
        return;
        if (this.scene == 2)
        {
          if ((Util.isNullOrNil(this.XUl)) && (Util.isNullOrNil(this.XUk))) {
            try
            {
              startActivityForResult(this.intent, 1);
            }
            catch (Exception localException1)
            {
              Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException1.getMessage() });
            }
          } else {
            k.a(this, false, this.XUl, this.XUk, MMApplicationContext.getContext().getString(c.h.jump_to_settings), MMApplicationContext.getContext().getString(c.h.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(151867);
                try
                {
                  Log.i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                  PermissionActivity.this.startActivityForResult(PermissionActivity.a(PermissionActivity.this), 1);
                  AppMethodBeat.o(151867);
                  return;
                }
                catch (Exception paramAnonymousDialogInterface)
                {
                  Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(PermissionActivity.b(PermissionActivity.this)), paramAnonymousDialogInterface.getMessage() });
                  AppMethodBeat.o(151867);
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(151868);
                PermissionActivity.this.finish();
                AppMethodBeat.o(151868);
              }
            });
          }
        }
        else if (this.scene == 3)
        {
          Object localObject;
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (!getPackageManager().canRequestPackageInstalls())
            {
              Intent localIntent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName()));
              try
              {
                startActivityForResult(localIntent, 1);
              }
              catch (Exception localException2)
              {
                Log.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException2.getMessage() });
              }
            }
            else
            {
              localObject = this.intent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          else
          {
            localObject = this.intent;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        else if (this.scene == 4)
        {
          if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("954_95_first", true))
          {
            f.Ozc.idkeyStat(954L, 95L, 1L, false);
            MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("954_95_first", false);
          }
          f.Ozc.idkeyStat(954L, 96L, 1L, false);
          k.a(this, false, MMApplicationContext.getContext().getString(c.h.permission_ignore_battery_optimizations_again_msg), MMApplicationContext.getContext().getString(c.h.permission_tips_title), MMApplicationContext.getContext().getString(c.h.jump_to_settings), MMApplicationContext.getContext().getString(c.h.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151869);
              Log.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
              PermissionActivity.c(PermissionActivity.this);
              AppMethodBeat.o(151869);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151870);
              Log.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
              PermissionActivity.this.finish();
              AppMethodBeat.o(151870);
            }
          });
        }
      }
    }
    this.XUj = true;
    AppMethodBeat.o(151872);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionActivity
 * JD-Core Version:    0.7.0.1
 */