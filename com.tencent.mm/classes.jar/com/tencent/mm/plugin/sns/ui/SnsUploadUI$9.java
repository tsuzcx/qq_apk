package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SnsUploadUI$9
  implements TextWatcher
{
  private List<ForegroundColorSpan> EDf;
  
  SnsUploadUI$9(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(203767);
    this.EDf = new LinkedList();
    AppMethodBeat.o(203767);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(203768);
    paramEditable = SnsUploadUI.a(this.EPZ).getText();
    Object localObject = this.EDf.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
    }
    this.EDf.clear();
    localObject = SnsUploadUI.a(this.EPZ).getText().toString();
    if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      localObject = k.a.Krb.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find())
      {
        ((Matcher)localObject).group();
        int i = ((Matcher)localObject).start();
        int j = ((Matcher)localObject).end();
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(this.EPZ.getResources().getColor(2131099784));
        this.EDf.add(localForegroundColorSpan);
        paramEditable.setSpan(localForegroundColorSpan, i, j, 33);
      }
    }
    AppMethodBeat.o(203768);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.9
 * JD-Core Version:    0.7.0.1
 */