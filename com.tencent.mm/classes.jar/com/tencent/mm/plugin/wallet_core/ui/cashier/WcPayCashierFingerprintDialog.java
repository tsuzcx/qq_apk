package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WcPayCashierFingerprintDialog
  extends i
  implements LifecycleObserver
{
  private ViewGroup iux;
  private ImageView uvJ;
  TextView uvM;
  ImageView uvN;
  TextView uvO;
  a uvP;
  WcPayCashierFingerprintDialog.b uvQ;
  
  public WcPayCashierFingerprintDialog(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(47830);
    init();
    AppMethodBeat.o(47830);
  }
  
  public WcPayCashierFingerprintDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(47831);
    init();
    AppMethodBeat.o(47831);
  }
  
  private void init()
  {
    AppMethodBeat.i(47832);
    initView();
    setContentView(this.iux);
    setCanceledOnTouchOutside(false);
    this.uvP = new a();
    setOnCancelListener(new WcPayCashierFingerprintDialog.1(this));
    setOnDismissListener(new WcPayCashierFingerprintDialog.2(this));
    AppMethodBeat.o(47832);
  }
  
  private void initView()
  {
    AppMethodBeat.i(47833);
    this.iux = ((ViewGroup)View.inflate(getContext(), 2130971281, null));
    this.uvJ = ((ImageView)this.iux.findViewById(2131829471));
    this.uvM = ((TextView)this.iux.findViewById(2131829472));
    this.uvN = ((ImageView)this.iux.findViewById(2131829473));
    this.uvO = ((TextView)this.iux.findViewById(2131829474));
    ImageView localImageView = this.uvJ;
    int i = WcPayCashierDialog.uuP;
    int j = WcPayCashierDialog.uuP;
    bo.n(localImageView, i, i, j, j);
    this.uvJ.setOnClickListener(new WcPayCashierFingerprintDialog.3(this));
    AppMethodBeat.o(47833);
  }
  
  public final int cWC()
  {
    if (this.uvP == null) {
      return 0;
    }
    return this.uvP.usY;
  }
  
  public final void cWD()
  {
    AppMethodBeat.i(142571);
    this.uvN.setImageResource(2131231084);
    this.uvO.setTextColor(getContext().getResources().getColor(2131690159));
    AppMethodBeat.o(142571);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(47835);
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
    cancel();
    AppMethodBeat.o(47835);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47834);
    super.onCreate(paramBundle);
    paramBundle = this.uvP;
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint");
    f.dVD().dVE();
    com.tencent.mm.plugin.soter.d.a.cyb();
    paramBundle.uvS = new ma();
    paramBundle.uvS.cCa.cwk = paramBundle.cnI;
    paramBundle.uvS.cCa.cCc = 1;
    paramBundle.uvS.cCa.cCe = new WcPayCashierFingerprintDialog.a.1(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle.uvS);
    AppMethodBeat.o(47834);
  }
  
  final class a
  {
    public String cnI;
    public l mFC;
    int mGM;
    int usY;
    ma uvS;
    
    a()
    {
      AppMethodBeat.i(47829);
      this.mFC = ((l)g.E(l.class));
      AppMethodBeat.o(47829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */