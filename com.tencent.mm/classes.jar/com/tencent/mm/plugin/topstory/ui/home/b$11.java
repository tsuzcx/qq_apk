package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;

final class b$11
  implements View.OnClickListener
{
  b$11(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125941);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    long l = System.currentTimeMillis();
    if (l - this.BsG.Bst < 300L) {}
    try
    {
      if ((this.BsG.Bsm != null) && (this.BsG.Bsm.getView() != null)) {
        this.BsG.Bsm.getView().scrollTo(this.BsG.Bsm.getView().getScrollX(), 0);
      }
      label107:
      this.BsG.Bst = l;
      a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(125941);
      return;
    }
    catch (Throwable paramView)
    {
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.11
 * JD-Core Version:    0.7.0.1
 */