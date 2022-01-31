package com.tencent.mm.plugin.traceroute.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseUI
  extends MMActivity
{
  private ah handler = new NetworkDiagnoseUI.2(this);
  private TextView kgZ;
  private int moo = 0;
  private final int pJt = 100;
  private int pJu = 0;
  private a pJv;
  private MMProgressBar pJw;
  private am pJx = new am(new am.a()
  {
    public final boolean tC()
    {
      NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, NetworkDiagnoseUI.a(NetworkDiagnoseUI.this) + 1);
      NetworkDiagnoseUI.b(NetworkDiagnoseUI.this, NetworkDiagnoseUI.b(NetworkDiagnoseUI.this));
      if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 100)
      {
        NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(NetworkDiagnoseUI.b(NetworkDiagnoseUI.this));
        return true;
      }
      NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(100);
      return false;
    }
  }, true);
  
  private void bOP()
  {
    h.a(this, R.l.confirm_cancel_diagnose, R.l.diagnose_cancel_confirm_title, R.l.app_yes, R.l.app_no, new NetworkDiagnoseUI.7(this), new NetworkDiagnoseUI.8(this));
  }
  
  protected final int getLayoutId()
  {
    return R.i.network_diagnose_run;
  }
  
  protected final void initView()
  {
    this.kgZ = ((TextView)findViewById(R.h.report_status_tv));
    this.pJw = ((MMProgressBar)findViewById(R.h.diagnose_progress));
    this.pJw.setOnProgressChangedListener(new NetworkDiagnoseUI.3(this));
    setMMTitle("");
    setBackBtn(new NetworkDiagnoseUI.4(this));
    new ah().postDelayed(new NetworkDiagnoseUI.5(this), 200L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bOP();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    this.pJw.setAutoProgress(false);
    super.onPause();
  }
  
  protected void onResume()
  {
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(this);
      return;
    }
    this.pJw.setAutoProgress(true);
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI
 * JD-Core Version:    0.7.0.1
 */