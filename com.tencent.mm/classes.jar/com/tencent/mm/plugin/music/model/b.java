package com.tencent.mm.plugin.music.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.findersdk.a.cr;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager;", "", "()V", "ENABLE_MUSIC_PLAY_LOOP", "", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "isMusicMvMode", "mCurrentMusicId", "mCurrentMusicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "mMusicActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "mPhoneCallListener", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;", "mPhoneStatusWatcher", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;", "mVoipEventListener", "Lcom/tencent/mm/autogen/events/VoipEvent;", "needStopMusicWhenRemoveMusicBall", "pausedMusicId", "pausedMusicWrapperExtend", "create", "", "destroy", "getCurrentMusicWrapperExtend", "handleMusicCompleteEvent", "event", "initPhoneStatusWatcher", "notifyMusicCoverChanged", "musicId", "coverPath", "onMusicBallRemoved", "removeListener", "removeMusicBall", "reset", "removeMusicFloatBall", "needStopMusic", "resetMusicId", "resetMusicMvInfo", "resumeMusicFloatBallIfNeed", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "setNeedStopMusicWhenRemovedMusicBall", "setTryListenMark", "setUpListener", "updateCurrentMusicCover", "coverUrl", "updateMusicInfo", "musicWrapper", "musicWrapperExtend", "updateMusicMvInfo", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "updateMusicMvUIExtra", "extra", "Landroid/os/Bundle;", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b LLR;
  private static boolean LLS;
  private static String LLT;
  private static com.tencent.mm.aw.h LLU;
  private static boolean LLV;
  private static String LLW;
  private static com.tencent.mm.aw.h LLX;
  private static final IListener<ox> LLY;
  private static PhoneStatusWatcher qSA;
  private static final PhoneStatusWatcher.PhoneCallListener qSC;
  private static final IListener<acn> qSD;
  private static final e roL;
  
  static
  {
    AppMethodBeat.i(271258);
    LLR = new b();
    LLT = "";
    LLV = true;
    LLW = "";
    qSC = b..ExternalSyntheticLambda0.INSTANCE;
    qSD = (IListener)new GlobalMusicFloatBallManager.mVoipEventListener.1(com.tencent.mm.app.f.hfK);
    roL = (e)new a();
    LLY = (IListener)new GlobalMusicFloatBallManager.mMusicActionListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(271258);
  }
  
  public static final void B(com.tencent.mm.aw.f paramf)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(271150);
    Object localObject;
    label22:
    int i;
    if (paramf == null)
    {
      localObject = null;
      boolean bool = LLS;
      if (paramf != null) {
        break label117;
      }
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resumeMusicFloatBallIfNeed isFromNewMusicPlayer: %s, isMusicMvMode: %s, showMusicFloatBall: %s", new Object[] { localObject, Boolean.valueOf(bool), localBoolean });
      if ((paramf == null) || (paramf.oOY != true)) {
        break label129;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((paramf.oPa) || (LLS))
        {
          paramf.oPa = true;
          localObject = d.LMb;
          localObject = d.b.LMj;
          d.b.gnV().B(paramf);
          AppMethodBeat.o(271150);
          return;
          localObject = Boolean.valueOf(paramf.oPa);
          break;
          label117:
          localBoolean = Boolean.valueOf(paramf.oOY);
          break label22;
          label129:
          i = 0;
          continue;
        }
        localObject = a.a.LLQ;
        if (localObject == null) {
          break label157;
        }
        ((a)localObject).B(paramf);
        AppMethodBeat.o(271150);
        return;
      }
    }
    hj(false);
    label157:
    AppMethodBeat.o(271150);
  }
  
  public static final void aK(Bundle paramBundle)
  {
    AppMethodBeat.i(271197);
    if (paramBundle != null) {
      LLS = true;
    }
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV().aK(paramBundle);
    AppMethodBeat.o(271197);
  }
  
  public static final void aOT(String paramString)
  {
    AppMethodBeat.i(271208);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateCurrentMusicCover %s", new Object[] { paramString });
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    d.a(d.b.gnV(), paramString);
    AppMethodBeat.o(271208);
  }
  
  private static final void ady(int paramInt)
  {
    AppMethodBeat.i(271228);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271228);
      return;
      AppMethodBeat.o(271228);
      return;
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "onPhoneCall, removeCurrentBall, state:%s", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.threadpool.h.ahAA.bk(b..ExternalSyntheticLambda1.INSTANCE);
    }
  }
  
  public static final void b(com.tencent.mm.aw.f paramf, com.tencent.mm.aw.h paramh)
  {
    boolean bool2 = true;
    Object localObject3 = null;
    AppMethodBeat.i(271174);
    Object localObject2;
    Object localObject1;
    label36:
    int i;
    label59:
    boolean bool1;
    label79:
    Boolean localBoolean1;
    label91:
    label98:
    label105:
    Boolean localBoolean2;
    if (paramf == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramh != null) {
          break label287;
        }
        localObject1 = "";
      }
      LLT = (String)localObject1;
      LLU = paramh;
      if ((paramf == null) || (paramf.oPa != true)) {
        break label309;
      }
      i = 1;
      if ((i == 0) && ((paramh == null) || (cr.b(paramh.oPb)))) {
        break label314;
      }
      bool1 = true;
      String str = LLT;
      if (paramf != null) {
        break label319;
      }
      localBoolean1 = null;
      if (paramh != null) {
        break label331;
      }
      localObject1 = null;
      if (paramh != null) {
        break label358;
      }
      localObject2 = null;
      if (paramf != null) {
        break label385;
      }
      localBoolean2 = null;
      label112:
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicInfo musicId: %s, isFromNewMusicPlayer: %s, isValid: %s, song: %s, %s, showMusicBall: %s", new Object[] { str, localBoolean1, Boolean.valueOf(bool1), localObject1, localObject2, localBoolean2 });
      if (!bool1) {
        break label470;
      }
      LLS = true;
      if (paramh != null) {
        break label397;
      }
      localObject1 = null;
      label172:
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label406;
      }
      i = 1;
      label196:
      if (i != 0) {
        break label420;
      }
      if (paramh != null) {
        break label411;
      }
      localObject1 = null;
      label207:
      localObject2 = d.LMb;
      localObject2 = d.b.LMj;
      localObject2 = d.b.gnV();
      if ((paramf == null) || (paramf.oOY != true)) {
        break label457;
      }
      bool1 = bool2;
      label237:
      ((d)localObject2).cx((String)localObject1, bool1);
      paramf = d.LMb;
      paramf = d.b.LMj;
      localObject1 = d.b.gnV();
      if (paramh != null) {
        break label462;
      }
    }
    label287:
    label309:
    label314:
    label319:
    label331:
    label462:
    for (paramf = localObject3;; paramf = paramh.oPb)
    {
      ((d)localObject1).d(paramf);
      AppMethodBeat.o(271174);
      return;
      localObject2 = paramf.oOv;
      break;
      localObject2 = paramh.musicId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label36;
      }
      localObject1 = "";
      break label36;
      i = 0;
      break label59;
      bool1 = false;
      break label79;
      localBoolean1 = Boolean.valueOf(paramf.oPa);
      break label91;
      localObject1 = paramh.oPb;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label98;
      }
      localObject1 = ((dtj)localObject1).songName;
      break label98;
      label358:
      localObject2 = paramh.oPb;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label105;
      }
      localObject2 = ((dtj)localObject2).singerName;
      break label105;
      localBoolean2 = Boolean.valueOf(paramf.oOY);
      break label112;
      localObject1 = paramh.oPc;
      break label172;
      i = 0;
      break label196;
      localObject1 = paramh.oPc;
      break label207;
      if (paramh == null)
      {
        localObject1 = null;
        break label207;
      }
      localObject1 = paramh.oPb;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label207;
      }
      localObject1 = ((dtj)localObject1).oPc;
      break label207;
      bool1 = false;
      break label237;
    }
    label385:
    label397:
    label406:
    label411:
    label420:
    label457:
    label470:
    LLS = false;
    paramf = d.LMb;
    paramf = d.b.LMj;
    d.a(d.b.gnV(), null);
    paramf = d.LMb;
    paramf = d.b.LMj;
    d.b.gnV().d(null);
    AppMethodBeat.o(271174);
  }
  
  public static final com.tencent.mm.aw.h bLx()
  {
    return LLU;
  }
  
  public static final void c(dtj paramdtj)
  {
    AppMethodBeat.i(271187);
    s.u(paramdtj, "musicShareObject");
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicMvInfo objectId: %s, nonceId: %s", new Object[] { paramdtj.YqN, paramdtj.YqO });
    if (LLS)
    {
      Object localObject1 = d.LMb;
      localObject1 = d.b.LMj;
      localObject1 = d.b.gnV();
      Object localObject2 = ((d)localObject1).LMg;
      if (localObject2 != null)
      {
        ((dtj)localObject2).YqN = paramdtj.YqN;
        ((dtj)localObject2).YqO = paramdtj.YqO;
        ((dtj)localObject2).YqP = paramdtj.YqP;
        ((dtj)localObject2).YqQ = paramdtj.YqQ;
      }
      Bundle localBundle = ((d)localObject1).LMe;
      if (localBundle != null)
      {
        localObject2 = paramdtj.YqN;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_feed_id", (String)localObject1);
        localObject2 = paramdtj.YqO;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_nonce_id", (String)localObject1);
        localObject2 = paramdtj.YqP;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_cover_url", (String)localObject1);
        localObject1 = paramdtj.YqQ;
        paramdtj = (dtj)localObject1;
        if (localObject1 == null) {
          paramdtj = "";
        }
        localBundle.putString("key_mv_poster", paramdtj);
      }
    }
    AppMethodBeat.o(271187);
  }
  
  public static final void create()
  {
    AppMethodBeat.i(271131);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(6, roL);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(23, roL);
    LLY.alive();
    qSD.alive();
    if (androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      Log.e("MicroMsg.GlobalMusicFloatBallManager", "initPhoneStatusWatcher not have read_phone_state perm");
    }
    for (;;)
    {
      Object localObject = a.a.LLQ;
      localObject = d.LMb;
      localObject = d.b.LMj;
      d.b.gnV();
      AppMethodBeat.o(271131);
      return;
      localObject = new PhoneStatusWatcher();
      qSA = (PhoneStatusWatcher)localObject;
      ((PhoneStatusWatcher)localObject).begin(MMApplicationContext.getContext());
      localObject = qSA;
      if (localObject != null) {
        ((PhoneStatusWatcher)localObject).addPhoneCallListener(qSC);
      }
    }
  }
  
  public static final void destroy()
  {
    AppMethodBeat.i(271138);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(6, roL);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(23, roL);
    LLY.dead();
    qSD.dead();
    Object localObject = qSA;
    if (localObject != null) {
      ((PhoneStatusWatcher)localObject).removePhoneCallListener(qSC);
    }
    localObject = qSA;
    if (localObject != null) {
      ((PhoneStatusWatcher)localObject).end();
    }
    localObject = a.a.LLQ;
    localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV();
    AppMethodBeat.o(271138);
  }
  
  public static final void gnD()
  {
    LLV = true;
  }
  
  public static final void gnE()
  {
    AppMethodBeat.i(271193);
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV().LMi = true;
    AppMethodBeat.o(271193);
  }
  
  private static void gnF()
  {
    AppMethodBeat.i(271214);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resetMusicMvInfo");
    LLS = false;
    LLU = null;
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV().d(null);
    localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV().aK(null);
    AppMethodBeat.o(271214);
  }
  
  private static final void gnH()
  {
    AppMethodBeat.i(271226);
    zJ(true);
    AppMethodBeat.o(271226);
  }
  
  public static final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(271155);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo removeMusicFloatBall needStopMusic: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    LLV = paramBoolean;
    zJ(paramBoolean);
    AppMethodBeat.o(271155);
  }
  
  public static final void kw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271202);
    if (!s.p(paramString1, LLT))
    {
      Log.w("MicroMsg.GlobalMusicFloatBallManager", "alvinluo notifyMusicCoverChanged musicId not the same and ignore musicId: %s, current: %s", new Object[] { paramString1, LLT });
      AppMethodBeat.o(271202);
      return;
    }
    paramString1 = d.LMb;
    paramString1 = d.b.LMj;
    d.a(d.b.gnV(), paramString2);
    AppMethodBeat.o(271202);
  }
  
  private static void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(271220);
    a.a.LLQ.cYp();
    Object localObject = d.LMb;
    localObject = d.b.LMj;
    d.b.gnV().cYp();
    if (paramBoolean) {
      gnF();
    }
    AppMethodBeat.o(271220);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoAdded", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.ball.c.f
  {
    private static final void gnO()
    {
      AppMethodBeat.i(271243);
      b localb = b.LLR;
      b.gnG();
      AppMethodBeat.o(271243);
    }
    
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(271250);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(271250);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.a.LLQ;
        if (localObject != null)
        {
          ((a)localObject).T(paramBallInfo);
          AppMethodBeat.o(271250);
        }
      }
      else if (paramBallInfo.type == 23)
      {
        localObject = d.LMb;
        localObject = d.b.LMj;
        d.b.gnV().T(paramBallInfo);
      }
      AppMethodBeat.o(271250);
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(271252);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(271252);
        return;
      }
      switch (paramBallInfo.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(271252);
        return;
        Object localObject = a.a.LLQ;
        if (localObject == null) {}
        for (paramBallInfo = null;; paramBallInfo = ((a)localObject).d(paramBallInfo, b.gnI()))
        {
          if (b.gnI())
          {
            localObject = b.LLR;
            b.aOU(paramBallInfo);
          }
          paramBallInfo = b.LLR;
          b.gnJ();
          AppMethodBeat.o(271252);
          return;
        }
        localObject = d.LMb;
        localObject = d.b.LMj;
        paramBallInfo = d.b.gnV().d(paramBallInfo, b.gnI());
        if (b.gnI())
        {
          localObject = b.LLR;
          b.aOU(paramBallInfo);
        }
        paramBallInfo = b.LLR;
        b.gnJ();
      }
    }
    
    public final void d(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(271254);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(271254);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.a.LLQ;
        if (localObject != null)
        {
          ((a)localObject).U(paramBallInfo);
          AppMethodBeat.o(271254);
        }
      }
      else if (paramBallInfo.type == 23)
      {
        localObject = d.LMb;
        localObject = d.b.LMj;
        d.b.gnV().U(paramBallInfo);
      }
      AppMethodBeat.o(271254);
    }
    
    public final void g(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(271261);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(271261);
        return;
      }
      Object localObject = d.LMb;
      localObject = d.b.LMj;
      if (s.p(paramBallInfo, d.b.gnV().vjV))
      {
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove normal music ball");
        localObject = a.a.LLQ;
        if (localObject != null) {
          ((a)localObject).cYp();
        }
      }
      while (paramBallInfo.type == 6)
      {
        localObject = a.a.LLQ;
        if (localObject == null) {
          break label227;
        }
        ((a)localObject).B(paramBallInfo);
        AppMethodBeat.o(271261);
        return;
        localObject = a.a.LLQ;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((FloatBallHelper)localObject).vjV)
        {
          if (!s.p(paramBallInfo, localObject)) {
            break label133;
          }
          Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove music player ball");
          localObject = d.LMb;
          localObject = d.b.LMj;
          d.b.gnV().cYp();
          break;
        }
        label133:
        if ((18 == paramBallInfo.type) || (17 == paramBallInfo.type) || (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)))
        {
          Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded pause music because of ball: %s", new Object[] { Integer.valueOf(paramBallInfo.type) });
          if ((com.tencent.mm.aw.a.bLn() != null) && (com.tencent.mm.aw.a.bLk())) {
            com.tencent.mm.aw.a.bLg();
          }
          MMHandlerThread.postToMainThread(b.a..ExternalSyntheticLambda0.INSTANCE);
        }
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.LMb;
        localObject = d.b.LMj;
        d.b.gnV().B(paramBallInfo);
      }
      label227:
      AppMethodBeat.o(271261);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b
 * JD-Core Version:    0.7.0.1
 */