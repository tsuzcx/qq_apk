package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;

public final class p
  extends q
{
  private TextView ERW;
  public ProgressBar lQU;
  private View mContentView;
  private Context mContext;
  private int style;
  
  private p(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(142066);
    this.mContext = paramContext;
    this.style = paramInt2;
    paramInt1 = i;
    switch (this.style)
    {
    }
    for (paramInt1 = i;; paramInt1 = 2131494897)
    {
      this.mContentView = y.js(this.mContext).inflate(paramInt1, null);
      this.ERW = ((TextView)this.mContentView.findViewById(2131302339));
      this.lQU = ((ProgressBar)this.mContentView.findViewById(2131302338));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(142066);
      return;
    }
  }
  
  public static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(142070);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, 0, -1, null);
    AppMethodBeat.o(142070);
    return paramContext;
  }
  
  private static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142071);
    int i = paramInt2;
    if (paramInt2 <= 0) {
      switch (paramInt1)
      {
      default: 
        i = 2131821728;
      }
    }
    for (;;)
    {
      paramContext = new p(paramContext, i, paramInt1);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(142071);
      return paramContext;
      i = 2131821723;
      continue;
      i = 2131821723;
      continue;
      i = 2131821723;
      continue;
      i = 2131821728;
    }
  }
  
  public static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142072);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, paramInt, -1, paramOnCancelListener);
    AppMethodBeat.o(142072);
    return paramContext;
  }
  
  public static p b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142073);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, paramInt1, paramInt2, paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(142073);
    return paramContext;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(142075);
    try
    {
      super.dismiss();
      AppMethodBeat.o(142075);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142075);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142067);
    super.onCreate(paramBundle);
    setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    if (this.style == 2)
    {
      getWindow().addFlags(2);
      paramBundle.dimAmount = 0.65F;
    }
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142067);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(142068);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(142068);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142069);
    this.ERW.setText(paramCharSequence);
    AppMethodBeat.o(142069);
  }
  
  public final void show()
  {
    AppMethodBeat.i(142074);
    try
    {
      super.show();
      AppMethodBeat.o(142074);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMProgressDialog", localException, "", new Object[0]);
      AppMethodBeat.o(142074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.p
 * JD-Core Version:    0.7.0.1
 */