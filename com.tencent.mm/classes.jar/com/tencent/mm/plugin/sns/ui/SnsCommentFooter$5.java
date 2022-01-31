package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

final class SnsCommentFooter$5
  implements TextWatcher
{
  int rQm = 0;
  
  SnsCommentFooter$5(SnsCommentFooter paramSnsCommentFooter, List paramList) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(38883);
    if (SnsCommentFooter.b(this.rQk).getText() == null)
    {
      AppMethodBeat.o(38883);
      return;
    }
    if ((d.fS(SnsCommentFooter.c(this.rQk), 8)) && (!bo.isNullOrNil(SnsCommentFooter.d(this.rQk))) && (!bo.isNullOrNil(SnsCommentFooter.b(this.rQk).getText().toString())) && (!SnsCommentFooter.b(this.rQk).getText().toString().startsWith(SnsCommentFooter.d(this.rQk))))
    {
      ab.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(this.rQk), SnsCommentFooter.b(this.rQk).getText() });
      SnsCommentFooter.a(this.rQk, "");
      SnsCommentFooter.e(this.rQk);
      this.rQk.EN(8);
      SnsCommentFooter.a(this.rQk, 0);
    }
    ab.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(this.rQk));
    if (!bo.isNullOrNil(SnsCommentFooter.f(this.rQk)))
    {
      paramEditable = this.rQn.iterator();
      while (paramEditable.hasNext())
      {
        k localk = (k)paramEditable.next();
        if (SnsCommentFooter.f(this.rQk).equals(localk.key))
        {
          ab.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
          localk.text = SnsCommentFooter.b(this.rQk).getText().toString();
          localk.bsY = SnsCommentFooter.c(this.rQk);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ab.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
        paramEditable = new k();
        paramEditable.key = SnsCommentFooter.f(this.rQk);
        paramEditable.text = SnsCommentFooter.b(this.rQk).getText().toString();
        paramEditable.bsY = SnsCommentFooter.c(this.rQk);
        if ((paramEditable.text != null) && (paramEditable.text.length() > 0)) {
          this.rQn.add(paramEditable);
        }
      }
      if (this.rQn.size() > 5)
      {
        ab.d("MicroMsg.SnsCommentFooter", "comments remove");
        this.rQn.remove(0);
      }
      SnsCommentFooter.b(this.rQk).requestFocus();
      if (SnsCommentFooter.b(this.rQk).getText().toString().trim().length() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (this.rQk.oxr))
        {
          SnsCommentFooter.a(this.rQk, bool);
          this.rQk.oxr = false;
        }
        if (!bool)
        {
          SnsCommentFooter.a(this.rQk, bool);
          this.rQk.oxr = true;
        }
        AppMethodBeat.o(38883);
        return;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38882);
    if (paramCharSequence == null) {}
    for (paramInt1 = 0;; paramInt1 = paramCharSequence.length())
    {
      this.rQm = paramInt1;
      AppMethodBeat.o(38882);
      return;
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38881);
    if ((paramCharSequence == null) || (paramCharSequence.length() < a.raX))
    {
      this.rQk.EN(16);
      ab.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
      AppMethodBeat.o(38881);
      return;
    }
    if (paramCharSequence.length() - this.rQm > a.raX)
    {
      this.rQk.setCommentFlag(16);
      ab.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
    }
    AppMethodBeat.o(38881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.5
 * JD-Core Version:    0.7.0.1
 */