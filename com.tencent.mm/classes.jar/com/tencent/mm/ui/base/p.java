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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;

public final class p
  extends q
{
  private View Qz;
  public ProgressBar jba;
  private Context mContext;
  private int style;
  private TextView zag;
  
  private p(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(106711);
    this.mContext = paramContext;
    this.style = paramInt2;
    paramInt1 = i;
    switch (this.style)
    {
    }
    for (paramInt1 = i;; paramInt1 = 2130970267)
    {
      this.Qz = w.hM(this.mContext).inflate(paramInt1, null);
      this.zag = ((TextView)this.Qz.findViewById(2131821848));
      this.jba = ((ProgressBar)this.Qz.findViewById(2131821847));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(106711);
      return;
    }
  }
  
  private static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106716);
    int i = paramInt2;
    if (paramInt2 <= 0) {
      switch (paramInt1)
      {
      default: 
        i = 2131493886;
      }
    }
    for (;;)
    {
      paramContext = new p(paramContext, i, paramInt1);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(106716);
      return paramContext;
      i = 2131493881;
      continue;
      i = 2131493881;
      continue;
      i = 2131493881;
      continue;
      i = 2131493886;
    }
  }
  
  public static p b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106718);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, paramInt1, paramInt2, paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(106718);
    return paramContext;
  }
  
  public static p b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(106717);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, 0, -1, paramOnCancelListener);
    AppMethodBeat.o(106717);
    return paramContext;
  }
  
  public static p d(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106715);
    paramContext = a(paramContext, paramCharSequence, true, 0, -1, null);
    AppMethodBeat.o(106715);
    return paramContext;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(106720);
    try
    {
      super.dismiss();
      AppMethodBeat.o(106720);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(106720);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106712);
    super.onCreate(paramBundle);
    setContentView(this.Qz, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    if (this.style == 2)
    {
      getWindow().addFlags(2);
      paramBundle.dimAmount = 0.65F;
    }
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(106712);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(106713);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(106713);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106714);
    this.zag.setText(paramCharSequence);
    AppMethodBeat.o(106714);
  }
  
  public final void show()
  {
    AppMethodBeat.i(106719);
    try
    {
      super.show();
      AppMethodBeat.o(106719);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMProgressDialog", localException, "", new Object[0]);
      AppMethodBeat.o(106719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.p
 * JD-Core Version:    0.7.0.1
 */