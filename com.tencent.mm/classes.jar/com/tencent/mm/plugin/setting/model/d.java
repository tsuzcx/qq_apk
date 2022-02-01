package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.sdk.platformtools.ad;
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
  public String wcU;
  
  public d(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public d(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(186500);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new anu();
    ((b.a)localObject).gUV = new anv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).funcId = 177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.wcU = paramString;
    localObject = (anu)this.rr.gUS.gUX;
    ((anu)localObject).SetType = 1;
    ((anu)localObject).DoX = paramString;
    if (paramMap != null)
    {
      ((anu)localObject).DoY = paramMap.size();
      ((anu)localObject).DoZ = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        anw localanw = new anw();
        localanw.mBH = localInteger.intValue();
        localanw.Ddo = ((String)paramMap.get(localInteger));
        ((anu)localObject).DoZ.add(localanw);
      }
    }
    AppMethodBeat.o(186500);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73767);
    ad.d("MicroMsg.NetSceneGeneralSet", "doScene");
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
    ad.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */