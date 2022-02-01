package android.support.v4.app;

import java.util.ArrayList;

final class ad
  implements n
{
  private final boolean eU;
  private final e eV;
  private int eW;
  
  ad(e parame, boolean paramBoolean)
  {
    this.eU = paramBoolean;
    this.eV = parame;
  }
  
  public final boolean aB()
  {
    return this.eW == 0;
  }
  
  public final void aC()
  {
    boolean bool1 = false;
    if (this.eW > 0) {}
    for (int i = 1;; i = 0)
    {
      localu = this.eV.bA;
      int k = localu.dZ.size();
      int j = 0;
      while (j < k)
      {
        localObject = (Fragment)localu.dZ.get(j);
        ((Fragment)localObject).b(null);
        if ((i != 0) && (((Fragment)localObject).E())) {
          ((Fragment)localObject).startPostponedEnterTransition();
        }
        j += 1;
      }
    }
    u localu = this.eV.bA;
    Object localObject = this.eV;
    boolean bool2 = this.eU;
    if (i == 0) {
      bool1 = true;
    }
    u.a(localu, (e)localObject, bool2, bool1, true);
  }
  
  public final void aD()
  {
    u.a(this.eV.bA, this.eV, this.eU, false, false);
  }
  
  public final void ag()
  {
    this.eW -= 1;
    if (this.eW != 0) {
      return;
    }
    u.b(this.eV.bA);
  }
  
  public final void startListening()
  {
    this.eW += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ad
 * JD-Core Version:    0.7.0.1
 */