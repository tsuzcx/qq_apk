package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean aXh();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int HdV = 3;
    private final float HdW = 1.0F;
    private int HdX = 5000;
    private int HdY = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean aXh()
    {
      this.HdY += 1;
      this.HdX = ((int)(this.HdX + this.HdX * this.HdW));
      return this.HdY < this.HdV;
    }
    
    public final int getTimeout()
    {
      return this.HdX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */