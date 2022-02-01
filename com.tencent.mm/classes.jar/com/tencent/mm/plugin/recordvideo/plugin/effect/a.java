package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "setTranslucentStatus", "wrapSheet", "plugin-recordvideo_release"})
public final class a
  extends e
{
  private Context mContext;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(204143);
    this.mContext = paramContext;
    gl();
    AppMethodBeat.o(204143);
  }
  
  private final void fYj()
  {
    AppMethodBeat.i(204141);
    if (getWindow() == null)
    {
      AppMethodBeat.o(204141);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = getWindow();
      k.g(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      k.g(localObject, "window.decorView");
      ((View)localObject).setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      localObject = getWindow();
      k.g(localObject, "window");
      ((Window)localObject).setStatusBarColor(0);
    }
    for (;;)
    {
      getWindow().setFlags(134217728, 134217728);
      AppMethodBeat.o(204141);
      return;
      getWindow().addFlags(67108864);
    }
  }
  
  private final View gS(View paramView)
  {
    AppMethodBeat.i(204142);
    Window localWindow = getWindow();
    if (localWindow == null) {
      k.fvU();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820790);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    AppMethodBeat.o(204142);
    return paramView;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204138);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(204138);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(204139);
    k.h(paramView, "view");
    super.setContentView(gS(paramView));
    paramView = getWindow();
    if (paramView != null) {
      paramView.setLayout(-1, -2);
    }
    fYj();
    AppMethodBeat.o(204139);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(204140);
    k.h(paramView, "view");
    gS(paramView);
    super.setContentView(paramView, paramLayoutParams);
    paramView = getWindow();
    if (paramView != null) {
      paramView.setLayout(-1, -2);
    }
    fYj();
    AppMethodBeat.o(204140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.a
 * JD-Core Version:    0.7.0.1
 */