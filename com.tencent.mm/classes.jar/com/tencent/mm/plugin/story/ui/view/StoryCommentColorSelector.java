package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private final int SxC;
  private final Drawable SxD;
  private final ImageView SxE;
  private final ImageView SxF;
  private final ImageView SxG;
  private final LinearLayout SxH;
  private final TextView SxI;
  private kotlin.g.a.b<? super Integer, ah> SxJ;
  private final int strokeWidth;
  private int ymh;
  
  public StoryCommentColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120102);
    AppMethodBeat.o(120102);
  }
  
  public StoryCommentColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120101);
    this.ymh = -1;
    View.inflate(paramContext, a.e.Sgu, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(a.d.Seo);
    s.s(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.SxE = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sek);
    s.s(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.SxF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sem);
    s.s(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.SxG = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sel);
    s.s(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.SxH = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sen);
    s.s(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.SxI = ((TextView)paramAttributeSet);
    this.SxE.setOnClickListener(new StoryCommentColorSelector..ExternalSyntheticLambda2(this));
    this.SxF.setOnClickListener(new StoryCommentColorSelector..ExternalSyntheticLambda0(this));
    this.SxH.setOnClickListener(new StoryCommentColorSelector..ExternalSyntheticLambda1(this));
    this.strokeWidth = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
    this.SxC = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    s.u(paramContext, "origin");
    this.SxD = ((Drawable)new InsetDrawable(paramContext, this.SxC));
    hzO();
    AppMethodBeat.o(120101);
  }
  
  private static final void a(StoryCommentColorSelector paramStoryCommentColorSelector, View paramView)
  {
    AppMethodBeat.i(367574);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryCommentColorSelector);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryCommentColorSelector, "this$0");
    paramStoryCommentColorSelector.setSelectedColor(-1);
    paramStoryCommentColorSelector.hzO();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367574);
  }
  
  private GradientDrawable anz(int paramInt)
  {
    AppMethodBeat.i(367569);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setStroke(this.strokeWidth, -1);
    localGradientDrawable.setShape(1);
    AppMethodBeat.o(367569);
    return localGradientDrawable;
  }
  
  private static final void b(StoryCommentColorSelector paramStoryCommentColorSelector, View paramView)
  {
    AppMethodBeat.i(367578);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryCommentColorSelector);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryCommentColorSelector, "this$0");
    paramStoryCommentColorSelector.setSelectedColor(-16777216);
    paramStoryCommentColorSelector.hzO();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367578);
  }
  
  private static final void c(StoryCommentColorSelector paramStoryCommentColorSelector, View paramView)
  {
    AppMethodBeat.i(367581);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryCommentColorSelector);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryCommentColorSelector, "this$0");
    paramView = new Random();
    localObject = StoryCommentView.SxY;
    int i = paramView.nextInt(StoryCommentView.hzT().length);
    paramView = StoryCommentView.SxY;
    paramStoryCommentColorSelector.setSelectedColor(StoryCommentView.hzT()[i]);
    paramStoryCommentColorSelector.hzO();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367581);
  }
  
  private final void hzO()
  {
    AppMethodBeat.i(120099);
    switch (this.ymh)
    {
    default: 
      this.SxE.setSelected(false);
      this.SxF.setSelected(false);
      this.SxG.setImageDrawable((Drawable)anz(this.ymh));
      this.SxI.setVisibility(0);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.SxJ;
      if (localb != null) {
        localb.invoke(Integer.valueOf(this.ymh));
      }
      AppMethodBeat.o(120099);
      return;
      this.SxE.setSelected(true);
      this.SxF.setSelected(false);
      this.SxG.setImageDrawable(this.SxD);
      this.SxI.setVisibility(8);
      continue;
      this.SxE.setSelected(false);
      this.SxF.setSelected(true);
      this.SxG.setImageDrawable(this.SxD);
      this.SxI.setVisibility(8);
    }
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnColorSelected()
  {
    return this.SxJ;
  }
  
  public final int getSelectedColor()
  {
    return this.ymh;
  }
  
  public final void setOnColorSelected(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.SxJ = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.ymh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */