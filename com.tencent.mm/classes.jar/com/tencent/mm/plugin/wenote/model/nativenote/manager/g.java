package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class g
{
  public a XBb;
  public PopupWindow xyX;
  public View xyY;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(30472);
    this.xyY = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.gpi, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.xyX = new PopupWindow(paramContext, -2, -2, false);
    this.xyX.setClippingEnabled(false);
    paramContext.findViewById(R.h.gdE).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30468);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.xyX.dismiss();
        g.this.xyY.setVisibility(8);
        if (g.this.XBb != null) {
          g.this.XBb.dvJ();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30468);
      }
    });
    paramContext.findViewById(R.h.gdB).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30469);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.xyX.dismiss();
        g.this.xyY.setVisibility(8);
        if (g.this.XBb != null) {
          g.this.XBb.dvK();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30469);
      }
    });
    paramContext.findViewById(R.h.gdD).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30470);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.xyX.dismiss();
        g.this.xyY.setVisibility(8);
        if (g.this.XBb != null) {
          g.this.XBb.dvL();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30470);
      }
    });
    paramContext.findViewById(R.h.gdL).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30471);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.xyX.dismiss();
        g.this.xyY.setVisibility(8);
        if (g.this.XBb != null) {
          g.this.XBb.dvM();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30471);
      }
    });
    AppMethodBeat.o(30472);
  }
  
  public static abstract interface a
  {
    public abstract void dvJ();
    
    public abstract void dvK();
    
    public abstract void dvL();
    
    public abstract void dvM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */