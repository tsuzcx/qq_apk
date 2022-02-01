package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public final class PluginTextPreference
  extends Preference
{
  private ImageView Bga;
  public int OZn;
  private TextView gyt;
  private String text;
  private int textColor;
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
    this.Bga = null;
    this.gyt = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PluginTextPreference);
    setLayoutResource(paramContext.getResourceId(1, 2131495575));
    this.OZn = paramContext.getResourceId(0, 0);
    this.text = paramContext.getString(2);
    this.textColor = paramContext.getColor(3, -7039852);
    paramContext.recycle();
    AppMethodBeat.o(142627);
  }
  
  public final void alN(int paramInt)
  {
    AppMethodBeat.i(142628);
    this.text = this.mContext.getString(paramInt);
    AppMethodBeat.o(142628);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142629);
    super.onBindView(paramView);
    this.Bga = ((ImageView)paramView.findViewById(2131302573));
    this.Bga.setImageResource(this.OZn);
    this.Bga.setVisibility(this.visibility);
    this.gyt = ((TextView)paramView.findViewById(2131309013));
    this.gyt.setText(this.text);
    this.gyt.setTextColor(this.textColor);
    AppMethodBeat.o(142629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */