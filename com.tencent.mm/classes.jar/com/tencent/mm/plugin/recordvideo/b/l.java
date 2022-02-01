package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class l
{
  public static boolean HKt = false;
  
  public static boolean isEnable()
  {
    AppMethodBeat.i(75022);
    if (HKt)
    {
      AppMethodBeat.o(75022);
      return true;
    }
    if (((b)h.ae(b.class)).a(b.a.vCo, 0L) > 0L)
    {
      i = 1;
      if ((i == 0) || (!d.qV(28))) {
        break label97;
      }
      if (h.aHG().aHp().a(ar.a.Vxo, 0L) < 3L) {
        break label92;
      }
    }
    label92:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label97;
      }
      AppMethodBeat.o(75022);
      return true;
      i = 0;
      break;
    }
    label97:
    AppMethodBeat.o(75022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.l
 * JD-Core Version:    0.7.0.1
 */