package com.tencent.mm.plugin.mv.ui.open.text_status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.a.c;
import com.tencent.mm.plugin.thumbplayer.d.c.c;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.plugin.thumbplayer.view.b;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;", "Lcom/tencent/mm/plugin/mv/ui/open/api/IMusicMvViewLifeCycle;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lyricManager", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "getLyricManager", "()Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "lyricManager$delegate", "Lkotlin/Lazy;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "needResumePosition", "", "onSceneEndListener", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "videoContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getVideoContainer", "()Landroid/widget/FrameLayout;", "videoContainer$delegate", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "addSceneEndListener", "", "checkVideoLayout", "fillMvByMusicShareObject", "obj", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mv", "fillSongInfoByMusicShareObject", "getMvDetailInfo", "mvObjectId", "", "mvNonceId", "", "getSongDetailInfo", "getSongIdWithCheckPermission", "handleGetCommentDetailResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "musicMvHashCode", "onBackground", "onForeground", "onMvPause", "onMvResume", "onViewCreate", "mvInfo", "onViewDestroy", "refreshVideo", "position", "removeSceneEndListener", "Companion", "plugin-mv_release"})
public final class MusicMvView
  extends RelativeLayout
{
  public static final MusicMvView.a Ghe;
  public bds GaB;
  public MultiMediaEffectVideoLayout GgY;
  public final com.tencent.mm.plugin.mv.model.f GgZ;
  private final kotlin.f Gha;
  public boolean Ghb;
  private final kotlin.f Ghc;
  public final i Ghd;
  
  static
  {
    AppMethodBeat.i(228487);
    Ghe = new MusicMvView.a((byte)0);
    AppMethodBeat.o(228487);
  }
  
  public MusicMvView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(228485);
    AppMethodBeat.o(228485);
  }
  
  public MusicMvView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(228484);
    AppMethodBeat.o(228484);
  }
  
  public MusicMvView(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228481);
    this.GgZ = new com.tencent.mm.plugin.mv.model.f();
    this.GaB = new bds();
    this.Gha = g.ar((kotlin.g.a.a)new g(this));
    this.Ghc = g.ar((kotlin.g.a.a)new d(this, paramContext));
    View.inflate(paramContext, b.f.FZO, (ViewGroup)this);
    this.Ghd = ((i)new e(this));
    AppMethodBeat.o(228481);
  }
  
  public static void a(dbr paramdbr, bds parambds)
  {
    AppMethodBeat.i(293188);
    Object localObject = paramdbr.HLH;
    int i;
    if (localObject != null)
    {
      p.j(localObject, "it");
      if (((CharSequence)localObject).length() <= 0) {
        break label398;
      }
      i = 1;
      if (i == 0) {
        break label403;
      }
      label40:
      if (localObject != null) {
        parambds.HLH = ((String)localObject);
      }
    }
    localObject = paramdbr.songLyric;
    if (localObject != null)
    {
      p.j(localObject, "it");
      if (((CharSequence)localObject).length() <= 0) {
        break label408;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label413;
      }
      label83:
      if (localObject != null) {
        parambds.SOL = ((String)localObject);
      }
    }
    localObject = paramdbr.albumName;
    if (localObject != null)
    {
      p.j(localObject, "it");
      if (((CharSequence)localObject).length() <= 0) {
        break label418;
      }
      i = 1;
      label122:
      if (i == 0) {
        break label423;
      }
      label126:
      if (localObject != null) {
        parambds.albumName = ((String)localObject);
      }
    }
    localObject = paramdbr.singerName;
    if (localObject != null)
    {
      p.j(localObject, "it");
      if (((CharSequence)localObject).length() <= 0) {
        break label428;
      }
      i = 1;
      label165:
      if (i == 0) {
        break label433;
      }
      label169:
      if (localObject != null) {
        parambds.ozs = ((String)localObject);
      }
    }
    localObject = paramdbr.KGh;
    if (localObject != null)
    {
      p.j(localObject, "it");
      if (((CharSequence)localObject).length() <= 0) {
        break label438;
      }
      i = 1;
      label208:
      if (i == 0) {
        break label443;
      }
      label212:
      if (localObject != null) {
        parambds.SOM = ((String)localObject);
      }
    }
    localObject = Long.valueOf(paramdbr.issueDate);
    if (((Number)localObject).longValue() > 0L)
    {
      i = 1;
      label243:
      if (i == 0) {
        break label453;
      }
      label247:
      if (localObject != null) {
        parambds.SOO = ((Number)localObject).longValue();
      }
      localObject = paramdbr.musicGenre;
      if (localObject != null)
      {
        p.j(localObject, "it");
        if (((CharSequence)localObject).length() <= 0) {
          break label458;
        }
        i = 1;
        label292:
        if (i == 0) {
          break label463;
        }
        label296:
        if (localObject != null) {
          parambds.SMY = ((String)localObject);
        }
      }
      localObject = paramdbr.identification;
      if (localObject != null)
      {
        p.j(localObject, "it");
        if (((CharSequence)localObject).length() <= 0) {
          break label468;
        }
        i = 1;
        label335:
        if (i == 0) {
          break label473;
        }
        label339:
        if (localObject != null) {
          parambds.identification = ((String)localObject);
        }
      }
      paramdbr = paramdbr.extraInfo;
      if (paramdbr == null) {
        break label488;
      }
      p.j(paramdbr, "it");
      if (((CharSequence)paramdbr).length() <= 0) {
        break label478;
      }
      i = 1;
      label378:
      if (i == 0) {
        break label483;
      }
    }
    for (;;)
    {
      if (paramdbr == null) {
        break label488;
      }
      parambds.extraInfo = paramdbr;
      AppMethodBeat.o(293188);
      return;
      label398:
      i = 0;
      break;
      label403:
      localObject = null;
      break label40;
      label408:
      i = 0;
      break label79;
      label413:
      localObject = null;
      break label83;
      label418:
      i = 0;
      break label122;
      label423:
      localObject = null;
      break label126;
      label428:
      i = 0;
      break label165;
      label433:
      localObject = null;
      break label169;
      label438:
      i = 0;
      break label208;
      label443:
      localObject = null;
      break label212;
      i = 0;
      break label243;
      label453:
      localObject = null;
      break label247;
      label458:
      i = 0;
      break label292;
      label463:
      localObject = null;
      break label296;
      label468:
      i = 0;
      break label335;
      label473:
      localObject = null;
      break label339;
      label478:
      i = 0;
      break label378;
      label483:
      paramdbr = null;
    }
    label488:
    AppMethodBeat.o(293188);
  }
  
  private final void fgI()
  {
    AppMethodBeat.i(228471);
    if (this.GgY == null)
    {
      Object localObject = getContext();
      p.j(localObject, "context");
      this.GgY = new MultiMediaEffectVideoLayout((Context)localObject);
      localObject = this.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).setMvMusicProxy((b)new b());
      }
      localObject = this.GgY;
      if (localObject != null)
      {
        ((MultiMediaEffectVideoLayout)localObject).setId(b.e.music_video_layout);
        AppMethodBeat.o(228471);
        return;
      }
    }
    AppMethodBeat.o(228471);
  }
  
  private final FrameLayout getVideoContainer()
  {
    AppMethodBeat.i(228467);
    FrameLayout localFrameLayout = (FrameLayout)this.Gha.getValue();
    AppMethodBeat.o(228467);
    return localFrameLayout;
  }
  
  public final void fgJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(228477);
    if (this.GgZ.Gbo.size() == 0)
    {
      Log.i("MicroMsg.Ts.MusicMvView", "refreshVideo 0 trackDataList empty");
      AppMethodBeat.o(228477);
      return;
    }
    Log.i("MicroMsg.Ts.MusicMvView", "refreshVideo, position:0");
    fgI();
    Object localObject3 = new StringBuilder("refreshVideo, videoLayout.parent:");
    Object localObject1 = this.GgY;
    if (localObject1 != null) {}
    for (localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();; localObject1 = null)
    {
      Log.i("MicroMsg.Ts.MusicMvView", localObject1);
      localObject3 = this.GgY;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((MultiMediaEffectVideoLayout)localObject3).getParent();
      }
      if (localObject1 == null)
      {
        localObject1 = this.GgY;
        if (localObject1 != null) {
          ((MultiMediaEffectVideoLayout)localObject1).setId(b.e.music_video_layout);
        }
        Log.i("MicroMsg.Ts.MusicMvView", "refreshVideo add videoLayout to current videoContainer");
        getVideoContainer().addView((View)this.GgY);
      }
      localObject1 = new StringBuilder("refreshVideo current music position:");
      localObject2 = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject2, "MusicPlayerManager.Instance()");
      localObject2 = ((com.tencent.mm.plugin.music.e.k)localObject2).feg();
      p.j(localObject2, "MusicPlayerManager.Instance().musicPlayer");
      Log.i("MicroMsg.Ts.MusicMvView", ((d)localObject2).fdx());
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setMute(true);
      }
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setMediaList((List)this.GgZ.ffZ());
      }
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setPlayStatusChangeListener((c.c)new f(this));
      }
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).start();
      }
      localObject1 = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject1, "MusicPlayerManager.Instance()");
      localObject1 = ((com.tencent.mm.plugin.music.e.k)localObject1).feg();
      p.j(localObject1, "MusicPlayerManager.Instance().musicPlayer");
      int j = ((d)localObject1).fdx();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).seekTo(i);
      }
      localObject1 = this.GgY;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setPauseOnVideoPlay(false);
      }
      localObject1 = this.GgY;
      if (localObject1 == null) {
        break;
      }
      ((MultiMediaEffectVideoLayout)localObject1).setKeepScreenOn(true);
      AppMethodBeat.o(228477);
      return;
    }
    AppMethodBeat.o(228477);
  }
  
  public final a getLyricManager()
  {
    AppMethodBeat.i(228468);
    a locala = (a)this.Ghc.getValue();
    AppMethodBeat.o(228468);
    return locala;
  }
  
  public final void getSongIdWithCheckPermission()
  {
    AppMethodBeat.i(293187);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new c(this.GaB, hashCode()));
    AppMethodBeat.o(293187);
  }
  
  public final void hfT()
  {
    AppMethodBeat.i(293186);
    com.tencent.mm.kernel.h.aGY().a(3763, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(5286, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(5292, this.Ghd);
    AppMethodBeat.o(293186);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView$checkVideoLayout$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
  public static final class b
    implements b
  {
    public final void ZN(int paramInt)
    {
      AppMethodBeat.i(226535);
      com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localk, "MusicPlayerManager.Instance()");
      localk.feg().wG(paramInt);
      AppMethodBeat.o(226535);
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(226533);
      Object localObject = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
      p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
      long l = ((d)localObject).fdx();
      AppMethodBeat.o(226533);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView$getMvDetailInfo$1$1"})
  public static final class c
    implements Runnable
  {
    public c(att paramatt, MusicMvView paramMusicMvView, com.tencent.mm.plugin.mv.model.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(230857);
      MusicMvView.a(this.Ghg, this.Ghf, this.Ghh.hashCode());
      AppMethodBeat.o(230857);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<a>
  {
    d(MusicMvView paramMusicMvView, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements i
  {
    e(MusicMvView paramMusicMvView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(231263);
      if (((paramq instanceof com.tencent.mm.plugin.mv.model.a.a)) && (((com.tencent.mm.plugin.mv.model.a.a)paramq).GcW != 0) && (((com.tencent.mm.plugin.mv.model.a.a)paramq).GcW != this.Ghg.hashCode()))
      {
        Log.i("MicroMsg.Ts.MusicMvView", "not the same page of netscene");
        AppMethodBeat.o(231263);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.h))
      {
        Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvGetFinderFeedDetail, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.mv.model.a.h)paramq).GaS;
          if (paramString != null)
          {
            MusicMvView.a(this.Ghg, paramString, ((com.tencent.mm.plugin.mv.model.a.h)paramq).Gdt);
            AppMethodBeat.o(231263);
            return;
          }
          AppMethodBeat.o(231263);
        }
      }
      else if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.k))
      {
        Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvGetSongStatus, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.mv.model.a.k)paramq).Gdz;
          if (paramString != null)
          {
            paramString = paramString.SOL;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() > 0)
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label302;
                }
              }
              for (;;)
              {
                if (paramString == null) {
                  break label307;
                }
                Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvGetSongStatus, lyric length:" + paramString.length());
                MusicMvView.b(this.Ghg).aSK(paramString);
                AppMethodBeat.o(231263);
                return;
                paramInt1 = 0;
                break;
                label302:
                paramString = null;
              }
            }
            label307:
            AppMethodBeat.o(231263);
            return;
          }
          AppMethodBeat.o(231263);
        }
      }
      else if ((paramq instanceof c))
      {
        Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvCheckPermission, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((c)paramq).Gdd;
          if (paramString != null)
          {
            MusicMvView.c(this.Ghg).kkU = paramString.TIm;
            Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvCheckPermission songId:" + paramString.TIm + " mvPostPermissionBit:" + paramString.TIo + " statusVerifyInfo:" + paramString.zfW);
            MusicMvView.a(this.Ghg, MusicMvView.c(this.Ghg));
            AppMethodBeat.o(231263);
            return;
          }
        }
      }
      AppMethodBeat.o(231263);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView$refreshVideo$1", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "onPause", "", "onResume", "plugin-mv_release"})
  public static final class f
    implements c.c
  {
    public final void onPause()
    {
      AppMethodBeat.i(228282);
      if (MusicMvView.a(this.Ghg).Gbz > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = MusicMvView.a(this.Ghg);
        localf.GbA += cm.bfE() - MusicMvView.a(this.Ghg).Gbz;
        MusicMvView.a(this.Ghg).Gbz = 0L;
      }
      AppMethodBeat.o(228282);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(228285);
      if (MusicMvView.a(this.Ghg).Gbz > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = MusicMvView.a(this.Ghg);
        localf.GbA += cm.bfE() - MusicMvView.a(this.Ghg).Gbz;
      }
      MusicMvView.a(this.Ghg).Gbz = cm.bfE();
      AppMethodBeat.o(228285);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    g(MusicMvView paramMusicMvView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView
 * JD-Core Version:    0.7.0.1
 */