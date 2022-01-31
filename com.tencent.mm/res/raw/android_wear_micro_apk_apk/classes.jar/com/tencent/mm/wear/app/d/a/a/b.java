package com.tencent.mm.wear.app.d.a.a;

public final class b
  implements Runnable
{
  int aaw = 0;
  long acG;
  
  public b(a parama, long paramLong)
  {
    this.acG = paramLong;
  }
  
  public final void run()
  {
    if (a.a(this.adr) != null) {
      a.a(this.adr).c(this.aaw, this.acG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */