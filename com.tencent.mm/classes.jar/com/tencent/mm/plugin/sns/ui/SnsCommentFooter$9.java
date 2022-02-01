package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;

final class SnsCommentFooter$9
  implements TextWatcher
{
  SnsCommentFooter$9(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(369940);
    if (SnsCommentFooter.g(this.RqJ) != null)
    {
      if (Tiger2022Helper.b(SnsCommentFooter.g(this.RqJ).getTimeLine(), paramEditable.toString()))
      {
        Tiger2022Helper.bE(paramEditable);
        AppMethodBeat.o(369940);
        return;
      }
      Tiger2022Helper.g(paramEditable);
    }
    AppMethodBeat.o(369940);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.9
 * JD-Core Version:    0.7.0.1
 */