package com.tencent.mm.plugin.voip.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  private long AxY;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.AxY = 0L;
    aa(9, "VOIPFloatBall");
    bGv().nfG = 10;
    if (c.ehb() != null) {
      bGv().dlk = String.valueOf(c.ehb().AEF.Ayh.ABJ.tIG);
    }
    bGr();
    AppMethodBeat.o(184042);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (bGo())
      {
        if (this.nfN.tk != paramView)
        {
          ac.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.nfN.tk });
          this.nfN.nfB = true;
          this.nfN.state = paramInt;
          this.nfN.tk = paramView;
          this.nfN.nfC = false;
          this.nfN.nfA = true;
          bGq();
          AppMethodBeat.o(184043);
          return;
        }
        ac.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
        AppMethodBeat.o(184043);
        return;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184040);
          ac.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
          a.this.nfN.nfB = true;
          a.this.nfN.nfC = false;
          a.this.nfN.state = paramInt;
          a.this.nfN.tk = paramView;
          a.this.nfN.fra = c.ehb().AEJ;
          a.this.nfN.nfA = true;
          if (!c.ehb().AEJ) {
            c.ehb().AEJ = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.bGv();
          if (bool)
          {
            str = "3";
            localBallReportInfo.nfH = str;
            localBallReportInfo = locala.bGv();
            if (!bool) {
              break label225;
            }
          }
          label225:
          for (String str = null;; str = String.valueOf(c.ehb().AEF.Ayh.ABJ.tIG))
          {
            localBallReportInfo.hxt = str;
            locala.bGv().nfE = 2;
            locala.bGr();
            a.this.bGq();
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
      long l = 200L + this.AxY - bs.eWj();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(184043);
        return;
      }
      ac.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      ap.n(paramView, l);
    }
    AppMethodBeat.o(184043);
  }
  
  public final void a(BaseSmallView paramBaseSmallView)
  {
    AppMethodBeat.i(184044);
    if (bGo())
    {
      ac.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramBaseSmallView });
      this.AxY = bs.eWj();
      bGp();
      AppMethodBeat.o(184044);
      return;
    }
    ac.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramBaseSmallView });
    AppMethodBeat.o(184044);
  }
  
  public static final class a
  {
    public static a Ayb;
    
    static
    {
      AppMethodBeat.i(184041);
      Ayb = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */