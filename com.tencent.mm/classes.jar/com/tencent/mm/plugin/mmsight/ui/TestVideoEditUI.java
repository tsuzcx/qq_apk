package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a.a;
import com.tencent.mm.api.s.b;
import com.tencent.mm.api.s.c;
import com.tencent.mm.ui.MMActivity;

public class TestVideoEditUI
  extends MMActivity
  implements g
{
  private s oQJ;
  
  public int getLayoutId()
  {
    return 2130970993;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(55298);
    if (!this.oQJ.zY()) {
      finish();
    }
    AppMethodBeat.o(55298);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55296);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    paramBundle = (FrameLayout)findViewById(2131820946);
    this.oQJ = s.bWe.Ab();
    Object localObject = this.oQJ;
    s.a.a locala = new s.a.a();
    locala.bWg = false;
    locala.bWj = true;
    locala.bWk = new Rect(0, 0, 1080, 1080);
    locala.bWf = s.c.bWl;
    ((s)localObject).a(locala.Ax());
    localObject = this.oQJ.aV(getContext());
    ((c)localObject).setActionBarCallback(this);
    paramBundle.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    ((c)localObject).setSelectedFeatureListener(new TestVideoEditUI.1(this));
    AppMethodBeat.o(55296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55297);
    super.onDestroy();
    this.oQJ.onDestroy();
    AppMethodBeat.o(55297);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(55301);
    finish();
    AppMethodBeat.o(55301);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(55300);
    this.oQJ.a(new TestVideoEditUI.2(this));
    AppMethodBeat.o(55300);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(55299);
    super.onSwipeBack();
    AppMethodBeat.o(55299);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI
 * JD-Core Version:    0.7.0.1
 */