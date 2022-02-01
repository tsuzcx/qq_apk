package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;

public class m
  extends ClickableSpan
{
  public a OYN;
  private int mBgColor;
  int mColor;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(70927);
    this.OYN = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mColor = paramContext.getResources().getColor(a.c.wallet_link_color);
    this.mBgColor = paramContext.getResources().getColor(a.c.transparent);
    AppMethodBeat.o(70927);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70928);
    if (this.OYN != null) {
      this.OYN.onClick(paramView);
    }
    AppMethodBeat.o(70928);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(70929);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(false);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.mBgColor;
    AppMethodBeat.o(70929);
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */