package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.am;

public class WcPayCashierFingerprintDialog
  extends com.tencent.mm.ui.base.i
  implements LifecycleObserver
{
  private ImageView AsE;
  TextView AsH;
  ImageView AsI;
  TextView AsJ;
  a AsK;
  b AsL;
  private ViewGroup kWT;
  
  public WcPayCashierFingerprintDialog(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71428);
    init();
    AppMethodBeat.o(71428);
  }
  
  public WcPayCashierFingerprintDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71429);
    init();
    AppMethodBeat.o(71429);
  }
  
  private void init()
  {
    AppMethodBeat.i(71430);
    initView();
    setContentView(this.kWT);
    setCanceledOnTouchOutside(false);
    this.AsK = new a();
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71418);
        if (WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this) != null) {
          WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this).eeU();
        }
        AppMethodBeat.o(71418);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71419);
        ad.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
        if (WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this) != null)
        {
          WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this).eeX();
          WcPayCashierFingerprintDialog.c(WcPayCashierFingerprintDialog.this);
        }
        WcPayCashierFingerprintDialog.d(WcPayCashierFingerprintDialog.this);
        AppMethodBeat.o(71419);
      }
    });
    AppMethodBeat.o(71430);
  }
  
  private void initView()
  {
    AppMethodBeat.i(71431);
    this.kWT = ((ViewGroup)View.inflate(getContext(), 2131496058, null));
    this.AsE = ((ImageView)this.kWT.findViewById(2131307048));
    this.AsH = ((TextView)this.kWT.findViewById(2131307049));
    this.AsI = ((ImageView)this.kWT.findViewById(2131307051));
    this.AsJ = ((TextView)this.kWT.findViewById(2131307050));
    this.AsE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71420);
        ad.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
        WcPayCashierFingerprintDialog.this.cancel();
        AppMethodBeat.o(71420);
      }
    });
    AppMethodBeat.o(71431);
  }
  
  public final void eeW()
  {
    AppMethodBeat.i(71435);
    this.AsI.setImageDrawable(am.i(getContext(), 2131690621, getContext().getResources().getColor(2131099735)));
    this.AsJ.setTextColor(getContext().getResources().getColor(2131100482));
    AppMethodBeat.o(71435);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71434);
    ad.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
    if (this.AsK != null)
    {
      this.AsK.eeX();
      this.AsK = null;
    }
    this.AsE = null;
    this.AsL = null;
    AppMethodBeat.o(71434);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71433);
    ad.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
    cancel();
    AppMethodBeat.o(71433);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71432);
    super.onCreate(paramBundle);
    paramBundle = this.AsK;
    ad.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.d.a.dEP();
    h.vKh.dB(1104, 38);
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    com.tencent.mm.plugin.fingerprint.b.a.f localf = new com.tencent.mm.plugin.fingerprint.b.a.f(paramBundle.rcj);
    localf.dcE = paramBundle.dcE;
    locali.a(aj.getContext(), localf, new WcPayCashierFingerprintDialog.a.1(paramBundle));
    AppMethodBeat.o(71432);
  }
  
  final class a
  {
    int ApS;
    com.tencent.mm.plugin.fingerprint.b.a.i AsN;
    public String dcE;
    com.tencent.mm.plugin.fingerprint.d.a rbu;
    public String rcj;
    
    a()
    {
      AppMethodBeat.i(71426);
      this.rbu = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      this.AsN = ((com.tencent.mm.plugin.fingerprint.b.a.i)g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class));
      AppMethodBeat.o(71426);
    }
    
    public final void eeX()
    {
      AppMethodBeat.i(71427);
      ad.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
      this.AsN.cancel();
      com.tencent.soter.a.g.f.fnw().fnx();
      this.rbu = null;
      this.AsN = null;
      AppMethodBeat.o(71427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
    
    public abstract void eeU();
    
    public abstract void eeV();
    
    public abstract void sP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */