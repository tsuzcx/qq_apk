package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.y;

final class d$36
  implements View.OnClickListener
{
  d$36(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207250);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    boolean bool;
    if (!y.hsF().SzV)
    {
      bool = true;
      y.hsF().Ei(bool);
      if (!bool) {
        break label97;
      }
      this.SGe.huM();
      this.SGe.SFV.setVisibility(0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207250);
      return;
      bool = false;
      break;
      label97:
      if (this.SGe.SFV != null) {
        this.SGe.SFV.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.36
 * JD-Core Version:    0.7.0.1
 */