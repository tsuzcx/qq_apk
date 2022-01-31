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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;

public final class g
  extends q
{
  private View Qz;
  private ProgressBar jba;
  private Context mContext;
  private TextView zag;
  
  private g(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(49335);
    this.mContext = paramContext;
    this.Qz = null;
    if (this.Qz == null)
    {
      this.Qz = View.inflate(this.mContext, 2130971237, null);
      this.zag = ((TextView)this.Qz.findViewById(2131821848));
      this.jba = ((ProgressBar)this.Qz.findViewById(2131821847));
      setCanceledOnTouchOutside(true);
    }
    AppMethodBeat.o(49335);
  }
  
  public static Dialog a(Context paramContext, CharSequence paramCharSequence, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(49339);
    paramContext = new g(paramContext);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    AppMethodBeat.o(49339);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(49341);
    View localView = View.inflate(paramContext, 2130971238, null);
    paramContext = new i(paramContext, 2131493742);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(49341);
    return paramContext;
  }
  
  public static Dialog b(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142677);
    View localView = View.inflate(paramContext, 2130971238, null);
    paramContext = new i(paramContext, 2131493742);
    paramContext.setCancelable(paramBoolean);
    paramContext.setContentView(localView);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(142677);
    return paramContext;
  }
  
  public static Dialog c(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(49343);
    paramContext.getString(2131296919);
    paramContext = h.b(paramContext, paramContext.getString(2131305479), paramBoolean, paramOnCancelListener);
    AppMethodBeat.o(49343);
    return paramContext;
  }
  
  public static Dialog d(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(49340);
    View localView = View.inflate(paramContext, 2130971238, null);
    ((TextView)localView.findViewById(2131829357)).setText(paramString);
    paramContext = new i(paramContext, 2131493742);
    paramContext.setCancelable(false);
    paramContext.setContentView(localView);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(49340);
    return paramContext;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(49344);
    try
    {
      super.dismiss();
      AppMethodBeat.o(49344);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(49344);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(49336);
    super.onCreate(paramBundle);
    setContentView(this.Qz, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -2;
    paramBundle.height = -2;
    getWindow().addFlags(2);
    paramBundle.dimAmount = 0.65F;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(49336);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(49337);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(49337);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(49338);
    this.zag.setText(paramCharSequence);
    AppMethodBeat.o(49338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */