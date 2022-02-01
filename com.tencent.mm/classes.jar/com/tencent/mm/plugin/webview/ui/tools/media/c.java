package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"})
public final class c
{
  public static final c Jwu;
  private static final String TAG = "MicroMsg.MPVideoShareToSns";
  
  static
  {
    AppMethodBeat.i(210561);
    Jwu = new c();
    TAG = "MicroMsg.MPVideoShareToSns";
    AppMethodBeat.o(210561);
  }
  
  public static void b(final jo paramjo, MMActivity paramMMActivity, final int paramInt)
  {
    AppMethodBeat.i(210560);
    if ((paramjo == null) || (paramMMActivity == null))
    {
      Log.w(TAG, "doShareToSns msgInfo is null");
      AppMethodBeat.o(210560);
      return;
    }
    Intent localIntent = new Intent();
    com.tencent.mm.modelsns.h localh = new com.tencent.mm.modelsns.h();
    localh.jli = paramjo;
    localIntent.putExtra("ksnsupload_mp_video_xml", localh.bfF());
    localIntent.putExtra("Ksnsupload_type", 19);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.br.c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", localIntent, 5, (MMActivity.a)new a(paramMMActivity, paramjo, paramInt));
    AppMethodBeat.o(210560);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a
    implements MMActivity.a
  {
    a(MMActivity paramMMActivity, jo paramjo, int paramInt) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(210559);
      Object localObject;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.h.cA((Context)this.tTu, this.tTu.getString(2131755986));
        if ((this.tTu instanceof WebViewUI))
        {
          paramIntent = ((WebViewUI)this.tTu).IBw;
          if (paramIntent != null)
          {
            localObject = paramjo;
            if (localObject == null) {
              p.hyc();
            }
            paramIntent.lT(((jo)localObject).KOf, "success");
          }
        }
        paramIntent = h.JwJ;
        paramIntent = paramjo;
        if (paramIntent == null) {
          p.hyc();
        }
        paramIntent = paramIntent.KOf;
        p.g(paramIntent, "videoInfo!!.videoVid");
        localObject = paramjo;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((jo)localObject).KOe;
        p.g(localObject, "videoInfo!!.mpUrl");
        h.a.i(2, paramIntent, (String)localObject, paramInt);
        AppMethodBeat.o(210559);
        return;
      }
      com.tencent.mm.ui.base.h.cA((Context)this.tTu, this.tTu.getString(2131765833));
      if ((this.tTu instanceof WebViewUI))
      {
        paramIntent = ((WebViewUI)this.tTu).IBw;
        if (paramIntent != null)
        {
          localObject = paramjo;
          if (localObject == null) {
            p.hyc();
          }
          paramIntent.lT(((jo)localObject).KOf, "canceled");
          AppMethodBeat.o(210559);
          return;
        }
      }
      AppMethodBeat.o(210559);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */