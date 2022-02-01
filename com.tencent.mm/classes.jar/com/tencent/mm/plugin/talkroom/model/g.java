package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ak.g, com.tencent.mm.bh.a, com.tencent.mm.bh.c, com.tencent.mm.model.ai
{
  public static final int[] zWN = { 80, 8080, 16285 };
  public static final byte[][] zWO;
  private final ServiceConnection onI;
  private int roomId;
  private int state;
  private long tIG;
  private boolean zWA;
  public String zWB;
  private int zWC;
  private int zWD;
  private int zWE;
  private LinkedList<dgq> zWF;
  private com.tencent.mm.plugin.talkroom.component.a zWG;
  private com.tencent.mm.plugin.talkroom.component.b zWH;
  private com.tencent.mm.plugin.talkroom.component.e zWI;
  private com.tencent.mm.plugin.talkroom.component.d zWJ;
  private ag zWK;
  private au zWL;
  private i zWM;
  public boolean zWP;
  private int zWy;
  private int zWz;
  
  static
  {
    byte[] arrayOfByte1 = { 101, -30, 76, 27 };
    byte[] arrayOfByte2 = { 120, -52, -55, -58 };
    zWO = new byte[][] { arrayOfByte1, { 112, 64, -19, -29 }, arrayOfByte2 };
  }
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.zWy = 0;
    this.zWz = 0;
    this.state = 0;
    this.zWA = false;
    this.zWF = new LinkedList();
    this.zWM = new i();
    this.onI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        ac.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).q("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.C(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.sb(true);
              AppMethodBeat.o(29482);
            }
          });
        }
        AppMethodBeat.o(29483);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(29484);
        ac.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        AppMethodBeat.o(29484);
      }
    };
    this.zWP = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private void Rd(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.zWG != null) {
      try
      {
        ebD();
        AppMethodBeat.o(29510);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        AppMethodBeat.o(29510);
        return;
      }
    }
    if (paramInt == 0)
    {
      this.zWM.q("bind talkroomService timeout", 3, -1);
      AppMethodBeat.o(29510);
      return;
    }
    new ao().postDelayed(new Runnable()
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
  
  private void Re(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.zWC)
    {
      this.zWC = paramInt;
      if (this.state >= 3) {
        this.zWM.pF(311);
      }
      ebC();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String Rf(int paramInt)
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
      ac.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
      AppMethodBeat.o(29516);
    }
    return null;
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.zWG != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.zWG.d(arrayOfInt, paramString);
        int i = arrayOfInt[0];
        AppMethodBeat.o(29520);
        return i;
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          ac.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(29520);
    return -99;
  }
  
  private void ebB()
  {
    AppMethodBeat.i(29503);
    if (this.zWI != null) {}
    try
    {
      this.zWI.release();
      this.zWI = null;
      if (this.zWJ == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.zWJ.release();
        this.zWJ = null;
        if (this.zWK != null)
        {
          this.zWK.stopTimer();
          this.zWK = null;
        }
        if (this.zWL != null)
        {
          this.zWL.stopTimer();
          this.zWL = null;
        }
        AppMethodBeat.o(29503);
        return;
        localRemoteException1 = localRemoteException1;
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void ebC()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.ebp().ebw();
      if (this.zWJ != null) {
        this.zWJ.ebj();
      }
      if (this.zWI != null) {
        this.zWI.dOc();
      }
      this.state = 2;
      AppMethodBeat.o(29508);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29508);
    }
  }
  
  private void ebD()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.zWA = false;
    if (!ebE())
    {
      AppMethodBeat.o(29511);
      return;
    }
    ebB();
    ebG();
    ebF();
    if (this.zWK != null)
    {
      ac.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.zWK = new ag(new ag.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29491);
        if ((g.e(g.this) == 0) || (bs.isNullOrNil(g.g(g.this))))
        {
          ac.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(g.this)), g.g(g.this) });
          g.h(g.this);
          AppMethodBeat.o(29491);
          return false;
        }
        Object localObject = g.g(g.this);
        int i = g.e(g.this);
        long l = g.f(g.this);
        g localg = g.this;
        g.g(g.this);
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.ebx());
        com.tencent.mm.model.az.agi().a((n)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    });
    this.zWK.eUT();
    AppMethodBeat.o(29511);
  }
  
  private boolean ebE()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.zWG.ebh();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      AppMethodBeat.o(29512);
    }
    ac.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.zWG = null;
      ac.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.zWM.q("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void ebF()
  {
    AppMethodBeat.i(29515);
    if (this.zWG == null)
    {
      ac.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.zWI = this.zWG.a(new c.a()
    {
      public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).DD("");
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
        String str = g.this.eby();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.ebx());
          com.tencent.mm.model.az.agi().a((n)localObject, 0);
          localObject = b.ebp();
          ((f)localObject).zWd += 1;
          localObject = b.ebp();
          ((f)localObject).zWe += 1;
        }
        g.a(g.this).DD(str);
        bc.aF(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131764376);
        AppMethodBeat.o(29492);
      }
    });
    this.zWI.start();
    this.zWJ = this.zWG.ebi();
    this.zWJ.start();
    AppMethodBeat.o(29515);
  }
  
  private void ebG()
  {
    AppMethodBeat.i(29517);
    if (this.zWF.size() == 0)
    {
      ac.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.zWM.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.zWF.size()];
    int[] arrayOfInt2 = new int[this.zWF.size()];
    String[] arrayOfString = new String[this.zWF.size()];
    ac.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.zWF.size()) });
    int i = 0;
    while (i < this.zWF.size())
    {
      arrayOfInt1[i] = ((dgq)this.zWF.get(i)).FPR;
      arrayOfInt2[i] = ((dgq)this.zWF.get(i)).FvP;
      arrayOfString[i] = ((dgq)this.zWF.get(i)).FPS;
      ac.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { Rf(((dgq)this.zWF.get(i)).FPR), ((dgq)this.zWF.get(i)).FPS, Integer.valueOf(((dgq)this.zWF.get(i)).FvP) });
      i += 1;
    }
    ac.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.zWD), Integer.valueOf(this.roomId), Long.valueOf(this.tIG) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.zWG;
      com.tencent.mm.plugin.talkroom.component.b localb = this.zWH;
      com.tencent.mm.model.az.ayM();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.zWD, this.roomId, this.tIG, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        ac.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.zWM.j(3, i, "engine.Open error");
      }
      AppMethodBeat.o(29517);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = -99999;
      }
    }
  }
  
  private boolean ebz()
  {
    AppMethodBeat.i(29499);
    if (ebx() == 1) {
      b(b.ebl().zVH);
    }
    while (this.zWz > 0)
    {
      ac.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.ebl().zVH);
    }
    com.tencent.mm.model.az.agi().a(332, this);
    com.tencent.mm.model.az.agi().a(334, this);
    com.tencent.mm.model.az.agi().a(336, this);
    com.tencent.mm.model.az.agi().a(335, this);
    b.ebn().a(this);
    com.tencent.mm.model.az.Lt().a(this);
    this.zWz = 1;
    if (this.zWG != null) {}
    try
    {
      this.zWG.Close();
      this.zWG.uninitLive();
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ai.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.ai.getContext().bindService(localIntent, this.onI, 1);
      this.zWH = new b.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          ac.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.ebp().ebu();
          b.ebp().zVV = 1;
          g.a(g.this).q("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.ebA();
              AppMethodBeat.o(29486);
            }
          });
          AppMethodBeat.o(29488);
        }
        
        public final void keep_OnOpenSuccess()
        {
          AppMethodBeat.i(29487);
          ac.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
          if (g.b(g.this) != 1)
          {
            ac.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(g.this)) });
            AppMethodBeat.o(29487);
            return;
          }
          b.ebp().ebu();
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29485);
              g.c(g.this);
              AppMethodBeat.o(29485);
            }
          });
          g.d(g.this);
          g.a(g.this).aIR();
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
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(29500);
    this.zWz = 0;
    com.tencent.mm.model.az.agi().b(332, this);
    com.tencent.mm.model.az.agi().b(334, this);
    com.tencent.mm.model.az.agi().b(336, this);
    com.tencent.mm.model.az.agi().b(335, this);
    b.ebn().b(this);
    com.tencent.mm.model.az.Lt().b(this);
    b(b.ebl().zVH);
    int j = -99999;
    int i = j;
    if (this.zWG != null) {}
    try
    {
      i = this.zWG.uninitLive();
      com.tencent.mm.sdk.platformtools.ai.getContext().unbindService(this.onI);
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ai.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.ai.getContext().stopService(localIntent);
      this.zWG = null;
      if (i < 0) {
        ac.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(29500);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (bs.isNullOrNil(this.zWB))
    {
      AppMethodBeat.o(29504);
      return;
    }
    com.tencent.mm.model.az.ayM();
    ap localap = com.tencent.mm.model.c.awG().aNI(this.zWB);
    if (localap == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localap.ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, i, localap.field_conversationTime));
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(localap, this.zWB);
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
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:zWM	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   10: astore_2
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_2
    //   14: getfield 534	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 540 2 0
    //   23: ifeq +23 -> 46
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:zWM	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 543	com/tencent/mm/plugin/talkroom/model/g:eby	()Ljava/lang/String;
    //   36: invokevirtual 547	com/tencent/mm/plugin/talkroom/model/i:DD	(Ljava/lang/String;)V
    //   39: sipush 29497
    //   42: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: getfield 534	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 550 2 0
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
  
  public final void aIL()
  {
    AppMethodBeat.i(29509);
    ac.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.ebp();
    localf.zWw = true;
    localf.zWv = bs.Gn();
    try
    {
      this.zWJ.aIL();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short aIM()
  {
    AppMethodBeat.i(29518);
    if (this.zWJ == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.zWJ.ebk();
      short s = (short)i;
      AppMethodBeat.o(29518);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29518);
    }
    return 0;
  }
  
  public final short aIN()
  {
    AppMethodBeat.i(29519);
    if (this.zWI == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.zWI.ebk();
      short s = (short)i;
      AppMethodBeat.o(29519);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29519);
    }
    return 0;
  }
  
  public final boolean aIO()
  {
    AppMethodBeat.i(29505);
    ac.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      ac.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.zWM.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.zWI != null) {}
    try
    {
      this.zWI.crK();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.tIG, 1, this.zWB, ebx());
      com.tencent.mm.model.az.agi().a(locald, 0);
      b.ebp().zWu = bs.Gn();
      b.ebp().zWx = true;
      AppMethodBeat.o(29505);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void aIP()
  {
    AppMethodBeat.i(29506);
    ac.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.ebp();
    if ((((f)localObject).zWx) && (!((f)localObject).zWw)) {
      ((f)localObject).zWr += 1;
    }
    ((f)localObject).zWw = false;
    ((f)localObject).zWx = false;
    if (this.state < 3)
    {
      ac.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.zWL != null)
    {
      this.zWL.stopTimer();
      this.zWL = null;
    }
    ebC();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.tIG, 2, this.zWB, ebx());
    com.tencent.mm.model.az.agi().a((n)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean aIQ()
  {
    return this.zWP;
  }
  
  public final void ap(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    ac.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.zWy = paramInt;
    ebz();
    if (paramString.equals(this.zWB))
    {
      ac.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.zWM.aIR();
      }
      AppMethodBeat.o(29501);
      return;
    }
    ac.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.zWB = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.zWB, ebx());
    com.tencent.mm.model.az.agi().a((n)localObject, 0);
    b.ebl().zVJ = new f();
    b.ebp().zWs = bs.Gn();
    b.ebp().zWp = paramString;
    if (ebx() == 0) {
      b.ebl().zVH.uaQ = true;
    }
    localObject = this.zWM;
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
  
  public final void ayt()
  {
    AppMethodBeat.i(29522);
    ac.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bs.isNullOrNil(this.zWB)) {
      ac.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.zWP = false;
      locali = this.zWM;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      ebC();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void ayu()
  {
    AppMethodBeat.i(29523);
    ac.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bs.isNullOrNil(this.zWB)) {
        ac.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.zWP = true;
        i locali = this.zWM;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.zWJ != null) {
          this.zWJ.ebj();
        }
        if (this.zWI != null) {
          this.zWI.crK();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
      AppMethodBeat.o(29523);
    }
  }
  
  public final void b(com.tencent.mm.bh.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.zWM;
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
  
  public final List cXc()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.ebn().axD(this.zWB);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final void ebA()
  {
    AppMethodBeat.i(29502);
    ac.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    sa(false);
    if (bs.isNullOrNil(this.zWB))
    {
      ac.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.ebp().exitRoom();
    this.state = 0;
    this.zWA = false;
    int i = this.roomId;
    long l = this.tIG;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.zWB;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, ebx());
      com.tencent.mm.model.az.agi().a((n)localObject1, 0);
      if (this.zWG != null) {}
      try
      {
        i = this.zWG.Close();
        if (i < 0) {
          ac.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, v.wk(this.zWB)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          ac.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          dgs localdgs = new dgs();
          localdgs.Fdx = 10402;
          localdgs.FPU = new crm().aJV((String)localObject1);
          localObject1 = new dgs();
          ((dgs)localObject1).Fdx = 10404;
          ((dgs)localObject1).FPU = new crm().aJV(b.ebp().toString());
          ((LinkedList)localObject2).add(localdgs);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, ebx());
          com.tencent.mm.model.az.agi().a((n)localObject1, 0);
        }
        this.zWB = "";
        this.roomId = 0;
        this.tIG = 0L;
        this.zWC = 0;
        this.zWD = 0;
        this.zWE = 0;
        this.zWF.clear();
        ebB();
        this.zWM.aIT();
        b.ebl().zVH.ebr();
        removeListener();
        AppMethodBeat.o(29502);
        return;
        localObject1 = "";
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  public final int ebx()
  {
    AppMethodBeat.i(29494);
    if ((this.zWy == 1) || ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(this.zWB))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String eby()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.ebn().axD(this.zWB).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dgr localdgr = (dgr)((Iterator)localObject).next();
      if (localdgr.FPT == this.zWE)
      {
        localObject = localdgr.ncR;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29521);
    if (!paramString1.equals(this.zWB))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.zWM;
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29507);
    ac.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramn;
    if ((paramString.ebH() == null) || (!paramString.ebH().equals(this.zWB)))
    {
      ac.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.ebH(), this.zWB });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 332)
      {
        b.ebp().Rc(2);
        if (paramInt1 == 4) {
          b.ebp().zWq = paramInt2;
        }
        this.zWM.q("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        ebA();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 334)
      {
        if (((com.tencent.mm.plugin.talkroom.b.d)paramn).actionType != 1)
        {
          AppMethodBeat.o(29507);
          return;
        }
        paramString = b.ebp();
        paramString.zVZ += 1;
        paramString.zWu = 0L;
        ebC();
        ac.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.zWM.pF(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.zWM.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 336)
      {
        this.zWA = false;
        this.zWM.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        ebA();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 335)
      {
        this.zWM.j(paramInt1, paramInt2, "TalkNoop failed!!");
        ebA();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramn.getType() == 332)
    {
      b.ebp().Rc(1);
      paramn = (com.tencent.mm.plugin.talkroom.b.a)paramn;
      this.roomId = paramn.roomId;
      this.tIG = paramn.tIG;
      this.zWC = paramn.zWC;
      this.zWD = paramn.zWD;
      this.zWF = paramn.zWF;
      localObject = b.ebp();
      paramInt1 = this.roomId;
      long l = this.tIG;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).tIG = l;
      paramn = paramn.zWX;
      b.ebn().a(this.zWB, paramn, null, null, paramString.ebI());
      Rd(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramn;
      if (paramString.actionType == 1)
      {
        paramn = b.ebp();
        if (paramn.zWu != 0L)
        {
          paramn.zVX = ((bs.aO(paramn.zWu) + paramn.zVX * paramn.zWt) / (paramn.zWt + 1));
          paramn.zWt += 1;
          paramn.zVY += 1;
          paramn.zWu = 0L;
        }
        ac.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.zWC < this.zWC)
        {
          ac.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.zWC), Integer.valueOf(this.zWC) });
          ebC();
          this.zWM.pF(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.zWC = paramString.zWC;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.zWG.SetCurrentMicId(this.zWC);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.zWM;
          paramn = new i.6(paramString);
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label861;
          }
        }
        if (this.state != 3)
        {
          ac.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
          AppMethodBeat.o(29507);
          return;
        }
        paramn.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            ac.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.zWL == null)
          {
            this.zWL = new au(new au.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.ebx());
                com.tencent.mm.model.az.agi().a((n)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.zWL.au(5000L, 5000L);
          }
          AppMethodBeat.o(29507);
          return;
          label861:
          paramString.handler.post(paramn);
        }
      }
      ac.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramn;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).zWX;
      b.ebn().a(this.zWB, localLinkedList, null, null, paramString.ebI());
      Re(((com.tencent.mm.plugin.talkroom.b.c)localObject).zWC);
      this.zWA = false;
      this.zWM.DD(eby());
    }
    if ((paramn.getType() == 335) && (this.state == 0)) {
      this.zWM.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    ac.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.zWB });
    if ((bs.isNullOrNil(this.zWB)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.ebp().ebv();
    if (paramBoolean) {
      if (!ebE())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      ebF();
      ebC();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.zWG != null) {
          this.zWG.Close();
        }
        if (this.roomId != 0) {
          ebG();
        }
        if (!paramBoolean) {
          this.zWM.aIW();
        }
        AppMethodBeat.o(29514);
        return;
        localRemoteException1 = localRemoteException1;
        ac.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
        ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */