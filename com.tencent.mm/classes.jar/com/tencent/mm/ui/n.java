package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class n
{
  boolean gzb = true;
  Runnable yZO;
  
  public final boolean a(final Activity paramActivity, final int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29514);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (i = -1;; i = paramArrayOfInt.length)
      {
        ab.w("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bo.dtY() });
        al.p(new n.1(this), 500L);
        AppMethodBeat.o(29514);
        return true;
      }
    }
    ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(29514);
      return false;
    case 32: 
    case 64: 
    case 96: 
      i = 2131302081;
      if (paramInt == 96)
      {
        i = 2131302076;
        if (paramArrayOfInt[0] != 0) {
          break label320;
        }
        if (paramInt != 32) {
          break label276;
        }
        e.qrI.idkeyStat(462L, 0L, 1L, true);
        label239:
        if (this.yZO != null) {
          this.yZO.run();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(29514);
        return true;
        if (paramInt != 64) {
          break;
        }
        i = 2131302073;
        break;
        label276:
        if (paramInt == 96)
        {
          e.qrI.idkeyStat(462L, 1L, 1L, true);
          q.LL();
          q.LC();
          break label239;
        }
        e.qrI.idkeyStat(462L, 2L, 1L, true);
        break label239;
        label320:
        h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(2131302083), paramActivity.getString(2131300996), paramActivity.getString(2131297837), false, new n.2(this, paramInt, paramActivity), new n.3(this, paramInt, paramActivity));
      }
    }
    int i = 2131302081;
    if (paramInt == 97)
    {
      i = 2131302076;
      if (paramArrayOfInt[0] != 0) {
        break label475;
      }
      if (paramInt != 33) {
        break label435;
      }
      e.qrI.idkeyStat(462L, 9L, 1L, true);
    }
    for (;;)
    {
      AppMethodBeat.o(29514);
      return true;
      if (paramInt != 70) {
        break;
      }
      i = 2131302073;
      break;
      label435:
      if (paramInt == 97)
      {
        e.qrI.idkeyStat(462L, 10L, 1L, true);
      }
      else
      {
        e.qrI.idkeyStat(462L, 11L, 1L, true);
        continue;
        label475:
        this.gzb = false;
        h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(2131302083), paramActivity.getString(2131300996), paramActivity.getString(2131297837), false, new n.4(this, paramInt, paramActivity), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29511);
            if (paramInt == 33) {
              e.qrI.idkeyStat(462L, 15L, 1L, true);
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              n.this.gzb = true;
              MMAppMgr.l(paramActivity, true);
              paramActivity.finish();
              AppMethodBeat.o(29511);
              return;
              if (paramInt == 97) {
                e.qrI.idkeyStat(462L, 16L, 1L, true);
              } else {
                e.qrI.idkeyStat(462L, 17L, 1L, true);
              }
            }
          }
        });
      }
    }
  }
  
  public final boolean aw(Activity paramActivity)
  {
    AppMethodBeat.i(29512);
    if (this.gzb)
    {
      boolean bool = b.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(29512);
        return false;
      }
      bool = b.a(paramActivity, "android.permission.READ_PHONE_STATE", 97, "", "");
      ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(29512);
        return false;
      }
    }
    AppMethodBeat.o(29512);
    return true;
  }
  
  public final boolean c(Activity paramActivity, Runnable paramRunnable)
  {
    AppMethodBeat.i(29513);
    boolean bool = b.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "");
    ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      this.yZO = paramRunnable;
      AppMethodBeat.o(29513);
      return false;
    }
    bool = b.a(paramActivity, "android.permission.READ_PHONE_STATE", 96, "", "");
    ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      this.yZO = paramRunnable;
      AppMethodBeat.o(29513);
      return false;
    }
    q.LC();
    ab.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.yYR));
    g.lb(LauncherUI.yYR);
    AppMethodBeat.o(29513);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.n
 * JD-Core Version:    0.7.0.1
 */