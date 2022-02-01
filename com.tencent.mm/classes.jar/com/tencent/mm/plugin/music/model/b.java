package com.tencent.mm.plugin.music.model;

import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager;", "", "()V", "ENABLE_MUSIC_PLAY_LOOP", "", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "isMusicMvMode", "mCurrentMusicId", "mCurrentMusicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "mMusicActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "mPhoneCallListener", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;", "mPhoneStatusWatcher", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;", "mVoipEventListener", "Lcom/tencent/mm/autogen/events/VoipEvent;", "needStopMusicWhenRemoveMusicBall", "pausedMusicId", "pausedMusicWrapperExtend", "create", "", "destroy", "getCurrentMusicWrapperExtend", "handleMusicCompleteEvent", "event", "notifyMusicCoverChanged", "musicId", "coverPath", "onMusicBallRemoved", "removeListener", "removeMusicBall", "reset", "removeMusicFloatBall", "needStopMusic", "resetMusicId", "resetMusicMvInfo", "resumeMusicFloatBallIfNeed", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "setNeedStopMusicWhenRemovedMusicBall", "setUpListener", "updateCurrentMusicCover", "coverUrl", "updateMusicInfo", "musicWrapper", "musicWrapperExtend", "updateMusicMvInfo", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "updateMusicMvUIExtra", "extra", "Landroid/os/Bundle;", "plugin-music_release"})
public final class b
{
  private static boolean FQT;
  private static String FQU;
  private static com.tencent.mm.bb.h FQV;
  private static boolean FQW;
  private static String FQX;
  private static com.tencent.mm.bb.h FQY;
  private static final IListener<np> FQZ;
  public static final b FRa;
  private static PhoneStatusWatcher nSO;
  private static final PhoneStatusWatcher.PhoneCallListener nSQ;
  private static final IListener<aaq> nSR;
  private static final e old;
  
  static
  {
    AppMethodBeat.i(259739);
    FRa = new b();
    FQU = "";
    FQW = true;
    FQX = "";
    nSQ = (PhoneStatusWatcher.PhoneCallListener)c.FRc;
    nSR = (IListener)new d();
    old = (e)new a();
    FQZ = (IListener)new b();
    AppMethodBeat.o(259739);
  }
  
  public static final void aSb(String paramString)
  {
    AppMethodBeat.i(259732);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateCurrentMusicCover %s", new Object[] { paramString });
    Object localObject = d.FRm;
    localObject = d.b.FRo;
    d.a(d.b.feN(), paramString);
    AppMethodBeat.o(259732);
  }
  
  public static final void am(Bundle paramBundle)
  {
    AppMethodBeat.i(259728);
    if (paramBundle != null) {
      FQT = true;
    }
    Object localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN().am(paramBundle);
    AppMethodBeat.o(259728);
  }
  
  public static final void b(com.tencent.mm.bb.f paramf, com.tencent.mm.bb.h paramh)
  {
    boolean bool2 = true;
    Object localObject4 = null;
    AppMethodBeat.i(259726);
    Object localObject2;
    Object localObject1;
    if (paramf != null)
    {
      localObject2 = paramf.lVt;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else if (paramh != null)
    {
      localObject2 = paramh.fMd;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    FQU = (String)localObject1;
    FQV = paramh;
    label108:
    Object localObject3;
    label130:
    label152:
    Boolean localBoolean;
    label165:
    label227:
    int i;
    if (((paramf != null) && (paramf.lVX == true)) || ((paramh != null) && (!an.b(paramh.lVY))))
    {
      bool1 = true;
      String str = FQU;
      if (paramf == null) {
        break label345;
      }
      localObject1 = Boolean.valueOf(paramf.lVX);
      if (paramh == null) {
        break label351;
      }
      localObject2 = paramh.lVY;
      if (localObject2 == null) {
        break label351;
      }
      localObject2 = ((dbr)localObject2).HLH;
      if (paramh == null) {
        break label357;
      }
      localObject3 = paramh.lVY;
      if (localObject3 == null) {
        break label357;
      }
      localObject3 = ((dbr)localObject3).singerName;
      if (paramf == null) {
        break label363;
      }
      localBoolean = Boolean.valueOf(paramf.lVW);
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicInfo musicId: %s, isFromNewMusicPlayer: %s, isValid: %s, song: %s, %s, showMusicBall: %s", new Object[] { str, localObject1, Boolean.valueOf(bool1), localObject2, localObject3, localBoolean });
      if (!bool1) {
        break label422;
      }
      FQT = true;
      if (paramh == null) {
        break label369;
      }
      localObject1 = paramh.lVZ;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label375;
      }
      i = 1;
      label251:
      if (i != 0) {
        break label386;
      }
      if (paramh == null) {
        break label380;
      }
      localObject1 = paramh.lVZ;
      label265:
      localObject2 = d.FRm;
      localObject2 = d.b.FRo;
      localObject2 = d.b.feN();
      if ((paramf == null) || (paramf.lVW != true)) {
        break label417;
      }
    }
    label386:
    label417:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((d)localObject2).cb((String)localObject1, bool1);
      paramf = d.FRm;
      paramf = d.b.FRo;
      localObject1 = d.b.feN();
      paramf = localObject4;
      if (paramh != null) {
        paramf = paramh.lVY;
      }
      ((d)localObject1).d(paramf);
      AppMethodBeat.o(259726);
      return;
      bool1 = false;
      break;
      label345:
      localObject1 = null;
      break label108;
      label351:
      localObject2 = null;
      break label130;
      label357:
      localObject3 = null;
      break label152;
      label363:
      localBoolean = null;
      break label165;
      label369:
      localObject1 = null;
      break label227;
      label375:
      i = 0;
      break label251;
      label380:
      localObject1 = null;
      break label265;
      if (paramh != null)
      {
        localObject1 = paramh.lVY;
        if (localObject1 != null)
        {
          localObject1 = ((dbr)localObject1).lVZ;
          break label265;
        }
      }
      localObject1 = null;
      break label265;
    }
    label422:
    FQT = false;
    paramf = d.FRm;
    paramf = d.b.FRo;
    d.a(d.b.feN(), null);
    paramf = d.FRm;
    paramf = d.b.FRo;
    d.b.feN().d(null);
    AppMethodBeat.o(259726);
  }
  
  public static final void bnJ()
  {
    AppMethodBeat.i(259725);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo removeMusicFloatBall needStopMusic: %s", new Object[] { Boolean.FALSE });
    FQW = false;
    vr(false);
    AppMethodBeat.o(259725);
  }
  
  public static final com.tencent.mm.bb.h bnK()
  {
    return FQV;
  }
  
  public static final void c(dbr paramdbr)
  {
    AppMethodBeat.i(259727);
    p.k(paramdbr, "musicShareObject");
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicMvInfo objectId: %s, nonceId: %s", new Object[] { paramdbr.Ruu, paramdbr.Ruv });
    if (FQT)
    {
      Object localObject1 = d.FRm;
      localObject1 = d.b.FRo;
      localObject1 = d.b.feN();
      Object localObject2 = ((d)localObject1).FRk;
      if (localObject2 != null)
      {
        ((dbr)localObject2).Ruu = paramdbr.Ruu;
        ((dbr)localObject2).Ruv = paramdbr.Ruv;
        ((dbr)localObject2).Ruw = paramdbr.Ruw;
        ((dbr)localObject2).Rux = paramdbr.Rux;
      }
      Bundle localBundle = ((d)localObject1).FRi;
      if (localBundle != null)
      {
        localObject2 = paramdbr.Ruu;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_feed_id", (String)localObject1);
        localObject2 = paramdbr.Ruv;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_nonce_id", (String)localObject1);
        localObject2 = paramdbr.Ruw;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_cover_url", (String)localObject1);
        localObject1 = paramdbr.Rux;
        paramdbr = (dbr)localObject1;
        if (localObject1 == null) {
          paramdbr = "";
        }
        localBundle.putString("key_mv_poster", paramdbr);
        AppMethodBeat.o(259727);
        return;
      }
    }
    AppMethodBeat.o(259727);
  }
  
