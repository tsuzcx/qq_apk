package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;

public final class e
{
  IListener Kvi;
  IListener RzK;
  private KeyguardManager WiC;
  IListener WiD;
  IListener WiE;
  IListener WiF;
  IListener WiG;
  IListener WiH;
  MTimerHandler eln;
  IListener ltN;
  private PowerManager powerManager;
  IListener tje;
  public i.a zOk;
  
  public e()
  {
    AppMethodBeat.i(30000);
    this.RzK = new WearLogic.1(this, f.hfK);
    this.WiD = new WearLogic.2(this, f.hfK);
    this.WiE = new WearLogic.3(this, f.hfK);
    this.tje = new WearLogic.4(this, f.hfK);
    this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29995);
        a.inJ().a(new com.tencent.mm.plugin.wear.model.f.a());
        AppMethodBeat.o(29995);
        return true;
      }
    }, true);
    this.WiF = new WearLogic.6(this, f.hfK);
    this.WiG = new WearLogic.7(this, f.hfK);
    this.WiH = new WearLogic.8(this, f.hfK);
    this.ltN = new WearLogic.9(this, f.hfK);
    this.zOk = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(29988);
        if (CrashReportFactory.isBackupMerge())
        {
          AppMethodBeat.o(29988);
          return;
        }
        if (paramAnonymousc == null)
        {
          AppMethodBeat.o(29988);
          return;
        }
        if (Util.isNullOrNil(paramAnonymousc.talker))
        {
          AppMethodBeat.o(29988);
          return;
        }
        if ((paramAnonymousc.KRn > 0) && (a.inI() != null) && (paramAnonymousc.talker.equals(a.inI().WiA.Wjl))) {
          a.inJ().a(new com.tencent.mm.plugin.wear.model.f.c()
          {
            public final String getName()
            {
              return "SendMsgSyncTask";
            }
            
            public final void send()
            {
              AppMethodBeat.i(29987);
              try
              {
                a.inM();
                r.a(20007, a.inI().WiA.Wjl.getBytes("utf8"), false);
                AppMethodBeat.o(29987);
                return;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                AppMethodBeat.o(29987);
              }
            }
          });
        }
        AppMethodBeat.o(29988);
      }
    };
    this.Kvi = new WearLogic.11(this, f.hfK);
    Log.i("MicroMsg.Wear.WearLogic", "Create!");
    this.RzK.alive();
    this.WiD.alive();
    this.WiE.alive();
    this.tje.alive();
    this.WiF.alive();
    this.WiG.alive();
    this.WiH.alive();
    this.ltN.alive();
    this.Kvi.alive();
    this.eln.startTimer(1800000L);
    this.powerManager = ((PowerManager)MMApplicationContext.getContext().getSystemService("power"));
    this.WiC = ((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard"));
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(this.zOk, null);
    AppMethodBeat.o(30000);
  }
  
  public static void B(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30001);
    a.inJ().a(new com.tencent.mm.plugin.wear.model.f.j(paramString, paramInt, paramBoolean));
    AppMethodBeat.o(30001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e
 * JD-Core Version:    0.7.0.1
 */