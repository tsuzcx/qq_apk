package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;

final class q
  extends i
  implements DialogInterface
{
  private LinearLayout UWb;
  TextView UWd;
  private TextView UWf;
  LinearLayout UWl;
  private LinearLayout UWn;
  private boolean bxO;
  private Context mContext;
  private TextView mLH;
  private View roq;
  Button xPd;
  
  public q(Context paramContext)
  {
    super(paramContext, R.m.mmalertdialog);
    AppMethodBeat.i(33393);
    this.mContext = paramContext;
    this.UWb = ((LinearLayout)ad.kS(this.mContext).inflate(R.i.mm_alert_comfirm_lite_dependency, null));
    this.xPd = ((Button)this.UWb.findViewById(R.h.mm_alert_ok_btn));
    this.mLH = ((TextView)this.UWb.findViewById(R.h.mm_alert_title));
    this.UWd = ((TextView)this.UWb.findViewById(R.h.mm_alert_msg));
    this.UWf = ((TextView)this.UWb.findViewById(R.h.mm_alert_msg_subtitle));
    this.roq = this.UWb.findViewById(R.h.mm_alert_title_area);
    this.UWl = ((LinearLayout)this.UWb.findViewById(R.h.mm_alert_msg_area));
    this.UWn = ((LinearLayout)this.UWb.findViewById(R.h.mm_alert_custom_area));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(33393);
  }
  
  private void asb(int paramInt)
  {
    AppMethodBeat.i(287888);
    if (this.UWd != null) {
      this.UWd.setTextColor(this.UWd.getContext().getResources().getColor(paramInt));
    }
    AppMethodBeat.o(287888);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(33402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new q.2(this));
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
  
  public final void hHm()
  {
    AppMethodBeat.i(33400);
    super.setCancelable(false);
    AppMethodBeat.o(33400);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33394);
    super.onCreate(paramBundle);
    setContentView(this.UWb);
    AppMethodBeat.o(33394);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(33399);
    super.setCancelable(paramBoolean);
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(33399);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33398);
    this.UWl.setVisibility(0);
    this.UWd.setVisibility(0);
    this.UWd.setText(paramCharSequence);
    AppMethodBeat.o(33398);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(33396);
    this.roq.setVisibility(0);
    this.mLH.setVisibility(0);
    this.mLH.setMaxLines(2);
    this.mLH.setText(paramInt);
    asb(R.e.dialog_msg_color);
    AppMethodBeat.o(33396);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33395);
    this.roq.setVisibility(0);
    this.mLH.setVisibility(0);
    this.mLH.setMaxLines(2);
    this.mLH.setText(paramCharSequence);
    asb(R.e.dialog_msg_color);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */