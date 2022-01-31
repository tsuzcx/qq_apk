package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference
  extends Preference
{
  private TextView iJG;
  private Context mContext;
  private String mmp;
  private TextView pzq;
  private TextView pzr;
  private boolean pzs;
  private String pzt;
  private String pzu;
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.pzs = false;
    this.mContext = paramContext;
  }
  
  public ContactRemarkAndLabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23428);
    this.pzs = false;
    this.mContext = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(23428);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23430);
    this.iJG = ((TextView)paramView.findViewById(2131820680));
    this.pzq = ((TextView)paramView.findViewById(2131826227));
    this.pzr = ((TextView)paramView.findViewById(2131826228));
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.iJG != null) && (!bo.isNullOrNil(this.mmp)))
    {
      this.iJG.setVisibility(0);
      this.iJG.setText(this.mmp);
      localLayoutParams = (RelativeLayout.LayoutParams)this.iJG.getLayoutParams();
      localLayoutParams.width = a.ao(this.mContext, 2131427664);
      this.iJG.setLayoutParams(localLayoutParams);
    }
    if (this.pzq != null) {
      if (!this.pzs)
      {
        this.pzq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        i = 0;
        if (!bo.isNullOrNil(this.pzt))
        {
          this.pzq.setVisibility(0);
          this.pzq.setText(j.b(this.mContext, bo.nullAsNil(this.pzt), this.pzq.getTextSize()));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.pzr != null)
      {
        j = i;
        if (!bo.isNullOrNil(this.pzu))
        {
          j = i | 0x2;
          this.pzr.setVisibility(0);
          this.pzr.setText(this.pzu);
        }
      }
      if (j == 1) {
        ((RelativeLayout.LayoutParams)this.pzq.getLayoutParams()).addRule(15);
      }
      if (j == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.pzr.getLayoutParams();
        localLayoutParams.addRule(3, 0);
        localLayoutParams.addRule(15);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(23430);
      return;
      this.pzq.setVisibility(0);
      this.pzq.setCompoundDrawablesWithIntrinsicBounds(2131231080, 0, 0, 0);
      i = 1;
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23429);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970216, localViewGroup);
    AppMethodBeat.o(23429);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactRemarkAndLabelPreference
 * JD-Core Version:    0.7.0.1
 */