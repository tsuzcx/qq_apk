package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.bo;

final class Updater$4
  implements f
{
  Updater$4(Updater paramUpdater, TextView paramTextView) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(28935);
    aw.Rc().b(3899, Updater.g(this.ylv));
    Updater.a(this.ylv, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = ((bjv)((b)paramm.getReqResp()).fsW.fta).xyk;
      paramString = new e(paramm);
      if ((paramm != null) && (paramm.xyp == 3))
      {
        paramm = new Intent(this.ylv.getContext(), AppUpdaterUI.class);
        if (e.QR(paramString.clientVersion)) {
          if (bo.isNullOrNil(paramString.nKW))
          {
            paramString = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
            paramm = new Intent("android.intent.action.VIEW");
            paramm.setClassName(this.ylv.getContext().getPackageName(), this.ylv.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            paramm.putExtra("rawUrl", paramString);
            paramm.putExtra("useJs", true);
            paramm.putExtra("vertical_scroll", true);
            paramm.setFlags(872415232);
            this.ylv.getContext().startActivity(paramm);
          }
        }
        for (;;)
        {
          if (Updater.h(this.ylv) != null) {
            Updater.h(this.ylv).cancel();
          }
          this.ylv.onStop();
          AppMethodBeat.o(28935);
          return;
          paramString = paramString.nKW;
          break;
          this.ylv.a(paramm, paramString);
          this.ylv.getContext().startActivity(paramm);
        }
      }
      if (Updater.h(this.ylv).findViewById(2131821847) != null) {
        Updater.h(this.ylv).findViewById(2131821847).setVisibility(8);
      }
      if (this.ylx != null)
      {
        h.qsU.idkeyStat(405L, 63L, 1L, true);
        this.ylx.setText(2131304434);
      }
      AppMethodBeat.o(28935);
      return;
    }
    if (Updater.h(this.ylv).findViewById(2131821847) != null) {
      Updater.h(this.ylv).findViewById(2131821847).setVisibility(8);
    }
    if (this.ylx != null)
    {
      h.qsU.idkeyStat(405L, 63L, 1L, true);
      this.ylx.setText(2131304434);
    }
    AppMethodBeat.o(28935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.4
 * JD-Core Version:    0.7.0.1
 */