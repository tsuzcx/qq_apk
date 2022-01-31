package com.tencent.mm.plugin.story.ui.view;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
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
import com.tencent.mm.cb.a;
import java.util.Random;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", "origin", "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector
  extends LinearLayout
{
  private int lzs;
  private final int sLX;
  private final Drawable sLY;
  private final ImageView sLZ;
  private final ImageView sMa;
  private final ImageView sMb;
  private final LinearLayout sMc;
  private final TextView sMd;
  private b<? super Integer, y> sMe;
  private final int strokeWidth;
  
  public StoryCommentColorSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110386);
    AppMethodBeat.o(110386);
  }
  
  public StoryCommentColorSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110385);
    this.lzs = -1;
    View.inflate(paramContext, 2130970932, (ViewGroup)this);
    setOrientation(0);
    paramAttributeSet = findViewById(2131828296);
    j.p(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_white)");
    this.sLZ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828297);
    j.p(paramAttributeSet, "findViewById(R.id.story_…ent_color_selector_black)");
    this.sMa = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828299);
    j.p(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_icon)");
    this.sMb = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828298);
    j.p(paramAttributeSet, "findViewById(R.id.story_…nt_color_selector_random)");
    this.sMc = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131828300);
    j.p(paramAttributeSet, "findViewById(R.id.story_…lor_selector_random_text)");
    this.sMd = ((TextView)paramAttributeSet);
    this.sLZ.setOnClickListener((View.OnClickListener)new StoryCommentColorSelector.1(this));
    this.sMa.setOnClickListener((View.OnClickListener)new StoryCommentColorSelector.2(this));
    this.sMc.setOnClickListener((View.OnClickListener)new StoryCommentColorSelector.3(this));
    this.strokeWidth = a.fromDPToPix(paramContext, 2);
    this.sLX = a.fromDPToPix(paramContext, 4);
    paramContext = new GradientDrawable();
    paramContext.setColors(new int[] { -372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399 });
    paramContext.setGradientType(2);
    paramContext.setStroke(this.strokeWidth, -1);
    paramContext.setShape(1);
    paramContext = (Drawable)paramContext;
    j.q(paramContext, "origin");
    this.sLY = ((Drawable)new InsetDrawable(paramContext, this.sLX));
    cFu();
    AppMethodBeat.o(110385);
  }
  
  private final void cFu()
  {
    AppMethodBeat.i(110383);
    Object localObject;
    switch (this.lzs)
    {
    default: 
      this.sLZ.setSelected(false);
      this.sMa.setSelected(false);
      localObject = this.sMb;
      int i = this.lzs;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(this.strokeWidth, -1);
      localGradientDrawable.setShape(1);
      ((ImageView)localObject).setImageDrawable((Drawable)localGradientDrawable);
      this.sMd.setVisibility(0);
    }
    for (;;)
    {
      localObject = this.sMe;
      if (localObject == null) {
        break;
      }
      ((b)localObject).S(Integer.valueOf(this.lzs));
      AppMethodBeat.o(110383);
      return;
      this.sLZ.setSelected(true);
      this.sMa.setSelected(false);
      this.sMb.setImageDrawable(this.sLY);
      this.sMd.setVisibility(8);
      continue;
      this.sLZ.setSelected(false);
      this.sMa.setSelected(true);
      this.sMb.setImageDrawable(this.sLY);
      this.sMd.setVisibility(8);
    }
    AppMethodBeat.o(110383);
  }
  
  public static int cFv()
  {
    AppMethodBeat.i(110384);
    Object localObject = new Random();
    StoryCommentView.a locala = StoryCommentView.sMY;
    int i = ((Random)localObject).nextInt(StoryCommentView.cFx().length);
    localObject = StoryCommentView.sMY;
    i = StoryCommentView.cFx()[i];
    AppMethodBeat.o(110384);
    return i;
  }
  
  public final b<Integer, y> getOnColorSelected()
  {
    return this.sMe;
  }
  
  public final int getSelectedColor()
  {
    return this.lzs;
  }
  
  public final void setOnColorSelected(b<? super Integer, y> paramb)
  {
    this.sMe = paramb;
  }
  
  public final void setSelectedColor(int paramInt)
  {
    this.lzs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector
 * JD-Core Version:    0.7.0.1
 */