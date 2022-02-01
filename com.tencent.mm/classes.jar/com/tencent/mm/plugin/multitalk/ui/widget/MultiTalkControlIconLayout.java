package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconText", "", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  private ImageView fWT;
  private View iFK;
  private int textColor;
  MMCheckBox wuX;
  private TextView wuY;
  private FrameLayout wuZ;
  private String wva;
  private int wvb;
  private int wvc;
  private boolean wvd;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(2131494973, (ViewGroup)this);
    p.g(localObject, "LayoutInflater.from(cont…italk_icons_layout, this)");
    this.iFK = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultitalkControlIconStyle);
    localObject = localTypedArray.getString(1);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.wva = paramAttributeSet;
    this.wvb = localTypedArray.getResourceId(0, -1);
    this.textColor = localTypedArray.getInteger(2, -1);
    this.wvd = localTypedArray.getBoolean(4, false);
    this.wvc = localTypedArray.getResourceId(3, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(2131300885);
    p.g(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.wuX = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131300891);
    p.g(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.fWT = ((ImageView)paramAttributeSet);
    if (this.wvb != -1)
    {
      if (!this.wvd) {
        break label275;
      }
      this.fWT.setImageDrawable(ao.k(paramContext, this.wvb, -16777216));
    }
    for (;;)
    {
      paramContext = findViewById(2131300896);
      p.g(paramContext, "findViewById(R.id.icon_name)");
      this.wuY = ((TextView)paramContext);
      this.wuY.setText((CharSequence)this.wva);
      this.wuY.setTextColor(this.textColor);
      paramContext = findViewById(2131300894);
      p.g(paramContext, "findViewById(R.id.icon_main)");
      this.wuZ = ((FrameLayout)paramContext);
      AppMethodBeat.o(178976);
      return;
      label275:
      this.fWT.setImageDrawable(ao.k(paramContext, this.wvb, -1));
    }
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.wuX.setChecked(paramBoolean);
    Drawable localDrawable = this.wuZ.getBackground();
    p.g(localDrawable, "background");
    Object localObject;
    if (this.wuX.isChecked()) {
      if (!this.wvd)
      {
        localObject = new PorterDuffColorFilter(ao.eW(-1, 90), PorterDuff.Mode.SRC);
        localObject = (ColorFilter)localObject;
        localDrawable.setColorFilter((ColorFilter)localObject);
        this.wuZ.setBackground(localDrawable);
        if (this.wvb != -1)
        {
          if (!this.wuX.isChecked()) {
            break label206;
          }
          if (this.wvd) {
            break label230;
          }
          localObject = ao.k(getContext(), this.wvb, -16777216);
        }
      }
    }
    for (;;)
    {
      this.fWT.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(178974);
      return;
      localObject = new PorterDuffColorFilter(ao.eW(-16777216, 30), PorterDuff.Mode.SRC);
      break;
      if (!this.wvd) {}
      for (localObject = new PorterDuffColorFilter(ao.eW(-16777216, 30), PorterDuff.Mode.SRC);; localObject = new PorterDuffColorFilter(ao.eW(-1, 90), PorterDuff.Mode.SRC))
      {
        localObject = (ColorFilter)localObject;
        break;
      }
      label206:
      if (this.wvd) {
        localObject = ao.k(getContext(), this.wvb, -16777216);
      } else {
        label230:
        localObject = ao.k(getContext(), this.wvc, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    if (paramBoolean)
    {
      this.iFK.setAlpha(1.0F);
      AppMethodBeat.o(178975);
      return;
    }
    this.iFK.setAlpha(0.3F);
    AppMethodBeat.o(178975);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.wuX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */