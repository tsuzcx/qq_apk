package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/tools/VoiceStateHolder;", "", "()V", "TAG", "", "enableBackgroundVoice", "", "isNeedStop", "value", "needStop", "getNeedStop", "()Z", "setNeedStop", "(Z)V", "noneStopList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "jumpTo", "", "toWhere", "openAppbrand", "openFloatBallPage", "type", "", "app_release"})
public final class y
{
  private static final HashSet<String> XVo;
  private static boolean XVp;
  private static boolean XVq;
  public static final y XVr;
  
  static
  {
    AppMethodBeat.i(272909);
    XVr = new y();
    HashSet localHashSet = new HashSet();
    localHashSet.add("com.tencent.mm.ui.chatting.gallery.ImageGalleryUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI");
    localHashSet.add("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI");
    localHashSet.add("com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    XVo = localHashSet;
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYF, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      XVq = bool;
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(0, (e)new e()
      {
        public final void b(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(285907);
          Log.i("MicroMsg.VoiceStateHolder", "onFloatBallInfoClicked, ballInfo:".concat(String.valueOf(paramAnonymousBallInfo)));
          if (paramAnonymousBallInfo != null)
          {
            y localy = y.XVr;
            int i = paramAnonymousBallInfo.type;
            Log.i("MicroMsg.VoiceStateHolder", "open ball page type: ".concat(String.valueOf(i)));
            switch (i)
            {
            case 7: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            default: 
              Log.i("MicroMsg.VoiceStateHolder", "need stop set to false for other float ball");
              y.Hg(false);
              AppMethodBeat.o(285907);
              return;
            }
            Log.i("MicroMsg.VoiceStateHolder", "need stop set to true for voice/video ball");
            y.Hg(true);
            AppMethodBeat.o(285907);
            return;
          }
          AppMethodBeat.o(285907);
        }
        
        public final void c(BallInfo paramAnonymousBallInfo) {}
        
        public final void d(BallInfo paramAnonymousBallInfo) {}
        
        public final void g(BallInfo paramAnonymousBallInfo) {}
      });
      AppMethodBeat.o(272909);
      return;
    }
  }
  
  public static void Hg(boolean paramBoolean)
  {
    if (XVq) {
      XVp = paramBoolean;
    }
  }
  
  public static void bAI(String paramString)
  {
    AppMethodBeat.i(272907);
    p.k(paramString, "toWhere");
    Log.i("MicroMsg.VoiceStateHolder", "jump to ".concat(String.valueOf(paramString)));
    if (XVo.contains(paramString))
    {
      Log.i("MicroMsg.VoiceStateHolder", "need stop set to false");
      Hg(false);
    }
    AppMethodBeat.o(272907);
  }
  
  public static boolean hYI()
  {
    if (XVq) {
      return XVp;
    }
    return true;
  }
  
  public static void hYJ()
  {
    AppMethodBeat.i(272908);
    Log.i("MicroMsg.VoiceStateHolder", "open appBrand");
    Hg(false);
    AppMethodBeat.o(272908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.y
 * JD-Core Version:    0.7.0.1
 */