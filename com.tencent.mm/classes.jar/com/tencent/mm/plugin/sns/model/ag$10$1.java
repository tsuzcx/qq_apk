package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.a;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$10$1
  implements Runnable
{
  ag$10$1(ag.10 param10, su paramsu) {}
  
  public final void run()
  {
    AppMethodBeat.i(36427);
    int i = (int)this.rhM.cJs.cJu;
    k localk = ag.cpk();
    String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= ".concat(String.valueOf(i));
    ab.i("MicroMsg.SnsCommentStorage", "updateToread ".concat(String.valueOf(str)));
    ab.i("MicroMsg.SnsCore", "update msg read ".concat(String.valueOf(localk.fnw.execSQL("SnsComment", str))));
    u.coB();
    AppMethodBeat.o(36427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.10.1
 * JD-Core Version:    0.7.0.1
 */