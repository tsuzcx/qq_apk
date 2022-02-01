package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean cgX();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int adth = 3;
    private final float adti = 1.0F;
    private int adtj = 5000;
    private int adtk = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean cgX()
    {
      this.adtk += 1;
      this.adtj = ((int)(this.adtj + this.adtj * this.adti));
      return this.adtk < this.adth;
    }
    
    public final int getTimeout()
    {
      return this.adtj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */