package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

final class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public final void run()
  {
    j.a(this.rGe);
    this.rGe.df(this.rGe.rFj.ntu);
    if (k.ciD() != null) {
      k.ciH();
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|dealWNoteInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j.1
 * JD-Core Version:    0.7.0.1
 */