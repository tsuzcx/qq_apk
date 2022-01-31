package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference
  extends Preference
{
  RegionCodeDecoder.Region Ayr;
  RegionCodeDecoder.Region Ays;
  RegionCodeDecoder.Region Ayt;
  private TextView Ayu;
  private ImageView Ayv;
  private TextView gpr;
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
    AppMethodBeat.i(35014);
    this.status = 0;
    setLayoutResource(2130970179);
    AppMethodBeat.o(35014);
  }
  
  final void dOe()
  {
    AppMethodBeat.i(35017);
    if ((this.Ayu == null) || (this.gpr == null))
    {
      AppMethodBeat.o(35017);
      return;
    }
    switch (this.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35017);
      return;
      this.Ayu.setVisibility(8);
      this.gpr.setVisibility(0);
      this.gpr.setText(2131303181);
      this.Ayv.setImageResource(2131231403);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(35017);
      return;
      this.Ayu.setVisibility(8);
      this.gpr.setVisibility(0);
      this.gpr.setText(2131303178);
      this.Ayv.setImageResource(2131231402);
      setEnabled(false);
      setSelectable(false);
      AppMethodBeat.o(35017);
      return;
      this.Ayu.setVisibility(0);
      this.gpr.setVisibility(8);
      this.Ayv.setImageResource(2131231403);
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.Ayr != null)
      {
        localObject1 = localObject2;
        if (!ah.isNullOrNil(this.Ayr.getName())) {
          localObject1 = "" + this.Ayr.getName();
        }
      }
      localObject2 = localObject1;
      if (this.Ays != null)
      {
        localObject2 = localObject1;
        if (!ah.isNullOrNil(this.Ays.getName())) {
          localObject2 = (String)localObject1 + " " + this.Ays.getName();
        }
      }
      localObject1 = localObject2;
      if (this.Ayt != null)
      {
        localObject1 = localObject2;
        if (!ah.isNullOrNil(this.Ayt.getName())) {
          localObject1 = (String)localObject2 + " " + this.Ayt.getName();
        }
      }
      this.Ayu.setText((CharSequence)localObject1);
      setEnabled(true);
      setSelectable(true);
    }
  }
  
  public final void dOf()
  {
    AppMethodBeat.i(35018);
    this.status = 2;
    dOe();
    AppMethodBeat.o(35018);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(35016);
    super.onBindView(paramView);
    dOe();
    AppMethodBeat.o(35016);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35015);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970223, localViewGroup);
    this.Ayu = ((TextView)paramViewGroup.findViewById(2131826226));
    this.gpr = ((TextView)paramViewGroup.findViewById(2131826231));
    this.Ayv = ((ImageView)paramViewGroup.findViewById(2131826230));
    AppMethodBeat.o(35015);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneRecommandPreference
 * JD-Core Version:    0.7.0.1
 */