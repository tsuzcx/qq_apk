package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.protocal.c.bxk;

final class b$21
  implements View.OnClickListener
{
  b$21(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ar))
    {
      paramView = (ar)paramView.getTag();
      paramView = af.bDF().OA(paramView.bRV);
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_text_show", paramView.bGe().tNo);
    localIntent.putExtra("sns_local_id", paramView.bGE());
    localIntent.setClass(this.ppl.activity, SnsSingleTextViewUI.class);
    this.ppl.activity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.21
 * JD-Core Version:    0.7.0.1
 */