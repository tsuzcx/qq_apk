package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  bd jVH;
  bd.a jVI;
  c<yh> jVK;
  com.tencent.mm.plugin.ball.c.f kmM;
  c<mg> wAk;
  
  private a()
  {
    AppMethodBeat.i(63001);
    this.jVI = new bd.a()
    {
      public final void kM(int paramAnonymousInt)
      {
        AppMethodBeat.i(220668);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(220668);
          return;
          AppMethodBeat.o(220668);
          return;
          ae.i("MicroMsg.GlobalMusicFloatBallHelper", "onPhoneCall, removeCurrentBall, state:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          a.this.bLx();
        }
      }
    };
    this.jVK = new c() {};
    this.wAk = new c() {};
    this.kmM = new g()
    {
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(220675);
        com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
        String str2 = paramAnonymousBallInfo.eC("song_id", "~");
        if (localf == null) {}
        for (String str1 = "";; str1 = localf.ijZ)
        {
          ae.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoRemoved, stop music id:%s current:%s", new Object[] { str2, str1 });
          if ((localf != null) && (com.tencent.mm.ay.a.aJZ()) && (str2.equals(str1))) {
            com.tencent.mm.ay.a.aJX();
          }
          if ((paramAnonymousBallInfo.nLr != null) && ((paramAnonymousBallInfo.nLr instanceof FloatBallMusicLyricView)))
          {
            paramAnonymousBallInfo = (FloatBallMusicLyricView)paramAnonymousBallInfo.nLr;
            paramAnonymousBallInfo.kzS.dead();
            k.dwp().dwc().b(paramAnonymousBallInfo.wxZ);
          }
          AppMethodBeat.o(220675);
          return;
        }
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void h(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(220676);
        ae.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramAnonymousBallInfo.type), paramAnonymousBallInfo.key });
        BallInfo localBallInfo = a.this.nLK;
        if (localBallInfo != null) {
          ae.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myType: %d, mKey: %s", new Object[] { Integer.valueOf(localBallInfo.type), localBallInfo.key });
        }
        if (paramAnonymousBallInfo.equals(localBallInfo))
        {
          ae.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myself");
          AppMethodBeat.o(220676);
          return;
        }
        if ((18 == paramAnonymousBallInfo.type) || (9 == paramAnonymousBallInfo.type) || (17 == paramAnonymousBallInfo.type))
        {
          if ((com.tencent.mm.ay.a.aKc() != null) && (com.tencent.mm.ay.a.aJZ())) {
            com.tencent.mm.ay.a.aJV();
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220674);
              a.this.bLx();
              AppMethodBeat.o(220674);
            }
          });
        }
        AppMethodBeat.o(220676);
      }
    };
    ac(6, "MusicFloatBall");
    bLD().nLC = 1;
    bLz();
    AppMethodBeat.o(63001);
  }
  
  static boolean bCl()
  {
    AppMethodBeat.i(220679);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ak.getContext().getSystemService("phone");
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
        ae.printErrStackTrace("MicroMsg.GlobalMusicFloatBallHelper", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ae.i("MicroMsg.GlobalMusicFloatBallHelper", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        AppMethodBeat.o(220679);
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
  
  public final void x(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(220678);
    if (this.nLK.nLr == null) {
      this.nLK.nLr = new FloatBallMusicLyricView(ak.getContext());
    }
    if ((this.nLK.nLr instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.nLK.nLr).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.nLK.nLr).onResume();
    }
    AppMethodBeat.o(220678);
  }
  
  public static final class a
  {
    public static a wAp;
    
    static
    {
      AppMethodBeat.i(63000);
      wAp = new a((byte)0);
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */