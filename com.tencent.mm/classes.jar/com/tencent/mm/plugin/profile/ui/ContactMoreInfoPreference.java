package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private ImageView Bec;
  private ImageView Bed;
  private ImageView Bee;
  private ImageView Bef;
  private ImageView Beg;
  private ImageView Beh;
  private int Bei;
  private int Bej;
  private int Bek;
  private int Bel;
  private int Bem;
  private int Ben;
  private TextView qbV;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Bei = 8;
    this.Bej = 8;
    this.Bek = 8;
    this.Bel = 8;
    this.Bem = 8;
    this.Ben = 8;
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27018);
    this.Bei = 8;
    this.Bej = 8;
    this.Bek = 8;
    this.Bel = 8;
    this.Bem = 8;
    this.Ben = 8;
    setLayoutResource(2131495538);
    AppMethodBeat.o(27018);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(27025);
    if (this.Bec != null) {
      this.Bec.setVisibility(this.Bei);
    }
    if (this.Bed != null) {
      this.Bed.setVisibility(this.Bej);
    }
    if (this.Bee != null) {
      this.Bee.setVisibility(this.Bek);
    }
    if (this.Bef != null) {
      this.Bef.setVisibility(this.Bel);
    }
    if (this.Beg != null) {
      this.Beg.setVisibility(this.Bem);
    }
    if (this.qbV != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.qbV.getLayoutParams();
      localLayoutParams.width = a.aG(this.mContext, 2131165381);
      this.qbV.setLayoutParams(localLayoutParams);
    }
    if (this.Beh != null) {
      this.Beh.setVisibility(this.Ben);
    }
    AppMethodBeat.o(27025);
  }
  
  public final void UF(int paramInt)
  {
    AppMethodBeat.i(27021);
    this.Bej = paramInt;
    updateView();
    AppMethodBeat.o(27021);
  }
  
  public final void UG(int paramInt)
  {
    AppMethodBeat.i(27022);
    this.Bek = paramInt;
    updateView();
    AppMethodBeat.o(27022);
  }
  
  public final void UH(int paramInt)
  {
    AppMethodBeat.i(27023);
    this.Bem = paramInt;
    updateView();
    AppMethodBeat.o(27023);
  }
  
  public final void UI(int paramInt)
  {
    AppMethodBeat.i(27024);
    this.Ben = paramInt;
    updateView();
    AppMethodBeat.o(27024);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27020);
    this.Bec = ((ImageView)paramView.findViewById(2131302586));
    this.Bed = ((ImageView)paramView.findViewById(2131302594));
    this.Bee = ((ImageView)paramView.findViewById(2131302582));
    this.Bef = ((ImageView)paramView.findViewById(2131302557));
    this.Beg = ((ImageView)paramView.findViewById(2131302567));
    this.Beh = ((ImageView)paramView.findViewById(2131302603));
    this.qbV = ((TextView)paramView.findViewById(2131309195));
    updateView();
    super.onBindView(paramView);
    AppMethodBeat.o(27020);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27019);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495571, localViewGroup);
    AppMethodBeat.o(27019);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */