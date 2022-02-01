package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class SnsCommentDetailUI$b$1
  implements Runnable
{
  SnsCommentDetailUI$b$1(SnsCommentDetailUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(98585);
    SnsCommentDetailUI.a(this.Aci.AbL).setSelection(SnsCommentDetailUI.a(this.Aci.AbL).getHeaderViewsCount() + this.Aci.commentList.size() - 1);
    AppMethodBeat.o(98585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b.1
 * JD-Core Version:    0.7.0.1
 */