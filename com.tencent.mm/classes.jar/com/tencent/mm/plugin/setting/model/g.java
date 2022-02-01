package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class g
  extends p
  implements m
{
  public String PnD;
  private h callback;
  private c rr;
  
  public g(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public g(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(298541);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ccn();
    ((c.a)localObject).otF = new cco();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((c.a)localObject).funcId = 177;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.PnD = paramString;
    localObject = (ccn)c.b.b(this.rr.otB);
    ((ccn)localObject).Zue = 1;
    ((ccn)localObject).aalW = paramString;
    if (paramMap != null)
    {
      ((ccn)localObject).aalX = paramMap.size();
      ((ccn)localObject).aalY = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        ccp localccp = new ccp();
        localccp.vhJ = localInteger.intValue();
        localccp.Njp = ((String)paramMap.get(localInteger));
        ((ccn)localObject).aalY.add(localccp);
      }
    }
    AppMethodBeat.o(298541);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(73767);
    Log.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(73767);
    return i;
  }
  
  public final int getType()
  {
    return 177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73768);
    Log.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.g
 * JD-Core Version:    0.7.0.1
 */