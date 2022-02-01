package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a
{
  protected ValueAnimator Exi;
  protected boolean KLr;
  protected Context LhJ;
  protected b LhK;
  protected int LhL;
  protected int LhM;
  protected int LhN;
  protected int LhO;
  protected int LhP;
  protected int LhQ;
  protected int targetHeight;
  protected int targetWidth;
  protected View view;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.LhJ = paramActivity;
    this.view = paramView;
    this.KLr = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.LhK = paramb;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.LhL = paramBundle.getInt("param_thumb_left");
    this.LhM = paramBundle.getInt("param_thumb_top");
    this.LhN = paramBundle.getInt("param_thumb_width");
    this.LhO = paramBundle.getInt("param_thumb_height");
    this.targetWidth = paramBundle.getInt("param_target_width");
    this.targetHeight = paramBundle.getInt("param_target_height");
    this.LhP = (this.targetHeight - this.LhO);
    this.LhQ = (this.targetWidth - this.LhN);
    Log.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.LhL), Integer.valueOf(this.LhM), Integer.valueOf(this.LhN), Integer.valueOf(this.LhO), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight) });
    AppMethodBeat.o(176405);
  }
  
  public void fYs()
  {
    AppMethodBeat.i(176406);
    if ((this.Exi != null) && (!this.Exi.isStarted()))
    {
      this.Exi.setStartDelay(0L);
      this.Exi.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */