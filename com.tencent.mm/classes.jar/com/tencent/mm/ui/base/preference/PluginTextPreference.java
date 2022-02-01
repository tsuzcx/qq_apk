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
  public int GfM;
  private TextView ful;
  private String text;
  private int textColor;
  private ImageView uCn;
  public int visibility;
  
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
    this.uCn = null;
    this.ful = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PluginTextPreference);
    setLayoutResource(paramContext.getResourceId(1, 2131494840));
    this.GfM = paramContext.getResourceId(0, 0);
    this.text = paramContext.getString(2);
    this.textColor = paramContext.getColor(3, -7039852);
    paramContext.recycle();
    AppMethodBeat.o(142627);
  }
  
  public final void Ya(int paramInt)
  {
    AppMethodBeat.i(142628);
    this.text = this.mContext.getString(paramInt);
    AppMethodBeat.o(142628);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142629);
    super.onBindView(paramView);
    this.uCn = ((ImageView)paramView.findViewById(2131300943));
    this.uCn.setImageResource(this.GfM);
    this.uCn.setVisibility(this.visibility);
    this.ful = ((TextView)paramView.findViewById(2131305744));
    this.ful.setText(this.text);
    this.ful.setTextColor(this.textColor);
    AppMethodBeat.o(142629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */