package com.tencent.mm.plugin.voip.c;

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
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;

public final class a
  extends FloatBallHelper
{
  private long mUE;
  
  private a()
  {
    AppMethodBeat.i(184042);
    this.mUE = 0L;
    J(9, "VOIPFloatBall");
    cYv().mUU = 10;
    if (SubCoreVoip.hVp() != null) {
      cYv().hOH = String.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
    }
    cYr();
    AppMethodBeat.o(184042);
  }
  
  public final void Gi(boolean paramBoolean)
  {
    AppMethodBeat.i(292310);
    Log.i("MicroMsg.VoipFloatBallHelper", "updateHideWhenAppBackground %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.vjV != null)
    {
      this.vjV.vjK = paramBoolean;
      cYr();
    }
    AppMethodBeat.o(292310);
  }
  
  public final void a(final int paramInt, final boolean paramBoolean, final View paramView)
  {
    AppMethodBeat.i(184043);
    if ((paramView != null) && ((paramInt == 4) || (paramInt == 8)))
    {
      if (cYo())
      {
        if (this.vjV.dyK != paramView)
        {
          Log.i("MicroMsg.VoipFloatBallHelper", "addVoipView, has ball, but view is different, state:%s, view:%s, ballInfo.customView:%s", new Object[] { Integer.valueOf(paramInt), paramView, this.vjV.dyK });
          this.vjV.vjH = true;
          this.vjV.dyK = paramView;
          this.vjV.trn = false;
          this.vjV.vjG = true;
          cc(paramInt, paramBoolean);
          cd(paramInt, paramBoolean);
          ce(paramInt, paramBoolean);
          cYq();
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
          a.this.vjV.vjH = true;
          a.this.vjV.trn = false;
          a.this.vjV.dyK = paramView;
          a.this.vjV.lwK = SubCoreVoip.hVp().UBI;
          a.this.vjV.vjG = true;
          if (!SubCoreVoip.hVp().UBI) {
            SubCoreVoip.hVp().UBI = true;
          }
          a locala = a.this;
          int i = paramInt;
          boolean bool = paramBoolean;
          BallReportInfo localBallReportInfo = locala.cYv();
          if (bool)
          {
            str = "3";
            localBallReportInfo.vjO = str;
            localBallReportInfo = locala.cYv();
            if (!bool) {
              break label256;
            }
          }
          label256:
          for (String str = null;; str = String.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt))
          {
            localBallReportInfo.ovT = str;
            locala.cYv().mUT = 2;
            locala.cYr();
            a.this.cc(paramInt, paramBoolean);
            a.this.cd(paramInt, paramBoolean);
            a.this.ce(paramInt, paramBoolean);
            a.this.cYq();
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
      long l = 200L + this.mUE - Util.nowMilliSecond();
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
    AppMethodBeat.i(292252);
    if (cYo())
    {
      Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, has ball, view:%s", new Object[] { paramFrameLayout });
      this.mUE = Util.nowMilliSecond();
      cYp();
      AppMethodBeat.o(292252);
      return;
    }
    Log.i("MicroMsg.VoipFloatBallHelper", "removeVoipView, no ball, view:%s", new Object[] { paramFrameLayout });
    AppMethodBeat.o(292252);
  }
  
  final void cc(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.vjV.state = paramInt;
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        this.vjV.state = 512;
        return;
      }
    } while (paramInt != 8);
    this.vjV.state = 1024;
  }
  
  final void cd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292281);
    if (this.vjV.vjC == null) {
      this.vjV.vjC = new Point();
    }
    int i = bd.bs(MMApplicationContext.getContext(), b.b.Edge_A);
    if (paramInt == 8) {
      if (!paramBoolean)
      {
        this.vjV.vjC.x = (bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_audio_size) + i * 2);
        this.vjV.vjC.y = (bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_audio_size) + i * 2);
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.VoipFloatBallHelper", "setVoipViewSize %s, margin: %d", new Object[] { this.vjV.vjC, Integer.valueOf(i) });
      AppMethodBeat.o(292281);
      return;
      this.vjV.vjC.x = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      this.vjV.vjC.y = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
      continue;
      if (paramInt == 4) {
        if (!paramBoolean)
        {
          this.vjV.vjC.x = (bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_width) + i * 2);
          this.vjV.vjC.y = (bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_height) + i * 2);
        }
        else
        {
          this.vjV.vjC.x = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
          this.vjV.vjC.y = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
        }
      }
    }
  }
  
  final void ce(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292299);
    if (((paramBoolean) || (paramInt == 4)) && (this.vjV.vjJ == null)) {
      this.vjV.vjJ = new BallInfo.a();
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      bd.bs(MMApplicationContext.getContext(), b.b.Edge_A);
      i = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      j = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_width);
      k = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_multi_talk_video_total_height);
      this.vjV.vjJ.vjL = new Point(i, k);
      this.vjV.vjJ.vjM = new Point(j, k);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %d, endWidth: %d, endHeight: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(292299);
      return;
    }
    if (paramInt == 4)
    {
      i = bd.bs(MMApplicationContext.getContext(), b.b.Edge_A);
      j = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_width);
      k = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_video_height);
      int m = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_audio_width);
      int n = bd.bs(MMApplicationContext.getContext(), b.b.float_ball_voip_view_audio_height);
      this.vjV.vjJ.vjL = new Point(j + i * 2, k + i * 2);
      this.vjV.vjJ.vjM = new Point(m + i * 2, i * 2 + n);
      Log.d("MicroMsg.VoipFloatBallHelper", "setAnimationInfo isMultiTalk: %b, state: %d, startSize: %s, endSize: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.vjV.vjJ.vjL, this.vjV.vjJ.vjM });
      AppMethodBeat.o(292299);
      return;
    }
    this.vjV.vjJ = null;
    AppMethodBeat.o(292299);
  }
  
  public final void hVt()
  {
    AppMethodBeat.i(292262);
    this.vjV.vjI.opType = 3;
    ((b)h.ax(b.class)).m(this.vjV);
    AppMethodBeat.o(292262);
  }
  
  public final void hVu()
  {
    AppMethodBeat.i(292319);
    Log.i("MicroMsg.VoipFloatBallHelper", "switchVoipVoice");
    this.vjV.state = 8;
    ((b)h.ax(b.class)).u(this.vjV);
    AppMethodBeat.o(292319);
  }
  
  public static final class a
  {
    public static a Uvh;
    
    static
    {
      AppMethodBeat.i(184041);
      Uvh = new a((byte)0);
      AppMethodBeat.o(184041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.a
 * JD-Core Version:    0.7.0.1
 */