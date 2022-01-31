package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView
  extends AbsStoryMuteView
{
  private final int sNe;
  private final int sNf;
  private Drawable sNg;
  private TextView sNh;
  private ImageView sNi;
  
  public StoryMuteView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110446);
    this.sNe = 30;
    cFy();
    AppMethodBeat.o(110446);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110447);
    this.sNe = 30;
    cFy();
    AppMethodBeat.o(110447);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110448);
    this.sNe = 30;
    cFy();
    AppMethodBeat.o(110448);
  }
  
  private final void cFy()
  {
    AppMethodBeat.i(110441);
    LayoutInflater.from(getContext()).inflate(2130970967, (ViewGroup)this);
    this.sNh = ((TextView)findViewById(2131828438));
    this.sNi = ((ImageView)findViewById(2131828437));
    Object localObject = getContext();
    j.p(localObject, "context");
    this.sNg = aj.e(((Context)localObject).getResources().getDrawable(2131231541), -1);
    localObject = this.sNg;
    if (localObject == null) {
      j.ebi();
    }
    ((Drawable)localObject).setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
    localObject = this.sNh;
    if (localObject != null) {
      ((TextView)localObject).setCompoundDrawables(null, this.sNg, null, null);
    }
    localObject = this.sNh;
    if (localObject != null)
    {
      Context localContext = getContext();
      j.p(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131304177));
    }
    localObject = this.sNi;
    if (localObject != null)
    {
      ((ImageView)localObject).setPadding(this.sNf, this.sNe, this.sNe, this.sNf);
      AppMethodBeat.o(110441);
      return;
    }
    AppMethodBeat.o(110441);
  }
  
  private static int gd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110442);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    for (;;)
    {
      AppMethodBeat.o(110442);
      return paramInt2;
      paramInt2 = paramInt1;
      if (j == -2147483648) {
        paramInt2 = Math.min(paramInt1, i);
      }
    }
  }
  
  public final void czi()
  {
    AppMethodBeat.i(110444);
    ImageView localImageView = this.sNi;
    if (localImageView != null)
    {
      localImageView.setPadding(this.sNf, this.sNf, this.sNf, this.sNf);
      AppMethodBeat.o(110444);
      return;
    }
    AppMethodBeat.o(110444);
  }
  
  public final void czj()
  {
    AppMethodBeat.i(110445);
    ImageView localImageView = this.sNi;
    if (localImageView != null)
    {
      localImageView.setPadding(this.sNf, this.sNe, this.sNe, this.sNf);
      AppMethodBeat.o(110445);
      return;
    }
    AppMethodBeat.o(110445);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110443);
    int i = gd(a.ap(getContext(), 2131428633), paramInt1);
    int j = gd(a.ap(getContext(), 2131428633), paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
    AppMethodBeat.o(110443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMuteView
 * JD-Core Version:    0.7.0.1
 */