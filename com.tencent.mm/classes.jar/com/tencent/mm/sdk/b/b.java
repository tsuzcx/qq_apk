package com.tencent.mm.sdk.b;

public abstract class b
{
  protected boolean IbR;
  private int IbS = 0;
  public Runnable callback = null;
  
  final int __getEventID()
  {
    if (this.IbS == 0) {
      this.IbS = getClass().getName().hashCode();
    }
    return this.IbS;
  }
  
  public final boolean fjR()
  {
    return this.IbR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */