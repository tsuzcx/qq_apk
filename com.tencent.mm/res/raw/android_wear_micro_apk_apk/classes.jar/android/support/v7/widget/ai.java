package android.support.v7.widget;

import android.view.View;

public abstract class ai
{
  private ab uJ;
  private RecyclerView wa;
  private int wr = -1;
  private boolean ws;
  private boolean wt;
  private View wu;
  private final aj wv = new aj();
  
  protected abstract void a(int paramInt1, int paramInt2, aj paramaj);
  
  final void a(RecyclerView paramRecyclerView, ab paramab)
  {
    this.wa = paramRecyclerView;
    this.uJ = paramab;
    if (this.wr == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    ak.c(this.wa.vC, this.wr);
    this.wt = true;
    this.ws = true;
    int i = this.wr;
    this.wu = RecyclerView.e(this.wa).ar(i);
    RecyclerView.q(this.wa).er();
  }
  
  protected abstract void a(View paramView, aj paramaj);
  
  protected final void aF(View paramView)
  {
    if (RecyclerView.ar(paramView) == this.wr) {
      this.wu = paramView;
    }
  }
  
  public final void aI(int paramInt)
  {
    this.wr = paramInt;
  }
  
  public final ab jdMethod_do()
  {
    return this.uJ;
  }
  
  public final boolean ej()
  {
    return this.ws;
  }
  
  public final int ek()
  {
    return this.wr;
  }
  
  public final int getChildCount()
  {
    return RecyclerView.e(this.wa).getChildCount();
  }
  
  public final boolean isRunning()
  {
    return this.wt;
  }
  
  protected abstract void onStop();
  
  protected final void stop()
  {
    if (!this.wt) {
      return;
    }
    onStop();
    ak.c(this.wa.vC, -1);
    this.wu = null;
    this.wr = -1;
    this.ws = false;
    this.wt = false;
    ab.a(this.uJ, this);
    this.uJ = null;
    this.wa = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ai
 * JD-Core Version:    0.7.0.1
 */