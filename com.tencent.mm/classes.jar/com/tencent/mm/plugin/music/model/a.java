package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ln.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  bc iYc;
  bc.a iYd;
  c<ww> iYf;
  com.tencent.mm.plugin.ball.c.f jpa;
  c<ln> tWw;
  
  private a()
  {
    AppMethodBeat.i(63001);
    this.iYd = new a.1(this);
    this.iYf = new a.2(this);
    this.tWw = new c() {};
    this.jpa = new g()
    {
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(190244);
        com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
        String str = paramAnonymousBallInfo.ee("song_id", "~");
        if (localf == null) {}
        for (paramAnonymousBallInfo = "";; paramAnonymousBallInfo = localf.hnp)
        {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoRemoved, stop music id:%s current:%s", new Object[] { str, paramAnonymousBallInfo });
          if ((localf != null) && (com.tencent.mm.az.a.azF()) && (str.equals(paramAnonymousBallInfo))) {
            com.tencent.mm.az.a.azD();
          }
          AppMethodBeat.o(190244);
          return;
        }
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void s(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(190245);
        ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramAnonymousBallInfo.type), paramAnonymousBallInfo.key });
        BallInfo localBallInfo = a.this.mDH;
        if (localBallInfo != null) {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myType: %d, mKey: %s", new Object[] { Integer.valueOf(localBallInfo.type), localBallInfo.key });
        }
        if (paramAnonymousBallInfo.equals(localBallInfo))
        {
          ad.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myself");
          AppMethodBeat.o(190245);
          return;
        }
        if ((18 == paramAnonymousBallInfo.type) || (9 == paramAnonymousBallInfo.type) || (17 == paramAnonymousBallInfo.type)) {
          a.this.bzt();
        }
        AppMethodBeat.o(190245);
      }
    };
    Z(6, "MusicFloatBall");
    bzz().mDz = 1;
    bzv();
    AppMethodBeat.o(63001);
  }
  
  static boolean bvl()
  {
    AppMethodBeat.i(190247);
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
        AppMethodBeat.o(190247);
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
  
  public static final class a
  {
    public static a tWA;
    
    static
    {
      AppMethodBeat.i(63000);
      tWA = new a((byte)0);
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */