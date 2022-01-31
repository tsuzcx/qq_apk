package android.support.v7.widget;

import java.util.ArrayList;

public abstract class x
{
  private y ud = null;
  private ArrayList<Object> ue = new ArrayList();
  private long uf = 120L;
  private long ug = 120L;
  private long uh = 250L;
  private long ui = 250L;
  private boolean uj = true;
  
  final void a(y paramy)
  {
    this.ud = paramy;
  }
  
  public abstract boolean a(an paraman);
  
  public abstract boolean a(an paraman, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(an paraman1, an paraman2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean b(an paraman);
  
  public abstract void c(an paraman);
  
  public abstract void cG();
  
  public abstract void cI();
  
  public final long dG()
  {
    return this.uh;
  }
  
  public final long dH()
  {
    return this.uf;
  }
  
  public final long dI()
  {
    return this.ug;
  }
  
  public final long dJ()
  {
    return this.ui;
  }
  
  public final boolean dK()
  {
    return this.uj;
  }
  
  public final void dL()
  {
    int j = this.ue.size();
    int i = 0;
    while (i < j)
    {
      this.ue.get(i);
      i += 1;
    }
    this.ue.clear();
  }
  
  public final void g(an paraman)
  {
    if (this.ud != null) {
      this.ud.k(paraman);
    }
  }
  
  public final void h(an paraman)
  {
    if (this.ud != null) {
      this.ud.m(paraman);
    }
  }
  
  public final void i(an paraman)
  {
    if (this.ud != null) {
      this.ud.l(paraman);
    }
  }
  
  public abstract boolean isRunning();
  
  public final void j(an paraman)
  {
    if (this.ud != null) {
      this.ud.n(paraman);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.x
 * JD-Core Version:    0.7.0.1
 */