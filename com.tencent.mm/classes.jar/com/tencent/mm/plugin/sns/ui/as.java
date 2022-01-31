package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class as
  implements a
{
  public String ctV;
  public String czw;
  public boolean rUm = false;
  public boolean rUn = false;
  public int scene;
  public String userName;
  
  public as(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.czw = paramString1;
    this.rUm = paramBoolean1;
    this.rUn = paramBoolean2;
    this.scene = paramInt;
    this.ctV = paramString2;
  }
  
  public final boolean cvI()
  {
    int i = 2;
    AppMethodBeat.i(39186);
    if (this.scene == 1) {}
    for (;;)
    {
      aq.b localb = aq.aaD(this.czw);
      if ((localb != null) && (localb.fon) && (!localb.frX) && ((i & localb.dqG) != 0))
      {
        AppMethodBeat.o(39186);
        return true;
        if (this.scene == 2) {
          i = 4;
        }
      }
      else
      {
        AppMethodBeat.o(39186);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */