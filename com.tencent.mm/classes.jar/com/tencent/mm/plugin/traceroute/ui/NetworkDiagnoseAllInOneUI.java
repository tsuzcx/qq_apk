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
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private av cbR;
  private ImageView djK;
  private b.a fjJ;
  private Button hJh;
  private boolean sVh;
  private com.tencent.mm.modelgeo.d sWF;
  private int yTV;
  private TextView yTW;
  private TextView yTX;
  private TextView yTY;
  private TextView yTZ;
  private p yUa;
  private int yUb;
  private String yUc;
  private c<ma> yUd;
  private boolean yUe;
  private boolean yUf;
  private boolean yUg;
  
  private void aJY()
  {
    AppMethodBeat.i(29687);
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.yTV) });
    switch (this.yTV)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.djK.setImageResource(2131690932);
      this.yTY.setText(getString(2131758055, new Object[] { Integer.valueOf(this.yUb) }));
      this.yTZ.setText(2131758047);
      this.hJh.setVisibility(4);
      this.yTX.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.djK.setImageResource(2131690932);
      this.yTY.setText(2131758059);
      this.yTZ.setText(2131758050);
      this.hJh.setVisibility(0);
      this.yTX.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.djK.setImageResource(2131690930);
      this.yTY.setText(2131758058);
      this.yTZ.setText(2131758048);
      this.hJh.setVisibility(0);
      this.hJh.setText(2131758044);
      this.yTX.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.djK.setImageResource(2131690930);
      this.yTY.setText(2131758056);
      this.yTZ.setText(2131758048);
      this.hJh.setVisibility(0);
      this.hJh.setText(2131758044);
      this.yTX.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131761535);
      localIntent.putExtra("rawUrl", getString(2131761532));
      localIntent.putExtra("showShare", false);
      com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      rj(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.djK.setImageResource(2131690931);
      this.yTY.setText(2131758057);
      this.yTZ.setText(2131758049);
      this.hJh.setVisibility(0);
      this.hJh.setText(2131758043);
      this.yTX.setVisibility(4);
    }
  }
  
  private void bMk()
  {
    AppMethodBeat.i(29688);
    if (this.sWF == null) {
      this.sWF = com.tencent.mm.modelgeo.d.axT();
    }
    this.sWF.a(this.fjJ, true);
    AppMethodBeat.o(29688);
  }
  
  private void rj(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (bt.isNullOrNil(this.yUc))
    {
      AppMethodBeat.o(29689);
      return;
    }
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(2131755906);
        this.yUa = com.tencent.mm.ui.base.h.b(this, getString(2131758061), true, null);
        this.hJh.setEnabled(false);
        bMk();
      }
      AppMethodBeat.o(29689);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(14533, "," + this.yUc);
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
    if (((this.yTV == 5) || (this.yTV == 4)) && (paramView == this.hJh))
    {
      rj(true);
      AppMethodBeat.o(29690);
      return;
    }
    rj(false);
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
    this.yTV = paramBundle.getIntExtra("diagnose_state", 0);
    this.yUb = paramBundle.getIntExtra("diagnose_percent", 1);
    this.yUc = paramBundle.getStringExtra("diagnose_kvInfo");
    ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.yTV), Integer.valueOf(this.yUb), this.yUc });
    if (this.yTV == 0)
    {
      this.yTV = 1;
      ad.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      az.aeS().a(new bn(new NetworkDiagnoseAllInOneUI.4(this)), 0);
    }
    this.hJh = ((Button)findViewById(2131299090));
    this.yTW = ((TextView)findViewById(2131299088));
    this.yTX = ((TextView)findViewById(2131299087));
    this.djK = ((ImageView)findViewById(2131299092));
    this.yTY = ((TextView)findViewById(2131299093));
    this.yTZ = ((TextView)findViewById(2131299089));
    this.yTW.setOnClickListener(this);
    this.hJh.setOnClickListener(this);
    this.yTX.setOnClickListener(this);
    aJY();
    this.yUd = new c() {};
    a.ESL.b(this.yUd);
    this.fjJ = new b.a()
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
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!com.tencent.mm.modelgeo.d.axU()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            com.tencent.mm.ui.base.h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(2131760082), NetworkDiagnoseAllInOneUI.this.getString(2131755906), NetworkDiagnoseAllInOneUI.this.getString(2131760598), NetworkDiagnoseAllInOneUI.this.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                com.tencent.mm.modelgeo.d.cv(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          ad.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.cbR = new av(new av.a()
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
    if ((this.yTV == 0) || (this.yTV == 1)) {
      this.cbR.av(1000L, 1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    a.ESL.d(this.yUd);
    if (this.sWF != null)
    {
      this.sWF.c(this.fjJ);
      this.sWF = null;
    }
    if (this.cbR != null)
    {
      this.cbR.stopTimer();
      this.cbR = null;
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
        rj(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */