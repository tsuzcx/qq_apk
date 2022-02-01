package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.b;
import com.tencent.mm.plugin.mv.b.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barMode", "", "getUnscaledDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "iconSize", "init", "plugin-mv_release"})
public final class MusicMvSliderSeekBar
  extends SliderSeekBar
{
  public MusicMvSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MusicMvSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final Drawable iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227507);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt1);
    p.j(localObject, "drawable");
    int i = ((Drawable)localObject).getIntrinsicWidth();
    float f = 1.0F * paramInt2 / i;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = com.tencent.mm.svg.a.a.a(((Context)localObject).getResources(), paramInt1, f);
    p.j(localObject, "SVGCompat.getSVGDrawable…rces, drawableRes, scale)");
    AppMethodBeat.o(227507);
    return localObject;
  }
  
  public final void eUk()
  {
    AppMethodBeat.i(227510);
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    this.FcR = ((Drawable)new SliderSeekBar.b(this, iD(b.g.music_mv_left_bar, i), iD(b.g.music_mv_left_bar, i)));
    this.FcS = ((Drawable)new SliderSeekBar.b(this, iD(b.g.music_mv_right_bar, i), iD(b.g.music_mv_right_bar, i)));
    this.Fdj = true;
    postInvalidate();
    AppMethodBeat.o(227510);
  }
  
  public final void init()
  {
    AppMethodBeat.i(227504);
    super.init();
    this.FcT = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    this.FcU = (this.FcT * 0.5F);
    this.Fdg = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    eUi();
    AppMethodBeat.o(227504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */