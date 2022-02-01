package com.tencent.mm.ui.widget.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.ui.av;

public class j
  extends ProgressDialog
{
  private TextView UWd;
  private View mContentView;
  private Context mContext;
  private ProgressBar ros;
  
  public j(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(252049);
    this.mContext = paramContext;
    this.mContentView = View.inflate(this.mContext, a.g.progress_dialog, null);
    this.UWd = ((TextView)this.mContentView.findViewById(a.f.progress_dialog_msg));
    this.ros = ((ProgressBar)this.mContentView.findViewById(a.f.progress_dialog_icon));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(252049);
  }
  
  public static j b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(159394);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, null);
    paramContext.show();
    AppMethodBeat.o(159394);
    return paramContext;
  }
  
  public static j b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(252050);
    paramContext = new j(paramContext, a.j.mmalertdialog);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean);
    paramContext.setOnCancelListener(null);
    paramContext.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(252050);
    return paramContext;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159399);
    try
    {
      super.dismiss();
      AppMethodBeat.o(159399);
      return;
    }
    catch (Exception localException)
    {
      av.e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(159399);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159395);
    super.onCreate(paramBundle);
    setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(159395);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159396);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(159396);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159397);
    this.UWd.setText(paramCharSequence);
    AppMethodBeat.o(159397);
  }
  
  public void show()
  {
    AppMethodBeat.i(159398);
    try
    {
      super.show();
      AppMethodBeat.o(159398);
      return;
    }
    catch (Exception localException)
    {
      av.printErrStackTrace("WeUI.WeUIProgresssDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.j
 * JD-Core Version:    0.7.0.1
 */