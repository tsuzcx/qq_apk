package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/tools/VoiceStateHolder;", "", "()V", "TAG", "", "enableBackgroundVoice", "", "isNeedStop", "value", "needStop", "getNeedStop", "()Z", "setNeedStop", "(Z)V", "noneStopList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "jumpTo", "", "toWhere", "openAppbrand", "openFloatBallPage", "type", "", "app_release"})
public final class w
{
  private static final HashSet<String> Lij;
  private static boolean Lik;
  private static boolean Lil;
  public static final w Lim;
  
  static
  {
    AppMethodBeat.i(188375);
    Lim = new w();
    HashSet localHashSet = new HashSet();
    localHashSet.add("com.tencent.mm.ui.chatting.gallery.ImageGalleryUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI");
    localHashSet.add("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI");
    localHashSet.add("com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    Lij = localHashSet;
    if (((b)g.ab(b.class)).a(b.a.qPY, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Lil = bool;
      ((c)g.ab(c.class)).a(0, (f)new f()
      {
        public final void c(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(188372);
          ae.i("MicroMsg.VoiceStateHolder", "onFloatBallInfoClicked, ballInfo:".concat(String.valueOf(paramAnonymousBallInfo)));
          if (paramAnonymousBallInfo != null)
          {
            w localw = w.Lim;
            int i = paramAnonymousBallInfo.type;
            ae.i("MicroMsg.VoiceStateHolder", "open ball page type: ".concat(String.valueOf(i)));
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
              ae.i("MicroMsg.VoiceStateHolder", "need stop set to false for other float ball");
              w.yR(false);
              AppMethodBeat.o(188372);
              return;
            }
            ae.i("MicroMsg.VoiceStateHolder", "need stop set to true for voice/video ball");
            w.yR(true);
            AppMethodBeat.o(188372);
            return;
          }
          AppMethodBeat.o(188372);
        }
        
        public final void d(BallInfo paramAnonymousBallInfo) {}
        
        public final void e(BallInfo paramAnonymousBallInfo) {}
        
        public final void h(BallInfo paramAnonymousBallInfo) {}
      });
      AppMethodBeat.o(188375);
      return;
    }
  }
  
  public static void aYQ(String paramString)
  {
    AppMethodBeat.i(188373);
    p.h(paramString, "toWhere");
    ae.i("MicroMsg.VoiceStateHolder", "jump to ".concat(String.valueOf(paramString)));
    if (Lij.contains(paramString))
    {
      ae.i("MicroMsg.VoiceStateHolder", "need stop set to false");
      yR(false);
    }
    AppMethodBeat.o(188373);
  }
  
  public static boolean fPd()
  {
    if (Lil) {
      return Lik;
    }
    return true;
  }
  
  public static void fPe()
  {
    AppMethodBeat.i(188374);
    ae.i("MicroMsg.VoiceStateHolder", "open appBrand");
    yR(false);
    AppMethodBeat.o(188374);
  }
  
  public static void yR(boolean paramBoolean)
  {
    if (Lil) {
      Lik = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */