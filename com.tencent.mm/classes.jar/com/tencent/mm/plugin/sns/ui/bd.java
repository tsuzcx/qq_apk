package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class bd
  implements a
{
  public boolean Ahc = false;
  public boolean Ahd = false;
  public String drH;
  public String dzb;
  public int scene;
  public String userName;
  
  public bd(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.dzb = paramString1;
    this.Ahc = paramBoolean1;
    this.Ahd = paramBoolean2;
    this.scene = paramInt;
    this.drH = paramString2;
  }
  
  public final boolean ect()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      ar.b localb = ar.azc(this.dzb);
      if ((localb != null) && (localb.hII) && (!localb.aGQ) && ((i & localb.ePo) != 0))
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