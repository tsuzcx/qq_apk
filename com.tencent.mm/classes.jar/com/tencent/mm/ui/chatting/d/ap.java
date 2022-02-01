package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.ui.a.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.l;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.ag.class)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/component/MultiTaskComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "()V", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onChattingEnterAnimEnd", "", "onChattingExitAnimEnd", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "Companion", "app_release"})
public final class ap
  extends a
  implements ag
{
  public static final ap.a WMV;
  private com.tencent.mm.ui.chatting.e.a VYv;
  
  static
  {
    AppMethodBeat.i(281815);
    WMV = new ap.a((byte)0);
    AppMethodBeat.o(281815);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(281808);
    super.a(parama);
    this.VYv = parama;
    AppMethodBeat.o(281808);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(281812);
    super.hGW();
    Object localObject1 = this.VYv;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.chatting.e.a)localObject1).getContext();
      if (localObject1 != null)
      {
        Object localObject2 = g.Xox;
        if (((c)g.lm((Context)localObject1).i(c.class)).fbW())
        {
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
          localObject1 = (daq)a.a.a((Context)localObject1, 5, daq.class);
          if (localObject1 != null)
          {
            ((daq)localObject1).TIb = true;
            localObject2 = ((daq)localObject1).THZ;
            if (localObject2 != null)
            {
              ((dao)localObject2).THT = 1L;
              if (cm.bfE() >= ((daq)localObject1).zUF)
              {
                ((dao)localObject2).duration += cm.bfE() - ((daq)localObject1).zUF;
                ((daq)localObject1).zUF = cm.bfE();
              }
            }
            localObject2 = ((daq)localObject1).TIc;
            if ((localObject2 != null) && (cm.bfE() >= ((dan)localObject2).THM))
            {
              ((dan)localObject2).duration += cm.bfE() - ((dan)localObject2).THM;
              ((dan)localObject2).THM = cm.bfE();
            }
            localObject2 = ((daq)localObject1).TIe;
            if ((localObject2 != null) && (cm.bfE() >= ((dan)localObject2).THM))
            {
              ((dan)localObject2).duration += cm.bfE() - ((dan)localObject2).THM;
              ((dan)localObject2).THM = cm.bfE();
            }
            localObject1 = ((daq)localObject1).TId;
            if (localObject1 != null)
            {
              if (cm.bfE() >= ((dan)localObject1).THM)
              {
                ((dan)localObject1).duration += cm.bfE() - ((dan)localObject1).THM;
                ((dan)localObject1).THM = cm.bfE();
              }
              AppMethodBeat.o(281812);
              return;
            }
            AppMethodBeat.o(281812);
            return;
          }
        }
        AppMethodBeat.o(281812);
        return;
      }
    }
    AppMethodBeat.o(281812);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(281810);
    super.hGX();
    AppMethodBeat.o(281810);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(281811);
    super.hGY();
    AppMethodBeat.o(281811);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(281814);
    super.hHa();
    Object localObject1 = this.VYv;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.chatting.e.a)localObject1).getContext();
      if (localObject1 != null)
      {
        Object localObject2 = g.Xox;
        if (((c)g.lm((Context)localObject1).i(c.class)).fbW())
        {
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
          localObject1 = (daq)a.a.a((Context)localObject1, 5, daq.class);
          if (localObject1 != null)
          {
            ((daq)localObject1).TIb = false;
            ((daq)localObject1).zUF = cm.bfE();
            localObject2 = ((daq)localObject1).TId;
            if (localObject2 != null) {
              ((dan)localObject2).THM = cm.bfE();
            }
            localObject2 = ((daq)localObject1).TIc;
            if (localObject2 != null) {
              ((dan)localObject2).THM = cm.bfE();
            }
            localObject1 = ((daq)localObject1).TIe;
            if (localObject1 != null)
            {
              ((dan)localObject1).THM = cm.bfE();
              AppMethodBeat.o(281814);
              return;
            }
            AppMethodBeat.o(281814);
            return;
          }
        }
        AppMethodBeat.o(281814);
        return;
      }
    }
    AppMethodBeat.o(281814);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(281809);
    super.hNZ();
    AppMethodBeat.o(281809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ap
 * JD-Core Version:    0.7.0.1
 */