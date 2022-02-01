package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "initStaus", "", "isChceked", "()Z", "setChceked", "(Z)V", "mRootView", "Landroid/view/View;", "singleStatus", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "plugin-multitalk_release"})
public final class MultiTalkSmallControlIconLayout
  extends FrameLayout
{
  private ImageView gBZ;
  private View jBN;
  private int textColor;
  private int zRY;
  private int zRZ;
  private boolean zSa;
  private float zSb;
  private boolean zVG;
  boolean zVH;
  
  public MultiTalkSmallControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239899);
    View localView = LayoutInflater.from(paramContext).inflate(2131495756, (ViewGroup)this);
    p.g(localView, "LayoutInflater.from(cont…small_icons_layout, this)");
    this.jBN = localView;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultitalkControlIconStyle);
    this.zRY = paramAttributeSet.getResourceId(2, -1);
    this.textColor = paramAttributeSet.getInteger(5, -1);
    this.zSa = paramAttributeSet.getBoolean(6, false);
    this.zRZ = paramAttributeSet.getResourceId(0, -1);
    this.zSb = paramAttributeSet.getDimension(3, -1.0F);
    this.zVG = paramAttributeSet.getBoolean(7, false);
    paramAttributeSet.recycle();
    paramAttributeSet = findViewById(2131302497);
    p.g(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.gBZ = ((ImageView)paramAttributeSet);
    if (this.zRY != -1)
    {
      if (this.zSa)
      {
        this.gBZ.setImageDrawable(ar.m(paramContext, this.zRY, -16777216));
        AppMethodBeat.o(239899);
        return;
      }
      this.gBZ.setImageDrawable(ar.m(paramContext, this.zRY, -1));
    }
    AppMethodBeat.o(239899);
  }
  
  public final void setChceked(boolean paramBoolean)
  {
    this.zVH = paramBoolean;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(239897);
    this.zVH = paramBoolean;
    setSelected(paramBoolean);
    if ((this.zVG) && (paramBoolean))
    {
      AppMethodBeat.o(239897);
      return;
    }
    Drawable localDrawable;
    if (this.zRY != -1)
    {
      if (!this.zVH) {
        break label82;
      }
      if (this.zSa) {
        break label106;
      }
      localDrawable = ar.m(getContext(), this.zRY, -16777216);
    }
    for (;;)
    {
      this.gBZ.setImageDrawable(localDrawable);
      AppMethodBeat.o(239897);
      return;
      label82:
      if (this.zSa) {
        localDrawable = ar.m(getContext(), this.zRY, -16777216);
      } else {
        label106:
        localDrawable = ar.m(getContext(), this.zRZ, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(239898);
    if (paramBoolean)
    {
      this.jBN.setAlpha(1.0F);
      AppMethodBeat.o(239898);
      return;
    }
    this.jBN.setAlpha(0.3F);
    AppMethodBeat.o(239898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.MultiTalkSmallControlIconLayout
 * JD-Core Version:    0.7.0.1
 */