package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.sdk.platformtools.y;

public final class e$2
  implements View.OnClickListener
{
  public e$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("NoteSelectManager", "delete");
    if ((!e.ciX()) || (!e.k(this.rKn)))
    {
      y.e("NoteSelectManager", "delete: not init or not editable");
      this.rKn.ciP();
    }
    do
    {
      return;
      if (!e.l(this.rKn)) {
        break;
      }
    } while (e.m(this.rKn) == null);
    e.m(this.rKn).chJ();
    return;
    if (e.m(this.rKn) != null)
    {
      e.m(this.rKn).chK();
      return;
    }
    this.rKn.ciW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.2
 * JD-Core Version:    0.7.0.1
 */