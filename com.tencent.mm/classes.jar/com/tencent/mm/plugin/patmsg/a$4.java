package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;

final class a$4
  implements Runnable
{
  a$4(a parama, czg paramczg) {}
  
  public final void run()
  {
    AppMethodBeat.i(206915);
    ca localca = new ca();
    localca.setContent(MMApplicationContext.getContext().getString(2131764641));
    localca.setType(10000);
    localca.nv(0);
    localca.Cy(this.ARe.gnh);
    localca.setCreateTime(System.currentTimeMillis());
    bp.x(localca);
    AppMethodBeat.o(206915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.4
 * JD-Core Version:    0.7.0.1
 */