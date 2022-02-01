package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean aQp();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int FES = 3;
    private final float FET = 1.0F;
    private int FEU = 5000;
    private int FEV = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean aQp()
    {
      this.FEV += 1;
      this.FEU = ((int)(this.FEU + this.FEU * this.FET));
      return this.FEV < this.FES;
    }
    
    public final int getTimeout()
    {
      return this.FEU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */