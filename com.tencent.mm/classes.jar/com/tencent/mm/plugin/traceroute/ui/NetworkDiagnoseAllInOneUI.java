package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.oc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private d Ert;
  private int Nen;
  private TextView Neo;
  private TextView Nep;
  private TextView Neq;
  private TextView Ner;
  private s Nes;
  private int Net;
  private String Neu;
  private IListener<oc> Nev;
  private boolean New;
  private boolean Nex;
  private boolean Ney;
  private MTimerHandler cts;
  private ImageView fDJ;
  private b.a iQJ;
  private Button kEt;
  private boolean zHI;
  
  private void Am(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (Util.isNullOrNil(this.Neu))
    {
      AppMethodBeat.o(29689);
      return;
    }
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 71, "", ""))
      {
        getString(R.l.app_tip);
        this.Nes = com.tencent.mm.ui.base.h.a(this, getString(R.l.eBs), true, null);
        this.kEt.setEnabled(false);
        cKK();
      }
      AppMethodBeat.o(29689);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14533, "," + this.Neu);
    AppMethodBeat.o(29689);
  }
  
  private void bzz()
  {
    AppMethodBeat.i(29687);
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.Nen) });
    switch (this.Nen)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.fDJ.setImageResource(R.k.network_diagnose_work);
      this.Neq.setText(getString(R.l.eBn, new Object[] { Integer.valueOf(this.Net) }));
      this.Ner.setText(R.l.eBi);
      this.kEt.setVisibility(4);
      this.Nep.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.fDJ.setImageResource(R.k.network_diagnose_work);
      this.Neq.setText(R.l.eBr);
      this.Ner.setText(R.l.eBl);
      this.kEt.setVisibility(0);
      this.Nep.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.fDJ.setImageResource(R.k.network_diagnose_fail);
      this.Neq.setText(R.l.eBq);
      this.Ner.setText(R.l.eBj);
      this.kEt.setVisibility(0);
      this.kEt.setText(R.l.eBg);
      this.Nep.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.fDJ.setImageResource(R.k.network_diagnose_fail);
      this.Neq.setText(R.l.eBo);
      this.Ner.setText(R.l.eBj);
      this.kEt.setVisibility(0);
      this.kEt.setText(R.l.eBg);
      this.Nep.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", R.l.net_warn_no_network);
      localIntent.putExtra("rawUrl", getString(R.l.net_warn_detail_doc));
      localIntent.putExtra("showShare", false);
      c.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      Am(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.fDJ.setImageResource(R.k.network_diagnose_feedback);
      this.Neq.setText(R.l.eBp);
      this.Ner.setText(R.l.eBk);
      this.kEt.setVisibility(0);
      this.kEt.setText(R.l.eBf);
      this.Nep.setVisibility(4);
    }
  }
  
  private void cKK()
  {
    AppMethodBeat.i(29688);
    if (this.Ert == null) {
      this.Ert = d.blq();
    }
    this.Ert.a(this.iQJ, true);
    AppMethodBeat.o(29688);
  }
  
  public void finish()
  {
    AppMethodBeat.i(29686);
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(29686);
  }
  
  public int getLayoutId()
  {
    return R.i.ejs;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29690);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (((this.Nen == 5) || (this.Nen == 4)) && (paramView == this.kEt)) {
      Am(true);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29690);
      return;
      Am(false);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29685);
    super.onCreate(paramBundle);
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.Nen = paramBundle.getIntExtra("diagnose_state", 0);
    this.Net = paramBundle.getIntExtra("diagnose_percent", 1);
    this.Neu = paramBundle.getStringExtra("diagnose_kvInfo");
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.Nen), Integer.valueOf(this.Net), this.Neu });
    if (this.Nen == 0)
    {
      this.Nen = 1;
      Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      bh.aGY().a(new bv(new NetworkDiagnoseAllInOneUI.4(this)), 0);
    }
    this.kEt = ((Button)findViewById(R.h.dEo));
    this.Neo = ((TextView)findViewById(R.h.dEm));
    this.Nep = ((TextView)findViewById(R.h.dEl));
    this.fDJ = ((ImageView)findViewById(R.h.dEq));
    this.Neq = ((TextView)findViewById(R.h.dEr));
    this.Ner = ((TextView)findViewById(R.h.dEn));
    this.Neo.setOnClickListener(this);
    this.kEt.setOnClickListener(this);
    this.Nep.setOnClickListener(this);
    bzz();
    this.Nev = new IListener() {};
    EventCenter.instance.add(this.Nev);
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(29680);
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).b(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
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
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(14533, str);
          AppMethodBeat.o(29680);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!d.blr()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            com.tencent.mm.ui.base.h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(R.l.gps_disable_tip), NetworkDiagnoseAllInOneUI.this.getString(R.l.app_tip), NetworkDiagnoseAllInOneUI.this.getString(R.l.jump_to_settings), NetworkDiagnoseAllInOneUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                d.cW(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          Log.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.cts = new MTimerHandler(new MTimerHandler.CallBack()
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
          NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this).setText(NetworkDiagnoseAllInOneUI.this.getString(R.l.eBn, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this)) }));
        }
        AppMethodBeat.o(29681);
        return true;
      }
    }, true);
    if ((this.Nen == 0) || (this.Nen == 1)) {
      this.cts.startTimer(1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    EventCenter.instance.removeListener(this.Nev);
    if (this.Ert != null)
    {
      this.Ert.b(this.iQJ);
      this.Ert = null;
    }
    if (this.cts != null)
    {
      this.cts.stopTimer();
      this.cts = null;
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
        Am(true);
        AppMethodBeat.o(29692);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.permission_cancel), false, new NetworkDiagnoseAllInOneUI.5(this), new NetworkDiagnoseAllInOneUI.6(this));
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