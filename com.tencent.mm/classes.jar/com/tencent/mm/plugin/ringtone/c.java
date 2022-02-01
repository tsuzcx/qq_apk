package com.tencent.mm.plugin.ringtone;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ringtone.g.b.b;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.p;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/RingBackHelper;", "", "()V", "TAG", "", "ringtoneFilePath", "ringtoneMediaInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "getRingtoneMediaInfo", "()Landroidx/lifecycle/MutableLiveData;", "ringtoneRootPath", "copyRingtone", "", "getCallingRingBackMediaInfo", "username", "isOutCall", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultBadNetHintSound", "getDefaultCallingRingtone", "getDefaultCloseSound", "getDefaultEndRingtone", "getDefaultPath", "fileName", "getRingBackMediaInfo", "soundInfo", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingBackSettingMediaDesc", "ringbackInfo", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "(Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingtoneCachePath", "mediaSid", "", "mediaId", "getRingtoneRingIcon", "isDark", "getTmpRingtonePath", "toUser", "isExternalDeviceUseRing", "isRingtoneCallingUseVoiceCall", "isRingtoneChannelGrantPermission", "isSetModeWhileRinging", "multitalkStartScoWhenRing", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c OBr;
  private static final String OBs;
  private static final String OBt;
  private static final x<com.tencent.mm.plugin.ringtone.g.d> OBu;
  
  static
  {
    AppMethodBeat.i(273257);
    OBr = new c();
    String str = s.X(com.tencent.mm.loader.i.b.bmq(), "app_ringtone");
    OBs = str;
    OBt = s.X(str, "/");
    OBu = new x();
    AppMethodBeat.o(273257);
  }
  
  public static final String BL(boolean paramBoolean)
  {
    AppMethodBeat.i(273205);
    if (paramBoolean)
    {
      str = aUr("animation_ringonte_ring_dark.wxam");
      AppMethodBeat.o(273205);
      return str;
    }
    String str = aUr("animation_ringonte_ring.wxam");
    AppMethodBeat.o(273205);
    return str;
  }
  
  public static final Object a(com.tencent.mm.plugin.ringtone.a.b paramb, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d> paramd)
  {
    AppMethodBeat.i(273193);
    paramb = l.a((f)bg.kCi(), (m)new c(paramb, null), paramd);
    AppMethodBeat.o(273193);
    return paramb;
  }
  
  public static final Object a(final String paramString, b.b paramb, final boolean paramBoolean, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d> paramd)
  {
    AppMethodBeat.i(273178);
    paramString = l.a((f)bg.kCi(), (m)new b(paramb, paramString, paramBoolean, null), paramd);
    AppMethodBeat.o(273178);
    return paramString;
  }
  
  public static final Object a(String paramString, final boolean paramBoolean, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d> paramd)
  {
    AppMethodBeat.i(273184);
    paramString = l.a((f)bg.kCi(), (m)new a(paramString, paramBoolean, null), paramd);
    AppMethodBeat.o(273184);
    return paramString;
  }
  
  private static String aUr(String paramString)
  {
    AppMethodBeat.i(273220);
    if (!new u(s.X(OBt, paramString)).jKS()) {
      gOf();
    }
    paramString = com.tencent.mm.vfs.ah.v(new u(s.X(OBt, paramString)).jKT());
    s.s(paramString, "file.absolutePath");
    AppMethodBeat.o(273220);
    return paramString;
  }
  
  public static String cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(273230);
    s.u(paramString, "mediaId");
    paramString = OBt + paramInt + '_' + paramString + ".ringtone";
    AppMethodBeat.o(273230);
    return paramString;
  }
  
  public static x<com.tencent.mm.plugin.ringtone.g.d> gOe()
  {
    return OBu;
  }
  
  private static void gOf()
  {
    AppMethodBeat.i(273131);
    u localu = new u(OBs);
    if (localu.jKV()) {
      localu.diJ();
    }
    if (!localu.jKS()) {
      localu.jKY();
    }
    long l = System.currentTimeMillis();
    y.O("assets:///phonering.mp3", s.X(OBt, "phonering.mp3"), false);
    y.O("assets:///playend.mp3", s.X(OBt, "playend.mp3"), false);
    y.O("assets:///close_sound.mp3", s.X(OBt, "close_sound.mp3"), false);
    y.O("assets:///voip_bad_netstatus_hint.mp3", s.X(OBt, "voip_bad_netstatus_hint.mp3"), false);
    y.O("assets:///animation_ringonte_ring.wxam", s.X(OBt, "animation_ringonte_ring.wxam"), false);
    y.O("assets:///animation_ringonte_ring_dark.wxam", s.X(OBt, "animation_ringonte_ring_dark.wxam"), false);
    Log.d("MicroMsg.RingBackHelper", "copyRingtone. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(273131);
  }
  
  public static final boolean gOg()
  {
    AppMethodBeat.i(273140);
    i locali = i.agtt;
    if (i.a(b.a.agsK, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsK, 0) == 1)
      {
        AppMethodBeat.o(273140);
        return true;
      }
      AppMethodBeat.o(273140);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySM, false))
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySL, true);
      AppMethodBeat.o(273140);
      return bool;
    }
    AppMethodBeat.o(273140);
    return true;
  }
  
  public static boolean gOh()
  {
    AppMethodBeat.i(273146);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySO, false);
    AppMethodBeat.o(273146);
    return bool;
  }
  
  public static final boolean gOi()
  {
    AppMethodBeat.i(273153);
    i locali = i.agtt;
    if (i.a(b.a.agsL, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsL, 0) == 1)
      {
        AppMethodBeat.o(273153);
        return true;
      }
      AppMethodBeat.o(273153);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySN, false);
    AppMethodBeat.o(273153);
    return bool;
  }
  
  public static final boolean gOj()
  {
    AppMethodBeat.i(273161);
    i locali = i.agtt;
    if (i.a(b.a.agsM, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsM, 0) == 1)
      {
        AppMethodBeat.o(273161);
        return true;
      }
      AppMethodBeat.o(273161);
      return false;
    }
    if (com.tencent.mm.compatible.util.d.rb(29))
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySZ, true);
      AppMethodBeat.o(273161);
      return bool;
    }
    AppMethodBeat.o(273161);
    return false;
  }
  
  public static final boolean gOk()
  {
    AppMethodBeat.i(273169);
    i locali = i.agtt;
    if (i.a(b.a.agsR, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsR, 0) == 1)
      {
        AppMethodBeat.o(273169);
        return true;
      }
      AppMethodBeat.o(273169);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySY, false))
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySX, true);
      AppMethodBeat.o(273169);
      return bool;
    }
    AppMethodBeat.o(273169);
    return true;
  }
  
  public static final String gOl()
  {
    AppMethodBeat.i(273199);
    String str = aUr("phonering.mp3");
    AppMethodBeat.o(273199);
    return str;
  }
  
  public static final String lD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273213);
    s.u(paramString1, "toUser");
    s.u(paramString2, "fileName");
    paramString2 = n.m(paramString2, "/", " ", false);
    int i;
    StringBuilder localStringBuilder;
    if (((CharSequence)paramString2).length() == 0)
    {
      i = 1;
      if (i != 0) {
        paramString2 = String.valueOf(System.currentTimeMillis());
      }
      localStringBuilder = new StringBuilder().append(OBt);
      if (((CharSequence)paramString1).length() <= 0) {
        break label164;
      }
      i = 1;
      label84:
      if (i == 0) {
        break label169;
      }
    }
    label164:
    label169:
    for (paramString1 = s.X(paramString1, "/");; paramString1 = "")
    {
      paramString1 = new u(paramString1 + paramString2);
      paramString2 = paramString1.jKP();
      if ((paramString2 != null) && (!paramString2.jKS())) {
        paramString2.jKY();
      }
      paramString1 = com.tencent.mm.vfs.ah.v(paramString1.jKT());
      s.s(paramString1, "userRingtonePath.absolutePath");
      AppMethodBeat.o(273213);
      return paramString1;
      i = 0;
      break;
      i = 0;
      break label84;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>, Object>
  {
    Object L$0;
    int label;
    
    a(String paramString, boolean paramBoolean, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273001);
      paramObject = (kotlin.d.d)new a(this.mrr, paramBoolean, paramd);
      AppMethodBeat.o(273001);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272993);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272993);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.RingBackHelper", "getCallingRingBackMediaInfo, username:" + this.mrr + ", isOutCall:" + paramBoolean);
        paramObject = PluginRingtone.OBl;
        paramObject = this.mrr;
        boolean bool = paramBoolean;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = PluginRingtone.a.getRingBackPlayInfo(paramObject, bool, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(272993);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (r)paramObject;
        paramObject = new ah.f();
        paramObject.aqH = ((r)localObject1).bsC;
        localObject1 = (com.tencent.mm.plugin.ringtone.a.b)((r)localObject1).bsD;
        if ((paramObject.aqH == com.tencent.mm.plugin.ringtone.g.c.ODp) && (!paramBoolean))
        {
          localObject1 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 2;
          localObject2 = com.tencent.mm.plugin.ringtone.i.a.am((kotlin.d.d)localObject1);
          localObject1 = localObject2;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(272993);
            return locala;
          }
        }
        break;
      case 2: 
        localObject2 = (ah.f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject1 = (com.tencent.mm.plugin.ringtone.a.b)localObject1;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.ringtone.g.d.ODu;
          localObject1 = d.a.gOF();
          if ((s.p(((com.tencent.mm.plugin.ringtone.g.d)localObject1).getMediaId(), "voip_default_sound")) || (paramObject.aqH == com.tencent.mm.plugin.ringtone.g.c.ODp)) {
            break label380;
          }
          ((com.tencent.mm.plugin.ringtone.g.d)localObject1).a((com.tencent.mm.plugin.ringtone.g.c)paramObject.aqH);
        }
        for (;;)
        {
          AppMethodBeat.o(272993);
          return localObject1;
          localObject2 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 3;
          localObject2 = c.a((com.tencent.mm.plugin.ringtone.a.b)localObject1, (kotlin.d.d)localObject2);
          localObject1 = localObject2;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(272993);
            return locala;
            localObject2 = (ah.f)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          localObject1 = (com.tencent.mm.plugin.ringtone.g.d)localObject1;
          break;
          label380:
          if ((s.p(((com.tencent.mm.plugin.ringtone.g.d)localObject1).getMediaId(), "voip_default_sound")) && (paramObject.aqH != com.tencent.mm.plugin.ringtone.g.c.ODp)) {
            ((com.tencent.mm.plugin.ringtone.g.d)localObject1).a(com.tencent.mm.plugin.ringtone.g.c.ODq);
          } else {
            ((com.tencent.mm.plugin.ringtone.g.d)localObject1).a(com.tencent.mm.plugin.ringtone.g.c.ODp);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>, Object>
  {
    Object L$0;
    int label;
    
    b(b.b paramb, String paramString, boolean paramBoolean, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272854);
      paramObject = (kotlin.d.d)new b(this.OBv, paramString, paramBoolean, paramd);
      AppMethodBeat.o(272854);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool1 = false;
      AppMethodBeat.i(272849);
      Object localObject3 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272849);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = this.OBv;
        if (localObject1 == null) {
          break label449;
        }
        localObject2 = paramString;
        boolean bool2 = paramBoolean;
        paramObject = ((b.b)localObject1).ODh;
        switch (a.$EnumSwitchMapping$0[paramObject.ordinal()])
        {
        default: 
          paramObject = new p();
          AppMethodBeat.o(272849);
          throw paramObject;
        case 1: 
          if (localObject2 == null) {
            break label449;
          }
          if (!bool2)
          {
            paramObject = (CharSequence)localObject2;
            if ((paramObject == null) || (paramObject.length() == 0)) {}
            for (int i = 1; i == 0; i = 0)
            {
              paramObject = localObject2;
              if (s.p(localObject2, z.bAM())) {
                paramObject = "";
              }
              paramObject = d.aUu(paramObject);
              AppMethodBeat.o(272849);
              return paramObject;
            }
          }
          if (bool2) {
            bool1 = true;
          }
          this.L$0 = localObject1;
          this.label = 1;
          localObject2 = c.a((String)localObject2, bool1, this);
          paramObject = localObject2;
          if (localObject2 == localObject3)
          {
            AppMethodBeat.o(272849);
            return localObject3;
          }
          break;
        }
      case 1: 
        localObject1 = (b.b)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject2 = (com.tencent.mm.plugin.ringtone.g.d)paramObject;
      localObject3 = ((com.tencent.mm.plugin.ringtone.g.d)localObject2).ODv;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject3).loop = ((b.b)localObject1).oYG;
      }
      Object localObject1 = c.OBr;
      c.gOe().t(localObject2);
      AppMethodBeat.o(272849);
      return paramObject;
      c.gOm();
      paramObject = new com.tencent.mm.plugin.thumbplayer.a.b("voip_ending_sound", c.gOm(), "", 0, 0);
      paramObject.hJv = true;
      paramObject = new com.tencent.mm.plugin.ringtone.g.d(paramObject);
      AppMethodBeat.o(272849);
      return paramObject;
      c.gOm();
      paramObject = new com.tencent.mm.plugin.thumbplayer.a.b("voip_close_sound", c.gOn(), "", 0, 0);
      paramObject.hJv = true;
      paramObject.loop = false;
      paramObject = new com.tencent.mm.plugin.ringtone.g.d(paramObject);
      AppMethodBeat.o(272849);
      return paramObject;
      c.gOm();
      paramObject = new com.tencent.mm.plugin.thumbplayer.a.b("voip_bad_net_sound", c.gOo(), "", 0, 0);
      paramObject.hJv = true;
      paramObject = new com.tencent.mm.plugin.ringtone.g.d(paramObject);
      AppMethodBeat.o(272849);
      return paramObject;
      label449:
      paramObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
      paramObject = d.a.gOF();
      AppMethodBeat.o(272849);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>, Object>
  {
    int label;
    
    c(com.tencent.mm.plugin.ringtone.a.b paramb, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272856);
      paramObject = (kotlin.d.d)new c(this.OBw, paramd);
      AppMethodBeat.o(272856);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272852);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272852);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.OBw.OBS;
      if (paramObject == null)
      {
        paramObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
        paramObject = d.a.gOF();
        AppMethodBeat.o(272852);
        return paramObject;
      }
      AppMethodBeat.o(272852);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.c
 * JD-Core Version:    0.7.0.1
 */