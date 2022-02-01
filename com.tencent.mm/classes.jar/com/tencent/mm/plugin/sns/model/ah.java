package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.b;

public final class ah
  implements af
{
  private int scene = 0;
  private b zkL;
  
  public final b dTI()
  {
    AppMethodBeat.i(95844);
    if (this.zkL == null) {
      this.zkL = new b();
    }
    b localb = this.zkL;
    AppMethodBeat.o(95844);
    return localb;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah
 * JD-Core Version:    0.7.0.1
 */