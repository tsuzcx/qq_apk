package android.support.v4.view;

import android.database.DataSetObserver;

final class p
  extends DataSetObserver
  implements ak, al
{
  private int mz;
  
  p(PagerTitleStrip paramPagerTitleStrip) {}
  
  public final void J(int paramInt)
  {
    this.mz = paramInt;
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (paramFloat > 0.5F) {
      i = paramInt + 1;
    }
    this.mA.a(i, paramFloat, false);
  }
  
  public final void bJ()
  {
    float f = 0.0F;
    if (this.mz == 0)
    {
      this.mA.a(this.mA.mk.mY, this.mA.mk.mX);
      if (this.mA.mp >= 0.0F) {
        f = this.mA.mp;
      }
      this.mA.a(this.mA.mk.mY, f, true);
    }
  }
  
  public final void onChanged()
  {
    float f = 0.0F;
    this.mA.a(this.mA.mk.mY, this.mA.mk.mX);
    if (this.mA.mp >= 0.0F) {
      f = this.mA.mp;
    }
    this.mA.a(this.mA.mk.mY, f, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.p
 * JD-Core Version:    0.7.0.1
 */