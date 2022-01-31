package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

final class SnsCommentFooter$4
  implements TextWatcher
{
  SnsCommentFooter$4(SnsCommentFooter paramSnsCommentFooter, List paramList) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (SnsCommentFooter.d(this.oXQ).getText() == null) {
      return;
    }
    if ((SnsCommentFooter.e(this.oXQ) == 8) && (!bk.bl(SnsCommentFooter.f(this.oXQ))) && (!bk.bl(SnsCommentFooter.d(this.oXQ).getText().toString())) && (!SnsCommentFooter.d(this.oXQ).getText().toString().startsWith(SnsCommentFooter.f(this.oXQ))))
    {
      y.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.f(this.oXQ), SnsCommentFooter.d(this.oXQ).getText() });
      SnsCommentFooter.a(this.oXQ, "");
      SnsCommentFooter.g(this.oXQ);
      SnsCommentFooter.h(this.oXQ);
      SnsCommentFooter.a(this.oXQ, 0);
    }
    y.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.i(this.oXQ));
    if (!bk.bl(SnsCommentFooter.i(this.oXQ)))
    {
      paramEditable = this.oXS.iterator();
      while (paramEditable.hasNext())
      {
        k localk = (k)paramEditable.next();
        if (SnsCommentFooter.i(this.oXQ).equals(localk.key))
        {
          y.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
          localk.text = SnsCommentFooter.d(this.oXQ).getText().toString();
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        y.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
        paramEditable = new k();
        paramEditable.key = SnsCommentFooter.i(this.oXQ);
        paramEditable.text = SnsCommentFooter.d(this.oXQ).getText().toString();
        if ((paramEditable.text != null) && (paramEditable.text.length() > 0)) {
          this.oXS.add(paramEditable);
        }
      }
      if (this.oXS.size() > 5)
      {
        y.d("MicroMsg.SnsCommentFooter", "comments remove");
        this.oXS.remove(0);
      }
      SnsCommentFooter.d(this.oXQ).requestFocus();
      if (SnsCommentFooter.d(this.oXQ).getText().toString().trim().length() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (this.oXQ.lXS))
        {
          SnsCommentFooter.a(this.oXQ, bool);
          this.oXQ.lXS = false;
        }
        if (bool) {
          break;
        }
        SnsCommentFooter.a(this.oXQ, bool);
        this.oXQ.lXS = true;
        return;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.4
 * JD-Core Version:    0.7.0.1
 */