package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ai.f, com.tencent.mm.bg.a, com.tencent.mm.bg.c, com.tencent.mm.model.af
{
  public static final int[] tde = { 80, 8080, 16285 };
  public static final byte[][] tdf;
  private final ServiceConnection kDI;
  private int nMZ;
  private long nNa;
  private int state;
  private int tcP;
  private int tcQ;
  private boolean tcR;
  public String tcS;
  private int tcT;
  private int tcU;
  private int tcV;
  private LinkedList<cjm> tcW;
  private com.tencent.mm.plugin.talkroom.component.a tcX;
  private com.tencent.mm.plugin.talkroom.component.b tcY;
  private com.tencent.mm.plugin.talkroom.component.e tcZ;
  private com.tencent.mm.plugin.talkroom.component.d tda;
  private com.tencent.mm.sdk.platformtools.af tdb;
  private ap tdc;
  private i tdd;
  public boolean tdg;
  
  static
  {
    byte[] arrayOfByte = { 112, 64, -19, -29 };
    tdf = new byte[][] { { 101, -30, 76, 27 }, arrayOfByte, { 120, -52, -55, -58 } };
  }
  
  public g()
  {
    AppMethodBeat.i(25811);
    this.tcP = 0;
    this.tcQ = 0;
    this.state = 0;
    this.tcR = false;
    this.tcW = new LinkedList();
    this.tdd = new i();
    this.kDI = new g.1(this);
    this.tdg = false;
    TalkRoomReceiver.init();
    AppMethodBeat.o(25811);
  }
  
  private void Gq(int paramInt)
  {
    AppMethodBeat.i(25828);
    if (this.tcX != null) {
      try
      {
        cHK();
        AppMethodBeat.o(25828);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        AppMethodBeat.o(25828);
        return;
      }
    }
    if (paramInt == 0)
    {
      this.tdd.t("bind talkroomService timeout", 3, -1);
      AppMethodBeat.o(25828);
      return;
    }
    new com.tencent.mm.sdk.platformtools.ak().postDelayed(new g.4(this, paramInt), 50L);
    AppMethodBeat.o(25828);
  }
  
  private void Gr(int paramInt)
  {
    AppMethodBeat.i(25831);
    if (paramInt > this.tcT)
    {
      this.tcT = paramInt;
      if (this.state >= 3) {
        this.tdd.mh(311);
      }
      cHJ();
    }
    AppMethodBeat.o(25831);
  }
  
  private static String Gs(int paramInt)
  {
    AppMethodBeat.i(25834);
    try
    {
      String str = InetAddress.getByAddress(new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) }).getHostAddress();
      AppMethodBeat.o(25834);
      return str;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
      AppMethodBeat.o(25834);
    }
    return null;
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    AppMethodBeat.i(25838);
    if (this.tcX != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.tcX.e(arrayOfInt, paramString);
        int i = arrayOfInt[0];
        AppMethodBeat.o(25838);
        return i;
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          ab.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(25838);
    return -99;
  }
  
  private boolean cHG()
  {
    AppMethodBeat.i(25817);
    if (cHE() == 1) {
      b(b.cHr().tbZ);
    }
    while (this.tcQ > 0)
    {
      ab.i("MicroMsg.TalkRoomServer", "addListener has init before");
      AppMethodBeat.o(25817);
      return true;
      a(b.cHr().tbZ);
    }
    aw.Rc().a(332, this);
    aw.Rc().a(334, this);
    aw.Rc().a(336, this);
    aw.Rc().a(335, this);
    b.cHt().a(this);
    aw.BY().a(this);
    this.tcQ = 1;
    if (this.tcX != null) {}
    try
    {
      this.tcX.Close();
      this.tcX.uninitLive();
      Intent localIntent = new Intent(ah.getContext(), TalkRoomService.class);
      ah.getContext().bindService(localIntent, this.kDI, 1);
      this.tcY = new g.2(this);
      AppMethodBeat.o(25817);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void cHI()
  {
    AppMethodBeat.i(25821);
    if (this.tcZ != null) {}
    try
    {
      this.tcZ.release();
      this.tcZ = null;
      if (this.tda == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.tda.release();
        this.tda = null;
        if (this.tdb != null)
        {
          this.tdb.stopTimer();
          this.tdb = null;
        }
        if (this.tdc != null)
        {
          this.tdc.stopTimer();
          this.tdc = null;
        }
        AppMethodBeat.o(25821);
        return;
        localRemoteException1 = localRemoteException1;
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void cHJ()
  {
    AppMethodBeat.i(25826);
    try
    {
      b.cHv().cHD();
      if (this.tda != null) {
        this.tda.cHp();
      }
      if (this.tcZ != null) {
        this.tcZ.ctY();
      }
      this.state = 2;
      AppMethodBeat.o(25826);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(25826);
    }
  }
  
  private void cHK()
  {
    AppMethodBeat.i(25829);
    this.state = 1;
    this.tcR = false;
    if (!cHL())
    {
      AppMethodBeat.o(25829);
      return;
    }
    cHI();
    cHN();
    cHM();
    if (this.tdb != null)
    {
      ab.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
      AppMethodBeat.o(25829);
      return;
    }
    this.tdb = new com.tencent.mm.sdk.platformtools.af(new g.5(this));
    this.tdb.dsL();
    AppMethodBeat.o(25829);
  }
  
  private boolean cHL()
  {
    AppMethodBeat.i(25830);
    int i = -99999;
    try
    {
      int j = this.tcX.cHn();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      AppMethodBeat.o(25830);
    }
    ab.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.tcX = null;
      ab.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.tdd.t("enterTalkRoom protocalInit failed", 3, -1);
      AppMethodBeat.o(25830);
      return false;
    }
    return true;
  }
  
  private void cHM()
  {
    AppMethodBeat.i(25833);
    if (this.tcX == null)
    {
      ab.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      AppMethodBeat.o(25833);
      return;
    }
    this.tcZ = this.tcX.a(new g.6(this));
    this.tcZ.start();
    this.tda = this.tcX.cHo();
    this.tda.start();
    AppMethodBeat.o(25833);
  }
  
  private void cHN()
  {
    AppMethodBeat.i(25835);
    if (this.tcW.size() == 0)
    {
      ab.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.tdd.i(3, -1, "engine.talk relay addr list empty");
      AppMethodBeat.o(25835);
      return;
    }
    int[] arrayOfInt1 = new int[this.tcW.size()];
    int[] arrayOfInt2 = new int[this.tcW.size()];
    ab.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.tcW.size()) });
    int i = 0;
    while (i < this.tcW.size())
    {
      arrayOfInt1[i] = ((cjm)this.tcW.get(i)).xTC;
      arrayOfInt2[i] = ((cjm)this.tcW.get(i)).xCi;
      ab.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[] { Gs(((cjm)this.tcW.get(i)).xTC), Integer.valueOf(((cjm)this.tcW.get(i)).xCi) });
      i += 1;
    }
    ab.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.tcU), Integer.valueOf(this.nMZ), Long.valueOf(this.nNa) });
    try
    {
      com.tencent.mm.plugin.talkroom.component.a locala = this.tcX;
      com.tencent.mm.plugin.talkroom.component.b localb = this.tcY;
      aw.aaz();
      i = locala.a(localb, com.tencent.mm.model.c.getUin(), this.tcU, this.nMZ, this.nNa, arrayOfInt1, arrayOfInt2, 0);
      if ((i < 0) && (i != -3))
      {
        ab.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.tdd.i(3, i, "engine.Open error");
      }
      AppMethodBeat.o(25835);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = -99999;
      }
    }
  }
  
  private void my(boolean paramBoolean)
  {
    AppMethodBeat.i(25822);
    if (bo.isNullOrNil(this.tcS))
    {
      AppMethodBeat.o(25822);
      return;
    }
    aw.aaz();
    com.tencent.mm.storage.ak localak = com.tencent.mm.model.c.YF().arH(this.tcS);
    if (localak == null)
    {
      AppMethodBeat.o(25822);
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localak.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, i, localak.field_conversationTime));
      aw.aaz();
      com.tencent.mm.model.c.YF().a(localak, this.tcS);
      AppMethodBeat.o(25822);
      return;
    }
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(25818);
    this.tcQ = 0;
    aw.Rc().b(332, this);
    aw.Rc().b(334, this);
    aw.Rc().b(336, this);
    aw.Rc().b(335, this);
    b.cHt().b(this);
    aw.BY().b(this);
    b(b.cHr().tbZ);
    int j = -99999;
    int i = j;
    if (this.tcX != null) {}
    try
    {
      i = this.tcX.uninitLive();
      ah.getContext().unbindService(this.kDI);
      Intent localIntent = new Intent(ah.getContext(), TalkRoomService.class);
      ah.getContext().stopService(localIntent);
      this.tcX = null;
      if (i < 0) {
        ab.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(25818);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        i = j;
      }
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.bg.d paramd)
  {
    // Byte code:
    //   0: sipush 25815
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 100	com/tencent/mm/plugin/talkroom/model/g:tdd	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   10: astore_2
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_2
    //   14: getfield 523	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 529 2 0
    //   23: ifeq +23 -> 46
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 100	com/tencent/mm/plugin/talkroom/model/g:tdd	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   32: aload_0
    //   33: invokevirtual 532	com/tencent/mm/plugin/talkroom/model/g:cHF	()Ljava/lang/String;
    //   36: invokevirtual 536	com/tencent/mm/plugin/talkroom/model/i:uM	(Ljava/lang/String;)V
    //   39: sipush 25815
    //   42: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_2
    //   47: getfield 523	com/tencent/mm/plugin/talkroom/model/i:callbacks	Ljava/util/List;
    //   50: aload_1
    //   51: invokeinterface 539 2 0
    //   56: pop
    //   57: aload_1
    //   58: monitorexit
    //   59: goto -31 -> 28
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: sipush 25815
    //   68: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	g
    //   0	73	1	paramd	com.tencent.mm.bg.d
    //   10	37	2	locali	i
    //   62	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	28	62	finally
    //   46	59	62	finally
    //   63	65	62	finally
  }
  
  public final void aah()
  {
    AppMethodBeat.i(25840);
    ab.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bo.isNullOrNil(this.tcS)) {
      ab.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.tdg = false;
      locali = this.tdd;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      AppMethodBeat.o(25840);
      return;
      cHJ();
    }
    locali.handler.post(local3);
    AppMethodBeat.o(25840);
  }
  
  public final void aai()
  {
    AppMethodBeat.i(25841);
    ab.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bo.isNullOrNil(this.tcS)) {
        ab.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.tdg = true;
        i locali = this.tdd;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        AppMethodBeat.o(25841);
        return;
        if (this.tda != null) {
          this.tda.cHp();
        }
        if (this.tcZ != null) {
          this.tcZ.crn();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
      AppMethodBeat.o(25841);
    }
  }
  
  public final void ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(25819);
    ab.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.tcP = paramInt;
    cHG();
    if (paramString.equals(this.tcS))
    {
      ab.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.tdd.akV();
      }
      AppMethodBeat.o(25819);
      return;
    }
    ab.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.tcS = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.tcS, cHE());
    aw.Rc().a((m)localObject, 0);
    b.cHr().tcb = new f();
    b.cHv().tcJ = bo.yB();
    b.cHv().tcG = paramString;
    if (cHE() == 0) {
      b.cHr().tbZ.odR = true;
    }
    localObject = this.tdd;
    paramString = new i.11((i)localObject, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(25819);
      return;
    }
    ((i)localObject).handler.post(paramString);
    AppMethodBeat.o(25819);
  }
  
  public final void akP()
  {
    AppMethodBeat.i(25827);
    ab.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4)
    {
      AppMethodBeat.o(25827);
      return;
    }
    f localf = b.cHv();
    localf.tcN = true;
    localf.tcM = bo.yB();
    try
    {
      this.tda.akP();
      AppMethodBeat.o(25827);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(25827);
    }
  }
  
  public final short akQ()
  {
    AppMethodBeat.i(25836);
    if (this.tda == null)
    {
      AppMethodBeat.o(25836);
      return 0;
    }
    try
    {
      int i = this.tda.cHq();
      short s = (short)i;
      AppMethodBeat.o(25836);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(25836);
    }
    return 0;
  }
  
  public final short akR()
  {
    AppMethodBeat.i(25837);
    if (this.tcZ == null)
    {
      AppMethodBeat.o(25837);
      return 0;
    }
    try
    {
      int i = this.tcZ.cHq();
      short s = (short)i;
      AppMethodBeat.o(25837);
      return s;
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(25837);
    }
    return 0;
  }
  
  public final boolean akS()
  {
    AppMethodBeat.i(25823);
    ab.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      ab.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.tdd.i(3, -1, "seizeMic in outside room state");
      }
      AppMethodBeat.o(25823);
      return false;
    }
    if (this.tcZ != null) {}
    try
    {
      this.tcZ.crn();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.nMZ, this.nNa, 1, this.tcS, cHE());
      aw.Rc().a(locald, 0);
      b.cHv().tcL = bo.yB();
      b.cHv().tcO = true;
      AppMethodBeat.o(25823);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void akT()
  {
    AppMethodBeat.i(25824);
    ab.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.cHv();
    if ((((f)localObject).tcO) && (!((f)localObject).tcN)) {
      ((f)localObject).tcI += 1;
    }
    ((f)localObject).tcN = false;
    ((f)localObject).tcO = false;
    if (this.state < 3)
    {
      ab.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      AppMethodBeat.o(25824);
      return;
    }
    if (this.tdc != null)
    {
      this.tdc.stopTimer();
      this.tdc = null;
    }
    cHJ();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.nMZ, this.nNa, 2, this.tcS, cHE());
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(25824);
  }
  
  public final boolean akU()
  {
    return this.tdg;
  }
  
  public final void b(com.tencent.mm.bg.d paramd)
  {
    AppMethodBeat.i(25816);
    i locali = this.tdd;
    try
    {
      locali.callbacks.remove(paramd);
      return;
    }
    finally
    {
      AppMethodBeat.o(25816);
    }
  }
  
  public final List bLy()
  {
    AppMethodBeat.i(25813);
    LinkedList localLinkedList = b.cHt().uK(this.tcS);
    AppMethodBeat.o(25813);
    return localLinkedList;
  }
  
  public final int cHE()
  {
    AppMethodBeat.i(25812);
    if ((this.tcP == 1) || ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(this.tcS))))
    {
      AppMethodBeat.o(25812);
      return 1;
    }
    AppMethodBeat.o(25812);
    return 0;
  }
  
  public final String cHF()
  {
    AppMethodBeat.i(25814);
    Object localObject = b.cHt().uK(this.tcS).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cjn localcjn = (cjn)((Iterator)localObject).next();
      if (localcjn.xTD == this.tcV)
      {
        localObject = localcjn.jJA;
        AppMethodBeat.o(25814);
        return localObject;
      }
    }
    AppMethodBeat.o(25814);
    return null;
  }
  
  public final void cHH()
  {
    AppMethodBeat.i(25820);
    ab.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    my(false);
    if (bo.isNullOrNil(this.tcS))
    {
      ab.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
      AppMethodBeat.o(25820);
      return;
    }
    b.cHv().cHB();
    this.state = 0;
    this.tcR = false;
    int i = this.nMZ;
    long l = this.nNa;
    Object localObject1;
    if (this.nMZ != 0) {
      localObject1 = this.tcS;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, cHE());
      aw.Rc().a((m)localObject1, 0);
      if (this.tcX != null) {}
      try
      {
        i = this.tcX.Close();
        if (i < 0) {
          ab.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        Object localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, s.nE(this.tcS)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          ab.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          cjo localcjo = new cjo();
          localcjo.xoo = 10402;
          localcjo.xTE = new bwc().aoF((String)localObject1);
          localObject1 = new cjo();
          ((cjo)localObject1).xoo = 10404;
          ((cjo)localObject1).xTE = new bwc().aoF(b.cHv().toString());
          ((LinkedList)localObject2).add(localcjo);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, cHE());
          aw.Rc().a((m)localObject1, 0);
        }
        this.tcS = "";
        this.nMZ = 0;
        this.nNa = 0L;
        this.tcT = 0;
        this.tcU = 0;
        this.tcV = 0;
        this.tcW.clear();
        cHI();
        this.tdd.akX();
        b.cHr().tbZ.cHx();
        removeListener();
        AppMethodBeat.o(25820);
        return;
        localObject1 = "";
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(25839);
    if (!paramString1.equals(this.tcS))
    {
      AppMethodBeat.o(25839);
      return;
    }
    paramString1 = this.tdd;
    paramString2 = new i.10(paramString1, paramString2, paramString3);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString2.run();
      AppMethodBeat.o(25839);
      return;
    }
    paramString1.handler.post(paramString2);
    AppMethodBeat.o(25839);
  }
  
  public final void mz(boolean paramBoolean)
  {
    AppMethodBeat.i(25832);
    ab.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.tcS });
    if ((bo.isNullOrNil(this.tcS)) || (this.state < 2))
    {
      AppMethodBeat.o(25832);
      return;
    }
    b.cHv().cHC();
    if (paramBoolean) {
      if (!cHL())
      {
        AppMethodBeat.o(25832);
        return;
      }
    }
    try
    {
      cHM();
      cHJ();
      this.state = 1;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        if (this.tcX != null) {
          this.tcX.Close();
        }
        if (this.nMZ != 0) {
          cHN();
        }
        if (!paramBoolean) {
          this.tdd.ala();
        }
        AppMethodBeat.o(25832);
        return;
        localRemoteException1 = localRemoteException1;
        ab.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
        ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25825);
    ab.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramm;
    if ((paramString.cHO() == null) || (!paramString.cHO().equals(this.tcS)))
    {
      ab.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.cHO(), this.tcS });
      AppMethodBeat.o(25825);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramm.getType() == 332)
      {
        b.cHv().Gp(2);
        if (paramInt1 == 4) {
          b.cHv().tcH = paramInt2;
        }
        this.tdd.t("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
        cHH();
        AppMethodBeat.o(25825);
        return;
      }
      if (paramm.getType() == 334)
      {
        if (((com.tencent.mm.plugin.talkroom.b.d)paramm).actionType != 1)
        {
          AppMethodBeat.o(25825);
          return;
        }
        paramString = b.cHv();
        paramString.tcq += 1;
        paramString.tcL = 0L;
        cHJ();
        ab.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
        if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
        {
          this.tdd.mh(paramInt2);
          AppMethodBeat.o(25825);
          return;
        }
        this.tdd.i(paramInt1, paramInt2, "TalkMicAction failed!!");
        AppMethodBeat.o(25825);
        return;
      }
      if (paramm.getType() == 336)
      {
        this.tcR = false;
        this.tdd.i(paramInt1, paramInt2, "TalkGetMember failed!!");
        cHH();
        AppMethodBeat.o(25825);
        return;
      }
      if (paramm.getType() == 335)
      {
        this.tdd.i(paramInt1, paramInt2, "TalkNoop failed!!");
        cHH();
        AppMethodBeat.o(25825);
        return;
      }
    }
    Object localObject;
    if (paramm.getType() == 332)
    {
      b.cHv().Gp(1);
      paramm = (com.tencent.mm.plugin.talkroom.b.a)paramm;
      this.nMZ = paramm.nMZ;
      this.nNa = paramm.nNa;
      this.tcT = paramm.tcT;
      this.tcU = paramm.tcU;
      this.tcW = paramm.tcW;
      localObject = b.cHv();
      paramInt1 = this.nMZ;
      long l = this.nNa;
      ((f)localObject).nMZ = paramInt1;
      ((f)localObject).nNa = l;
      paramm = paramm.tdp;
      b.cHt().a(this.tcS, paramm, null, null, paramString.cHP());
      Gq(100);
      AppMethodBeat.o(25825);
      return;
    }
    if (paramm.getType() == 334)
    {
      paramString = (com.tencent.mm.plugin.talkroom.b.d)paramm;
      if (paramString.actionType == 1)
      {
        paramm = b.cHv();
        if (paramm.tcL != 0L)
        {
          paramm.tco = ((bo.av(paramm.tcL) + paramm.tco * paramm.tcK) / (paramm.tcK + 1));
          paramm.tcK += 1;
          paramm.tcp += 1;
          paramm.tcL = 0L;
        }
        ab.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
        if (paramString.tcT < this.tcT)
        {
          ab.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.tcT), Integer.valueOf(this.tcT) });
          cHJ();
          this.tdd.mh(311);
          AppMethodBeat.o(25825);
          return;
        }
        this.tcT = paramString.tcT;
        paramInt1 = -99999;
        try
        {
          paramInt2 = this.tcX.SetCurrentMicId(this.tcT);
          paramInt1 = paramInt2;
        }
        catch (RemoteException paramString)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
          }
          paramString = this.tdd;
          paramm = new i.6(paramString);
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label861;
          }
        }
        if (this.state != 3)
        {
          ab.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
          AppMethodBeat.o(25825);
          return;
        }
        paramm.run();
        for (;;)
        {
          this.state = 4;
          if (paramInt1 < 0) {
            ab.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
          }
          if (this.tdc == null)
          {
            this.tdc = new ap(new ap.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(25807);
                int i = g.e(g.this);
                long l = g.f(g.this);
                Object localObject = g.g(g.this);
                g localg = g.this;
                g.g(g.this);
                localObject = new com.tencent.mm.plugin.talkroom.b.d(i, l, 1, (String)localObject, localg.cHE());
                aw.Rc().a((m)localObject, 0);
                AppMethodBeat.o(25807);
                return true;
              }
            }, true);
            this.tdc.ag(5000L, 5000L);
          }
          AppMethodBeat.o(25825);
          return;
          label861:
          paramString.handler.post(paramm);
        }
      }
      ab.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
      AppMethodBeat.o(25825);
      return;
    }
    if (paramm.getType() == 336)
    {
      localObject = (com.tencent.mm.plugin.talkroom.b.c)paramm;
      LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).tdp;
      b.cHt().a(this.tcS, localLinkedList, null, null, paramString.cHP());
      Gr(((com.tencent.mm.plugin.talkroom.b.c)localObject).tcT);
      this.tcR = false;
      this.tdd.uM(cHF());
    }
    if ((paramm.getType() == 335) && (this.state == 0)) {
      this.tdd.i(3, -1, "talknoop success but in outside room state");
    }
    AppMethodBeat.o(25825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */