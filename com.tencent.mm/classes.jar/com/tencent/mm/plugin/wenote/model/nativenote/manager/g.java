package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class g
{
  public a JIl;
  public View mParentView;
  public PopupWindow qQv;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(30472);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131497091, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.qQv = new PopupWindow(paramContext, -2, -2, false);
    this.qQv.setClippingEnabled(false);
    paramContext.findViewById(2131310477).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30468);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.this.qQv.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.JIl != null) {
          g.this.JIl.cCL();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30468);
      }
    });
    paramContext.findViewById(2131310474).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30469);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.this.qQv.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.JIl != null) {
          g.this.JIl.cCM();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30469);
      }
    });
    paramContext.findViewById(2131310476).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30470);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.this.qQv.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.JIl != null) {
          g.this.JIl.cCN();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30470);
      }
    });
    paramContext.findViewById(2131310485).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30471);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.this.qQv.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.JIl != null) {
          g.this.JIl.cCO();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30471);
      }
    });
    AppMethodBeat.o(30472);
  }
  
  public static abstract interface a
  {
    public abstract void cCL();
    
    public abstract void cCM();
    
    public abstract void cCN();
    
    public abstract void cCO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */