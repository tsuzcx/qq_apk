package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.bd;

final class SnsHeader$2
  implements View.OnClickListener
{
  SnsHeader$2(SnsHeader paramSnsHeader, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    int i = 1;
    paramView = af.bDt().abl(SnsHeader.e(this.oYq));
    if ((paramView != null) && ((com.tencent.mm.n.a.gR(paramView.field_type)) || (SnsHeader.f(this.oYq))))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", SnsHeader.e(this.oYq));
      if ((SnsHeader.e(this.oYq) != null) && (SnsHeader.e(this.oYq).length() > 0))
      {
        if (SnsHeader.c(this.oYq) == 1) {
          i = 6;
        }
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.eUR.d(paramView, this.val$context);
      }
      return;
    }
    paramView = ((Activity)this.val$context).getIntent();
    paramView.putExtra("Contact_User", SnsHeader.e(this.oYq));
    com.tencent.mm.plugin.sns.c.a.eUR.d(paramView, this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader.2
 * JD-Core Version:    0.7.0.1
 */