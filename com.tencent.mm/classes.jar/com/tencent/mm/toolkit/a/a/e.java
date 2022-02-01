package com.tencent.mm.toolkit.a.a;

public abstract interface e
{
  public abstract boolean bws();
  
  public abstract int getTimeout();
  
  public static final class a
    implements e
  {
    private final int OvM = 3;
    private final float OvN = 1.0F;
    private int OvO = 5000;
    private int OvP = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
    
    public final boolean bws()
    {
      this.OvP += 1;
      this.OvO = ((int)(this.OvO + this.OvO * this.OvN));
      return this.OvP < this.OvM;
    }
    
    public final int getTimeout()
    {
      return this.OvO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.a.e
 * JD-Core Version:    0.7.0.1
 */