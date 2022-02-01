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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class RadioBelowSummarytAndIconPreference
  extends Preference
{
  int abP;
  private View mView;
  private LinearLayout zSB;
  private ImageView zSC;
  private View zSD;
  View.OnClickListener zSE;
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.abP = 0;
  }
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69580);
    this.abP = 0;
    setLayoutResource(2131494804);
    AppMethodBeat.o(69580);
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(69582);
    super.onBindView(paramView);
    Yb(8);
    if ((this.zSC != null) && (this.zSE != null) && (!bt.iY(0, this.abP)))
    {
      this.zSC.setImageResource(this.abP);
      this.zSC.post(new Runnable()
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
      this.zSD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69579);
          RadioBelowSummarytAndIconPreference.b(RadioBelowSummarytAndIconPreference.this).onClick(paramAnonymousView);
          AppMethodBeat.o(69579);
        }
      });
    }
    while (this.zSB != null) {
      if (this.Gge != 0)
      {
        this.zSB.removeAllViews();
        View.inflate(this.mContext, this.Gge, this.zSB);
        AppMethodBeat.o(69582);
        return;
        if (this.zSC != null) {
          this.zSC.setVisibility(8);
        }
      }
      else
      {
        this.zSB.setVisibility(8);
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
      this.zSB = ((LinearLayout)paramViewGroup.findViewById(16908312));
      View.inflate(this.mContext, 2131494890, localViewGroup);
      this.zSC = ((ImageView)localViewGroup.findViewById(2131305551));
      this.zSD = localViewGroup.findViewById(2131305549);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(69581);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RadioBelowSummarytAndIconPreference
 * JD-Core Version:    0.7.0.1
 */