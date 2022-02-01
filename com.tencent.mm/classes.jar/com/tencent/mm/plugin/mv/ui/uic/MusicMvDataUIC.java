package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.a.e.a;
import com.tencent.mm.plugin.mv.a.n;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimeEnterMusicId", "getFirstTimeEnterMusicId", "setFirstTimeEnterMusicId", "(Ljava/lang/String;)V", "firstTimeEnterMusicType", "", "getFirstTimeEnterMusicType", "()Ljava/lang/Integer;", "setFirstTimeEnterMusicType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "initMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getInitMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setInitMv", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "launchCommentDialog", "", "getLaunchCommentDialog", "()Z", "setLaunchCommentDialog", "(Z)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "mvPostPermissionBit", "", "getMvPostPermissionBit", "()J", "setMvPostPermissionBit", "(J)V", "refCommentId", "getRefCommentId", "setRefCommentId", "shareExtInfo", "Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "getShareExtInfo", "()Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "setShareExtInfo", "(Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "verifyInfo", "getVerifyInfo", "setVerifyInfo", "canCreateMv", "musicMv", "checkAndFillThirdAppSongInfo", "", "initData", "intent", "Landroid/content/Intent;", "isSameMusic", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseLyric", "plugin-mv_release"})
public final class MusicMvDataUIC
  extends UIComponent
  implements i
{
  com.tencent.mm.plugin.music.model.e Amv;
  public axy Aqo;
  String Ato;
  public com.tencent.mm.plugin.mv.a.e Atp;
  long Atq;
  csr Atr;
  public boolean Ats;
  private final String TAG;
  Integer Ura;
  public String fuN;
  public long tuj;
  
  public MusicMvDataUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257113);
    this.TAG = "MicroMsg.Mv.MusicMvDataUIC";
    this.Atp = new com.tencent.mm.plugin.mv.a.e();
    this.Aqo = new axy();
    this.Atr = new csr();
    AppMethodBeat.o(257113);
  }
  
  public final boolean d(com.tencent.mm.plugin.mv.a.e parame)
  {
    AppMethodBeat.i(257112);
    p.h(parame, "musicMv");
    if ((this.Atq & 1L) > 0L)
    {
      if (parame.ApM == 1)
      {
        if (parame.ApH.size() > 0)
        {
          AppMethodBeat.o(257112);
          return true;
        }
        AppMethodBeat.o(257112);
        return false;
      }
      if (parame.ApM == 4)
      {
        if ((parame.ApP != null) && (parame.ApQ.size() > 0))
        {
          AppMethodBeat.o(257112);
          return true;
        }
        AppMethodBeat.o(257112);
        return false;
      }
      AppMethodBeat.o(257112);
      return false;
    }
    AppMethodBeat.o(257112);
    return false;
  }
  
  public final void evO()
  {
    AppMethodBeat.i(257110);
    axy localaxy = this.Aqo;
    CharSequence localCharSequence = (CharSequence)localaxy.LIh;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label97;
      }
      i = 1;
      label39:
      if (i == 0) {
        break label102;
      }
    }
    for (;;)
    {
      if (localaxy == null) {
        break label107;
      }
      this.Amv = com.tencent.mm.plugin.music.model.e.a(localaxy.LIh, getActivity().getString(2131763403), "", m.iZ(localaxy.LIg, localaxy.musicDataUrl), localaxy.lDR, false, false);
      AppMethodBeat.o(257110);
      return;
      i = 0;
      break;
      label97:
      i = 0;
      break label39;
      label102:
      localaxy = null;
    }
    label107:
    AppMethodBeat.o(257110);
  }
  
  public final boolean f(f paramf)
  {
    AppMethodBeat.i(258901);
    if (paramf != null)
    {
      int i = paramf.jeT;
      Integer localInteger = this.Ura;
      if (localInteger == null) {}
      while ((i != localInteger.intValue()) || (!p.j(paramf.jeV, this.Ato)))
      {
        AppMethodBeat.o(258901);
        return false;
      }
      AppMethodBeat.o(258901);
      return true;
    }
    AppMethodBeat.o(258901);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(257109);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    p.h(localIntent, "intent");
    paramBundle = com.tencent.mm.plugin.music.model.l.AkI;
    paramBundle = com.tencent.mm.plugin.music.model.l.au((Activity)getActivity());
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.mv.ui.a.ArA;
      com.tencent.mm.plugin.mv.ui.a.a(paramBundle, this.Aqo);
    }
    paramBundle = com.tencent.mm.plugin.music.e.k.euj();
    p.g(paramBundle, "MusicPlayerManager.Instance()");
    paramBundle = paramBundle.etU();
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.jeT);
      this.Ura = paramBundle;
      paramBundle = com.tencent.mm.plugin.music.e.k.euj();
      p.g(paramBundle, "MusicPlayerManager.Instance()");
      paramBundle = paramBundle.etU();
      if (paramBundle == null) {
        break label612;
      }
      paramBundle = paramBundle.jeV;
      label117:
      this.Ato = paramBundle;
      if (!m.akQ(this.Aqo.LIf))
      {
        this.Aqo.BPc = getIntent().getStringExtra("key_mv_song_name");
        this.Aqo.LIh = getIntent().getStringExtra("key_mv_song_lyric");
        this.Aqo.lDR = getIntent().getStringExtra("key_mv_singer_name");
        this.Aqo.albumName = getIntent().getStringExtra("key_mv_album_name");
        this.Aqo.Djf = getIntent().getStringExtra("key_mv_album_cover_url");
        this.Aqo.LIk = Util.safeParseLong(getIntent().getStringExtra("key_mv_issue_date"));
        this.Aqo.LIi = getIntent().getStringExtra("key_mv_music_genre");
      }
      this.Aqo.identification = getIntent().getStringExtra("key_mv_identification");
      this.Aqo.extraInfo = getIntent().getStringExtra("key_mv_extra_info");
      this.Aqo.duration = getIntent().getIntExtra("key_mv_music_duration", 0);
      this.Atr.thumbPath = getIntent().getStringExtra("key_mv_thumb_path");
      Log.v(this.TAG, "alvinluo checkAndFillThirdAppSongInfo ext: %s, identification: %s, duration: %s", new Object[] { this.Aqo.extraInfo, this.Aqo.identification, Integer.valueOf(this.Aqo.duration) });
      localObject2 = localIntent.getByteArrayExtra("key_track_data");
      if (localObject2 == null) {
        break label646;
      }
      paramBundle = new csp();
      paramBundle.parseFrom((byte[])localObject2);
      localObject1 = paramBundle.MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((axw)localObject1).Aqo;
            if (localObject1 != null)
            {
              p.g(localObject1, "it");
              this.Aqo = ((axy)localObject1);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.mv.a.e.ApR;
      this.Atp = e.a.b(paramBundle);
      localObject1 = c.vGN;
      paramBundle = c.a.FS(paramBundle.localId);
      if (paramBundle != null)
      {
        if (!paramBundle.isPostFailed()) {
          break label617;
        }
        this.Atp.ApM = 3;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "init by trackData mvLocalId:" + this.Atp.ApB + " coverPath:" + this.Atp.ApD + " mvPostStatus:" + this.Atp.ApM);
      evO();
      this.Ats = localIntent.getBooleanExtra("key_launch_mv_comment", false);
      this.tuj = localIntent.getLongExtra("key_refer_mv_comment_id", 0L);
      AppMethodBeat.o(257109);
      return;
      paramBundle = null;
      break;
      label612:
      paramBundle = null;
      break label117;
      label617:
      if (!paramBundle.isPostFinish()) {
        this.Atp.ApM = 2;
      } else {
        this.Atp.ApM = 1;
      }
    }
    label646:
    Object localObject2 = (MusicMvDataUIC)this;
    String str1 = localIntent.getStringExtra("key_mv_feed_id");
    String str2 = localIntent.getStringExtra("key_mv_nonce_id");
    String str3 = localIntent.getStringExtra("key_mv_cover_url");
    String str4 = localIntent.getStringExtra("key_mv_poster");
    paramBundle = (Bundle)localObject1;
    int i;
    if (str1 != null)
    {
      paramBundle = (Bundle)localObject1;
      if (str2 != null)
      {
        paramBundle = (Bundle)localObject1;
        if (str3 != null)
        {
          paramBundle = (Bundle)localObject1;
          if (str4 != null)
          {
            if (((CharSequence)str1).length() <= 0) {
              break label943;
            }
            i = 1;
            label739:
            if (i == 0) {
              break label963;
            }
            if (((CharSequence)str2).length() <= 0) {
              break label948;
            }
            i = 1;
            label758:
            if (i == 0) {
              break label963;
            }
            if (((CharSequence)str3).length() <= 0) {
              break label953;
            }
            i = 1;
            label777:
            if (i == 0) {
              break label963;
            }
            if (((CharSequence)str4).length() <= 0) {
              break label958;
            }
            i = 1;
            label796:
            if (i == 0) {
              break label963;
            }
            long l = d.Ga(str1);
            ((MusicMvDataUIC)localObject2).Atp.ApE = Long.valueOf(l);
            ((MusicMvDataUIC)localObject2).Atp.ApF = str2;
            ((MusicMvDataUIC)localObject2).Atp.coverUrl = str3;
            ((MusicMvDataUIC)localObject2).Atp.aIm(str4);
            if (localIntent.getBooleanExtra("key_need_update_music_ball_url", false)) {
              com.tencent.mm.plugin.music.model.b.aHM(((MusicMvDataUIC)localObject2).Atp.coverUrl);
            }
            Log.i(((MusicMvDataUIC)localObject2).TAG, "init by feedId:" + str1 + " feedNonceId:" + str2);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = x.SXb;
      if (paramBundle != null) {
        break;
      }
      ((MusicMvDataUIC)localObject2).Atp.ApO = true;
      Log.i(((MusicMvDataUIC)localObject2).TAG, "enter empty mv 2");
      paramBundle = x.SXb;
      break;
      label943:
      i = 0;
      break label739;
      label948:
      i = 0;
      break label758;
      label953:
      i = 0;
      break label777;
      label958:
      i = 0;
      break label796;
      label963:
      ((MusicMvDataUIC)localObject2).Atp.ApO = true;
      Log.i(((MusicMvDataUIC)localObject2).TAG, "enter empty mv 1 " + str1 + ' ' + str2 + ' ' + str3 + ' ' + str4);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(258900);
    Object localObject1 = com.tencent.mm.plugin.mv.a.k.Aql;
    localObject1 = (Context)getActivity();
    axy localaxy = this.Aqo;
    p.h(localObject1, "context");
    p.h(localaxy, "songInfo");
    Object localObject2 = SecDataUIC.CWq;
    Object localObject3 = (cst)SecDataUIC.a.a((Context)localObject1, 7, cst.class);
    localObject2 = new gk();
    if (localObject3 != null)
    {
      ((gk)localObject2).tW(((cst)localObject3).sGQ);
      ((gk)localObject2).qn(((cst)localObject3).scene);
      ((gk)localObject2).ub(((cst)localObject3).MxJ);
      ((gk)localObject2).PT(((cst)localObject3).MxN);
      ((gk)localObject2).PV(((cst)localObject3).Uuh);
    }
    localObject3 = com.tencent.mm.plugin.mv.a.k.hz((Context)localObject1);
    ((gk)localObject2).PQ(((n)localObject3).UqB);
    ((gk)localObject2).PR(((n)localObject3).UqC);
    ((gk)localObject2).PS(((n)localObject3).UqD);
    ((gk)localObject2).tX(localaxy.BPc);
    ((gk)localObject2).ua(localaxy.LIf);
    ((gk)localObject2).tY(localaxy.LIg);
    ((gk)localObject2).tZ(localaxy.musicDataUrl);
    localObject3 = (CharSequence)localaxy.LIh;
    int i;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label333;
      }
    }
    label333:
    for (long l = 2L;; l = 1L)
    {
      ((gk)localObject2).qo(l);
      ((gk)localObject2).ue(localaxy.AqO);
      ((gk)localObject2).bvL(localaxy.lDR);
      ((gk)localObject2).PP(2L);
      ((gk)localObject2).PU(com.tencent.mm.plugin.mv.a.k.me((Context)localObject1));
      ((gk)localObject2).bfK();
      localObject1 = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(258900);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257111);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramq);
    AppMethodBeat.o(257111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC
 * JD-Core Version:    0.7.0.1
 */