  public static final void create()
  {
    AppMethodBeat.i(259721);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(6, old);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(23, old);
    FQZ.alive();
    Object localObject = new PhoneStatusWatcher();
    nSO = (PhoneStatusWatcher)localObject;
    ((PhoneStatusWatcher)localObject).begin(MMApplicationContext.getContext());
    localObject = nSO;
    if (localObject == null) {
      p.iCn();
    }
    ((PhoneStatusWatcher)localObject).addPhoneCallListener(nSQ);
    nSR.alive();
    a.fex();
    localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN();
    AppMethodBeat.o(259721);
  }
  
  public static final void destroy()
  {
    AppMethodBeat.i(259723);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(6, old);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(23, old);
    FQZ.dead();
    Object localObject = nSO;
    if (localObject == null) {
      p.iCn();
    }
    ((PhoneStatusWatcher)localObject).removePhoneCallListener(nSQ);
    localObject = nSO;
    if (localObject == null) {
      p.iCn();
    }
    ((PhoneStatusWatcher)localObject).end();
    nSR.dead();
    a.fex();
    localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN();
    AppMethodBeat.o(259723);
  }
  
  public static final void feA()
  {
    FQW = true;
  }
  
  private static void feB()
  {
    AppMethodBeat.i(259735);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resetMusicMvInfo");
    FQT = false;
    FQV = null;
    Object localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN().d(null);
    localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN().am(null);
    AppMethodBeat.o(259735);
  }
  
