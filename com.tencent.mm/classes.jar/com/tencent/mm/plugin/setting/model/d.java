package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  public String yCN;
  
  public d(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public d(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(220928);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new auu();
    ((b.a)localObject).hNN = new auv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).funcId = 177;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.yCN = paramString;
    localObject = (auu)this.rr.hNK.hNQ;
    ((auu)localObject).SetType = 1;
    ((auu)localObject).GsZ = paramString;
    if (paramMap != null)
    {
      ((auu)localObject).Gta = paramMap.size();
      ((auu)localObject).Gtb = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        auw localauw = new auw();
        localauw.nEf = localInteger.intValue();
        localauw.xbo = ((String)paramMap.get(localInteger));
        ((auu)localObject).Gtb.add(localauw);
      }
    }
    AppMethodBeat.o(220928);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(73767);
    ad.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(73767);
    return i;
  }
  
  public final int getType()
  {
    return 177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73768);
    ad.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */