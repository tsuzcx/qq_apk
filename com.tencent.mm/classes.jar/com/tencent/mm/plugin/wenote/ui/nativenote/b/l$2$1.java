package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.text.Editable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

final class l$2$1
  implements Runnable
{
  l$2$1(l.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(27176);
    if (this.vEc.vEb.vxf != 0)
    {
      int i = l.a(this.vEc.vDZ).getSelection().akX;
      if (i == this.vEc.vEb.content.length())
      {
        l.a(this.vEc.vDZ).diM();
        l.a(this.vEc.vDZ).getText().append("\n");
        l.a(this.vEc.vDZ).diN();
        l.a(this.vEc.vDZ).setSelection(i);
      }
      this.vEc.vEb.vxf = 0;
      if (this.vEc.vEb.vxg == 1)
      {
        l.a(this.vEc.vDZ).a(u.vBE, Boolean.TRUE);
        AppMethodBeat.o(27176);
        return;
      }
      if (this.vEc.vEb.vxg == 3)
      {
        l.a(this.vEc.vDZ).a(u.vBD, Boolean.TRUE);
        AppMethodBeat.o(27176);
        return;
      }
      if (this.vEc.vEb.vxg == 2) {
        l.a(this.vEc.vDZ).a(u.vBF, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(27176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l.2.1
 * JD-Core Version:    0.7.0.1
 */