package com.tencent.mm.pluginsdk.location;

public final class b
{
  public int bRv;
  public float elk;
  public float ell;
  public long itemId;
  public int scene;
  
  public b(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.elk = paramFloat1;
    this.ell = paramFloat2;
    this.bRv = paramInt1;
    this.scene = paramInt2;
    this.itemId = paramLong;
  }
  
  public final String toString()
  {
    return String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.elk * 1000000.0F)), Integer.valueOf((int)(this.ell * 1000000.0F)), Integer.valueOf(this.bRv) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.b
 * JD-Core Version:    0.7.0.1
 */