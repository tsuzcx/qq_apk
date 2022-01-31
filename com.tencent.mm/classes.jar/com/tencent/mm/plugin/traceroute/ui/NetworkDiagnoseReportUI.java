package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ui.MMActivity;

public class NetworkDiagnoseReportUI
  extends MMActivity
{
  private static String tmL;
  private Button tnA;
  private Button tnB;
  private ImageView tnC;
  private TextView tnD;
  private TextView tnE;
  private TextView tnF;
  private boolean tnz = false;
  
  public int getLayoutId()
  {
    return 2130970354;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26021);
    setMMTitle("");
    this.tnC = ((ImageView)findViewById(2131826522));
    this.tnD = ((TextView)findViewById(2131826523));
    this.tnE = ((TextView)findViewById(2131826524));
    this.tnz = getIntent().getBooleanExtra("diagnose_result", false);
    if (this.tnz)
    {
      this.tnC.setImageResource(2130839778);
      this.tnD.setText(getString(2131304446));
      this.tnE.setVisibility(0);
      addTextOptionMenu(0, getString(2131298963), new NetworkDiagnoseReportUI.1(this));
      AppMethodBeat.o(26021);
      return;
    }
    setBackBtn(new NetworkDiagnoseReportUI.2(this));
    tmL = getIntent().getStringExtra("diagnose_log_file_path");
    this.tnC.setImageResource(2130839777);
    this.tnD.setText(getString(2131304445));
    if ((tmL == null) || (e.cM(tmL) <= 0))
    {
      AppMethodBeat.o(26021);
      return;
    }
    this.tnF = ((TextView)findViewById(2131826527));
    this.tnF.setText(getString(2131302639, new Object[] { tmL.replace("mnt/", "") }));
    findViewById(2131826527).setVisibility(0);
    findViewById(2131826529).setVisibility(0);
    this.tnA = ((Button)findViewById(2131826528));
    this.tnA.setVisibility(0);
    this.tnA.setOnClickListener(new NetworkDiagnoseReportUI.3(this));
    this.tnB = ((Button)findViewById(2131826526));
    this.tnB.setVisibility(0);
    this.tnB.setOnClickListener(new NetworkDiagnoseReportUI.4(this));
    AppMethodBeat.o(26021);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26020);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(26020);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI
 * JD-Core Version:    0.7.0.1
 */