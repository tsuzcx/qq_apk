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
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private final int FBF;
  private final Drawable FBG;
  private final ImageView FBH;
  private final ImageView FBI;
  private final ImageView FBJ;
  private final LinearLayout FBK;
  private final TextView FBL;
  private kotlin.g.a.b<? super Integer, x> FBM;
  private int ruC;
  private final int strokeWidth;
  
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
    this.ruC = -1;
    View.inflate(paramContext, 2131496575, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(2131308498);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.FBH = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308494);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.FBI = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308496);
    p.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.FBJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308495);
    p.g(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.FBK = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131308497);
    p.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.FBL = ((TextView)paramAttributeSet);
    this.FBH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120096);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.FBN.setSelectedColor(-1);
        StoryCommentColorSelector.a(this.FBN);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120096);
      }
    });
    this.FBI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120097);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.FBN.setSelectedColor(-16777216);
        StoryCommentColorSelector.a(this.FBN);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120097);
      }
    });
    this.FBK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120098);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.FBN.setSelectedColor(StoryCommentColorSelector.frY());
        StoryCommentColorSelector.a(this.FBN);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120098);
      }
    });
    this.strokeWidth = com.tencent.mm.cb.a.fromDPToPix(paramContext, 2);
    this.FBF = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    p.h(paramContext, "origin");
    this.FBG = ((Drawable)new InsetDrawable(paramContext, this.FBF));
    frX();
    AppMethodBeat.o(120101);
  }
  
  private final void frX()
  {
    AppMethodBeat.i(120099);
    Object localObject;
    switch (this.ruC)
    {
    default: 
      this.FBH.setSelected(false);
      this.FBI.setSelected(false);
      localObject = this.FBJ;
      int i = this.ruC;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(this.strokeWidth, -1);
      localGradientDrawable.setShape(1);
      ((ImageView)localObject).setImageDrawable((Drawable)localGradientDrawable);
      this.FBL.setVisibility(0);
    }
    for (;;)
    {
      localObject = this.FBM;
      if (localObject == null) {
        break;
      }
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(this.ruC));
      AppMethodBeat.o(120099);
      return;
      this.FBH.setSelected(true);
      this.FBI.setSelected(false);
      this.FBJ.setImageDrawable(this.FBG);
      this.FBL.setVisibility(8);
      continue;
      this.FBH.setSelected(false);
      this.FBI.setSelected(true);
      this.FBJ.setImageDrawable(this.FBG);
      this.FBL.setVisibility(8);
    }
    AppMethodBeat.o(120099);
  }
  
  public static int frY()
  {
    AppMethodBeat.i(120100);
    Object localObject = new Random();
    StoryCommentView.a locala = StoryCommentView.FCD;
    int i = ((Random)localObject).nextInt(StoryCommentView.fsa().length);
    localObject = StoryCommentView.FCD;
    i = StoryCommentView.fsa()[i];
    AppMethodBeat.o(120100);
    return i;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnColorSelected()
  {
    return this.FBM;
  }
  
  public final int getSelectedColor()
  {
    return this.ruC;
  }
  
  public final void setOnColorSelected(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.FBM = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.ruC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */