package com.tencent.mm.plugin.product.ui;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al.a;

final class HtmlTextView$1
  implements al.a
{
  private volatile Spanned pvl;
  
  HtmlTextView$1(HtmlTextView paramHtmlTextView, String paramString) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(44009);
    this.pvl = HtmlTextView.a(this.pvn, this.pvm);
    AppMethodBeat.o(44009);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(44010);
    HtmlTextView.a(this.pvn, this.pvl, TextView.BufferType.SPANNABLE);
    this.pvn.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(44010);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(44011);
    String str = super.toString() + "|setText";
    AppMethodBeat.o(44011);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.1
 * JD-Core Version:    0.7.0.1
 */