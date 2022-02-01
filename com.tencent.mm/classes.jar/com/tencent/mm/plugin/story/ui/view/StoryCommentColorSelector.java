package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private final int LVJ;
  private final Drawable LVK;
  private final ImageView LVL;
  private final ImageView LVM;
  private final ImageView LVN;
  private final LinearLayout LVO;
  private final TextView LVP;
  private kotlin.g.a.b<? super Integer, x> LVQ;
  private final int strokeWidth;
  private int vag;
  
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
    this.vag = -1;
    View.inflate(paramContext, a.e.LCJ, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(a.d.LAB);
    p.j(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.LVL = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAx);
    p.j(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.LVM = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAz);
    p.j(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.LVN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAy);
    p.j(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.LVO = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LAA);
    p.j(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.LVP = ((TextView)paramAttributeSet);
    this.LVL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120096);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.LVR.setSelectedColor(-1);
        StoryCommentColorSelector.a(this.LVR);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120096);
      }
    });
    this.LVM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120097);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.LVR.setSelectedColor(-16777216);
        StoryCommentColorSelector.a(this.LVR);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120097);
      }
    });
    this.LVO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120098);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.LVR.setSelectedColor(StoryCommentColorSelector.ggw());
        StoryCommentColorSelector.a(this.LVR);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120098);
      }
    });
    this.strokeWidth = com.tencent.mm.ci.a.fromDPToPix(paramContext, 2);
    this.LVJ = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    p.k(paramContext, "origin");
    this.LVK = ((Drawable)new InsetDrawable(paramContext, this.LVJ));
    ggv();
    AppMethodBeat.o(120101);
  }
  
  private final void ggv()
  {
    AppMethodBeat.i(120099);
    Object localObject;
    switch (this.vag)
    {
    default: 
      this.LVL.setSelected(false);
      this.LVM.setSelected(false);
      localObject = this.LVN;
      int i = this.vag;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(this.strokeWidth, -1);
      localGradientDrawable.setShape(1);
      ((ImageView)localObject).setImageDrawable((Drawable)localGradientDrawable);
      this.LVP.setVisibility(0);
    }
    for (;;)
    {
      localObject = this.LVQ;
      if (localObject == null) {
        break;
      }
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(this.vag));
      AppMethodBeat.o(120099);
      return;
      this.LVL.setSelected(true);
      this.LVM.setSelected(false);
      this.LVN.setImageDrawable(this.LVK);
      this.LVP.setVisibility(8);
      continue;
      this.LVL.setSelected(false);
      this.LVM.setSelected(true);
      this.LVN.setImageDrawable(this.LVK);
      this.LVP.setVisibility(8);
    }
    AppMethodBeat.o(120099);
  }
  
  public static int ggw()
  {
    AppMethodBeat.i(120100);
    Object localObject = new Random();
    StoryCommentView.a locala = StoryCommentView.LWH;
    int i = ((Random)localObject).nextInt(StoryCommentView.ggy().length);
    localObject = StoryCommentView.LWH;
    i = StoryCommentView.ggy()[i];
    AppMethodBeat.o(120100);
    return i;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnColorSelected()
  {
    return this.LVQ;
  }
  
  public final int getSelectedColor()
  {
    return this.vag;
  }
  
  public final void setOnColorSelected(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.LVQ = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.vag = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */