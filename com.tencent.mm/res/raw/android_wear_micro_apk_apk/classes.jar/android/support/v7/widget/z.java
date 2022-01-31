package android.support.v7.widget;

final class z
  implements y
{
  private z(RecyclerView paramRecyclerView) {}
  
  public final void k(an paraman)
  {
    paraman.p(true);
    if ((!RecyclerView.c(this.ua, paraman.ve)) && (paraman.ep())) {
      this.ua.removeDetachedView(paraman.ve, false);
    }
  }
  
  public final void l(an paraman)
  {
    paraman.p(true);
    if (!an.x(paraman)) {
      RecyclerView.c(this.ua, paraman.ve);
    }
  }
  
  public final void m(an paraman)
  {
    paraman.p(true);
    if (!an.x(paraman)) {
      RecyclerView.c(this.ua, paraman.ve);
    }
  }
  
  public final void n(an paraman)
  {
    paraman.p(true);
    if ((paraman.vj != null) && (paraman.vk == null))
    {
      paraman.vj = null;
      paraman.setFlags(-65, an.y(paraman));
    }
    paraman.vk = null;
    if (!an.x(paraman)) {
      RecyclerView.c(this.ua, paraman.ve);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.z
 * JD-Core Version:    0.7.0.1
 */