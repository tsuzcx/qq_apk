package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;

public class PermissionActivity
  extends AppCompatActivity
{
  private String[] BRg;
  private boolean BRh;
  private String BRi;
  private String BRj;
  private Intent intent;
  private String key;
  private int requestCode;
  private int scene;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151874);
    ad.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.scene == 2)
    {
      paramIntent = b.aBc(this.key);
      if (paramIntent != null) {
        paramIntent.LD(paramInt2);
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(151874);
        return;
        Toast.makeText(aj.getContext(), 2131761620, 1).show();
      }
    }
    if (this.scene == 4)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        boolean bool = com.tencent.mm.booter.c.bG(this);
        if (bool)
        {
          if (ax.aFC("service_launch_way").getBoolean("954_84_first", true))
          {
            e.vIY.idkeyStat(954L, 84L, 1L, false);
            ax.aFC("service_launch_way").edit().putBoolean("954_84_first", false);
          }
          com.tencent.mm.booter.c.cv(true);
        }
        ad.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", new Object[] { Boolean.valueOf(bool) });
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
    this.BRh = true;
    this.scene = getIntent().getIntExtra("scene", 1);
    this.key = getIntent().getStringExtra("key");
    if (this.scene == 1)
    {
      this.BRg = getIntent().getStringArrayExtra("permission");
      this.requestCode = getIntent().getIntExtra("requestCode", 0);
      if (!bt.T(this.BRg))
      {
        ad.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", new Object[] { Integer.valueOf(this.scene), this.BRg.toString(), Integer.valueOf(this.requestCode) });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 2)
    {
      this.intent = getIntent().getSelector();
      this.BRi = getIntent().getStringExtra("reasonTitle");
      this.BRj = getIntent().getStringExtra("reasonMsg");
      if ((!bt.isNullOrNil(this.BRi)) && (!bt.isNullOrNil(this.BRj)))
      {
        ad.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", new Object[] { Integer.valueOf(this.scene), this.BRi, this.BRj });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 3)
    {
      this.intent = getIntent().getSelector();
      if (this.intent != null)
      {
        ad.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", new Object[] { Integer.valueOf(this.scene), this.intent.toString() });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 4)
    {
      ad.i("MicroMsg.PermissionActivity", "scene: %d", new Object[] { Integer.valueOf(this.scene) });
    }
    AppMethodBeat.o(151871);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(151875);
    ad.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    if (this.scene == 1) {
      b.aBb(this.key);
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(151875);
      return;
      if (this.scene == 2) {
        b.aBc(this.key);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(151873);
    ad.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt), paramArrayOfString.toString(), paramArrayOfInt.toString() });
    if (this.scene == 1)
    {
      paramArrayOfString = b.aBb(this.key);
      if (paramArrayOfString != null) {
        paramArrayOfString.s(paramArrayOfInt);
      }
    }
    finish();
    AppMethodBeat.o(151873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151872);
    ad.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    super.onResume();
    if (this.BRh)
    {
      if (this.scene == 1) {
        b.a(this, this.BRg, this.requestCode);
      }
      for (;;)
      {
        this.BRh = false;
        AppMethodBeat.o(151872);
        return;
        if (this.scene == 2)
        {
          if ((bt.isNullOrNil(this.BRj)) && (bt.isNullOrNil(this.BRi))) {
            try
            {
              startActivityForResult(this.intent, 1);
            }
            catch (Exception localException1)
            {
              ad.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException1.getMessage() });
            }
          } else {
            h.a(this, false, this.BRj, this.BRi, getString(2131760598), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(151867);
                try
                {
                  ad.i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                  PermissionActivity.this.startActivityForResult(PermissionActivity.a(PermissionActivity.this), 1);
                  AppMethodBeat.o(151867);
                  return;
                }
                catch (Exception paramAnonymousDialogInterface)
                {
                  ad.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(PermissionActivity.b(PermissionActivity.this)), paramAnonymousDialogInterface.getMessage() });
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
                ad.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException2.getMessage() });
              }
            }
            else
            {
              localObject = this.intent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          else
          {
            localObject = this.intent;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        else if (this.scene == 4)
        {
          if (ax.aFC("service_launch_way").getBoolean("954_95_first", true))
          {
            e.vIY.idkeyStat(954L, 95L, 1L, false);
            ax.aFC("service_launch_way").edit().putBoolean("954_95_first", false);
          }
          e.vIY.idkeyStat(954L, 96L, 1L, false);
          h.a(this, false, getString(2131761866), getString(2131761885), getString(2131760598), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151869);
              ad.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
              PermissionActivity.c(PermissionActivity.this);
              AppMethodBeat.o(151869);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151870);
              ad.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
              PermissionActivity.this.finish();
              AppMethodBeat.o(151870);
            }
          });
        }
      }
    }
    this.BRh = true;
    AppMethodBeat.o(151872);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionActivity
 * JD-Core Version:    0.7.0.1
 */