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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.story.a.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView
  extends AbsStoryMuteView
{
  private final int LXR;
  private final int LXS;
  private Drawable LXT;
  private TextView LXU;
  private ImageView LXV;
  
  public StoryMuteView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120281);
    this.LXR = 30;
    buQ();
    AppMethodBeat.o(120281);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120282);
    this.LXR = 30;
    buQ();
    AppMethodBeat.o(120282);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120283);
    this.LXR = 30;
    buQ();
    AppMethodBeat.o(120283);
  }
  
  private final void buQ()
  {
    AppMethodBeat.i(120276);
    LayoutInflater.from(getContext()).inflate(a.e.LDi, (ViewGroup)this);
    this.LXU = ((TextView)findViewById(a.d.LCk));
    this.LXV = ((ImageView)findViewById(a.d.LCj));
    Object localObject = getContext();
    p.j(localObject, "context");
    this.LXT = au.e(((Context)localObject).getResources().getDrawable(a.f.icons_outlined_volume_off), -1);
    localObject = this.LXT;
    if (localObject == null) {
      p.iCn();
    }
    ((Drawable)localObject).setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
    localObject = this.LXU;
    if (localObject != null) {
      ((TextView)localObject).setCompoundDrawables(null, this.LXT, null, null);
    }
    localObject = this.LXU;
    if (localObject != null)
    {
      Context localContext = getContext();
      p.j(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(a.g.LEj));
    }
    localObject = this.LXV;
    if (localObject != null)
    {
      ((ImageView)localObject).setPadding(this.LXS, this.LXR, this.LXR, this.LXS);
      AppMethodBeat.o(120276);
      return;
    }
    AppMethodBeat.o(120276);
  }
  
  private static int kq(int paramInt1, int paramInt2)
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
  
  public final void gbo()
  {
    AppMethodBeat.i(120279);
    ImageView localImageView = this.LXV;
    if (localImageView != null)
    {
      localImageView.setPadding(this.LXS, this.LXS, this.LXS, this.LXS);
      AppMethodBeat.o(120279);
      return;
    }
    AppMethodBeat.o(120279);
  }
  
  public final void gbp()
  {
    AppMethodBeat.i(120280);
    ImageView localImageView = this.LXV;
    if (localImageView != null)
    {
      localImageView.setPadding(this.LXS, this.LXR, this.LXR, this.LXS);
      AppMethodBeat.o(120280);
      return;
    }
    AppMethodBeat.o(120280);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120278);
    int i = kq(a.aZ(getContext(), a.b.dlA), paramInt1);
    int j = kq(a.aZ(getContext(), a.b.dlA), paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
    AppMethodBeat.o(120278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMuteView
 * JD-Core Version:    0.7.0.1
 */