package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.b.a.la;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.f.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;

@i
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements e.b
{
  private boolean CEf;
  private boolean CJq;
  private long CJs;
  private int CLK;
  private ScanCardRectView CLL;
  private com.tencent.mm.plugin.scanner.b.c.a CLM;
  private la CLN;
  private ScanCardRectView.a CLO;
  private ScanCardRectView.a CLP;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.CJq = true;
    this.CLN = new la();
    this.CLO = new ScanCardRectView.a()
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
    this.CLP = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = BitmapUtil.decodeByteArray(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            th localth = new th();
            localth.dZJ.cardType = "identity_pay_auth";
            localth.dZJ.dZK = 1;
            localth.dZJ.dZM = paramAnonymousBundle;
            EventCenter.instance.publish(localth);
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
    tl localtl = new tl();
    localtl.dZU.cSx = 1;
    EventCenter.instance.publish(localtl);
    setResult(0);
    cvn();
    AppMethodBeat.o(118360);
  }
  
  public final void cvn()
  {
    AppMethodBeat.i(118361);
    Log.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.CLK == 7)
    {
      if (this.CLN.erW == 1L) {
        this.CLN.erW = 4L;
      }
      this.CLN.eiR = (System.currentTimeMillis() - this.CJs);
      this.CLN.bfK();
    }
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(118361);
  }
  
  public int getLayoutId()
  {
    return 2131496140;
  }
  
  public void initView()
  {
    AppMethodBeat.i(118359);
    getWindow().getDecorView().setSystemUiVisibility(5892);
    setActionbarColor(getResources().getColor(2131101287));
    Object localObject = (FrameLayout)findViewById(2131307160);
    this.CLL = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.CLL, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(ar.e(getResources().getDrawable(2131690515), -1));
    localButton.setOnClickListener(new ScanCardUI.3(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165300), getResources().getDimensionPixelSize(2131165312), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.CLL.setMode(this.CLK);
    this.CLL.onCreate();
    switch (this.CLK)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(2131764899);
      localObject = this.CLN;
      ((la)localObject).erW = 1L;
      ((la)localObject).bfK();
      this.CLL.setScanCallback(this.CLO);
      this.CLM = new com.tencent.mm.plugin.scanner.b.c.a(this.CLK, this.CLL, this, this.CLN);
      this.CLM.CEf = this.CEf;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(2131764902);
      this.CLL.setScanCallback(this.CLP);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(2131764900);
      this.CLL.setScanCallback(this.CLP);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(2131764903);
    this.CLL.setScanCallback(this.CLP);
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
    this.CLK = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    Log.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.CLK) });
    this.CEf = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.CJs = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.CLL.onDestroy();
    if (this.CLM != null) {
      this.CLM.destroy();
    }
    AppMethodBeat.o(118366);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(118364);
    Log.i("MicroMsg.ScanCardUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118364);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.CJq = false;
        h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    Log.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.CJq) });
    int i;
    if (this.CJq)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i = 0;
        if (i != 0)
        {
          if (com.tencent.mm.compatible.e.b.apj()) {
            break label195;
          }
          h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118353);
              paramAnonymousDialogInterface = ScanCardUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      if (!com.tencent.mm.q.a.o(getApplicationContext(), true))
      {
        getApplicationContext();
        if ((!e.bgF()) && (!com.tencent.mm.q.a.r(getApplicationContext(), true))) {}
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
      this.CLL.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.CLL.onStop();
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