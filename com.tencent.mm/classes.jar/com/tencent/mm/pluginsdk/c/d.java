package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.lo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d
  implements k.a
{
  public int Fco = 0;
  
  public final void CA()
  {
    if (this.Fco == 0)
    {
      k localk = cZh();
      if (localk != null) {
        localk.add(this);
      }
    }
    this.Fco += 1;
  }
  
  public final void a(String paramString, m paramm)
  {
    paramm = new lo();
    paramm.dzR.dzS = amh(paramString);
    a.IvT.l(paramm);
  }
  
  public abstract b amh(String paramString);
  
  public abstract k cZh();
  
  public final void unregister()
  {
    if (this.Fco == 0) {}
    k localk;
    do
    {
      do
      {
        return;
        this.Fco -= 1;
      } while (this.Fco != 0);
      localk = cZh();
    } while (localk == null);
    localk.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */