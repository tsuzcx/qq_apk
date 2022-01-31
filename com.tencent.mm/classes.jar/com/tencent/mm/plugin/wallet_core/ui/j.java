package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  extends ClickableSpan
{
  private int mBgColor;
  public int mColor;
  private Context mContext;
  public j.a uqj;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(47362);
    this.mContext = null;
    this.uqj = null;
    this.mColor = -1;
    this.mBgColor = -1;
    this.mContext = paramContext;
    this.mColor = this.mContext.getResources().getColor(2131690648);
    this.mBgColor = this.mContext.getResources().getColor(2131690605);
    AppMethodBeat.o(47362);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(47363);
    if (this.uqj != null) {
      this.uqj.onClick(paramView);
    }
    AppMethodBeat.o(47363);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(47364);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(false);
    paramTextPaint.setColor(this.mColor);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.bgColor = this.mBgColor;
    AppMethodBeat.o(47364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */