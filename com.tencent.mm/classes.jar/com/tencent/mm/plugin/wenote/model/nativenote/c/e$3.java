package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class e$3
  implements View.OnClickListener
{
  public e$3(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26860);
    ab.i("NoteSelectManager", "cut");
    if ((!e.djy()) || (!e.k(this.vAR)))
    {
      ab.e("NoteSelectManager", "cut: not init or not editable");
      this.vAR.dji();
      AppMethodBeat.o(26860);
      return;
    }
    if (e.l(this.vAR))
    {
      if (e.m(this.vAR) != null) {
        e.m(this.vAR).dhZ();
      }
      AppMethodBeat.o(26860);
      return;
    }
    this.vAR.dji();
    int i = this.vAR.djb();
    if (i == 2)
    {
      Object localObject = e.a(this.vAR, true, null, "");
      if (bo.aa((CharSequence)localObject))
      {
        ab.e("NoteSelectManager", "cut: selectedSpan is null or empty");
        e.h(this.vAR);
        AppMethodBeat.o(26860);
        return;
      }
      paramView = new i();
      paramView.content = b.a((Spanned)localObject);
      paramView.vwY = -1;
      paramView.vwW = false;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramView);
      f.d(ah.getContext(), (ArrayList)localObject);
      AppMethodBeat.o(26860);
      return;
    }
    if (i == 3)
    {
      paramView = e.b(this.vAR, true, null, "");
      if ((paramView != null) && (paramView.size() > 0))
      {
        f.d(ah.getContext(), paramView);
        AppMethodBeat.o(26860);
        return;
      }
      ab.e("NoteSelectManager", "cut: dataList is null or empty");
      e.h(this.vAR);
      AppMethodBeat.o(26860);
      return;
    }
    ab.e("NoteSelectManager", "cut: not in select");
    e.h(this.vAR);
    AppMethodBeat.o(26860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.3
 * JD-Core Version:    0.7.0.1
 */