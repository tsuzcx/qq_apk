package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(7)
public class WebSearchVoiceUI
  extends WebSearchBaseActivity
{
  private String bIB;
  private String bVp;
  private com.tencent.mm.pluginsdk.ui.websearch.a rvM;
  private View rvN;
  private int rvO;
  private int scene;
  
  protected final int getLayoutId()
  {
    return R.i.websearch_voice_ui;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      this.bIB = getIntent().getStringExtra("sessionId");
      this.bVp = getIntent().getStringExtra("subSessionId");
      this.scene = getIntent().getIntExtra("key_scene", -1);
      this.rvO = getIntent().getIntExtra("key_is_nav_voice", 0);
    }
    this.rvN = findViewById(R.h.voiceinput_mask_view);
    this.mController.hideTitleView();
    if (this.rvM == null)
    {
      this.rvM = new com.tencent.mm.pluginsdk.ui.websearch.a(this.mController.uMN);
      this.rvM.setCallback(new WebSearchVoiceUI.1(this));
    }
    this.rvM.cnP();
    com.tencent.mm.pluginsdk.ui.websearch.a locala = this.rvM;
    y.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(locala.sem), Boolean.valueOf(locala.shD) });
    if (locala.shD)
    {
      locala.shD = false;
      View localView = locala.findViewById(R.h.voice_panel_display_view);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = locala.sem;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      locala.cnR();
      locala.requestLayout();
    }
    this.rvM.setVisibility(0);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    ((ViewGroup)findViewById(R.h.root)).addView(this.rvM, paramBundle);
    h.nFQ.f(15178, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.bIB, this.bVp, Integer.valueOf(this.scene), Integer.valueOf(this.rvO) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.rvM != null) {
      this.rvM.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WebSearchVoiceUI
 * JD-Core Version:    0.7.0.1
 */