package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private String Kma;
  private TextView Kmb;
  private TextView Kmc;
  private TextView Kmd;
  private boolean qhs;
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
    this.qhs = false;
    this.title = "";
    this.Kma = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.Kmb = ((TextView)paramView.findViewById(2131300107));
    this.Kmc = ((TextView)paramView.findViewById(2131304458));
    this.Kmd = ((TextView)paramView.findViewById(2131305768));
    this.qhs = true;
    if (!this.qhs)
    {
      ad.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(bt.nullAsNil(this.title));
    String[] arrayOfString = this.Kma.split(";");
    if (bt.nullAsNil(this.Kma).length() <= 0)
    {
      this.Kmb.setVisibility(8);
      this.Kmc.setVisibility(8);
    }
    label259:
    for (;;)
    {
      this.Kmd.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.Kmb.setVisibility(0);
        this.Kmb.setText(bt.nullAsNil(arrayOfString[0]));
        label180:
        if (arrayOfString.length <= 1) {
          break label249;
        }
        this.Kmc.setVisibility(0);
        this.Kmc.setText(bt.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label259;
        }
        this.Kmd.setVisibility(0);
        this.Kmd.setText(bt.nullAsNil(arrayOfString[2]));
        break;
        this.Kmb.setVisibility(8);
        break label180;
        label249:
        this.Kmc.setVisibility(8);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37818);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494826, localViewGroup);
    AppMethodBeat.o(37818);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */