package com.tencent.skyline.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.skyline.SkylineLogic;
import io.flutter.embedding.android.FlutterView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/flutter/FlutterLogicUI;", "Landroid/app/Activity;", "()V", "flutterView", "Lio/flutter/embedding/android/FlutterView;", "createContentView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "Companion", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public class FlutterLogicUI
  extends HellActivity
{
  public static final FlutterLogicUI.Companion Companion;
  private static final String TAG = "FlutterBaseUI";
  private FlutterView flutterView;
  
  static
  {
    AppMethodBeat.i(210691);
    Companion = new FlutterLogicUI.Companion(null);
    AppMethodBeat.o(210691);
  }
  
  private final View createContentView()
  {
    AppMethodBeat.i(210685);
    Object localObject1 = new LinearLayout((Context)this);
    ((LinearLayout)localObject1).setBackgroundColor(-16711936);
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject2 = getResources();
    s.r(localObject2, "resources");
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    s.r(localObject2, "resources.displayMetrics");
    FlutterLogicUI localFlutterLogicUI = (FlutterLogicUI)this;
    Object localObject3 = new ViewGroup.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels / 2);
    Object localObject4 = new FrameLayout((Context)localFlutterLogicUI);
    ((FrameLayout)localObject4).setBackgroundColor(-16777216);
    FlutterView localFlutterView = SkylineLogic.createFlutterView$default(SkylineLogic.INSTANCE, (Context)localFlutterLogicUI, 0, 0, 0, 14, null);
    SkylineLogic.INSTANCE.attachFlutterEngine(0, localFlutterView);
    localFlutterLogicUI.flutterView = localFlutterView;
    ((FrameLayout)localObject4).addView((View)localFlutterLogicUI.flutterView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    ((LinearLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
    localFlutterLogicUI = (FlutterLogicUI)this;
    localObject2 = new ViewGroup.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels / 2);
    localObject3 = new FrameLayout((Context)localFlutterLogicUI);
    ((FrameLayout)localObject3).setBackgroundColor(-16777216);
    localObject4 = SkylineLogic.createFlutterView$default(SkylineLogic.INSTANCE, (Context)localFlutterLogicUI, 0, 0, 0, 14, null);
    SkylineLogic.INSTANCE.attachFlutterEngine(1, (FlutterView)localObject4);
    localFlutterLogicUI.flutterView = ((FlutterView)localObject4);
    ((FrameLayout)localObject3).addView((View)localFlutterLogicUI.flutterView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    localObject1 = (View)localObject1;
    AppMethodBeat.o(210685);
    return localObject1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210696);
    super.onCreate(paramBundle);
    setContentView(createContentView());
    AppMethodBeat.o(210696);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(210725);
    super.onDestroy();
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null)
    {
      SkylineLogic.INSTANCE.detachFlutterView(localFlutterView);
      AppMethodBeat.o(210725);
      return;
    }
    AppMethodBeat.o(210725);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(210714);
    super.onPause();
    AppMethodBeat.o(210714);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(210708);
    super.onResume();
    AppMethodBeat.o(210708);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(210701);
    super.onStart();
    AppMethodBeat.o(210701);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(210720);
    super.onStop();
    AppMethodBeat.o(210720);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.skyline.flutter.FlutterLogicUI
 * JD-Core Version:    0.7.0.1
 */