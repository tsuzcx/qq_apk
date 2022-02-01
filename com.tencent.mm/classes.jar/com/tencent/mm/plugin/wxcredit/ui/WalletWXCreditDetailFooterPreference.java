package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference
  extends Preference
  implements View.OnClickListener
{
  private TextView XIt;
  private TextView XIu;
  private LayoutInflater mInflater;
  View.OnClickListener tyA;
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72357);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(72357);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(72359);
    super.onBindView(paramView);
    this.XIt = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_detail_username_tv));
    this.XIu = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_detail_help_tv));
    this.XIt.setOnClickListener(this);
    this.XIu.setOnClickListener(this);
    AppMethodBeat.o(72359);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72360);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.tyA != null) {
      this.tyA.onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72360);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(72358);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(a.g.wallet_wxcredit_detail_footer_pref, localViewGroup);
    AppMethodBeat.o(72358);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference
 * JD-Core Version:    0.7.0.1
 */