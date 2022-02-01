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
  public a CWg;
  public View mParentView;
  public PopupWindow oQQ;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(30472);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496103, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.oQQ = new PopupWindow(paramContext, -2, -2, false);
    this.oQQ.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30468);
        g.this.oQQ.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.CWg != null) {
          g.this.CWg.bZc();
        }
        AppMethodBeat.o(30468);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30469);
        g.this.oQQ.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.CWg != null) {
          g.this.CWg.bZd();
        }
        AppMethodBeat.o(30469);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30470);
        g.this.oQQ.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.CWg != null) {
          g.this.CWg.bZe();
        }
        AppMethodBeat.o(30470);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30471);
        g.this.oQQ.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.CWg != null) {
          g.this.CWg.bZf();
        }
        AppMethodBeat.o(30471);
      }
    });
    AppMethodBeat.o(30472);
  }
  
  public static abstract interface a
  {
    public abstract void bZc();
    
    public abstract void bZd();
    
    public abstract void bZe();
    
    public abstract void bZf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */