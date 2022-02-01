package com.tencent.mm.plugin.ringtone.j;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.ringtone.a.b;
import com.tencent.mm.plugin.ringtone.g.b.b;
import com.tencent.mm.plugin.ringtone.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/service/RingtoneServiceHelper;", "", "()V", "audioJob", "Lkotlinx/coroutines/Job;", "audioScope", "Lkotlinx/coroutines/CoroutineScope;", "canPlayRingtone", "", "duration", "", "finderObjectId", "", "isOutCall", "isSupportShake", "lastMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "lazyVolume", "", "mBeforeRingVolume", "", "mIsVibrate", "mPlayer", "Lcom/tencent/mm/plugin/ringtone/service/RingtonePlayer;", "mUsername", "mediaInfo", "musicSid", "playPersistentTime", "playStart", "prefAction", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$Action;", "ringtoneChannelModifiedByUser", "ringtoneJob", "ringtoneScope", "ringtoneSource", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "seekStartMs", "soundInfo", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "tpMediaInfoDesc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "vibratePlayer", "Lcom/tencent/mm/plugin/vibrate/VibrateServiceHelper;", "adjustVolume", "", "left", "right", "checkPlayerStatus", "destroyPlayer", "doShakeOnly", "getCurrentPlayPosition", "getPlayInfo", "Lcom/tencent/mm/plugin/ringtone/api/PlayerReportInfo;", "getStreamType", "initPlayer", "play", "resetReportInfo", "responseCommand", "action", "setAudioMode", "mode", "setMusicStreamMute", "mute", "setMute", "setSoundInfo", "soundType", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;", "streamType", "isLoop", "setSpeakerOn", "isSpeakerOn", "setSpeakerStatus", "updateRingtoneInfo", "name", "updateVibrateInfo", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a OEb;
  private static b.c OEs;
  public long GmG;
  public com.tencent.mm.plugin.thumbplayer.a.b GvR;
  public boolean OBR;
  public com.tencent.mm.plugin.ringtone.g.d OBS;
  public com.tencent.mm.plugin.ringtone.g.c ODB;
  public int ODC;
  public b.b ODZ;
  public boolean OEa;
  public com.tencent.mm.plugin.thumbplayer.a.b OEc;
  public b OEd;
  private com.tencent.mm.plugin.ringtone.g.b.a OEe;
  public long OEf;
  public float OEg;
  public cb OEh;
  public final aq OEi;
  private cb OEj;
  private final aq OEk;
  public com.tencent.mm.plugin.au.a OEl;
  public boolean OEm;
  public long OEn;
  public boolean OEo;
  public String OEp;
  public int OEq;
  public boolean OEr;
  public long duration;
  public String sWX;
  
  static
  {
    AppMethodBeat.i(272997);
    OEb = new c.a((byte)0);
    OEs = b.c.ODl;
    AppMethodBeat.o(272997);
  }
  
  public c()
  {
    AppMethodBeat.i(272870);
    this.OEg = -1.0F;
    this.OEi = ar.kBZ();
    this.OEk = ar.d(cx.g(null).plus((f)bg.kCi()));
    this.OEo = true;
    this.ODB = com.tencent.mm.plugin.ringtone.g.c.ODp;
    this.OEp = "";
    this.sWX = "";
    OEs = b.c.ODl;
    AppMethodBeat.o(272870);
  }
  
  public static void BN(boolean paramBoolean)
  {
    AppMethodBeat.i(272904);
    int i;
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (af.lXZ.lRF < 0)) {
        break label139;
      }
      j = af.lXZ.lRF;
    }
    for (;;)
    {
      a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
      if (j != a.a.getMode())
      {
        Log.i("MicroMsg.RingtoneServiceHelper", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        com.tencent.mm.plugin.audio.b.a.a(a.a.cTW(), j);
      }
      locala = com.tencent.mm.plugin.audio.c.a.uVi;
      if (paramBoolean != a.a.cTW().cTU())
      {
        Log.i("MicroMsg.RingtoneServiceHelper", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        a.a.cTW().lP(paramBoolean);
      }
      AppMethodBeat.o(272904);
      return;
      if (com.tencent.mm.compatible.util.d.rb(21))
      {
        i = 3;
        break;
      }
      i = 2;
      break;
      label139:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (af.lXZ.lRD >= 0) {
          j = af.lXZ.lRD;
        }
      }
    }
  }
  
  private final void BO(boolean paramBoolean)
  {
    AppMethodBeat.i(272911);
    cb localcb = this.OEj;
    if (localcb != null) {
      localcb.a(null);
    }
    this.OEj = null;
    this.OEj = j.a(this.OEk, null, null, (m)new d(paramBoolean, null), 3);
    AppMethodBeat.o(272911);
  }
  
  private static final int a(c paramc)
  {
    AppMethodBeat.i(272919);
    s.u(paramc, "this$0");
    paramc = paramc.OEd;
    if (paramc == null)
    {
      AppMethodBeat.o(272919);
      return 0;
    }
    int i = (int)paramc.getCurrentPosition();
    AppMethodBeat.o(272919);
    return i;
  }
  
  private final void eDO()
  {
    AppMethodBeat.i(272877);
    Log.i("MicroMsg.RingtoneServiceHelper", "initPlayer");
    if (this.OEd != null)
    {
      localObject1 = this.OEd;
      if (localObject1 != null) {
        ((b)localObject1).stopAsync();
      }
      localObject1 = this.OEd;
      if (localObject1 != null) {
        ((b)localObject1).release();
      }
      this.OEd = null;
    }
    Object localObject1 = this.GvR;
    Object localObject2 = this.ODZ;
    boolean bool;
    if ((localObject1 != null) && (localObject2 != null))
    {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).loop = ((b.b)localObject2).oYG;
      b.a locala = b.ODY;
      bool = this.OEa;
      s.u(localObject1, "mediaInfo");
      s.u(localObject2, "soundInfo");
      Log.i("MicroMsg.RingtonePlayer", "create ringtonePlayer, mediaInfo:" + localObject1 + ", soundInfo:" + localObject2 + ", isOutCall:" + bool);
      if (!((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv) {
        break label339;
      }
      localObject1 = (b)new a((com.tencent.mm.plugin.thumbplayer.a.b)localObject1, (b.b)localObject2, bool);
      this.OEd = ((b)localObject1);
      if (this.OEg != -1.0F) {
        break label357;
      }
    }
    label339:
    label357:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        da(this.OEg);
      }
      localObject1 = this.OEd;
      if (localObject1 != null) {
        ((b)localObject1).tL(this.OEf);
      }
      if (((b.b)localObject2).ODh == a.b.OBg)
      {
        localObject1 = this.OEd;
        if (localObject1 != null) {
          ((b)localObject1).aC((kotlin.g.a.b)new c(this));
        }
        if (this.OEm)
        {
          this.OEl = new com.tencent.mm.plugin.au.a();
          localObject1 = this.OBS;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.ringtone.g.d)localObject1).gOD();
            if (localObject1 != null)
            {
              localObject2 = this.OEl;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.au.a)localObject2).a((com.tencent.mm.plugin.aj.a.a)localObject1, new c..ExternalSyntheticLambda0(this));
              }
              localObject1 = this.OEl;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.au.a)localObject1).hQe();
              }
              this.OBR = true;
            }
          }
        }
      }
      AppMethodBeat.o(272877);
      return;
      localObject1 = (b)new d((com.tencent.mm.plugin.thumbplayer.a.b)localObject1, (b.b)localObject2, bool);
      break;
    }
  }
  
  private final void gOA()
  {
    AppMethodBeat.i(272884);
    if (this.OEd != null) {
      try
      {
        b localb = this.OEd;
        if (localb != null) {
          localb.stopAsync();
        }
        localb = this.OEd;
        if (localb != null) {
          localb.release();
        }
        this.OEd = null;
        this.GvR = null;
        this.OEc = null;
        this.ODZ = null;
        Log.i("MicroMsg.RingtoneServiceHelper", "Player destroyed");
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      finally
      {
        this.OEd = null;
        AppMethodBeat.o(272884);
      }
    }
    AppMethodBeat.o(272884);
  }
  
  private final void play()
  {
    AppMethodBeat.i(272891);
    Log.i("MicroMsg.RingtoneServiceHelper", "play");
    try
    {
      BO(true);
      b localb = this.OEd;
      if (localb != null)
      {
        localb.play();
        AppMethodBeat.o(272891);
        return;
      }
    }
    catch (Exception localException)
    {
      gOA();
      AppMethodBeat.o(272891);
    }
  }
  
  public static void setAudioMode(int paramInt)
  {
    AppMethodBeat.i(272898);
    if (com.tencent.mm.plugin.ringtone.c.gOi())
    {
      a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
      if (paramInt != a.a.getMode())
      {
        Log.i("MicroMsg.RingtoneServiceHelper", "set AudioManager mode: %s", new Object[] { Integer.valueOf(paramInt) });
        locala = com.tencent.mm.plugin.audio.c.a.uVi;
        com.tencent.mm.plugin.audio.b.a.a(a.a.cTW(), paramInt);
      }
    }
    AppMethodBeat.o(272898);
  }
  
  public final void a(com.tencent.mm.plugin.ringtone.g.b.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(273016);
    s.u(parama, "action");
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        this.OEe = parama;
        AppMethodBeat.o(273016);
        return;
        Log.printInfoStack("MicroMsg.RingtoneServiceHelper", "Received start Intent ", new Object[0]);
        if (this.GvR == null)
        {
          Log.e("MicroMsg.RingtoneServiceHelper", "media info not ready ");
          AppMethodBeat.o(273016);
          return;
        }
        OEs = b.c.ODi;
        label126:
        com.tencent.mm.plugin.thumbplayer.a.b localb;
        if (this.OEd != null)
        {
          localObject1 = this.GvR;
          if (localObject1 != null) {
            break label164;
          }
          localObject1 = null;
          localb = this.OEc;
          if (localb != null) {
            break label172;
          }
        }
        for (;;)
        {
          if (!s.p(localObject1, localObject2))
          {
            Log.i("MicroMsg.RingtoneServiceHelper", "player not ready, recreate player and start play");
            eDO();
          }
          play();
          break;
          label164:
          localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
          break label126;
          label172:
          localObject2 = localb.mediaId;
        }
        OEs = b.c.ODk;
        Log.i("MicroMsg.RingtoneServiceHelper", "Received pause Intent");
        localObject1 = this.OEl;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.au.a)localObject1).stopShake();
        }
        localObject1 = this.OEd;
        if (localObject1 != null) {
          ((b)localObject1).pause();
        }
        BO(false);
        continue;
        OEs = b.c.ODj;
        Log.i("MicroMsg.RingtoneServiceHelper", "Received continue Intent");
        play();
      }
    }
    Log.i("MicroMsg.RingtoneServiceHelper", "Received Stop Intent");
    gOA();
    BO(false);
    OEs = b.c.ODk;
    localObject2 = this.OEl;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.au.a)localObject2).stopShake();
    }
    this.OEm = false;
    localObject2 = this.OEh;
    if (localObject2 != null) {
      ((cb)localObject2).a(null);
    }
    localObject2 = com.tencent.mm.plugin.ringtone.c.OBr;
    com.tencent.mm.plugin.ringtone.c.gOe().t(null);
    localObject2 = this.ODZ;
    if (localObject2 == null) {}
    for (;;)
    {
      if (localObject1 == a.b.OBg) {
        this.OEn = (System.currentTimeMillis() - this.GmG);
      }
      this.OEf = 0L;
      localObject1 = com.tencent.mm.plugin.ringtone.d.OBx;
      com.tencent.mm.plugin.ringtone.d.gOu();
      break;
      localObject1 = ((b.b)localObject2).ODh;
    }
  }
  
  public final void da(float paramFloat)
  {
    AppMethodBeat.i(273022);
    if (this.OEd != null)
    {
      if (paramFloat == -1.0F) {}
      for (int i = 1; i == 0; i = 0)
      {
        b localb = this.OEd;
        if (localb != null) {
          localb.da(paramFloat);
        }
        this.OEg = -1.0F;
        AppMethodBeat.o(273022);
        return;
      }
    }
    this.OEg = paramFloat;
    AppMethodBeat.o(273022);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Exception, ah>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(boolean paramBoolean, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272882);
      paramObject = (kotlin.d.d)new d(this.usI, paramd);
      AppMethodBeat.o(272882);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272878);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272878);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (this.usI)
      {
        paramObject = com.tencent.mm.plugin.audio.c.a.uVi;
        a.a.cTW().bLg();
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(272878);
        return paramObject;
        paramObject = com.tencent.mm.plugin.audio.c.a.uVi;
        a.a.cTW().bLh();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public e(String paramString, c paramc, boolean paramBoolean, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272892);
      paramd = new e(this.aCx, this.OEt, this.OBo, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272892);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272887);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272887);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (aq)this.L$0;
        paramObject = this.aCx;
        b.b localb = c.b(this.OEt);
        boolean bool = this.OBo;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.label = 1;
        paramObject = com.tencent.mm.plugin.ringtone.c.a(paramObject, localb, bool, locald);
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(272887);
          return localObject2;
        }
        break;
      case 1: 
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        localObject2 = (com.tencent.mm.plugin.ringtone.g.d)paramObject;
        c.a(this.OEt, ((com.tencent.mm.plugin.ringtone.g.d)localObject2).ODv);
        c.a(this.OEt, (com.tencent.mm.plugin.ringtone.g.d)localObject2);
        if (ar.a((aq)localObject1)) {
          this.OEt.a(com.tencent.mm.plugin.ringtone.g.b.a.ODb);
        }
        paramObject = c.b(this.OEt);
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = paramObject.ODh)
        {
          if (paramObject == a.b.OBg)
          {
            paramObject = this.aCx;
            if (paramObject != null) {
              c.b(this.OEt, paramObject);
            }
            c.a(this.OEt, System.currentTimeMillis());
            c.a(this.OEt, ((com.tencent.mm.plugin.ringtone.g.d)localObject2).ODB);
            paramObject = this.OEt;
            localObject1 = Util.getUnsignedLongString(((com.tencent.mm.plugin.ringtone.g.d)localObject2).mIH);
            s.s(localObject1, "getUnsignedLongString(ri…MediaInfo.finderObjectId)");
            c.a(paramObject, (String)localObject1);
            c.a(this.OEt, ((com.tencent.mm.plugin.ringtone.g.d)localObject2).ODC);
            paramObject = this.OEt;
            localObject1 = com.tencent.mm.plugin.ringtone.d.OBx;
            c.a(paramObject, com.tencent.mm.plugin.ringtone.d.b((com.tencent.mm.plugin.ringtone.g.d)localObject2));
            c.b(this.OEt, ((com.tencent.mm.plugin.ringtone.g.d)localObject2).mDuration);
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(272887);
          return paramObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.j.c
 * JD-Core Version:    0.7.0.1
 */