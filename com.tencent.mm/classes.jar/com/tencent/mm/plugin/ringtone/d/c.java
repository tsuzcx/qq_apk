package com.tencent.mm.plugin.ringtone.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.i.a.a;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.ag;
import com.tencent.mm.protocal.protobuf.a.q;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.l;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;", "Landroidx/lifecycle/ViewModel;", "lifeCycleScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_actionFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onPlay;", "_uiState", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow$RingtonePlayerUiState$onNewState;", "actionFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getLifeCycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "setLifeCycleScope", "mPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "mSongId", "", "getMSongId", "()J", "setMSongId", "(J)V", "mTpMediaInfoDesc", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "mVibrate", "Lcom/tencent/mm/plugin/vibrate/manager/VibratePlayer;", "playFlowJob", "Lkotlinx/coroutines/Job;", "uiState", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkResourceAvailable", "playDesc", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyPlayer", "", "initPlayer", "tpMediaInfo", "play", "release", "requestPlayFlow", "tpMediaInfoDesc", "id", "", "requestRingtonePlay", "requestStopPlay", "restartFlowJob", "setMediaInfo", "info", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "stopPlaySync", "Companion", "RingtonePlayerUiState", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends androidx.lifecycle.af
{
  public static final c.a OCw;
  private com.tencent.mm.plugin.thumbplayer.e.b CNh;
  long OCA;
  private com.tencent.mm.plugin.au.b.a OCB;
  private com.tencent.mm.plugin.ringtone.g.d OCC;
  private cb OCD;
  private final x<c.b.a> OCe;
  public final kotlinx.coroutines.b.af<c.b.a> OCf;
  private aq OCx;
  private x<c.b.b> OCy;
  private final kotlinx.coroutines.b.af<c.b.b> OCz;
  
  static
  {
    AppMethodBeat.i(273211);
    OCw = new c.a((byte)0);
    AppMethodBeat.o(273211);
  }
  
  public c(aq paramaq)
  {
    AppMethodBeat.i(273129);
    this.OCx = paramaq;
    this.OCe = kotlinx.coroutines.b.ah.ji(new c.b.a(0L, 3));
    this.OCf = ((kotlinx.coroutines.b.af)this.OCe);
    this.OCy = kotlinx.coroutines.b.ah.ji(new c.b.b(0L, null, 1));
    this.OCz = ((kotlinx.coroutines.b.af)this.OCy);
    AppMethodBeat.o(273129);
  }
  
  private static final int a(c paramc)
  {
    AppMethodBeat.i(273156);
    s.u(paramc, "this$0");
    paramc = paramc.CNh;
    if (paramc == null)
    {
      AppMethodBeat.o(273156);
      return 0;
    }
    int i = (int)paramc.getCurrentPositionMs();
    AppMethodBeat.o(273156);
    return i;
  }
  
  private final void gOA()
  {
    AppMethodBeat.i(273149);
    if (this.CNh != null) {
      try
      {
        Object localObject1 = this.CNh;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).eLO();
        }
        localObject1 = this.CNh;
        if (localObject1 != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
        }
        localObject1 = this.CNh;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).stopAsync();
        }
        localObject1 = this.OCB;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.au.b.a)localObject1).stopShake();
        }
        localObject1 = this.CNh;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).recycle();
        }
        this.CNh = null;
        Log.i("MicroMsg.RingtonePlayerFlow", "Player destroyed");
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      finally
      {
        this.CNh = null;
        AppMethodBeat.o(273149);
      }
    }
    AppMethodBeat.o(273149);
  }
  
  private final void gOz()
  {
    AppMethodBeat.i(273138);
    StringBuilder localStringBuilder = new StringBuilder("stop play sync id is").append(this.OCA).append(" and ");
    Object localObject = this.OCC;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.ringtone.g.d)localObject).toJson())
    {
      Log.i("MicroMsg.RingtonePlayerFlow", localObject);
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).aG(null);
      }
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).TFi = null;
      }
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).j(null);
      }
      localObject = this.OCB;
      if (localObject != null) {
        ((com.tencent.mm.plugin.au.b.a)localObject).stopShake();
      }
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).eLO();
      }
      localObject = this.CNh;
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      }
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stop();
      }
      localObject = this.CNh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
      AppMethodBeat.o(273138);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.ringtone.g.d paramd, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(273224);
    x localx = this.OCy;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      localx.setValue(new c.b.b(paramLong, paramd, i));
      AppMethodBeat.o(273224);
      return;
    }
  }
  
  public final void c(com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    AppMethodBeat.i(273263);
    s.u(paramd, "tpMediaInfo");
    Log.i("MicroMsg.RingtonePlayerFlow", s.X("initPlayer is ", paramd.toJson()));
    this.OCC = paramd;
    Object localObject1 = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
    localObject1 = MMApplicationContext.getContext();
    s.s(localObject1, "getContext()");
    this.CNh = com.tencent.mm.plugin.thumbplayer.e.d.a.ks((Context)localObject1);
    localObject1 = paramd.ODv;
    Object localObject2;
    if (localObject1 != null)
    {
      s.u(localObject1, "info");
      localObject2 = com.tencent.mm.plugin.ringtone.g.d.ODu;
      Log.i("MicroMsg.RingtonePlayerFlow", s.X("setMediaInfo to play ", com.tencent.mm.plugin.ringtone.g.d.a.a((com.tencent.mm.plugin.thumbplayer.a.b)localObject1)));
      localObject2 = this.CNh;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
      }
      localObject2 = this.CNh;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).loop);
      }
      localObject1 = this.CNh;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Flr = true;
      }
      localObject1 = this.CNh;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFv = paramd.mStartTime;
      }
      localObject1 = this.CNh;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).bs(paramd.mStartTime, paramd.mEndTime);
      }
    }
    localObject1 = this.CNh;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFi = ((kotlin.g.a.b)new d(this));
    }
    localObject1 = this.CNh;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).aG((kotlin.g.a.b)new e(this));
    }
    localObject1 = this.CNh;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((b.b)localObject1).TFy = ((m)new f(paramd, this));
      }
      this.OCB = new com.tencent.mm.plugin.au.b.a();
      localObject1 = this.OCC;
      if (localObject1 != null) {
        break label460;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = new ag();
        localObject2 = new com.tencent.mm.protocal.protobuf.a.b();
        ((com.tencent.mm.protocal.protobuf.a.b)localObject2).aacf = paramd.mIH;
        ((com.tencent.mm.protocal.protobuf.a.b)localObject2).aacg = paramd.LYS;
        kotlin.ah localah = kotlin.ah.aiuX;
        ((ag)localObject1).acji = ((com.tencent.mm.protocal.protobuf.a.b)localObject2);
        localObject2 = new com.tencent.mm.protocal.protobuf.a.u();
        ((com.tencent.mm.protocal.protobuf.a.u)localObject2).aaYO = paramd.ODC;
        paramd = kotlin.ah.aiuX;
        ((ag)localObject1).acjh = ((com.tencent.mm.protocal.protobuf.a.u)localObject2);
        paramd = com.tencent.mm.plugin.au.d.a.TWU;
        com.tencent.mm.plugin.au.d.a.a((ag)localObject1);
      }
      paramd = this.OCC;
      if (paramd != null)
      {
        paramd = paramd.gOD();
        if (paramd != null)
        {
          localObject1 = this.OCB;
          if (localObject1 != null)
          {
            localObject2 = MMApplicationContext.getContext();
            s.s(localObject2, "getContext()");
            ((com.tencent.mm.plugin.au.b.a)localObject1).a(paramd, (Context)localObject2, new c..ExternalSyntheticLambda0(this));
          }
        }
      }
      Log.i("MicroMsg.RingtonePlayerFlow", "play");
      try
      {
        paramd = this.CNh;
        if (paramd != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.a(paramd, 0, false, 6);
        }
        paramd = this.CNh;
        if (paramd == null) {
          break label487;
        }
        paramd.hLh();
        AppMethodBeat.o(273263);
        return;
      }
      catch (Exception paramd)
      {
        label460:
        gOA();
        AppMethodBeat.o(273263);
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFd;
      break;
      localObject1 = ((com.tencent.mm.plugin.ringtone.g.d)localObject1).gOD();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((com.tencent.mm.plugin.aj.a.a)localObject1).fileUrl;
      }
    }
    label487:
  }
  
  public final void gOx()
  {
    AppMethodBeat.i(273232);
    gOz();
    this.OCy.setValue(new c.b.b(0L, null, 3));
    AppMethodBeat.o(273232);
  }
  
  public final void gOy()
  {
    AppMethodBeat.i(273239);
    this.OCD = j.a(this.OCx, null, null, (m)new g(this, null), 3);
    cb localcb = this.OCD;
    if (localcb != null) {
      localcb.start();
    }
    AppMethodBeat.o(273239);
  }
  
  public final void release()
  {
    AppMethodBeat.i(273247);
    this.OCy.setValue(new c.b.b(0L, null, 3));
    gOA();
    cb localcb = this.OCD;
    if (localcb != null) {
      localcb.a(null);
    }
    AppMethodBeat.o(273247);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>, Object>
  {
    Object L$0;
    long Yx;
    int aai;
    int label;
    
    c(com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273171);
      paramObject = (kotlin.d.d)new c(this.OCF, paramd);
      AppMethodBeat.o(273171);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273162);
      Object localObject2 = kotlin.d.a.a.aiwj;
      com.tencent.mm.plugin.ringtone.g.d locald;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273162);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.OCF;
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = paramObject.toJson())
        {
          Log.i("MicroMsg.RingtonePlayerFlow", s.X("checkResourceAvailable ", paramObject));
          locald = this.OCF;
          if (locald != null) {
            break;
          }
          AppMethodBeat.o(273162);
          return null;
        }
        paramObject = locald;
        if (locald.ODv == null) {
          if (locald.ODC != 0)
          {
            i = locald.ODC;
            paramObject = PluginRingtone.OBl;
            paramObject = (kotlin.d.d)this;
            this.L$0 = locald;
            this.aai = i;
            this.label = 1;
            paramObject = PluginRingtone.a.getSingleMusicRingBackPlayInfo(i, paramObject);
            if (paramObject != localObject2) {
              break label630;
            }
            AppMethodBeat.o(273162);
            return localObject2;
          }
        }
        break;
      case 1: 
        i = this.aai;
        locald = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      label236:
      label630:
      for (;;)
      {
        paramObject = (q)paramObject;
        Object localObject1;
        if (paramObject == null)
        {
          paramObject = null;
          if (paramObject == null) {
            break label336;
          }
          localObject1 = paramObject.URL;
          if (localObject1 == null) {
            break label331;
          }
          if (n.bp((CharSequence)localObject1)) {
            break label326;
          }
          j = 1;
          if (j != 1) {
            break label331;
          }
        }
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label336;
          }
          localObject1 = s.X("music_ringtone_", Integer.valueOf(i));
          localObject2 = com.tencent.mm.plugin.ringtone.c.OBr;
          locald.ODv = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, com.tencent.mm.plugin.ringtone.c.cI(i, (String)localObject1), paramObject.URL, 0, 2147483647);
          locald.ODE = false;
          AppMethodBeat.o(273162);
          return locald;
          paramObject = paramObject.aciQ;
          if (paramObject == null)
          {
            paramObject = null;
            break;
          }
          paramObject = paramObject.acjr;
          break;
          j = 0;
          break label236;
        }
        AppMethodBeat.o(273162);
        return null;
        if ((locald.mIH != 0L) && (!s.p(locald.LYS, "")))
        {
          long l = locald.mIH;
          paramObject = locald.LYS;
          localObject1 = PluginRingtone.OBl;
          localObject1 = (kotlin.d.d)this;
          this.L$0 = locald;
          this.Yx = l;
          this.label = 2;
          localObject1 = com.tencent.mm.plugin.ringtone.i.a.getRingBackFromFinder(l, paramObject, (kotlin.d.d)localObject1);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(273162);
            return localObject2;
            l = this.Yx;
            locald = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
            ResultKt.throwOnFailure(paramObject);
          }
          localObject1 = (a.a)paramObject;
          if (localObject1 == null) {
            paramObject = null;
          }
          while ((localObject1 != null) && (!((a.a)localObject1).OBU) && (paramObject != null))
          {
            paramObject = ((cn)h.az(cn.class)).createMediaInfo(paramObject, kotlin.d.b.a.b.BF(l), false);
            if (paramObject == null)
            {
              AppMethodBeat.o(273162);
              return null;
              paramObject = ((a.a)localObject1).ABJ;
              if (paramObject == null)
              {
                paramObject = null;
              }
              else
              {
                paramObject = paramObject.objectDesc;
                if (paramObject == null)
                {
                  paramObject = null;
                }
                else
                {
                  paramObject = paramObject.media;
                  if (paramObject == null) {
                    paramObject = null;
                  } else {
                    paramObject = (FinderMedia)p.oL((List)paramObject);
                  }
                }
              }
            }
            else
            {
              paramObject.path = s.X(paramObject.path, ".ring");
              paramObject.videoFlag = "A0";
              locald.ODE = true;
              locald.ODv = paramObject;
              paramObject = locald;
              AppMethodBeat.o(273162);
              return paramObject;
            }
          }
          AppMethodBeat.o(273162);
          return null;
        }
        AppMethodBeat.o(273162);
        return null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, kotlin.ah>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, kotlin.ah>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "ret", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<String, Integer, kotlin.ah>
  {
    f(com.tencent.mm.plugin.ringtone.g.d paramd, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    g(c paramc, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273172);
      paramObject = (kotlin.d.d)new g(this.OCG, paramd);
      AppMethodBeat.o(273172);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273163);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273163);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (g)c.b(this.OCG);
        m localm = (m)new k(this.OCG, null)
        {
          int label;
          
          public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(273200);
            paramAnonymousd = new 1(this.OCG, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
            AppMethodBeat.o(273200);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(273192);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            c.b.b localb;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(273192);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              localb = (c.b.b)this.L$0;
              if (localb.state == 3)
              {
                c.c(this.OCG).setValue(new c.b.a(0L, 1));
                c.d(this.OCG);
              }
              for (;;)
              {
                paramAnonymousObject = kotlin.ah.aiuX;
                AppMethodBeat.o(273192);
                return paramAnonymousObject;
                if (localb.OCE != null) {
                  break;
                }
                c.c(this.OCG).setValue(new c.b.a(localb.id, 1));
                c.d(this.OCG);
              }
              c.c(this.OCG).setValue(new c.b.a(localb.id, 1));
              paramAnonymousObject = localb.OCE;
              kotlin.d.d locald = (kotlin.d.d)this;
              this.L$0 = localb;
              this.label = 1;
              paramAnonymousObject = c.c(paramAnonymousObject, locald);
              if (paramAnonymousObject == locala)
              {
                AppMethodBeat.o(273192);
                return locala;
              }
              break;
            case 1: 
              localb = (c.b.b)this.L$0;
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            for (;;)
            {
              paramAnonymousObject = (com.tencent.mm.plugin.ringtone.g.d)paramAnonymousObject;
              if (paramAnonymousObject == null)
              {
                c.e(this.OCG).setValue(new c.b.b(0L, null, 3));
                c.d(this.OCG);
                break;
              }
              c.a(this.OCG, paramAnonymousObject, localb.id);
              break;
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, localm, locald) == locala)
        {
          AppMethodBeat.o(273163);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(273163);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.d.c
 * JD-Core Version:    0.7.0.1
 */