package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.b;
import com.tencent.mm.plugin.mv.b.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barMode", "", "getUnscaledDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "iconSize", "init", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  private final Drawable kh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287227);
    int i = getContext().getResources().getDrawable(paramInt1).getIntrinsicWidth();
    float f = 1.0F * paramInt2 / i;
    Drawable localDrawable = com.tencent.mm.svg.a.a.a(getContext().getResources(), paramInt1, f);
    s.s(localDrawable, "getSVGDrawable(context.r…rces, drawableRes, scale)");
    AppMethodBeat.o(287227);
    return localDrawable;
  }
  
  public final void gcY()
  {
    AppMethodBeat.i(287236);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.KYA = ((Drawable)new SliderSeekBar.b((SliderSeekBar)this, kh(b.g.music_mv_left_bar, i), kh(b.g.music_mv_left_bar, i)));
    this.KYB = ((Drawable)new SliderSeekBar.b((SliderSeekBar)this, kh(b.g.music_mv_right_bar, i), kh(b.g.music_mv_right_bar, i)));
    this.KYS = true;
    postInvalidate();
    AppMethodBeat.o(287236);
  }
  
  public final void init()
  {
    AppMethodBeat.i(287230);
    super.init();
    this.KYC = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.KYD = (this.KYC * 0.5F);
    this.KYP = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.KYv = true;
    AppMethodBeat.o(287230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */