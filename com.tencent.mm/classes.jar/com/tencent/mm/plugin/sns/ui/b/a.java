package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class a
{
  protected Context AsA;
  protected b AsB;
  protected int AsC;
  protected int AsD;
  protected int AsE;
  protected int AsF;
  protected int AsG;
  protected int AsH;
  protected int targetHeight;
  protected int targetWidth;
  protected View view;
  protected ValueAnimator vmS;
  protected boolean zXD;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.AsA = paramActivity;
    this.view = paramView;
    this.zXD = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.AsB = paramb;
  }
  
  public final void at(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.AsC = paramBundle.getInt("param_thumb_left");
    this.AsD = paramBundle.getInt("param_thumb_top");
    this.AsE = paramBundle.getInt("param_thumb_width");
    this.AsF = paramBundle.getInt("param_thumb_height");
    this.targetWidth = paramBundle.getInt("param_target_width");
    this.targetHeight = paramBundle.getInt("param_target_height");
    this.AsG = (this.targetHeight - this.AsF);
    this.AsH = (this.targetWidth - this.AsE);
    ad.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.AsC), Integer.valueOf(this.AsD), Integer.valueOf(this.AsE), Integer.valueOf(this.AsF), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight) });
    AppMethodBeat.o(176405);
  }
  
  public final void eea()
  {
    AppMethodBeat.i(176406);
    if ((this.vmS != null) && (!this.vmS.isStarted()))
    {
      this.vmS.setStartDelay(0L);
      this.vmS.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */