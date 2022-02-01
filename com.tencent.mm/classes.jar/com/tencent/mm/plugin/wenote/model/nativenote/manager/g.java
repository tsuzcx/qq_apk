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
  public a EAc;
  public View mParentView;
  public PopupWindow puA;
  
  public g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(30472);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496103, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.puA = new PopupWindow(paramContext, -2, -2, false);
    this.puA.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30468);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.this.puA.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.EAc != null) {
          g.this.EAc.cdG();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30468);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30469);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.this.puA.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.EAc != null) {
          g.this.EAc.cdH();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30469);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30470);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.this.puA.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.EAc != null) {
          g.this.EAc.cdI();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30470);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30471);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.this.puA.dismiss();
        g.this.mParentView.setVisibility(8);
        if (g.this.EAc != null) {
          g.this.EAc.cdJ();
        }
        a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WNNoteEditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30471);
      }
    });
    AppMethodBeat.o(30472);
  }
  
  public static abstract interface a
  {
    public abstract void cdG();
    
    public abstract void cdH();
    
    public abstract void cdI();
    
    public abstract void cdJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */