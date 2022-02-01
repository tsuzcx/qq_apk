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
  private String GVh;
  private TextView GVi;
  private TextView GVj;
  private TextView GVk;
  private boolean paC;
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
    this.paC = false;
    this.title = "";
    this.GVh = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.GVi = ((TextView)paramView.findViewById(2131300107));
    this.GVj = ((TextView)paramView.findViewById(2131304458));
    this.GVk = ((TextView)paramView.findViewById(2131305768));
    this.paC = true;
    if (!this.paC)
    {
      ad.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(bt.nullAsNil(this.title));
    String[] arrayOfString = this.GVh.split(";");
    if (bt.nullAsNil(this.GVh).length() <= 0)
    {
      this.GVi.setVisibility(8);
      this.GVj.setVisibility(8);
    }
    label259:
    for (;;)
    {
      this.GVk.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.GVi.setVisibility(0);
        this.GVi.setText(bt.nullAsNil(arrayOfString[0]));
        label180:
        if (arrayOfString.length <= 1) {
          break label249;
        }
        this.GVj.setVisibility(0);
        this.GVj.setText(bt.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label259;
        }
        this.GVk.setVisibility(0);
        this.GVk.setText(bt.nullAsNil(arrayOfString[2]));
        break;
        this.GVi.setVisibility(8);
        break label180;
        label249:
        this.GVj.setVisibility(8);
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