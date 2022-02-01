package com.tencent.mm.plugin.scanner.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.autogen.a.vy;
import com.tencent.mm.autogen.a.wc;
import com.tencent.mm.autogen.mmdata.rpt.ro;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.ak.a.a;
import com.tencent.mm.plugin.ak.a.b;
import com.tencent.mm.plugin.ak.a.d;
import com.tencent.mm.plugin.ak.a.e;
import com.tencent.mm.plugin.ak.a.f;
import com.tencent.mm.plugin.ak.a.g;
import com.tencent.mm.plugin.scanner.g.f.b;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(3)
public class ScanCardUI
  extends MMActivity
  implements f.b
{
  private boolean OOF;
  private boolean OXs;
  private long OXu;
  private int Pag;
  private ScanCardRectView Pah;
  private com.tencent.mm.plugin.scanner.b.c.a Pai;
  private ro Paj;
  private ScanCardRectView.a Pak;
  private ScanCardRectView.a Pal;
  
  public ScanCardUI()
  {
    AppMethodBeat.i(118357);
    this.OXs = true;
    this.Paj = new ro();
    this.Pak = new ScanCardRectView.a()
    {
      public final void aU(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314478);
        if (ScanCardUI.a(ScanCardUI.this) != null) {
          ScanCardUI.a(ScanCardUI.this).aS(paramAnonymousBundle);
        }
        AppMethodBeat.o(314478);
      }
    };
    this.Pal = new ScanCardRectView.a()
    {
      public final void aU(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314484);
        if (paramAnonymousBundle.containsKey("param_card_bitmap"))
        {
          paramAnonymousBundle = BitmapUtil.decodeByteArray(paramAnonymousBundle.getByteArray("param_card_bitmap"));
          if (ScanCardUI.b(ScanCardUI.this) == 11)
          {
            vy localvy = new vy();
            localvy.hZB.cardType = "identity_pay_auth";
            localvy.hZB.hZC = 1;
            localvy.hZB.hZE = paramAnonymousBundle;
            localvy.publish();
            ScanCardUI.this.finish();
          }
        }
        AppMethodBeat.o(314484);
      }
    };
    AppMethodBeat.o(118357);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(118360);
    wc localwc = new wc();
    localwc.hZM.eQp = 1;
    localwc.publish();
    setResult(0);
    dmh();
    AppMethodBeat.o(118360);
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(118361);
    Log.i("MicroMsg.ScanCardUI", "finishUI");
    if (this.Pag == 7)
    {
      if (this.Paj.iqr == 1L) {
        this.Paj.iqr = 4L;
      }
      this.Paj.ijA = (System.currentTimeMillis() - this.OXu);
      this.Paj.bMH();
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
    this.Pah = new ScanCardRectView(this);
    ((FrameLayout)localObject).addView(this.Pah, 0, new FrameLayout.LayoutParams(-1, -1));
    Button localButton = new Button(this);
    localButton.setWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 36));
    localButton.setHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 36));
    localButton.setBackgroundDrawable(bb.e(getResources().getDrawable(a.f.icons_filled_close2), -1));
    localButton.setContentDescription(getContext().getString(a.g.close_btn));
    localButton.setOnClickListener(new ScanCardUI.3(this));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(a.b.Edge_3_5_A), getResources().getDimensionPixelSize(a.b.Edge_8A), 0, 0);
    ((FrameLayout)localObject).addView(localButton, localLayoutParams);
    this.Pah.setMode(this.Pag);
    this.Pah.onCreate();
    switch (this.Pag)
    {
    case 8: 
    default: 
      setMMTitle("");
      AppMethodBeat.o(118359);
      return;
    case 7: 
      setMMTitle(a.g.scan_entry_bankcard);
      localObject = this.Paj;
      ((ro)localObject).iqr = 1L;
      ((ro)localObject).bMH();
      this.Pah.setScanCallback(this.Pak);
      this.Pai = new com.tencent.mm.plugin.scanner.b.c.a(this.Pag, this.Pah, this, this.Paj);
      this.Pai.OOF = this.OOF;
      AppMethodBeat.o(118359);
      return;
    case 9: 
      setMMTitle(a.g.scan_entry_id_card);
      this.Pah.setScanCallback(this.Pal);
      AppMethodBeat.o(118359);
      return;
    case 10: 
      setMMTitle(a.g.scan_entry_driving_licence);
      this.Pah.setScanCallback(this.Pal);
      AppMethodBeat.o(118359);
      return;
    }
    setMMTitle(a.g.scan_entry_id_card_for_pay_auth);
    this.Pah.setScanCallback(this.Pal);
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
    this.Pag = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
    Log.i("MicroMsg.ScanCardUI", "scanMode %d", new Object[] { Integer.valueOf(this.Pag) });
    this.OOF = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
    initView();
    this.OXu = System.currentTimeMillis();
    AppMethodBeat.o(118358);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118366);
    super.onDestroy();
    this.Pah.onDestroy();
    if (this.Pai != null) {
      this.Pai.destroy();
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
        this.OXs = false;
        com.tencent.mm.ui.base.k.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(118355);
            com.tencent.mm.pluginsdk.permission.b.lx(ScanCardUI.this.getContext());
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
    Log.i("MicroMsg.ScanCardUI", "should check camera %s", new Object[] { Boolean.valueOf(this.OXs) });
    int i;
    if (this.OXs)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null);
      Log.i("MicroMsg.ScanCardUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i = 0;
        if (i != 0)
        {
          if (com.tencent.mm.compatible.e.b.aPP()) {
            break label194;
          }
          com.tencent.mm.ui.base.k.a(this, getString(a.g.permission_camera_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(118353);
              com.tencent.mm.pluginsdk.permission.b.lx(ScanCardUI.this.getContext());
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
      if (!com.tencent.mm.n.a.p(getApplicationContext(), true))
      {
        getApplicationContext();
        if ((!e.bNA()) && (!com.tencent.mm.n.a.u(getApplicationContext(), true))) {}
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
      label194:
      this.Pah.onResume();
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(118365);
    super.onStop();
    this.Pah.onStop();
    AppMethodBeat.o(118365);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(314479);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
    AppMethodBeat.o(314479);
  }
  
  public static class a
    extends MMBaseAccessibilityConfig
  {
    public a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    public void initConfig()
    {
      AppMethodBeat.i(314444);
      MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.e.scan_bankcard_body);
      localConfigHelper.disable(a.d.bank_card_declare);
      localConfigHelper.disable(a.d.bank_card_owner);
      localConfigHelper.focusFirst(a.d.bottom_tip_view);
      localConfigHelper.view(a.d.top_container).descFormat(a.g.talkback_placehodler_2).valueByView(a.d.bank_card_owner).valueByString(a.g.scan_bank_card_know_more_accessibility).type(ViewType.Button).clickAs(a.d.bank_card_declare);
      AppMethodBeat.o(314444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanCardUI
 * JD-Core Version:    0.7.0.1
 */