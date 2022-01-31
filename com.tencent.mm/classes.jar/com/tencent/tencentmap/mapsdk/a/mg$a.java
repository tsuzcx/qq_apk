package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

class mg$a
  extends Thread
{
  private final WeakReference<mg> a;
  private final String b;
  private final int c;
  
  public mg$a(mg parammg, String paramString, int paramInt)
  {
    this.a = new WeakReference(parammg);
    this.b = paramString;
    this.c = paramInt;
  }
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      mg localmg = (mg)this.a.get();
      mg.a(localmg, this.b, this.c);
      mg.a(localmg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mg.a
 * JD-Core Version:    0.7.0.1
 */