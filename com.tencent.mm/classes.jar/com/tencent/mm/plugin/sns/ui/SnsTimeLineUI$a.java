package com.tencent.mm.plugin.sns.ui;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;

final class SnsTimeLineUI$a
  extends Animation
{
  int DELAY_TIME = 600;
  private ListView list;
  private float rYP;
  private float rYQ;
  float rYR = -1.0F;
  float rYS;
  private float rYT = 50.0F;
  private float rYU = 10.0F;
  float rYV = 0.0F;
  private float rYW = 0.0F;
  private float rYX;
  private float rYY;
  boolean rYZ;
  int rZa;
  boolean rZb = false;
  int rZc = 0;
  float rZd = 0.0F;
  float rZe = 0.0F;
  float rZf = 0.0F;
  float rZg = 0.0F;
  
  public SnsTimeLineUI$a(SnsTimeLineUI paramSnsTimeLineUI, ListView paramListView)
  {
    this.list = paramListView;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(39548);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.t(this.rYv).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.rYZ) });
    }
    if (SnsTimeLineUI.t(this.rYv).getVisibility() != 0)
    {
      AppMethodBeat.o(39548);
      return;
    }
    float f1 = (paramFloat - this.rYX) * (float)getDuration();
    if (f1 < 2.0F)
    {
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
      }
      AppMethodBeat.o(39548);
      return;
    }
    this.rYX = paramFloat;
    SnsTimeLineUI.t(this.rYv).setImageResource(2131231368);
    SnsTimeLineUI.t(this.rYv).setScaleType(QImageView.a.AEx);
    if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.DELAY_TIME)) || (this.rYZ))
    {
      paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.t(this.rYv).getLayoutParams();
      if (paramTransformation.y <= this.rYW)
      {
        AppMethodBeat.o(39548);
        return;
      }
      if (this.rZf == 0.0F)
      {
        this.rZf = (-this.rYW + paramTransformation.y);
        this.rZg = paramTransformation.y;
        this.rYY = paramFloat;
      }
      paramFloat = (paramFloat - this.rYY) / (1.0F - this.rYY);
      f1 = this.rZf * paramFloat;
      float f2 = this.rZg - f1;
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.rYY * (float)getDuration()) });
      }
      if (paramTransformation.y > f2) {
        paramTransformation.y = ((int)f2);
      }
      this.rYV = paramTransformation.y;
      SnsTimeLineUI.t(this.rYv).setLayoutParams(paramTransformation);
    }
    for (;;)
    {
      SnsTimeLineUI.t(this.rYv).invalidate();
      AppMethodBeat.o(39548);
      return;
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
      }
      SnsTimeLineUI.t(this.rYv).getImageMatrix().postRotate(f1 / 2.5F, this.rYP, this.rYQ);
    }
  }
  
  public final void bf(float paramFloat)
  {
    AppMethodBeat.i(39542);
    if (this.list != null)
    {
      if (this.list.getFirstVisiblePosition() != 0) {
        break label122;
      }
      if (SnsTimeLineUI.l(this.rYv).rmc.getTop() >= SnsTimeLineUI.j(this.rYv).rZa) {
        SnsTimeLineUI.b(this.rYv, 0);
      }
    }
    for (;;)
    {
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.rYS), Float.valueOf(this.rYR) });
      }
      if (SnsTimeLineUI.t(this.rYv).getVisibility() == 0) {
        break;
      }
      AppMethodBeat.o(39542);
      return;
      label122:
      SnsTimeLineUI.b(this.rYv, 8);
    }
    SnsTimeLineUI.t(this.rYv).clearAnimation();
    init();
    float f1 = paramFloat;
    if (paramFloat <= -this.rYT) {
      f1 = -this.rYT;
    }
    float f2 = f1;
    if (f1 >= this.rYT) {
      f2 = this.rYT;
    }
    if (f2 < 0.0F)
    {
      this.rYV -= f2 * 2.0F;
      f1 = this.rYV;
      paramFloat = f1;
      if (f1 < this.rYS)
      {
        paramFloat = this.rYS;
        this.rYV = this.rYS;
      }
      f1 = paramFloat;
      if (paramFloat > this.rYR)
      {
        f1 = this.rYR;
        this.rYV = this.rYR;
      }
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.rYS), Float.valueOf(this.rYR), Float.valueOf(this.rYV), Float.valueOf(f1), Float.valueOf(this.rYT) });
      }
      if (f1 != this.rYR) {
        break label455;
      }
    }
    label455:
    for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
    {
      SnsTimeLineUI.t(this.rYv).setScaleType(QImageView.a.AEx);
      SnsTimeLineUI.t(this.rYv).getImageMatrix().postRotate(paramFloat, this.rYP, this.rYQ);
      SnsTimeLineUI.t(this.rYv).setImageResource(2131231368);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.t(this.rYv).getLayoutParams();
      localLayoutParams.y = ((int)f1);
      SnsTimeLineUI.t(this.rYv).setLayoutParams(localLayoutParams);
      SnsTimeLineUI.t(this.rYv).invalidate();
      AppMethodBeat.o(39542);
      return;
      this.rYV -= f2 / 2.0F;
      break;
    }
  }
  
  public final void cwq()
  {
    AppMethodBeat.i(39543);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.d("MicroMsg.RefreshAnim", "animtest playLoading");
    }
    if (SnsTimeLineUI.t(this.rYv).getVisibility() != 0)
    {
      AppMethodBeat.o(39543);
      return;
    }
    init();
    this.rYV = (this.rYR + 20.0F);
    AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.t(this.rYv).getLayoutParams();
    localLayoutParams.y = ((int)this.rYR);
    SnsTimeLineUI.t(this.rYv).setLayoutParams(localLayoutParams);
    cws();
    AppMethodBeat.o(39543);
  }
  
  public final void cwr()
  {
    AppMethodBeat.i(39544);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.t(this.rYv).getVisibility()), Float.valueOf(this.rYV), Float.valueOf(this.rYR) });
    }
    if (SnsTimeLineUI.t(this.rYv).getVisibility() != 0)
    {
      AppMethodBeat.o(39544);
      return;
    }
    init();
    if (this.rYV < this.rYR - this.rYU)
    {
      AppMethodBeat.o(39544);
      return;
    }
    SnsTimeLineUI.t(this.rYv).clearAnimation();
    mg(this.DELAY_TIME + 100);
    SnsTimeLineUI.t(this.rYv).startAnimation(this);
    this.rYZ = false;
    AppMethodBeat.o(39544);
  }
  
  public final void cws()
  {
    AppMethodBeat.i(39546);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
    }
    if (SnsTimeLineUI.t(this.rYv).getVisibility() != 0)
    {
      AppMethodBeat.o(39546);
      return;
    }
    init();
    SnsTimeLineUI.t(this.rYv).clearAnimation();
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.rYV), Float.valueOf(this.rYR), bo.dtY().toString() });
    }
    SnsTimeLineUI.t(this.rYv).startAnimation(this);
    if (this.rYV >= this.rYR - this.rYU)
    {
      mg(20000L);
      this.rYZ = false;
      AppMethodBeat.o(39546);
      return;
    }
    mg(this.DELAY_TIME + 100);
    this.rYZ = true;
    AppMethodBeat.o(39546);
  }
  
  final void init()
  {
    AppMethodBeat.i(39547);
    if ((this.rYR == -1.0F) || (this.rYQ < 0.1D))
    {
      this.rYR = BackwardSupportUtil.b.b(this.rYv, 70.0F);
      this.rYT = BackwardSupportUtil.b.b(this.rYv, 16.0F);
      this.rYP = (SnsTimeLineUI.t(this.rYv).getWidth() / 2);
      this.rYQ = (SnsTimeLineUI.t(this.rYv).getHeight() / 2);
      this.rYW = (-SnsTimeLineUI.t(this.rYv).getHeight() * 2);
      if (this.rYW == 0.0F) {
        this.rYW = (-BackwardSupportUtil.b.b(this.rYv, 40.0F));
      }
      this.rYS = this.rYW;
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.rYS), Float.valueOf(this.rYR), Float.valueOf(this.rYW), Float.valueOf(this.rYT) });
      }
      this.rYV = this.rYS;
      if (!this.rZb)
      {
        if (SnsTimeLineUI.rYc.booleanValue()) {
          ab.i("MicroMsg.RefreshAnim", "initState");
        }
        this.rZc = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.t(this.rYv).getLayoutParams()).y;
        this.rZd = this.rYR;
        this.rZe = this.rYV;
      }
      this.rZb = true;
    }
    AppMethodBeat.o(39547);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39549);
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { bo.dtY().toString() });
    }
    this.rYX = 0.0F;
    this.rYY = 0.0F;
    this.rZf = 0.0F;
    this.rZg = 0.0F;
    AppMethodBeat.o(39549);
  }
  
  final void mg(long paramLong)
  {
    AppMethodBeat.i(39545);
    if (SnsTimeLineUI.rYc.booleanValue()) {
      ab.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), bo.dtY().toString() });
    }
    setDuration(paramLong);
    AppMethodBeat.o(39545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a
 * JD-Core Version:    0.7.0.1
 */