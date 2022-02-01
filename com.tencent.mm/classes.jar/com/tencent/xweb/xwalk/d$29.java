package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.f.c;

final class d$29
  implements View.OnClickListener
{
  d$29(d paramd, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154182);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    d.a(this.SGe, this.SGo.getText().toString(), f.c.SyY);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.29
 * JD-Core Version:    0.7.0.1
 */