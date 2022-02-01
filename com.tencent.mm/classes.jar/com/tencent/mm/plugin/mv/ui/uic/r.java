package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lyricView", "Lcom/tencent/mm/plugin/music/ui/LyricView;", "getLyricView", "()Lcom/tencent/mm/plugin/music/ui/LyricView;", "setLyricView", "(Lcom/tencent/mm/plugin/music/ui/LyricView;)V", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "initBgLyric", "", "onPause", "onResume", "plugin-mv_release"})
public final class r
  extends UIComponent
{
  private final d.a FOE;
  LyricView FUB;
  public bds GaB;
  private final String TAG;
  
  public r(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(227298);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewLyricUIC";
    this.FOE = ((d.a)new a(this));
    AppMethodBeat.o(227298);
  }
  
  public final void fht()
  {
    AppMethodBeat.i(227296);
    this.FUB = ((LyricView)getActivity().findViewById(b.e.lyric_view));
    int i = com.tencent.mm.ci.a.fromDPToPix((Context)getActivity(), 22);
    int j = com.tencent.mm.ci.a.fromDPToPix((Context)getActivity(), 4.0F);
    int k = com.tencent.mm.ci.a.fromDPToPix((Context)getActivity(), 4.0F);
    Object localObject1 = this.FUB;
    if (localObject1 != null) {
      ((LyricView)localObject1).a(Paint.Align.LEFT, i, j, k);
    }
    localObject1 = this.FUB;
    if (localObject1 != null) {
      ((LyricView)localObject1).setMode(1);
    }
    localObject1 = this.FUB;
    if (localObject1 != null) {}
    for (localObject1 = ((LyricView)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(227296);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    Object localObject2 = getActivity().getResources();
    p.j(localObject2, "activity.resources");
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = ((int)(((Resources)localObject2).getDisplayMetrics().heightPixels * 0.37F));
    localObject1 = this.GaB;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((bds)localObject1).SOL;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label362;
        }
        i = 1;
        label233:
        if (i == 0) {
          break label367;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = e.a(((bds)localObject1).SOL, getActivity().getString(b.h.music_prefix), "", m.jj(((bds)localObject1).SOK, ((bds)localObject1).musicDataUrl), ((bds)localObject1).ozs, false, false);
          p.j(localObject2, "lyricObj");
          if (((e)localObject2).feO() > 1)
          {
            LyricView localLyricView = this.FUB;
            if (localLyricView != null) {
              localLyricView.setLyricObj((e)localObject2);
            }
            if (!m.jj(((bds)localObject1).SOK, ((bds)localObject1).musicDataUrl))
            {
              localObject1 = this.FUB;
              if (localObject1 != null)
              {
                ((LyricView)localObject1).setCurrentTime(1L);
                AppMethodBeat.o(227296);
                return;
                i = 0;
                break;
                label362:
                i = 0;
                break label233;
                label367:
                localObject1 = null;
                continue;
              }
            }
          }
          AppMethodBeat.o(227296);
          return;
        }
      }
    }
    AppMethodBeat.o(227296);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(227283);
    k localk = k.fet();
    p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().b(this.FOE);
    AppMethodBeat.o(227283);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(227279);
    k localk = k.fet();
    p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().a(this.FOE);
    AppMethodBeat.o(227279);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class a
    implements d.a
  {
    a(r paramr) {}
    
    public final void fK(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(228248);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(228248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.r
 * JD-Core Version:    0.7.0.1
 */