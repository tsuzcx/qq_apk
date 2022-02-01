package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public final class r
{
  Runnable pBm;
  private boolean pUC = false;
  
  private static boolean jju()
  {
    AppMethodBeat.i(161503);
    com.tencent.mm.kernel.h.baC();
    boolean bool = com.tencent.mm.kernel.b.aZM();
    String str = bg.okT.aM("login_user_name", "");
    if ((!bool) && (str.equals("")))
    {
      AppMethodBeat.o(161503);
      return true;
    }
    AppMethodBeat.o(161503);
    return false;
  }
  
  public static boolean jjv()
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
            if (r.this.pBm != null) {
              r.this.pBm.run();
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
      i = R.l.permission_storage_request_again_msg;
      if (paramInt == 96)
      {
        i = R.l.permission_phone_request_again_msg;
        if (paramArrayOfInt[0] != 0) {
          break label317;
        }
        if (paramInt != 32) {
          break label273;
        }
        f.Ozc.idkeyStat(462L, 0L, 1L, true);
        label236:
        if (this.pBm != null) {
          this.pBm.run();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33368);
        return true;
        if (paramInt != 64) {
          break;
        }
        i = R.l.permission_location_request_again_msg;
        break;
        label273:
        if (paramInt == 96)
        {
          f.Ozc.idkeyStat(462L, 1L, 1L, true);
          q.aPh();
          q.aOX();
          break label236;
        }
        f.Ozc.idkeyStat(462L, 2L, 1L, true);
        break label236;
        label317:
        k.a(paramActivity, paramActivity.getString(i), paramActivity.getString(R.l.permission_tips_title), paramActivity.getString(R.l.jump_to_settings), paramActivity.getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33362);
            if (paramInt == 32) {
              f.Ozc.idkeyStat(462L, 3L, 1L, true);
            }
            for (;;)
            {
              com.tencent.mm.pluginsdk.permission.b.lx(paramActivity);
              paramAnonymousDialogInterface.dismiss();
              paramActivity.finish();
              AppMethodBeat.o(33362);
              return;
              if (paramInt == 96) {
                f.Ozc.idkeyStat(462L, 4L, 1L, true);
              } else {
                f.Ozc.idkeyStat(462L, 5L, 1L, true);
              }
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33363);
            if (paramInt == 32) {
              f.Ozc.idkeyStat(462L, 6L, 1L, true);
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              paramActivity.finish();
              AppMethodBeat.o(33363);
              return;
              if (paramInt == 96) {
                f.Ozc.idkeyStat(462L, 7L, 1L, true);
              } else {
                f.Ozc.idkeyStat(462L, 8L, 1L, true);
              }
            }
          }
        });
      }
    }
    int i = R.l.permission_storage_request_again_msg;
    if (paramInt == 97)
    {
      i = R.l.permission_phone_request_again_msg;
      if (paramArrayOfInt[0] != 0) {
        break label477;
      }
      if (paramInt != 33) {
        break label437;
      }
      f.Ozc.idkeyStat(462L, 9L, 1L, true);
    }
    for (;;)
    {
      AppMethodBeat.o(33368);
      return true;
      if (paramInt != 70) {
        break;
      }
      i = R.l.permission_location_request_again_msg;
      break;
      label437:
      if (paramInt == 97)
      {
        f.Ozc.idkeyStat(462L, 10L, 1L, true);
      }
      else
      {
        f.Ozc.idkeyStat(462L, 11L, 1L, true);
        continue;
        label477:
        this.pUC = false;
        k.a(paramActivity, paramActivity.getString(i), paramActivity.getString(R.l.permission_tips_title), paramActivity.getString(R.l.jump_to_settings), paramActivity.getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33364);
            if (paramInt == 33) {
              f.Ozc.idkeyStat(462L, 12L, 1L, true);
            }
            for (;;)
            {
              com.tencent.mm.pluginsdk.permission.b.lx(paramActivity);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33364);
              return;
              if (paramInt == 97) {
                f.Ozc.idkeyStat(462L, 13L, 1L, true);
              } else {
                f.Ozc.idkeyStat(462L, 14L, 1L, true);
              }
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33365);
            if (paramInt == 33) {
              f.Ozc.idkeyStat(462L, 15L, 1L, true);
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(33365);
              return;
              if (paramInt == 97) {
                f.Ozc.idkeyStat(462L, 16L, 1L, true);
              } else {
                f.Ozc.idkeyStat(462L, 17L, 1L, true);
              }
            }
          }
        });
      }
    }
  }
  
  public final boolean bN(Activity paramActivity)
  {
    AppMethodBeat.i(33366);
    if (!this.pUC)
    {
      AppMethodBeat.o(33366);
      return true;
    }
    this.pUC = false;
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool = localSharedPreferences.getBoolean("SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE", false);
    int i = localSharedPreferences.getInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", -2147483648);
    if (((bool) && (MMApplicationContext.getContext().getApplicationInfo().uid == i)) || ((jju()) && (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())))
    {
      Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "ingore check permission on resume, %b, %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(33366);
      return true;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.r
 * JD-Core Version:    0.7.0.1
 */