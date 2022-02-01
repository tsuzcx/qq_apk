package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;

public final class MobileRemitHistoryRecodUI$e
  extends RecyclerView.v
{
  LinearLayout IjI;
  TextView IjJ;
  View jac;
  TextView mUy;
  TextView qBs;
  TextView yVc;
  
  public MobileRemitHistoryRecodUI$e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(67705);
    this.jac = paramView;
    this.IjI = ((LinearLayout)paramView.findViewById(a.f.name_container));
    this.mUy = ((TextView)paramView.findViewById(a.f.nickname_tv));
    this.IjJ = ((TextView)paramView.findViewById(a.f.realname_tv));
    this.qBs = ((TextView)paramView.findViewById(a.f.phone_tv));
    this.yVc = ((TextView)paramView.findViewById(a.f.state_tv));
    AppMethodBeat.o(67705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.e
 * JD-Core Version:    0.7.0.1
 */