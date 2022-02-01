package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView
  extends AbsStoryMuteView
{
  private final int BbE;
  private final int BbF;
  private Drawable BbG;
  private TextView BbH;
  private ImageView BbI;
  
  public StoryMuteView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120281);
    this.BbE = 30;
    aPX();
    AppMethodBeat.o(120281);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120282);
    this.BbE = 30;
    aPX();
    AppMethodBeat.o(120282);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120283);
    this.BbE = 30;
    aPX();
    AppMethodBeat.o(120283);
  }
  
  private final void aPX()
  {
    AppMethodBeat.i(120276);
    LayoutInflater.from(getContext()).inflate(2131495712, (ViewGroup)this);
    this.BbH = ((TextView)findViewById(2131305481));
    this.BbI = ((ImageView)findViewById(2131305480));
    Object localObject = getContext();
    p.g(localObject, "context");
    this.BbG = ao.e(((Context)localObject).getResources().getDrawable(2131690675), -1);
    localObject = this.BbG;
    if (localObject == null) {
      p.gfZ();
    }
    ((Drawable)localObject).setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
    localObject = this.BbH;
    if (localObject != null) {
      ((TextView)localObject).setCompoundDrawables(null, this.BbG, null, null);
    }
    localObject = this.BbH;
    if (localObject != null)
    {
      Context localContext = getContext();
      p.g(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131764287));
    }
    localObject = this.BbI;
    if (localObject != null)
    {
      ((ImageView)localObject).setPadding(this.BbF, this.BbE, this.BbE, this.BbF);
      AppMethodBeat.o(120276);
      return;
    }
    AppMethodBeat.o(120276);
  }
  
  private static int ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120277);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    for (;;)
    {
      AppMethodBeat.o(120277);
      return paramInt2;
      paramInt2 = paramInt1;
      if (j == -2147483648) {
        paramInt2 = Math.min(paramInt1, i);
      }
    }
  }
  
  public final void egM()
  {
    AppMethodBeat.i(120279);
    ImageView localImageView = this.BbI;
    if (localImageView != null)
    {
      localImageView.setPadding(this.BbF, this.BbF, this.BbF, this.BbF);
      AppMethodBeat.o(120279);
      return;
    }
    AppMethodBeat.o(120279);
  }
  
  public final void egN()
  {
    AppMethodBeat.i(120280);
    ImageView localImageView = this.BbI;
    if (localImageView != null)
    {
      localImageView.setPadding(this.BbF, this.BbE, this.BbE, this.BbF);
      AppMethodBeat.o(120280);
      return;
    }
    AppMethodBeat.o(120280);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120278);
    int i = ii(a.ay(getContext(), 2131166720), paramInt1);
    int j = ii(a.ay(getContext(), 2131166720), paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
    AppMethodBeat.o(120278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMuteView
 * JD-Core Version:    0.7.0.1
 */