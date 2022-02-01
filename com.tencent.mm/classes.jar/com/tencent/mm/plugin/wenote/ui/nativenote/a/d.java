package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  private TextView JJA;
  
  public d(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30854);
    this.JJA = null;
    this.JJA = ((TextView)paramView.findViewById(2131305507));
    this.JJA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30853);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteComplaintItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        NoteEditorUI.gkh();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteComplaintItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30853);
      }
    });
    AppMethodBeat.o(30854);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30855);
    Log.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + lQ());
    AppMethodBeat.o(30855);
  }
  
  public final int cCY()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.d
 * JD-Core Version:    0.7.0.1
 */