package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.a;

public final class a
  extends com.tencent.mm.plugin.ball.service.a
{
  com.tencent.mm.plugin.ball.c.f jPm;
  bb jyt;
  bb.a jyu;
  c<xh> jyw;
  c<lw> vfg;
  
  private a()
  {
    AppMethodBeat.i(63001);
    this.jyu = new a.1(this);
    this.jyw = new a.2(this);
    this.vfg = new c() {};
    this.jPm = new g()
    {
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(195604);
        com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
        String str2 = paramAnonymousBallInfo.eq("song_id", "~");
        if (localf == null) {}
        for (String str1 = "";; str1 = localf.hNS)
        {
          ac.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoRemoved, stop music id:%s current:%s", new Object[] { str2, str1 });
          if ((localf != null) && (com.tencent.mm.ay.a.aGv()) && (str2.equals(str1))) {
            com.tencent.mm.ay.a.aGt();
          }
          if ((paramAnonymousBallInfo.nfy != null) && ((paramAnonymousBallInfo.nfy instanceof FloatBallMusicLyricView)))
          {
            paramAnonymousBallInfo = (FloatBallMusicLyricView)paramAnonymousBallInfo.nfy;
            paramAnonymousBallInfo.kce.dead();
            k.diO().diB().b(paramAnonymousBallInfo.vcY);
          }
          AppMethodBeat.o(195604);
          return;
        }
      }
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
      
      public final void g(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(195605);
        ac.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, type: %d, key: %s", new Object[] { Integer.valueOf(paramAnonymousBallInfo.type), paramAnonymousBallInfo.key });
        BallInfo localBallInfo = a.this.nfN;
        if (localBallInfo != null) {
          ac.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myType: %d, mKey: %s", new Object[] { Integer.valueOf(localBallInfo.type), localBallInfo.key });
        }
        if (paramAnonymousBallInfo.equals(localBallInfo))
        {
          ac.i("MicroMsg.GlobalMusicFloatBallHelper", "onFloatBallInfoAdded, myself");
          AppMethodBeat.o(195605);
          return;
        }
        if ((18 == paramAnonymousBallInfo.type) || (9 == paramAnonymousBallInfo.type) || (17 == paramAnonymousBallInfo.type))
        {
          if ((com.tencent.mm.ay.a.aGy() != null) && (com.tencent.mm.ay.a.aGv())) {
            com.tencent.mm.ay.a.aGr();
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195603);
              a.this.bGp();
              AppMethodBeat.o(195603);
            }
          });
        }
        AppMethodBeat.o(195605);
      }
    };
    aa(6, "MusicFloatBall");
    bGv().nfG = 1;
    bGr();
    AppMethodBeat.o(63001);
  }
  
  static boolean bxn()
  {
    AppMethodBeat.i(195608);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ai.getContext().getSystemService("phone");
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
        ac.printErrStackTrace("MicroMsg.GlobalMusicFloatBallHelper", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ac.i("MicroMsg.GlobalMusicFloatBallHelper", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        AppMethodBeat.o(195608);
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
    AppMethodBeat.i(195607);
    if (this.nfN.nfy == null) {
      this.nfN.nfy = new FloatBallMusicLyricView(ai.getContext());
    }
    if ((this.nfN.nfy instanceof FloatBallMusicLyricView))
    {
      ((FloatBallMusicLyricView)this.nfN.nfy).setMusicWrapper(paramf);
      ((FloatBallMusicLyricView)this.nfN.nfy).onResume();
    }
    AppMethodBeat.o(195607);
  }
  
  public static final class a
  {
    public static a vfl;
    
    static
    {
      AppMethodBeat.i(63000);
      vfl = new a((byte)0);
      AppMethodBeat.o(63000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a
 * JD-Core Version:    0.7.0.1
 */