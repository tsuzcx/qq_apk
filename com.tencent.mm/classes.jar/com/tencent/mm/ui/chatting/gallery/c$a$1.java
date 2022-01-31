package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.ah;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, long paramLong, Boolean paramBoolean, c paramc) {}
  
  public final void run()
  {
    c.a.a(this.vul, this.vui);
    if (this.vuj.booleanValue()) {
      this.vul.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          c.a.a(c.a.1.this.vul);
          if (c.a.1.this.vuk.vtR != null) {
            c.a.1.this.vuk.vtR.kA();
          }
        }
      }, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a.1
 * JD-Core Version:    0.7.0.1
 */