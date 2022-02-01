package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.f.a;

final class d$25
  implements View.OnClickListener
{
  d$25(d paramd, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154178);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    d.a(this.SGe, this.SGn.getText().toString(), f.a.SyV);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.25
 * JD-Core Version:    0.7.0.1
 */