package com.tencent.mm.plugin.mv.ui.uic;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
public final class p$e
  extends kotlin.d.b.a.k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  public p$e(p paramp, d<? super e> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(287999);
    paramObject = (d)new e(this.MgJ, paramd);
    AppMethodBeat.o(287999);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(287992);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(287992);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.MgJ;
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((n)com.tencent.mm.ui.component.k.d(this.MgJ.getActivity()).q(n.class)).grd();
      s.u(localObject1, "<set-?>");
      paramObject.vaX = ((LinkedList)localObject1);
      paramObject = p.MgB;
      localObject1 = p.access$getTAG$cp();
      Object localObject2 = new StringBuilder("initBgTrackView size:").append(this.MgJ.MgC.size()).append(", mediaInfoList.size:").append(this.MgJ.vaX.size()).append(", trackData?.refObjectList.size:");
      paramObject = this.MgJ.LZM;
      if (paramObject == null) {
        paramObject = null;
      }
      for (;;)
      {
        Log.i((String)localObject1, paramObject);
        paramObject = (f)bg.kCh();
        localObject1 = (m)new kotlin.d.b.a.k(this.MgJ, null)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(287464);
            paramAnonymousObject = (d)new 1(this.MgJ, paramAnonymousd);
            AppMethodBeat.o(287464);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(287460);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(287460);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.MgJ.getAdapter().bZE.notifyChanged();
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(287460);
            return paramAnonymousObject;
          }
        };
        localObject2 = (d)this;
        this.label = 1;
        if (l.a(paramObject, (m)localObject1, (d)localObject2) != locala) {
          break;
        }
        AppMethodBeat.o(287992);
        return locala;
        paramObject = paramObject.ZJp;
        if (paramObject == null) {
          paramObject = null;
        } else {
          paramObject = Integer.valueOf(paramObject.size());
        }
      }
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ah.aiuX;
    AppMethodBeat.o(287992);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.p.e
 * JD-Core Version:    0.7.0.1
 */