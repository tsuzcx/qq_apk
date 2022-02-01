package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private String PVs;
  private TextView PVt;
  private TextView PVu;
  private TextView PVv;
  private boolean rFe;
  private String title;
  private TextView titleTv;
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37816);
    init();
    AppMethodBeat.o(37816);
  }
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37817);
    init();
    AppMethodBeat.o(37817);
  }
  
  private void init()
  {
    this.rFe = false;
    this.title = "";
    this.PVs = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(2131309195));
    this.PVt = ((TextView)paramView.findViewById(2131301546));
    this.PVu = ((TextView)paramView.findViewById(2131307434));
    this.PVv = ((TextView)paramView.findViewById(2131309039));
    this.rFe = true;
    if (!this.rFe)
    {
      Log.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(Util.nullAsNil(this.title));
    String[] arrayOfString = this.PVs.split(";");
    if (Util.nullAsNil(this.PVs).length() <= 0)
    {
      this.PVt.setVisibility(8);
      this.PVu.setVisibility(8);
    }
    label259:
    for (;;)
    {
      this.PVv.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.PVt.setVisibility(0);
        this.PVt.setText(Util.nullAsNil(arrayOfString[0]));
        label180:
        if (arrayOfString.length <= 1) {
          break label249;
        }
        this.PVu.setVisibility(0);
        this.PVu.setText(Util.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label259;
        }
        this.PVv.setVisibility(0);
        this.PVv.setText(Util.nullAsNil(arrayOfString[2]));
        break;
        this.PVt.setVisibility(8);
        break label180;
        label249:
        this.PVu.setVisibility(8);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37818);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495560, localViewGroup);
    AppMethodBeat.o(37818);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */