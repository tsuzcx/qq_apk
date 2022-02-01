package com.tencent.mm.plugin.multitalk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.protocal.protobuf.fbt;
import com.tencent.mm.protocal.protobuf.fbu;
import com.tencent.mm.protocal.protobuf.fbv;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.protocal.protobuf.fbx;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.fcb;
import com.tencent.mm.protocal.protobuf.fcd;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.pb.common.b.a.a.a.aj;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wxmm.IConfCallBack;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum o
  implements com.tencent.pb.common.b.b
{
  public static int EMethodGetQosPara;
  public static boolean Fnp;
  public final j FmD;
  private a FmH;
  public k.a FnA;
  public k.a FnB;
  private k.a FnC;
  private k.a FnD;
  private k.a FnE;
  private k.a FnF;
  private k.a FnG;
  private k.a FnH;
  private k.a FnI;
  private k.a FnJ;
  private k.a FnK;
  private k.a FnL;
  public k.a FnM;
  public k.a FnN;
  private k.a FnO;
  private k.a FnP;
  private k.a FnQ;
  private boolean FnR;
  private b<String> FnS;
  private c FnT;
  String FnU;
  private long FnV;
  String FnW;
  String FnX;
  int FnY;
  private boolean FnZ;
  private final q Fnf;
  public final k Fng;
  public final e Fnh;
  private final s Fni;
  private final h Fnj;
  int Fnk;
  a Fnl;
  private int Fnm;
  private int Fnn;
  public int Fno;
  private b<a> Fnq;
  private b<ArrayList<i>> Fnr;
  private k.a Fns;
  private k.a Fnt;
  private k.a Fnu;
  private k.a Fnv;
  private k.a Fnw;
  private k.a Fnx;
  k.a Fny;
  k.a Fnz;
  private boolean Foa;
  private boolean Fob;
  private LinkedList<fcn> Foc;
  public o.b Fod;
  public g Foe;
  LinkedList<acy> Fof;
  private boolean Fog;
  private epj Foh;
  private boolean Foi;
  public Network Foj;
  public ConnectivityManager.NetworkCallback Fok;
  public LinkedList<Integer> Fol;
  Object Fom;
  public Map<Long, fce> Fon;
  private boolean mIsInit;
  int mRoomType;
  private MMHandler mainHandler;
  private final MMHandler opL;
  String peY;
  private String tRV;
  private int tRX;
  private boolean tSA;
  private final int tSB;
  public Runnable tSC;
  public boolean tSm;
  boolean tSp;
  private long tSr;
  public boolean tSt;
  private int tSu;
  public boolean tSw;
  public boolean tSx;
  public boolean tSy;
  private boolean tSz;
  String woU;
  
  static
  {
    AppMethodBeat.i(198569);
    Fne = new o("INSTANCE");
    Foo = new o[] { Fne };
    Fnp = false;
    EMethodGetQosPara = 25;
    AppMethodBeat.o(198569);
  }
  
  private o()
  {
    AppMethodBeat.i(198283);
    this.tRX = 0;
    this.mRoomType = 1;
    this.Fnm = 2;
    this.Fnn = 160;
    this.Fno = 0;
    this.FnT = null;
    this.tSr = -1L;
    this.tSt = false;
    this.tSu = 0;
    this.FnW = "";
    this.FnX = "";
    this.FnY = 4;
    this.FnZ = false;
    this.Foa = false;
    this.Fob = false;
    this.woU = null;
    this.Fod = o.b.FpL;
    this.Foe = null;
    this.FmH = null;
    this.Fof = null;
    this.Fog = false;
    this.Foh = null;
    this.Foi = true;
    this.Foj = null;
    this.Fok = null;
    this.Fol = new LinkedList();
    this.Fom = new Object();
    this.mainHandler = new o.1(this, Looper.getMainLooper());
    this.Fon = new ConcurrentHashMap();
    this.tSy = false;
    this.tSz = false;
    this.tSA = false;
    this.tSB = -9999;
    this.tSC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197344);
        if ((o.F(o.this) == 0) && (!o.af(o.this)))
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          o.a(o.this);
        }
        AppMethodBeat.o(197344);
      }
    };
    this.Fnf = new q();
    this.Fng = new k();
    this.FmD = new j();
    this.Fnh = new e(this.FmD);
    this.Fni = new s(this.FmD);
    this.Fnj = new h();
    this.FnT = new c(ad.eYc());
    this.opL = new MMHandler("ILink_voip_worker");
    this.Fnk = 0;
    this.peY = null;
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.j.a("com.tencent.mm", null, o.c.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      Log.v("MicroMsg.Multitalk.ILinkService", "hy: updatad device info %s", new Object[] { localObject });
      af.KN((String)localObject);
    }
    for (;;)
    {
      this.tSm = false;
      this.mIsInit = false;
      this.FnR = false;
      this.tRX = 0;
      this.mRoomType = 1;
      this.Fnm = 2;
      this.Fnn = 160;
      this.tSp = false;
      this.FnS = null;
      this.Foe = null;
      this.tSw = false;
      this.tSx = false;
      this.FmH = new a();
      this.Fod = o.b.FpL;
      this.Foa = false;
      this.Fof = null;
      this.Fog = false;
      this.tSt = false;
      this.Foh = new epj();
      this.Foj = null;
      this.Fok = null;
      this.Fol.clear();
      com.tencent.pb.common.b.e.ikG().a(214, this);
      AppMethodBeat.o(198283);
      return;
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: can not get device info from mm");
    }
  }
  
  static void I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198474);
    l.H(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(198474);
  }
  
  private void OB(long paramLong)
  {
    AppMethodBeat.i(198424);
    l(this.tSC, paramLong);
    AppMethodBeat.o(198424);
  }
  
  static int U(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(198457);
    paramInt = l.T(paramArrayOfByte, paramInt);
    AppMethodBeat.o(198457);
    return paramInt;
  }
  
  static int V(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(198477);
    paramInt = l.S(paramArrayOfByte, paramInt);
    AppMethodBeat.o(198477);
    return paramInt;
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(198395);
    switch (41.Fpx[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(198395);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(198395);
      return 0;
    case 4: 
      AppMethodBeat.o(198395);
      return 1;
    case 5: 
      AppMethodBeat.o(198395);
      return 6;
    case 6: 
      AppMethodBeat.o(198395);
      return 8;
    }
    AppMethodBeat.o(198395);
    return 7;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(198455);
    paramInt1 = l.a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(198455);
    return paramInt1;
  }
  
  public static t a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(198454);
    paramArrayOfByte = l.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(198454);
    return paramArrayOfByte;
  }
  
  private void a(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(198295);
    this.tSm = false;
    synchronized (this.Fng)
    {
      this.Fng.b(3, this.Fny);
      this.Fng.b(4, this.Fnz);
      this.Fng.b(22, this.FnA);
      this.Fng.b(23, this.FnB);
      this.Fny = null;
      this.Fnz = null;
      this.FnA = null;
      this.FnB = null;
      ??? = this.FmD.eVq();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Fnk = 1;
        AppMethodBeat.o(198295);
        return;
      }
    }
    if (paramInt2 == 15)
    {
      MMHandlerThread.postToMainThread(new c.8(this.FnT));
      AppMethodBeat.o(198295);
      return;
    }
    this.FnT.bF(2, this.FnW);
    AppMethodBeat.o(198295);
  }
  
  static boolean a(i parami)
  {
    AppMethodBeat.i(198460);
    if (l.IC(parami.tQm) > 0)
    {
      AppMethodBeat.o(198460);
      return true;
    }
    AppMethodBeat.o(198460);
    return false;
  }
  
  private int aPI(String paramString)
  {
    AppMethodBeat.i(198353);
    IConfCallBack localIConfCallBack = this.Fng.lW(false);
    int i = l.a(paramString, this.tRX, this.Fnm, this.Fnn, localIConfCallBack);
    this.Fnv = new k.a()
    {
      public final boolean cNB()
      {
        return true;
      }
    };
    this.Fng.a(26, this.Fnv);
    AppMethodBeat.o(198353);
    return i;
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(198398);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.Fnl = parama;
    if (this.tSm)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: current joining room. waiting for exiting after joining");
      this.tSp = true;
      AppMethodBeat.o(198398);
      return -9999;
    }
    if (this.Fnk == 0)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(198398);
      return 0;
    }
    int i = l.ID(a(parama));
    OB(180000L);
    AppMethodBeat.o(198398);
    return i;
  }
  
  private void b(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(198304);
    this.tSm = false;
    synchronized (this.Fng)
    {
      this.Fng.b(5, this.FnC);
      this.Fng.b(6, this.FnD);
      this.Fng.b(22, this.FnA);
      this.Fng.b(23, this.FnB);
      this.Fng.b(7, this.FnG);
      this.FnC = null;
      this.FnD = null;
      this.FnA = null;
      this.FnB = null;
      this.FnG = null;
      ??? = this.FmD.eVq();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Fnk = 1;
        AppMethodBeat.o(198304);
        return;
      }
    }
    this.FnT.bF(16, this.FnW);
    AppMethodBeat.o(198304);
  }
  
  private void c(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(198364);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger InviteSucc: %b %b %b %b %b", new Object[] { Boolean.valueOf(this.tSy), Boolean.valueOf(this.tSz), Boolean.valueOf(this.tSA), Boolean.valueOf(this.FnZ), Boolean.valueOf(this.Foa) });
    if ((this.tSy) && (this.tSA) && (this.tSz) && (this.FnZ) && (!this.Foa))
    {
      if (this.tSp)
      {
        f(paramb);
        AppMethodBeat.o(198364);
        return;
      }
      this.Fni.cNM();
      boolean bool1 = this.Fnh.cNM();
      boolean bool2 = this.Fnh.aeU();
      if ((bool1) && (bool2))
      {
        i = 0;
        n.tRD = i;
        if (!bool1) {
          break label220;
        }
        i = 0;
        label169:
        n.tRF = i;
        if (!bool2) {
          break label231;
        }
      }
      label220:
      label231:
      for (int i = 0;; i = this.Fnh.eVo())
      {
        n.tRE = i;
        if ((!bool1) || (!bool2)) {
          break label242;
        }
        b(paramb, 0, 0, "ok");
        this.Foa = true;
        AppMethodBeat.o(198364);
        return;
        i = 1;
        break;
        i = this.Fnh.eVp();
        break label169;
      }
      label242:
      e(paramb);
    }
    AppMethodBeat.o(198364);
  }
  
  private void cNF()
  {
    AppMethodBeat.i(198387);
    this.FmD.tRa.clear();
    this.FmD.eVr();
    this.Fnh.release();
    this.Fni.release();
    synchronized (this.Fng)
    {
      this.Fng.b(24, this.Fns);
      this.Fng.b(27, this.Fnx);
      this.Fng.b(25, this.Fnt);
      this.Fng.b(20, this.Fnu);
      this.Fns = null;
      this.Fnt = null;
      this.Fnu = null;
      this.Fnv = null;
      this.Fnx = null;
      AppMethodBeat.o(198387);
      return;
    }
  }
  
  private void e(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(198373);
    this.FnT.bF(4, this.FnW);
    a(paramb, -10086, -7, "start audio device failed");
    b(a.FpF);
    AppMethodBeat.o(198373);
  }
  
  private int eVC()
  {
    AppMethodBeat.i(198430);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.TRUE });
    eVz();
    this.Fnf.asv(this.peY);
    n.tRD = 0;
    n.tRE = 0;
    n.tRF = 0;
    n.tRG = 0;
    n.tRH = 0;
    n.tRI = 0;
    n.tRJ = 0;
    n.tRK = 0;
    n.tRL = 0;
    this.peY = null;
    this.tRV = null;
    cNF();
    this.mIsInit = false;
    this.FnR = false;
    this.Foa = false;
    this.tSm = false;
    m.Fna.cPS();
    AppMethodBeat.o(198430);
    return 0;
  }
  
  private void eVJ()
  {
    AppMethodBeat.i(198493);
    Log.i("MicroMsg.Multitalk.ILinkService", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.Fok != null) {
        Log.i("MicroMsg.Multitalk.ILinkService", "unregister networkcallback hashCode: " + this.Fok.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.Fok);
      this.Fok = null;
      this.Foj = null;
      AppMethodBeat.o(198493);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
      }
    }
  }
  
  public static int eVt()
  {
    AppMethodBeat.i(198473);
    int i = l.eVt();
    AppMethodBeat.o(198473);
    return i;
  }
  
  private void eVy()
  {
    AppMethodBeat.i(198308);
    synchronized (this.Fng)
    {
      this.Fng.b(8, this.FnH);
      this.Fng.b(9, this.FnI);
      this.Fng.b(11, this.FnJ);
      this.Fng.b(16, this.FnO);
      this.FnH = null;
      this.FnI = null;
      this.FnJ = null;
      this.FnO = null;
      AppMethodBeat.o(198308);
      return;
    }
  }
  
  private void eVz()
  {
    AppMethodBeat.i(198349);
    if ((this.mIsInit) || (this.FnR))
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "uninitEngine called!");
      this.Fnf.asv(this.peY);
      this.FmD.ata();
      this.Fnh.release();
      this.Fni.release();
      this.Fno = 0;
      Fnp = false;
      this.Fng.lW(true);
      this.mIsInit = false;
      this.FnR = false;
      m.Fna.cPS();
      this.FnZ = false;
      this.Fob = false;
      this.Foa = false;
      this.tSm = false;
      if (this.Fof != null)
      {
        this.Fof.clear();
        this.Fof = null;
      }
      eVJ();
      this.Foj = null;
      this.Fok = null;
      this.Fol.clear();
      cNE();
      l.cND();
    }
    AppMethodBeat.o(198349);
  }
  
  public static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(198475);
    paramInt1 = l.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(198475);
    return paramInt1;
  }
  
  private void f(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(198375);
    Log.w("MicroMsg.Multitalk.ILinkService", "hy: require exit. try exit exit again");
    a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
    int i = b(this.Fnl);
    if (this.FnS != null)
    {
      if (i != 0) {
        break label82;
      }
      this.FnS.a(0, 0, "ok", "");
    }
    for (;;)
    {
      this.tSp = false;
      this.FnS = null;
      AppMethodBeat.o(198375);
      return;
      label82:
      this.FnS.a(-10086, -17, "exit failed", "");
    }
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(198392);
    this.opL.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(198392);
  }
  
  public final void F(long paramLong, String paramString)
  {
    AppMethodBeat.i(198286);
    this.FnU = paramString;
    this.FnV = paramLong;
    Log.i("MicroMsg.Multitalk.ILinkService", "set name=%s, uin=%d", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(198286);
  }
  
  final void IH(int paramInt)
  {
    AppMethodBeat.i(198478);
    this.FnY = paramInt;
    l.IE(paramInt);
    AppMethodBeat.o(198478);
  }
  
  public final int Xm(int paramInt)
  {
    AppMethodBeat.i(198422);
    paramInt = this.FmD.Xm(paramInt);
    AppMethodBeat.o(198422);
    return paramInt;
  }
  
  public final void Xp(final int paramInt)
  {
    AppMethodBeat.i(198335);
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197431);
        l.Xn(paramInt);
        AppMethodBeat.o(197431);
      }
    });
    AppMethodBeat.o(198335);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(198496);
    if (paramd != null) {}
    Object localObject;
    for (paramString = Integer.valueOf(paramd.getType());; paramString = "")
    {
      Log.d("MicroMsg.Multitalk.ILinkService", "CLTNOT onNetSceneEnd errCode:", new Object[] { Integer.valueOf(paramInt2), " errType: ", Integer.valueOf(paramInt1), " scene.getType(): ", paramString });
      if (paramd.getType() != 214) {
        break label169;
      }
      paramString = (a.aj)paramd.Zej;
      localObject = (com.tencent.wecall.talkroom.a.m)paramd;
      if (((com.tencent.wecall.talkroom.a.m)localObject).ZXT != 0) {
        break;
      }
      Log.d("MicroMsg.Multitalk.ILinkService", "handleSwitchVideoGroup, but old multitalk event");
      AppMethodBeat.o(198496);
      return;
    }
    if ((paramString.ZgL == 1) && (((com.tencent.wecall.talkroom.a.m)localObject).wDk == 103))
    {
      paramd = this.FnT;
      localObject = ((com.tencent.wecall.talkroom.a.m)localObject).ZXU;
      paramInt1 = paramString.ZgM;
      paramd.Fmu.ay((String)localObject, paramInt2, paramInt1);
    }
    label169:
    AppMethodBeat.o(198496);
  }
  
  public final void a(final b<String> paramb)
  {
    AppMethodBeat.i(198344);
    Log.i("MicroMsg.Multitalk.ILinkService", "steve: initsession : isInit :%b ", new Object[] { Boolean.valueOf(this.mIsInit) });
    if ((this.mIsInit) && (this.Fnk == 0)) {
      eVz();
    }
    if (!this.mIsInit)
    {
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new fbw();
      ((d.a)localObject).lBV = new fbx();
      ((d.a)localObject).funcId = 573;
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetauthcode";
      ((d.a)localObject).lBW = 0;
      ((d.a)localObject).respCmdId = 0;
      localObject = ((d.a)localObject).bgN();
      d.b.b(((com.tencent.mm.an.d)localObject).lBR);
      IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
      {
        public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.an.d paramAnonymousd)
        {
          AppMethodBeat.i(196772);
          o.this.am(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203692);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (d.c.b(paramAnonymousd.lBS) == null))
              {
                Log.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
                AppMethodBeat.o(203692);
                return;
              }
              String str = ((fbx)d.c.b(paramAnonymousd.lBS)).UCa.Ap();
              o.h(o.this, new k.a()
              {
                public final boolean cNB()
                {
                  return true;
                }
              });
              o.i(o.this, new k.a()
              {
                public final boolean cNB()
                {
                  return true;
                }
              });
              o.o(o.this).a(1, o.B(o.this));
              o.o(o.this).a(2, o.D(o.this));
              int i = o.d(o.this, str);
              if (i != 0)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "initEngine failed ret=%d", new Object[] { Integer.valueOf(i) });
                if (o.6.this.FoE != null) {
                  o.6.this.FoE.a(-10086, -3, "initengine failed", "");
                }
                AppMethodBeat.o(203692);
                return;
              }
              AppMethodBeat.o(203692);
            }
          });
          AppMethodBeat.o(196772);
        }
      });
      AppMethodBeat.o(198344);
      return;
    }
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204550);
        m.Fna.cPR();
        if (paramb != null) {
          paramb.a(0, 0, null, null);
        }
        AppMethodBeat.o(204550);
      }
    });
    AppMethodBeat.o(198344);
  }
  
  public final void aG(final ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(198412);
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201860);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(201860);
          return;
        }
        if (paramArrayList == null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(201860);
          return;
        }
        if ((paramArrayList.size() == 1) && (!this.Fpq))
        {
          o.this.eVB();
          AppMethodBeat.o(201860);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label151:
        Integer localInteger;
        epk localepk;
        if (this.Fpq)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          Iterator localIterator = paramArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label275;
          }
          localInteger = (Integer)localIterator.next();
          localepk = new epk();
          localepk.SoO = localInteger.intValue();
          localepk.Usi = i;
          int j = o.this.Xm(localInteger.intValue());
          if ((j != 102) && (j != 101)) {
            break label265;
          }
          localepk.Usi = 240;
          localLinkedList2.add(localepk);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localInteger });
          break label151;
          i = 480;
          break;
          label265:
          localLinkedList1.add(localepk);
        }
        label275:
        o.ag(o.this).Crl = localLinkedList1;
        if (ad.eYc().eXm().Fta) {}
        for (o.ag(o.this).Ush = localLinkedList2;; o.ag(o.this).Ush = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUserMids, videoMembers %s", new Object[] { o.ag(o.this) });
          l.a(o.ag(o.this));
          AppMethodBeat.o(201860);
          return;
        }
      }
    });
    AppMethodBeat.o(198412);
  }
  
  public final void aJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(198486);
    Log.i("MicroMsg.Multitalk.ILinkService", "start bindSocket " + paramInt + " ToNetwork " + this.Foj + " rebind " + paramBoolean);
    if (paramInt == -1) {
      eVJ();
    }
    if (!paramBoolean) {
      this.Fol.add(Integer.valueOf(paramInt));
    }
    if ((this.Foj != null) && (com.tencent.mm.compatible.util.d.qV(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.Foj.bindSocket(localFileDescriptor);
        Log.d("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork success: network" + this.Foj + "+socketfd" + paramInt);
        AppMethodBeat.o(198486);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(198486);
  }
  
  public final int aPJ(String paramString)
  {
    AppMethodBeat.i(198410);
    int i = -1;
    paramString = this.FmD.aPH(paramString);
    if (paramString != null) {
      i = paramString.tQm;
    }
    AppMethodBeat.o(198410);
    return i;
  }
  
  public final void aPK(final String paramString)
  {
    AppMethodBeat.i(198436);
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195726);
        com.tencent.wecall.talkroom.a.m localm = new com.tencent.wecall.talkroom.a.m("", 0, 0L, 103, o.b(o.this), 1, paramString, this.Fpw);
        boolean bool = com.tencent.pb.common.b.e.ikG().b(localm);
        Log.d("MicroMsg.Multitalk.ILinkService", "DoScreenSharingSecurityCheck fileMd5 %s fileId %s ret: %b", new Object[] { paramString, this.Fpw, Boolean.valueOf(bool) });
        AppMethodBeat.o(195726);
      }
    });
    AppMethodBeat.o(198436);
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(198389);
    if (this.opL.getSerialTag().equals(com.tencent.e.j.a.iqg()))
    {
      paramRunnable.run();
      AppMethodBeat.o(198389);
      return;
    }
    this.opL.post(paramRunnable);
    AppMethodBeat.o(198389);
  }
  
  final void b(b<ArrayList<i>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(198362);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger JoinSucc: %b %b %b", new Object[] { Boolean.valueOf(this.tSy), Boolean.valueOf(this.tSz), Boolean.valueOf(this.tSA) });
    if ((this.tSy) && (this.tSA) && (this.tSz))
    {
      if (this.tSp)
      {
        f(paramb);
        AppMethodBeat.o(198362);
        return;
      }
      this.Fni.cNM();
      boolean bool1 = this.Fnh.cNM();
      boolean bool2 = this.Fnh.aeU();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      n.tRD = i;
      if (bool1)
      {
        i = 0;
        n.tRF = i;
        if (!bool2) {
          break label197;
        }
      }
      label197:
      for (i = 0;; i = this.Fnh.eVo())
      {
        n.tRE = i;
        if ((!bool1) || (!bool2)) {
          break label208;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(198362);
        return;
        i = this.Fnh.eVp();
        break;
      }
      label208:
      e(paramb);
    }
    AppMethodBeat.o(198362);
  }
  
  public final void cNE()
  {
    this.tSy = false;
    this.tSz = false;
    this.tSA = false;
  }
  
  public final void cNH()
  {
    AppMethodBeat.i(198435);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStop");
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199070);
        if (!o.ai(o.this))
        {
          AppMethodBeat.o(199070);
          return;
        }
        o.d(o.this, false);
        l.b(o.ah(o.this), o.ai(o.this), o.aj(o.this));
        AppMethodBeat.o(199070);
      }
    });
    AppMethodBeat.o(198435);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198334);
    fbt localfbt = new fbt();
    try
    {
      localfbt.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.Multitalk.ILinkService", "got banner msg from wxgroupid %s sdkgroupid %s roomid %d seq %d status %d", new Object[] { localfbt.UBS, localfbt.UBT, Long.valueOf(localfbt.SoR), Long.valueOf(localfbt.UBV), Integer.valueOf(localfbt.UBW) });
      if (((localfbt.UBT == null) || (localfbt.UBT.equals(""))) && (localfbt.UBW != 0))
      {
        AppMethodBeat.o(198334);
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(198334);
      return;
    }
    ad.eYc().fn(localfbt.UBS, 2);
    paramArrayOfByte = this.FnT;
    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onMultiTalkBannerChange:%s, status:%d, banner seq:%d", new Object[] { localfbt.UBS, Integer.valueOf(localfbt.UBW), Long.valueOf(localfbt.UBV) });
    String str = localfbt.UBS;
    if ((localfbt.UBS == null) || (localfbt.UBS == ""))
    {
      AppMethodBeat.o(198334);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "userName is null");
          AppMethodBeat.o(198334);
          return;
        }
        localObject2 = localfbt.UBX;
        localObject3 = ad.eXY().aPU(str);
        if (localObject3 == null) {
          break label1485;
        }
        i = 1;
        if ((localfbt.UBW != 0) && (localObject3 != null) && (((com.tencent.mm.bj.f)localObject3).field_ilinkRoomId != 0L) && (localfbt.SoR != ((com.tencent.mm.bj.f)localObject3).field_ilinkRoomId))
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that roomid not mathced wxgroupid %s roomid %d cached roomid %d", new Object[] { str, Long.valueOf(localfbt.SoR), Long.valueOf(((com.tencent.mm.bj.f)localObject3).field_ilinkRoomId) });
          AppMethodBeat.o(198334);
          return;
        }
        if ((paramArrayOfByte.Fmw.containsKey(str)) && (localfbt.UBV < ((Long)paramArrayOfByte.Fmw.get(str)).longValue()))
        {
          if (localfbt.UBW == 2)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that expired wxgroupid %s roomid %d seq %d cached seq %d", new Object[] { str, Long.valueOf(localfbt.SoR), Long.valueOf(localfbt.UBV), paramArrayOfByte.Fmw.get(str) });
            AppMethodBeat.o(198334);
            return;
          }
          if ((localfbt.UBW == 1) && (paramArrayOfByte.Fmw != null) && (paramArrayOfByte.Fmw.size() > 0))
          {
            paramArrayOfByte.Fmw.remove(str);
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "remove bannerMsgTimeMap success at begin");
          }
          if ((localfbt.UBW != 0) || (i != 1)) {
            break label729;
          }
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "get WxVoiceBannerEnd,dismiss bar!");
          if ((!ad.eYf().aQu(str)) && (ad.eYf().eXJ().contains(str)) && (ad.eYf().iW(str, (String)localObject1)))
          {
            ad.eYc();
            com.tencent.mm.plugin.multitalk.model.q.aQq(str);
          }
          ad.eYc().aQp(str);
          ad.eYc().aQk(str);
          ad.eYf().aQa(str);
          ad.eYf().aQt(str);
          ad.eYf().eXJ().remove(str);
          if ((paramArrayOfByte.Fmw == null) || (paramArrayOfByte.Fmw.size() <= 0)) {
            break label1478;
          }
          paramArrayOfByte.Fmw.remove(str);
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "remove bannerMsgTimeMap success at end");
          AppMethodBeat.o(198334);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "parse  bannerinfo  failure! xml" + paramArrayOfByte.toString());
        AppMethodBeat.o(198334);
        return;
      }
      paramArrayOfByte.Fmw.put(str, Long.valueOf(localfbt.UBV));
      continue;
      label729:
      if (localfbt.UBW == 1)
      {
        i = 0;
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "The count of banner member is %d, groupid[%s]", new Object[] { Integer.valueOf(localfbt.UBU.size()), str });
        localObject3 = localfbt.UBU.iterator();
        paramArrayOfByte = "";
        while (((Iterator)localObject3).hasNext())
        {
          fco localfco = (fco)((Iterator)localObject3).next();
          if (!localfco.UCk.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + localfco.UCk.username + ",";
          }
          else
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", new Object[] { "" });
            i = 1;
          }
        }
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(paramArrayOfByte)));
        if (i == 0)
        {
          ad.eYf().aQt(str);
          ad.eYf().eXJ().remove(str);
          if (!((String)localObject1).equals(localObject2)) {
            break label1003;
          }
          ad.eYc().c(str, (String)localObject2, false, false);
        }
        for (;;)
        {
          ad.eYf().a(str, localfbt);
          ad.eYb().Frw.ds(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().kcw.get(1)), z.bcZ());
          AppMethodBeat.o(198334);
          return;
          ad.eYf().eXJ().contains(str);
          break;
          label1003:
          if (i != 0) {
            ad.eYc().c(str, (String)localObject2, false, false);
          } else {
            ad.eYc().c(str, (String)localObject2, true, false);
          }
        }
      }
      if (localfbt.UBW == 2)
      {
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange!2,member size : " + localfbt.UBU.size());
        i = 0;
        localObject2 = localfbt.UBU.iterator();
        paramArrayOfByte = "";
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (fco)((Iterator)localObject2).next();
          if (!((fco)localObject3).UCk.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + ((fco)localObject3).UCk.username + ",";
          }
          else
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", new Object[] { "" });
            i = 1;
          }
        }
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(paramArrayOfByte)));
        if (i == 0)
        {
          if ((!ad.eYf().aQu(str)) && (ad.eYf().eXJ().contains(str)) && (ad.eYf().iW(str, (String)localObject1)))
          {
            ad.eYc();
            com.tencent.mm.plugin.multitalk.model.q.aQq(str);
          }
          ad.eYf().aQt(str);
          ad.eYf().eXJ().remove(str);
        }
        for (;;)
        {
          ad.eYb().Frw.ds(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().kcw.get(1)), z.bcZ());
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          paramArrayOfByte = ad.eYf();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { str });
          localObject1 = ad.eXY().aPU(str);
          if (localObject1 == null) {
            break label1462;
          }
          if (((com.tencent.mm.bj.f)localObject1).field_ilinkRoomId == localfbt.SoR) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bj.f)localObject1).field_roomId + "bannerinfo.roomid:" + localfbt.SoR);
          AppMethodBeat.o(198334);
          return;
          ad.eYf().eXJ().contains(str);
        }
        if (!com.tencent.mm.plugin.multitalk.model.s.b(str, localfbt))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(198334);
          return;
        }
        paramArrayOfByte.aQv(str);
        AppMethodBeat.o(198334);
        return;
        label1462:
        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        paramArrayOfByte.a(str, localfbt);
      }
      label1478:
      AppMethodBeat.o(198334);
      return;
      label1485:
      int i = 0;
    }
  }
  
  public final void d(b<ArrayList<i>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(198370);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger AcceptSucc: %b %b %b", new Object[] { Boolean.valueOf(this.tSy), Boolean.valueOf(this.tSz), Boolean.valueOf(this.tSA) });
    if ((this.tSy) && (this.tSA) && (this.tSz))
    {
      if (this.tSp)
      {
        f(paramb);
        AppMethodBeat.o(198370);
        return;
      }
      this.Fni.cNM();
      boolean bool1 = this.Fnh.cNM();
      boolean bool2 = this.Fnh.aeU();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      n.tRD = i;
      if (bool1)
      {
        i = 0;
        n.tRF = i;
        if (!bool2) {
          break label193;
        }
      }
      label193:
      for (i = 0;; i = this.Fnh.eVo())
      {
        n.tRE = i;
        if ((!bool1) || (!bool2)) {
          break label204;
        }
        il(0, 0);
        AppMethodBeat.o(198370);
        return;
        i = this.Fnh.eVp();
        break;
      }
      label204:
      e(paramb);
    }
    AppMethodBeat.o(198370);
  }
  
  public final void d(ArrayList<String> paramArrayList, final boolean paramBoolean)
  {
    AppMethodBeat.i(198420);
    if (this.Fnk != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.Fnk) });
      AppMethodBeat.o(198420);
      return;
    }
    final ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = this.FmD.aPH((String)localObject);
        if (localObject != null) {
          localArrayList.add(Integer.valueOf(((i)localObject).tQm));
        }
      }
    }
    Log.i("MicroMsg.Multitalk.ILinkService", "subscribeScreenByUsernames, screen midlist:%s,memberName%s", new Object[] { localArrayList, paramArrayList });
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200744);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(200744);
          return;
        }
        LinkedList localLinkedList1 = new LinkedList();
        LinkedList localLinkedList2 = new LinkedList();
        Object localObject1;
        Object localObject2;
        epk localepk;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            localepk = new epk();
            localepk.SoO = ((Integer)localObject2).intValue();
            localepk.Usi = this.Fpt;
            localLinkedList2.add(localepk);
            Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localObject2 });
          }
        }
        if (paramBoolean)
        {
          localObject1 = o.d(o.this).eVq();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (i)((Iterator)localObject1).next();
              if (o.u(o.this).equals(((i)localObject2).iSn))
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(((i)localObject2).tQm), ((i)localObject2).iSn });
              }
              else
              {
                int i = ((i)localObject2).tQm;
                localepk = new epk();
                localepk.SoO = i;
                localepk.Usi = 480;
                int j = o.this.Xm(i);
                if ((j == 102) || (j == 101))
                {
                  localepk.Usi = 240;
                  localLinkedList2.add(localepk);
                }
                for (;;)
                {
                  Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), ((i)localObject2).iSn });
                  break;
                  localLinkedList1.add(localepk);
                }
              }
            }
          }
        }
        o.ag(o.this).Crl = localLinkedList1;
        if (ad.eYc().eXm().Fta) {}
        for (o.ag(o.this).Ush = localLinkedList2;; o.ag(o.this).Ush = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeScreenByUserMids, videoMembers %s", new Object[] { o.ag(o.this) });
          l.a(o.ag(o.this));
          AppMethodBeat.o(200744);
          return;
        }
      }
    });
    AppMethodBeat.o(198420);
  }
  
  public final void e(final ArrayList<i> paramArrayList, final String paramString)
  {
    AppMethodBeat.i(198290);
    Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkInvite. %s, %s", new Object[] { paramArrayList, paramString });
    this.FnW = paramString;
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196218);
        o localo = o.this;
        ArrayList localArrayList = paramArrayList;
        String str = paramString;
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter inviteSync. %s, %s", new Object[] { localArrayList, str });
        if ((localo.Fnk == 1) || (localo.tSm))
        {
          Log.w("MicroMsg.Multitalk.ILinkService", "hy: already in room or joining room!");
          AppMethodBeat.o(196218);
          return;
        }
        localo.FmD.ata();
        localo.FmD.FmO = str;
        localo.FmD.FmP = str;
        localo.woU = localo.FnU;
        localo.peY = new String("wechat");
        localo.Fnl = o.a.FpJ;
        localo.tSt = false;
        localo.tSm = true;
        localo.tSp = false;
        localo.Fod = o.b.FpM;
        localo.a(new o.33(localo, localArrayList));
        AppMethodBeat.o(196218);
      }
    });
    AppMethodBeat.o(198290);
  }
  
  final void eVA()
  {
    AppMethodBeat.i(198382);
    this.Fnu = new k.a()
    {
      private static adi bw(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195703);
        adi localadi = new adi();
        try
        {
          localadi.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(195703);
          return localadi;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(195703);
        }
        return null;
      }
      
      public final boolean cNB()
      {
        return true;
      }
    };
    this.Fng.a(20, this.Fnu);
    this.Fnw = new k.a()
    {
      private static acz bx(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(200588);
        acz localacz = new acz();
        try
        {
          localacz.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(200588);
          return localacz;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(200588);
        }
        return null;
      }
      
      public final boolean cNB()
      {
        return true;
      }
    };
    this.Fng.a(21, this.Fnw);
    this.Fns = new k.a()
    {
      public final boolean cNB()
      {
        return true;
      }
    };
    this.Fng.a(24, this.Fns);
    this.Fnt = new k.a()
    {
      private static byte[] a(adb paramAnonymousadb)
      {
        AppMethodBeat.i(203792);
        if (paramAnonymousadb != null) {
          try
          {
            paramAnonymousadb = paramAnonymousadb.toByteArray();
            AppMethodBeat.o(203792);
            return paramAnonymousadb;
          }
          catch (IOException paramAnonymousadb)
          {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousadb, "hy: error when convert to byte array", new Object[0]);
          }
        }
        AppMethodBeat.o(203792);
        return new byte[0];
      }
      
      public final boolean cNB()
      {
        return true;
      }
    };
    this.Fng.a(25, this.Fnt);
    j localj = this.FmD;
    j.a local17 = new j.a()
    {
      public final void R(final ArrayList<i> paramAnonymousArrayList)
      {
        AppMethodBeat.i(207206);
        Log.v("MicroMsg.Multitalk.ILinkService", "hy: current talking members are %s", new Object[] { paramAnonymousArrayList });
        o.this.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200011);
            if (o.F(o.this) != 1)
            {
              Log.w("MicroMsg.Multitalk.ILinkService", "hy: onSpeakerListChanged but not in room!");
              AppMethodBeat.o(200011);
              return;
            }
            if (o.ac(o.this) != null) {
              o.ac(o.this).a(0, 0, "on talklist change", paramAnonymousArrayList);
            }
            AppMethodBeat.o(200011);
          }
        });
        AppMethodBeat.o(207206);
      }
    };
    synchronized (localj.tRe)
    {
      localj.tRe.add(local17);
      ??? = this.FmD;
      ((j)???).tRf = com.tencent.e.h.ZvG.b(((j)???).FmV, 1000L, 1000L);
      this.Fnx = new k.a()
      {
        public final boolean cNB()
        {
          return true;
        }
      };
      this.Fng.a(27, this.Fnx);
      AppMethodBeat.o(198382);
      return;
    }
  }
  
  public final void eVB()
  {
    AppMethodBeat.i(198407);
    if (this.Fnk != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.Fnk) });
      AppMethodBeat.o(198407);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.FmD.eVq();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(198407);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      if (this.FnU.equals(locali.iSn))
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(locali.tQm), locali.iSn });
      }
      else
      {
        int i = locali.tQm;
        epk localepk = new epk();
        localepk.SoO = i;
        localepk.Usi = 480;
        int j = Xm(i);
        if ((j == 102) || (j == 101))
        {
          localepk.Usi = 240;
          localLinkedList2.add(localepk);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), locali.iSn });
          break;
          localLinkedList1.add(localepk);
        }
      }
    }
    this.Foh.Crl = localLinkedList1;
    if (ad.eYc().eXm().Fta) {}
    for (this.Foh.Ush = localLinkedList2;; this.Foh.Ush = null)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribe, videoMembers %s", new Object[] { localArrayList });
      l.a(this.Foh);
      AppMethodBeat.o(198407);
      return;
    }
  }
  
  public final s eVD()
  {
    return this.Fni;
  }
  
  public final List<String> eVE()
  {
    AppMethodBeat.i(198463);
    Object localObject = this.FmD.eVq();
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(198463);
      return null;
    }
    if (this.Fnk != 1)
    {
      AppMethodBeat.o(198463);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      if (a(locali))
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(locali.tQm), locali.iSn });
        localArrayList.add(locali.iSn);
      }
    }
    AppMethodBeat.o(198463);
    return localArrayList;
  }
  
  public final Map<String, Integer> eVF()
  {
    AppMethodBeat.i(198467);
    Object localObject = this.FmD.eVq();
    HashMap localHashMap = new HashMap();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(198467);
      return null;
    }
    if (this.Fnk != 1)
    {
      AppMethodBeat.o(198467);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      int i = l.IC(locali.tQm);
      if (i > 0)
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingEnergyMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(locali.tQm), locali.iSn });
        localHashMap.put(locali.iSn, Integer.valueOf(i));
      }
    }
    AppMethodBeat.o(198467);
    return localHashMap;
  }
  
  public final List<String> eVG()
  {
    AppMethodBeat.i(198472);
    Object localObject = this.FmD.eVq();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (this.Fnk == 1))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        byte[] arrayOfByte = new byte[4];
        if (l.Z(arrayOfByte, locali.tQm) >= 0)
        {
          int i = Util.byteArrayToInt(arrayOfByte);
          Log.d("MicroMsg.Multitalk.ILinkService", "netStatus: %d", new Object[] { Integer.valueOf(i) });
          if ((i != -1) && (i <= 3)) {
            localArrayList.add(locali.iSn);
          }
        }
      }
    }
    AppMethodBeat.o(198472);
    return localArrayList;
  }
  
  final void eVH()
  {
    AppMethodBeat.i(198480);
    m localm = m.Fna;
    this.FnY = m.eVw();
    AppMethodBeat.o(198480);
  }
  
  public final void eVI()
  {
    AppMethodBeat.i(198483);
    Log.i("MicroMsg.Multitalk.ILinkService", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.qV(21))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      Object localObject = new NetworkRequest.Builder();
      ((NetworkRequest.Builder)localObject).addTransportType(0);
      ((NetworkRequest.Builder)localObject).addCapability(12);
      localObject = ((NetworkRequest.Builder)localObject).build();
      Log.i("MicroMsg.Multitalk.ILinkService", "NetworkRequest toString: " + ((NetworkRequest)localObject).toString() + " hashCode: " + ((NetworkRequest)localObject).hashCode());
      try
      {
        localConnectivityManager.requestNetwork((NetworkRequest)localObject, new ConnectivityManager.NetworkCallback()
        {
          public final void onAvailable(Network paramAnonymousNetwork)
          {
            int i = 0;
            AppMethodBeat.i(200101);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            Log.i("MicroMsg.Multitalk.ILinkService", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.qV(28)) {
              localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            }
            try
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference ret ".concat(String.valueOf(((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork))));
              o.this.Foj = paramAnonymousNetwork;
              if (o.this.Fol != null) {
                while (i < o.this.Fol.size())
                {
                  o.this.aJ(((Integer)o.this.Fol.get(i)).intValue(), true);
                  i += 1;
                }
              }
              return;
            }
            catch (Exception paramAnonymousNetwork)
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference  Error");
              try
              {
                ((ConnectivityManager)localObject).unregisterNetworkCallback(this);
                AppMethodBeat.o(200101);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
                AppMethodBeat.o(200101);
                return;
              }
              o.this.Fok = this;
              Log.i("MicroMsg.Multitalk.ILinkService", "networkcallback hashCode: " + o.this.Fok.hashCode());
              AppMethodBeat.o(200101);
            }
          }
        });
        AppMethodBeat.o(198483);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "missing the appropriate permissions");
        AppMethodBeat.o(198483);
        return;
      }
    }
    AppMethodBeat.o(198483);
  }
  
  public final com.tencent.mm.plugin.multitalk.a.b eVx()
  {
    AppMethodBeat.i(198257);
    Object localObject = this.Fnh;
    if (((e)localObject).FmE == null)
    {
      ((e)localObject).FmE = new com.tencent.mm.plugin.multitalk.a.a();
      ad.eYc().Fsp = ((e)localObject).FmE;
    }
    localObject = ((e)localObject).FmE;
    AppMethodBeat.o(198257);
    return localObject;
  }
  
  public final int g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(198453);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.tSw)
    {
      if (l.e(EMethodGetQosPara, this.FmH.s2p, this.FmH.s2p.length) >= 0)
      {
        localObject1 = this.FmH;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).tQn = ((ByteBuffer)localObject2).get();
        ((a)localObject1).tQo = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = this.FmH;
        Log.d("ILink[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        Log.d("ILink[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).tQn + ", HWEnable:" + ((a)localObject1).tQo + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (this.tSw) {
        if (8 == this.FmH.tQn)
        {
          this.tSx = true;
          if (this.FmH.tQo == 0)
          {
            this.tSw = false;
            this.tSx = false;
          }
          if ((1 != this.FmH.cSkipFlag) && (this.tSw) && (this.tSx)) {
            break label470;
          }
          i = -1;
          if (i >= 0) {
            break label854;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      label407:
      if (this.tSx)
      {
        if ((this.Foe == null) || (i != 0)) {
          break label898;
        }
        paramInt1 = this.Foe.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if (paramInt1 >= 0) {
          paramInt1 = j;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198453);
        return paramInt1;
        this.tSx = false;
        break;
        this.tSx = false;
        break;
        label470:
        if ((this.tSw) && (this.Foe == null)) {
          this.Foe = new g(this.FmH.cFps, this.FmH.iKbps, "video/avc");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject1 = this.Foe;
          localObject2 = this.FmH;
          if ((((g)localObject1).FmH != null) && (((g)localObject1).tQL != null))
          {
            a locala = ((g)localObject1).FmH;
            locala.iKbps = ((a)localObject2).iKbps;
            locala.cFps = ((a)localObject2).cFps;
            locala.cIPeriod = ((a)localObject2).cIPeriod;
            locala.cResolution = ((a)localObject2).cResolution;
            locala.tQn = ((a)localObject2).tQn;
            locala.tQo = ((a)localObject2).tQo;
            locala.cSkipFlag = ((a)localObject2).cSkipFlag;
            locala.cIReqFlag = ((a)localObject2).cIReqFlag;
            locala.cRsvd1 = ((a)localObject2).cRsvd1;
            i = (int)(((g)localObject1).FmH.iKbps * 1.1D);
            if (((g)localObject1).m_br_kbps != i)
            {
              ((g)localObject1).SetBitRate(i);
              Log.i("ILink[HWEnc]", "steve[QoS]: Update BR! frameID: " + g.frameID + ", new_br: " + ((g)localObject1).m_br_kbps + ", tuneBR:" + i);
              ((g)localObject1).m_br_kbps = i;
            }
            if ((1 == ((g)localObject1).FmH.cIReqFlag) && (g.frameID > 0))
            {
              if (((g)localObject1).tQL != null)
              {
                Log.v("ILink[HWEnc]", "steve: Sync frame request soon!");
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("request-sync", 0);
                ((g)localObject1).tQL.setParameters((Bundle)localObject2);
              }
              Log.i("ILink[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + g.frameID);
            }
            if (((g)localObject1).FmH.cFps != ((g)localObject1).m_framerate) {
              ((g)localObject1).m_framerate = ((g)localObject1).FmH.cFps;
            }
          }
        }
        label854:
        i = 0;
        break label407;
        Log.e("MicroMsg.Multitalk.ILinkService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        this.tSx = false;
        paramInt1 = -1;
        continue;
        paramInt1 = l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        continue;
        label898:
        paramInt1 = -1;
      }
      i = 0;
    }
  }
  
  public final void il(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198306);
    this.tSm = false;
    synchronized (this.Fng)
    {
      this.Fng.b(14, this.FnM);
      this.Fng.b(15, this.FnN);
      this.Fng.b(22, this.FnA);
      this.Fng.b(23, this.FnB);
      this.FnM = null;
      this.FnN = null;
      this.FnA = null;
      this.FnB = null;
      eVy();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Fnk = 1;
        AppMethodBeat.o(198306);
        return;
      }
    }
    this.FnT.bF(2, this.FnW);
    AppMethodBeat.o(198306);
  }
  
  public final void lY(final boolean paramBoolean)
  {
    AppMethodBeat.i(198432);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "onMicSwitch: %s", new Object[] { str });
      am(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201536);
          if (paramBoolean == o.ah(o.this))
          {
            AppMethodBeat.o(201536);
            return;
          }
          o.c(o.this, paramBoolean);
          AppMethodBeat.o(201536);
        }
      });
      AppMethodBeat.o(198432);
      return;
    }
  }
  
  public final void s(final Integer paramInteger)
  {
    AppMethodBeat.i(198414);
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195976);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(195976);
          return;
        }
        if (paramInteger.intValue() < 0)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(195976);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        epk localepk;
        if (this.Fpq)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          localepk = new epk();
          localepk.SoO = paramInteger.intValue();
          localepk.Usi = i;
          i = o.this.Xm(paramInteger.intValue());
          if ((i != 102) && (i != 101)) {
            break label279;
          }
          localLinkedList2.add(localepk);
          label174:
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeOneByUserMid, videoMembers memberId:%d", new Object[] { paramInteger });
          o.ag(o.this).Crl = localLinkedList1;
          if (!ad.eYc().eXm().Fta) {
            break label289;
          }
          localepk.Usi = 240;
        }
        label279:
        label289:
        for (o.ag(o.this).Ush = localLinkedList2;; o.ag(o.this).Ush = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeOneByUserMid, videoMembers %s", new Object[] { o.ag(o.this) });
          l.a(o.ag(o.this));
          AppMethodBeat.o(195976);
          return;
          i = 480;
          break;
          localLinkedList1.add(localepk);
          break label174;
        }
      }
    });
    AppMethodBeat.o(198414);
  }
  
  public final void ux(boolean paramBoolean)
  {
    AppMethodBeat.i(198255);
    try
    {
      this.Fnh.release();
      if ((paramBoolean) && (this.Fnk == 1))
      {
        this.Fnh.init();
        boolean bool1 = this.Fnh.cNM();
        boolean bool2 = this.Fnh.aeU();
        if ((bool1) && (bool2)) {
          Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive restart audio device OK!");
        }
      }
      Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(198255);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: " + paramBoolean + ", error:" + localThrowable);
      AppMethodBeat.o(198255);
    }
  }
  
  public static enum a
  {
    final int cOr;
    
    static
    {
      AppMethodBeat.i(202986);
      FpD = new a("ReasonInterrupted", 0, 0);
      FpE = new a("ReasonManual", 1, 1);
      FpF = new a("ReasonDevice", 2, 2);
      FpG = new a("ReasonInCommingCall", 3, 3);
      FpH = new a("ReasonSessionUpdateFailed", 4, 4);
      FpI = new a("ReasonWeappEnterBackground", 5, 5);
      FpJ = new a("ReasonUnknown", 6, 100);
      FpK = new a[] { FpD, FpE, FpF, FpG, FpH, FpI, FpJ };
      AppMethodBeat.o(202986);
    }
    
    private a(int paramInt)
    {
      this.cOr = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.o
 * JD-Core Version:    0.7.0.1
 */