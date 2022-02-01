package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.al.f, com.tencent.mm.bi.a, com.tencent.mm.bi.c, com.tencent.mm.model.aj
{
  public static final int[] Bor = { 80, 8080, 16285 };
  public static final byte[][] Bos = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  private int Boc;
  private int Bod;
  private boolean Boe;
  public String Bof;
  private int Bog;
  private int Boh;
  private int Boi;
  private LinkedList<dmd> Boj;
  private com.tencent.mm.plugin.talkroom.component.a Bok;
  private com.tencent.mm.plugin.talkroom.component.b Bol;
  private com.tencent.mm.plugin.talkroom.component.e Bom;
  private com.tencent.mm.plugin.talkroom.component.d Bon;
  private ah Boo;
  private av Bop;
  private i Boq;
  public boolean Bot;
  private final ServiceConnection oRd;
  private int roomId;
  private int state;
  private long uLt;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.Boc = 0;
    this.Bod = 0;
    this.state = 0;
    this.Boe = false;
    this.Boj = new LinkedList();
    this.Boq = new i();
    this.oRd = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        ad.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).s("enterTalkRoom bindServie or protocalInit failed", 3, -1);
          AppMethodBeat.o(29483);
          return;
        }
        g.a(g.this, a.a.C(paramAnonymousIBinder));
        if (g.b(g.this) >= 2) {
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29482);
              g.this.sH(true);
              AppMethodBeat.o(29482);
            }
          });
        }
        AppMethodBeat.o(29483);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(29484);
        ad.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        AppMethodBeat.o(29484);
      }
    };
    this.Bot = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private void SN(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.Bok != null) {
      try
      {
        enU();
        AppMethodBeat.o(29510);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        AppMethodBeat.o(29510);
        return;
      }
    }
    if (paramInt == 0)
    {
      this.Boq.s("bind talkroomService timeout", 3, -1);
      AppMethodBeat.o(29510);
      return;
    }
    new ap().postDelayed(new Runnable()
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
  
  private void SO(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.Bog)
    {
      this.Bog = paramInt;
      if (this.state >= 3) {
        this.Boq.qh(311);
      }
      enT();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String SP(int paramInt)
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
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
      AppMethodBeat.o(29516);
    }
    return null;
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(29520);
    if (this.Bok != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.Bok.d(arrayOfInt, paramString);
        int i = arrayOfInt[0];
        AppMethodBeat.o(29520);
        return i;
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          ad.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(29520);
    return -99;
  }
  
  private boolean enQ()
  {
    AppMethodBeat.i(29499);
    if (enO() == 1) {
      b(b.enC().Bnl);
    }
    while (this.Bod > 0)
    {
      ad.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.enC().Bnl);
    }
    com.tencent.mm.model.ba.aiU().a(332, this);
    com.tencent.mm.model.ba.aiU().a(334, this);
    com.tencent.mm.model.ba.aiU().a(336, this);
    com.tencent.mm.model.ba.aiU().a(335, this);
    b.enE().a(this);
    com.tencent.mm.model.ba.Nb().a(this);
    this.Bod = 1;
    if (this.Bok != null) {}
    try
    {
      this.Bok.Close();
      this.Bok.uninitLive();
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.aj.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.aj.getContext().bindService(localIntent, this.oRd, 1);
      this.Bol = new b.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          ad.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.enG().enL();
          b.enG().Bnz = 1;
          g.a(g.this).s("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.enR();
              AppMethodBeat.o(29486);
            }
          });
          AppMethodBeat.o(29488);
        }
        
        public final void keep_OnOpenSuccess()
        {
          AppMethodBeat.i(29487);
          ad.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
          if (g.b(g.this) != 1)
          {
            ad.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(g.this)) });
            AppMethodBeat.o(29487);
            return;
          }
          b.enG().enL();
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29485);
              g.c(g.this);
              AppMethodBeat.o(29485);
            }
          });
          g.d(g.this);
          g.a(g.this).aMb();
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
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void enS()
  {
    AppMethodBeat.i(29503);
    if (this.Bom != null) {}
    try
    {
      this.Bom.release();
      this.Bom = null;
      if (this.Bon == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.Bon.release();
        this.Bon = null;
        if (this.Boo != null)
        {
          this.Boo.stopTimer();
          this.Boo = null;
        }
        if (this.Bop != null)
        {
          this.Bop.stopTimer();
          this.Bop = null;
        }
        AppMethodBeat.o(29503);
        return;
        localRemoteException1 = localRemoteException1;
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void enT()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.enG().enN();
      if (this.Bon != null) {
        this.Bon.enA();
      }
      if (this.Bom != null) {
        this.Bom.eaq();
      }
      this.state = 2;
      AppMethodBeat.o(29508);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29508);
    }
  }
  
  private void enU()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.Boe = false;
    if (!enV())
    {
      AppMethodBeat.o(29511);
      return;
    }
    enS();
    enX();
    enW();
    if (this.Boo != null)
    {
      ad.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.Boo = new ah(new ah.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29491);
        if ((g.e(g.this) == 0) || (bt.isNullOrNil(g.g(g.this))))
        {
          ad.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[] { Integer.valueOf(g.e(g.this)), g.g(g.this) });
          g.h(g.this);
          AppMethodBeat.o(29491);
          return false;
        }
        Object localObject = g.g(g.this);
        int i = g.e(g.this);
        long l = g.f(g.this);
        g localg = g.this;
        g.g(g.this);
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.enO());
        com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    });
    this.Boo.fky();
    AppMethodBeat.o(29511);
  }
  
  private boolean enV()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.Bok.eny();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      AppMethodBeat.o(29512);
    }
    ad.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.Bok = null;
      ad.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.Boq.s("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void enW()
  {
    AppMethodBeat.i(29515);
    if (this.Bok == null)
    {
      ad.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.Bom = this.Bok.a(new c.a()
    {
      public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).GI("");
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
        String str = g.this.enP();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.enO());
          com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
          localObject = b.enG();
          ((f)localObject).BnH += 1;
          localObject = b.enG();
          ((f)localObject).BnI += 1;
        }
        g.a(g.this).GI(str);
        bd.aI(com.tencent.mm.sdk.platformtools.aj.getContext(), 2131764376);
        AppMethodBeat.o(29492);
      }
    });
    this.Bom.start();
    this.Bon = this.Bok.enz();
    this.Bon.start();
    AppMethodBeat.o(29515);
  }
  
  private void enX()
  {
    AppMethodBeat.i(29517);
    if (this.Boj.size() == 0)
    {
      ad.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.Boq.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.Boj.size()];
    int[] arrayOfInt2 = new int[this.Boj.size()];
    String[] arrayOfString = new String[this.Boj.size()];
    ad.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.Boj.size()) });
    int i = 0;
    while (i < this.Boj.size())
    {
      arrayOfInt1[i] = ((dmd)this.Boj.get(i)).HAw;
      arrayOfInt2[i] = ((dmd)this.Boj.get(i)).HfV;
      arrayOfString[i] = ((dmd)this.Boj.get(i)).HAx;
      ad.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { SP(((dmd)this.Boj.get(i)).HAw), ((dmd)this.Boj.get(i)).HAx, Integer.valueOf(((dmd)this.Boj.get(i)).HfV) });
      i += 1;
    }
    ad.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.Boh), Integer.valueOf(this.roomId), Long.valueOf(this.uLt) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.Bok;
      com.tencent.mm.plugin.talkroom.component.b localb = this.Bol;
      com.tencent.mm.model.ba.aBQ();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.Boh, this.roomId, this.uLt, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        ad.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.Boq.j(3, i, "engine.Open error");
      }
      AppMethodBeat.o(29517);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = -99999;
      }
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(29500);
    this.Bod = 0;
    com.tencent.mm.model.ba.aiU().b(332, this);
    com.tencent.mm.model.ba.aiU().b(334, this);
    com.tencent.mm.model.ba.aiU().b(336, this);
    com.tencent.mm.model.ba.aiU().b(335, this);
    b.enE().b(this);
    com.tencent.mm.model.ba.Nb().b(this);
    b(b.enC().Bnl);
    int j = -99999;
    int i = j;
    if (this.Bok != null) {}
    try
    {
      i = this.Bok.uninitLive();
      com.tencent.mm.sdk.platformtools.aj.getContext().unbindService(this.oRd);
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.aj.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.aj.getContext().stopService(localIntent);
      this.Bok = null;
      if (i < 0) {
        ad.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(29500);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (bt.isNullOrNil(this.Bof))
    {
      AppMethodBeat.o(29504);
      return;
    }
    com.tencent.mm.model.ba.aBQ();
    at localat = com.tencent.mm.model.c.azv().aTz(this.Bof);
    if (localat == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localat.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, i, localat.field_conversationTime));
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(localat, this.Bof);
      AppMethodBeat.o(29504);
      return;
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.bi.d paramd)
  {
    // Byte code:
    //   0: sipush 29497
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:Boq	Lcom/tencent/mm/plugin/talkroom/model/i;
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
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:Boq	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 543	com/tencent/mm/plugin/talkroom/model/g:enP	()Ljava/lang/String;
    //   36: invokevirtual 547	com/tencent/mm/plugin/talkroom/model/i:GI	(Ljava/lang/String;)V
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
    //   0	73	1	paramd	com.tencent.mm.bi.d
    //   10	37	2	locali	i
    //   62	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	28	62	finally
    //   46	59	62	finally
    //   63	65	62	finally
  }
  
  public final void aBx()
  {
    AppMethodBeat.i(29522);
    ad.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bt.isNullOrNil(this.Bof)) {
      ad.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.Bot = false;
      locali = this.Boq;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      enT();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void aBy()
  {
    AppMethodBeat.i(29523);
    ad.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bt.isNullOrNil(this.Bof)) {
        ad.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.Bot = true;
        i locali = this.Boq;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.Bon != null) {
          this.Bon.enA();
        }
        if (this.Bom != null) {
          this.Bom.cxw();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
      AppMethodBeat.o(29523);
    }
  }
  
  public final void aLV()
  {
    AppMethodBeat.i(29509);
    ad.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.enG();
    localf.Boa = true;
    localf.BnZ = bt.HI();
    try
    {
      this.Bon.aLV();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short aLW()
  {
    AppMethodBeat.i(29518);
    if (this.Bon == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.Bon.enB();
      short s = (short)i;
      AppMethodBeat.o(29518);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29518);
    }
    return 0;
  }
  
  public final short aLX()
  {
    AppMethodBeat.i(29519);
    if (this.Bom == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.Bom.enB();
      short s = (short)i;
      AppMethodBeat.o(29519);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29519);
    }
    return 0;
  }
  
  public final boolean aLY()
  {
    AppMethodBeat.i(29505);
    ad.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      ad.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.Boq.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.Bom != null) {}
    try
    {
      this.Bom.cxw();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.uLt, 1, this.Bof, enO());
      com.tencent.mm.model.ba.aiU().a(locald, 0);
      b.enG().BnY = bt.HI();
      b.enG().Bob = true;
      AppMethodBeat.o(29505);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void aLZ()
  {
    AppMethodBeat.i(29506);
    ad.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.enG();
    if ((((f)localObject).Bob) && (!((f)localObject).Boa)) {
      ((f)localObject).BnV += 1;
    }
    ((f)localObject).Boa = false;
    ((f)localObject).Bob = false;
    if (this.state < 3)
    {
      ad.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.Bop != null)
    {
      this.Bop.stopTimer();
      this.Bop = null;
    }
    enT();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.uLt, 2, this.Bof, enO());
    com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean aMa()
  {
    return this.Bot;
  }
  
  public final void ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    ad.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.Boc = paramInt;
    enQ();
    if (paramString.equals(this.Bof))
    {
      ad.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.Boq.aMb();
      }
      AppMethodBeat.o(29501);
      return;
    }
    ad.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.Bof = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.Bof, enO());
    com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
    b.enC().Bnn = new f();
    b.enG().BnW = bt.HI();
    b.enG().BnT = paramString;
    if (enO() == 0) {
      b.enC().Bnl.vdz = true;
    }
    localObject = this.Boq;
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
  
  public final void b(com.tencent.mm.bi.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.Boq;
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
  
  public final List dgo()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.enE().aCH(this.Bof);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int enO()
  {
    AppMethodBeat.i(29494);
    if ((this.Boc == 1) || ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(this.Bof))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String enP()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.enE().aCH(this.Bof).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dme localdme = (dme)((Iterator)localObject).next();
      if (localdme.HAy == this.Boi)
      {
        localObject = localdme.nDo;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void enR()
  {
    AppMethodBeat.i(29502);
    ad.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    sG(false);
    if (bt.isNullOrNil(this.Bof))
    {
      ad.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.enG().exitRoom();
    this.state = 0;
    this.Boe = false;
    int i = this.roomId;
    long l = this.uLt;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.Bof;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, enO());
      com.tencent.mm.model.ba.aiU().a((n)localObject1, 0);
      if (this.Bok != null) {}
      try
      {
        i = this.Bok.Close();
        if (i < 0) {
          ad.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, v.zf(this.Bof)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          ad.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          dmf localdmf = new dmf();
          localdmf.GNa = 10402;
          localdmf.HAz = new cwt().aPy((String)localObject1);
          localObject1 = new dmf();
          ((dmf)localObject1).GNa = 10404;
          ((dmf)localObject1).HAz = new cwt().aPy(b.enG().toString());
          ((LinkedList)localObject2).add(localdmf);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, enO());
          com.tencent.mm.model.ba.aiU().a((n)localObject1, 0);
        }
        this.Bof = "";
        this.roomId = 0;
        this.uLt = 0L;
        this.Bog = 0;
        this.Boh = 0;
        this.Boi = 0;
        this.Boj.clear();
        enS();
        this.Boq.aMd();
        b.enC().Bnl.enI();
        removeListener();
        AppMethodBeat.o(29502);
        return;
        localObject1 = "";
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(29521);
    if (!paramString1.equals(this.Bof))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.Boq;
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
    ad.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramn;
    if ((paramString.enY() == null) || (!paramString.enY().equals(this.Bof)))
    {
      ad.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.enY(), this.Bof });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 332)
      {
        b.enG().SM(2);
        if (paramInt1 == 4) {
          b.enG().BnU = paramInt2;
        }
        this.Boq.s("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        enR();
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
        paramString = b.enG();
        paramString.BnD += 1;
        paramString.BnY = 0L;
        enT();
        ad.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.Boq.qh(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.Boq.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 336)
      {
        this.Boe = false;
        this.Boq.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        enR();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 335)
      {
        this.Boq.j(paramInt1, paramInt2, "TalkNoop failed!!");
        enR();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramn.getType() == 332)
    {
      b.enG().SM(1);
      paramn = (com.tencent.mm.plugin.talkroom.b.a)paramn;
      this.roomId = paramn.roomId;
      this.uLt = paramn.uLt;
      this.Bog = paramn.Bog;
      this.Boh = paramn.Boh;
      this.Boj = paramn.Boj;
      localObject = b.enG();
      paramInt1 = this.roomId;
      long l = this.uLt;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).uLt = l;
      paramn = paramn.BoB;
      b.enE().a(this.Bof, paramn, null, null, paramString.enZ());
      SN(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramn;
      if (paramString.actionType == 1)
      {
        paramn = b.enG();
        if (paramn.BnY != 0L)
        {
          paramn.BnB = ((bt.aO(paramn.BnY) + paramn.BnB * paramn.BnX) / (paramn.BnX + 1));
          paramn.BnX += 1;
          paramn.BnC += 1;
          paramn.BnY = 0L;
        }
        ad.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.Bog < this.Bog)
        {
          ad.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.Bog), Integer.valueOf(this.Bog) });
          enT();
          this.Boq.qh(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.Bog = paramString.Bog;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.Bok.SetCurrentMicId(this.Bog);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.Boq;
          paramn = new i.6(paramString);
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label861;
          }
        }
        if (this.state != 3)
        {
          ad.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
          AppMethodBeat.o(29507);
          return;
        }
        paramn.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            ad.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.Bop == null)
          {
            this.Bop = new av(new av.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.enO());
                com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.Bop.az(5000L, 5000L);
          }
          AppMethodBeat.o(29507);
          return;
          label861:
          paramString.handler.post(paramn);
        }
      }
      ad.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramn;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).BoB;
      b.enE().a(this.Bof, localLinkedList, null, null, paramString.enZ());
      SO(((com.tencent.mm.plugin.talkroom.b.c)localObject).Bog);
      this.Boe = false;
      this.Boq.GI(enP());
    }
    if ((paramn.getType() == 335) && (this.state == 0)) {
      this.Boq.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    ad.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.Bof });
    if ((bt.isNullOrNil(this.Bof)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.enG().enM();
    if (paramBoolean) {
      if (!enV())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      enW();
      enT();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.Bok != null) {
          this.Bok.Close();
        }
        if (this.roomId != 0) {
          enX();
        }
        if (!paramBoolean) {
          this.Boq.aMg();
        }
        AppMethodBeat.o(29514);
        return;
        localRemoteException1 = localRemoteException1;
        ad.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
        ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */