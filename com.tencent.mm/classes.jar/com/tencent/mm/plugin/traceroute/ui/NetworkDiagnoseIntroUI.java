package com.tencent.mm.plugin.traceroute.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;

public class NetworkDiagnoseIntroUI
  extends MMActivity
{
  private Button pJi;
  private TextView pJj;
  
  protected final int getLayoutId()
  {
    return R.i.network_diagnose_ready;
  }
  
  protected final void initView()
  {
    this.pJi = ((Button)findViewById(R.h.start_diagnose));
    this.pJi.setOnClickListener(new NetworkDiagnoseIntroUI.1(this));
    this.pJj = ((TextView)findViewById(R.h.net_diagnose_privacy_intro));
    this.pJj.setOnClickListener(new NetworkDiagnoseIntroUI.2(this));
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        NetworkDiagnoseIntroUI.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI
 * JD-Core Version:    0.7.0.1
 */