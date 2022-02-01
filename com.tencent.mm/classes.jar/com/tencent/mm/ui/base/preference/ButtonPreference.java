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
import com.tencent.mm.ae.a.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

public class ButtonPreference
  extends Preference
{
  private ImageView HDI;
  private String HDJ;
  public boolean HDK;
  public int HDL;
  private int Hyl;
  private TextView Up;
  private Drawable icon;
  private Context mContext;
  private int textColor;
  private View uCg;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.HDK = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.HDK = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142502);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142505);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ButtonPreference);
    this.Hyl = paramAttributeSet.getColor(2, 0);
    this.textColor = paramAttributeSet.getColor(3, 0);
    this.HDJ = paramContext.getString(paramAttributeSet.getResourceId(1, 0));
    this.icon = paramAttributeSet.getDrawable(0);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void fY(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.HDJ = paramString;
    this.textColor = paramInt;
    if (this.Up != null)
    {
      this.Up.setText(paramString);
      this.Up.setTextColor(paramInt);
      if (this.HDK) {
        aj.a(this.Up.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.HDI = ((ImageView)paramView.findViewById(2131300874));
    this.Up = ((TextView)paramView.findViewById(2131305710));
    if ((this.HDI != null) && (this.icon != null))
    {
      this.HDI.setVisibility(0);
      this.HDI.setImageDrawable(am.e(this.icon, this.Hyl));
    }
    if (this.Up != null)
    {
      this.Up.setText(this.HDJ);
      this.Up.setTextColor(this.textColor);
      if (this.HDK) {
        aj.a(this.Up.getPaint(), 0.8F);
      }
    }
    if ((this.uCg != null) && (this.HDL != 0)) {
      this.uCg.setId(this.HDL);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.uCg = LayoutInflater.from(this.mContext).inflate(2131495104, null);
    paramViewGroup = this.uCg;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */