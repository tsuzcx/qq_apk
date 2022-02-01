package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean bHz();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int VPc = 3;
    private final float VPd = 1.0F;
    private int VPe = 5000;
    private int VPf = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean bHz()
    {
      this.VPf += 1;
      this.VPe = ((int)(this.VPe + this.VPe * this.VPd));
      return this.VPf < this.VPc;
    }
    
    public final int getTimeout()
    {
      return this.VPe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */