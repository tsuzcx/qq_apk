package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  private ImageView QxA;
  RegionCodeDecoder.Region Qxw;
  RegionCodeDecoder.Region Qxx;
  RegionCodeDecoder.Region Qxy;
  private TextView Qxz;
  private TextView gCd;
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
    setLayoutResource(2131495538);
    AppMethodBeat.o(39211);
  }
  
  final void gYa()
  {
    AppMethodBeat.i(39214);
    if ((this.Qxz == null) || (this.gCd == null))
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
      this.Qxz.setVisibility(8);
      this.gCd.setVisibility(0);
      this.gCd.setText(2131765315);
      this.QxA.setImageResource(2131690390);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.Qxz.setVisibility(8);
      this.gCd.setVisibility(0);
      this.gCd.setText(2131765312);
      this.QxA.setImageResource(2131690389);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.Qxz.setVisibility(0);
      this.gCd.setVisibility(8);
      this.QxA.setImageResource(2131690390);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.Qxw != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.Qxw.getName())) {
          localObject1 = "" + this.Qxw.getName();
        }
      }
      localObject2 = localObject1;
      if (this.Qxx != null)
      {
        localObject2 = localObject1;
        if (!Util.isNullOrNil(this.Qxx.getName())) {
          localObject2 = (String)localObject1 + " " + this.Qxx.getName();
        }
      }
      localObject1 = localObject2;
      if (this.Qxy != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(this.Qxy.getName())) {
          localObject1 = (String)localObject2 + " " + this.Qxy.getName();
        }
      }
      this.Qxz.setText((CharSequence)localObject1);
      setEnabled(true);
      setSelectable(true);
    }
  }
  
  public final void gYb()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    gYa();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    gYa();
    AppMethodBeat.o(39213);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39212);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495585, localViewGroup);
    this.Qxz = ((TextView)paramViewGroup.findViewById(2131310681));
    this.gCd = ((TextView)paramViewGroup.findViewById(2131308389));
    this.QxA = ((ImageView)paramViewGroup.findViewById(2131308399));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */