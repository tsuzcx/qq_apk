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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;

final class o
  extends i
  implements DialogInterface
{
  private LinearLayout ERU;
  TextView ERW;
  private TextView ERX;
  LinearLayout ESe;
  private LinearLayout ESg;
  private boolean lA;
  private View lQS;
  private TextView lWE;
  private Context mContext;
  Button zXZ;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.ERU = ((LinearLayout)y.js(this.mContext).inflate(2131494765, null));
    this.zXZ = ((Button)this.ERU.findViewById(2131302314));
    this.lWE = ((TextView)this.ERU.findViewById(2131302315));
    this.ERW = ((TextView)this.ERU.findViewById(2131302307));
    this.ERX = ((TextView)this.ERU.findViewById(2131302312));
    this.lQS = this.ERU.findViewById(2131302316);
    this.ESe = ((LinearLayout)this.ERU.findViewById(2131302308));
    this.ESg = ((LinearLayout)this.ERU.findViewById(2131302303));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void eQR()
  {
    AppMethodBeat.i(33397);
    if (this.ERW != null) {
      this.ERW.setTextColor(this.ERW.getContext().getResources().getColor(2131100242));
    }
    AppMethodBeat.o(33397);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(33402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33392);
          o.this.dismiss();
          AppMethodBeat.o(33392);
        }
      });
      ad.e("MicroMsg.LiteDependDialog", bt.eGN().toString());
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
      ad.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(33402);
    }
  }
  
  public final void eQS()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.ERU);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.ESe.setVisibility(0);
    this.ERW.setVisibility(0);
    this.ERW.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.lQS.setVisibility(0);
    this.lWE.setVisibility(0);
    this.lWE.setMaxLines(2);
    this.lWE.setText(paramInt);
    eQR();
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.lQS.setVisibility(0);
    this.lWE.setVisibility(0);
    this.lWE.setMaxLines(2);
    this.lWE.setText(paramCharSequence);
    eQR();
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
      ad.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
      AppMethodBeat.o(33401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.o
 * JD-Core Version:    0.7.0.1
 */