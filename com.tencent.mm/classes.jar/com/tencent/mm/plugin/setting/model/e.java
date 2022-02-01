package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  public String ySS;
  
  public e(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(73766);
    AppMethodBeat.o(73766);
  }
  
  public e(String paramString, Map<Integer, String> paramMap)
  {
    AppMethodBeat.i(190290);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new avk();
    ((b.a)localObject).hQG = new avl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/generalset";
    ((b.a)localObject).funcId = 177;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.ySS = paramString;
    localObject = (avk)this.rr.hQD.hQJ;
    ((avk)localObject).SetType = 1;
    ((avk)localObject).GMx = paramString;
    if (paramMap != null)
    {
      ((avk)localObject).GMy = paramMap.size();
      ((avk)localObject).GMz = new LinkedList();
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        Integer localInteger = (Integer)paramString.next();
        avm localavm = new avm();
        localavm.nJA = localInteger.intValue();
        localavm.xrf = ((String)paramMap.get(localInteger));
        ((avk)localObject).GMz.add(localavm);
      }
    }
    AppMethodBeat.o(190290);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(73767);
    ae.d("MicroMsg.NetSceneGeneralSet", "doScene");
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
    ae.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */