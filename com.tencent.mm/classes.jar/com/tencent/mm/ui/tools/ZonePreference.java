package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  RegionCodeDecoder.Region IUS;
  private CharSequence IUT;
  private TextView IUU;
  
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
  
  private void ftZ()
  {
    AppMethodBeat.i(39208);
    if (this.IUU == null)
    {
      AppMethodBeat.o(39208);
      return;
    }
    if ((this.IUT != null) && (!bs.isNullOrNil(this.IUT.toString()))) {
      this.IUU.setVisibility(0);
    }
    for (;;)
    {
      this.IUU.setText(this.IUT);
      AppMethodBeat.o(39208);
      return;
      this.IUU.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    AppMethodBeat.i(39206);
    if ((paramRegion == null) || (bs.isNullOrNil(paramRegion.getName())) || (bs.isNullOrNil(paramRegion.getCode())))
    {
      ac.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      AppMethodBeat.o(39206);
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.IUS = paramRegion;
    AppMethodBeat.o(39206);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39210);
    super.onBindView(paramView);
    if (this.IUS == null)
    {
      AppMethodBeat.o(39210);
      return;
    }
    ((TextView)paramView.findViewById(2131307140)).setText(this.IUS.getName());
    this.IUU = ((TextView)paramView.findViewById(2131305556));
    ftZ();
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
    this.IUT = paramCharSequence;
    ftZ();
    AppMethodBeat.o(39207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */