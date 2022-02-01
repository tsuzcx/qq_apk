package android.support.v7.widget;

import java.util.ArrayList;

public abstract class x
{
  private y vT = null;
  private ArrayList<Object> vU = new ArrayList();
  private long vV = 120L;
  private long vW = 120L;
  private long vX = 250L;
  private long vY = 250L;
  private boolean vZ = true;
  
  final void a(y paramy)
  {
    this.vT = paramy;
  }
  
  public abstract boolean a(an paraman);
  
  public abstract boolean a(an paraman, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(an paraman1, an paraman2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean b(an paraman);
  
  public abstract void c(an paraman);
  
  public abstract void cO();
  
  public abstract void cQ();
  
  public final long dU()
  {
    return this.vX;
  }
  
  public final long dV()
  {
    return this.vV;
  }
  
  public final long dW()
  {
    return this.vW;
  }
  
  public final long dX()
  {
    return this.vY;
  }
  
  public final boolean dY()
  {
    return this.vZ;
  }
  
  public final void dZ()
  {
    int j = this.vU.size();
    int i = 0;
    while (i < j)
    {
      this.vU.get(i);
      i += 1;
    }
    this.vU.clear();
  }
  
  public final void g(an paraman)
  {
    if (this.vT != null) {
      this.vT.k(paraman);
    }
  }
  
  public final void h(an paraman)
  {
    if (this.vT != null) {
      this.vT.m(paraman);
    }
  }
  
  public final void i(an paraman)
  {
    if (this.vT != null) {
      this.vT.l(paraman);
    }
  }
  
  public abstract boolean isRunning();
  
  public final void j(an paraman)
  {
    if (this.vT != null) {
      this.vT.n(paraman);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.x
 * JD-Core Version:    0.7.0.1
 */