package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  private CharSequence XVA;
  private TextView XVB;
  RegionCodeDecoder.Region XVz;
  
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
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(39205);
  }
  
  private void hYK()
  {
    AppMethodBeat.i(39208);
    if (this.XVB == null)
    {
      AppMethodBeat.o(39208);
      return;
    }
    if ((this.XVA != null) && (!Util.isNullOrNil(this.XVA.toString()))) {
      this.XVB.setVisibility(0);
    }
    for (;;)
    {
      this.XVB.setText(this.XVA);
      AppMethodBeat.o(39208);
      return;
      this.XVB.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    AppMethodBeat.i(39206);
    if ((paramRegion == null) || (Util.isNullOrNil(paramRegion.getName())) || (Util.isNullOrNil(paramRegion.getCode())))
    {
      Log.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      AppMethodBeat.o(39206);
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.XVz = paramRegion;
    AppMethodBeat.o(39206);
  }
  
  public final void aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39207);
    this.XVA = paramCharSequence;
    hYK();
    AppMethodBeat.o(39207);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39210);
    super.onBindView(paramView);
    if (this.XVz == null)
    {
      AppMethodBeat.o(39210);
      return;
    }
    ((TextView)paramView.findViewById(R.h.zonename)).setText(this.XVz.getName());
    this.XVB = ((TextView)paramView.findViewById(R.h.dVT));
    hYK();
    AppMethodBeat.o(39210);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39209);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eja, localViewGroup);
    AppMethodBeat.o(39209);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */