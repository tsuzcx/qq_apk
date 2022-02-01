package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.euu;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends p
  implements m
{
  final LinkedList<String> WLc;
  private h mAY;
  private final c rr;
  private long startTime;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt2, String paramString4, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, Boolean paramBoolean)
  {
    AppMethodBeat.i(298305);
    this.startTime = 0L;
    this.WLc = new LinkedList();
    Object localObject = new c.a();
    ((c.a)localObject).otE = new euu();
    ((c.a)localObject).otF = new euv();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((c.a)localObject).funcId = 1346;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (euu)c.b.b(this.rr.otB);
    ((euu)localObject).abaP = paramInt1;
    ((euu)localObject).appid = paramString1;
    ((euu)localObject).abaQ = paramLinkedList;
    ((euu)localObject).state = paramString2;
    ((euu)localObject).abxv = paramString3;
    ((euu)localObject).ZqK = paramInt2;
    ((euu)localObject).abxw = paramString4;
    ((euu)localObject).abxB = paramb2;
    ((euu)localObject).abxC = paramBoolean.booleanValue();
    this.startTime = System.currentTimeMillis();
    ((euu)localObject).abxy = paramb1;
    if (paramLinkedList != null) {
      this.WLc.addAll(paramLinkedList);
    }
    if (paramb1 != null) {}
    for (paramInt1 = paramb1.Op.length;; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneSDKOauthAuthorizeConfirm", "do sdk confirm appId=%s, packageName=%s, oauthContextBuffer size=%d", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(298305);
      return;
    }
  }
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4, com.tencent.mm.bx.b paramb)
  {
    this(paramInt, paramString1, paramString2, paramString3, paramLinkedList, 0, paramString4, paramb, null, Boolean.FALSE);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final euv ivg()
  {
    AppMethodBeat.i(298318);
    euv localeuv = (euv)c.c.b(this.rr.otC);
    AppMethodBeat.o(298318);
    return localeuv;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.k.b.XsD.bt(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */