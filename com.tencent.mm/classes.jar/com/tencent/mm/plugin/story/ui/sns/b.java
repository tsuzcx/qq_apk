package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.h;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onOkBtnClick", "Lkotlin/Function0;", "", "getOnOkBtnClick", "()Lkotlin/jvm/functions/Function0;", "setOnOkBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "targetView", "Landroid/view/View;", "cancel", "isLandscape", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b
  extends e
{
  public static final a LTV;
  private static final String TAG = "MicroMsg.StoryBigMouthGuideDialog";
  public kotlin.g.a.a<x> LTU;
  private View kJL;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(119949);
    LTV = new a((byte)0);
    TAG = "MicroMsg.StoryBigMouthGuideDialog";
    AppMethodBeat.o(119949);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, a.h.CustomSheetStyle);
    AppMethodBeat.i(119948);
    this.mContext = paramContext;
    bb();
    AppMethodBeat.o(119948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(119947);
    if ((this.kJL instanceof a))
    {
      Object localObject = this.kJL;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(a.d.LAs);
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
    p.k(paramView, "view");
    getWindow();
    paramView.findViewById(a.d.LAt).setOnClickListener((View.OnClickListener)new b.c(this));
    paramView.findViewById(a.d.LAu).setOnClickListener((View.OnClickListener)new b.d(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(a.d.LAs);
    if (localRelativeLayout != null) {
      localRelativeLayout.setTranslationY(ax.au(getContext()).y);
    }
    super.setContentView(paramView);
    this.kJL = paramView;
    paramView = getWindow();
    if (paramView == null) {
      p.iCn();
    }
    paramView.setLayout(-1, -1);
    if (getWindow() != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label234;
      }
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      p.j(paramView, "window!!");
      paramView = paramView.getDecorView();
      p.j(paramView, "window!!.decorView");
      paramView.setSystemUiVisibility(1280);
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.addFlags(-2147483648);
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      p.j(paramView, "window!!");
      paramView.setStatusBarColor(0);
    }
    for (;;)
    {
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119946);
      return;
      label234:
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.addFlags(67108864);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(RelativeLayout paramRelativeLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(119941);
      ViewPropertyAnimator localViewPropertyAnimator = this.LTW.animate();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b
 * JD-Core Version:    0.7.0.1
 */