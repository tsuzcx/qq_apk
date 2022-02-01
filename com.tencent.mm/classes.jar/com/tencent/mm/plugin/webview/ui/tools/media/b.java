package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoShareToSns;", "", "()V", "TAG", "", "doShareToSns", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "context", "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b Xmj;
  
  static
  {
    AppMethodBeat.i(296699);
    Xmj = new b();
    TAG = "MicroMsg.MPVideoShareToSns";
    AppMethodBeat.o(296699);
  }
  
  private static final void a(MMActivity paramMMActivity, jz paramjz, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(296697);
    if (paramInt3 == -1)
    {
      k.cZ((Context)paramMMActivity, paramMMActivity.getString(c.i.app_shared));
      if ((paramMMActivity instanceof WebViewUI))
      {
        paramMMActivity = ((WebViewUI)paramMMActivity).WlX;
        if (paramMMActivity != null)
        {
          s.checkNotNull(paramjz);
          paramMMActivity.ok(paramjz.YMn, "success");
        }
      }
      paramMMActivity = g.Xms;
      s.checkNotNull(paramjz);
      paramMMActivity = paramjz.YMn;
      s.s(paramMMActivity, "videoInfo!!.videoVid");
      paramjz = paramjz.YMm;
      s.s(paramjz, "videoInfo!!.mpUrl");
      g.a.h(2, paramMMActivity, paramjz, paramInt1);
      AppMethodBeat.o(296697);
      return;
    }
    k.cZ((Context)paramMMActivity, paramMMActivity.getString(c.i.share_err));
    if ((paramMMActivity instanceof WebViewUI))
    {
      paramMMActivity = ((WebViewUI)paramMMActivity).WlX;
      if (paramMMActivity != null)
      {
        s.checkNotNull(paramjz);
        paramMMActivity.ok(paramjz.YMn, "canceled");
      }
    }
    AppMethodBeat.o(296697);
  }
  
  public static void b(jz paramjz, MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(296691);
    if ((paramjz == null) || (paramMMActivity == null))
    {
      Log.w(TAG, "doShareToSns msgInfo is null");
      AppMethodBeat.o(296691);
      return;
    }
    Intent localIntent = new Intent();
    i locali = new i();
    locali.oUf = paramjz;
    localIntent.putExtra("ksnsupload_mp_video_xml", i.b(locali.oUf));
    localIntent.putExtra("Ksnsupload_type", 19);
    localIntent.putExtra("need_result", true);
    c.a(paramMMActivity, ".plugin.sns.ui.SnsUploadUI", localIntent, 209, new b..ExternalSyntheticLambda0(paramMMActivity, paramjz, paramInt));
    AppMethodBeat.o(296691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.b
 * JD-Core Version:    0.7.0.1
 */