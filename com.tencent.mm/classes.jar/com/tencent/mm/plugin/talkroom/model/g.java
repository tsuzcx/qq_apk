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
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ak.f, com.tencent.mm.bh.a, com.tencent.mm.bh.c, com.tencent.mm.model.ak
{
  public static final int[] BFQ = { 80, 8080, 16285 };
  public static final byte[][] BFR = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  private int BFB;
  private int BFC;
  private boolean BFD;
  public String BFE;
  private int BFF;
  private int BFG;
  private int BFH;
  private LinkedList<dna> BFI;
  private com.tencent.mm.plugin.talkroom.component.a BFJ;
  private com.tencent.mm.plugin.talkroom.component.b BFK;
  private com.tencent.mm.plugin.talkroom.component.e BFL;
  private com.tencent.mm.plugin.talkroom.component.d BFM;
  private ai BFN;
  private aw BFO;
  private i BFP;
  public boolean BFS;
  private final ServiceConnection oXF;
  private int roomId;
  private int state;
  private long uXg;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.BFB = 0;
    this.BFC = 0;
    this.state = 0;
    this.BFD = false;
    this.BFI = new LinkedList();
    this.BFP = new i();
    this.oXF = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        ae.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).s("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.D(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.sO(true);
              AppMethodBeat.o(29482);
            }
          });
        }
        AppMethodBeat.o(29483);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(29484);
        ae.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        AppMethodBeat.o(29484);
      }
    };
    this.BFS = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private void Tu(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.BFJ != null) {
      try
      {
        erB();
        AppMethodBeat.o(29510);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        AppMethodBeat.o(29510);
        return;
      }
    }
    if (paramInt == 0)
    {
      this.BFP.s("bind talkroomService timeout", 3, -1);
      AppMethodBeat.o(29510);
      return;
    }
    new aq().postDelayed(new Runnable()
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
  
  private void Tv(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.BFF)
    {
      this.BFF = paramInt;
      if (this.state >= 3) {
        this.BFP.qk(311);
      }
      erA();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String Tw(int paramInt)
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
      ae.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
      AppMethodBeat.o(29516);
    }
    return null;
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.BFJ != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.BFJ.d(arrayOfInt, paramString);
        int i = arrayOfInt[0];
        AppMethodBeat.o(29520);
        return i;
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          ae.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(29520);
    return -99;
  }
  
  private void erA()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.ern().eru();
      if (this.BFM != null) {
        this.BFM.erh();
      }
      if (this.BFL != null) {
        this.BFL.edW();
      }
      this.state = 2;
      AppMethodBeat.o(29508);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29508);
    }
  }
  
  private void erB()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.BFD = false;
    if (!erC())
    {
      AppMethodBeat.o(29511);
      return;
    }
    erz();
    erE();
    erD();
    if (this.BFN != null)
    {
      ae.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.BFN = new ai(new ai.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29491);
        if ((g.e(g.this) == 0) || (bu.isNullOrNil(g.g(g.this))))
        {
          ae.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(g.this)), g.g(g.this) });
          g.h(g.this);
          AppMethodBeat.o(29491);
          return false;
        }
        Object localObject = g.g(g.this);
        int i = g.e(g.this);
        long l = g.f(g.this);
        g localg = g.this;
        g.g(g.this);
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.erv());
        bc.ajj().a((n)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    });
    this.BFN.fos();
    AppMethodBeat.o(29511);
  }
  
  private boolean erC()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.BFJ.erf();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      AppMethodBeat.o(29512);
    }
    ae.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.BFJ = null;
      ae.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.BFP.s("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void erD()
  {
    AppMethodBeat.i(29515);
    if (this.BFJ == null)
    {
      ae.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.BFL = this.BFJ.a(new c.a()
    {
      public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).Hk("");
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
        String str = g.this.erw();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.erv());
          bc.ajj().a((n)localObject, 0);
          localObject = b.ern();
          ((f)localObject).BFg += 1;
          localObject = b.ern();
          ((f)localObject).BFh += 1;
        }
        g.a(g.this).Hk(str);
        be.aI(com.tencent.mm.sdk.platformtools.ak.getContext(), 2131764376);
        AppMethodBeat.o(29492);
      }
    });
    this.BFL.start();
    this.BFM = this.BFJ.erg();
    this.BFM.start();
    AppMethodBeat.o(29515);
  }
  
  private void erE()
  {
    AppMethodBeat.i(29517);
    if (this.BFI.size() == 0)
    {
      ae.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.BFP.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.BFI.size()];
    int[] arrayOfInt2 = new int[this.BFI.size()];
    String[] arrayOfString = new String[this.BFI.size()];
    ae.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.BFI.size()) });
    int i = 0;
    while (i < this.BFI.size())
    {
      arrayOfInt1[i] = ((dna)this.BFI.get(i)).HUj;
      arrayOfInt2[i] = ((dna)this.BFI.get(i)).Hzv;
      arrayOfString[i] = ((dna)this.BFI.get(i)).HUk;
      ae.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { Tw(((dna)this.BFI.get(i)).HUj), ((dna)this.BFI.get(i)).HUk, Integer.valueOf(((dna)this.BFI.get(i)).Hzv) });
      i += 1;
    }
    ae.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.BFG), Integer.valueOf(this.roomId), Long.valueOf(this.uXg) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.BFJ;
      com.tencent.mm.plugin.talkroom.component.b localb = this.BFK;
      bc.aCg();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.BFG, this.roomId, this.uXg, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        ae.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.BFP.j(3, i, "engine.Open error");
      }
      AppMethodBeat.o(29517);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = -99999;
      }
    }
  }
  
  private boolean erx()
  {
    AppMethodBeat.i(29499);
    if (erv() == 1) {
      b(b.erj().BEK);
    }
    while (this.BFC > 0)
    {
      ae.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.erj().BEK);
    }
    bc.ajj().a(332, this);
    bc.ajj().a(334, this);
    bc.ajj().a(336, this);
    bc.ajj().a(335, this);
    b.erl().a(this);
    bc.MW().a(this);
    this.BFC = 1;
    if (this.BFJ != null) {}
    try
    {
      this.BFJ.Close();
      this.BFJ.uninitLive();
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ak.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.ak.getContext().bindService(localIntent, this.oXF, 1);
      this.BFK = new b.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          ae.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.ern().ers();
          b.ern().BEY = 1;
          g.a(g.this).s("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.ery();
              AppMethodBeat.o(29486);
            }
          });
          AppMethodBeat.o(29488);
        }
        
        public final void keep_OnOpenSuccess()
        {
          AppMethodBeat.i(29487);
          ae.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
          if (g.b(g.this) != 1)
          {
            ae.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(g.this)) });
            AppMethodBeat.o(29487);
            return;
          }
          b.ern().ers();
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29485);
              g.c(g.this);
              AppMethodBeat.o(29485);
            }
          });
          g.d(g.this);
          g.a(g.this).aMy();
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
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void erz()
  {
    AppMethodBeat.i(29503);
    if (this.BFL != null) {}
    try
    {
      this.BFL.release();
      this.BFL = null;
      if (this.BFM == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.BFM.release();
        this.BFM = null;
        if (this.BFN != null)
        {
          this.BFN.stopTimer();
          this.BFN = null;
        }
        if (this.BFO != null)
        {
          this.BFO.stopTimer();
          this.BFO = null;
        }
        AppMethodBeat.o(29503);
        return;
        localRemoteException1 = localRemoteException1;
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(29500);
    this.BFC = 0;
    bc.ajj().b(332, this);
    bc.ajj().b(334, this);
    bc.ajj().b(336, this);
    bc.ajj().b(335, this);
    b.erl().b(this);
    bc.MW().b(this);
    b(b.erj().BEK);
    int j = -99999;
    int i = j;
    if (this.BFJ != null) {}
    try
    {
      i = this.BFJ.uninitLive();
      com.tencent.mm.sdk.platformtools.ak.getContext().unbindService(this.oXF);
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ak.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.ak.getContext().stopService(localIntent);
      this.BFJ = null;
      if (i < 0) {
        ae.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(29500);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (bu.isNullOrNil(this.BFE))
    {
      AppMethodBeat.o(29504);
      return;
    }
    bc.aCg();
    au localau = com.tencent.mm.model.c.azL().aVa(this.BFE);
    if (localau == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localau.qI(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, i, localau.field_conversationTime));
      bc.aCg();
      com.tencent.mm.model.c.azL().a(localau, this.BFE);
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
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:BFP	Lcom/tencent/mm/plugin/talkroom/model/i;
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
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:BFP	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 543	com/tencent/mm/plugin/talkroom/model/g:erw	()Ljava/lang/String;
    //   36: invokevirtual 547	com/tencent/mm/plugin/talkroom/model/i:Hk	(Ljava/lang/String;)V
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
  
  public final void aBN()
  {
    AppMethodBeat.i(29522);
    ae.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bu.isNullOrNil(this.BFE)) {
      ae.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.BFS = false;
      locali = this.BFP;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      erA();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void aBO()
  {
    AppMethodBeat.i(29523);
    ae.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bu.isNullOrNil(this.BFE)) {
        ae.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.BFS = true;
        i locali = this.BFP;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.BFM != null) {
          this.BFM.erh();
        }
        if (this.BFL != null) {
          this.BFL.cyX();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
      AppMethodBeat.o(29523);
    }
  }
  
  public final void aMs()
  {
    AppMethodBeat.i(29509);
    ae.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.ern();
    localf.BFz = true;
    localf.BFy = bu.HQ();
    try
    {
      this.BFM.aMs();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short aMt()
  {
    AppMethodBeat.i(29518);
    if (this.BFM == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.BFM.eri();
      short s = (short)i;
      AppMethodBeat.o(29518);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29518);
    }
    return 0;
  }
  
  public final short aMu()
  {
    AppMethodBeat.i(29519);
    if (this.BFL == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.BFL.eri();
      short s = (short)i;
      AppMethodBeat.o(29519);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29519);
    }
    return 0;
  }
  
  public final boolean aMv()
  {
    AppMethodBeat.i(29505);
    ae.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      ae.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.BFP.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.BFL != null) {}
    try
    {
      this.BFL.cyX();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.uXg, 1, this.BFE, erv());
      bc.ajj().a(locald, 0);
      b.ern().BFx = bu.HQ();
      b.ern().BFA = true;
      AppMethodBeat.o(29505);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void aMw()
  {
    AppMethodBeat.i(29506);
    ae.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.ern();
    if ((((f)localObject).BFA) && (!((f)localObject).BFz)) {
      ((f)localObject).BFu += 1;
    }
    ((f)localObject).BFz = false;
    ((f)localObject).BFA = false;
    if (this.state < 3)
    {
      ae.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.BFO != null)
    {
      this.BFO.stopTimer();
      this.BFO = null;
    }
    erA();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.uXg, 2, this.BFE, erv());
    bc.ajj().a((n)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean aMx()
  {
    return this.BFS;
  }
  
  public final void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    ae.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.BFB = paramInt;
    erx();
    if (paramString.equals(this.BFE))
    {
      ae.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.BFP.aMy();
      }
      AppMethodBeat.o(29501);
      return;
    }
    ae.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.BFE = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.BFE, erv());
    bc.ajj().a((n)localObject, 0);
    b.erj().BEM = new f();
    b.ern().BFv = bu.HQ();
    b.ern().BFs = paramString;
    if (erv() == 0) {
      b.erj().BEK.vpK = true;
    }
    localObject = this.BFP;
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
    i locali = this.BFP;
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
  
  public final List djn()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.erl().aEa(this.BFE);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int erv()
  {
    AppMethodBeat.i(29494);
    if ((this.BFB == 1) || ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(this.BFE))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String erw()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.erl().aEa(this.BFE).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dnb localdnb = (dnb)((Iterator)localObject).next();
      if (localdnb.HUl == this.BFH)
      {
        localObject = localdnb.nIJ;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void ery()
  {
    AppMethodBeat.i(29502);
    ae.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    sN(false);
    if (bu.isNullOrNil(this.BFE))
    {
      ae.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.ern().exitRoom();
    this.state = 0;
    this.BFD = false;
    int i = this.roomId;
    long l = this.uXg;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.BFE;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, erv());
      bc.ajj().a((n)localObject1, 0);
      if (this.BFJ != null) {}
      try
      {
        i = this.BFJ.Close();
        if (i < 0) {
          ae.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, w.zP(this.BFE)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          ae.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          dnc localdnc = new dnc();
          localdnc.HgA = 10402;
          localdnc.HUm = new cxn().aQV((String)localObject1);
          localObject1 = new dnc();
          ((dnc)localObject1).HgA = 10404;
          ((dnc)localObject1).HUm = new cxn().aQV(b.ern().toString());
          ((LinkedList)localObject2).add(localdnc);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, erv());
          bc.ajj().a((n)localObject1, 0);
        }
        this.BFE = "";
        this.roomId = 0;
        this.uXg = 0L;
        this.BFF = 0;
        this.BFG = 0;
        this.BFH = 0;
        this.BFI.clear();
        erz();
        this.BFP.aMA();
        b.erj().BEK.erp();
        removeListener();
        AppMethodBeat.o(29502);
        return;
        localObject1 = "";
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29521);
    if (!paramString1.equals(this.BFE))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.BFP;
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
    ae.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramn;
    if ((paramString.erF() == null) || (!paramString.erF().equals(this.BFE)))
    {
      ae.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.erF(), this.BFE });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 332)
      {
        b.ern().Tt(2);
        if (paramInt1 == 4) {
          b.ern().BFt = paramInt2;
        }
        this.BFP.s("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        ery();
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
        paramString = b.ern();
        paramString.BFc += 1;
        paramString.BFx = 0L;
        erA();
        ae.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.BFP.qk(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.BFP.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 336)
      {
        this.BFD = false;
        this.BFP.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        ery();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 335)
      {
        this.BFP.j(paramInt1, paramInt2, "TalkNoop failed!!");
        ery();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramn.getType() == 332)
    {
      b.ern().Tt(1);
      paramn = (com.tencent.mm.plugin.talkroom.b.a)paramn;
      this.roomId = paramn.roomId;
      this.uXg = paramn.uXg;
      this.BFF = paramn.BFF;
      this.BFG = paramn.BFG;
      this.BFI = paramn.BFI;
      localObject = b.ern();
      paramInt1 = this.roomId;
      long l = this.uXg;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).uXg = l;
      paramn = paramn.BGa;
      b.erl().a(this.BFE, paramn, null, null, paramString.erG());
      Tu(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramn;
      if (paramString.actionType == 1)
      {
        paramn = b.ern();
        if (paramn.BFx != 0L)
        {
          paramn.BFa = ((bu.aO(paramn.BFx) + paramn.BFa * paramn.BFw) / (paramn.BFw + 1));
          paramn.BFw += 1;
          paramn.BFb += 1;
          paramn.BFx = 0L;
        }
        ae.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.BFF < this.BFF)
        {
          ae.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.BFF), Integer.valueOf(this.BFF) });
          erA();
          this.BFP.qk(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.BFF = paramString.BFF;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.BFJ.SetCurrentMicId(this.BFF);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.BFP;
          paramn = new i.6(paramString);
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label861;
          }
        }
        if (this.state != 3)
        {
          ae.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
          AppMethodBeat.o(29507);
          return;
        }
        paramn.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            ae.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.BFO == null)
          {
            this.BFO = new aw(new aw.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.erv());
                bc.ajj().a((n)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.BFO.ay(5000L, 5000L);
          }
          AppMethodBeat.o(29507);
          return;
          label861:
          paramString.handler.post(paramn);
        }
      }
      ae.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramn;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).BGa;
      b.erl().a(this.BFE, localLinkedList, null, null, paramString.erG());
      Tv(((com.tencent.mm.plugin.talkroom.b.c)localObject).BFF);
      this.BFD = false;
      this.BFP.Hk(erw());
    }
    if ((paramn.getType() == 335) && (this.state == 0)) {
      this.BFP.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    ae.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.BFE });
    if ((bu.isNullOrNil(this.BFE)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.ern().ert();
    if (paramBoolean) {
      if (!erC())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      erD();
      erA();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.BFJ != null) {
          this.BFJ.Close();
        }
        if (this.roomId != 0) {
          erE();
        }
        if (!paramBoolean) {
          this.BFP.aMD();
        }
        AppMethodBeat.o(29514);
        return;
        localRemoteException1 = localRemoteException1;
        ae.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
        ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */