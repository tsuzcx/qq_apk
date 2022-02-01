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
import com.tencent.mm.bj.e;
import com.tencent.mm.f.a.ui;
import com.tencent.mm.f.a.um;
import com.tencent.mm.f.b.a.nw;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.b;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.e;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.scanner.g.e.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;

@k
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements e.b
{
  private boolean IIH;
  private boolean IOQ;
  private long IOT;
  private int IRl;
  private ScanCardRectView IRm;
  private com.tencent.mm.plugin.scanner.b.c.a IRn;
  private nw IRo;
  private ScanCardRectView.a IRp;
  private ScanCardRectView.a IRq;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.IOQ = true;
    this.IRo = new nw();
    this.IRp = new ScanCardRectView.a()
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
    this.IRq = new ScanCardRectView.a()
    {
      public final void e(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118351);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = BitmapUtil.decodeByteArray(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            ui localui = new ui();
            localui.fTD.cardType = "identity_pay_auth";
            localui.fTD.fTE = 1;
            localui.fTD.fTG = paramAnonymousBundle;
            EventCenter.instance.publish(localui);
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
    um localum = new um();
    localum.fTO.cUP = 1;
    EventCenter.instance.publish(localum);
    setResult(0);
    cIP();
    AppMethodBeat.o(118360);
  }
  
  public final void cIP()
  {
    AppMethodBeat.i(118361);
    Log.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.IRl == 7)
    {
      if (this.IRo.gnP == 1L) {
        this.IRo.gnP = 4L;
      }
      this.IRo.gdk = (System.currentTimeMillis() - this.IOT);
      this.IRo.bpa();
    }
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(118361);
  }
  
  public int getLayoutId()
  {
    return a.e.scan_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(118359);
    getWindow().getDecorView().setSystemUiVisibility(5892);
    setActionbarColor(getResources().getColor(a.a.transparent));
    Object localObject = (FrameLayout)findViewById(a.d.root_container);
    this.IRm = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.IRm, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.ci.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(au.e(getResources().getDrawable(a.f.icons_filled_close2), -1));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118352);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ScanCardUI.c(ScanCardUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(118352);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(a.b.Edge_3_5_A), getResources().getDimensionPixelSize(a.b.Edge_8A), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.IRm.setMode(this.IRl);
    this.IRm.onCreate();
    switch (this.IRl)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(a.g.scan_entry_bankcard);
      localObject = this.IRo;
      ((nw)localObject).gnP = 1L;
      ((nw)localObject).bpa();
      this.IRm.setScanCallback(this.IRp);
      this.IRn = new com.tencent.mm.plugin.scanner.b.c.a(this.IRl, this.IRm, this, this.IRo);
      this.IRn.IIH = this.IIH;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(a.g.scan_entry_id_card);
      this.IRm.setScanCallback(this.IRq);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(a.g.scan_entry_driving_licence);
      this.IRm.setScanCallback(this.IRq);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(a.g.scan_entry_id_card_for_pay_auth);
    this.IRm.setScanCallback(this.IRq);
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
    this.IRl = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    Log.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.IRl) });
    this.IIH = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.IOT = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.IRm.onDestroy();
    if (this.IRn != null) {
      this.IRn.destroy();
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
        this.IOQ = false;
        h.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            paramAnonymousDialogInterface = ScanCardUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    Log.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.IOQ) });
    int i;
    if (this.IOQ)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
      Log.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i = 0;
        if (i != 0)
        {
          if (com.tencent.mm.compatible.e.b.avv()) {
            break label195;
          }
          h.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118353);
              paramAnonymousDialogInterface = ScanCardUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      if (!com.tencent.mm.q.a.p(getApplicationContext(), true))
      {
        getApplicationContext();
        if ((!e.bpU()) && (!com.tencent.mm.q.a.t(getApplicationContext(), true))) {}
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
      this.IRm.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.IRm.onStop();
    AppMethodBeat.o(118365);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanCardUI
 * JD-Core Version:    0.7.0.1
 */