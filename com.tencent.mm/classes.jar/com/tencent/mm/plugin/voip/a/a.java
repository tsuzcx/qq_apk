package com.tencent.mm.plugin.voip.a;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;

public final class a
  extends FloatBallHelper
{
  private long kqE;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.kqE = 0L;
    I(9, "VOIPFloatBall");
    cvL().kqZ = 10;
    if (c.gxs() != null) {
      cvL().fIZ = String.valueOf(c.gxs().NPf.NJk.NMi.DPJ);
    }
    cvG();
    AppMethodBeat.o(184042);
  }
  
  public static a gxw()
  {
    return a.NJe;
  }
  
  public final void AJ(boolean paramBoolean)
  {
    AppMethodBeat.i(241528);
    Log.i("MicroMsg.VoipFloatBallHelper", "updateHideWhenAppBackground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.rYE != null)
    {
      this.rYE.rYu = paramBoolean;
      cvG();
    }
    AppMethodBeat.o(241528);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (cvD())
      {
        if (this.rYE.bFK != paramView)
        {
          Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.rYE.bFK });
          this.rYE.rYr = true;
          this.rYE.bFK = paramView;
          this.rYE.qmt = false;
          this.rYE.rYq = true;
          bu(paramInt, paramBoolean);
          bv(paramInt, paramBoolean);
          bw(paramInt, paramBoolean);
          cvF();
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
          a.this.rYE.rYr = true;
          a.this.rYE.qmt = false;
          a.this.rYE.bFK = paramView;
          a.this.rYE.iUF = c.gxs().NPj;
          a.this.rYE.rYq = true;
          if (!c.gxs().NPj) {
            c.gxs().NPj = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.cvL();
          if (bool)
          {
            str = "3";
            localBallReportInfo.rYy = str;
            localBallReportInfo = locala.cvL();
            if (!bool) {
              break label256;
            }
          }
          label256:
          for (String str = null;; str = String.valueOf(c.gxs().NPf.NJk.NMi.DPJ))
          {
            localBallReportInfo.lEm = str;
            locala.cvL().kqY = 2;
            locala.cvG();
            a.this.bu(paramInt, paramBoolean);
            a.this.bv(paramInt, paramBoolean);
            a.this.bw(paramInt, paramBoolean);
            a.this.cvF();
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
      long l = 200L + this.kqE - Util.nowMilliSecond();
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
    AppMethodBeat.i(241523);
    if (cvD())
    {
      Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.kqE = Util.nowMilliSecond();
      cvE();
      AppMethodBeat.o(241523);
      return;
    }
    Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(241523);
  }
  
  final void bu(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.rYE.state = paramInt;
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        this.rYE.state = 512;
        return;
      }
    } while (paramInt != 8);
    this.rYE.state = 1024;
  }
  
  final void bv(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241524);
    if (this.rYE.rYm == null) {
      this.rYE.rYm = new Point();
    }
    int i = aw.aZ(MMApplicationContext.getContext(), b.b.Edge_A);
    if (paramInt == 8) {
      if (!paramBoolean)
      {
        this.rYE.rYm.x = (aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_audio_size) + i * 2);
        this.rYE.rYm.y = (aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_audio_size) + i * 2);
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.VoipFloatBallHelper", "setVoipViewSize %s, margin: %d", new Object[] { this.rYE.rYm, Integer.valueOf(i) });
      AppMethodBeat.o(241524);
      return;
      this.rYE.rYm.x = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      this.rYE.rYm.y = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
      continue;
      if (paramInt == 4) {
        if (!paramBoolean)
        {
          this.rYE.rYm.x = (aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_width) + i * 2);
          this.rYE.rYm.y = (aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_height) + i * 2);
        }
        else
        {
          this.rYE.rYm.x = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
          this.rYE.rYm.y = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
        }
      }
    }
  }
  
  final void bw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241526);
    if (((paramBoolean) || (paramInt == 4)) && (this.rYE.rYt == null)) {
      this.rYE.rYt = new BallInfo.a();
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      aw.aZ(MMApplicationContext.getContext(), b.b.Edge_A);
      i = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      j = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      k = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
      this.rYE.rYt.rYv = new Point(i, k);
      this.rYE.rYt.rYw = new Point(j, k);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %d, endWidth: %d, endHeight: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(241526);
      return;
    }
    if (paramInt == 4)
    {
      i = aw.aZ(MMApplicationContext.getContext(), b.b.Edge_A);
      j = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_width);
      k = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_height);
      int m = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_audio_width);
      int n = aw.aZ(MMApplicationContext.getContext(), b.b.float_ball_voip_view_audio_height);
      this.rYE.rYt.rYv = new Point(j + i * 2, k + i * 2);
      this.rYE.rYt.rYw = new Point(m + i * 2, i * 2 + n);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %s, endSize: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.rYE.rYt.rYv, this.rYE.rYt.rYw });
      AppMethodBeat.o(241526);
      return;
    }
    this.rYE.rYt = null;
    AppMethodBeat.o(241526);
  }
  
  public final void gxx()
  {
    AppMethodBeat.i(241529);
    Log.i("MicroMsg.VoipFloatBallHelper", "switchVoipVoice");
    this.rYE.state = 8;
    ((b)h.ae(b.class)).u(this.rYE);
    AppMethodBeat.o(241529);
  }
  
  public static final class a
  {
    public static a NJe;
    
    static
    {
      AppMethodBeat.i(184041);
      NJe = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.a
 * JD-Core Version:    0.7.0.1
 */