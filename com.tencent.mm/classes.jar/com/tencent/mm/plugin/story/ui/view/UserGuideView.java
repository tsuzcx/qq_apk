package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initNewGuide", "initOldGuide", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UserGuideView
  extends RelativeLayout
{
  private kotlin.g.a.a<ah> SzO;
  
  public UserGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120312);
    AppMethodBeat.o(120312);
  }
  
  public UserGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120311);
    if (e.Sjb.huS())
    {
      View.inflate(getContext(), a.e.Shd, (ViewGroup)this);
      setOnClickListener(UserGuideView..ExternalSyntheticLambda3.INSTANCE);
      paramContext = findViewById(a.d.Sgc).getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120311);
        throw paramContext;
      }
      ((ViewGroup.MarginLayoutParams)paramContext).bottomMargin = (bd.fromDPToPix(getContext(), 64) + bf.bk(getContext()));
      findViewById(a.d.Sgc).setOnClickListener(new UserGuideView..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(120311);
      return;
    }
    View.inflate(getContext(), a.e.Shc, (ViewGroup)this);
    setBackgroundColor(-13421773);
    paramContext = findViewById(a.d.Sge);
    s.s(paramContext, "findViewById(R.id.story_user_guide_content_2)");
    paramContext = (TextView)paramContext;
    paramAttributeSet = getContext().getString(a.g.Sge);
    s.s(paramAttributeSet, "context.getString(R.stri…ory_user_guide_content_2)");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramAttributeSet);
    Drawable localDrawable = getResources().getDrawable(a.f.chatting_avatar_story_hint);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 10);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable, 1), paramAttributeSet.length() - 3, paramAttributeSet.length() - 2, 17);
    paramContext.setText((CharSequence)localSpannableString);
    setOnClickListener(UserGuideView..ExternalSyntheticLambda2.INSTANCE);
    findViewById(a.d.Sgd).setOnClickListener(new UserGuideView..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(120311);
  }
  
  private static final void a(UserGuideView paramUserGuideView, View paramView)
  {
    AppMethodBeat.i(367521);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramUserGuideView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramUserGuideView, "this$0");
    paramUserGuideView = paramUserGuideView.getClickListener();
    if (paramUserGuideView != null) {
      paramUserGuideView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367521);
  }
  
  private static final void b(UserGuideView paramUserGuideView, View paramView)
  {
    AppMethodBeat.i(367530);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramUserGuideView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramUserGuideView, "this$0");
    paramUserGuideView = paramUserGuideView.getClickListener();
    if (paramUserGuideView != null) {
      paramUserGuideView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367530);
  }
  
  private static final void ki(View paramView)
  {
    AppMethodBeat.i(367517);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367517);
  }
  
  private static final void kj(View paramView)
  {
    AppMethodBeat.i(367525);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/UserGuideView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367525);
  }
  
  public final kotlin.g.a.a<ah> getClickListener()
  {
    return this.SzO;
  }
  
  public final void setClickListener(kotlin.g.a.a<ah> parama)
  {
    this.SzO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.UserGuideView
 * JD-Core Version:    0.7.0.1
 */