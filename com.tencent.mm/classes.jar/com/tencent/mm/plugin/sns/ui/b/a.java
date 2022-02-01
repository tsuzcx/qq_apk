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
  protected int gnh;
  protected int gni;
  protected ValueAnimator tbV;
  protected View view;
  protected Context xNT;
  protected b xNU;
  protected int xNV;
  protected int xNW;
  protected int xNX;
  protected int xNY;
  protected int xNZ;
  protected int xOa;
  protected boolean xtv;
  
  public a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.xNT = paramActivity;
    this.view = paramView;
    this.xtv = paramBoolean;
  }
  
  public final void a(b paramb)
  {
    this.xNU = paramb;
  }
  
  public final void aj(Bundle paramBundle)
  {
    AppMethodBeat.i(176405);
    this.xNV = paramBundle.getInt("param_thumb_left");
    this.xNW = paramBundle.getInt("param_thumb_top");
    this.xNX = paramBundle.getInt("param_thumb_width");
    this.xNY = paramBundle.getInt("param_thumb_height");
    this.gnh = paramBundle.getInt("param_target_width");
    this.gni = paramBundle.getInt("param_target_height");
    this.xNZ = (this.gni - this.xNY);
    this.xOa = (this.gnh - this.xNX);
    ad.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", new Object[] { Integer.valueOf(this.xNV), Integer.valueOf(this.xNW), Integer.valueOf(this.xNX), Integer.valueOf(this.xNY), Integer.valueOf(this.gnh), Integer.valueOf(this.gni) });
    AppMethodBeat.o(176405);
  }
  
  public final void dDj()
  {
    AppMethodBeat.i(176406);
    if ((this.tbV != null) && (!this.tbV.isStarted()))
    {
      this.tbV.setStartDelay(0L);
      this.tbV.start();
    }
    AppMethodBeat.o(176406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a
 * JD-Core Version:    0.7.0.1
 */