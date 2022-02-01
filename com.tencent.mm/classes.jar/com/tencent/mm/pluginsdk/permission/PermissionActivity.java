package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;

public class PermissionActivity
  extends AppCompatActivity
{
  private String[] FgO;
  private boolean FgP;
  private String FgQ;
  private String FgR;
  private Intent intent;
  private String key;
  private int requestCode;
  private int scene;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151874);
    ae.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.scene == 2)
    {
      paramIntent = b.aNq(this.key);
      if (paramIntent != null) {
        paramIntent.PN(paramInt2);
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(151874);
        return;
        Toast.makeText(ak.getContext(), 2131761620, 1).show();
      }
    }
    if (this.scene == 4)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        boolean bool = com.tencent.mm.booter.c.bK(this);
        if (bool)
        {
          if (ay.aRW("service_launch_way").getBoolean("954_84_first", true))
          {
            e.ywz.idkeyStat(954L, 84L, 1L, false);
            ay.aRW("service_launch_way").edit().putBoolean("954_84_first", false);
          }
          com.tencent.mm.booter.c.cy(true);
        }
        ae.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", new Object[] { Boolean.valueOf(bool) });
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
    this.FgP = true;
    this.scene = getIntent().getIntExtra("scene", 1);
    this.key = getIntent().getStringExtra("key");
    if (this.scene == 1)
    {
      this.FgO = getIntent().getStringArrayExtra("permission");
      this.requestCode = getIntent().getIntExtra("requestCode", 0);
      if (!bu.V(this.FgO))
      {
        ae.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", new Object[] { Integer.valueOf(this.scene), this.FgO.toString(), Integer.valueOf(this.requestCode) });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 2)
    {
      this.intent = getIntent().getSelector();
      this.FgQ = getIntent().getStringExtra("reasonTitle");
      this.FgR = getIntent().getStringExtra("reasonMsg");
      if ((!bu.isNullOrNil(this.FgQ)) && (!bu.isNullOrNil(this.FgR)))
      {
        ae.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", new Object[] { Integer.valueOf(this.scene), this.FgQ, this.FgR });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 3)
    {
      this.intent = getIntent().getSelector();
      if (this.intent != null)
      {
        ae.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", new Object[] { Integer.valueOf(this.scene), this.intent.toString() });
        AppMethodBeat.o(151871);
      }
    }
    else if (this.scene == 4)
    {
      ae.i("MicroMsg.PermissionActivity", "scene: %d", new Object[] { Integer.valueOf(this.scene) });
    }
    AppMethodBeat.o(151871);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(151875);
    ae.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    if (this.scene == 1) {
      b.aNp(this.key);
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(151875);
      return;
      if (this.scene == 2) {
        b.aNq(this.key);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(151873);
    ae.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt), paramArrayOfString.toString(), paramArrayOfInt.toString() });
    if (this.scene == 1)
    {
      paramArrayOfString = b.aNp(this.key);
      if (paramArrayOfString != null) {
        paramArrayOfString.b(paramInt, paramArrayOfInt);
      }
    }
    finish();
    AppMethodBeat.o(151873);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151872);
    ae.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    super.onResume();
    if (this.FgP)
    {
      if (this.scene == 1) {
        b.a(this, this.FgO, this.requestCode);
      }
      for (;;)
      {
        this.FgP = false;
        AppMethodBeat.o(151872);
        return;
        if (this.scene == 2)
        {
          if ((bu.isNullOrNil(this.FgR)) && (bu.isNullOrNil(this.FgQ))) {
            try
            {
              startActivityForResult(this.intent, 1);
            }
            catch (Exception localException1)
            {
              ae.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException1.getMessage() });
            }
          } else {
            h.a(this, false, this.FgR, this.FgQ, ak.getContext().getString(2131760598), ak.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(151867);
                try
                {
                  ae.i("MicroMsg.PermissionActivity", "START_SETTINGS_REQUEST click ok");
                  PermissionActivity.this.startActivityForResult(PermissionActivity.a(PermissionActivity.this), 1);
                  AppMethodBeat.o(151867);
                  return;
                }
                catch (Exception paramAnonymousDialogInterface)
                {
                  ae.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(PermissionActivity.b(PermissionActivity.this)), paramAnonymousDialogInterface.getMessage() });
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
                ae.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException2.getMessage() });
              }
            }
            else
            {
              localObject = this.intent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          else
          {
            localObject = this.intent;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/permission/PermissionActivity", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        else if (this.scene == 4)
        {
          if (ay.aRW("service_launch_way").getBoolean("954_95_first", true))
          {
            e.ywz.idkeyStat(954L, 95L, 1L, false);
            ay.aRW("service_launch_way").edit().putBoolean("954_95_first", false);
          }
          e.ywz.idkeyStat(954L, 96L, 1L, false);
          h.a(this, false, ak.getContext().getString(2131761866), ak.getContext().getString(2131761885), ak.getContext().getString(2131760598), ak.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151869);
              ae.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
              PermissionActivity.c(PermissionActivity.this);
              AppMethodBeat.o(151869);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(151870);
              ae.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
              PermissionActivity.this.finish();
              AppMethodBeat.o(151870);
            }
          });
        }
      }
    }
    this.FgP = true;
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