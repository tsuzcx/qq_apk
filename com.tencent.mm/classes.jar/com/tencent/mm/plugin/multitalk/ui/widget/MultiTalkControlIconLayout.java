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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconText", "", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  private ImageView fUN;
  private View iCR;
  private int textColor;
  private boolean wfA;
  MMCheckBox wfu;
  private TextView wfv;
  private FrameLayout wfw;
  private String wfx;
  private int wfy;
  private int wfz;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(2131494973, (ViewGroup)this);
    p.g(localObject, "LayoutInflater.from(cont…italk_icons_layout, this)");
    this.iCR = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultitalkControlIconStyle);
    localObject = localTypedArray.getString(1);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.wfx = paramAttributeSet;
    this.wfy = localTypedArray.getResourceId(0, -1);
    this.textColor = localTypedArray.getInteger(2, -1);
    this.wfA = localTypedArray.getBoolean(4, false);
    this.wfz = localTypedArray.getResourceId(3, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(2131300885);
    p.g(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.wfu = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131300891);
    p.g(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.fUN = ((ImageView)paramAttributeSet);
    if (this.wfy != -1)
    {
      if (!this.wfA) {
        break label275;
      }
      this.fUN.setImageDrawable(ao.k(paramContext, this.wfy, -16777216));
    }
    for (;;)
    {
      paramContext = findViewById(2131300896);
      p.g(paramContext, "findViewById(R.id.icon_name)");
      this.wfv = ((TextView)paramContext);
      this.wfv.setText((CharSequence)this.wfx);
      this.wfv.setTextColor(this.textColor);
      paramContext = findViewById(2131300894);
      p.g(paramContext, "findViewById(R.id.icon_main)");
      this.wfw = ((FrameLayout)paramContext);
      AppMethodBeat.o(178976);
      return;
      label275:
      this.fUN.setImageDrawable(ao.k(paramContext, this.wfy, -1));
    }
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.wfu.setChecked(paramBoolean);
    Drawable localDrawable = this.wfw.getBackground();
    p.g(localDrawable, "background");
    Object localObject;
    if (this.wfu.isChecked()) {
      if (!this.wfA)
      {
        localObject = new PorterDuffColorFilter(ao.eV(-1, 90), PorterDuff.Mode.SRC);
        localObject = (ColorFilter)localObject;
        localDrawable.setColorFilter((ColorFilter)localObject);
        this.wfw.setBackground(localDrawable);
        if (this.wfy != -1)
        {
          if (!this.wfu.isChecked()) {
            break label206;
          }
          if (this.wfA) {
            break label230;
          }
          localObject = ao.k(getContext(), this.wfy, -16777216);
        }
      }
    }
    for (;;)
    {
      this.fUN.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(178974);
      return;
      localObject = new PorterDuffColorFilter(ao.eV(-16777216, 30), PorterDuff.Mode.SRC);
      break;
      if (!this.wfA) {}
      for (localObject = new PorterDuffColorFilter(ao.eV(-16777216, 30), PorterDuff.Mode.SRC);; localObject = new PorterDuffColorFilter(ao.eV(-1, 90), PorterDuff.Mode.SRC))
      {
        localObject = (ColorFilter)localObject;
        break;
      }
      label206:
      if (this.wfA) {
        localObject = ao.k(getContext(), this.wfy, -16777216);
      } else {
        label230:
        localObject = ao.k(getContext(), this.wfz, -1);
      }
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    if (paramBoolean)
    {
      this.iCR.setAlpha(1.0F);
      AppMethodBeat.o(178975);
      return;
    }
    this.iCR.setAlpha(0.3F);
    AppMethodBeat.o(178975);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.wfu.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */