package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$7
  implements View.OnClickListener
{
  SnsCommentFooter$7(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38885);
    this.rQk.setModeClick(true);
    ab.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(this.rQk));
    if (SnsCommentFooter.i(this.rQk) == 0)
    {
      this.rQk.cmc.hideVKB();
      SnsCommentFooter.b(this.rQk).requestFocus();
      SnsCommentFooter.a(this.rQk, 1);
      SnsCommentFooter.j(this.rQk);
      SnsCommentFooter.k(this.rQk).setImageResource(2130838350);
      SnsCommentFooter.l(this.rQk);
      AppMethodBeat.o(38885);
      return;
    }
    SnsCommentFooter.m(this.rQk);
    SnsCommentFooter.l(this.rQk);
    SnsCommentFooter.b(this.rQk).requestFocus();
    this.rQk.cmc.showVKB();
    SnsCommentFooter.k(this.rQk).setImageResource(2130838345);
    SnsCommentFooter.a(this.rQk, 0);
    AppMethodBeat.o(38885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7
 * JD-Core Version:    0.7.0.1
 */