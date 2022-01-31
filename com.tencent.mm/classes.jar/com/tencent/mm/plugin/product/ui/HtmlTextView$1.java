package com.tencent.mm.plugin.product.ui;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.ai.a;

final class HtmlTextView$1
  implements ai.a
{
  private volatile Spanned mTf;
  
  HtmlTextView$1(HtmlTextView paramHtmlTextView, String paramString) {}
  
  public final boolean JS()
  {
    this.mTf = HtmlTextView.a(this.mTh, this.mTg);
    return true;
  }
  
  public final boolean JT()
  {
    HtmlTextView.a(this.mTh, this.mTf, TextView.BufferType.SPANNABLE);
    this.mTh.setMovementMethod(LinkMovementMethod.getInstance());
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|setText";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView.1
 * JD-Core Version:    0.7.0.1
 */