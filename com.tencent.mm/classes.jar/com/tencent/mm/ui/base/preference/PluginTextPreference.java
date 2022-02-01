package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;

public final class PluginTextPreference
  extends Preference
{
  public int Jts;
  private TextView fRf;
  private String text;
  private int textColor;
  public int visibility;
  private ImageView wSp;
  
  public PluginTextPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PluginTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PluginTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142627);
    this.wSp = null;
    this.fRf = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PluginTextPreference);
    setLayoutResource(paramContext.getResourceId(1, 2131494840));
    this.Jts = paramContext.getResourceId(0, 0);
    this.text = paramContext.getString(2);
    this.textColor = paramContext.getColor(3, -7039852);
    paramContext.recycle();
    AppMethodBeat.o(142627);
  }
  
  public final void acv(int paramInt)
  {
    AppMethodBeat.i(142628);
    this.text = this.mContext.getString(paramInt);
    AppMethodBeat.o(142628);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142629);
    super.onBindView(paramView);
    this.wSp = ((ImageView)paramView.findViewById(2131300943));
    this.wSp.setImageResource(this.Jts);
    this.wSp.setVisibility(this.visibility);
    this.fRf = ((TextView)paramView.findViewById(2131305744));
    this.fRf.setText(this.text);
    this.fRf.setTextColor(this.textColor);
    AppMethodBeat.o(142629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */