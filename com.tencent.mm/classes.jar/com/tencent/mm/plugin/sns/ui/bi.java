package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class bi
  implements a
{
  public boolean KVI = false;
  public boolean KVJ = false;
  public String fCM;
  public String fLp;
  public int scene;
  public String userName;
  
  public bi(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.fLp = paramString1;
    this.KVI = paramBoolean1;
    this.KVJ = paramBoolean2;
    this.scene = paramInt;
    this.fCM = paramString2;
  }
  
  public final boolean fWO()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      at.b localb = at.bal(this.fLp);
      if ((localb != null) && (localb.lwF) && (!localb.lAQ) && ((i & localb.showFlag) != 0))
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bi
 * JD-Core Version:    0.7.0.1
 */