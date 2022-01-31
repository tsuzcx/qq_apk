package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.widget.b.d;

final class b$8
  implements View.OnLongClickListener
{
  b$8(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(91535);
    if ((this.uNn.uNg != null) && (bp.dud()))
    {
      Object localObject = this.uNn.eyt.getContext();
      paramView = new b.8.1(this);
      localObject = new d((Context)localObject, 2, true);
      ((d)localObject).r("当前服务为体验版本，可以选择以下调试功能", 48);
      ((d)localObject).sao = new a.1();
      ((d)localObject).sap = new a.2(paramView);
      ((d)localObject).crd();
    }
    AppMethodBeat.o(91535);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.8
 * JD-Core Version:    0.7.0.1
 */