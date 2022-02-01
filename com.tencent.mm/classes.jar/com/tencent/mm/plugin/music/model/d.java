package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.ui.FloatBallMusicView;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallHelper;", "()V", "mCoverPath", "", "mCurrentMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mFloatBallMusicView", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "mMultiTaskHelper", "Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "mMvUIExtra", "Landroid/os/Bundle;", "addMusicFloatBall", "", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "canHandleMusicPlayerEvent", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "wrapper", "getFloatBallType", "", "getMusicMvUIIntent", "Landroid/content/Intent;", "initMusicFloatBallView", "onClickMusicBall", "onFloatBallRemoved", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "removeCurrentBall", "removeMusicBallState", "updateMusicBallState", "updateMusicCoverPath", "coverPath", "updateMusicMvInfo", "musicShareObject", "updateMusicMvUIExtra", "extra", "updateMusicShareObject", "Companion", "Holder", "plugin-music_release"})
public final class d
  extends a
{
  public static final d.a Aki;
  private FloatBallMusicView Akd;
  Bundle Ake;
  private String Akf;
  css Akg;
  private final k Akh;
  
  static
  {
    AppMethodBeat.i(219968);
    Aki = new d.a((byte)0);
    AppMethodBeat.o(219968);
  }
  
  public d()
  {
    super("MicroMsg.GlobalMusicPlayerFloatBallHelper");
    AppMethodBeat.i(219967);
    this.Akh = new k();
    AppMethodBeat.o(219967);
  }
  
  public static final d euu()
  {
    AppMethodBeat.i(219970);
    Object localObject = b.Akk;
    localObject = b.euv();
    AppMethodBeat.o(219970);
    return localObject;
  }
  
  protected final void A(f paramf)
  {
    AppMethodBeat.i(219959);
    p.h(paramf, "wrapper");
    if (paramf.jfx)
    {
      this.oWE.state = com.tencent.mm.plugin.ball.f.d.eV(this.oWE.state, 8);
      BH(this.oWE.state);
    }
    AppMethodBeat.o(219959);
  }
  
  public final void C(BallInfo paramBallInfo)
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(219962);
    Object localObject1 = com.tencent.mm.plugin.music.f.c.b.aS(e.class);
    p.g(localObject1, "MusicCoreService.service…PrivateLogic::class.java)");
    com.tencent.mm.plugin.music.model.e.a locala = ((e)localObject1).etY();
    k localk;
    label126:
    Object localObject3;
    label167:
    label190:
    label213:
    label236:
    int i;
    if (locala != null)
    {
      this.Akh.G(6, com.tencent.mm.plugin.multitask.g.az(locala.field_songName, locala.field_songSinger, locala.field_songAlbum));
      localk = this.Akh;
      localObject1 = this.Akg;
      Bundle localBundle = this.Ake;
      p.h(locala, "music");
      if ((localObject1 == null) && (localBundle == null))
      {
        Log.w("MicroMsg.MusicPlayerMultiTaskHelper", "fillMultiTaskData failed");
        localk.Abp = null;
        this.Akh.O(0, false);
        super.C(paramBallInfo);
        AppMethodBeat.o(219962);
        return;
      }
      if (localObject1 != null) {
        break label865;
      }
      localObject3 = new css();
      if (localBundle != null)
      {
        localObject1 = localBundle.getString("key_mv_cover_url", null);
        ((css)localObject3).Ktp = ((String)localObject1);
        if (localBundle == null) {
          break label770;
        }
        localObject1 = localBundle.getString("key_mv_poster", null);
        ((css)localObject3).Ktq = ((String)localObject1);
        if (localBundle == null) {
          break label776;
        }
        localObject1 = localBundle.getString("key_mv_nonce_id", null);
        ((css)localObject3).Kto = ((String)localObject1);
        if (localBundle == null) {
          break label782;
        }
        localObject1 = localBundle.getString("key_mv_feed_id", null);
        ((css)localObject3).Ktn = ((String)localObject1);
        if (localBundle == null) {
          break label788;
        }
        localObject1 = localBundle.getString("key_mv_song_name", null);
        label259:
        ((css)localObject3).BPc = ((String)localObject1);
        if (localBundle == null) {
          break label794;
        }
        localObject1 = localBundle.getString("key_mv_song_lyric", "");
        label284:
        ((css)localObject3).songLyric = ((String)localObject1);
        if (localBundle == null) {
          break label800;
        }
        localObject1 = localBundle.getString("key_mv_singer_name", null);
        label307:
        ((css)localObject3).singerName = ((String)localObject1);
        if (localBundle == null) {
          break label806;
        }
        localObject1 = localBundle.getString("key_mv_album_name", null);
        label330:
        ((css)localObject3).albumName = ((String)localObject1);
        if (localBundle == null) {
          break label812;
        }
        localObject1 = localBundle.getString("key_mv_music_genre", null);
        label353:
        ((css)localObject3).musicGenre = ((String)localObject1);
        if (localBundle != null) {
          l = localBundle.getLong("key_mv_issue_date", 0L);
        }
        ((css)localObject3).issueDate = l;
        if (localBundle == null) {
          break label818;
        }
        localObject1 = localBundle.getString("key_mv_album_cover_url", null);
        label397:
        ((css)localObject3).EsK = ((String)localObject1);
        if (localBundle == null) {
          break label824;
        }
        localObject1 = localBundle.getString("key_mv_identification", null);
        label420:
        ((css)localObject3).identification = ((String)localObject1);
        if (localBundle == null) {
          break label830;
        }
        localObject1 = localBundle.getString("key_mv_extra_info", null);
        label443:
        ((css)localObject3).extraInfo = ((String)localObject1);
        if (localBundle == null) {
          break label836;
        }
        i = localBundle.getInt("key_mv_music_duration", 0);
        label465:
        ((css)localObject3).Alz = i;
        localObject1 = localObject2;
        if (localBundle != null) {
          localObject1 = localBundle.getString("key_mv_thumb_path", null);
        }
        ((css)localObject3).jfz = ((String)localObject1);
        localObject1 = localObject3;
      }
    }
    label544:
    label806:
    label812:
    label818:
    label824:
    label830:
    label836:
    label846:
    label865:
    for (;;)
    {
      localObject3 = localk.Abp;
      if (localObject3 == null) {
        break;
      }
      localObject2 = locala.field_songSinger;
      p.g(localObject2, "music.field_songSinger");
      if (((CharSequence)localObject2).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label846;
        }
      }
      for (localObject2 = " · " + locala.field_songSinger;; localObject2 = "")
      {
        ((MultiTaskInfo)localObject3).erh().title = (locala.field_songName + (String)localObject2);
        ((MultiTaskInfo)localObject3).erh().nickname = ((css)localObject1).Ktq;
        localObject2 = new cso();
        ((cso)localObject2).jfy = ((css)localObject1);
        ((cso)localObject2).musicType = locala.field_musicType;
        ((cso)localObject2).Djf = locala.field_songAlbumUrl;
        ((cso)localObject2).name = locala.field_songName;
        ((cso)localObject2).lDR = locala.field_songSinger;
        ((cso)localObject2).lDS = locala.field_songWebUrl;
        ((cso)localObject2).Mxy = locala.field_songWapLinkUrl;
        ((cso)localObject2).Mxz = locala.field_songWifiUrl;
        ((cso)localObject2).dSF = locala.field_musicId;
        ((cso)localObject2).MxB = locala.field_songAlbumLocalPath;
        ((cso)localObject2).MxC = locala.field_songAlbum;
        ((cso)localObject2).appId = locala.field_appId;
        ((cso)localObject2).MxD = locala.field_songHAlbumUrl;
        ((MultiTaskInfo)localObject3).field_data = ((cso)localObject2).toByteArray();
        break;
        localObject1 = null;
        break label167;
        localObject1 = null;
        break label190;
        localObject1 = null;
        break label213;
        localObject1 = null;
        break label236;
        localObject1 = null;
        break label259;
        localObject1 = null;
        break label284;
        localObject1 = null;
        break label307;
        localObject1 = null;
        break label330;
        localObject1 = null;
        break label353;
        localObject1 = null;
        break label397;
        localObject1 = null;
        break label420;
        localObject1 = null;
        break label443;
        i = 0;
        break label465;
        i = 0;
        break label544;
      }
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "onFloatBallRemoved currentMusic is null");
      break label126;
    }
  }
  
  public final void aHN(String paramString)
  {
    AppMethodBeat.i(219965);
    Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicCoverPath %s", new Object[] { paramString });
    this.Akf = paramString;
    FloatBallMusicView localFloatBallMusicView = this.Akd;
    if (localFloatBallMusicView != null)
    {
      localFloatBallMusicView.setCoverPath(paramString);
      AppMethodBeat.o(219965);
      return;
    }
    AppMethodBeat.o(219965);
  }
  
  public final void as(Bundle paramBundle)
  {
    AppMethodBeat.i(219964);
    this.Ake = paramBundle;
    paramBundle = this.Ake;
    if (paramBundle != null) {}
    for (paramBundle = Integer.valueOf(paramBundle.hashCode());; paramBundle = null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicMvUIExtra hashCode: %s", new Object[] { paramBundle });
      AppMethodBeat.o(219964);
      return;
    }
  }
  
  public final void cir()
  {
    AppMethodBeat.i(219958);
    super.cir();
    FloatBallMusicView localFloatBallMusicView = this.Akd;
    if (localFloatBallMusicView != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)localFloatBallMusicView.AmF);
    }
    this.Akd = null;
    AppMethodBeat.o(219958);
  }
  
  public final void d(css paramcss)
  {
    AppMethodBeat.i(219963);
    this.Akg = paramcss;
    paramcss = this.Akg;
    if (paramcss != null) {}
    for (paramcss = Integer.valueOf(paramcss.hashCode());; paramcss = null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicShareObject hashCode: %s", new Object[] { paramcss });
      AppMethodBeat.o(219963);
      return;
    }
  }
  
  protected final int euo()
  {
    return 23;
  }
  
  protected final void eup()
  {
    AppMethodBeat.i(219960);
    BH(com.tencent.mm.plugin.ball.f.d.eW(this.oWE.state, 8));
    AppMethodBeat.o(219960);
  }
  
  public final Intent eut()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(219966);
    Intent localIntent = new Intent();
    if (this.Ake != null)
    {
      localObject2 = this.Ake;
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(((Bundle)localObject2).hashCode());
      }
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by extra %s", new Object[] { localObject1 });
      localObject1 = this.Ake;
      if (localObject1 == null) {
        p.hyc();
      }
      localIntent.putExtras((Bundle)localObject1);
      AppMethodBeat.o(219966);
      return localIntent;
    }
    css localcss = this.Akg;
    localObject1 = localObject2;
    if (localcss != null) {
      localObject1 = Integer.valueOf(localcss.hashCode());
    }
    Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by musicShareObject: %s", new Object[] { localObject1 });
    localIntent.putExtra("key_scene", 6);
    if (localcss != null)
    {
      localObject2 = localcss.Ktn;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_feed_id", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.Kto;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_nonce_id", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.Ktp;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_cover_url", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.Ktq;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_poster", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.BPc;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_song_name", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.songLyric;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_song_lyric", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.singerName;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_singer_name", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.albumName;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_album_name", (String)localObject1);
    if (localcss != null)
    {
      localObject2 = localcss.musicGenre;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_music_genre", (String)localObject1);
    long l;
    if (localcss != null)
    {
      l = localcss.issueDate;
      label494:
      localIntent.putExtra("key_mv_issue_date", l);
      if (localcss != null)
      {
        localObject2 = localcss.EsK;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localIntent.putExtra("key_mv_album_cover_url", (String)localObject1);
      if (localcss != null)
      {
        localObject2 = localcss.identification;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localIntent.putExtra("key_mv_identification", (String)localObject1);
      if (localcss != null)
      {
        localObject2 = localcss.extraInfo;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localIntent.putExtra("key_mv_extra_info", (String)localObject1);
      if (localcss == null) {
        break label690;
      }
    }
    label690:
    for (int i = localcss.Alz;; i = 0)
    {
      localIntent.putExtra("key_mv_music_duration", i);
      if (localcss != null)
      {
        localObject2 = localcss.jfz;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localIntent.putExtra("key_mv_thumb_path", (String)localObject1);
      localIntent.setFlags(268435456);
      break;
      l = 0L;
      break label494;
    }
  }
  
  protected final boolean y(f paramf)
  {
    return (paramf != null) && (paramf.jfx == true);
  }
  
  protected final void z(f paramf)
  {
    AppMethodBeat.i(219961);
    if (paramf != null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.jfx) });
      if (paramf.jfx)
      {
        paramf = MMApplicationContext.getContext();
        p.g(paramf, "MMApplicationContext.getContext()");
        this.Akd = new FloatBallMusicView(paramf);
        paramf = this.Akd;
        if (paramf != null) {
          paramf.setOnCloseListener((View.OnClickListener)new d.c(this));
        }
        paramf = this.Akd;
        if (paramf != null) {
          paramf.setOnMusicIconClickListener((View.OnClickListener)new d.d(this));
        }
        paramf = this.Akd;
        if (paramf != null) {
          paramf.setCoverPath(this.Akf);
        }
        this.oWE.vk = ((View)this.Akd);
        if (this.oWE.oWm == null) {
          this.oWE.oWm = new Point();
        }
        if (this.oWE.oWn == null) {
          this.oWE.oWn = new Point();
        }
        this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), 2131166409);
        this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), 2131166406);
        this.oWE.oWn.x = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.oWE.oWn.y = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.oWE.nno = false;
        this.oWE.oWr = true;
        this.oWE.oWq = true;
        this.oWE.gqx = false;
        this.oWE.state = com.tencent.mm.plugin.ball.f.d.eW(this.oWE.state, 2);
        this.oWE.state = com.tencent.mm.plugin.ball.f.d.eV(this.oWE.state, 8);
        Log.v("MicroMsg.GlobalMusicPlayerFloatBallHelper", "initMusicFloatBallViewSize %s, ballInfo.state: %d", new Object[] { this.oWE.oWm, Integer.valueOf(this.oWE.state) });
        cis();
      }
    }
    AppMethodBeat.o(219961);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;)V", "plugin-music_release"})
  static final class b
  {
    private static d Akj;
    public static final b Akk;
    
    static
    {
      AppMethodBeat.i(219955);
      Akk = new b();
      Akj = new d();
      AppMethodBeat.o(219955);
    }
    
    public static d euv()
    {
      return Akj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */