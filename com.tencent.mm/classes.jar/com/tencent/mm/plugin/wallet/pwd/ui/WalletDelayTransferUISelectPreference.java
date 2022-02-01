package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class WalletDelayTransferUISelectPreference
  extends Preference
{
  private WeImageView HaZ;
  private boolean enable;
  boolean isSelected;
  private View mView;
  
  public WalletDelayTransferUISelectPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.enable = true;
  }
  
  public WalletDelayTransferUISelectPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(315680);
    this.enable = true;
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(315680);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(315685);
    super.onBindView(paramView);
    aBq(8);
    Object localObject = (TextView)paramView.findViewById(16908310);
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getText();; localObject = "")
    {
      if (this.isSelected)
      {
        paramView.setContentDescription(localObject + " " + paramView.getContext().getText(a.i.wallet_delay_transfer_setting_accessibility_selected));
        this.HaZ = ((WeImageView)paramView.findViewById(a.f.state_icon));
        paramView = this.HaZ;
        if (!this.isSelected) {
          break label156;
        }
      }
      label156:
      for (int i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        AppMethodBeat.o(315685);
        return;
        paramView.setContentDescription(localObject + " " + paramView.getContext().getText(a.i.wallet_delay_transfer_setting_accessibility_unselected));
        break;
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(315681);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    localViewGroup.setPadding(0, 0, 0, 0);
    ((ViewGroup)paramViewGroup.findViewById(a.f.right_ll)).setPadding(0, 0, 0, 0);
    View.inflate(this.mContext, a.g.mm_preference_select, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(315681);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferUISelectPreference
 * JD-Core Version:    0.7.0.1
 */