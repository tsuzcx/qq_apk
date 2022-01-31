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
import com.tencent.mm.g.a.kv;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private ap bAz;
  private ImageView cuM;
  private b.a dZA;
  private Button gtF;
  private boolean ogA;
  private com.tencent.mm.modelgeo.d oho;
  private int tng;
  private TextView tnh;
  private TextView tni;
  private TextView tnj;
  private TextView tnk;
  private com.tencent.mm.ui.base.p tnl;
  private int tnm;
  private String tnn;
  private c<kv> tno;
  private boolean tnp;
  private boolean tnq;
  private boolean tnr;
  
  private void ary()
  {
    AppMethodBeat.i(26004);
    ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.tng) });
    switch (this.tng)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26004);
      return;
      this.cuM.setImageResource(2131231765);
      this.tnj.setText(getString(2131298967, new Object[] { Integer.valueOf(this.tnm) }));
      this.tnk.setText(2131298959);
      this.gtF.setVisibility(4);
      this.tni.setVisibility(4);
      AppMethodBeat.o(26004);
      return;
      this.cuM.setImageResource(2131231765);
      this.tnj.setText(2131298971);
      this.tnk.setText(2131298962);
      this.gtF.setVisibility(0);
      this.tni.setVisibility(4);
      AppMethodBeat.o(26004);
      return;
      this.cuM.setImageResource(2131231763);
      this.tnj.setText(2131298970);
      this.tnk.setText(2131298960);
      this.gtF.setVisibility(0);
      this.gtF.setText(2131298956);
      this.tni.setVisibility(0);
      AppMethodBeat.o(26004);
      return;
      this.cuM.setImageResource(2131231763);
      this.tnj.setText(2131298968);
      this.tnk.setText(2131298960);
      this.gtF.setVisibility(0);
      this.gtF.setText(2131298956);
      this.tni.setVisibility(0);
      AppMethodBeat.o(26004);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("title", 2131301788);
      localIntent.putExtra("rawUrl", getString(2131301785));
      localIntent.putExtra("showShare", false);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      mE(false);
      finish();
      AppMethodBeat.o(26004);
      return;
      this.cuM.setImageResource(2131231764);
      this.tnj.setText(2131298969);
      this.tnk.setText(2131298961);
      this.gtF.setVisibility(0);
      this.gtF.setText(2131298955);
      this.tni.setVisibility(4);
    }
  }
  
  private void bfm()
  {
    AppMethodBeat.i(26005);
    if (this.oho == null) {
      this.oho = com.tencent.mm.modelgeo.d.agQ();
    }
    this.oho.a(this.dZA, true);
    AppMethodBeat.o(26005);
  }
  
  private void mE(boolean paramBoolean)
  {
    AppMethodBeat.i(26006);
    if (bo.isNullOrNil(this.tnn))
    {
      AppMethodBeat.o(26006);
      return;
    }
    ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(2131297087);
        this.tnl = com.tencent.mm.ui.base.h.b(this, getString(2131298973), true, null);
        this.gtF.setEnabled(false);
        bfm();
      }
      AppMethodBeat.o(26006);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14533, "," + this.tnn);
    AppMethodBeat.o(26006);
  }
  
  public void finish()
  {
    AppMethodBeat.i(26003);
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(26003);
  }
  
  public int getLayoutId()
  {
    return 2130970352;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(26007);
    if (((this.tng == 5) || (this.tng == 4)) && (paramView == this.gtF))
    {
      mE(true);
      AppMethodBeat.o(26007);
      return;
    }
    mE(false);
    finish();
    AppMethodBeat.o(26007);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26002);
    super.onCreate(paramBundle);
    overridePendingTransition(2131034230, 2131034130);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.tng = paramBundle.getIntExtra("diagnose_state", 0);
    this.tnm = paramBundle.getIntExtra("diagnose_percent", 1);
    this.tnn = paramBundle.getStringExtra("diagnose_kvInfo");
    ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.tng), Integer.valueOf(this.tnm), this.tnn });
    if (this.tng == 0)
    {
      this.tng = 1;
      ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      aw.Rc().a(new bk(new NetworkDiagnoseAllInOneUI.4(this)), 0);
    }
    this.gtF = ((Button)findViewById(2131826518));
    this.tnh = ((TextView)findViewById(2131826514));
    this.tni = ((TextView)findViewById(2131826519));
    this.cuM = ((ImageView)findViewById(2131826515));
    this.tnj = ((TextView)findViewById(2131826516));
    this.tnk = ((TextView)findViewById(2131826517));
    this.tnh.setOnClickListener(this);
    this.gtF.setOnClickListener(this);
    this.tni.setOnClickListener(this);
    ary();
    this.tno = new NetworkDiagnoseAllInOneUI.1(this);
    a.ymk.b(this.tno);
    this.dZA = new NetworkDiagnoseAllInOneUI.2(this);
    this.bAz = new ap(new NetworkDiagnoseAllInOneUI.3(this), true);
    if ((this.tng == 0) || (this.tng == 1)) {
      this.bAz.ag(1000L, 1000L);
    }
    AppMethodBeat.o(26002);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26008);
    super.onDestroy();
    a.ymk.d(this.tno);
    if (this.oho != null)
    {
      this.oho.c(this.dZA);
      this.oho = null;
    }
    if (this.bAz != null)
    {
      this.bAz.stopTimer();
      this.bAz = null;
    }
    AppMethodBeat.o(26008);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26009);
    ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26009);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        mE(true);
        AppMethodBeat.o(26009);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131302068), false, new DialogInterface.OnClickListener()new NetworkDiagnoseAllInOneUI.6
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26000);
          NetworkDiagnoseAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          AppMethodBeat.o(26000);
        }
      }, new NetworkDiagnoseAllInOneUI.6(this));
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