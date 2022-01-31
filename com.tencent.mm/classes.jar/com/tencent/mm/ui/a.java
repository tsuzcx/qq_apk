package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public TextView gpL;
  private ImageView lzc;
  private ImageView tit;
  private View vlC;
  public TextView yTn;
  public ImageView yTo;
  public ImageView yTp;
  private ImageView yTq;
  public ImageView yTr;
  private View yTs;
  
  public a(View paramView)
  {
    AppMethodBeat.i(105936);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      this.gpL = ((TextView)paramView.findViewById(2131820981));
      this.yTn = ((TextView)paramView.findViewById(2131820982));
      this.tit = ((ImageView)paramView.findViewById(2131820984));
      this.yTo = ((ImageView)paramView.findViewById(2131820983));
      this.yTp = ((ImageView)paramView.findViewById(2131820985));
      this.yTq = ((ImageView)paramView.findViewById(2131820986));
      this.vlC = paramView.findViewById(2131820979);
      this.lzc = ((ImageView)paramView.findViewById(2131820980));
      this.yTr = ((ImageView)paramView.findViewById(2131820987));
      this.yTs = paramView;
      AppMethodBeat.o(105936);
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(105940);
    this.vlC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(105940);
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    ImageView localImageView = this.tit;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(105938);
      return;
    }
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(105939);
    ImageView localImageView = this.yTq;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(105939);
      return;
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105937);
    this.gpL.setText(paramCharSequence);
    if (com.tencent.mm.cb.a.gt(this.gpL.getContext())) {
      this.gpL.setTextSize(0, com.tencent.mm.cb.a.ap(this.gpL.getContext(), 2131427493) * com.tencent.mm.cb.a.gr(this.gpL.getContext()));
    }
    AppMethodBeat.o(105937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */