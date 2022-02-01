package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public class a
  extends FloatBallHelper
{
  String TAG;
  
  protected a(String paramString)
  {
    AppMethodBeat.i(260307);
    this.TAG = "MicroMsg.GlobalMusicFloatBallHelper";
    this.TAG = paramString;
    I(fey(), "MusicFloatBall");
    if (fey() == 23) {
      cvL().kqZ = 18;
    }
    for (;;)
    {
      cvG();
      AppMethodBeat.o(260307);
      return;
      if (fey() == 6) {
        cvL().kqZ = 1;
      }
    }
  }
  
  private void B(f paramf)
  {
    AppMethodBeat.i(260323);
    if (paramf.lVX)
    {
      AppMethodBeat.o(260323);
      return;
    }
    if (this.rYE.rYo == null) {
      this.rYE.rYo = new FloatBallMusicLyricView(MMApplicationContext.getContext());
    }
    if ((this.rYE.rYo instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.rYE.rYo).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.rYE.rYo).onResume();
    }
    AppMethodBeat.o(260323);
  }
  
  private boolean cme()
  {
    AppMethodBeat.i(260326);
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
        AppMethodBeat.o(260326);
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
  
  public static a fex()
  {
    return a.FQS;
  }
  
  protected void A(f paramf)
  {
    AppMethodBeat.i(260320);
    if (!paramf.lVX)
    {
      this.rYE.state = com.tencent.mm.plugin.ball.f.d.fu(this.rYE.state, 2);
      Fi(this.rYE.state);
    }
    AppMethodBeat.o(260320);
  }
  
  public final void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260315);
    Log.v(this.TAG, "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(260315);
  }
  
  public final void R(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260313);
    Log.v(this.TAG, "onFloatBallInfoClicked, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(260313);
  }
  
  public final void S(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(260318);
    Log.v(this.TAG, "onFloatBallInfoExposed, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(260318);
  }
  
  public final void a(final np paramnp)
  {
    AppMethodBeat.i(260312);
    if (!k.isInit())
    {
      Log.e(this.TAG, "floatBallMusicActionListener don't anything, must init MusicPlayerManager first with MusicLogic before!");
      AppMethodBeat.o(260312);
      return;
    }
    label131:
    int i;
    switch (paramnp.fMc.action)
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
        AppMethodBeat.o(260312);
        return;
        if (!cme()) {
          break;
        }
        paramnp = MMApplicationContext.getContext().getString(a.h.in_phone_tip);
        if (!Util.isNullOrNil(paramnp)) {
          break label368;
        }
        i = 0;
      } while (i != 0);
      if (!cvD()) {
        le(true);
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      paramnp = com.tencent.mm.bb.a.bnA();
      if (!y(paramnp))
      {
        Log.w(this.TAG, "can not hand musicPlayerEvent and ignore");
        AppMethodBeat.o(260312);
        return;
        if (com.tencent.mm.q.a.aAn())
        {
          paramnp = MMApplicationContext.getContext().getString(a.h.in_voip_cs_tip);
          break label131;
        }
        if ((m.isVoipStarted()) || (m.gDh()) || (com.tencent.mm.q.a.aAj()) || (com.tencent.mm.q.a.aAm()))
        {
          paramnp = MMApplicationContext.getContext().getString(a.h.in_voip_tip);
          break label131;
        }
        if (!m.gDi())
        {
          if (com.tencent.mm.kernel.h.ae(g.class) == null) {
            break label331;
          }
          paramnp = ((g)com.tencent.mm.kernel.h.ae(g.class)).bKo().iterator();
          while (paramnp.hasNext()) {
            if ((((AppBrandBackgroundRunningApp)paramnp.next()).aOm & 0x4) > 0) {
              Log.i(this.TAG, "isAnyAppInVOIP, already exist wxa using VOIP");
            }
          }
        }
        label331:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label336;
          }
          paramnp = MMApplicationContext.getContext().getString(a.h.in_voip_cs_tip);
          break;
        }
        label336:
        if ((com.tencent.mm.q.a.q(null, false)) || (com.tencent.mm.q.a.aAl()))
        {
          paramnp = MMApplicationContext.getContext().getString(a.h.in_live_tip);
          break label131;
        }
        paramnp = null;
        break label131;
        label368:
        com.tencent.mm.bb.a.bnv();
        com.tencent.e.h.ZvG.bc(new a.2(this, paramnp));
        i = 1;
        break label140;
      }
      aoy(paramnp.lVv);
      aoz(paramnp.lVw);
      fi("song_id", paramnp.lVt);
      fi("db_music_id", b.S(paramnp));
      A(paramnp);
      Log.i(this.TAG, "onMusicPlayerEvent isFromNewMusicPlayer: %s, newBall: %s", new Object[] { Boolean.valueOf(paramnp.lVX), Boolean.valueOf(bool) });
      if (bool)
      {
        cvL().rYx = paramnp.lVr;
        cvG();
        z(paramnp);
      }
      B(paramnp);
      AppMethodBeat.o(260312);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259476);
          if (com.tencent.mm.bb.a.bnx())
          {
            Log.i(a.this.TAG, "delay stop and playing music again");
            AppMethodBeat.o(259476);
            return;
          }
          if (!a.this.cvD())
          {
            AppMethodBeat.o(259476);
            return;
          }
          Object localObject = a.this.cvy();
          if ((localObject != null) && (((BallInfo)localObject).rYr))
          {
            localObject = a.this.cvL();
            if (paramnp.fMc.action == 2) {}
            for (int i = 10;; i = 11)
            {
              ((BallReportInfo)localObject).opType = i;
              a.this.cvG();
              a.this.cvE();
              AppMethodBeat.o(259476);
              return;
            }
          }
          a.this.fez();
          AppMethodBeat.o(259476);
        }
      }, 200L);
      AppMethodBeat.o(260312);
      return;
      if (!cvD()) {
        break;
      }
      paramnp = com.tencent.mm.bb.a.bnA();
      aoy(paramnp.lVv);
      aoz(paramnp.lVw);
      fi("song_id", paramnp.lVt);
      fi("db_music_id", b.S(paramnp));
      B(paramnp);
      break;
    }
  }
  
  protected String d(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(260314);
    f localf = com.tencent.mm.bb.a.bnA();
    String str2 = paramBallInfo.fh("song_id", "~");
    if (localf == null) {}
    for (String str1 = "";; str1 = localf.lVt)
    {
      Log.i(this.TAG, "onFloatBallInfoRemoved, stop music id:%s current:%s, needStopMusic: %s", new Object[] { str2, str1, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (localf != null) && (com.tencent.mm.bb.a.bnx()) && (str2.equals(str1))) {
        com.tencent.mm.bb.a.bnv();
      }
      if ((paramBallInfo.rYo != null) && ((paramBallInfo.rYo instanceof FloatBallMusicLyricView)))
      {
        paramBallInfo = (FloatBallMusicLyricView)paramBallInfo.rYo;
        paramBallInfo.ozM.dead();
        k.fet().feg().b(paramBallInfo.FOE);
      }
      if (!paramBoolean) {
        break;
      }
      AppMethodBeat.o(260314);
      return str2;
    }
    AppMethodBeat.o(260314);
    return null;
  }
  
  protected int fey()
  {
    return 6;
  }
  
  protected void fez()
  {
    AppMethodBeat.i(260321);
    Fi(com.tencent.mm.plugin.ball.f.d.fv(this.rYE.state, 2));
    AppMethodBeat.o(260321);
  }
  
  public final void x(f paramf)
  {
    AppMethodBeat.i(260308);
    if (!cvD())
    {
      le(true);
      aoy(paramf.lVv);
      aoz(paramf.lVw);
      fi("song_id", paramf.lVt);
      fi("db_music_id", b.S(paramf));
      A(paramf);
      cvL().rYx = paramf.lVr;
      cvG();
      B(paramf);
      z(paramf);
    }
    AppMethodBeat.o(260308);
  }
  
  protected boolean y(f paramf)
  {
    AppMethodBeat.i(260309);
    if ((!paramf.lVX) && (fey() == 6))
    {
      AppMethodBeat.o(260309);
      return true;
    }
    AppMethodBeat.o(260309);
    return false;
  }
  
  protected void z(f paramf)
  {
    AppMethodBeat.i(260319);
    if (paramf != null)
    {
      Log.i(this.TAG, "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.lVX) });
      if (!paramf.lVX) {
        cvF();
      }
    }
    AppMethodBeat.o(260319);
  }
  
  static final class a
  {
    static a FQS;
    
    static
    {
      AppMethodBeat.i(63000);
      FQS = new a("MicroMsg.GlobalMusicFloatBallHelper");
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */