package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.pluginsdk.ui.d.o;

final class BaseTimeLineItem$c
  extends o
{
  BaseTimeLineItem$c(BaseTimeLineItem paramBaseTimeLineItem) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40126);
    this.sgI.rkX.rON.scx.onClick(paramView);
    AppMethodBeat.o(40126);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(40127);
    int i = this.sgI.mActivity.getResources().getColor(2131690488);
    if (getPress())
    {
      paramTextPaint.bgColor = i;
      AppMethodBeat.o(40127);
      return;
    }
    paramTextPaint.bgColor = 0;
    AppMethodBeat.o(40127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.c
 * JD-Core Version:    0.7.0.1
 */