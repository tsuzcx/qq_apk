package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

final class BankRemitSortView$1
  implements c.a
{
  BankRemitSortView$1(BankRemitSortView paramBankRemitSortView) {}
  
  public final View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(44698);
    Object localObject = this.qiK.getContext();
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from((Context)localObject).inflate(2130968834, null);
      paramView = new BankRemitSortView.a(this.qiK, (byte)0);
      paramView.qiL = ((TextView)localView.findViewById(2131821732));
      paramView.qgt = ((TextView)localView.findViewById(2131821735));
      paramView.qgr = ((CdnImageView)localView.findViewById(2131821734));
      localView.setTag(paramView);
    }
    paramView = (BankRemitSortView.a)localView.getTag();
    localObject = (hi)paramd.data;
    if (localObject != null) {
      if ((this.qiK.zsE) && (paramBoolean1)) {
        if (paramd.zsM.equals("☆"))
        {
          paramView.qiL.setText(2131297510);
          paramView.qiL.setVisibility(0);
          label162:
          paramView.qgr.setUseSdcardCache(true);
          paramView.qgr.hV(((hi)localObject).qfY, b.WX(((hi)localObject).qfY));
          paramView.qgt.setText(((hi)localObject).nLq);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44698);
      return localView;
      paramView.qiL.setText(paramd.zsM);
      break;
      paramView.qiL.setVisibility(8);
      break label162;
      ab.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView.1
 * JD-Core Version:    0.7.0.1
 */