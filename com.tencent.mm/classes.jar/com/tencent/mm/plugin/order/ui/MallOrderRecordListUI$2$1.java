package com.tencent.mm.plugin.order.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.ui.base.h.c;
import java.util.List;

final class MallOrderRecordListUI$2$1
  implements h.c
{
  MallOrderRecordListUI$2$1(MallOrderRecordListUI.2 param2, int paramInt) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(43850);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43850);
      return;
      i locali = (i)this.pri.prh.prd.get(this.lU);
      if (locali != null)
      {
        String str = locali.ppY;
        this.pri.prh.fI(str, locali.pqq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.2.1
 * JD-Core Version:    0.7.0.1
 */