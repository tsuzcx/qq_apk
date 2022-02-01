package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class f
  extends i
  implements View.OnClickListener
{
  protected View iCR;
  private int mScene;
  private View.OnClickListener ydR;
  
  private f(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private f(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(68111);
    this.mScene = 0;
    this.iCR = View.inflate(paramContext, 2131495257, null);
    setContentView(this.iCR);
    ((Button)this.iCR.findViewById(2131297690)).setOnClickListener(this);
    ((Button)this.iCR.findViewById(2131300913)).setOnClickListener(this);
    AppMethodBeat.o(68111);
  }
  
  public static f a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(68114);
    ad.i("RemittanceChargeDialog", "showCostDetail");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      ad.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localf.findViewById(2131304076)).setText(e.D(paramDouble1));
    ((TextView)localf.findViewById(2131299539)).setText(e.D(paramDouble2));
    if (paramDouble3 == 0.0D) {
      ad.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localf.findViewById(2131306062)).setText(e.D(paramDouble3));
    localf.findViewById(2131304012).setVisibility(0);
    if (!bt.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localf.findViewById(2131304034);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localf.findViewById(2131305877).setVisibility(0);
    localf.ydR = paramOnClickListener;
    localf.findViewById(2131302999).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68110);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (f.a(f.this) != null)
        {
          f.a(f.this).onClick(paramAnonymousView);
          f.this.dismiss();
        }
        a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68110);
      }
    });
    localf.show();
    h.a(paramContext, localf);
    if (paramInt == 1) {
      g.yhR.f(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(68114);
      return localf;
      g.yhR.f(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, double paramDouble)
  {
    AppMethodBeat.i(68113);
    ad.i("RemittanceChargeDialog", "showAlert");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    ad.i("RemittanceChargeDialog", "showTips");
    TextView localTextView = (TextView)localf.findViewById(2131304034);
    if (bt.isNullOrNil(paramString)) {
      ad.e("RemittanceChargeDialog", "desc is null");
    }
    for (;;)
    {
      ((TextView)localf.findViewById(2131301015)).setText(paramContext.getResources().getString(2131762493, new Object[] { e.D(paramDouble) }));
      localf.findViewById(2131305863).setVisibility(0);
      localf.findViewById(2131301016).setVisibility(0);
      localf.show();
      h.a(paramContext, localf);
      AppMethodBeat.o(68113);
      return;
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68112);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() != 2131302999)
    {
      ad.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == 2131297690)
    {
      if (this.mScene != 1) {
        break label117;
      }
      g.yhR.f(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68112);
      return;
      label117:
      g.yhR.f(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f
 * JD-Core Version:    0.7.0.1
 */