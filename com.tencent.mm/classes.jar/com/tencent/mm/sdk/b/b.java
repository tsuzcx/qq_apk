package com.tencent.mm.sdk.b;

public abstract class b
{
  protected boolean IvZ;
  private int Iwa = 0;
  public Runnable callback = null;
  
  final int __getEventID()
  {
    if (this.Iwa == 0) {
      this.Iwa = getClass().getName().hashCode();
    }
    return this.Iwa;
  }
  
  public final boolean fnJ()
  {
    return this.IvZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */