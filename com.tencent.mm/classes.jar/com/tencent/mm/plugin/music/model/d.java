package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.ui.FloatBallMusicView;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallHelper;", "()V", "mCoverPath", "", "mCurrentMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mFloatBallMusicView", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "mMultiTaskHelper", "Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "mMvUIExtra", "Landroid/os/Bundle;", "musicDataChangedListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "addMusicFloatBall", "", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "canHandleMusicPlayerEvent", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "wrapper", "getFloatBallType", "", "getMusicMvUIIntent", "Landroid/content/Intent;", "initMusicFloatBallView", "notifyMusicDataChanged", "onClickMusicBall", "onFloatBallRemoved", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onMusicBallRemoved", "needStopMusic", "registerMusicDataChangedEventListener", "listener", "removeCurrentBall", "removeMusicBallState", "unRegisterMusicDataChangedEventListener", "updateMusicBallState", "updateMusicCoverPath", "coverPath", "notify", "updateMusicMvInfo", "musicShareObject", "updateMusicMvUIExtra", "extra", "updateMusicShareObject", "Companion", "Holder", "MusicPlayerDataChangedEventListener", "plugin-music_release"})
public final class d
  extends a
{
  public static final d.a FRm;
  public final CopyOnWriteArraySet<c> FRg;
  private FloatBallMusicView FRh;
  Bundle FRi;
  private String FRj;
  dbr FRk;
  private final k FRl;
  
  static
  {
    AppMethodBeat.i(260290);
    FRm = new d.a((byte)0);
    AppMethodBeat.o(260290);
  }
  
  public d()
  {
    super("MicroMsg.GlobalMusicPlayerFloatBallHelper");
    AppMethodBeat.i(260289);
    this.FRg = new CopyOnWriteArraySet();
    this.FRl = new k();
    AppMethodBeat.o(260289);
  }
  
  private final void feK()
  {
    AppMethodBeat.i(260285);
    Iterator localIterator = ((Iterable)this.FRg).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc != null) {
        localc.an(this.FRi);
      }
    }
    AppMethodBeat.o(260285);
  }
  
  public static final d feM()
  {
    AppMethodBeat.i(260292);
    Object localObject = b.FRo;
    localObject = b.feN();
    AppMethodBeat.o(260292);
    return localObject;
  }
  
  protected final void A(f paramf)
  {
    AppMethodBeat.i(260275);
    p.k(paramf, "wrapper");
    if (paramf.lVX)
    {
      this.rYE.state = com.tencent.mm.plugin.ball.f.d.fu(this.rYE.state, 8);
      Fi(this.rYE.state);
    }
    AppMethodBeat.o(260275);
  }
  
  public final void am(Bundle paramBundle)
  {
    AppMethodBeat.i(260284);
    if ((p.h(this.FRi, paramBundle) ^ true))
    {
      this.FRi = paramBundle;
      paramBundle = this.FRi;
      if (paramBundle == null) {
        break label66;
      }
    }
    label66:
    for (paramBundle = Integer.valueOf(paramBundle.hashCode());; paramBundle = null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicMvUIExtra hashCode: %s", new Object[] { paramBundle });
      feK();
      AppMethodBeat.o(260284);
      return;
    }
  }
  
  public final void cb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(260286);
    Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicCoverPath %s, notify: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    this.FRj = paramString;
    if (paramBoolean)
    {
      FloatBallMusicView localFloatBallMusicView = this.FRh;
      if (localFloatBallMusicView != null)
      {
        localFloatBallMusicView.setCoverPath(paramString);
        AppMethodBeat.o(260286);
        return;
      }
    }
    AppMethodBeat.o(260286);
  }
  
  public final void cvE()
  {
    AppMethodBeat.i(260274);
    super.cvE();
    FloatBallMusicView localFloatBallMusicView = this.FRh;
    if (localFloatBallMusicView != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)localFloatBallMusicView.FTM);
    }
    this.FRh = null;
    AppMethodBeat.o(260274);
  }
  
  public final String d(BallInfo paramBallInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(260282);
    Object localObject1 = com.tencent.mm.plugin.music.f.c.b.bm(e.class);
    p.j(localObject1, "MusicCoreService.service…PrivateLogic::class.java)");
    com.tencent.mm.plugin.music.model.e.a locala = ((e)localObject1).fei();
    k localk;
    label130:
    Object localObject3;
    label175:
    label198:
    label221:
    label244:
    int i;
    if (locala != null)
    {
      this.FRl.I(6, com.tencent.mm.plugin.multitask.g.au(locala.field_songName, locala.field_songSinger, locala.field_songAlbum));
      localk = this.FRl;
      localObject1 = this.FRk;
      Bundle localBundle = this.FRi;
      p.k(locala, "music");
      if ((localObject1 == null) && (localBundle == null))
      {
        Log.w("MicroMsg.MusicPlayerMultiTaskHelper", "fillMultiTaskData failed");
        localk.FHd = null;
        this.FRl.Q(0, false);
        paramBallInfo = super.d(paramBallInfo, paramBoolean);
        AppMethodBeat.o(260282);
        return paramBallInfo;
      }
      if (localObject1 != null) {
        break label883;
      }
      localObject3 = new dbr();
      if (localBundle != null)
      {
        localObject1 = localBundle.getString("key_mv_cover_url", null);
        ((dbr)localObject3).Ruw = ((String)localObject1);
        if (localBundle == null) {
          break label764;
        }
        localObject1 = localBundle.getString("key_mv_poster", null);
        ((dbr)localObject3).Rux = ((String)localObject1);
        if (localBundle == null) {
          break label770;
        }
        localObject1 = localBundle.getString("key_mv_nonce_id", null);
        ((dbr)localObject3).Ruv = ((String)localObject1);
        if (localBundle == null) {
          break label776;
        }
        localObject1 = localBundle.getString("key_mv_feed_id", null);
        ((dbr)localObject3).Ruu = ((String)localObject1);
        if (localBundle == null) {
          break label782;
        }
        localObject1 = localBundle.getString("key_mv_song_name", null);
        label267:
        ((dbr)localObject3).HLH = ((String)localObject1);
        if (localBundle == null) {
          break label788;
        }
        localObject1 = localBundle.getString("key_mv_song_lyric", "");
        label292:
        ((dbr)localObject3).songLyric = ((String)localObject1);
        if (localBundle == null) {
          break label794;
        }
        localObject1 = localBundle.getString("key_mv_singer_name", null);
        label315:
        ((dbr)localObject3).singerName = ((String)localObject1);
        if (localBundle == null) {
          break label800;
        }
        localObject1 = localBundle.getString("key_mv_album_name", null);
        label338:
        ((dbr)localObject3).albumName = ((String)localObject1);
        if (localBundle == null) {
          break label806;
        }
        localObject1 = localBundle.getString("key_mv_music_genre", null);
        label361:
        ((dbr)localObject3).musicGenre = ((String)localObject1);
        if (localBundle == null) {
          break label812;
        }
        localObject1 = localBundle.getString("key_mv_issue_date", "");
        label386:
        ((dbr)localObject3).issueDate = Util.safeParseLong((String)localObject1);
        if (localBundle == null) {
          break label818;
        }
        localObject1 = localBundle.getString("key_mv_album_cover_url", null);
        label412:
        ((dbr)localObject3).KGh = ((String)localObject1);
        if (localBundle == null) {
          break label824;
        }
        localObject1 = localBundle.getString("key_mv_identification", null);
        label435:
        ((dbr)localObject3).identification = ((String)localObject1);
        if (localBundle == null) {
          break label830;
        }
        localObject1 = localBundle.getString("key_mv_extra_info", null);
        label458:
        ((dbr)localObject3).extraInfo = ((String)localObject1);
        if (localBundle == null) {
          break label836;
        }
        i = localBundle.getInt("key_mv_music_duration", 0);
        label480:
        ((dbr)localObject3).FSG = i;
        localObject1 = localObject2;
        if (localBundle != null) {
          localObject1 = localBundle.getString("key_mv_thumb_path", null);
        }
        ((dbr)localObject3).lVZ = ((String)localObject1);
        localObject1 = localObject3;
      }
    }
    label556:
    label818:
    label824:
    label830:
    label836:
    label846:
    label883:
    for (;;)
    {
      localObject3 = localk.FHd;
      if (localObject3 == null) {
        break;
      }
      localObject2 = (CharSequence)locala.field_songSinger;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label846;
        }
      }
      for (localObject2 = "";; localObject2 = " · " + locala.field_songSinger)
      {
        ((MultiTaskInfo)localObject3).fbc().title = (locala.field_songName + (String)localObject2);
        ((MultiTaskInfo)localObject3).fbc().nickname = ((dbr)localObject1).Rux;
        localObject2 = new dbn();
        ((dbn)localObject2).lVY = ((dbr)localObject1);
        ((dbn)localObject2).musicType = locala.field_musicType;
        ((dbn)localObject2).SOM = locala.field_songAlbumUrl;
        ((dbn)localObject2).name = locala.field_songName;
        ((dbn)localObject2).ozs = locala.field_songSinger;
        ((dbn)localObject2).ozt = locala.field_songWebUrl;
        ((dbn)localObject2).TIO = locala.field_songWapLinkUrl;
        ((dbn)localObject2).TIQ = locala.field_songWifiUrl;
        ((dbn)localObject2).fMd = locala.field_musicId;
        ((dbn)localObject2).TIS = locala.field_songAlbumLocalPath;
        ((dbn)localObject2).TIT = locala.field_songAlbum;
        ((dbn)localObject2).appId = locala.field_appId;
        ((dbn)localObject2).TIU = locala.field_songHAlbumUrl;
        ((MultiTaskInfo)localObject3).field_data = ((dbn)localObject2).toByteArray();
        break;
        localObject1 = null;
        break label175;
        label764:
        localObject1 = null;
        break label198;
        localObject1 = null;
        break label221;
        localObject1 = null;
        break label244;
        localObject1 = null;
        break label267;
        localObject1 = null;
        break label292;
        localObject1 = null;
        break label315;
        localObject1 = null;
        break label338;
        localObject1 = null;
        break label361;
        localObject1 = null;
        break label386;
        localObject1 = null;
        break label412;
        localObject1 = null;
        break label435;
        localObject1 = null;
        break label458;
        i = 0;
        break label480;
        i = 0;
        break label556;
      }
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "onFloatBallRemoved currentMusic is null");
      break label130;
    }
  }
  
  public final void d(dbr paramdbr)
  {
    AppMethodBeat.i(260283);
    this.FRk = paramdbr;
    paramdbr = this.FRk;
    if (paramdbr != null) {}
    for (paramdbr = Integer.valueOf(paramdbr.hashCode());; paramdbr = null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicShareObject hashCode: %s", new Object[] { paramdbr });
      AppMethodBeat.o(260283);
      return;
    }
  }
  
  public final Intent feL()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(260288);
    Intent localIntent = new Intent();
    if (this.FRi != null)
    {
      localObject2 = this.FRi;
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(((Bundle)localObject2).hashCode());
      }
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by extra %s", new Object[] { localObject1 });
      localObject1 = this.FRi;
      if (localObject1 == null) {
        p.iCn();
      }
      localIntent.putExtras((Bundle)localObject1);
      AppMethodBeat.o(260288);
      return localIntent;
    }
    dbr localdbr = this.FRk;
    localObject1 = localObject2;
    if (localdbr != null) {
      localObject1 = Integer.valueOf(localdbr.hashCode());
    }
    Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by musicShareObject: %s", new Object[] { localObject1 });
    localIntent.putExtra("key_scene", 6);
    if (localdbr != null)
    {
      localObject2 = localdbr.Ruu;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_feed_id", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.Ruv;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_nonce_id", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.Ruw;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_cover_url", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.Rux;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_poster", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.HLH;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_song_name", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.songLyric;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_song_lyric", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.singerName;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_singer_name", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.albumName;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_album_name", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.musicGenre;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_music_genre", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = String.valueOf(localdbr.issueDate);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_issue_date", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.KGh;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_album_cover_url", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.identification;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_identification", (String)localObject1);
    if (localdbr != null)
    {
      localObject2 = localdbr.extraInfo;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localIntent.putExtra("key_mv_extra_info", (String)localObject1);
    if (localdbr != null) {}
    for (int i = localdbr.FSG;; i = 0)
    {
      localIntent.putExtra("key_mv_music_duration", i);
      if (localdbr != null)
      {
        localObject2 = localdbr.lVZ;
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
    }
  }
  
  protected final int fey()
  {
    return 23;
  }
  
  protected final void fez()
  {
    AppMethodBeat.i(260276);
    Fi(com.tencent.mm.plugin.ball.f.d.fv(this.rYE.state, 8));
    AppMethodBeat.o(260276);
  }
  
  protected final boolean y(f paramf)
  {
    return (paramf != null) && (paramf.lVX == true);
  }
  
  protected final void z(f paramf)
  {
    AppMethodBeat.i(260279);
    if (paramf != null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.lVX) });
      if (paramf.lVX)
      {
        paramf = MMApplicationContext.getContext();
        p.j(paramf, "MMApplicationContext.getContext()");
        this.FRh = new FloatBallMusicView(paramf);
        paramf = this.FRh;
        if (paramf != null) {
          paramf.setOnCloseListener((View.OnClickListener)new d.d(this));
        }
        paramf = this.FRh;
        if (paramf != null) {
          paramf.setOnMusicIconClickListener((View.OnClickListener)new d.e(this));
        }
        paramf = this.FRh;
        if (paramf != null) {
          paramf.setCoverPath(this.FRj);
        }
        this.rYE.bFK = ((View)this.FRh);
        if (this.rYE.rYm == null) {
          this.rYE.rYm = new Point();
        }
        if (this.rYE.rYn == null) {
          this.rYE.rYn = new Point();
        }
        this.rYE.rYm.x = aw.aZ(MMApplicationContext.getContext(), a.c.float_ball_music_view_width);
        this.rYE.rYm.y = aw.aZ(MMApplicationContext.getContext(), a.c.float_ball_music_view_height);
        this.rYE.rYn.x = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.rYE.rYn.y = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.rYE.qmt = false;
        this.rYE.rYr = true;
        this.rYE.rYq = true;
        this.rYE.iUF = false;
        this.rYE.state = com.tencent.mm.plugin.ball.f.d.fv(this.rYE.state, 2);
        this.rYE.state = com.tencent.mm.plugin.ball.f.d.fu(this.rYE.state, 8);
        Log.v("MicroMsg.GlobalMusicPlayerFloatBallHelper", "initMusicFloatBallViewSize %s, ballInfo.state: %d", new Object[] { this.rYE.rYm, Integer.valueOf(this.rYE.state) });
        cvF();
      }
    }
    AppMethodBeat.o(260279);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;)V", "plugin-music_release"})
  static final class b
  {
    private static d FRn;
    public static final b FRo;
    
    static
    {
      AppMethodBeat.i(260125);
      FRo = new b();
      FRn = new d();
      AppMethodBeat.o(260125);
    }
    
    public static d feN()
    {
      return FRn;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "", "onMusicDataChanged", "", "extra", "Landroid/os/Bundle;", "plugin-music_release"})
  public static abstract interface c
  {
    public abstract void an(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */