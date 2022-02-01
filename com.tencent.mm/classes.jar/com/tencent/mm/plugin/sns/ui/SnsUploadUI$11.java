package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SnsUploadUI$11
  implements TextWatcher
{
  private List<ForegroundColorSpan> RqM;
  
  SnsUploadUI$11(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(369908);
    this.RqM = new LinkedList();
    AppMethodBeat.o(369908);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(369909);
    paramEditable = SnsUploadUI.a(this.REd).getText();
    Object localObject = this.RqM.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
    }
    this.RqM.clear();
    localObject = SnsUploadUI.a(this.REd).getText().toString();
    if (((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      localObject = o.a.YoB.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find())
      {
        ((Matcher)localObject).group();
        int i = ((Matcher)localObject).start();
        int j = ((Matcher)localObject).end();
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.REd.getResources().getColor(b.c.Link_100));
        this.RqM.add(localForegroundColorSpan);
        paramEditable.setSpan(localForegroundColorSpan, i, j, 33);
      }
    }
    AppMethodBeat.o(369909);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(99580);
    AppMethodBeat.o(99580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.11
 * JD-Core Version:    0.7.0.1
 */