package com.tencent.mm.wear.app.d.a.a;

public final class c
  implements Runnable
{
  long acG;
  
  public c(a parama, long paramLong)
  {
    this.acG = paramLong;
  }
  
  public final void run()
  {
    if (a.a(this.adr) != null) {
      a.a(this.adr).f(this.acG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */