package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends a
  implements k
{
  cyz Chi;
  private g callback;
  public int drc;
  private b hEg;
  
  public c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(77923);
    this.drc = -1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cyy();
    ((b.a)localObject).hvu = new cyz();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
    ((b.a)localObject).funcId = 2999;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (cyy)this.hEg.hvr.hvw;
    ((cyy)localObject).Md5 = paramString1;
    ((cyy)localObject).EfV = paramInt1;
    ((cyy)localObject).FhW = paramString2;
    ((cyy)localObject).DSu = paramString3;
    ((cyy)localObject).FIg = paramInt2;
    ((cyy)localObject).FrP = paramString4;
    ((cyy)localObject).FhS = z.Ul(0);
    ((cyy)localObject).Scene = paramInt3;
    ((cyy)localObject).FhT = z.bJn();
    ((cyy)localObject).AesKey = paramString6;
    ((cyy)localObject).FIh = paramString5;
    ac.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(77923);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(77925);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(77925);
    return i;
  }
  
  public final String ewZ()
  {
    return null;
  }
  
  public final int exa()
  {
    return 0;
  }
  
  public final cyz ezo()
  {
    return this.Chi;
  }
  
  public final int getType()
  {
    return 2999;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77924);
    ac.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Chi = ((cyz)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c
 * JD-Core Version:    0.7.0.1
 */