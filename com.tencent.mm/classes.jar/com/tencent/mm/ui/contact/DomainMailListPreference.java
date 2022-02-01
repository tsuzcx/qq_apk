package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private String KIu;
  private TextView KIv;
  private TextView KIw;
  private TextView KIx;
  private boolean qnX;
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
    this.qnX = false;
    this.title = "";
    this.KIu = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(37819);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.KIv = ((TextView)paramView.findViewById(2131300107));
    this.KIw = ((TextView)paramView.findViewById(2131304458));
    this.KIx = ((TextView)paramView.findViewById(2131305768));
    this.qnX = true;
    if (!this.qnX)
    {
      ae.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(37819);
      return;
    }
    this.titleTv.setText(bu.nullAsNil(this.title));
    String[] arrayOfString = this.KIu.split(";");
    if (bu.nullAsNil(this.KIu).length() <= 0)
    {
      this.KIv.setVisibility(8);
      this.KIw.setVisibility(8);
    }
    label259:
    for (;;)
    {
      this.KIx.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.KIv.setVisibility(0);
        this.KIv.setText(bu.nullAsNil(arrayOfString[0]));
        label180:
        if (arrayOfString.length <= 1) {
          break label249;
        }
        this.KIw.setVisibility(0);
        this.KIw.setText(bu.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label259;
        }
        this.KIx.setVisibility(0);
        this.KIx.setText(bu.nullAsNil(arrayOfString[2]));
        break;
        this.KIv.setVisibility(8);
        break label180;
        label249:
        this.KIw.setVisibility(8);
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