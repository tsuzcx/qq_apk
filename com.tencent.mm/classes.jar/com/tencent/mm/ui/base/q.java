package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public class q
  extends r
{
  private TextView NIC;
  private View mContentView;
  private Context mContext;
  public ProgressBar olQ;
  private int style;
  
  protected q(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(142066);
    this.mContext = paramContext;
    this.style = paramInt2;
    paramInt1 = i;
    switch (this.style)
    {
    }
    for (paramInt1 = i;; paramInt1 = 2131495635)
    {
      this.mContentView = aa.jQ(this.mContext).inflate(paramInt1, null);
      this.NIC = ((TextView)this.mContentView.findViewById(2131304734));
      this.NIC.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(205237);
          if (q.c(q.this).getLineCount() > 1) {
            q.c(q.this).setTextSize(0, a.aG(q.d(q.this), 2131165261));
          }
          q.c(q.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          AppMethodBeat.o(205237);
        }
      });
      this.olQ = ((ProgressBar)this.mContentView.findViewById(2131304733));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(142066);
      return;
    }
  }
  
  public static q a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(142070);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, 0, -1, null);
    AppMethodBeat.o(142070);
    return paramContext;
  }
  
  private static q a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142071);
    int i = paramInt2;
    if (paramInt2 <= 0) {
      switch (paramInt1)
      {
      default: 
        i = 2131821777;
      }
    }
    for (;;)
    {
      paramContext = new q(paramContext, i, paramInt1);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(142071);
      return paramContext;
      i = 2131821772;
      continue;
      i = 2131821772;
      continue;
      i = 2131821772;
      continue;
      i = 2131821777;
    }
  }
  
  public static q a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142072);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, paramInt, -1, paramOnCancelListener);
    AppMethodBeat.o(142072);
    return paramContext;
  }
  
  public static q b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142073);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, paramInt1, paramInt2, paramOnCancelListener);
    paramContext.show();
    AppMethodBeat.o(142073);
    return paramContext;
  }
  
  public void dismiss()
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
      Log.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142075);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142067);
    super.onCreate(paramBundle);
    setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -2;
    paramBundle.height = -2;
    if (this.style == 2)
    {
      getWindow().addFlags(2);
      paramBundle.dimAmount = 0.65F;
    }
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142067);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(142068);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(142068);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142069);
    this.NIC.setText(paramCharSequence);
    AppMethodBeat.o(142069);
  }
  
  public void show()
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
      Log.printErrStackTrace("MicroMsg.MMProgressDialog", localException, "", new Object[0]);
      AppMethodBeat.o(142074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.q
 * JD-Core Version:    0.7.0.1
 */