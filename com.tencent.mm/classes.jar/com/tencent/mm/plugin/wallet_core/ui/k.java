package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.LinkedList;

public final class k
{
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, com.tencent.mm.plugin.wallet_core.model.c paramc, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(142507);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(142507);
      return null;
    }
    if ((paramc == null) || ((TextUtils.isEmpty(paramc.ufo)) && ((paramc.ufp == null) || (paramc.ufp.isEmpty()))))
    {
      ab.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
      AppMethodBeat.o(142507);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.rG(false);
    locala.Rj(2131296888).b(paramOnClickListener2);
    locala.Ri(2131304793).a(paramOnClickListener1);
    paramOnClickListener1 = View.inflate(paramContext, 2130971175, null);
    int i;
    if ((paramc.ufp != null) && (!paramc.ufp.isEmpty()))
    {
      paramOnClickListener2 = (LinearLayout)paramOnClickListener1.findViewById(2131821084);
      paramOnClickListener2.removeAllViews();
      i = 0;
    }
    while ((i < paramc.ufp.size()) && (i < paramc.ufp.size()))
    {
      View localView = View.inflate(paramContext, 2130971174, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131820680);
      TextView localTextView2 = (TextView)localView.findViewById(2131821949);
      localTextView1.setText(((c.b)paramc.ufp.get(i)).key);
      localTextView2.setText(((c.b)paramc.ufp.get(i)).value);
      paramOnClickListener2.addView(localView, i);
      i += 1;
      continue;
      ab.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
    }
    ((TextView)paramOnClickListener1.findViewById(2131820680)).setText(paramc.ufo);
    paramc = (TextView)paramOnClickListener1.findViewById(2131821001);
    paramc.setVisibility(0);
    paramc.setText(paramContext.getString(2131304794));
    locala.fu(paramOnClickListener1);
    paramc = locala.aLZ();
    paramc.show();
    h.a(paramContext, paramc);
    AppMethodBeat.o(142507);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */