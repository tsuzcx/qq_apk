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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.ao;

public class WcPayCashierFingerprintDialog
  extends com.tencent.mm.ui.base.i
  implements LifecycleObserver
{
  private ImageView DCU;
  TextView DCX;
  ImageView DCY;
  TextView DCZ;
  a DDa;
  b DDb;
  private ViewGroup mcI;
  
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
    setContentView(this.mcI);
    setCanceledOnTouchOutside(false);
    this.DDa = new a();
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71418);
        if (WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this) != null) {
          WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this).eMd();
        }
        AppMethodBeat.o(71418);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71419);
        ae.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
        if (WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this) != null)
        {
          WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this).eMg();
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
    this.mcI = ((ViewGroup)View.inflate(getContext(), 2131496058, null));
    this.DCU = ((ImageView)this.mcI.findViewById(2131307048));
    this.DCX = ((TextView)this.mcI.findViewById(2131307049));
    this.DCY = ((ImageView)this.mcI.findViewById(2131307051));
    this.DCZ = ((TextView)this.mcI.findViewById(2131307050));
    this.DCU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71420);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
        WcPayCashierFingerprintDialog.this.cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71420);
      }
    });
    AppMethodBeat.o(71431);
  }
  
  public final void eMf()
  {
    AppMethodBeat.i(71435);
    this.DCY.setImageDrawable(ao.k(getContext(), 2131690621, getContext().getResources().getColor(2131099735)));
    this.DCZ.setTextColor(getContext().getResources().getColor(2131100482));
    AppMethodBeat.o(71435);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71434);
    ae.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
    if (this.DDa != null)
    {
      this.DDa.eMg();
      this.DDa = null;
    }
    this.DCU = null;
    this.DDb = null;
    AppMethodBeat.o(71434);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71433);
    ae.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
    cancel();
    AppMethodBeat.o(71433);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71432);
    super.onCreate(paramBundle);
    paramBundle = this.DDa;
    ae.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.d.a.ejk();
    com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 38);
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    com.tencent.mm.plugin.fingerprint.b.a.f localf = new com.tencent.mm.plugin.fingerprint.b.a.f(paramBundle.trY);
    localf.dmw = paramBundle.dmw;
    locali.a(ak.getContext(), localf, new WcPayCashierFingerprintDialog.a.1(paramBundle));
    AppMethodBeat.o(71432);
  }
  
  final class a
  {
    int DAi;
    com.tencent.mm.plugin.fingerprint.b.a.i DDd;
    public String dmw;
    public String trY;
    com.tencent.mm.plugin.fingerprint.d.a trj;
    
    a()
    {
      AppMethodBeat.i(71426);
      this.trj = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      this.DDd = ((com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class));
      AppMethodBeat.o(71426);
    }
    
    public final void eMg()
    {
      AppMethodBeat.i(71427);
      ae.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
      this.DDd.cancel();
      com.tencent.soter.a.g.f.fZD().fZE();
      this.trj = null;
      this.DDd = null;
      AppMethodBeat.o(71427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
    
    public abstract void eMd();
    
    public abstract void eMe();
    
    public abstract void uI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */