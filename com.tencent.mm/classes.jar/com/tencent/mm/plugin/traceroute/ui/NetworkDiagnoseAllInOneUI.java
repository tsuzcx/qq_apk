package com.tencent.mm.plugin.traceroute.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pk;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private boolean EPk;
  private d KjZ;
  private int TRa;
  private TextView TRb;
  private TextView TRc;
  private TextView TRd;
  private TextView TRe;
  private w TRf;
  private int TRg;
  private String TRh;
  private IListener<pk> TRi;
  private boolean TRj;
  private boolean TRk;
  private boolean TRl;
  private MTimerHandler eln;
  private ImageView hIz;
  private b.a lsF;
  private Button nhC;
  
  private void FH(boolean paramBoolean)
  {
    AppMethodBeat.i(29689);
    if (Util.isNullOrNil(this.TRh))
    {
      AppMethodBeat.o(29689);
      return;
    }
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 71, ""))
      {
        getString(R.l.app_tip);
        this.TRf = k.a(this, getString(R.l.gEv), true, null);
        this.nhC.setEnabled(false);
        don();
      }
      AppMethodBeat.o(29689);
      return;
    }
    h.OAn.kvStat(14533, "," + this.TRh);
    AppMethodBeat.o(29689);
  }
  
  private void bYl()
  {
    AppMethodBeat.i(29687);
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.TRa) });
    switch (this.TRa)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29687);
      return;
      this.hIz.setImageResource(R.k.network_diagnose_work);
      this.TRd.setText(getString(R.l.gEq, new Object[] { Integer.valueOf(this.TRg) }));
      this.TRe.setText(R.l.gEl);
      this.nhC.setVisibility(4);
      this.TRc.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.hIz.setImageResource(R.k.network_diagnose_work);
      this.TRd.setText(R.l.gEu);
      this.TRe.setText(R.l.gEo);
      this.nhC.setVisibility(0);
      this.TRc.setVisibility(4);
      AppMethodBeat.o(29687);
      return;
      this.hIz.setImageResource(R.k.network_diagnose_fail);
      this.TRd.setText(R.l.gEt);
      this.TRe.setText(R.l.gEm);
      this.nhC.setVisibility(0);
      this.nhC.setText(R.l.gEj);
      this.TRc.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      this.hIz.setImageResource(R.k.network_diagnose_fail);
      this.TRd.setText(R.l.gEr);
      this.TRe.setText(R.l.gEm);
      this.nhC.setVisibility(0);
      this.nhC.setText(R.l.gEj);
      this.TRc.setVisibility(0);
      AppMethodBeat.o(29687);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", R.l.net_warn_no_network);
      localIntent.putExtra("rawUrl", getString(R.l.net_warn_detail_doc));
      localIntent.putExtra("showShare", false);
      c.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      FH(false);
      finish();
      AppMethodBeat.o(29687);
      return;
      this.hIz.setImageResource(R.k.network_diagnose_feedback);
      this.TRd.setText(R.l.gEs);
      this.TRe.setText(R.l.gEn);
      this.nhC.setVisibility(0);
      this.nhC.setText(R.l.gEi);
      this.TRc.setVisibility(4);
    }
  }
  
  private void don()
  {
    AppMethodBeat.i(29688);
    if (this.KjZ == null) {
      this.KjZ = d.bJl();
    }
    this.KjZ.a(this.lsF, true, false);
    l.kK(22, 10);
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
    return R.i.gmt;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(29690);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (((this.TRa == 5) || (this.TRa == 4)) && (paramView == this.nhC)) {
      FH(true);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/traceroute/ui/NetworkDiagnoseAllInOneUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29690);
      return;
      FH(false);
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
    this.TRa = paramBundle.getIntExtra("diagnose_state", 0);
    this.TRg = paramBundle.getIntExtra("diagnose_percent", 1);
    this.TRh = paramBundle.getStringExtra("diagnose_kvInfo");
    Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.TRa), Integer.valueOf(this.TRg), this.TRh });
    if (this.TRa == 0)
    {
      this.TRa = 1;
      Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      bh.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(29682);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(29682);
            return;
          }
          try
          {
            paramAnonymousg.bGj();
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
    this.nhC = ((Button)findViewById(R.h.fFt));
    this.TRb = ((TextView)findViewById(R.h.fFr));
    this.TRc = ((TextView)findViewById(R.h.fFq));
    this.hIz = ((ImageView)findViewById(R.h.fFv));
    this.TRd = ((TextView)findViewById(R.h.fFw));
    this.TRe = ((TextView)findViewById(R.h.fFs));
    this.TRb.setOnClickListener(this);
    this.nhC.setOnClickListener(this);
    this.TRc.setOnClickListener(this);
    bYl();
    this.TRi = new IListener(f.hfK) {};
    this.TRi.alive();
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(260952);
        Log.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this) != null) {
          NetworkDiagnoseAllInOneUI.f(NetworkDiagnoseAllInOneUI.this).a(NetworkDiagnoseAllInOneUI.g(NetworkDiagnoseAllInOneUI.this));
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
          h.OAn.kvStat(14533, str);
          AppMethodBeat.o(260952);
          return false;
          if ((!NetworkDiagnoseAllInOneUI.k(NetworkDiagnoseAllInOneUI.this)) && (!d.bJm()))
          {
            NetworkDiagnoseAllInOneUI.l(NetworkDiagnoseAllInOneUI.this);
            k.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(R.l.gps_disable_tip), NetworkDiagnoseAllInOneUI.this.getString(R.l.app_tip), NetworkDiagnoseAllInOneUI.this.getString(R.l.jump_to_settings), NetworkDiagnoseAllInOneUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29679);
                d.dP(NetworkDiagnoseAllInOneUI.this);
                AppMethodBeat.o(29679);
              }
            }, null);
          }
          Log.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
        }
      }
    };
    this.eln = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29681);
        NetworkDiagnoseAllInOneUI.m(NetworkDiagnoseAllInOneUI.this);
        Log.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this)) });
        if (NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this) > 99)
        {
          AppMethodBeat.o(29681);
          return false;
        }
        if (NetworkDiagnoseAllInOneUI.a(NetworkDiagnoseAllInOneUI.this) == 1) {
          NetworkDiagnoseAllInOneUI.o(NetworkDiagnoseAllInOneUI.this).setText(NetworkDiagnoseAllInOneUI.this.getString(R.l.gEq, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.n(NetworkDiagnoseAllInOneUI.this)) }));
        }
        AppMethodBeat.o(29681);
        return true;
      }
    }, true);
    if ((this.TRa == 0) || (this.TRa == 1)) {
      this.eln.startTimer(1000L);
    }
    AppMethodBeat.o(29685);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29691);
    super.onDestroy();
    this.TRi.dead();
    if (this.KjZ != null)
    {
      this.KjZ.a(this.lsF);
      this.KjZ = null;
    }
    if (this.eln != null)
    {
      this.eln.stopTimer();
      this.eln = null;
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
        FH(true);
        AppMethodBeat.o(29692);
        return;
      }
      k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.permission_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29683);
          com.tencent.mm.pluginsdk.permission.b.lx(NetworkDiagnoseAllInOneUI.this.getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */