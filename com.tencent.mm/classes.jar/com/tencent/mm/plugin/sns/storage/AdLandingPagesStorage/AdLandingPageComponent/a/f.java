package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.eva;
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
    AppMethodBeat.i(222772);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdz();
    ((d.a)localObject).lBV = new cea();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_twist_adcard";
    ((d.a)localObject).funcId = 4729;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cdz)d.b.b(this.rr.lBR);
    ((cdz)localObject).uxInfo = paramString1;
    ((cdz)localObject).RHs = paramString2;
    ((cdz)localObject).scene = paramInt;
    ((cdz)localObject).RHW = paramString3;
    ((cdz)localObject).extInfo = paramString4;
    Log.i("NetSceneAdGetTwistCard", "snsId=" + paramString2 + ", scene=" + paramInt + ", canvasId=" + paramString3 + ", uxInfo=" + paramString1 + ", extra=" + paramString4);
    AppMethodBeat.o(222772);
  }
  
  public static Bundle j(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(222780);
    Log.i("NetSceneAdGetTwistCard", "parseTwistCardInfo, errType=" + paramInt1 + ", errNo=" + paramInt2);
    Bundle localBundle = new Bundle();
    cea localcea;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramObject != null)) {
      localcea = new cea();
    }
    try
    {
      localcea.parseFrom((byte[])paramObject);
      Log.i("NetSceneAdGetTwistCard", "parseTwistCardInfo, cardId=" + localcea.fUL + ", snsId=" + localcea.RHs);
      localBundle.putString("card_id", Util.nullAsNil(localcea.fUL));
      paramObject = localcea.TlG;
      if (paramObject != null) {
        localBundle.putString("card_ext_info", Util.nullAsNil(paramObject.UwN));
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        Log.e("NetSceneAdGetTwistCard", "parseTwistCardInfo exp=" + paramObject.toString());
      }
    }
    AppMethodBeat.o(222780);
    return localBundle;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(222775);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(222775);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(222774);
    int i = this.rr.getType();
    AppMethodBeat.o(222774);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222773);
    Log.i("NetSceneAdGetTwistCard", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(222773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */