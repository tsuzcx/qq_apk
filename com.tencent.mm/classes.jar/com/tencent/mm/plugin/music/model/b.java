package com.tencent.mm.plugin.music.model;

import android.os.Bundle;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager;", "", "()V", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "isMusicMvMode", "", "mCurrentMusicId", "mMusicActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "mPhoneCallListener", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;", "mPhoneStatusWatcher", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;", "mVoipEventListener", "Lcom/tencent/mm/autogen/events/VoipEvent;", "create", "", "destroy", "notifyMusicCoverChanged", "musicId", "coverPath", "onMusicBallRemoved", "removeListener", "removeMusicBall", "resetMusicMvInfo", "resumeMusicFloatBallIfNeed", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "setUpListener", "updateCurrentMusicCover", "coverUrl", "updateMusicInfo", "musicWrapper", "musicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "updateMusicMvInfo", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "updateMusicMvUIExtra", "extra", "Landroid/os/Bundle;", "plugin-music_release"})
public final class b
{
  private static boolean AjV;
  private static String AjW;
  private static final IListener<mx> AjX;
  public static final b AjY;
  private static PhoneStatusWatcher kYD;
  private static final PhoneStatusWatcher.PhoneCallListener kYE;
  private static final IListener<zj> kYG;
  private static final e lqt;
  
  static
  {
    AppMethodBeat.i(219952);
    AjY = new b();
    AjW = "";
    kYE = (PhoneStatusWatcher.PhoneCallListener)c.Aka;
    kYG = (IListener)new d();
    lqt = (e)new a();
    AjX = (IListener)new b();
    AppMethodBeat.o(219952);
  }
  
  public static final void aHM(String paramString)
  {
    AppMethodBeat.i(219950);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateCurrentMusicCover %s", new Object[] { paramString });
    Object localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv().aHN(paramString);
    AppMethodBeat.o(219950);
  }
  
  public static final void as(Bundle paramBundle)
  {
    AppMethodBeat.i(219948);
    if (paramBundle != null) {
      AjV = true;
    }
    Object localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv().as(paramBundle);
    AppMethodBeat.o(219948);
  }
  
