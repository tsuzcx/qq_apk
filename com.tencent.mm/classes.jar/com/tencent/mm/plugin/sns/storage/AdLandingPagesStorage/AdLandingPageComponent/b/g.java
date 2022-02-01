package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public g(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(306809);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cub();
    ((c.a)localObject).otF = new cuc();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_twist_card_status";
    ((c.a)localObject).funcId = 4689;
    ((c.a)localObject).timeout = 5000;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cub)c.b.b(this.rr.otB);
    ((cub)localObject).mdG = paramString1;
    ((cub)localObject).scene = paramInt1;
    ((cub)localObject).YEY = paramString2;
    ((cub)localObject).iaI = paramString3;
    ((cub)localObject).tNW = 0;
    ((cub)localObject).aazB = paramString4;
    ((cub)localObject).YAN = paramInt2;
    Log.i("NetSceneAdGetTwistCardStatus", "scene=" + paramInt1 + ", canvasId=" + paramString2 + ", cardId=" + paramString3 + ", giveCardId=" + paramString4 + ", uxInfo=" + paramString1 + ", opType=" + paramInt2);
    AppMethodBeat.o(306809);
  }
  
  public static Bundle k(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(306817);
    Log.i("NetSceneAdGetTwistCardStatus", "parseTwistCardStatusInfo, errType=" + paramInt1 + ", errNo=" + paramInt2);
    Bundle localBundle = new Bundle();
    cuc localcuc;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramObject != null)) {
      localcuc = new cuc();
    }
    try
    {
      localcuc.parseFrom((byte[])paramObject);
      localBundle.putInt("status", localcuc.status);
      localBundle.putString("card_id", Util.nullAsNil(localcuc.iaI));
      localBundle.putString("give_card_id", Util.nullAsNil(localcuc.aazB));
      localBundle.putString("receive_url", localcuc.aazC);
      Log.i("NetSceneAdGetTwistCardStatus", "parseTwistCardStatusInfo, status=" + localcuc.status + ", cardId=" + localcuc.iaI + ", giveCardId=" + localcuc.aazB + ", jumpUrl=" + localcuc.aazC);
      AppMethodBeat.o(306817);
      return localBundle;
    }
    finally
    {
      for (;;)
      {
        Log.e("NetSceneAdGetTwistCardStatus", "parseTwistCardStatusInfo exp=" + paramObject.toString());
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(306833);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306833);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306827);
    int i = this.rr.getType();
    AppMethodBeat.o(306827);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306822);
    Log.i("NetSceneAdGetTwistCardStatus", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.g
 * JD-Core Version:    0.7.0.1
 */