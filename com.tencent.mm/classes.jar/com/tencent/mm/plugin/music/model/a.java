package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public class a
  extends com.tencent.mm.plugin.ball.service.a
{
  String TAG;
  
  protected a(String paramString)
  {
    AppMethodBeat.i(219820);
    this.TAG = "MicroMsg.GlobalMusicFloatBallHelper";
    this.TAG = paramString;
    G(euo(), "MusicFloatBall");
    ciw().hDa = 1;
    cit();
    AppMethodBeat.o(219820);
  }
  
  private void B(f paramf)
  {
    AppMethodBeat.i(219831);
    if (paramf.jfx)
    {
      AppMethodBeat.o(219831);
      return;
    }
    if (this.oWE.oWo == null) {
      this.oWE.oWo = new FloatBallMusicLyricView(MMApplicationContext.getContext());
    }
    if ((this.oWE.oWo instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.oWE.oWo).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.oWE.oWo).onResume();
    }
    AppMethodBeat.o(219831);
  }
  
  private boolean bZp()
  {
    AppMethodBeat.i(219832);
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
        AppMethodBeat.o(219832);
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
  
  public static a eun()
  {
    return a.AjU;
  }
  
  protected void A(f paramf)
  {
    AppMethodBeat.i(219829);
    if (!paramf.jfx)
    {
      this.oWE.state = com.tencent.mm.plugin.ball.f.d.eV(this.oWE.state, 2);
      BH(this.oWE.state);
    }
    AppMethodBeat.o(219829);
  }
  
  public final void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(219826);
    Log.v(this.TAG, "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(219826);
  }
  
  public void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(219825);
    f localf = com.tencent.mm.ay.a.bef();
    String str2 = paramBallInfo.eT("song_id", "~");
    if (localf == null) {}
    for (String str1 = "";; str1 = localf.jeV)
    {
      Log.i(this.TAG, "onFloatBallInfoRemoved, stop music id:%s current:%s", new Object[] { str2, str1 });
      if ((localf != null) && (com.tencent.mm.ay.a.bec()) && (str2.equals(str1))) {
        com.tencent.mm.ay.a.bea();
      }
      if ((paramBallInfo.oWo != null) && ((paramBallInfo.oWo instanceof FloatBallMusicLyricView)))
      {
        paramBallInfo = (FloatBallMusicLyricView)paramBallInfo.oWo;
        paramBallInfo.lEl.dead();
        k.euj().etW().c(paramBallInfo.AhI);
      }
      AppMethodBeat.o(219825);
      return;
    }
  }
  
  public final void Q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(219824);
    Log.v(this.TAG, "onFloatBallInfoClicked, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(219824);
  }
  
  public final void R(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(219827);
    Log.v(this.TAG, "onFloatBallInfoExposed, type: %d, key: %s", new Object[] { Integer.valueOf(paramBallInfo.type), paramBallInfo.key });
    AppMethodBeat.o(219827);
  }
  
  public final void a(final mx parammx)
  {
    AppMethodBeat.i(219823);
    if (!k.isInit())
    {
      Log.e(this.TAG, "floatBallMusicActionListener don't anything, must init MusicPlayerManager first with MusicLogic before!");
      AppMethodBeat.o(219823);
      return;
    }
    label131:
    int i;
    switch (parammx.dSE.action)
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
        AppMethodBeat.o(219823);
        return;
        if (!bZp()) {
          break;
        }
        parammx = MMApplicationContext.getContext().getString(2131761778);
        if (!Util.isNullOrNil(parammx)) {
          break label369;
        }
        i = 0;
      } while (i != 0);
      if (!ciq()) {
        jT(true);
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      parammx = com.tencent.mm.ay.a.bef();
      if (!y(parammx))
      {
        Log.w(this.TAG, "can not hand musicPlayerEvent and ignore");
        AppMethodBeat.o(219823);
        return;
        if (com.tencent.mm.q.a.atx())
        {
          parammx = MMApplicationContext.getContext().getString(2131761780);
          break label131;
        }
        if ((m.isVoipStarted()) || (m.fKH()) || (com.tencent.mm.q.a.att()) || (com.tencent.mm.q.a.atw()))
        {
          parammx = MMApplicationContext.getContext().getString(2131761781);
          break label131;
        }
        if (!m.fKI())
        {
          if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) == null) {
            break label332;
          }
          parammx = ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).byZ().iterator();
          while (parammx.hasNext()) {
            if ((((AppBrandBackgroundRunningApp)parammx.next()).beL & 0x4) > 0) {
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
          parammx = MMApplicationContext.getContext().getString(2131761780);
          break;
        }
        label337:
        if ((com.tencent.mm.q.a.p(null, false)) || (com.tencent.mm.q.a.atu()))
        {
          parammx = MMApplicationContext.getContext().getString(2131761775);
          break label131;
        }
        parammx = null;
        break label131;
        label369:
        com.tencent.mm.ay.a.bea();
        h.RTc.aV(new a.2(this, parammx));
        i = 1;
        break label140;
      }
      agT(parammx.jeX);
      agU(parammx.jeY);
      eU("song_id", parammx.jeV);
      eU("db_music_id", b.S(parammx));
      A(parammx);
      Log.i(this.TAG, "onMusicPlayerEvent isFromNewMusicPlayer: %s, newBall: %s", new Object[] { Boolean.valueOf(parammx.jfx), Boolean.valueOf(bool) });
      if (bool)
      {
        ciw().oWx = parammx.jeT;
        cit();
        z(parammx);
      }
      B(parammx);
      AppMethodBeat.o(219823);
      return;
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219818);
          if (com.tencent.mm.ay.a.bec())
          {
            Log.i(a.this.TAG, "delay stop and playing music again");
            AppMethodBeat.o(219818);
            return;
          }
          if (!a.this.ciq())
          {
            AppMethodBeat.o(219818);
            return;
          }
          Object localObject = a.this.cim();
          if ((localObject != null) && (((BallInfo)localObject).oWr))
          {
            localObject = a.this.ciw();
            if (parammx.dSE.action == 2) {}
            for (int i = 10;; i = 11)
            {
              ((BallReportInfo)localObject).opType = i;
              a.this.cit();
              a.this.cir();
              AppMethodBeat.o(219818);
              return;
            }
          }
          a.this.eup();
          AppMethodBeat.o(219818);
        }
      }, 200L);
      AppMethodBeat.o(219823);
      return;
      if (!ciq()) {
        break;
      }
      parammx = com.tencent.mm.ay.a.bef();
      agT(parammx.jeX);
      agU(parammx.jeY);
      eU("song_id", parammx.jeV);
      eU("db_music_id", b.S(parammx));
      B(parammx);
      break;
    }
  }
  
  protected int euo()
  {
    return 6;
  }
  
  protected void eup()
  {
    AppMethodBeat.i(219830);
    BH(com.tencent.mm.plugin.ball.f.d.eW(this.oWE.state, 2));
    AppMethodBeat.o(219830);
  }
  
  public final void x(f paramf)
  {
    AppMethodBeat.i(219821);
    if (!ciq())
    {
      jT(true);
      agT(paramf.jeX);
      agU(paramf.jeY);
      eU("song_id", paramf.jeV);
      eU("db_music_id", b.S(paramf));
      A(paramf);
      ciw().oWx = paramf.jeT;
      cit();
      B(paramf);
      z(paramf);
    }
    AppMethodBeat.o(219821);
  }
  
  protected boolean y(f paramf)
  {
    AppMethodBeat.i(219822);
    if ((!paramf.jfx) && (euo() == 6))
    {
      AppMethodBeat.o(219822);
      return true;
    }
    AppMethodBeat.o(219822);
    return false;
  }
  
  protected void z(f paramf)
  {
    AppMethodBeat.i(219828);
    if (paramf != null)
    {
      Log.i(this.TAG, "addMusicFloatBall isFromNewMusicPlayer: %s", new Object[] { Boolean.valueOf(paramf.jfx) });
      if (!paramf.jfx) {
        cis();
      }
    }
    AppMethodBeat.o(219828);
  }
  
  static final class a
  {
    static a AjU;
    
    static
    {
      AppMethodBeat.i(63000);
      AjU = new a("MicroMsg.GlobalMusicFloatBallHelper");
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */