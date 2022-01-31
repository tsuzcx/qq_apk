package com.tencent.mm.wear.app.d.a.a;

public abstract class a
  implements d
{
  private e adq;
  
  public final void a(e parame)
  {
    this.adq = parame;
  }
  
  protected final void f(long paramLong)
  {
    com.tencent.mm.wear.a.b.a.aiT.post(new c(this, paramLong));
  }
  
  protected final void g(long paramLong)
  {
    com.tencent.mm.wear.a.b.a.aiT.post(new b(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */