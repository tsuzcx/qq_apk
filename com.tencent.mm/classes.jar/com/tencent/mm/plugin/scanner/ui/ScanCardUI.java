package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

@i
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements e.b
{
  private boolean yBE;
  private boolean yFB;
  private long yFD;
  private int yHY;
  private ScanCardRectView yHZ;
  private com.tencent.mm.plugin.scanner.b.c.a yIa;
  private hj yIb;
  private ScanCardRectView.a yIc;
  private ScanCardRectView.a yId;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.yFB = true;
    this.yIb = new hj();
    this.yIc = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118350);
        if (ScanCardUI.a(ScanCardUI.this) != null) {
          ScanCardUI.a(ScanCardUI.this).c(paramAnonymousLong, paramAnonymousBundle);
        }
        AppMethodBeat.o(118350);
      }
    };
    this.yId = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = com.tencent.mm.sdk.platformtools.h.cu(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            sk localsk = new sk();
            localsk.dHX.cardType = "identity_pay_auth";
            localsk.dHX.dHY = 1;
            localsk.dHX.dIa = paramAnonymousBundle;
            com.tencent.mm.sdk.b.a.IvT.l(localsk);
            ScanCardUI.this.finish();
          }
        }
        AppMethodBeat.o(118351);
      }
    };
    AppMethodBeat.o(118357);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(118360);
    so localso = new so();
    localso.dIi.dEu = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localso);
    setResult(0);
    bXx();
    AppMethodBeat.o(118360);
  }
  
  public final void bXx()
  {
    AppMethodBeat.i(118361);
    ae.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.yHY == 7)
    {
      if (this.yIb.dWt == 1L) {
        this.yIb.dWt = 4L;
      }
      this.yIb.edt = (System.currentTimeMillis() - this.yFD);
      this.yIb.aLH();
    }
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(118361);
  }
  
  public int getLayoutId()
  {
    return 2131495290;
  }
  
  public void initView()
  {
    AppMethodBeat.i(118359);
    getWindow().getDecorView().setSystemUiVisibility(5892);
    setActionbarColor(getResources().getColor(2131101053));
    Object localObject = (FrameLayout)findViewById(2131304241);
    this.yHZ = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.yHZ, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(ao.e(getResources().getDrawable(2131690372), -1));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118352);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ScanCardUI.c(ScanCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(118352);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165293), getResources().getDimensionPixelSize(2131165301), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.yHZ.setMode(this.yHY);
    this.yHZ.onCreate();
    switch (this.yHY)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(2131762802);
      localObject = this.yIb;
      ((hj)localObject).dWt = 1L;
      ((hj)localObject).aLH();
      this.yHZ.setScanCallback(this.yIc);
      this.yIa = new com.tencent.mm.plugin.scanner.b.c.a(this.yHY, this.yHZ, this, this.yIb);
      this.yIa.yBE = this.yBE;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(2131762805);
      this.yHZ.setScanCallback(this.yId);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(2131762803);
      this.yHZ.setScanCallback(this.yId);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(2131762806);
    this.yHZ.setScanCallback(this.yId);
    AppMethodBeat.o(118359);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(118362);
    goBack();
    AppMethodBeat.o(118362);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(118358);
    super.onCreate(paramBundle);
    hideTitleView();
    this.yHY = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    ae.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.yHY) });
    this.yBE = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.yFD = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.yHZ.onDestroy();
    if (this.yIa != null) {
      this.yIa.destroy();
    }
    AppMethodBeat.o(118366);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(118364);
    ae.i("MicroMsg.ScanCardUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118364);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.yFB = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ScanCardUI.d(ScanCardUI.this);
            ScanCardUI.this.finish();
            AppMethodBeat.o(118355);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118356);
            ScanCardUI.d(ScanCardUI.this);
            ScanCardUI.this.finish();
            AppMethodBeat.o(118356);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(118363);
    super.onResume();
    ae.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.yFB) });
    int i;
    if (this.yFB)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ae.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i = 0;
        if (i != 0)
        {
          if (com.tencent.mm.compatible.d.b.abk()) {
            break label195;
          }
          com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118353);
              paramAnonymousDialogInterface = ScanCardUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ScanCardUI.d(ScanCardUI.this);
              ScanCardUI.this.finish();
              AppMethodBeat.o(118353);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118354);
              ScanCardUI.d(ScanCardUI.this);
              ScanCardUI.this.finish();
              AppMethodBeat.o(118354);
            }
          });
        }
      }
    }
    for (;;)
    {
      if (!com.tencent.mm.r.a.n(getApplicationContext(), true))
      {
        getApplicationContext();
        if ((!e.aME()) && (!com.tencent.mm.r.a.p(getApplicationContext(), true))) {}
      }
      else
      {
        goBack();
      }
      getWindow().addFlags(128);
      AppMethodBeat.o(118363);
      return;
      i = 1;
      break;
      label195:
      this.yHZ.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.yHZ.onStop();
    AppMethodBeat.o(118365);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanCardUI
 * JD-Core Version:    0.7.0.1
 */