package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.ao;
import com.tencent.mm.plugin.qqmail.d.ap;

public final class a
  extends com.tencent.mm.an.q
  implements m
{
  public String HnQ;
  private i callback;
  public String filePath;
  public d lKU;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(251205);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
    this.filePath = paramString1;
    paramString1 = new com.tencent.mm.vfs.q(paramString1);
    ao localao = new ao();
    h.aHE();
    localao.uin = com.tencent.mm.kernel.b.getUin();
    localao.name = paramString1.getName();
    localao.size = paramInt;
    localao.Hnv = paramString2;
    localao.md5 = paramString3;
    this.HnQ = paramString2;
    locala.lBU = localao;
    locala.lBV = new ap();
    this.lKU = locala.bgN();
    AppMethodBeat.o(251205);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(251208);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(251208);
    return i;
  }
  
  public final int getType()
  {
    return 11665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251209);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(251209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.a
 * JD-Core Version:    0.7.0.1
 */