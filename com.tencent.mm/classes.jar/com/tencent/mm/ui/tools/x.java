package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/tools/VoiceStateHolder;", "", "()V", "TAG", "", "enableBackgroundVoice", "", "isNeedStop", "value", "needStop", "getNeedStop", "()Z", "setNeedStop", "(Z)V", "noneStopList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "jumpTo", "", "toWhere", "openAppbrand", "openFloatBallPage", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x afLD;
  private static final HashSet<String> afLE;
  private static boolean afLF;
  private static boolean afLG;
  
  static
  {
    AppMethodBeat.i(251086);
    afLD = new x();
    HashSet localHashSet = new HashSet();
    localHashSet.add("com.tencent.mm.ui.chatting.gallery.ImageGalleryUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localHashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI");
    localHashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI");
    localHashSet.add("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI");
    localHashSet.add("com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localHashSet.add("com.tencent.mm.compose_chatting.VoiceSeekUI");
    afLE = localHashSet;
    if (((c)h.ax(c.class)).a(c.a.zrZ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      afLG = bool;
      ((b)h.ax(b.class)).a(0, (e)new f()
      {
        public final void b(BallInfo paramAnonymousBallInfo)
        {
          AppMethodBeat.i(251127);
          Log.i("MicroMsg.VoiceStateHolder", s.X("onFloatBallInfoClicked, ballInfo:", paramAnonymousBallInfo));
          int i;
          if (paramAnonymousBallInfo != null)
          {
            x localx = x.afLD;
            i = paramAnonymousBallInfo.type;
            Log.i("MicroMsg.VoiceStateHolder", s.X("open ball page type: ", Integer.valueOf(i)));
          }
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
            x.Nb(false);
            AppMethodBeat.o(251127);
            return;
          }
          Log.i("MicroMsg.VoiceStateHolder", "need stop set to true for voice/video ball");
          x.Nb(true);
          AppMethodBeat.o(251127);
        }
        
        public final void c(BallInfo paramAnonymousBallInfo) {}
        
        public final void d(BallInfo paramAnonymousBallInfo) {}
        
        public final void g(BallInfo paramAnonymousBallInfo) {}
      });
      AppMethodBeat.o(251086);
      return;
    }
  }
  
  public static void Nb(boolean paramBoolean)
  {
    if (afLG) {
      afLF = paramBoolean;
    }
  }
  
  public static void bCG(String paramString)
  {
    AppMethodBeat.i(251080);
    s.u(paramString, "toWhere");
    Log.i("MicroMsg.VoiceStateHolder", s.X("jump to ", paramString));
    if (afLE.contains(paramString))
    {
      Log.i("MicroMsg.VoiceStateHolder", "need stop set to false");
      Nb(false);
    }
    AppMethodBeat.o(251080);
  }
  
  public static boolean jDr()
  {
    if (afLG) {
      return afLF;
    }
    return true;
  }
  
  public static void jDs()
  {
    AppMethodBeat.i(251082);
    Log.i("MicroMsg.VoiceStateHolder", "open appBrand");
    Nb(false);
    AppMethodBeat.o(251082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */