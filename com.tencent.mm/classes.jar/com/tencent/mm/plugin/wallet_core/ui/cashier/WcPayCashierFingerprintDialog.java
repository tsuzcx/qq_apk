package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.mgr.a.c;
import com.tencent.mm.plugin.fingerprint.mgr.a.d;
import com.tencent.mm.plugin.fingerprint.mgr.a.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.bb;
import com.tencent.mm.wallet_core.ui.k;

public class WcPayCashierFingerprintDialog
  extends com.tencent.mm.ui.widget.a.i
  implements p
{
  private ImageView VVg;
  TextView VVj;
  ImageView VVk;
  TextView VVl;
  a VVm;
  b VVn;
  private ViewGroup tth;
  
  public WcPayCashierFingerprintDialog(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71428);
    this.tth = ((ViewGroup)View.inflate(getContext(), a.g.wc_pay_cashier_fingerprint_dialog, null));
    this.VVg = ((ImageView)this.tth.findViewById(a.f.wpcf_left_iv));
    this.VVj = ((TextView)this.tth.findViewById(a.f.wpcf_switch_pay_way_tv));
    this.VVk = ((ImageView)this.tth.findViewById(a.f.wpcf_verify_iv));
    this.VVl = ((TextView)this.tth.findViewById(a.f.wpcf_verify_hint_tv));
    this.VVg.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301345);
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
        WcPayCashierFingerprintDialog.this.cancel();
        AppMethodBeat.o(301345);
      }
    });
    setContentView(this.tth);
    setCanceledOnTouchOutside(false);
    this.VVm = new a();
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71418);
        if (WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this) != null) {
          WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this).ilF();
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
          WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this).ilI();
          WcPayCashierFingerprintDialog.c(WcPayCashierFingerprintDialog.this);
        }
        WcPayCashierFingerprintDialog.d(WcPayCashierFingerprintDialog.this);
        AppMethodBeat.o(71419);
      }
    });
    AppMethodBeat.o(71428);
  }
  
  public final void ilH()
  {
    AppMethodBeat.i(71435);
    this.VVk.setImageDrawable(bb.m(getContext(), a.h.icons_outlined_pay_fingerprint_android, getContext().getResources().getColor(a.c.FG_2)));
    this.VVl.setTextColor(getContext().getResources().getColor(a.c.half_alpha_black));
    AppMethodBeat.o(71435);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71434);
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
    if (this.VVm != null)
    {
      this.VVm.ilI();
      this.VVm = null;
    }
    this.VVg = null;
    this.VVn = null;
    AppMethodBeat.o(71434);
  }
  
  @z(Ho=j.a.ON_PAUSE)
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
    paramBundle = this.VVm;
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.model.a.htx();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 38);
    com.tencent.mm.plugin.fingerprint.mgr.a.i locali = (com.tencent.mm.plugin.fingerprint.mgr.a.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class);
    com.tencent.mm.plugin.fingerprint.mgr.a.f localf = new com.tencent.mm.plugin.fingerprint.mgr.a.f(paramBundle.Hgd);
    localf.hAT = paramBundle.hAT;
    locali.a(MMApplicationContext.getContext(), localf, new WcPayCashierFingerprintDialog.a.1(paramBundle));
    AppMethodBeat.o(71432);
  }
  
  final class a
  {
    com.tencent.mm.plugin.fingerprint.c.a Hfq;
    public String Hgd;
    int VSr;
    com.tencent.mm.plugin.fingerprint.mgr.a.i VVp;
    public String hAT;
    
    a()
    {
      AppMethodBeat.i(71426);
      this.Hfq = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
      this.VVp = ((com.tencent.mm.plugin.fingerprint.mgr.a.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class));
      AppMethodBeat.o(71426);
    }
    
    public final void ilI()
    {
      AppMethodBeat.i(71427);
      Log.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
      this.VVp.cancel();
      com.tencent.soter.a.g.f.jYD().jYE();
      this.Hfq = null;
      this.VVp = null;
      AppMethodBeat.o(71427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void HW(boolean paramBoolean);
    
    public abstract void a(e parame);
    
    public abstract void ilF();
    
    public abstract void ilG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */