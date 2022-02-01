package com.tencent.mm.plugin.voip.a;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  private long BXt;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.BXt = 0L;
    ac(9, "VOIPFloatBall");
    bKG().nGc = 10;
    if (com.tencent.mm.plugin.voip.c.euM() != null) {
      bKG().dwX = String.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt);
    }
    bKC();
    AppMethodBeat.o(184042);
  }
  
  public static void euP()
  {
    AppMethodBeat.i(216237);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).bKg();
    AppMethodBeat.o(216237);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (bKz())
      {
        if (this.nGj.vd != paramView)
        {
          ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.nGj.vd });
          this.nGj.nFX = true;
          this.nGj.state = paramInt;
          this.nGj.vd = paramView;
          this.nGj.nFY = false;
          this.nGj.nFW = true;
          bKB();
          AppMethodBeat.o(184043);
          return;
        }
        ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
        AppMethodBeat.o(184043);
        return;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184040);
          ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
          a.this.nGj.nFX = true;
          a.this.nGj.nFY = false;
          a.this.nGj.state = paramInt;
          a.this.nGj.vd = paramView;
          a.this.nGj.fJh = com.tencent.mm.plugin.voip.c.euM().CdJ;
          a.this.nGj.nFW = true;
          if (!com.tencent.mm.plugin.voip.c.euM().CdJ) {
            com.tencent.mm.plugin.voip.c.euM().CdJ = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.bKG();
          if (bool)
          {
            str = "3";
            localBallReportInfo.nGd = str;
            localBallReportInfo = locala.bKG();
            if (!bool) {
              break label225;
            }
          }
          label225:
          for (String str = null;; str = String.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt))
          {
            localBallReportInfo.hPO = str;
            locala.bKG().nGa = 2;
            locala.bKC();
            a.this.bKB();
            AppMethodBeat.o(184040);
            return;
            if (i == 4)
            {
              str = "2";
              break;
            }
            str = "1";
            break;
          }
        }
      };
      long l = 200L + this.BXt - bt.flT();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(184043);
        return;
      }
      ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      aq.o(paramView, l);
    }
    AppMethodBeat.o(184043);
  }
  
  public final void d(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(216236);
    if (bKz())
    {
      ad.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.BXt = bt.flT();
      bKA();
      AppMethodBeat.o(216236);
      return;
    }
    ad.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(216236);
  }
  
  public static final class a
  {
    public static a BXw;
    
    static
    {
      AppMethodBeat.i(184041);
      BXw = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */