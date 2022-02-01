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
import com.tencent.mm.bi.e;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;

@i
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements e.b
{
  private boolean ylF;
  private boolean ypC;
  private long ypE;
  private int yrY;
  private ScanCardRectView yrZ;
  private com.tencent.mm.plugin.scanner.b.c.a ysa;
  private hh ysb;
  private ScanCardRectView.a ysc;
  private ScanCardRectView.a ysd;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.ypC = true;
    this.ysb = new hh();
    this.ysc = new ScanCardRectView.a()
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
    this.ysd = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = g.cr(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            sj localsj = new sj();
            localsj.dGR.cardType = "identity_pay_auth";
            localsj.dGR.dGS = 1;
            localsj.dGR.dGU = paramAnonymousBundle;
            com.tencent.mm.sdk.b.a.IbL.l(localsj);
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
    sn localsn = new sn();
    localsn.dHc.dDp = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localsn);
    setResult(0);
    bWi();
    AppMethodBeat.o(118360);
  }
  
  public final void bWi()
  {
    AppMethodBeat.i(118361);
    ad.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.yrY == 7)
    {
      if (this.ysb.dVd == 1L) {
        this.ysb.dVd = 4L;
      }
      this.ysb.ebY = (System.currentTimeMillis() - this.ypE);
      this.ysb.aLk();
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
    this.yrZ = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.yrZ, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cc.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(ao.e(getResources().getDrawable(2131690372), -1));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118352);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ScanCardUI.c(ScanCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(118352);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165293), getResources().getDimensionPixelSize(2131165301), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.yrZ.setMode(this.yrY);
    this.yrZ.onCreate();
    switch (this.yrY)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(2131762802);
      localObject = this.ysb;
      ((hh)localObject).dVd = 1L;
      ((hh)localObject).aLk();
      this.yrZ.setScanCallback(this.ysc);
      this.ysa = new com.tencent.mm.plugin.scanner.b.c.a(this.yrY, this.yrZ, this, this.ysb);
      this.ysa.ylF = this.ylF;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(2131762805);
      this.yrZ.setScanCallback(this.ysd);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(2131762803);
      this.yrZ.setScanCallback(this.ysd);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(2131762806);
    this.yrZ.setScanCallback(this.ysd);
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
    this.yrY = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    ad.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.yrY) });
    this.ylF = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.ypE = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.yrZ.onDestroy();
    if (this.ysa != null) {
      this.ysa.destroy();
    }
    AppMethodBeat.o(118366);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(118364);
    ad.i("MicroMsg.ScanCardUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118364);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.ypC = false;
        h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    ad.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.ypC) });
    int i;
    if (this.ypC)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i = 0;
        if (i != 0)
        {
          if (com.tencent.mm.compatible.d.b.abb()) {
            break label195;
          }
          h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118353);
              paramAnonymousDialogInterface = ScanCardUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      if (!com.tencent.mm.s.a.n(getApplicationContext(), true))
      {
        getApplicationContext();
        if ((!e.aMh()) && (!com.tencent.mm.s.a.p(getApplicationContext(), true))) {}
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
      this.yrZ.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.yrZ.onStop();
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