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
  protected Context ETH;
  protected b ETI;
  protected int ETJ;
  protected int ETK;
  protected int ETL;
  protected int ETM;
  protected int ETN;
  protected int ETO;
  protected boolean Exy;
  protected int targetHeight;
  protected int targetWidth;
  protected View view;
  protected ValueAnimator yTl;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.ETH = paramActivity;
    this.view = paramView;
    this.Exy = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.ETI = paramb;
  }
  
  public final void aG(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.ETJ = paramBundle.getInt("param_thumb_left");
    this.ETK = paramBundle.getInt("param_thumb_top");
    this.ETL = paramBundle.getInt("param_thumb_width");
    this.ETM = paramBundle.getInt("param_thumb_height");
    this.targetWidth = paramBundle.getInt("param_target_width");
    this.targetHeight = paramBundle.getInt("param_target_height");
    this.ETN = (this.targetHeight - this.ETM);
    this.ETO = (this.targetWidth - this.ETL);
    Log.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.ETJ), Integer.valueOf(this.ETK), Integer.valueOf(this.ETL), Integer.valueOf(this.ETM), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight) });
    AppMethodBeat.o(176405);
  }
  
  public void fkj()
  {
    AppMethodBeat.i(176406);
    if ((this.yTl != null) && (!this.yTl.isStarted()))
    {
      this.yTl.setStartDelay(0L);
      this.yTl.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */