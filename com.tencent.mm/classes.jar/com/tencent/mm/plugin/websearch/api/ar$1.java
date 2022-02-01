package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
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
    AppMethodBeat.i(187863);
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
      long l = g.aAh().azQ().a(ar.a.Ohw, 0L);
      if (cl.aWA() - l > 86400000L)
      {
        i = j;
        while (i < 5)
        {
          localnh = new nh();
          localnh.erY = (i + 1);
          localnh.fgr = ai.aft(arrayOfInt[i]);
          localnh.bfK();
          ar.a(localnh);
          i += 1;
        }
        g.aAh().azQ().set(ar.a.Ohw, Long.valueOf(cl.aWA()));
      }
      AppMethodBeat.o(187863);
      return;
    }
    do
    {
      i += 1;
      if (i >= 5) {
        break;
      }
    } while (arrayOfInt[i] != this.val$type);
    nh localnh = new nh();
    localnh.erY = (i + 1);
    localnh.fgr = ai.aft(arrayOfInt[i]);
    localnh.bfK();
    ar.a(localnh);
    AppMethodBeat.o(187863);
    return;
    AppMethodBeat.o(187863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ar.1
 * JD-Core Version:    0.7.0.1
 */