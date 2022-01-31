package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private String AcD;
  private TextView AcE;
  private TextView AcF;
  private TextView AcG;
  private boolean lJS;
  private String title;
  private TextView titleTv;
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33699);
    init();
    AppMethodBeat.o(33699);
  }
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33700);
    init();
    AppMethodBeat.o(33700);
  }
  
  private void init()
  {
    this.lJS = false;
    this.title = "";
    this.AcD = "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33702);
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.AcE = ((TextView)paramView.findViewById(2131826211));
    this.AcF = ((TextView)paramView.findViewById(2131826212));
    this.AcG = ((TextView)paramView.findViewById(2131826213));
    this.lJS = true;
    if (!this.lJS)
    {
      ab.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      AppMethodBeat.o(33702);
      return;
    }
    this.titleTv.setText(ah.nullAsNil(this.title));
    String[] arrayOfString = this.AcD.split(";");
    if (ah.nullAsNil(this.AcD).length() <= 0)
    {
      this.AcE.setVisibility(8);
      this.AcF.setVisibility(8);
    }
    label259:
    for (;;)
    {
      this.AcG.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.AcE.setVisibility(0);
        this.AcE.setText(ah.nullAsNil(arrayOfString[0]));
        label180:
        if (arrayOfString.length <= 1) {
          break label249;
        }
        this.AcF.setVisibility(0);
        this.AcF.setText(ah.nullAsNil(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label259;
        }
        this.AcG.setVisibility(0);
        this.AcG.setText(ah.nullAsNil(arrayOfString[2]));
        break;
        this.AcE.setVisibility(8);
        break label180;
        label249:
        this.AcF.setVisibility(8);
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33701);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970199, localViewGroup);
    AppMethodBeat.o(33701);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */