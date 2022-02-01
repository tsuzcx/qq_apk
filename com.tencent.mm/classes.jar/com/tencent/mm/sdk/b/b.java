package com.tencent.mm.sdk.b;

public abstract class b
{
  protected boolean Gqe;
  private int Gqf = 0;
  public Runnable callback = null;
  
  final int __getEventID()
  {
    if (this.Gqf == 0) {
      this.Gqf = getClass().getName().hashCode();
    }
    return this.Gqf;
  }
  
  public final boolean eUo()
  {
    return this.Gqe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */