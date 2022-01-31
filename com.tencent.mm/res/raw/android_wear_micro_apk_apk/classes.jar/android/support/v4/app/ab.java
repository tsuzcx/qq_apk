package android.support.v4.app;

import java.util.ArrayList;

final class ab
  implements m
{
  private final boolean dg;
  private final d dh;
  private int di;
  
  ab(d paramd, boolean paramBoolean)
  {
    this.dg = paramBoolean;
    this.dh = paramd;
  }
  
  public final void Q()
  {
    this.di -= 1;
    if (this.di != 0) {
      return;
    }
    t.b(this.dh.R);
  }
  
  public final boolean am()
  {
    return this.di == 0;
  }
  
  public final void an()
  {
    boolean bool1 = false;
    if (this.di > 0) {}
    for (int i = 1;; i = 0)
    {
      localt = this.dh.R;
      int k = localt.cq.size();
      int j = 0;
      while (j < k)
      {
        localObject = (Fragment)localt.cq.get(j);
        ((Fragment)localObject).b(null);
        if ((i != 0) && (((Fragment)localObject).k())) {
          ((Fragment)localObject).startPostponedEnterTransition();
        }
        j += 1;
      }
    }
    t localt = this.dh.R;
    Object localObject = this.dh;
    boolean bool2 = this.dg;
    if (i == 0) {
      bool1 = true;
    }
    t.a(localt, (d)localObject, bool2, bool1, true);
  }
  
  public final void ao()
  {
    t.a(this.dh.R, this.dh, this.dg, false, false);
  }
  
  public final void startListening()
  {
    this.di += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ab
 * JD-Core Version:    0.7.0.1
 */