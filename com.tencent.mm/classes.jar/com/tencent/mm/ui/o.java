package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
{
  Runnable jNB;
  private boolean kgv = true;
  
  private static boolean gIy()
  {
    AppMethodBeat.i(161503);
    g.aAf();
    boolean bool = com.tencent.mm.kernel.a.azo();
    String str = bf.iDu.aA("login_user_name", "");
    if ((!bool) && (str.equals("")))
    {
      AppMethodBeat.o(161503);
      return true;
    }
    AppMethodBeat.o(161503);
    return false;
  }
  
  public static boolean gIz()
  {
    AppMethodBeat.i(163278);
    Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "ingore check permission on init");
    AppMethodBeat.o(163278);
    return true;
  }
  
  public final boolean a(final Activity paramActivity, final int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33368);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (i = -1;; i = paramArrayOfInt.length)
      {
        Log.w("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, Util.getStack() });
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33360);
            if (o.this.jNB != null) {
              o.this.jNB.run();
            }
            AppMethodBeat.o(33360);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(33361);
            String str = super.toString() + "|onInitDelay";
            AppMethodBeat.o(33361);
            return str;
          }
        }, 500L);
        AppMethodBeat.o(33368);
        return true;
      }
    }
    Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33368);
      return false;
    case 32: 
    case 64: 
    case 96: 
      i = 2131763888;
      if (paramInt == 96)
      {
        i = 2131763877;
        if (paramArrayOfInt[0] != 0) {
          break label314;
        }
        if (paramInt != 32) {
          break label270;
        }
        e.Cxv.idkeyStat(462L, 0L, 1L, true);
        label234:
        if (this.jNB != null) {
          this.jNB.run();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33368);
        return true;
        if (paramInt != 64) {
          break;
        }
        i = 2131763874;
        break;
        label270:
        if (paramInt == 96)
        {
          e.Cxv.idkeyStat(462L, 1L, 1L, true);
          q.aoH();
          q.aoy();
          break label234;
        }
        e.Cxv.idkeyStat(462L, 2L, 1L, true);
        break label234;
        label314:
        com.tencent.mm.ui.base.h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(2131763890), paramActivity.getString(2131762043), paramActivity.getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33362);
            if (paramInt == 32) {
              e.Cxv.idkeyStat(462L, 3L, 1L, true);
            }
            for (;;)
            {
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              ((Intent)localObject).addFlags(268435456);
              Activity localActivity = paramActivity;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUICheckPermissionHelper$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/LauncherUICheckPermissionHelper$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.dismiss();
              paramActivity.finish();
              AppMethodBeat.o(33362);
              return;
              if (paramInt == 96) {
                e.Cxv.idkeyStat(462L, 4L, 1L, true);
              } else {
                e.Cxv.idkeyStat(462L, 5L, 1L, true);
              }
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33363);
            if (paramInt == 32) {
              e.Cxv.idkeyStat(462L, 6L, 1L, true);
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              paramActivity.finish();
              AppMethodBeat.o(33363);
              return;
              if (paramInt == 96) {
                e.Cxv.idkeyStat(462L, 7L, 1L, true);
              } else {
                e.Cxv.idkeyStat(462L, 8L, 1L, true);
              }
            }
          }
        });
      }
    }
    int i = 2131763888;
    if (paramInt == 97)
    {
      i = 2131763877;
      if (paramArrayOfInt[0] != 0) {
        break label468;
      }
      if (paramInt != 33) {
        break label428;
      }
      e.Cxv.idkeyStat(462L, 9L, 1L, true);
    }
    for (;;)
    {
      AppMethodBeat.o(33368);
      return true;
      if (paramInt != 70) {
        break;
      }
      i = 2131763874;
      break;
      label428:
      if (paramInt == 97)
      {
        e.Cxv.idkeyStat(462L, 10L, 1L, true);
      }
      else
      {
        e.Cxv.idkeyStat(462L, 11L, 1L, true);
        continue;
        label468:
        this.kgv = false;
        com.tencent.mm.ui.base.h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(2131763890), paramActivity.getString(2131762043), paramActivity.getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33364);
            if (paramInt == 33) {
              e.Cxv.idkeyStat(462L, 12L, 1L, true);
            }
            for (;;)
            {
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              ((Intent)localObject).addFlags(268435456);
              Activity localActivity = paramActivity;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUICheckPermissionHelper$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/LauncherUICheckPermissionHelper$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33364);
              return;
              if (paramInt == 97) {
                e.Cxv.idkeyStat(462L, 13L, 1L, true);
              } else {
                e.Cxv.idkeyStat(462L, 14L, 1L, true);
              }
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33365);
            if (paramInt == 33) {
              e.Cxv.idkeyStat(462L, 15L, 1L, true);
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33365);
              return;
              if (paramInt == 97) {
                e.Cxv.idkeyStat(462L, 16L, 1L, true);
              } else {
                e.Cxv.idkeyStat(462L, 17L, 1L, true);
              }
            }
          }
        });
      }
    }
  }
  
  public final boolean bc(Activity paramActivity)
  {
    AppMethodBeat.i(33366);
    if (!this.kgv)
    {
      AppMethodBeat.o(33366);
      return true;
    }
    this.kgv = false;
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool = localSharedPreferences.getBoolean("SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE", false);
    int i = localSharedPreferences.getInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", -2147483648);
    if (((bool) && (MMApplicationContext.getContext().getApplicationInfo().uid == i)) || ((gIy()) && (((com.tencent.mm.kernel.b.h)g.aAe().azG()).aBb())))
    {
      Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "ingore check permission on resume, %b, %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(33366);
      return true;
    }
    bool = b.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
    Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "check resume, summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    localSharedPreferences.edit().putBoolean("SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE", true).apply();
    localSharedPreferences.edit().putInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", MMApplicationContext.getContext().getApplicationInfo().uid).apply();
    if (!bool)
    {
      AppMethodBeat.o(33366);
      return false;
    }
    AppMethodBeat.o(33366);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.o
 * JD-Core Version:    0.7.0.1
 */