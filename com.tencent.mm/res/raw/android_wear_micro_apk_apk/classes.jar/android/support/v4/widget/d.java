package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

final class d
{
  int gc;
  final RectF nB = new RectF();
  final Paint nC = new Paint();
  final Paint nD = new Paint();
  final Paint nE = new Paint();
  float nF = 0.0F;
  float nG = 0.0F;
  float nH = 5.0F;
  int[] nI;
  int nJ;
  float nK;
  float nL;
  float nM;
  boolean nN;
  Path nO;
  float nP = 1.0F;
  float nQ;
  int nR;
  int nS;
  int nT = 255;
  float nv = 0.0F;
  
  d()
  {
    this.nC.setStrokeCap(Paint.Cap.SQUARE);
    this.nC.setAntiAlias(true);
    this.nC.setStyle(Paint.Style.STROKE);
    this.nD.setStyle(Paint.Style.FILL);
    this.nD.setAntiAlias(true);
    this.nE.setColor(0);
  }
  
  final void H(int paramInt)
  {
    this.nJ = paramInt;
    this.gc = this.nI[this.nJ];
  }
  
  final int bX()
  {
    return (this.nJ + 1) % this.nI.length;
  }
  
  final int bY()
  {
    return this.nI[this.nJ];
  }
  
  final void bZ()
  {
    this.nK = this.nF;
    this.nL = this.nG;
    this.nM = this.nv;
  }
  
  final void ca()
  {
    this.nK = 0.0F;
    this.nL = 0.0F;
    this.nM = 0.0F;
    this.nF = 0.0F;
    this.nG = 0.0F;
    this.nv = 0.0F;
  }
  
  final void k(boolean paramBoolean)
  {
    if (this.nN != paramBoolean) {
      this.nN = paramBoolean;
    }
  }
  
  final void setStrokeWidth(float paramFloat)
  {
    this.nH = paramFloat;
    this.nC.setStrokeWidth(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */