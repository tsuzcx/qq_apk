package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public long valLayout = 0L;
  public long valMeasure = 0L;
  
  public final String result()
  {
    AppMethodBeat.i(68353);
    String str = String.format("result valMeasure:%s valLayout:%s total:%s", new Object[] { Long.valueOf(this.valMeasure), Long.valueOf(this.valLayout), Long.valueOf(this.valLayout + this.valMeasure) });
    AppMethodBeat.o(68353);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.i
 * JD-Core Version:    0.7.0.1
 */