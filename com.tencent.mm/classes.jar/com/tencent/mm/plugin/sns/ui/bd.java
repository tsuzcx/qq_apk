package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class bd
  implements a
{
  public boolean Ayo = false;
  public boolean Ayp = false;
  public String dAg;
  public String dsN;
  public int scene;
  public String userName;
  
  public bd(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.dAg = paramString1;
    this.Ayo = paramBoolean1;
    this.Ayp = paramBoolean2;
    this.scene = paramInt;
    this.dsN = paramString2;
  }
  
  public final boolean ega()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      as.b localb = as.aAt(this.dAg);
      if ((localb != null) && (localb.hLB) && (!localb.aGQ) && ((i & localb.eQZ) != 0))
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */