package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/widget/VoIPFuncIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconBg", "", "iconDrawable", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "iconSize", "", "iconText", "", "iconTv", "Landroid/widget/TextView;", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "setIconEnabled", "", "enable", "", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VoIPFuncIconLayout
  extends FrameLayout
{
  private WeImageView Bqk;
  private TextView LtK;
  private FrameLayout LtL;
  private String LtM;
  private float LtQ;
  private int iconBg;
  private int iconDrawable;
  private View plc;
  private int textColor;
  
  public VoIPFuncIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293427);
    Object localObject = LayoutInflater.from(paramContext).inflate(b.e.voip_func_icons_layout, (ViewGroup)this);
    s.s(localObject, "from(context).inflate(R.…_func_icons_layout, this)");
    this.plc = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, b.h.VoipControlIconStyle);
    s.s(localTypedArray, "context.obtainStyledAttr…ble.VoipControlIconStyle)");
    localObject = localTypedArray.getString(b.h.VoipControlIconStyle_iconText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.LtM = paramAttributeSet;
    this.iconDrawable = localTypedArray.getResourceId(b.h.VoipControlIconStyle_iconDrawable, -1);
    this.textColor = localTypedArray.getInteger(b.h.VoipControlIconStyle_iconTextColor, -1);
    this.LtQ = localTypedArray.getDimension(b.h.VoipControlIconStyle_iconSize, -1.0F);
    this.iconBg = localTypedArray.getResourceId(b.h.VoipControlIconStyle_iconBg, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(b.d.icon_iv);
    s.s(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.Bqk = ((WeImageView)paramAttributeSet);
    if (this.iconDrawable != -1)
    {
      this.Bqk.setImageDrawable(bb.m(paramContext, this.iconDrawable, -1));
      this.Bqk.setIconColor(-1);
    }
    paramAttributeSet = findViewById(b.d.icon_name);
    s.s(paramAttributeSet, "findViewById(R.id.icon_name)");
    this.LtK = ((TextView)paramAttributeSet);
    this.LtK.setText((CharSequence)this.LtM);
    this.LtK.setTextColor(this.textColor);
    paramAttributeSet = findViewById(b.d.icon_main);
    s.s(paramAttributeSet, "findViewById(R.id.icon_main)");
    this.LtL = ((FrameLayout)paramAttributeSet);
    if (this.LtQ == -1.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.LtL.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(bd.fromDPToPix(paramContext, (int)this.LtQ), bd.fromDPToPix(paramContext, (int)this.LtQ)));
      }
      if (this.iconBg != -1) {
        this.LtL.setBackground(getResources().getDrawable(this.iconBg));
      }
      AppMethodBeat.o(293427);
      return;
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(293432);
    this.LtL.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      if (this.iconDrawable != -1)
      {
        this.Bqk.setImageDrawable(bb.m(getContext(), this.iconDrawable, -1));
        this.Bqk.setIconColor(-1);
        AppMethodBeat.o(293432);
      }
    }
    else if (this.iconDrawable != -1)
    {
      int i = bb.av(bb.gy(-16777216, 50), -1);
      this.Bqk.setImageDrawable(bb.m(getContext(), this.iconDrawable, i));
      this.Bqk.setIconColor(i);
    }
    AppMethodBeat.o(293432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPFuncIconLayout
 * JD-Core Version:    0.7.0.1
 */