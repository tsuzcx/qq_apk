package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  RegionCodeDecoder.Region Qxt;
  private CharSequence Qxu;
  private TextView Qxv;
  
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
    setLayoutResource(2131495538);
    AppMethodBeat.o(39205);
  }
  
  private void gXZ()
  {
    AppMethodBeat.i(39208);
    if (this.Qxv == null)
    {
      AppMethodBeat.o(39208);
      return;
    }
    if ((this.Qxu != null) && (!Util.isNullOrNil(this.Qxu.toString()))) {
      this.Qxv.setVisibility(0);
    }
    for (;;)
    {
      this.Qxv.setText(this.Qxu);
      AppMethodBeat.o(39208);
      return;
      this.Qxv.setVisibility(8);
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
    this.Qxt = paramRegion;
    AppMethodBeat.o(39206);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39210);
    super.onBindView(paramView);
    if (this.Qxt == null)
    {
      AppMethodBeat.o(39210);
      return;
    }
    ((TextView)paramView.findViewById(2131310681)).setText(this.Qxt.getName());
    this.Qxv = ((TextView)paramView.findViewById(2131308777));
    gXZ();
    AppMethodBeat.o(39210);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39209);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495584, localViewGroup);
    AppMethodBeat.o(39209);
    return paramViewGroup;
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39207);
    this.Qxu = paramCharSequence;
    gXZ();
    AppMethodBeat.o(39207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */