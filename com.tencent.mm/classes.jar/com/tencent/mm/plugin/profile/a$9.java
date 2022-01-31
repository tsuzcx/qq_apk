package com.tencent.mm.plugin.profile;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class a$9
  implements f
{
  a$9(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(23214);
    paramm.setHasCallbackToQueue(true);
    paramString = (com.tencent.mm.plugin.profile.b.a)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramString.pxN == null) {
        paramString.pxN = ((ang)paramString.rr.fsW.fta);
      }
      String str = paramString.pxN.xdI;
      paramString = null;
      try
      {
        paramm = Uri.parse(str);
        paramString = paramm;
      }
      catch (Exception paramm)
      {
        for (;;)
        {
          ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramm.getMessage() });
        }
      }
      paramString = new Intent("android.intent.action.VIEW", paramString);
      this.pxs.jpX.startActivityForResult(paramString, 111);
      ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
      AppMethodBeat.o(23214);
      return;
    }
    ab.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
    if (paramString.pxN == null) {
      paramString.pxN = ((ang)paramString.rr.fsW.fta);
    }
    if ((paramString.pxN.BaseResponse != null) && (paramString.pxN.BaseResponse.ErrMsg != null)) {}
    for (paramString = bo.nullAsNil(paramString.pxN.BaseResponse.ErrMsg.xJE);; paramString = paramString.errMsg)
    {
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = this.pxs.jpX.getString(2131302032);
      }
      h.b(this.pxs.jpX, paramm, this.pxs.jpX.getString(2131304313), false);
      AppMethodBeat.o(23214);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.9
 * JD-Core Version:    0.7.0.1
 */