package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class f
  extends i
  implements View.OnClickListener
{
  protected View ijA;
  private int mScene;
  private View.OnClickListener wQj;
  
  private f(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private f(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821727);
    AppMethodBeat.i(68111);
    this.mScene = 0;
    this.ijA = View.inflate(paramContext, 2131495257, null);
    setContentView(this.ijA);
    ((Button)this.ijA.findViewById(2131297690)).setOnClickListener(this);
    ((Button)this.ijA.findViewById(2131300913)).setOnClickListener(this);
    AppMethodBeat.o(68111);
  }
  
  public static f a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(68114);
    ac.i("RemittanceChargeDialog", "showCostDetail");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      ac.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localf.findViewById(2131304076)).setText(e.D(paramDouble1));
    ((TextView)localf.findViewById(2131299539)).setText(e.D(paramDouble2));
    if (paramDouble3 == 0.0D) {
      ac.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localf.findViewById(2131306062)).setText(e.D(paramDouble3));
    localf.findViewById(2131304012).setVisibility(0);
    if (!bs.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localf.findViewById(2131304034);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localf.findViewById(2131305877).setVisibility(0);
    localf.wQj = paramOnClickListener;
    localf.findViewById(2131302999).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68110);
        if (f.a(f.this) != null)
        {
          f.a(f.this).onClick(paramAnonymousView);
          f.this.dismiss();
        }
        AppMethodBeat.o(68110);
      }
    });
    localf.show();
    com.tencent.mm.ui.base.h.a(paramContext, localf);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(68114);
      return localf;
      com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, double paramDouble)
  {
    AppMethodBeat.i(68113);
    ac.i("RemittanceChargeDialog", "showAlert");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    ac.i("RemittanceChargeDialog", "showTips");
    TextView localTextView = (TextView)localf.findViewById(2131304034);
    if (bs.isNullOrNil(paramString)) {
      ac.e("RemittanceChargeDialog", "desc is null");
    }
    for (;;)
    {
      ((TextView)localf.findViewById(2131301015)).setText(paramContext.getResources().getString(2131762493, new Object[] { e.D(paramDouble) }));
      localf.findViewById(2131305863).setVisibility(0);
      localf.findViewById(2131301016).setVisibility(0);
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
    if (paramView.getId() != 2131302999)
    {
      ac.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == 2131297690)
    {
      if (this.mScene == 1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
        AppMethodBeat.o(68112);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
    AppMethodBeat.o(68112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f
 * JD-Core Version:    0.7.0.1
 */