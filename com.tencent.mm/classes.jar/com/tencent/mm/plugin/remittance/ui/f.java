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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;

public final class f
  extends i
  implements View.OnClickListener
{
  private View.OnClickListener Cuz;
  protected View jBN;
  private int mScene;
  
  private f(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private f(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821776);
    AppMethodBeat.i(68111);
    this.mScene = 0;
    this.jBN = View.inflate(paramContext, 2131496104, null);
    setContentView(this.jBN);
    ((Button)this.jBN.findViewById(2131297963)).setOnClickListener(this);
    ((Button)this.jBN.findViewById(2131302525)).setOnClickListener(this);
    AppMethodBeat.o(68111);
  }
  
  public static f a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(68114);
    Log.i("RemittanceChargeDialog", "showCostDetail");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      Log.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localf.findViewById(2131306939)).setText(com.tencent.mm.wallet_core.ui.f.D(paramDouble1));
    ((TextView)localf.findViewById(2131300187)).setText(com.tencent.mm.wallet_core.ui.f.D(paramDouble2));
    if (paramDouble3 == 0.0D) {
      Log.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localf.findViewById(2131309391)).setText(com.tencent.mm.wallet_core.ui.f.D(paramDouble3));
    localf.findViewById(2131306868).setVisibility(0);
    if (!Util.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localf.findViewById(2131306897);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localf.findViewById(2131309159).setVisibility(0);
    localf.Cuz = paramOnClickListener;
    localf.findViewById(2131305592).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68110);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    com.tencent.mm.ui.base.h.a(paramContext, localf);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(68114);
      return localf;
      com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, double paramDouble)
  {
    AppMethodBeat.i(68113);
    Log.i("RemittanceChargeDialog", "showAlert");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    Log.i("RemittanceChargeDialog", "showTips");
    TextView localTextView = (TextView)localf.findViewById(2131306897);
    if (Util.isNullOrNil(paramString)) {
      Log.e("RemittanceChargeDialog", "desc is null");
    }
    for (;;)
    {
      ((TextView)localf.findViewById(2131302659)).setText(paramContext.getResources().getString(2131764560, new Object[] { com.tencent.mm.wallet_core.ui.f.D(paramDouble) }));
      localf.findViewById(2131309145).setVisibility(0);
      localf.findViewById(2131302660).setVisibility(0);
      localf.show();
      com.tencent.mm.ui.base.h.a(paramContext, localf);
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
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() != 2131305592)
    {
      Log.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == 2131297963)
    {
      if (this.mScene != 1) {
        break label117;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68112);
      return;
      label117:
      com.tencent.mm.plugin.report.service.h.CyF.a(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f
 * JD-Core Version:    0.7.0.1
 */