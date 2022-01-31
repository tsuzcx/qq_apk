package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class SnsHeader$1
  implements View.OnClickListener
{
  SnsHeader$1(SnsHeader paramSnsHeader, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.SnsHeader", "change backGround");
    if ((SnsHeader.a(this.oYq) != null) && (SnsHeader.a(this.oYq).isShowing())) {}
    long l;
    do
    {
      return;
      if (SnsHeader.b(this.oYq) != null) {
        SnsHeader.b(this.oYq).bIO();
      }
      if (SnsHeader.c(this.oYq) != 1) {
        break;
      }
      paramView = SnsHeader.d(this.oYq);
      paramView = af.bDJ().OF(paramView);
      l = paramView.field_snsBgId;
    } while ((!SnsHeader.f(this.oYq)) && (l == 0L));
    SnsHeader.a(this.oYq, paramView.bGt());
    label178:
    String str;
    if ((SnsHeader.c(this.oYq) == 1) || (SnsHeader.d(this.oYq).trim().equals(SnsHeader.e(this.oYq).trim())))
    {
      paramView = new String[1];
      paramView[0] = this.val$context.getString(i.j.sns_ui_setback);
      SnsHeader.a(this.oYq, false);
      if (!SnsHeader.g(this.oYq)) {
        break label302;
      }
      str = this.val$context.getString(i.j.sns_set_has_like_bg);
      label200:
      if (!SnsHeader.g(this.oYq)) {
        break label309;
      }
      this.val$context.getString(i.j.app_ok);
    }
    for (;;)
    {
      SnsHeader.a(this.oYq, h.a(this.oYq.getContext(), str, paramView, new SnsHeader.1.1(this, l)));
      return;
      paramView = SnsHeader.e(this.oYq);
      break;
      if (SnsHeader.g(this.oYq))
      {
        paramView = new String[0];
        break label178;
      }
      paramView = new String[1];
      paramView[0] = this.val$context.getString(i.j.sns_love_back);
      break label178;
      label302:
      str = "";
      break label200;
      label309:
      this.val$context.getString(i.j.app_cancel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader.1
 * JD-Core Version:    0.7.0.1
 */