package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  RegionCodeDecoder.Region Huv;
  private CharSequence Huw;
  private TextView Hux;
  
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
    AppMethodBeat.i(39205);
    setLayoutResource(2131494804);
    AppMethodBeat.o(39205);
  }
  
  private void fee()
  {
    AppMethodBeat.i(39208);
    if (this.Hux == null)
    {
      AppMethodBeat.o(39208);
      return;
    }
    if ((this.Huw != null) && (!bt.isNullOrNil(this.Huw.toString()))) {
      this.Hux.setVisibility(0);
    }
    for (;;)
    {
      this.Hux.setText(this.Huw);
      AppMethodBeat.o(39208);
      return;
      this.Hux.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    AppMethodBeat.i(39206);
    if ((paramRegion == null) || (bt.isNullOrNil(paramRegion.getName())) || (bt.isNullOrNil(paramRegion.getCode())))
    {
      ad.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      AppMethodBeat.o(39206);
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.Huv = paramRegion;
    AppMethodBeat.o(39206);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39210);
    super.onBindView(paramView);
    if (this.Huv == null)
    {
      AppMethodBeat.o(39210);
      return;
    }
    ((TextView)paramView.findViewById(2131307140)).setText(this.Huv.getName());
    this.Hux = ((TextView)paramView.findViewById(2131305556));
    fee();
    AppMethodBeat.o(39210);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39209);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494849, localViewGroup);
    AppMethodBeat.o(39209);
    return paramViewGroup;
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39207);
    this.Huw = paramCharSequence;
    fee();
    AppMethodBeat.o(39207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */