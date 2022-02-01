package android.support.v7.widget;

final class ah
  extends v
{
  private ah(RecyclerView paramRecyclerView) {}
  
  public final void onChanged()
  {
    this.vQ.f(null);
    if (RecyclerView.g(this.vQ).hasStableIds())
    {
      ak.a(this.vQ.vC, true);
      RecyclerView.m(this.vQ);
    }
    for (;;)
    {
      if (!this.vQ.uQ.cJ()) {
        this.vQ.requestLayout();
      }
      return;
      ak.a(this.vQ.vC, true);
      RecyclerView.m(this.vQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ah
 * JD-Core Version:    0.7.0.1
 */