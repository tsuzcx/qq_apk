package android.support.v7.widget;

import android.view.View;

public abstract class ai
{
  private ab sT;
  private int uC = -1;
  private boolean uD;
  private boolean uE;
  private View uF;
  private final aj uG = new aj();
  private RecyclerView uk;
  
  protected abstract void a(int paramInt1, int paramInt2, aj paramaj);
  
  final void a(RecyclerView paramRecyclerView, ab paramab)
  {
    this.uk = paramRecyclerView;
    this.sT = paramab;
    if (this.uC == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    ak.c(this.uk.tM, this.uC);
    this.uE = true;
    this.uD = true;
    int i = this.uC;
    this.uF = RecyclerView.e(this.uk).af(i);
    RecyclerView.q(this.uk).ed();
  }
  
  protected abstract void a(View paramView, aj paramaj);
  
  public final void aw(int paramInt)
  {
    this.uC = paramInt;
  }
  
  protected final void ay(View paramView)
  {
    if (RecyclerView.ak(paramView) == this.uC) {
      this.uF = paramView;
    }
  }
  
  public final boolean dV()
  {
    return this.uD;
  }
  
  public final int dW()
  {
    return this.uC;
  }
  
  public final ab df()
  {
    return this.sT;
  }
  
  public final int getChildCount()
  {
    return RecyclerView.e(this.uk).getChildCount();
  }
  
  public final boolean isRunning()
  {
    return this.uE;
  }
  
  protected abstract void onStop();
  
  protected final void stop()
  {
    if (!this.uE) {
      return;
    }
    onStop();
    ak.c(this.uk.tM, -1);
    this.uF = null;
    this.uC = -1;
    this.uD = false;
    this.uE = false;
    ab.a(this.sT, this);
    this.sT = null;
    this.uk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ai
 * JD-Core Version:    0.7.0.1
 */