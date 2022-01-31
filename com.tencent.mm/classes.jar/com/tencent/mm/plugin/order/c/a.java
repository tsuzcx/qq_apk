package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public final class a
  extends ClickableSpan
{
  private int dIk = -1;
  private int mColor = -1;
  private Context mContext = null;
  public a.a mRJ = null;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.mColor = this.mContext.getResources().getColor(a.c.mall_link_color);
    this.dIk = -1;
  }
  
  public final void onClick(View paramView)
  {
    if (this.mRJ != null) {
      this.mRJ.onClick(paramView);
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(true);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.dIk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.c.a
 * JD-Core Version:    0.7.0.1
 */