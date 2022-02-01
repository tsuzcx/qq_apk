package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onOkBtnClick", "Lkotlin/Function0;", "", "getOnOkBtnClick", "()Lkotlin/jvm/functions/Function0;", "setOnOkBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "targetView", "Landroid/view/View;", "cancel", "isLandscape", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b
  extends e
{
  public static final a FzQ;
  private static final String TAG = "MicroMsg.StoryBigMouthGuideDialog";
  public kotlin.g.a.a<x> FzP;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(119949);
    FzQ = new a((byte)0);
    TAG = "MicroMsg.StoryBigMouthGuideDialog";
    AppMethodBeat.o(119949);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, 2131820868);
    AppMethodBeat.i(119948);
    this.mContext = paramContext;
    gR();
    AppMethodBeat.o(119948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(119947);
    if ((this.targetView instanceof a))
    {
      Object localObject = this.targetView;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
        AppMethodBeat.o(119947);
        throw ((Throwable)localObject);
      }
      ((a)localObject).finish();
    }
    super.cancel();
    AppMethodBeat.o(119947);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119944);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setDimAmount(0.0F);
      AppMethodBeat.o(119944);
      return;
    }
    AppMethodBeat.o(119944);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(119945);
    super.onStart();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131308475);
    if (localRelativeLayout != null)
    {
      localRelativeLayout.post((Runnable)new b(localRelativeLayout));
      AppMethodBeat.o(119945);
      return;
    }
    AppMethodBeat.o(119945);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(119946);
    p.h(paramView, "view");
    getWindow();
    paramView.findViewById(2131308476).setOnClickListener((View.OnClickListener)new c(this));
    paramView.findViewById(2131308478).setOnClickListener((View.OnClickListener)new d(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131308475);
    if (localRelativeLayout != null) {
      localRelativeLayout.setTranslationY(au.az(getContext()).y);
    }
    super.setContentView(paramView);
    this.targetView = paramView;
    paramView = getWindow();
    if (paramView == null) {
      p.hyc();
    }
    paramView.setLayout(-1, -1);
    if (getWindow() != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label231;
      }
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      p.g(paramView, "window!!");
      paramView = paramView.getDecorView();
      p.g(paramView, "window!!.decorView");
      paramView.setSystemUiVisibility(1280);
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.addFlags(-2147483648);
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      p.g(paramView, "window!!");
      paramView.setStatusBarColor(0);
    }
    for (;;)
    {
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119946);
      return;
      label231:
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.addFlags(67108864);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RelativeLayout paramRelativeLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(119941);
      ViewPropertyAnimator localViewPropertyAnimator = this.FzR.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.translationY(0.0F);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator.start();
          AppMethodBeat.o(119941);
          return;
        }
      }
      AppMethodBeat.o(119941);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119942);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.FzS.isShowing()) {
        this.FzS.cancel();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119942);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119943);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FzS.FzP;
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b
 * JD-Core Version:    0.7.0.1
 */