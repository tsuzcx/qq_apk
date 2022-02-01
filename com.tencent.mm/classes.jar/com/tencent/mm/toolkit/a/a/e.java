package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean baF();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int IRl = 3;
    private final float IRm = 1.0F;
    private int IRn = 5000;
    private int IRo = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean baF()
    {
      this.IRo += 1;
      this.IRn = ((int)(this.IRn + this.IRn * this.IRm));
      return this.IRo < this.IRl;
    }
    
    public final int getTimeout()
    {
      return this.IRn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */