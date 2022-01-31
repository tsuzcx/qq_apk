package android.support.v4.app;

import java.util.ArrayList;

final class aa
  implements z
{
  final int de;
  final int df;
  final String mName = null;
  
  aa(t paramt, int paramInt1, int paramInt2)
  {
    this.de = paramInt1;
    this.df = 1;
  }
  
  public final boolean a(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((this.cU.cB != null) && (this.de < 0) && (this.mName == null))
    {
      t localt = this.cU.cB.ba;
      if ((localt != null) && (localt.popBackStackImmediate())) {
        return false;
      }
    }
    return this.cU.a(paramArrayList, paramArrayList1, this.mName, this.de, this.df);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.aa
 * JD-Core Version:    0.7.0.1
 */