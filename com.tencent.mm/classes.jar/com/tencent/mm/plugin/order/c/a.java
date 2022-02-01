package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;

public final class a
  extends ClickableSpan
{
  public a MGT;
  private int mBgColor;
  private int mColor;
  private Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(66834);
    this.mContext = null;
    this.MGT = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mContext = paramContext;
    this.mColor = this.mContext.getResources().getColor(a.c.mall_link_color);
    this.mBgColor = -1;
    AppMethodBeat.o(66834);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66835);
    if (this.MGT != null) {
      this.MGT.onClick(paramView);
    }
    AppMethodBeat.o(66835);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(66836);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(true);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.mBgColor;
    AppMethodBeat.o(66836);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.a
 * JD-Core Version:    0.7.0.1
 */