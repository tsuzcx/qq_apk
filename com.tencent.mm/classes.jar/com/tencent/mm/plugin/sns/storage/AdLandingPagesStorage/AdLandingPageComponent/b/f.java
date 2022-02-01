package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.fqn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public f(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(306806);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ctz();
    ((c.a)localObject).otF = new cua();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_twist_adcard";
    ((c.a)localObject).funcId = 4729;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ctz)c.b.b(this.rr.otB);
    ((ctz)localObject).uxInfo = paramString1;
    ((ctz)localObject).YEv = paramString2;
    ((ctz)localObject).scene = paramInt;
    ((ctz)localObject).YEY = paramString3;
    ((ctz)localObject).extInfo = paramString4;
    Log.i("NetSceneAdGetTwistCard", "snsId=" + paramString2 + ", scene=" + paramInt + ", canvasId=" + paramString3 + ", uxInfo=" + paramString1 + ", extra=" + paramString4);
    AppMethodBeat.o(306806);
  }
  
  public static Bundle j(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(306812);
    Log.i("NetSceneAdGetTwistCard", "parseTwistCardInfo, errType=" + paramInt1 + ", errNo=" + paramInt2);
    Bundle localBundle = new Bundle();
    cua localcua;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramObject != null)) {
      localcua = new cua();
    }
    try
    {
      localcua.parseFrom((byte[])paramObject);
      Log.i("NetSceneAdGetTwistCard", "parseTwistCardInfo, cardId=" + localcua.iaI + ", snsId=" + localcua.YEv);
      localBundle.putString("card_id", Util.nullAsNil(localcua.iaI));
      paramObject = localcua.aazA;
      if (paramObject != null) {
        localBundle.putString("card_ext_info", Util.nullAsNil(paramObject.abQv));
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("NetSceneAdGetTwistCard", "parseTwistCardInfo exp=" + paramObject.toString());
      }
    }
    AppMethodBeat.o(306812);
    return localBundle;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(306828);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306828);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306824);
    int i = this.rr.getType();
    AppMethodBeat.o(306824);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306819);
    Log.i("NetSceneAdGetTwistCard", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.f
 * JD-Core Version:    0.7.0.1
 */