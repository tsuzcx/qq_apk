package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class ba
  implements a
{
  public String diQ;
  public String dpC;
  public int scene;
  public String userName;
  public boolean xCS = false;
  public boolean xCT = false;
  
  public ba(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.dpC = paramString1;
    this.xCS = paramBoolean1;
    this.xCT = paramBoolean2;
    this.scene = paramInt;
    this.diQ = paramString2;
  }
  
  public final boolean dBG()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      ap.b localb = ap.aoL(this.dpC);
      if ((localb != null) && (localb.gPQ) && (!localb.aEj) && ((i & localb.evt) != 0))
      {
        AppMethodBeat.o(98984);
        return true;
        if (this.scene == 2) {
          i = 4;
        }
      }
      else
      {
        AppMethodBeat.o(98984);
        return false;
      }
      i = -1;
    }
  }
  
  public final String getUserName()
  {
    return this.userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */