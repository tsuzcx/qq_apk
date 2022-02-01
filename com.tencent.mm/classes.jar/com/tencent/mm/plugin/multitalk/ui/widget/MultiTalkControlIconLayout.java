package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "forbiddenDrawable", "", "iconBg", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "iconText", "", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "applyDeviceOrientataionChange", "", "orientation", "isChecked", "onClickCalled", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  private TextView FxA;
  private FrameLayout FxB;
  private String FxC;
  private boolean FxD;
  private float FxE;
  MMCheckBox Fxz;
  private int forbiddenDrawable;
  private int iconBg;
  private int iconDrawable;
  private ImageView jmf;
  private View mrI;
  private int textColor;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(a.f.multitalk_icons_layout, (ViewGroup)this);
    p.j(localObject, "LayoutInflater.from(cont…italk_icons_layout, this)");
    this.mrI = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.MultitalkControlIconStyle);
    localObject = localTypedArray.getString(a.i.MultitalkControlIconStyle_iconText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.FxC = paramAttributeSet;
    this.iconDrawable = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_iconDrawable, -1);
    this.textColor = localTypedArray.getInteger(a.i.MultitalkControlIconStyle_iconTextColor, -1);
    this.FxD = localTypedArray.getBoolean(a.i.MultitalkControlIconStyle_initStatus, false);
    this.forbiddenDrawable = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_forbiddenDrawable, -1);
    this.FxE = localTypedArray.getDimension(a.i.MultitalkControlIconStyle_iconSize, -1.0F);
    this.iconBg = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_iconBg, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(a.e.icon_checkbox);
    p.j(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.Fxz = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(a.e.icon_iv);
    p.j(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.jmf = ((ImageView)paramAttributeSet);
    if (this.iconDrawable != -1)
    {
      if (!this.FxD) {
        break label388;
      }
      this.jmf.setImageDrawable(au.o(paramContext, this.iconDrawable, -16777216));
    }
    for (;;)
    {
      paramAttributeSet = findViewById(a.e.icon_name);
      p.j(paramAttributeSet, "findViewById(R.id.icon_name)");
      this.FxA = ((TextView)paramAttributeSet);
      this.FxA.setText((CharSequence)this.FxC);
      this.FxA.setTextColor(this.textColor);
      paramAttributeSet = findViewById(a.e.icon_main);
      p.j(paramAttributeSet, "findViewById(R.id.icon_main)");
      this.FxB = ((FrameLayout)paramAttributeSet);
      if (this.FxE != -1.0F) {
        this.FxB.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(aw.fromDPToPix(paramContext, (int)this.FxE), aw.fromDPToPix(paramContext, (int)this.FxE)));
      }
      if (this.iconBg != -1) {
        this.FxB.setBackground(getResources().getDrawable(this.iconBg));
      }
      AppMethodBeat.o(178976);
      return;
      label388:
      this.jmf.setImageDrawable(au.o(paramContext, this.iconDrawable, -1));
    }
  }
  
  public final void XG(int paramInt)
  {
    AppMethodBeat.i(204178);
    this.jmf.setRotation(360.0F - paramInt);
    AppMethodBeat.o(204178);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.Fxz.setChecked(paramBoolean);
    this.FxB.setSelected(paramBoolean);
    Drawable localDrawable;
    if (this.iconDrawable != -1)
    {
      if (!this.Fxz.isChecked()) {
        break label76;
      }
      if (this.FxD) {
        break label100;
      }
      localDrawable = au.o(getContext(), this.iconDrawable, -16777216);
    }
    for (;;)
    {
      this.jmf.setImageDrawable(localDrawable);
      AppMethodBeat.o(178974);
      return;
      label76:
      if (this.FxD) {
        localDrawable = au.o(getContext(), this.iconDrawable, -16777216);
      } else {
        label100:
        localDrawable = au.o(getContext(), this.forbiddenDrawable, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    if (paramBoolean)
    {
      this.mrI.setAlpha(1.0F);
      AppMethodBeat.o(178975);
      return;
    }
    this.mrI.setAlpha(0.3F);
    AppMethodBeat.o(178975);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.Fxz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */