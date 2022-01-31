package com.tencent.mm.ui.widget.b;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

public class f
  extends ProgressDialog
{
  private View Qz;
  private ProgressBar jba;
  private Context mContext;
  private TextView zag;
  
  public f(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(112694);
    this.mContext = paramContext;
    this.Qz = View.inflate(this.mContext, 2130970475, null);
    this.zag = ((TextView)this.Qz.findViewById(2131826866));
    this.jba = ((ProgressBar)this.Qz.findViewById(2131826865));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(112694);
  }
  
  public static f g(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(112695);
    paramContext = new f(paramContext);
    paramContext.setMessage(paramCharSequence);
    paramContext.setCancelable(false);
    paramContext.setOnCancelListener(null);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    AppMethodBeat.o(112695);
    return paramContext;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(112700);
    try
    {
      super.dismiss();
      AppMethodBeat.o(112700);
      return;
    }
    catch (Exception localException)
    {
      ak.e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(112700);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112696);
    super.onCreate(paramBundle);
    setContentView(this.Qz, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(112696);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(112697);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(112697);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(112698);
    this.zag.setText(paramCharSequence);
    AppMethodBeat.o(112698);
  }
  
  public void show()
  {
    AppMethodBeat.i(112699);
    try
    {
      super.show();
      AppMethodBeat.o(112699);
      return;
    }
    catch (Exception localException)
    {
      ak.printErrStackTrace("WeUI.WeUIProgresssDialog", localException, "", new Object[0]);
      AppMethodBeat.o(112699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.f
 * JD-Core Version:    0.7.0.1
 */