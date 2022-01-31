package com.tencent.mm.plugin.readerapp.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.mm.sdk.platformtools.bk;

final class ReaderAppUI$a$1
  implements Html.ImageGetter
{
  ReaderAppUI$a$1(ReaderAppUI.a parama) {}
  
  public final Drawable getDrawable(String paramString)
  {
    int i = bk.getInt(paramString, 0);
    paramString = this.noZ.noS.getResources().getDrawable(i);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.1
 * JD-Core Version:    0.7.0.1
 */