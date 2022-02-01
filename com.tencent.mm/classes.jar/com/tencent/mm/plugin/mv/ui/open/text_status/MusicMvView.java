package com.tencent.mm.plugin.mv.ui.open.text_status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.music.e.a.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.a.o;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.thumbplayer.c.b.c;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;", "Lcom/tencent/mm/plugin/mv/ui/open/api/IMusicMvViewLifeCycle;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lyricManager", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "getLyricManager", "()Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "lyricManager$delegate", "Lkotlin/Lazy;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "needResumePosition", "", "onSceneEndListener", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "videoContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getVideoContainer", "()Landroid/widget/FrameLayout;", "videoContainer$delegate", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "addSceneEndListener", "", "checkVideoLayout", "fillMvByMusicShareObject", "obj", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mv", "fillSongInfoByMusicShareObject", "getMvDetailInfo", "mvObjectId", "", "mvNonceId", "", "getSongDetailInfo", "getSongIdWithCheckPermission", "handleGetCommentDetailResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "musicMvHashCode", "onBackground", "onForeground", "onMvPause", "onMvResume", "onViewCreate", "mvInfo", "onViewDestroy", "refreshVideo", "position", "removeSceneEndListener", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvView
  extends RelativeLayout
{
  public static final MusicMvView.a Mch;
  public boo LWI;
  public final com.tencent.mm.am.h LYH;
  public MultiMediaEffectVideoLayout Mci;
  public final com.tencent.mm.plugin.mv.model.f Mcj;
  private final kotlin.j Mck;
  public boolean Mcl;
  private final kotlin.j Mcm;
  
  static
  {
    AppMethodBeat.i(286662);
    Mch = new MusicMvView.a((byte)0);
    AppMethodBeat.o(286662);
  }
  
  public MusicMvView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(286577);
    AppMethodBeat.o(286577);
  }
  
  public MusicMvView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(286571);
    AppMethodBeat.o(286571);
  }
  
  public MusicMvView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286564);
    this.Mcj = new com.tencent.mm.plugin.mv.model.f();
    this.LWI = new boo();
    this.Mck = kotlin.k.cm((kotlin.g.a.a)new MusicMvView.e(this));
    this.Mcm = kotlin.k.cm((kotlin.g.a.a)new MusicMvView.c(paramContext, this));
    View.inflate(paramContext, b.f.LVP, (ViewGroup)this);
    this.LYH = new MusicMvView..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(286564);
  }
  
  private static final void a(MusicMvView paramMusicMvView, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(286652);
    kotlin.g.b.s.u(paramMusicMvView, "this$0");
    if (((paramp instanceof com.tencent.mm.plugin.mv.model.a.a)) && (((com.tencent.mm.plugin.mv.model.a.a)paramp).LYA != 0) && (((com.tencent.mm.plugin.mv.model.a.a)paramp).LYA != paramMusicMvView.hashCode()))
    {
      Log.i("MicroMsg.Ts.MusicMvView", "not the same page of netscene");
      AppMethodBeat.o(286652);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.k))
    {
      Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvGetFinderFeedDetail, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.k)paramp).LWS;
        if (paramString != null)
        {
          paramMusicMvView.a(paramString, ((com.tencent.mm.plugin.mv.model.a.k)paramp).LZe);
          AppMethodBeat.o(286652);
        }
      }
    }
    else if ((paramp instanceof o))
    {
      Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvGetSongStatus, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((o)paramp).LZo;
        if (paramString != null)
        {
          paramString = paramString.Mcq;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label276;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label281;
            }
          }
          for (;;)
          {
            if (paramString != null)
            {
              Log.i("MicroMsg.Ts.MusicMvView", kotlin.g.b.s.X("NetSceneMusicMvGetSongStatus, lyric length:", Integer.valueOf(paramString.length())));
              paramMusicMvView.getLyricManager().aPE(paramString);
            }
            AppMethodBeat.o(286652);
            return;
            label276:
            paramInt1 = 0;
            break;
            label281:
            paramString = null;
          }
        }
      }
    }
    else if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.f))
    {
      Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvCheckPermission, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.f)paramp).LYP;
        if (paramString != null)
        {
          paramMusicMvView.LWI.mLQ = paramString.aaXV;
          Log.i("MicroMsg.Ts.MusicMvView", "NetSceneMusicMvCheckPermission songId:" + paramString.aaXV + " mvPostPermissionBit:" + paramString.aaXX + " statusVerifyInfo:" + paramString.EdM);
          paramString = paramMusicMvView.LWI;
          Log.i("MicroMsg.Ts.MusicMvView", "getSongDetailInfo songId:" + paramString.mLQ + " appId:" + paramString.ZWQ + " webUrl:" + paramString.ZWR);
          com.tencent.mm.kernel.h.aZW().a((p)new o(paramString, paramMusicMvView.hashCode()), 0);
        }
      }
    }
    AppMethodBeat.o(286652);
  }
  
  private static final void a(MusicMvView paramMusicMvView, ayl paramayl, com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(286644);
    kotlin.g.b.s.u(paramMusicMvView, "this$0");
    kotlin.g.b.s.u(paramayl, "$cache");
    kotlin.g.b.s.u(paramf, "$musicMv");
    paramMusicMvView.a(paramayl, paramf.hashCode());
    AppMethodBeat.o(286644);
  }
  
  private final void a(ayl paramayl, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(286635);
    Object localObject1 = new StringBuilder("handleGetCommentDetailResponse, musicMv.hashCode() == musicMvHashCode:");
    boolean bool;
    if (this.Mcj.hashCode() == paramInt)
    {
      bool = true;
      Log.i("MicroMsg.Ts.MusicMvView", bool + ", musicMvHashCode:" + paramInt);
      if (this.Mcj.hashCode() == paramInt)
      {
        localObject1 = paramayl.feedObject;
        if (localObject1 != null)
        {
          Object localObject2 = com.tencent.mm.plugin.mv.model.f.LXf;
          f.a.a((FinderObject)localObject1, this.Mcj);
          localObject2 = this.Mcj;
          paramayl = paramayl.ZJp;
          kotlin.g.b.s.s(paramayl, "resp.refObjectList");
          ((com.tencent.mm.plugin.mv.model.f)localObject2).bH(paramayl);
          paramayl = ((FinderObject)localObject1).objectDesc;
          if (paramayl != null)
          {
            paramayl = paramayl.mvInfo;
            if (paramayl != null)
            {
              paramayl = paramayl.LWI;
              if (paramayl != null)
              {
                paramayl = paramayl.Mcq;
                if (paramayl != null)
                {
                  if (((CharSequence)paramayl).length() <= 0) {
                    break label203;
                  }
                  paramInt = i;
                  label170:
                  if (paramInt == 0) {
                    break label208;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramayl != null) {
        getLyricManager().aPE(paramayl);
      }
      gqs();
      AppMethodBeat.o(286635);
      return;
      bool = false;
      break;
      label203:
      paramInt = 0;
      break label170;
      label208:
      paramayl = null;
    }
  }
  
  public static void a(dtj paramdtj, boo paramboo)
  {
    AppMethodBeat.i(286624);
    Object localObject = paramdtj.songName;
    int i;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() <= 0) {
        break label342;
      }
      i = 1;
      if (i == 0) {
        break label347;
      }
      label33:
      if (localObject != null) {
        paramboo.songName = ((String)localObject);
      }
    }
    localObject = paramdtj.songLyric;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() <= 0) {
        break label352;
      }
      i = 1;
      label65:
      if (i == 0) {
        break label357;
      }
      label69:
      if (localObject != null) {
        paramboo.Mcq = ((String)localObject);
      }
    }
    localObject = paramdtj.albumName;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() <= 0) {
        break label362;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label367;
      }
      label105:
      if (localObject != null) {
        paramboo.albumName = ((String)localObject);
      }
    }
    localObject = paramdtj.singerName;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() <= 0) {
        break label372;
      }
      i = 1;
      label137:
      if (i == 0) {
        break label377;
      }
      label141:
      if (localObject != null) {
        paramboo.rDl = ((String)localObject);
      }
    }
    localObject = paramdtj.RfH;
    if (localObject != null)
    {
      if (((CharSequence)localObject).length() <= 0) {
        break label382;
      }
      i = 1;
      label173:
      if (i == 0) {
        break label387;
      }
      label177:
      if (localObject != null) {
        paramboo.ZWS = ((String)localObject);
      }
    }
    localObject = Long.valueOf(paramdtj.issueDate);
    if (((Number)localObject).longValue() > 0L)
    {
      i = 1;
      label208:
      if (i == 0) {
        break label397;
      }
      label212:
      if (localObject != null) {
        paramboo.ZWU = ((Number)localObject).longValue();
      }
      localObject = paramdtj.musicGenre;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() <= 0) {
          break label402;
        }
        i = 1;
        label250:
        if (i == 0) {
          break label407;
        }
        label254:
        if (localObject != null) {
          paramboo.ZTA = ((String)localObject);
        }
      }
      localObject = paramdtj.identification;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() <= 0) {
          break label412;
        }
        i = 1;
        label286:
        if (i == 0) {
          break label417;
        }
        label290:
        if (localObject != null) {
          paramboo.identification = ((String)localObject);
        }
      }
      paramdtj = paramdtj.extraInfo;
      if (paramdtj != null)
      {
        if (((CharSequence)paramdtj).length() <= 0) {
          break label422;
        }
        i = 1;
        label322:
        if (i == 0) {
          break label427;
        }
      }
    }
    for (;;)
    {
      if (paramdtj != null) {
        paramboo.extraInfo = paramdtj;
      }
      AppMethodBeat.o(286624);
      return;
      label342:
      i = 0;
      break;
      label347:
      localObject = null;
      break label33;
      label352:
      i = 0;
      break label65;
      label357:
      localObject = null;
      break label69;
      label362:
      i = 0;
      break label101;
      label367:
      localObject = null;
      break label105;
      label372:
      i = 0;
      break label137;
      label377:
      localObject = null;
      break label141;
      label382:
      i = 0;
      break label173;
      label387:
      localObject = null;
      break label177;
      i = 0;
      break label208;
      label397:
      localObject = null;
      break label212;
      label402:
      i = 0;
      break label250;
      label407:
      localObject = null;
      break label254;
      label412:
      i = 0;
      break label286;
      label417:
      localObject = null;
      break label290;
      label422:
      i = 0;
      break label322;
      label427:
      paramdtj = null;
    }
  }
  
  private final FrameLayout getVideoContainer()
  {
    AppMethodBeat.i(286583);
    FrameLayout localFrameLayout = (FrameLayout)this.Mck.getValue();
    AppMethodBeat.o(286583);
    return localFrameLayout;
  }
  
  private final void gqr()
  {
    AppMethodBeat.i(286594);
    if (this.Mci == null)
    {
      Object localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      this.Mci = new MultiMediaEffectVideoLayout((Context)localObject);
      localObject = this.Mci;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.b)new b());
      }
      localObject = this.Mci;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).setId(b.e.music_video_layout);
      }
    }
    AppMethodBeat.o(286594);
  }
  
  private final void gqs()
  {
    Object localObject2 = null;
    AppMethodBeat.i(286609);
    if (this.Mcj.LXm.size() == 0)
    {
      Log.i("MicroMsg.Ts.MusicMvView", "refreshVideo 0 trackDataList empty");
      AppMethodBeat.o(286609);
      return;
    }
    Log.i("MicroMsg.Ts.MusicMvView", kotlin.g.b.s.X("refreshVideo, position:", Integer.valueOf(0)));
    gqr();
    Object localObject1 = this.Mci;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.Ts.MusicMvView", kotlin.g.b.s.X("refreshVideo, videoLayout.parent:", localObject1));
      localObject1 = this.Mci;
      if (localObject1 != null) {
        break label320;
      }
    }
    label320:
    for (localObject1 = localObject2;; localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent())
    {
      if (localObject1 == null)
      {
        localObject1 = this.Mci;
        if (localObject1 != null) {
          ((MultiMediaEffectVideoLayout)localObject1).setId(b.e.music_video_layout);
        }
        Log.i("MicroMsg.Ts.MusicMvView", "refreshVideo add videoLayout to current videoContainer");
        getVideoContainer().addView((View)this.Mci);
      }
      Log.i("MicroMsg.Ts.MusicMvView", kotlin.g.b.s.X("refreshVideo current music position:", Integer.valueOf(com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA())));
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setMute(true);
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setMediaList((List)this.Mcj.gpD());
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setPlayStatusChangeListener((b.c)new d(this));
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).start();
      }
      int j = com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).seekTo(i);
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setPauseOnVideoPlay(false);
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setKeepScreenOn(true);
      }
      AppMethodBeat.o(286609);
      return;
      localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();
      break;
    }
  }
  
  public final void a(long paramLong, String paramString, com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(286716);
    Log.i("MicroMsg.Ts.MusicMvView", "getMvDetailInfo mvObjectId:" + paramLong + " mvNonceId:" + paramString + " localId:" + paramf.LXg);
    Object localObject = com.tencent.mm.plugin.mv.model.i.LXD;
    localObject = com.tencent.mm.plugin.mv.model.i.W(paramLong, paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = com.tencent.threadpool.h.ahAA.bk(new MusicMvView..ExternalSyntheticLambda1(this, (ayl)localObject, paramf)))
    {
      if (localObject == null)
      {
        localObject = (MusicMvView)this;
        com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.mv.model.a.k(paramLong, paramString, paramf.hashCode(), ((MusicMvView)localObject).hashCode()), 0);
      }
      AppMethodBeat.o(286716);
      return;
      Log.i("MicroMsg.Ts.MusicMvView", "getMvDetailInfo hit cache");
    }
  }
  
  public final a getLyricManager()
  {
    AppMethodBeat.i(286684);
    a locala = (a)this.Mcm.getValue();
    AppMethodBeat.o(286684);
    return locala;
  }
  
  public final void getSongIdWithCheckPermission()
  {
    AppMethodBeat.i(286707);
    com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.mv.model.a.f(this.LWI, hashCode()), 0);
    AppMethodBeat.o(286707);
  }
  
  public final void gqo()
  {
    AppMethodBeat.i(286689);
    Log.i("MicroMsg.Ts.MusicMvView", kotlin.g.b.s.X("onResume, needResumePosition:", Boolean.valueOf(this.Mcl)));
    if (!this.Mcl) {
      gqs();
    }
    for (;;)
    {
      this.Mcl = false;
      getLyricManager().onResume();
      AppMethodBeat.o(286689);
      return;
      MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.TGY.resume();
      }
    }
  }
  
  public final void gqp()
  {
    AppMethodBeat.i(286696);
    Log.i("MicroMsg.Ts.MusicMvView", "onMvPause");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.pause();
    }
    this.Mcl = true;
    getLyricManager().onPause();
    AppMethodBeat.o(286696);
  }
  
  public final void gqq()
  {
    AppMethodBeat.i(286700);
    com.tencent.mm.kernel.h.aZW().a(3763, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(5286, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(5292, this.LYH);
    AppMethodBeat.o(286700);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView$checkVideoLayout$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.thumbplayer.view.b
  {
    public final void aea(int paramInt)
    {
      AppMethodBeat.i(286553);
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(paramInt);
      AppMethodBeat.o(286553);
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(286546);
      long l = com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA();
      AppMethodBeat.o(286546);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView$refreshVideo$1", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "onPause", "", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b.c
  {
    d(MusicMvView paramMusicMvView) {}
    
    public final void onPause()
    {
      AppMethodBeat.i(286551);
      if (MusicMvView.a(this.Mcn).LXx > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = MusicMvView.a(this.Mcn);
        localf.LXy += cn.bDw() - MusicMvView.a(this.Mcn).LXx;
        MusicMvView.a(this.Mcn).LXx = 0L;
      }
      AppMethodBeat.o(286551);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(286556);
      if (MusicMvView.a(this.Mcn).LXx > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = MusicMvView.a(this.Mcn);
        localf.LXy += cn.bDw() - MusicMvView.a(this.Mcn).LXx;
      }
      MusicMvView.a(this.Mcn).LXx = cn.bDw();
      AppMethodBeat.o(286556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView
 * JD-Core Version:    0.7.0.1
 */