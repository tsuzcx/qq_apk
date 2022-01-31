package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class p$6
  implements Runnable
{
  p$6(p paramp, Activity paramActivity) {}
  
  public final void run()
  {
    p localp = this.nMw;
    Activity localActivity = this.val$activity;
    this.val$activity.getString(R.l.app_tip);
    localp.dnm = h.b(localActivity, this.val$activity.getString(R.l.qrcode_reading_file), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        p.6.this.nMw.nMm = false;
        p.6.this.nMw.nMl.set(false);
        p.6.this.nMw.nMn = false;
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.6
 * JD-Core Version:    0.7.0.1
 */