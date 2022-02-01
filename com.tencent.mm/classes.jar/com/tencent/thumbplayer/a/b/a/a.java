package com.tencent.thumbplayer.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;

public final class a
{
  public int[] ahGg;
  public int ahGh;
  public int ahGi;
  public boolean ahGj;
  
  public a(c paramc)
  {
    AppMethodBeat.i(228482);
    this.ahGj = false;
    this.ahGh = 2;
    this.ahGi = 2;
    if (paramc == null)
    {
      AppMethodBeat.o(228482);
      return;
    }
    TPOptionalParam localTPOptionalParam = paramc.aHq(210);
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 4))
    {
      this.ahGg = localTPOptionalParam.getParamQueueInt().queueValue;
      this.ahGj = true;
      AppMethodBeat.o(228482);
      return;
    }
    localTPOptionalParam = paramc.aHq(202);
    long l;
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 2))
    {
      l = localTPOptionalParam.getParamLong().value;
      if ((l <= 0L) || (l >= 5L)) {
        break label250;
      }
      i = 1;
      if (i != 0) {
        this.ahGi = ((int)localTPOptionalParam.getParamLong().value);
      }
    }
    paramc = paramc.aHq(203);
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
        this.ahGh = ((int)paramc.getParamLong().value);
      }
      i = this.ahGi;
      j = this.ahGh;
      if ((i != 3) || (j != 3)) {
        break label260;
      }
      paramc = new IllegalArgumentException("can not soft with systemplayer");
      AppMethodBeat.o(228482);
      throw paramc;
      i = 0;
      break;
    }
    label260:
    AppMethodBeat.o(228482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */