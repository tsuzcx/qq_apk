package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;

public final class PluginTextPreference
  extends Preference
{
  private ImageView MXO;
  public int adZM;
  private TextView lKQ;
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
    this.MXO = null;
    this.lKQ = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.PluginTextPreference);
    setLayoutResource(paramContext.getResourceId(a.m.PluginTextPreference_plugin_layout, a.h.mm_preference_content_plugin_text));
    this.adZM = paramContext.getResourceId(a.m.PluginTextPreference_plugin_icon, 0);
    this.text = paramContext.getString(a.m.PluginTextPreference_plugin_text);
    this.textColor = paramContext.getColor(a.m.PluginTextPreference_plugin_text_color, -7039852);
    paramContext.recycle();
    AppMethodBeat.o(142627);
  }
  
  public final void aBo(int paramInt)
  {
    AppMethodBeat.i(142628);
    this.text = this.mContext.getString(paramInt);
    AppMethodBeat.o(142628);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142629);
    super.onBindView(paramView);
    this.MXO = ((ImageView)paramView.findViewById(a.g.image_iv));
    this.MXO.setImageResource(this.adZM);
    this.MXO.setVisibility(this.visibility);
    this.lKQ = ((TextView)paramView.findViewById(a.g.text_tv));
    this.lKQ.setText(this.text);
    this.lKQ.setTextColor(this.textColor);
    AppMethodBeat.o(142629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */