package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.b;

public final class ah
  implements af
{
  private b rhS;
  private int scene = 0;
  
  public final b coJ()
  {
    AppMethodBeat.i(36525);
    if (this.rhS == null) {
      this.rhS = new b();
    }
    b localb = this.rhS;
    AppMethodBeat.o(36525);
    return localb;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah
 * JD-Core Version:    0.7.0.1
 */