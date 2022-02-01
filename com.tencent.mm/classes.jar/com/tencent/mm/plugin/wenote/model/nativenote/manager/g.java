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
  public a BDZ;
  public View mParentView;
  public PopupWindow onq;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(30472);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496103, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.onq = new PopupWindow(paramContext, -2, -2, false);
    this.onq.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30468);
        g.this.onq.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.BDZ != null) {
          g.this.BDZ.bRN();
        }
        AppMethodBeat.o(30468);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30469);
        g.this.onq.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.BDZ != null) {
          g.this.BDZ.bRO();
        }
        AppMethodBeat.o(30469);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30470);
        g.this.onq.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.BDZ != null) {
          g.this.BDZ.bRP();
        }
        AppMethodBeat.o(30470);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30471);
        g.this.onq.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.BDZ != null) {
          g.this.BDZ.bRQ();
        }
        AppMethodBeat.o(30471);
      }
    });
    AppMethodBeat.o(30472);
  }
  
  public static abstract interface a
  {
    public abstract void bRN();
    
    public abstract void bRO();
    
    public abstract void bRP();
    
    public abstract void bRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */