package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;

final class m$12
  implements Runnable
{
  m$12(m paramm) {}
  
  public final void run()
  {
    if (!au.DK()) {
      return;
    }
    au.Hx();
    bk.h(c.FM(), "Sk", 604800000L);
  }
  
  public final String toString()
  {
    return super.toString() + "|onAccountPostReset";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.12
 * JD-Core Version:    0.7.0.1
 */