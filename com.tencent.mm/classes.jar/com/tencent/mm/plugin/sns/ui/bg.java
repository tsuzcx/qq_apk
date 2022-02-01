package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class bg
  implements a
{
  public boolean EHG = false;
  public boolean EHH = false;
  public String dJX;
  public String dRS;
  public int scene;
  public String userName;
  
  public bg(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.dRS = paramString1;
    this.EHG = paramBoolean1;
    this.EHH = paramBoolean2;
    this.scene = paramInt;
    this.dJX = paramString2;
  }
  
  public final boolean fiA()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      au.b localb = au.aPp(this.dRS);
      if ((localb != null) && (localb.iGD) && (!localb.aGI) && ((i & localb.showFlag) != 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */