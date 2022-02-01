package com.tencent.mm.plugin.mv.jump;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/jump/MusicPullDownView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "musicPlayState", "", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "alreadyHasMusicPlaying", "", "coverUrl", "getCoverUrl", "setCoverUrl", "cycleTimes", "getCycleTimes", "()I", "setCycleTimes", "(I)V", "finderMVSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getFinderMVSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setFinderMVSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "isOpening", "()Z", "setOpening", "(Z)V", "isPlaying", "setPlaying", "isSame", "setSame", "getJumpInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "lastMusicExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "lastMusicState", "Lcom/tencent/mm/modelmusic/MusicPlayerState;", "lastMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "lastPosition", "getLastPosition", "setLastPosition", "lastStatusSongPosition", "getLastStatusSongPosition", "setLastStatusSongPosition", "lastVolume", "", "getLastVolume", "()F", "setLastVolume", "(F)V", "musicPlayerListener", "com/tencent/mm/plugin/mv/jump/MusicPullDownView$musicPlayerListener$1", "Lcom/tencent/mm/plugin/mv/jump/MusicPullDownView$musicPlayerListener$1;", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "getMusicShareObject", "()Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "setMusicShareObject", "(Lcom/tencent/mm/protocal/protobuf/MusicShareObject;)V", "mvView", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;", "getMvView", "()Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;", "setMvView", "(Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvView;)V", "getSourceId", "startSecond", "", "getStartSecond", "()J", "setStartSecond", "(J)V", "checkMute", "clearLastSongInfo", "", "getCurCycle", "getTag", "isSameMvMusic", "onDestroy", "onPostClose", "onPostCloseInner", "onPostOpen", "onPostOpenInner", "onPreClose", "onPreOpen", "onTransAnim", "percent", "parseXml", "Companion", "PlayState", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.ui.widget.b
{
  public static final d.a LWq;
  int BuD;
  private final TextStatusJumpInfo DGX;
  private boo Gbe;
  boolean LWA;
  int LWB;
  float LWC;
  private int LWn;
  private MusicMvView LWr;
  private long LWs;
  private boolean LWt;
  private com.tencent.mm.aw.f LWu;
  private com.tencent.mm.aw.c LWv;
  private com.tencent.mm.aw.h LWw;
  private final MusicPullDownView.musicPlayerListener.1 LWx;
  int LWy;
  private boolean LWz;
  private String TAG;
  private String coverUrl;
  private boolean hLy;
  private dtj oPb;
  private final String sourceId;
  
  static
  {
    AppMethodBeat.i(286073);
    LWq = new d.a((byte)0);
    AppMethodBeat.o(286073);
  }
  
  public d(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, int paramInt)
  {
    AppMethodBeat.i(286060);
    this.sourceId = paramString;
    this.DGX = paramTextStatusJumpInfo;
    this.LWn = paramInt;
    this.TAG = "MusicPullDownView";
    this.coverUrl = "";
    this.LWx = new MusicPullDownView.musicPlayerListener.1(this, com.tencent.mm.app.f.hfK);
    paramString = paramFrameLayout.getContext();
    kotlin.g.b.s.s(paramString, "container.context");
    MusicMvView localMusicMvView = new MusicMvView(paramString);
    paramFrameLayout.addView((View)localMusicMvView);
    Log.i(getTAG(), "parseXml");
    TextStatusJumpInfo localTextStatusJumpInfo = this.DGX;
    if (localTextStatusJumpInfo != null) {}
    for (;;)
    {
      try
      {
        paramString = XmlParser.parseXml(localTextStatusJumpInfo.busiBuf, "MusicVideoStatusOpenParams", null);
        if (paramString != null)
        {
          paramFrameLayout = new boo();
          c.a(paramFrameLayout, kotlin.g.b.s.X(".", "MusicVideoStatusOpenParams"), paramString);
          paramTextStatusJumpInfo = ah.aiuX;
          this.Gbe = paramFrameLayout;
          this.oPb = cq.J(kotlin.g.b.s.X(".", "MusicVideoStatusOpenParams"), paramString);
          paramString = this.oPb;
          if (paramString != null) {
            continue;
          }
          paramString = null;
          paramString = (CharSequence)paramString;
          if (paramString == null) {
            break label1176;
          }
          if (paramString.length() != 0) {
            break label1182;
          }
          break label1176;
          if (paramInt != 0) {
            continue;
          }
          paramString = this.oPb;
          if (paramString != null) {
            continue;
          }
          paramString = null;
          paramString = String.valueOf(paramString);
          this.coverUrl = paramString;
          String str = getTAG();
          paramString = this.Gbe;
          if (paramString != null) {
            continue;
          }
          paramString = null;
          paramFrameLayout = this.oPb;
          if (paramFrameLayout != null) {
            continue;
          }
          paramFrameLayout = null;
          paramTextStatusJumpInfo = this.Gbe;
          if (paramTextStatusJumpInfo != null) {
            continue;
          }
          paramTextStatusJumpInfo = null;
          localObject1 = this.oPb;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          Log.i(str, "jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", new Object[] { paramString, paramFrameLayout, paramTextStatusJumpInfo, localObject1, localTextStatusJumpInfo.busiBuf });
        }
        Log.i(getTAG(), "finderMvSongInfo:" + this.Gbe + ", musicShareOjbect:" + this.oPb + ", cover_url:" + this.coverUrl);
      }
      catch (Exception paramString)
      {
        Object localObject1;
        long l;
        Log.e(getTAG(), kotlin.g.b.s.X("process TextStatusJumpInfo fail:", paramString.getLocalizedMessage()));
        Log.i(getTAG(), "finderMvSongInfo:" + this.Gbe + ", musicShareOjbect:" + this.oPb + ", cover_url:" + this.coverUrl);
        continue;
      }
      finally
      {
        Log.i(getTAG(), "finderMvSongInfo:" + this.Gbe + ", musicShareOjbect:" + this.oPb + ", cover_url:" + this.coverUrl);
        AppMethodBeat.o(286060);
      }
      paramTextStatusJumpInfo = this.oPb;
      if (paramTextStatusJumpInfo != null)
      {
        paramString = paramTextStatusJumpInfo.YqN;
        paramFrameLayout = paramTextStatusJumpInfo.YqO;
        if ((paramString != null) && (paramFrameLayout != null))
        {
          if (((CharSequence)paramString).length() > 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label1170;
            }
            if (((CharSequence)paramFrameLayout).length() > 0)
            {
              paramInt = 1;
              if (paramInt == 0) {
                break label1170;
              }
              kotlin.g.b.s.u(paramTextStatusJumpInfo, "mvInfo");
              paramFrameLayout = new StringBuilder("onViewCreateWithMvShareObject, mvInfoObjId:").append(paramTextStatusJumpInfo.YqN).append(", mvInfoSongName:").append(paramTextStatusJumpInfo.songName).append(", mvInfoLyricLength:");
              paramString = paramTextStatusJumpInfo.songLyric;
              if (paramString != null) {
                break label1143;
              }
              paramString = null;
              Log.i("MicroMsg.Ts.MusicMvView", paramString);
              localObject1 = localMusicMvView.Mcj;
              ((com.tencent.mm.plugin.mv.model.f)localObject1).LXj = Long.valueOf(com.tencent.mm.ae.d.FK(paramTextStatusJumpInfo.YqN));
              ((com.tencent.mm.plugin.mv.model.f)localObject1).LXk = paramTextStatusJumpInfo.YqO;
              paramFrameLayout = paramTextStatusJumpInfo.YqQ;
              paramString = paramFrameLayout;
              if (paramFrameLayout == null) {
                paramString = "";
              }
              ((com.tencent.mm.plugin.mv.model.f)localObject1).aPx(paramString);
              paramString = (CharSequence)((com.tencent.mm.plugin.mv.model.f)localObject1).coverUrl;
              if (paramString != null)
              {
                paramInt = i;
                if (paramString.length() != 0) {}
              }
              else
              {
                paramInt = 1;
              }
              if (paramInt != 0) {
                ((com.tencent.mm.plugin.mv.model.f)localObject1).coverUrl = paramTextStatusJumpInfo.YqP;
              }
              paramString = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXj;
              paramFrameLayout = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXk;
              if ((paramString == null) || (paramFrameLayout == null)) {
                break label1154;
              }
              l = ((Number)paramString).longValue();
              localMusicMvView.a(l, paramFrameLayout, localMusicMvView.Mcj);
              Log.i("MicroMsg.Ts.MusicMvView", "init finder music mv " + l + ' ' + paramFrameLayout);
              paramString = ah.aiuX;
              if (paramString == null) {
                Log.e("MicroMsg.Ts.MusicMvView", "fillMvByMusicShareObject, invalid music info!!");
              }
              localMusicMvView.getLyricManager().onCreate();
              localMusicMvView.getLyricManager().aPE(paramTextStatusJumpInfo.songLyric);
              MusicMvView.a(paramTextStatusJumpInfo, localMusicMvView.LWI);
              localMusicMvView.getSongIdWithCheckPermission();
              localMusicMvView.gqq();
              paramInt = 1;
              if (paramInt == 0)
              {
                paramFrameLayout = this.Gbe;
                if (paramFrameLayout != null)
                {
                  kotlin.g.b.s.u(paramFrameLayout, "songInfo");
                  paramTextStatusJumpInfo = new StringBuilder("onViewCreateWithSongInfo，songName:").append(paramFrameLayout.songName).append(" lyric length:");
                  paramString = paramFrameLayout.Mcq;
                  if (paramString != null) {
                    break label1159;
                  }
                  paramString = localObject2;
                  Log.i("MicroMsg.Ts.MusicMvView", paramString);
                  localMusicMvView.LWI = paramFrameLayout;
                  localMusicMvView.getLyricManager().onCreate();
                  localMusicMvView.getLyricManager().aPE(paramFrameLayout.Mcq);
                  localMusicMvView.getSongIdWithCheckPermission();
                  localMusicMvView.gqq();
                }
              }
              this.LWr = localMusicMvView;
              this.LWx.alive();
              Log.i("MusicPullDownView", "bindMvView " + hashCode() + " - mv:" + localMusicMvView.hashCode());
              this.LWB = 1;
              this.LWC = 1.0F;
              AppMethodBeat.o(286060);
              return;
              paramString = paramString.YqP;
              continue;
              paramString = paramString.YqP;
              continue;
              paramString = this.Gbe;
              if (paramString == null)
              {
                paramString = "";
                continue;
              }
              paramFrameLayout = paramString.ZWS;
              paramString = paramFrameLayout;
              if (paramFrameLayout != null) {
                continue;
              }
              paramString = "";
              continue;
              paramString = paramString.extraInfo;
              continue;
              paramFrameLayout = paramFrameLayout.extraInfo;
              continue;
              paramTextStatusJumpInfo = paramTextStatusJumpInfo.identification;
              continue;
              localObject1 = ((dtj)localObject1).identification;
              continue;
            }
          }
          else
          {
            paramInt = 0;
            continue;
          }
          paramInt = 0;
          continue;
          label1143:
          paramString = Integer.valueOf(paramString.length());
          continue;
          label1154:
          paramString = null;
          continue;
          label1159:
          paramString = Integer.valueOf(paramString.length());
          continue;
        }
      }
      label1170:
      paramInt = 0;
      continue;
      label1176:
      paramInt = 1;
      continue;
      label1182:
      paramInt = 0;
    }
  }
  
  protected final String dUD()
  {
    return this.coverUrl;
  }
  
  public final void etL()
  {
    AppMethodBeat.i(286145);
    this.LWx.alive();
    AppMethodBeat.o(286145);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(286150);
    this.LWx.dead();
    AppMethodBeat.o(286150);
  }
  
  public final void etO()
  {
    AppMethodBeat.i(286172);
    super.etO();
    gpk();
    AppMethodBeat.o(286172);
  }
  
  public final long flv()
  {
    return this.LWB;
  }
  
  protected String getTAG()
  {
    return this.TAG;
  }
  
  public final String getTag()
  {
    return "MusicPullDownView";
  }
  
  protected void gpk()
  {
    AppMethodBeat.i(286180);
    this.hLy = com.tencent.mm.aw.a.bLk();
    this.LWA = true;
    this.LWz = false;
    boo localboo;
    Object localObject;
    dtj localdtj;
    String str;
    if (!this.hLy)
    {
      localboo = this.Gbe;
      if (localboo != null)
      {
        localObject = ac.FLX;
        localdtj = this.oPb;
        str = localboo.mLQ;
        localObject = str;
        if (str == null) {
          localObject = String.valueOf(System.currentTimeMillis());
        }
        kotlin.g.b.s.s(localObject, "it.songId\n              …ntTimeMillis().toString()");
        ac.a(localboo, localdtj, (String)localObject, this.coverUrl);
      }
    }
    for (;;)
    {
      Log.i(getTAG(), "onPostOpen@" + hashCode() + ' ' + this.LWz + "  " + this.hLy);
      localObject = this.LWr;
      if (localObject != null) {
        ((MusicMvView)localObject).gqo();
      }
      this.LWs = Util.nowSecond();
      AppMethodBeat.o(286180);
      return;
      this.LWz = gps();
      if (this.LWz)
      {
        localObject = com.tencent.mm.aw.a.bLn();
        if (localObject != null)
        {
          ((com.tencent.mm.aw.f)localObject).oOY = false;
          com.tencent.mm.aw.a.b((com.tencent.mm.aw.f)localObject);
        }
        ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).hj(false);
      }
      else
      {
        this.BuD = j.gnw().gnj().gmA();
        this.hLy = com.tencent.mm.aw.a.bLk();
        this.LWu = com.tencent.mm.aw.a.bLn();
        this.LWv = com.tencent.mm.aw.a.bLo();
        this.LWw = ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).bLx();
        com.tencent.mm.aw.a.bLi();
        localboo = this.Gbe;
        if (localboo != null)
        {
          localObject = ac.FLX;
          localdtj = this.oPb;
          str = localboo.mLQ;
          localObject = str;
          if (str == null) {
            localObject = String.valueOf(System.currentTimeMillis());
          }
          kotlin.g.b.s.s(localObject, "it.songId\n              …ntTimeMillis().toString()");
          ac.a(localboo, localdtj, (String)localObject, this.coverUrl);
        }
      }
    }
  }
  
  protected void gpl()
  {
    AppMethodBeat.i(286204);
    this.LWA = false;
    boolean bool2 = gpr();
    boolean bool1;
    if (Util.secondsToNow(this.LWs) >= 5L)
    {
      bool1 = true;
      if (!gpr()) {
        break label163;
      }
      j.gnw().bLi();
    }
    for (;;)
    {
      Object localObject = this.LWr;
      if (localObject != null) {
        ((MusicMvView)localObject).gqp();
      }
      Log.i(getTAG(), "onPostClose@" + hashCode() + ' ' + bool2 + ' ' + this.LWz + ' ' + bool1 + ' ' + this.hLy + ' ' + this.LWy + ' ' + this.BuD);
      AppMethodBeat.o(286204);
      return;
      bool1 = false;
      break;
      label163:
      if (this.LWz)
      {
        ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).bLv();
      }
      else if (bool1)
      {
        this.LWt = false;
        this.LWv = null;
        this.LWu = null;
        this.BuD = 0;
        ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).bLv();
      }
      else
      {
        this.LWy = j.gnw().gnj().gmA();
        com.tencent.mm.aw.a.bLi();
        if (this.hLy)
        {
          localObject = this.LWu;
          if (localObject != null) {
            ((com.tencent.mm.aw.f)localObject).oOY = true;
          }
          ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(this.LWu, this.LWw);
          com.tencent.mm.aw.a.c(this.LWu);
        }
      }
    }
  }
  
  protected final MusicMvView gpm()
  {
    return this.LWr;
  }
  
  protected final dtj gpn()
  {
    return this.oPb;
  }
  
  protected final boo gpo()
  {
    return this.Gbe;
  }
  
  protected final long gpp()
  {
    return this.LWs;
  }
  
  public final boolean gpq()
  {
    return this.LWz;
  }
  
  public final boolean gpr()
  {
    AppMethodBeat.i(286189);
    if (!com.tencent.mm.n.a.aTj())
    {
      localObject = this.LWr;
      if (localObject != null) {
        break label39;
      }
    }
    label39:
    for (Object localObject = null; com.tencent.mm.n.a.s((Context)localObject, false); localObject = ((MusicMvView)localObject).getContext())
    {
      AppMethodBeat.o(286189);
      return true;
    }
    AppMethodBeat.o(286189);
    return false;
  }
  
  protected final boolean gps()
  {
    AppMethodBeat.i(286211);
    Object localObject = com.tencent.mm.aw.a.bLn();
    if (localObject != null)
    {
      String str = ((com.tencent.mm.aw.f)localObject).oOB;
      localObject = this.Gbe;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((boo)localObject).musicDataUrl)
      {
        boolean bool = kotlin.g.b.s.p(str, localObject);
        AppMethodBeat.o(286211);
        return bool;
      }
    }
    AppMethodBeat.o(286211);
    return false;
  }
  
  public final boolean isPlaying()
  {
    return this.hLy;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(286135);
    Log.i(getTAG(), kotlin.g.b.s.X("onDestroy@", Integer.valueOf(hashCode())));
    super.onDestroy();
    MusicMvView localMusicMvView = this.LWr;
    if (localMusicMvView != null)
    {
      Log.i("MicroMsg.Ts.MusicMvView", "onViewDestroy");
      com.tencent.mm.kernel.h.aZW().b(3763, localMusicMvView.LYH);
      com.tencent.mm.kernel.h.aZW().b(5286, localMusicMvView.LYH);
      com.tencent.mm.kernel.h.aZW().b(5292, localMusicMvView.LYH);
      Object localObject = localMusicMvView.getLyricManager();
      Log.i("MicroMsg.Mv.MusicMvLyric", "onDestroy");
      ((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).Mcc.clear();
      ((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).LOA = null;
      j.gnw().gnj().b(((com.tencent.mm.plugin.mv.ui.open.text_status.a)localObject).LJz);
      localObject = localMusicMvView.Mci;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).TGY.release();
      }
      localMusicMvView.Mci = null;
      localMusicMvView.Mcl = false;
    }
    this.LWx.dead();
    AppMethodBeat.o(286135);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(286194);
    super.onPostClose();
    gpl();
    AppMethodBeat.o(286194);
  }
  
  protected final void sD(long paramLong)
  {
    this.LWs = paramLong;
  }
  
  public final void zO(boolean paramBoolean)
  {
    this.hLy = paramBoolean;
  }
  
  public final void zP(boolean paramBoolean)
  {
    this.LWz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.jump.d
 * JD-Core Version:    0.7.0.1
 */