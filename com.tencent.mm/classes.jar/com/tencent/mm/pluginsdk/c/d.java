package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.ln;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d
  implements k.a
{
  public int EJQ = 0;
  
  public final void Cx()
  {
    if (this.EJQ == 0)
    {
      k localk = cWC();
      if (localk != null) {
        localk.add(this);
      }
    }
    this.EJQ += 1;
  }
  
  public final void a(String paramString, m paramm)
  {
    paramm = new ln();
    paramm.dyM.dyN = alj(paramString);
    a.IbL.l(paramm);
  }
  
  public abstract b alj(String paramString);
  
  public abstract k cWC();
  
  public final void unregister()
  {
    if (this.EJQ == 0) {}
    k localk;
    do
    {
      do
      {
        return;
        this.EJQ -= 1;
      } while (this.EJQ != 0);
      localk = cWC();
    } while (localk == null);
    localk.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */