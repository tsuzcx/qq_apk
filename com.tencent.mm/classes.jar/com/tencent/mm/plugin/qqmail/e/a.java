package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.ao;
import com.tencent.mm.plugin.qqmail.d.ap;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public String filePath;
  public com.tencent.mm.ak.b hZD;
  public String xtt;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217994);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
    this.filePath = paramString1;
    paramString1 = new com.tencent.mm.vfs.k(paramString1);
    ao localao = new ao();
    g.ajP();
    localao.uin = com.tencent.mm.kernel.a.getUin();
    localao.name = paramString1.getName();
    localao.size = paramInt;
    localao.xsY = paramString2;
    localao.md5 = paramString3;
    this.xtt = paramString2;
    locala.hQF = localao;
    locala.hQG = new ap();
    this.hZD = locala.aDS();
    AppMethodBeat.o(217994);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217995);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(217995);
    return i;
  }
  
  public final int getType()
  {
    return 11665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217996);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.a
 * JD-Core Version:    0.7.0.1
 */