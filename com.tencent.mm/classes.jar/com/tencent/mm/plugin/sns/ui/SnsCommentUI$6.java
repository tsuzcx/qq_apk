package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SnsCommentUI$6
  implements TextWatcher
{
  private List<ForegroundColorSpan> KQU;
  
  SnsCommentUI$6(SnsCommentUI paramSnsCommentUI)
  {
    AppMethodBeat.i(235563);
    this.KQU = new LinkedList();
    AppMethodBeat.o(235563);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(235572);
    paramEditable = SnsCommentUI.b(this.KRc).getText();
    Object localObject = this.KQU.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
    }
    this.KQU.clear();
    localObject = SnsCommentUI.b(this.KRc).getText().toString();
    if (((com.tencent.mm.plugin.websearch.api.c)h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      localObject = k.a.Rsi.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find())
      {
        int i = ((Matcher)localObject).start();
        int j = ((Matcher)localObject).end();
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.KRc.getResources().getColor(i.c.Link_100));
        this.KQU.add(localForegroundColorSpan);
        paramEditable.setSpan(localForegroundColorSpan, i, j, 33);
      }
    }
    AppMethodBeat.o(235572);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.6
 * JD-Core Version:    0.7.0.1
 */