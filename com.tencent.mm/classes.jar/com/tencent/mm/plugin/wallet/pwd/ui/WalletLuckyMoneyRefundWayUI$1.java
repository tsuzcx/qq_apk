package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.a;
import com.tencent.mm.plugin.wallet.pwd.a.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLuckyMoneyRefundWayUI$1
  implements View.OnClickListener
{
  WalletLuckyMoneyRefundWayUI$1(WalletLuckyMoneyRefundWayUI paramWalletLuckyMoneyRefundWayUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142378);
    ab.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
    a locala = new a(this.tZJ, WalletLuckyMoneyRefundWayUI.a(this.tZJ));
    Object localObject1 = View.inflate(locala.mContext, 2130971242, null);
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131823717);
    if (locala.tZI.tXQ.size() > 0)
    {
      Iterator localIterator = locala.tZI.tXQ.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        i += 1;
        Object localObject2 = View.inflate(locala.mContext, 2130971243, null);
        localLinearLayout.addView((View)localObject2);
        label153:
        TextView localTextView;
        if (i != 1)
        {
          paramView = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
          if ((paramView instanceof ViewGroup.MarginLayoutParams))
          {
            paramView = (ViewGroup.MarginLayoutParams)paramView;
            paramView.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(locala.mContext, 24), 0, 0);
            ((View)localObject2).setLayoutParams(paramView);
          }
        }
        else
        {
          paramView = (ImageView)((View)localObject2).findViewById(2131820929);
          localTextView = (TextView)((View)localObject2).findViewById(2131820680);
          localObject2 = (TextView)((View)localObject2).findViewById(2131821949);
          if (!bo.isNullOrNil(localb.tXS)) {
            break label278;
          }
          com.tencent.mm.at.a.a.ahM().a(localb.ffD, paramView, new c.a().ahY());
        }
        for (;;)
        {
          localTextView.setText(localb.title);
          ((TextView)localObject2).setText(localb.desc);
          break;
          paramView = new ViewGroup.MarginLayoutParams(paramView);
          break label153;
          label278:
          com.tencent.mm.at.a.a locala1 = com.tencent.mm.at.a.a.ahM();
          String str = localb.ffD;
          c.a locala2 = new c.a();
          locala2.cqq = localb.tXS;
          locala1.a(str, paramView, locala2.ahY());
        }
      }
    }
    paramView = new e.a(locala.mContext);
    localObject1 = paramView.aj(locala.tZI.tXP).fv((View)localObject1);
    ((e.a)localObject1).AHs = locala.mContext.getString(2131305291);
    ((e.a)localObject1).Rn(locala.mContext.getResources().getColor(2131690666)).AHv = true;
    paramView.b(new a.1(locala)).show();
    AppMethodBeat.o(142378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI.1
 * JD-Core Version:    0.7.0.1
 */