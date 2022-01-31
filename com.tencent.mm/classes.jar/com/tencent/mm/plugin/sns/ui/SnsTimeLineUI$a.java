package com.tencent.mm.plugin.sns.ui;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;

final class SnsTimeLineUI$a
  extends Animation
{
  ListView lwE;
  float pfQ;
  float pfR;
  float pfS = -1.0F;
  float pfT;
  float pfU = 0.0F;
  private float pfV;
  boolean pfW;
  int pfX;
  boolean pfY = false;
  int pfZ = 0;
  float pga = 0.0F;
  float pgb = 0.0F;
  
  public SnsTimeLineUI$a(SnsTimeLineUI paramSnsTimeLineUI, ListView paramListView)
  {
    this.lwE = paramListView;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (SnsTimeLineUI.m(this.pfC).getVisibility() != 0) {}
    float f;
    do
    {
      return;
      f = this.pfV;
      f = (float)getDuration() * (paramFloat - f);
    } while (f < 2.0F);
    this.pfV = paramFloat;
    SnsTimeLineUI.m(this.pfC).setImageResource(i.i.friendactivity_refresh);
    SnsTimeLineUI.m(this.pfC).setScaleType(QImageView.a.wkM);
    if (((float)getDuration() * paramFloat >= (float)(getDuration() - 600L)) || (this.pfW))
    {
      paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.m(this.pfC).getLayoutParams();
      this.pfU = (paramTransformation.y - f / 3.0F - 1.0F);
      paramTransformation.y = ((int)this.pfU);
      SnsTimeLineUI.m(this.pfC).setLayoutParams(paramTransformation);
    }
    for (;;)
    {
      SnsTimeLineUI.m(this.pfC).invalidate();
      return;
      SnsTimeLineUI.m(this.pfC).getImageMatrix().postRotate(f / 2.5F, this.pfQ, this.pfR);
    }
  }
  
  public final void bJL()
  {
    y.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
    if (SnsTimeLineUI.m(this.pfC).getVisibility() != 0) {
      return;
    }
    init();
    this.pfU = (this.pfS + 20.0F);
    AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.m(this.pfC).getLayoutParams();
    localLayoutParams.y = ((int)this.pfS);
    SnsTimeLineUI.m(this.pfC).setLayoutParams(localLayoutParams);
    bJM();
  }
  
  public final void bJM()
  {
    if (SnsTimeLineUI.m(this.pfC).getVisibility() != 0) {
      return;
    }
    init();
    SnsTimeLineUI.m(this.pfC).clearAnimation();
    SnsTimeLineUI.m(this.pfC).startAnimation(this);
    if (this.pfU >= this.pfS)
    {
      setDuration(20000L);
      this.pfW = false;
      return;
    }
    setDuration(600L);
    this.pfW = true;
  }
  
  final void init()
  {
    if ((this.pfS == -1.0F) || (this.pfR < 0.1D))
    {
      this.pfS = BackwardSupportUtil.b.b(this.pfC, 31.0F);
      this.pfQ = (SnsTimeLineUI.m(this.pfC).getWidth() / 2);
      this.pfR = (SnsTimeLineUI.m(this.pfC).getHeight() / 2);
      this.pfT = (this.pfR * -2.0F - 3.0F);
      y.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.pfT);
      this.pfU = this.pfT;
      if (!this.pfY)
      {
        y.i("MicroMsg.SnsTimeLineUI", "initState");
        this.pfZ = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.m(this.pfC).getLayoutParams()).y;
        this.pga = this.pfS;
        this.pgb = this.pfU;
      }
      this.pfY = true;
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.pfV = 0.0F;
    this.pfU = this.pfS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a
 * JD-Core Version:    0.7.0.1
 */