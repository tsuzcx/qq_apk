package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

final class d
{
  int hY;
  float pA;
  boolean pB;
  Path pC;
  float pD = 1.0F;
  float pE;
  int pF;
  int pG;
  int pH = 255;
  float pj = 0.0F;
  final RectF pp = new RectF();
  final Paint pq = new Paint();
  final Paint pr = new Paint();
  final Paint ps = new Paint();
  float pt = 0.0F;
  float pu = 0.0F;
  float pv = 5.0F;
  int[] pw;
  int px;
  float py;
  float pz;
  
  d()
  {
    this.pq.setStrokeCap(Paint.Cap.SQUARE);
    this.pq.setAntiAlias(true);
    this.pq.setStyle(Paint.Style.STROKE);
    this.pr.setStyle(Paint.Style.FILL);
    this.pr.setAntiAlias(true);
    this.ps.setColor(0);
  }
  
  final void S(int paramInt)
  {
    this.px = paramInt;
    this.hY = this.pw[this.px];
  }
  
  final int cb()
  {
    return (this.px + 1) % this.pw.length;
  }
  
  final int cc()
  {
    return this.pw[this.px];
  }
  
  final void cd()
  {
    this.py = this.pt;
    this.pz = this.pu;
    this.pA = this.pj;
  }
  
  final void ce()
  {
    this.py = 0.0F;
    this.pz = 0.0F;
    this.pA = 0.0F;
    this.pt = 0.0F;
    this.pu = 0.0F;
    this.pj = 0.0F;
  }
  
  final void n(boolean paramBoolean)
  {
    if (this.pB != paramBoolean) {
      this.pB = paramBoolean;
    }
  }
  
  final void setStrokeWidth(float paramFloat)
  {
    this.pv = paramFloat;
    this.pq.setStrokeWidth(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */