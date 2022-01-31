package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.al;

final class l$2
  implements Runnable
{
  l$2(l paraml, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(27177);
    l.a(this.vDZ).setRichTextEditing(this.vEb.content);
    l.a(this.vDZ).diM();
    l.a(this.vDZ).diO();
    j.l(l.a(this.vDZ));
    l.a(this.vDZ).diP();
    l.a(this.vDZ).diN();
    if (this.vEb.vwW) {
      if ((this.vEb.vwY != -1) && (this.vEb.vwY < l.a(this.vDZ).getText().toString().length()))
      {
        l.a(this.vDZ).setSelection(this.vEb.vwY);
        l.a(this.vDZ).requestFocus();
        al.p(new l.2.1(this), 500L);
      }
    }
    for (;;)
    {
      if (this.vEb.vxe)
      {
        this.vEb.vxe = false;
        l.a(this.vDZ).vxe = true;
        l.a(this.vDZ).onTextContextMenuItem(16908322);
      }
      AppMethodBeat.o(27177);
      return;
      l.a(this.vDZ).setSelection(l.a(this.vDZ).getText().toString().length());
      break;
      if (l.a(this.vDZ).hasFocus()) {
        l.a(this.vDZ).clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l.2
 * JD-Core Version:    0.7.0.1
 */