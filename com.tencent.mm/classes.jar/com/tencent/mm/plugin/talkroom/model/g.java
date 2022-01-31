package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ac.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  implements com.tencent.mm.ah.f, com.tencent.mm.bf.a, com.tencent.mm.bf.c, com.tencent.mm.model.ae
{
  public static final int[] pBu = { 80, 8080, 16285 };
  public static final byte[][] pBv;
  private final ServiceConnection iAC = new g.1(this);
  private int lpD;
  private long lpE;
  private int pBf = 0;
  private int pBg = 0;
  private boolean pBh = false;
  public String pBi;
  private int pBj;
  private int pBk;
  private int pBl;
  private LinkedList<bxb> pBm = new LinkedList();
  private com.tencent.mm.plugin.talkroom.component.a pBn;
  private com.tencent.mm.plugin.talkroom.component.b pBo;
  private com.tencent.mm.plugin.talkroom.component.e pBp;
  private com.tencent.mm.plugin.talkroom.component.d pBq;
  private ac pBr;
  private am pBs;
  private i pBt = new i();
  public boolean pBw = false;
  private int state = 0;
  
  static
  {
    byte[] arrayOfByte = { 120, -52, -55, -58 };
    pBv = new byte[][] { { 101, -30, 76, 27 }, { 112, 64, -19, -29 }, arrayOfByte };
  }
  
  public g()
  {
    TalkRoomReceiver.init();
  }
  
  private int a(PByteArray paramPByteArray, String paramString)
  {
    if (this.pBn != null)
    {
      int[] arrayOfInt = new int[1];
      try
      {
        paramPByteArray.value = this.pBn.e(arrayOfInt, paramString);
        return arrayOfInt[0];
      }
      catch (RemoteException paramPByteArray)
      {
        for (;;)
        {
          arrayOfInt[0] = -99999;
          y.printErrStackTrace("MicroMsg.TalkRoomServer", paramPByteArray, "", new Object[0]);
        }
      }
    }
    return -99;
  }
  
  private boolean bME()
  {
    if (bMC() == 1) {
      b(b.bMt().pAn);
    }
    while (this.pBg > 0)
    {
      y.i("MicroMsg.TalkRoomServer", "addListener has init before");
      return true;
      a(b.bMt().pAn);
    }
    au.Dk().a(332, this);
    au.Dk().a(334, this);
    au.Dk().a(336, this);
    au.Dk().a(335, this);
    b.bMv().a(this);
    au.tu().a(this);
    this.pBg = 1;
    if (this.pBn != null) {}
    try
    {
      this.pBn.Close();
      this.pBn.uninitLive();
      Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ae.getContext(), TalkRoomService.class);
      com.tencent.mm.sdk.platformtools.ae.getContext().bindService(localIntent, this.iAC, 1);
      this.pBo = new g.2(this);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private void bMF()
  {
    if (this.pBp != null) {}
    try
    {
      this.pBp.release();
      this.pBp = null;
      if (this.pBq == null) {}
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.pBq.release();
        this.pBq = null;
        if (this.pBr != null)
        {
          this.pBr.stopTimer();
          this.pBr = null;
        }
        if (this.pBs != null)
        {
          this.pBs.stopTimer();
          this.pBs = null;
        }
        return;
        localRemoteException1 = localRemoteException1;
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
      }
      catch (RemoteException localRemoteException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
        }
      }
    }
  }
  
  private void bMG()
  {
    for (;;)
    {
      long l;
      try
      {
        f localf = b.bMx();
        if (localf.pBc != 0L)
        {
          l = bk.cp(localf.pBc) / 1000L;
          if (l < 2L)
          {
            localf.pAN += 1;
            localf.pBc = 0L;
          }
        }
        else
        {
          if (this.pBq != null) {
            this.pBq.bMq();
          }
          if (this.pBp != null) {
            this.pBp.bMs();
          }
          this.state = 2;
          return;
        }
        if (l < 6L)
        {
          localf.pAO += 1;
          continue;
        }
        if (l >= 11L) {
          break label142;
        }
      }
      catch (RemoteException localRemoteException)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        return;
      }
      localRemoteException.pAP += 1;
      continue;
      label142:
      if (l < 21L) {
        localRemoteException.pAQ += 1;
      } else if (l < 31L) {
        localRemoteException.pAR += 1;
      } else if (l < 41L) {
        localRemoteException.pAS += 1;
      } else if (l < 51L) {
        localRemoteException.pAT += 1;
      } else if (l < 61L) {
        localRemoteException.pAU += 1;
      } else {
        localRemoteException.pAV += 1;
      }
    }
  }
  
  private boolean bMH()
  {
    int i = -99999;
    try
    {
      int j = this.pBn.bMo();
      i = j;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
    y.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
    if ((i < 0) && (i != -3))
    {
      this.pBn = null;
      y.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[] { Integer.valueOf(i) });
      this.pBt.i("enterTalkRoom protocalInit failed", 3, -1);
      return false;
    }
    return true;
  }
  
  private void bMI()
  {
    if (this.pBn == null)
    {
      y.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
      return;
    }
    this.pBp = this.pBn.a(new g.6(this));
    this.pBp.start();
    this.pBq = this.pBn.bMp();
    this.pBq.start();
  }
  
  private void bMJ()
  {
    if (this.pBm.size() == 0)
    {
      y.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
      this.pBt.e(3, -1, "engine.talk relay addr list empty");
    }
    for (;;)
    {
      return;
      int[] arrayOfInt1 = new int[this.pBm.size()];
      int[] arrayOfInt2 = new int[this.pBm.size()];
      y.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[] { Integer.valueOf(this.pBm.size()) });
      int i = 0;
      while (i < this.pBm.size())
      {
        arrayOfInt1[i] = ((bxb)this.pBm.get(i)).tNg;
        arrayOfInt2[i] = ((bxb)this.pBm.get(i)).tAA;
        y.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[] { zs(((bxb)this.pBm.get(i)).tNg), Integer.valueOf(((bxb)this.pBm.get(i)).tAA) });
        i += 1;
      }
      y.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[] { Integer.valueOf(this.pBk), Integer.valueOf(this.lpD), Long.valueOf(this.lpE) });
      try
      {
        com.tencent.mm.plugin.talkroom.component.a locala = this.pBn;
        com.tencent.mm.plugin.talkroom.component.b localb = this.pBo;
        au.Hx();
        i = locala.a(localb, com.tencent.mm.model.c.CK(), this.pBk, this.lpD, this.lpE, arrayOfInt1, arrayOfInt2, 0);
        if ((i >= 0) || (i == -3)) {
          continue;
        }
        y.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[] { Integer.valueOf(i) });
        this.pBt.e(3, i, "engine.Open error");
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
          i = -99999;
        }
      }
    }
  }
  
  private void jG(boolean paramBoolean)
  {
    if (bk.bl(this.pBi)) {}
    ak localak;
    do
    {
      return;
      au.Hx();
      localak = com.tencent.mm.model.c.FB().abv(this.pBi);
    } while (localak == null);
    if (paramBoolean) {}
    for (int i = 5;; i = 6)
    {
      localak.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, i, localak.field_conversationTime));
      au.Hx();
      com.tencent.mm.model.c.FB().a(localak, this.pBi);
      return;
    }
  }
  
  private void zq(int paramInt)
  {
    if (this.pBn != null)
    {
      try
      {
        this.state = 1;
        this.pBh = false;
        if (!bMH()) {
          return;
        }
        bMF();
        bMJ();
        bMI();
        if (this.pBr != null)
        {
          y.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
          return;
        }
        this.pBr = new ac(new g.5(this));
        ac localac = this.pBr;
        ac.uff = true;
        localac.dFf = 50000L;
        localac.ts = bk.UZ();
        boolean bool = ac.hp(localac.dFf);
        localac.stopTimer();
        ac.ufc.put(Integer.valueOf(localac.ufb), localac);
        if ((ac.dhs == null) || (!bool)) {
          return;
        }
        y.v("MicroMsg.MAlarmHandler", "prepare bumper");
        ac.dhs.prepare();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
        return;
      }
    }
    else
    {
      if (paramInt == 0)
      {
        this.pBt.i("bind talkroomService timeout", 3, -1);
        return;
      }
      new ah().postDelayed(new g.4(this, paramInt), 50L);
    }
  }
  
  private void zr(int paramInt)
  {
    if (paramInt > this.pBj)
    {
      this.pBj = paramInt;
      if (this.state >= 3) {
        this.pBt.jp(311);
      }
      bMG();
    }
  }
  
  private static String zs(int paramInt)
  {
    try
    {
      String str = InetAddress.getByAddress(new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) }).getHostAddress();
      return str;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomServer", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final void Hf()
  {
    y.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
    if (bk.bl(this.pBi)) {
      y.d("MicroMsg.TalkRoomServer", "pause");
    }
    i locali;
    i.3 local3;
    for (;;)
    {
      this.pBw = false;
      locali = this.pBt;
      local3 = new i.3(locali);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      local3.run();
      return;
      bMG();
    }
    locali.handler.post(local3);
  }
  
  public final void Hg()
  {
    y.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
    try
    {
      if (bk.bl(this.pBi)) {
        y.d("MicroMsg.TalkRoomServer", "pause");
      }
      for (;;)
      {
        this.pBw = true;
        i locali = this.pBt;
        local2 = new i.2(locali);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        local2.run();
        return;
        if (this.pBq != null) {
          this.pBq.bMq();
        }
        if (this.pBp != null) {
          this.pBp.bFy();
        }
        this.state = 2;
      }
    }
    catch (RemoteException localRemoteException)
    {
      i.2 local2;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
      localRemoteException.handler.post(local2);
    }
  }
  
  public final void RG()
  {
    y.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[] { Integer.valueOf(this.state) });
    if (this.state != 4) {
      return;
    }
    f localf = b.bMx();
    localf.pBd = true;
    localf.pBc = bk.UZ();
    try
    {
      this.pBq.RG();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
    }
  }
  
  public final short RH()
  {
    if (this.pBq == null) {
      return 0;
    }
    try
    {
      int i = this.pBq.bMr();
      return (short)i;
    }
    catch (RemoteException localRemoteException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
    }
    return 0;
  }
  
  public final short RI()
  {
    if (this.pBp == null) {
      return 0;
    }
    try
    {
      int i = this.pBp.bMr();
      return (short)i;
    }
    catch (RemoteException localRemoteException)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
    }
    return 0;
  }
  
  public final boolean RJ()
  {
    y.i("MicroMsg.TalkRoomServer", "seizeMic");
    if (this.state != 2)
    {
      y.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
      if (this.state == 0) {
        this.pBt.e(3, -1, "seizeMic in outside room state");
      }
      return false;
    }
    if (this.pBp != null) {}
    try
    {
      this.pBp.bFy();
      this.state = 3;
      com.tencent.mm.plugin.talkroom.b.d locald = new com.tencent.mm.plugin.talkroom.b.d(this.lpD, this.lpE, 1, this.pBi, bMC());
      au.Dk().a(locald, 0);
      b.bMx().pBb = bk.UZ();
      b.bMx().pBe = true;
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final void RK()
  {
    y.i("MicroMsg.TalkRoomServer", "putAwayMic");
    Object localObject = b.bMx();
    if ((((f)localObject).pBe) && (!((f)localObject).pBd)) {
      ((f)localObject).pAY += 1;
    }
    ((f)localObject).pBd = false;
    ((f)localObject).pBe = false;
    if (this.state < 3)
    {
      y.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
      return;
    }
    if (this.pBs != null)
    {
      this.pBs.stopTimer();
      this.pBs = null;
    }
    bMG();
    localObject = new com.tencent.mm.plugin.talkroom.b.d(this.lpD, this.lpE, 2, this.pBi, bMC());
    au.Dk().a((m)localObject, 0);
  }
  
  public final boolean RL()
  {
    return this.pBw;
  }
  
  public final void U(String paramString, int paramInt)
  {
    y.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.pBf = paramInt;
    bME();
    if (paramString.equals(this.pBi))
    {
      y.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[] { paramString });
      if (this.state == 2) {
        this.pBt.RM();
      }
      return;
    }
    y.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[] { paramString });
    this.pBi = paramString;
    Object localObject = new com.tencent.mm.plugin.talkroom.b.a(this.pBi, bMC());
    au.Dk().a((m)localObject, 0);
    b.bMt().pAp = new f();
    b.bMx().pAZ = bk.UZ();
    b.bMx().pAW = paramString;
    if (bMC() == 0) {
      b.bMt().pAn.lGE = true;
    }
    localObject = this.pBt;
    paramString = new i.11((i)localObject, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      return;
    }
    ((i)localObject).handler.post(paramString);
  }
  
  /* Error */
  public final void a(com.tencent.mm.bf.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mm/plugin/talkroom/model/g:pBt	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   4: astore_2
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_2
    //   8: getfield 721	com/tencent/mm/plugin/talkroom/model/i:dhm	Ljava/util/List;
    //   11: aload_1
    //   12: invokeinterface 726 2 0
    //   17: ifeq +17 -> 34
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 92	com/tencent/mm/plugin/talkroom/model/g:pBt	Lcom/tencent/mm/plugin/talkroom/model/i;
    //   26: aload_0
    //   27: invokevirtual 729	com/tencent/mm/plugin/talkroom/model/g:bMD	()Ljava/lang/String;
    //   30: invokevirtual 733	com/tencent/mm/plugin/talkroom/model/i:ny	(Ljava/lang/String;)V
    //   33: return
    //   34: aload_2
    //   35: getfield 721	com/tencent/mm/plugin/talkroom/model/i:dhm	Ljava/util/List;
    //   38: aload_1
    //   39: invokeinterface 736 2 0
    //   44: pop
    //   45: aload_1
    //   46: monitorexit
    //   47: goto -25 -> 22
    //   50: astore_2
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	g
    //   0	55	1	paramd	com.tencent.mm.bf.d
    //   4	31	2	locali	i
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	50	finally
    //   34	47	50	finally
    //   51	53	50	finally
  }
  
  public final void b(com.tencent.mm.bf.d paramd)
  {
    i locali = this.pBt;
    try
    {
      locali.dhm.remove(paramd);
      return;
    }
    finally {}
  }
  
  public final int bMC()
  {
    if ((this.pBf == 1) || ((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.nA(this.pBi)))) {
      return 1;
    }
    return 0;
  }
  
  public final String bMD()
  {
    Iterator localIterator = b.bMv().nw(this.pBi).iterator();
    while (localIterator.hasNext())
    {
      bxc localbxc = (bxc)localIterator.next();
      if (localbxc.tNh == this.pBl) {
        return localbxc.hPY;
      }
    }
    return null;
  }
  
  public final void beA()
  {
    y.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
    jG(false);
    if (bk.bl(this.pBi)) {
      y.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
    }
    for (;;)
    {
      return;
      Object localObject1 = b.bMx();
      if (((f)localObject1).pAZ != 0L) {
        ((f)localObject1).pAD = ((int)(bk.cp(((f)localObject1).pAZ) / 1000L));
      }
      this.state = 0;
      this.pBh = false;
      int i = this.lpD;
      long l = this.lpE;
      if (this.lpD != 0)
      {
        localObject1 = this.pBi;
        localObject1 = new com.tencent.mm.plugin.talkroom.b.b(i, l, (String)localObject1, bMC());
        au.Dk().a((m)localObject1, 0);
        if (this.pBn == null) {}
      }
      try
      {
        i = this.pBn.Close();
        if (i < 0) {
          y.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[] { Integer.valueOf(i) });
        }
        localObject2 = new PByteArray();
        if (a((PByteArray)localObject2, r.gV(this.pBi)) == 0)
        {
          localObject1 = new String(((PByteArray)localObject2).value);
          y.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[] { Integer.valueOf(((PByteArray)localObject2).value.length), localObject1 });
          localObject2 = new LinkedList();
          bxd localbxd = new bxd();
          localbxd.tou = 10402;
          localbxd.tNi = new bml().YI((String)localObject1);
          localObject1 = new bxd();
          ((bxd)localObject1).tou = 10404;
          ((bxd)localObject1).tNi = new bml().YI(b.bMx().toString());
          ((LinkedList)localObject2).add(localbxd);
          ((LinkedList)localObject2).add(localObject1);
          localObject1 = new com.tencent.mm.plugin.talkroom.b.g((LinkedList)localObject2, bMC());
          au.Dk().a((m)localObject1, 0);
        }
        this.pBi = "";
        this.lpD = 0;
        this.lpE = 0L;
        this.pBj = 0;
        this.pBk = 0;
        this.pBl = 0;
        this.pBm.clear();
        bMF();
        localObject1 = this.pBt;
        localObject2 = new i.12((i)localObject1);
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ((Runnable)localObject2).run();
          localObject1 = b.bMt().pAn;
          ((c)localObject1).mHandler.post(new c.1((c)localObject1));
          this.pBg = 0;
          au.Dk().b(332, this);
          au.Dk().b(334, this);
          au.Dk().b(336, this);
          au.Dk().b(335, this);
          b.bMv().b(this);
          au.tu().b(this);
          b(b.bMt().pAn);
          if (this.pBn == null) {}
        }
        else
        {
          try
          {
            i = this.pBn.uninitLive();
            com.tencent.mm.sdk.platformtools.ae.getContext().unbindService(this.iAC);
            localObject1 = new Intent(com.tencent.mm.sdk.platformtools.ae.getContext(), TalkRoomService.class);
            com.tencent.mm.sdk.platformtools.ae.getContext().stopService((Intent)localObject1);
            this.pBn = null;
            if (i >= 0) {
              continue;
            }
            y.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[] { Integer.valueOf(i) });
            return;
          }
          catch (RemoteException localRemoteException2)
          {
            y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
          }
          localObject1 = "";
        }
      }
      catch (RemoteException localRemoteException1)
      {
        for (;;)
        {
          Object localObject2;
          y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
          i = -99999;
          continue;
          localRemoteException1.handler.post((Runnable)localObject2);
          continue;
          i = -99999;
        }
      }
    }
  }
  
  public final List bee()
  {
    return b.bMv().nw(this.pBi);
  }
  
  public final void i(String paramString1, String paramString2, String paramString3)
  {
    if (!paramString1.equals(this.pBi)) {
      return;
    }
    paramString1 = this.pBt;
    paramString2 = new i.10(paramString1, paramString2, paramString3);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString2.run();
      return;
    }
    paramString1.handler.post(paramString2);
  }
  
  public final void jH(boolean paramBoolean)
  {
    y.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[] { this.pBi });
    if ((bk.bl(this.pBi)) || (this.state < 2)) {}
    for (;;)
    {
      return;
      Object localObject = b.bMx();
      ((f)localObject).pAJ += 1;
      if ((!paramBoolean) || (bMH())) {
        try
        {
          bMI();
          bMG();
          this.state = 1;
        }
        catch (RemoteException localRemoteException1)
        {
          try
          {
            if (this.pBn != null) {
              this.pBn.Close();
            }
            if (this.lpD != 0) {
              bMJ();
            }
            if (!paramBoolean)
            {
              localObject = this.pBt;
              local4 = new i.4((i)localObject);
              if (Looper.myLooper() == Looper.getMainLooper())
              {
                local4.run();
                return;
                localRemoteException1 = localRemoteException1;
                y.e("MicroMsg.TalkRoomServer", localRemoteException1.toString());
                y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException1, "", new Object[0]);
              }
            }
          }
          catch (RemoteException localRemoteException2)
          {
            i.4 local4;
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.TalkRoomServer", localRemoteException2, "", new Object[0]);
            }
            localRemoteException2.handler.post(local4);
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (com.tencent.mm.plugin.talkroom.b.f)paramm;
    if ((paramString.bMK() == null) || (!paramString.bMK().equals(this.pBi))) {
      y.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[] { paramString.bMK(), this.pBi });
    }
    label326:
    do
    {
      do
      {
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label326;
        }
        if (paramm.getType() == 332)
        {
          b.bMx().zp(2);
          if (paramInt1 == 4) {
            b.bMx().pAX = paramInt2;
          }
          this.pBt.i("cgi enter failed : errType:" + paramInt1 + " errCode:" + paramInt2, paramInt1, paramInt2);
          beA();
          return;
        }
        if (paramm.getType() != 334) {
          break;
        }
      } while (((com.tencent.mm.plugin.talkroom.b.d)paramm).actionType != 1);
      paramString = b.bMx();
      paramString.pAG += 1;
      paramString.pBb = 0L;
      bMG();
      y.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
      if ((paramInt1 == 4) && ((paramInt2 == 311) || (paramInt2 == 340)))
      {
        this.pBt.jp(paramInt2);
        return;
      }
      this.pBt.e(paramInt1, paramInt2, "TalkMicAction failed!!");
      return;
      if (paramm.getType() == 336)
      {
        this.pBh = false;
        this.pBt.e(paramInt1, paramInt2, "TalkGetMember failed!!");
        beA();
        return;
      }
      if (paramm.getType() == 335)
      {
        this.pBt.e(paramInt1, paramInt2, "TalkNoop failed!!");
        beA();
        return;
      }
      Object localObject;
      if (paramm.getType() == 332)
      {
        b.bMx().zp(1);
        paramm = (com.tencent.mm.plugin.talkroom.b.a)paramm;
        this.lpD = paramm.lpD;
        this.lpE = paramm.lpE;
        this.pBj = paramm.pBj;
        this.pBk = paramm.pBk;
        this.pBm = paramm.pBm;
        localObject = b.bMx();
        paramInt1 = this.lpD;
        long l = this.lpE;
        ((f)localObject).lpD = paramInt1;
        ((f)localObject).lpE = l;
        paramm = paramm.pBF;
        b.bMv().a(this.pBi, paramm, null, null, paramString.bML());
        zq(100);
        return;
      }
      if (paramm.getType() == 334)
      {
        paramString = (com.tencent.mm.plugin.talkroom.b.d)paramm;
        if (paramString.actionType == 1)
        {
          paramm = b.bMx();
          if (paramm.pBb != 0L)
          {
            paramm.pAE = ((bk.cp(paramm.pBb) + paramm.pAE * paramm.pBa) / (paramm.pBa + 1));
            paramm.pBa += 1;
            paramm.pAF += 1;
            paramm.pBb = 0L;
          }
          y.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
          if (paramString.pBj < this.pBj)
          {
            y.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[] { Integer.valueOf(paramString.pBj), Integer.valueOf(this.pBj) });
            bMG();
            this.pBt.jp(311);
            return;
          }
          this.pBj = paramString.pBj;
          paramInt1 = -99999;
          try
          {
            paramInt2 = this.pBn.SetCurrentMicId(this.pBj);
            paramInt1 = paramInt2;
          }
          catch (RemoteException paramString)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.TalkRoomServer", paramString, "", new Object[0]);
            }
            paramString = this.pBt;
            paramm = new i.6(paramString);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label788;
            }
          }
          if (this.state != 3)
          {
            y.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
            return;
          }
          paramm.run();
          for (;;)
          {
            this.state = 4;
            if (paramInt1 < 0) {
              y.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[] { Integer.valueOf(paramInt1) });
            }
            if (this.pBs != null) {
              break;
            }
            this.pBs = new am(new g.3(this), true);
            this.pBs.S(5000L, 5000L);
            return;
            paramString.handler.post(paramm);
          }
        }
        y.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        return;
      }
      if (paramm.getType() == 336)
      {
        localObject = (com.tencent.mm.plugin.talkroom.b.c)paramm;
        LinkedList localLinkedList = ((com.tencent.mm.plugin.talkroom.b.c)localObject).pBF;
        b.bMv().a(this.pBi, localLinkedList, null, null, paramString.bML());
        zr(((com.tencent.mm.plugin.talkroom.b.c)localObject).pBj);
        this.pBh = false;
        this.pBt.ny(bMD());
      }
    } while ((paramm.getType() != 335) || (this.state != 0));
    label788:
    this.pBt.e(3, -1, "talknoop success but in outside room state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */