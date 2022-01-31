package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.bk;

public class EllipsizeTextView
  extends TextView
{
  private String uSP;
  private int uSQ;
  private int uSR;
  private EllipsizeTextView.a uSS;
  private CharSequence uST;
  private long uSU = -1L;
  
  public EllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EllipsizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2)
  {
    this.uSP = paramString;
    this.uSQ = paramInt1;
    this.uSR = paramInt2;
    this.uST = paramCharSequence;
    setText(this.uST + "  " + paramString);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getMeasuredWidth() > 0) && (!bk.bl(this.uSP)) && (this.uSS != null) && (getText() != null) && (getText().length() > 0))
    {
      CharSequence localCharSequence = this.uSS.a(this, this.uST, this.uSP, this.uSQ, this.uSR);
      this.uSP = null;
      setText(localCharSequence, TextView.BufferType.SPANNABLE);
      requestLayout();
    }
  }
  
  public void setLayoutCallback(EllipsizeTextView.a parama)
  {
    this.uSS = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.EllipsizeTextView
 * JD-Core Version:    0.7.0.1
 */