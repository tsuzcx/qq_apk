package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.u;

public class OfflineAlertView
  extends LinearLayout
{
  private View contentView = null;
  public int mLS = 0;
  RelativeLayout mLT = null;
  boolean mLU = true;
  private a mLV = null;
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OfflineAlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.contentView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_alert, this);
    this.mLT = ((RelativeLayout)this.contentView.findViewById(a.f.offline_alert_root));
  }
  
  final void a(View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    this.mLS = paramInt;
    setVisibility(0);
    this.mLT.removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(a.g.wallet_offline_unopened_layout, null);
    if (paramInt == 6) {
      ((TextView)localView.findViewById(a.f.alert_title)).setText(a.i.offline_need_open_again_text);
    }
    for (;;)
    {
      this.mLT.addView(localView);
      ((Button)this.contentView.findViewById(a.f.i_know_btn)).setOnClickListener(paramOnClickListener);
      this.mLU = false;
      paramView.post(new OfflineAlertView.7(this, paramView));
      return;
      if (((paramInt == 3) || (paramInt == 1)) && (b.mC((String)g.DP().Dz().get(274436, null)))) {
        ((TextView)localView.findViewById(a.f.alert_title)).setText(a.i.offline_unopened_pay_desc_gdpr_tips);
      }
    }
  }
  
  public final void dismiss()
  {
    if (this.mLT != null) {
      this.mLT.removeAllViews();
    }
    setVisibility(8);
    if (this.mLV != null) {
      this.mLV.onClose();
    }
    this.mLU = true;
  }
  
  public final boolean isShowing()
  {
    return getVisibility() == 0;
  }
  
  public void setDialogState(a parama)
  {
    this.mLV = parama;
  }
  
  public final boolean vB(int paramInt)
  {
    if ((!isShowing()) || (paramInt == this.mLS)) {}
    while (((paramInt == 2) && ((this.mLS == 3) || (this.mLS == 4) || (this.mLS == 2) || (this.mLS == 5))) || ((paramInt == 5) && (this.mLS == 4)) || (paramInt == 6)) {
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void onClose();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView
 * JD-Core Version:    0.7.0.1
 */