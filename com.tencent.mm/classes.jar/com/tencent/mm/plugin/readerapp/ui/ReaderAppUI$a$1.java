package com.tencent.mm.plugin.readerapp.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class ReaderAppUI$a$1
  implements Html.ImageGetter
{
  ReaderAppUI$a$1(ReaderAppUI.a parama) {}
  
  public final Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(76822);
    int i = bo.getInt(paramString, 0);
    paramString = this.pUn.pUg.getResources().getDrawable(i);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    AppMethodBeat.o(76822);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.1
 * JD-Core Version:    0.7.0.1
 */