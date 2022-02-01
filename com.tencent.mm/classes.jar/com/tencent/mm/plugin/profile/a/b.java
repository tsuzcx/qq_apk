package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class b
  extends p
  implements m
{
  public String MUN;
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.MUN = paramString1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cwp();
    ((c.a)localObject).otF = new cwq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((c.a)localObject).funcId = 205;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cwp)c.b.b(this.rr.otB);
    ((cwp)localObject).UserName = paramString2;
    bh.bCz();
    paramString2 = Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(46, null));
    ((cwp)localObject).YJr = new gol().df(Util.decodeHexString(paramString2));
    bh.bCz();
    String str = Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(72, null));
    ((cwp)localObject).aand = new gol().df(Util.decodeHexString(str));
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(26904);
  }
  
  public final String cgR()
  {
    AppMethodBeat.i(305379);
    String str = ((cwq)c.c.b(this.rr.otC)).URL;
    AppMethodBeat.o(305379);
    return str;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26905);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26905);
    return i;
  }
  
  public final int getType()
  {
    return 205;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26906);
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), cgR() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */