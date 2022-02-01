package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.sdk.platformtools.Log;

final class AdLandingPagesProxy$3
  implements i
{
  AdLandingPagesProxy$3(AdLandingPagesProxy paramAdLandingPagesProxy, long paramLong) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(267252);
    Log.i("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (cfv)d.c.b(((d)paramq.getReqResp()).lBS);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.Tnd)))
      {
        this.JTn.CLIENT_CALL("onGetBtnPersonalWxUserName", new Object[] { Long.valueOf(this.val$id), paramString.username, paramString.Tnd });
        this.JTn.doSearchContactMM(this.val$id, paramString.Tnd);
      }
    }
    for (;;)
    {
      h.aGY().b(paramq.getType(), this);
      AppMethodBeat.o(267252);
      return;
      Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, rsp==null");
      this.JTn.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(this.val$id), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null });
      continue;
      Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, failed");
      this.JTn.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(this.val$id), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.3
 * JD-Core Version:    0.7.0.1
 */