package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$13
  implements View.OnClickListener
{
  public e$13(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26870);
    ab.i("NoteSelectManager", "select all");
    this.vAR.dji();
    if (!e.djy())
    {
      ab.e("NoteSelectManager", "select all: not init");
      AppMethodBeat.o(26870);
      return;
    }
    int j = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diy();
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diz();
    paramView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(j);
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(k);
    if ((paramView == null) || (localc == null))
    {
      ab.e("NoteSelectManager", "select all: item is null");
      e.h(this.vAR);
      AppMethodBeat.o(26870);
      return;
    }
    if (localc.getType() == 1)
    {
      paramView = a.ajK(((i)localc).content);
      if (paramView == null)
      {
        ab.e("NoteSelectManager", "select all: spanned is null");
        e.h(this.vAR);
        AppMethodBeat.o(26870);
        return;
      }
    }
    for (int i = paramView.length();; i = 1)
    {
      e.e(this.vAR);
      this.vAR.G(j, 0, k, i);
      this.vAR.djk();
      this.vAR.dji();
      e.j(this.vAR);
      this.vAR.oT(false);
      this.vAR.oR(false);
      AppMethodBeat.o(26870);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.13
 * JD-Core Version:    0.7.0.1
 */