package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$3
  implements TextWatcher
{
  SnsCommentFooter$3(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (SnsCommentFooter.d(this.oXQ).getText() == null) {
      return;
    }
    if ((SnsCommentFooter.e(this.oXQ) == 8) && (!bk.bl(SnsCommentFooter.f(this.oXQ))) && (SnsCommentFooter.d(this.oXQ).getText() != null) && (!SnsCommentFooter.d(this.oXQ).getText().toString().startsWith(SnsCommentFooter.f(this.oXQ))))
    {
      y.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.d(this.oXQ).getText() });
      SnsCommentFooter.a(this.oXQ, "");
      SnsCommentFooter.g(this.oXQ);
      SnsCommentFooter.h(this.oXQ);
      SnsCommentFooter.a(this.oXQ, 0);
    }
    SnsCommentFooter.d(this.oXQ).requestFocus();
    if (SnsCommentFooter.d(this.oXQ).getText().toString().trim().length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.oXQ.lXS))
      {
        SnsCommentFooter.a(this.oXQ, true);
        this.oXQ.lXS = false;
      }
      if (i != 0) {
        break;
      }
      SnsCommentFooter.a(this.oXQ, false);
      this.oXQ.lXS = true;
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.3
 * JD-Core Version:    0.7.0.1
 */