package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class EllipsizeTextView
  extends TextView
{
  private String zhp;
  private int zhq;
  private int zhr;
  private EllipsizeTextView.a zhs;
  private CharSequence zht;
  private long zhu = -1L;
  
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
    AppMethodBeat.i(106264);
    this.zhp = paramString;
    this.zhq = paramInt1;
    this.zhr = paramInt2;
    this.zht = paramCharSequence;
    setText(this.zht + "  " + paramString);
    AppMethodBeat.o(106264);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106265);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getMeasuredWidth() > 0) && (!bo.isNullOrNil(this.zhp)) && (this.zhs != null) && (getText() != null) && (getText().length() > 0))
    {
      CharSequence localCharSequence = this.zhs.a(this, this.zht, this.zhp, this.zhq, this.zhr);
      this.zhp = null;
      setText(localCharSequence, TextView.BufferType.SPANNABLE);
      requestLayout();
    }
    AppMethodBeat.o(106265);
  }
  
  public void setLayoutCallback(EllipsizeTextView.a parama)
  {
    this.zhs = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(106266);
    super.setText(paramCharSequence, paramBufferType);
    AppMethodBeat.o(106266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.EllipsizeTextView
 * JD-Core Version:    0.7.0.1
 */