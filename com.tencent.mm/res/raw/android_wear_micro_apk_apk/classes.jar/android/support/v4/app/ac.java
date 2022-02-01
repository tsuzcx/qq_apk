package android.support.v4.app;

import java.util.ArrayList;

final class ac
  implements ab
{
  final int eS;
  final int eT;
  final String mName = null;
  
  ac(u paramu, int paramInt1, int paramInt2)
  {
    this.eS = paramInt1;
    this.eT = 1;
  }
  
  public final boolean a(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((this.eD.ek != null) && (this.eS < 0) && (this.mName == null))
    {
      u localu = this.eD.ek.cK;
      if ((localu != null) && (localu.popBackStackImmediate())) {
        return false;
      }
    }
    return this.eD.a(paramArrayList, paramArrayList1, this.mName, this.eS, this.eT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ac
 * JD-Core Version:    0.7.0.1
 */