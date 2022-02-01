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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.i;

final class s
  extends i
  implements DialogInterface
{
  Button BoW;
  private LinearLayout acrm;
  TextView acro;
  private TextView acrq;
  LinearLayout acrw;
  private LinearLayout acry;
  private boolean dqR;
  private Context mContext;
  private TextView pIp;
  private View uyx;
  
  public s(Context paramContext)
  {
    super(paramContext, R.m.mmalertdialog);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.acrm = ((LinearLayout)af.mU(this.mContext).inflate(R.i.mm_alert_comfirm_lite_dependency, null));
    this.BoW = ((Button)this.acrm.findViewById(R.h.mm_alert_ok_btn));
    this.pIp = ((TextView)this.acrm.findViewById(R.h.mm_alert_title));
    this.acro = ((TextView)this.acrm.findViewById(R.h.mm_alert_msg));
    this.acrq = ((TextView)this.acrm.findViewById(R.h.mm_alert_msg_subtitle));
    this.uyx = this.acrm.findViewById(R.h.mm_alert_title_area);
    this.acrw = ((LinearLayout)this.acrm.findViewById(R.h.mm_alert_msg_area));
    this.acry = ((LinearLayout)this.acrm.findViewById(R.h.mm_alert_custom_area));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void ayg(int paramInt)
  {
    AppMethodBeat.i(249172);
    if (this.acro != null) {
      this.acro.setTextColor(this.acro.getContext().getResources().getColor(paramInt));
    }
    AppMethodBeat.o(249172);
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
          s.this.dismiss();
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
  
  public final void jjx()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.acrm);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.acrw.setVisibility(0);
    this.acro.setVisibility(0);
    this.acro.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.uyx.setVisibility(0);
    this.pIp.setVisibility(0);
    this.pIp.setMaxLines(2);
    this.pIp.setText(paramInt);
    ayg(R.e.dialog_msg_color);
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.uyx.setVisibility(0);
    this.pIp.setVisibility(0);
    this.pIp.setMaxLines(2);
    this.pIp.setText(paramCharSequence);
    ayg(R.e.dialog_msg_color);
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
 * Qualified Name:     com.tencent.mm.ui.s
 * JD-Core Version:    0.7.0.1
 */