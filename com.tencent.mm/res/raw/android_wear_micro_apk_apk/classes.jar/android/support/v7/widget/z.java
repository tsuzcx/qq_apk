package android.support.v7.widget;

final class z
  implements y
{
  private z(RecyclerView paramRecyclerView) {}
  
  public final void k(an paraman)
  {
    paraman.s(true);
    if ((!RecyclerView.c(this.vQ, paraman.wT)) && (paraman.eE())) {
      this.vQ.removeDetachedView(paraman.wT, false);
    }
  }
  
  public final void l(an paraman)
  {
    paraman.s(true);
    if (!an.y(paraman)) {
      RecyclerView.c(this.vQ, paraman.wT);
    }
  }
  
  public final void m(an paraman)
  {
    paraman.s(true);
    if (!an.y(paraman)) {
      RecyclerView.c(this.vQ, paraman.wT);
    }
  }
  
  public final void n(an paraman)
  {
    paraman.s(true);
    if ((paraman.wY != null) && (paraman.wZ == null))
    {
      paraman.wY = null;
      paraman.setFlags(-65, an.z(paraman));
    }
    paraman.wZ = null;
    if (!an.y(paraman)) {
      RecyclerView.c(this.vQ, paraman.wT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */