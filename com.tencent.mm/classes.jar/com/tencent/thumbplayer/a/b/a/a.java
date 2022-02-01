package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;

public final class a
{
  public int[] RYt;
  public int RYu;
  public int RYv;
  public boolean RYw;
  
  public a(c paramc)
  {
    AppMethodBeat.i(188994);
    this.RYw = false;
    this.RYu = 2;
    this.RYv = 2;
    if (paramc == null)
    {
      AppMethodBeat.o(188994);
      return;
    }
    TPOptionalParam localTPOptionalParam = paramc.aqR(210);
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 4))
    {
      this.RYt = localTPOptionalParam.getParamQueueInt().queueValue;
      this.RYw = true;
      AppMethodBeat.o(188994);
      return;
    }
    localTPOptionalParam = paramc.aqR(202);
    long l;
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 2))
    {
      l = localTPOptionalParam.getParamLong().value;
      if ((l <= 0L) || (l >= 5L)) {
        break label250;
      }
      i = 1;
      if (i != 0) {
        this.RYv = ((int)localTPOptionalParam.getParamLong().value);
      }
    }
    paramc = paramc.aqR(203);
    if ((paramc != null) && (paramc.getParamType() == 2))
    {
      l = paramc.getParamLong().value;
      if ((l <= 0L) || (l >= 5L)) {
        break label255;
      }
    }
    label250:
    label255:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        this.RYu = ((int)paramc.getParamLong().value);
      }
      i = this.RYv;
      j = this.RYu;
      if ((i != 3) || (j != 3)) {
        break label260;
      }
      paramc = new IllegalArgumentException("can not soft with systemplayer");
      AppMethodBeat.o(188994);
      throw paramc;
      i = 0;
      break;
    }
    label260:
    AppMethodBeat.o(188994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */