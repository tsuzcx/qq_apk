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
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.l;

public class p
  extends q
{
  private View QR;
  public ProgressBar hox;
  private Context mContext;
  private int style;
  private TextView uLZ;
  
  public p(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mContext = paramContext;
    this.style = paramInt2;
    switch (this.style)
    {
    default: 
      paramInt1 = a.h.mm_progress_dialog;
    }
    for (;;)
    {
      this.QR = com.tencent.mm.ui.y.gt(this.mContext).inflate(paramInt1, null);
      this.uLZ = ((TextView)this.QR.findViewById(a.g.mm_progress_dialog_msg));
      this.hox = ((ProgressBar)this.QR.findViewById(a.g.mm_progress_dialog_icon));
      setCanceledOnTouchOutside(true);
      return;
      paramInt1 = a.h.mm_progress_dialog;
      continue;
      paramInt1 = a.h.mm_progress_dialog_with_bg;
      continue;
      paramInt1 = a.h.mm_progress_dialog;
    }
  }
  
  public static p a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = a.l.mmtipsdialog;
    }
    for (;;)
    {
      paramContext = new p(paramContext, i, paramInt);
      paramContext.setMessage(paramCharSequence);
      paramContext.setCancelable(paramBoolean);
      paramContext.setOnCancelListener(paramOnCancelListener);
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmalertdialog;
    }
  }
  
  public static p b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = a(paramContext, paramCharSequence, paramBoolean, paramInt, paramOnCancelListener);
    paramContext.show();
    return paramContext;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.QR, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    if (this.style == 2)
    {
      getWindow().addFlags(2);
      paramBundle.dimAmount = 0.65F;
    }
    onWindowAttributesChanged(paramBundle);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.uLZ.setText(paramCharSequence);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMProgressDialog", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.p
 * JD-Core Version:    0.7.0.1
 */