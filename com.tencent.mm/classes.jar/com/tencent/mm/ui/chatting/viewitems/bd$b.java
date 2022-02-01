package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ap.a.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class bd$b
  extends bi.b
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37370);
    this.WBq = parama1;
    parama = (bi.f)parama;
    paramString = a.a.Vp(paramca.field_content);
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      l.a(parama.XkW.getContext(), com.tencent.mm.ap.a.a(paramString), (int)parama.XkW.getTextSize(), null, "");
      parama.XkW.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
      parama.XkW.setOnLongClickListener(c(parama1));
      a(paramInt, parama, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(198208);
    if (paramca.hzK())
    {
      int i = ((by)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramo.a(i, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(198208);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.b
 * JD-Core Version:    0.7.0.1
 */