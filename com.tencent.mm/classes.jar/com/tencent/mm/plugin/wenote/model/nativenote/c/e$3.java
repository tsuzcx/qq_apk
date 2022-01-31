package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e$3
  implements View.OnClickListener
{
  public e$3(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("NoteSelectManager", "cut");
    if ((!e.ciX()) || (!e.k(this.rKn)))
    {
      y.e("NoteSelectManager", "cut: not init or not editable");
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
    this.rKn.ciP();
    int i = this.rKn.ciI();
    if (i == 2)
    {
      Object localObject = e.a(this.rKn, true, null, "");
      if (bk.L((CharSequence)localObject))
      {
        y.e("NoteSelectManager", "cut: selectedSpan is null or empty");
        e.h(this.rKn);
        return;
      }
      paramView = new i();
      paramView.content = b.a((Spanned)localObject);
      paramView.rGp = -1;
      paramView.rGn = false;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramView);
      f.c(ae.getContext(), (ArrayList)localObject);
      return;
    }
    if (i == 3)
    {
      paramView = e.b(this.rKn, true, null, "");
      if ((paramView != null) && (paramView.size() > 0))
      {
        f.c(ae.getContext(), paramView);
        return;
      }
      y.e("NoteSelectManager", "cut: dataList is null or empty");
      e.h(this.rKn);
      return;
    }
    y.e("NoteSelectManager", "cut: not in select");
    e.h(this.rKn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.3
 * JD-Core Version:    0.7.0.1
 */