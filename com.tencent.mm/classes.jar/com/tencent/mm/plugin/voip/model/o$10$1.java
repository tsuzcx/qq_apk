package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.h.a.uc;
import com.tencent.mm.h.a.uc.a;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;

final class o$10$1
  implements Runnable
{
  o$10$1(o.10 param10, uc paramuc) {}
  
  public final void run()
  {
    switch (this.pSX.ceA.bHz)
    {
    default: 
      return;
    case 1: 
      if (b.Ax(o.a(this.pSY.pSP).mState))
      {
        this.pSY.pSP.bQv();
        return;
      }
      this.pSY.pSP.bQy();
      return;
    case 2: 
      if (b.Ax(o.a(this.pSY.pSP).mState))
      {
        this.pSY.pSP.bQu();
        return;
      }
      this.pSY.pSP.bQx();
      return;
    }
    this.pSY.pSP.bQs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.10.1
 * JD-Core Version:    0.7.0.1
 */