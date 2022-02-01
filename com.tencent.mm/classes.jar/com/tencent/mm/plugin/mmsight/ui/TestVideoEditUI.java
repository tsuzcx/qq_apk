package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.f;
import com.tencent.mm.api.i;
import com.tencent.mm.api.k;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class TestVideoEditUI
  extends MMActivity
  implements k
{
  private ac Les;
  
  public int getLayoutId()
  {
    return a.f.test_video_edit_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94749);
    if (!this.Les.aAx()) {
      finish();
    }
    AppMethodBeat.o(94749);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94747);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    paramBundle = (FrameLayout)findViewById(a.e.content);
    this.Les = ac.hdY.aAA();
    this.Les.a(new ac.a.a().dR(false).dQ(true).t(new Rect(0, 0, 1080, 1080)).a(ac.c.hef).hee);
    f localf = this.Les.cn(getContext());
    localf.setActionBarCallback(this);
    paramBundle.addView(localf, new FrameLayout.LayoutParams(-1, -1));
    localf.setSelectedFeatureListener(new aa()
    {
      public final void a(i paramAnonymousi)
      {
        AppMethodBeat.i(94743);
        Log.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousi.name() });
        AppMethodBeat.o(94743);
      }
      
      public final void a(i paramAnonymousi, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169420);
        Log.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousi.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169420);
      }
      
      public final void dP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94745);
        if (paramAnonymousBoolean)
        {
          TestVideoEditUI.this.showVKB();
          AppMethodBeat.o(94745);
          return;
        }
        TestVideoEditUI.this.hideVKB(TestVideoEditUI.a(TestVideoEditUI.this));
        AppMethodBeat.o(94745);
      }
    });
    AppMethodBeat.o(94747);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94748);
    super.onDestroy();
    this.Les.onDestroy();
    AppMethodBeat.o(94748);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(94752);
    finish();
    AppMethodBeat.o(94752);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(94751);
    this.Les.a(new TestVideoEditUI.2(this));
    AppMethodBeat.o(94751);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(94750);
    super.onSwipeBack();
    AppMethodBeat.o(94750);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI
 * JD-Core Version:    0.7.0.1
 */