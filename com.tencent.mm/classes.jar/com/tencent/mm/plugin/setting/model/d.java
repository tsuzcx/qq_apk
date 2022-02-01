package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  public String xoi;
  
  public d(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public d(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(190965);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aqy();
    ((b.a)localObject).hvu = new aqz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).funcId = 177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.xoi = paramString;
    localObject = (aqy)this.rr.hvr.hvw;
    ((aqy)localObject).SetType = 1;
    ((aqy)localObject).EJX = paramString;
    if (paramMap != null)
    {
      ((aqy)localObject).EJY = paramMap.size();
      ((aqy)localObject).EJZ = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        ara localara = new ara();
        localara.ndI = localInteger.intValue();
        localara.Ewu = ((String)paramMap.get(localInteger));
        ((aqy)localObject).EJZ.add(localara);
      }
    }
    AppMethodBeat.o(190965);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73767);
    ac.d("MicroMsg.NetSceneGeneralSet", "doScene");
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */