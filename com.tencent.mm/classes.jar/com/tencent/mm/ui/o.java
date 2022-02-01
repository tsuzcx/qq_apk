package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.i;

final class o
  extends i
  implements DialogInterface
{
  Button Dim;
  private LinearLayout Ivb;
  TextView Ivd;
  private TextView Ivf;
  LinearLayout Ivm;
  private LinearLayout Ivo;
  private Context mContext;
  private View mYJ;
  private TextView jdField_new;
  private boolean ov;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.Ivb = ((LinearLayout)z.jV(this.mContext).inflate(2131494765, null));
    this.Dim = ((Button)this.Ivb.findViewById(2131302314));
    this.jdField_new = ((TextView)this.Ivb.findViewById(2131302315));
    this.Ivd = ((TextView)this.Ivb.findViewById(2131302307));
    this.Ivf = ((TextView)this.Ivb.findViewById(2131302312));
    this.mYJ = this.Ivb.findViewById(2131302316);
    this.Ivm = ((LinearLayout)this.Ivb.findViewById(2131302308));
    this.Ivo = ((LinearLayout)this.Ivb.findViewById(2131302303));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void fAJ()
  {
    AppMethodBeat.i(33397);
    if (this.Ivd != null) {
      this.Ivd.setTextColor(this.Ivd.getContext().getResources().getColor(2131100242));
    }
    AppMethodBeat.o(33397);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(33402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33392);
          o.this.dismiss();
          AppMethodBeat.o(33392);
        }
      });
      ae.e("MicroMsg.LiteDependDialog", bu.fpN().toString());
      AppMethodBeat.o(33402);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(33402);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(33402);
    }
  }
  
  public final void fAK()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.Ivb);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.Ivm.setVisibility(0);
    this.Ivd.setVisibility(0);
    this.Ivd.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.mYJ.setVisibility(0);
    this.jdField_new.setVisibility(0);
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText(paramInt);
    fAJ();
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.mYJ.setVisibility(0);
    this.jdField_new.setVisibility(0);
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText(paramCharSequence);
    fAJ();
    AppMethodBeat.o(33395);
  }
  
  public final void show()
  {
    AppMethodBeat.i(33401);
    try
    {
      super.show();
      AppMethodBeat.o(33401);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
      AppMethodBeat.o(33401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.o
 * JD-Core Version:    0.7.0.1
 */