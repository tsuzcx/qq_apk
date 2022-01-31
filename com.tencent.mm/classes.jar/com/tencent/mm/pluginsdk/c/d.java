package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.h.a.jj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

public abstract class d
  implements j.a
{
  public int rSS = 0;
  
  public abstract b Ew(String paramString);
  
  public final void a(String paramString, l paraml)
  {
    paraml = new jj();
    paraml.bRH.bRI = Ew(paramString);
    a.udP.m(paraml);
  }
  
  public abstract j aYb();
  
  public final void adn()
  {
    if (this.rSS == 0)
    {
      j localj = aYb();
      if (localj != null) {
        localj.c(this);
      }
    }
    this.rSS += 1;
  }
  
  public final void unregister()
  {
    if (this.rSS == 0) {}
    j localj;
    do
    {
      do
      {
        return;
        this.rSS -= 1;
      } while (this.rSS != 0);
      localj = aYb();
    } while (localj == null);
    localj.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */