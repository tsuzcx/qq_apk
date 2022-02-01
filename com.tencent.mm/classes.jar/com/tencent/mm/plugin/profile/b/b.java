package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
  extends q
  implements m
{
  public String GWU;
  private i callback;
  private final d rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.GWU = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cgm();
    ((d.a)localObject).lBV = new cgn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((d.a)localObject).funcId = 205;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cgm)d.b.b(this.rr.lBR);
    ((cgm)localObject).UserName = paramString2;
    bh.beI();
    paramString2 = Util.nullAsNil((String)c.aHp().b(46, null));
    ((cgm)localObject).RMd = new eae().dc(Util.decodeHexString(paramString2));
    bh.beI();
    String str = Util.nullAsNil((String)c.aHp().b(72, null));
    ((cgm)localObject).Taf = new eae().dc(Util.decodeHexString(str));
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(26904);
  }
  
  public final String btD()
  {
    AppMethodBeat.i(291513);
    String str = ((cgn)d.c.b(this.rr.lBS)).URL;
    AppMethodBeat.o(291513);
    return str;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26905);
    this.callback = parami;
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
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), btD() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */