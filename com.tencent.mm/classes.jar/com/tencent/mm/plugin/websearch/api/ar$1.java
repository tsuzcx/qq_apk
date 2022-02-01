package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qh;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class ar$1
  implements Runnable
{
  ar$1(int paramInt) {}
  
  public final void run()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(212542);
    int[] arrayOfInt = new int[5];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 1;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 0;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 5;
    int[] tmp28_24 = tmp24_20;
    tmp28_24[3] = 6;
    int[] tmp33_28 = tmp28_24;
    tmp33_28[4] = 3;
    tmp33_28;
    if (this.val$type == -1)
    {
      long l = h.aHG().aHp().a(ar.a.VvM, 0L);
      if (cm.bfE() - l > 86400000L)
      {
        i = j;
        while (i < 5)
        {
          localqh = new qh();
          localqh.goe = (i + 1);
          localqh.hjA = ai.anh(arrayOfInt[i]);
          localqh.bpa();
          ar.a(localqh);
          i += 1;
        }
        h.aHG().aHp().set(ar.a.VvM, Long.valueOf(cm.bfE()));
      }
      AppMethodBeat.o(212542);
      return;
    }
    do
    {
      i += 1;
      if (i >= 5) {
        break;
      }
    } while (arrayOfInt[i] != this.val$type);
    qh localqh = new qh();
    localqh.goe = (i + 1);
    localqh.hjA = ai.anh(arrayOfInt[i]);
    localqh.bpa();
    ar.a(localqh);
    AppMethodBeat.o(212542);
    return;
    AppMethodBeat.o(212542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ar.1
 * JD-Core Version:    0.7.0.1
 */