package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class ba
  implements a
{
  public String dgl;
  public String dnn;
  public int scene;
  public String userName;
  public boolean yPG = false;
  public boolean yPH = false;
  
  public ba(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.dnn = paramString1;
    this.yPG = paramBoolean1;
    this.yPH = paramBoolean2;
    this.scene = paramInt;
    this.dgl = paramString2;
  }
  
  public final boolean dQd()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      aq.b localb = aq.atX(this.dnn);
      if ((localb != null) && (localb.hqq) && (!localb.aEZ) && ((i & localb.exP) != 0))
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