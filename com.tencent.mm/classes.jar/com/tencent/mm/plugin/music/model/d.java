package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.aw.f;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.logic.e;
import com.tencent.mm.plugin.music.ui.FloatBallMusicView;
import com.tencent.mm.protocal.protobuf.dte;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallHelper;", "()V", "mCoverPath", "", "mCurrentMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mFloatBallMusicView", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "mMultiTaskHelper", "Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "mMvUIExtra", "Landroid/os/Bundle;", "markTryListen", "", "musicDataChangedListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "addMusicFloatBall", "", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "canHandleMusicPlayerEvent", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "wrapper", "getFloatBallType", "", "getMusicMvUIIntent", "Landroid/content/Intent;", "initMusicFloatBallView", "notifyMusicDataChanged", "onClickMusicBall", "onMusicBallRemoved", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "needStopMusic", "registerMusicDataChangedEventListener", "listener", "removeCurrentBall", "removeMusicBallState", "unMarkTryListen", "unRegisterMusicDataChangedEventListener", "updateMusicBallState", "updateMusicCoverPath", "coverPath", "notify", "updateMusicMvInfo", "musicShareObject", "updateMusicMvUIExtra", "extra", "updateMusicShareObject", "Companion", "Holder", "MusicPlayerDataChangedEventListener", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a LMb;
  public final CopyOnWriteArraySet<c> LMc;
  private FloatBallMusicView LMd;
  Bundle LMe;
  private String LMf;
  dtj LMg;
  private final k LMh;
  boolean LMi;
  
  static
  {
    AppMethodBeat.i(271168);
    LMb = new d.a((byte)0);
    AppMethodBeat.o(271168);
  }
  
  public d()
  {
    super("MicroMsg.GlobalMusicPlayerFloatBallHelper");
    AppMethodBeat.i(271121);
    this.LMc = new CopyOnWriteArraySet();
    this.LMh = new k();
    AppMethodBeat.o(271121);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(271145);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = new kn();
    paramView.ioV = 2L;
    paramView.iqr = 4L;
    cp.a(paramView);
    b.gnD();
    paramd.cYp();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271145);
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(271153);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = new dtk();
    localObject = com.tencent.mm.plugin.comm.a.xeG;
    paramView.zIO = com.tencent.mm.plugin.comm.a.dsT();
    paramView.scene = 4;
    localObject = paramd.gnT();
    ((Intent)localObject).putExtra("key_mv_report_data", paramView.toByteArray());
    ((Intent)localObject).putExtra("markTryListen", paramd.LMi);
    c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", (Intent)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271153);
  }
  
  private final void gnS()
  {
    AppMethodBeat.i(271129);
    Iterator localIterator = ((Iterable)this.LMc).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc != null) {
        localc.aL(this.LMe);
      }
    }
    AppMethodBeat.o(271129);
  }
  
  public static final d gnU()
  {
    AppMethodBeat.i(271161);
    Object localObject = b.LMj;
    localObject = b.gnV();
    AppMethodBeat.o(271161);
    return localObject;
  }
  
  protected final boolean C(f paramf)
  {
    if ((paramf != null) && (paramf.oPa == true)) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected final void D(f paramf)
  {
    AppMethodBeat.i(271215);
    if (paramf != null)
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.oPa) });
      if (paramf.oPa)
      {
        paramf = MMApplicationContext.getContext();
        s.s(paramf, "getContext()");
        this.LMd = new FloatBallMusicView(paramf);
        paramf = this.LMd;
        if (paramf != null) {
          paramf.setOnCloseListener(new d..ExternalSyntheticLambda1(this));
        }
        paramf = this.LMd;
        if (paramf != null) {
          paramf.setOnMusicIconClickListener(new d..ExternalSyntheticLambda0(this));
        }
        paramf = this.LMd;
        if (paramf != null) {
          paramf.setCoverPath(this.LMf);
        }
        this.vjV.dyK = ((View)this.LMd);
        if (this.vjV.vjC == null) {
          this.vjV.vjC = new Point();
        }
        if (this.vjV.vjD == null) {
          this.vjV.vjD = new Point();
        }
        this.vjV.vjC.x = bd.bs(MMApplicationContext.getContext(), a.c.float_ball_music_view_width);
        this.vjV.vjC.y = bd.bs(MMApplicationContext.getContext(), a.c.float_ball_music_view_height);
        this.vjV.vjD.x = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.vjV.vjD.y = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20);
        this.vjV.trn = false;
        this.vjV.vjH = true;
        this.vjV.vjG = true;
        this.vjV.lwK = false;
        this.vjV.state = com.tencent.mm.plugin.ball.f.d.gn(this.vjV.state, 2);
        this.vjV.state = com.tencent.mm.plugin.ball.f.d.gm(this.vjV.state, 8);
        Log.v("MicroMsg.GlobalMusicPlayerFloatBallHelper", "initMusicFloatBallViewSize %s, ballInfo.state: %d", new Object[] { this.vjV.vjC, Integer.valueOf(this.vjV.state) });
        cYq();
      }
    }
    AppMethodBeat.o(271215);
  }
  
  protected final void E(f paramf)
  {
    AppMethodBeat.i(271201);
    s.u(paramf, "wrapper");
    if (paramf.oPa)
    {
      this.vjV.state = com.tencent.mm.plugin.ball.f.d.gm(this.vjV.state, 8);
      FJ(this.vjV.state);
    }
    AppMethodBeat.o(271201);
  }
  
  public final void aK(Bundle paramBundle)
  {
    AppMethodBeat.i(271236);
    if (!s.p(this.LMe, paramBundle))
    {
      this.LMe = paramBundle;
      paramBundle = this.LMe;
      if (paramBundle != null) {
        break label60;
      }
    }
    label60:
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.hashCode()))
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicMvUIExtra hashCode: %s", new Object[] { paramBundle });
      gnS();
      AppMethodBeat.o(271236);
      return;
    }
  }
  
  public final void cYp()
  {
    AppMethodBeat.i(271196);
    super.cYp();
    FloatBallMusicView localFloatBallMusicView = this.LMd;
    if (localFloatBallMusicView != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.g)localFloatBallMusicView.LOM);
    }
    this.LMd = null;
    AppMethodBeat.o(271196);
  }
  
  public final void cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(271239);
    Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicCoverPath %s, notify: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    this.LMf = paramString;
    if (paramBoolean)
    {
      FloatBallMusicView localFloatBallMusicView = this.LMd;
      if (localFloatBallMusicView != null) {
        localFloatBallMusicView.setCoverPath(paramString);
      }
    }
    AppMethodBeat.o(271239);
  }
  
  public final String d(BallInfo paramBallInfo, boolean paramBoolean)
  {
    MultiTaskInfo localMultiTaskInfo = null;
    Object localObject1 = null;
    AppMethodBeat.i(271229);
    com.tencent.mm.plugin.music.model.e.a locala = ((e)com.tencent.mm.plugin.music.e.c.b.bU(e.class)).gnl();
    if (locala == null) {}
    k localk;
    Bundle localBundle;
    for (;;)
    {
      if (localObject1 == null) {
        Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "onFloatBallRemoved currentMusic is null");
      }
      paramBallInfo = super.d(paramBallInfo, paramBoolean);
      AppMethodBeat.o(271229);
      return paramBallInfo;
      this.LMh.J(6, com.tencent.mm.plugin.multitask.g.aI(locala.field_songName, locala.field_songSinger, locala.field_songAlbum));
      localk = this.LMh;
      localObject1 = this.LMg;
      localBundle = this.LMe;
      s.u(locala, "music");
      if ((localObject1 != null) || (localBundle != null)) {
        break;
      }
      Log.w("MicroMsg.MusicPlayerMultiTaskHelper", "fillMultiTaskData failed");
      localk.LCE = null;
      this.LMh.af(0, false);
      localObject1 = ah.aiuX;
    }
    Object localObject2;
    label179:
    label194:
    label209:
    label224:
    label239:
    label254:
    int i;
    if (localObject1 == null)
    {
      localObject2 = new dtj();
      if (localBundle == null)
      {
        localObject1 = null;
        ((dtj)localObject2).YqP = ((String)localObject1);
        if (localBundle != null) {
          break label659;
        }
        localObject1 = null;
        ((dtj)localObject2).YqQ = ((String)localObject1);
        if (localBundle != null) {
          break label673;
        }
        localObject1 = null;
        ((dtj)localObject2).YqO = ((String)localObject1);
        if (localBundle != null) {
          break label687;
        }
        localObject1 = null;
        ((dtj)localObject2).YqN = ((String)localObject1);
        if (localBundle != null) {
          break label701;
        }
        localObject1 = null;
        ((dtj)localObject2).songName = ((String)localObject1);
        if (localBundle != null) {
          break label715;
        }
        localObject1 = null;
        ((dtj)localObject2).songLyric = ((String)localObject1);
        if (localBundle != null) {
          break label731;
        }
        localObject1 = null;
        label269:
        ((dtj)localObject2).singerName = ((String)localObject1);
        if (localBundle != null) {
          break label745;
        }
        localObject1 = null;
        label284:
        ((dtj)localObject2).albumName = ((String)localObject1);
        if (localBundle != null) {
          break label759;
        }
        localObject1 = null;
        label299:
        ((dtj)localObject2).musicGenre = ((String)localObject1);
        if (localBundle != null) {
          break label773;
        }
        localObject1 = null;
        label314:
        ((dtj)localObject2).issueDate = Util.safeParseLong((String)localObject1);
        if (localBundle != null) {
          break label789;
        }
        localObject1 = null;
        label332:
        ((dtj)localObject2).RfH = ((String)localObject1);
        if (localBundle != null) {
          break label803;
        }
        localObject1 = null;
        label347:
        ((dtj)localObject2).identification = ((String)localObject1);
        if (localBundle != null) {
          break label817;
        }
        localObject1 = null;
        label362:
        ((dtj)localObject2).extraInfo = ((String)localObject1);
        if (localBundle != null) {
          break label831;
        }
        i = 0;
        label376:
        ((dtj)localObject2).LNC = i;
        if (localBundle != null) {
          break label844;
        }
        localObject1 = null;
        label390:
        ((dtj)localObject2).oPc = ((String)localObject1);
        if (localBundle != null) {
          break label858;
        }
        localObject1 = localMultiTaskInfo;
        label406:
        ((dtj)localObject2).musicOperationUrl = ((String)localObject1);
        localObject1 = localObject2;
      }
    }
    label456:
    label715:
    label844:
    label858:
    for (;;)
    {
      localMultiTaskInfo = localk.LCE;
      if (localMultiTaskInfo == null) {
        break;
      }
      localObject2 = (CharSequence)locala.field_songSinger;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label877;
        }
      }
      label731:
      label745:
      label877:
      for (localObject2 = "";; localObject2 = s.X(" · ", locala.field_songSinger))
      {
        localMultiTaskInfo.gkh().title = s.X(locala.field_songName, localObject2);
        localMultiTaskInfo.gkh().nickname = ((dtj)localObject1).YqQ;
        localObject2 = new dte();
        ((dte)localObject2).oPb = ((dtj)localObject1);
        ((dte)localObject2).musicType = locala.field_musicType;
        ((dte)localObject2).ZWS = locala.field_songAlbumUrl;
        ((dte)localObject2).name = locala.field_songName;
        ((dte)localObject2).rDl = locala.field_songSinger;
        ((dte)localObject2).rDm = locala.field_songWebUrl;
        ((dte)localObject2).aaYE = locala.field_songWapLinkUrl;
        ((dte)localObject2).aaYF = locala.field_songWifiUrl;
        ((dte)localObject2).musicId = locala.field_musicId;
        ((dte)localObject2).aaYH = locala.field_songAlbumLocalPath;
        ((dte)localObject2).aaYI = locala.field_songAlbum;
        ((dte)localObject2).appId = locala.field_appId;
        ((dte)localObject2).aaYJ = locala.field_songHAlbumUrl;
        localMultiTaskInfo.field_data = ((dte)localObject2).toByteArray();
        break;
        localObject1 = localBundle.getString("key_mv_cover_url", null);
        break label179;
        localObject1 = localBundle.getString("key_mv_poster", null);
        break label194;
        localObject1 = localBundle.getString("key_mv_nonce_id", null);
        break label209;
        localObject1 = localBundle.getString("key_mv_feed_id", null);
        break label224;
        localObject1 = localBundle.getString("key_mv_song_name", null);
        break label239;
        localObject1 = localBundle.getString("key_mv_song_lyric", "");
        break label254;
        localObject1 = localBundle.getString("key_mv_singer_name", null);
        break label269;
        localObject1 = localBundle.getString("key_mv_album_name", null);
        break label284;
        label759:
        localObject1 = localBundle.getString("key_mv_music_genre", null);
        break label299;
        localObject1 = localBundle.getString("key_mv_issue_date", "");
        break label314;
        localObject1 = localBundle.getString("key_mv_album_cover_url", null);
        break label332;
        localObject1 = localBundle.getString("key_mv_identification", null);
        break label347;
        localObject1 = localBundle.getString("key_mv_extra_info", null);
        break label362;
        i = localBundle.getInt("key_mv_music_duration", 0);
        break label376;
        localObject1 = localBundle.getString("key_mv_thumb_path", null);
        break label390;
        localObject1 = localBundle.getString("key_mv_music_operation_url", null);
        break label406;
        i = 0;
        break label456;
      }
    }
  }
  
  public final void d(dtj paramdtj)
  {
    AppMethodBeat.i(271232);
    this.LMg = paramdtj;
    paramdtj = this.LMg;
    if (paramdtj == null) {}
    for (paramdtj = null;; paramdtj = Integer.valueOf(paramdtj.hashCode()))
    {
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicShareObject hashCode: %s", new Object[] { paramdtj });
      AppMethodBeat.o(271232);
      return;
    }
  }
  
  protected final int gnB()
  {
    return 23;
  }
  
  protected final void gnC()
  {
    AppMethodBeat.i(271207);
    FJ(com.tencent.mm.plugin.ball.f.d.gn(this.vjV.state, 8));
    AppMethodBeat.o(271207);
  }
  
  public final Intent gnT()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(271246);
    Intent localIntent = new Intent();
    if (this.LMe != null)
    {
      localObject2 = this.LMe;
      if (localObject2 == null) {}
      for (;;)
      {
        Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by extra %s", new Object[] { localObject1 });
        localObject1 = this.LMe;
        s.checkNotNull(localObject1);
        localIntent.putExtras((Bundle)localObject1);
        AppMethodBeat.o(271246);
        return localIntent;
        localObject1 = Integer.valueOf(((Bundle)localObject2).hashCode());
      }
    }
    dtj localdtj = this.LMg;
    label100:
    label231:
    label250:
    int i;
    if (localdtj == null)
    {
      localObject1 = localObject2;
      Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by musicShareObject: %s", new Object[] { localObject1 });
      localIntent.putExtra("key_scene", 6);
      if (localdtj != null) {
        break label472;
      }
      localObject1 = "";
      label136:
      localIntent.putExtra("key_mv_feed_id", (String)localObject1);
      if (localdtj != null) {
        break label491;
      }
      localObject1 = "";
      label155:
      localIntent.putExtra("key_mv_nonce_id", (String)localObject1);
      if (localdtj != null) {
        break label510;
      }
      localObject1 = "";
      label174:
      localIntent.putExtra("key_mv_cover_url", (String)localObject1);
      if (localdtj != null) {
        break label529;
      }
      localObject1 = "";
      label193:
      localIntent.putExtra("key_mv_poster", (String)localObject1);
      if (localdtj != null) {
        break label548;
      }
      localObject1 = "";
      label212:
      localIntent.putExtra("key_mv_song_name", (String)localObject1);
      if (localdtj != null) {
        break label567;
      }
      localObject1 = "";
      localIntent.putExtra("key_mv_song_lyric", (String)localObject1);
      if (localdtj != null) {
        break label586;
      }
      localObject1 = "";
      localIntent.putExtra("key_mv_singer_name", (String)localObject1);
      if (localdtj != null) {
        break label605;
      }
      localObject1 = "";
      label269:
      localIntent.putExtra("key_mv_album_name", (String)localObject1);
      if (localdtj != null) {
        break label624;
      }
      localObject1 = "";
      label288:
      localIntent.putExtra("key_mv_music_genre", (String)localObject1);
      if (localdtj != null) {
        break label643;
      }
      localObject1 = "";
      label307:
      localIntent.putExtra("key_mv_issue_date", (String)localObject1);
      if (localdtj != null) {
        break label668;
      }
      localObject1 = "";
      label326:
      localIntent.putExtra("key_mv_album_cover_url", (String)localObject1);
      if (localdtj != null) {
        break label687;
      }
      localObject1 = "";
      label345:
      localIntent.putExtra("key_mv_identification", (String)localObject1);
      if (localdtj != null) {
        break label706;
      }
      localObject1 = "";
      label364:
      localIntent.putExtra("key_mv_extra_info", (String)localObject1);
      if (localdtj != null) {
        break label725;
      }
      i = 0;
      label381:
      localIntent.putExtra("key_mv_music_duration", i);
      if (localdtj != null) {
        break label734;
      }
      localObject1 = "";
      label400:
      localIntent.putExtra("key_mv_thumb_path", (String)localObject1);
      if (localdtj != null) {
        break label753;
      }
      localObject1 = "";
      label419:
      localIntent.putExtra("key_mv_music_operation_url", (String)localObject1);
      if (localdtj != null) {
        break label772;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localIntent.putExtra("key_mv_song_mid", (String)localObject1);
      localIntent.setFlags(268435456);
      break;
      localObject1 = Integer.valueOf(localdtj.hashCode());
      break label100;
      label472:
      localObject2 = localdtj.YqN;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label136;
      }
      localObject1 = "";
      break label136;
      label491:
      localObject2 = localdtj.YqO;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label155;
      }
      localObject1 = "";
      break label155;
      label510:
      localObject2 = localdtj.YqP;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label174;
      }
      localObject1 = "";
      break label174;
      label529:
      localObject2 = localdtj.YqQ;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label193;
      }
      localObject1 = "";
      break label193;
      label548:
      localObject2 = localdtj.songName;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label212;
      }
      localObject1 = "";
      break label212;
      label567:
      localObject2 = localdtj.songLyric;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label231;
      }
      localObject1 = "";
      break label231;
      label586:
      localObject2 = localdtj.singerName;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label250;
      }
      localObject1 = "";
      break label250;
      label605:
      localObject2 = localdtj.albumName;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label269;
      }
      localObject1 = "";
      break label269;
      label624:
      localObject2 = localdtj.musicGenre;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label288;
      }
      localObject1 = "";
      break label288;
      label643:
      localObject2 = Long.valueOf(localdtj.issueDate).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label307;
      }
      localObject1 = "";
      break label307;
      label668:
      localObject2 = localdtj.RfH;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label326;
      }
      localObject1 = "";
      break label326;
      label687:
      localObject2 = localdtj.identification;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label345;
      }
      localObject1 = "";
      break label345;
      label706:
      localObject2 = localdtj.extraInfo;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label364;
      }
      localObject1 = "";
      break label364;
      label725:
      i = localdtj.LNC;
      break label381;
      label734:
      localObject2 = localdtj.oPc;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label400;
      }
      localObject1 = "";
      break label400;
      label753:
      localObject2 = localdtj.musicOperationUrl;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label419;
      }
      localObject1 = "";
      break label419;
      label772:
      localObject2 = localdtj.oOZ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;)V", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b LMj;
    private static d LMk;
    
    static
    {
      AppMethodBeat.i(271265);
      LMj = new b();
      LMk = new d();
      AppMethodBeat.o(271265);
    }
    
    public static d gnV()
    {
      return LMk;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "", "onMusicDataChanged", "", "extra", "Landroid/os/Bundle;", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void aL(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */