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
import com.tencent.mm.sdk.platformtools.ad;
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
    if ((paramb == null) || ((TextUtils.isEmpty(paramb.Aby)) && ((paramb.Abz == null) || (paramb.Abz.isEmpty()))))
    {
      ad.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
      AppMethodBeat.o(70939);
      return null;
    }
    d.a locala = new d.a(paramContext);
    locala.wX(false);
    locala.aaC(2131755691).c(paramOnClickListener2);
    locala.aaB(2131764976).b(paramOnClickListener1);
    paramOnClickListener1 = View.inflate(paramContext, 2131495950, null);
    int i;
    if ((paramb.Abz != null) && (!paramb.Abz.isEmpty()))
    {
      paramOnClickListener2 = (LinearLayout)paramOnClickListener1.findViewById(2131298736);
      paramOnClickListener2.removeAllViews();
      i = 0;
    }
    while ((i < paramb.Abz.size()) && (i < paramb.Abz.size()))
    {
      View localView = View.inflate(paramContext, 2131495949, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131305902);
      TextView localTextView2 = (TextView)localView.findViewById(2131305529);
      localTextView1.setText(((b.b)paramb.Abz.get(i)).key);
      localTextView2.setText(((b.b)paramb.Abz.get(i)).value);
      paramOnClickListener2.addView(localView, i);
      i += 1;
      continue;
      ad.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
    }
    ((TextView)paramOnClickListener1.findViewById(2131305902)).setText(paramb.Aby);
    paramb = (TextView)paramOnClickListener1.findViewById(2131305884);
    paramb.setVisibility(0);
    paramb.setText(paramContext.getString(2131764977));
    locala.gs(paramOnClickListener1);
    paramb = locala.fft();
    paramb.show();
    h.a(paramContext, paramb);
    AppMethodBeat.o(70939);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m
 * JD-Core Version:    0.7.0.1
 */