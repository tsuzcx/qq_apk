package com.tencent.mm.sdk.a;

public abstract class d
{
  public Runnable YK = null;
  protected boolean YS;
  private int YT = 0;
  
  final int ln()
  {
    if (this.YT == 0) {
      this.YT = getClass().getName().hashCode();
    }
    return this.YT;
  }
  
  public final boolean lo()
  {
    return this.YS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */