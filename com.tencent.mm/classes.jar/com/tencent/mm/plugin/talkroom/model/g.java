package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL;
import com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL.a;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.flx;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.protocal.protobuf.flz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MAlarmHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements h, com.tencent.mm.bc.a, com.tencent.mm.bc.c, aq
{
  public static final int[] SOd = { 80, 8080, 16285 };
  public static final byte[][] SOe = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  public boolean GNB;
  private long Hnt;
  private int SNO;
  private int SNP;
  private boolean SNQ;
  public String SNR;
  private int SNS;
  private int SNT;
  private int SNU;
  private LinkedList<flx> SNV;
  private com.tencent.mm.plugin.talkroom.component.a SNW;
  private ILiveConEngineCallback_AIDL SNX;
  private com.tencent.mm.plugin.talkroom.component.d SNY;
  private com.tencent.mm.plugin.talkroom.component.c SNZ;
  private MAlarmHandler SOa;
  private MTimerHandler SOb;
  private i SOc;
  private int roomId;
  private int state;
  private final ServiceConnection wOI;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.SNO = 0;
    this.SNP = 0;
    this.state = 0;
    this.SNQ = false;
    this.SNV = new LinkedList();
    this.SOc = new i();
    this.wOI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        Log.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).w("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.L(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.Ff(true);
              AppMethodBeat.o(29482);
            }
          });
        }
        AppMethodBeat.o(29483);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(29484);
        Log.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        AppMethodBeat.o(29484);
      }
    };
    this.GNB = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private void Fe(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (Util.isNullOrNil(this.SNR))
    {
      AppMethodBeat.o(29504);
      return;
    }
    bh.bCz();
    bb localbb = com.tencent.mm.model.c.bzG().bxM(this.SNR);
    if (localbb == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localbb.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, i, localbb.field_conversationTime));
      bh.bCz();
      com.tencent.mm.model.c.bzG().c(localbb, this.SNR);
      AppMethodBeat.o(29504);
      return;
    }
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.SNW != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.SNW.f(arrayOfInt, paramString);
        int i = arrayOfInt[0];
        AppMethodBeat.o(29520);
        return i;
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          Log.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(29520);
    return -99;
  }
  
  private void anO(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.SNW != null) {
      try
      {
        hCH();
        AppMethodBeat.o(29510);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        AppMethodBeat.o(29510);
        return;
      }
    }
    if (paramInt == 0)
    {
      this.SOc.w("bind talkroomService timeout", 3, -1);
      AppMethodBeat.o(29510);
      return;
    }
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29490);
        g.a(g.this, paramInt - 1);
        AppMethodBeat.o(29490);
      }
    }, 50L);
    AppMethodBeat.o(29510);
  }
  
  private void anP(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.SNS)
    {
      this.SNS = paramInt;
      if (this.state >= 3) {
        this.SOc.wZ(311);
      }
      hCG();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String anQ(int paramInt)
  {
    AppMethodBeat.i(29516);
    try
    {
      String str = InetAddress.getByAddress(new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) }).getHostAddress();
      AppMethodBeat.o(29516);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
      AppMethodBeat.o(29516);
    }
    return null;
  }
  
  private boolean hCD()
  {
    AppMethodBeat.i(29499);
    if (hCB() == 1) {
      b(b.hCs());
    }
    while (this.SNP > 0)
    {
      Log.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.hCs());
    }
    bh.aZW().a(332, this);
    bh.aZW().a(334, this);
    bh.aZW().a(336, this);
    bh.aZW().a(335, this);
    b.hCp().a(this);
    bh.aDI().a(this);
    this.SNP = 1;
    if (this.SNW != null) {}
    try
    {
      this.SNW.Close();
      this.SNW.uninitLive();
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().bindService(localIntent, this.wOI, 1);
      this.SNX = new ILiveConEngineCallback_AIDL.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          Log.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.hCt().hCy();
          b.hCt().SNl = 1;
          g.a(g.this).w("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.hCE();
              AppMethodBeat.o(29486);
            }
          });
          AppMethodBeat.o(29488);
        }
        
        public final void keep_OnOpenSuccess()
        {
          AppMethodBeat.i(29487);
          Log.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
          if (g.b(g.this) != 1)
          {
            Log.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(g.this)) });
            AppMethodBeat.o(29487);
            return;
          }
          b.hCt().hCy();
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29485);
              g.c(g.this);
              AppMethodBeat.o(29485);
            }
          });
          g.d(g.this);
          g.a(g.this).bNv();
          AppMethodBeat.o(29487);
        }
      };
      AppMethodBeat.o(29499);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void hCF()
  {
    AppMethodBeat.i(29503);
    if (this.SNY != null) {}
    try
    {
      this.SNY.release();
      this.SNY = null;
      if (this.SNZ == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.SNZ.release();
        this.SNZ = null;
        if (this.SOa != null)
        {
          this.SOa.stopTimer();
          this.SOa = null;
        }
        if (this.SOb != null)
        {
          this.SOb.stopTimer();
          this.SOb = null;
        }
        AppMethodBeat.o(29503);
        return;
        localRemoteException1 = localRemoteException1;
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void hCG()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.hCt().hCA();
      if (this.SNZ != null) {
        this.SNZ.hCj();
      }
      if (this.SNY != null) {
        this.SNY.bcl();
      }
      this.state = 2;
      AppMethodBeat.o(29508);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29508);
    }
  }
  
  private void hCH()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.SNQ = false;
    if (!hCI())
    {
      AppMethodBeat.o(29511);
      return;
    }
    hCF();
    hCK();
    hCJ();
    if (this.SOa != null)
    {
      Log.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.SOa = new MAlarmHandler(new MAlarmHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29491);
        if ((g.e(g.this) == 0) || (Util.isNullOrNil(g.g(g.this))))
        {
          Log.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(g.this)), g.g(g.this) });
          g.h(g.this);
          AppMethodBeat.o(29491);
          return false;
        }
        Object localObject = g.g(g.this);
        int i = g.e(g.this);
        long l = g.f(g.this);
        g localg = g.this;
        g.g(g.this);
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.hCB());
        bh.aZW().a((p)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    }, true);
    this.SOa.startTimer(50000L);
    AppMethodBeat.o(29511);
  }
  
  private boolean hCI()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.SNW.hCe();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      AppMethodBeat.o(29512);
    }
    Log.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.SNW = null;
      Log.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.SOc.w("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void hCJ()
  {
    AppMethodBeat.i(29515);
    if (this.SNW == null)
    {
      Log.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.SNY = this.SNW.a(new b.a()
    {
      public final void P(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).Pw("");
          AppMethodBeat.o(29492);
          return;
        }
        g.c(g.this, paramAnonymousInt2);
        if (g.i(g.this) == paramAnonymousInt1)
        {
          AppMethodBeat.o(29492);
          return;
        }
        g.b(g.this, paramAnonymousInt1);
        String str = g.this.hCC();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.hCB());
          bh.aZW().a((p)localObject, 0);
          localObject = b.hCt();
          ((f)localObject).SNt += 1;
          localObject = b.hCt();
          ((f)localObject).SNu += 1;
        }
        g.a(g.this).Pw(str);
        PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_othersbegin);
        AppMethodBeat.o(29492);
      }
    });
    this.SNY.start();
    this.SNZ = this.SNW.hCf();
    this.SNZ.start();
    AppMethodBeat.o(29515);
  }
  
  private void hCK()
  {
    AppMethodBeat.i(29517);
    if (this.SNV.size() == 0)
    {
      Log.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.SOc.k(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.SNV.size()];
    int[] arrayOfInt2 = new int[this.SNV.size()];
    String[] arrayOfString = new String[this.SNV.size()];
    Log.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.SNV.size()) });
    int i = 0;
    while (i < this.SNV.size())
    {
      arrayOfInt1[i] = ((flx)this.SNV.get(i)).abMm;
      arrayOfInt2[i] = ((flx)this.SNV.get(i)).abmN;
      arrayOfString[i] = ((flx)this.SNV.get(i)).abMn;
      Log.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { anQ(((flx)this.SNV.get(i)).abMm), ((flx)this.SNV.get(i)).abMn, Integer.valueOf(((flx)this.SNV.get(i)).abmN) });
      i += 1;
    }
    Log.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.SNT), Integer.valueOf(this.roomId), Long.valueOf(this.Hnt) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.SNW;
      ILiveConEngineCallback_AIDL localILiveConEngineCallback_AIDL = this.SNX;
      bh.bCz();
      i = locala.a(localILiveConEngineCallback_AIDL, com.tencent.mm.model.c.getUin(), this.SNT, this.roomId, this.Hnt, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        Log.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.SOc.k(3, i, "engine.Open error");
      }
      AppMethodBeat.o(29517);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = -99999;
      }
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(29500);
    this.SNP = 0;
    bh.aZW().b(332, this);
    bh.aZW().b(334, this);
    bh.aZW().b(336, this);
    bh.aZW().b(335, this);
    b.hCp().b(this);
    bh.aDI().b(this);
    b(b.hCs());
    int j = -99999;
    int i = j;
    if (this.SNW != null) {}
    try
    {
      i = this.SNW.uninitLive();
      MMApplicationContext.getContext().unbindService(this.wOI);
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().stopService(localIntent);
      this.SNW = null;
      if (i < 0) {
        Log.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(29500);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = j;
      }
    }
  }
  
  public final void Ff(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    Log.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.SNR });
    if ((Util.isNullOrNil(this.SNR)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.hCt().hCz();
    if (paramBoolean) {
      if (!hCI())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      hCJ();
      hCG();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.SNW != null) {
          this.SNW.Close();
        }
        if (this.roomId != 0) {
          hCK();
        }
        if (!paramBoolean) {
          this.SOc.onReconnect();
        }
        AppMethodBeat.o(29514);
        return;
        localRemoteException1 = localRemoteException1;
        Log.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.bc.d paramd)
  {
    // Byte code:
    //   0: sipush 29497
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:SOc	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   10: astore_2
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_2
    //   14: getfield 543	com/tencent/mm/plugin/talkroom/model/i:bPE	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 549 2 0
    //   23: ifeq +23 -> 46
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:SOc	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 552	com/tencent/mm/plugin/talkroom/model/g:hCC	()Ljava/lang/String;
    //   36: invokevirtual 556	com/tencent/mm/plugin/talkroom/model/i:Pw	(Ljava/lang/String;)V
    //   39: sipush 29497
    //   42: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: getfield 543	com/tencent/mm/plugin/talkroom/model/i:bPE	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 559 2 0
    //   56: pop
    //   57: aload_1
    //   58: monitorexit
    //   59: goto -31 -> 28
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: sipush 29497
    //   68: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	g
    //   0	73	1	paramd	com.tencent.mm.bc.d
    //   10	37	2	locali	i
    //   62	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	28	62	finally
    //   46	59	62	finally
  }
  
  public final void b(com.tencent.mm.bc.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.SOc;
    try
    {
      locali.bPE.remove(paramd);
      return;
    }
    finally
    {
      AppMethodBeat.o(29498);
    }
  }
  
  public final void bCh()
  {
    AppMethodBeat.i(29522);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (Util.isNullOrNil(this.SNR)) {
      Log.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.GNB = false;
      locali = this.SOc;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      hCG();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void bCi()
  {
    AppMethodBeat.i(29523);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (Util.isNullOrNil(this.SNR)) {
        Log.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.GNB = true;
        i locali = this.SOc;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.SNZ != null) {
          this.SNZ.hCj();
        }
        if (this.SNY != null) {
          this.SNY.bck();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
      AppMethodBeat.o(29523);
    }
  }
  
  public final void bNp()
  {
    AppMethodBeat.i(29509);
    Log.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.hCt();
    localf.SNM = true;
    localf.SNL = Util.currentTicks();
    try
    {
      this.SNZ.bNp();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short bNq()
  {
    AppMethodBeat.i(29518);
    if (this.SNZ == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.SNZ.hCk();
      short s = (short)i;
      AppMethodBeat.o(29518);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29518);
    }
    return 0;
  }
  
  public final short bNr()
  {
    AppMethodBeat.i(29519);
    if (this.SNY == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.SNY.hCk();
      short s = (short)i;
      AppMethodBeat.o(29519);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29519);
    }
    return 0;
  }
  
  public final boolean bNs()
  {
    AppMethodBeat.i(29505);
    Log.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      Log.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.SOc.k(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.SNY != null) {}
    try
    {
      this.SNY.bck();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.Hnt, 1, this.SNR, hCB());
      bh.aZW().a(locald, 0);
      b.hCt().SNK = Util.currentTicks();
      b.hCt().SNN = true;
      AppMethodBeat.o(29505);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void bNt()
  {
    AppMethodBeat.i(29506);
    Log.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.hCt();
    if ((((f)localObject).SNN) && (!((f)localObject).SNM)) {
      ((f)localObject).SNH += 1;
    }
    ((f)localObject).SNM = false;
    ((f)localObject).SNN = false;
    if (this.state < 3)
    {
      Log.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.SOb != null)
    {
      this.SOb.stopTimer();
      this.SOb = null;
    }
    hCG();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.Hnt, 2, this.SNR, hCB());
    bh.aZW().a((p)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean bNu()
  {
    return this.GNB;
  }
  
  public final void ba(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    Log.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.SNO = paramInt;
    if (!hCD())
    {
      this.SOc.w("enterTalkRoom addListener failed", 3, -1);
      hCE();
      AppMethodBeat.o(29501);
      return;
    }
    if (paramString.equals(this.SNR))
    {
      Log.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.SOc.bNv();
      }
      AppMethodBeat.o(29501);
      return;
    }
    Log.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.SNR = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.SNR, hCB());
    bh.aZW().a((p)localObject, 0);
    b.hCr();
    b.hCt().SNI = Util.currentTicks();
    b.hCt().SNF = paramString;
    if (hCB() == 0) {
      b.hCs().Kgb = true;
    }
    localObject = this.SOc;
    paramString = new i.11((i)localObject, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(29501);
      return;
    }
    ((i)localObject).handler.post(paramString);
    AppMethodBeat.o(29501);
  }
  
  public final List fUJ()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.hCp().bdh(this.SNR);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int hCB()
  {
    AppMethodBeat.i(29494);
    if ((this.SNO == 1) || ((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.Py(this.SNR))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String hCC()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.hCp().bdh(this.SNR).iterator();
    while (((Iterator)localObject).hasNext())
    {
      fly localfly = (fly)((Iterator)localObject).next();
      if (localfly.abMo == this.SNU)
      {
        localObject = localfly.UserName;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void hCE()
  {
    AppMethodBeat.i(29502);
    Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    Fe(false);
    if (Util.isNullOrNil(this.SNR))
    {
      Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.hCt().exitRoom();
    this.state = 0;
    this.SNQ = false;
    int i = this.roomId;
    long l = this.Hnt;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.SNR;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, hCB());
      bh.aZW().a((p)localObject1, 0);
      if (this.SNW != null) {}
      try
      {
        i = this.SNW.Close();
        if (i < 0) {
          Log.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, aa.getDisplayName(this.SNR)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          Log.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          flz localflz = new flz();
          localflz.aaLf = 10402;
          localflz.abMp = new etl().btH((String)localObject1);
          localObject1 = new flz();
          ((flz)localObject1).aaLf = 10404;
          ((flz)localObject1).abMp = new etl().btH(b.hCt().toString());
          ((LinkedList)localObject2).add(localflz);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, hCB());
          bh.aZW().a((p)localObject1, 0);
        }
        this.SNR = "";
        this.roomId = 0;
        this.Hnt = 0L;
        this.SNS = 0;
        this.SNT = 0;
        this.SNU = 0;
        this.SNV.clear();
        hCF();
        this.SOc.bNx();
        b.hCs().hCv();
        removeListener();
        AppMethodBeat.o(29502);
        return;
        localObject1 = "";
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29521);
    if (!paramString1.equals(this.SNR))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.SOc;
    paramString2 = new i.10(paramString1, paramString2, paramString3);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString2.run();
      AppMethodBeat.o(29521);
      return;
    }
    paramString1.handler.post(paramString2);
    AppMethodBeat.o(29521);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29507);
    Log.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramp;
    if ((paramString.hCL() == null) || (!paramString.hCL().equals(this.SNR)))
    {
      Log.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.hCL(), this.SNR });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramp.getType() == 332)
      {
        b.hCt().anN(2);
        if (paramInt1 == 4) {
          b.hCt().SNG = paramInt2;
        }
        this.SOc.w("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        hCE();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramp.getType() == 334)
      {
        if (((com.tencent.mm.plugin.talkroom.b.d)paramp).actionType != 1)
        {
          AppMethodBeat.o(29507);
          return;
        }
        paramString = b.hCt();
        paramString.SNp += 1;
        paramString.SNK = 0L;
        hCG();
        Log.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.SOc.wZ(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.SOc.k(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramp.getType() == 336)
      {
        this.SNQ = false;
        this.SOc.k(paramInt1, paramInt2, "TalkGetMember failed!!");
        hCE();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramp.getType() == 335)
      {
        this.SOc.k(paramInt1, paramInt2, "TalkNoop failed!!");
        hCE();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramp.getType() == 332)
    {
      b.hCt().anN(1);
      paramp = (com.tencent.mm.plugin.talkroom.b.a)paramp;
      this.roomId = paramp.roomId;
      this.Hnt = paramp.Hnt;
      this.SNS = paramp.SNS;
      this.SNT = paramp.SNT;
      this.SNV = paramp.SNV;
      localObject = b.hCt();
      paramInt1 = this.roomId;
      long l = this.Hnt;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).Hnt = l;
      paramp = paramp.SOm;
      b.hCp().a(this.SNR, paramp, null, null, paramString.hCM());
      anO(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramp.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramp;
      if (paramString.actionType == 1)
      {
        paramp = b.hCt();
        if (paramp.SNK != 0L)
        {
          paramp.SNn = ((Util.ticksToNow(paramp.SNK) + paramp.SNn * paramp.SNJ) / (paramp.SNJ + 1));
          paramp.SNJ += 1;
          paramp.SNo += 1;
          paramp.SNK = 0L;
        }
        Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.SNS < this.SNS)
        {
          Log.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.SNS), Integer.valueOf(this.SNS) });
          hCG();
          this.SOc.wZ(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.SNS = paramString.SNS;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.SNW.SetCurrentMicId(this.SNS);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.SOc;
          paramp = new i.6(paramString);
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label858;
          }
        }
        if (this.state != 3)
        {
          Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
          AppMethodBeat.o(29507);
          return;
        }
        paramp.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            Log.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.SOb == null)
          {
            this.SOb = new MTimerHandler(new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.hCB());
                bh.aZW().a((p)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.SOb.startTimer(5000L);
          }
          AppMethodBeat.o(29507);
          return;
          label858:
          paramString.handler.post(paramp);
        }
      }
      Log.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(29507);
      return;
    }
    if (paramp.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramp;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).SOm;
      b.hCp().a(this.SNR, localLinkedList, null, null, paramString.hCM());
      anP(((com.tencent.mm.plugin.talkroom.b.c)localObject).SNS);
      this.SNQ = false;
      this.SOc.Pw(hCC());
    }
    if ((paramp.getType() == 335) && (this.state == 0)) {
      this.SOc.k(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */