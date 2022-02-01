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
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;

public class ButtonPreference
  extends Preference
{
  private int Jmc;
  public boolean JrA;
  public int JrB;
  private ImageView Jry;
  private String Jrz;
  private TextView Wf;
  private Drawable icon;
  private Context mContext;
  private int textColor;
  private View vET;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.JrA = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.JrA = true;
    setLayoutResource(2131494804);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(142502);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142505);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ButtonPreference);
    this.Jmc = paramAttributeSet.getColor(2, 0);
    this.textColor = paramAttributeSet.getColor(3, 0);
    this.Jrz = paramContext.getString(paramAttributeSet.getResourceId(1, 0));
    this.icon = paramAttributeSet.getDrawable(0);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void gv(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.Jrz = paramString;
    this.textColor = paramInt;
    if (this.Wf != null)
    {
      this.Wf.setText(paramString);
      this.Wf.setTextColor(paramInt);
      if (this.JrA) {
        al.a(this.Wf.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.Jry = ((ImageView)paramView.findViewById(2131300874));
    this.Wf = ((TextView)paramView.findViewById(2131305710));
    if ((this.Jry != null) && (this.icon != null))
    {
      this.Jry.setVisibility(0);
      this.Jry.setImageDrawable(ao.e(this.icon, this.Jmc));
    }
    if (this.Wf != null)
    {
      this.Wf.setText(this.Jrz);
      this.Wf.setTextColor(this.textColor);
      if (this.JrA) {
        al.a(this.Wf.getPaint(), 0.8F);
      }
    }
    if ((this.vET != null) && (this.JrB != 0)) {
      this.vET.setId(this.JrB);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.vET = LayoutInflater.from(this.mContext).inflate(2131495104, null);
    paramViewGroup = this.vET;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */