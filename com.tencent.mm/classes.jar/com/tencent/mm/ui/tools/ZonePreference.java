package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference
  extends Preference
{
  RegionCodeDecoder.Region Ayo;
  private CharSequence Ayp;
  private TextView Ayq;
  
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
    AppMethodBeat.i(35008);
    setLayoutResource(2130970179);
    AppMethodBeat.o(35008);
  }
  
  private void dOd()
  {
    AppMethodBeat.i(35011);
    if (this.Ayq == null)
    {
      AppMethodBeat.o(35011);
      return;
    }
    if ((this.Ayp != null) && (!ah.isNullOrNil(this.Ayp.toString()))) {
      this.Ayq.setVisibility(0);
    }
    for (;;)
    {
      this.Ayq.setText(this.Ayp);
      AppMethodBeat.o(35011);
      return;
      this.Ayq.setVisibility(8);
    }
  }
  
  public final void a(RegionCodeDecoder.Region paramRegion)
  {
    AppMethodBeat.i(35009);
    if ((paramRegion == null) || (ah.isNullOrNil(paramRegion.getName())) || (ah.isNullOrNil(paramRegion.getCode())))
    {
      ab.e("MicroMsg.ZonePreference", "setZoneItem item = null");
      AppMethodBeat.o(35009);
      return;
    }
    setKey(paramRegion.getCode() + paramRegion.isCity());
    this.Ayo = paramRegion;
    AppMethodBeat.o(35009);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(35013);
    super.onBindView(paramView);
    if (this.Ayo == null)
    {
      AppMethodBeat.o(35013);
      return;
    }
    ((TextView)paramView.findViewById(2131826226)).setText(this.Ayo.getName());
    this.Ayq = ((TextView)paramView.findViewById(2131826229));
    dOd();
    AppMethodBeat.o(35013);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35012);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970222, localViewGroup);
    AppMethodBeat.o(35012);
    return paramViewGroup;
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35010);
    this.Ayp = paramCharSequence;
    dOd();
    AppMethodBeat.o(35010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZonePreference
 * JD-Core Version:    0.7.0.1
 */