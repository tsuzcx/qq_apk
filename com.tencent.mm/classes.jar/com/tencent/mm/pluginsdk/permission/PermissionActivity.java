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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class PermissionActivity
  extends AppCompatActivity
{
  private Intent intent;
  private String key;
  private int requestCode;
  private int scene;
  private String[] vMt;
  private boolean vMu;
  private String vMv;
  private String vMw;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79434);
    ab.i("MicroMsg.PermissionActivity", "onActivityResult(),  scene=%d, requestCode=%d, resultCode=%d", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.scene == 2)
    {
      paramIntent = b.alC(this.key);
      if (paramIntent != null) {
        paramIntent.De(paramInt2);
      }
      finish();
      AppMethodBeat.o(79434);
      return;
    }
    if (this.scene == 3)
    {
      if (paramInt2 == -1) {
        startActivity(this.intent);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(79434);
        return;
        Toast.makeText(ah.getContext(), 2131301860, 1).show();
      }
    }
    if (this.scene == 4)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        boolean bool = com.tencent.mm.booter.c.bs(this);
        if (bool)
        {
          if (as.apq("service_launch_way").getBoolean("954_84_first", true))
          {
            e.qrI.idkeyStat(954L, 84L, 1L, false);
            as.apq("service_launch_way").edit().putBoolean("954_84_first", false);
          }
          com.tencent.mm.booter.c.bD(true);
        }
        ab.i("MicroMsg.PermissionActivity", "onActivityResult ADD_IGNORING_BATTERY_OPTIMIZATIONS result=%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    else {
      finish();
    }
    AppMethodBeat.o(79434);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79431);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("scene")))
    {
      finish();
      AppMethodBeat.o(79431);
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
    this.vMu = true;
    this.scene = getIntent().getIntExtra("scene", 1);
    this.key = getIntent().getStringExtra("key");
    if (this.scene == 1)
    {
      this.vMt = getIntent().getStringArrayExtra("permission");
      this.requestCode = getIntent().getIntExtra("requestCode", 0);
      if (!bo.Q(this.vMt))
      {
        ab.i("MicroMsg.PermissionActivity", "scene: %d, permission: %s, requestCode: %d", new Object[] { Integer.valueOf(this.scene), this.vMt.toString(), Integer.valueOf(this.requestCode) });
        AppMethodBeat.o(79431);
      }
    }
    else if (this.scene == 2)
    {
      this.intent = getIntent().getSelector();
      this.vMv = getIntent().getStringExtra("reasonTitle");
      this.vMw = getIntent().getStringExtra("reasonMsg");
      if ((!bo.isNullOrNil(this.vMv)) && (!bo.isNullOrNil(this.vMw)))
      {
        ab.i("MicroMsg.PermissionActivity", "scene: %d, reasonTitle: %s, reasonMsg: %s", new Object[] { Integer.valueOf(this.scene), this.vMv, this.vMw });
        AppMethodBeat.o(79431);
      }
    }
    else if (this.scene == 3)
    {
      this.intent = getIntent().getSelector();
      if (this.intent != null)
      {
        ab.i("MicroMsg.PermissionActivity", "scene: %d, intent: %s", new Object[] { Integer.valueOf(this.scene), this.intent.toString() });
        AppMethodBeat.o(79431);
      }
    }
    else if (this.scene == 4)
    {
      ab.i("MicroMsg.PermissionActivity", "scene: %d", new Object[] { Integer.valueOf(this.scene) });
    }
    AppMethodBeat.o(79431);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79435);
    ab.i("MicroMsg.PermissionActivity", "onDestroy(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    if (this.scene == 1) {
      b.alB(this.key);
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(79435);
      return;
      if (this.scene == 2) {
        b.alC(this.key);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79433);
    ab.i("MicroMsg.PermissionActivity", "onRequestPermissionsResult(),  scene=%d, requestCode=%d, permissions=%s, grantResults=%s", new Object[] { Integer.valueOf(this.scene), Integer.valueOf(paramInt), paramArrayOfString.toString(), paramArrayOfInt.toString() });
    if (this.scene == 1)
    {
      paramArrayOfString = b.alB(this.key);
      if (paramArrayOfString != null) {
        paramArrayOfString.t(paramArrayOfInt);
      }
    }
    finish();
    AppMethodBeat.o(79433);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79432);
    ab.i("MicroMsg.PermissionActivity", "onResume(), scene=%d", new Object[] { Integer.valueOf(this.scene) });
    super.onResume();
    if (this.vMu)
    {
      if (this.scene == 1) {
        b.a(this, this.vMt, this.requestCode);
      }
      for (;;)
      {
        this.vMu = false;
        AppMethodBeat.o(79432);
        return;
        if (this.scene == 2)
        {
          if ((bo.isNullOrNil(this.vMw)) && (bo.isNullOrNil(this.vMv))) {
            try
            {
              startActivityForResult(this.intent, 1);
            }
            catch (Exception localException1)
            {
              ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException1.getMessage() });
            }
          } else {
            h.a(this, false, this.vMw, this.vMv, getString(2131300996), getString(2131296888), new PermissionActivity.1(this), new PermissionActivity.2(this));
          }
        }
        else if (this.scene == 3)
        {
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
                ab.e("MicroMsg.PermissionActivity", "onResume scene = %d startActivityForResult() Exception = %s ", new Object[] { Integer.valueOf(this.scene), localException2.getMessage() });
              }
            }
            else
            {
              startActivity(this.intent);
            }
          }
          else {
            startActivity(this.intent);
          }
        }
        else if (this.scene == 4)
        {
          if (as.apq("service_launch_way").getBoolean("954_95_first", true))
          {
            e.qrI.idkeyStat(954L, 95L, 1L, false);
            as.apq("service_launch_way").edit().putBoolean("954_95_first", false);
          }
          e.qrI.idkeyStat(954L, 96L, 1L, false);
          h.a(this, false, getString(2131302072), getString(2131302083), getString(2131300996), getString(2131296888), new PermissionActivity.3(this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79430);
              ab.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations app_cancel");
              PermissionActivity.this.finish();
              AppMethodBeat.o(79430);
            }
          });
        }
      }
    }
    this.vMu = true;
    AppMethodBeat.o(79432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionActivity
 * JD-Core Version:    0.7.0.1
 */