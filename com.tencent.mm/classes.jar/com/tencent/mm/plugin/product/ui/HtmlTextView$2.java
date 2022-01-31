package com.tencent.mm.plugin.product.ui;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import java.net.URL;

final class HtmlTextView$2
  implements Html.ImageGetter
{
  HtmlTextView$2(HtmlTextView paramHtmlTextView) {}
  
  public final Drawable getDrawable(String paramString)
  {
    try
    {
      paramString = Drawable.createFromStream(new URL(paramString).openStream(), "");
      if (paramString != null) {
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.2
 * JD-Core Version:    0.7.0.1
 */