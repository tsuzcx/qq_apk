package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static Dialog e(Context paramContext, final View paramView)
  {
    View localView = LayoutInflater.from(paramContext).inflate(i.g.lucky_comment_dialog, null);
    Object localObject;
    if (x.cqG()) {
      localObject = "font_1.otf";
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(i.f.lucky_money_title_tv);
      if (!bk.bl((String)localObject)) {
        localTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), (String)localObject));
      }
      if (!x.cqF()) {
        localTextView.setTextSize(1, 10.0F);
      }
      localObject = new Dialog(paramContext, i.k.mmalertdialog);
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setTitle(null);
      ((Dialog)localObject).setOnCancelListener(new a.1((Dialog)localObject));
      ((TextView)localView.findViewById(i.f.go_shake_lucky_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
          if ((this.oof != null) && (this.oof.isShowing())) {
            this.oof.dismiss();
          }
          paramAnonymousView = paramView;
          if (paramAnonymousView != null) {
            paramAnonymousView.performClick();
          }
        }
      });
      paramView = localView.findViewById(i.f.tips_dialog_close_btn);
      int i = BackwardSupportUtil.b.b(paramContext, 10.0F);
      bk.j(paramView, i, i, i, i);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
          if ((this.oof != null) && (this.oof.isShowing())) {
            this.oof.dismiss();
          }
        }
      });
      ((Dialog)localObject).show();
      return localObject;
      if (x.cqH()) {
        localObject = "font_2.otf";
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a
 * JD-Core Version:    0.7.0.1
 */