package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.scanlib.ui.ScanCodeView;
import com.tencent.scanlib.ui.ScanCodeView.a;

@com.tencent.mm.ui.base.a(35)
public class ScanSampleActivity
  extends MMActivity
{
  private ScanCodeView CMu;
  
  public int getLayoutId()
  {
    return 2131496154;
  }
  
  public void initView()
  {
    AppMethodBeat.i(91053);
    this.CMu = ((ScanCodeView)findViewById(2131307276));
    this.CMu.setScanCallBack(new ScanCodeView.a()
    {
      public final void ay(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(91051);
        paramAnonymousBundle = paramAnonymousBundle.getString("result_content", "");
        if (!com.tencent.scanlib.a.isNullOrNil(paramAnonymousBundle)) {
          h.c(ScanSampleActivity.this, paramAnonymousBundle, "", true);
        }
        AppMethodBeat.o(91051);
      }
    });
    this.CMu.onCreate();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(91053);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(91052);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getController().p(this, getResources().getColor(2131101287));
    getController().setNavigationbarColor(getResources().getColor(2131101287));
    paramBundle = getWindow().getDecorView();
    int i = 1796;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 5892;
    }
    paramBundle.setSystemUiVisibility(i);
    initView();
    AppMethodBeat.o(91052);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(91057);
    super.onDestroy();
    this.CMu.onDestroy();
    AppMethodBeat.o(91057);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(91055);
    super.onPause();
    this.CMu.onPause();
    AppMethodBeat.o(91055);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(91054);
    super.onResume();
    this.CMu.onResume();
    AppMethodBeat.o(91054);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(91056);
    super.onStop();
    this.CMu.onStop();
    AppMethodBeat.o(91056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanSampleActivity
 * JD-Core Version:    0.7.0.1
 */