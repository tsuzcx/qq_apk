package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
  extends q
  implements m
{
  public String BcV;
  private i callback;
  private final d rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26904);
    this.BcV = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bys();
    ((d.a)localObject).iLO = new byt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((d.a)localObject).funcId = 205;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bys)this.rr.iLK.iLR;
    ((bys)localObject).UserName = paramString2;
    bg.aVF();
    paramString2 = Util.nullAsNil((String)c.azQ().get(46, null));
    ((bys)localObject).KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(paramString2));
    bg.aVF();
    String str = Util.nullAsNil((String)c.azQ().get(72, null));
    ((bys)localObject).LRA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
    AppMethodBeat.o(26904);
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
  
  public final String getURL()
  {
    return ((byt)this.rr.iLL.iLR).URL;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26906);
    Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.b
 * JD-Core Version:    0.7.0.1
 */