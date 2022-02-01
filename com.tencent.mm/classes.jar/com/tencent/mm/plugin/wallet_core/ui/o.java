package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.LinkedList;

public final class o
{
  public static e a(Context paramContext, b paramb, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(70939);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(70939);
      return null;
    }
    if ((paramb == null) || ((TextUtils.isEmpty(paramb.VCS)) && ((paramb.VCT == null) || (paramb.VCT.isEmpty()))))
    {
      Log.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
      AppMethodBeat.o(70939);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.NC(false);
    locala.aES(a.i.app_cancel).d(paramOnClickListener2);
    locala.aER(a.i.wallet_balance_fetch_all_btn).c(paramOnClickListener1);
    paramOnClickListener1 = View.inflate(paramContext, a.g.wallet_fetch_info_dialog, null);
    int i;
    if ((paramb.VCT != null) && (!paramb.VCT.isEmpty()))
    {
      paramOnClickListener2 = (LinearLayout)paramOnClickListener1.findViewById(a.f.container);
      paramOnClickListener2.removeAllViews();
      i = 0;
    }
    while ((i < paramb.VCT.size()) && (i < paramb.VCT.size()))
    {
      View localView = View.inflate(paramContext, a.g.wallet_fetch_fee_list_item, null);
      TextView localTextView1 = (TextView)localView.findViewById(a.f.title);
      TextView localTextView2 = (TextView)localView.findViewById(a.f.subtitle);
      localTextView1.setText(((b.b)paramb.VCT.get(i)).key);
      localTextView2.setText(((b.b)paramb.VCT.get(i)).value);
      paramOnClickListener2.addView(localView, i);
      i += 1;
      continue;
      Log.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
    }
    ((TextView)paramOnClickListener1.findViewById(a.f.title)).setText(paramb.VCS);
    paramb = (TextView)paramOnClickListener1.findViewById(a.f.tips);
    paramb.setVisibility(0);
    paramb.setText(paramContext.getString(a.i.wallet_balance_fetch_all_tips));
    locala.md(paramOnClickListener1);
    paramb = locala.jHH();
    paramb.show();
    k.a(paramContext, paramb);
    AppMethodBeat.o(70939);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */