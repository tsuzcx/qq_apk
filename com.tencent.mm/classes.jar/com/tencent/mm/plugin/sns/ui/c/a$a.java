package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.pluginsdk.ui.d.o;

final class a$a
  extends o
{
  a$a(a parama) {}
  
  public final void onClick(View paramView)
  {
    this.pmz.owd.oWp.pkc.onClick(paramView);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.pmz.mActivity.getResources().getColor(i.c.sns_link_bg_color);
    if (this.mmZ)
    {
      paramTextPaint.bgColor = i;
      return;
    }
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */