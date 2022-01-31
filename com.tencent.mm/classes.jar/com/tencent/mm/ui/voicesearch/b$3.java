package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$3
  implements Runnable
{
  b$3(b paramb, m paramm) {}
  
  public final void run()
  {
    Object localObject1 = ((f)this.bEe).bhH();
    y.d("MicroMsg.SearchResultAdapter", "count " + ((bnm)localObject1).tcA);
    if (((bnm)localObject1).tcA > 0)
    {
      localObject1 = ((bnm)localObject1).tcB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bnk)((Iterator)localObject1).next();
        if (s.hI(((bnk)localObject2).tpg))
        {
          if (b.f(this.wiQ) == null) {
            b.a(this.wiQ, new LinkedList());
          }
          b.f(this.wiQ).add(localObject2);
        }
      }
    }
    Object localObject2 = aa.a(((bnm)localObject1).sQs);
    y.d("MicroMsg.SearchResultAdapter", "user " + (String)localObject2);
    if (bk.pm((String)localObject2).length() > 0)
    {
      bnk localbnk = new bnk();
      localbnk.sQs = ((bnm)localObject1).sQs;
      localbnk.tpg = ((bnm)localObject1).tpg;
      localbnk.ffk = ((bnm)localObject1).ffk;
      localbnk.tmw = ((bnm)localObject1).tmw;
      localbnk.ffm = ((bnm)localObject1).ffm;
      localbnk.ffq = ((bnm)localObject1).ffq;
      localbnk.ffj = ((bnm)localObject1).ffj;
      localbnk.ffi = ((bnm)localObject1).ffi;
      localbnk.ffh = ((bnm)localObject1).ffh;
      localbnk.tph = ((bnm)localObject1).tph;
      localbnk.tpk = ((bnm)localObject1).tpk;
      localbnk.tpi = ((bnm)localObject1).tpi;
      localbnk.tpj = ((bnm)localObject1).tpj;
      localbnk.tpm = ((bnm)localObject1).tpm;
      o.JQ().h((String)localObject2, aa.a(((bnm)localObject1).svJ));
      if (b.f(this.wiQ) == null) {
        b.a(this.wiQ, new LinkedList());
      }
      b.f(this.wiQ).clear();
      if (s.hI(localbnk.tpg)) {
        b.f(this.wiQ).add(localbnk);
      }
      y.d("MicroMsg.SearchResultAdapter", "count " + b.f(this.wiQ).size());
    }
    b.b(this.wiQ, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.3
 * JD-Core Version:    0.7.0.1
 */