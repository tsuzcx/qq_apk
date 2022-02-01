package com.tencent.mm.plugin.voip.a;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  private long hCC;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.hCC = 0L;
    G(9, "VOIPFloatBall");
    ciw().hDa = 10;
    if (c.fFg() != null) {
      ciw().dPJ = String.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
    }
    cit();
    AppMethodBeat.o(184042);
  }
  
  public static a fFk()
  {
    return a.GST;
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (ciq())
      {
        if (this.oWE.vk != paramView)
        {
          Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.oWE.vk });
          this.oWE.oWr = true;
          this.oWE.vk = paramView;
          this.oWE.nno = false;
          this.oWE.oWq = true;
          bh(paramInt, paramBoolean);
          bi(paramInt, paramBoolean);
          bj(paramInt, paramBoolean);
          cis();
          AppMethodBeat.o(184043);
          return;
        }
        Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
        AppMethodBeat.o(184043);
        return;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184040);
          Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", new Object[] { Integer.valueOf(paramInt), paramView });
          a.this.oWE.oWr = true;
          a.this.oWE.nno = false;
          a.this.oWE.vk = paramView;
          a.this.oWE.gqx = c.fFg().GYW;
          a.this.oWE.oWq = true;
          if (!c.fFg().GYW) {
            c.fFg().GYW = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.ciw();
          if (bool)
          {
            str = "3";
            localBallReportInfo.oWy = str;
            localBallReportInfo = locala.ciw();
            if (!bool) {
              break label256;
            }
          }
          label256:
          for (String str = null;; str = String.valueOf(c.fFg().GYS.GSZ.GVV.ypH))
          {
            localBallReportInfo.iNV = str;
            locala.ciw().hCZ = 2;
            locala.cit();
            a.this.bh(paramInt, paramBoolean);
            a.this.bi(paramInt, paramBoolean);
            a.this.bj(paramInt, paramBoolean);
            a.this.cis();
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
      long l = 200L + this.hCC - Util.nowMilliSecond();
      if (l <= 0L)
      {
        paramView.run();
        AppMethodBeat.o(184043);
        return;
      }
      Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, no ball, add delayed:%s", new Object[] { Long.valueOf(l) });
      MMHandlerThread.postToMainThreadDelayed(paramView, l);
    }
    AppMethodBeat.o(184043);
  }
  
  public final void b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(235473);
    if (ciq())
    {
      Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.hCC = Util.nowMilliSecond();
      cir();
      AppMethodBeat.o(235473);
      return;
    }
    Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(235473);
  }
  
  final void bh(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.oWE.state = paramInt;
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        this.oWE.state = 512;
        return;
      }
    } while (paramInt != 8);
    this.oWE.state = 1024;
  }
  
  final void bi(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235474);
    if (this.oWE.oWm == null) {
      this.oWE.oWm = new Point();
    }
    int i = at.aH(MMApplicationContext.getContext(), 2131165314);
    if (paramInt == 8) {
      if (!paramBoolean)
      {
        this.oWE.oWm.x = (at.aH(MMApplicationContext.getContext(), 2131166443) + i * 2);
        this.oWE.oWm.y = (at.aH(MMApplicationContext.getContext(), 2131166443) + i * 2);
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.VoipFloatBallHelper", "setVoipViewSize %s, margin: %d", new Object[] { this.oWE.oWm, Integer.valueOf(i) });
      AppMethodBeat.o(235474);
      return;
      this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), 2131166445);
      this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), 2131166444);
      continue;
      if (paramInt == 4) {
        if (!paramBoolean)
        {
          this.oWE.oWm.x = (at.aH(MMApplicationContext.getContext(), 2131166448) + i * 2);
          this.oWE.oWm.y = (at.aH(MMApplicationContext.getContext(), 2131166446) + i * 2);
        }
        else
        {
          this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), 2131166445);
          this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), 2131166444);
        }
      }
    }
  }
  
  final void bj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235475);
    if (((paramBoolean) || (paramInt == 4)) && (this.oWE.oWt == null)) {
      this.oWE.oWt = new BallInfo.a();
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      at.aH(MMApplicationContext.getContext(), 2131165314);
      i = at.aH(MMApplicationContext.getContext(), 2131166445);
      j = at.aH(MMApplicationContext.getContext(), 2131166445);
      k = at.aH(MMApplicationContext.getContext(), 2131166444);
      this.oWE.oWt.oWv = new Point(i, k);
      this.oWE.oWt.oWw = new Point(j, k);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %d, endWidth: %d, endHeight: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(235475);
      return;
    }
    if (paramInt == 4)
    {
      i = at.aH(MMApplicationContext.getContext(), 2131165314);
      j = at.aH(MMApplicationContext.getContext(), 2131166448);
      k = at.aH(MMApplicationContext.getContext(), 2131166446);
      int m = at.aH(MMApplicationContext.getContext(), 2131166441);
      int n = at.aH(MMApplicationContext.getContext(), 2131166439);
      this.oWE.oWt.oWv = new Point(j + i * 2, k + i * 2);
      this.oWE.oWt.oWw = new Point(m + i * 2, i * 2 + n);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %s, endSize: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.oWE.oWt.oWv, this.oWE.oWt.oWw });
      AppMethodBeat.o(235475);
      return;
    }
    this.oWE.oWt = null;
    AppMethodBeat.o(235475);
  }
  
  public final void fFl()
  {
    AppMethodBeat.i(235477);
    Log.i("MicroMsg.VoipFloatBallHelper", "switchVoipVoice");
    this.oWE.state = 8;
    ((b)g.af(b.class)).u(this.oWE);
    AppMethodBeat.o(235477);
  }
  
  public final void wR(boolean paramBoolean)
  {
    AppMethodBeat.i(235476);
    Log.i("MicroMsg.VoipFloatBallHelper", "updateHideWhenAppBackground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.oWE != null)
    {
      this.oWE.oWu = paramBoolean;
      cit();
    }
    AppMethodBeat.o(235476);
  }
  
  public static final class a
  {
    public static a GST;
    
    static
    {
      AppMethodBeat.i(184041);
      GST = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */