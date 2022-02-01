package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class BizInfoPayInfoIconPreference
  extends Preference
{
  private LayoutInflater mInflater;
  private LinearLayout vIK;
  private List<String> vIL;
  private int vIM;
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26936);
    this.vIM = -1;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2131494804);
    AppMethodBeat.o(26936);
  }
  
  private void Lg(int paramInt)
  {
    AppMethodBeat.i(26942);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2131493604, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
    localImageView.setImageResource(paramInt);
    this.vIK.addView(localImageView, localLayoutParams);
    AppMethodBeat.o(26942);
  }
  
  private void apA(String paramString)
  {
    AppMethodBeat.i(26943);
    CdnImageView localCdnImageView = new CdnImageView(this.mContext);
    localCdnImageView.setUrl(paramString);
    paramString = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    paramString.rightMargin = a.fromDPToPix(this.mContext, 6);
    this.vIK.addView(localCdnImageView, paramString);
    AppMethodBeat.o(26943);
  }
  
  private void cL()
  {
    AppMethodBeat.i(26941);
    if (this.vIK == null)
    {
      AppMethodBeat.o(26941);
      return;
    }
    this.vIK.removeAllViews();
    if (this.vIM >= 0)
    {
      int i = this.vIM;
      int j = 0;
      if (j < 5)
      {
        if (i <= 0) {
          Lg(2131689766);
        }
        for (;;)
        {
          j += 1;
          break;
          if (i <= 10)
          {
            Lg(2131689764);
            i -= 20;
          }
          else
          {
            Lg(2131689765);
            i -= 20;
          }
        }
      }
      AppMethodBeat.o(26941);
      return;
    }
    if (this.vIL != null)
    {
      Iterator localIterator = this.vIL.iterator();
      while (localIterator.hasNext()) {
        apA((String)localIterator.next());
      }
    }
    AppMethodBeat.o(26941);
  }
  
  public final void Lf(int paramInt)
  {
    AppMethodBeat.i(26939);
    if (paramInt == this.vIM)
    {
      AppMethodBeat.o(26939);
      return;
    }
    this.vIM = paramInt;
    cL();
    AppMethodBeat.o(26939);
  }
  
  public final void eB(List<String> paramList)
  {
    AppMethodBeat.i(26940);
    this.vIL = paramList;
    cL();
    AppMethodBeat.o(26940);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26938);
    super.onBindView(paramView);
    this.vIK = ((LinearLayout)paramView.findViewById(2131305546));
    cL();
    AppMethodBeat.o(26938);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26937);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2131493641, localViewGroup);
    AppMethodBeat.o(26937);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference
 * JD-Core Version:    0.7.0.1
 */