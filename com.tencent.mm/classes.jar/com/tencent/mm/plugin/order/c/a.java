package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ClickableSpan
{
  private int mBgColor;
  private int mColor;
  private Context mContext;
  public a prW;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(43927);
    this.mContext = null;
    this.prW = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mContext = paramContext;
    this.mColor = this.mContext.getResources().getColor(2131690267);
    this.mBgColor = -1;
    AppMethodBeat.o(43927);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43928);
    if (this.prW != null) {
      this.prW.onClick(paramView);
    }
    AppMethodBeat.o(43928);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(43929);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(true);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.mBgColor;
    AppMethodBeat.o(43929);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.a
 * JD-Core Version:    0.7.0.1
 */