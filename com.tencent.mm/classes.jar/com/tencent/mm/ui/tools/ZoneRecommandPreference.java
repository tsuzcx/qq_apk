package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  private TextView eXu;
  int status = 0;
  RegionCodeDecoder.Region wfB;
  RegionCodeDecoder.Region wfC;
  RegionCodeDecoder.Region wfD;
  private TextView wfE;
  private ImageView wfF;
  
  public ZoneRecommandPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZoneRecommandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZoneRecommandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  final void cJo()
  {
    if ((this.wfE == null) || (this.eXu == null)) {
      return;
    }
    switch (this.status)
    {
    default: 
      return;
    case 0: 
      this.wfE.setVisibility(8);
      this.eXu.setVisibility(0);
      this.eXu.setText(R.l.setting_zone_getting_location);
      this.wfF.setImageResource(R.k.get_location_icon);
      setEnabled(false);
      setSelectable(false);
      return;
    case 2: 
      this.wfE.setVisibility(8);
      this.eXu.setVisibility(0);
      this.eXu.setText(R.l.setting_zone_cannot_get_location);
      this.wfF.setImageResource(R.k.get_location_failed_icon);
      setEnabled(false);
      setSelectable(false);
      return;
    }
    this.wfE.setVisibility(0);
    this.eXu.setVisibility(8);
    this.wfF.setImageResource(R.k.get_location_icon);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.wfB != null)
    {
      localObject1 = localObject2;
      if (!ah.bl(this.wfB.getName())) {
        localObject1 = "" + this.wfB.getName();
      }
    }
    localObject2 = localObject1;
    if (this.wfC != null)
    {
      localObject2 = localObject1;
      if (!ah.bl(this.wfC.getName())) {
        localObject2 = (String)localObject1 + " " + this.wfC.getName();
      }
    }
    localObject1 = localObject2;
    if (this.wfD != null)
    {
      localObject1 = localObject2;
      if (!ah.bl(this.wfD.getName())) {
        localObject1 = (String)localObject2 + " " + this.wfD.getName();
      }
    }
    this.wfE.setText((CharSequence)localObject1);
    setEnabled(true);
    setSelectable(true);
  }
  
  public final void cJp()
  {
    this.status = 2;
    cJo();
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    cJo();
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_zone_recommand, localViewGroup);
    this.wfE = ((TextView)paramViewGroup.findViewById(R.h.zonename));
    this.eXu = ((TextView)paramViewGroup.findViewById(R.h.status));
    this.wfF = ((ImageView)paramViewGroup.findViewById(R.h.status_image));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */