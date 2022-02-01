package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public f(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(203136);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bwj();
    ((d.a)localObject).iLO = new bwk();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_twist_adcard";
    ((d.a)localObject).funcId = 4729;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bwj)this.rr.iLK.iLR;
    ((bwj)localObject).uxInfo = paramString1;
    ((bwj)localObject).KFZ = paramString2;
    ((bwj)localObject).scene = paramInt;
    ((bwj)localObject).LYB = paramString3;
    ((bwj)localObject).extInfo = paramString4;
    Log.i("NetSceneAdGetTwistCard", "snsId=" + paramString2 + ", scene=" + paramInt + ", canvasId=" + paramString3 + ", uxInfo=" + paramString1 + ", extra=" + paramString4);
    AppMethodBeat.o(203136);
  }
  
  public static String i(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(203140);
    Log.i("NetSceneAdGetTwistCard", "parseTwistCardId, errType=" + paramInt1 + ", errNo=" + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramObject != null))
    {
      bwk localbwk = new bwk();
      try
      {
        localbwk.parseFrom((byte[])paramObject);
        Log.i("NetSceneAdGetTwistCard", "parseTwistCardId, cardId=" + localbwk.eaO + ", snsId=" + localbwk.KFZ);
        paramObject = Util.nullAsNil(localbwk.eaO);
        AppMethodBeat.o(203140);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        Log.e("NetSceneAdGetTwistCard", "parseTwistCardId exp=" + paramObject.toString());
      }
    }
    AppMethodBeat.o(203140);
    return "";
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(203139);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(203139);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(203138);
    int i = this.rr.getType();
    AppMethodBeat.o(203138);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(203137);
    Log.i("NetSceneAdGetTwistCard", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(203137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */