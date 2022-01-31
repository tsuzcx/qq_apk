package com.tencent.mm.ui;

import com.tencent.mm.h.a.ml;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;

final class h$10
  implements Runnable
{
  h$10(h paramh) {}
  
  public final void run()
  {
    final ml localml = new ml();
    a.udP.m(localml);
    ai.d(new Runnable()
    {
      public final void run()
      {
        h.a(h.10.this.uJi, localml);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.h.10
 * JD-Core Version:    0.7.0.1
 */