package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  private TextView wfA;
  RegionCodeDecoder.Region wfy;
  private CharSequence wfz;
  
  public ZonePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZonePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZonePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  private void cJn()
  {
    if (this.wfA == null) {
      return;
    }
    if ((this.wfz != null) && (!ah.bl(this.wfz.toString()))) {
      this.wfA.setVisibility(0);
    }
    for (;;)
    {
      this.wfA.setText(this.wfz);
      return;
      this.wfA.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    if ((paramRegion == null) || (ah.bl(paramRegion.getName())) || (ah.bl(paramRegion.getCode())))
    {
      y.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.wfy = paramRegion;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.wfy == null) {
      return;
    }
    ((TextView)paramView.findViewById(R.h.zonename)).setText(this.wfy.getName());
    this.wfA = ((TextView)paramView.findViewById(R.h.summery));
    cJn();
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
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    this.wfz = paramCharSequence;
    cJn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */