package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.k.a.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;

final class am$b$5
  implements MMNeat7extView.a
{
  am$b$5(am.b paramb, am.f paramf) {}
  
  public final void ae(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(33308);
    if (((Boolean)this.zWZ.zXe.getTag(am.b.access$200())).booleanValue())
    {
      a.dLf();
      a.dLg().a(paramCharSequence, ((Long)this.zWZ.zXe.getTag(am.b.access$300())).longValue());
    }
    AppMethodBeat.o(33308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b.5
 * JD-Core Version:    0.7.0.1
 */