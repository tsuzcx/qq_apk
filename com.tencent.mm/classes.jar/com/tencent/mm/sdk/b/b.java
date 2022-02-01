package com.tencent.mm.sdk.b;

public abstract class b
{
  protected boolean ESR;
  private int ESS = 0;
  public Runnable callback = null;
  
  final int __getEventID()
  {
    if (this.ESS == 0) {
      this.ESS = getClass().getName().hashCode();
    }
    return this.ESS;
  }
  
  public final boolean eEU()
  {
    return this.ESR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */