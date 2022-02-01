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
import com.tencent.mm.plugin.voip.widget.MMCheckBox;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/widget/MMCheckBox;", "checkedIcon", "", "checkedText", "", "iconBg", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "iconText", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "uncheckedIcon", "uncheckedText", "applyDeviceOrientataionChange", "", "orientation", "isChecked", "onClickCalled", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTalkControlIconLayout
  extends FrameLayout
{
  MMCheckBox LtJ;
  private TextView LtK;
  private FrameLayout LtL;
  private final String LtM;
  private String LtN;
  private String LtO;
  private boolean LtP;
  private float LtQ;
  private int checkedIcon;
  private int iconBg;
  private ImageView lPb;
  private View plc;
  private int textColor;
  private int uncheckedIcon;
  
  public MultiTalkControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178976);
    Object localObject = LayoutInflater.from(paramContext).inflate(a.f.multitalk_icons_layout, (ViewGroup)this);
    s.s(localObject, "from(context).inflate(R.…italk_icons_layout, this)");
    this.plc = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.MultitalkControlIconStyle);
    s.s(localTypedArray, "context.obtainStyledAttr…ultitalkControlIconStyle)");
    this.LtM = localTypedArray.getString(a.i.MultitalkControlIconStyle_iconText);
    localObject = localTypedArray.getString(a.i.MultitalkControlIconStyle_checkedText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.LtN = paramAttributeSet;
    localObject = localTypedArray.getString(a.i.MultitalkControlIconStyle_uncheckedText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.LtO = paramAttributeSet;
    this.checkedIcon = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_checkedIcon, -1);
    this.textColor = localTypedArray.getInteger(a.i.MultitalkControlIconStyle_iconTextColor, -1);
    this.LtP = localTypedArray.getBoolean(a.i.MultitalkControlIconStyle_initStatus, false);
    this.uncheckedIcon = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_uncheckedIcon, -1);
    this.LtQ = localTypedArray.getDimension(a.i.MultitalkControlIconStyle_iconSize, -1.0F);
    this.iconBg = localTypedArray.getResourceId(a.i.MultitalkControlIconStyle_iconBg, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(a.e.icon_checkbox);
    s.s(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.LtJ = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(a.e.icon_iv);
    s.s(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.lPb = ((ImageView)paramAttributeSet);
    if (this.checkedIcon != -1)
    {
      if (this.LtP) {
        this.lPb.setImageDrawable(bb.m(paramContext, this.checkedIcon, -16777216));
      }
    }
    else
    {
      paramAttributeSet = findViewById(a.e.icon_name);
      s.s(paramAttributeSet, "findViewById(R.id.icon_name)");
      this.LtK = ((TextView)paramAttributeSet);
      this.LtK.setText((CharSequence)this.LtM);
      this.LtK.setTextColor(this.textColor);
      paramAttributeSet = findViewById(a.e.icon_main);
      s.s(paramAttributeSet, "findViewById(R.id.icon_main)");
      this.LtL = ((FrameLayout)paramAttributeSet);
      if (this.LtQ != -1.0F) {
        break label485;
      }
    }
    label485:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.LtL.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(bd.fromDPToPix(paramContext, (int)this.LtQ), bd.fromDPToPix(paramContext, (int)this.LtQ)));
      }
      if (this.iconBg != -1) {
        this.LtL.setBackground(getResources().getDrawable(this.iconBg));
      }
      if (this.LtM != null) {
        this.LtK.setText((CharSequence)this.LtN);
      }
      AppMethodBeat.o(178976);
      return;
      this.lPb.setImageDrawable(bb.m(paramContext, this.checkedIcon, -1));
      break;
    }
  }
  
  public final void abQ(int paramInt)
  {
    AppMethodBeat.i(285546);
    this.lPb.setRotation(360.0F - paramInt);
    AppMethodBeat.o(285546);
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(178974);
    this.LtJ.setChecked(paramBoolean);
    this.LtL.setSelected(paramBoolean);
    TextView localTextView;
    if (this.checkedIcon != -1)
    {
      if (this.LtJ.isChecked())
      {
        if (this.LtP) {
          break label135;
        }
        localObject = bb.m(getContext(), this.checkedIcon, -16777216);
        this.lPb.setImageDrawable((Drawable)localObject);
      }
    }
    else if (this.LtM == null)
    {
      localTextView = this.LtK;
      if (!this.LtJ.isChecked()) {
        break label151;
      }
    }
    label135:
    label151:
    for (Object localObject = (CharSequence)this.LtN;; localObject = (CharSequence)this.LtO)
    {
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(178974);
      return;
      if (this.LtP)
      {
        localObject = bb.m(getContext(), this.checkedIcon, -16777216);
        break;
      }
      localObject = bb.m(getContext(), this.uncheckedIcon, -1);
      break;
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(178975);
    TextView localTextView;
    if (paramBoolean)
    {
      this.plc.setAlpha(1.0F);
      if (this.LtM == null)
      {
        localTextView = this.LtK;
        if (!this.LtJ.isChecked()) {
          break label73;
        }
      }
    }
    label73:
    for (CharSequence localCharSequence = (CharSequence)this.LtN;; localCharSequence = (CharSequence)this.LtO)
    {
      localTextView.setText(localCharSequence);
      AppMethodBeat.o(178975);
      return;
      this.plc.setAlpha(0.3F);
      break;
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178973);
    this.LtJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(178973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout
 * JD-Core Version:    0.7.0.1
 */