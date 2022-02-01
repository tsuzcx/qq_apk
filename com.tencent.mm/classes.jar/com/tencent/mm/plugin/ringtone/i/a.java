package com.tencent.mm.plugin.ringtone.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.ringtone.f.g;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.ae;
import com.tencent.mm.protocal.protobuf.a.i;
import com.tencent.mm.protocal.protobuf.a.j;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ringtone/RingtoneSettingHelper;", "", "()V", "TAG", "", "checkCommonRingtoneHasBeenSet", "", "checkExclusiveHasBeenSet", "checkRemoteCheckCallmeListenSwitch", "checkSelfHasRingtone", "getRingBackFromFinder", "Lcom/tencent/mm/plugin/ringtone/ringtone/RingtoneSettingHelper$FinderObjectDesc;", "finderObjectId", "", "finderNonceId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingBackPlayInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "username", "isOutCall", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingBackPlayInfoParseByRingBackDetail", "ringback", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetFriendRingBackRespFriendRingBackInfo;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/GetFriendRingBackRespFriendRingBackInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetFriendRingBackRespGlobalRingBackInfo;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/GetFriendRingBackRespGlobalRingBackInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRingBackPlayInfoSelfRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveExclusiveRingtone", "opType", "", "setRingBackType", "startTs", "endTs", "musicSid", "(IIJLjava/lang/String;IILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNormalPersonalityRingtone", "ringtoneType", "(IIIJLjava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRingtoneCommon", "FinderObjectDesc", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ODH;
  
  static
  {
    AppMethodBeat.i(273538);
    ODH = new a();
    AppMethodBeat.o(273538);
  }
  
  public static Object a(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, int paramInt5, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(273523);
    Log.i("MicroMsg.RingtoneSettingHelper", "saveNormalPersonalityRingtone: useRingtone=" + paramInt2 + ", objectId=" + paramLong + ", nonceId=" + paramString + ", start=" + paramInt4 + ", end=" + paramInt5 + ",musicUrl=" + paramInt3);
    paramString = b(paramInt1, paramInt2, paramLong, paramString, paramInt4, paramInt5, null, paramInt3, paramd);
    AppMethodBeat.o(273523);
    return paramString;
  }
  
  public static Object a(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(273527);
    Log.i("MicroMsg.RingtoneSettingHelper", "saveExclusiveRingtone: useRingtone=" + paramInt2 + ", objectId=" + paramLong + ", nonceId=" + paramString1 + ", start=" + paramInt3 + ", end=" + paramInt4 + ", username=" + paramString2 + ",musicUrl =" + paramInt5);
    paramString1 = b(paramInt1, paramInt2, paramLong, paramString1, paramInt3, paramInt4, paramString2, paramInt5, paramd);
    AppMethodBeat.o(273527);
    return paramString1;
  }
  
  public static final Object a(i parami, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b> paramd)
  {
    AppMethodBeat.i(273506);
    parami = l.a((f)bg.kCi(), (m)new d(parami, null), paramd);
    AppMethodBeat.o(273506);
    return parami;
  }
  
  public static final Object a(j paramj, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b> paramd)
  {
    AppMethodBeat.i(273510);
    paramj = l.a((f)bg.kCi(), (m)new e(paramj, null), paramd);
    AppMethodBeat.o(273510);
    return paramj;
  }
  
  public static final Object am(kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b> paramd)
  {
    AppMethodBeat.i(273503);
    paramd = l.a((f)bg.kCi(), (m)new f(null), paramd);
    AppMethodBeat.o(273503);
    return paramd;
  }
  
  private static Object b(int paramInt1, final int paramInt2, final long paramLong, String paramString1, final int paramInt3, final int paramInt4, final String paramString2, final int paramInt5, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(273535);
    paramString1 = l.a((f)bg.kCi(), (m)new g(paramInt1, paramInt2, paramLong, paramString1, paramInt3, paramInt4, paramString2, paramInt5, null), paramd);
    AppMethodBeat.o(273535);
    return paramString1;
  }
  
  public static final boolean gOG()
  {
    AppMethodBeat.i(273475);
    String str = com.tencent.mm.model.z.bAM();
    s.s(str, "getUsernameFromUserInfo()");
    if (com.tencent.mm.plugin.ringtone.d.aUs(str) != null)
    {
      AppMethodBeat.o(273475);
      return true;
    }
    AppMethodBeat.o(273475);
    return false;
  }
  
  public static final boolean gOH()
  {
    AppMethodBeat.i(273484);
    boolean bool = com.tencent.mm.plugin.ringtone.d.gOr();
    AppMethodBeat.o(273484);
    return bool;
  }
  
  public static final boolean gOI()
  {
    AppMethodBeat.i(273495);
    boolean bool = com.tencent.mm.plugin.ringtone.d.gOp();
    AppMethodBeat.o(273495);
    return bool;
  }
  
  public static final boolean gOJ()
  {
    AppMethodBeat.i(273502);
    List localList = com.tencent.mm.plugin.ringtone.d.gOs();
    if (localList == null)
    {
      AppMethodBeat.o(273502);
      return false;
    }
    if (!((Collection)localList).isEmpty())
    {
      AppMethodBeat.o(273502);
      return true;
    }
    AppMethodBeat.o(273502);
    return false;
  }
  
  public static final Object getRingBackFromFinder(long paramLong, String paramString, kotlin.d.d<? super a> paramd)
  {
    AppMethodBeat.i(273468);
    paramString = l.a((f)bg.kCi(), (m)new b(paramLong, paramString, null), paramd);
    AppMethodBeat.o(273468);
    return paramString;
  }
  
  public static final Object getRingBackPlayInfo(String paramString, final boolean paramBoolean, kotlin.d.d<? super r<? extends com.tencent.mm.plugin.ringtone.g.c, ? extends com.tencent.mm.plugin.ringtone.a.b>> paramd)
  {
    AppMethodBeat.i(273518);
    paramString = l.a((f)bg.kCi(), (m)new c(paramString, paramBoolean, null), paramd);
    AppMethodBeat.o(273518);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ringtone/RingtoneSettingHelper$FinderObjectDesc;", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "unAvailable", "", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;Z)V", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getUnAvailable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final FinderObject ABJ;
    public final boolean OBU;
    
    public a(FinderObject paramFinderObject, boolean paramBoolean)
    {
      this.ABJ = paramFinderObject;
      this.OBU = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(273489);
      if (this == paramObject)
      {
        AppMethodBeat.o(273489);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(273489);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.ABJ, paramObject.ABJ))
      {
        AppMethodBeat.o(273489);
        return false;
      }
      if (this.OBU != paramObject.OBU)
      {
        AppMethodBeat.o(273489);
        return false;
      }
      AppMethodBeat.o(273489);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273471);
      String str = "FinderObjectDesc(finderObject=" + this.ABJ + ", unAvailable=" + this.OBU + ')';
      AppMethodBeat.o(273471);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/ringtone/RingtoneSettingHelper$FinderObjectDesc;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super a.a>, Object>
  {
    int label;
    
    b(long paramLong, String paramString, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273482);
      paramObject = (kotlin.d.d)new b(this.ODI, this.ODJ, paramd);
      AppMethodBeat.o(273482);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273474);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273474);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (this.ODI == 0L)
      {
        AppMethodBeat.o(273474);
        return null;
      }
      localObject = ((cn)h.az(cn.class)).getFinderUtilApi().J(this.ODI, this.ODJ);
      paramObject = (Boolean)((r)localObject).bsC;
      localObject = (FinderObject)((r)localObject).bsD;
      s.s(paramObject, "first");
      paramObject = new a.a((FinderObject)localObject, paramObject.booleanValue());
      AppMethodBeat.o(273474);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/ringtone/params/RingtoneSource;", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super r<? extends com.tencent.mm.plugin.ringtone.g.c, ? extends com.tencent.mm.plugin.ringtone.a.b>>, Object>
  {
    Object L$0;
    int label;
    
    c(String paramString, boolean paramBoolean, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273477);
      paramObject = (kotlin.d.d)new c(this.mrr, paramBoolean, paramd);
      AppMethodBeat.o(273477);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273469);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273469);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.ringtone.f.b(this.mrr, paramBoolean);
        Object localObject1 = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject1);
        localObject1 = paramObject;
        if (paramObject == locala)
        {
          AppMethodBeat.o(273469);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject1 = (com.tencent.mm.protocal.protobuf.a.k)localObject1;
        paramObject = ((com.tencent.mm.protocal.protobuf.a.k)localObject1).acjd;
        Object localObject2 = ((com.tencent.mm.protocal.protobuf.a.k)localObject1).acjc;
        Log.i("MicroMsg.RingtoneSettingHelper", "getRingBackPlayInfo name:" + this.mrr + ", global:" + paramObject + ", friend:" + localObject2);
        localObject1 = paramObject;
        if (localObject2 != null)
        {
          localObject1 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 2;
          localObject1 = a.a((i)localObject2, (kotlin.d.d)localObject1);
          localObject2 = localObject1;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(273469);
            return locala;
            localObject2 = (j)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject1;
          }
          localObject2 = (com.tencent.mm.plugin.ringtone.a.b)localObject2;
          if (localObject2 == null) {}
          for (localObject1 = null;; localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.ringtone.a.b)localObject2).isValid()))
          {
            Log.i("MicroMsg.RingtoneSettingHelper", s.X("friendPlayInfo isValid:", localObject1));
            localObject1 = paramObject;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramObject;
            if (!((com.tencent.mm.plugin.ringtone.a.b)localObject2).isValid()) {
              break;
            }
            paramObject = new r(com.tencent.mm.plugin.ringtone.g.c.ODs, localObject2);
            AppMethodBeat.o(273469);
            return paramObject;
          }
        }
        if (localObject1 != null)
        {
          paramObject = (kotlin.d.d)this;
          this.L$0 = null;
          this.label = 3;
          paramObject = a.a((j)localObject1, paramObject);
          localObject1 = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(273469);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
          }
          localObject1 = (com.tencent.mm.plugin.ringtone.a.b)localObject1;
          if (localObject1 == null) {}
          for (paramObject = null;; paramObject = Boolean.valueOf(((com.tencent.mm.plugin.ringtone.a.b)localObject1).isValid()))
          {
            Log.i("MicroMsg.RingtoneSettingHelper", s.X("globalPlayInfo isValid:", paramObject));
            if ((localObject1 == null) || (!((com.tencent.mm.plugin.ringtone.a.b)localObject1).isValid())) {
              break;
            }
            paramObject = new r(com.tencent.mm.plugin.ringtone.g.c.ODr, localObject1);
            AppMethodBeat.o(273469);
            return paramObject;
          }
        }
        paramObject = new r(com.tencent.mm.plugin.ringtone.g.c.ODq, null);
        AppMethodBeat.o(273469);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.e("MicroMsg.RingtoneSettingHelper", s.X("getRingBackPlayInfo error:", paramObject.getLocalizedMessage()));
        paramObject = new r(com.tencent.mm.plugin.ringtone.g.c.ODp, null);
        AppMethodBeat.o(273469);
      }
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b>, Object>
  {
    Object L$0;
    int aai;
    int asI;
    int label;
    
    d(i parami, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273479);
      paramObject = (kotlin.d.d)new d(this.ODK, paramd);
      AppMethodBeat.o(273479);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273470);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int k;
      int j;
      Object localObject1;
      int i;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273470);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ODK.aciQ;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.vhJ))
        {
          AppMethodBeat.o(273470);
          return null;
        }
        int m = paramObject.intValue();
        paramObject = this.ODK.aciX;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.abaj))
        {
          AppMethodBeat.o(273470);
          return null;
        }
        k = paramObject.intValue();
        paramObject = this.ODK.aciX;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.abak))
        {
          AppMethodBeat.o(273470);
          return null;
        }
        j = paramObject.intValue();
        paramObject = this.ODK.aciQ;
        if (paramObject == null)
        {
          AppMethodBeat.o(273470);
          return null;
        }
        localObject1 = this.ODK.aciQ;
        if ((localObject1 != null) && (((aa)localObject1).acjt == true)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(273470);
          return null;
        }
        if (m == 2)
        {
          localObject2 = paramObject.acjs;
          if (localObject2 == null)
          {
            AppMethodBeat.o(273470);
            return null;
          }
          paramObject = ((com.tencent.mm.protocal.protobuf.a.c)localObject2).aciR;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = kotlin.d.b.a.b.BF(paramObject.aacf))
          {
            AppMethodBeat.o(273470);
            return null;
          }
          long l = paramObject.longValue();
          paramObject = ((com.tencent.mm.protocal.protobuf.a.c)localObject2).aciR;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = paramObject.aacg)
          {
            AppMethodBeat.o(273470);
            return null;
          }
          localObject1 = (kotlin.d.d)this;
          this.L$0 = localObject2;
          this.aai = k;
          this.asI = j;
          this.label = 1;
          localObject1 = a.getRingBackFromFinder(l, paramObject, (kotlin.d.d)localObject1);
          if (localObject1 != locala) {
            break label541;
          }
          AppMethodBeat.o(273470);
          return locala;
        }
        break;
      case 1: 
        j = this.asI;
        i = this.aai;
        localObject2 = (com.tencent.mm.protocal.protobuf.a.c)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
      }
      for (paramObject = localObject2;; paramObject = localObject2)
      {
        localObject1 = (a.a)localObject1;
        if (localObject1 == null)
        {
          AppMethodBeat.o(273470);
          return null;
        }
        localObject2 = com.tencent.mm.plugin.ringtone.g.d.ODu;
        paramObject = d.a.a(i, j, paramObject, ((a.a)localObject1).ABJ);
        if (paramObject == null) {}
        for (boolean bool = false;; bool = paramObject.OBU)
        {
          paramObject = new com.tencent.mm.plugin.ringtone.a.b(2, i, j, bool, paramObject);
          AppMethodBeat.o(273470);
          return paramObject;
        }
        localObject1 = com.tencent.mm.plugin.ringtone.g.d.ODu;
        paramObject = d.a.a(k, j, paramObject);
        if (paramObject == null)
        {
          AppMethodBeat.o(273470);
          return null;
        }
        paramObject = new com.tencent.mm.plugin.ringtone.a.b(1, k, j, false, paramObject);
        AppMethodBeat.o(273470);
        return paramObject;
        label541:
        i = k;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b>, Object>
  {
    Object L$0;
    int aai;
    int asI;
    int label;
    
    e(j paramj, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273491);
      paramObject = (kotlin.d.d)new e(this.ODL, paramd);
      AppMethodBeat.o(273491);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273480);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int k;
      int j;
      Object localObject1;
      int i;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273480);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ODL.aciQ;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.vhJ))
        {
          AppMethodBeat.o(273480);
          return null;
        }
        int m = paramObject.intValue();
        paramObject = this.ODL.aciX;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.abaj))
        {
          AppMethodBeat.o(273480);
          return null;
        }
        k = paramObject.intValue();
        paramObject = this.ODL.aciX;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = Integer.valueOf(paramObject.abak))
        {
          AppMethodBeat.o(273480);
          return null;
        }
        j = paramObject.intValue();
        paramObject = this.ODL.aciQ;
        if (paramObject == null)
        {
          AppMethodBeat.o(273480);
          return null;
        }
        localObject1 = this.ODL.aciQ;
        if ((localObject1 != null) && (((aa)localObject1).acjt == true)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(273480);
          return null;
        }
        if (m == 2)
        {
          localObject2 = paramObject.acjs;
          if (localObject2 == null)
          {
            AppMethodBeat.o(273480);
            return null;
          }
          paramObject = ((com.tencent.mm.protocal.protobuf.a.c)localObject2).aciR;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = kotlin.d.b.a.b.BF(paramObject.aacf))
          {
            AppMethodBeat.o(273480);
            return null;
          }
          long l = paramObject.longValue();
          paramObject = ((com.tencent.mm.protocal.protobuf.a.c)localObject2).aciR;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = paramObject.aacg)
          {
            AppMethodBeat.o(273480);
            return null;
          }
          localObject1 = (kotlin.d.d)this;
          this.L$0 = localObject2;
          this.aai = k;
          this.asI = j;
          this.label = 1;
          localObject1 = a.getRingBackFromFinder(l, paramObject, (kotlin.d.d)localObject1);
          if (localObject1 != locala) {
            break label541;
          }
          AppMethodBeat.o(273480);
          return locala;
        }
        break;
      case 1: 
        j = this.asI;
        i = this.aai;
        localObject2 = (com.tencent.mm.protocal.protobuf.a.c)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
      }
      for (paramObject = localObject2;; paramObject = localObject2)
      {
        localObject1 = (a.a)localObject1;
        if (localObject1 == null)
        {
          AppMethodBeat.o(273480);
          return null;
        }
        localObject2 = com.tencent.mm.plugin.ringtone.g.d.ODu;
        paramObject = d.a.a(i, j, paramObject, ((a.a)localObject1).ABJ);
        if (paramObject == null) {}
        for (boolean bool = false;; bool = paramObject.OBU)
        {
          paramObject = new com.tencent.mm.plugin.ringtone.a.b(2, i, j, bool, paramObject);
          AppMethodBeat.o(273480);
          return paramObject;
        }
        localObject1 = com.tencent.mm.plugin.ringtone.g.d.ODu;
        paramObject = d.a.a(k, j, paramObject);
        if (paramObject == null)
        {
          AppMethodBeat.o(273480);
          return null;
        }
        paramObject = new com.tencent.mm.plugin.ringtone.a.b(1, k, j, false, paramObject);
        AppMethodBeat.o(273480);
        return paramObject;
        label541:
        i = k;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/ringtone/api/RingBackPlayInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.a.b>, Object>
  {
    Object L$0;
    int label;
    
    f(kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273485);
      paramObject = (kotlin.d.d)new f(paramd);
      AppMethodBeat.o(273485);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273476);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      com.tencent.mm.plugin.ringtone.g.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273476);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (!a.gOG()) {
          break label510;
        }
        paramObject = com.tencent.mm.model.z.bAM();
        s.s(paramObject, "getUsernameFromUserInfo()");
        locald = com.tencent.mm.plugin.ringtone.d.aUs(paramObject);
        if (locald == null)
        {
          AppMethodBeat.o(273476);
          return null;
        }
        paramObject = locald.ODy;
        if (paramObject == null)
        {
          paramObject = null;
          if (paramObject != null) {
            break label129;
          }
          label107:
          if (paramObject != null) {
            break label404;
          }
        }
        break;
      }
      label129:
      label404:
      while (paramObject.intValue() != 1)
      {
        AppMethodBeat.o(273476);
        return null;
        paramObject = Integer.valueOf(paramObject.vhJ);
        break;
        if (paramObject.intValue() != 2) {
          break label107;
        }
        paramObject = locald.ODy;
        if (paramObject == null) {
          paramObject = null;
        }
        while (paramObject == null)
        {
          AppMethodBeat.o(273476);
          return null;
          paramObject = paramObject.acjs;
          if (paramObject == null)
          {
            paramObject = null;
          }
          else
          {
            paramObject = paramObject.aciR;
            if (paramObject == null) {
              paramObject = null;
            } else {
              paramObject = kotlin.d.b.a.b.BF(paramObject.aacf);
            }
          }
        }
        long l = paramObject.longValue();
        paramObject = locald.ODy;
        if (paramObject == null) {
          paramObject = null;
        }
        while (paramObject == null)
        {
          AppMethodBeat.o(273476);
          return null;
          paramObject = paramObject.acjs;
          if (paramObject == null)
          {
            paramObject = null;
          }
          else
          {
            paramObject = paramObject.aciR;
            if (paramObject == null) {
              paramObject = null;
            } else {
              paramObject = paramObject.aacg;
            }
          }
        }
        Object localObject1 = (kotlin.d.d)this;
        this.L$0 = locald;
        this.label = 1;
        Object localObject2 = a.getRingBackFromFinder(l, paramObject, (kotlin.d.d)localObject1);
        localObject1 = localObject2;
        paramObject = locald;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(273476);
          return locala;
          locald = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = locald;
        }
        localObject1 = (a.a)localObject1;
        if (localObject1 == null)
        {
          AppMethodBeat.o(273476);
          return null;
        }
        paramObject.ODw = ((a.a)localObject1).ABJ;
        if (paramObject.OBU)
        {
          AppMethodBeat.o(273476);
          return null;
        }
        paramObject = new com.tencent.mm.plugin.ringtone.a.b(2, (int)paramObject.mStartTime, (int)paramObject.mEndTime, ((a.a)localObject1).OBU, paramObject);
        AppMethodBeat.o(273476);
        return paramObject;
      }
      paramObject = locald.ODy;
      if (paramObject == null) {
        paramObject = null;
      }
      while (paramObject == null)
      {
        AppMethodBeat.o(273476);
        return null;
        paramObject = paramObject.acjr;
        if (paramObject == null)
        {
          paramObject = null;
        }
        else
        {
          paramObject = paramObject.acjj;
          if (paramObject == null) {
            paramObject = null;
          } else {
            paramObject = Integer.valueOf(paramObject.aaYO);
          }
        }
      }
      paramObject.intValue();
      paramObject = new com.tencent.mm.plugin.ringtone.a.b(1, (int)locald.mStartTime, (int)locald.mEndTime, false, locald);
      AppMethodBeat.o(273476);
      return paramObject;
      label510:
      AppMethodBeat.o(273476);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    
    g(int paramInt1, int paramInt2, long paramLong, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273493);
      paramObject = (kotlin.d.d)new g(this.ODM, paramInt2, paramLong, paramInt3, paramInt4, paramString2, paramInt5, this.ODQ, paramd);
      AppMethodBeat.o(273493);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273481);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      int k;
      Object localObject3;
      long l;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273481);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.RingtoneSettingHelper", "saveExclusiveRingtone: opType=" + this.ODM + " ,useRingtone=" + paramInt2 + ", objectId=" + paramLong + ", nonceId=" + paramInt3 + ", start=" + paramInt4 + ", end=" + paramString2 + ", username=" + paramInt5 + ",musicUrl = " + this.ODQ);
        paramObject = new ae();
        paramObject.muC = this.ODM;
        paramObject.vhJ = paramInt2;
        localObject1 = new com.tencent.mm.protocal.protobuf.a.z();
        int i = paramString2;
        int j = paramInt4;
        k = this.ODQ;
        localObject3 = paramInt3;
        l = paramLong;
        ((com.tencent.mm.protocal.protobuf.a.z)localObject1).abak = i;
        ((com.tencent.mm.protocal.protobuf.a.z)localObject1).abaj = j;
        if (k == 0) {
          ((com.tencent.mm.protocal.protobuf.a.z)localObject1).vhJ = 2;
        }
        break;
      }
      for (;;)
      {
        Object localObject2 = new com.tencent.mm.protocal.protobuf.a.b();
        ((com.tencent.mm.protocal.protobuf.a.b)localObject2).aacg = ((String)localObject3);
        ((com.tencent.mm.protocal.protobuf.a.b)localObject2).aacf = l;
        localObject3 = ah.aiuX;
        ((com.tencent.mm.protocal.protobuf.a.z)localObject1).acji = ((com.tencent.mm.protocal.protobuf.a.b)localObject2);
        localObject2 = new u();
        ((u)localObject2).aaYO = k;
        localObject3 = ah.aiuX;
        ((com.tencent.mm.protocal.protobuf.a.z)localObject1).acjh = ((u)localObject2);
        localObject2 = ah.aiuX;
        paramObject.aciX = ((com.tencent.mm.protocal.protobuf.a.z)localObject1);
        paramObject.UserName = paramInt5;
        try
        {
          paramObject = (com.tencent.mm.am.b)new g(paramObject);
          localObject1 = (kotlin.d.d)this;
          this.label = 1;
          paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject1);
          if (paramObject == locala)
          {
            AppMethodBeat.o(273481);
            return locala;
            ((com.tencent.mm.protocal.protobuf.a.z)localObject1).vhJ = 1;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            paramObject = Boolean.TRUE;
            AppMethodBeat.o(273481);
            return paramObject;
          }
        }
        catch (Exception paramObject)
        {
          Log.e("MicroMsg.RingtoneSettingHelper", "error happened in save ringtone ");
          paramObject = Boolean.FALSE;
          AppMethodBeat.o(273481);
        }
      }
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.i.a
 * JD-Core Version:    0.7.0.1
 */