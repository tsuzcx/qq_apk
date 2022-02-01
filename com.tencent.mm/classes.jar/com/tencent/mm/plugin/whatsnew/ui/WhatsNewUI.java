package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "hasGoThroughOnCreated", "", "whatsNewView", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "enterFullScreen", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "Companion", "app_release"})
public final class WhatsNewUI
  extends MMActivity
{
  public static final WhatsNewUI.a JPh;
  private WhatsNewView JPf;
  private boolean JPg;
  
  static
  {
    AppMethodBeat.i(230986);
    JPh = new WhatsNewUI.a((byte)0);
    AppMethodBeat.o(230986);
  }
  
  private final void KD()
  {
    AppMethodBeat.i(230981);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(5894);
    AppMethodBeat.o(230981);
  }
  
  public final int getLayoutId()
  {
    return 2131497096;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230980);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131310488);
    p.g(paramBundle, "findViewById(R.id.whats_new)");
    this.JPf = ((WhatsNewView)paramBundle);
    KD();
    this.JPg = true;
    paramBundle = this.JPf;
    if (paramBundle == null) {
      p.btv("whatsNewView");
    }
    paramBundle.setOnFinish((kotlin.g.a.a)new b(this));
    if (getIntent().getBooleanExtra("from_about", false))
    {
      paramBundle = this.JPf;
      if (paramBundle == null) {
        p.btv("whatsNewView");
      }
      paramBundle.oeO.setAlpha(0.0F);
      paramBundle.JPl.setAlpha(0.0F);
      paramBundle.oeO.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new WhatsNewView.i(paramBundle)).start();
    }
    AppMethodBeat.o(230980);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(230985);
    super.onDestroy();
    WhatsNewView localWhatsNewView = this.JPf;
    if (localWhatsNewView == null) {
      p.btv("whatsNewView");
    }
    localWhatsNewView.onDestroy();
    AppMethodBeat.o(230985);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(230983);
    super.onStart();
    WhatsNewView localWhatsNewView = this.JPf;
    if (localWhatsNewView == null) {
      p.btv("whatsNewView");
    }
    localWhatsNewView.onStart();
    AppMethodBeat.o(230983);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(230984);
    super.onStop();
    WhatsNewView localWhatsNewView = this.JPf;
    if (localWhatsNewView == null) {
      p.btv("whatsNewView");
    }
    localWhatsNewView.onStop();
    AppMethodBeat.o(230984);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(230982);
    AppMethodBeat.at(this, paramBoolean);
    Log.d("MicroMsg.WhatsNewUI", "hasFocus: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (this.JPg)) {
      KD();
    }
    AppMethodBeat.o(230982);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(WhatsNewUI paramWhatsNewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewUI
 * JD-Core Version:    0.7.0.1
 */