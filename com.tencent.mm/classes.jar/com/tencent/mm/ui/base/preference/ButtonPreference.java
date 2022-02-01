package com.tencent.mm.ui.base.preference;

import android.content.Context;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;

public class ButtonPreference
  extends Preference
{
  private View EQs;
  private ImageView Wqv;
  private String Wqw;
  public int Wqx;
  private Drawable bxV;
  private int iconColor;
  private Context mContext;
  private TextView rR;
  private int textColor;
  public boolean yfJ;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.yfJ = true;
    setLayoutResource(a.h.mm_preference);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.yfJ = true;
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
    this.Wqw = paramContext.getString(paramAttributeSet.getResourceId(a.m.ButtonPreference_btn_title, 0));
    this.bxV = paramAttributeSet.getDrawable(a.m.ButtonPreference_btn_icon);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void hG(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.Wqw = paramString;
    this.textColor = paramInt;
    if (this.rR != null)
    {
      this.rR.setText(paramString);
      this.rR.setTextColor(paramInt);
      if (this.yfJ) {
        ar.a(this.rR.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.Wqv = ((ImageView)paramView.findViewById(a.g.icon));
    this.rR = ((TextView)paramView.findViewById(a.g.text));
    if ((this.Wqv != null) && (this.bxV != null))
    {
      this.Wqv.setVisibility(0);
      this.Wqv.setImageDrawable(au.e(this.bxV, this.iconColor));
    }
    if (this.rR != null)
    {
      this.rR.setText(this.Wqw);
      this.rR.setTextColor(this.textColor);
      if (this.yfJ) {
        ar.a(this.rR.getPaint(), 0.8F);
      }
    }
    if ((this.EQs != null) && (this.Wqx != 0)) {
      this.EQs.setId(this.Wqx);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.EQs = LayoutInflater.from(this.mContext).inflate(a.h.preference_button_layout, null);
    paramViewGroup = this.EQs;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */