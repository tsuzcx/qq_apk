package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static Dialog f(Context paramContext, final View paramView)
  {
    AppMethodBeat.i(95200);
    View localView = LayoutInflater.from(paramContext).inflate(i.g.lucky_comment_dialog, null);
    Object localObject;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      localObject = "font_1.otf";
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(i.f.lucky_money_title_tv);
      if (!Util.isNullOrNil((String)localObject)) {
        localTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), (String)localObject));
      }
      if (!LocaleUtil.isChineseAppLang()) {
        localTextView.setTextSize(1, 10.0F);
      }
      localObject = new com.tencent.mm.plugin.crashfix.b.a(paramContext, i.k.mmalertdialog);
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setTitle(null);
      ((Dialog)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(95197);
          Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          AppMethodBeat.o(95197);
        }
      });
      ((TextView)localView.findViewById(i.f.go_shake_lucky_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(95198);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          paramAnonymousView = paramView;
          if (paramAnonymousView != null) {
            paramAnonymousView.performClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(95198);
        }
      });
      paramView = localView.findViewById(i.f.tips_dialog_close_btn);
      int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 10.0F);
      Util.expandViewTouchArea(paramView, i, i, i, i);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(95199);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
          if ((this.JSZ != null) && (this.JSZ.isShowing())) {
            this.JSZ.dismiss();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(95199);
        }
      });
      ((Dialog)localObject).show();
      AppMethodBeat.o(95200);
      return localObject;
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        localObject = "font_2.otf";
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a
 * JD-Core Version:    0.7.0.1
 */