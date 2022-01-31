package com.tencent.mm.plugin.product.ui;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.style.StrikethroughSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.XMLReader;

final class HtmlTextView$3
  implements Html.TagHandler
{
  HtmlTextView$3(HtmlTextView paramHtmlTextView) {}
  
  private static Object a(Editable paramEditable, Class paramClass)
  {
    AppMethodBeat.i(44014);
    paramClass = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramClass.length == 0)
    {
      AppMethodBeat.o(44014);
      return null;
    }
    int i = paramClass.length;
    while (i > 0)
    {
      if (paramEditable.getSpanFlags(paramClass[(i - 1)]) == 17)
      {
        paramEditable = paramClass[(i - 1)];
        AppMethodBeat.o(44014);
        return paramEditable;
      }
      i -= 1;
    }
    AppMethodBeat.o(44014);
    return null;
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    AppMethodBeat.i(44013);
    if ((paramString.equalsIgnoreCase("strike")) || (paramString.equals("s")))
    {
      int i = paramEditable.length();
      if (paramBoolean)
      {
        paramEditable.setSpan(new StrikethroughSpan(), i, i, 17);
        AppMethodBeat.o(44013);
        return;
      }
      paramString = a(paramEditable, StrikethroughSpan.class);
      int j = paramEditable.getSpanStart(paramString);
      paramEditable.removeSpan(paramString);
      if (j != i) {
        paramEditable.setSpan(new StrikethroughSpan(), j, i, 33);
      }
    }
    AppMethodBeat.o(44013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.3
 * JD-Core Version:    0.7.0.1
 */