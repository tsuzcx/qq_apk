package com.tencent.mm.plugin.mv.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.dtf;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class MusicMvRouterUI$c
  extends k
  implements m<aq, d<? super Boolean>, Object>
{
  int label;
  
  MusicMvRouterUI$c(MusicMvRouterUI paramMusicMvRouterUI, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(287442);
    paramObject = (d)new c(this.Max, paramd);
    AppMethodBeat.o(287442);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    bool = true;
    AppMethodBeat.i(287437);
    Object localObject = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(287437);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    for (;;)
    {
      try
      {
        paramObject = this.Max.getIntent().getByteArrayExtra("key_track_data");
        if (paramObject == null)
        {
          paramObject = Boolean.FALSE;
          AppMethodBeat.o(287437);
          return paramObject;
        }
        localObject = new dtf();
        ((dtf)localObject).parseFrom(paramObject);
        paramObject = ((dtf)localObject).aaYK;
        if (paramObject == null) {
          continue;
        }
        paramObject = paramObject.objectDesc;
        if (paramObject == null) {
          continue;
        }
        paramObject = paramObject.mvInfo;
        if (paramObject == null) {
          continue;
        }
        i = paramObject.ZWM;
        if (i != 1) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramObject)
      {
        int i = 0;
        continue;
        bool = false;
        continue;
      }
      if (i == 0) {
        continue;
      }
      AppMethodBeat.o(287437);
      return Boolean.valueOf(bool);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvRouterUI.c
 * JD-Core Version:    0.7.0.1
 */