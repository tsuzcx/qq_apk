package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.text.Editable;
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
    if (this.rNy.rNx.rGw != 0)
    {
      int i = l.a(this.rNy.rNv).getSelection().aiH;
      if (i == this.rNy.rNx.content.length())
      {
        l.a(this.rNy.rNv).civ();
        l.a(this.rNy.rNv).getText().append("\n");
        l.a(this.rNy.rNv).ciw();
        l.a(this.rNy.rNv).setSelection(i);
      }
      this.rNy.rNx.rGw = 0;
      if (this.rNy.rNx.rGx != 1) {
        break label154;
      }
      l.a(this.rNy.rNv).a(u.rLa, Boolean.valueOf(true));
    }
    label154:
    do
    {
      return;
      if (this.rNy.rNx.rGx == 3)
      {
        l.a(this.rNy.rNv).a(u.rKZ, Boolean.valueOf(true));
        return;
      }
    } while (this.rNy.rNx.rGx != 2);
    l.a(this.rNy.rNv).a(u.rLb, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l.2.1
 * JD-Core Version:    0.7.0.1
 */