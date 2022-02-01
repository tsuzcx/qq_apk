package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d
  implements k.a
{
  public int DfU = 0;
  
  public final void AY()
  {
    if (this.DfU == 0)
    {
      k localk = cOj();
      if (localk != null) {
        localk.add(this);
      }
    }
    this.DfU += 1;
  }
  
  public final void a(String paramString, m paramm)
  {
    paramm = new le();
    paramm.dmY.dmZ = agM(paramString);
    a.GpY.l(paramm);
  }
  
  public abstract b agM(String paramString);
  
  public abstract k cOj();
  
  public final void unregister()
  {
    if (this.DfU == 0) {}
    k localk;
    do
    {
      do
      {
        return;
        this.DfU -= 1;
      } while (this.DfU != 0);
      localk = cOj();
    } while (localk == null);
    localk.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */