package com.tencent.mm.plugin.wenote.model.nativenote.c;

public final class d
{
  public int ebL = -1;
  public int endPos = -1;
  public int rJE = -1;
  public int startOffset = -1;
  
  public d()
  {
    set(-1, -1, -1, -1);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final int ciI()
  {
    int i = 1;
    if ((this.ebL < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.rJE < 0) || (this.ebL > this.endPos) || ((this.ebL == this.endPos) && (this.startOffset > this.rJE))) {
      i = 0;
    }
    com.tencent.mm.plugin.wenote.model.a.c localc1;
    do
    {
      return i;
      localc1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(this.ebL);
      com.tencent.mm.plugin.wenote.model.a.c localc2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(this.endPos);
      if ((localc1 == null) || (localc2 == null)) {
        return 0;
      }
    } while ((this.ebL == this.endPos) && (this.startOffset == this.rJE));
    if ((this.ebL == this.endPos) && (localc1.getType() == 1)) {
      return 2;
    }
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ebL = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.rJE = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */