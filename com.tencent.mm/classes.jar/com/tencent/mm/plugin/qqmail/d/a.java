package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.an;
import com.tencent.mm.plugin.qqmail.model.ao;
import com.tencent.mm.vfs.u;

public final class a
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String filePath;
  public c oDw;
  public String obF;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(266892);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
    this.filePath = paramString1;
    paramString1 = new u(paramString1);
    an localan = new an();
    com.tencent.mm.kernel.h.baC();
    localan.uin = com.tencent.mm.kernel.b.getUin();
    localan.name = paramString1.getName();
    localan.size = paramInt;
    localan.Nlj = paramString2;
    localan.md5 = paramString3;
    this.obF = paramString2;
    locala.otE = localan;
    locala.otF = new ao();
    this.oDw = locala.bEF();
    AppMethodBeat.o(266892);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266900);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266900);
    return i;
  }
  
  public final int getType()
  {
    return 11665;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266907);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.a
 * JD-Core Version:    0.7.0.1
 */