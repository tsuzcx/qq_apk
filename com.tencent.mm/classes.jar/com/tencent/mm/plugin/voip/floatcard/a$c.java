package com.tencent.mm.plugin.voip.floatcard;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager$WindowManagerProxy;", "Landroid/view/ViewManager;", "windowManager", "Landroid/view/WindowManager;", "(Landroid/view/WindowManager;)V", "addView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "removeView", "updateViewLayout", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  implements ViewManager
{
  private final WindowManager windowManager;
  
  public a$c(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(292248);
    this.windowManager = paramWindowManager;
    AppMethodBeat.o(292248);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(292258);
    Log.i("VoipFloatCardManager", "addView() called with: view = " + paramView + ", params = " + paramLayoutParams);
    try
    {
      this.windowManager.addView(paramView, paramLayoutParams);
      AppMethodBeat.o(292258);
      return;
    }
    catch (Exception paramView)
    {
      Log.e("VoipFloatCardManager", "addView: ", new Object[] { paramView });
      AppMethodBeat.o(292258);
    }
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(292270);
    Log.i("VoipFloatCardManager", s.X("removeView() called with: view = ", paramView));
    try
    {
      this.windowManager.removeView(paramView);
      AppMethodBeat.o(292270);
      return;
    }
    catch (Exception paramView)
    {
      Log.e("VoipFloatCardManager", "updateViewLayout: ", new Object[] { paramView });
      AppMethodBeat.o(292270);
    }
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(292266);
    Log.i("VoipFloatCardManager", "updateViewLayout() called with: view = " + paramView + ", params = " + paramLayoutParams);
    try
    {
      this.windowManager.updateViewLayout(paramView, paramLayoutParams);
      AppMethodBeat.o(292266);
      return;
    }
    catch (Exception paramView)
    {
      Log.e("VoipFloatCardManager", "updateViewLayout: ", new Object[] { paramView });
      AppMethodBeat.o(292266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.a.c
 * JD-Core Version:    0.7.0.1
 */