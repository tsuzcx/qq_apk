package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  public cko cKi;
  private f callback;
  private com.tencent.mm.ai.b rr;
  private long tfo;
  
  public b(cko paramcko, int paramInt, String paramString)
  {
    AppMethodBeat.i(155513);
    ab.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramcko.bWu), Integer.valueOf(paramInt), paramcko.xUt, paramcko.cpW });
    this.tfo = System.currentTimeMillis();
    this.cKi = paramcko;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).fsX = new cyg();
    ((b.a)localObject).fsY = new cyh();
    this.rr = ((b.a)localObject).ado();
    localObject = (cyg)this.rr.fsV.fta;
    ((cyg)localObject).wzS = paramcko.offset;
    ((cyg)localObject).xqT = aa.Jf(1);
    ((cyg)localObject).wXt = paramcko.cnv;
    ((cyg)localObject).xqU = aa.acv();
    ((cyg)localObject).Scene = paramcko.scene;
    ((cyg)localObject).wBZ = paramcko.hng;
    ((cyg)localObject).yel.addAll(paramcko.uIO);
    ((cyg)localObject).xTB = paramcko.bWu;
    ((cyg)localObject).yfo = paramInt;
    if (((cyg)localObject).xTB == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cHZ();
      if (paramString != null) {
        ((cyg)localObject).xFD = paramString.cDC;
      }
    }
    for (;;)
    {
      ((cyg)localObject).yfm = paramcko.uIX;
      ((cyg)localObject).yfn = paramcko.xUz;
      paramcko = new up();
      paramcko.key = "client_system_version";
      paramcko.wMM = Build.VERSION.SDK_INT;
      ((cyg)localObject).yel.add(paramcko);
      paramcko = new up();
      paramcko.key = "netType";
      paramcko.wMN = aa.bXn();
      ((cyg)localObject).yel.add(paramcko);
      paramcko = new up();
      paramcko.key = "client_request_time";
      paramcko.wMN = String.valueOf(System.currentTimeMillis());
      ((cyg)localObject).yel.add(paramcko);
      paramcko = ((cyg)localObject).yel.iterator();
      while (paramcko.hasNext())
      {
        paramString = (up)paramcko.next();
        ab.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.wMM), paramString.wMN });
      }
      if (((cyg)localObject).xTB == 100) {
        ((cyg)localObject).xFD = paramString;
      } else {
        ((cyg)localObject).xFD = "";
      }
    }
    ab.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((cyg)localObject).wzS), Integer.valueOf(((cyg)localObject).xqT), Integer.valueOf(((cyg)localObject).yfn.size()) });
    AppMethodBeat.o(155513);
  }
  
  public final cyh cID()
  {
    return (cyh)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(96384);
    an.reportIdKey649ForLook(this.cKi.scene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(96384);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96385);
    ab.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.tfo) });
    if (paramInt3 == -1) {
      an.reportIdKey649ForLook(this.cKi.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(96385);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        an.reportIdKey649ForLook(this.cKi.scene, 8);
      } else {
        an.reportIdKey649ForLook(this.cKi.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */