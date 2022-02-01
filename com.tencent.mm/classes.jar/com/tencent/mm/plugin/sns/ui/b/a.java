package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class a
{
  protected int gNU;
  protected int gNV;
  protected ValueAnimator ukk;
  protected View view;
  protected boolean yGl;
  protected Context zaJ;
  protected b zaK;
  protected int zaL;
  protected int zaM;
  protected int zaN;
  protected int zaO;
  protected int zaP;
  protected int zaQ;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.zaJ = paramActivity;
    this.view = paramView;
    this.yGl = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.zaK = paramb;
  }
  
  public final void ao(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.zaL = paramBundle.getInt("param_thumb_left");
    this.zaM = paramBundle.getInt("param_thumb_top");
    this.zaN = paramBundle.getInt("param_thumb_width");
    this.zaO = paramBundle.getInt("param_thumb_height");
    this.gNU = paramBundle.getInt("param_target_width");
    this.gNV = paramBundle.getInt("param_target_height");
    this.zaP = (this.gNV - this.zaO);
    this.zaQ = (this.gNU - this.zaN);
    ac.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.zaL), Integer.valueOf(this.zaM), Integer.valueOf(this.zaN), Integer.valueOf(this.zaO), Integer.valueOf(this.gNU), Integer.valueOf(this.gNV) });
    AppMethodBeat.o(176405);
  }
  
  public final void dRG()
  {
    AppMethodBeat.i(176406);
    if ((this.ukk != null) && (!this.ukk.isStarted()))
    {
      this.ukk.setStartDelay(0L);
      this.ukk.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */