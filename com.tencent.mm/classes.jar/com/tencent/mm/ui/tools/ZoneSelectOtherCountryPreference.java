package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneSelectOtherCountryPreference
  extends Preference
{
  String text;
  ZoneSelectOtherCountryPreference.a wfG;
  
  public ZoneSelectOtherCountryPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZoneSelectOtherCountryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZoneSelectOtherCountryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(R.h.zonename);
    if (!bk.bl(this.text)) {
      localTextView.setText(this.text);
    }
    paramView.setOnClickListener(new ZoneSelectOtherCountryPreference.1(this));
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_zone, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference
 * JD-Core Version:    0.7.0.1
 */