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
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.plugin.talkroom.component.c.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.al.g, com.tencent.mm.bi.a, com.tencent.mm.bi.c, ai
{
  public static final int[] yJA = { 80, 8080, 16285 };
  public static final byte[][] yJB = { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, { 120, -52, -55, -58 } };
  private final ServiceConnection nKI;
  private int roomId;
  private long sAY;
  private int state;
  public boolean yJC;
  private int yJl;
  private int yJm;
  private boolean yJn;
  public String yJo;
  private int yJp;
  private int yJq;
  private int yJr;
  private LinkedList<dbe> yJs;
  private com.tencent.mm.plugin.talkroom.component.a yJt;
  private com.tencent.mm.plugin.talkroom.component.b yJu;
  private com.tencent.mm.plugin.talkroom.component.e yJv;
  private com.tencent.mm.plugin.talkroom.component.d yJw;
  private com.tencent.mm.sdk.platformtools.ah yJx;
  private av yJy;
  private i yJz;
  
  public g()
  {
    AppMethodBeat.i(29493);
    this.yJl = 0;
    this.yJm = 0;
    this.state = 0;
    this.yJn = false;
    this.yJs = new LinkedList();
    this.yJz = new i();
    this.nKI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(29483);
        ad.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (paramAnonymousIBinder == null)
        {
          g.a(g.this).r("enterTalkRoom bindServie or protocalInit failed", 3, -1);
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
              g.this.rd(true);
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
    this.yJC = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(29493);
  }
  
  private void OX(final int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.yJt != null) {
      try
      {
        dNd();
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
      this.yJz.r("bind talkroomService timeout", 3, -1);
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
  
  private void OY(int paramInt)
  {
    AppMethodBeat.i(29513);
    if (paramInt > this.yJp)
    {
      this.yJp = paramInt;
      if (this.state >= 3) {
        this.yJz.oQ(311);
      }
      dNc();
    }
    AppMethodBeat.o(29513);
  }
  
  private static String OZ(int paramInt)
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
    if (this.yJt != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.yJt.d(arrayOfInt, paramString);
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
  
  private boolean dMZ()
  {
    AppMethodBeat.i(29499);
    if (dMX() == 1) {
      b(b.dML().yIu);
    }
    while (this.yJm > 0)
    {
      ad.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(29499);
      return true;
      a(b.dML().yIu);
    }
    az.aeS().a(332, this);
    az.aeS().a(334, this);
    az.aeS().a(336, this);
    az.aeS().a(335, this);
    b.dMN().a(this);
    az.Lv().a(this);
    this.yJm = 1;
    if (this.yJt != null) {}
    try
    {
      this.yJt.Close();
      this.yJt.uninitLive();
      Intent localIntent = new Intent(aj.getContext(), TalkRoomService.class);
      aj.getContext().bindService(localIntent, this.nKI, 1);
      this.yJu = new b.a()
      {
        public final void keep_OnError(int paramAnonymousInt)
        {
          AppMethodBeat.i(29488);
          ad.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          b.dMP().dMU();
          b.dMP().yII = 1;
          g.a(g.this).r("component OnError ".concat(String.valueOf(paramAnonymousInt)), 99, paramAnonymousInt);
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(29486);
              g.this.dNa();
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
          b.dMP().dMU();
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
          g.a(g.this).aCb();
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
  
  private void dNb()
  {
    AppMethodBeat.i(29503);
    if (this.yJv != null) {}
    try
    {
      this.yJv.release();
      this.yJv = null;
      if (this.yJw == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.yJw.release();
        this.yJw = null;
        if (this.yJx != null)
        {
          this.yJx.stopTimer();
          this.yJx = null;
        }
        if (this.yJy != null)
        {
          this.yJy.stopTimer();
          this.yJy = null;
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
  
  private void dNc()
  {
    AppMethodBeat.i(29508);
    try
    {
      b.dMP().dMW();
      if (this.yJw != null) {
        this.yJw.dMJ();
      }
      if (this.yJv != null) {
        this.yJv.dzF();
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
  
  private void dNd()
  {
    AppMethodBeat.i(29511);
    this.state = 1;
    this.yJn = false;
    if (!dNe())
    {
      AppMethodBeat.o(29511);
      return;
    }
    dNb();
    dNg();
    dNf();
    if (this.yJx != null)
    {
      ad.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(29511);
      return;
    }
    this.yJx = new com.tencent.mm.sdk.platformtools.ah(new ah.a()
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
        localObject = new com.tencent.mm.plugin.talkroom.b.e((String)localObject, i, l, localg.dMX());
        az.aeS().a((n)localObject, 0);
        AppMethodBeat.o(29491);
        return true;
      }
    });
    this.yJx.eFz();
    AppMethodBeat.o(29511);
  }
  
  private boolean dNe()
  {
    AppMethodBeat.i(29512);
    int i = -99999;
    try
    {
      int j = this.yJt.dMH();
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
      this.yJt = null;
      ad.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.yJz.r("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(29512);
      return false;
    }
    return true;
  }
  
  private void dNf()
  {
    AppMethodBeat.i(29515);
    if (this.yJt == null)
    {
      ad.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(29515);
      return;
    }
    this.yJv = this.yJt.a(new c.a()
    {
      public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(29492);
        if (paramAnonymousBoolean)
        {
          g.b(g.this, 0);
          g.a(g.this).zy("");
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
        String str = g.this.dMY();
        if ((!g.j(g.this)) && (str == null))
        {
          g.k(g.this);
          paramAnonymousInt1 = g.e(g.this);
          long l = g.f(g.this);
          Object localObject = g.g(g.this);
          g localg = g.this;
          g.g(g.this);
          localObject = new com.tencent.mm.plugin.talkroom.b.c(paramAnonymousInt1, l, (String)localObject, localg.dMX());
          az.aeS().a((n)localObject, 0);
          localObject = b.dMP();
          ((f)localObject).yIQ += 1;
          localObject = b.dMP();
          ((f)localObject).yIR += 1;
        }
        g.a(g.this).zy(str);
        bd.az(aj.getContext(), 2131764376);
        AppMethodBeat.o(29492);
      }
    });
    this.yJv.start();
    this.yJw = this.yJt.dMI();
    this.yJw.start();
    AppMethodBeat.o(29515);
  }
  
  private void dNg()
  {
    AppMethodBeat.i(29517);
    if (this.yJs.size() == 0)
    {
      ad.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.yJz.j(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(29517);
      return;
    }
    int[] arrayOfInt1 = new int[this.yJs.size()];
    int[] arrayOfInt2 = new int[this.yJs.size()];
    String[] arrayOfString = new String[this.yJs.size()];
    ad.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.yJs.size()) });
    int i = 0;
    while (i < this.yJs.size())
    {
      arrayOfInt1[i] = ((dbe)this.yJs.get(i)).EsP;
      arrayOfInt2[i] = ((dbe)this.yJs.get(i)).DYT;
      arrayOfString[i] = ((dbe)this.yJs.get(i)).EsQ;
      ad.i("MicroMsg.TalkRoomServer", "add talk relay addr [%s][%s][%d]", new Object[] { OZ(((dbe)this.yJs.get(i)).EsP), ((dbe)this.yJs.get(i)).EsQ, Integer.valueOf(((dbe)this.yJs.get(i)).DYT) });
      i += 1;
    }
    ad.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.yJq), Integer.valueOf(this.roomId), Long.valueOf(this.sAY) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.yJt;
      com.tencent.mm.plugin.talkroom.component.b localb = this.yJu;
      az.arV();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.yJq, this.roomId, this.sAY, arrayOfInt1, arrayOfInt2, 0, arrayOfString);
      if ((i < 0) && (i != -3))
      {
        ad.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.yJz.j(3, i, "engine.Open error");
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
  
  private void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(29504);
    if (bt.isNullOrNil(this.yJo))
    {
      AppMethodBeat.o(29504);
      return;
    }
    az.arV();
    am localam = com.tencent.mm.model.c.apR().aIn(this.yJo);
    if (localam == null)
    {
      AppMethodBeat.o(29504);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localam.kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, i, localam.field_conversationTime));
      az.arV();
      com.tencent.mm.model.c.apR().a(localam, this.yJo);
      AppMethodBeat.o(29504);
      return;
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(29500);
    this.yJm = 0;
    az.aeS().b(332, this);
    az.aeS().b(334, this);
    az.aeS().b(336, this);
    az.aeS().b(335, this);
    b.dMN().b(this);
    az.Lv().b(this);
    b(b.dML().yIu);
    int j = -99999;
    int i = j;
    if (this.yJt != null) {}
    try
    {
      i = this.yJt.uninitLive();
      aj.getContext().unbindService(this.nKI);
      Intent localIntent = new Intent(aj.getContext(), TalkRoomService.class);
      aj.getContext().stopService(localIntent);
      this.yJt = null;
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
  
  /* Error */
  public final void a(com.tencent.mm.bi.d paramd)
  {
    // Byte code:
    //   0: sipush 29497
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/talkroom/model/g:yJz	Lcom/tencent/mm/plugin/talkroom/model/i;
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
    //   29: getfield 116	com/tencent/mm/plugin/talkroom/model/g:yJz	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 543	com/tencent/mm/plugin/talkroom/model/g:dMY	()Ljava/lang/String;
    //   36: invokevirtual 547	com/tencent/mm/plugin/talkroom/model/i:zy	(Ljava/lang/String;)V
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
  
  public final void aBV()
  {
    AppMethodBeat.i(29509);
    ad.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(29509);
      return;
    }
    f localf = b.dMP();
    localf.yJj = true;
    localf.yJi = bt.GC();
    try
    {
      this.yJw.aBV();
      AppMethodBeat.o(29509);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(29509);
    }
  }
  
  public final short aBW()
  {
    AppMethodBeat.i(29518);
    if (this.yJw == null)
    {
      AppMethodBeat.o(29518);
      return 0;
    }
    try
    {
      int i = this.yJw.dMK();
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
  
  public final short aBX()
  {
    AppMethodBeat.i(29519);
    if (this.yJv == null)
    {
      AppMethodBeat.o(29519);
      return 0;
    }
    try
    {
      int i = this.yJv.dMK();
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
  
  public final boolean aBY()
  {
    AppMethodBeat.i(29505);
    ad.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      ad.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.yJz.j(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(29505);
      return false;
    }
    if (this.yJv != null) {}
    try
    {
      this.yJv.ckd();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.sAY, 1, this.yJo, dMX());
      az.aeS().a(locald, 0);
      b.dMP().yJh = bt.GC();
      b.dMP().yJk = true;
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
  
  public final void aBZ()
  {
    AppMethodBeat.i(29506);
    ad.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.dMP();
    if ((((f)localObject).yJk) && (!((f)localObject).yJj)) {
      ((f)localObject).yJe += 1;
    }
    ((f)localObject).yJj = false;
    ((f)localObject).yJk = false;
    if (this.state < 3)
    {
      ad.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(29506);
      return;
    }
    if (this.yJy != null)
    {
      this.yJy.stopTimer();
      this.yJy = null;
    }
    dNc();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.roomId, this.sAY, 2, this.yJo, dMX());
    az.aeS().a((n)localObject, 0);
    AppMethodBeat.o(29506);
  }
  
  public final boolean aCa()
  {
    return this.yJC;
  }
  
  public final void al(String paramString, int paramInt)
  {
    AppMethodBeat.i(29501);
    ad.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.yJl = paramInt;
    dMZ();
    if (paramString.equals(this.yJo))
    {
      ad.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.yJz.aCb();
      }
      AppMethodBeat.o(29501);
      return;
    }
    ad.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.yJo = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.yJo, dMX());
    az.aeS().a((n)localObject, 0);
    b.dML().yIw = new f();
    b.dMP().yJf = bt.GC();
    b.dMP().yJc = paramString;
    if (dMX() == 0) {
      b.dML().yIu.sSE = true;
    }
    localObject = this.yJz;
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
  
  public final void arC()
  {
    AppMethodBeat.i(29522);
    ad.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bt.isNullOrNil(this.yJo)) {
      ad.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.yJC = false;
      locali = this.yJz;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(29522);
      return;
      dNc();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(29522);
  }
  
  public final void arD()
  {
    AppMethodBeat.i(29523);
    ad.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bt.isNullOrNil(this.yJo)) {
        ad.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.yJC = true;
        i locali = this.yJz;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(29523);
        return;
        if (this.yJw != null) {
          this.yJw.dMJ();
        }
        if (this.yJv != null) {
          this.yJv.ckd();
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
  
  public final void b(com.tencent.mm.bi.d paramd)
  {
    AppMethodBeat.i(29498);
    i locali = this.yJz;
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
  
  public final List cJx()
  {
    AppMethodBeat.i(29495);
    LinkedList localLinkedList = b.dMN().asu(this.yJo);
    AppMethodBeat.o(29495);
    return localLinkedList;
  }
  
  public final int dMX()
  {
    AppMethodBeat.i(29494);
    if ((this.yJl == 1) || ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(this.yJo))))
    {
      AppMethodBeat.o(29494);
      return 1;
    }
    AppMethodBeat.o(29494);
    return 0;
  }
  
  public final String dMY()
  {
    AppMethodBeat.i(29496);
    Object localObject = b.dMN().asu(this.yJo).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dbf localdbf = (dbf)((Iterator)localObject).next();
      if (localdbf.EsR == this.yJr)
      {
        localObject = localdbf.mAQ;
        AppMethodBeat.o(29496);
        return localObject;
      }
    }
    AppMethodBeat.o(29496);
    return null;
  }
  
  public final void dNa()
  {
    AppMethodBeat.i(29502);
    ad.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    rc(false);
    if (bt.isNullOrNil(this.yJo))
    {
      ad.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(29502);
      return;
    }
    b.dMP().exitRoom();
    this.state = 0;
    this.yJn = false;
    int i = this.roomId;
    long l = this.sAY;
    Object localObject1;
    if (this.roomId != 0) {
      localObject1 = this.yJo;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, dMX());
      az.aeS().a((n)localObject1, 0);
      if (this.yJt != null) {}
      try
      {
        i = this.yJt.Close();
        if (i < 0) {
          ad.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, v.sh(this.yJo)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          ad.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          dbg localdbg = new dbg();
          localdbg.DIc = 10402;
          localdbg.EsS = new cmf().aEE((String)localObject1);
          localObject1 = new dbg();
          ((dbg)localObject1).DIc = 10404;
          ((dbg)localObject1).EsS = new cmf().aEE(b.dMP().toString());
          ((LinkedList)localObject2).add(localdbg);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, dMX());
          az.aeS().a((n)localObject1, 0);
        }
        this.yJo = "";
        this.roomId = 0;
        this.sAY = 0L;
        this.yJp = 0;
        this.yJq = 0;
        this.yJr = 0;
        this.yJs.clear();
        dNb();
        this.yJz.aCd();
        b.dML().yIu.dMR();
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
    if (!paramString1.equals(this.yJo))
    {
      AppMethodBeat.o(29521);
      return;
    }
    paramString1 = this.yJz;
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
    if ((paramString.dNh() == null) || (!paramString.dNh().equals(this.yJo)))
    {
      ad.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.dNh(), this.yJo });
      AppMethodBeat.o(29507);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 332)
      {
        b.dMP().OW(2);
        if (paramInt1 == 4) {
          b.dMP().yJd = paramInt2;
        }
        this.yJz.r("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        dNa();
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
        paramString = b.dMP();
        paramString.yIM += 1;
        paramString.yJh = 0L;
        dNc();
        ad.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.yJz.oQ(paramInt2);
          AppMethodBeat.o(29507);
          return;
        }
        this.yJz.j(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 336)
      {
        this.yJn = false;
        this.yJz.j(paramInt1, paramInt2, "TalkGetMember failed!!");
        dNa();
        AppMethodBeat.o(29507);
        return;
      }
      if (paramn.getType() == 335)
      {
        this.yJz.j(paramInt1, paramInt2, "TalkNoop failed!!");
        dNa();
        AppMethodBeat.o(29507);
        return;
      }
    }
    Object localObject;
    if (paramn.getType() == 332)
    {
      b.dMP().OW(1);
      paramn = (com.tencent.mm.plugin.talkroom.b.a)paramn;
      this.roomId = paramn.roomId;
      this.sAY = paramn.sAY;
      this.yJp = paramn.yJp;
      this.yJq = paramn.yJq;
      this.yJs = paramn.yJs;
      localObject = b.dMP();
      paramInt1 = this.roomId;
      long l = this.sAY;
      ((f)localObject).roomId = paramInt1;
      ((f)localObject).sAY = l;
      paramn = paramn.yJK;
      b.dMN().a(this.yJo, paramn, null, null, paramString.dNi());
      OX(100);
      AppMethodBeat.o(29507);
      return;
    }
    if (paramn.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramn;
      if (paramString.actionType == 1)
      {
        paramn = b.dMP();
        if (paramn.yJh != 0L)
        {
          paramn.yIK = ((bt.aS(paramn.yJh) + paramn.yIK * paramn.yJg) / (paramn.yJg + 1));
          paramn.yJg += 1;
          paramn.yIL += 1;
          paramn.yJh = 0L;
        }
        ad.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.yJp < this.yJp)
        {
          ad.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.yJp), Integer.valueOf(this.yJp) });
          dNc();
          this.yJz.oQ(311);
          AppMethodBeat.o(29507);
          return;
        }
        this.yJp = paramString.yJp;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.yJt.SetCurrentMicId(this.yJp);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.yJz;
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
          if (this.yJy == null)
          {
            this.yJy = new av(new av.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(29489);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.dMX());
                az.aeS().a((n)localObject, 0);
                AppMethodBeat.o(29489);
                return true;
              }
            }, true);
            this.yJy.av(5000L, 5000L);
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
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).yJK;
      b.dMN().a(this.yJo, localLinkedList, null, null, paramString.dNi());
      OY(((com.tencent.mm.plugin.talkroom.b.c)localObject).yJp);
      this.yJn = false;
      this.yJz.zy(dMY());
    }
    if ((paramn.getType() == 335) && (this.state == 0)) {
      this.yJz.j(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(29507);
  }
  
  public final void rd(boolean paramBoolean)
  {
    AppMethodBeat.i(29514);
    ad.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.yJo });
    if ((bt.isNullOrNil(this.yJo)) || (this.state < 2))
    {
      AppMethodBeat.o(29514);
      return;
    }
    b.dMP().dMV();
    if (paramBoolean) {
      if (!dNe())
      {
        AppMethodBeat.o(29514);
        return;
      }
    }
    try
    {
      dNf();
      dNc();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.yJt != null) {
          this.yJt.Close();
        }
        if (this.roomId != 0) {
          dNg();
        }
        if (!paramBoolean) {
          this.yJz.aCg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */