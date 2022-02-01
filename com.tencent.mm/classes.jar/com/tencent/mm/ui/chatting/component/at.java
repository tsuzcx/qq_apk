package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.aj.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/MultiTaskComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "()V", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onChattingEnterAnimEnd", "", "onChattingExitAnimEnd", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends a
  implements aj
{
  public static final at.a aevd;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  
  static
  {
    AppMethodBeat.i(255765);
    aevd = new at.a((byte)0);
    AppMethodBeat.o(255765);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(255769);
    super.a(parama);
    this.adCQ = parama;
    AppMethodBeat.o(255769);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(255787);
    super.jjh();
    Object localObject1 = this.adCQ;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getContext();
      if (localObject1 != null)
      {
        Object localObject2 = k.aeZF;
        if (((c)k.nq((Context)localObject1).q(c.class)).gkZ())
        {
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
          localObject1 = (dry)a.a.a((Context)localObject1, 5, dry.class);
          if (localObject1 != null)
          {
            ((dry)localObject1).aaXK = true;
            localObject2 = ((dry)localObject1).aaXI;
            if (localObject2 != null)
            {
              ((drw)localObject2).aaXC = 1L;
              if (cn.bDw() >= ((dry)localObject1).AxK)
              {
                ((drw)localObject2).duration += cn.bDw() - ((dry)localObject1).AxK;
                ((dry)localObject1).AxK = cn.bDw();
              }
            }
            localObject2 = ((dry)localObject1).aaXL;
            if ((localObject2 != null) && (cn.bDw() >= ((drv)localObject2).aaXv))
            {
              ((drv)localObject2).duration += cn.bDw() - ((drv)localObject2).aaXv;
              ((drv)localObject2).aaXv = cn.bDw();
            }
            localObject2 = ((dry)localObject1).aaXN;
            if ((localObject2 != null) && (cn.bDw() >= ((drv)localObject2).aaXv))
            {
              ((drv)localObject2).duration += cn.bDw() - ((drv)localObject2).aaXv;
              ((drv)localObject2).aaXv = cn.bDw();
            }
            localObject1 = ((dry)localObject1).aaXM;
            if ((localObject1 != null) && (cn.bDw() >= ((drv)localObject1).aaXv))
            {
              ((drv)localObject1).duration += cn.bDw() - ((drv)localObject1).aaXv;
              ((drv)localObject1).aaXv = cn.bDw();
            }
          }
        }
      }
    }
    AppMethodBeat.o(255787);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(255780);
    super.jji();
    AppMethodBeat.o(255780);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(255784);
    super.jjj();
    AppMethodBeat.o(255784);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(255788);
    super.jjl();
    Object localObject1 = this.adCQ;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getContext();
      if (localObject1 != null)
      {
        Object localObject2 = k.aeZF;
        if (((c)k.nq((Context)localObject1).q(c.class)).gkZ())
        {
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
          localObject1 = (dry)a.a.a((Context)localObject1, 5, dry.class);
          if (localObject1 != null)
          {
            ((dry)localObject1).aaXK = false;
            ((dry)localObject1).AxK = cn.bDw();
            localObject2 = ((dry)localObject1).aaXM;
            if (localObject2 != null) {
              ((drv)localObject2).aaXv = cn.bDw();
            }
            localObject2 = ((dry)localObject1).aaXL;
            if (localObject2 != null) {
              ((drv)localObject2).aaXv = cn.bDw();
            }
            localObject1 = ((dry)localObject1).aaXN;
            if (localObject1 != null) {
              ((drv)localObject1).aaXv = cn.bDw();
            }
          }
        }
      }
    }
    AppMethodBeat.o(255788);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(255774);
    super.jqF();
    AppMethodBeat.o(255774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.at
 * JD-Core Version:    0.7.0.1
 */