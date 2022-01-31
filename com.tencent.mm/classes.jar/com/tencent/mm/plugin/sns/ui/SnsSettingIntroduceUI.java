package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class SnsSettingIntroduceUI
  extends MMActivity
{
  private Button pcY;
  private Button pcZ;
  private Intent pda;
  
  protected final int getLayoutId()
  {
    return i.g.sns_setting_introduce_ui;
  }
  
  @TargetApi(17)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    this.mController.hideTitleView();
    this.pda = getIntent();
    this.pcY = ((Button)findViewById(i.f.back_btn));
    this.pcY.setOnClickListener(new SnsSettingIntroduceUI.1(this));
    h.nFQ.f(14090, new Object[] { Integer.valueOf(1) });
    this.pcZ = ((Button)findViewById(i.f.go_btn));
    this.pcZ.setOnClickListener(new SnsSettingIntroduceUI.2(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      h.nFQ.f(14090, new Object[] { Integer.valueOf(3) });
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI
 * JD-Core Version:    0.7.0.1
 */