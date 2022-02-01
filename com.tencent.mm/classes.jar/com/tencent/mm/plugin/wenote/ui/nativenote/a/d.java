package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends a
{
  private TextView CXp;
  
  public d(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30854);
    this.CXp = null;
    this.CXp = ((TextView)paramView.findViewById(2131302920));
    this.CXp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30853);
        NoteEditorUI.eIx();
        AppMethodBeat.o(30853);
      }
    });
    AppMethodBeat.o(30854);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30855);
    ac.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lu());
    AppMethodBeat.o(30855);
  }
  
  public final int bZp()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.d
 * JD-Core Version:    0.7.0.1
 */