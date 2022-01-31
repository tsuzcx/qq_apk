package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class p
{
  boolean fht = true;
  Runnable uLJ;
  
  public final boolean a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (i = -1;; i = paramArrayOfInt.length)
      {
        y.w("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
        ai.l(new p.1(this), 500L);
        return true;
      }
    }
    y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return false;
    case 32: 
    case 64: 
    case 96: 
      i = R.l.permission_storage_request_again_msg;
      if (paramInt == 96)
      {
        i = R.l.permission_phone_request_again_msg;
        if (paramArrayOfInt[0] != 0) {
          break label298;
        }
        if (paramInt != 32) {
          break label255;
        }
        f.nEG.a(462L, 0L, 1L, true);
        label223:
        if (this.uLJ != null) {
          this.uLJ.run();
        }
      }
      for (;;)
      {
        return true;
        if (paramInt != 64) {
          break;
        }
        i = R.l.permission_location_request_again_msg;
        break;
        label255:
        if (paramInt == 96)
        {
          f.nEG.a(462L, 1L, 1L, true);
          q.br(true);
          break label223;
        }
        f.nEG.a(462L, 2L, 1L, true);
        break label223;
        label298:
        h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(R.l.permission_tips_title), paramActivity.getString(R.l.jump_to_settings), paramActivity.getString(R.l.cancel), false, new p.2(this, paramInt, paramActivity), new p.3(this, paramInt, paramActivity));
      }
    }
    int i = R.l.permission_storage_request_again_msg;
    if (paramInt == 97)
    {
      i = R.l.permission_phone_request_again_msg;
      if (paramArrayOfInt[0] != 0) {
        break label453;
      }
      if (paramInt != 33) {
        break label413;
      }
      f.nEG.a(462L, 9L, 1L, true);
    }
    for (;;)
    {
      return true;
      if (paramInt != 70) {
        break;
      }
      i = R.l.permission_location_request_again_msg;
      break;
      label413:
      if (paramInt == 97)
      {
        f.nEG.a(462L, 10L, 1L, true);
      }
      else
      {
        f.nEG.a(462L, 11L, 1L, true);
        continue;
        label453:
        this.fht = false;
        h.a(paramActivity, paramActivity.getString(i), paramActivity.getString(R.l.permission_tips_title), paramActivity.getString(R.l.jump_to_settings), paramActivity.getString(R.l.cancel), false, new p.4(this, paramInt, paramActivity), new p.5(this, paramInt, paramActivity));
      }
    }
  }
  
  public final boolean c(Activity paramActivity, Runnable paramRunnable)
  {
    boolean bool = a.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "");
    y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      this.uLJ = paramRunnable;
      return false;
    }
    bool = a.a(paramActivity, "android.permission.READ_PHONE_STATE", 96, "", "");
    y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      this.uLJ = paramRunnable;
      return false;
    }
    y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.uKO));
    g.fx(LauncherUI.uKO);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */