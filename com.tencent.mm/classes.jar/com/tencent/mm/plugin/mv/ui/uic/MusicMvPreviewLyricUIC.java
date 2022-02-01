package com.tencent.mm.plugin.mv.ui.uic;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lyricView", "Lcom/tencent/mm/plugin/music/ui/LyricView;", "getLyricView", "()Lcom/tencent/mm/plugin/music/ui/LyricView;", "setLyricView", "(Lcom/tencent/mm/plugin/music/ui/LyricView;)V", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "initBgLyric", "", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvPreviewLyricUIC
  extends UIComponent
{
  private final d.a AhI;
  public LyricView Anv;
  public axy Aqo;
  private final String TAG;
  
  public MusicMvPreviewLyricUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257330);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewLyricUIC";
    this.AhI = ((d.a)new a(this));
    AppMethodBeat.o(257330);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257329);
    k localk = k.euj();
    p.g(localk, "MusicPlayerManager.Instance()");
    localk.etW().a(null);
    AppMethodBeat.o(257329);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257328);
    k localk = k.euj();
    p.g(localk, "MusicPlayerManager.Instance()");
    localk.etW().a(this.AhI);
    AppMethodBeat.o(257328);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class a
    implements d.a
  {
    a(MusicMvPreviewLyricUIC paramMusicMvPreviewLyricUIC) {}
    
    public final void fn(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(257327);
      com.tencent.mm.ac.d.h((a)new q(paramInt1) {});
      AppMethodBeat.o(257327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewLyricUIC
 * JD-Core Version:    0.7.0.1
 */