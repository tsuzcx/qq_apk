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
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "iconDrawable", "", "iconIv", "Landroid/widget/ImageView;", "iconText", "", "iconTv", "Landroid/widget/TextView;", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "isChecked", "", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  private ImageView fBA;
  private View ijA;
  private int textColor;
  MMCheckBox van;
  private TextView vao;
  private FrameLayout vap;
  private String vaq;
  private int var;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(2131494973, (ViewGroup)this);
    k.g(localObject, "LayoutInflater.from(cont…italk_icons_layout, this)");
    this.ijA = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultitalkControlIconStyle);
    localObject = localTypedArray.getString(1);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.vaq = paramAttributeSet;
    this.var = localTypedArray.getResourceId(0, -1);
    this.textColor = localTypedArray.getInteger(2, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(2131300885);
    k.g(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.van = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131300891);
    k.g(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.fBA = ((ImageView)paramAttributeSet);
    if (this.var != -1) {
      this.fBA.setImageDrawable(am.k(paramContext, this.var, -1));
    }
    paramContext = findViewById(2131300896);
    k.g(paramContext, "findViewById(R.id.icon_name)");
    this.vao = ((TextView)paramContext);
    this.vao.setText((CharSequence)this.vaq);
    this.vao.setTextColor(this.textColor);
    paramContext = findViewById(2131300894);
    k.g(paramContext, "findViewById(R.id.icon_main)");
    this.vap = ((FrameLayout)paramContext);
    AppMethodBeat.o(178976);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.van.setChecked(paramBoolean);
    Drawable localDrawable = this.vap.getBackground();
    k.g(localDrawable, "background");
    if (this.van.isChecked())
    {
      localObject = (ColorFilter)new PorterDuffColorFilter(am.eR(-1, 90), PorterDuff.Mode.SRC);
      localDrawable.setColorFilter((ColorFilter)localObject);
      this.vap.setBackground(localDrawable);
      if (this.var != -1) {
        if (!this.van.isChecked()) {
          break label140;
        }
      }
    }
    label140:
    for (Object localObject = am.k(getContext(), this.var, -16777216);; localObject = am.k(getContext(), this.var, -1))
    {
      this.fBA.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(178974);
      return;
      localObject = (ColorFilter)new PorterDuffColorFilter(am.eR(-16777216, 30), PorterDuff.Mode.SRC);
      break;
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    if (paramBoolean)
    {
      this.ijA.setAlpha(1.0F);
      AppMethodBeat.o(178975);
      return;
    }
    this.ijA.setAlpha(0.3F);
    AppMethodBeat.o(178975);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.van.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */