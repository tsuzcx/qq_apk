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
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initNewGuide", "initOldGuide", "plugin-story_release"})
public final class UserGuideView
  extends RelativeLayout
{
  private d.g.a.a<y> yxh;
  
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
    if (e.ydS.dGh())
    {
      View.inflate(getContext(), 2131495722, (ViewGroup)this);
      setOnClickListener((View.OnClickListener)UserGuideView.a.yxi);
      paramContext = findViewById(2131305495);
      k.g(paramContext, "findViewById<View>(R.id.story_user_guide_btn)");
      paramContext = paramContext.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(120311);
        throw paramContext;
      }
      ((ViewGroup.MarginLayoutParams)paramContext).bottomMargin = (ao.fromDPToPix(getContext(), 64) + ap.eb(getContext()));
      findViewById(2131305495).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(120311);
      return;
    }
    View.inflate(getContext(), 2131495721, (ViewGroup)this);
    setBackgroundColor(-13421773);
    paramContext = findViewById(2131305497);
    k.g(paramContext, "findViewById(R.id.story_user_guide_content_2)");
    paramContext = (TextView)paramContext;
    paramAttributeSet = getContext().getString(2131764310);
    SpannableString localSpannableString = new SpannableString((CharSequence)paramAttributeSet);
    Drawable localDrawable = getResources().getDrawable(2131689897);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), 10);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable), paramAttributeSet.length() - 3, paramAttributeSet.length() - 2, 17);
    paramContext.setText((CharSequence)localSpannableString);
    setOnClickListener((View.OnClickListener)UserGuideView.c.yxk);
    findViewById(2131305496).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(120311);
  }
  
  public final d.g.a.a<y> getClickListener()
  {
    return this.yxh;
  }
  
  public final void setClickListener(d.g.a.a<y> parama)
  {
    this.yxh = parama;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120307);
      paramView = this.yxj.getClickListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(120307);
        return;
      }
      AppMethodBeat.o(120307);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(UserGuideView paramUserGuideView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(120310);
      paramView = this.yxj.getClickListener();
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(120310);
        return;
      }
      AppMethodBeat.o(120310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.UserGuideView
 * JD-Core Version:    0.7.0.1
 */