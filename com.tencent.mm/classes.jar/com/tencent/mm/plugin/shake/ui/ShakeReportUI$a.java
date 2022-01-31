package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.o;
import java.lang.ref.WeakReference;

final class ShakeReportUI$a
  extends d.a
{
  private final long[] glS;
  private Vibrator kqP;
  private long lastShakeTime;
  WeakReference<ShakeReportUI> qRz;
  
  public ShakeReportUI$a(ShakeReportUI paramShakeReportUI)
  {
    AppMethodBeat.i(24812);
    this.lastShakeTime = bo.yB();
    this.glS = new long[] { 300L, 200L, 300L, 200L };
    this.qRz = new WeakReference(paramShakeReportUI);
    AppMethodBeat.o(24812);
  }
  
  public final void onRelease() {}
  
  public final void onShake(boolean paramBoolean)
  {
    AppMethodBeat.i(153646);
    ShakeReportUI localShakeReportUI = (ShakeReportUI)this.qRz.get();
    if (localShakeReportUI == null)
    {
      AppMethodBeat.o(153646);
      return;
    }
    if (localShakeReportUI.isFinishing())
    {
      ab.e("MicroMsg.ShakeReportUI", "ui finished");
      AppMethodBeat.o(153646);
      return;
    }
    if (!ShakeReportUI.v(localShakeReportUI))
    {
      ab.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
      AppMethodBeat.o(153646);
      return;
    }
    ShakeReportUI.w(localShakeReportUI);
    long l = bo.av(this.lastShakeTime);
    if (l < 1200L)
    {
      ab.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:".concat(String.valueOf(l)));
      AppMethodBeat.o(153646);
      return;
    }
    ab.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:".concat(String.valueOf(l)));
    this.lastShakeTime = bo.yB();
    Object localObject;
    if (ShakeReportUI.x(localShakeReportUI) != null)
    {
      localObject = ShakeReportUI.x(localShakeReportUI);
      if (((c)localObject).view != null) {
        ((c)localObject).view.setKeepScreenOn(true);
      }
      ((c)localObject).caS.ag(30000L, 30000L);
    }
    if (ShakeReportUI.y(localShakeReportUI) != null)
    {
      localObject = ShakeReportUI.y(localShakeReportUI);
      if (((f)localObject).vQH != null) {
        ((f)localObject).vQH.dismiss();
      }
    }
    if (ShakeReportUI.z(localShakeReportUI))
    {
      localObject = (ShakeReportUI)this.qRz.get();
      if (localObject != null) {
        ay.ax((Context)localObject, 2131303636);
      }
    }
    for (;;)
    {
      reset();
      ShakeReportUI.A(localShakeReportUI);
      AppMethodBeat.o(153646);
      return;
      localObject = (ShakeReportUI)this.qRz.get();
      if (localObject != null)
      {
        if (this.kqP == null) {
          this.kqP = ((Vibrator)((ShakeReportUI)localObject).getSystemService("vibrator"));
        }
        if (this.kqP != null) {
          this.kqP.vibrate(this.glS, -1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.a
 * JD-Core Version:    0.7.0.1
 */