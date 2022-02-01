package com.tencent.mm.xwebutil;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$5
  implements View.OnClickListener
{
  a$5(ValueCallback paramValueCallback) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(231680);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.rXV.onReceiveValue("fileReaderClosed");
    a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(231680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xwebutil.a.5
 * JD-Core Version:    0.7.0.1
 */