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
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "forbiddenDrawable", "", "iconBg", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "iconText", "", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "applyDeviceOrientataionChange", "", "orientation", "isChecked", "onClickCalled", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  private ImageView gBZ;
  private View jBN;
  private int textColor;
  MMCheckBox zRU;
  private TextView zRV;
  private FrameLayout zRW;
  private String zRX;
  private int zRY;
  private int zRZ;
  private boolean zSa;
  private float zSb;
  private int zSc;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(2131495727, (ViewGroup)this);
    p.g(localObject, "LayoutInflater.from(cont…italk_icons_layout, this)");
    this.jBN = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultitalkControlIconStyle);
    localObject = localTypedArray.getString(4);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.zRX = paramAttributeSet;
    this.zRY = localTypedArray.getResourceId(2, -1);
    this.textColor = localTypedArray.getInteger(5, -1);
    this.zSa = localTypedArray.getBoolean(6, false);
    this.zRZ = localTypedArray.getResourceId(0, -1);
    this.zSb = localTypedArray.getDimension(3, -1.0F);
    this.zSc = localTypedArray.getResourceId(1, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(2131302485);
    p.g(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.zRU = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131302497);
    p.g(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.gBZ = ((ImageView)paramAttributeSet);
    if (this.zRY != -1)
    {
      if (!this.zSa) {
        break label370;
      }
      this.gBZ.setImageDrawable(ar.m(paramContext, this.zRY, -16777216));
    }
    for (;;)
    {
      paramAttributeSet = findViewById(2131302503);
      p.g(paramAttributeSet, "findViewById(R.id.icon_name)");
      this.zRV = ((TextView)paramAttributeSet);
      this.zRV.setText((CharSequence)this.zRX);
      this.zRV.setTextColor(this.textColor);
      paramAttributeSet = findViewById(2131302501);
      p.g(paramAttributeSet, "findViewById(R.id.icon_main)");
      this.zRW = ((FrameLayout)paramAttributeSet);
      if (this.zSb != -1.0F) {
        this.zRW.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(at.fromDPToPix(paramContext, (int)this.zSb), at.fromDPToPix(paramContext, (int)this.zSb)));
      }
      if (this.zSc != -1) {
        this.zRW.setBackground(getResources().getDrawable(this.zSc));
      }
      AppMethodBeat.o(178976);
      return;
      label370:
      this.gBZ.setImageDrawable(ar.m(paramContext, this.zRY, -1));
    }
  }
  
  public final void Rr(int paramInt)
  {
    AppMethodBeat.i(239784);
    this.gBZ.setRotation(360.0F - paramInt);
    AppMethodBeat.o(239784);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.zRU.setChecked(paramBoolean);
    this.zRW.setSelected(paramBoolean);
    Drawable localDrawable;
    if (this.zRY != -1)
    {
      if (!this.zRU.isChecked()) {
        break label74;
      }
      if (this.zSa) {
        break label98;
      }
      localDrawable = ar.m(getContext(), this.zRY, -16777216);
    }
    for (;;)
    {
      this.gBZ.setImageDrawable(localDrawable);
      AppMethodBeat.o(178974);
      return;
      label74:
      if (this.zSa) {
        localDrawable = ar.m(getContext(), this.zRY, -16777216);
      } else {
        label98:
        localDrawable = ar.m(getContext(), this.zRZ, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    if (paramBoolean)
    {
      this.jBN.setAlpha(1.0F);
      AppMethodBeat.o(178975);
      return;
    }
    this.jBN.setAlpha(0.3F);
    AppMethodBeat.o(178975);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.zRU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */