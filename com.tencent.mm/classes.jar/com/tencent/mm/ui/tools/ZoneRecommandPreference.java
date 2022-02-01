package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  RegionCodeDecoder.Region afLR;
  RegionCodeDecoder.Region afLS;
  RegionCodeDecoder.Region afLT;
  private TextView afLU;
  private ImageView afLV;
  private TextView lPf;
  int status;
  
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
    AppMethodBeat.i(39211);
    this.status = 0;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(39211);
  }
  
  final void jDu()
  {
    AppMethodBeat.i(39214);
    if ((this.afLU == null) || (this.lPf == null))
    {
      AppMethodBeat.o(39214);
      return;
    }
    switch (this.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39214);
      return;
      this.afLU.setVisibility(8);
      this.lPf.setVisibility(0);
      this.lPf.setText(R.l.setting_zone_getting_location);
      this.afLV.setImageResource(R.k.get_location_icon);
      setEnabled(false);
      LH(false);
      AppMethodBeat.o(39214);
      return;
      this.afLU.setVisibility(8);
      this.lPf.setVisibility(0);
      this.lPf.setText(R.l.setting_zone_cannot_get_location);
      this.afLV.setImageResource(R.k.get_location_failed_icon);
      setEnabled(false);
      LH(false);
      AppMethodBeat.o(39214);
      return;
      this.afLU.setVisibility(0);
      this.lPf.setVisibility(8);
      this.afLV.setImageResource(R.k.get_location_icon);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.afLR != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.afLR.getName())) {
          localObject1 = "" + this.afLR.getName();
        }
      }
      localObject2 = localObject1;
      if (this.afLS != null)
      {
        localObject2 = localObject1;
        if (!Util.isNullOrNil(this.afLS.getName())) {
          localObject2 = (String)localObject1 + " " + this.afLS.getName();
        }
      }
      localObject1 = localObject2;
      if (this.afLT != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.afLT.getName())) {
          localObject1 = (String)localObject2 + " " + this.afLT.getName();
        }
      }
      this.afLU.setText((CharSequence)localObject1);
      setEnabled(true);
      LH(true);
    }
  }
  
  public final void jDv()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    jDu();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    jDu();
    AppMethodBeat.o(39213);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39212);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.gmb, localViewGroup);
    this.afLU = ((TextView)paramViewGroup.findViewById(R.h.gdT));
    this.lPf = ((TextView)paramViewGroup.findViewById(R.h.status));
    this.afLV = ((ImageView)paramViewGroup.findViewById(R.h.fYd));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */