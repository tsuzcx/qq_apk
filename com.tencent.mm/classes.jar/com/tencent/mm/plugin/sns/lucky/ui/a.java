package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static Dialog f(Context paramContext, View paramView)
  {
    AppMethodBeat.i(35903);
    View localView = LayoutInflater.from(paramContext).inflate(2130970013, null);
    Object localObject;
    if (aa.dsD()) {
      localObject = "font_1.otf";
    }
    for (;;)
    {
      TextView localTextView = (TextView)localView.findViewById(2131825541);
      if (!bo.isNullOrNil((String)localObject)) {
        localTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), (String)localObject));
      }
      if (!aa.dsC()) {
        localTextView.setTextSize(1, 10.0F);
      }
      localObject = new com.tencent.mm.plugin.crashfix.b.a(paramContext, 2131493881);
      ((Dialog)localObject).setContentView(localView);
      ((Dialog)localObject).setTitle(null);
      ((Dialog)localObject).setOnCancelListener(new a.1((Dialog)localObject));
      ((TextView)localView.findViewById(2131825543)).setOnClickListener(new a.2((Dialog)localObject, paramView));
      paramView = localView.findViewById(2131825539);
      int i = BackwardSupportUtil.b.b(paramContext, 10.0F);
      bo.n(paramView, i, i, i, i);
      paramView.setOnClickListener(new a.3((Dialog)localObject));
      ((Dialog)localObject).show();
      AppMethodBeat.o(35903);
      return localObject;
      if (aa.dsE()) {
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