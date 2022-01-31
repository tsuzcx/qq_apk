package com.tencent.mm.plugin.product.ui;

import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.style.StrikethroughSpan;
import org.xml.sax.XMLReader;

final class HtmlTextView$3
  implements Html.TagHandler
{
  HtmlTextView$3(HtmlTextView paramHtmlTextView) {}
  
  private static Object a(Editable paramEditable, Class paramClass)
  {
    paramClass = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramClass.length == 0) {}
    for (;;)
    {
      return null;
      int i = paramClass.length;
      while (i > 0)
      {
        if (paramEditable.getSpanFlags(paramClass[(i - 1)]) == 17) {
          return paramClass[(i - 1)];
        }
        i -= 1;
      }
    }
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    int i;
    if ((paramString.equalsIgnoreCase("strike")) || (paramString.equals("s")))
    {
      i = paramEditable.length();
      if (!paramBoolean) {
        break label50;
      }
      paramEditable.setSpan(new StrikethroughSpan(), i, i, 17);
    }
    label50:
    int j;
    do
    {
      return;
      paramString = a(paramEditable, StrikethroughSpan.class);
      j = paramEditable.getSpanStart(paramString);
      paramEditable.removeSpan(paramString);
    } while (j == i);
    paramEditable.setSpan(new StrikethroughSpan(), j, i, 33);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.3
 * JD-Core Version:    0.7.0.1
 */