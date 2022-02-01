package com.tencent.mm.plugin.ringtone.uic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.f.f;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneGlobalDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mGlobalRingtoneDataReady", "Landroidx/lifecycle/MutableLiveData;", "", "getMGlobalRingtoneDataReady", "()Landroidx/lifecycle/MutableLiveData;", "setMGlobalRingtoneDataReady", "(Landroidx/lifecycle/MutableLiveData;)V", "mGlobalRingtoneInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "getMGlobalRingtoneInfo", "()Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "setMGlobalRingtoneInfo", "(Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;)V", "deleteRingtone", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResume", "", "replaceRingtone", "info", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSelfRingtoneRemote", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final e.a OFe;
  com.tencent.mm.plugin.ringtone.g.d OFf;
  x<Integer> OFg;
  
  static
  {
    AppMethodBeat.i(273399);
    OFe = new e.a((byte)0);
    AppMethodBeat.o(273399);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273385);
    this.OFg = new x();
    AppMethodBeat.o(273385);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273409);
    super.onResume();
    this.OFf = com.tencent.mm.plugin.ringtone.d.gOq();
    this.OFg.t(Integer.valueOf(2));
    j.a(getLifecycleScope(), null, null, (kotlin.g.a.m)new c(this, null), 3);
    AppMethodBeat.o(273409);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(e parame, kotlin.d.d<? super Boolean> paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273404);
      paramObject = (kotlin.d.d)new b(this.OFh, this.nXT, paramd);
      AppMethodBeat.o(273404);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool = true;
      AppMethodBeat.i(273395);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273395);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.plugin.ringtone.d.gOq();
        localObject1 = PluginRingtone.OBl;
        localObject1 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = PluginRingtone.a.a(2, 1, 0, 0L, "", 0, 0, (kotlin.d.d)localObject1);
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(273395);
          return localObject2;
        }
        break;
      case 1: 
        localObject2 = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        e locale = this.OFh;
        localObject2 = this.nXT;
        int i;
        if (((Boolean)localObject1).booleanValue())
        {
          com.tencent.mm.plugin.ringtone.d.b("", null);
          if ((paramObject.ODD != null) && (paramObject.gOD().fileName != null) && (com.tencent.mm.plugin.au.b.b.a(paramObject.gOD())))
          {
            i = 1;
            localObject1 = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.ui.component.k.d(locale.getActivity()).q(n.class);
            if (i == 0) {
              break label273;
            }
            label216:
            n.b(paramObject, null, bool);
            paramObject = com.tencent.mm.model.z.bAM();
            s.s(paramObject, "getUsernameFromUserInfo()");
            com.tencent.mm.plugin.ringtone.d.a(paramObject, null);
            paramObject = Boolean.TRUE;
            localObject1 = Result.Companion;
            ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(paramObject));
          }
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(273395);
          return paramObject;
          i = 0;
          break;
          label273:
          bool = false;
          break label216;
          paramObject = Boolean.FALSE;
          localObject1 = Result.Companion;
          ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(paramObject));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(e parame, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273367);
      paramObject = (kotlin.d.d)new c(this.OFh, paramd);
      AppMethodBeat.o(273367);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273350);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273350);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      e.a(this.OFh);
      paramObject = ah.aiuX;
      AppMethodBeat.o(273350);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(com.tencent.mm.protocal.protobuf.a.z paramz, kotlin.d.d<? super Boolean> paramd, kotlin.d.d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273340);
      paramObject = (kotlin.d.d)new d(this.OFi, this.nXT, paramd);
      AppMethodBeat.o(273340);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273332);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273332);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = PluginRingtone.OBl;
        paramObject = this.OFi;
        int i = this.OFi.abaj;
        int j = this.OFi.abak;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = PluginRingtone.a.saveGlobalRingtone(1, 1, paramObject, i, j, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(273332);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = this.nXT;
      if (((Boolean)paramObject).booleanValue())
      {
        paramObject = Boolean.TRUE;
        localObject2 = Result.Companion;
        ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(paramObject));
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(273332);
        return paramObject;
        paramObject = Boolean.FALSE;
        localObject2 = Result.Companion;
        ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(paramObject));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(e parame, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273353);
      paramObject = (kotlin.d.d)new e(this.OFh, paramd);
      AppMethodBeat.o(273353);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(273343);
      Object localObject3 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273343);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1;
      try
      {
        paramObject = (com.tencent.mm.am.b)new f();
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject1);
        localObject1 = paramObject;
        if (paramObject == localObject3)
        {
          AppMethodBeat.o(273343);
          return localObject3;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (com.tencent.mm.protocal.protobuf.a.m)localObject1;
      }
      catch (Exception paramObject)
      {
        com.tencent.mm.protocal.protobuf.a.a locala;
        for (;;)
        {
          Log.e("SimpleUIComponent", "GetSearchRingBackCgi failed in RingtoneSearchMgr");
          paramObject = null;
          continue;
          label221:
          paramObject = Integer.valueOf(paramObject.vhJ);
          continue;
          label232:
          switch (paramObject.intValue())
          {
          default: 
            paramObject = d.a.gOF();
            break;
          case 1: 
            paramObject = locala.aciQ;
            if (paramObject == null) {
              paramObject = null;
            } else {
              paramObject = d.a.a(locala.abaj, locala.abak, paramObject);
            }
            break;
          case 2: 
            paramObject = locala.aciQ;
            if (paramObject == null)
            {
              paramObject = null;
            }
            else
            {
              localObject1 = paramObject.acjs;
              if (localObject1 != null) {
                break label331;
              }
              paramObject = null;
            }
            break;
          }
        }
        label331:
        localObject1 = d.a.a((c)localObject1, paramObject);
        ((com.tencent.mm.plugin.ringtone.g.d)localObject1).mEndTime = locala.abak;
        ((com.tencent.mm.plugin.ringtone.g.d)localObject1).mStartTime = locala.abaj;
        paramObject = locala.aciQ;
        if (paramObject != null) {
          break label379;
        }
        label379:
        for (paramObject = null;; paramObject = paramObject.acju)
        {
          ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODD = paramObject;
          paramObject = localObject1;
          break;
        }
        label387:
        paramObject.ODy = locala.aciQ;
        localObject1 = locala.aciQ;
        if (localObject1 != null) {
          break label461;
        }
      }
      if (paramObject != null)
      {
        localObject3 = this.OFh;
        com.tencent.mm.plugin.ringtone.d.BM(paramObject.acjf);
        locala = paramObject.acje;
        if (locala != null)
        {
          paramObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
          s.u(locala, "extRingBackDetail");
          paramObject = locala.aciQ;
          if (paramObject != null) {
            break label221;
          }
          paramObject = null;
          if (paramObject != null) {
            break label232;
          }
          paramObject = null;
          if (paramObject != null) {
            break label387;
          }
          paramObject = localObject2;
          ((e)localObject3).OFf = paramObject;
          ((e)localObject3).OFg.t(Integer.valueOf(1));
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273343);
      return paramObject;
      label461:
      for (boolean bool = false;; bool = ((aa)localObject1).acjt)
      {
        paramObject.OBU = bool;
        localObject1 = com.tencent.mm.model.z.bAM();
        s.s(localObject1, "getUsernameFromUserInfo()");
        com.tencent.mm.plugin.ringtone.d.a((String)localObject1, paramObject);
        j.a(((e)localObject3).getLifecycleScope(), null, null, (kotlin.g.a.m)new a((e)localObject3, paramObject, null), 3);
        localObject1 = ah.aiuX;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      Object L$0;
      Object Uf;
      int label;
      
      a(e parame, com.tencent.mm.plugin.ringtone.g.d paramd, kotlin.d.d<? super a> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(273459);
        paramObject = (kotlin.d.d)new a(this.OFh, paramObject, paramd);
        AppMethodBeat.o(273459);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(273453);
        Object localObject2 = kotlin.d.a.a.aiwj;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(273453);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.plugin.ringtone.d.a.OCq;
          long l = com.tencent.mm.model.z.bAM().hashCode();
          localObject1 = this.OFh.OFf;
          localObject3 = (kotlin.d.d)this;
          this.label = 1;
          localObject1 = paramObject.a(l, (com.tencent.mm.plugin.ringtone.g.d)localObject1, (kotlin.d.d)localObject3);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(273453);
            return localObject2;
          }
        case 1: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (com.tencent.mm.plugin.ringtone.g.d)paramObject;
          if (paramObject == null)
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(273453);
            return paramObject;
          }
          if (this.OFh.OFf == null) {
            break label320;
          }
          localObject3 = paramObject;
          localObject1 = this.OFh;
          localObject3 = ((com.tencent.mm.plugin.ringtone.g.d)localObject3).ODy;
          if (localObject3 == null) {}
          for (boolean bool = false;; bool = ((aa)localObject3).acjt)
          {
            paramObject.OBU = bool;
            com.tencent.mm.plugin.ringtone.d.a.a(com.tencent.mm.model.z.bAM().hashCode(), paramObject);
            localObject3 = com.tencent.mm.plugin.ringtone.d.OBx;
            this.L$0 = paramObject;
            this.Uf = localObject1;
            this.label = 2;
            if (((com.tencent.mm.plugin.ringtone.d)localObject3).a("", paramObject, this) != localObject2) {
              break;
            }
            AppMethodBeat.o(273453);
            return localObject2;
          }
        }
        Object localObject1 = (e)this.Uf;
        localObject2 = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.model.z.bAM();
          s.s(localObject2, "getUsernameFromUserInfo()");
          com.tencent.mm.plugin.ringtone.d.a((String)localObject2, paramObject);
          com.tencent.mm.plugin.ringtone.d.b("", paramObject);
          ((e)localObject1).OFf = paramObject;
          ((e)localObject1).OFg.t(Integer.valueOf(1));
          label320:
          paramObject = ah.aiuX;
          AppMethodBeat.o(273453);
          return paramObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.e
 * JD-Core Version:    0.7.0.1
 */