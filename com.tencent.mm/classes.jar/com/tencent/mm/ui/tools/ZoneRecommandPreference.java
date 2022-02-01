package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  RegionCodeDecoder.Region IUV;
  RegionCodeDecoder.Region IUW;
  RegionCodeDecoder.Region IUX;
  private TextView IUY;
  private ImageView IUZ;
  private TextView fBE;
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
    setLayoutResource(2131494804);
    AppMethodBeat.o(39211);
  }
  
  final void fua()
  {
    AppMethodBeat.i(39214);
    if ((this.IUY == null) || (this.fBE == null))
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
      this.IUY.setVisibility(8);
      this.fBE.setVisibility(0);
      this.fBE.setText(2131763147);
      this.IUZ.setImageResource(2131690294);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.IUY.setVisibility(8);
      this.fBE.setVisibility(0);
      this.fBE.setText(2131763144);
      this.IUZ.setImageResource(2131690293);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.IUY.setVisibility(0);
      this.fBE.setVisibility(8);
      this.IUZ.setImageResource(2131690294);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.IUV != null)
      {
        localObject1 = localObject2;
        if (!bs.isNullOrNil(this.IUV.getName())) {
          localObject1 = "" + this.IUV.getName();
        }
      }
      localObject2 = localObject1;
      if (this.IUW != null)
      {
        localObject2 = localObject1;
        if (!bs.isNullOrNil(this.IUW.getName())) {
          localObject2 = (String)localObject1 + " " + this.IUW.getName();
        }
      }
      localObject1 = localObject2;
      if (this.IUX != null)
      {
        localObject1 = localObject2;
        if (!bs.isNullOrNil(this.IUX.getName())) {
          localObject1 = (String)localObject2 + " " + this.IUX.getName();
        }
      }
      this.IUY.setText((CharSequence)localObject1);
      setEnabled(true);
      setSelectable(true);
    }
  }
  
  public final void fub()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    fua();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    fua();
    AppMethodBeat.o(39213);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39212);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494850, localViewGroup);
    this.IUY = ((TextView)paramViewGroup.findViewById(2131307140));
    this.fBE = ((TextView)paramViewGroup.findViewById(2131305193));
    this.IUZ = ((ImageView)paramViewGroup.findViewById(2131305202));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */