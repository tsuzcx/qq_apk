package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  RegionCodeDecoder.Region KLZ;
  RegionCodeDecoder.Region KMa;
  RegionCodeDecoder.Region KMb;
  private TextView KMc;
  private ImageView KMd;
  private TextView fUR;
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
  
  final void fKN()
  {
    AppMethodBeat.i(39214);
    if ((this.KMc == null) || (this.fUR == null))
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
      this.KMc.setVisibility(8);
      this.fUR.setVisibility(0);
      this.fUR.setText(2131763147);
      this.KMd.setImageResource(2131690294);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.KMc.setVisibility(8);
      this.fUR.setVisibility(0);
      this.fUR.setText(2131763144);
      this.KMd.setImageResource(2131690293);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.KMc.setVisibility(0);
      this.fUR.setVisibility(8);
      this.KMd.setImageResource(2131690294);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.KLZ != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(this.KLZ.getName())) {
          localObject1 = "" + this.KLZ.getName();
        }
      }
      localObject2 = localObject1;
      if (this.KMa != null)
      {
        localObject2 = localObject1;
        if (!bt.isNullOrNil(this.KMa.getName())) {
          localObject2 = (String)localObject1 + " " + this.KMa.getName();
        }
      }
      localObject1 = localObject2;
      if (this.KMb != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(this.KMb.getName())) {
          localObject1 = (String)localObject2 + " " + this.KMb.getName();
        }
      }
      this.KMc.setText((CharSequence)localObject1);
      setEnabled(true);
      setSelectable(true);
    }
  }
  
  public final void fKO()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    fKN();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    fKN();
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
    this.KMc = ((TextView)paramViewGroup.findViewById(2131307140));
    this.fUR = ((TextView)paramViewGroup.findViewById(2131305193));
    this.KMd = ((ImageView)paramViewGroup.findViewById(2131305202));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */