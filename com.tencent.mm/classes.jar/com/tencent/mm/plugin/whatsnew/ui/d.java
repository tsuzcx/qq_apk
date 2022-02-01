package com.tencent.mm.plugin.whatsnew.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "view", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "enterFullScreen", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "", "app_release"})
public final class d
  extends Dialog
{
  private final WhatsNewView JPc;
  
  public d(Context paramContext)
  {
    super(paramContext, 16973841);
    AppMethodBeat.i(230975);
    this.JPc = new WhatsNewView(paramContext, null, 6, (byte)0);
    AppMethodBeat.o(230975);
  }
  
  private final void KD()
  {
    AppMethodBeat.i(230972);
    Window localWindow = getWindow();
    if (localWindow == null)
    {
      AppMethodBeat.o(230972);
      return;
    }
    p.g(localWindow, "window ?: return");
    Object localObject = localWindow.getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(3846);
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = localWindow.getAttributes();
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes((WindowManager.LayoutParams)localObject);
    }
    AppMethodBeat.o(230972);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230970);
    super.onCreate(paramBundle);
    this.JPc.setOnFinish((a)new d.a(this));
    setContentView((View)this.JPc);
    KD();
    setOnDismissListener((DialogInterface.OnDismissListener)new b(this));
    setCancelable(false);
    AppMethodBeat.o(230970);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(230973);
    super.onStart();
    this.JPc.onStart();
    AppMethodBeat.o(230973);
  }
  
  protected final void onStop()
  {
    AppMethodBeat.i(230974);
    super.onStop();
    this.JPc.onStop();
    AppMethodBeat.o(230974);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(230971);
    if (paramBoolean) {
      KD();
    }
    AppMethodBeat.o(230971);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(d paramd) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(230969);
      d.a(this.JPd).onDestroy();
      AppMethodBeat.o(230969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.d
 * JD-Core Version:    0.7.0.1
 */