  public static final void b(com.tencent.mm.ay.f paramf, com.tencent.mm.ay.h paramh)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(219946);
    Object localObject1;
    if (paramh != null)
    {
      String str = paramh.dSF;
      localObject1 = str;
      if (str != null) {}
    }
    else
    {
      localObject1 = "";
    }
    AjW = (String)localObject1;
    boolean bool;
    if (((paramf != null) && (paramf.jfx == true)) || ((paramh != null) && (!al.b(paramh.jfy))))
    {
      bool = true;
      localObject1 = AjW;
      if (paramf == null) {
        break label219;
      }
      paramf = Boolean.valueOf(paramf.jfx);
      label83:
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicInfo musicId: %s, isFromNewMusicPlayer: %s, isValid: %s", new Object[] { localObject1, paramf, Boolean.valueOf(bool) });
      if (!bool) {
        break label260;
      }
      AjV = true;
      if (paramh == null) {
        break label224;
      }
      paramf = paramh.jfz;
      label127:
      paramf = (CharSequence)paramf;
      if ((paramf == null) || (paramf.length() == 0)) {
        i = 1;
      }
      if (i != 0) {
        break label234;
      }
      if (paramh == null) {
        break label229;
      }
      paramf = paramh.jfz;
    }
    for (;;)
    {
      localObject1 = d.Aki;
      localObject1 = d.b.Akk;
      d.b.euv().aHN(paramf);
      paramf = d.Aki;
      paramf = d.b.Akk;
      localObject1 = d.b.euv();
      paramf = localObject2;
      if (paramh != null) {
        paramf = paramh.jfy;
      }
      ((d)localObject1).d(paramf);
      AppMethodBeat.o(219946);
      return;
      bool = false;
      break;
      label219:
      paramf = null;
      break label83;
      label224:
      paramf = null;
      break label127;
      label229:
      paramf = null;
      continue;
      label234:
      if (paramh != null)
      {
        paramf = paramh.jfy;
        if (paramf != null)
        {
          paramf = paramf.jfz;
          continue;
        }
      }
      paramf = null;
    }
    label260:
    AjV = false;
    paramf = d.Aki;
    paramf = d.b.Akk;
    d.b.euv().aHN(null);
    paramf = d.Aki;
    paramf = d.b.Akk;
    d.b.euv().d(null);
    AppMethodBeat.o(219946);
  }
  
  public static final void c(css paramcss)
  {
    AppMethodBeat.i(219947);
    p.h(paramcss, "musicShareObject");
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicMvInfo objectId: %s, nonceId: %s", new Object[] { paramcss.Ktn, paramcss.Kto });
    if (AjV)
    {
      Object localObject1 = d.Aki;
      localObject1 = d.b.Akk;
      localObject1 = d.b.euv();
      Object localObject2 = ((d)localObject1).Akg;
      if (localObject2 != null)
      {
        ((css)localObject2).Ktn = paramcss.Ktn;
        ((css)localObject2).Kto = paramcss.Kto;
        ((css)localObject2).Ktp = paramcss.Ktp;
        ((css)localObject2).Ktq = paramcss.Ktq;
      }
      Bundle localBundle = ((d)localObject1).Ake;
      if (localBundle != null)
      {
        localObject2 = paramcss.Ktn;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_feed_id", (String)localObject1);
        localObject2 = paramcss.Kto;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_nonce_id", (String)localObject1);
        localObject2 = paramcss.Ktp;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localBundle.putString("key_mv_cover_url", (String)localObject1);
        localObject1 = paramcss.Ktq;
        paramcss = (css)localObject1;
        if (localObject1 == null) {
          paramcss = "";
        }
        localBundle.putString("key_mv_poster", paramcss);
        AppMethodBeat.o(219947);
        return;
      }
    }
    AppMethodBeat.o(219947);
  }
  
  public static final void create()
  {
    AppMethodBeat.i(219943);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(6, lqt);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(23, lqt);
    AjX.alive();
    Object localObject = new PhoneStatusWatcher();
    kYD = (PhoneStatusWatcher)localObject;
    ((PhoneStatusWatcher)localObject).begin(MMApplicationContext.getContext());
    localObject = kYD;
    if (localObject == null) {
      p.hyc();
    }
    ((PhoneStatusWatcher)localObject).addPhoneCallListener(kYE);
    kYG.alive();
    a.eun();
    localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv();
    AppMethodBeat.o(219943);
  }
  
  public static final void destroy()
  {
    AppMethodBeat.i(219944);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).b(6, lqt);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).b(23, lqt);
    AjX.dead();
    Object localObject = kYD;
    if (localObject == null) {
      p.hyc();
    }
    ((PhoneStatusWatcher)localObject).removePhoneCallListener(kYE);
    localObject = kYD;
    if (localObject == null) {
      p.hyc();
    }
    ((PhoneStatusWatcher)localObject).end();
    kYG.dead();
    a.eun();
    localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv();
    AppMethodBeat.o(219944);
  }
  
  private static void euq()
  {
    AppMethodBeat.i(219951);
    Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resetMusicMvInfo");
    AjV = false;
    Object localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv().d(null);
    localObject = d.Aki;
    localObject = d.b.Akk;
    d.b.euv().as(null);
    AppMethodBeat.o(219951);
  }
  
  public static final void iX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219949);
    if ((p.j(paramString1, AjW) ^ true))
    {
      Log.w("MicroMsg.GlobalMusicFloatBallManager", "alvinluo notifyMusicCoverChanged musicId not the same and ignore musicId: %s, current: %s", new Object[] { paramString1, AjW });
      AppMethodBeat.o(219949);
      return;
    }
    paramString1 = d.Aki;
    paramString1 = d.b.Akk;
    d.b.euv().aHN(paramString2);
    AppMethodBeat.o(219949);
  }
  
  public static final void x(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(219945);
    if (paramf != null) {}
    for (Object localObject = Boolean.valueOf(paramf.jfx);; localObject = null)
    {
      Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resumeMusicFloatBallIfNeed isFromNewMusicPlayer: %s, isMusicMvMode: %s", new Object[] { localObject, Boolean.valueOf(AjV) });
      if (((paramf == null) || (paramf.jfx != true)) && (!AjV)) {
        break;
      }
      if (paramf != null) {
        paramf.jfx = true;
      }
      localObject = d.Aki;
      localObject = d.b.Akk;
      d.b.euv().x(paramf);
      AppMethodBeat.o(219945);
      return;
    }
    localObject = a.eun();
    if (localObject != null)
    {
      ((a)localObject).x(paramf);
      AppMethodBeat.o(219945);
      return;
    }
    AppMethodBeat.o(219945);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoAdded", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-music_release"})
  public static final class a
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(219935);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(219935);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.eun();
        if (localObject != null)
        {
          ((a)localObject).Q(paramBallInfo);
          AppMethodBeat.o(219935);
          return;
        }
        AppMethodBeat.o(219935);
        return;
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.Aki;
        localObject = d.b.Akk;
        d.b.euv().Q(paramBallInfo);
      }
      AppMethodBeat.o(219935);
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(219936);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(219936);
        return;
      }
      switch (paramBallInfo.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(219936);
        return;
        Object localObject = a.eun();
        if (localObject != null) {
          ((a)localObject).C(paramBallInfo);
        }
        paramBallInfo = b.AjY;
        b.eus();
        AppMethodBeat.o(219936);
        return;
        localObject = d.Aki;
        localObject = d.b.Akk;
        d.b.euv().C(paramBallInfo);
        paramBallInfo = b.AjY;
        b.eus();
      }
    }
    
    public final void d(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(219937);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(219937);
        return;
      }
      Object localObject;
      if (paramBallInfo.type == 6)
      {
        localObject = a.eun();
        if (localObject != null)
        {
          ((a)localObject).R(paramBallInfo);
          AppMethodBeat.o(219937);
          return;
        }
        AppMethodBeat.o(219937);
        return;
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.Aki;
        localObject = d.b.Akk;
        d.b.euv().R(paramBallInfo);
      }
      AppMethodBeat.o(219937);
    }
    
    public final void g(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(219938);
      if (paramBallInfo == null)
      {
        AppMethodBeat.o(219938);
        return;
      }
      Object localObject = d.Aki;
      localObject = d.b.Akk;
      if (p.j(paramBallInfo, d.b.euv().cix()))
      {
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove normal music ball");
        localObject = a.eun();
        if (localObject != null) {
          ((a)localObject).cir();
        }
      }
      while (paramBallInfo.type == 6)
      {
        localObject = a.eun();
        if (localObject != null)
        {
          ((a)localObject).B(paramBallInfo);
          AppMethodBeat.o(219938);
          return;
          localObject = a.eun();
          if (localObject != null) {}
          for (localObject = ((a)localObject).cix();; localObject = null)
          {
            if (!p.j(paramBallInfo, localObject)) {
              break label133;
            }
            Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove music player ball");
            localObject = d.Aki;
            localObject = d.b.Akk;
            d.b.euv().cir();
            break;
          }
          label133:
          if ((18 == paramBallInfo.type) || (17 == paramBallInfo.type) || (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)))
          {
            Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded pause music because of ball: %s", new Object[] { Integer.valueOf(paramBallInfo.type) });
            if ((com.tencent.mm.ay.a.bef() != null) && (com.tencent.mm.ay.a.bec())) {
              com.tencent.mm.ay.a.bdY();
            }
            MMHandlerThread.postToMainThread((Runnable)a.AjZ);
          }
        }
        else
        {
          AppMethodBeat.o(219938);
          return;
        }
      }
      if (paramBallInfo.type == 23)
      {
        localObject = d.Aki;
        localObject = d.b.Akk;
        d.b.euv().B(paramBallInfo);
      }
      AppMethodBeat.o(219938);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a AjZ;
      
      static
      {
        AppMethodBeat.i(219934);
        AjZ = new a();
        AppMethodBeat.o(219934);
      }
      
      public final void run()
      {
        AppMethodBeat.i(219933);
        b localb = b.AjY;
        b.eur();
        AppMethodBeat.o(219933);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mMusicActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-music_release"})
  public static final class b
    extends IListener<mx>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "state", "", "onPhoneCall"})
  static final class c
    implements PhoneStatusWatcher.PhoneCallListener
  {
    public static final c Aka;
    
    static
    {
      AppMethodBeat.i(219941);
      Aka = new c();
      AppMethodBeat.o(219941);
    }
    
    public final void onPhoneCall(int paramInt)
    {
      AppMethodBeat.i(219940);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(219940);
        return;
        AppMethodBeat.o(219940);
        return;
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "onPhoneCall, removeCurrentBall, state:%s", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.f.h.RTc.aV((Runnable)b.c.1.Uqr);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mVoipEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-music_release"})
  public static final class d
    extends IListener<zj>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.b
 * JD-Core Version:    0.7.0.1
 */