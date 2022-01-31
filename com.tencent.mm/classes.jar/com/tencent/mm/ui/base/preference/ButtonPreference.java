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
import com.tencent.mm.ad.a.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aj;

public class ButtonPreference
  extends Preference
{
  private Drawable icon;
  private Context mContext;
  private TextView md;
  private View ozm;
  private int textColor;
  private ImageView zqr;
  private int zqs;
  private String zqt;
  public boolean zqu;
  public int zqv;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142755);
    this.zqu = true;
    setLayoutResource(2130970179);
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(142755);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142754);
    this.zqu = true;
    setLayoutResource(2130970179);
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(142754);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142757);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ButtonPreference);
    this.zqs = paramAttributeSet.getColor(0, 0);
    this.textColor = paramAttributeSet.getColor(2, 0);
    this.zqt = paramContext.getString(paramAttributeSet.getResourceId(3, 0));
    this.icon = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142757);
  }
  
  public final void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(142758);
    this.zqt = paramString;
    this.textColor = paramInt;
    if (this.md != null)
    {
      this.md.setText(paramString);
      this.md.setTextColor(paramInt);
      if (this.zqu) {
        af.a(this.md.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142758);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142759);
    super.onBindView(paramView);
    this.zqr = ((ImageView)paramView.findViewById(2131820929));
    this.md = ((TextView)paramView.findViewById(2131820676));
    if ((this.zqr != null) && (this.icon != null))
    {
      this.zqr.setVisibility(0);
      this.zqr.setImageDrawable(aj.e(this.icon, this.zqs));
    }
    if (this.md != null)
    {
      this.md.setText(this.zqt);
      this.md.setTextColor(this.textColor);
      if (this.zqu) {
        af.a(this.md.getPaint(), 0.8F);
      }
    }
    if ((this.ozm != null) && (this.zqv != 0)) {
      this.ozm.setId(this.zqv);
    }
    AppMethodBeat.o(142759);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142756);
    this.ozm = LayoutInflater.from(this.mContext).inflate(2130970431, null);
    paramViewGroup = this.ozm;
    AppMethodBeat.o(142756);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */