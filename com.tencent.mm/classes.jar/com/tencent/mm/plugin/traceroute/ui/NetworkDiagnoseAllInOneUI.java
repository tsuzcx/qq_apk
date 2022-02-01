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
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private int GrC;
  private TextView GrD;
  private TextView GrE;
  private TextView GrF;
  private TextView GrG;
  private q GrH;
  private int GrI;
  private String GrJ;
  private IListener<nk> GrK;
  private boolean GrL;
  private boolean GrM;
  private boolean GrN;
  private MTimerHandler cve;
  private ImageView dKU;
  private b.a gmA;
  private Button hPX;
  private boolean uSu;
  private d yNv;
  
  private void bpn()
  {
    AppMethodBeat.i(29687);
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.GrC) });
    switch (this.GrC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.dKU.setImageResource(2131691229);
      this.GrF.setText(getString(2131758315, new Object[] { Integer.valueOf(this.GrI) }));
      this.GrG.setText(2131758307);
      this.hPX.setVisibility(4);
      this.GrE.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dKU.setImageResource(2131691229);
      this.GrF.setText(2131758319);
      this.GrG.setText(2131758310);
      this.hPX.setVisibility(0);
      this.GrE.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.dKU.setImageResource(2131691227);
      this.GrF.setText(2131758318);
      this.GrG.setText(2131758308);
      this.hPX.setVisibility(0);
      this.hPX.setText(2131758304);
      this.GrE.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.dKU.setImageResource(2131691227);
      this.GrF.setText(2131758316);
      this.GrG.setText(2131758308);
      this.hPX.setVisibility(0);
      this.hPX.setText(2131758304);
      this.GrE.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131763501);
      localIntent.putExtra("rawUrl", getString(2131763498));
      localIntent.putExtra("showShare", false);
      c.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      wz(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.dKU.setImageResource(2131691228);
      this.GrF.setText(2131758317);
      this.GrG.setText(2131758309);
      this.hPX.setVisibility(0);
      this.hPX.setText(2131758303);
      this.GrE.setVisibility(4);
    }
  }
  
  private void cxh()
  {
    AppMethodBeat.i(29688);
    if (this.yNv == null) {
      this.yNv = d.bca();
    }
    this.yNv.a(this.gmA, true);
    AppMethodBeat.o(29688);
  }
  
  private void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (Util.isNullOrNil(this.GrJ))
    {
      AppMethodBeat.o(29689);
      return;
    }
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 71, "", ""))
      {
        getString(2131755998);
        this.GrH = com.tencent.mm.ui.base.h.a(this, getString(2131758321), true, null);
        this.hPX.setEnabled(false);
        cxh();
      }
      AppMethodBeat.o(29689);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(14533, "," + this.GrJ);
    AppMethodBeat.o(29689);
  }
  
  public void finish()
  {
    AppMethodBeat.i(29686);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(29686);
  }
  
  public int getLayoutId()
  {
    return 2131495839;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29690);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (((this.GrC == 5) || (this.GrC == 4)) && (paramView == this.hPX)) {
      wz(true);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29690);
      return;
      wz(false);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29685);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772132, 2130771986);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.GrC = paramBundle.getIntExtra("diagnose_state", 0);
    this.GrI = paramBundle.getIntExtra("diagnose_percent", 1);
    this.GrJ = paramBundle.getStringExtra("diagnose_kvInfo");
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.GrC), Integer.valueOf(this.GrI), this.GrJ });
    if (this.GrC == 0)
    {
      this.GrC = 1;
      Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      bg.azz().a(new bu(new bu.a()
      {
        public final void a(g paramAnonymousg)
        {
          AppMethodBeat.i(29682);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(29682);
            return;
          }
          try
          {
            paramAnonymousg.aZk();
            AppMethodBeat.o(29682);
            return;
          }
          catch (Exception paramAnonymousg)
          {
            AppMethodBeat.o(29682);
          }
        }
      }), 0);
    }
    this.hPX = ((Button)findViewById(2131299610));
    this.GrD = ((TextView)findViewById(2131299608));
    this.GrE = ((TextView)findViewById(2131299607));
    this.dKU = ((ImageView)findViewById(2131299612));
    this.GrF = ((TextView)findViewById(2131299613));
    this.GrG = ((TextView)findViewById(2131299609));
    this.GrD.setOnClickListener(this);
    this.hPX.setOnClickListener(this);
    this.GrE.setOnClickListener(this);
    bpn();
    this.GrK = new IListener() {};
    EventCenter.instance.add(this.GrK);
    this.gmA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(29680);
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).c(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
        }
        MMHandlerThread.postToMainThread(new Runnable()
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
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!d.bcc()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            com.tencent.mm.ui.base.h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(2131761461), NetworkDiagnoseAllInOneUI.this.getString(2131755998), NetworkDiagnoseAllInOneUI.this.getString(2131762043), NetworkDiagnoseAllInOneUI.this.getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                d.cZ(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          Log.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.cve = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29681);
        NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) + 1);
        Log.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) });
        if (NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this) > 99)
        {
          AppMethodBeat.o(29681);
          return false;
        }
        if (NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this) == 1) {
          NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this).setText(NetworkDiagnoseAllInOneUI.this.getString(2131758315, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) }));
        }
        AppMethodBeat.o(29681);
        return true;
      }
    }, true);
    if ((this.GrC == 0) || (this.GrC == 1)) {
      this.cve.startTimer(1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    EventCenter.instance.removeListener(this.GrK);
    if (this.yNv != null)
    {
      this.yNv.c(this.gmA);
      this.yNv = null;
    }
    if (this.cve != null)
    {
      this.cve.stopTimer();
      this.cve = null;
    }
    AppMethodBeat.o(29691);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29692);
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29692);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        wz(true);
        AppMethodBeat.o(29692);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131763865), false, new NetworkDiagnoseAllInOneUI.5(this), new NetworkDiagnoseAllInOneUI.6(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */