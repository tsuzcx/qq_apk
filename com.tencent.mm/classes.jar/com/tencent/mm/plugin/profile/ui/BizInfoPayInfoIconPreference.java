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
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class BizInfoPayInfoIconPreference
  extends Preference
{
  private LinearLayout Bdo;
  private List<String> Bdp;
  private int Bdq;
  private LayoutInflater mInflater;
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26936);
    this.Bdq = -1;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2131495538);
    AppMethodBeat.o(26936);
  }
  
  private void UB(int paramInt)
  {
    AppMethodBeat.i(26942);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2131493721, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
    localImageView.setImageResource(paramInt);
    this.Bdo.addView(localImageView, localLayoutParams);
    AppMethodBeat.o(26942);
  }
  
  private void aKn(String paramString)
  {
    AppMethodBeat.i(26943);
    CdnImageView localCdnImageView = new CdnImageView(this.mContext);
    localCdnImageView.setUrl(paramString);
    paramString = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    paramString.rightMargin = a.fromDPToPix(this.mContext, 6);
    this.Bdo.addView(localCdnImageView, paramString);
    AppMethodBeat.o(26943);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(26941);
    if (this.Bdo == null)
    {
      AppMethodBeat.o(26941);
      return;
    }
    this.Bdo.removeAllViews();
    if (this.Bdq >= 0)
    {
      int i = this.Bdq;
      int j = 0;
      if (j < 5)
      {
        if (i <= 0) {
          UB(2131689776);
        }
        for (;;)
        {
          j += 1;
          break;
          if (i <= 10)
          {
            UB(2131689774);
            i -= 20;
          }
          else
          {
            UB(2131689775);
            i -= 20;
          }
        }
      }
      AppMethodBeat.o(26941);
      return;
    }
    if (this.Bdp != null)
    {
      Iterator localIterator = this.Bdp.iterator();
      while (localIterator.hasNext()) {
        aKn((String)localIterator.next());
      }
    }
    AppMethodBeat.o(26941);
  }
  
  public final void UA(int paramInt)
  {
    AppMethodBeat.i(26939);
    if (paramInt == this.Bdq)
    {
      AppMethodBeat.o(26939);
      return;
    }
    this.Bdq = paramInt;
    updateView();
    AppMethodBeat.o(26939);
  }
  
  public final void fR(List<String> paramList)
  {
    AppMethodBeat.i(26940);
    this.Bdp = paramList;
    updateView();
    AppMethodBeat.o(26940);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26938);
    super.onBindView(paramView);
    this.Bdo = ((LinearLayout)paramView.findViewById(2131308767));
    updateView();
    AppMethodBeat.o(26938);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26937);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2131493771, localViewGroup);
    AppMethodBeat.o(26937);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference
 * JD-Core Version:    0.7.0.1
 */