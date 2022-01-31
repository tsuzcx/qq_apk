package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public class h
  extends ClickableSpan
{
  private int dIk = -1;
  int mColor = -1;
  private Context mContext = null;
  public h.a qDo = null;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    this.mColor = this.mContext.getResources().getColor(a.c.wallet_link_color);
    this.dIk = this.mContext.getResources().getColor(a.c.transparent);
  }
  
  public void onClick(View paramView)
  {
    if (this.qDo != null) {
      this.qDo.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(false);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.dIk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */