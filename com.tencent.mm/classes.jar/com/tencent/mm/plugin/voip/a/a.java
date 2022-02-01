package com.tencent.mm.plugin.voip.a;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  private long CoU;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.CoU = 0L;
    ac(9, "VOIPFloatBall");
    bLD().nLC = 10;
    if (com.tencent.mm.plugin.voip.c.eys() != null) {
      bLD().dyc = String.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg);
    }
    bLz();
    AppMethodBeat.o(184042);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (bLw())
      {
        if (this.nLK.vd != paramView)
        {
          ae.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.nLK.vd });
          this.nLK.nLu = true;
          this.nLK.vd = paramView;
          this.nLK.nLv = false;
          this.nLK.nLt = true;
          aP(paramInt, paramBoolean);
          aQ(paramInt, paramBoolean);
          aR(paramInt, paramBoolean);
          bLy();
          AppMethodBeat.o(184043);
          return;
        }
        ae.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
        AppMethodBeat.o(184043);
        return;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184040);
          ae.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
          a.this.nLK.nLu = true;
          a.this.nLK.nLv = false;
          a.this.nLK.vd = paramView;
          a.this.nLK.fLk = com.tencent.mm.plugin.voip.c.eys().Cvk;
          a.this.nLK.nLt = true;
          if (!com.tencent.mm.plugin.voip.c.eys().Cvk) {
            com.tencent.mm.plugin.voip.c.eys().Cvk = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.bLD();
          if (bool)
          {
            str = "3";
            localBallReportInfo.nLD = str;
            localBallReportInfo = locala.bLD();
            if (!bool) {
              break label256;
            }
          }
          label256:
          for (String str = null;; str = String.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg))
          {
            localBallReportInfo.hSG = str;
            locala.bLD().nLA = 2;
            locala.bLz();
            a.this.aP(paramInt, paramBoolean);
            a.this.aQ(paramInt, paramBoolean);
            a.this.aR(paramInt, paramBoolean);
            a.this.bLy();
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
      long l = 200L + this.CoU - bu.fpO();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(184043);
        return;
      }
      ae.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      ar.o(paramView, l);
    }
    AppMethodBeat.o(184043);
  }
  
  final void aP(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.nLK.state = paramInt;
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        this.nLK.state = 512;
        return;
      }
    } while (paramInt != 8);
    this.nLK.state = 1024;
  }
  
  final void aQ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209912);
    if (this.nLK.nLq == null) {
      this.nLK.nLq = new Point();
    }
    int i = aq.ay(ak.getContext(), 2131165303);
    if (paramInt == 8)
    {
      this.nLK.nLq.x = (aq.ay(ak.getContext(), 2131167090) + i * 2);
      this.nLK.nLq.y = (aq.ay(ak.getContext(), 2131167090) + i * 2);
    }
    for (;;)
    {
      ae.v("MicroMsg.VoipFloatBallHelper", "setVoipViewSize %s, margin: %d", new Object[] { this.nLK.nLq, Integer.valueOf(i) });
      AppMethodBeat.o(209912);
      return;
      if (paramInt == 4) {
        if (!paramBoolean)
        {
          this.nLK.nLq.x = (aq.ay(ak.getContext(), 2131166356) + i * 2);
          this.nLK.nLq.y = (aq.ay(ak.getContext(), 2131166354) + i * 2);
        }
        else
        {
          this.nLK.nLq.x = aq.ay(ak.getContext(), 2131167092);
          this.nLK.nLq.y = aq.ay(ak.getContext(), 2131167091);
        }
      }
    }
  }
  
  final void aR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209913);
    if (((paramBoolean) || (paramInt == 4)) && (this.nLK.nLx == null)) {
      this.nLK.nLx = new BallInfo.a();
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      i = aq.ay(ak.getContext(), 2131165303) * 2 + aq.ay(ak.getContext(), 2131167090);
      j = aq.ay(ak.getContext(), 2131167092);
      k = aq.ay(ak.getContext(), 2131167091);
      this.nLK.nLx.nLy = new Point(i, i);
      this.nLK.nLx.nLz = new Point(j, k);
      ae.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %d, endWidth: %d, endHeight: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(209913);
      return;
    }
    if (paramInt == 4)
    {
      i = aq.ay(ak.getContext(), 2131165303);
      j = aq.ay(ak.getContext(), 2131166356);
      k = aq.ay(ak.getContext(), 2131166354);
      int m = aq.ay(ak.getContext(), 2131166352);
      int n = aq.ay(ak.getContext(), 2131166350);
      this.nLK.nLx.nLy = new Point(j + i * 2, k + i * 2);
      this.nLK.nLx.nLz = new Point(m + i * 2, i * 2 + n);
      ae.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %s, endSize: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.nLK.nLx.nLy, this.nLK.nLx.nLz });
      AppMethodBeat.o(209913);
      return;
    }
    this.nLK.nLx = null;
    AppMethodBeat.o(209913);
  }
  
  public final void d(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(209911);
    if (bLw())
    {
      ae.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.CoU = bu.fpO();
      bLx();
      AppMethodBeat.o(209911);
      return;
    }
    ae.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(209911);
  }
  
  public final void eyv()
  {
    AppMethodBeat.i(209914);
    ae.i("MicroMsg.VoipFloatBallHelper", "switchVoipVoice");
    this.nLK.state = 8;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).v(this.nLK);
    AppMethodBeat.o(209914);
  }
  
  public static final class a
  {
    public static a CoX;
    
    static
    {
      AppMethodBeat.i(184041);
      CoX = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */