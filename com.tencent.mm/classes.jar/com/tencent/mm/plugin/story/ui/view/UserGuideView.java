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
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initNewGuide", "initOldGuide", "plugin-story_release"})
public final class UserGuideView
  extends RelativeLayout
{
  private kotlin.g.a.a<x> FEi;
  
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
    if (e.Fln.fng())
    {
      View.inflate(getContext(), 2131496627, (ViewGroup)this);
      setOnClickListener((View.OnClickListener)a.FEj);
      paramContext = findViewById(2131308702);
      p.g(paramContext, "findViewById<View>(R.id.story_user_guide_btn)");
      paramContext = paramContext.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120311);
        throw paramContext;
      }
      ((ViewGroup.MarginLayoutParams)paramContext).bottomMargin = (at.fromDPToPix(getContext(), 64) + au.aD(getContext()));
      findViewById(2131308702).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(120311);
      return;
    }
    View.inflate(getContext(), 2131496626, (ViewGroup)this);
    setBackgroundColor(-13421773);
    paramContext = findViewById(2131308704);
    p.g(paramContext, "findViewById(R.id.story_user_guide_content_2)");
    paramContext = (TextView)paramContext;
    paramAttributeSet = getContext().getString(2131766568);
    p.g(paramAttributeSet, "context.getString(R.stri…ory_user_guide_content_2)");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramAttributeSet);
    Drawable localDrawable = getResources().getDrawable(2131689912);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 10);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable), paramAttributeSet.length() - 3, paramAttributeSet.length() - 2, 17);
    paramContext.setText((CharSequence)localSpannableString);
    setOnClickListener((View.OnClickListener)c.FEl);
    findViewById(2131308703).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(120311);
  }
  
  public final kotlin.g.a.a<x> getClickListener()
  {
    return this.FEi;
  }
  
  public final void setClickListener(kotlin.g.a.a<x> parama)
  {
    this.FEi = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a FEj;
    
    static
    {
      AppMethodBeat.i(120306);
      FEj = new a();
      AppMethodBeat.o(120306);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120305);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120305);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120307);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEk.getClickListener();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initNewGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120307);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c FEl;
    
    static
    {
      AppMethodBeat.i(120309);
      FEl = new c();
      AppMethodBeat.o(120309);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120308);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(120308);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120310);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/UserGuideView$initOldGuide$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FEk.getClickListener();
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