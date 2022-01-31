package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.c;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.l.e;
import java.util.List;

final class a$1
  implements d.c<bi>
{
  a$1(a parama, Bundle paramBundle, d.a parama1) {}
  
  public final e b(d.d<bi> paramd)
  {
    AppMethodBeat.i(32713);
    paramd.zOD = this.zQo;
    paramd = this.zQp.a(this.zOr, this.zQo, paramd);
    AppMethodBeat.o(32713);
    return paramd;
  }
  
  public final void c(d.d<bi> paramd)
  {
    AppMethodBeat.i(32714);
    this.zQp.zQj = paramd.eke;
    this.zQp.zQk = paramd.zOG;
    if (paramd.zOF.size() > 0)
    {
      bi localbi = (bi)paramd.zOF.get(0);
      if (localbi != null)
      {
        this.zQp.zPU = localbi.field_createTime;
        this.zQp.zQm = localbi.field_msgSeq;
      }
      paramd = (bi)paramd.zOF.get(paramd.zOF.size() - 1);
      if (paramd != null)
      {
        this.zQp.zPV = paramd.field_createTime;
        this.zQp.zQl = paramd.field_msgSeq;
      }
    }
    AppMethodBeat.o(32714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.a.1
 * JD-Core Version:    0.7.0.1
 */