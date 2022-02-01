package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.c;

public final class ag
  implements ae
{
  private int scene = 0;
  private c wIv;
  
  public final c dsZ()
  {
    AppMethodBeat.i(95844);
    if (this.wIv == null) {
      this.wIv = new c();
    }
    c localc = this.wIv;
    AppMethodBeat.o(95844);
    return localc;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag
 * JD-Core Version:    0.7.0.1
 */