package com.tencent.mm.plugin.qqmail.b;

import java.util.Map;

final class v$1
  implements Runnable
{
  v$1(v paramv, v.d paramd) {}
  
  public final void run()
  {
    v.b localb = new v.b(this.neu, (byte)0);
    v.a(this.neu).put(Long.valueOf(this.nes.id), this.nes);
    v.b(this.neu).put(Long.valueOf(this.nes.id), localb);
    localb.b(this.nes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.1
 * JD-Core Version:    0.7.0.1
 */