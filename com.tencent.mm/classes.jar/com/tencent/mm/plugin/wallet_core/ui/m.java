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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

public final class m
{
  public static d a(Context paramContext, b paramb, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(70939);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(70939);
      return null;
    }
    if ((paramb == null) || ((TextUtils.isEmpty(paramb.HVg)) && ((paramb.HVh == null) || (paramb.HVh.isEmpty()))))
    {
      Log.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
      AppMethodBeat.o(70939);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.Dk(false);
    locala.aoW(2131755761).d(paramOnClickListener2);
    locala.aoV(2131767419).c(paramOnClickListener1);
    paramOnClickListener1 = View.inflate(paramContext, 2131496930, null);
    int i;
    if ((paramb.HVh != null) && (!paramb.HVh.isEmpty()))
    {
      paramOnClickListener2 = (LinearLayout)paramOnClickListener1.findViewById(2131299174);
      paramOnClickListener2.removeAllViews();
      i = 0;
    }
    while ((i < paramb.HVh.size()) && (i < paramb.HVh.size()))
    {
      View localView = View.inflate(paramContext, 2131496929, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131309195);
      TextView localTextView2 = (TextView)localView.findViewById(2131308746);
      localTextView1.setText(((b.b)paramb.HVh.get(i)).key);
      localTextView2.setText(((b.b)paramb.HVh.get(i)).value);
      paramOnClickListener2.addView(localView, i);
      i += 1;
      continue;
      Log.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
    }
    ((TextView)paramOnClickListener1.findViewById(2131309195)).setText(paramb.HVg);
    paramb = (TextView)paramOnClickListener1.findViewById(2131309167);
    paramb.setVisibility(0);
    paramb.setText(paramContext.getString(2131767420));
    locala.hs(paramOnClickListener1);
    paramb = locala.hbn();
    paramb.show();
    h.a(paramContext, paramb);
    AppMethodBeat.o(70939);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */