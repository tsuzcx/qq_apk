package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;

public final class a
{
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, h.b paramb, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(47862);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(47862);
      return null;
    }
    c.a locala = new c.a(paramContext);
    locala.rG(false);
    locala.rH(true);
    locala.Rj(2131296888).b(paramOnClickListener);
    locala.avm(paramString1);
    paramString1 = View.inflate(paramContext, 2130971123, null);
    paramOnClickListener = (EditText)paramString1.findViewById(2131820995);
    if (!bo.isNullOrNil(paramString2)) {
      paramOnClickListener.append(j.b(paramContext, paramString2, paramOnClickListener.getTextSize()));
    }
    ((TextView)paramString1.findViewById(2131823916)).setVisibility(8);
    if (!bo.isNullOrNil(paramString3)) {
      paramOnClickListener.setHint(paramString3);
    }
    locala.Ri(2131297018).a(false, new a.1(paramb, paramOnClickListener, paramContext));
    if (paramInt > 0) {
      com.tencent.mm.ui.tools.b.c.d(paramOnClickListener).QS(paramInt).a(null);
    }
    locala.fu(paramString1);
    paramString2 = locala.aLZ();
    paramString2.show();
    a(paramContext, paramString2);
    if ((paramContext instanceof MMActivity)) {
      paramString1.post(new a.2(paramContext));
    }
    AppMethodBeat.o(47862);
    return paramString2;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, a.a parama, e.c paramc)
  {
    AppMethodBeat.i(47863);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      AppMethodBeat.o(47863);
      return null;
    }
    e.a locala = new e.a(paramContext);
    locala.rI(true);
    locala.a(paramc);
    locala.aj(paramString1);
    paramString1 = View.inflate(paramContext, 2130971124, null);
    paramc = (EditText)paramString1.findViewById(2131820995);
    if (!bo.isNullOrNil(paramString2)) {
      paramc.append(j.b(paramContext, paramString2, paramc.getTextSize()));
    }
    if (!bo.isNullOrNil(paramString3)) {
      paramc.setHint(paramString3);
    }
    paramString2 = (LinearLayout)paramString1.findViewById(2131828922);
    paramString3 = (LinearLayout)paramString1.findViewById(2131825265);
    TextView localTextView1 = (TextView)paramString1.findViewById(2131827258);
    TextView localTextView2 = (TextView)paramString1.findViewById(2131827259);
    TextView localTextView3 = (TextView)paramString1.findViewById(2131828924);
    ((ImageView)paramString1.findViewById(2131828923)).getDrawable().setColorFilter(-15970418, PorterDuff.Mode.SRC_ATOP);
    localTextView3.setText(ah.getContext().getString(2131302513));
    paramString2.setOnClickListener(new a.3(parama, paramc, paramContext, locala));
    if (paramBoolean)
    {
      paramString2.setVisibility(0);
      paramString3.setVisibility(8);
    }
    for (;;)
    {
      locala.Rm(2131297018).b(new a.6(paramContext, parama, localTextView1, paramc, paramString4, paramString5, localTextView2));
      com.tencent.mm.ui.tools.b.c.d(paramc).QS(20).a(null);
      locala.fv(paramString1);
      locala.show();
      if ((paramContext instanceof MMActivity)) {
        locala.gwf.getContentView().post(new a.7(paramContext));
      }
      al.d(new a.8(paramContext, paramc));
      AppMethodBeat.o(47863);
      return null;
      paramString2.setVisibility(8);
      paramString3.setVisibility(0);
      localTextView1.setText(paramString4 + "  " + paramString5);
      localTextView2.setText(paramString6);
      paramString1.findViewById(2131828925).setOnClickListener(new a.4(parama, paramc, paramString4, paramString5, localTextView2, paramContext, locala));
      paramString1.findViewById(2131828926).setOnClickListener(new a.5(paramString2, paramString3, localTextView1, localTextView2));
    }
  }
  
  private static void a(Context paramContext, Dialog paramDialog)
  {
    AppMethodBeat.i(47864);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).addDialog(paramDialog);
    }
    AppMethodBeat.o(47864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a
 * JD-Core Version:    0.7.0.1
 */