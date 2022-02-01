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
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;

public class w
  extends x
{
  private TextView acro;
  private View mContentView;
  private int style;
  public ProgressBar uyz;
  
  protected w(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(142066);
    this.style = paramInt2;
    switch (this.style)
    {
    default: 
      paramInt1 = a.h.mm_progress_dialog;
    }
    for (;;)
    {
      this.mContentView = af.mU(getContext()).inflate(paramInt1, null);
      this.acro = ((TextView)this.mContentView.findViewById(a.g.mm_progress_dialog_msg));
      this.acro.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(251420);
          if (w.f(w.this).getLineCount() > 1) {
            w.f(w.this).setTextSize(0, a.br(w.this.getContext(), a.e.DescTextSize));
          }
          w.f(w.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          AppMethodBeat.o(251420);
        }
      });
      this.uyz = ((ProgressBar)this.mContentView.findViewById(a.g.mm_progress_dialog_icon));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(142066);
      return;
      paramInt1 = a.h.mm_progress_dialog;
      continue;
      paramInt1 = a.h.mm_progress_dialog_with_bg;
      continue;
      paramInt1 = a.h.mm_progress_dialog;
      continue;
      paramInt1 = a.h.mm_progress_dialog;
    }
  }
  
  public static w a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(142070);
    paramContext = a(paramContext, paramCharSequence, paramBoolean, 0, -1, null);
    AppMethodBeat.o(142070);
    return paramContext;
  }
  
  private static w a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142071);
    int i = paramInt2;
    if (paramInt2 <= 0) {
      switch (paramInt1)
      {
      default: 
        i = a.l.mmtipsdialog;
      }
    }
    for (;;)
    {
      paramContext = new w(paramContext, i, paramInt1);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(142071);
      return paramContext;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmtipsdialog;
    }
  }
  
  public static w a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142072);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, paramInt, -1, paramOnCancelListener);
    AppMethodBeat.o(142072);
    return paramContext;
  }
  
  public static w b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
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
    this.acro.setText(paramCharSequence);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.w
 * JD-Core Version:    0.7.0.1
 */