package com.tencent.soter.core.c;

final class h$1
  implements h.a
{
  private boolean wOV = false;
  
  public final boolean cPs()
  {
    return this.wOV;
  }
  
  public final void cPt()
  {
    d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
    this.wOV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.c.h.1
 * JD-Core Version:    0.7.0.1
 */