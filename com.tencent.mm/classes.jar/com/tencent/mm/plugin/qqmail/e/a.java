package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.ao;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.vfs.o;

public final class a
  extends q
  implements m
{
  public String Btw;
  private i callback;
  public String filePath;
  public d iUB;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198650);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
    this.filePath = paramString1;
    paramString1 = new o(paramString1);
    ao localao = new ao();
    com.tencent.mm.kernel.g.aAf();
    localao.uin = com.tencent.mm.kernel.a.getUin();
    localao.name = paramString1.getName();
    localao.size = paramInt;
    localao.Btb = paramString2;
    localao.md5 = paramString3;
    this.Btw = paramString2;
    locala.iLN = localao;
    locala.iLO = new ap();
    this.iUB = locala.aXF();
    AppMethodBeat.o(198650);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198651);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198651);
    return i;
  }
  
  public final int getType()
  {
    return 11665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198652);
    b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.a
 * JD-Core Version:    0.7.0.1
 */