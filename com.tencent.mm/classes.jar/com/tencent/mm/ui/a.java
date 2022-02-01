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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a
{
  private ImageView Gmy;
  private View JoP;
  private ImageView OwD;
  public ViewGroup OwE;
  public WeImageView OwF;
  public TextView OwG;
  public ViewGroup OwH;
  public WeImageView OwI;
  public ImageView OwJ;
  public ImageView OwK;
  private ImageView OwL;
  public ImageView OwM;
  private View OwN;
  private ImageView hNZ;
  public TextView jVO;
  
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
      this.jVO = ((TextView)paramView.findViewById(2131309202));
      this.OwD = ((ImageView)paramView.findViewById(2131309234));
      this.OwE = ((ViewGroup)paramView.findViewById(2131309204));
      this.OwF = ((WeImageView)paramView.findViewById(2131309203));
      this.OwG = ((TextView)paramView.findViewById(2131308718));
      this.OwH = ((ViewGroup)paramView.findViewById(2131308720));
      this.OwI = ((WeImageView)paramView.findViewById(2131308719));
      this.Gmy = ((ImageView)paramView.findViewById(2131305120));
      this.OwJ = ((ImageView)paramView.findViewById(2131301690));
      this.OwK = ((ImageView)paramView.findViewById(2131305879));
      this.OwL = ((ImageView)paramView.findViewById(2131306328));
      this.JoP = paramView.findViewById(2131297046);
      this.hNZ = ((ImageView)paramView.findViewById(2131297047));
      this.OwM = ((ImageView)paramView.findViewById(2131306820));
      this.OwN = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void AR(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.Gmy;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void AS(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.OwL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141269);
      return;
    }
  }
  
  public final void ap(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205098);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      this.OwG.setVisibility(8);
      AppMethodBeat.o(205098);
      return;
    }
    this.OwG.setVisibility(0);
    this.OwG.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.jk(this.OwG.getContext()))
    {
      this.OwG.setTextSize(1, 14.0F);
      this.jVO.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(205098);
  }
  
  public final void gGI()
  {
    AppMethodBeat.i(205099);
    if (this.hNZ != null) {
      this.hNZ.setImageResource(2131689492);
    }
    AppMethodBeat.o(205099);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.JoP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.jVO.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.jk(this.jVO.getContext())) {
      this.jVO.setTextSize(0, com.tencent.mm.cb.a.aH(this.jVO.getContext(), 2131165186) * com.tencent.mm.cb.a.ji(this.jVO.getContext()));
    }
    AppMethodBeat.o(141267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */