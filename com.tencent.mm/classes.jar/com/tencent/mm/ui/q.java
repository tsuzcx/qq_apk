package com.tencent.mm.ui;

import android.app.Dialog;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;

final class q
  extends Dialog
  implements DialogInterface
{
  private boolean fsA;
  private View hou;
  private TextView hrg;
  private Context mContext;
  Button qFr;
  private LinearLayout uLY;
  TextView uLZ;
  private TextView uMa;
  LinearLayout uMb;
  private LinearLayout uMc;
  
  public q(Context paramContext)
  {
    super(paramContext, R.m.mmalertdialog);
    this.mContext = paramContext;
    this.uLY = ((LinearLayout)y.gt(this.mContext).inflate(R.i.mm_alert_comfirm_lite_dependency, null));
    this.qFr = ((Button)this.uLY.findViewById(R.h.mm_alert_ok_btn));
    this.hrg = ((TextView)this.uLY.findViewById(R.h.mm_alert_title));
    this.uLZ = ((TextView)this.uLY.findViewById(R.h.mm_alert_msg));
    this.uMa = ((TextView)this.uLY.findViewById(R.h.mm_alert_msg_subtitle));
    this.hou = this.uLY.findViewById(R.h.mm_alert_title_area);
    this.uMb = ((LinearLayout)this.uLY.findViewById(R.h.mm_alert_msg_area));
    this.uMc = ((LinearLayout)this.uLY.findViewById(R.h.mm_alert_custom_area));
    setCanceledOnTouchOutside(true);
  }
  
  private void FO(int paramInt)
  {
    if (this.uLZ != null) {
      this.uLZ.setTextColor(this.uLZ.getContext().getResources().getColor(paramInt));
    }
  }
  
  public final void cze()
  {
    super.setCancelable(true);
  }
  
  public final void dismiss()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          q.this.dismiss();
        }
      });
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LiteDependDialog", bk.csb().toString());
      return;
    }
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.uLY);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
    setCanceledOnTouchOutside(this.fsA);
  }
  
  public final void setTitle(int paramInt)
  {
    this.hou.setVisibility(0);
    this.hrg.setVisibility(0);
    this.hrg.setMaxLines(2);
    this.hrg.setText(paramInt);
    FO(R.e.dialog_msg_color);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.hou.setVisibility(0);
    this.hrg.setVisibility(0);
    this.hrg.setMaxLines(2);
    this.hrg.setText(paramCharSequence);
    FO(R.e.dialog_msg_color);
  }
  
  public final void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */