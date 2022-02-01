package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  RegionCodeDecoder.Region Liu;
  private CharSequence Liv;
  private TextView Liw;
  
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
  
  private void fPf()
  {
    AppMethodBeat.i(39208);
    if (this.Liw == null)
    {
      AppMethodBeat.o(39208);
      return;
    }
    if ((this.Liv != null) && (!bu.isNullOrNil(this.Liv.toString()))) {
      this.Liw.setVisibility(0);
    }
    for (;;)
    {
      this.Liw.setText(this.Liv);
      AppMethodBeat.o(39208);
      return;
      this.Liw.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    AppMethodBeat.i(39206);
    if ((paramRegion == null) || (bu.isNullOrNil(paramRegion.getName())) || (bu.isNullOrNil(paramRegion.getCode())))
    {
      ae.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      AppMethodBeat.o(39206);
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.Liu = paramRegion;
    AppMethodBeat.o(39206);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39210);
    super.onBindView(paramView);
    if (this.Liu == null)
    {
      AppMethodBeat.o(39210);
      return;
    }
    ((TextView)paramView.findViewById(2131307140)).setText(this.Liu.getName());
    this.Liw = ((TextView)paramView.findViewById(2131305556));
    fPf();
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
    this.Liv = paramCharSequence;
    fPf();
    AppMethodBeat.o(39207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */