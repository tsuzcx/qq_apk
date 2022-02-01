package com.tencent.mm.plugin.voip.widget;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/widget/VoIPControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/widget/MMCheckBox;", "checkedIconResId", "", "checkedText", "", "iconBg", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "iconSize", "", "iconText", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "uncheckedIconResId", "uncheckedText", "iconColor", "isChecked", "isEnabled", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VoIPControlIconLayout
  extends FrameLayout
{
  private WeImageView Bqk;
  public MMCheckBox LtJ;
  private TextView LtK;
  private FrameLayout LtL;
  private final String LtM;
  private String LtN;
  private String LtO;
  private boolean LtP;
  private float LtQ;
  private int UVx;
  private int UVy;
  private int iconBg;
  private View plc;
  private int textColor;
  
  public VoIPControlIconLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293460);
    Object localObject = LayoutInflater.from(paramContext).inflate(b.e.voip_control_icons_layout, (ViewGroup)this);
    s.s(localObject, "from(context).inflate(R.…ntrol_icons_layout, this)");
    this.plc = ((View)localObject);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, b.h.VoipControlIconStyle);
    s.s(localTypedArray, "context.obtainStyledAttr…ble.VoipControlIconStyle)");
    this.LtM = localTypedArray.getString(b.h.VoipControlIconStyle_iconText);
    localObject = localTypedArray.getString(b.h.VoipControlIconStyle_checkedText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.LtN = paramAttributeSet;
    localObject = localTypedArray.getString(b.h.VoipControlIconStyle_uncheckedText);
    paramAttributeSet = (AttributeSet)localObject;
    if (localObject == null) {
      paramAttributeSet = "";
    }
    this.LtO = paramAttributeSet;
    this.UVx = localTypedArray.getResourceId(b.h.VoipControlIconStyle_checkedIcon, -1);
    this.textColor = localTypedArray.getInteger(b.h.VoipControlIconStyle_iconTextColor, -1);
    this.LtP = localTypedArray.getBoolean(b.h.VoipControlIconStyle_initStatus, false);
    this.UVy = localTypedArray.getResourceId(b.h.VoipControlIconStyle_uncheckedIcon, -1);
    this.LtQ = localTypedArray.getDimension(b.h.VoipControlIconStyle_iconSize, -1.0F);
    this.iconBg = localTypedArray.getResourceId(b.h.VoipControlIconStyle_iconBg, -1);
    localTypedArray.recycle();
    paramAttributeSet = findViewById(b.d.icon_checkbox);
    s.s(paramAttributeSet, "findViewById(R.id.icon_checkbox)");
    this.LtJ = ((MMCheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(b.d.icon_iv);
    s.s(paramAttributeSet, "findViewById(R.id.icon_iv)");
    this.Bqk = ((WeImageView)paramAttributeSet);
    if (this.UVx != -1)
    {
      if (this.LtP)
      {
        this.Bqk.setImageDrawable(bb.m(paramContext, this.UVx, -16777216));
        this.Bqk.setIconColor(-16777216);
      }
    }
    else
    {
      paramAttributeSet = findViewById(b.d.icon_name);
      s.s(paramAttributeSet, "findViewById(R.id.icon_name)");
      this.LtK = ((TextView)paramAttributeSet);
      this.LtK.setText((CharSequence)this.LtM);
      this.LtK.setTextColor(this.textColor);
      paramAttributeSet = findViewById(b.d.icon_main);
      s.s(paramAttributeSet, "findViewById(R.id.icon_main)");
      this.LtL = ((FrameLayout)paramAttributeSet);
      if (this.LtQ != -1.0F) {
        break label514;
      }
    }
    label514:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.LtL.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(bd.fromDPToPix(paramContext, (int)this.LtQ), bd.fromDPToPix(paramContext, (int)this.LtQ)));
      }
      if (this.iconBg != -1) {
        this.LtL.setBackground(getResources().getDrawable(this.iconBg));
      }
      if (this.LtM == null)
      {
        this.LtK.setText((CharSequence)this.LtN);
        setContentDescription((CharSequence)this.LtN);
      }
      AppMethodBeat.o(293460);
      return;
      this.Bqk.setImageDrawable(bb.m(paramContext, this.UVx, -1));
      this.Bqk.setIconColor(-1);
      break;
    }
  }
  
  private static int by(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(293470);
    if (!paramBoolean2)
    {
      int i = bb.av(bb.gy(-7829368, 50), -1);
      AppMethodBeat.o(293470);
      return i;
    }
    if (paramBoolean1)
    {
      AppMethodBeat.o(293470);
      return -16777216;
    }
    AppMethodBeat.o(293470);
    return -1;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(293483);
    this.LtJ.setChecked(paramBoolean);
    this.LtL.setSelected(paramBoolean);
    int i;
    TextView localTextView;
    if (this.UVx != -1)
    {
      i = by(this.LtJ.isChecked(), this.LtJ.isEnabled());
      if (this.LtJ.isChecked())
      {
        localObject = bb.m(getContext(), this.UVx, i);
        this.Bqk.setImageDrawable((Drawable)localObject);
        this.Bqk.setIconColor(i);
      }
    }
    else if (this.LtM == null)
    {
      localTextView = this.LtK;
      if (!this.LtJ.isChecked()) {
        break label158;
      }
    }
    label158:
    for (Object localObject = (CharSequence)this.LtN;; localObject = (CharSequence)this.LtO)
    {
      localTextView.setText((CharSequence)localObject);
      setContentDescription(this.LtK.getText());
      AppMethodBeat.o(293483);
      return;
      localObject = bb.m(getContext(), this.UVy, i);
      break;
    }
  }
  
  public final void setIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(293492);
    this.LtJ.setEnabled(paramBoolean);
    this.LtL.setEnabled(paramBoolean);
    this.Bqk.setIconColor(by(this.LtJ.isChecked(), paramBoolean));
    AppMethodBeat.o(293492);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(293475);
    this.LtJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(293475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPControlIconLayout
 * JD-Core Version:    0.7.0.1
 */