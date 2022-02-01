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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class BizInfoPayInfoIconPreference
  extends Preference
{
  private LinearLayout MVk;
  private List<String> MVl;
  private int MVm;
  private LayoutInflater mInflater;
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26936);
    this.MVm = -1;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(26936);
  }
  
  private void aRU(String paramString)
  {
    AppMethodBeat.i(26943);
    CdnImageView localCdnImageView = new CdnImageView(this.mContext);
    localCdnImageView.setUrl(paramString);
    paramString = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    paramString.rightMargin = a.fromDPToPix(this.mContext, 6);
    this.MVk.addView(localCdnImageView, paramString);
    AppMethodBeat.o(26943);
  }
  
  private void afG(int paramInt)
  {
    AppMethodBeat.i(26942);
    ImageView localImageView = (ImageView)this.mInflater.inflate(R.i.ghL, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
    localImageView.setImageResource(paramInt);
    this.MVk.addView(localImageView, localLayoutParams);
    AppMethodBeat.o(26942);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(26941);
    if (this.MVk == null)
    {
      AppMethodBeat.o(26941);
      return;
    }
    this.MVk.removeAllViews();
    if (this.MVm >= 0)
    {
      int i = this.MVm;
      int j = 0;
      if (j < 5)
      {
        if (i <= 0) {
          afG(R.k.biz_info_brand_unselect);
        }
        for (;;)
        {
          j += 1;
          break;
          if (i <= 10)
          {
            afG(R.k.biz_info_brand_half_selected);
            i -= 20;
          }
          else
          {
            afG(R.k.biz_info_brand_selected);
            i -= 20;
          }
        }
      }
      AppMethodBeat.o(26941);
      return;
    }
    if (this.MVl != null)
    {
      Iterator localIterator = this.MVl.iterator();
      while (localIterator.hasNext()) {
        aRU((String)localIterator.next());
      }
    }
    AppMethodBeat.o(26941);
  }
  
  public final void afF(int paramInt)
  {
    AppMethodBeat.i(26939);
    if (paramInt == this.MVm)
    {
      AppMethodBeat.o(26939);
      return;
    }
    this.MVm = paramInt;
    updateView();
    AppMethodBeat.o(26939);
  }
  
  public final void jv(List<String> paramList)
  {
    AppMethodBeat.i(26940);
    this.MVl = paramList;
    updateView();
    AppMethodBeat.o(26940);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26938);
    super.onBindView(paramView);
    this.MVk = ((LinearLayout)paramView.findViewById(R.h.summary));
    updateView();
    AppMethodBeat.o(26938);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26937);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(R.i.gil, localViewGroup);
    AppMethodBeat.o(26937);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference
 * JD-Core Version:    0.7.0.1
 */