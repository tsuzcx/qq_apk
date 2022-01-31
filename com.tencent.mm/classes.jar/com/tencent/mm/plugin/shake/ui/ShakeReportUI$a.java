package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;
import java.lang.ref.WeakReference;

final class ShakeReportUI$a
  extends c.a
{
  private final long[] eTU = { 300L, 200L, 300L, 200L };
  private long iam = bk.UZ();
  private Vibrator ibr;
  WeakReference<ShakeReportUI> ods;
  
  public ShakeReportUI$a(ShakeReportUI paramShakeReportUI)
  {
    this.ods = new WeakReference(paramShakeReportUI);
  }
  
  public final void bnY()
  {
    ShakeReportUI localShakeReportUI = (ShakeReportUI)this.ods.get();
    if (localShakeReportUI == null) {
      return;
    }
    if (localShakeReportUI.isFinishing())
    {
      y.e("MicroMsg.ShakeReportUI", "ui finished");
      return;
    }
    if (!ShakeReportUI.u(localShakeReportUI))
    {
      y.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
      return;
    }
    ShakeReportUI.v(localShakeReportUI);
    long l = bk.cp(this.iam);
    if (l < 1200L)
    {
      y.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + l);
      return;
    }
    y.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + l);
    this.iam = bk.UZ();
    Object localObject;
    if (ShakeReportUI.w(localShakeReportUI) != null)
    {
      localObject = ShakeReportUI.w(localShakeReportUI);
      if (((c)localObject).view != null) {
        ((c)localObject).view.setKeepScreenOn(true);
      }
      ((c)localObject).byQ.S(30000L, 30000L);
    }
    if (ShakeReportUI.q(localShakeReportUI) != null)
    {
      localObject = ShakeReportUI.q(localShakeReportUI);
      if (((f)localObject).lXp != null) {
        ((f)localObject).lXp.dismiss();
      }
    }
    if (ShakeReportUI.x(localShakeReportUI))
    {
      localObject = (ShakeReportUI)this.ods.get();
      if (localObject != null) {
        au.G((Context)localObject, R.l.shake_sound_male);
      }
    }
    for (;;)
    {
      reset();
      ShakeReportUI.y(localShakeReportUI);
      return;
      localObject = (ShakeReportUI)this.ods.get();
      if (localObject != null)
      {
        if (this.ibr == null) {
          this.ibr = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
        }
        if (this.ibr != null) {
          this.ibr.vibrate(this.eTU, -1);
        }
      }
    }
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.a
 * JD-Core Version:    0.7.0.1
 */