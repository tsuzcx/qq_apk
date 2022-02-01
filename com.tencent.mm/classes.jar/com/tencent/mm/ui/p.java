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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;

final class p
  extends i
  implements DialogInterface
{
  Button HRF;
  private LinearLayout NIA;
  TextView NIC;
  private TextView NIE;
  LinearLayout NIK;
  private LinearLayout NIM;
  private TextView jUu;
  private Context mContext;
  private View olO;
  private boolean ox;
  
  public p(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.NIA = ((LinearLayout)aa.jQ(this.mContext).inflate(2131495499, null));
    this.HRF = ((Button)this.NIA.findViewById(2131304709));
    this.jUu = ((TextView)this.NIA.findViewById(2131304710));
    this.NIC = ((TextView)this.NIA.findViewById(2131304701));
    this.NIE = ((TextView)this.NIA.findViewById(2131304707));
    this.olO = this.NIA.findViewById(2131304711);
    this.NIK = ((LinearLayout)this.NIA.findViewById(2131304703));
    this.NIM = ((LinearLayout)this.NIA.findViewById(2131304697));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void gIB()
  {
    AppMethodBeat.i(33397);
    if (this.NIC != null) {
      this.NIC.setTextColor(this.NIC.getContext().getResources().getColor(2131100276));
    }
    AppMethodBeat.o(33397);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(33402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33392);
          p.this.dismiss();
          AppMethodBeat.o(33392);
        }
      });
      Log.e("MicroMsg.LiteDependDialog", Util.getStack().toString());
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
      Log.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(33402);
    }
  }
  
  public final void gIC()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.NIA);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.NIK.setVisibility(0);
    this.NIC.setVisibility(0);
    this.NIC.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.olO.setVisibility(0);
    this.jUu.setVisibility(0);
    this.jUu.setMaxLines(2);
    this.jUu.setText(paramInt);
    gIB();
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.olO.setVisibility(0);
    this.jUu.setVisibility(0);
    this.jUu.setMaxLines(2);
    this.jUu.setText(paramCharSequence);
    gIB();
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
      Log.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
      AppMethodBeat.o(33401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.p
 * JD-Core Version:    0.7.0.1
 */