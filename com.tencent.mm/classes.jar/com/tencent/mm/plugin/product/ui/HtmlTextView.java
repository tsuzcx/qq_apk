package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;

public class HtmlTextView
  extends TextView
{
  Html.ImageGetter mTd = new HtmlTextView.2(this);
  Html.TagHandler mTe = new HtmlTextView.3(this);
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HtmlTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setText(String paramString)
  {
    g.DS().a(new HtmlTextView.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView
 * JD-Core Version:    0.7.0.1
 */