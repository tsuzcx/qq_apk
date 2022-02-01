package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView;
import com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/jump/MusicPullDownView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "musicPlayState", "", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;I)V", "alreadyHasMusicPlaying", "", "coverUrl", "cycleTimes", "getCycleTimes", "()I", "setCycleTimes", "(I)V", "finderMVSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "isOpening", "()Z", "setOpening", "(Z)V", "isPlaying", "setPlaying", "isSame", "setSame", "getJumpInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "lastMusicExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "lastMusicState", "Lcom/tencent/mm/modelmusic/MusicPlayerState;", "lastMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "lastPosition", "getLastPosition", "setLastPosition", "lastStatusSongPosition", "getLastStatusSongPosition", "setLastStatusSongPosition", "lastVolume", "", "getLastVolume", "()F", "setLastVolume", "(F)V", "musicPlayerListener", "com/tencent/mm/plugin/mv/jump/MusicPullDownView$musicPlayerListener$1", "Lcom/tencent/mm/plugin/mv/jump/MusicPullDownView$musicPlayerListener$1;", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mvView", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;", "getSourceId", "()Ljava/lang/String;", "startSecond", "", "checkMute", "clearLastSongInfo", "", "getCurCycle", "getTag", "isSameMvMusic", "onDestroy", "onJumpDetail", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onTransAnim", "percent", "parseXml", "Companion", "PlayState", "plugin-mv_release"})
public final class c
  extends com.tencent.mm.ui.widget.b
{
  public static final c.a Gav;
  int BoC;
  private MusicMvView Gah;
  private bds Gai;
  private long Gaj;
  private boolean Gak;
  private com.tencent.mm.bb.f Gal;
  private com.tencent.mm.bb.c Gam;
  private com.tencent.mm.bb.h Gan;
  private final b Gao;
  int Gap;
  private boolean Gaq;
  boolean Gar;
  int Gas;
  float Gat;
  private int Gau;
  private String coverUrl;
  private boolean fGh;
  private dbr lVY;
  private final String sourceId;
  private final TextStatusJumpInfo yNQ;
  
  static
  {
    AppMethodBeat.i(238094);
    Gav = new c.a((byte)0);
    AppMethodBeat.o(238094);
  }
  
  public c(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, int paramInt)
  {
    AppMethodBeat.i(238092);
    this.sourceId = paramString;
    this.yNQ = paramTextStatusJumpInfo;
    this.Gau = paramInt;
    this.coverUrl = "";
    this.Gao = new b(this);
    paramString = paramFrameLayout.getContext();
    p.j(paramString, "container.context");
    MusicMvView localMusicMvView = new MusicMvView(paramString);
    paramFrameLayout.addView((View)localMusicMvView);
    Log.i("MusicPullDownView", "parseXml");
    TextStatusJumpInfo localTextStatusJumpInfo = this.yNQ;
    label139:
    label159:
    label221:
    Object localObject;
    if (localTextStatusJumpInfo == null)
    {
      paramTextStatusJumpInfo = this.lVY;
      if (paramTextStatusJumpInfo == null) {
        break label1279;
      }
      paramString = paramTextStatusJumpInfo.Ruu;
      paramFrameLayout = paramTextStatusJumpInfo.Ruv;
      if ((paramString == null) || (paramFrameLayout == null)) {
        break label1279;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label1251;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label1279;
      }
      if (((CharSequence)paramFrameLayout).length() <= 0) {
        break label1257;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label1279;
      }
      p.k(paramTextStatusJumpInfo, "mvInfo");
      paramFrameLayout = new StringBuilder("onViewCreateWithMvShareObject, mvInfoObjId:").append(paramTextStatusJumpInfo.Ruu).append(", mvInfoSongName:").append(paramTextStatusJumpInfo.HLH).append(", mvInfoLyricLength:");
      paramString = paramTextStatusJumpInfo.songLyric;
      if (paramString == null) {
        break label1263;
      }
      paramString = Integer.valueOf(paramString.length());
      Log.i("MicroMsg.Ts.MusicMvView", paramString);
      localObject = localMusicMvView.GgZ;
      ((com.tencent.mm.plugin.mv.model.f)localObject).Gbl = Long.valueOf(com.tencent.mm.ae.d.Nb(paramTextStatusJumpInfo.Ruu));
      ((com.tencent.mm.plugin.mv.model.f)localObject).Gbm = paramTextStatusJumpInfo.Ruv;
      paramFrameLayout = paramTextStatusJumpInfo.Rux;
      paramString = paramFrameLayout;
      if (paramFrameLayout == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.mv.model.f)localObject).aSD(paramString);
      paramString = (CharSequence)((com.tencent.mm.plugin.mv.model.f)localObject).coverUrl;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label1268;
      }
      paramInt = 1;
      label310:
      if (paramInt != 0) {
        ((com.tencent.mm.plugin.mv.model.f)localObject).coverUrl = paramTextStatusJumpInfo.Ruw;
      }
      paramFrameLayout = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbl;
      paramString = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbm;
      if ((paramFrameLayout == null) || (paramString == null)) {
        break label1274;
      }
      long l = ((Number)paramFrameLayout).longValue();
      paramFrameLayout = localMusicMvView.GgZ;
      Log.i("MicroMsg.Ts.MusicMvView", "getMvDetailInfo mvObjectId:" + l + " mvNonceId:" + paramString + " localId:" + paramFrameLayout.Gbi);
      localObject = com.tencent.mm.plugin.mv.model.i.GbW;
      localObject = com.tencent.mm.plugin.mv.model.i.I(l, paramString);
      if (localObject != null)
      {
        Log.i("MicroMsg.Ts.MusicMvView", "getMvDetailInfo hit cache");
        if (com.tencent.e.h.ZvG.bc((Runnable)new MusicMvView.c((att)localObject, localMusicMvView, paramFrameLayout)) != null) {}
      }
      else
      {
        localObject = (MusicMvView)localMusicMvView;
        com.tencent.mm.kernel.h.aGY().b((q)new com.tencent.mm.plugin.mv.model.a.h(l, paramString, paramFrameLayout.hashCode(), ((MusicMvView)localObject).hashCode()));
      }
      Log.i("MicroMsg.Ts.MusicMvView", "init finder music mv " + l + ' ' + paramString);
      paramString = x.aazN;
      label529:
      if (paramString == null)
      {
        Log.e("MicroMsg.Ts.MusicMvView", "fillMvByMusicShareObject, invalid music info!!");
        paramString = x.aazN;
      }
      localMusicMvView.getLyricManager().onCreate();
      localMusicMvView.getLyricManager().aSK(paramTextStatusJumpInfo.songLyric);
      MusicMvView.a(paramTextStatusJumpInfo, localMusicMvView.GaB);
      localMusicMvView.getSongIdWithCheckPermission();
      localMusicMvView.hfT();
      paramInt = 1;
      label587:
      if (paramInt == 0)
      {
        paramFrameLayout = this.Gai;
        if (paramFrameLayout != null)
        {
          p.k(paramFrameLayout, "songInfo");
          paramTextStatusJumpInfo = new StringBuilder("onViewCreateWithSongInfo，songName:").append(paramFrameLayout.HLH).append(" lyric length:");
          paramString = paramFrameLayout.SOL;
          if (paramString == null) {
            break label1285;
          }
          paramString = Integer.valueOf(paramString.length());
          Log.i("MicroMsg.Ts.MusicMvView", paramString);
          localMusicMvView.GaB = paramFrameLayout;
          localMusicMvView.getLyricManager().onCreate();
          localMusicMvView.getLyricManager().aSK(paramFrameLayout.SOL);
          localMusicMvView.getSongIdWithCheckPermission();
          localMusicMvView.hfT();
        }
      }
      label649:
      this.Gah = localMusicMvView;
      this.Gao.alive();
      Log.i("MusicPullDownView", "bindMvView " + hashCode() + " - mv:" + localMusicMvView.hashCode());
      this.Gas = 1;
      this.Gat = 1.0F;
      AppMethodBeat.o(238092);
    }
    for (;;)
    {
      try
      {
        paramString = XmlParser.parseXml(localTextStatusJumpInfo.busiBuf, "MusicVideoStatusOpenParams", null);
        if (paramString != null)
        {
          paramFrameLayout = new bds();
          b.a(paramFrameLayout, ".".concat(String.valueOf("MusicVideoStatusOpenParams")), paramString);
          this.Gai = paramFrameLayout;
          this.lVY = am.C(".".concat(String.valueOf("MusicVideoStatusOpenParams")), paramString);
          paramString = this.lVY;
          if (paramString != null)
          {
            paramString = paramString.Ruw;
            paramString = (CharSequence)paramString;
            if (paramString == null) {
              break label1290;
            }
            if (paramString.length() != 0) {
              continue;
            }
            break label1290;
            if (paramInt != 0) {
              continue;
            }
            paramString = this.lVY;
            if (paramString == null) {
              continue;
            }
            paramString = paramString.Ruw;
            paramString = String.valueOf(paramString);
            this.coverUrl = paramString;
            paramString = this.Gai;
            if (paramString == null) {
              continue;
            }
            paramString = paramString.extraInfo;
            paramFrameLayout = this.lVY;
            if (paramFrameLayout == null) {
              continue;
            }
            paramFrameLayout = paramFrameLayout.extraInfo;
            paramTextStatusJumpInfo = this.Gai;
            if (paramTextStatusJumpInfo == null) {
              continue;
            }
            paramTextStatusJumpInfo = paramTextStatusJumpInfo.identification;
            localObject = this.lVY;
            if (localObject == null) {
              continue;
            }
            localObject = ((dbr)localObject).identification;
            Log.i("MusicPullDownView", "jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", new Object[] { paramString, paramFrameLayout, paramTextStatusJumpInfo, localObject, localTextStatusJumpInfo.busiBuf });
          }
        }
        else
        {
          Log.i("MusicPullDownView", "finderMvSongInfo:" + this.Gai + ", musicShareOjbect:" + this.lVY + ", cover_url:" + this.coverUrl);
          break;
        }
        paramString = null;
        continue;
        paramInt = 0;
        continue;
        paramString = null;
        continue;
        paramString = this.Gai;
        if (paramString != null)
        {
          paramFrameLayout = paramString.SOM;
          paramString = paramFrameLayout;
          if (paramFrameLayout != null) {
            continue;
          }
        }
        paramString = "";
        continue;
        paramString = null;
        continue;
        paramFrameLayout = null;
        continue;
        paramTextStatusJumpInfo = null;
        continue;
        localObject = null;
        continue;
      }
      catch (Exception paramString)
      {
        Log.e("MusicPullDownView", "process TextStatusJumpInfo fail:" + paramString.getLocalizedMessage());
        Log.i("MusicPullDownView", "finderMvSongInfo:" + this.Gai + ", musicShareOjbect:" + this.lVY + ", cover_url:" + this.coverUrl);
        break;
      }
      finally
      {
        Log.i("MusicPullDownView", "finderMvSongInfo:" + this.Gai + ", musicShareOjbect:" + this.lVY + ", cover_url:" + this.coverUrl);
        AppMethodBeat.o(238092);
      }
      label1251:
      paramInt = 0;
      break label139;
      label1257:
      paramInt = 0;
      break label159;
      label1263:
      paramString = null;
      break label221;
      label1268:
      paramInt = 0;
      break label310;
      label1274:
      paramString = null;
      break label529;
      label1279:
      paramInt = 0;
      break label587;
      label1285:
      paramString = null;
      break label649;
      label1290:
      paramInt = 1;
    }
  }
  
  public final void dDB() {}
  
  public final void dDC() {}
  
  public final void dDE()
  {
    AppMethodBeat.i(238079);
    super.dDE();
    this.fGh = com.tencent.mm.bb.a.bnx();
    this.Gar = true;
    this.Gaq = false;
    bds localbds;
    Object localObject1;
    dbr localdbr;
    Object localObject2;
    if (!this.fGh)
    {
      localbds = this.Gai;
      if (localbds != null)
      {
        localObject1 = aa.Amg;
        localdbr = this.lVY;
        localObject2 = localbds.kkU;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        aa.a(localbds, localdbr, (String)localObject1, this.coverUrl);
      }
      Log.i("MusicPullDownView", "onPostOpen@" + hashCode() + ' ' + this.Gaq + "  " + this.fGh);
      localObject1 = this.Gah;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.Ts.MusicMvView", "onResume, needResumePosition:" + ((MusicMvView)localObject1).Ghb);
        if (((MusicMvView)localObject1).Ghb) {
          break label466;
        }
        ((MusicMvView)localObject1).fgJ();
      }
    }
    for (;;)
    {
      ((MusicMvView)localObject1).Ghb = false;
      localObject1 = ((MusicMvView)localObject1).getLyricManager();
      Log.i("MicroMsg.Mv.MusicMvLyric", "onResume");
      localObject2 = k.fet();
      p.j(localObject2, "MusicPlayerManager.Instance()");
      ((k)localObject2).feg().a(((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject1).FOE);
      this.Gaj = Util.nowSecond();
      AppMethodBeat.o(238079);
      return;
      localObject1 = com.tencent.mm.bb.a.bnA();
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.bb.f)localObject1).lVz;
        localObject1 = this.Gai;
        if (localObject1 != null) {
          localObject1 = ((bds)localObject1).musicDataUrl;
        }
      }
      label265:
      for (boolean bool = p.h(localObject2, localObject1);; bool = false)
      {
        this.Gaq = bool;
        if (!this.Gaq) {
          break label327;
        }
        localObject1 = com.tencent.mm.bb.a.bnA();
        if (localObject1 != null)
        {
          ((com.tencent.mm.bb.f)localObject1).lVW = false;
          com.tencent.mm.bb.a.b((com.tencent.mm.bb.f)localObject1);
        }
        ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).bnJ();
        break;
        localObject1 = null;
        break label265;
      }
      label327:
      localObject1 = k.fet();
      p.j(localObject1, "MusicPlayerManager.Instance()");
      localObject1 = ((k)localObject1).feg();
      p.j(localObject1, "MusicPlayerManager.Instance().musicPlayer");
      this.BoC = ((com.tencent.mm.plugin.music.f.a.d)localObject1).fdx();
      this.fGh = com.tencent.mm.bb.a.bnx();
      this.Gal = com.tencent.mm.bb.a.bnA();
      this.Gam = com.tencent.mm.bb.a.bnB();
      localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class);
      p.j(localObject1, "MMKernel.service(IMusicF…tBallService::class.java)");
      this.Gan = ((com.tencent.mm.bb.a.a)localObject1).bnK();
      com.tencent.mm.bb.a.bnv();
      localbds = this.Gai;
      if (localbds == null) {
        break;
      }
      localObject1 = aa.Amg;
      localdbr = this.lVY;
      localObject2 = localbds.kkU;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = String.valueOf(System.currentTimeMillis());
      }
      aa.a(localbds, localdbr, (String)localObject1, this.coverUrl);
      break;
      label466:
      localObject2 = ((MusicMvView)localObject1).GgY;
      if (localObject2 != null) {
        ((MultiMediaEffectVideoLayout)localObject2).MUy.resume();
      }
    }
  }
  
  public final long ejq()
  {
    return this.Gas;
  }
  
  public final boolean ffO()
  {
    AppMethodBeat.i(238081);
    if (!com.tencent.mm.q.a.aAo())
    {
      localObject = this.Gah;
      if (localObject == null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = ((MusicMvView)localObject).getContext(); com.tencent.mm.q.a.r((Context)localObject, false); localObject = null)
    {
      AppMethodBeat.o(238081);
      return true;
    }
    AppMethodBeat.o(238081);
    return false;
  }
  
  public final String getTag()
  {
    return "MusicPullDownView";
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238077);
    Log.i("MusicPullDownView", "onDestroy@" + hashCode());
    super.onDestroy();
    MusicMvView localMusicMvView = this.Gah;
    if (localMusicMvView != null)
    {
      Log.i("MicroMsg.Ts.MusicMvView", "onViewDestroy");
      com.tencent.mm.kernel.h.aGY().b(3763, localMusicMvView.Ghd);
      com.tencent.mm.kernel.h.aGY().b(5286, localMusicMvView.Ghd);
      com.tencent.mm.kernel.h.aGY().b(5292, localMusicMvView.Ghd);
      Object localObject = localMusicMvView.getLyricManager();
      Log.i("MicroMsg.Mv.MusicMvLyric", "onDestroy");
      ((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).GgR.clear();
      ((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).FTB = null;
      k localk = k.fet();
      p.j(localk, "MusicPlayerManager.Instance()");
      localk.feg().b(((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).FOE);
      localObject = localMusicMvView.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).MUy.release();
      }
      localMusicMvView.GgY = null;
      localMusicMvView.Ghb = false;
    }
    this.Gao.dead();
    AppMethodBeat.o(238077);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(238083);
    super.onPostClose();
    this.Gar = false;
    boolean bool2 = ffO();
    boolean bool1;
    if (Util.secondsToNow(this.Gaj) >= 5L)
    {
      bool1 = true;
      if (!ffO()) {
        break label231;
      }
      k.fet().bnv();
    }
    for (;;)
    {
      Object localObject1 = this.Gah;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.Ts.MusicMvView", "onMvPause");
        Object localObject2 = ((MusicMvView)localObject1).GgY;
        if (localObject2 != null) {
          ((MultiMediaEffectVideoLayout)localObject2).pause();
        }
        ((MusicMvView)localObject1).Ghb = true;
        localObject1 = ((MusicMvView)localObject1).getLyricManager();
        Log.i("MicroMsg.Mv.MusicMvLyric", "onPause");
        localObject2 = k.fet();
        p.j(localObject2, "MusicPlayerManager.Instance()");
        ((k)localObject2).feg().b(((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject1).FOE);
      }
      Log.i("MusicPullDownView", "onPostClose@" + hashCode() + ' ' + bool2 + ' ' + this.Gaq + ' ' + bool1 + ' ' + this.fGh + ' ' + this.Gap + ' ' + this.BoC);
      AppMethodBeat.o(238083);
      return;
      bool1 = false;
      break;
      label231:
      if (this.Gaq)
      {
        ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).bnI();
      }
      else if (bool1)
      {
        this.Gak = false;
        this.Gam = null;
        this.Gal = null;
        this.BoC = 0;
        ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).bnI();
      }
      else
      {
        localObject1 = k.fet();
        p.j(localObject1, "MusicPlayerManager.Instance()");
        localObject1 = ((k)localObject1).feg();
        p.j(localObject1, "MusicPlayerManager.Instance().musicPlayer");
        this.Gap = ((com.tencent.mm.plugin.music.f.a.d)localObject1).fdx();
        com.tencent.mm.bb.a.bnv();
        if (this.fGh)
        {
          localObject1 = this.Gal;
          if (localObject1 != null) {
            ((com.tencent.mm.bb.f)localObject1).lVW = true;
          }
          ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).b(this.Gal, this.Gan);
          com.tencent.mm.bb.a.c(this.Gal);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/jump/MusicPullDownView$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class b
    extends IListener<np>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.c
 * JD-Core Version:    0.7.0.1
 */