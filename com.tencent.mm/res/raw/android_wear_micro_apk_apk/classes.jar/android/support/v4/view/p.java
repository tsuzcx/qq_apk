package android.support.v4.view;

import android.database.DataSetObserver;

final class p
  extends DataSetObserver
  implements ak, al
{
  private int kD;
  
  p(PagerTitleStrip paramPagerTitleStrip) {}
  
  public final void a(int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (paramFloat > 0.5F) {
      i = paramInt + 1;
    }
    this.kE.a(i, paramFloat, false);
  }
  
  public final void bs()
  {
    float f = 0.0F;
    if (this.kD == 0)
    {
      this.kE.a(this.kE.kn.lc, this.kE.kn.lb);
      if (this.kE.ks >= 0.0F) {
        f = this.kE.ks;
      }
      this.kE.a(this.kE.kn.lc, f, true);
    }
  }
  
  public final void onChanged()
  {
    float f = 0.0F;
    this.kE.a(this.kE.kn.lc, this.kE.kn.lb);
    if (this.kE.ks >= 0.0F) {
      f = this.kE.ks;
    }
    this.kE.a(this.kE.kn.lc, f, true);
  }
  
  public final void y(int paramInt)
  {
    this.kD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.p
 * JD-Core Version:    0.7.0.1
 */