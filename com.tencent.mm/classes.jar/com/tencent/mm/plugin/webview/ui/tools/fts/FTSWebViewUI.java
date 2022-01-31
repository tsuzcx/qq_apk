package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.websearch.api.ao;

public class FTSWebViewUI
  extends FTSBaseWebViewUI
{
  private void cfH()
  {
    if (this.scene == 21) {
      ao.BG(19);
    }
  }
  
  protected final void aoX()
  {
    super.aoX();
    ao.BE(this.scene);
    if (this.scene == 21) {
      ao.BG(17);
    }
  }
  
  protected final void cew()
  {
    cfH();
    super.cew();
  }
  
  protected final String getHint()
  {
    return getString(R.l.app_search);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    cfH();
  }
  
  public void onClickCancelBtn(View paramView)
  {
    super.onClickCancelBtn(paramView);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ao.bZO();
    ao.bZP();
    if (this.scene == 21) {
      ao.BG(18);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    ao.bZN();
  }
  
  protected void onResume()
  {
    super.onResume();
    ao.bZM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSWebViewUI
 * JD-Core Version:    0.7.0.1
 */