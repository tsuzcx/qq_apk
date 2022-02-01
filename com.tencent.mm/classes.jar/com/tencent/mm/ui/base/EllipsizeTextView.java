package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class EllipsizeTextView
  extends TextView
{
  private String adOl;
  private int adOm;
  private int adOn;
  private a adOo;
  private CharSequence adOp;
  private long adOq = -1L;
  
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
    AppMethodBeat.i(141626);
    this.adOl = paramString;
    this.adOm = paramInt1;
    this.adOn = paramInt2;
    this.adOp = paramCharSequence;
    setText(this.adOp + "  " + paramString);
    AppMethodBeat.o(141626);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141627);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getMeasuredWidth() > 0) && (!Util.isNullOrNil(this.adOl)) && (this.adOo != null) && (getText() != null) && (getText().length() > 0))
    {
      CharSequence localCharSequence = this.adOo.a(this, this.adOp, this.adOl, this.adOm, this.adOn);
      this.adOl = null;
      setText(localCharSequence, TextView.BufferType.SPANNABLE);
      requestLayout();
    }
    AppMethodBeat.o(141627);
  }
  
  public void setLayoutCallback(a parama)
  {
    this.adOo = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(141628);
    super.setText(paramCharSequence, paramBufferType);
    AppMethodBeat.o(141628);
  }
  
  public static abstract interface a
  {
    public abstract CharSequence a(TextView paramTextView, CharSequence paramCharSequence, String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.EllipsizeTextView
 * JD-Core Version:    0.7.0.1
 */