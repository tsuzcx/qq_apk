package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

final class BankCardSelectSortView$1
  implements c.a
{
  BankCardSelectSortView$1(BankCardSelectSortView paramBankCardSelectSortView) {}
  
  public final View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47866);
    Context localContext = this.uwm.getContext();
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(localContext).inflate(2130968834, null);
      paramView = new BankCardSelectSortView.b((byte)0);
      paramView.qiL = ((TextView)localView.findViewById(2131821732));
      paramView.qgt = ((TextView)localView.findViewById(2131821735));
      paramView.qgr = ((CdnImageView)localView.findViewById(2131821734));
      localView.setTag(paramView);
    }
    paramView = (BankCardSelectSortView.b)localView.getTag();
    if ((this.uwm.zsE) && (paramBoolean1))
    {
      paramView.qiL.setText(paramd.zsM);
      paramView.qiL.setVisibility(0);
      paramd = (BankCardSelectSortView.a)paramd.data;
      paramView.qgt.setText(paramd.ppn);
      if (bo.isNullOrNil(paramd.cDz)) {
        break label206;
      }
      paramView.qgr.setUseSdcardCache(true);
      paramView.qgr.hV(paramd.cDz, paramd.uwn);
    }
    for (;;)
    {
      AppMethodBeat.o(47866);
      return localView;
      paramView.qiL.setVisibility(8);
      break;
      label206:
      paramView.qgr.setImageBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.1
 * JD-Core Version:    0.7.0.1
 */