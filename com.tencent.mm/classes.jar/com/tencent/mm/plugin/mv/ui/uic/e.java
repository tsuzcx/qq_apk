package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.a.q;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAGLyric", "getTAGLyric", "audioType", "", "getAudioType", "()I", "setAudioType", "(I)V", "commentCount", "getCommentCount", "setCommentCount", "finderunicomment_appname", "getFinderunicomment_appname", "setFinderunicomment_appname", "(Ljava/lang/String;)V", "finderunicomment_entity_id", "getFinderunicomment_entity_id", "setFinderunicomment_entity_id", "firstTimeEnterMusicId", "getFirstTimeEnterMusicId", "setFirstTimeEnterMusicId", "firstTimeEnterMusicType", "getFirstTimeEnterMusicType", "()Ljava/lang/Integer;", "setFirstTimeEnterMusicType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "flexClipMaxCount", "getFlexClipMaxCount", "setFlexClipMaxCount", "forwardCount", "getForwardCount", "setForwardCount", "hasLiked", "", "getHasLiked", "()Z", "setHasLiked", "(Z)V", "initMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getInitMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setInitMv", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "isFromShake", "setFromShake", "isFullScreen", "setFullScreen", "isRingTone", "setRingTone", "jumpInEntityId", "getJumpInEntityId", "setJumpInEntityId", "launchCommentDialog", "getLaunchCommentDialog", "setLaunchCommentDialog", "likeCount", "getLikeCount", "setLikeCount", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "mPlayInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "getMPlayInfo", "()Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "setMPlayInfo", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;)V", "markTryListen", "getMarkTryListen", "setMarkTryListen", "mvPostPermissionBit", "", "getMvPostPermissionBit", "()J", "setMvPostPermissionBit", "(J)V", "refCommentId", "getRefCommentId", "setRefCommentId", "ringBackDetail", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "getRingBackDetail", "()Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "setRingBackDetail", "(Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;)V", "ringToneNum", "getRingToneNum", "setRingToneNum", "shareExtInfo", "Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "getShareExtInfo", "()Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "setShareExtInfo", "(Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "verifyInfo", "getVerifyInfo", "setVerifyInfo", "canCreateMv", "musicMv", "canEnableChatRoom", "checkAndFillThirdAppSongInfo", "", "initData", "intent", "Landroid/content/Intent;", "isSameMusic", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseLyric", "processRingBackDetail", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public long AAW;
  public boolean Flq;
  int LIC;
  boolean LMi;
  com.tencent.mm.plugin.music.model.e LOA;
  public boo LWI;
  private final String MdT;
  Integer MdU;
  String MdV;
  public com.tencent.mm.plugin.mv.model.f MdW;
  public long MdX;
  public dti MdY;
  public boolean MdZ;
  int Mea;
  aa Meb;
  com.tencent.mm.plugin.ringtone.g.d Mec;
  boolean Med;
  int Mee;
  boolean Mef;
  public String Meg;
  public String Meh;
  public boolean Mei;
  public String Mej;
  final String TAG;
  public int commentCount;
  public int forwardCount;
  public int likeCount;
  String verifyInfo;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287721);
    this.TAG = "MicroMsg.Mv.MusicMvDataUIC";
    this.MdT = "MicroMsg.Mv.GetLyric";
    this.MdW = new com.tencent.mm.plugin.mv.model.f();
    this.LWI = new boo();
    this.MdY = new dti();
    this.LIC = 1;
    this.Meg = "";
    this.Meh = "";
    this.Mej = "";
    AppMethodBeat.o(287721);
  }
  
  private static final void a(e parame, com.tencent.mm.plugin.music.logic.a parama, String paramString)
  {
    AppMethodBeat.i(287755);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(parama, "$iMusicLogic");
    parame.LWI.Mcq = paramString;
    parame.gqD();
    k localk = k.aeZF;
    ((h)k.d(parame.getActivity()).q(h.class)).a(parame.LWI, parame.LOA);
    Log.i(parame.MdT, kotlin.g.b.s.X("get lyric from MidLink ", paramString));
    com.tencent.threadpool.h.ahAA.bm(new e..ExternalSyntheticLambda1(parame, paramString));
    ((com.tencent.mm.plugin.music.logic.l)parama).gnA();
    AppMethodBeat.o(287755);
  }
  
  private static final void a(e parame, String paramString)
  {
    AppMethodBeat.i(287741);
    kotlin.g.b.s.u(parame, "this$0");
    com.tencent.mm.plugin.music.model.l locall = com.tencent.mm.plugin.music.model.l.LMH;
    parame = com.tencent.mm.plugin.music.model.l.bb((Activity)parame.getActivity());
    if (parame != null) {
      com.tencent.mm.plugin.music.model.o.god().b(parame.field_musicId, parame.field_songAlbum, parame.field_songHAlbumUrl, paramString, false, false);
    }
    AppMethodBeat.o(287741);
  }
  
  public final boolean f(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(287880);
    if (paramf != null)
    {
      int i = paramf.oOt;
      Integer localInteger = this.MdU;
      if (localInteger == null) {}
      while ((i != localInteger.intValue()) || (!kotlin.g.b.s.p(paramf.oOv, this.MdV)))
      {
        AppMethodBeat.o(287880);
        return false;
      }
      AppMethodBeat.o(287880);
      return true;
    }
    AppMethodBeat.o(287880);
    return false;
  }
  
  public final void gqD()
  {
    AppMethodBeat.i(287842);
    Object localObject = this.LWI;
    CharSequence localCharSequence = (CharSequence)((boo)localObject).Mcq;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label113;
      }
      i = 1;
      label40:
      if (i == 0) {
        break label118;
      }
      label44:
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.music.model.e.a(((boo)localObject).Mcq, getActivity().getString(b.h.music_prefix), "", m.ky(((boo)localObject).ZWR, ((boo)localObject).musicDataUrl), ((boo)localObject).rDl, false, false);
        if (((com.tencent.mm.plugin.music.model.e)localObject).LMm.size() <= 1) {
          break label123;
        }
      }
    }
    for (;;)
    {
      this.LOA = ((com.tencent.mm.plugin.music.model.e)localObject);
      AppMethodBeat.o(287842);
      return;
      i = 0;
      break;
      label113:
      i = 0;
      break label40;
      label118:
      localObject = null;
      break label44;
      label123:
      localObject = null;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(287828);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    kotlin.g.b.s.u(localIntent, "intent");
    paramBundle = com.tencent.mm.plugin.music.model.l.LMH;
    paramBundle = com.tencent.mm.plugin.music.model.l.bb((Activity)getActivity());
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.LWI);
    }
    paramBundle = j.gnw().LLw;
    if (paramBundle != null)
    {
      if (!(paramBundle instanceof com.tencent.mm.plugin.music.logic.l)) {
        break label1531;
      }
      if (paramBundle != null) {
        ((com.tencent.mm.plugin.music.logic.l)paramBundle).LLC = new e..ExternalSyntheticLambda0(this, paramBundle);
      }
    }
    if (kotlin.g.b.s.p(this.LWI.ZWQ, "wx485a97c844086dc9")) {
      this.LWI.ZWQ = "wx5aa333606550dfd5";
    }
    this.Mef = localIntent.getBooleanExtra("key_mv_music_from_shake", false);
    this.LIC = localIntent.getIntExtra("key_mv_audio_type", 1);
    Object localObject2 = localIntent.getStringExtra("key_mv_entity_id");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.Mej = paramBundle;
    paramBundle = com.tencent.mm.plugin.mv.model.l.LXJ;
    Object localObject3 = this.LWI;
    paramBundle = (Activity)getActivity();
    kotlin.g.b.s.u(localObject3, "songInfo");
    kotlin.g.b.s.u(paramBundle, "activity");
    com.tencent.mm.plugin.mv.model.l.activity = paramBundle;
    Log.i("MicroMsg.Mv.MvChattingDataManger", "onMvMainUIEnter, songName:" + ((boo)localObject3).songName + ", singer:" + ((boo)localObject3).rDl);
    Object localObject4 = new StringBuilder();
    localObject2 = ((boo)localObject3).songName;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    localObject4 = ((StringBuilder)localObject4).append(paramBundle).append('_');
    localObject2 = ((boo)localObject3).rDl;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    paramBundle = paramBundle;
    boolean bool;
    if (!com.tencent.mm.plugin.mv.model.l.LXK)
    {
      if (kotlin.g.b.s.p(paramBundle, com.tencent.mm.plugin.mv.model.l.LXL)) {
        break label1536;
      }
      bool = true;
      label339:
      com.tencent.mm.plugin.mv.model.l.LXK = bool;
      if (bool) {
        com.tencent.mm.plugin.mv.model.l.gpI();
      }
    }
    com.tencent.mm.plugin.mv.model.l.LYb = true;
    label369:
    label382:
    int i;
    label400:
    label434:
    label438:
    label479:
    label608:
    label612:
    label746:
    label750:
    label881:
    label885:
    String str;
    label512:
    label518:
    label522:
    label563:
    label567:
    label698:
    label702:
    label836:
    label840:
    label1007:
    label1011:
    Object localObject5;
    if (!com.tencent.mm.plugin.mv.model.l.LXK)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "onSessionStart, Not new session");
      paramBundle = j.gnw().gng();
      if (paramBundle != null) {
        break label1579;
      }
      paramBundle = null;
      this.MdU = paramBundle;
      paramBundle = j.gnw().gng();
      if (paramBundle != null) {
        break label1590;
      }
      paramBundle = null;
      this.MdV = paramBundle;
      paramBundle = getIntent().getStringExtra("key_mv_song_name");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1598;
        }
        i = 1;
        if (i == 0) {
          break label1603;
        }
        if (paramBundle != null) {
          this.LWI.songName = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_song_lyric");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1608;
        }
        i = 1;
        if (i == 0) {
          break label1618;
        }
        localObject2 = (CharSequence)this.LWI.Mcq;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label1613;
        }
        i = 1;
        if (i == 0) {
          break label1618;
        }
        i = 1;
        if (i == 0) {
          break label1623;
        }
        if (paramBundle != null) {
          this.LWI.Mcq = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_singer_name");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1628;
        }
        i = 1;
        if (i == 0) {
          break label1633;
        }
        if (paramBundle != null) {
          this.LWI.rDl = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_album_name");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1638;
        }
        i = 1;
        if (i == 0) {
          break label1643;
        }
        if (paramBundle != null) {
          this.LWI.albumName = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_album_cover_url");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1648;
        }
        i = 1;
        label653:
        if (i == 0) {
          break label1653;
        }
        label657:
        if (paramBundle != null) {
          this.LWI.ZWS = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_issue_date");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1658;
        }
        i = 1;
        if (i == 0) {
          break label1663;
        }
        if (paramBundle != null) {
          this.LWI.ZWU = Util.safeParseLong(paramBundle);
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_music_genre");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1668;
        }
        i = 1;
        if (i == 0) {
          break label1673;
        }
        if (paramBundle != null) {
          this.LWI.ZTA = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_identification");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1678;
        }
        i = 1;
        label791:
        if (i == 0) {
          break label1683;
        }
        label795:
        if (paramBundle != null) {
          this.LWI.identification = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_extra_info");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1688;
        }
        i = 1;
        if (i == 0) {
          break label1693;
        }
        if (paramBundle != null) {
          this.LWI.extraInfo = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_thumb_path");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1698;
        }
        i = 1;
        if (i == 0) {
          break label1703;
        }
        if (paramBundle != null) {
          this.MdY.thumbPath = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_music_operation_url");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1708;
        }
        i = 1;
        label926:
        if (i == 0) {
          break label1713;
        }
        label930:
        if (paramBundle != null)
        {
          if (this.LWI.ZWW == null) {
            this.LWI.ZWW = new bop();
          }
          localObject2 = this.LWI.ZWW;
          kotlin.g.b.s.checkNotNull(localObject2);
          ((bop)localObject2).ZWX = paramBundle;
        }
      }
      paramBundle = getIntent().getStringExtra("key_mv_song_mid");
      if (paramBundle != null)
      {
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1718;
        }
        i = 1;
        if (i == 0) {
          break label1723;
        }
        if (paramBundle != null) {
          this.LWI.oOZ = paramBundle;
        }
      }
      this.LWI.duration = getIntent().getIntExtra("key_mv_music_duration", 0);
      localObject2 = this.TAG;
      localObject3 = this.LWI.extraInfo;
      localObject4 = this.LWI.identification;
      paramBundle = this.LWI.ZWW;
      if (paramBundle != null) {
        break label1728;
      }
      paramBundle = null;
      label1079:
      i = this.LWI.duration;
      str = this.LWI.ZWQ;
      localObject5 = com.tencent.mm.plugin.mv.ui.a.Maz;
      Log.v((String)localObject2, "alvinluo checkAndFillThirdAppSongInfo ext: %s, identification: %s, operationUrl: %s, duration: %s, musicAppId: %s, %s", new Object[] { localObject3, localObject4, paramBundle, Integer.valueOf(i), str, com.tencent.mm.plugin.mv.ui.a.b(this.LWI) });
      this.LMi = localIntent.getBooleanExtra("markTryListen", false);
      localObject2 = localIntent.getByteArrayExtra("key_track_data");
      if (localObject2 != null) {
        break label1736;
      }
      paramBundle = null;
      if (paramBundle == null)
      {
        localObject2 = (e)this;
        localObject3 = localIntent.getStringExtra("key_mv_feed_id");
        localObject4 = localIntent.getStringExtra("key_mv_nonce_id");
        str = localIntent.getStringExtra("key_mv_cover_url");
        localObject5 = localIntent.getStringExtra("key_mv_poster");
        paramBundle = localObject1;
        if (localObject3 != null)
        {
          paramBundle = localObject1;
          if (localObject4 != null)
          {
            paramBundle = localObject1;
            if (str != null)
            {
              paramBundle = localObject1;
              if (localObject5 != null)
              {
                if (((CharSequence)localObject3).length() <= 0) {
                  break label1967;
                }
                i = 1;
                label1277:
                if (i == 0) {
                  break label1987;
                }
                if (((CharSequence)localObject4).length() <= 0) {
                  break label1972;
                }
                i = 1;
                label1296:
                if (i == 0) {
                  break label1987;
                }
                if (((CharSequence)str).length() <= 0) {
                  break label1977;
                }
                i = 1;
                label1315:
                if (i == 0) {
                  break label1987;
                }
                if (((CharSequence)localObject5).length() <= 0) {
                  break label1982;
                }
                i = 1;
                label1334:
                if (i == 0) {
                  break label1987;
                }
                long l = com.tencent.mm.ae.d.FK((String)localObject3);
                ((e)localObject2).MdW.LXj = Long.valueOf(l);
                ((e)localObject2).MdW.LXk = ((String)localObject4);
                ((e)localObject2).MdW.coverUrl = str;
                ((e)localObject2).MdW.aPx((String)localObject5);
                if (localIntent.getBooleanExtra("key_need_update_music_ball_url", false)) {
                  com.tencent.mm.plugin.music.model.b.aOT(((e)localObject2).MdW.coverUrl);
                }
                Log.i(((e)localObject2).TAG, "init by feedId:" + (String)localObject3 + " feedNonceId:" + (String)localObject4);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = ah.aiuX;
      if (paramBundle == null)
      {
        ((e)localObject2).MdW.LXu = true;
        Log.i(((e)localObject2).TAG, "enter empty mv 2");
      }
      gqD();
      this.MdZ = localIntent.getBooleanExtra("key_launch_mv_comment", false);
      this.AAW = localIntent.getLongExtra("key_refer_mv_comment_id", 0L);
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(87);
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(92);
      AppMethodBeat.o(287828);
      return;
      label1531:
      paramBundle = null;
      break;
      label1536:
      bool = false;
      break label339;
      com.tencent.mm.plugin.mv.model.l.LXL = paramBundle;
      com.tencent.mm.plugin.mv.model.l.LWI = (boo)localObject3;
      com.tencent.mm.plugin.mv.model.l.LXK = false;
      paramBundle = new q((boo)localObject3);
      com.tencent.mm.kernel.h.aZW().a((p)paramBundle, 0);
      break label369;
      label1579:
      paramBundle = Integer.valueOf(paramBundle.oOt);
      break label382;
      label1590:
      paramBundle = paramBundle.oOv;
      break label400;
      label1598:
      i = 0;
      break label434;
      label1603:
      paramBundle = null;
      break label438;
      label1608:
      i = 0;
      break label479;
      label1613:
      i = 0;
      break label512;
      label1618:
      i = 0;
      break label518;
      label1623:
      paramBundle = null;
      break label522;
      label1628:
      i = 0;
      break label563;
      label1633:
      paramBundle = null;
      break label567;
      label1638:
      i = 0;
      break label608;
      label1643:
      paramBundle = null;
      break label612;
      label1648:
      i = 0;
      break label653;
      label1653:
      paramBundle = null;
      break label657;
      label1658:
      i = 0;
      break label698;
      label1663:
      paramBundle = null;
      break label702;
      label1668:
      i = 0;
      break label746;
      label1673:
      paramBundle = null;
      break label750;
      label1678:
      i = 0;
      break label791;
      label1683:
      paramBundle = null;
      break label795;
      label1688:
      i = 0;
      break label836;
      label1693:
      paramBundle = null;
      break label840;
      label1698:
      i = 0;
      break label881;
      label1703:
      paramBundle = null;
      break label885;
      label1708:
      i = 0;
      break label926;
      label1713:
      paramBundle = null;
      break label930;
      label1718:
      i = 0;
      break label1007;
      label1723:
      paramBundle = null;
      break label1011;
      label1728:
      paramBundle = paramBundle.ZWX;
      break label1079;
      label1736:
      paramBundle = new dtf();
      paramBundle.parseFrom((byte[])localObject2);
      localObject2 = paramBundle.aaYK;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).mvInfo;
          if (localObject2 != null)
          {
            localObject2 = ((bol)localObject2).LWI;
            if (localObject2 != null)
            {
              kotlin.g.b.s.u(localObject2, "<set-?>");
              this.LWI = ((boo)localObject2);
            }
          }
        }
      }
      localObject2 = com.tencent.mm.plugin.mv.model.f.LXf;
      localObject2 = f.a.b(paramBundle);
      kotlin.g.b.s.u(localObject2, "<set-?>");
      this.MdW = ((com.tencent.mm.plugin.mv.model.f)localObject2);
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramBundle = d.a.qr(paramBundle.localId);
      if (paramBundle != null)
      {
        if (!paramBundle.isPostFailed()) {
          break label1938;
        }
        this.MdW.LXs = 3;
      }
      for (;;)
      {
        Log.i(this.TAG, "init by trackData mvLocalId:" + this.MdW.LXg + " coverPath:" + this.MdW.LXi + " mvPostStatus:" + this.MdW.LXs);
        paramBundle = ah.aiuX;
        break;
        label1938:
        if (!paramBundle.isPostFinish()) {
          this.MdW.LXs = 2;
        } else {
          this.MdW.LXs = 1;
        }
      }
      label1967:
      i = 0;
      break label1277;
      label1972:
      i = 0;
      break label1296;
      label1977:
      i = 0;
      break label1315;
      label1982:
      i = 0;
      break label1334;
      label1987:
      ((e)localObject2).MdW.LXu = true;
      Log.i(((e)localObject2).TAG, "enter empty mv 1 " + (String)localObject3 + ' ' + (String)localObject4 + ' ' + str + ' ' + (String)localObject5);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287871);
    Object localObject = com.tencent.mm.plugin.mv.model.o.LYk;
    com.tencent.mm.plugin.mv.model.o.a((Context)getActivity(), this.LWI);
    localObject = com.tencent.mm.plugin.mv.model.l.LXJ;
    StringBuilder localStringBuilder = new StringBuilder("onMvMainUIExit, songName:");
    localObject = com.tencent.mm.plugin.mv.model.l.LWI;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(", singer:");
      localObject = com.tencent.mm.plugin.mv.model.l.LWI;
      if (localObject != null) {
        break label180;
      }
      localObject = null;
      label71:
      Log.i("MicroMsg.Mv.MvChattingDataManger", localObject);
      com.tencent.mm.plugin.mv.model.l.activity = null;
      com.tencent.mm.plugin.mv.model.l.LXV.clear();
      com.tencent.mm.plugin.mv.model.l.LXW.clear();
      com.tencent.mm.plugin.mv.model.l.LXX.clear();
      com.tencent.mm.plugin.mv.model.l.LXY.clear();
      if (2 == com.tencent.mm.plugin.mv.model.l.LYa)
      {
        Log.i("MicroMsg.Mv.MvChattingDataManger", "song is stop Playing, session End");
        com.tencent.mm.plugin.mv.model.l.gpI();
      }
      com.tencent.mm.plugin.mv.model.l.LYb = false;
      localObject = j.gnw().LLw;
      if (localObject != null) {
        if (!(localObject instanceof com.tencent.mm.plugin.music.logic.l)) {
          break label188;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.music.logic.l)localObject).gnA();
      }
      AppMethodBeat.o(287871);
      return;
      localObject = ((boo)localObject).songName;
      break;
      label180:
      localObject = ((boo)localObject).rDl;
      break label71;
      label188:
      localObject = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(287856);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramp);
    AppMethodBeat.o(287856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.e
 * JD-Core Version:    0.7.0.1
 */