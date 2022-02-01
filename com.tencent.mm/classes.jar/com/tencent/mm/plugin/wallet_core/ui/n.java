package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.wallet_core.ui.g;

public class n
  extends ClickableSpan
{
  public n.a VPb;
  private int mBgColor;
  int mColor;
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(70927);
    this.VPb = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mColor = paramContext.getResources().getColor(a.c.wallet_link_color);
    this.mBgColor = paramContext.getResources().getColor(a.c.transparent);
    AppMethodBeat.o(70927);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70928);
    if (this.VPb != null)
    {
      this.VPb.onClick(paramView);
      g.mH(paramView);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */