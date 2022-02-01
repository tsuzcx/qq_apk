package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class TestVideoEditUI
  extends MMActivity
  implements j
{
  private ab zDV;
  
  public int getLayoutId()
  {
    return 2131496673;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(94749);
    if (!this.zDV.Ul()) {
      finish();
    }
    AppMethodBeat.o(94749);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94747);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    paramBundle = (FrameLayout)findViewById(2131299180);
    this.zDV = ab.diQ.Uo();
    Object localObject = this.zDV;
    ab.a.a locala = new ab.a.a();
    locala.diS = false;
    locala.diW = true;
    locala.diX = new Rect(0, 0, 1080, 1080);
    locala.diR = ab.c.diY;
    ((ab)localObject).a(locala.VJ());
    localObject = this.zDV.bB(getContext());
    ((e)localObject).setActionBarCallback(this);
    paramBundle.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    ((e)localObject).setSelectedFeatureListener(new z()
    {
      public final void a(h paramAnonymoush)
      {
        AppMethodBeat.i(94743);
        Log.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymoush.name() });
        AppMethodBeat.o(94743);
      }
      
      public final void a(h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(169420);
        Log.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush.name(), Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(169420);
      }
      
      public final void cH(boolean paramAnonymousBoolean)
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
    this.zDV.onDestroy();
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
    this.zDV.a(new TestVideoEditUI.2(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI
 * JD-Core Version:    0.7.0.1
 */