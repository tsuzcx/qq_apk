package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.platformtools.ah;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.b paramb1, b.c paramc, ah paramah) {}
  
  public final void run()
  {
    this.ueb.a(this.udZ, this.uea);
    if (this.hZR != null)
    {
      this.hZR.post(new b.1.1(this));
      return;
    }
    this.uea.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b.1
 * JD-Core Version:    0.7.0.1
 */