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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView
  extends AbsStoryMuteView
{
  private final int ywN;
  private final int ywO;
  private Drawable ywP;
  private TextView ywQ;
  private ImageView ywR;
  
  public StoryMuteView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120281);
    this.ywN = 30;
    aFZ();
    AppMethodBeat.o(120281);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120282);
    this.ywN = 30;
    aFZ();
    AppMethodBeat.o(120282);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120283);
    this.ywN = 30;
    aFZ();
    AppMethodBeat.o(120283);
  }
  
  private final void aFZ()
  {
    AppMethodBeat.i(120276);
    LayoutInflater.from(getContext()).inflate(2131495712, (ViewGroup)this);
    this.ywQ = ((TextView)findViewById(2131305481));
    this.ywR = ((ImageView)findViewById(2131305480));
    Object localObject = getContext();
    k.g(localObject, "context");
    this.ywP = am.e(((Context)localObject).getResources().getDrawable(2131690675), -1);
    localObject = this.ywP;
    if (localObject == null) {
      k.fvU();
    }
    ((Drawable)localObject).setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
    localObject = this.ywQ;
    if (localObject != null) {
      ((TextView)localObject).setCompoundDrawables(null, this.ywP, null, null);
    }
    localObject = this.ywQ;
    if (localObject != null)
    {
      Context localContext = getContext();
      k.g(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131764287));
    }
    localObject = this.ywR;
    if (localObject != null)
    {
      ((ImageView)localObject).setPadding(this.ywO, this.ywN, this.ywN, this.ywO);
      AppMethodBeat.o(120276);
      return;
    }
    AppMethodBeat.o(120276);
  }
  
  private static int hI(int paramInt1, int paramInt2)
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
  
  public final void dFX()
  {
    AppMethodBeat.i(120279);
    ImageView localImageView = this.ywR;
    if (localImageView != null)
    {
      localImageView.setPadding(this.ywO, this.ywO, this.ywO, this.ywO);
      AppMethodBeat.o(120279);
      return;
    }
    AppMethodBeat.o(120279);
  }
  
  public final void dFY()
  {
    AppMethodBeat.i(120280);
    ImageView localImageView = this.ywR;
    if (localImageView != null)
    {
      localImageView.setPadding(this.ywO, this.ywN, this.ywN, this.ywO);
      AppMethodBeat.o(120280);
      return;
    }
    AppMethodBeat.o(120280);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120278);
    int i = hI(a.ap(getContext(), 2131166720), paramInt1);
    int j = hI(a.ap(getContext(), 2131166720), paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
    AppMethodBeat.o(120278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMuteView
 * JD-Core Version:    0.7.0.1
 */