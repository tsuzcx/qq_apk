package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d
  implements k.a
{
  public int vJQ = 0;
  
  public abstract b PL(String paramString);
  
  public final void a(String paramString, m paramm)
  {
    paramm = new js();
    paramm.czj.czk = PL(paramString);
    a.ymk.l(paramm);
  }
  
  public abstract k bEO();
  
  public final void uD()
  {
    if (this.vJQ == 0)
    {
      k localk = bEO();
      if (localk != null) {
        localk.add(this);
      }
    }
    this.vJQ += 1;
  }
  
  public final void unregister()
  {
    if (this.vJQ == 0) {}
    k localk;
    do
    {
      do
      {
        return;
        this.vJQ -= 1;
      } while (this.vJQ != 0);
      localk = bEO();
    } while (localk == null);
    localk.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */