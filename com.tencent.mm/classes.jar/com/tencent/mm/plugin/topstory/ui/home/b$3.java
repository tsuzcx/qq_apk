package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ad;

final class b$3
  implements Runnable
{
  b$3(b paramb, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(125922);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(this.lYq), Integer.valueOf(this.BsH) });
    int i = this.lYq;
    int j = this.BsH;
    this.BsG.Bsp.setBackgroundColor(i + 16777216 * j);
    this.BsG.Bsp.setVisibility(0);
    this.BsG.Bsu = true;
    this.BsG.Bsp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125921);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.3.this.BsG);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125921);
      }
    });
    if (this.BsG.Bsw != null) {
      this.BsG.Bsw.setScrollEnable(false);
    }
    AppMethodBeat.o(125922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.3
 * JD-Core Version:    0.7.0.1
 */