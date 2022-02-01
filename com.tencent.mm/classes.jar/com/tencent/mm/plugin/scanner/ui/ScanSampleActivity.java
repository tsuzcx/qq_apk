package com.tencent.mm.plugin.scanner.ui;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.al.a.a;
import com.tencent.mm.plugin.al.a.b;
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.f;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.y;
import com.tencent.scanlib.ui.ScanCodeView;

@a(35)
public class ScanSampleActivity
  extends MMActivity
{
  private ScanCodeView PaP;
  
  public int getLayoutId()
  {
    return a.f.scan_sample_activity;
  }
  
  public void initView()
  {
    AppMethodBeat.i(91053);
    this.PaP = ((ScanCodeView)findViewById(a.e.scan_view));
    this.PaP.setScanCallBack(new ScanSampleActivity.1(this));
    this.PaP.onCreate();
    int i = a.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(91053);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(91052);
    requestWindowFeature(1);
    e.jB(this);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getController().s(this, getResources().getColor(a.b.transparent));
    getController().setNavigationbarColor(getResources().getColor(a.b.transparent));
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
    this.PaP.onDestroy();
    AppMethodBeat.o(91057);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(91055);
    super.onPause();
    this.PaP.onPause();
    AppMethodBeat.o(91055);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(91054);
    super.onResume();
    this.PaP.onResume();
    AppMethodBeat.o(91054);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(91056);
    super.onStop();
    this.PaP.onStop();
    AppMethodBeat.o(91056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanSampleActivity
 * JD-Core Version:    0.7.0.1
 */