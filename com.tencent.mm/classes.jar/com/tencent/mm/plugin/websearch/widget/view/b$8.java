package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.plugin.websearch.widget.b.a.a;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.a.e;

final class b$8
  implements View.OnLongClickListener
{
  b$8(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(116712);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if ((this.IIZ.IIS != null) && (WeChatEnvironment.hasDebugger()))
    {
      localObject = this.IIZ.parent.getContext();
      paramView = new a.a()
      {
        public final void fXH()
        {
          AppMethodBeat.i(116711);
          b.8.this.IIZ.IIQ.fXH();
          AppMethodBeat.o(116711);
        }
        
        public final void fYX()
        {
          AppMethodBeat.i(116710);
          b.8.this.IIZ.IIH.aWY(b.8.this.IIZ.III);
          AppMethodBeat.o(116710);
        }
      };
      localObject = new e((Context)localObject, 2, true);
      ((e)localObject).o("当前服务为体验版本，可以选择以下调试功能", 48);
      ((e)localObject).HLX = new a.1();
      ((e)localObject).HLY = new a.2(paramView);
      ((e)localObject).dGm();
    }
    a.a(true, this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(116712);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.8
 * JD-Core Version:    0.7.0.1
 */