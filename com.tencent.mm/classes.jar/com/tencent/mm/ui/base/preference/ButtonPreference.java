package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;

public class ButtonPreference
  extends Preference
{
  public boolean DWD;
  private View KKQ;
  private ImageView adXH;
  public String adXI;
  public int adXJ;
  private Drawable dqY;
  private int iconColor;
  private Context mContext;
  private TextView sQ;
  private int textColor;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.DWD = true;
    setLayoutResource(a.h.mm_preference);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.DWD = true;
    setLayoutResource(a.h.mm_preference);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142502);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142505);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ButtonPreference);
    this.iconColor = paramAttributeSet.getColor(a.m.ButtonPreference_icon_color, 0);
    this.textColor = paramAttributeSet.getColor(a.m.ButtonPreference_title_color, 0);
    this.adXI = paramContext.getString(paramAttributeSet.getResourceId(a.m.ButtonPreference_btn_title, 0));
    this.dqY = paramAttributeSet.getDrawable(a.m.ButtonPreference_btn_icon);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void aBd(int paramInt)
  {
    AppMethodBeat.i(251505);
    if (this.KKQ != null) {
      this.KKQ.setBackground(this.mContext.getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(251505);
  }
  
  public final void iN(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.adXI = paramString;
    this.textColor = paramInt;
    if (this.sQ != null)
    {
      this.sQ.setText(paramString);
      this.sQ.setTextColor(paramInt);
      if (this.DWD) {
        aw.a(this.sQ.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.adXH = ((ImageView)paramView.findViewById(a.g.icon));
    this.sQ = ((TextView)paramView.findViewById(a.g.text));
    if ((this.adXH != null) && (this.dqY != null))
    {
      this.adXH.setVisibility(0);
      this.adXH.setImageDrawable(bb.e(this.dqY, this.iconColor));
    }
    if (this.sQ != null)
    {
      this.sQ.setText(this.adXI);
      this.sQ.setTextColor(this.textColor);
      if (this.DWD) {
        aw.a(this.sQ.getPaint(), 0.8F);
      }
    }
    if ((this.KKQ != null) && (this.adXJ != 0)) {
      this.KKQ.setId(this.adXJ);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.KKQ = LayoutInflater.from(this.mContext).inflate(a.h.preference_button_layout, null);
    paramViewGroup = this.KKQ;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */