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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;

final class o
  extends i
  implements DialogInterface
{
  Button CQI;
  private LinearLayout IaU;
  TextView IaW;
  private TextView IaX;
  LinearLayout Ibe;
  private LinearLayout Ibg;
  private Context mContext;
  private View mTB;
  private TextView mZo;
  private boolean ov;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.IaU = ((LinearLayout)z.jO(this.mContext).inflate(2131494765, null));
    this.CQI = ((Button)this.IaU.findViewById(2131302314));
    this.mZo = ((TextView)this.IaU.findViewById(2131302315));
    this.IaW = ((TextView)this.IaU.findViewById(2131302307));
    this.IaX = ((TextView)this.IaU.findViewById(2131302312));
    this.mTB = this.IaU.findViewById(2131302316);
    this.Ibe = ((LinearLayout)this.IaU.findViewById(2131302308));
    this.Ibg = ((LinearLayout)this.IaU.findViewById(2131302303));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void fwJ()
  {
    AppMethodBeat.i(33397);
    if (this.IaW != null) {
      this.IaW.setTextColor(this.IaW.getContext().getResources().getColor(2131100242));
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
      ad.e("MicroMsg.LiteDependDialog", bt.flS().toString());
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
  
  public final void fwK()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.IaU);
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
    this.Ibe.setVisibility(0);
    this.IaW.setVisibility(0);
    this.IaW.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.mTB.setVisibility(0);
    this.mZo.setVisibility(0);
    this.mZo.setMaxLines(2);
    this.mZo.setText(paramInt);
    fwJ();
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.mTB.setVisibility(0);
    this.mZo.setVisibility(0);
    this.mZo.setMaxLines(2);
    this.mZo.setText(paramCharSequence);
    fwJ();
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