package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;

public final class PluginTextPreference
  extends Preference
{
  private TextView dqa = null;
  private ImageView mXR = null;
  private String text;
  private int textColor;
  public int vdA;
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
    setLayoutResource(a.h.mm_preference_content_plugin_text);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.PluginTextPreference);
    this.vdA = paramContext.getResourceId(a.m.PluginTextPreference_plugin_icon, 0);
    this.text = paramContext.getString(a.m.PluginTextPreference_plugin_text);
    this.textColor = paramContext.getColor(a.m.PluginTextPreference_plugin_text_color, -7039852);
    paramContext.recycle();
  }
  
  public final void GC(int paramInt)
  {
    this.text = this.mContext.getString(paramInt);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mXR = ((ImageView)paramView.findViewById(a.g.image_iv));
    this.mXR.setImageResource(this.vdA);
    this.mXR.setVisibility(this.visibility);
    this.dqa = ((TextView)paramView.findViewById(a.g.text_tv));
    this.dqa.setText(this.text);
    this.dqa.setTextColor(this.textColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */