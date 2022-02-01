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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;

public class ButtonPreference
  extends Preference
{
  private ImageView OXk;
  private String OXl;
  public boolean OXm;
  public int OXn;
  private TextView Ws;
  private Drawable icon;
  private Context mContext;
  private int textColor;
  private int uzt;
  private View zlc;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142503);
    this.OXm = true;
    setLayoutResource(2131495538);
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(142503);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142502);
    this.OXm = true;
    setLayoutResource(2131495538);
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(142502);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142505);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ButtonPreference);
    this.uzt = paramAttributeSet.getColor(2, 0);
    this.textColor = paramAttributeSet.getColor(3, 0);
    this.OXl = paramContext.getString(paramAttributeSet.getResourceId(1, 0));
    this.icon = paramAttributeSet.getDrawable(0);
    paramAttributeSet.recycle();
    AppMethodBeat.o(142505);
  }
  
  public final void gX(String paramString, int paramInt)
  {
    AppMethodBeat.i(142506);
    this.OXl = paramString;
    this.textColor = paramInt;
    if (this.Ws != null)
    {
      this.Ws.setText(paramString);
      this.Ws.setTextColor(paramInt);
      if (this.OXm) {
        ao.a(this.Ws.getPaint(), 0.8F);
      }
    }
    AppMethodBeat.o(142506);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142507);
    super.onBindView(paramView);
    this.OXk = ((ImageView)paramView.findViewById(2131302468));
    this.Ws = ((TextView)paramView.findViewById(2131308977));
    if ((this.OXk != null) && (this.icon != null))
    {
      this.OXk.setVisibility(0);
      this.OXk.setImageDrawable(ar.e(this.icon, this.uzt));
    }
    if (this.Ws != null)
    {
      this.Ws.setText(this.OXl);
      this.Ws.setTextColor(this.textColor);
      if (this.OXm) {
        ao.a(this.Ws.getPaint(), 0.8F);
      }
    }
    if ((this.zlc != null) && (this.OXn != 0)) {
      this.zlc.setId(this.OXn);
    }
    AppMethodBeat.o(142507);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142504);
    this.zlc = LayoutInflater.from(this.mContext).inflate(2131495946, null);
    paramViewGroup = this.zlc;
    AppMethodBeat.o(142504);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ButtonPreference
 * JD-Core Version:    0.7.0.1
 */