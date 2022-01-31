package com.tencent.mm.sdk.b;

public abstract class b
{
  public Runnable callback = null;
  protected boolean ymq;
  private int ymr = 0;
  
  final int __getEventID()
  {
    if (this.ymr == 0) {
      this.ymr = getClass().getName().hashCode();
    }
    return this.ymr;
  }
  
  public final boolean dsj()
  {
    return this.ymq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */