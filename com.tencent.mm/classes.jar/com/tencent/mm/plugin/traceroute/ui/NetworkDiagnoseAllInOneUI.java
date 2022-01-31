package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ki;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class NetworkDiagnoseAllInOneUI
  extends MMActivity
  implements View.OnClickListener
{
  private ImageView bNu;
  private a.a dig;
  private Button fbO;
  private am fjC;
  private com.tencent.mm.modelgeo.c lKa;
  private int pIS;
  private TextView pIT;
  private TextView pIU;
  private TextView pIV;
  private TextView pIW;
  private com.tencent.mm.ui.base.p pIX;
  private int pIY;
  private String pIZ;
  private com.tencent.mm.sdk.b.c<ki> pJa;
  private boolean pJb;
  private boolean pJc;
  private boolean pJd;
  
  private void XS()
  {
    y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[] { Integer.valueOf(this.pIS) });
    switch (this.pIS)
    {
    default: 
      return;
    case 0: 
    case 1: 
      this.bNu.setImageResource(R.k.network_diagnose_work);
      this.pIV.setText(getString(R.l.diagnose_state_doing, new Object[] { Integer.valueOf(this.pIY) }));
      this.pIW.setText(R.l.diagnose_descript_doing);
      this.fbO.setVisibility(4);
      this.pIU.setVisibility(4);
      return;
    case 2: 
      this.bNu.setImageResource(R.k.network_diagnose_work);
      this.pIV.setText(R.l.diagnose_state_success);
      this.pIW.setText(R.l.diagnose_descript_success);
      this.fbO.setVisibility(0);
      this.pIU.setVisibility(4);
      return;
    case 4: 
      this.bNu.setImageResource(R.k.network_diagnose_fail);
      this.pIV.setText(R.l.diagnose_state_longlink_fail);
      this.pIW.setText(R.l.diagnose_descript_fail);
      this.fbO.setVisibility(0);
      this.fbO.setText(R.l.diagnose_btn_submit);
      this.pIU.setVisibility(0);
      return;
    case 5: 
      this.bNu.setImageResource(R.k.network_diagnose_fail);
      this.pIV.setText(R.l.diagnose_state_fail);
      this.pIW.setText(R.l.diagnose_descript_fail);
      this.fbO.setVisibility(0);
      this.fbO.setText(R.l.diagnose_btn_submit);
      this.pIU.setVisibility(0);
      return;
    case 3: 
      Intent localIntent = new Intent();
      localIntent.putExtra("title", R.l.net_warn_no_network);
      localIntent.putExtra("rawUrl", getString(R.l.net_warn_detail_doc));
      localIntent.putExtra("showShare", false);
      d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
      jN(false);
      finish();
      return;
    }
    this.bNu.setImageResource(R.k.network_diagnose_feedback);
    this.pIV.setText(R.l.diagnose_state_feedback);
    this.pIW.setText(R.l.diagnose_descript_feedback);
    this.fbO.setVisibility(0);
    this.fbO.setText(R.l.diagnose_btn_comfirm);
    this.pIU.setVisibility(4);
  }
  
  private void jN(boolean paramBoolean)
  {
    if (bk.bl(this.pIZ)) {
      return;
    }
    y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", ""))
      {
        getString(R.l.app_tip);
        this.pIX = com.tencent.mm.ui.base.h.b(this, getString(R.l.diagnose_uploading), true, null);
        this.fbO.setEnabled(false);
        if (this.lKa == null) {
          this.lKa = com.tencent.mm.modelgeo.c.Ob();
        }
        this.lKa.a(this.dig, true);
      }
    }
    for (;;)
    {
      this.pIZ = null;
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.aC(14533, "," + this.pIZ);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
  }
  
  protected final int getLayoutId()
  {
    return R.i.network_diagnose_all_in_one;
  }
  
  public void onClick(View paramView)
  {
    if (((this.pIS == 5) || (this.pIS == 4)) && (paramView == this.fbO))
    {
      jN(true);
      return;
    }
    jN(false);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    setMMTitle("");
    getSupportActionBar().hide();
    paramBundle = getIntent();
    this.pIS = paramBundle.getIntExtra("diagnose_state", 0);
    this.pIY = paramBundle.getIntExtra("diagnose_percent", 1);
    this.pIZ = paramBundle.getStringExtra("diagnose_kvInfo");
    y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[] { Integer.valueOf(this.pIS), Integer.valueOf(this.pIY), this.pIZ });
    if (this.pIS == 0)
    {
      this.pIS = 1;
      y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
      au.Dk().a(new bi(new NetworkDiagnoseAllInOneUI.4(this)), 0);
    }
    this.fbO = ((Button)findViewById(R.h.diagnose_okBtn));
    this.pIT = ((TextView)findViewById(R.h.diagnose_closeLabel));
    this.pIU = ((TextView)findViewById(R.h.diagnose_cancelLabel));
    this.bNu = ((ImageView)findViewById(R.h.diagnose_state_img));
    this.pIV = ((TextView)findViewById(R.h.diagnose_state_label));
    this.pIW = ((TextView)findViewById(R.h.diagnose_descp_label));
    this.pIT.setOnClickListener(this);
    this.fbO.setOnClickListener(this);
    this.pIU.setOnClickListener(this);
    XS();
    this.pJa = new NetworkDiagnoseAllInOneUI.1(this);
    com.tencent.mm.sdk.b.a.udP.b(this.pJa);
    this.dig = new NetworkDiagnoseAllInOneUI.2(this);
    this.fjC = new am(new NetworkDiagnoseAllInOneUI.3(this), true);
    if ((this.pIS == 0) || (this.pIS == 1)) {
      this.fjC.S(1000L, 1000L);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.pJa);
    if (this.lKa != null)
    {
      this.lKa.c(this.dig);
      this.lKa = null;
    }
    if (this.fjC != null)
    {
      this.fjC.stopTimer();
      this.fjC = null;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      jN(true);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.permission_cancel), false, new NetworkDiagnoseAllInOneUI.5(this), new NetworkDiagnoseAllInOneUI.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI
 * JD-Core Version:    0.7.0.1
 */