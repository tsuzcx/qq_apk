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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static Dialog f(Context paramContext, final View paramView)
  {
    AppMethodBeat.i(95200);
    View localView = LayoutInflater.from(paramContext).inflate(2131494625, null);
    Object localObject;
    if (ac.eFr()) {
      localObject = "font_1.otf";
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(2131301956);
      if (!bt.isNullOrNil((String)localObject)) {
        localTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), (String)localObject));
      }
      if (!ac.eFq()) {
        localTextView.setTextSize(1, 10.0F);
      }
      localObject = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131821723);
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setTitle(null);
      ((Dialog)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(95197);
          ad.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(95197);
        }
      });
      ((TextView)localView.findViewById(2131300596)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(95198);
          ad.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          paramAnonymousView = paramView;
          if (paramAnonymousView != null) {
            paramAnonymousView.performClick();
          }
          AppMethodBeat.o(95198);
        }
      });
      paramView = localView.findViewById(2131305893);
      int i = BackwardSupportUtil.b.g(paramContext, 10.0F);
      bt.n(paramView, i, i, i, i);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(95199);
          ad.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
          if ((this.wCM != null) && (this.wCM.isShowing())) {
            this.wCM.dismiss();
          }
          AppMethodBeat.o(95199);
        }
      });
      ((Dialog)localObject).show();
      AppMethodBeat.o(95200);
      return localObject;
      if (ac.eFs()) {
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