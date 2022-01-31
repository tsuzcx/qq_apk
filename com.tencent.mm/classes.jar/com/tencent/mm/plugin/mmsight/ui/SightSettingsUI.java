package com.tencent.mm.plugin.mmsight.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class SightSettingsUI
  extends MMActivity
{
  private d eMh = new d(this);
  private ListView fuF;
  private CaptureMMProxy mfJ;
  private SightSettingsUI.a mqK;
  private LinkedList<SightSettingsUI.b> mqL = new LinkedList();
  
  protected final int getLayoutId()
  {
    return a.f.sight_settings_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mfJ = new CaptureMMProxy(this.eMh);
    this.eMh.connect(new SightSettingsUI.1(this));
    setBackBtn(new SightSettingsUI.2(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eMh.release();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI
 * JD-Core Version:    0.7.0.1
 */