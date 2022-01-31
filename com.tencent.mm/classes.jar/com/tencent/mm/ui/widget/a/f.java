package com.tencent.mm.ui.widget.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ci.a.j;
import com.tencent.mm.ui.ao;

public final class f
  extends ProgressDialog
{
  private View QR;
  private ProgressBar hox;
  private Context mContext;
  private TextView uLZ;
  
  private f(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.QR = View.inflate(this.mContext, a.g.progress_dialog, null);
    this.uLZ = ((TextView)this.QR.findViewById(a.f.progress_dialog_msg));
    this.hox = ((ProgressBar)this.QR.findViewById(a.f.progress_dialog_icon));
    setCanceledOnTouchOutside(true);
  }
  
  public static f e(Context paramContext, CharSequence paramCharSequence)
  {
    paramContext = new f(paramContext, a.j.mmalertdialog);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(false);
    paramContext.setOnCancelListener(null);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    return paramContext;
  }
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      ao.v("dismiss exception, e = " + localException.getMessage(), new Object[0]);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.QR, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    this.uLZ.setText(paramCharSequence);
  }
  
  public final void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      ao.a(localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */