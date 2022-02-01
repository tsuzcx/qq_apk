package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/tools/VoiceStateHolder;", "", "()V", "TAG", "", "enableBackgroundVoice", "", "isNeedStop", "value", "needStop", "getNeedStop", "()Z", "setNeedStop", "(Z)V", "noneStopList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "jumpTo", "", "toWhere", "openAppbrand", "openFloatBallPage", "type", "", "app_release"})
public final class x
{
  private static final HashSet<String> Qxi;
  private static boolean Qxj;
  private static boolean Qxk;
  public static final x Qxl;
  
  static
  {
    AppMethodBeat.i(231384);
    Qxl = new x();
    HashSet localHashSet = new HashSet();
    localHashSet.add("com.tencent.mm.ui.chatting.gallery.ImageGalleryUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI");
    localHashSet.add("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI");
    localHashSet.add("com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    Qxi = localHashSet;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snt, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Qxk = bool;
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(0, (e)new e()
      {
        public final void b(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(231381);
          Log.i("MicroMsg.VoiceStateHolder", "onFloatBallInfoClicked, ballInfo:".concat(String.valueOf(paramAnonymousBallInfo)));
          if (paramAnonymousBallInfo != null)
          {
            x localx = x.Qxl;
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
              x.CM(false);
              AppMethodBeat.o(231381);
              return;
            }
            Log.i("MicroMsg.VoiceStateHolder", "need stop set to true for voice/video ball");
            x.CM(true);
            AppMethodBeat.o(231381);
            return;
          }
          AppMethodBeat.o(231381);
        }
        
        public final void c(BallInfo paramAnonymousBallInfo) {}
        
        public final void d(BallInfo paramAnonymousBallInfo) {}
        
        public final void g(BallInfo paramAnonymousBallInfo) {}
      });
      AppMethodBeat.o(231384);
      return;
    }
  }
  
  public static void CM(boolean paramBoolean)
  {
    if (Qxk) {
      Qxj = paramBoolean;
    }
  }
  
  public static void bnV(String paramString)
  {
    AppMethodBeat.i(231382);
    p.h(paramString, "toWhere");
    Log.i("MicroMsg.VoiceStateHolder", "jump to ".concat(String.valueOf(paramString)));
    if (Qxi.contains(paramString))
    {
      Log.i("MicroMsg.VoiceStateHolder", "need stop set to false");
      CM(false);
    }
    AppMethodBeat.o(231382);
  }
  
  public static boolean gXX()
  {
    if (Qxk) {
      return Qxj;
    }
    return true;
  }
  
  public static void gXY()
  {
    AppMethodBeat.i(231383);
    Log.i("MicroMsg.VoiceStateHolder", "open appBrand");
    CM(false);
    AppMethodBeat.o(231383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */