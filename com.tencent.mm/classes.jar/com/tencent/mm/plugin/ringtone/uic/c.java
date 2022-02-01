package com.tencent.mm.plugin.ringtone.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.c.a.d;
import com.tencent.mm.plugin.ringtone.c.a.e;
import com.tencent.mm.plugin.ringtone.c.a.f;
import com.tencent.mm.plugin.ringtone.c.a.h;
import com.tencent.mm.plugin.ringtone.g.d.a.a;
import com.tencent.mm.protocal.protobuf.a.e;
import com.tencent.mm.protocal.protobuf.a.g;
import com.tencent.mm.protocal.protobuf.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveFlowUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_minSeq", "", "hasContinue", "", "mRingtoneDataSource", "Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;", "getMRingtoneDataSource", "()Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;", "setMRingtoneDataSource", "(Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;)V", "mRingtoneViewModel", "Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel;", "getMRingtoneViewModel", "()Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel;", "setMRingtoneViewModel", "(Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel;)V", "mUserSeqLists", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addRingtone", "username", "item", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/ringtone/RingBack;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRingtone", "", "loadMore", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "refreshDataSource", "temp", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public static final c.a OEM;
  private static String TAG;
  private long OEN;
  private ArrayList<String> OEO;
  com.tencent.mm.plugin.ringtone.c.a OEP;
  private com.tencent.mm.plugin.ringtone.e.a OEQ;
  private boolean pUl;
  
  static
  {
    AppMethodBeat.i(273387);
    OEM = new c.a((byte)0);
    TAG = "MicroMsg.RingtoneExclusiveDataUIC";
    AppMethodBeat.o(273387);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273324);
    this.OEN = -1L;
    this.pUl = true;
    this.OEO = new ArrayList();
    AppMethodBeat.o(273324);
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(273394);
    j.a(getLifecycleScope(), null, null, (m)new d(this, null), 3);
    AppMethodBeat.o(273394);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273401);
    super.onCreateAfter(paramBundle);
    this.OEQ = new com.tencent.mm.plugin.ringtone.e.a();
    paramBundle = this.OEQ;
    if (paramBundle != null) {
      this.OEP = new com.tencent.mm.plugin.ringtone.c.a(paramBundle);
    }
    AppMethodBeat.o(273401);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273422);
    super.onDestroy();
    Object localObject = this.OEQ;
    if (localObject != null) {
      ar.a(((com.tencent.mm.plugin.ringtone.e.a)localObject).OCJ, null);
    }
    localObject = this.OEP;
    if (localObject != null)
    {
      cb localcb = ((com.tencent.mm.plugin.ringtone.c.a)localObject).OCg;
      if (localcb != null) {
        localcb.a(null);
      }
      j.a(((com.tencent.mm.plugin.ringtone.c.a)localObject).OCd, null, null, (m)new a.d((com.tencent.mm.plugin.ringtone.c.a)localObject, null), 3);
      ar.a(((com.tencent.mm.plugin.ringtone.c.a)localObject).OCd, null);
    }
    AppMethodBeat.o(273422);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273412);
    super.onResume();
    com.tencent.mm.plugin.ringtone.c.a locala = this.OEP;
    if (locala != null) {
      locala.OCg = j.a(locala.OCd, null, null, (m)new a.e(locala, null), 3);
    }
    this.pUl = true;
    this.OEN = -1L;
    this.OEO.clear();
    aWi();
    AppMethodBeat.o(273412);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(z paramz, String paramString, kotlin.d.d<? super Boolean> paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273310);
      paramObject = (kotlin.d.d)new b(this.OER, this.mrr, this.nXT, paramd);
      AppMethodBeat.o(273310);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273307);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273307);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = PluginRingtone.OBl;
        paramObject = this.OER;
        int i = this.OER.abaj;
        int j = this.OER.abak;
        localObject1 = this.mrr;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = PluginRingtone.a.saveExclusiveRingtone(1, 3, paramObject, i, j, (String)localObject1, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(273307);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = this.OER;
        localObject2 = this.nXT;
        if (!((Boolean)paramObject).booleanValue()) {
          break label282;
        }
        paramObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
        this.L$0 = localObject2;
        this.label = 2;
        Object localObject3 = l.a((f)bg.kCi(), (m)new d.a.a((z)localObject1, null), this);
        localObject1 = localObject3;
        paramObject = localObject2;
        if (localObject3 != locala) {
          break label242;
        }
        AppMethodBeat.o(273307);
        return locala;
      }
      Object localObject2 = (kotlin.d.d)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = paramObject;
      paramObject = localObject2;
      label242:
      if ((com.tencent.mm.plugin.ringtone.g.d)localObject1 != null)
      {
        localObject1 = Boolean.TRUE;
        localObject2 = Result.Companion;
        paramObject.resumeWith(Result.constructor-impl(localObject1));
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(273307);
        return paramObject;
        label282:
        paramObject = Boolean.FALSE;
        localObject1 = Result.Companion;
        ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(paramObject));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(String paramString, c paramc, w paramw, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273312);
      paramObject = (kotlin.d.d)new c(this.mrr, this.OES, this.OEL, paramd);
      AppMethodBeat.o(273312);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      int i = 0;
      AppMethodBeat.i(273308);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273308);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.plugin.ringtone.d.aUs(this.mrr);
        localObject1 = PluginRingtone.OBl;
        localObject1 = this.mrr;
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = PluginRingtone.a.a(2, 3, 0L, null, 0, 0, (String)localObject1, (kotlin.d.d)localObject3);
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(273308);
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
        if (((Boolean)localObject1).booleanValue()) {
          i = 1;
        }
        localObject1 = this.mrr;
        localObject2 = this.OES;
        localObject3 = this.OEL;
        if (i != 0)
        {
          j.a(ar.kBZ(), null, null, (m)new a((w)localObject3, (c)localObject2, paramObject, (String)localObject1, null), 3);
          com.tencent.mm.plugin.ringtone.d.a((String)localObject1, null);
          paramObject = ((c)localObject2).OEP;
          if (paramObject != null)
          {
            s.u(localObject1, "username");
            paramObject.OCg = j.a(paramObject.OCd, null, null, (m)new a.h((String)localObject1, paramObject, null), 3);
          }
          com.tencent.mm.plugin.ringtone.d.b((String)localObject1, null);
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(273308);
          return paramObject;
          j.a(ar.kBZ(), null, null, (m)new b((w)localObject3, (c)localObject2, null), 3);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(w paramw, c paramc, com.tencent.mm.plugin.ringtone.g.d paramd, String paramString, kotlin.d.d<? super a> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(273287);
        paramObject = (kotlin.d.d)new a(this.OEL, this.OES, paramObject, this.mrr, paramd);
        AppMethodBeat.o(273287);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        boolean bool = true;
        AppMethodBeat.i(273282);
        Object localObject = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(273282);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.OEL;
        if (paramObject != null) {
          paramObject.hide();
        }
        aa.db((Context)this.OES.getActivity(), this.OES.getActivity().getResources().getString(b.f.delete_success));
        paramObject = paramObject;
        if (paramObject == null)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(273282);
          return paramObject;
        }
        int i;
        if ((paramObject.ODD != null) && (paramObject.gOD().fileName != null) && (com.tencent.mm.plugin.au.b.b.a(paramObject.gOD())))
        {
          i = 1;
          localObject = com.tencent.mm.ui.component.k.aeZF;
          com.tencent.mm.ui.component.k.d(this.OES.getActivity()).q(n.class);
          localObject = this.mrr;
          if (i == 0) {
            break label202;
          }
        }
        for (;;)
        {
          n.b(paramObject, (String)localObject, bool);
          paramObject = ah.aiuX;
          AppMethodBeat.o(273282);
          return paramObject;
          i = 0;
          break;
          label202:
          bool = false;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(w paramw, c paramc, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(273291);
        paramObject = (kotlin.d.d)new b(this.OEL, this.OES, paramd);
        AppMethodBeat.o(273291);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(273288);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(273288);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.OEL;
        if (paramObject != null) {
          paramObject.hide();
        }
        aa.dc((Context)this.OES.getActivity(), this.OES.getActivity().getResources().getString(b.f.delete_failed));
        paramObject = ah.aiuX;
        AppMethodBeat.o(273288);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(c paramc, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273348);
      paramObject = (kotlin.d.d)new d(this.OES, paramd);
      AppMethodBeat.o(273348);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273338);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273338);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (!c.a(this.OES))
        {
          paramObject = this.OES.OEP;
          if (paramObject != null) {
            paramObject.bp(c.b(this.OES));
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(273338);
          return paramObject;
        }
        break;
      }
      for (;;)
      {
        String str;
        Object localObject3;
        boolean bool;
        try
        {
          paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.ringtone.f.a(c.c(this.OES));
          Object localObject1 = (kotlin.d.d)this;
          this.label = 1;
          paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject1);
          localObject1 = paramObject;
          if (paramObject == localObject2)
          {
            AppMethodBeat.o(273338);
            return localObject2;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
          }
          localObject1 = (g)localObject1;
          c.a(this.OES, -1L);
          c.a(this.OES, ((g)localObject1).aavs);
          paramObject = new ArrayList();
          localObject1 = ((g)localObject1).acja;
          s.s(localObject1, "resp.Infos");
          localObject2 = (Iterable)localObject1;
          localObject1 = this.OES;
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          e locale = (e)((Iterator)localObject2).next();
          if ((c.c((c)localObject1) == -1L) || (c.c((c)localObject1) > locale.aciY)) {
            c.a((c)localObject1, locale.aciY);
          }
          str = locale.UserName;
          if (str == null) {
            continue;
          }
          localObject3 = (com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          if (localObject3 == null)
          {
            bool = false;
            if ((!bool) || (c.b((c)localObject1).contains(str))) {
              break label531;
            }
            Log.i(c.access$getTAG$cp(), s.X("ringtone username is ", str));
            c.b((c)localObject1).add(str);
            s.s(locale, "it");
            paramObject.add(new com.tencent.mm.plugin.ringtone.b.c(locale));
            continue;
          }
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject3).bzA();
        }
        catch (com.tencent.mm.af.a paramObject)
        {
          c.a(this.OES, false);
          Log.e(c.access$getTAG$cp(), s.X("GetAllFriendRingBackCgi failed: ", paramObject.getMessage()));
          if (c.c(this.OES) == -1L)
          {
            paramObject = this.OES.OEP;
            if (paramObject != null) {
              paramObject.OCg = j.a(paramObject.OCd, null, null, (m)new a.f(paramObject, null), 3);
            }
          }
          paramObject = this.OES.OEP;
          if (paramObject != null) {
            paramObject.bp(c.b(this.OES));
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(273338);
          return paramObject;
        }
        if (localObject3 == null)
        {
          bool = false;
        }
        else
        {
          localObject3 = ((bx)localObject3).JE(str);
          if (localObject3 == null)
          {
            bool = false;
          }
          else
          {
            bool = com.tencent.mm.contact.d.rs(((az)localObject3).field_type);
            continue;
            label531:
            Log.e(c.access$getTAG$cp(), s.X(str, " is not you friend"));
          }
        }
      }
      c.a(this.OES, paramObject);
      if (!c.a(this.OES))
      {
        paramObject = this.OES.OEP;
        if (paramObject != null) {
          paramObject.bp(c.b(this.OES));
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(273338);
        return paramObject;
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273338);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.c
 * JD-Core Version:    0.7.0.1
 */