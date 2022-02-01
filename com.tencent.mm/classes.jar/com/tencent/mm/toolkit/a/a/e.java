package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean bbe();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int JlT = 3;
    private final float JlU = 1.0F;
    private int JlV = 5000;
    private int JlW = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean bbe()
    {
      this.JlW += 1;
      this.JlV = ((int)(this.JlV + this.JlV * this.JlU));
      return this.JlW < this.JlT;
    }
    
    public final int getTimeout()
    {
      return this.JlV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */