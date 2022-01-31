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

final class BaseTimeLineItem$a
  extends o
{
  BaseTimeLineItem$a(BaseTimeLineItem paramBaseTimeLineItem) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40121);
    this.sgI.rkX.rON.scG.onClick(paramView);
    AppMethodBeat.o(40121);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(40122);
    int i = this.sgI.mActivity.getResources().getColor(2131690488);
    if (getPress())
    {
      paramTextPaint.bgColor = i;
      AppMethodBeat.o(40122);
      return;
    }
    paramTextPaint.bgColor = 0;
    AppMethodBeat.o(40122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.a
 * JD-Core Version:    0.7.0.1
 */