package com.tencent.mm.plugin.repairer.ui.uic;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  b$b(b paramb, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(278041);
    paramd = new b(this.Oyt, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(278041);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(278038);
    Object localObject = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(278038);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    localObject = new ept();
    paramObject = this.Oyt.getIntent().getByteArrayExtra("key_config_item_list");
    if (paramObject == null)
    {
      paramObject = null;
      if (paramObject != null) {
        break label236;
      }
    }
    label236:
    for (paramObject = b.gNp();; paramObject = localObject)
    {
      localObject = b.a(this.Oyt, paramObject);
      if (!n.bp((CharSequence)localObject)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          LifecycleScope localLifecycleScope = this.Oyt.getLifecycleScope();
          if (localLifecycleScope != null) {
            j.a((aq)localLifecycleScope, (f)bg.kCh(), null, (m)new k(this.Oyt, (String)localObject)
            {
              int label;
              
              private static final void a(b paramAnonymousb, boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(278055);
                paramAnonymousb.getActivity().finish();
                AppMethodBeat.o(278055);
              }
              
              public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
              {
                AppMethodBeat.i(278077);
                paramAnonymousObject = (d)new 1(this.Oyt, this.Oyu, paramAnonymousd);
                AppMethodBeat.o(278077);
                return paramAnonymousObject;
              }
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(278071);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(278071);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = new g.a((Context)this.Oyt.getActivity());
                paramAnonymousObject.bDE(s.X(this.Oyu, "\n命名不合法！！"));
                paramAnonymousObject.c(new b.b.1..ExternalSyntheticLambda0(this.Oyt)).show();
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(278071);
                return paramAnonymousObject;
              }
            }, 2);
          }
        }
        if (!h.baz()) {
          b.b(this.Oyt, paramObject);
        }
        localObject = this.Oyt.gst();
        if (localObject != null)
        {
          localObject = ((BaseMvvmActivity)localObject).getStateCenter();
          if (localObject != null) {
            ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.plugin.repairer.ui.d.a(paramObject));
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(278038);
        return paramObject;
        paramObject = ((ept)localObject).parseFrom(paramObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.uic.b.b
 * JD-Core Version:    0.7.0.1
 */