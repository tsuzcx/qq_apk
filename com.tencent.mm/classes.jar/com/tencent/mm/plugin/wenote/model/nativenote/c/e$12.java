package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Editable;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.y;

public final class e$12
  implements View.OnClickListener
{
  public e$12(e parame) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    y.i("NoteSelectManager", "select");
    this.rKn.ciP();
    if (!e.ciX())
    {
      y.e("NoteSelectManager", "select: not init");
      return;
    }
    if (this.rKn.ciI() != 1)
    {
      y.e("NoteSelectManager", "select: not insert");
      e.h(this.rKn);
      return;
    }
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(e.i(this.rKn).ebL) == null)
    {
      y.e("NoteSelectManager", "select: item is null");
      e.h(this.rKn);
      return;
    }
    paramView = e.a(this.rKn);
    if (paramView == null)
    {
      y.e("NoteSelectManager", "select: recyclerView is null");
      e.h(this.rKn);
      return;
    }
    paramView = f.ds(f.f(paramView, e.i(this.rKn).ebL));
    if (paramView == null)
    {
      y.e("NoteSelectManager", "select: rteInfo is null");
      e.h(this.rKn);
      return;
    }
    Object localObject2;
    if (paramView.rJB != null)
    {
      localObject2 = paramView.rJB.getText();
      if (localObject2 == null)
      {
        y.e("NoteSelectManager", "select: text is null");
        e.h(this.rKn);
        return;
      }
      if (((Editable)localObject2).length() > 0)
      {
        paramView.rJB.aj(e.i(this.rKn).startOffset, true);
        return;
      }
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(e.i(this.rKn).ebL - 1);
      paramView = (View)localObject2;
      if (localObject2 != null)
      {
        paramView = (View)localObject2;
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == -3) {
          paramView = null;
        }
      }
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(e.i(this.rKn).ebL + 1);
      if ((localObject2 == null) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() != -2)) {
        break label590;
      }
    }
    for (;;)
    {
      if (paramView != null) {
        if (paramView.getType() == 1)
        {
          paramView = a.Uw(((i)paramView).content);
          if (paramView == null)
          {
            y.e("NoteSelectManager", "select: spanned is null");
            e.h(this.rKn);
            return;
          }
          this.rKn.A(e.i(this.rKn).ebL - 1, paramView.length(), e.i(this.rKn).ebL, 0);
        }
      }
      for (;;)
      {
        e.e(this.rKn);
        this.rKn.S(true, true);
        return;
        this.rKn.A(e.i(this.rKn).ebL - 1, 0, e.i(this.rKn).ebL, 0);
        continue;
        if (localObject1 == null) {
          break;
        }
        if (localObject1.getType() == 1) {
          this.rKn.A(e.i(this.rKn).ebL, 0, e.i(this.rKn).ebL + 1, 0);
        } else {
          this.rKn.A(e.i(this.rKn).ebL, 0, e.i(this.rKn).ebL + 1, 1);
        }
      }
      y.e("NoteSelectManager", "select: no neighbor");
      e.h(this.rKn);
      return;
      if ((paramView.rJC != null) && (paramView.rJD != null))
      {
        e.e(this.rKn);
        this.rKn.A(e.i(this.rKn).ebL, 0, e.i(this.rKn).ebL, 1);
        this.rKn.S(true, true);
        return;
      }
      y.e("NoteSelectManager", "select: rteInfo invalid");
      e.h(this.rKn);
      return;
      label590:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.12
 * JD-Core Version:    0.7.0.1
 */