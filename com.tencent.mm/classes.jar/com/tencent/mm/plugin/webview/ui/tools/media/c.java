package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"})
public final class c
{
  public static final c Qud;
  private static final String TAG = "MicroMsg.MPVideoShareToSns";
  
  static
  {
    AppMethodBeat.i(268263);
    Qud = new c();
    TAG = "MicroMsg.MPVideoShareToSns";
    AppMethodBeat.o(268263);
  }
  
  public static void b(final jd paramjd, MMActivity paramMMActivity, final int paramInt)
  {
    AppMethodBeat.i(268261);
    if ((paramjd == null) || (paramMMActivity == null))
    {
      Log.w(TAG, "doShareToSns msgInfo is null");
      AppMethodBeat.o(268261);
      return;
    }
    Intent localIntent = new Intent();
    i locali = new i();
    locali.mbl = paramjd;
    localIntent.putExtra("ksnsupload_mp_video_xml", locali.boV());
    localIntent.putExtra("Ksnsupload_type", 19);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.by.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", localIntent, 5, (MMActivity.a)new a(paramMMActivity, paramjd, paramInt));
    AppMethodBeat.o(268261);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a
    implements MMActivity.a
  {
    a(MMActivity paramMMActivity, jd paramjd, int paramInt) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(229062);
      Object localObject;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.h.cL((Context)this.xzL, this.xzL.getString(c.i.app_shared));
        if ((this.xzL instanceof WebViewUI))
        {
          paramIntent = ((WebViewUI)this.xzL).PvJ;
          if (paramIntent != null)
          {
            localObject = paramjd;
            if (localObject == null) {
              p.iCn();
            }
            paramIntent.mu(((jd)localObject).RPa, "success");
          }
        }
        paramIntent = h.Quy;
        paramIntent = paramjd;
        if (paramIntent == null) {
          p.iCn();
        }
        paramIntent = paramIntent.RPa;
        p.j(paramIntent, "videoInfo!!.videoVid");
        localObject = paramjd;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((jd)localObject).ROZ;
        p.j(localObject, "videoInfo!!.mpUrl");
        h.a.i(2, paramIntent, (String)localObject, paramInt);
        AppMethodBeat.o(229062);
        return;
      }
      com.tencent.mm.ui.base.h.cL((Context)this.xzL, this.xzL.getString(c.i.share_err));
      if ((this.xzL instanceof WebViewUI))
      {
        paramIntent = ((WebViewUI)this.xzL).PvJ;
        if (paramIntent != null)
        {
          localObject = paramjd;
          if (localObject == null) {
            p.iCn();
          }
          paramIntent.mu(((jd)localObject).RPa, "canceled");
          AppMethodBeat.o(229062);
          return;
        }
      }
      AppMethodBeat.o(229062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */