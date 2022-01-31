package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.o;

final class SnsCommentDetailUI$a
  extends o
{
  SnsCommentDetailUI$a(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38827);
    SnsCommentDetailUI.j(this.rPu).scw.onClick(paramView);
    AppMethodBeat.o(38827);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(38828);
    int i = this.rPu.getResources().getColor(2131690488);
    if (getPress())
    {
      paramTextPaint.bgColor = i;
      AppMethodBeat.o(38828);
      return;
    }
    paramTextPaint.bgColor = 0;
    AppMethodBeat.o(38828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.a
 * JD-Core Version:    0.7.0.1
 */