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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
{
  private ImageView Buu;
  private View EhE;
  private ImageView ISc;
  public ViewGroup ISd;
  public WeImageView ISe;
  public TextView ISf;
  public ViewGroup ISg;
  public WeImageView ISh;
  public ImageView ISi;
  public ImageView ISj;
  private ImageView ISk;
  public ImageView ISl;
  private View ISm;
  private ImageView gSx;
  public TextView iVq;
  
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
      this.iVq = ((TextView)paramView.findViewById(2131305908));
      this.ISc = ((ImageView)paramView.findViewById(2131305936));
      this.ISd = ((ViewGroup)paramView.findViewById(2131308035));
      this.ISe = ((WeImageView)paramView.findViewById(2131308034));
      this.ISf = ((TextView)paramView.findViewById(2131305509));
      this.ISg = ((ViewGroup)paramView.findViewById(2131308013));
      this.ISh = ((WeImageView)paramView.findViewById(2131308012));
      this.Buu = ((ImageView)paramView.findViewById(2131302623));
      this.ISi = ((ImageView)paramView.findViewById(2131300216));
      this.ISj = ((ImageView)paramView.findViewById(2131303211));
      this.ISk = ((ImageView)paramView.findViewById(2131303553));
      this.EhE = paramView.findViewById(2131296939);
      this.gSx = ((ImageView)paramView.findViewById(2131296940));
      this.ISl = ((ImageView)paramView.findViewById(2131303966));
      this.ISm = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(186435);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      this.ISf.setVisibility(8);
      AppMethodBeat.o(186435);
      return;
    }
    this.ISf.setVisibility(0);
    this.ISf.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.im(this.ISf.getContext()))
    {
      this.ISf.setTextSize(1, 14.0F);
      this.iVq.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(186435);
  }
  
  public final void fuT()
  {
    AppMethodBeat.i(186436);
    if (this.gSx != null) {
      this.gSx.setImageResource(2131689490);
    }
    AppMethodBeat.o(186436);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.EhE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.iVq.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.im(this.iVq.getContext())) {
      this.iVq.setTextSize(0, com.tencent.mm.cc.a.ay(this.iVq.getContext(), 2131165184) * com.tencent.mm.cc.a.ik(this.iVq.getContext()));
    }
    AppMethodBeat.o(141267);
  }
  
  public final void wV(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.Buu;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void wW(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.ISk;
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