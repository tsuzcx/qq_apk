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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;

public class RadioBelowSummarytAndIconPreference
  extends Preference
{
  private LinearLayout DcP;
  private ImageView DcQ;
  private View DcR;
  View.OnClickListener DcS;
  int aeA;
  private View mView;
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aeA = 0;
  }
  
  public RadioBelowSummarytAndIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69580);
    this.aeA = 0;
    setLayoutResource(2131494804);
    AppMethodBeat.o(69580);
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(69582);
    super.onBindView(paramView);
    ade(8);
    if ((this.DcQ != null) && (this.DcS != null) && (!bu.jB(0, this.aeA)))
    {
      this.DcQ.setImageResource(this.aeA);
      this.DcQ.post(new Runnable()
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
      this.DcR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69579);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/pwd/ui/RadioBelowSummarytAndIconPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RadioBelowSummarytAndIconPreference.b(RadioBelowSummarytAndIconPreference.this).onClick(paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/RadioBelowSummarytAndIconPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69579);
        }
      });
    }
    while (this.DcP != null) {
      if (this.JOA != 0)
      {
        this.DcP.removeAllViews();
        View.inflate(this.mContext, this.JOA, this.DcP);
        AppMethodBeat.o(69582);
        return;
        if (this.DcQ != null) {
          this.DcQ.setVisibility(8);
        }
      }
      else
      {
        this.DcP.setVisibility(8);
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
      this.DcP = ((LinearLayout)paramViewGroup.findViewById(16908312));
      View.inflate(this.mContext, 2131494890, localViewGroup);
      this.DcQ = ((ImageView)localViewGroup.findViewById(2131305551));
      this.DcR = localViewGroup.findViewById(2131305549);
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