package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
  extends ClickableSpan
{
  public a DfS;
  private int mBgColor;
  public int mColor;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(70927);
    this.DfS = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mColor = paramContext.getResources().getColor(2131101114);
    this.mBgColor = paramContext.getResources().getColor(2131101053);
    AppMethodBeat.o(70927);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70928);
    if (this.DfS != null) {
      this.DfS.onClick(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */