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
import d.g.b.p;
import d.l;
import d.z;
import java.util.Random;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private final TextView AZA;
  private d.g.a.b<? super Integer, z> AZB;
  private final int AZu;
  private final Drawable AZv;
  private final ImageView AZw;
  private final ImageView AZx;
  private final ImageView AZy;
  private final LinearLayout AZz;
  private int pWZ;
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
    this.pWZ = -1;
    View.inflate(paramContext, 2131495670, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(2131305293);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.AZw = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305289);
    p.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.AZx = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305291);
    p.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.AZy = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305290);
    p.g(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.AZz = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305292);
    p.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.AZA = ((TextView)paramAttributeSet);
    this.AZw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120096);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.AZC.setSelectedColor(-1);
        StoryCommentColorSelector.a(this.AZC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120096);
      }
    });
    this.AZx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120097);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.AZC.setSelectedColor(-16777216);
        StoryCommentColorSelector.a(this.AZC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120097);
      }
    });
    this.AZz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120098);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.AZC.setSelectedColor(StoryCommentColorSelector.elQ());
        StoryCommentColorSelector.a(this.AZC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120098);
      }
    });
    this.strokeWidth = com.tencent.mm.cc.a.fromDPToPix(paramContext, 2);
    this.AZu = com.tencent.mm.cc.a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    p.h(paramContext, "origin");
    this.AZv = ((Drawable)new InsetDrawable(paramContext, this.AZu));
    elP();
    AppMethodBeat.o(120101);
  }
  
  private final void elP()
  {
    AppMethodBeat.i(120099);
    Object localObject;
    switch (this.pWZ)
    {
    default: 
      this.AZw.setSelected(false);
      this.AZx.setSelected(false);
      localObject = this.AZy;
      int i = this.pWZ;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(this.strokeWidth, -1);
      localGradientDrawable.setShape(1);
      ((ImageView)localObject).setImageDrawable((Drawable)localGradientDrawable);
      this.AZA.setVisibility(0);
    }
    for (;;)
    {
      localObject = this.AZB;
      if (localObject == null) {
        break;
      }
      ((d.g.a.b)localObject).invoke(Integer.valueOf(this.pWZ));
      AppMethodBeat.o(120099);
      return;
      this.AZw.setSelected(true);
      this.AZx.setSelected(false);
      this.AZy.setImageDrawable(this.AZv);
      this.AZA.setVisibility(8);
      continue;
      this.AZw.setSelected(false);
      this.AZx.setSelected(true);
      this.AZy.setImageDrawable(this.AZv);
      this.AZA.setVisibility(8);
    }
    AppMethodBeat.o(120099);
  }
  
  public static int elQ()
  {
    AppMethodBeat.i(120100);
    Object localObject = new Random();
    StoryCommentView.a locala = StoryCommentView.Bas;
    int i = ((Random)localObject).nextInt(StoryCommentView.elS().length);
    localObject = StoryCommentView.Bas;
    i = StoryCommentView.elS()[i];
    AppMethodBeat.o(120100);
    return i;
  }
  
  public final d.g.a.b<Integer, z> getOnColorSelected()
  {
    return this.AZB;
  }
  
  public final int getSelectedColor()
  {
    return this.pWZ;
  }
  
  public final void setOnColorSelected(d.g.a.b<? super Integer, z> paramb)
  {
    this.AZB = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.pWZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */