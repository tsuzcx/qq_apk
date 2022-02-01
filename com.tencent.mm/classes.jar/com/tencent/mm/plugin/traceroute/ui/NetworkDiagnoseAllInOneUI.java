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
import com.tencent.mm.g.a.mj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private int AhK;
  private TextView AhL;
  private TextView AhM;
  private TextView AhN;
  private TextView AhO;
  private p AhP;
  private int AhQ;
  private String AhR;
  private c<mj> AhS;
  private boolean AhT;
  private boolean AhU;
  private boolean AhV;
  private au bYO;
  private ImageView dhf;
  private b.a fnd;
  private Button gAJ;
  private boolean udt;
  private com.tencent.mm.modelgeo.d ueS;
  
  private void aQP()
  {
    AppMethodBeat.i(29687);
    ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.AhK) });
    switch (this.AhK)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.dhf.setImageResource(2131690932);
      this.AhN.setText(getString(2131758055, new Object[] { Integer.valueOf(this.AhQ) }));
      this.AhO.setText(2131758047);
      this.gAJ.setVisibility(4);
      this.AhM.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dhf.setImageResource(2131690932);
      this.AhN.setText(2131758059);
      this.AhO.setText(2131758050);
      this.gAJ.setVisibility(0);
      this.AhM.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dhf.setImageResource(2131690930);
      this.AhN.setText(2131758058);
      this.AhO.setText(2131758048);
      this.gAJ.setVisibility(0);
      this.gAJ.setText(2131758044);
      this.AhM.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.dhf.setImageResource(2131690930);
      this.AhN.setText(2131758056);
      this.AhO.setText(2131758048);
      this.gAJ.setVisibility(0);
      this.gAJ.setText(2131758044);
      this.AhM.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131761535);
      localIntent.putExtra("rawUrl", getString(2131761532));
      localIntent.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      sh(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.dhf.setImageResource(2131690931);
      this.AhN.setText(2131758057);
      this.AhO.setText(2131758049);
      this.gAJ.setVisibility(0);
      this.gAJ.setText(2131758043);
      this.AhM.setVisibility(4);
    }
  }
  
  private void bTx()
  {
    AppMethodBeat.i(29688);
    if (this.ueS == null) {
      this.ueS = com.tencent.mm.modelgeo.d.aEL();
    }
    this.ueS.a(this.fnd, true);
    AppMethodBeat.o(29688);
  }
  
  private void sh(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (bs.isNullOrNil(this.AhR))
    {
      AppMethodBeat.o(29689);
      return;
    }
    ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(2131755906);
        this.AhP = com.tencent.mm.ui.base.h.b(this, getString(2131758061), true, null);
        this.gAJ.setEnabled(false);
        bTx();
      }
      AppMethodBeat.o(29689);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(14533, "," + this.AhR);
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
    if (((this.AhK == 5) || (this.AhK == 4)) && (paramView == this.gAJ))
    {
      sh(true);
      AppMethodBeat.o(29690);
      return;
    }
    sh(false);
    finish();
    AppMethodBeat.o(29690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29685);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772108, 2130771986);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.AhK = paramBundle.getIntExtra("diagnose_state", 0);
    this.AhQ = paramBundle.getIntExtra("diagnose_percent", 1);
    this.AhR = paramBundle.getStringExtra("diagnose_kvInfo");
    ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.AhK), Integer.valueOf(this.AhQ), this.AhR });
    if (this.AhK == 0)
    {
      this.AhK = 1;
      ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      az.agi().a(new bn(new NetworkDiagnoseAllInOneUI.4(this)), 0);
    }
    this.gAJ = ((Button)findViewById(2131299090));
    this.AhL = ((TextView)findViewById(2131299088));
    this.AhM = ((TextView)findViewById(2131299087));
    this.dhf = ((ImageView)findViewById(2131299092));
    this.AhN = ((TextView)findViewById(2131299093));
    this.AhO = ((TextView)findViewById(2131299089));
    this.AhL.setOnClickListener(this);
    this.gAJ.setOnClickListener(this);
    this.AhM.setOnClickListener(this);
    aQP();
    this.AhS = new c() {};
    a.GpY.b(this.AhS);
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(29680);
        ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).c(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
        }
        ap.f(new Runnable()
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
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            com.tencent.mm.ui.base.h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(2131760082), NetworkDiagnoseAllInOneUI.this.getString(2131755906), NetworkDiagnoseAllInOneUI.this.getString(2131760598), NetworkDiagnoseAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                com.tencent.mm.modelgeo.d.cE(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          ac.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.bYO = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29681);
        NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) + 1);
        ac.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) });
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
    if ((this.AhK == 0) || (this.AhK == 1)) {
      this.bYO.au(1000L, 1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    a.GpY.d(this.AhS);
    if (this.ueS != null)
    {
      this.ueS.c(this.fnd);
      this.ueS = null;
    }
    if (this.bYO != null)
    {
      this.bYO.stopTimer();
      this.bYO = null;
    }
    AppMethodBeat.o(29691);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29692);
    ac.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29692);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        sh(true);
        AppMethodBeat.o(29692);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, new NetworkDiagnoseAllInOneUI.5(this), new NetworkDiagnoseAllInOneUI.6(this));
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