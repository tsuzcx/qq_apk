package com.tencent.mm.plugin.product.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;

final class HtmlTextView$2
  implements Html.ImageGetter
{
  HtmlTextView$2(HtmlTextView paramHtmlTextView) {}
  
  public final Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(66918);
    try
    {
      paramString = Drawable.createFromStream(new URL(paramString).openStream(), "");
      if (paramString != null) {
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      AppMethodBeat.o(66918);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(66918);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.2
 * JD-Core Version:    0.7.0.1
 */