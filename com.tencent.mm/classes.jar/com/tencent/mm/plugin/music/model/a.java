package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  bc jSq;
  bc.a jSr;
  c<yb> jSt;
  com.tencent.mm.plugin.ball.c.f kjw;
  c<mf> wkB;
  
  private a()
  {
    AppMethodBeat.i(63001);
    this.jSr = new a.1(this);
    this.jSt = new a.2(this);
    this.wkB = new c() {};
    this.kjw = new g()
    {
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(192462);
        com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
        String str2 = paramAnonymousBallInfo.ez("song_id", "~");
        if (localf == null) {}
        for (String str1 = "";; str1 = localf.ihg)
        {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoRemoved, stop music id:%s current:%s", new Object[] { str2, str1 });
          if ((localf != null) && (com.tencent.mm.az.a.aJG()) && (str2.equals(str1))) {
            com.tencent.mm.az.a.aJE();
          }
          if ((paramAnonymousBallInfo.nFU != null) && ((paramAnonymousBallInfo.nFU instanceof FloatBallMusicLyricView)))
          {
            paramAnonymousBallInfo = (FloatBallMusicLyricView)paramAnonymousBallInfo.nFU;
            paramAnonymousBallInfo.kwD.dead();
            k.dta().dsN().b(paramAnonymousBallInfo.wiu);
          }
          AppMethodBeat.o(192462);
          return;
        }
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void h(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(192463);
        ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramAnonymousBallInfo.type), paramAnonymousBallInfo.key });
        BallInfo localBallInfo = a.this.nGj;
        if (localBallInfo != null) {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myType: %d, mKey: %s", new Object[] { Integer.valueOf(localBallInfo.type), localBallInfo.key });
        }
        if (paramAnonymousBallInfo.equals(localBallInfo))
        {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myself");
          AppMethodBeat.o(192463);
          return;
        }
        if ((18 == paramAnonymousBallInfo.type) || (9 == paramAnonymousBallInfo.type) || (17 == paramAnonymousBallInfo.type))
        {
          if ((com.tencent.mm.az.a.aJJ() != null) && (com.tencent.mm.az.a.aJG())) {
            com.tencent.mm.az.a.aJC();
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192461);
              a.this.bKA();
              AppMethodBeat.o(192461);
            }
          });
        }
        AppMethodBeat.o(192463);
      }
    };
    ac(6, "MusicFloatBall");
    bKG().nGc = 1;
    bKC();
    AppMethodBeat.o(63001);
  }
  
  static boolean bBr()
  {
    AppMethodBeat.i(192466);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
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
        ad.printErrStackTrace("MicroMsg.GlobalMusicFloatBallHelper", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ad.i("MicroMsg.GlobalMusicFloatBallHelper", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        AppMethodBeat.o(192466);
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
  
  public final void x(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(192465);
    if (this.nGj.nFU == null) {
      this.nGj.nFU = new FloatBallMusicLyricView(aj.getContext());
    }
    if ((this.nGj.nFU instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.nGj.nFU).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.nGj.nFU).onResume();
    }
    AppMethodBeat.o(192465);
  }
  
  public static final class a
  {
    public static a wkG;
    
    static
    {
      AppMethodBeat.i(63000);
      wkG = new a((byte)0);
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */