package com.tencent.mm.sdk.a;

public abstract class d
{
  public Runnable WP = null;
  protected boolean WQ;
  private int WR = 0;
  
  final int lb()
  {
    if (this.WR == 0) {
      this.WR = getClass().getName().hashCode();
    }
    return this.WR;
  }
  
  public final boolean lc()
  {
    return this.WQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */