package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  int mTH;
  int mTI;
  
  public e(int paramInt1, int paramInt2)
  {
    this.mTI = paramInt1;
    this.mTH = paramInt2;
  }
  
  public final boolean bsm()
  {
    if ((this.mTI & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MallProductConfig", "isFreePost, ret = " + bool);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */