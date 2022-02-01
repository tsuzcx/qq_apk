package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class a
{
  protected Context AJO;
  protected b AJP;
  protected int AJQ;
  protected int AJR;
  protected int AJS;
  protected int AJT;
  protected int AJU;
  protected int AJV;
  protected boolean AoO;
  protected int targetHeight;
  protected int targetWidth;
  protected View view;
  protected ValueAnimator vyX;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.AJO = paramActivity;
    this.view = paramView;
    this.AoO = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.AJP = paramb;
  }
  
  public final void au(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.AJQ = paramBundle.getInt("param_thumb_left");
    this.AJR = paramBundle.getInt("param_thumb_top");
    this.AJS = paramBundle.getInt("param_thumb_width");
    this.AJT = paramBundle.getInt("param_thumb_height");
    this.targetWidth = paramBundle.getInt("param_target_width");
    this.targetHeight = paramBundle.getInt("param_target_height");
    this.AJU = (this.targetHeight - this.AJT);
    this.AJV = (this.targetWidth - this.AJS);
    ae.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.AJQ), Integer.valueOf(this.AJR), Integer.valueOf(this.AJS), Integer.valueOf(this.AJT), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight) });
    AppMethodBeat.o(176405);
  }
  
  public final void ehH()
  {
    AppMethodBeat.i(176406);
    if ((this.vyX != null) && (!this.vyX.isStarted()))
    {
      this.vyX.setStartDelay(0L);
      this.vyX.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */