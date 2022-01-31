package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.LinkedList;

public final class i
{
  public static c a(Context paramContext, b paramb, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    if ((paramb == null) || ((TextUtils.isEmpty(paramb.qtd)) && ((paramb.qte == null) || (paramb.qte.isEmpty()))))
    {
      y.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.nW(false);
    locala.It(a.i.app_cancel).b(paramOnClickListener2);
    if (paramBoolean) {
      locala.Is(a.i.wallet_balance_fetch_all_btn).a(paramOnClickListener1);
    }
    for (;;)
    {
      paramOnClickListener1 = View.inflate(paramContext, a.g.wallet_fetch_info_dialog, null);
      if ((paramb.qte == null) || (paramb.qte.isEmpty())) {
        break;
      }
      paramOnClickListener2 = (LinearLayout)paramOnClickListener1.findViewById(a.f.container);
      paramOnClickListener2.removeAllViews();
      int i = 0;
      while ((i < paramb.qte.size()) && (i < paramb.qte.size()))
      {
        View localView = View.inflate(paramContext, a.g.wallet_fetch_fee_list_item, null);
        TextView localTextView1 = (TextView)localView.findViewById(a.f.title);
        TextView localTextView2 = (TextView)localView.findViewById(a.f.subtitle);
        localTextView1.setText(((b.b)paramb.qte.get(i)).key);
        localTextView2.setText(((b.b)paramb.qte.get(i)).value);
        paramOnClickListener2.addView(localView, i);
        i += 1;
      }
      locala.Ip(a.i.wallet_balance_fetch_dialog_title);
      locala.Is(a.i.wallet_balance_fetch_go_on_btn).a(paramOnClickListener1);
    }
    y.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
    ((TextView)paramOnClickListener1.findViewById(a.f.title)).setText(paramb.qtd);
    if (paramBoolean)
    {
      paramb = (TextView)paramOnClickListener1.findViewById(a.f.tips);
      paramb.setVisibility(0);
      paramb.setText(paramContext.getString(a.i.wallet_balance_fetch_all_tips));
    }
    locala.ei(paramOnClickListener1);
    paramb = locala.aoP();
    paramb.show();
    h.a(paramContext, paramb);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.i
 * JD-Core Version:    0.7.0.1
 */