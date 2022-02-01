package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;

public final class g
  extends q
{
  private TextView IaW;
  private View mContentView;
  private Context mContext;
  private ProgressBar mTD;
  
  private g(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(73061);
    this.mContext = paramContext;
    this.mContentView = null;
    if (this.mContentView == null)
    {
      this.mContentView = View.inflate(this.mContext, 2131496014, null);
      this.IaW = ((TextView)this.mContentView.findViewById(2131302339));
      this.mTD = ((ProgressBar)this.mContentView.findViewById(2131302338));
      setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(73061);
  }
  
  public static Dialog a(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73067);
    View localView = View.inflate(paramContext, 2131496015, null);
    paramContext = new i(paramContext, 2131821537);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73067);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73065);
    paramContext = new g(paramContext);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    AppMethodBeat.o(73065);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73068);
    View localView = View.inflate(paramContext, 2131496015, null);
    paramContext = new i(paramContext, 2131821537);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73068);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73066);
    View localView = View.inflate(paramContext, 2131496015, null);
    ((TextView)localView.findViewById(2131299131)).setText(paramString);
    paramContext = new i(paramContext, 2131821537);
    paramContext.setCancelable(false);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(73066);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(73069);
    paramContext.getString(2131755726);
    paramContext = h.b(paramContext, paramContext.getString(2131765693), paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(73069);
    return paramContext;
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
      ad.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + localException.getMessage());
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
    this.IaW.setText(paramCharSequence);
    AppMethodBeat.o(73064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */