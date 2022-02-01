package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.ao;
import com.tencent.mm.plugin.qqmail.d.ap;

public final class a
  extends n
  implements k
{
  private f callback;
  public String filePath;
  public com.tencent.mm.al.b hWL;
  public String xdC;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(215248);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
    this.filePath = paramString1;
    paramString1 = new com.tencent.mm.vfs.e(paramString1);
    ao localao = new ao();
    g.ajA();
    localao.uin = com.tencent.mm.kernel.a.getUin();
    localao.name = paramString1.getName();
    localao.size = paramInt;
    localao.xdh = paramString2;
    localao.md5 = paramString3;
    this.xdC = paramString2;
    locala.hNM = localao;
    locala.hNN = new ap();
    this.hWL = locala.aDC();
    AppMethodBeat.o(215248);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215249);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215249);
    return i;
  }
  
  public final int getType()
  {
    return 11665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215250);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.a
 * JD-Core Version:    0.7.0.1
 */