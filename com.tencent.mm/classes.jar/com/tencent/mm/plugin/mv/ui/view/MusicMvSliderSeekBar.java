package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barMode", "", "getUnscaledDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "iconSize", "init", "plugin-mv_release"})
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
  
  private final Drawable hy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257612);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt1);
    p.g(localObject, "drawable");
    int i = ((Drawable)localObject).getIntrinsicWidth();
    float f = 1.0F * paramInt2 / i;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = com.tencent.mm.svg.a.a.a(((Context)localObject).getResources(), paramInt1, f);
    p.g(localObject, "SVGCompat.getSVGDrawable…rces, drawableRes, scale)");
    AppMethodBeat.o(257612);
    return localObject;
  }
  
  public final void ekC()
  {
    AppMethodBeat.i(257613);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.zxx = ((Drawable)new SliderSeekBar.b(this, hy(2131691200, i), hy(2131691200, i)));
    this.zxy = ((Drawable)new SliderSeekBar.b(this, hy(2131691201, i), hy(2131691201, i)));
    this.zxP = true;
    postInvalidate();
    AppMethodBeat.o(257613);
  }
  
  public final void init()
  {
    AppMethodBeat.i(257611);
    super.init();
    this.zxz = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.zxA = (this.zxz * 0.5F);
    this.zxM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    ekA();
    AppMethodBeat.o(257611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */