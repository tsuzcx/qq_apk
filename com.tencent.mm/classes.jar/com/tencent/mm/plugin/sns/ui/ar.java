package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;

public final class ar
{
  public String bMB;
  public String bRV;
  public boolean pbD = false;
  public boolean pbE = false;
  public int scene;
  
  public ar(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.bRV = paramString1;
    this.pbD = paramBoolean1;
    this.pbE = paramBoolean2;
    this.scene = paramInt;
    this.bMB = paramString2;
  }
  
  public final boolean bJh()
  {
    int i = 2;
    if (this.scene == 1) {}
    for (;;)
    {
      ap.b localb = ap.NJ(this.bRV);
      if ((localb != null) && (localb.dYj) && (!localb.ebE) && ((i & localb.cCu) != 0))
      {
        return true;
        if (this.scene == 2) {
          i = 4;
        }
      }
      else
      {
        return false;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */