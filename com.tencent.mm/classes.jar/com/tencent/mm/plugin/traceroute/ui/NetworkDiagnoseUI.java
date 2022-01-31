package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class NetworkDiagnoseUI
  extends MMActivity
{
  private ak handler;
  private TextView mBO;
  private int oNy;
  private final int tnH;
  private int tnI;
  private a tnJ;
  private MMProgressBar tnK;
  private ap tnL;
  
  public NetworkDiagnoseUI()
  {
    AppMethodBeat.i(26034);
    this.tnH = 100;
    this.oNy = 0;
    this.tnI = 0;
    this.tnL = new ap(new NetworkDiagnoseUI.1(this), true);
    this.handler = new NetworkDiagnoseUI.2(this);
    AppMethodBeat.o(26034);
  }
  
  private void cKL()
  {
    AppMethodBeat.i(26040);
    h.a(this, 2131298493, 2131298957, 2131297115, 2131297014, new NetworkDiagnoseUI.7(this), new NetworkDiagnoseUI.8(this));
    AppMethodBeat.o(26040);
  }
  
  public int getLayoutId()
  {
    return 2130970355;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26036);
    this.mBO = ((TextView)findViewById(2131826531));
    this.tnK = ((MMProgressBar)findViewById(2131826530));
    this.tnK.setOnProgressChangedListener(new NetworkDiagnoseUI.3(this));
    setMMTitle("");
    setBackBtn(new NetworkDiagnoseUI.4(this));
    new ak().postDelayed(new NetworkDiagnoseUI.5(this), 200L);
    AppMethodBeat.o(26036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26035);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(26035);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26039);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      cKL();
      AppMethodBeat.o(26039);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26039);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26037);
    this.tnK.setAutoProgress(false);
    super.onPause();
    AppMethodBeat.o(26037);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26038);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(this);
      AppMethodBeat.o(26038);
      return;
    }
    this.tnK.setAutoProgress(true);
    super.onResume();
    AppMethodBeat.o(26038);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI
 * JD-Core Version:    0.7.0.1
 */