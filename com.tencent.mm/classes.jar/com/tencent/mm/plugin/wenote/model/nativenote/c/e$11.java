package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class e$11
  implements View.OnClickListener
{
  public e$11(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30562);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wenote/model/nativenote/multiselect/NoteSelectManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("NoteSelectManager", "unbold");
    this.XBK.dwY();
    a.a(this, "com/tencent/mm/plugin/wenote/model/nativenote/multiselect/NoteSelectManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.11
 * JD-Core Version:    0.7.0.1
 */