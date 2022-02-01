package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private int BQU;
  private TextView BQV;
  private TextView BQW;
  private TextView BQX;
  private TextView BQY;
  private p BQZ;
  private int BRa;
  private String BRb;
  private c<mt> BRc;
  private boolean BRd;
  private boolean BRe;
  private boolean BRf;
  private aw cji;
  private ImageView dtJ;
  private b.a fHp;
  private Button gXc;
  private boolean vsk;
  private com.tencent.mm.modelgeo.d vtI;
  
  private void aUA()
  {
    AppMethodBeat.i(29687);
    ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.BQU) });
    switch (this.BQU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.dtJ.setImageResource(2131690932);
      this.BQX.setText(getString(2131758055, new Object[] { Integer.valueOf(this.BRa) }));
      this.BQY.setText(2131758047);
      this.gXc.setVisibility(4);
      this.BQW.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dtJ.setImageResource(2131690932);
      this.BQX.setText(2131758059);
      this.BQY.setText(2131758050);
      this.gXc.setVisibility(0);
      this.BQW.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dtJ.setImageResource(2131690930);
      this.BQX.setText(2131758058);
      this.BQY.setText(2131758048);
      this.gXc.setVisibility(0);
      this.gXc.setText(2131758044);
      this.BQW.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.dtJ.setImageResource(2131690930);
      this.BQX.setText(2131758056);
      this.BQY.setText(2131758048);
      this.gXc.setVisibility(0);
      this.gXc.setText(2131758044);
      this.BQW.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131761535);
      localIntent.putExtra("rawUrl", getString(2131761532));
      localIntent.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      sV(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.dtJ.setImageResource(2131690931);
      this.BQX.setText(2131758057);
      this.BQY.setText(2131758049);
      this.gXc.setVisibility(0);
      this.gXc.setText(2131758043);
      this.BQW.setVisibility(4);
    }
  }
  
  private void bZr()
  {
    AppMethodBeat.i(29688);
    if (this.vtI == null) {
      this.vtI = com.tencent.mm.modelgeo.d.aIh();
    }
    this.vtI.a(this.fHp, true);
    AppMethodBeat.o(29688);
  }
  
  private void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (bu.isNullOrNil(this.BRb))
    {
      AppMethodBeat.o(29689);
      return;
    }
    ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(2131755906);
        this.BQZ = h.b(this, getString(2131758061), true, null);
        this.gXc.setEnabled(false);
        bZr();
      }
      AppMethodBeat.o(29689);
      return;
    }
    g.yxI.kvStat(14533, "," + this.BRb);
    AppMethodBeat.o(29689);
  }
  
  public void finish()
  {
    AppMethodBeat.i(29686);
    super.finish();
    overridePendingTransition(2130771986, 2130772106);
    AppMethodBeat.o(29686);
  }
  
  public int getLayoutId()
  {
    return 2131495009;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29690);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (((this.BQU == 5) || (this.BQU == 4)) && (paramView == this.gXc)) {
      sV(true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29690);
      return;
      sV(false);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29685);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772108, 2130771986);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.BQU = paramBundle.getIntExtra("diagnose_state", 0);
    this.BRa = paramBundle.getIntExtra("diagnose_percent", 1);
    this.BRb = paramBundle.getStringExtra("diagnose_kvInfo");
    ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.BQU), Integer.valueOf(this.BRa), this.BRb });
    if (this.BQU == 0)
    {
      this.BQU = 1;
      ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      bc.ajj().a(new bq(new bq.a()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(29682);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(29682);
            return;
          }
          try
          {
            paramAnonymouse.aFv();
            AppMethodBeat.o(29682);
            return;
          }
          catch (Exception paramAnonymouse)
          {
            AppMethodBeat.o(29682);
          }
        }
      }), 0);
    }
    this.gXc = ((Button)findViewById(2131299090));
    this.BQV = ((TextView)findViewById(2131299088));
    this.BQW = ((TextView)findViewById(2131299087));
    this.dtJ = ((ImageView)findViewById(2131299092));
    this.BQX = ((TextView)findViewById(2131299093));
    this.BQY = ((TextView)findViewById(2131299089));
    this.BQV.setOnClickListener(this);
    this.gXc.setOnClickListener(this);
    this.BQW.setOnClickListener(this);
    aUA();
    this.BRc = new c() {};
    com.tencent.mm.sdk.b.a.IvT.b(this.BRc);
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(29680);
        ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).c(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29678);
            NetworkDiagnoseAllInOneUI.h(NetworkDiagnoseAllInOneUI.this).setEnabled(true);
            if ((NetworkDiagnoseAllInOneUI.i(NetworkDiagnoseAllInOneUI.this) != null) && (NetworkDiagnoseAllInOneUI.i(NetworkDiagnoseAllInOneUI.this).isShowing())) {
              NetworkDiagnoseAllInOneUI.i(NetworkDiagnoseAllInOneUI.this).dismiss();
            }
            NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this, 6);
            NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
            AppMethodBeat.o(29678);
          }
        });
        NetworkDiagnoseAllInOneUI.j(NetworkDiagnoseAllInOneUI.this);
        if (paramAnonymousBoolean) {
          str = String.valueOf(paramAnonymousFloat2) + "-" + String.valueOf(paramAnonymousFloat1);
        }
        for (String str = str + "," + NetworkDiagnoseAllInOneUI.j(NetworkDiagnoseAllInOneUI.this);; str = "," + NetworkDiagnoseAllInOneUI.j(NetworkDiagnoseAllInOneUI.this))
        {
          g.yxI.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(2131760082), NetworkDiagnoseAllInOneUI.this.getString(2131755906), NetworkDiagnoseAllInOneUI.this.getString(2131760598), NetworkDiagnoseAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                com.tencent.mm.modelgeo.d.cD(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          ae.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.cji = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29681);
        NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) + 1);
        ae.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) });
        if (NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) > 99)
        {
          AppMethodBeat.o(29681);
          return false;
        }
        if (NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this) == 1) {
          NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this).setText(NetworkDiagnoseAllInOneUI.this.getString(2131758055, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) }));
        }
        AppMethodBeat.o(29681);
        return true;
      }
    }, true);
    if ((this.BQU == 0) || (this.BQU == 1)) {
      this.cji.ay(1000L, 1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.BRc);
    if (this.vtI != null)
    {
      this.vtI.c(this.fHp);
      this.vtI = null;
    }
    if (this.cji != null)
    {
      this.cji.stopTimer();
      this.cji = null;
    }
    AppMethodBeat.o(29691);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29692);
    ae.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29692);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        sV(true);
        AppMethodBeat.o(29692);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29683);
          paramAnonymousDialogInterface = NetworkDiagnoseAllInOneUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(29683);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29684);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(29684);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */