package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.c;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.k.e;
import java.util.List;

final class a$1
  implements d.c<bi>
{
  a$1(a parama, Bundle paramBundle, d.a parama1) {}
  
  public final e b(d.d<bi> paramd)
  {
    paramd.vyi = this.vzR;
    return this.vzS.a(this.vxW, this.vzR, paramd);
  }
  
  public final void c(d.d<bi> paramd)
  {
    this.vzS.vzM = paramd.dsw;
    this.vzS.vzN = paramd.vyl;
    if (paramd.vyk.size() > 0)
    {
      bi localbi = (bi)paramd.vyk.get(0);
      if (localbi != null)
      {
        this.vzS.vzx = localbi.field_createTime;
        this.vzS.vzP = localbi.field_msgSeq;
      }
      paramd = (bi)paramd.vyk.get(paramd.vyk.size() - 1);
      if (paramd != null)
      {
        this.vzS.vzy = paramd.field_createTime;
        this.vzS.vzO = paramd.field_msgSeq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a.1
 * JD-Core Version:    0.7.0.1
 */