package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class RadioBelowSummarytAndIconPreference
  extends Preference
{
  int UM;
  private View mView;
  private LinearLayout tYh;
  private ImageView tYi;
  private View tYj;
  View.OnClickListener tYk;
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.UM = 0;
  }
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142374);
    this.UM = 0;
    setLayoutResource(2130970179);
    AppMethodBeat.o(142374);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142376);
    super.onBindView(paramView);
    OW(8);
    if ((this.tYi != null) && (this.tYk != null) && (!bo.hl(0, this.UM)))
    {
      this.tYi.setImageResource(this.UM);
      this.tYi.post(new RadioBelowSummarytAndIconPreference.1(this, paramView));
      this.tYj.setOnClickListener(new RadioBelowSummarytAndIconPreference.2(this));
    }
    while (this.tYh != null) {
      if (this.zsq != 0)
      {
        this.tYh.removeAllViews();
        View.inflate(this.mContext, this.zsq, this.tYh);
        AppMethodBeat.o(142376);
        return;
        if (this.tYi != null) {
          this.tYi.setVisibility(8);
        }
      }
      else
      {
        this.tYh.setVisibility(8);
      }
    }
    AppMethodBeat.o(142376);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142375);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      this.tYh = ((LinearLayout)paramViewGroup.findViewById(16908312));
      View.inflate(this.mContext, 2130970260, localViewGroup);
      this.tYi = ((ImageView)localViewGroup.findViewById(2131826258));
      this.tYj = localViewGroup.findViewById(2131826259);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(142375);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference
 * JD-Core Version:    0.7.0.1
 */