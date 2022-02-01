package com.tencent.mm.plugin.recordvideo.ui.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/common/VideoEditCommonDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "Landroid/view/View;", "setTranslucentStatus", "wrapSheet", "plugin-recordvideo_release"})
public final class a
  extends e
{
  private Context mContext;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(199417);
    this.mContext = paramContext;
    gt();
    AppMethodBeat.o(199417);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199415);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(199415);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(199416);
    k.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      k.fOy();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820790);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    super.setContentView(paramView);
    paramView = getWindow();
    if (paramView != null) {
      paramView.setLayout(-1, -2);
    }
    if (getWindow() != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label174;
      }
      paramView = getWindow();
      k.g(paramView, "window");
      paramView = paramView.getDecorView();
      k.g(paramView, "window.decorView");
      paramView.setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      paramView = getWindow();
      k.g(paramView, "window");
      paramView.setStatusBarColor(0);
    }
    for (;;)
    {
      getWindow().setFlags(134217728, 134217728);
      AppMethodBeat.o(199416);
      return;
      label174:
      getWindow().addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.b.a
 * JD-Core Version:    0.7.0.1
 */