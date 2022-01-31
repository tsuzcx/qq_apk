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
  private LayoutInflater mInflater;
  private LinearLayout pyh;
  private List<String> pyi;
  private int pyj;
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23316);
    this.pyj = -1;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2130970179);
    AppMethodBeat.o(23316);
  }
  
  private void Bu(int paramInt)
  {
    AppMethodBeat.i(23322);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2130969218, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
    localImageView.setImageResource(paramInt);
    this.pyh.addView(localImageView, localLayoutParams);
    AppMethodBeat.o(23322);
  }
  
  private void Xa(String paramString)
  {
    AppMethodBeat.i(23323);
    CdnImageView localCdnImageView = new CdnImageView(this.mContext);
    localCdnImageView.setUrl(paramString);
    paramString = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    paramString.rightMargin = a.fromDPToPix(this.mContext, 6);
    this.pyh.addView(localCdnImageView, paramString);
    AppMethodBeat.o(23323);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(23321);
    if (this.pyh == null)
    {
      AppMethodBeat.o(23321);
      return;
    }
    this.pyh.removeAllViews();
    if (this.pyj >= 0)
    {
      int i = this.pyj;
      int j = 0;
      if (j < 5)
      {
        if (i <= 0) {
          Bu(2131230984);
        }
        for (;;)
        {
          j += 1;
          break;
          if (i <= 10)
          {
            Bu(2131230982);
            i -= 20;
          }
          else
          {
            Bu(2131230983);
            i -= 20;
          }
        }
      }
      AppMethodBeat.o(23321);
      return;
    }
    if (this.pyi != null)
    {
      Iterator localIterator = this.pyi.iterator();
      while (localIterator.hasNext()) {
        Xa((String)localIterator.next());
      }
    }
    AppMethodBeat.o(23321);
  }
  
  public final void Bt(int paramInt)
  {
    AppMethodBeat.i(23319);
    if (paramInt == this.pyj)
    {
      AppMethodBeat.o(23319);
      return;
    }
    this.pyj = paramInt;
    bJ();
    AppMethodBeat.o(23319);
  }
  
  public final void cA(List<String> paramList)
  {
    AppMethodBeat.i(23320);
    this.pyi = paramList;
    bJ();
    AppMethodBeat.o(23320);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23318);
    super.onBindView(paramView);
    this.pyh = ((LinearLayout)paramView.findViewById(2131821890));
    bJ();
    AppMethodBeat.o(23318);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23317);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2130969253, localViewGroup);
    AppMethodBeat.o(23317);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference
 * JD-Core Version:    0.7.0.1
 */