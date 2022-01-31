package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.m;

final class b$18
  implements View.OnClickListener
{
  b$18(b paramb) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      int i = v.OV((String)paramView.getTag());
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      a.eUR.v(paramView, this.ppl.activity);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.18
 * JD-Core Version:    0.7.0.1
 */