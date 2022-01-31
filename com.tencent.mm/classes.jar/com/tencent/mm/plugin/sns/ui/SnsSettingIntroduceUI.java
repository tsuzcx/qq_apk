package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;

public class SnsSettingIntroduceUI
  extends MMActivity
{
  private Button rVI;
  private Button rVJ;
  private Intent rVK;
  
  public int getLayoutId()
  {
    return 2130970861;
  }
  
  @TargetApi(17)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39245);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.rVK = getIntent();
    this.rVI = ((Button)findViewById(2131826460));
    this.rVI.setOnClickListener(new SnsSettingIntroduceUI.1(this));
    h.qsU.e(14090, new Object[] { Integer.valueOf(1) });
    this.rVJ = ((Button)findViewById(2131826085));
    this.rVJ.setOnClickListener(new SnsSettingIntroduceUI.2(this));
    AppMethodBeat.o(39245);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39246);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      h.qsU.e(14090, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(39246);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(39246);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI
 * JD-Core Version:    0.7.0.1
 */