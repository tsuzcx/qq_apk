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

final class SnsUploadUI$10
  implements TextWatcher
{
  private List<ForegroundColorSpan> KQU;
  
  SnsUploadUI$10(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(293222);
    this.KQU = new LinkedList();
    AppMethodBeat.o(293222);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(293223);
    paramEditable = SnsUploadUI.a(this.LdU).getText();
    Object localObject = this.KQU.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
    }
    this.KQU.clear();
    localObject = SnsUploadUI.a(this.LdU).getText().toString();
    if (((com.tencent.mm.plugin.websearch.api.c)h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      localObject = k.a.Rsi.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find())
      {
        ((Matcher)localObject).group();
        int i = ((Matcher)localObject).start();
        int j = ((Matcher)localObject).end();
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.LdU.getResources().getColor(i.c.Link_100));
        this.KQU.add(localForegroundColorSpan);
        paramEditable.setSpan(localForegroundColorSpan, i, j, 33);
      }
    }
    AppMethodBeat.o(293223);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(99579);
    AppMethodBeat.o(99579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.10
 * JD-Core Version:    0.7.0.1
 */