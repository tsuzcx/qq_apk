package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class o
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public o(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(78882);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new brc();
    ((d.a)localObject).lBV = new brd();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((d.a)localObject).funcId = 1393;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (brc)d.b.b(this.rr.lBR);
    ((brc)localObject).SqC = paramString1;
    ((brc)localObject).RYS = paramString2;
    ((brc)localObject).MFH = ((String)paramMap.get("groupId"));
    ((brc)localObject).OPc = ((String)paramMap.get("timestamp"));
    ((brc)localObject).tyJ = ((String)paramMap.get("nonceStr"));
    ((brc)localObject).signature = ((String)paramMap.get("signature"));
    ((brc)localObject).TbX = paramMap.get("params").toString();
    AppMethodBeat.o(78882);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78884);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78884);
    return i;
  }
  
  public final brd gVq()
  {
    AppMethodBeat.i(267731);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      brd localbrd = (brd)d.c.b(this.rr.lBS);
      AppMethodBeat.o(267731);
      return localbrd;
    }
    AppMethodBeat.o(267731);
    return null;
  }
  
  public final int getType()
  {
    return 1393;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78883);
    Log.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.o
 * JD-Core Version:    0.7.0.1
 */