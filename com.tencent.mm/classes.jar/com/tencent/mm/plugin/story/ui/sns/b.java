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
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onOkBtnClick", "Lkotlin/Function0;", "", "getOnOkBtnClick", "()Lkotlin/jvm/functions/Function0;", "setOnOkBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "targetView", "Landroid/view/View;", "cancel", "isLandscape", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b
  extends e
{
  private static final String TAG = "MicroMsg.StoryBigMouthGuideDialog";
  public static final a zGf;
  private Context mContext;
  private View targetView;
  public d.g.a.a<y> zGe;
  
  static
  {
    AppMethodBeat.i(119949);
    zGf = new a((byte)0);
    TAG = "MicroMsg.StoryBigMouthGuideDialog";
    AppMethodBeat.o(119949);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(119948);
    this.mContext = paramContext;
    gt();
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
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
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
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(119944);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(119945);
    super.onStart();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131305270);
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
    k.h(paramView, "view");
    getWindow();
    paramView.findViewById(2131305271).setOnClickListener((View.OnClickListener)new c(this));
    paramView.findViewById(2131305273).setOnClickListener((View.OnClickListener)new d(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131305270);
    if (localRelativeLayout != null) {
      localRelativeLayout.setTranslationY(ap.cl(getContext()).y);
    }
    super.setContentView(paramView);
    this.targetView = paramView;
    paramView = getWindow();
    if (paramView == null) {
      k.fOy();
    }
    paramView.setLayout(-1, -1);
    if (getWindow() != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label199;
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
      AppMethodBeat.o(119946);
      return;
      label199:
      getWindow().addFlags(67108864);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RelativeLayout paramRelativeLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(119941);
      ViewPropertyAnimator localViewPropertyAnimator = this.zGg.animate();
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119942);
      if (this.zGh.isShowing()) {
        this.zGh.cancel();
      }
      AppMethodBeat.o(119942);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119943);
      paramView = this.zGh.zGe;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(119943);
        return;
      }
      AppMethodBeat.o(119943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b
 * JD-Core Version:    0.7.0.1
 */