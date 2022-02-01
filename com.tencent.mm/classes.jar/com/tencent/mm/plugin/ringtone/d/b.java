package com.tencent.mm.plugin.ringtone.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.plugin.ringtone.i.a.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.plugin.ringtone.g.d;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/feed/RingtoneDetailCacheLogic;", "", "()V", "cacheRingtoneItem", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "", "getByHashCode", "hashCode", "loadByHashCode", "desc", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFinderResource", "onAddRingtone", "", "info", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b OCt;
  private static final Map<Long, com.tencent.mm.plugin.ringtone.g.d> OCu;
  
  static
  {
    AppMethodBeat.i(273147);
    OCt = new b();
    OCu = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(273147);
  }
  
  public static final void a(long paramLong, com.tencent.mm.plugin.ringtone.g.d paramd)
  {
    AppMethodBeat.i(273133);
    s.u(paramd, "info");
    Map localMap1 = OCu;
    s.s(localMap1, "cacheRingtoneItem");
    try
    {
      Map localMap2 = OCu;
      s.s(localMap2, "cacheRingtoneItem");
      localMap2.put(Long.valueOf(paramLong), paramd);
      paramd = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(273133);
    }
  }
  
  public static final com.tencent.mm.plugin.ringtone.g.d tK(long paramLong)
  {
    AppMethodBeat.i(273139);
    Map localMap = OCu;
    s.s(localMap, "cacheRingtoneItem");
    try
    {
      com.tencent.mm.plugin.ringtone.g.d locald = (com.tencent.mm.plugin.ringtone.g.d)OCu.get(Long.valueOf(paramLong));
      return locald;
    }
    finally
    {
      AppMethodBeat.o(273139);
    }
  }
  
  public final Object a(com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d> paramd1)
  {
    AppMethodBeat.i(273158);
    Object localObject;
    if ((paramd1 instanceof a))
    {
      localObject = (a)paramd1;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>)localObject;; paramd1 = new a(this, paramd1))
    {
      localObject = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273158);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramd != null)
    {
      localObject = paramd.ODy;
      if ((localObject != null) && (((aa)localObject).vhJ == 2)) {
        i = 1;
      }
      while (i != 0) {
        if (paramd.ODw == null)
        {
          localObject = OCt;
          paramd1.label = 1;
          paramd1 = ((b)localObject).b(paramd, paramd1);
          paramd = paramd1;
          if (paramd1 == locala)
          {
            AppMethodBeat.o(273158);
            return locala;
            i = 0;
            continue;
            ResultKt.throwOnFailure(localObject);
            paramd = (com.tencent.mm.plugin.ringtone.g.d)localObject;
          }
          else
          {
            paramd = (com.tencent.mm.plugin.ringtone.g.d)paramd;
            AppMethodBeat.o(273158);
            return paramd;
          }
        }
        else
        {
          AppMethodBeat.o(273158);
          return paramd;
        }
      }
      paramd1 = paramd.ODy;
      if ((paramd1 != null) && (paramd1.vhJ == 1)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(273158);
        return paramd;
      }
      AppMethodBeat.o(273158);
      return null;
    }
    AppMethodBeat.o(273158);
    return paramd;
  }
  
  public final Object b(com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d> paramd1)
  {
    AppMethodBeat.i(273179);
    if ((paramd1 instanceof b))
    {
      localObject1 = (b)paramd1;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    for (paramd1 = (kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>)localObject1;; paramd1 = new b(this, paramd1))
    {
      localObject1 = paramd1.result;
      localObject3 = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273179);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = paramd.ODy;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((aa)localObject1).acjs)
    {
      AppMethodBeat.o(273179);
      return null;
    }
    localObject1 = ((c)localObject1).aciR;
    if (localObject1 == null)
    {
      AppMethodBeat.o(273179);
      return null;
    }
    Object localObject2 = PluginRingtone.OBl;
    long l = ((com.tencent.mm.protocal.protobuf.a.b)localObject1).aacf;
    localObject2 = ((com.tencent.mm.protocal.protobuf.a.b)localObject1).aacg;
    paramd1.L$0 = paramd;
    paramd1.Uf = localObject1;
    paramd1.label = 1;
    localObject2 = com.tencent.mm.plugin.ringtone.i.a.getRingBackFromFinder(l, (String)localObject2, paramd1);
    if (localObject2 == localObject3)
    {
      AppMethodBeat.o(273179);
      return localObject3;
      paramd = (com.tencent.mm.protocal.protobuf.a.b)paramd1.Uf;
      localObject2 = (com.tencent.mm.plugin.ringtone.g.d)paramd1.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramd1 = paramd;
      paramd = (com.tencent.mm.plugin.ringtone.g.d)localObject2;
    }
    for (;;)
    {
      localObject1 = (a.a)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((a.a)localObject1).ABJ;
        if (localObject2 == null)
        {
          AppMethodBeat.o(273179);
          return null;
        }
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).media;
          if (localObject2 != null)
          {
            localObject2 = (FinderMedia)p.oL((List)localObject2);
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.ringtone.g.d.ODu;
              localObject1 = d.a.a(0L, ((FinderMedia)localObject2).videoDuration * 1000L, ((a.a)localObject1).ABJ, paramd1.aacf, ((a.a)localObject1).ABJ + '_' + paramd1.aacg, 80);
              localObject2 = paramd.nUM;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.ringtone.g.d)localObject1).nUM = ((String)localObject2);
              }
              localObject2 = paramd.ODz;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODz = ((String)localObject2);
              }
              localObject2 = paramd.ODA;
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODA = ((String)localObject2);
              }
              ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODy = paramd.ODy;
              ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODD = paramd.ODD;
              a(paramd1.aacf, (com.tencent.mm.plugin.ringtone.g.d)localObject1);
              AppMethodBeat.o(273179);
              return localObject1;
            }
          }
        }
      }
      AppMethodBeat.o(273179);
      return null;
      paramd1 = (kotlin.d.d<? super com.tencent.mm.plugin.ringtone.g.d>)localObject1;
      localObject1 = localObject2;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(b paramb, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273134);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.OCv.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(273134);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273123);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.OCv.b(null, (kotlin.d.d)this);
      AppMethodBeat.o(273123);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.d.b
 * JD-Core Version:    0.7.0.1
 */