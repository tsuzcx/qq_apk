package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

final class bv$17
  implements View.OnClickListener
{
  bv$17(bv parambv) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(308259);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    Log.i("MicroMsg.TimeLineClickEvent", "LiteApp Click");
    com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 35L, 1L);
    if ((paramView.getTag() instanceof s))
    {
      localObject1 = ((s)paramView.getTag()).RcF;
      if (((TimeLineObject)localObject1).liteappInfo != null) {
        break label125;
      }
      Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
    }
    label125:
    do
    {
      this.RFN.Rwb.onClick(paramView);
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(308259);
      return;
      localObject2 = ((TimeLineObject)localObject1).liteappInfo.appId;
    } while (Util.isNullOrNil((String)localObject2));
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).aJU((String)localObject2);
    if ((WeChatEnvironment.isCoolassistEnv()) || (bool)) {}
    for (int i = 1;; i = 0)
    {
      WxaLiteAppInfo localWxaLiteAppInfo = ((c)com.tencent.mm.kernel.h.ax(c.class)).et((String)localObject2);
      int j = i;
      if (i != 0)
      {
        j = i;
        if (localWxaLiteAppInfo == null)
        {
          if (((c)com.tencent.mm.kernel.h.ax(c.class)).fTU() == null) {
            ((c)com.tencent.mm.kernel.h.ax(c.class)).fTS();
          }
          ((c)com.tencent.mm.kernel.h.ax(c.class)).aJS((String)localObject2);
          j = 0;
        }
      }
      if (j != 0) {
        break label274;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 86L, 1L);
      break;
    }
    label274:
    bv.a((TimeLineObject)localObject1, ((s)paramView.getTag()).hES);
    com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 85L, 1L);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", ((TimeLineObject)localObject1).liteappInfo.appId);
    if (!Util.isNullOrNil(((TimeLineObject)localObject1).liteappInfo.path)) {
      ((Bundle)localObject2).putString("path", ((TimeLineObject)localObject1).liteappInfo.path);
    }
    if (!Util.isNullOrNil(((TimeLineObject)localObject1).liteappInfo.query)) {
      ((Bundle)localObject2).putString("query", ((TimeLineObject)localObject1).liteappInfo.query);
    }
    localObject1 = paramView.getContext();
    paramView.getContext().getString(b.j.app_tip);
    localObject1 = k.a((Context)localObject1, paramView.getContext().getString(b.j.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(paramView.getContext(), (Bundle)localObject2, false, true, new c.a()
    {
      public final void csx()
      {
        AppMethodBeat.i(307795);
        com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 33L, 1L);
        this.xin.cancel();
        AppMethodBeat.o(307795);
      }
      
      public final void csy()
      {
        AppMethodBeat.i(307797);
        aa.makeText(paramView.getContext(), b.j.loading_failed, 0).show();
        this.xin.cancel();
        AppMethodBeat.o(307797);
      }
    });
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bv.17
 * JD-Core Version:    0.7.0.1
 */