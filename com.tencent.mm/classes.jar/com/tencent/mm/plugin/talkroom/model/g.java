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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL;
import com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL.a;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eqt;
import com.tencent.mm.protocal.protobuf.equ;
import com.tencent.mm.protocal.protobuf.eqv;
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
  implements com.tencent.mm.an.i, com.tencent.mm.bj.a, com.tencent.mm.bj.c, ap
{
  public static final int[] MkI = { 80, 8080, 16285 };
  public static final byte[][] MkJ = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  private long DPJ;
  private LinkedList<eqt> MkA;
  private com.tencent.mm.plugin.talkroom.component.a MkB;
  private ILiveConEngineCallback_AIDL MkC;
  private com.tencent.mm.plugin.talkroom.component.d MkD;
  private com.tencent.mm.plugin.talkroom.component.c MkE;
  private MAlarmHandler MkF;
  private MTimerHandler MkG;
  private i MkH;
  public boolean MkK;
  private int Mkt;
  private int Mku;
  private boolean Mkv;
  public String Mkw;
  private int Mkx;
  private int Mky;
  private int Mkz;
  private int roomId;
  private int state;
  private final ServiceConnection tLt;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.Mkt = 0;
    this.Mku = 0;
    this.state = 0;
    this.Mkv = false;
    this.MkA = new LinkedList();
    this.MkH = new i();
    this.tLt = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        Log.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).t("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.G(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.zO(true);
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
    this.MkK = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.MkB != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.MkB.e(arrayOfInt, paramString);
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
  
  private void aiM(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.MkB != null) {
      try
      {
        giG();
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
      this.MkH.t("bind talkroomService timeout", 3, -1);
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
  
  private void aiN(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.Mkx)
    {
      this.Mkx = paramInt;
      if (this.state >= 3) {
        this.MkH.wZ(311);
      }
      giF();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String aiO(int paramInt)
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
  
  private boolean giC()
  {
    AppMethodBeat.i(29499);
    if (giA() == 1) {
      b(b.gir());
    }
    while (this.Mku > 0)
    {
      Log.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.gir());
    }
    bh.aGY().a(332, this);
    bh.aGY().a(334, this);
    bh.aGY().a(336, this);
    bh.aGY().a(335, this);
    b.gio().a(this);
    bh.abL().a(this);
    this.Mku = 1;
    if (this.MkB != null) {}
    try
    {
      this.MkB.Close();
      this.MkB.uninitLive();
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().bindService(localIntent, this.tLt, 1);
      this.MkC = new ILiveConEngineCallback_AIDL.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          Log.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.gis().gix();
          b.gis().MjQ = 1;
          g.a(g.this).t("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.giD();
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
          b.gis().gix();
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
          g.a(g.this).bpP();
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
  
  private void giE()
  {
    AppMethodBeat.i(29503);
    if (this.MkD != null) {}
    try
    {
      this.MkD.release();
      this.MkD = null;
      if (this.MkE == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.MkE.release();
        this.MkE = null;
        if (this.MkF != null)
        {
          this.MkF.stopTimer();
          this.MkF = null;
        }
        if (this.MkG != null)
        {
          this.MkG.stopTimer();
          this.MkG = null;
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
  
  private void giF()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.gis().giz();
      if (this.MkE != null) {
        this.MkE.gii();
      }
      if (this.MkD != null) {
        this.MkD.fLJ();
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
  
  private void giG()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.Mkv = false;
    if (!giH())
    {
      AppMethodBeat.o(29511);
      return;
    }
    giE();
    giJ();
    giI();
    if (this.MkF != null)
    {
      Log.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.MkF = new MAlarmHandler(new MAlarmHandler.CallBack()
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
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.giA());
        bh.aGY().a((q)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    }, true);
    this.MkF.startTimer(50000L);
    AppMethodBeat.o(29511);
  }
  
  private boolean giH()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.MkB.gid();
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
      this.MkB = null;
      Log.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.MkH.t("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void giI()
  {
    AppMethodBeat.i(29515);
    if (this.MkB == null)
    {
      Log.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.MkD = this.MkB.a(new b.a()
    {
      public final void J(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).Xu("");
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
        String str = g.this.giB();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.giA());
          bh.aGY().a((q)localObject, 0);
          localObject = b.gis();
          ((f)localObject).MjY += 1;
          localObject = b.gis();
          ((f)localObject).MjZ += 1;
        }
        g.a(g.this).Xu(str);
        PlaySound.play(MMApplicationContext.getContext(), R.l.talkroom_othersbegin);
        AppMethodBeat.o(29492);
      }
    });
    this.MkD.start();
    this.MkE = this.MkB.gie();
    this.MkE.start();
    AppMethodBeat.o(29515);
  }
  
  private void giJ()
  {
    AppMethodBeat.i(29517);
    if (this.MkA.size() == 0)
    {
      Log.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.MkH.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.MkA.size()];
    int[] arrayOfInt2 = new int[this.MkA.size()];
    String[] arrayOfString = new String[this.MkA.size()];
    Log.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.MkA.size()) });
    int i = 0;
    while (i < this.MkA.size())
    {
      arrayOfInt1[i] = ((eqt)this.MkA.get(i)).Utf;
      arrayOfInt2[i] = ((eqt)this.MkA.get(i)).TVY;
      arrayOfString[i] = ((eqt)this.MkA.get(i)).Utg;
      Log.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { aiO(((eqt)this.MkA.get(i)).Utf), ((eqt)this.MkA.get(i)).Utg, Integer.valueOf(((eqt)this.MkA.get(i)).TVY) });
      i += 1;
    }
    Log.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.Mky), Integer.valueOf(this.roomId), Long.valueOf(this.DPJ) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.MkB;
      ILiveConEngineCallback_AIDL localILiveConEngineCallback_AIDL = this.MkC;
      bh.beI();
      i = locala.a(localILiveConEngineCallback_AIDL, com.tencent.mm.model.c.getUin(), this.Mky, this.roomId, this.DPJ, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        Log.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.MkH.j(3, i, "engine.Open error");
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
    this.Mku = 0;
    bh.aGY().b(332, this);
    bh.aGY().b(334, this);
    bh.aGY().b(336, this);
    bh.aGY().b(335, this);
    b.gio().b(this);
    bh.abL().b(this);
    b(b.gir());
    int j = -99999;
    int i = j;
    if (this.MkB != null) {}
    try
    {
      i = this.MkB.uninitLive();
      MMApplicationContext.getContext().unbindService(this.tLt);
      Intent localIntent = new Intent(MMApplicationContext.getContext(), TalkRoomService.class);
      MMApplicationContext.getContext().stopService(localIntent);
      this.MkB = null;
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
  
  private void zN(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (Util.isNullOrNil(this.Mkw))
    {
      AppMethodBeat.o(29504);
      return;
    }
    bh.beI();
    az localaz = com.tencent.mm.model.c.bbR().bwx(this.Mkw);
    if (localaz == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localaz.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, i, localaz.field_conversationTime));
      bh.beI();
      com.tencent.mm.model.c.bbR().a(localaz, this.Mkw);
      AppMethodBeat.o(29504);
      return;
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.bj.d paramd)
  {
    // Byte code:
    //   0: sipush 29497
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:MkH	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   10: astore_2
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_2
    //   14: getfield 532	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 538 2 0
    //   23: ifeq +23 -> 46
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:MkH	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 541	com/tencent/mm/plugin/talkroom/model/g:giB	()Ljava/lang/String;
    //   36: invokevirtual 545	com/tencent/mm/plugin/talkroom/model/i:Xu	(Ljava/lang/String;)V
    //   39: sipush 29497
    //   42: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: getfield 532	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 548 2 0
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
    //   0	73	1	paramd	com.tencent.mm.bj.d
    //   10	37	2	locali	i
    //   62	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	28	62	finally
    //   46	59	62	finally
  }
  
  public final void aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    Log.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.Mkt = paramInt;
    giC();
    if (paramString.equals(this.Mkw))
    {
      Log.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.MkH.bpP();
      }
      AppMethodBeat.o(29501);
      return;
    }
    Log.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.Mkw = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.Mkw, giA());
    bh.aGY().a((q)localObject, 0);
    b.giq();
    b.gis().Mkn = Util.currentTicks();
    b.gis().Mkk = paramString;
    if (giA() == 0) {
      b.gir().Ent = true;
    }
    localObject = this.MkH;
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
  
  public final void b(com.tencent.mm.bj.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.MkH;
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
  
  public final void beo()
  {
    AppMethodBeat.i(29522);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (Util.isNullOrNil(this.Mkw)) {
      Log.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.MkK = false;
      locali = this.MkH;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      giF();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void bep()
  {
    AppMethodBeat.i(29523);
    Log.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (Util.isNullOrNil(this.Mkw)) {
        Log.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.MkK = true;
        i locali = this.MkH;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.MkE != null) {
          this.MkE.gii();
        }
        if (this.MkD != null) {
          this.MkD.dmi();
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
  
  public final void bpJ()
  {
    AppMethodBeat.i(29509);
    Log.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.gis();
    localf.Mkr = true;
    localf.Mkq = Util.currentTicks();
    try
    {
      this.MkE.bpJ();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short bpK()
  {
    AppMethodBeat.i(29518);
    if (this.MkE == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.MkE.gij();
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
  
  public final short bpL()
  {
    AppMethodBeat.i(29519);
    if (this.MkD == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.MkD.gij();
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
  
  public final boolean bpM()
  {
    AppMethodBeat.i(29505);
    Log.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      Log.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.MkH.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.MkD != null) {}
    try
    {
      this.MkD.dmi();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.DPJ, 1, this.Mkw, giA());
      bh.aGY().a(locald, 0);
      b.gis().Mkp = Util.currentTicks();
      b.gis().Mks = true;
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
  
  public final void bpN()
  {
    AppMethodBeat.i(29506);
    Log.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.gis();
    if ((((f)localObject).Mks) && (!((f)localObject).Mkr)) {
      ((f)localObject).Mkm += 1;
    }
    ((f)localObject).Mkr = false;
    ((f)localObject).Mks = false;
    if (this.state < 3)
    {
      Log.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.MkG != null)
    {
      this.MkG.stopTimer();
      this.MkG = null;
    }
    giF();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.DPJ, 2, this.Mkw, giA());
    bh.aGY().a((q)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean bpO()
  {
    return this.MkK;
  }
  
  public final List eMr()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.gio().bdZ(this.Mkw);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int giA()
  {
    AppMethodBeat.i(29494);
    if ((this.Mkt == 1) || ((com.tencent.mm.bk.d.meV != null) && (com.tencent.mm.bk.d.meV.Xw(this.Mkw))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String giB()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.gio().bdZ(this.Mkw).iterator();
    while (((Iterator)localObject).hasNext())
    {
      equ localequ = (equ)((Iterator)localObject).next();
      if (localequ.Uth == this.Mkz)
      {
        localObject = localequ.UserName;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void giD()
  {
    AppMethodBeat.i(29502);
    Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    zN(false);
    if (Util.isNullOrNil(this.Mkw))
    {
      Log.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.gis().exitRoom();
    this.state = 0;
    this.Mkv = false;
    int i = this.roomId;
    long l = this.DPJ;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.Mkw;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, giA());
      bh.aGY().a((q)localObject1, 0);
      if (this.MkB != null) {}
      try
      {
        i = this.MkB.Close();
        if (i < 0) {
          Log.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, aa.PJ(this.Mkw)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          Log.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          eqv localeqv = new eqv();
          localeqv.Twy = 10402;
          localeqv.Uti = new eaf().btQ((String)localObject1);
          localObject1 = new eqv();
          ((eqv)localObject1).Twy = 10404;
          ((eqv)localObject1).Uti = new eaf().btQ(b.gis().toString());
          ((LinkedList)localObject2).add(localeqv);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, giA());
          bh.aGY().a((q)localObject1, 0);
        }
        this.Mkw = "";
        this.roomId = 0;
        this.DPJ = 0L;
        this.Mkx = 0;
        this.Mky = 0;
        this.Mkz = 0;
        this.MkA.clear();
        giE();
        this.MkH.bpR();
        b.gir().giu();
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
    if (!paramString1.equals(this.Mkw))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.MkH;
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
    if ((paramString.giK() == null) || (!paramString.giK().equals(this.Mkw)))
    {
      Log.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.giK(), this.Mkw });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramq.getType() == 332)
      {
        b.gis().aiL(2);
        if (paramInt1 == 4) {
          b.gis().Mkl = paramInt2;
        }
        this.MkH.t("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        giD();
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
        paramString = b.gis();
        paramString.MjU += 1;
        paramString.Mkp = 0L;
        giF();
        Log.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.MkH.wZ(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.MkH.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramq.getType() == 336)
      {
        this.Mkv = false;
        this.MkH.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        giD();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramq.getType() == 335)
      {
        this.MkH.j(paramInt1, paramInt2, "TalkNoop failed!!");
        giD();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramq.getType() == 332)
    {
      b.gis().aiL(1);
      paramq = (com.tencent.mm.plugin.talkroom.b.a)paramq;
      this.roomId = paramq.roomId;
      this.DPJ = paramq.DPJ;
      this.Mkx = paramq.Mkx;
      this.Mky = paramq.Mky;
      this.MkA = paramq.MkA;
      localObject = b.gis();
      paramInt1 = this.roomId;
      long l = this.DPJ;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).DPJ = l;
      paramq = paramq.MkS;
      b.gio().a(this.Mkw, paramq, null, null, paramString.giL());
      aiM(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramq.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramq;
      if (paramString.actionType == 1)
      {
        paramq = b.gis();
        if (paramq.Mkp != 0L)
        {
          paramq.MjS = ((Util.ticksToNow(paramq.Mkp) + paramq.MjS * paramq.Mko) / (paramq.Mko + 1));
          paramq.Mko += 1;
          paramq.MjT += 1;
          paramq.Mkp = 0L;
        }
        Log.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.Mkx < this.Mkx)
        {
          Log.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.Mkx), Integer.valueOf(this.Mkx) });
          giF();
          this.MkH.wZ(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.Mkx = paramString.Mkx;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.MkB.SetCurrentMicId(this.Mkx);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.MkH;
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
          if (this.MkG == null)
          {
            this.MkG = new MTimerHandler(new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.giA());
                bh.aGY().a((q)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.MkG.startTimer(5000L);
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
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).MkS;
      b.gio().a(this.Mkw, localLinkedList, null, null, paramString.giL());
      aiN(((com.tencent.mm.plugin.talkroom.b.c)localObject).Mkx);
      this.Mkv = false;
      this.MkH.Xu(giB());
    }
    if ((paramq.getType() == 335) && (this.state == 0)) {
      this.MkH.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void zO(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    Log.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.Mkw });
    if ((Util.isNullOrNil(this.Mkw)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.gis().giy();
    if (paramBoolean) {
      if (!giH())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      giI();
      giF();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.MkB != null) {
          this.MkB.Close();
        }
        if (this.roomId != 0) {
          giJ();
        }
        if (!paramBoolean) {
          this.MkH.aFx();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */