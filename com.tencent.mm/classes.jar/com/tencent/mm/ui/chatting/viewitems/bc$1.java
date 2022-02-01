package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class bc$1
  extends p
{
  bc$1(bc parambc, int paramInt1, int paramInt2, a parama, a.b paramb, bf.b paramb1, ca paramca, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37364);
    Log.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { this.WNd });
    this.Xkr.a(this.Xks.convertView, this.lrk, this.WNd, this.sHz);
    AppMethodBeat.o(37364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.1
 * JD-Core Version:    0.7.0.1
 */