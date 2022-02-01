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
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;

@i
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements e.b
{
  private boolean vNz;
  private boolean vQS;
  private long vQU;
  private int vTl;
  private ScanCardRectView vTm;
  private com.tencent.mm.plugin.scanner.b.c.a vTn;
  private eo vTo;
  private ScanCardRectView.a vTp;
  private ScanCardRectView.a vTq;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.vQS = true;
    this.vTo = new eo();
    this.vTp = new ScanCardRectView.a()
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
    this.vTq = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = f.cl(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            ro localro = new ro();
            localro.dxd.cardType = "identity_pay_auth";
            localro.dxd.dxe = 1;
            localro.dxd.dxg = paramAnonymousBundle;
            com.tencent.mm.sdk.b.a.ESL.l(localro);
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
    rs localrs = new rs();
    localrs.dxo.dtM = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localrs);
    setResult(0);
    bKq();
    AppMethodBeat.o(118360);
  }
  
  public final void bKq()
  {
    AppMethodBeat.i(118361);
    ad.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.vTl == 7)
    {
      if (this.vTo.dKe == 1L) {
        this.vTo.dKe = 4L;
      }
      this.vTo.dZz = (System.currentTimeMillis() - this.vQU);
      this.vTo.aBj();
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
    this.vTm = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.vTm, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(am.e(getResources().getDrawable(2131690372), -1));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118352);
        ScanCardUI.c(ScanCardUI.this);
        AppMethodBeat.o(118352);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165293), getResources().getDimensionPixelSize(2131165301), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.vTm.setMode(this.vTl);
    this.vTm.onCreate();
    switch (this.vTl)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(2131762802);
      localObject = this.vTo;
      ((eo)localObject).dKe = 1L;
      ((eo)localObject).aBj();
      this.vTm.setScanCallback(this.vTp);
      this.vTn = new com.tencent.mm.plugin.scanner.b.c.a(this.vTl, this.vTm, this, this.vTo);
      this.vTn.vNz = this.vNz;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(2131762805);
      this.vTm.setScanCallback(this.vTq);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(2131762803);
      this.vTm.setScanCallback(this.vTq);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(2131762806);
    this.vTm.setScanCallback(this.vTq);
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
    this.vTl = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    ad.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.vTl) });
    this.vNz = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.vQU = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.vTm.onDestroy();
    if (this.vTn != null) {
      this.vTn.destroy();
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
        this.vQS = false;
        h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    int j = 1;
    AppMethodBeat.i(118363);
    super.onResume();
    ad.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.vQS) });
    int i = j;
    if (this.vQS)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ad.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      i = j;
      if (!bool) {
        i = 0;
      }
    }
    if (i != 0)
    {
      if (com.tencent.mm.compatible.d.b.XC()) {
        break label184;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(118353);
          paramAnonymousDialogInterface = ScanCardUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    for (;;)
    {
      if (!com.tencent.mm.r.a.cd(getApplicationContext()))
      {
        getApplicationContext();
        if (!e.aCh()) {}
      }
      else
      {
        goBack();
      }
      getWindow().addFlags(128);
      AppMethodBeat.o(118363);
      return;
      label184:
      this.vTm.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.vTm.onStop();
    AppMethodBeat.o(118365);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanCardUI
 * JD-Core Version:    0.7.0.1
 */