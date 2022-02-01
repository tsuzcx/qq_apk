package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;

public class a
  extends FloatBallHelper
{
  String TAG;
  
  protected a(String paramString)
  {
    AppMethodBeat.i(271115);
    this.TAG = "MicroMsg.GlobalMusicFloatBallHelper";
    this.TAG = paramString;
    J(gnB(), "MusicFloatBall");
    if (gnB() == 23) {
      cYv().mUU = 18;
    }
    for (;;)
    {
      cYr();
      AppMethodBeat.o(271115);
      return;
      if (gnB() == 6) {
        cYv().mUU = 1;
      }
    }
  }
  
  private void F(f paramf)
  {
    AppMethodBeat.i(271118);
    if (paramf.oPa)
    {
      AppMethodBeat.o(271118);
      return;
    }
    if (this.vjV.vjE == null) {
      this.vjV.vjE = new FloatBallMusicLyricView(MMApplicationContext.getContext());
    }
    if ((this.vjV.vjE instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.vjV.vjE).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.vjV.vjE).onResume();
    }
    AppMethodBeat.o(271118);
  }
  
  private boolean cNy()
  {
    AppMethodBeat.i(271125);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          continue;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        Log.printErrStackTrace(this.TAG, localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
        continue;
        bool = false;
        continue;
      }
      try
      {
        Log.i(this.TAG, "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        AppMethodBeat.o(271125);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public final void B(f paramf)
  {
    AppMethodBeat.i(271139);
    if (!cYo())
    {
      mr(true);
      ahU(paramf.oOx);
      ahV(paramf.oOy);
      fz("song_id", paramf.oOv);
      fz("db_music_id", b.Y(paramf));
      E(paramf);
      cYv().vjN = paramf.oOt;
      cYr();
      F(paramf);
      D(paramf);
    }
    AppMethodBeat.o(271139);
  }
  
  public final void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(271191);
    Log.v(this.TAG, "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(271191);
  }
  
  protected boolean C(f paramf)
  {
    AppMethodBeat.i(271147);
    if ((!paramf.oPa) && (gnB() == 6))
    {
      AppMethodBeat.o(271147);
      return true;
    }
    AppMethodBeat.o(271147);
    return false;
  }
  
  protected void D(f paramf)
  {
    AppMethodBeat.i(271200);
    if (paramf != null)
    {
      Log.i(this.TAG, "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.oPa) });
      if (!paramf.oPa) {
        cYq();
      }
    }
    AppMethodBeat.o(271200);
  }
  
  protected void E(f paramf)
  {
    AppMethodBeat.i(271204);
    if (!paramf.oPa)
    {
      this.vjV.state = com.tencent.mm.plugin.ball.f.d.gm(this.vjV.state, 2);
      FJ(this.vjV.state);
    }
    AppMethodBeat.o(271204);
  }
  
  public final void T(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(271169);
    Log.v(this.TAG, "onFloatBallInfoClicked, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(271169);
  }
  
  public final void U(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(271195);
    Log.v(this.TAG, "onFloatBallInfoExposed, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(271195);
  }
  
  public final void a(final ox paramox)
  {
    AppMethodBeat.i(271164);
    if (!j.isInit())
    {
      Log.e(this.TAG, "floatBallMusicActionListener don't anything, must init MusicPlayerManager first with MusicLogic before!");
      AppMethodBeat.o(271164);
      return;
    }
    label131:
    int i;
    switch (paramox.hRN.action)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
    case 0: 
    case 1: 
      label140:
      do
      {
        AppMethodBeat.o(271164);
        return;
        if (!cNy()) {
          break;
        }
        paramox = MMApplicationContext.getContext().getString(a.h.in_phone_tip);
        if (!Util.isNullOrNil(paramox)) {
          break label369;
        }
        i = 0;
      } while (i != 0);
      if (!cYo()) {
        mr(true);
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      paramox = com.tencent.mm.aw.a.bLn();
      if (!C(paramox))
      {
        Log.w(this.TAG, "can not hand musicPlayerEvent and ignore");
        AppMethodBeat.o(271164);
        return;
        if (com.tencent.mm.n.a.aTi())
        {
          paramox = MMApplicationContext.getContext().getString(a.h.in_voip_cs_tip);
          break label131;
        }
        if ((m.isVoipStarted()) || (m.icd()) || (com.tencent.mm.n.a.aTe()) || (com.tencent.mm.n.a.aTh()))
        {
          paramox = MMApplicationContext.getContext().getString(a.h.in_voip_tip);
          break label131;
        }
        if (!m.ice())
        {
          if (com.tencent.mm.kernel.h.ax(g.class) == null) {
            break label332;
          }
          paramox = ((g)com.tencent.mm.kernel.h.ax(g.class)).cjO().iterator();
          while (paramox.hasNext()) {
            if ((((AppBrandBackgroundRunningApp)paramox.next()).cIi & 0x4) > 0) {
              Log.i(this.TAG, "isAnyAppInVOIP, already exist wxa using VOIP");
            }
          }
        }
        label332:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label337;
          }
          paramox = MMApplicationContext.getContext().getString(a.h.in_voip_cs_tip);
          break;
        }
        label337:
        if ((com.tencent.mm.n.a.q(null, false)) || (com.tencent.mm.n.a.aTg()))
        {
          paramox = MMApplicationContext.getContext().getString(a.h.in_live_tip);
          break label131;
        }
        paramox = null;
        break label131;
        label369:
        com.tencent.mm.aw.a.bLi();
        com.tencent.threadpool.h.ahAA.bk(new a.2(this, paramox));
        i = 1;
        break label140;
      }
      ahU(paramox.oOx);
      ahV(paramox.oOy);
      fz("song_id", paramox.oOv);
      fz("db_music_id", b.Y(paramox));
      E(paramox);
      Log.i(this.TAG, "onMusicPlayerEvent isFromNewMusicPlayer: %s, newBall: %s", new Object[] { Boolean.valueOf(paramox.oPa), Boolean.valueOf(bool) });
      if (bool)
      {
        cYv().vjN = paramox.oOt;
        cYr();
        D(paramox);
      }
      F(paramox);
      AppMethodBeat.o(271164);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271177);
          if (com.tencent.mm.aw.a.bLk())
          {
            Log.i(a.this.TAG, "delay stop and playing music again");
            AppMethodBeat.o(271177);
            return;
          }
          if (!a.this.cYo())
          {
            AppMethodBeat.o(271177);
            return;
          }
          Object localObject = a.this.cYj();
          if ((localObject != null) && (((BallInfo)localObject).vjH))
          {
            localObject = a.this.cYv();
            if (paramox.hRN.action == 2) {}
            for (int i = 10;; i = 11)
            {
              ((BallReportInfo)localObject).opType = i;
              a.this.cYr();
              a.this.cYp();
              AppMethodBeat.o(271177);
              return;
            }
          }
          a.this.gnC();
          AppMethodBeat.o(271177);
        }
      }, 200L);
      AppMethodBeat.o(271164);
      return;
      if (!cYo()) {
        break;
      }
      paramox = com.tencent.mm.aw.a.bLn();
      ahU(paramox.oOx);
      ahV(paramox.oOy);
      fz("song_id", paramox.oOv);
      fz("db_music_id", b.Y(paramox));
      F(paramox);
      break;
    }
  }
  
  protected String d(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(271184);
    f localf = com.tencent.mm.aw.a.bLn();
    String str2 = paramBallInfo.fy("song_id", "~");
    if (localf == null) {}
    for (String str1 = "";; str1 = localf.oOv)
    {
      Log.i(this.TAG, "onFloatBallInfoRemoved, stop music id:%s current:%s, needStopMusic: %s", new Object[] { str2, str1, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (localf != null) && (com.tencent.mm.aw.a.bLk()) && (str2.equals(str1))) {
        com.tencent.mm.aw.a.bLi();
      }
      if ((paramBallInfo.vjE != null) && ((paramBallInfo.vjE instanceof FloatBallMusicLyricView)))
      {
        paramBallInfo = (FloatBallMusicLyricView)paramBallInfo.vjE;
        paramBallInfo.rDF.dead();
        j.gnw().gnj().b(paramBallInfo.LJz);
      }
      if (!paramBoolean) {
        break;
      }
      AppMethodBeat.o(271184);
      return str2;
    }
    AppMethodBeat.o(271184);
    return null;
  }
  
  protected int gnB()
  {
    return 6;
  }
  
  protected void gnC()
  {
    AppMethodBeat.i(271210);
    FJ(com.tencent.mm.plugin.ball.f.d.gn(this.vjV.state, 2));
    AppMethodBeat.o(271210);
  }
  
  static final class a
  {
    static a LLQ;
    
    static
    {
      AppMethodBeat.i(63000);
      LLQ = new a("MicroMsg.GlobalMusicFloatBallHelper");
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */