package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n
  extends e
{
  final boolean rKx;
  public final boolean rKy;
  
  public n(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.rKx = paramBoolean1;
    this.rKy = paramBoolean2;
  }
  
  public final boolean a(e parame)
  {
    if (parame == null) {}
    label83:
    label86:
    do
    {
      for (;;)
      {
        return false;
        if (!parame.isEmpty()) {
          break;
        }
        int i;
        if ((parame.aiH >= this.aiH) && (parame.Eo < this.Eo))
        {
          i = 1;
          if ((parame.aiH < this.aiH) || (parame.Eo > this.Eo)) {
            break label83;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((i == 0) && ((j == 0) || (!this.rKy))) {
            break label86;
          }
          return true;
          i = 0;
          break;
        }
      }
    } while (Math.max(this.aiH, parame.aiH) >= Math.min(this.Eo, parame.Eo));
    return true;
  }
  
  public final int cjf()
  {
    return Math.abs(this.Eo - this.aiH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.n
 * JD-Core Version:    0.7.0.1
 */