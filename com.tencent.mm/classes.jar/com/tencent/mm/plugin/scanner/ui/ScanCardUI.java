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
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.d.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean wXU;
  private boolean xbA;
  private long xbC;
  private int xdW;
  private ScanCardRectView xdX;
  private com.tencent.mm.plugin.scanner.b.c.a xdY;
  private ge xdZ;
  private ScanCardRectView.a xea;
  private ScanCardRectView.a xeb;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.xbA = true;
    this.xdZ = new ge();
    this.xea = new ScanCardRectView.a()
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
    this.xeb = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = f.ck(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            rx localrx = new rx();
            localrx.duQ.cardType = "identity_pay_auth";
            localrx.duQ.duR = 1;
            localrx.duQ.duT = paramAnonymousBundle;
            com.tencent.mm.sdk.b.a.GpY.l(localrx);
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
    sb localsb = new sb();
    localsb.dvb.drx = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localsb);
    setResult(0);
    bRD();
    AppMethodBeat.o(118360);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(118361);
    ac.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.xdW == 7)
    {
      if (this.xdZ.dHY == 1L) {
        this.xdZ.dHY = 4L;
      }
      this.xdZ.ebr = (System.currentTimeMillis() - this.xbC);
      this.xdZ.aHZ();
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
    this.xdX = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.xdX, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cc.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 36));
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
    this.xdX.setMode(this.xdW);
    this.xdX.onCreate();
    switch (this.xdW)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(2131762802);
      localObject = this.xdZ;
      ((ge)localObject).dHY = 1L;
      ((ge)localObject).aHZ();
      this.xdX.setScanCallback(this.xea);
      this.xdY = new com.tencent.mm.plugin.scanner.b.c.a(this.xdW, this.xdX, this, this.xdZ);
      this.xdY.wXU = this.wXU;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(2131762805);
      this.xdX.setScanCallback(this.xeb);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(2131762803);
      this.xdX.setScanCallback(this.xeb);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(2131762806);
    this.xdX.setScanCallback(this.xeb);
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
    this.xdW = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    ac.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.xdW) });
    this.wXU = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.xbC = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.xdX.onDestroy();
    if (this.xdY != null) {
      this.xdY.destroy();
    }
    AppMethodBeat.o(118366);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(118364);
    ac.i("MicroMsg.ScanCardUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118364);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.xbA = false;
        h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    ac.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.xbA) });
    int i = j;
    if (this.xbA)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      ac.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      i = j;
      if (!bool) {
        i = 0;
      }
    }
    if (i != 0)
    {
      if (com.tencent.mm.compatible.d.b.Yz()) {
        break label194;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(118353);
          paramAnonymousDialogInterface = ScanCardUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      if (!com.tencent.mm.r.a.cg(getApplicationContext()))
      {
        getApplicationContext();
        if ((!e.aIX()) && (!com.tencent.mm.r.a.cj(getApplicationContext()))) {}
      }
      else
      {
        goBack();
      }
      getWindow().addFlags(128);
      AppMethodBeat.o(118363);
      return;
      label194:
      this.xdX.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.xdX.onStop();
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