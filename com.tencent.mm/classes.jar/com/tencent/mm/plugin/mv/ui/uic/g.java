package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.ij;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.model.o;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimeEnterMusicId", "getFirstTimeEnterMusicId", "setFirstTimeEnterMusicId", "(Ljava/lang/String;)V", "firstTimeEnterMusicType", "", "getFirstTimeEnterMusicType", "()Ljava/lang/Integer;", "setFirstTimeEnterMusicType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "flexClipMaxCount", "getFlexClipMaxCount", "()I", "setFlexClipMaxCount", "(I)V", "initMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getInitMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setInitMv", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "launchCommentDialog", "getLaunchCommentDialog", "setLaunchCommentDialog", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "mvPostPermissionBit", "", "getMvPostPermissionBit", "()J", "setMvPostPermissionBit", "(J)V", "refCommentId", "getRefCommentId", "setRefCommentId", "shareExtInfo", "Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "getShareExtInfo", "()Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "setShareExtInfo", "(Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "verifyInfo", "getVerifyInfo", "setVerifyInfo", "canCreateMv", "musicMv", "canEnableChatRoom", "checkAndFillThirdAppSongInfo", "", "initData", "intent", "Landroid/content/Intent;", "isSameMusic", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseLyric", "plugin-mv_release"})
public final class g
  extends UIComponent
  implements i
{
  public boolean AJP;
  e FTB;
  public bds GaB;
  Integer GiT;
  String GiU;
  public com.tencent.mm.plugin.mv.model.f GiV;
  public long GiW;
  public dbq GiX;
  public boolean GiY;
  int GiZ;
  private final String TAG;
  String verifyInfo;
  public long xbT;
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(229604);
    this.TAG = "MicroMsg.Mv.MusicMvDataUIC";
    this.GiV = new com.tencent.mm.plugin.mv.model.f();
    this.GaB = new bds();
    this.GiX = new dbq();
    AppMethodBeat.o(229604);
  }
  
  public final boolean f(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(229603);
    if (paramf != null)
    {
      int i = paramf.lVr;
      Integer localInteger = this.GiT;
      if (localInteger == null) {}
      while ((i != localInteger.intValue()) || (!kotlin.g.b.p.h(paramf.lVt, this.GiU)))
      {
        AppMethodBeat.o(229603);
        return false;
      }
      AppMethodBeat.o(229603);
      return true;
    }
    AppMethodBeat.o(229603);
    return false;
  }
  
  public final boolean f(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(229599);
    kotlin.g.b.p.k(paramf, "musicMv");
    if ((this.GiW & 1L) > 0L)
    {
      boolean bool2 = ((ak)h.ag(ak.class)).showFinderEntry();
      com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      kotlin.g.b.p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
      {
        locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
        kotlin.g.b.p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
        if (((com.tencent.mm.plugin.teenmode.a.b)locala).dYS() != 2) {}
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i(this.TAG, "[canCreateMv] show:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((bool2) && (!bool1)) {
          break;
        }
        AppMethodBeat.o(229599);
        return false;
      }
      switch (paramf.Gbu)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(229599);
        return false;
      case 1: 
        if (paramf.Gbo.size() > 0)
        {
          AppMethodBeat.o(229599);
          return true;
        }
        AppMethodBeat.o(229599);
        return false;
      }
      if ((paramf.Gbx != null) && (paramf.Gby.size() > 0))
      {
        AppMethodBeat.o(229599);
        return true;
      }
      AppMethodBeat.o(229599);
      return false;
    }
    AppMethodBeat.o(229599);
    return false;
  }
  
  public final void fgV()
  {
    AppMethodBeat.i(229597);
    Object localObject = this.GaB;
    CharSequence localCharSequence = (CharSequence)((bds)localObject).SOL;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label116;
      }
      i = 1;
      label39:
      if (i == 0) {
        break label121;
      }
      label43:
      if (localObject == null) {
        break label131;
      }
      localObject = e.a(((bds)localObject).SOL, getActivity().getString(b.h.music_prefix), "", com.tencent.mm.plugin.music.model.m.jj(((bds)localObject).SOK, ((bds)localObject).musicDataUrl), ((bds)localObject).ozs, false, false);
      kotlin.g.b.p.j(localObject, "obj");
      if (((e)localObject).feO() <= 1) {
        break label126;
      }
    }
    for (;;)
    {
      this.FTB = ((e)localObject);
      AppMethodBeat.o(229597);
      return;
      i = 0;
      break;
      label116:
      i = 0;
      break label39;
      label121:
      localObject = null;
      break label43;
      label126:
      localObject = null;
    }
    label131:
    AppMethodBeat.o(229597);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(229595);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    kotlin.g.b.p.k(localIntent, "intent");
    paramBundle = com.tencent.mm.plugin.music.model.l.FRM;
    paramBundle = com.tencent.mm.plugin.music.model.l.aA((Activity)getActivity());
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.GaB);
    }
    paramBundle = com.tencent.mm.plugin.mv.model.l.Gcr;
    Object localObject3 = this.GaB;
    paramBundle = (Activity)getActivity();
    kotlin.g.b.p.k(localObject3, "songInfo");
    kotlin.g.b.p.k(paramBundle, "activity");
    com.tencent.mm.plugin.mv.model.l.activity = paramBundle;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onMvMainUIEnter, songName:" + ((bds)localObject3).HLH + ", singer:" + ((bds)localObject3).ozs);
    Object localObject4 = new StringBuilder();
    Object localObject2 = ((bds)localObject3).HLH;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    localObject4 = ((StringBuilder)localObject4).append(paramBundle).append('_');
    localObject2 = ((bds)localObject3).ozs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    paramBundle = paramBundle;
    if (!com.tencent.mm.plugin.mv.model.l.GbZ)
    {
      boolean bool = kotlin.g.b.p.h(paramBundle, com.tencent.mm.plugin.mv.model.l.Gca) ^ true;
      com.tencent.mm.plugin.mv.model.l.GbZ = bool;
      if (bool) {
        com.tencent.mm.plugin.mv.model.l.fge();
      }
    }
    com.tencent.mm.plugin.mv.model.l.Gcq = true;
    label281:
    label311:
    int i;
    if (!com.tencent.mm.plugin.mv.model.l.GbZ)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "onSessionStart, Not new session");
      paramBundle = k.fet();
      kotlin.g.b.p.j(paramBundle, "MusicPlayerManager.Instance()");
      paramBundle = paramBundle.fed();
      if (paramBundle == null) {
        break label1125;
      }
      paramBundle = Integer.valueOf(paramBundle.lVr);
      this.GiT = paramBundle;
      paramBundle = k.fet();
      kotlin.g.b.p.j(paramBundle, "MusicPlayerManager.Instance()");
      paramBundle = paramBundle.fed();
      if (paramBundle == null) {
        break label1130;
      }
      paramBundle = paramBundle.lVt;
      this.GiU = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_song_name");
      if (paramBundle == null) {
        break label1145;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1135;
      }
      i = 1;
      label345:
      if (i == 0) {
        break label1140;
      }
      label349:
      this.GaB.HLH = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_song_lyric");
      if (paramBundle == null) {
        break label1160;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1150;
      }
      i = 1;
      label386:
      if (i == 0) {
        break label1155;
      }
      label390:
      this.GaB.SOL = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_singer_name");
      if (paramBundle == null) {
        break label1175;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1165;
      }
      i = 1;
      label427:
      if (i == 0) {
        break label1170;
      }
      label431:
      this.GaB.ozs = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_album_name");
      if (paramBundle == null) {
        break label1190;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1180;
      }
      i = 1;
      label468:
      if (i == 0) {
        break label1185;
      }
      label472:
      this.GaB.albumName = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_album_cover_url");
      if (paramBundle == null) {
        break label1205;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1195;
      }
      i = 1;
      label509:
      if (i == 0) {
        break label1200;
      }
      label513:
      this.GaB.SOM = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_issue_date");
      if (paramBundle == null) {
        break label1220;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1210;
      }
      i = 1;
      label550:
      if (i == 0) {
        break label1215;
      }
      label554:
      this.GaB.SOO = Util.safeParseLong(paramBundle);
      paramBundle = getIntent().getStringExtra("key_mv_music_genre");
      if (paramBundle == null) {
        break label1235;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1225;
      }
      i = 1;
      label594:
      if (i == 0) {
        break label1230;
      }
      label598:
      this.GaB.SMY = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_identification");
      if (paramBundle == null) {
        break label1250;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1240;
      }
      i = 1;
      label635:
      if (i == 0) {
        break label1245;
      }
      label639:
      this.GaB.identification = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_extra_info");
      if (paramBundle == null) {
        break label1265;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1255;
      }
      i = 1;
      label676:
      if (i == 0) {
        break label1260;
      }
      label680:
      this.GaB.extraInfo = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_thumb_path");
      if (paramBundle == null) {
        break label1280;
      }
      if (((CharSequence)paramBundle).length() <= 0) {
        break label1270;
      }
      i = 1;
      label717:
      if (i == 0) {
        break label1275;
      }
      label721:
      this.GiX.thumbPath = paramBundle;
      this.GaB.duration = getIntent().getIntExtra("key_mv_music_duration", 0);
      paramBundle = this.TAG;
      localObject2 = this.GaB.extraInfo;
      localObject3 = this.GaB.identification;
      i = this.GaB.duration;
      localObject4 = this.GaB.SOJ;
      localObject5 = com.tencent.mm.plugin.mv.ui.a.Gfi;
      Log.v(paramBundle, "alvinluo checkAndFillThirdAppSongInfo ext: %s, identification: %s, duration: %s, musicAppId: %s, %s", new Object[] { localObject2, localObject3, Integer.valueOf(i), localObject4, com.tencent.mm.plugin.mv.ui.a.b(this.GaB) });
      localObject2 = localIntent.getByteArrayExtra("key_track_data");
      if (localObject2 == null) {
        break label1314;
      }
      paramBundle = new dbo();
      paramBundle.parseFrom((byte[])localObject2);
      localObject1 = paramBundle.TIV;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((bdp)localObject1).GaB;
            if (localObject1 != null)
            {
              kotlin.g.b.p.j(localObject1, "it");
              this.GaB = ((bds)localObject1);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.mv.model.f.GbD;
      this.GiV = f.a.b(paramBundle);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      paramBundle = c.a.MS(paramBundle.localId);
      if (paramBundle != null)
      {
        if (!paramBundle.isPostFailed()) {
          break label1285;
        }
        this.GiV.Gbu = 3;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "init by trackData mvLocalId:" + this.GiV.Gbi + " coverPath:" + this.GiV.Gbk + " mvPostStatus:" + this.GiV.Gbu);
      fgV();
      this.GiY = localIntent.getBooleanExtra("key_launch_mv_comment", false);
      this.xbT = localIntent.getLongExtra("key_refer_mv_comment_id", 0L);
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      com.tencent.mm.pluginsdk.k.a.a.b.apP(87);
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      com.tencent.mm.pluginsdk.k.a.a.b.apP(92);
      AppMethodBeat.o(229595);
      return;
      com.tencent.mm.plugin.mv.model.l.Gca = paramBundle;
      com.tencent.mm.plugin.mv.model.l.GaB = (bds)localObject3;
      com.tencent.mm.plugin.mv.model.l.GbZ = false;
      paramBundle = new com.tencent.mm.plugin.mv.model.a.m((bds)localObject3);
      h.aGY().b((q)paramBundle);
      break;
      label1125:
      paramBundle = null;
      break label281;
      label1130:
      paramBundle = null;
      break label311;
      label1135:
      i = 0;
      break label345;
      label1140:
      paramBundle = null;
      break label349;
      label1145:
      paramBundle = null;
      break label349;
      label1150:
      i = 0;
      break label386;
      label1155:
      paramBundle = null;
      break label390;
      label1160:
      paramBundle = null;
      break label390;
      label1165:
      i = 0;
      break label427;
      label1170:
      paramBundle = null;
      break label431;
      label1175:
      paramBundle = null;
      break label431;
      label1180:
      i = 0;
      break label468;
      label1185:
      paramBundle = null;
      break label472;
      label1190:
      paramBundle = null;
      break label472;
      label1195:
      i = 0;
      break label509;
      label1200:
      paramBundle = null;
      break label513;
      label1205:
      paramBundle = null;
      break label513;
      label1210:
      i = 0;
      break label550;
      label1215:
      paramBundle = null;
      break label554;
      label1220:
      paramBundle = null;
      break label554;
      label1225:
      i = 0;
      break label594;
      label1230:
      paramBundle = null;
      break label598;
      label1235:
      paramBundle = null;
      break label598;
      label1240:
      i = 0;
      break label635;
      label1245:
      paramBundle = null;
      break label639;
      label1250:
      paramBundle = null;
      break label639;
      label1255:
      i = 0;
      break label676;
      label1260:
      paramBundle = null;
      break label680;
      label1265:
      paramBundle = null;
      break label680;
      label1270:
      i = 0;
      break label717;
      label1275:
      paramBundle = null;
      break label721;
      label1280:
      paramBundle = null;
      break label721;
      label1285:
      if (!paramBundle.isPostFinish()) {
        this.GiV.Gbu = 2;
      } else {
        this.GiV.Gbu = 1;
      }
    }
    label1314:
    localObject2 = (g)this;
    localObject3 = localIntent.getStringExtra("key_mv_feed_id");
    localObject4 = localIntent.getStringExtra("key_mv_nonce_id");
    Object localObject5 = localIntent.getStringExtra("key_mv_cover_url");
    String str = localIntent.getStringExtra("key_mv_poster");
    paramBundle = (Bundle)localObject1;
    if (localObject3 != null)
    {
      paramBundle = (Bundle)localObject1;
      if (localObject4 != null)
      {
        paramBundle = (Bundle)localObject1;
        if (localObject5 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (str != null)
          {
            if (((CharSequence)localObject3).length() <= 0) {
              break label1613;
            }
            i = 1;
            label1407:
            if (i == 0) {
              break label1633;
            }
            if (((CharSequence)localObject4).length() <= 0) {
              break label1618;
            }
            i = 1;
            label1426:
            if (i == 0) {
              break label1633;
            }
            if (((CharSequence)localObject5).length() <= 0) {
              break label1623;
            }
            i = 1;
            label1445:
            if (i == 0) {
              break label1633;
            }
            if (((CharSequence)str).length() <= 0) {
              break label1628;
            }
            i = 1;
            label1464:
            if (i == 0) {
              break label1633;
            }
            long l = d.Nb((String)localObject3);
            ((g)localObject2).GiV.Gbl = Long.valueOf(l);
            ((g)localObject2).GiV.Gbm = ((String)localObject4);
            ((g)localObject2).GiV.coverUrl = ((String)localObject5);
            ((g)localObject2).GiV.aSD(str);
            if (localIntent.getBooleanExtra("key_need_update_music_ball_url", false)) {
              com.tencent.mm.plugin.music.model.b.aSb(((g)localObject2).GiV.coverUrl);
            }
            Log.i(((g)localObject2).TAG, "init by feedId:" + (String)localObject3 + " feedNonceId:" + (String)localObject4);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = x.aazN;
      if (paramBundle != null) {
        break;
      }
      ((g)localObject2).GiV.Gbw = true;
      Log.i(((g)localObject2).TAG, "enter empty mv 2");
      paramBundle = x.aazN;
      break;
      label1613:
      i = 0;
      break label1407;
      label1618:
      i = 0;
      break label1426;
      label1623:
      i = 0;
      break label1445;
      label1628:
      i = 0;
      break label1464;
      label1633:
      ((g)localObject2).GiV.Gbw = true;
      Log.i(((g)localObject2).TAG, "enter empty mv 1 " + (String)localObject3 + ' ' + (String)localObject4 + ' ' + (String)localObject5 + ' ' + str);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229601);
    Object localObject1 = o.GcB;
    Object localObject2 = (Context)getActivity();
    bds localbds = this.GaB;
    kotlin.g.b.p.k(localObject2, "context");
    kotlin.g.b.p.k(localbds, "songInfo");
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject1 = (dbs)a.a.a((Context)localObject2, 7, dbs.class);
    ij localij = new ij();
    label265:
    int i;
    label333:
    long l;
    if (localObject1 != null)
    {
      localij.yy(((dbs)localObject1).wmL);
      localij.ta(((dbs)localObject1).scene);
      localij.yD(((dbs)localObject1).TJa);
      localij.tg(((dbs)localObject1).TJb);
      localij.ti(((dbs)localObject1).TJh);
      localij.tj(((dbs)localObject1).TJi);
      localij.tk(((dbs)localObject1).TJj);
      localij.tl(((dbs)localObject1).TJk);
      localij.tm(((dbs)localObject1).TJl);
      if (((dbs)localObject1).TJo == 3) {
        localij.tn(3L);
      }
    }
    else
    {
      localObject1 = o.hF((Context)localObject2);
      localij.td(((com.tencent.mm.plugin.mv.model.p)localObject1).GcD);
      localij.te(((com.tencent.mm.plugin.mv.model.p)localObject1).GcE);
      localij.tf(((com.tencent.mm.plugin.mv.model.p)localObject1).GcF);
      localObject1 = localbds.HLH;
      if (localObject1 == null) {
        break label584;
      }
      localObject1 = n.l((String)localObject1, ",", " ", false);
      localij.yz((String)localObject1);
      localij.yC(localbds.SOJ);
      localij.yA(localbds.SOK);
      localij.yB(localbds.musicDataUrl);
      localObject1 = (CharSequence)localbds.SOL;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label590;
      }
      i = 1;
      if (i == 0) {
        break label595;
      }
      l = 2L;
      label341:
      localij.tb(l);
      localij.yG(localbds.kkU);
      localObject1 = localbds.ozs;
      if (localObject1 == null) {
        break label600;
      }
      localObject1 = n.l((String)localObject1, ",", " ", false);
      label385:
      localij.yH((String)localObject1);
      localij.tc(2L);
      localij.th(o.hG((Context)localObject2));
      localij.bpa();
      localObject1 = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localij);
      localObject1 = com.tencent.mm.plugin.mv.model.l.Gcr;
      localObject2 = new StringBuilder("onMvMainUIExit, songName:");
      localObject1 = com.tencent.mm.plugin.mv.model.l.GaB;
      if (localObject1 == null) {
        break label606;
      }
      localObject1 = ((bds)localObject1).HLH;
      label466:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", singer:");
      localObject1 = com.tencent.mm.plugin.mv.model.l.GaB;
      if (localObject1 == null) {
        break label612;
      }
    }
    label584:
    label590:
    label595:
    label600:
    label606:
    label612:
    for (localObject1 = ((bds)localObject1).ozs;; localObject1 = null)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", (String)localObject1);
      com.tencent.mm.plugin.mv.model.l.activity = null;
      com.tencent.mm.plugin.mv.model.l.Gck.clear();
      com.tencent.mm.plugin.mv.model.l.Gcl.clear();
      com.tencent.mm.plugin.mv.model.l.Gcm.clear();
      com.tencent.mm.plugin.mv.model.l.Gcn.clear();
      if (2 == com.tencent.mm.plugin.mv.model.l.Gcp)
      {
        Log.i("MicroMsg.Mv.MvChattingDataManger", "song is stop Playing, session End");
        com.tencent.mm.plugin.mv.model.l.fge();
      }
      com.tencent.mm.plugin.mv.model.l.Gcq = false;
      AppMethodBeat.o(229601);
      return;
      localij.tn(2L);
      break;
      localObject1 = null;
      break label265;
      i = 0;
      break label333;
      l = 1L;
      break label341;
      localObject1 = null;
      break label385;
      localObject1 = null;
      break label466;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(229598);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramq);
    AppMethodBeat.o(229598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.g
 * JD-Core Version:    0.7.0.1
 */