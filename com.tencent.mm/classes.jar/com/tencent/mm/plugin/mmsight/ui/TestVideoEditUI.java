package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.f;
import com.tencent.mm.api.q;
import com.tencent.mm.api.q.a.a;
import com.tencent.mm.api.q.b;
import com.tencent.mm.api.q.c;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class TestVideoEditUI
  extends MMActivity
  implements f
{
  private q mqU;
  
  protected final int getLayoutId()
  {
    return a.f.test_video_edit_ui;
  }
  
  public void onBackPressed()
  {
    if (!this.mqU.rG()) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    paramBundle = (FrameLayout)findViewById(a.e.content);
    this.mqU = q.buU.rJ();
    Object localObject = this.mqU;
    q.a.a locala = new q.a.a();
    locala.buW = false;
    locala.buY = true;
    locala.buZ = new Rect(0, 0, 1080, 1080);
    locala.buV = q.c.bva;
    ((q)localObject).a(locala.sh());
    localObject = this.mqU.ax(this.mController.uMN);
    ((b)localObject).setActionBarCallback(this);
    paramBundle.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    ((b)localObject).setSelectedFeatureListener(new TestVideoEditUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mqU.onDestroy();
  }
  
  public final void onFinish()
  {
    this.mqU.a(new TestVideoEditUI.2(this));
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
  }
  
  public final void rX()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI
 * JD-Core Version:    0.7.0.1
 */