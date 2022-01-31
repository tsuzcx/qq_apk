package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$4
  implements TextWatcher
{
  private int rQm = 0;
  
  SnsCommentFooter$4(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(38880);
    if (SnsCommentFooter.b(this.rQk).getText() == null)
    {
      AppMethodBeat.o(38880);
      return;
    }
    if ((d.fS(SnsCommentFooter.c(this.rQk), 8)) && (!bo.isNullOrNil(SnsCommentFooter.d(this.rQk))) && (SnsCommentFooter.b(this.rQk).getText() != null) && (!SnsCommentFooter.b(this.rQk).getText().toString().startsWith(SnsCommentFooter.d(this.rQk))))
    {
      ab.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(this.rQk).getText() });
      SnsCommentFooter.a(this.rQk, "");
      SnsCommentFooter.e(this.rQk);
      this.rQk.EN(8);
      SnsCommentFooter.a(this.rQk, 0);
    }
    SnsCommentFooter.b(this.rQk).requestFocus();
    if (SnsCommentFooter.b(this.rQk).getText().toString().trim().length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.rQk.oxr))
      {
        SnsCommentFooter.a(this.rQk, true);
        this.rQk.oxr = false;
      }
      if (i == 0)
      {
        SnsCommentFooter.a(this.rQk, false);
        this.rQk.oxr = true;
      }
      AppMethodBeat.o(38880);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38878);
    if (paramCharSequence == null) {}
    for (paramInt1 = 0;; paramInt1 = paramCharSequence.length())
    {
      this.rQm = paramInt1;
      AppMethodBeat.o(38878);
      return;
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38879);
    if ((paramCharSequence == null) || (paramCharSequence.length() < a.raX))
    {
      this.rQk.EN(16);
      ab.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
      AppMethodBeat.o(38879);
      return;
    }
    if (paramCharSequence.length() - this.rQm > a.raX)
    {
      this.rQk.setCommentFlag(16);
      ab.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
    }
    AppMethodBeat.o(38879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.4
 * JD-Core Version:    0.7.0.1
 */