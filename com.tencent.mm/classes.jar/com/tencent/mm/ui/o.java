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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.i;

final class o
  extends i
  implements DialogInterface
{
  Button Bqt;
  private LinearLayout Gph;
  TextView Gpj;
  private TextView Gpk;
  LinearLayout Gpr;
  private LinearLayout Gpt;
  private Context mContext;
  private View msV;
  private TextView myG;
  private boolean mz;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.Gph = ((LinearLayout)z.jD(this.mContext).inflate(2131494765, null));
    this.Bqt = ((Button)this.Gph.findViewById(2131302314));
    this.myG = ((TextView)this.Gph.findViewById(2131302315));
    this.Gpj = ((TextView)this.Gph.findViewById(2131302307));
    this.Gpk = ((TextView)this.Gph.findViewById(2131302312));
    this.msV = this.Gph.findViewById(2131302316);
    this.Gpr = ((LinearLayout)this.Gph.findViewById(2131302308));
    this.Gpt = ((LinearLayout)this.Gph.findViewById(2131302303));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void fgx()
  {
    AppMethodBeat.i(33397);
    if (this.Gpj != null) {
      this.Gpj.setTextColor(this.Gpj.getContext().getResources().getColor(2131100242));
    }
    AppMethodBeat.o(33397);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(33402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33392);
          o.this.dismiss();
          AppMethodBeat.o(33392);
        }
      });
      ac.e("MicroMsg.LiteDependDialog", bs.eWi().toString());
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
      ac.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(33402);
    }
  }
  
  public final void fgy()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.Gph);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.Gpr.setVisibility(0);
    this.Gpj.setVisibility(0);
    this.Gpj.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.msV.setVisibility(0);
    this.myG.setVisibility(0);
    this.myG.setMaxLines(2);
    this.myG.setText(paramInt);
    fgx();
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.msV.setVisibility(0);
    this.myG.setVisibility(0);
    this.myG.setMaxLines(2);
    this.myG.setText(paramCharSequence);
    fgx();
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
      ac.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
      AppMethodBeat.o(33401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.o
 * JD-Core Version:    0.7.0.1
 */