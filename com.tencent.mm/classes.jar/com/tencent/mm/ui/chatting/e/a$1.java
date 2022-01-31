package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.k.e;
import java.util.List;

final class a$1
  implements d.b
{
  a$1(a parama, e parame, d.d paramd, d.a parama1, d.b paramb) {}
  
  public final void cN()
  {
    this.vxU.ei(this.vxV.vyk);
    this.vxU.close();
    this.vxV.dsw = this.vxU.cDk();
    this.vxV.vyl = this.vxV.vyk.size();
    y.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + this.vxW + " addCount:" + this.vxV.vyl + " totalCount:" + this.vxV.dsw);
    this.vxX.cN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a.1
 * JD-Core Version:    0.7.0.1
 */