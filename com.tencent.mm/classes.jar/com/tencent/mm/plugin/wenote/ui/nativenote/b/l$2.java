package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;

final class l$2
  implements Runnable
{
  l$2(l paraml, i parami) {}
  
  public final void run()
  {
    l.a(this.rNv).setRichTextEditing(this.rNx.content);
    l.a(this.rNv).civ();
    l.a(this.rNv).cix();
    j.h(l.a(this.rNv));
    l.a(this.rNv).ciy();
    l.a(this.rNv).ciw();
    if (this.rNx.rGn) {
      if ((this.rNx.rGp != -1) && (this.rNx.rGp < l.a(this.rNv).getText().toString().length()))
      {
        l.a(this.rNv).setSelection(this.rNx.rGp);
        l.a(this.rNv).requestFocus();
        ai.l(new l.2.1(this), 500L);
      }
    }
    for (;;)
    {
      if (this.rNx.rGv)
      {
        this.rNx.rGv = false;
        l.a(this.rNv).rGv = true;
        l.a(this.rNv).onTextContextMenuItem(16908322);
      }
      return;
      l.a(this.rNv).setSelection(l.a(this.rNv).getText().toString().length());
      break;
      if (l.a(this.rNv).hasFocus()) {
        l.a(this.rNv).clearFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l.2
 * JD-Core Version:    0.7.0.1
 */