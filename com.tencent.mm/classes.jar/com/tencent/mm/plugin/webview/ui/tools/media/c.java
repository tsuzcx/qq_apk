package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"})
public final class c
{
  public static final c EGQ;
  private static final String TAG = "MicroMsg.MPVideoShareToSns";
  
  static
  {
    AppMethodBeat.i(199369);
    EGQ = new c();
    TAG = "MicroMsg.MPVideoShareToSns";
    AppMethodBeat.o(199369);
  }
  
  public static void b(final jb paramjb, MMActivity paramMMActivity, final int paramInt)
  {
    AppMethodBeat.i(199368);
    if ((paramjb == null) || (paramMMActivity == null))
    {
      ae.w(TAG, "doShareToSns msgInfo is null");
      AppMethodBeat.o(199368);
      return;
    }
    Intent localIntent = new Intent();
    com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
    locald.ipY = paramjb;
    localIntent.putExtra("ksnsupload_mp_video_xml", locald.aLC());
    localIntent.putExtra("Ksnsupload_type", 19);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.br.d.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", localIntent, 5, (MMActivity.a)new a(paramMMActivity, paramjb, paramInt));
    AppMethodBeat.o(199368);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a
    implements MMActivity.a
  {
    a(MMActivity paramMMActivity, jb paramjb, int paramInt) {}
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(199367);
      Object localObject;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.h.cj((Context)this.sjk, this.sjk.getString(2131755894));
        if ((this.sjk instanceof WebViewUI))
        {
          paramIntent = ((WebViewUI)this.sjk).DRx;
          if (paramIntent != null)
          {
            localObject = paramjb;
            if (localObject == null) {
              p.gkB();
            }
            paramIntent.kV(((jb)localObject).FUx, "success");
          }
        }
        paramIntent = h.EHf;
        paramIntent = paramjb;
        if (paramIntent == null) {
          p.gkB();
        }
        paramIntent = paramIntent.FUx;
        p.g(paramIntent, "videoInfo!!.videoVid");
        localObject = paramjb;
        if (localObject == null) {
          p.gkB();
        }
        localObject = ((jb)localObject).FUw;
        p.g(localObject, "videoInfo!!.mpUrl");
        h.a.i(2, paramIntent, (String)localObject, paramInt);
        AppMethodBeat.o(199367);
        return;
      }
      com.tencent.mm.ui.base.h.cj((Context)this.sjk, this.sjk.getString(2131763645));
      if ((this.sjk instanceof WebViewUI))
      {
        paramIntent = ((WebViewUI)this.sjk).DRx;
        if (paramIntent != null)
        {
          localObject = paramjb;
          if (localObject == null) {
            p.gkB();
          }
          paramIntent.kV(((jb)localObject).FUx, "canceled");
          AppMethodBeat.o(199367);
          return;
        }
      }
      AppMethodBeat.o(199367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */