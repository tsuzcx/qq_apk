package com.tencent.mm.plugin.ringtone.uic;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.d.c;
import com.tencent.mm.plugin.ringtone.d.c.b.a;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneGlobalMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "commonRingtoneUI", "Lcom/tencent/mm/plugin/ringtone/widget/CommonRingtoneLayout;", "isPlay", "", "onDestroy", "", "onPause", "onResume", "refreshUI", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  private com.tencent.mm.plugin.ringtone.widget.a OFk;
  private boolean hJg;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273326);
    AppMethodBeat.o(273326);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(273334);
    s.u(paramf, "this$0");
    com.tencent.mm.plugin.ringtone.widget.a locala = paramf.OFk;
    if (locala != null) {
      locala.BT(paramf.hJg);
    }
    AppMethodBeat.o(273334);
  }
  
  private static final void a(f paramf, com.tencent.mm.plugin.ringtone.widget.b.a parama)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(273368);
    s.u(paramf, "this$0");
    int i;
    if (parama == null) {
      i = -1;
    }
    Object localObject;
    switch (i)
    {
    default: 
    case 1: 
      do
      {
        AppMethodBeat.o(273368);
        return;
        i = a.$EnumSwitchMapping$0[parama.ordinal()];
        break;
        parama = com.tencent.mm.ui.component.k.aeZF;
        parama = ((e)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(e.class)).OFf;
      } while (parama == null);
      if (parama.ODv == null)
      {
        localObject = com.tencent.mm.plugin.ringtone.d.gOq();
        parama = com.tencent.mm.ui.component.k.aeZF;
        com.tencent.mm.plugin.ringtone.g.d locald = ((e)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(e.class)).OFf;
        parama = (com.tencent.mm.plugin.ringtone.widget.b.a)localObject;
        if (locald != null)
        {
          locald.ODv = ((com.tencent.mm.plugin.ringtone.g.d)localObject).ODv;
          parama = (com.tencent.mm.plugin.ringtone.widget.b.a)localObject;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = parama.ODv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject).loop = false;
      }
      if (paramf.hJg)
      {
        localObject = com.tencent.mm.plugin.ringtone.l.a.OFQ;
        com.tencent.mm.plugin.ringtone.l.a.gPd();
        i = 1;
      }
      label255:
      int j;
      do
      {
        if (paramf.hJg) {
          break;
        }
        bool1 = true;
        paramf.hJg = bool1;
        com.tencent.threadpool.h.ahAA.bk(new f..ExternalSyntheticLambda2(paramf));
        if (paramf.hJg)
        {
          if ((parama.ODD == null) || (parama.gOD().fileName == null) || (!com.tencent.mm.plugin.au.b.b.a(parama.gOD()))) {
            break label353;
          }
          bool1 = bool2;
          localObject = com.tencent.mm.ui.component.k.aeZF;
          com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(n.class);
          n.a(parama, null, bool1);
        }
        if (i == 2) {
          break label359;
        }
        localObject = com.tencent.mm.ui.component.k.aeZF;
        ((h)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(h.class)).b(parama, z.bAM().hashCode(), paramf.hJg);
        AppMethodBeat.o(273368);
        return;
        localObject = com.tencent.mm.plugin.ringtone.l.a.OFQ;
        j = com.tencent.mm.plugin.ringtone.l.a.gPc();
        i = j;
      } while (j != 0);
      for (;;)
      {
        AppMethodBeat.o(273368);
        return;
        bool1 = false;
        break;
        label353:
        bool1 = false;
        break label255;
        label359:
        com.tencent.threadpool.h.ahAA.o(new f..ExternalSyntheticLambda3(paramf), 200L);
      }
      parama = com.tencent.mm.ui.component.k.aeZF;
      i = ((b)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(b.class)).OEE;
      parama = PluginRingtone.OBl;
      PluginRingtone.a.enterRingtoneSelectUI((Activity)paramf.getActivity(), 1, z.bAM(), i);
      parama = com.tencent.mm.ui.component.k.aeZF;
      parama = ((e)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(e.class)).OFf;
      if (parama == null) {
        break;
      }
      if ((parama.ODD != null) && (parama.gOD().fileName != null) && (com.tencent.mm.plugin.au.b.b.a(parama.gOD()))) {}
      for (;;)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(n.class);
        n.c(parama, null, bool1);
        break;
        bool1 = false;
      }
    }
  }
  
  private static final void a(f paramf, Integer paramInteger)
  {
    AppMethodBeat.i(273382);
    s.u(paramf, "this$0");
    paramInteger = com.tencent.mm.ui.component.k.aeZF;
    com.tencent.mm.plugin.ringtone.g.d locald = ((e)com.tencent.mm.ui.component.k.d(paramf.getActivity()).q(e.class)).OFf;
    com.tencent.mm.plugin.ringtone.widget.a locala;
    if (locald != null)
    {
      locala = paramf.OFk;
      if (locala != null)
      {
        s.u(locald, "info");
        if (!locald.OBU) {
          break label220;
        }
        paramf = locala.OFU;
        if (paramf != null) {
          paramf.setText((CharSequence)locala.mContext.getString(b.f.ringtone_unavailable_text));
        }
        paramf = locala.OFU;
        if (paramf != null) {
          paramf.setTextColor(com.tencent.mm.cd.a.w(locala.mContext, com.tencent.mm.plugin.ringtone.b.a.FG_4));
        }
        paramf = locala.OFW;
        if (paramf != null) {
          paramf.setText((CharSequence)com.tencent.mm.plugin.ringtone.widget.a.iY(0L));
        }
        paramf = locala.OFW;
        if (paramf != null) {
          paramf.setTextColor(com.tencent.mm.cd.a.w(locala.mContext, com.tencent.mm.plugin.ringtone.b.a.FG_4));
        }
        paramf = locala.OFV;
        if (paramf != null)
        {
          paramInteger = com.tencent.mm.plugin.ringtone.l.b.OFS;
          paramInteger = locala.rootView.getContext();
          s.s(paramInteger, "rootView.context");
          paramf.setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m(paramInteger, b.e.icons_filled_error, com.tencent.mm.plugin.ringtone.b.a.ringtone_unavailable_bg));
        }
        paramf = locala.OGb;
        if (paramf != null) {
          paramf.BU(false);
        }
        locala.OFX = locald;
      }
    }
    AppMethodBeat.o(273382);
    return;
    label220:
    if (locald.ODA != null)
    {
      TextView localTextView = locala.OFU;
      if (localTextView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramInteger = locald.ODz;
        paramf = paramInteger;
        if (paramInteger == null) {
          paramf = "";
        }
        localStringBuilder = localStringBuilder.append(paramf).append(" · ");
        paramInteger = locald.ODA;
        paramf = paramInteger;
        if (paramInteger == null) {
          paramf = "";
        }
        localTextView.setText((CharSequence)paramf);
      }
    }
    for (;;)
    {
      paramf = locala.OGb;
      if (paramf != null) {
        paramf.BU(true);
      }
      paramf = locala.OFU;
      if (paramf != null) {
        paramf.setTextColor(com.tencent.mm.cd.a.w(locala.mContext, com.tencent.mm.plugin.ringtone.b.a.FG_0));
      }
      paramf = locala.OFW;
      if (paramf != null) {
        paramf.setTextColor(com.tencent.mm.cd.a.w(locala.mContext, com.tencent.mm.plugin.ringtone.b.a.FG_1));
      }
      paramf = locala.OFV;
      if (paramf != null)
      {
        paramInteger = com.tencent.mm.plugin.ringtone.l.b.OFS;
        paramInteger = locala.rootView.getContext();
        s.s(paramInteger, "rootView.context");
        paramf.setImageDrawable(com.tencent.mm.plugin.ringtone.l.b.m(paramInteger, b.e.icons_filled_ringing, com.tencent.mm.plugin.ringtone.b.a.FG_0));
      }
      paramf = locala.OFW;
      if (paramf == null) {
        break;
      }
      paramf.setText((CharSequence)com.tencent.mm.plugin.ringtone.widget.a.iY(locald.mEndTime / 1000L - locald.mStartTime / 1000L));
      break;
      paramf = locala.OFU;
      if (paramf != null) {
        paramf.setText((CharSequence)String.valueOf(locald.ODz));
      }
    }
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(273344);
    s.u(paramf, "this$0");
    paramf.hJg = false;
    paramf = paramf.OFk;
    if (paramf != null) {
      paramf.BT(false);
    }
    AppMethodBeat.o(273344);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273449);
    super.onDestroy();
    com.tencent.mm.plugin.ringtone.l.a locala = com.tencent.mm.plugin.ringtone.l.a.OFQ;
    com.tencent.mm.plugin.ringtone.l.a.gPd();
    AppMethodBeat.o(273449);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273431);
    super.onPause();
    com.tencent.mm.plugin.ringtone.widget.a locala = this.OFk;
    if (locala != null)
    {
      MTimerHandler localMTimerHandler = locala.OFY;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localMTimerHandler = locala.OFY;
      if (localMTimerHandler != null) {
        localMTimerHandler.quit();
      }
      locala.OFY = null;
    }
    AppMethodBeat.o(273431);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273443);
    super.onResume();
    Object localObject = findViewById(b.c.common_ringtone_layout);
    s.s(localObject, "findViewById(R.id.common_ringtone_layout)");
    this.OFk = new com.tencent.mm.plugin.ringtone.widget.a((View)localObject);
    localObject = this.OFk;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.ringtone.widget.a)localObject).OFZ;
      if (localObject != null) {
        ((x)localObject).a((q)getActivity(), new f..ExternalSyntheticLambda0(this));
      }
    }
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((e)com.tencent.mm.ui.component.k.d(getActivity()).q(e.class)).OFg.a((q)getActivity(), new f..ExternalSyntheticLambda1(this));
    j.a(getLifecycleScope(), null, null, (m)new b(this, null), 3);
    localObject = this.OFk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.ringtone.widget.a)localObject).BT(false);
    }
    AppMethodBeat.o(273443);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(f paramf, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273269);
      paramObject = (kotlin.d.d)new b(this.OFl, paramd);
      AppMethodBeat.o(273269);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273260);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273260);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((h)com.tencent.mm.ui.component.k.d(this.OFl.getActivity()).q(h.class)).OFo;
        if (paramObject != null)
        {
          paramObject = paramObject.OCf;
          if (paramObject != null)
          {
            paramObject = (g)paramObject;
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new d(this.OFl);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(273260);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273260);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements Runnable
    {
      a(f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(273455);
        f.c(this.OFl);
        com.tencent.mm.plugin.ringtone.widget.a locala = f.d(this.OFl);
        if (locala != null) {
          locala.BT(false);
        }
        AppMethodBeat.o(273455);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      implements Runnable
    {
      b(c.b.a parama, f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(273447);
        if (this.OFc.id == z.bAM().hashCode())
        {
          com.tencent.mm.plugin.ringtone.widget.a locala = f.d(this.OFl);
          if (locala != null) {
            locala.gPg();
          }
        }
        AppMethodBeat.o(273447);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      implements Runnable
    {
      c(f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(273462);
        f.c(this.OFl);
        com.tencent.mm.plugin.ringtone.widget.a locala = f.d(this.OFl);
        if (locala != null) {
          locala.BT(false);
        }
        AppMethodBeat.o(273462);
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements kotlinx.coroutines.b.h<c.b.a>
    {
      public d(f paramf) {}
      
      public final Object a(c.b.a parama, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(273464);
        parama = (c.b.a)parama;
        switch (parama.EcS)
        {
        }
        for (;;)
        {
          parama = ah.aiuX;
          AppMethodBeat.o(273464);
          return parama;
          if (parama.id != z.bAM().hashCode())
          {
            com.tencent.threadpool.h.ahAA.bk((Runnable)new f.b.a(this.OFl));
            continue;
            com.tencent.threadpool.h.ahAA.bk((Runnable)new f.b.b(parama, this.OFl));
            continue;
            if (parama.id == z.bAM().hashCode())
            {
              com.tencent.threadpool.h.ahAA.bk((Runnable)new f.b.c(this.OFl));
              parama = com.tencent.mm.plugin.ringtone.l.a.OFQ;
              com.tencent.mm.plugin.ringtone.l.a.gPd();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.f
 * JD-Core Version:    0.7.0.1
 */