package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.kv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

public abstract class d
  implements k.a
{
  public int BNK = 0;
  
  public final void Bu()
  {
    if (this.BNK == 0)
    {
      k localk = cBa();
      if (localk != null) {
        localk.add(this);
      }
    }
    this.BNK += 1;
  }
  
  public final void a(String paramString, m paramm)
  {
    paramm = new kv();
    paramm.dpp.dpq = abU(paramString);
    a.ESL.l(paramm);
  }
  
  public abstract b abU(String paramString);
  
  public abstract k cBa();
  
  public final void unregister()
  {
    if (this.BNK == 0) {}
    k localk;
    do
    {
      do
      {
        return;
        this.BNK -= 1;
      } while (this.BNK != 0);
      localk = cBa();
    } while (localk == null);
    localk.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.d
 * JD-Core Version:    0.7.0.1
 */