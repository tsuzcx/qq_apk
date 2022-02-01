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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  private long zfr;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.zfr = 0L;
    Z(9, "VOIPFloatBall");
    bzz().mDz = 10;
    if (c.dRQ() != null) {
      bzz().dnC = String.valueOf(c.dRQ().zlR.zfA.ziZ.sAY);
    }
    bzv();
    AppMethodBeat.o(184042);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (bzs())
      {
        if (this.mDH.sk != paramView)
        {
          ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.mDH.sk });
          this.mDH.mDu = true;
          this.mDH.state = paramInt;
          this.mDH.sk = paramView;
          this.mDH.mDv = false;
          this.mDH.mDt = true;
          bzu();
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
          a.this.mDH.mDu = true;
          a.this.mDH.mDv = false;
          a.this.mDH.state = paramInt;
          a.this.mDH.sk = paramView;
          a.this.mDH.fnG = c.dRQ().zlV;
          a.this.mDH.mDt = true;
          if (!c.dRQ().zlV) {
            c.dRQ().zlV = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.bzz();
          if (bool)
          {
            str = "3";
            localBallReportInfo.mDA = str;
            localBallReportInfo = locala.bzz();
            if (!bool) {
              break label225;
            }
          }
          label225:
          for (String str = null;; str = String.valueOf(c.dRQ().zlR.zfA.ziZ.sAY))
          {
            localBallReportInfo.gWU = str;
            locala.bzz().mDx = 2;
            locala.bzv();
            a.this.bzu();
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
      long l = 200L + this.zfr - bt.eGO();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(184043);
        return;
      }
      ad.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      aq.n(paramView, l);
    }
    AppMethodBeat.o(184043);
  }
  
  public final void a(BaseSmallView paramBaseSmallView)
  {
    AppMethodBeat.i(184044);
    if (bzs())
    {
      ad.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramBaseSmallView });
      this.zfr = bt.eGO();
      bzt();
      AppMethodBeat.o(184044);
      return;
    }
    ad.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramBaseSmallView });
    AppMethodBeat.o(184044);
  }
  
  public static final class a
  {
    public static a zfu;
    
    static
    {
      AppMethodBeat.i(184041);
      zfu = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */