package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initNewGuide", "initOldGuide", "plugin-story_release"})
public final class UserGuideView
  extends RelativeLayout
{
  private kotlin.g.a.a<x> LYk;
  
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
    if (e.LFp.gbz())
    {
      View.inflate(getContext(), a.e.LDs, (ViewGroup)this);
      setOnClickListener((View.OnClickListener)a.LYl);
      paramContext = findViewById(a.d.LCr);
      p.j(paramContext, "findViewById<View>(R.id.story_user_guide_btn)");
      paramContext = paramContext.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120311);
        throw paramContext;
      }
      ((ViewGroup.MarginLayoutParams)paramContext).bottomMargin = (aw.fromDPToPix(getContext(), 64) + ax.aB(getContext()));
      findViewById(a.d.LCr).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(120311);
      return;
    }
    View.inflate(getContext(), a.e.LDr, (ViewGroup)this);
    setBackgroundColor(-13421773);
    paramContext = findViewById(a.d.LCt);
    p.j(paramContext, "findViewById(R.id.story_user_guide_content_2)");
    paramContext = (TextView)paramContext;
    paramAttributeSet = getContext().getString(a.g.LCt);
    p.j(paramAttributeSet, "context.getString(R.stri…ory_user_guide_content_2)");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramAttributeSet);
    Drawable localDrawable = getResources().getDrawable(a.f.chatting_avatar_story_hint);
    paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), 10);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable, 1), paramAttributeSet.length() - 3, paramAttributeSet.length() - 2, 17);
    paramContext.setText((CharSequence)localSpannableString);
    setOnClickListener((View.OnClickListener)c.LYn);
    findViewById(a.d.LCs).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(120311);
  }
  
  public final kotlin.g.a.a<x> getClickListener()
  {
    return this.LYk;
  }
  
  public final void setClickListener(kotlin.g.a.a<x> parama)
  {
    this.LYk = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a LYl;
    
    static
    {
      AppMethodBeat.i(120306);
      LYl = new a();
      AppMethodBeat.o(120306);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120305);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120305);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120307);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYm.getClickListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120307);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c LYn;
    
    static
    {
      AppMethodBeat.i(120309);
      LYn = new c();
      AppMethodBeat.o(120309);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120308);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120308);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120310);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.LYm.getClickListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.UserGuideView
 * JD-Core Version:    0.7.0.1
 */