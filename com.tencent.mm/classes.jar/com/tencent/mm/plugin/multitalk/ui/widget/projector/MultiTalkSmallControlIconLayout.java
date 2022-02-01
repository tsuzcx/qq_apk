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
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "initStaus", "", "isChceked", "()Z", "setChceked", "(Z)V", "mRootView", "Landroid/view/View;", "singleStatus", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "plugin-multitalk_release"})
public final class MultiTalkSmallControlIconLayout
  extends FrameLayout
{
  private boolean FBq;
  boolean FBr;
  private boolean FxD;
  private float FxE;
  private int forbiddenDrawable;
  private int iconDrawable;
  private ImageView jmf;
  private View mrI;
  private int textColor;
  
  public MultiTalkSmallControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200346);
    View localView = LayoutInflater.from(paramContext).inflate(a.f.multitalk_small_icons_layout, (ViewGroup)this);
    p.j(localView, "LayoutInflater.from(cont…small_icons_layout, this)");
    this.mrI = localView;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.MultitalkControlIconStyle);
    this.iconDrawable = paramAttributeSet.getResourceId(a.i.MultitalkControlIconStyle_iconDrawable, -1);
    this.textColor = paramAttributeSet.getInteger(a.i.MultitalkControlIconStyle_iconTextColor, -1);
    this.FxD = paramAttributeSet.getBoolean(a.i.MultitalkControlIconStyle_initStatus, false);
    this.forbiddenDrawable = paramAttributeSet.getResourceId(a.i.MultitalkControlIconStyle_forbiddenDrawable, -1);
    this.FxE = paramAttributeSet.getDimension(a.i.MultitalkControlIconStyle_iconSize, -1.0F);
    this.FBq = paramAttributeSet.getBoolean(a.i.MultitalkControlIconStyle_singleStatus, false);
    paramAttributeSet.recycle();
    paramAttributeSet = findViewById(a.e.icon_iv);
    p.j(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.jmf = ((ImageView)paramAttributeSet);
    if (this.iconDrawable != -1)
    {
      if (this.FxD)
      {
        this.jmf.setImageDrawable(au.o(paramContext, this.iconDrawable, -16777216));
        AppMethodBeat.o(200346);
        return;
      }
      this.jmf.setImageDrawable(au.o(paramContext, this.iconDrawable, -1));
    }
    AppMethodBeat.o(200346);
  }
  
  public final void setChceked(boolean paramBoolean)
  {
    this.FBr = paramBoolean;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(200339);
    this.FBr = paramBoolean;
    setSelected(paramBoolean);
    if ((this.FBq) && (paramBoolean))
    {
      AppMethodBeat.o(200339);
      return;
    }
    Drawable localDrawable;
    if (this.iconDrawable != -1)
    {
      if (!this.FBr) {
        break label82;
      }
      if (this.FxD) {
        break label106;
      }
      localDrawable = au.o(getContext(), this.iconDrawable, -16777216);
    }
    for (;;)
    {
      this.jmf.setImageDrawable(localDrawable);
      AppMethodBeat.o(200339);
      return;
      label82:
      if (this.FxD) {
        localDrawable = au.o(getContext(), this.iconDrawable, -16777216);
      } else {
        label106:
        localDrawable = au.o(getContext(), this.forbiddenDrawable, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200343);
    if (paramBoolean)
    {
      this.mrI.setAlpha(1.0F);
      AppMethodBeat.o(200343);
      return;
    }
    this.mrI.setAlpha(0.3F);
    AppMethodBeat.o(200343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.MultiTalkSmallControlIconLayout
 * JD-Core Version:    0.7.0.1
 */