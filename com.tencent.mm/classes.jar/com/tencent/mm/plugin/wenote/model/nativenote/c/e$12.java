package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Editable;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$12
  implements View.OnClickListener
{
  public e$12(e parame) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(26869);
    ab.i("NoteSelectManager", "select");
    this.vAR.dji();
    if (!e.djy())
    {
      ab.e("NoteSelectManager", "select: not init");
      AppMethodBeat.o(26869);
      return;
    }
    if (this.vAR.djb() != 1)
    {
      ab.e("NoteSelectManager", "select: not insert");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
    }
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(e.i(this.vAR).chT) == null)
    {
      ab.e("NoteSelectManager", "select: item is null");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
    }
    paramView = e.a(this.vAR);
    if (paramView == null)
    {
      ab.e("NoteSelectManager", "select: recyclerView is null");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
    }
    paramView = f.ey(f.f(paramView, e.i(this.vAR).chT));
    if (paramView == null)
    {
      ab.e("NoteSelectManager", "select: rteInfo is null");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
    }
    Object localObject2;
    if (paramView.vAf != null)
    {
      localObject2 = paramView.vAf.getText();
      if (localObject2 == null)
      {
        ab.e("NoteSelectManager", "select: text is null");
        e.h(this.vAR);
        AppMethodBeat.o(26869);
        return;
      }
      if (((Editable)localObject2).length() > 0)
      {
        paramView.vAf.ay(e.i(this.vAR).startOffset, true);
        AppMethodBeat.o(26869);
        return;
      }
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(e.i(this.vAR).chT - 1);
      paramView = (View)localObject2;
      if (localObject2 != null)
      {
        paramView = (View)localObject2;
        if (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() == -3) {
          paramView = null;
        }
      }
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(e.i(this.vAR).chT + 1);
      if ((localObject2 == null) || (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() != -2)) {
        break label668;
      }
    }
    for (;;)
    {
      if (paramView != null) {
        if (paramView.getType() == 1)
        {
          paramView = a.ajK(((i)paramView).content);
          if (paramView == null)
          {
            ab.e("NoteSelectManager", "select: spanned is null");
            e.h(this.vAR);
            AppMethodBeat.o(26869);
            return;
          }
          this.vAR.G(e.i(this.vAR).chT - 1, paramView.length(), e.i(this.vAR).chT, 0);
        }
      }
      for (;;)
      {
        e.e(this.vAR);
        this.vAR.ac(true, true);
        AppMethodBeat.o(26869);
        return;
        this.vAR.G(e.i(this.vAR).chT - 1, 0, e.i(this.vAR).chT, 0);
        continue;
        if (localObject1 == null) {
          break;
        }
        if (localObject1.getType() == 1) {
          this.vAR.G(e.i(this.vAR).chT, 0, e.i(this.vAR).chT + 1, 0);
        } else {
          this.vAR.G(e.i(this.vAR).chT, 0, e.i(this.vAR).chT + 1, 1);
        }
      }
      ab.e("NoteSelectManager", "select: no neighbor");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
      if ((paramView.vAg != null) && (paramView.vAh != null))
      {
        e.e(this.vAR);
        this.vAR.G(e.i(this.vAR).chT, 0, e.i(this.vAR).chT, 1);
        this.vAR.ac(true, true);
        AppMethodBeat.o(26869);
        return;
      }
      ab.e("NoteSelectManager", "select: rteInfo invalid");
      e.h(this.vAR);
      AppMethodBeat.o(26869);
      return;
      label668:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.12
 * JD-Core Version:    0.7.0.1
 */