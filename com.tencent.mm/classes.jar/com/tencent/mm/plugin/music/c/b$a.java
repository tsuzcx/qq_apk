package com.tencent.mm.plugin.music.c;

final class b$a
  implements Runnable
{
  int action;
  
  b$a(b paramb, int paramInt)
  {
    this.action = paramInt;
  }
  
  public final void run()
  {
    if (this.myA.myz != null) {
      this.myA.myz.uH(this.action);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.c.b.a
 * JD-Core Version:    0.7.0.1
 */