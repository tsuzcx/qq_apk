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
import com.tencent.mm.cd.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Random;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private int oQi;
  private final int strokeWidth;
  private final int yuB;
  private final Drawable yuC;
  private final ImageView yuD;
  private final ImageView yuE;
  private final ImageView yuF;
  private final LinearLayout yuG;
  private final TextView yuH;
  private b<? super Integer, y> yuI;
  
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
    this.oQi = -1;
    View.inflate(paramContext, 2131495670, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(2131305293);
    k.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.yuD = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305289);
    k.g(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.yuE = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305291);
    k.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.yuF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305290);
    k.g(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.yuG = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305292);
    k.g(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.yuH = ((TextView)paramAttributeSet);
    this.yuD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120096);
        this.yuJ.setSelectedColor(-1);
        StoryCommentColorSelector.a(this.yuJ);
        AppMethodBeat.o(120096);
      }
    });
    this.yuE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120097);
        this.yuJ.setSelectedColor(-16777216);
        StoryCommentColorSelector.a(this.yuJ);
        AppMethodBeat.o(120097);
      }
    });
    this.yuG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120098);
        this.yuJ.setSelectedColor(StoryCommentColorSelector.dLb());
        StoryCommentColorSelector.a(this.yuJ);
        AppMethodBeat.o(120098);
      }
    });
    this.strokeWidth = a.fromDPToPix(paramContext, 2);
    this.yuB = a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    k.h(paramContext, "origin");
    this.yuC = ((Drawable)new InsetDrawable(paramContext, this.yuB));
    dLa();
    AppMethodBeat.o(120101);
  }
  
  private final void dLa()
  {
    AppMethodBeat.i(120099);
    Object localObject;
    switch (this.oQi)
    {
    default: 
      this.yuD.setSelected(false);
      this.yuE.setSelected(false);
      localObject = this.yuF;
      int i = this.oQi;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(this.strokeWidth, -1);
      localGradientDrawable.setShape(1);
      ((ImageView)localObject).setImageDrawable((Drawable)localGradientDrawable);
      this.yuH.setVisibility(0);
    }
    for (;;)
    {
      localObject = this.yuI;
      if (localObject == null) {
        break;
      }
      ((b)localObject).aA(Integer.valueOf(this.oQi));
      AppMethodBeat.o(120099);
      return;
      this.yuD.setSelected(true);
      this.yuE.setSelected(false);
      this.yuF.setImageDrawable(this.yuC);
      this.yuH.setVisibility(8);
      continue;
      this.yuD.setSelected(false);
      this.yuE.setSelected(true);
      this.yuF.setImageDrawable(this.yuC);
      this.yuH.setVisibility(8);
    }
    AppMethodBeat.o(120099);
  }
  
  public static int dLb()
  {
    AppMethodBeat.i(120100);
    Object localObject = new Random();
    StoryCommentView.a locala = StoryCommentView.yvz;
    int i = ((Random)localObject).nextInt(StoryCommentView.dLd().length);
    localObject = StoryCommentView.yvz;
    i = StoryCommentView.dLd()[i];
    AppMethodBeat.o(120100);
    return i;
  }
  
  public final b<Integer, y> getOnColorSelected()
  {
    return this.yuI;
  }
  
  public final int getSelectedColor()
  {
    return this.oQi;
  }
  
  public final void setOnColorSelected(b<? super Integer, y> paramb)
  {
    this.yuI = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.oQi = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */