package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static Dialog h(Context paramContext, View paramView)
  {
    AppMethodBeat.i(95200);
    View localView = LayoutInflater.from(paramContext).inflate(b.g.lucky_comment_dialog, null);
    Object localObject;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      localObject = "font_1.otf";
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(b.f.lucky_money_title_tv);
      if (!Util.isNullOrNil((String)localObject)) {
        localTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), (String)localObject));
      }
      if (!LocaleUtil.isChineseAppLang()) {
        localTextView.setTextSize(1, 10.0F);
      }
      localObject = new com.tencent.mm.plugin.crashfix.b.a(paramContext, b.k.mmalertdialog);
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setTitle(null);
      ((Dialog)localObject).setOnCancelListener(new a.1((Dialog)localObject));
      ((TextView)localView.findViewById(b.f.go_shake_lucky_btn)).setOnClickListener(new a.2((Dialog)localObject, paramView));
      paramView = localView.findViewById(b.f.tips_dialog_close_btn);
      int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 10.0F);
      Util.expandViewTouchArea(paramView, i, i, i, i);
      paramView.setOnClickListener(new a.3((Dialog)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a
 * JD-Core Version:    0.7.0.1
 */