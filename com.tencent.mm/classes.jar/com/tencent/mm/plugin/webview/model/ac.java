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
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  final LinkedList<String> PUq;
  private i jQg;
  private final d rr;
  private long startTime;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt2, String paramString4, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(246722);
    this.startTime = 0L;
    this.PUq = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ebd();
    ((d.a)localObject).lBV = new ebe();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((d.a)localObject).funcId = 1346;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ebd)d.b.b(this.rr.lBR);
    ((ebd)localObject).TKW = paramInt1;
    ((ebd)localObject).appid = paramString1;
    ((ebd)localObject).TKX = paramLinkedList;
    ((ebd)localObject).state = paramString2;
    ((ebd)localObject).UfZ = paramString3;
    ((ebd)localObject).SrG = paramInt2;
    ((ebd)localObject).Uga = paramString4;
    this.startTime = System.currentTimeMillis();
    ((ebd)localObject).Ugc = paramb;
    if (paramLinkedList != null) {
      this.PUq.addAll(paramLinkedList);
    }
    if (paramb != null) {}
    for (paramInt1 = paramb.UH.length;; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneSDKOauthAuthorizeConfirm", "do sdk confirm appId=%s, packageName=%s, oauthContextBuffer size=%d", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(246722);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final ebe gVv()
  {
    AppMethodBeat.i(246724);
    ebe localebe = (ebe)d.c.b(this.rr.lBS);
    AppMethodBeat.o(246724);
    return localebe;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.k.b.QzJ.aS(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */