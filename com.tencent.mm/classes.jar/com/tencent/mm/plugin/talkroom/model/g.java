package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MAlarmHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ak.i, com.tencent.mm.bh.a, com.tencent.mm.bh.c, ao
{
  public static final int[] FQH = { 80, 8080, 16285 };
  public static final byte[][] FQI = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  private com.tencent.mm.plugin.talkroom.component.a FQA;
  private com.tencent.mm.plugin.talkroom.component.b FQB;
  private com.tencent.mm.plugin.talkroom.component.e FQC;
  private com.tencent.mm.plugin.talkroom.component.d FQD;
  private MAlarmHandler FQE;
  private MTimerHandler FQF;
  private i FQG;
  public boolean FQJ;
  private int FQs;
  private int FQt;
  private boolean FQu;
  public String FQv;
  private int FQw;
  private int FQx;
  private int FQy;
  private LinkedList<egr> FQz;
  private final ServiceConnection qmC;
  private int roomId;
  private int state;
  private long ypH;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.FQs = 0;
    this.FQt = 0;
    this.state = 0;
    this.FQu = false;
    this.FQz = new LinkedList();
    this.FQG = new i();
    this.qmC = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        Log.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).s("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.D(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.wi(true);
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
    this.FQJ = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.FQA != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.FQA.e(arrayOfInt, paramString);
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
  
  private void abq(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.FQA != null) {
      try
      {
        fue();
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
      this.FQG.s("bind talkroomService timeout", 3, -1);
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
  
  private void abr(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.FQw)
    {
      this.FQw = paramInt;
      if (this.state >= 3) {
        this.FQG.ua(311);
      }
      fud();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String abs(int paramInt)
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
  
  private boolean fua()
  {
    AppMethodBeat.i(29499);
    if (ftY() == 1) {
      b(b.ftM().FPB);
    }
    while (this.FQt > 0)
    {
      Log.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.ftM().FPB);
    }
    bg.azz().a(332, this);
    bg.azz().a(334, this);
    bg.azz().a(336, this);
    bg.azz().a(335, this);
    b.ftO().a(this);
    bg.Xi().a(this);
    this.FQt = 1;
    if (this.FQA != null) {}
    try
    {
      this.FQA.Close();
      this.FQA.uninitLive();
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().bindService(localIntent, this.qmC, 1);
      this.FQB = new b.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          Log.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.ftQ().ftV();
          b.ftQ().FPP = 1;
          g.a(g.this).s("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.fub();
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
          b.ftQ().ftV();
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
          g.a(g.this).bgz();
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
  
  private void fuc()
  {
    AppMethodBeat.i(29503);
    if (this.FQC != null) {}
    try
    {
      this.FQC.release();
      this.FQC = null;
      if (this.FQD == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.FQD.release();
        this.FQD = null;
        if (this.FQE != null)
        {
          this.FQE.stopTimer();
          this.FQE = null;
        }
        if (this.FQF != null)
        {
          this.FQF.stopTimer();
          this.FQF = null;
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
  
  private void fud()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.ftQ().ftX();
      if (this.FQD != null) {
        this.FQD.ftI();
      }
      if (this.FQC != null) {
        this.FQC.eYd();
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
  
  private void fue()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.FQu = false;
    if (!fuf())
    {
      AppMethodBeat.o(29511);
      return;
    }
    fuc();
    fuh();
    fug();
    if (this.FQE != null)
    {
      Log.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.FQE = new MAlarmHandler(new MAlarmHandler.CallBack()
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
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.ftY());
        bg.azz().a((q)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    }, true);
    this.FQE.startTimer(50000L);
    AppMethodBeat.o(29511);
  }
  
  private boolean fuf()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.FQA.ftD();
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
      this.FQA = null;
      Log.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.FQG.s("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void fug()
  {
    AppMethodBeat.i(29515);
    if (this.FQA == null)
    {
      Log.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.FQC = this.FQA.a(new c.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).PX("");
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
        String str = g.this.ftZ();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.ftY());
          bg.azz().a((q)localObject, 0);
          localObject = b.ftQ();
          ((f)localObject).FPX += 1;
          localObject = b.ftQ();
          ((f)localObject).FPY += 1;
        }
        g.a(g.this).PX(str);
        PlaySound.play(MMApplicationContext.getContext(), 2131766637);
        AppMethodBeat.o(29492);
      }
    });
    this.FQC.start();
    this.FQD = this.FQA.ftE();
    this.FQD.start();
    AppMethodBeat.o(29515);
  }
  
  private void fuh()
  {
    AppMethodBeat.i(29517);
    if (this.FQz.size() == 0)
    {
      Log.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.FQG.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.FQz.size()];
    int[] arrayOfInt2 = new int[this.FQz.size()];
    String[] arrayOfString = new String[this.FQz.size()];
    Log.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.FQz.size()) });
    int i = 0;
    while (i < this.FQz.size())
    {
      arrayOfInt1[i] = ((egr)this.FQz.get(i)).NgB;
      arrayOfInt2[i] = ((egr)this.FQz.get(i)).MKe;
      arrayOfString[i] = ((egr)this.FQz.get(i)).NgC;
      Log.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { abs(((egr)this.FQz.get(i)).NgB), ((egr)this.FQz.get(i)).NgC, Integer.valueOf(((egr)this.FQz.get(i)).MKe) });
      i += 1;
    }
    Log.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.FQx), Integer.valueOf(this.roomId), Long.valueOf(this.ypH) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.FQA;
      com.tencent.mm.plugin.talkroom.component.b localb = this.FQB;
      bg.aVF();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.FQx, this.roomId, this.ypH, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        Log.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.FQG.j(3, i, "engine.Open error");
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
    this.FQt = 0;
    bg.azz().b(332, this);
    bg.azz().b(334, this);
    bg.azz().b(336, this);
    bg.azz().b(335, this);
    b.ftO().b(this);
    bg.Xi().b(this);
    b(b.ftM().FPB);
    int j = -99999;
    int i = j;
    if (this.FQA != null) {}
    try
    {
      i = this.FQA.uninitLive();
      MMApplicationContext.getContext().unbindService(this.qmC);
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().stopService(localIntent);
      this.FQA = null;
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
  
  private void wh(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (Util.isNullOrNil(this.FQv))
    {
      AppMethodBeat.o(29504);
      return;
    }
    bg.aVF();
    az localaz = com.tencent.mm.model.c.aST().bjY(this.FQv);
    if (localaz == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localaz.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, i, localaz.field_conversationTime));
      bg.aVF();
      com.tencent.mm.model.c.aST().a(localaz, this.FQv);
      AppMethodBeat.o(29504);
      return;
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.bh.d paramd)
  {
    // Byte code:
    //   0: sipush 29497
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:FQG	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   10: astore_2
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_2
    //   14: getfield 536	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 542 2 0
    //   23: ifeq +23 -> 46
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:FQG	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 545	com/tencent/mm/plugin/talkroom/model/g:ftZ	()Ljava/lang/String;
    //   36: invokevirtual 549	com/tencent/mm/plugin/talkroom/model/i:PX	(Ljava/lang/String;)V
    //   39: sipush 29497
    //   42: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: getfield 536	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 552 2 0
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
    //   0	73	1	paramd	com.tencent.mm.bh.d
    //   10	37	2	locali	i
    //   62	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	28	62	finally
    //   46	59	62	finally
    //   63	65	62	finally
  }
  
  public final void aVl()
  {
    AppMethodBeat.i(29522);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (Util.isNullOrNil(this.FQv)) {
      Log.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.FQJ = false;
      locali = this.FQG;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      fud();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void aVm()
  {
    AppMethodBeat.i(29523);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (Util.isNullOrNil(this.FQv)) {
        Log.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.FQJ = true;
        i locali = this.FQG;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.FQD != null) {
          this.FQD.ftI();
        }
        if (this.FQC != null) {
          this.FQC.cXa();
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
  
  public final void aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    Log.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.FQs = paramInt;
    fua();
    if (paramString.equals(this.FQv))
    {
      Log.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.FQG.bgz();
      }
      AppMethodBeat.o(29501);
      return;
    }
    Log.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.FQv = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.FQv, ftY());
    bg.azz().a((q)localObject, 0);
    b.ftM().FPD = new f();
    b.ftQ().FQm = Util.currentTicks();
    b.ftQ().FQj = paramString;
    if (ftY() == 0) {
      b.ftM().FPB.yJA = true;
    }
    localObject = this.FQG;
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
  
  public final void b(com.tencent.mm.bh.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.FQG;
    try
    {
      locali.callbacks.remove(paramd);
      return;
    }
    finally
    {
      AppMethodBeat.o(29498);
    }
  }
  
  public final void bgt()
  {
    AppMethodBeat.i(29509);
    Log.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.ftQ();
    localf.FQq = true;
    localf.FQp = Util.currentTicks();
    try
    {
      this.FQD.bgt();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short bgu()
  {
    AppMethodBeat.i(29518);
    if (this.FQD == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.FQD.ftJ();
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
  
  public final short bgv()
  {
    AppMethodBeat.i(29519);
    if (this.FQC == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.FQC.ftJ();
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
  
  public final boolean bgw()
  {
    AppMethodBeat.i(29505);
    Log.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      Log.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.FQG.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.FQC != null) {}
    try
    {
      this.FQC.cXa();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.ypH, 1, this.FQv, ftY());
      bg.azz().a(locald, 0);
      b.ftQ().FQo = Util.currentTicks();
      b.ftQ().FQr = true;
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
  
  public final void bgx()
  {
    AppMethodBeat.i(29506);
    Log.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.ftQ();
    if ((((f)localObject).FQr) && (!((f)localObject).FQq)) {
      ((f)localObject).FQl += 1;
    }
    ((f)localObject).FQq = false;
    ((f)localObject).FQr = false;
    if (this.state < 3)
    {
      Log.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.FQF != null)
    {
      this.FQF.stopTimer();
      this.FQF = null;
    }
    fud();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.ypH, 2, this.FQv, ftY());
    bg.azz().a((q)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean bgy()
  {
    return this.FQJ;
  }
  
  public final List ecY()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.ftO().aSV(this.FQv);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int ftY()
  {
    AppMethodBeat.i(29494);
    if ((this.FQs == 1) || ((com.tencent.mm.bi.d.jpA != null) && (com.tencent.mm.bi.d.jpA.PZ(this.FQv))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String ftZ()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.ftO().aSV(this.FQv).iterator();
    while (((Iterator)localObject).hasNext())
    {
      egs localegs = (egs)((Iterator)localObject).next();
      if (localegs.NgD == this.FQy)
      {
        localObject = localegs.UserName;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void fub()
  {
    AppMethodBeat.i(29502);
    Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    wh(false);
    if (Util.isNullOrNil(this.FQv))
    {
      Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.ftQ().exitRoom();
    this.state = 0;
    this.FQu = false;
    int i = this.roomId;
    long l = this.ypH;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.FQv;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, ftY());
      bg.azz().a((q)localObject1, 0);
      if (this.FQA != null) {}
      try
      {
        i = this.FQA.Close();
        if (i < 0) {
          Log.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, aa.getDisplayName(this.FQv)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          Log.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          egt localegt = new egt();
          localegt.MlF = 10402;
          localegt.NgE = new dqi().bhy((String)localObject1);
          localObject1 = new egt();
          ((egt)localObject1).MlF = 10404;
          ((egt)localObject1).NgE = new dqi().bhy(b.ftQ().toString());
          ((LinkedList)localObject2).add(localegt);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, ftY());
          bg.azz().a((q)localObject1, 0);
        }
        this.FQv = "";
        this.roomId = 0;
        this.ypH = 0L;
        this.FQw = 0;
        this.FQx = 0;
        this.FQy = 0;
        this.FQz.clear();
        fuc();
        this.FQG.bgB();
        b.ftM().FPB.ftS();
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
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29521);
    if (!paramString1.equals(this.FQv))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.FQG;
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29507);
    Log.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramq;
    if ((paramString.fui() == null) || (!paramString.fui().equals(this.FQv)))
    {
      Log.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.fui(), this.FQv });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramq.getType() == 332)
      {
        b.ftQ().abp(2);
        if (paramInt1 == 4) {
          b.ftQ().FQk = paramInt2;
        }
        this.FQG.s("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        fub();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramq.getType() == 334)
      {
        if (((com.tencent.mm.plugin.talkroom.b.d)paramq).actionType != 1)
        {
          AppMethodBeat.o(29507);
          return;
        }
        paramString = b.ftQ();
        paramString.FPT += 1;
        paramString.FQo = 0L;
        fud();
        Log.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.FQG.ua(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.FQG.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramq.getType() == 336)
      {
        this.FQu = false;
        this.FQG.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        fub();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramq.getType() == 335)
      {
        this.FQG.j(paramInt1, paramInt2, "TalkNoop failed!!");
        fub();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramq.getType() == 332)
    {
      b.ftQ().abp(1);
      paramq = (com.tencent.mm.plugin.talkroom.b.a)paramq;
      this.roomId = paramq.roomId;
      this.ypH = paramq.ypH;
      this.FQw = paramq.FQw;
      this.FQx = paramq.FQx;
      this.FQz = paramq.FQz;
      localObject = b.ftQ();
      paramInt1 = this.roomId;
      long l = this.ypH;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).ypH = l;
      paramq = paramq.FQR;
      b.ftO().a(this.FQv, paramq, null, null, paramString.fuj());
      abq(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramq.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramq;
      if (paramString.actionType == 1)
      {
        paramq = b.ftQ();
        if (paramq.FQo != 0L)
        {
          paramq.FPR = ((Util.ticksToNow(paramq.FQo) + paramq.FPR * paramq.FQn) / (paramq.FQn + 1));
          paramq.FQn += 1;
          paramq.FPS += 1;
          paramq.FQo = 0L;
        }
        Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.FQw < this.FQw)
        {
          Log.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.FQw), Integer.valueOf(this.FQw) });
          fud();
          this.FQG.ua(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.FQw = paramString.FQw;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.FQA.SetCurrentMicId(this.FQw);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.FQG;
          paramq = new i.6(paramString);
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
        paramq.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            Log.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.FQF == null)
          {
            this.FQF = new MTimerHandler(new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.ftY());
                bg.azz().a((q)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.FQF.startTimer(5000L);
          }
          AppMethodBeat.o(29507);
          return;
          label858:
          paramString.handler.post(paramq);
        }
      }
      Log.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(29507);
      return;
    }
    if (paramq.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramq;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).FQR;
      b.ftO().a(this.FQv, localLinkedList, null, null, paramString.fuj());
      abr(((com.tencent.mm.plugin.talkroom.b.c)localObject).FQw);
      this.FQu = false;
      this.FQG.PX(ftZ());
    }
    if ((paramq.getType() == 335) && (this.state == 0)) {
      this.FQG.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void wi(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    Log.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.FQv });
    if ((Util.isNullOrNil(this.FQv)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.ftQ().ftW();
    if (paramBoolean) {
      if (!fuf())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      fug();
      fud();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.FQA != null) {
          this.FQA.Close();
        }
        if (this.roomId != 0) {
          fuh();
        }
        if (!paramBoolean) {
          this.FQG.bgE();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */