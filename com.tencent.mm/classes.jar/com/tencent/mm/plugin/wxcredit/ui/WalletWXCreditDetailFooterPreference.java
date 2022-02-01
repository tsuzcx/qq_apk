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
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference
  extends Preference
  implements View.OnClickListener
{
  private TextView JQE;
  private TextView JQF;
  private LayoutInflater mInflater;
  View.OnClickListener zHh;
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72357);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2131495538);
    AppMethodBeat.o(72357);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(72359);
    super.onBindView(paramView);
    this.JQE = ((TextView)paramView.findViewById(2131310316));
    this.JQF = ((TextView)paramView.findViewById(2131310314));
    this.JQE.setOnClickListener(this);
    this.JQF.setOnClickListener(this);
    AppMethodBeat.o(72359);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72360);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.zHh != null) {
      this.zHh.onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72360);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(72358);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2131497026, localViewGroup);
    AppMethodBeat.o(72358);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference
 * JD-Core Version:    0.7.0.1
 */