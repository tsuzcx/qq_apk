package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"})
public final class c
{
  public static final c EoL;
  private static final String TAG = "MicroMsg.MPVideoShareToSns";
  
  static
  {
    AppMethodBeat.i(207611);
    EoL = new c();
    TAG = "MicroMsg.MPVideoShareToSns";
    AppMethodBeat.o(207611);
  }
  
  public static void b(final jb paramjb, MMActivity paramMMActivity, final int paramInt)
  {
    AppMethodBeat.i(207610);
    if ((paramjb == null) || (paramMMActivity == null))
    {
      ad.w(TAG, "doShareToSns msgInfo is null");
      AppMethodBeat.o(207610);
      return;
    }
    Intent localIntent = new Intent();
    com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
    locald.ine = paramjb;
    localIntent.putExtra("ksnsupload_mp_video_xml", locald.aLf());
    localIntent.putExtra("Ksnsupload_type", 19);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.bs.d.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", localIntent, 5, (MMActivity.a)new a(paramMMActivity, paramjb, paramInt));
    AppMethodBeat.o(207610);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a
    implements MMActivity.a
  {
    a(MMActivity paramMMActivity, jb paramjb, int paramInt) {}
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(207609);
      Object localObject;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.h.ci((Context)this.sav, this.sav.getString(2131755894));
        if ((this.sav instanceof WebViewUI))
        {
          paramIntent = ((WebViewUI)this.sav).DzP;
          if (paramIntent != null)
          {
            localObject = paramjb;
            if (localObject == null) {
              p.gfZ();
            }
            paramIntent.kO(((jb)localObject).FCc, "success");
          }
        }
        paramIntent = h.Epa;
        paramIntent = paramjb;
        if (paramIntent == null) {
          p.gfZ();
        }
        paramIntent = paramIntent.FCc;
        p.g(paramIntent, "videoInfo!!.videoVid");
        localObject = paramjb;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((jb)localObject).FCb;
        p.g(localObject, "videoInfo!!.mpUrl");
        h.a.i(2, paramIntent, (String)localObject, paramInt);
        AppMethodBeat.o(207609);
        return;
      }
      com.tencent.mm.ui.base.h.ci((Context)this.sav, this.sav.getString(2131763645));
      if ((this.sav instanceof WebViewUI))
      {
        paramIntent = ((WebViewUI)this.sav).DzP;
        if (paramIntent != null)
        {
          localObject = paramjb;
          if (localObject == null) {
            p.gfZ();
          }
          paramIntent.kO(((jb)localObject).FCc, "canceled");
          AppMethodBeat.o(207609);
          return;
        }
      }
      AppMethodBeat.o(207609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.c
 * JD-Core Version:    0.7.0.1
 */