package com.tencent.mm.plugin.sns.ad.widget.gllib;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.Matrix;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  private float QfS;
  private float QfT;
  private float QfU;
  public float QfV;
  public float QfW;
  private float QfX;
  private float QfY;
  public boolean QfZ;
  public float ccT;
  public float ceS;
  public float ceT;
  public float ceV;
  public float ceW;
  private float ceX;
  public float ceY;
  private float mAlpha;
  protected float mLeft;
  private float[] mQb;
  protected float mTop;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310129);
    this.ceS = 0.0F;
    this.ceT = 0.0F;
    this.QfS = 0.0F;
    this.QfT = 0.0F;
    this.ceV = 1.0F;
    this.ceW = 1.0F;
    this.QfU = 1.0F;
    this.ccT = 0.0F;
    this.ceX = 0.0F;
    this.ceY = 0.0F;
    this.QfV = 0.0F;
    this.QfW = 0.0F;
    this.QfX = 0.0F;
    this.QfY = 0.0F;
    this.QfZ = false;
    this.mLeft = 0.0F;
    this.mTop = 0.0F;
    this.mAlpha = 1.0F;
    this.mQb = new float[16];
    AppMethodBeat.o(310129);
  }
  
  private float dh(float paramFloat)
  {
    AppMethodBeat.i(310133);
    paramFloat /= hcR() * 0.5F;
    AppMethodBeat.o(310133);
    return paramFloat;
  }
  
  private float getX()
  {
    return this.mLeft + this.ceS;
  }
  
  private float getY()
  {
    return this.mTop + this.ceT;
  }
  
  public final void A(Rect paramRect)
  {
    AppMethodBeat.i(310170);
    Rect localRect1 = null;
    if (this.QfQ != null) {
      localRect1 = this.QfQ.getGlobalVisibleRect();
    }
    Rect localRect2 = localRect1;
    if (localRect1 == null) {
      localRect2 = new Rect();
    }
    paramRect.left = ((int)getX() + localRect2.left);
    int i = (int)getY();
    localRect2.top += i;
    paramRect.right = ((int)(paramRect.left + this.mWidth));
    paramRect.bottom = ((int)(paramRect.top + this.mHeight));
    AppMethodBeat.o(310170);
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310159);
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    setSize(paramInt3 - paramInt1, paramInt4 - paramInt2);
    AppMethodBeat.o(310159);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(310155);
    this.mLeft = parama.leftMargin;
    this.mTop = parama.topMargin;
    setSize(parama.width, parama.height);
    AppMethodBeat.o(310155);
  }
  
  public final void di(float paramFloat)
  {
    AppMethodBeat.i(310176);
    this.QfR = paramFloat;
    requestLayout();
    invalidate();
    AppMethodBeat.o(310176);
  }
  
  protected final float hcS()
  {
    return this.mAlpha;
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(310164);
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.mAlpha = f;
      invalidate();
      AppMethodBeat.o(310164);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public final float[] z(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(310148);
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(this.mQb, 0);
    float f1 = -(wR() - this.mWidth) / hcR();
    float f2 = (ejW() - this.mHeight) / hcR();
    this.QfS = (f1 + dh(this.ceS + this.mLeft));
    this.QfT = (f2 - dh(this.ceT + this.mTop));
    float f3;
    float f4;
    float f5;
    if (this.QfZ)
    {
      f1 = -(this.QfV - (getX() + this.mWidth / 2.0F) + this.ceS);
      f2 = this.QfW;
      f3 = getY();
      f4 = this.mHeight / 2.0F;
      f5 = this.ceT;
      this.QfX = dh(f1);
    }
    for (this.QfY = dh(f2 - (f3 + f4) + f5);; this.QfY = 0.0F)
    {
      Matrix.translateM(this.mQb, 0, this.QfS, this.QfT, 0.0F);
      Matrix.rotateM(this.mQb, 0, this.ceX, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.mQb, 0, this.ceY, 0.0F, 1.0F, 0.0F);
      Matrix.translateM(this.mQb, 0, -this.QfX, -this.QfY, 0.0F);
      Matrix.rotateM(this.mQb, 0, this.ccT, 0.0F, 0.0F, 1.0F);
      Matrix.translateM(this.mQb, 0, this.QfX, this.QfY, 0.0F);
      Matrix.scaleM(this.mQb, 0, this.ceV, this.ceW, this.QfU);
      Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat, 0, this.mQb, 0);
      AppMethodBeat.o(310148);
      return arrayOfFloat;
      this.QfX = 0.0F;
    }
  }
  
  public static final class a
    extends FrameLayout.LayoutParams
  {
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.gllib.b
 * JD-Core Version:    0.7.0.1
 */