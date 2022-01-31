package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public View mParentView;
  public PopupWindow vyE;
  public g.a vyF;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(26779);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2130971320, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.vyE = new PopupWindow(paramContext, -2, -2, false);
    this.vyE.setClippingEnabled(false);
    paramContext.findViewById(2131829587).setOnClickListener(new g.1(this));
    paramContext.findViewById(2131829588).setOnClickListener(new g.2(this));
    paramContext.findViewById(2131829589).setOnClickListener(new g.3(this));
    paramContext.findViewById(2131829590).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26778);
        g.this.vyE.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.vyF != null) {
          g.this.vyF.diH();
        }
        AppMethodBeat.o(26778);
      }
    });
    AppMethodBeat.o(26779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */