package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;

public final class h
  extends r
{
  private TextView NIC;
  private View mContentView;
  private Context mContext;
  private ProgressBar olQ;
  
  private h(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(73061);
    this.mContext = paramContext;
    this.mContentView = null;
    if (this.mContentView == null)
    {
      this.mContentView = View.inflate(this.mContext, 2131496994, null);
      this.NIC = ((TextView)this.mContentView.findViewById(2131304734));
      this.olQ = ((ProgressBar)this.mContentView.findViewById(2131304733));
      setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(73061);
  }
  
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73066);
    View localView = View.inflate(paramContext, 2131496995, null);
    h(paramContext, localView);
    ((TextView)localView.findViewById(2131299657)).setText(paramString);
    paramContext = new i(paramContext, 2131821585);
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
    View localView = View.inflate(paramContext, 2131496995, null);
    h(paramContext, localView);
    paramContext = new i(paramContext, 2131821585);
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
    View localView = View.inflate(paramContext, 2131496995, null);
    h(paramContext, localView);
    paramContext = new i(paramContext, 2131821585);
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
    paramContext = new h(paramContext);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    AppMethodBeat.o(73065);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73069);
    paramContext.getString(2131755797);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131768146), paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(73069);
    return paramContext;
  }
  
  private static void h(Context paramContext, View paramView)
  {
    AppMethodBeat.i(214343);
    float f1 = com.tencent.mm.cb.a.ez(paramContext);
    if (f1 > 1.4F) {
      f1 = 1.4F;
    }
    for (;;)
    {
      float f4 = com.tencent.mm.cb.a.fromDPToPix(paramContext, 8.0F);
      paramContext = (TextView)paramView.findViewById(2131299657);
      float f5 = paramView.getMinimumWidth();
      paramView = paramContext.getPaint();
      float f2 = paramView.measureText(paramContext.getText().toString());
      float f6 = com.tencent.mm.cc.a.gvi();
      if ((f5 - f2) * f6 / 2.0F < f4)
      {
        float[] arrayOfFloat = new float[6];
        float[] tmp93_91 = arrayOfFloat;
        tmp93_91[0] = 1.4F;
        float[] tmp98_93 = tmp93_91;
        tmp98_93[1] = 1.125F;
        float[] tmp103_98 = tmp98_93;
        tmp103_98[2] = 1.12F;
        float[] tmp108_103 = tmp103_98;
        tmp108_103[3] = 1.1F;
        float[] tmp113_108 = tmp108_103;
        tmp113_108[4] = 1.0F;
        float[] tmp117_113 = tmp113_108;
        tmp117_113[5] = 0.8F;
        tmp117_113;
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
      AppMethodBeat.o(214343);
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
    setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -2;
    paramBundle.height = -2;
    getWindow().addFlags(2);
    paramBundle.dimAmount = 0.65F;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(73062);
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
    this.NIC.setText(paramCharSequence);
    AppMethodBeat.o(73064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */