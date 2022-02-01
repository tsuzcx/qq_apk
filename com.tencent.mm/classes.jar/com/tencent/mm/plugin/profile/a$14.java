package com.tencent.mm.plugin.profile;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class a$14
  implements i
{
  a$14(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(270395);
    paramq.setHasCallbackToQueue(true);
    paramString = (com.tencent.mm.plugin.profile.b.a)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramString.GWT == null) {
        paramString.GWT = ((bzp)d.c.b(paramString.rr.lBS));
      }
      String str = paramString.GWT.Tis;
      paramString = null;
      try
      {
        paramq = Uri.parse(str);
        paramString = paramq;
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramq.getMessage() });
        }
      }
      paramString = new Intent("android.intent.action.VIEW", paramString);
      this.GWs.tmY.startActivityForResult(paramString, 111);
      Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
      AppMethodBeat.o(270395);
      return;
    }
    Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
    if (paramString.GWT == null) {
      paramString.GWT = ((bzp)d.c.b(paramString.rr.lBS));
    }
    if ((paramString.GWT.BaseResponse != null) && (paramString.GWT.BaseResponse.Tef != null)) {}
    for (paramString = Util.nullAsNil(paramString.GWT.BaseResponse.Tef.Ufy);; paramString = paramString.errMsg)
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = this.GWs.tmY.getString(R.l.eOM);
      }
      h.c(this.GWs.tmY, paramq, this.GWs.tmY.getString(R.l.tip_title), false);
      AppMethodBeat.o(270395);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.14
 * JD-Core Version:    0.7.0.1
 */