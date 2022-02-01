package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.pluginsdk.ui.b.a;

public final class bj
  implements a
{
  public boolean RvF = false;
  public boolean RvG = false;
  public String hHB;
  public String hQX;
  public int scene;
  public String userName;
  
  public bj(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.hQX = paramString1;
    this.RvF = paramBoolean1;
    this.RvG = paramBoolean2;
    this.scene = paramInt;
    this.hHB = paramString2;
  }
  
  public final String getUserName()
  {
    return this.userName;
  }
  
  public final int hlN()
  {
    return 1;
  }
  
  public final String hlO()
  {
    return null;
  }
  
  public final boolean hph()
  {
    int i = 2;
    AppMethodBeat.i(98984);
    if (this.scene == 1) {}
    for (;;)
    {
      av.b localb = av.aYE(this.hQX);
      if ((localb != null) && (localb.ooe) && (!localb.oss) && ((i & localb.showFlag) != 0))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bj
 * JD-Core Version:    0.7.0.1
 */