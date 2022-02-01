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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private TextView BzA;
  private p BzB;
  private int BzC;
  private String BzD;
  private c<ms> BzE;
  private boolean BzF;
  private boolean BzG;
  private boolean BzH;
  private int Bzw;
  private TextView Bzx;
  private TextView Bzy;
  private TextView Bzz;
  private av cjg;
  private ImageView dsD;
  private b.a fFl;
  private Button gUt;
  private boolean vgd;
  private com.tencent.mm.modelgeo.d vhB;
  
  private void aUb()
  {
    AppMethodBeat.i(29687);
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.Bzw) });
    switch (this.Bzw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.dsD.setImageResource(2131690932);
      this.Bzz.setText(getString(2131758055, new Object[] { Integer.valueOf(this.BzC) }));
      this.BzA.setText(2131758047);
      this.gUt.setVisibility(4);
      this.Bzy.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dsD.setImageResource(2131690932);
      this.Bzz.setText(2131758059);
      this.BzA.setText(2131758050);
      this.gUt.setVisibility(0);
      this.Bzy.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dsD.setImageResource(2131690930);
      this.Bzz.setText(2131758058);
      this.BzA.setText(2131758048);
      this.gUt.setVisibility(0);
      this.gUt.setText(2131758044);
      this.Bzy.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.dsD.setImageResource(2131690930);
      this.Bzz.setText(2131758056);
      this.BzA.setText(2131758048);
      this.gUt.setVisibility(0);
      this.gUt.setText(2131758044);
      this.Bzy.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131761535);
      localIntent.putExtra("rawUrl", getString(2131761532));
      localIntent.putExtra("showShare", false);
      com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      sO(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.dsD.setImageResource(2131690931);
      this.Bzz.setText(2131758057);
      this.BzA.setText(2131758049);
      this.gUt.setVisibility(0);
      this.gUt.setText(2131758043);
      this.Bzy.setVisibility(4);
    }
  }
  
  private void bYc()
  {
    AppMethodBeat.i(29688);
    if (this.vhB == null) {
      this.vhB = com.tencent.mm.modelgeo.d.aHQ();
    }
    this.vhB.a(this.fFl, true);
    AppMethodBeat.o(29688);
  }
  
  private void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (bt.isNullOrNil(this.BzD))
    {
      AppMethodBeat.o(29689);
      return;
    }
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(2131755906);
        this.BzB = h.b(this, getString(2131758061), true, null);
        this.gUt.setEnabled(false);
        bYc();
      }
      AppMethodBeat.o(29689);
      return;
    }
    g.yhR.kvStat(14533, "," + this.BzD);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (((this.Bzw == 5) || (this.Bzw == 4)) && (paramView == this.gUt)) {
      sO(true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29690);
      return;
      sO(false);
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
    this.Bzw = paramBundle.getIntExtra("diagnose_state", 0);
    this.BzC = paramBundle.getIntExtra("diagnose_percent", 1);
    this.BzD = paramBundle.getStringExtra("diagnose_kvInfo");
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.Bzw), Integer.valueOf(this.BzC), this.BzD });
    if (this.Bzw == 0)
    {
      this.Bzw = 1;
      ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      ba.aiU().a(new bo(new bo.a()
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
            paramAnonymouse.aFf();
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
    this.gUt = ((Button)findViewById(2131299090));
    this.Bzx = ((TextView)findViewById(2131299088));
    this.Bzy = ((TextView)findViewById(2131299087));
    this.dsD = ((ImageView)findViewById(2131299092));
    this.Bzz = ((TextView)findViewById(2131299093));
    this.BzA = ((TextView)findViewById(2131299089));
    this.Bzx.setOnClickListener(this);
    this.gUt.setOnClickListener(this);
    this.Bzy.setOnClickListener(this);
    aUb();
    this.BzE = new c() {};
    com.tencent.mm.sdk.b.a.IbL.b(this.BzE);
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(29680);
        ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).c(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
        }
        aq.f(new Runnable()
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
          g.yhR.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!com.tencent.mm.modelgeo.d.aHR()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(2131760082), NetworkDiagnoseAllInOneUI.this.getString(2131755906), NetworkDiagnoseAllInOneUI.this.getString(2131760598), NetworkDiagnoseAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                com.tencent.mm.modelgeo.d.cB(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          ad.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.cjg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29681);
        NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) + 1);
        ad.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) });
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
    if ((this.Bzw == 0) || (this.Bzw == 1)) {
      this.cjg.az(1000L, 1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.BzE);
    if (this.vhB != null)
    {
      this.vhB.c(this.fFl);
      this.vhB = null;
    }
    if (this.cjg != null)
    {
      this.cjg.stopTimer();
      this.cjg = null;
    }
    AppMethodBeat.o(29691);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29692);
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29692);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        sO(true);
        AppMethodBeat.o(29692);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, new NetworkDiagnoseAllInOneUI.5(this), new NetworkDiagnoseAllInOneUI.6(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */