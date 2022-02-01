package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private View BlI;
  private TextView FFJ;
  public ImageView FFK;
  public ImageView FFL;
  private ImageView FFM;
  public ImageView FFN;
  private View FFO;
  public TextView ica;
  private ImageView oPR;
  private ImageView yOS;
  
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
      this.ica = ((TextView)paramView.findViewById(2131305908));
      this.FFJ = ((TextView)paramView.findViewById(2131305509));
      this.yOS = ((ImageView)paramView.findViewById(2131302623));
      this.FFK = ((ImageView)paramView.findViewById(2131300216));
      this.FFL = ((ImageView)paramView.findViewById(2131303211));
      this.FFM = ((ImageView)paramView.findViewById(2131303553));
      this.BlI = paramView.findViewById(2131296939);
      this.oPR = ((ImageView)paramView.findViewById(2131296940));
      this.FFN = ((ImageView)paramView.findViewById(2131303966));
      this.FFO = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void ak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190968);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      this.FFJ.setVisibility(8);
      AppMethodBeat.o(190968);
      return;
    }
    this.FFJ.setVisibility(0);
    this.FFJ.setText(paramCharSequence);
    if (com.tencent.mm.cd.a.hS(this.FFJ.getContext()))
    {
      this.FFJ.setTextSize(1, 14.0F);
      this.ica.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(190968);
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.BlI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.ica.setText(paramCharSequence);
    if (com.tencent.mm.cd.a.hS(this.ica.getContext())) {
      this.ica.setTextSize(0, com.tencent.mm.cd.a.ap(this.ica.getContext(), 2131165184) * com.tencent.mm.cd.a.hQ(this.ica.getContext()));
    }
    AppMethodBeat.o(141267);
  }
  
  public final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.yOS;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.FFM;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141269);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */