package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends q
  implements m
{
  public String Jdo;
  private i callback;
  private d rr;
  
  public e(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public e(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(263775);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new boc();
    ((d.a)localObject).lBV = new bod();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((d.a)localObject).funcId = 177;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.Jdo = paramString;
    localObject = (boc)d.b.b(this.rr.lBR);
    ((boc)localObject).Suo = 1;
    ((boc)localObject).SZe = paramString;
    if (paramMap != null)
    {
      ((boc)localObject).SZf = paramMap.size();
      ((boc)localObject).SZg = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        boe localboe = new boe();
        localboe.rWu = localInteger.intValue();
        localboe.HlB = ((String)paramMap.get(localInteger));
        ((boc)localObject).SZg.add(localboe);
      }
    }
    AppMethodBeat.o(263775);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73767);
    Log.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */