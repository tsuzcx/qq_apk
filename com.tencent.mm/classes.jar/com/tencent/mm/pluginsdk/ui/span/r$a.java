package com.tencent.mm.pluginsdk.ui.span;

final class r$a
{
  private int end;
  private int start;
  
  r$a(r paramr, int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  final boolean a(a parama)
  {
    return (this.end > parama.start) && (parama.end > this.start);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r.a
 * JD-Core Version:    0.7.0.1
 */