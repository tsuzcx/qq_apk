package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;

public final class PluginTextPreference
  extends Preference
{
  private TextView ehx;
  private ImageView pAE;
  private String text;
  private int textColor;
  public int visibility;
  public int zsa;
  
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
    AppMethodBeat.i(107250);
    this.pAE = null;
    this.ehx = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PluginTextPreference);
    setLayoutResource(paramContext.getResourceId(1, 2130970213));
    this.zsa = paramContext.getResourceId(0, 0);
    this.text = paramContext.getString(2);
    this.textColor = paramContext.getColor(3, -7039852);
    paramContext.recycle();
    AppMethodBeat.o(107250);
  }
  
  public final void OV(int paramInt)
  {
    AppMethodBeat.i(107251);
    this.text = this.mContext.getString(paramInt);
    AppMethodBeat.o(107251);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107252);
    super.onBindView(paramView);
    this.pAE = ((ImageView)paramView.findViewById(2131822243));
    this.pAE.setImageResource(this.zsa);
    this.pAE.setVisibility(this.visibility);
    this.ehx = ((TextView)paramView.findViewById(2131821551));
    this.ehx.setText(this.text);
    this.ehx.setTextColor(this.textColor);
    AppMethodBeat.o(107252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PluginTextPreference
 * JD-Core Version:    0.7.0.1
 */