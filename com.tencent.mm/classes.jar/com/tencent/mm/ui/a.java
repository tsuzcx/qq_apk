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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
{
  private ImageView AcJ;
  private View CDT;
  public ViewGroup HeM;
  public WeImageView HeN;
  public TextView HeO;
  public ViewGroup HeP;
  public WeImageView HeQ;
  public ImageView HeR;
  public ImageView HeS;
  private ImageView HeT;
  public ImageView HeU;
  private View HeV;
  private ImageView gyM;
  public TextView iCg;
  
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
      this.iCg = ((TextView)paramView.findViewById(2131305908));
      this.HeM = ((ViewGroup)paramView.findViewById(2131308035));
      this.HeN = ((WeImageView)paramView.findViewById(2131308034));
      this.HeO = ((TextView)paramView.findViewById(2131305509));
      this.HeP = ((ViewGroup)paramView.findViewById(2131308013));
      this.HeQ = ((WeImageView)paramView.findViewById(2131308012));
      this.AcJ = ((ImageView)paramView.findViewById(2131302623));
      this.HeR = ((ImageView)paramView.findViewById(2131300216));
      this.HeS = ((ImageView)paramView.findViewById(2131303211));
      this.HeT = ((ImageView)paramView.findViewById(2131303553));
      this.CDT = paramView.findViewById(2131296939);
      this.gyM = ((ImageView)paramView.findViewById(2131296940));
      this.HeU = ((ImageView)paramView.findViewById(2131303966));
      this.HeV = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197177);
    if ((paramCharSequence == null) || (bs.isNullOrNil(paramCharSequence.toString())))
    {
      this.HeO.setVisibility(8);
      AppMethodBeat.o(197177);
      return;
    }
    this.HeO.setVisibility(0);
    this.HeO.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.id(this.HeO.getContext()))
    {
      this.HeO.setTextSize(1, 14.0F);
      this.iCg.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(197177);
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.CDT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.iCg.setText(paramCharSequence);
    if (com.tencent.mm.cc.a.id(this.iCg.getContext())) {
      this.iCg.setTextSize(0, com.tencent.mm.cc.a.av(this.iCg.getContext(), 2131165184) * com.tencent.mm.cc.a.ib(this.iCg.getContext()));
    }
    AppMethodBeat.o(141267);
  }
  
  public final void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.AcJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void wk(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.HeT;
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