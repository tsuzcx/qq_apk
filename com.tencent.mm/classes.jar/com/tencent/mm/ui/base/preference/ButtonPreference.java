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
import com.tencent.mm.af.a.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;

public class ButtonPreference
  extends Preference
{
  private int FYw;
  private ImageView GdT;
  private String GdU;
  public boolean GdV;
  public int GdW;
  private TextView Tu;
  private Drawable icon;
  private Context mContext;
  private int textColor;
  private View ttN;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.GdV = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.GdV = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142502);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142505);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ButtonPreference);
    this.FYw = paramAttributeSet.getColor(2, 0);
    this.textColor = paramAttributeSet.getColor(3, 0);
    this.GdU = paramContext.getString(paramAttributeSet.getResourceId(1, 0));
    this.icon = paramAttributeSet.getDrawable(0);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void fU(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.GdU = paramString;
    this.textColor = paramInt;
    if (this.Tu != null)
    {
      this.Tu.setText(paramString);
      this.Tu.setTextColor(paramInt);
      if (this.GdV) {
        ai.a(this.Tu.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.GdT = ((ImageView)paramView.findViewById(2131300874));
    this.Tu = ((TextView)paramView.findViewById(2131305710));
    if ((this.GdT != null) && (this.icon != null))
    {
      this.GdT.setVisibility(0);
      this.GdT.setImageDrawable(am.e(this.icon, this.FYw));
    }
    if (this.Tu != null)
    {
      this.Tu.setText(this.GdU);
      this.Tu.setTextColor(this.textColor);
      if (this.GdV) {
        ai.a(this.Tu.getPaint(), 0.8F);
      }
    }
    if ((this.ttN != null) && (this.GdW != 0)) {
      this.ttN.setId(this.GdW);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.ttN = LayoutInflater.from(this.mContext).inflate(2131495104, null);
    paramViewGroup = this.ttN;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */