package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.c.a;

public final class a
{
  public static com.tencent.mm.ui.widget.a.c a(final Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb, final DialogInterface.OnClickListener paramOnClickListener)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.nW(false);
    locala.nX(true);
    locala.It(a.i.app_cancel).b(paramOnClickListener);
    locala.aez(paramString1);
    paramString1 = View.inflate(paramContext, a.g.wallet_alert_input_with_mmedittext, null);
    paramOnClickListener = (EditText)paramString1.findViewById(a.f.edittext);
    if (!bk.bl(paramString2)) {
      paramOnClickListener.append(j.a(paramContext, paramString2, paramOnClickListener.getTextSize()));
    }
    paramString2 = (TextView)paramString1.findViewById(a.f.tips_tv);
    if (bk.bl(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.Is(a.i.app_ok).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          boolean bool = true;
          if (this.qHy != null) {
            bool = this.qHy.m(paramOnClickListener.getText().toString().trim());
          }
          if (bool)
          {
            paramAnonymousDialogInterface.dismiss();
            if ((paramContext instanceof MMActivity)) {
              ai.d(new a.1.1(this));
            }
          }
        }
      });
      if (paramInt > 0) {
        com.tencent.mm.ui.tools.a.c.d(paramOnClickListener).Ig(paramInt).a(null);
      }
      locala.ei(paramString1);
      paramString2 = locala.aoP();
      paramString2.show();
      if ((paramContext instanceof MMActivity)) {
        ((MMActivity)paramContext).addDialog(paramString2);
      }
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new Runnable()
        {
          public final void run()
          {
            ((MMActivity)this.val$context).showVKB();
          }
        });
      }
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a
 * JD-Core Version:    0.7.0.1
 */