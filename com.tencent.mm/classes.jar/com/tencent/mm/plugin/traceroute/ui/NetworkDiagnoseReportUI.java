package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.ui.MMActivity;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String pIx;
  private boolean pJl = false;
  private Button pJm;
  private Button pJn;
  private ImageView pJo;
  private TextView pJp;
  private TextView pJq;
  private TextView pJr;
  
  protected final int getLayoutId()
  {
    return R.i.network_diagnose_report;
  }
  
  protected final void initView()
  {
    setMMTitle("");
    this.pJo = ((ImageView)findViewById(R.h.report_result_iv));
    this.pJp = ((TextView)findViewById(R.h.report_result_tv));
    this.pJq = ((TextView)findViewById(R.h.report_result_tip_tv));
    this.pJl = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.pJl)
    {
      this.pJo.setImageResource(R.g.net_connectreport_success);
      this.pJp.setText(getString(R.l.upload_report_success));
      this.pJq.setVisibility(0);
      addTextOptionMenu(0, getString(R.l.diagnose_finish), new NetworkDiagnoseReportUI.1(this));
    }
    do
    {
      return;
      setBackBtn(new NetworkDiagnoseReportUI.2(this));
      pIx = getIntent().getStringExtra("diagnose_log_file_path");
      this.pJo.setImageResource(R.g.net_connectreport_fail);
      this.pJp.setText(getString(R.l.upload_report_failed));
    } while ((pIx == null) || (e.bJ(pIx) <= 0));
    this.pJr = ((TextView)findViewById(R.h.report_result_on_sdcard));
    this.pJr.setText(getString(R.l.report_on_sdcard, new Object[] { pIx.replace("mnt/", "") }));
    findViewById(R.h.report_result_on_sdcard).setVisibility(0);
    findViewById(R.h.send_mail_tip).setVisibility(0);
    this.pJm = ((Button)findViewById(R.h.send_report_by_email));
    this.pJm.setVisibility(0);
    this.pJm.setOnClickListener(new NetworkDiagnoseReportUI.3(this));
    this.pJn = ((Button)findViewById(R.h.view_log));
    this.pJn.setVisibility(0);
    this.pJn.setOnClickListener(new NetworkDiagnoseReportUI.4(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */