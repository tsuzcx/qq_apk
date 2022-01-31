package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v.c;

final class ReadMailUI$12
  implements View.OnClickListener
{
  ReadMailUI$12(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68435);
    ReadMailUI.j(this.pOX).setVisibility(8);
    ReadMailUI.a(this.pOX, new v.c());
    AppMethodBeat.o(68435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.12
 * JD-Core Version:    0.7.0.1
 */