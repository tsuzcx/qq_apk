package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;

public class RadioBelowSummarytAndIconPreference
  extends Preference
{
  private LinearLayout BkV;
  private ImageView BkW;
  private View BkX;
  View.OnClickListener BkY;
  int acJ;
  private View mView;
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.acJ = 0;
  }
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69580);
    this.acJ = 0;
    setLayoutResource(2131494804);
    AppMethodBeat.o(69580);
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(69582);
    super.onBindView(paramView);
    aam(8);
    if ((this.BkW != null) && (this.BkY != null) && (!bs.jl(0, this.acJ)))
    {
      this.BkW.setImageResource(this.acJ);
      this.BkW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(69578);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)RadioBelowSummarytAndIconPreference.a(RadioBelowSummarytAndIconPreference.this).getLayoutParams();
          localLayoutParams.leftMargin = paramView.findViewById(16908304).getWidth();
          RadioBelowSummarytAndIconPreference.a(RadioBelowSummarytAndIconPreference.this).setLayoutParams(localLayoutParams);
          AppMethodBeat.o(69578);
        }
      });
      this.BkX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69579);
          RadioBelowSummarytAndIconPreference.b(RadioBelowSummarytAndIconPreference.this).onClick(paramAnonymousView);
          AppMethodBeat.o(69579);
        }
      });
    }
    while (this.BkV != null) {
      if (this.HFU != 0)
      {
        this.BkV.removeAllViews();
        View.inflate(this.mContext, this.HFU, this.BkV);
        AppMethodBeat.o(69582);
        return;
        if (this.BkW != null) {
          this.BkW.setVisibility(8);
        }
      }
      else
      {
        this.BkV.setVisibility(8);
      }
    }
    AppMethodBeat.o(69582);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69581);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      this.BkV = ((LinearLayout)paramViewGroup.findViewById(16908312));
      View.inflate(this.mContext, 2131494890, localViewGroup);
      this.BkW = ((ImageView)localViewGroup.findViewById(2131305551));
      this.BkX = localViewGroup.findViewById(2131305549);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(69581);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference
 * JD-Core Version:    0.7.0.1
 */