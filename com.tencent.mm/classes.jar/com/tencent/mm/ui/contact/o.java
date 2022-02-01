package com.tencent.mm.ui.contact;

public abstract class o
  extends p
{
  public a PWf;
  
  public o(n paramn, boolean paramBoolean, int paramInt)
  {
    super(paramn, paramBoolean, paramInt);
  }
  
  public void a(a parama)
  {
    this.PWf = parama;
  }
  
  public abstract void b(String paramString, int[] paramArrayOfInt);
  
  public int bnr(String paramString)
  {
    return -1;
  }
  
  public int bnw(String paramString)
  {
    return -1;
  }
  
  public abstract void clearData();
  
  public boolean gUN()
  {
    return false;
  }
  
  public String gUO()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void B(String paramString, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.o
 * JD-Core Version:    0.7.0.1
 */