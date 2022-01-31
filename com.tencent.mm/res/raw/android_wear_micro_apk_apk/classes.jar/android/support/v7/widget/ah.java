package android.support.v7.widget;

final class ah
  extends v
{
  private ah(RecyclerView paramRecyclerView) {}
  
  public final void onChanged()
  {
    this.ua.f(null);
    if (RecyclerView.g(this.ua).hasStableIds())
    {
      ak.a(this.ua.tM, true);
      RecyclerView.m(this.ua);
    }
    for (;;)
    {
      if (!this.ua.ta.cC()) {
        this.ua.requestLayout();
      }
      return;
      ak.a(this.ua.tM, true);
      RecyclerView.m(this.ua);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ah
 * JD-Core Version:    0.7.0.1
 */