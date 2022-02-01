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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.w;

final class bu$17
  implements View.OnClickListener
{
  bu$17(bu parambu) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(267930);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    Log.i("MicroMsg.TimeLineClickEvent", "LiteApp Click");
    com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 35L, 1L);
    if ((paramView.getTag() instanceof s))
    {
      localObject1 = ((s)paramView.getTag()).KCX;
      if (((TimeLineObject)localObject1).liteappInfo != null) {
        break label125;
      }
      Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
    }
    label125:
    do
    {
      this.LfB.KWe.onClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267930);
      return;
      localObject2 = ((TimeLineObject)localObject1).liteappInfo.appId;
    } while (Util.isNullOrNil((String)localObject2));
    boolean bool = ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).aMZ((String)localObject2);
    if ((WeChatEnvironment.isCoolassistEnv()) || (bool)) {}
    for (int i = 1;; i = 0)
    {
      f.eLH();
      WxaLiteAppInfo localWxaLiteAppInfo = f.cY((String)localObject2);
      int j = i;
      if (i != 0)
      {
        j = i;
        if (localWxaLiteAppInfo == null)
        {
          f.eLH();
          if (f.eLJ() == null) {
            f.eLH().eLK();
          }
          f.eLH().a((String)localObject2, null);
          j = 0;
        }
      }
      if (j != 0) {
        break label249;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 86L, 1L);
      break;
    }
    label249:
    com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 85L, 1L);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", ((TimeLineObject)localObject1).liteappInfo.appId);
    if (!Util.isNullOrNil(((TimeLineObject)localObject1).liteappInfo.path)) {
      ((Bundle)localObject2).putString("path", ((TimeLineObject)localObject1).liteappInfo.path);
    }
    if (!Util.isNullOrNil(((TimeLineObject)localObject1).liteappInfo.query)) {
      ((Bundle)localObject2).putString("query", ((TimeLineObject)localObject1).liteappInfo.query);
    }
    localObject1 = paramView.getContext();
    paramView.getContext().getString(i.j.app_tip);
    localObject1 = com.tencent.mm.ui.base.h.a((Context)localObject1, paramView.getContext().getString(i.j.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).a(paramView.getContext(), (Bundle)localObject2, false, new a.a()
    {
      public final void ewC()
      {
        AppMethodBeat.i(267267);
        com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 33L, 1L);
        this.ucj.cancel();
        AppMethodBeat.o(267267);
      }
      
      public final void ewD()
      {
        AppMethodBeat.i(267268);
        w.makeText(paramView.getContext(), i.j.loading_failed, 0).show();
        this.ucj.cancel();
        AppMethodBeat.o(267268);
      }
    });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu.17
 * JD-Core Version:    0.7.0.1
 */