  public static final void jh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(259730);
    if ((p.h(paramString1, FQU) ^ true))
    {
      Log.w("MicroMsg.GlobalMusicFloatBallManager", "alvinluo notifyMusicCoverChanged musicId not the same and ignore musicId: %s, current: %s", new Object[] { paramString1, FQU });
      AppMethodBeat.o(259730);
      return;
    }
    paramString1 = d.FRm;
    paramString1 = d.b.FRo;
    d.a(d.b.feN(), paramString2);
    AppMethodBeat.o(259730);
  }
  
  private static void vr(boolean paramBoolean)
  {
    AppMethodBeat.i(259736);
    a.fex().cvE();
    Object localObject = d.FRm;
    localObject = d.b.FRo;
    d.b.feN().cvE();
    if (paramBoolean) {
      feB();
    }
    AppMethodBeat.o(259736);
  }
  
  public static final void x(com.tencent.mm.bb.f paramf)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(259724);
    if (paramf != null) {}
    for (Object localObject = Boolean.valueOf(paramf.lVX);; localObject = null)
    {
      boolean bool = FQT;
      if (paramf != null) {
        localBoolean = Boolean.valueOf(paramf.lVW);
      }
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resumeMusicFloatBallIfNeed isFromNewMusicPlayer: %s, isMusicMvMode: %s, showMusicFloatBall: %s", new Object[] { localObject, Boolean.valueOf(bool), localBoolean });
      if ((paramf == null) || (paramf.lVW != true)) {
        break label147;
      }
      if ((!paramf.lVX) && (!FQT)) {
        break;
      }
      paramf.lVX = true;
      localObject = d.FRm;
      localObject = d.b.FRo;
      d.b.feN().x(paramf);
      AppMethodBeat.o(259724);
      return;
    }
    localObject = a.fex();
    if (localObject != null)
    {
      ((a)localObject).x(paramf);
      AppMethodBeat.o(259724);
      return;
    }
    AppMethodBeat.o(259724);
    return;
    label147:
    bnJ();
    AppMethodBeat.o(259724);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoAdded", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-music_release"})
  public static final class a
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(260428);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(260428);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.fex();
        if (localObject != null)
        {
          ((a)localObject).R(paramBallInfo);
          AppMethodBeat.o(260428);
          return;
        }
        AppMethodBeat.o(260428);
        return;
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.FRm;
        localObject = d.b.FRo;
        d.b.feN().R(paramBallInfo);
      }
      AppMethodBeat.o(260428);
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(260429);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(260429);
        return;
      }
      switch (paramBallInfo.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(260429);
        return;
        Object localObject = a.fex();
        if (localObject != null) {
          localb = b.FRa;
        }
        for (paramBallInfo = ((a)localObject).d(paramBallInfo, b.feD());; paramBallInfo = null)
        {
          localObject = b.FRa;
          if (b.feD())
          {
            localObject = b.FRa;
            b.aSc(paramBallInfo);
          }
          paramBallInfo = b.FRa;
          b.feE();
          AppMethodBeat.o(260429);
          return;
        }
        localObject = d.FRm;
        localObject = d.b.FRo;
        localObject = d.b.feN();
        b localb = b.FRa;
        paramBallInfo = ((d)localObject).d(paramBallInfo, b.feD());
        localObject = b.FRa;
        if (b.feD())
        {
          localObject = b.FRa;
          b.aSc(paramBallInfo);
        }
        paramBallInfo = b.FRa;
        b.feE();
      }
    }
    
    public final void d(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(260430);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(260430);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.fex();
        if (localObject != null)
        {
          ((a)localObject).S(paramBallInfo);
          AppMethodBeat.o(260430);
          return;
        }
        AppMethodBeat.o(260430);
        return;
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.FRm;
        localObject = d.b.FRo;
        d.b.feN().S(paramBallInfo);
      }
      AppMethodBeat.o(260430);
    }
    
    public final void g(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(260437);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(260437);
        return;
      }
      Object localObject = d.FRm;
      localObject = d.b.FRo;
      if (p.h(paramBallInfo, d.b.feN().cvM()))
      {
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove normal music ball");
        localObject = a.fex();
        if (localObject != null) {
          ((a)localObject).cvE();
        }
      }
      while (paramBallInfo.type == 6)
      {
        localObject = a.fex();
        if (localObject != null)
        {
          ((a)localObject).B(paramBallInfo);
          AppMethodBeat.o(260437);
          return;
          localObject = a.fex();
          if (localObject != null) {}
          for (localObject = ((a)localObject).cvM();; localObject = null)
          {
            if (!p.h(paramBallInfo, localObject)) {
              break label133;
            }
            Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove music player ball");
            localObject = d.FRm;
            localObject = d.b.FRo;
            d.b.feN().cvE();
            break;
          }
          label133:
          if ((18 == paramBallInfo.type) || (17 == paramBallInfo.type) || (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)))
          {
            Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded pause music because of ball: %s", new Object[] { Integer.valueOf(paramBallInfo.type) });
            if ((com.tencent.mm.bb.a.bnA() != null) && (com.tencent.mm.bb.a.bnx())) {
              com.tencent.mm.bb.a.bnt();
            }
            MMHandlerThread.postToMainThread((Runnable)a.FRb);
          }
        }
        else
        {
          AppMethodBeat.o(260437);
          return;
        }
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.FRm;
        localObject = d.b.FRo;
        d.b.feN().B(paramBallInfo);
      }
      AppMethodBeat.o(260437);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a FRb;
      
      static
      {
        AppMethodBeat.i(260160);
        FRb = new a();
        AppMethodBeat.o(260160);
      }
      
      public final void run()
      {
        AppMethodBeat.i(260159);
        b localb = b.FRa;
        b.feC();
        AppMethodBeat.o(260159);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mMusicActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-music_release"})
  public static final class b
    extends IListener<np>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "", "onPhoneCall"})
  static final class c
    implements PhoneStatusWatcher.PhoneCallListener
  {
    public static final c FRc;
    
    static
    {
      AppMethodBeat.i(260545);
      FRc = new c();
      AppMethodBeat.o(260545);
    }
    
    public final void onPhoneCall(int paramInt)
    {
      AppMethodBeat.i(260543);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(260543);
        return;
        AppMethodBeat.o(260543);
        return;
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "onPhoneCall, removeCurrentBall, state:%s", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.e.h.ZvG.bc((Runnable)1.FRd);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mVoipEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-music_release"})
  public static final class d
    extends IListener<aaq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b
 * JD-Core Version:    0.7.0.1
 */