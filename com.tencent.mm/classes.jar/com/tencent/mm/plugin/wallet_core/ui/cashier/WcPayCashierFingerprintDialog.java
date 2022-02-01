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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;

public class WcPayCashierFingerprintDialog
  extends com.tencent.mm.ui.base.i
  implements LifecycleObserver
{
  private ImageView Img;
  TextView Imj;
  ImageView Imk;
  TextView Iml;
  a Imm;
  b Imn;
  private ViewGroup nmW;
  
  public WcPayCashierFingerprintDialog(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71428);
    init();
    AppMethodBeat.o(71428);
  }
  
  public WcPayCashierFingerprintDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71429);
    init();
    AppMethodBeat.o(71429);
  }
  
  private void init()
  {
    AppMethodBeat.i(71430);
    initView();
    setContentView(this.nmW);
    setCanceledOnTouchOutside(false);
    this.Imm = new a();
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71418);
        if (WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this) != null) {
          WcPayCashierFingerprintDialog.a(WcPayCashierFingerprintDialog.this).fTK();
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
          WcPayCashierFingerprintDialog.b(WcPayCashierFingerprintDialog.this).fTN();
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
    this.nmW = ((ViewGroup)View.inflate(getContext(), 2131497038, null));
    this.Img = ((ImageView)this.nmW.findViewById(2131310572));
    this.Imj = ((TextView)this.nmW.findViewById(2131310573));
    this.Imk = ((ImageView)this.nmW.findViewById(2131310575));
    this.Iml = ((TextView)this.nmW.findViewById(2131310574));
    this.Img.setOnClickListener(new WcPayCashierFingerprintDialog.3(this));
    AppMethodBeat.o(71431);
  }
  
  public final void fTM()
  {
    AppMethodBeat.i(71435);
    this.Imk.setImageDrawable(ar.m(getContext(), 2131690868, getContext().getResources().getColor(2131099749)));
    this.Iml.setTextColor(getContext().getResources().getColor(2131100584));
    AppMethodBeat.o(71435);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71434);
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
    if (this.Imm != null)
    {
      this.Imm.fTN();
      this.Imm = null;
    }
    this.Img = null;
    this.Imn = null;
    AppMethodBeat.o(71434);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
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
    paramBundle = this.Imm;
    Log.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.d.a.flK();
    h.CyF.dN(1104, 38);
    com.tencent.mm.plugin.fingerprint.b.a.i locali = (com.tencent.mm.plugin.fingerprint.b.a.i)g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    com.tencent.mm.plugin.fingerprint.b.a.f localf = new com.tencent.mm.plugin.fingerprint.b.a.f(paramBundle.wFE);
    localf.dDL = paramBundle.dDL;
    locali.a(MMApplicationContext.getContext(), localf, new WcPayCashierFingerprintDialog.a.1(paramBundle));
    AppMethodBeat.o(71432);
  }
  
  final class a
  {
    int Iju;
    com.tencent.mm.plugin.fingerprint.b.a.i Imp;
    public String dDL;
    com.tencent.mm.plugin.fingerprint.d.a wEQ;
    public String wFE;
    
    a()
    {
      AppMethodBeat.i(71426);
      this.wEQ = ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class));
      this.Imp = ((com.tencent.mm.plugin.fingerprint.b.a.i)g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class));
      AppMethodBeat.o(71426);
    }
    
    public final void fTN()
    {
      AppMethodBeat.i(71427);
      Log.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
      this.Imp.cancel();
      com.tencent.soter.a.g.f.hlO().hlP();
      this.wEQ = null;
      this.Imp = null;
      AppMethodBeat.o(71427);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
    
    public abstract void fTK();
    
    public abstract void fTL();
    
    public abstract void yw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog
 * JD-Core Version:    0.7.0.1
 */