package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.model.bf;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class k
{
  public boolean cDO;
  public Context jpJ;
  ak mHandler;
  public int mStatus;
  public boolean tuF;
  public boolean tuG;
  public boolean tuH;
  public boolean tuI;
  public boolean tuJ;
  public boolean tuK;
  public boolean tuL;
  public boolean tuM;
  public cfw tuN;
  public int tuO;
  public long tuP;
  public long tuQ;
  public int tuR;
  public int tuS;
  public boolean tuT;
  public boolean tuU;
  public boolean tuV;
  public int tuW;
  private int tuX;
  private int tuY;
  private int tuZ;
  private ap tvA;
  private a tvB;
  private int tva;
  private int tvb;
  public boolean tvc;
  private boolean tvd;
  private int tve;
  private boolean tvf;
  private int tvg;
  private int tvh;
  private int tvi;
  public v2protocal tvj;
  public w tvk;
  public m tvl;
  public v tvm;
  public byte[] tvn;
  public csp tvo;
  public boolean tvp;
  public boolean tvq;
  public int tvr;
  public int tvs;
  public int tvt;
  public boolean tvu;
  public VoipScoreState tvv;
  public int tvw;
  public ap tvx;
  Timer tvy;
  int tvz;
  
  protected k()
  {
    AppMethodBeat.i(4400);
    this.mStatus = 1;
    this.tuF = false;
    this.tuG = false;
    this.tuH = false;
    this.tuI = false;
    this.cDO = false;
    this.tuJ = false;
    this.tuK = false;
    this.tuL = false;
    this.tuM = false;
    this.tuN = new cfw();
    this.tuO = 0;
    this.tuP = 0L;
    this.tuQ = 0L;
    this.tuR = 0;
    this.tuS = 0;
    this.tuT = false;
    this.tuU = false;
    this.tuV = false;
    this.tuW = 10;
    this.tuX = -1;
    this.tuY = -1;
    this.tuZ = -1;
    this.tva = -1;
    this.tvb = -1;
    this.tvc = false;
    this.tvd = false;
    this.tve = 1;
    this.tvf = false;
    this.tvg = 1;
    this.tvh = -1;
    this.tvi = -1;
    this.jpJ = null;
    this.tvk = w.tzF;
    this.tvn = null;
    this.tvo = null;
    this.tvp = false;
    this.tvq = false;
    this.tvr = 0;
    this.tvs = 0;
    this.tvt = 0;
    this.tvu = false;
    this.tvw = 0;
    this.tvx = new ap(Looper.getMainLooper(), new k.1(this), true);
    this.mHandler = new k.3(this, Looper.getMainLooper());
    this.tvy = null;
    this.tvz = 0;
    this.tvA = new ap(Looper.getMainLooper(), new k.8(this), false);
    this.tvB = null;
    this.tvj = new v2protocal(this.mHandler);
    this.tvl = new m(this);
    this.tvm = new v(this);
    this.tvt = 0;
    this.tvv = new VoipScoreState();
    AppMethodBeat.o(4400);
  }
  
  private void cMe()
  {
    AppMethodBeat.i(4415);
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "SrvDeviceInfo.mAudioInfo.aecMode:" + ac.erv.eno);
    if (ac.erv.emP == 1) {
      this.tvj.setAppCmd(410);
    }
    byte[] arrayOfByte = new byte[2];
    label126:
    Object localObject;
    int n;
    int i;
    if (ac.erv.eno >= 0)
    {
      arrayOfByte[0] = ((byte)ac.erv.eno);
      this.tvj.setAppCmd(406, arrayOfByte, 1);
      if (ac.erv.enp < 0) {
        break label908;
      }
      arrayOfByte[0] = ((byte)ac.erv.enp);
      this.tvj.setAppCmd(408, arrayOfByte, 1);
      localObject = com.tencent.mm.model.c.c.abU().me("100447");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        n = bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("SetVoipRnnNsOn"), 0);
        if (1 == n)
        {
          i = (byte)n;
          this.tvj.setAppCmd(432, new byte[] { i }, 1);
        }
      }
      if (ac.erv.enr < 0) {
        break label950;
      }
      localObject = new byte[5];
      if ((ac.erv.ens >= 0) && (ac.erv.ent >= 0))
      {
        localObject[0] = ((byte)ac.erv.ens);
        localObject[1] = ((byte)ac.erv.ent);
        if (ac.erv.enu < 0) {
          break label933;
        }
        localObject[2] = ((byte)ac.erv.enu);
        localObject[3] = ((byte)ac.erv.enr);
        localObject[4] = ((byte)ac.erv.env);
        this.tvj.setAppCmd(404, (byte[])localObject, 5);
      }
    }
    for (;;)
    {
      if ((ac.erv.emQ >= 0) || (ac.erv.emS >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ac.erv.emQ >= 0) {
          arrayOfByte[0] = ((byte)ac.erv.emQ);
        }
        if (ac.erv.emS >= 0) {
          arrayOfByte[1] = ((byte)ac.erv.emS);
        }
        this.tvj.setAppCmd(414, arrayOfByte, 2);
      }
      if ((ac.erv.emR >= 0) || (ac.erv.emT >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ac.erv.emR >= 0) {
          arrayOfByte[0] = ((byte)ac.erv.emR);
        }
        if (ac.erv.emT >= 0) {
          arrayOfByte[1] = ((byte)ac.erv.emT);
        }
        this.tvj.setAppCmd(415, arrayOfByte, 2);
      }
      if ((ac.erv.emU >= 0) || (ac.erv.emV >= 0))
      {
        arrayOfByte[0] = -1;
        arrayOfByte[1] = -1;
        if (ac.erv.emU >= 0) {
          arrayOfByte[0] = ((byte)ac.erv.emU);
        }
        if (ac.erv.emV >= 0) {
          arrayOfByte[1] = ((byte)ac.erv.emV);
        }
        this.tvj.setAppCmd(422, arrayOfByte, 2);
      }
      if (ac.erv.emW >= 0)
      {
        arrayOfByte[0] = ((byte)ac.erv.emW);
        this.tvj.setAppCmd(416, arrayOfByte, 1);
      }
      if (ac.erv.ena >= 0)
      {
        arrayOfByte[0] = ((byte)ac.erv.ena);
        this.tvj.setAppCmd(431, arrayOfByte, 4);
      }
      if ((ac.erv.emX >= 0) && ((this.tvj.tAP != 0) || (ac.erv.emX != 5)))
      {
        arrayOfByte[0] = ((byte)ac.erv.emX);
        this.tvj.setAppCmd(417, arrayOfByte, 1);
      }
      if ((ac.erv.emY >= 0) && ((this.tvj.tAP != 0) || (ac.erv.emY != 5)))
      {
        arrayOfByte[0] = ((byte)ac.erv.emY);
        this.tvj.setAppCmd(418, arrayOfByte, 1);
      }
      if (ac.erv.emZ >= 0)
      {
        arrayOfByte[0] = ((byte)ac.erv.emZ);
        this.tvj.setAppCmd(419, arrayOfByte, 1);
      }
      if ((this.tvj.tAP == 1) && ((ac.erv.emX == 5) || (ac.erv.emY == 5))) {
        this.tvj.tAB = 5;
      }
      if (1 != ac.erv.eny) {
        break label990;
      }
      localObject = new byte[30];
      n = 0;
      while (n < 15)
      {
        localObject[(n * 2)] = ((byte)(ac.erv.enz[n] & 0xFF));
        localObject[(n * 2 + 1)] = ((byte)(ac.erv.enz[n] >> 8 & 0xFF));
        n += 1;
      }
      if (ac.erv.eno != -2) {
        break;
      }
      this.tvj.setAppCmd(407);
      break;
      label908:
      if (ac.erv.enp != -2) {
        break label126;
      }
      this.tvj.setAppCmd(409);
      break label126;
      label933:
      this.tvj.setAppCmd(404, (byte[])localObject, 2);
      continue;
      label950:
      if (ac.erv.enr == -2) {
        this.tvj.setAppCmd(405);
      }
    }
    this.tvj.setAppCmd(420, (byte[])localObject, 30);
    label990:
    if (ac.erv.eny == 0) {
      this.tvj.setAppCmd(421);
    }
    if ((ac.erv.enA[0] > 0) || (ac.erv.enA[1] > 0))
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      if ((ac.erv.enA[0] > 0) && (ac.erv.enA[0] < 10000)) {
        arrayOfByte[0] = ((byte)ac.erv.enA[0]);
      }
      if ((ac.erv.enA[1] > 0) && (ac.erv.enA[1] < 10000)) {
        arrayOfByte[1] = ((byte)ac.erv.enA[1]);
      }
      this.tvj.setAppCmd(423, arrayOfByte, 2);
    }
    if (ac.erv.enC > 0)
    {
      arrayOfByte[0] = ((byte)ac.erv.enC);
      this.tvj.setAppCmd(424, arrayOfByte, 1);
    }
    if (ac.erv.enK >= 0)
    {
      i = (byte)ac.erv.enK;
      int j = (byte)ac.erv.enL;
      int k = (byte)ac.erv.enM;
      int m = (byte)ac.erv.enN;
      this.tvj.setAppCmd(426, new byte[] { i, j, k, m }, 4);
    }
    AppMethodBeat.o(4415);
  }
  
  private void cMj()
  {
    AppMethodBeat.i(4424);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(4396);
        if ((k.this.mStatus != 2) && (k.this.mStatus != 3) && (k.this.mStatus != 4))
        {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + k.this.mStatus);
          AppMethodBeat.o(4396);
          return;
        }
        if (k.this.tuF)
        {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
          AppMethodBeat.o(4396);
          return;
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
        int k = (k.this.tvj.tAU >> 2 & 0x3) >> 1 & 0x1 & (k.this.tvj.tAU & 0x3) >> 1 & 0x1;
        v2protocal localv2protocal = k.this.tvj;
        int m = k.this.tvj.tAa;
        long l1 = k.this.tvj.nMZ;
        int n = k.this.tvj.nNh;
        long l2 = k.this.tvj.nNa;
        byte[] arrayOfByte1 = k.this.tvj.tAc;
        int i1 = k.this.tvj.channelStrategy;
        int i2 = k.this.tvj.tAh;
        int i3 = k.this.tvj.tAi;
        int i4 = k.this.tvj.tAf;
        int i;
        byte[] arrayOfByte2;
        int i5;
        int i6;
        int i7;
        byte[] arrayOfByte3;
        int i8;
        int i9;
        if (k.this.tvj.tAg == null)
        {
          i = 0;
          arrayOfByte2 = k.this.tvj.tAg;
          i5 = k.this.tvj.tAj;
          i6 = k.this.tvj.tzZ;
          i7 = k.this.tvj.tBe;
          arrayOfByte3 = k.this.tvj.tBf;
          i8 = k.this.tvj.tBg;
          i9 = k.this.tvj.tAk;
          if (k.this.tvj.tAl != null) {
            break label575;
          }
        }
        label575:
        for (int j = 0;; j = k.this.tvj.tAl.length)
        {
          j = localv2protocal.setConfigInfo(m, l1, n, l2, arrayOfByte1, i1, i2, i3, i4, i, arrayOfByte2, i5, k, i6, i7, arrayOfByte3, i8, i9, j, k.this.tvj.tAl, k.this.tvj.tBh);
          i = j;
          if (j == 0) {
            i = k.this.tvj.connectToPeerRelay();
          }
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + k + ",  NetType: " + k.this.tvj.tzZ + ", EncryptStrategy: " + k.this.tvj.tBe);
          if (i >= 0) {
            break label590;
          }
          com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:".concat(String.valueOf(i)));
          k.this.tvj.tBN.twb = 14;
          k.this.y(1, -9002, "");
          AppMethodBeat.o(4396);
          return;
          i = k.this.tvj.tAg.length;
          break;
        }
        label590:
        k.this.tuF = true;
        k.this.tvj.tBN.twi = 1;
        k.this.tvj.tBN.twq = 1;
        AppMethodBeat.o(4396);
      }
    });
    AppMethodBeat.o(4424);
  }
  
  public final void Hg(int paramInt)
  {
    AppMethodBeat.i(4404);
    this.tvj.tAp = Math.abs(paramInt);
    AppMethodBeat.o(4404);
  }
  
  public final void Hh(int paramInt)
  {
    AppMethodBeat.i(4405);
    this.tvj.tAq = Math.abs(paramInt);
    AppMethodBeat.o(4405);
  }
  
  public final void Hi(int paramInt)
  {
    this.tvj.tAt = paramInt;
  }
  
  public final void Hj(int paramInt)
  {
    AppMethodBeat.i(4411);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.tvb = paramInt;
    }
    for (;;)
    {
      if ((1 == paramInt) || (3 == paramInt)) {
        Hk(2);
      }
      this.tvk.Hw(paramInt);
      AppMethodBeat.o(4411);
      return;
      this.tuZ = paramInt;
      this.tuX = paramInt;
    }
  }
  
  public final void Hk(int paramInt)
  {
    AppMethodBeat.i(4412);
    if ((8 == paramInt) || (9 == paramInt)) {
      this.tva = paramInt;
    }
    for (;;)
    {
      this.tvm.HE(paramInt);
      AppMethodBeat.o(4412);
      return;
      this.tuX = paramInt;
      this.tuY = paramInt;
    }
  }
  
  public final void Hl(int paramInt)
  {
    AppMethodBeat.i(4422);
    try
    {
      cpp localcpp = new cpp();
      localcpp.xYy = paramInt;
      if (1 == paramInt)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localcpp.xYz = new com.tencent.mm.bv.b(localByteBuffer.array());
        this.tvj.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.tvj.SendRUDP(localcpp.toByteArray(), localcpp.toByteArray().length);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(4422);
        return;
        localcpp.xYz = null;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
      AppMethodBeat.o(4422);
    }
  }
  
  public final void Hm(int paramInt)
  {
    AppMethodBeat.i(4423);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      this.tvj.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new crq();
      ((crq)localObject).yaF = paramInt;
      ((crq)localObject).yaG = 1;
      cpp localcpp = new cpp();
      localcpp.xYy = 4;
      localcpp.xYz = new com.tencent.mm.bv.b(((crq)localObject).toByteArray(), 0, 1);
      this.tvj.SendRUDP(localcpp.toByteArray(), localcpp.toByteArray().length);
      AppMethodBeat.o(4423);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
      AppMethodBeat.o(4423);
    }
  }
  
  public final void Hn(int paramInt)
  {
    this.tvj.tBg = paramInt;
  }
  
  public final void Ho(int paramInt)
  {
    this.tvj.tAZ = paramInt;
  }
  
  public final void Hp(int paramInt)
  {
    this.tvj.tBN.twh = 1;
    this.tvj.channelStrategy = paramInt;
  }
  
  public final void Hq(int paramInt)
  {
    this.tvj.tAj = paramInt;
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.tvB = parama;
    }
  }
  
  public final void a(crn paramcrn1, crn paramcrn2, crn paramcrn3, LinkedList<csv> paramLinkedList)
  {
    AppMethodBeat.i(4428);
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    if ((str != null) && (str.length() > 0) && (i > 0))
    {
      localcsx = new csx();
      try
      {
        localcsx.ybW = 1;
        localcsx.ybX = i;
        localcsx.ybY = 0;
        localcsx.userName = "";
        localcsx.gFE = "";
        localcsx.ybX = com.tencent.mm.plugin.voip.a.a.RJ(InetAddress.getByName(str).getHostAddress());
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        ab.printErrStackTrace("MicroMsg.Voip.VoipContext", localUnknownHostException, "", new Object[0]);
        return;
      }
      finally
      {
        if (this.tvj.a(paramcrn1, paramcrn2, paramcrn3, localcsx, paramLinkedList) != 0) {
          ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
        }
        AppMethodBeat.o(4428);
      }
      AppMethodBeat.o(4428);
      return;
    }
    csx localcsx = new csx();
    localcsx.ybW = 0;
    localcsx.ybX = 0;
    localcsx.ybY = 0;
    localcsx.userName = "";
    localcsx.gFE = "";
    if (this.tvj.a(paramcrn1, paramcrn2, paramcrn3, localcsx, paramLinkedList) != 0) {
      ab.i("MicroMsg.Voip.VoipContext", "setIp fail!");
    }
    AppMethodBeat.o(4428);
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.tvj.tAf = paramInt1;
    this.tvj.tAg = paramArrayOfByte1;
    this.tvj.tBe = paramInt2;
    this.tvj.tBf = paramArrayOfByte2;
  }
  
  public final boolean a(csp paramcsp)
  {
    this.tvo = paramcsp;
    this.tvj.ocN = this.tvo.ybf;
    this.tvj.nMZ = this.tvo.wQP;
    this.tvj.nNa = this.tvo.wQQ;
    this.tvj.nNh = 1;
    this.tvj.tAa = 0;
    this.mStatus = 3;
    return true;
  }
  
  public final int ao(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(4418);
      return -1;
    }
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:DisableCodec: targetCodec = " + paramInt + ", local=" + paramBoolean + ", remote =true");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    if (paramBoolean) {}
    try
    {
      if (this.tvj != null)
      {
        cpp localcpp = new cpp();
        localcpp.xYy = 5;
        localcpp.xYz = new com.tencent.mm.bv.b(localByteBuffer.array());
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable local target codec: ".concat(String.valueOf(paramInt)));
        this.tvj.SendRUDP(localcpp.toByteArray(), localcpp.toByteArray().length);
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:disable remote target codec: ".concat(String.valueOf(paramInt)));
      this.tvj.setAppCmd(35, localByteBuffer.array(), 4);
      AppMethodBeat.o(4418);
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "DisableCodec Error");
      }
    }
  }
  
  public final void br(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4427);
    ab.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.tvj.tBN.twg = 1;
    this.tvj.tBN.twf = 1;
    this.tvj.tAc = paramArrayOfByte;
    AppMethodBeat.o(4427);
  }
  
  public final void bs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4429);
    ab.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.tvj.tBN.twk) });
    if ((this.tvj.tBN.twk == 1) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(4429);
      return;
    }
    this.tvj.tBN.twk = 1;
    this.tvj.tAd = paramArrayOfByte;
    int i = this.tvj.exchangeCabInfo(this.tvj.tAd, this.tvj.tAd.length);
    if (i < 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:".concat(String.valueOf(i)));
      this.tvj.tBN.twb = 15;
      y(1, -9003, "");
    }
    AppMethodBeat.o(4429);
  }
  
  public final void bt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4430);
    this.tvj.tAe = paramArrayOfByte;
    cMl();
    AppMethodBeat.o(4430);
  }
  
  public final void c(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.tvj.tBl = paramInt;
    this.tvj.tBm = paramArrayOfByte1;
    this.tvj.tBn = paramArrayOfByte2;
  }
  
  public final int cLL()
  {
    AppMethodBeat.i(4410);
    m localm = this.tvl;
    if (localm.tvF != null)
    {
      int i = localm.tvF.cLL();
      AppMethodBeat.o(4410);
      return i;
    }
    AppMethodBeat.o(4410);
    return 0;
  }
  
  public final void cLV()
  {
    int k = 0;
    AppMethodBeat.i(4402);
    if ((this.tuF == true) && (this.tuO == 0))
    {
      this.tuO = 1;
      if (this.tvj.field_speedTestInfoLength < 8)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.tvj.field_speedTestInfoLength);
        AppMethodBeat.o(4402);
      }
    }
    else
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.tuF + " ,mSpeedTestStatus=" + this.tuO);
      AppMethodBeat.o(4402);
      return;
    }
    int i = this.tvj.tBL[1];
    if (i + 2 > this.tvj.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.tvj.field_speedTestInfoLength);
      AppMethodBeat.o(4402);
      return;
    }
    int j = this.tvj.tBL[(i + 2 + 1)];
    if (i + 6 + j != this.tvj.field_speedTestInfoLength)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.tvj.field_speedTestInfoLength);
      AppMethodBeat.o(4402);
      return;
    }
    this.tuP = this.tvj.nNa;
    this.tuR = this.tvj.netType;
    this.tuS = this.tvj.nMZ;
    this.tuN.wQP = this.tvj.nMZ;
    this.tuN.xQo = this.tvj.tAo;
    this.tuN.wLO = this.tvj.netType;
    cfw localcfw = this.tuN;
    if (this.tuF == true)
    {
      i = 1;
      localcfw.xQp = i;
      localcfw = this.tuN;
      if (this.tuH != true) {
        break label478;
      }
    }
    label478:
    for (i = 1;; i = 0)
    {
      localcfw.xQq = i;
      this.tuN.xQr = this.tvj.tBL[0];
      this.tuN.xQs = this.tvj.tBL[1];
      j = 0;
      i = 2;
      while (j < this.tuN.xQs)
      {
        this.tuN.xQt.add(Integer.valueOf(this.tvj.tBL[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localcfw = this.tuN;
    int[] arrayOfInt = this.tvj.tBL;
    j = i + 1;
    localcfw.xQu = arrayOfInt[i];
    localcfw = this.tuN;
    arrayOfInt = this.tvj.tBL;
    i = j + 1;
    localcfw.xQv = arrayOfInt[j];
    j = k;
    while (j < this.tuN.xQv)
    {
      this.tuN.xQw.add(Integer.valueOf(this.tvj.tBL[i]));
      j += 1;
      i += 1;
    }
    this.tuN.xQx = this.tvj.tBL[i];
    this.tuN.xQy = this.tvj.tBL[(i + 1)];
    new com.tencent.mm.plugin.voip.model.a.k(this.tuN).cOs();
    AppMethodBeat.o(4402);
  }
  
  public final void cLW()
  {
    AppMethodBeat.i(4403);
    if (this.tuO == 0)
    {
      AppMethodBeat.o(4403);
      return;
    }
    if (this.tuO == 1)
    {
      this.tuO = 0;
      this.tvj.tBv = 0L;
      AppMethodBeat.o(4403);
      return;
    }
    this.tuO = 0;
    v2protocal localv2protocal = this.tvj;
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.tBv = 0L;
    AppMethodBeat.o(4403);
  }
  
  public final void cLX()
  {
    AppMethodBeat.i(4406);
    this.tvj.tAr = this.tvl.cMo();
    this.tvj.tAs = this.tvl.cLK();
    AppMethodBeat.o(4406);
  }
  
  public final int cLY()
  {
    int i = 2;
    if (this.mStatus == 1) {
      i = 0;
    }
    do
    {
      return i;
      if ((this.mStatus == 2) || (this.mStatus == 3)) {
        return 1;
      }
    } while (this.mStatus == 4);
    return 3;
  }
  
  public final boolean cLZ()
  {
    return this.mStatus == 3;
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(4409);
    ab.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 1)
    {
      AppMethodBeat.o(4409);
      return false;
    }
    AppMethodBeat.o(4409);
    return true;
  }
  
  public final long cMb()
  {
    return this.tvj.tAo;
  }
  
  public final boolean cMc()
  {
    if (this.tuV) {
      return false;
    }
    switch (this.tuX)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.tuY);
        return false;
      } while ((4 == this.tuY) || (-1 == this.tuY));
      return false;
      if ((5 == this.tuY) || (6 == this.tuY)) {
        break;
      }
    } while (7 != this.tuY);
    return false;
  }
  
  public final boolean cMd()
  {
    if (this.tuV) {
      return false;
    }
    switch (this.tuX)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.tuY);
        return false;
      } while ((4 == this.tuZ) || (this.tuZ == 0) || (-1 == this.tuZ));
      return false;
      if ((5 == this.tuZ) || (6 == this.tuZ)) {
        break;
      }
    } while (7 != this.tuZ);
    return false;
  }
  
  public final void cMf()
  {
    AppMethodBeat.i(4416);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.tuJ != true) || (this.tuH != true))
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.tuJ + ", isChannelConnectedSuccess " + this.tuH);
      AppMethodBeat.o(4416);
      return;
    }
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.tvj.setActive();
    if (this.tuM == true)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.tuM);
      AppMethodBeat.o(4416);
      return;
    }
    this.tvj.setSvrConfig(205, 0, 0, this.tvj.tBh, 0, 0, 0, 0, null);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.tvj.tBh + " SwitchFlag = " + this.tvj.tAk);
    if (this.tvj.startEngine() == 0) {}
    for (this.tvj.tBN.twB = 0; this.tvj.tAm == null; this.tvj.tBN.twB = 1)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: protocol has null generalStrategyBuf");
      AppMethodBeat.o(4416);
      return;
      this.tuM = false;
    }
    label333:
    int j;
    label391:
    int k;
    label770:
    int m;
    int n;
    label1563:
    label1594:
    label1604:
    Object localObject2;
    boolean bool;
    if (this.tvj.tAm.length < 1024)
    {
      this.tvj.setSvrConfig(208, 0, 0, 0, 0, 0, 0, this.tvj.tAm.length, this.tvj.tAm);
      cMe();
      if ((cMc()) || (cMd())) {
        break label1989;
      }
      cMi();
      this.tvk.cNd();
      localObject1 = this.tvl;
      if (((m)localObject1).kJF != 2) {
        break label2047;
      }
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
      localObject1 = this.tvj.tBN;
      if (((n)localObject1).beginTime != 0L) {
        break label2456;
      }
      ((n)localObject1).twu = 0;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((n)localObject1).beginTime + ", CurrentTime: " + System.currentTimeMillis());
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((n)localObject1).twu);
      this.tvk.onConnected();
      this.mStatus = 5;
      localObject1 = this.tvj.tBN;
      ((n)localObject1).twC = System.currentTimeMillis();
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((n)localObject1).twC);
      this.tvj.setSvrConfig(202, this.tvj.tAH, this.tvj.tAI, 0, 0, 0, 0, 0, null);
      this.tvj.setSvrConfig(203, 0, 0, this.tvj.tAM, 0, 0, 0, 0, null);
      this.tvj.setSvrConfig(206, 0, 0, this.tvj.tAQ, 0, 0, 0, 0, null);
      this.tvj.setSvrConfig(103, this.tvj.tAJ, this.tvj.tAK, this.tvj.tAL, this.tvj.tAO, 0, 0, 0, null);
      this.tvj.setSvrConfig(205, 0, 0, this.tvj.tBh, 0, 0, 0, 0, null);
      this.tvj.setSvrConfig(207, 0, 0, this.tvj.tAk, 0, 0, 0, 0, null);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.tvj.tBh + " SwitchFlag = " + this.tvj.tAk);
      j = this.tvj.tAU >> 2 & 0x3;
      k = this.tvj.tAU & 0x3;
      if (this.tvj.nNh != 0) {
        break label2474;
      }
      j = (j << 2) + k;
      this.tvj.setSvrConfig(502, 0, 0, j, 0, 0, 0, 0, null);
      this.tvj.setSvrConfig(503, 0, 0, this.tvj.tAV, this.tvj.tAW, this.tvj.tAX, this.tvj.tAY, 0, null);
      if ((this.tvj.tBm != null) && (this.tvj.tBn != null))
      {
        this.tvj.setSvrConfig(504, 0, 0, this.tvj.tBl, 0, 0, 0, 0, null);
        this.tvj.setSvrConfig(505, 0, 0, this.tvj.tBm[0], this.tvj.tBm[1], this.tvj.tBm[2], this.tvj.tBm[3], 0, null);
        this.tvj.setSvrConfig(506, 0, 0, this.tvj.tBn[0], this.tvj.tBn[1], 0, 0, 0, null);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.tvj.tBl + ",FECKeyPara1 = " + this.tvj.tBm[0] + "," + this.tvj.tBm[1] + "," + this.tvj.tBm[2] + "," + this.tvj.tBm[3] + ",FECKeyPara2 = " + this.tvj.tBn[0] + "," + this.tvj.tBn[1]);
      }
      k = this.tvj.tAZ;
      m = this.tvj.tAZ;
      n = this.tvj.tAZ;
      this.tvj.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0, 0, null);
      this.tvj.setjbmbitraterssvrparam();
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.tvj.tAH + ",audioTsdEdge = " + this.tvj.tAI + ",passthroughQosAlgorithm = " + this.tvj.tAJ + ",fastPlayRepair = " + this.tvj.tAK + ", audioDTX = " + this.tvj.tAM + ", mARQFlag = " + j + ", mQosStrategy = " + this.tvj.tAZ + ", mSvrCfgListV = " + this.tvj.tAL + ", maxBRForRelay = " + this.tvj.tAO);
      localObject1 = new byte[2];
      localObject1[0] = ((byte)ac.eru.eot);
      localObject1[1] = -1;
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject1[0]);
      this.tvj.setAppCmd(15, (byte[])localObject1, 1);
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.whH);
      localObject1 = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.whH);
      localObject1 = ((ByteBuffer)localObject1).array();
      this.tvj.setAppCmd(505, (byte[])localObject1, 4);
      if ((this.tvj.tAk & 0x2) == 0) {
        ao(16, true);
      }
      localObject1 = new byte[4];
      this.tvj.setAppCmd(26, (byte[])localObject1, 4);
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
      m = ((ByteBuffer)localObject1).getInt();
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: ".concat(String.valueOf(m)));
      if (((this.tvj.tAL & 0x4) == 0) && (ac.eru.eov <= 0)) {
        break label2483;
      }
      j = 1;
      if ((j == 0) && (this.tvj.kLn))
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
        if ((m & 0x4) == 0) {
          break label2488;
        }
        j = 1;
        if ((m & 0x8) == 0) {
          break label2493;
        }
        k = 1;
        if ((j != 0) || (k != 0))
        {
          this.tvl.tvO = true;
          mQ(false);
        }
        this.tvj.kLn = false;
      }
      if (this.tvj.kLn)
      {
        localObject2 = this.tvj;
        n = ac.eru.eov;
        bool = false;
        if ((m & 0x4) == 0) {
          break label2498;
        }
        j = 1;
        label1669:
        if ((m & 0x8) == 0) {
          break label2503;
        }
        k = 1;
        label1679:
        if ((j != 0) || (k != 0)) {
          if (j == 0) {
            break label2508;
          }
        }
      }
    }
    label1989:
    label2503:
    label2508:
    for (Object localObject1 = "video/hevc";; localObject1 = "video/avc")
    {
      ((v2protocal)localObject2).tBO = new e(((v2protocal)localObject2).width, ((v2protocal)localObject2).height, ((v2protocal)localObject2).tBQ, ((v2protocal)localObject2).bitrate, n, (String)localObject1);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:".concat(String.valueOf(localObject1)));
      if (v2protocal.tBR != null)
      {
        v2protocal.tBP = new d(v2protocal.tBR);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
      }
      bool = true;
      if ((((v2protocal)localObject2).tBO == null) || (v2protocal.tBP == null))
      {
        ((v2protocal)localObject2).kLn = false;
        bool = false;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool + ", iHW:" + m);
      if (!this.tvj.kLn)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
        this.tvl.tvO = true;
        mQ(false);
      }
      if (this.tvj.tBO != null) {
        this.tvj.tBO.ttm = this;
      }
      if (v2protocal.tBP != null) {
        v2protocal.tBP.a(this);
      }
      this.tuM = true;
      this.tvu = false;
      localObject1 = this.tvv;
      ((VoipScoreState)localObject1).nOy = bf.aaM();
      ab.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject1).nOy) });
      AppMethodBeat.o(4416);
      return;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: length of generalStrategyBuf = " + this.tvj.tAm.length);
      break;
      if (this.tvy != null)
      {
        cMi();
        break label333;
      }
      this.tvy = new Timer();
      this.tvz = 0;
      localObject1 = new k.5(this);
      this.tvy.schedule((TimerTask)localObject1, 200L, 200L);
      break label333;
      label2047:
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
      ((m)localObject1).kJF = 2;
      ((m)localObject1).tvO = false;
      ((m)localObject1).tvP = 0;
      if (((m)localObject1).tvU != null)
      {
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
        ((m)localObject1).tvU.tvX = true;
        com.tencent.mm.sdk.g.d.ysm.remove(((m)localObject1).tvU);
        ((m)localObject1).tvU = null;
      }
      ((m)localObject1).tvU = new m.b((m)localObject1);
      com.tencent.mm.sdk.g.d.post(((m)localObject1).tvU, "VoipDeviceHandler_decode");
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
      ac.erv.dump();
      ((m)localObject1).tvF = new c();
      localObject2 = new a();
      j = ((m)localObject1).ttm.tvj.a((a)localObject2);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.GetAudioDeviceFmt, play samplerate:" + ((a)localObject2).pJf + ", framelen: " + ((a)localObject2).tti + ", ret:" + j);
      ((m)localObject1).tvF.F(((a)localObject2).pJf, ((a)localObject2).channels, ((a)localObject2).tti, 0);
      ((m)localObject1).kJG = ((m)localObject1).tvF.x(((m)localObject1).ttm.jpJ, true);
      if (((m)localObject1).tvF.ttl == true)
      {
        j = 1;
        int i = (byte)j;
        ((m)localObject1).ttm.tvj.setAppCmd(502, new byte[] { i }, 1);
        if (((m)localObject1).kJG <= 10)
        {
          if (((m)localObject1).kJG <= 0) {
            ((m)localObject1).kJJ = 1;
          }
          ((m)localObject1).kJG = 92;
        }
        if ((!g.KC().KN()) && (!g.KC().KH())) {
          break label2446;
        }
        com.tencent.mm.plugin.voip.b.cLC().jA(true);
      }
      for (;;)
      {
        ((m)localObject1).tvF.ttu = new m.2((m)localObject1);
        if (((m)localObject1).tvF.cLH() <= 0) {
          ((m)localObject1).kJJ = 1;
        }
        com.tencent.mm.sdk.g.d.f(new m.3((m)localObject1), "voip_start_record");
        break;
        j = 0;
        break label2307;
        com.tencent.mm.plugin.voip.b.cLC().jA(false);
      }
      ((n)localObject1).twu = ((int)(System.currentTimeMillis() - ((n)localObject1).beginTime));
      break label391;
      j = (k << 2) + j;
      break label770;
      j = 0;
      break label1563;
      j = 0;
      break label1594;
      k = 0;
      break label1604;
      j = 0;
      break label1669;
      k = 0;
      break label1679;
    }
  }
  
  public final boolean cMg()
  {
    AppMethodBeat.i(4419);
    boolean bool = cMc();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.tvh == -1) || (this.tvh != i))
    {
      this.tvh = i;
      if (!bool) {
        break label71;
      }
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
      this.tvj.setAppCmd(203);
    }
    for (;;)
    {
      AppMethodBeat.o(4419);
      return bool;
      label71:
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
      this.tvj.setAppCmd(202);
    }
  }
  
  public final boolean cMh()
  {
    AppMethodBeat.i(4420);
    boolean bool = cMd();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.tvi == -1) || (this.tvi != i))
    {
      this.tvi = i;
      if (!bool) {
        break label71;
      }
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
      this.tvj.setAppCmd(201);
    }
    for (;;)
    {
      AppMethodBeat.o(4420);
      return bool;
      label71:
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
      this.tvj.setAppCmd(200);
    }
  }
  
  final void cMi()
  {
    AppMethodBeat.i(4421);
    if (this.mStatus == 5)
    {
      setStatus(6);
      this.tvj.tBN.cMr();
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new k.4(this));
    }
    AppMethodBeat.o(4421);
  }
  
  public final void cMk()
  {
    AppMethodBeat.i(4425);
    if (!bo.ce(this.tvj.tAc)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.tuL + ",isRemoteAccepted:" + this.tuI + ",isLocalAccept:" + this.cDO);
      this.tvj.tBN.twn = 7;
      if ((!bool) || ((this.mStatus != 4) && (this.mStatus != 5) && (this.mStatus != 6) && ((this.mStatus != 2) || (this.tuL != true)) && ((this.mStatus != 3) || (this.tuL != true)))) {
        break label307;
      }
      if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
        break;
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      AppMethodBeat.o(4425);
      return;
    }
    if ((!this.tuI) && (!this.cDO))
    {
      if ((this.tuL) && (!this.tuF))
      {
        cMj();
        AppMethodBeat.o(4425);
      }
    }
    else
    {
      if (!this.tuF) {
        cMj();
      }
      al.d(new k.7(this));
    }
    label307:
    AppMethodBeat.o(4425);
  }
  
  public final void cMl()
  {
    AppMethodBeat.i(4426);
    if ((this.tuG) && (!bo.ce(this.tvj.tAe)))
    {
      int i = this.tvj.handleCommand(this.tvj.tAe, this.tvj.tAe.length);
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:".concat(String.valueOf(i)));
      }
      this.tvj.tAe = null;
    }
    AppMethodBeat.o(4426);
  }
  
  public final void cMm()
  {
    AppMethodBeat.i(4431);
    ab.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.tvx.stopTimer();
    AppMethodBeat.o(4431);
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.tvj.tAU = paramInt1;
    this.tvj.tAV = paramInt2;
    this.tvj.tAW = paramInt3;
    this.tvj.tAX = paramInt4;
    this.tvj.tAY = paramInt5;
  }
  
  public final int mO(boolean paramBoolean)
  {
    AppMethodBeat.i(4413);
    if (paramBoolean) {}
    for (int i = this.tvj.setAppCmd(412);; i = this.tvj.setAppCmd(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(4413);
      return i;
    }
  }
  
  public final int mP(boolean paramBoolean)
  {
    AppMethodBeat.i(4414);
    if (paramBoolean) {}
    for (int i = this.tvj.setAppCmd(401);; i = this.tvj.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(4414);
      return i;
    }
  }
  
  public final void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(4417);
    if (paramBoolean) {
      Hl(2);
    }
    if (this.tvj != null)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
      ao(8, false);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(6);
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
      this.tvj.setAppCmd(30, localByteBuffer.array(), 4);
    }
    AppMethodBeat.o(4417);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(4401);
    ab.i("MicroMsg.Voip.VoipContext", "reset");
    this.tvk.cNc();
    if (this.tvj.cOG()) {
      this.tvj.mX(false);
    }
    this.tvj.reset();
    this.tuX = -1;
    this.tuY = -1;
    this.tuZ = -1;
    this.tva = -1;
    this.tvb = -1;
    this.tvl.cMp();
    this.tvj.tAv = 0;
    this.tvA.stopTimer();
    this.tvm.cOo();
    this.tvx.stopTimer();
    this.tuF = false;
    this.tuH = false;
    this.tuG = false;
    this.tuI = false;
    this.cDO = false;
    this.tuJ = false;
    this.tvn = null;
    this.tvo = null;
    this.tuT = false;
    this.tuU = false;
    this.tuV = false;
    this.tvc = false;
    this.tvd = false;
    this.tvf = false;
    this.tve = 1;
    this.tvg = 1;
    this.tvp = false;
    this.tvh = -1;
    this.tvi = -1;
    this.tuK = false;
    this.tuL = false;
    this.tuJ = false;
    this.tuF = false;
    this.tuM = false;
    this.tuW = 10;
    this.mStatus = 1;
    this.tvt = 0;
    this.tvw = 0;
    this.tvu = false;
    AppMethodBeat.o(4401);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(4408);
    if (paramInt == this.mStatus)
    {
      AppMethodBeat.o(4408);
      return;
    }
    if (paramInt == 4) {
      this.tvA.ag(60000L, 60000L);
    }
    this.mStatus = paramInt;
    AppMethodBeat.o(4408);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(4407);
    cMm();
    this.mHandler.post(new k.2(this));
    AppMethodBeat.o(4407);
  }
  
  public final void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4432);
    cMm();
    if (this.tvB != null) {
      this.tvB.y(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(4432);
  }
  
  public static abstract interface a
  {
    public abstract void y(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k
 * JD-Core Version:    0.7.0.1
 */