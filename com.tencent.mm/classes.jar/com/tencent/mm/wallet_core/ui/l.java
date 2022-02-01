package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.i;

public final class l
  extends x
{
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73066);
    View localView = View.inflate(paramContext, a.g.wallet_progress_dialog_view, null);
    k(paramContext, localView);
    ((TextView)localView.findViewById(a.f.dialog_title)).setText(paramString);
    paramContext = new i(paramContext, a.j.WalletProgressDialogStyle);
    paramContext.setCancelable(false);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73066);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73067);
    View localView = View.inflate(paramContext, a.g.wallet_progress_dialog_view, null);
    k(paramContext, localView);
    paramContext = new i(paramContext, a.j.WalletProgressDialogStyle);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73067);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73068);
    View localView = View.inflate(paramContext, a.g.wallet_progress_dialog_view, null);
    k(paramContext, localView);
    paramContext = new i(paramContext, a.j.WalletProgressDialogStyle);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73068);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73065);
    paramContext.getString(a.i.app_empty_string);
    paramContext = k.a(paramContext, paramCharSequence.toString(), paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(73065);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73069);
    paramContext.getString(a.i.app_empty_string);
    paramContext = k.a(paramContext, paramContext.getString(a.i.wallet_pay_loading), paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(73069);
    return paramContext;
  }
  
  private static void k(Context paramContext, View paramView)
  {
    AppMethodBeat.i(242196);
    float f1 = a.getScaleSize(paramContext);
    if (f1 > 1.4F) {
      f1 = 1.4F;
    }
    for (;;)
    {
      float f4 = a.fromDPToPix(paramContext, 8.0F);
      paramContext = (TextView)paramView.findViewById(a.f.dialog_title);
      float f5 = paramView.getMinimumWidth();
      paramView = paramContext.getPaint();
      float f2 = paramView.measureText(paramContext.getText().toString());
      float f6 = c.iRs();
      if ((f5 - f2) * f6 / 2.0F < f4)
      {
        float[] arrayOfFloat = new float[6];
        float[] tmp94_92 = arrayOfFloat;
        tmp94_92[0] = 1.4F;
        float[] tmp99_94 = tmp94_92;
        tmp99_94[1] = 1.125F;
        float[] tmp104_99 = tmp99_94;
        tmp104_99[2] = 1.12F;
        float[] tmp109_104 = tmp104_99;
        tmp109_104[3] = 1.1F;
        float[] tmp114_109 = tmp109_104;
        tmp114_109[4] = 1.0F;
        float[] tmp118_114 = tmp114_109;
        tmp118_114[5] = 0.8F;
        tmp118_114;
        float f7 = paramContext.getTextSize();
        int i = 0;
        float f3;
        for (f2 = f1;; f2 = f3)
        {
          f3 = f2;
          if (i >= 6) {
            break;
          }
          f3 = f2;
          if (f2 >= arrayOfFloat[i])
          {
            f2 = arrayOfFloat[i];
            paramView.setTextSize(f7 / f1 * f2);
            f3 = paramView.measureText(paramContext.getText().toString());
            float f8 = (f5 - f3) * f6 / 2.0F;
            Log.i("MicroMsg.WalletProgressDialog", "resetTextSize viewPx:" + f5 + " tvPx:" + f3 + " fontScale:" + f2 + " distance:" + f8);
            f3 = f2;
            if (f8 >= f4) {
              break;
            }
            f3 = f2;
          }
          i += 1;
        }
        paramContext.setTextSize(0, f7 / f1 * f3);
      }
      AppMethodBeat.o(242196);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(73070);
    try
    {
      super.dismiss();
      AppMethodBeat.o(73070);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(73070);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73062);
    super.onCreate(paramBundle);
    AppMethodBeat.o(73062);
    throw null;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(73063);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(73063);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73064);
    AppMethodBeat.o(73064);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */