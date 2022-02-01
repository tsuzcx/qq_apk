package com.tencent.mm.ui;

import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
{
  private ImageView BLS;
  private View EzI;
  private ImageView JmK;
  public ViewGroup JmL;
  public WeImageView JmM;
  public TextView JmN;
  public ViewGroup JmO;
  public WeImageView JmP;
  public ImageView JmQ;
  public ImageView JmR;
  private ImageView JmS;
  public ImageView JmT;
  private View JmU;
  private ImageView gVf;
  public TextView iYj;
  
  public a(View paramView)
  {
    AppMethodBeat.i(141266);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      this.iYj = ((TextView)paramView.findViewById(2131305908));
      this.JmK = ((ImageView)paramView.findViewById(2131305936));
      this.JmL = ((ViewGroup)paramView.findViewById(2131308035));
      this.JmM = ((WeImageView)paramView.findViewById(2131308034));
      this.JmN = ((TextView)paramView.findViewById(2131305509));
      this.JmO = ((ViewGroup)paramView.findViewById(2131308013));
      this.JmP = ((WeImageView)paramView.findViewById(2131308012));
      this.BLS = ((ImageView)paramView.findViewById(2131302623));
      this.JmQ = ((ImageView)paramView.findViewById(2131300216));
      this.JmR = ((ImageView)paramView.findViewById(2131303211));
      this.JmS = ((ImageView)paramView.findViewById(2131303553));
      this.EzI = paramView.findViewById(2131296939);
      this.gVf = ((ImageView)paramView.findViewById(2131296940));
      this.JmT = ((ImageView)paramView.findViewById(2131303966));
      this.JmU = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void ak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193688);
    if ((paramCharSequence == null) || (bu.isNullOrNil(paramCharSequence.toString())))
    {
      this.JmN.setVisibility(8);
      AppMethodBeat.o(193688);
      return;
    }
    this.JmN.setVisibility(0);
    this.JmN.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.ir(this.JmN.getContext()))
    {
      this.JmN.setTextSize(1, 14.0F);
      this.iYj.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(193688);
  }
  
  public final void fyU()
  {
    AppMethodBeat.i(193689);
    if (this.gVf != null) {
      this.gVf.setImageResource(2131689490);
    }
    AppMethodBeat.o(193689);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.EzI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.iYj.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.ir(this.iYj.getContext())) {
      this.iYj.setTextSize(0, com.tencent.mm.cb.a.ay(this.iYj.getContext(), 2131165184) * com.tencent.mm.cb.a.ip(this.iYj.getContext()));
    }
    AppMethodBeat.o(141267);
  }
  
  public final void xd(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.BLS;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void xe(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.JmS;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141269);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */