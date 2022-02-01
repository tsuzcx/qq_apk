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
import com.tencent.mm.ui.s;
import com.tencent.scanlib.ui.ScanCodeView;
import com.tencent.scanlib.ui.ScanCodeView.a;

@com.tencent.mm.ui.base.a(35)
public class ScanSampleActivity
  extends MMActivity
{
  private ScanCodeView yIH;
  
  public int getLayoutId()
  {
    return 2131495304;
  }
  
  public void initView()
  {
    AppMethodBeat.i(91053);
    this.yIH = ((ScanCodeView)findViewById(2131304344));
    this.yIH.setScanCallBack(new ScanCodeView.a()
    {
      public final void ao(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(91051);
        paramAnonymousBundle = paramAnonymousBundle.getString("result_content", "");
        if (!com.tencent.scanlib.a.isNullOrNil(paramAnonymousBundle)) {
          h.c(ScanSampleActivity.this, paramAnonymousBundle, "", true);
        }
        AppMethodBeat.o(91051);
      }
    });
    this.yIH.onCreate();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(91053);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(91052);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getController().q(this, getResources().getColor(2131101053));
    getController().setNavigationbarColor(getResources().getColor(2131101053));
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
    this.yIH.onDestroy();
    AppMethodBeat.o(91057);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(91055);
    super.onPause();
    this.yIH.onPause();
    AppMethodBeat.o(91055);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(91054);
    super.onResume();
    this.yIH.onResume();
    AppMethodBeat.o(91054);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(91056);
    super.onStop();
    this.yIH.onStop();
    AppMethodBeat.o(91056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanSampleActivity
 * JD-Core Version:    0.7.0.1
 */