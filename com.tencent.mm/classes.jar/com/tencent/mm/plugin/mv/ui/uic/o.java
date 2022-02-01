package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lyricView", "Lcom/tencent/mm/plugin/music/ui/LyricView;", "getLyricView", "()Lcom/tencent/mm/plugin/music/ui/LyricView;", "setLyricView", "(Lcom/tencent/mm/plugin/music/ui/LyricView;)V", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "initBgLyric", "", "onPause", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends UIComponent
{
  private final d.a LJz;
  LyricView LPB;
  public boo LWI;
  private final String TAG;
  
  public o(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287700);
    this.TAG = "MicroMsg.Mv.MusicMvPreviewLyricUIC";
    this.LJz = new o..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(287700);
  }
  
  private static final void a(final o paramo, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(287714);
    s.u(paramo, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramInt1, paramInt2, paramo));
    AppMethodBeat.o(287714);
  }
  
  public final void gre()
  {
    AppMethodBeat.i(287775);
    this.LPB = ((LyricView)getActivity().findViewById(b.e.lyric_view));
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 22);
    int j = com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 4.0F);
    int k = com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 4.0F);
    Object localObject1 = this.LPB;
    if (localObject1 != null) {
      ((LyricView)localObject1).a(Paint.Align.LEFT, i, j, k);
    }
    localObject1 = this.LPB;
    if (localObject1 != null) {
      ((LyricView)localObject1).setMode(1);
    }
    localObject1 = this.LPB;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((LyricView)localObject1).getLayoutParams())
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(287775);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = ((int)(getActivity().getResources().getDisplayMetrics().heightPixels * 0.37F));
    localObject1 = this.LWI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (CharSequence)((boo)localObject1).Mcq;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label338;
      }
      i = 1;
      if (i != 0) {
        break label343;
      }
      i = 1;
      label218:
      if (i == 0) {
        break label348;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = e.a(((boo)localObject1).Mcq, getActivity().getString(b.h.music_prefix), "", m.ky(((boo)localObject1).ZWR, ((boo)localObject1).musicDataUrl), ((boo)localObject1).rDl, false, false);
        if (((e)localObject2).LMm.size() > 1)
        {
          LyricView localLyricView = this.LPB;
          if (localLyricView != null) {
            localLyricView.setLyricObj((e)localObject2);
          }
          if (!m.ky(((boo)localObject1).ZWR, ((boo)localObject1).musicDataUrl))
          {
            localObject1 = this.LPB;
            if (localObject1 != null) {
              ((LyricView)localObject1).setCurrentTime(1L);
            }
          }
        }
      }
      AppMethodBeat.o(287775);
      return;
      label338:
      i = 0;
      break;
      label343:
      i = 0;
      break label218;
      label348:
      localObject1 = null;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287752);
    j.gnw().gnj().b(this.LJz);
    AppMethodBeat.o(287752);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287743);
    j.gnw().gnj().a(this.LJz);
    AppMethodBeat.o(287743);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(int paramInt1, int paramInt2, o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.o
 * JD-Core Version:    0.7.0.1
 */