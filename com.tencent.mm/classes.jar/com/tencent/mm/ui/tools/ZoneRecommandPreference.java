package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  private TextView LiA;
  private ImageView LiB;
  RegionCodeDecoder.Region Lix;
  RegionCodeDecoder.Region Liy;
  RegionCodeDecoder.Region Liz;
  private TextView fWX;
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
  
  final void fPg()
  {
    AppMethodBeat.i(39214);
    if ((this.LiA == null) || (this.fWX == null))
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
      this.LiA.setVisibility(8);
      this.fWX.setVisibility(0);
      this.fWX.setText(2131763147);
      this.LiB.setImageResource(2131690294);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.LiA.setVisibility(8);
      this.fWX.setVisibility(0);
      this.fWX.setText(2131763144);
      this.LiB.setImageResource(2131690293);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(39214);
      return;
      this.LiA.setVisibility(0);
      this.fWX.setVisibility(8);
      this.LiB.setImageResource(2131690294);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.Lix != null)
      {
        localObject1 = localObject2;
        if (!bu.isNullOrNil(this.Lix.getName())) {
          localObject1 = "" + this.Lix.getName();
        }
      }
      localObject2 = localObject1;
      if (this.Liy != null)
      {
        localObject2 = localObject1;
        if (!bu.isNullOrNil(this.Liy.getName())) {
          localObject2 = (String)localObject1 + " " + this.Liy.getName();
        }
      }
      localObject1 = localObject2;
      if (this.Liz != null)
      {
        localObject1 = localObject2;
        if (!bu.isNullOrNil(this.Liz.getName())) {
          localObject1 = (String)localObject2 + " " + this.Liz.getName();
        }
      }
      this.LiA.setText((CharSequence)localObject1);
      setEnabled(true);
      setSelectable(true);
    }
  }
  
  public final void fPh()
  {
    AppMethodBeat.i(39215);
    this.status = 2;
    fPg();
    AppMethodBeat.o(39215);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39213);
    super.onBindView(paramView);
    fPg();
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
    this.LiA = ((TextView)paramViewGroup.findViewById(2131307140));
    this.fWX = ((TextView)paramViewGroup.findViewById(2131305193));
    this.LiB = ((ImageView)paramViewGroup.findViewById(2131305202));
    AppMethodBeat.o(39212);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */