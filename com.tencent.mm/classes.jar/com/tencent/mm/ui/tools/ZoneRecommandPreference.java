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
  RegionCodeDecoder.Region XVC;
  RegionCodeDecoder.Region XVD;
  RegionCodeDecoder.Region XVE;
  private TextView XVF;
  private ImageView XVG;
  private TextView jmj;
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
  
  final void hYL()
  {
    AppMethodBeat.i(39214);
    if ((this.XVF == null) || (this.jmj == null))
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
      this.XVF.setVisibility(8);
      this.jmj.setVisibility(0);
      this.jmj.setText(R.l.setting_zone_getting_location);
      this.XVG.setImageResource(R.k.get_location_icon);
      setEnabled(false);
      FV(false);
      AppMethodBeat.o(39214);
      return;
      this.XVF.setVisibility(8);
      this.jmj.setVisibility(0);
      this.jmj.setText(R.l.setting_zone_cannot_get_location);
      this.XVG.setImageResource(R.k.get_location_failed_icon);
      setEnabled(false);
      FV(false);
      AppMethodBeat.o(39214);
      return;
      this.XVF.setVisibility(0);
      this.jmj.setVisibility(8);
      this.XVG.setImageResource(R.k.get_location_icon);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.XVC != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.XVC.getName())) {
          localObject1 = "" + this.XVC.getName();
        }
      }
      localObject2 = localObject1;
      if (this.XVD != null)
      {
        localObject2 = localObject1;
        if (!Util.isNullOrNil(this.XVD.getName())) {
          localObject2 = (String)localObject1 + " " + this.XVD.getName();
        }
      }
      localObject1 = localObject2;
      if (this.XVE != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.XVE.getName())) {
          localObject1 = (String)localObject2 + " " + this.XVE.getName();
        }
      }
      this.XVF.setText((CharSequence)localObject1);
      setEnabled(true);
      FV(true);
    }
  }
  
  public final void hYM()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    hYL();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    hYL();
    AppMethodBeat.o(39213);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39212);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.ejb, localViewGroup);
    this.XVF = ((TextView)paramViewGroup.findViewById(R.h.zonename));
    this.jmj = ((TextView)paramViewGroup.findViewById(R.h.status));
    this.XVG = ((ImageView)paramViewGroup.findViewById(R.h.dVG));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */