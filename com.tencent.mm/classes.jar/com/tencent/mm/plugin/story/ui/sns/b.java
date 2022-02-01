package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.h;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onOkBtnClick", "Lkotlin/Function0;", "", "getOnOkBtnClick", "()Lkotlin/jvm/functions/Function0;", "setOnOkBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "targetView", "Landroid/view/View;", "cancel", "isLandscape", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final b.a Swc;
  private static final String TAG;
  public kotlin.g.a.a<ah> Swd;
  private Context mContext;
  private View nmf;
  
  static
  {
    AppMethodBeat.i(119949);
    Swc = new b.a((byte)0);
    TAG = "MicroMsg.StoryBigMouthGuideDialog";
    AppMethodBeat.o(119949);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, a.h.CustomSheetStyle);
    AppMethodBeat.i(119948);
    this.mContext = paramContext;
    bU();
    AppMethodBeat.o(119948);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(367400);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (paramb.isShowing()) {
      paramb.cancel();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367400);
  }
  
  private static final void b(RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(367396);
    paramRelativeLayout = paramRelativeLayout.animate();
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout = paramRelativeLayout.translationY(0.0F);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.start();
      }
    }
    AppMethodBeat.o(367396);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(367407);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.Swd;
    if (paramb != null) {
      paramb.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367407);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(119947);
    if ((this.nmf instanceof a))
    {
      Object localObject = this.nmf;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
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
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.0F);
    }
    AppMethodBeat.o(119944);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(119945);
    super.onStart();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(a.d.Sef);
    if (localRelativeLayout != null) {
      localRelativeLayout.post(new b..ExternalSyntheticLambda2(localRelativeLayout));
    }
    AppMethodBeat.o(119945);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(119946);
    s.u(paramView, "view");
    getWindow();
    paramView.findViewById(a.d.Seg).setOnClickListener(new b..ExternalSyntheticLambda1(this));
    paramView.findViewById(a.d.Seh).setOnClickListener(new b..ExternalSyntheticLambda0(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(a.d.Sef);
    if (localRelativeLayout != null) {
      localRelativeLayout.setTranslationY(bf.bf(getContext()).y);
    }
    super.setContentView(paramView);
    this.nmf = paramView;
    paramView = getWindow();
    s.checkNotNull(paramView);
    paramView.setLayout(-1, -1);
    if (getWindow() != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label196;
      }
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.getDecorView().setSystemUiVisibility(1280);
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.addFlags(-2147483648);
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setStatusBarColor(0);
    }
    for (;;)
    {
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119946);
      return;
      label196:
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b
 * JD-Core Version:    0.7.0.1
 */