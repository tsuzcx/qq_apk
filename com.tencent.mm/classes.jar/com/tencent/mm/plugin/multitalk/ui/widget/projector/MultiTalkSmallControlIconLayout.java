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
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "initStaus", "", "isChceked", "()Z", "setChceked", "(Z)V", "mRootView", "Landroid/view/View;", "singleStatus", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTalkSmallControlIconLayout
  extends FrameLayout
{
  private boolean LtP;
  private float LtQ;
  private int Lxs;
  private boolean Lxt;
  boolean Lxu;
  private int iconDrawable;
  private ImageView lPb;
  private View plc;
  private int textColor;
  
  public MultiTalkSmallControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285711);
    View localView = LayoutInflater.from(paramContext).inflate(a.f.multitalk_small_icons_layout, (ViewGroup)this);
    s.s(localView, "from(context).inflate(R.…small_icons_layout, this)");
    this.plc = localView;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.MultitalkControlIconStyle);
    s.s(paramAttributeSet, "context.obtainStyledAttr…ultitalkControlIconStyle)");
    this.iconDrawable = paramAttributeSet.getResourceId(a.i.MultitalkControlIconStyle_checkedIcon, -1);
    this.textColor = paramAttributeSet.getInteger(a.i.MultitalkControlIconStyle_iconTextColor, -1);
    this.LtP = paramAttributeSet.getBoolean(a.i.MultitalkControlIconStyle_initStatus, false);
    this.Lxs = paramAttributeSet.getResourceId(a.i.MultitalkControlIconStyle_uncheckedIcon, -1);
    this.LtQ = paramAttributeSet.getDimension(a.i.MultitalkControlIconStyle_iconSize, -1.0F);
    this.Lxt = paramAttributeSet.getBoolean(a.i.MultitalkControlIconStyle_singleStatus, false);
    paramAttributeSet.recycle();
    paramAttributeSet = findViewById(a.e.icon_iv);
    s.s(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.lPb = ((ImageView)paramAttributeSet);
    if (this.iconDrawable != -1)
    {
      if (this.LtP)
      {
        this.lPb.setImageDrawable(bb.m(paramContext, this.iconDrawable, -16777216));
        AppMethodBeat.o(285711);
        return;
      }
      this.lPb.setImageDrawable(bb.m(paramContext, this.iconDrawable, -1));
    }
    AppMethodBeat.o(285711);
  }
  
  public final void setChceked(boolean paramBoolean)
  {
    this.Lxu = paramBoolean;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(285728);
    this.Lxu = paramBoolean;
    setSelected(paramBoolean);
    if ((this.Lxt) && (paramBoolean))
    {
      AppMethodBeat.o(285728);
      return;
    }
    Drawable localDrawable;
    if (this.iconDrawable != -1)
    {
      if (!this.Lxu) {
        break label82;
      }
      if (this.LtP) {
        break label106;
      }
      localDrawable = bb.m(getContext(), this.iconDrawable, -16777216);
    }
    for (;;)
    {
      this.lPb.setImageDrawable(localDrawable);
      AppMethodBeat.o(285728);
      return;
      label82:
      if (this.LtP) {
        localDrawable = bb.m(getContext(), this.iconDrawable, -16777216);
      } else {
        label106:
        localDrawable = bb.m(getContext(), this.Lxs, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(285738);
    if (paramBoolean)
    {
      this.plc.setAlpha(1.0F);
      AppMethodBeat.o(285738);
      return;
    }
    this.plc.setAlpha(0.3F);
    AppMethodBeat.o(285738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.MultiTalkSmallControlIconLayout
 * JD-Core Version:    0.7.0.1
 */