package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;

final class d$1
  implements Runnable
{
  d$1(d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    d.b(this.rHR).a(this.eot, d.a(this.rHR));
    if ((d.c(this.rHR)) || (this.pGH != -50006)) {
      au.DS().k(new Runnable()
      {
        public final void run()
        {
          d.b(d.1.this.rHR).b(d.d(d.1.this.rHR), d.a(d.1.this.rHR));
        }
      }, 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d.1
 * JD-Core Version:    0.7.0.1
 */