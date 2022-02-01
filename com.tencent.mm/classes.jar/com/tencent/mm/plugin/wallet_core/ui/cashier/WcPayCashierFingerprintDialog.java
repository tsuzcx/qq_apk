package com.tencent.mm.plugin.wallet_core.ui.cashier;

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
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;

public class WcPayCashierFingerprintDialog
  extends com.tencent.mm.ui.base.i
  implements k
{
  TextView PeB;
  ImageView PeC;
  TextView PeD;
  a PeE;
  b PeF;
  private ImageView Pey;
  private ViewGroup qoE;
  
  public WcPayCashierFingerprintDialog(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71428);
    this.qoE = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_fingerprint_dialog, null));
    this.Pey = ((ImageView)this.qoE.findViewById(a.f.wpcf_left_iv));
    this.PeB = ((TextView)this.qoE.findViewById(a.f.wpcf_switch_pay_way_tv));
    this.PeC = ((ImageView)this.qoE.findViewById(a.f.wpcf_verify_iv));
    this.PeD = ((TextView)this.qoE.findViewById(a.f.wpcf_verify_hint_tv));
    this.Pey.setOnClickListener(new WcPayCashierFingerprintDialog.3(this));
    setContentView(this.qoE);
    setCanceledOnTouchOutside(false);
    this.PeE = new a();
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71418);
        if (WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this) != null) {
          WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this).gMq();
        }
        AppMethodBeat.o(71418);
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71419);
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
        if (WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this) != null)
        {
          WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this).gMt();
          WcPayCashierFingerprintDialog.c(WcPayCashierFingerprintDialog.this);
        }
        WcPayCashierFingerprintDialog.d(WcPayCashierFingerprintDialog.this);
        AppMethodBeat.o(71419);
      }
    });
    AppMethodBeat.o(71428);
  }
  
  public final void gMs()
  {
    AppMethodBeat.i(71435);
    this.PeC.setImageDrawable(au.o(getContext(), a.h.icons_outlined_pay_fingerprint_android, getContext().getResources().getColor(a.c.FG_2)));
    this.PeD.setTextColor(getContext().getResources().getColor(a.c.half_alpha_black));
    AppMethodBeat.o(71435);
  }
  
  @t(jl=h.a.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71434);
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
    if (this.PeE != null)
    {
      this.PeE.gMt();
      this.PeE = null;
    }
    this.Pey = null;
    this.PeF = null;
    AppMethodBeat.o(71434);
  }
  
  @t(jl=h.a.ON_PAUSE)
  public void onActivityPause()
  {
    AppMethodBeat.i(71433);
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
    cancel();
    AppMethodBeat.o(71433);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71432);
    super.onCreate(paramBundle);
    paramBundle = this.PeE;
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.d.a.gag();
    com.tencent.mm.plugin.report.service.h.IzE.el(1104, 38);
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    com.tencent.mm.plugin.fingerprint.b.a.f localf = new com.tencent.mm.plugin.fingerprint.b.a.f(paramBundle.ByB);
    localf.fwv = paramBundle.fwv;
    locali.a(MMApplicationContext.getContext(), localf, new WcPayCashierFingerprintDialog.a.1(paramBundle));
    AppMethodBeat.o(71432);
  }
  
  final class a
  {
    com.tencent.mm.plugin.fingerprint.d.a BxN;
    public String ByB;
    int PbL;
    com.tencent.mm.plugin.fingerprint.b.a.i PeH;
    public String fwv;
    
    a()
    {
      AppMethodBeat.i(71426);
      this.BxN = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class));
      this.PeH = ((com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class));
      AppMethodBeat.o(71426);
    }
    
    public final void gMt()
    {
      AppMethodBeat.i(71427);
      Log.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
      this.PeH.cancel();
      com.tencent.soter.a.g.f.ipn().ipo();
      this.BxN = null;
      this.PeH = null;
      AppMethodBeat.o(71427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Cr(boolean paramBoolean);
    
    public abstract void a(e parame);
    
    public abstract void gMq();
    
    public abstract void gMr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */