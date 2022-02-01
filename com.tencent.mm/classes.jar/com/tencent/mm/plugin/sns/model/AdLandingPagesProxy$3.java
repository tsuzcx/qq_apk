package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.Log;

final class AdLandingPagesProxy$3
  implements com.tencent.mm.am.h
{
  AdLandingPagesProxy$3(AdLandingPagesProxy paramAdLandingPagesProxy, long paramLong) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(309456);
    Log.i("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (cvy)c.c.b(((c)paramp.getReqResp()).otC);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.aaBj)))
      {
        this.Qqp.CLIENT_CALL("onGetBtnPersonalWxUserName", new Object[] { Long.valueOf(this.val$id), paramString.username, paramString.aaBj });
        this.Qqp.doSearchContactMM(this.val$id, paramString.aaBj);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
      AppMethodBeat.o(309456);
      return;
      Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, rsp==null");
      this.Qqp.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(this.val$id), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null });
      continue;
      Log.e("AdLandingPagesProxy", "getBtnPersonalWxUserNameMM, failed");
      this.Qqp.CLIENT_CALL("onSearchContact", new Object[] { Long.valueOf(this.val$id), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.3
 * JD-Core Version:    0.7.0.1
 */