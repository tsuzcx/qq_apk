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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.bc;

public class m
  extends ProgressDialog
{
  private TextView acro;
  private View mContentView;
  private Context mContext;
  private ProgressBar uyz;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(251774);
    this.mContext = paramContext;
    this.mContentView = View.inflate(this.mContext, a.g.progress_dialog, null);
    this.acro = ((TextView)this.mContentView.findViewById(a.f.progress_dialog_msg));
    this.uyz = ((ProgressBar)this.mContentView.findViewById(a.f.progress_dialog_icon));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(251774);
  }
  
  public static m b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(159394);
    paramContext = b(paramContext, paramCharSequence, paramBoolean, null);
    paramContext.show();
    AppMethodBeat.o(159394);
    return paramContext;
  }
  
  public static m b(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(251777);
    paramContext = new m(paramContext, a.j.mmalertdialog);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(paramBoolean);
    paramContext.setOnCancelListener(null);
    paramContext.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(251777);
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
      bc.e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
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
    this.acro.setText(paramCharSequence);
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
      bc.printErrStackTrace("WeUI.WeUIProgresssDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.m
 * JD-Core Version:    0.7.0.1
 */