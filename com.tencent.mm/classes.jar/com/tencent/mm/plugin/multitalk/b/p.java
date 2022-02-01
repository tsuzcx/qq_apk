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
import android.os.Message;
import android.os.Parcel;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.s;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.erj;
import com.tencent.mm.protocal.protobuf.erk;
import com.tencent.mm.protocal.protobuf.erl;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.erq;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public enum p
{
  public static int EMethodGetQosPara;
  private final MMHandler luO;
  private boolean mIsInit;
  private MMHandler mainHandler;
  String mgS;
  public boolean qtA;
  boolean qtD;
  private long qtF;
  public boolean qtH;
  private int qtI;
  public boolean qtK;
  public boolean qtL;
  public boolean qtM;
  private boolean qtN;
  private boolean qtO;
  private final int qtP;
  public Runnable qtQ;
  private String qtj;
  private int qtl;
  int qtm;
  String sIX;
  private final r zHT;
  public final l zHU;
  public final f zHV;
  private final t zHW;
  private final i zHX;
  int zHY;
  a zHZ;
  public final k zHs;
  private a zHw;
  private l.a zIA;
  private l.a zIB;
  private l.a zIC;
  private boolean zID;
  private b<String> zIE;
  private d zIF;
  String zIG;
  private long zIH;
  String zII;
  String zIJ;
  int zIK;
  private boolean zIL;
  private boolean zIM;
  private boolean zIN;
  private LinkedList<esc> zIO;
  public b zIP;
  public h zIQ;
  LinkedList<acq> zIR;
  private boolean zIS;
  private efi zIT;
  public Network zIU;
  public ConnectivityManager.NetworkCallback zIV;
  public LinkedList<Integer> zIW;
  public Map<Long, ert> zIX;
  private int zIa;
  private int zIb;
  private b<a> zIc;
  private b<ArrayList<j>> zId;
  private l.a zIe;
  private l.a zIf;
  private l.a zIg;
  private l.a zIh;
  private l.a zIi;
  private l.a zIj;
  l.a zIk;
  l.a zIl;
  public l.a zIm;
  public l.a zIn;
  private l.a zIo;
  private l.a zIp;
  private l.a zIq;
  private l.a zIr;
  private l.a zIs;
  private l.a zIt;
  private l.a zIu;
  private l.a zIv;
  private l.a zIw;
  private l.a zIx;
  public l.a zIy;
  public l.a zIz;
  
  static
  {
    AppMethodBeat.i(239298);
    zHS = new p("INSTANCE");
    zIY = new p[] { zHS };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(239298);
  }
  
  private p()
  {
    AppMethodBeat.i(239233);
    this.qtl = 0;
    this.qtm = 1;
    this.zIa = 2;
    this.zIb = 160;
    this.zIF = null;
    this.qtF = -1L;
    this.qtH = false;
    this.qtI = 0;
    this.zII = "";
    this.zIJ = "";
    this.zIK = 4;
    this.zIL = false;
    this.zIM = false;
    this.zIN = false;
    this.sIX = null;
    this.zIP = b.zKt;
    this.zIQ = null;
    this.zHw = null;
    this.zIR = null;
    this.zIS = false;
    this.zIT = null;
    this.zIU = null;
    this.zIV = null;
    this.zIW = new LinkedList();
    this.mainHandler = new MMHandler(Looper.getMainLooper())
    {
      TelephonyManager qtS;
      PhoneStateListener qtT;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(239102);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.qtS == null)
          {
            this.qtS = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
            this.qtT = new PhoneStateListener()
            {
              public final void onCallStateChanged(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(239101);
                super.onCallStateChanged(paramAnonymous2Int, paramAnonymous2String);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(239101);
                  return;
                  p.this.aj(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(239100);
                      Log.i("MicroMsg.Multitalk.ILinkService", "hy: hy: phone broken. exit room if in room");
                      p.a(p.this, p.a.zKo);
                      AppMethodBeat.o(239100);
                    }
                  });
                }
              }
            };
          }
          paramAnonymousMessage = this.qtS;
          Object localObject = this.qtT;
          localObject = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          paramAnonymousMessage.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMessage, "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(239102);
      }
    };
    this.zIX = new ConcurrentHashMap();
    this.qtM = false;
    this.qtN = false;
    this.qtO = false;
    this.qtP = -9999;
    this.qtQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239197);
        if ((p.F(p.this) == 0) && (!p.af(p.this)))
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          p.a(p.this);
        }
        AppMethodBeat.o(239197);
      }
    };
    this.zHT = new r();
    this.zHU = new l();
    this.zHs = new k();
    this.zHV = new f(this.zHs);
    this.zHW = new t(this.zHs);
    this.zHX = new i();
    this.zIF = new d(ac.eom());
    this.luO = new MMHandler("ILink_voip_worker");
    this.zHY = 0;
    this.mgS = null;
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, p.c.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      Log.v("MicroMsg.Multitalk.ILinkService", "hy: updatad device info %s", new Object[] { localObject });
      ae.DV((String)localObject);
    }
    for (;;)
    {
      this.qtA = false;
      this.mIsInit = false;
      this.zID = false;
      this.qtl = 0;
      this.qtm = 1;
      this.zIa = 2;
      this.zIb = 160;
      this.qtD = false;
      this.zIE = null;
      this.zIQ = null;
      this.qtK = false;
      this.qtL = false;
      this.zHw = new a();
      this.zIP = b.zKt;
      this.zIM = false;
      this.zIR = null;
      this.zIS = false;
      this.qtH = false;
      this.zIT = new efi();
      this.zIU = null;
      this.zIV = null;
      this.zIW.clear();
      AppMethodBeat.o(239233);
      return;
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: can not get device info from mm");
    }
  }
  
  static void G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239270);
    m.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(239270);
  }
  
  private void Hm(long paramLong)
  {
    AppMethodBeat.i(239261);
    m(this.qtQ, paramLong);
    AppMethodBeat.o(239261);
  }
  
  static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239272);
    paramInt = m.R(paramArrayOfByte, paramInt);
    AppMethodBeat.o(239272);
    return paramInt;
  }
  
  static int Y(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239265);
    paramInt = m.W(paramArrayOfByte, paramInt);
    AppMethodBeat.o(239265);
    return paramInt;
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(239254);
    switch (38.zKf[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(239254);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(239254);
      return 0;
    case 4: 
      AppMethodBeat.o(239254);
      return 1;
    case 5: 
      AppMethodBeat.o(239254);
      return 6;
    case 6: 
      AppMethodBeat.o(239254);
      return 8;
    }
    AppMethodBeat.o(239254);
    return 7;
  }
  
  public static u a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(239264);
    paramArrayOfByte = m.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(239264);
    return paramArrayOfByte;
  }
  
  private void a(b<ArrayList<j>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(239236);
    this.qtA = false;
    synchronized (this.zHU)
    {
      this.zHU.b(3, this.zIk);
      this.zHU.b(4, this.zIl);
      this.zHU.b(22, this.zIm);
      this.zHU.b(23, this.zIn);
      this.zIk = null;
      this.zIl = null;
      this.zIm = null;
      this.zIn = null;
      ??? = this.zHs.elF();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zHY = 1;
        AppMethodBeat.o(239236);
        return;
      }
    }
    if (paramInt2 == 15)
    {
      MMHandlerThread.postToMainThread(new d.8(this.zIF));
      AppMethodBeat.o(239236);
      return;
    }
    this.zIF.bH(2, this.zII);
    AppMethodBeat.o(239236);
  }
  
  static boolean a(j paramj)
  {
    AppMethodBeat.i(239266);
    if (m.EU(paramj.qrD) > 0)
    {
      AppMethodBeat.o(239266);
      return true;
    }
    AppMethodBeat.o(239266);
    return false;
  }
  
  private int aFy(String paramString)
  {
    AppMethodBeat.i(239244);
    IConfCallBack localIConfCallBack = this.zHU.kK(false);
    int i = m.a(paramString, this.qtl, this.zIa, this.zIb, localIConfCallBack);
    this.zIh = new l.a()
    {
      public final boolean czb()
      {
        return true;
      }
    };
    this.zHU.a(26, this.zIh);
    AppMethodBeat.o(239244);
    return i;
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(239255);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.zHZ = parama;
    if (this.qtA)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: current joining room. waiting for exiting after joining");
      this.qtD = true;
      AppMethodBeat.o(239255);
      return -9999;
    }
    if (this.zHY == 0)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(239255);
      return 0;
    }
    int i = m.EV(a(parama));
    Hm(180000L);
    AppMethodBeat.o(239255);
    return i;
  }
  
  private void b(b<ArrayList<j>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(239237);
    this.qtA = false;
    synchronized (this.zHU)
    {
      this.zHU.b(5, this.zIo);
      this.zHU.b(6, this.zIp);
      this.zHU.b(22, this.zIm);
      this.zHU.b(23, this.zIn);
      this.zHU.b(7, this.zIs);
      this.zIo = null;
      this.zIp = null;
      this.zIm = null;
      this.zIn = null;
      this.zIs = null;
      ??? = this.zHs.elF();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zHY = 1;
        AppMethodBeat.o(239237);
        return;
      }
    }
    this.zIF.bH(16, this.zII);
    AppMethodBeat.o(239237);
  }
  
  private void c(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(239246);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger InviteSucc: %b %b %b %b %b", new Object[] { Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO), Boolean.valueOf(this.zIL), Boolean.valueOf(this.zIM) });
    if ((this.qtM) && (this.qtO) && (this.qtN) && (this.zIL) && (!this.zIM))
    {
      if (this.qtD)
      {
        f(paramb);
        AppMethodBeat.o(239246);
        return;
      }
      this.zHW.czm();
      boolean bool1 = this.zHV.czm();
      boolean bool2 = this.zHV.aai();
      if ((bool1) && (bool2))
      {
        i = 0;
        o.qsR = i;
        if (!bool1) {
          break label220;
        }
        i = 0;
        label169:
        o.qsT = i;
        if (!bool2) {
          break label231;
        }
      }
      label220:
      label231:
      for (int i = 0;; i = this.zHV.elD())
      {
        o.qsS = i;
        if ((!bool1) || (!bool2)) {
          break label242;
        }
        b(paramb, 0, 0, "ok");
        this.zIM = true;
        AppMethodBeat.o(239246);
        return;
        i = 1;
        break;
        i = this.zHV.elE();
        break label169;
      }
      label242:
      e(paramb);
    }
    AppMethodBeat.o(239246);
  }
  
  private void czg()
  {
    AppMethodBeat.i(239251);
    this.zHs.qsr.clear();
    this.zHs.elG();
    this.zHV.release();
    this.zHW.release();
    synchronized (this.zHU)
    {
      this.zHU.b(24, this.zIe);
      this.zHU.b(27, this.zIj);
      this.zHU.b(25, this.zIf);
      this.zHU.b(20, this.zIg);
      this.zIe = null;
      this.zIf = null;
      this.zIg = null;
      this.zIh = null;
      this.zIj = null;
      AppMethodBeat.o(239251);
      return;
    }
  }
  
  private void e(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(239248);
    this.zIF.bH(4, this.zII);
    a(paramb, -10086, -7, "start audio device failed");
    b(a.zKn);
    AppMethodBeat.o(239248);
  }
  
  private void elL()
  {
    AppMethodBeat.i(239239);
    synchronized (this.zHU)
    {
      this.zHU.b(8, this.zIt);
      this.zHU.b(9, this.zIu);
      this.zHU.b(11, this.zIv);
      this.zHU.b(16, this.zIA);
      this.zIt = null;
      this.zIu = null;
      this.zIv = null;
      this.zIA = null;
      AppMethodBeat.o(239239);
      return;
    }
  }
  
  private void elM()
  {
    AppMethodBeat.i(239243);
    if ((this.mIsInit) || (this.zID))
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "uninitEngine called!");
      this.zHT.akH(this.mgS);
      this.zHs.amZ();
      this.zHV.release();
      this.zHW.release();
      this.zHU.kK(true);
      this.mIsInit = false;
      this.zID = false;
      n.zHO.cBo();
      this.zIL = false;
      this.zIN = false;
      this.zIM = false;
      this.qtA = false;
      if (this.zIR != null)
      {
        this.zIR.clear();
        this.zIR = null;
      }
      elW();
      this.zIU = null;
      this.zIV = null;
      this.zIW.clear();
      czf();
      m.cze();
    }
    AppMethodBeat.o(239243);
  }
  
  private int elP()
  {
    AppMethodBeat.i(239262);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.TRUE });
    elM();
    this.zHT.akH(this.mgS);
    o.qsR = 0;
    o.qsS = 0;
    o.qsT = 0;
    o.qsU = 0;
    o.qsV = 0;
    o.qsW = 0;
    o.qsX = 0;
    o.qsY = 0;
    o.qsZ = 0;
    this.mgS = null;
    this.qtj = null;
    czg();
    this.mIsInit = false;
    this.zID = false;
    this.zIM = false;
    this.qtA = false;
    n.zHO.cBo();
    AppMethodBeat.o(239262);
    return 0;
  }
  
  private void elW()
  {
    AppMethodBeat.i(239277);
    Log.i("MicroMsg.Multitalk.ILinkService", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.oD(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.zIV != null) {
        Log.i("MicroMsg.Multitalk.ILinkService", "unregister networkcallback hashCode: " + this.zIV.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.zIV);
      this.zIV = null;
      this.zIU = null;
      AppMethodBeat.o(239277);
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
  
  public static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(239271);
    paramInt1 = m.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(239271);
    return paramInt1;
  }
  
  private void f(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(239249);
    Log.w("MicroMsg.Multitalk.ILinkService", "hy: require exit. try exit exit again");
    a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
    int i = b(this.zHZ);
    if (this.zIE != null)
    {
      if (i != 0) {
        break label82;
      }
      this.zIE.a(0, 0, "ok", "");
    }
    for (;;)
    {
      this.qtD = false;
      this.zIE = null;
      AppMethodBeat.o(239249);
      return;
      label82:
      this.zIE.a(-10086, -17, "exit failed", "");
    }
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(239253);
    this.luO.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(239253);
  }
  
  final void EZ(int paramInt)
  {
    AppMethodBeat.i(239273);
    this.zIK = paramInt;
    m.EW(paramInt);
    AppMethodBeat.o(239273);
  }
  
  public final int QY(int paramInt)
  {
    AppMethodBeat.i(239260);
    paramInt = this.zHs.QY(paramInt);
    AppMethodBeat.o(239260);
    return paramInt;
  }
  
  public final void Rb(final int paramInt)
  {
    AppMethodBeat.i(239241);
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239122);
        m.QZ(paramInt);
        AppMethodBeat.o(239122);
      }
    });
    AppMethodBeat.o(239241);
  }
  
  public final void a(final b<String> paramb)
  {
    AppMethodBeat.i(239242);
    Log.i("MicroMsg.Multitalk.ILinkService", "steve: initsession : isInit :%b ", new Object[] { Boolean.valueOf(this.mIsInit) });
    if ((this.mIsInit) && (this.zHY == 0)) {
      elM();
    }
    if (!this.mIsInit)
    {
      d.a locala = new d.a();
      locala.iLN = new erl();
      locala.iLO = new erm();
      locala.funcId = 573;
      locala.uri = "/cgi-bin/micromsg-bin/voipmtgetauthcode";
      locala.iLP = 0;
      locala.respCmdId = 0;
      IPCRunCgi.a(locala.aXF(), new IPCRunCgi.a()
      {
        public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.d paramAnonymousd)
        {
          AppMethodBeat.i(239129);
          p.this.aj(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(239128);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousd.iLL.iLR == null))
              {
                Log.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
                AppMethodBeat.o(239128);
                return;
              }
              String str = ((erm)paramAnonymousd.iLL.iLR).Npe.yO();
              p.h(p.this, new l.a()
              {
                public final boolean czb()
                {
                  return true;
                }
              });
              p.i(p.this, new l.a()
              {
                public final boolean czb()
                {
                  return true;
                }
              });
              p.o(p.this).a(1, p.B(p.this));
              p.o(p.this).a(2, p.D(p.this));
              int i = p.d(p.this, str);
              if (i != 0)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "initEngine failed ret=%d", new Object[] { Integer.valueOf(i) });
                if (p.6.this.zJo != null) {
                  p.6.this.zJo.a(-10086, -3, "initengine failed", "");
                }
                AppMethodBeat.o(239128);
                return;
              }
              AppMethodBeat.o(239128);
            }
          });
          AppMethodBeat.o(239129);
        }
      });
      AppMethodBeat.o(239242);
      return;
    }
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239130);
        n.zHO.cBn();
        if (paramb != null) {
          paramb.a(0, 0, null, null);
        }
        AppMethodBeat.o(239130);
      }
    });
    AppMethodBeat.o(239242);
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239276);
    Log.i("MicroMsg.Multitalk.ILinkService", "start bindSocket " + paramInt + " ToNetwork " + this.zIU + " rebind " + paramBoolean);
    if (paramInt == -1) {
      elW();
    }
    if (!paramBoolean) {
      this.zIW.add(Integer.valueOf(paramInt));
    }
    if ((this.zIU != null) && (com.tencent.mm.compatible.util.d.oD(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.zIU.bindSocket(localFileDescriptor);
        Log.d("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork success: network" + this.zIU + "+socketfd" + paramInt);
        AppMethodBeat.o(239276);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(239276);
  }
  
  public final int aFz(String paramString)
  {
    AppMethodBeat.i(239257);
    int i = -1;
    paramString = this.zHs.aFx(paramString);
    if (paramString != null) {
      i = paramString.qrD;
    }
    AppMethodBeat.o(239257);
    return i;
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(239252);
    if (this.luO.getSerialTag().equals(com.tencent.f.j.a.hmF()))
    {
      paramRunnable.run();
      AppMethodBeat.o(239252);
      return;
    }
    this.luO.post(paramRunnable);
    AppMethodBeat.o(239252);
  }
  
  public final void az(final ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(239258);
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239199);
        if (p.F(p.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(p.F(p.this)) });
          AppMethodBeat.o(239199);
          return;
        }
        if (paramArrayList == null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(p.F(p.this)) });
          AppMethodBeat.o(239199);
          return;
        }
        if ((paramArrayList.size() == 1) && (!this.zKa))
        {
          p.this.elO();
          AppMethodBeat.o(239199);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label151:
        Integer localInteger;
        efj localefj;
        if (this.zKa)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          Iterator localIterator = paramArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label275;
          }
          localInteger = (Integer)localIterator.next();
          localefj = new efj();
          localefj.Lnt = localInteger.intValue();
          localefj.NfF = i;
          int j = p.this.QY(localInteger.intValue());
          if ((j != 102) && (j != 101)) {
            break label265;
          }
          localefj.NfF = 240;
          localLinkedList2.add(localefj);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localInteger });
          break label151;
          i = 480;
          break;
          label265:
          localLinkedList1.add(localefj);
        }
        label275:
        p.ag(p.this).xuS = localLinkedList1;
        if (ac.eom().enw().zND) {}
        for (p.ag(p.this).NfE = localLinkedList2;; p.ag(p.this).NfE = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUserMids, videoMembers %s", new Object[] { p.ag(p.this) });
          m.a(p.ag(p.this));
          AppMethodBeat.o(239199);
          return;
        }
      }
    });
    AppMethodBeat.o(239258);
  }
  
  final void b(b<ArrayList<j>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(239245);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger JoinSucc: %b %b %b", new Object[] { Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO) });
    if ((this.qtM) && (this.qtO) && (this.qtN))
    {
      if (this.qtD)
      {
        f(paramb);
        AppMethodBeat.o(239245);
        return;
      }
      this.zHW.czm();
      boolean bool1 = this.zHV.czm();
      boolean bool2 = this.zHV.aai();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      o.qsR = i;
      if (bool1)
      {
        i = 0;
        o.qsT = i;
        if (!bool2) {
          break label197;
        }
      }
      label197:
      for (i = 0;; i = this.zHV.elD())
      {
        o.qsS = i;
        if ((!bool1) || (!bool2)) {
          break label208;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(239245);
        return;
        i = this.zHV.elE();
        break;
      }
      label208:
      e(paramb);
    }
    AppMethodBeat.o(239245);
  }
  
  public final void bK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(239240);
    eri localeri = new eri();
    try
    {
      localeri.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.Multitalk.ILinkService", "got banner msg from wxgroupid %s sdkgroupid %s roomid %d seq %d status %d", new Object[] { localeri.NoW, localeri.NoX, Long.valueOf(localeri.Lnw), Long.valueOf(localeri.NoZ), Integer.valueOf(localeri.Npa) });
      if (((localeri.NoX == null) || (localeri.NoX.equals(""))) && (localeri.Npa != 0))
      {
        AppMethodBeat.o(239240);
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(239240);
      return;
    }
    ac.eom().eM(localeri.NoW, 2);
    paramArrayOfByte = this.zIF;
    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onMultiTalkBannerChange:%s, status:%d, banner seq:%d", new Object[] { localeri.NoW, Integer.valueOf(localeri.Npa), Long.valueOf(localeri.NoZ) });
    String str = localeri.NoW;
    if ((localeri.NoW == null) || (localeri.NoW == ""))
    {
      AppMethodBeat.o(239240);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = (String)g.aAh().azQ().get(2, null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "userName is null");
          AppMethodBeat.o(239240);
          return;
        }
        localObject2 = localeri.Npb;
        localObject3 = ac.eoi().aFI(str);
        if (localObject3 == null) {
          break label1398;
        }
        i = 1;
        if ((localeri.Npa != 0) && (localObject3 != null) && (((com.tencent.mm.bh.f)localObject3).field_ilinkRoomId != 0L) && (localeri.Lnw != ((com.tencent.mm.bh.f)localObject3).field_ilinkRoomId))
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that roomid not mathced wxgroupid %s roomid %d cached roomid %d", new Object[] { str, Long.valueOf(localeri.Lnw), Long.valueOf(((com.tencent.mm.bh.f)localObject3).field_ilinkRoomId) });
          AppMethodBeat.o(239240);
          return;
        }
        if ((paramArrayOfByte.zHl.containsKey(str)) && (localeri.NoZ < ((Long)paramArrayOfByte.zHl.get(str)).longValue()))
        {
          if (localeri.Npa == 2)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that expired wxgroupid %s roomid %d seq %d cached seq %d", new Object[] { str, Long.valueOf(localeri.Lnw), Long.valueOf(localeri.NoZ), paramArrayOfByte.zHl.get(str) });
            AppMethodBeat.o(239240);
          }
        }
        else {
          paramArrayOfByte.zHl.put(str, Long.valueOf(localeri.NoZ));
        }
        if ((localeri.Npa == 0) && (i == 1))
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "get WxVoiceBannerEnd,dismiss bar!");
          if ((!ac.eop().aGg(str)) && (ac.eop().enT().contains(str)) && (ac.eop().iL(str, (String)localObject1)))
          {
            ac.eom();
            com.tencent.mm.plugin.multitalk.model.q.aGd(str);
          }
          ac.eom().aGc(str);
          ac.eom().aFX(str);
          ac.eop().aFO(str);
          ac.eop().aGf(str);
          ac.eop().enT().remove(str);
          AppMethodBeat.o(239240);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "parse  bannerinfo  failure! xml" + paramArrayOfByte.toString());
        AppMethodBeat.o(239240);
        return;
      }
      if ((localeri.Npa == 1) && (i == 0))
      {
        i = 0;
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "The count of banner member is %d, groupid[%s]", new Object[] { Integer.valueOf(localeri.NoY.size()), str });
        localObject3 = localeri.NoY.iterator();
        paramArrayOfByte = "";
        while (((Iterator)localObject3).hasNext())
        {
          esd localesd = (esd)((Iterator)localObject3).next();
          if (!localesd.Npo.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + localesd.Npo.username + ",";
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
          ac.eop().aGf(str);
          ac.eop().enT().remove(str);
          if (!((String)localObject1).equals(localObject2)) {
            break label916;
          }
          ac.eom().d(str, (String)localObject2, false, false);
        }
        for (;;)
        {
          ac.eop().a(str, localeri);
          ac.eol().zMd.dr(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
          AppMethodBeat.o(239240);
          return;
          ac.eop().enT().contains(str);
          break;
          label916:
          if (i != 0) {
            ac.eom().d(str, (String)localObject2, false, false);
          } else {
            ac.eom().d(str, (String)localObject2, true, false);
          }
        }
      }
      if (localeri.Npa == 2)
      {
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange!2,member size : " + localeri.NoY.size());
        i = 0;
        localObject2 = localeri.NoY.iterator();
        paramArrayOfByte = "";
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (esd)((Iterator)localObject2).next();
          if (!((esd)localObject3).Npo.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + ((esd)localObject3).Npo.username + ",";
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
          if ((!ac.eop().aGg(str)) && (ac.eop().enT().contains(str)) && (ac.eop().iL(str, (String)localObject1)))
          {
            ac.eom();
            com.tencent.mm.plugin.multitalk.model.q.aGd(str);
          }
          ac.eop().aGf(str);
          ac.eop().enT().remove(str);
        }
        for (;;)
        {
          ac.eol().zMd.dr(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          paramArrayOfByte = ac.eop();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { str });
          localObject1 = ac.eoi().aFI(str);
          if (localObject1 == null) {
            break label1375;
          }
          if (((com.tencent.mm.bh.f)localObject1).field_ilinkRoomId == localeri.Lnw) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bh.f)localObject1).field_roomId + "bannerinfo.roomid:" + localeri.Lnw);
          AppMethodBeat.o(239240);
          return;
          ac.eop().enT().contains(str);
        }
        if (!s.b(str, localeri))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(239240);
          return;
        }
        paramArrayOfByte.aGh(str);
        AppMethodBeat.o(239240);
        return;
        label1375:
        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        paramArrayOfByte.a(str, localeri);
      }
      AppMethodBeat.o(239240);
      return;
      label1398:
      int i = 0;
    }
  }
  
  public final void czf()
  {
    this.qtM = false;
    this.qtN = false;
    this.qtO = false;
  }
  
  public final void d(b<ArrayList<j>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(239247);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger AcceptSucc: %b %b %b", new Object[] { Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO) });
    if ((this.qtM) && (this.qtO) && (this.qtN))
    {
      if (this.qtD)
      {
        f(paramb);
        AppMethodBeat.o(239247);
        return;
      }
      this.zHW.czm();
      boolean bool1 = this.zHV.czm();
      boolean bool2 = this.zHV.aai();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      o.qsR = i;
      if (bool1)
      {
        i = 0;
        o.qsT = i;
        if (!bool2) {
          break label193;
        }
      }
      label193:
      for (i = 0;; i = this.zHV.elD())
      {
        o.qsS = i;
        if ((!bool1) || (!bool2)) {
          break label204;
        }
        hg(0, 0);
        AppMethodBeat.o(239247);
        return;
        i = this.zHV.elE();
        break;
      }
      label204:
      e(paramb);
    }
    AppMethodBeat.o(239247);
  }
  
  public final void d(ArrayList<String> paramArrayList, final boolean paramBoolean)
  {
    AppMethodBeat.i(239259);
    if (this.zHY != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.zHY) });
      AppMethodBeat.o(239259);
      return;
    }
    final ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = this.zHs.aFx((String)localObject);
        if (localObject != null) {
          localArrayList.add(Integer.valueOf(((j)localObject).qrD));
        }
      }
    }
    Log.i("MicroMsg.Multitalk.ILinkService", "subscribeScreenByUsernames, screen midlist:%s,memberName%s", new Object[] { localArrayList, paramArrayList });
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239200);
        if (p.F(p.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(p.F(p.this)) });
          AppMethodBeat.o(239200);
          return;
        }
        LinkedList localLinkedList1 = new LinkedList();
        LinkedList localLinkedList2 = new LinkedList();
        Object localObject1;
        Object localObject2;
        efj localefj;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            localefj = new efj();
            localefj.Lnt = ((Integer)localObject2).intValue();
            localefj.NfF = this.zKc;
            localLinkedList2.add(localefj);
            Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localObject2 });
          }
        }
        if (paramBoolean)
        {
          localObject1 = p.d(p.this).elF();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (j)((Iterator)localObject1).next();
              if (p.u(p.this).equals(((j)localObject2).goe))
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(((j)localObject2).qrD), ((j)localObject2).goe });
              }
              else
              {
                int i = ((j)localObject2).qrD;
                localefj = new efj();
                localefj.Lnt = i;
                localefj.NfF = 480;
                int j = p.this.QY(i);
                if ((j == 102) || (j == 101))
                {
                  localefj.NfF = 240;
                  localLinkedList2.add(localefj);
                }
                for (;;)
                {
                  Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), ((j)localObject2).goe });
                  break;
                  localLinkedList1.add(localefj);
                }
              }
            }
          }
        }
        p.ag(p.this).xuS = localLinkedList1;
        if (ac.eom().enw().zND) {}
        for (p.ag(p.this).NfE = localLinkedList2;; p.ag(p.this).NfE = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeScreenByUserMids, videoMembers %s", new Object[] { p.ag(p.this) });
          m.a(p.ag(p.this));
          AppMethodBeat.o(239200);
          return;
        }
      }
    });
    AppMethodBeat.o(239259);
  }
  
  public final void e(final ArrayList<j> paramArrayList, final String paramString)
  {
    AppMethodBeat.i(239235);
    Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkInvite. %s, %s", new Object[] { paramArrayList, paramString });
    this.zII = paramString;
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239153);
        p localp = p.this;
        ArrayList localArrayList = paramArrayList;
        String str = paramString;
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter inviteSync. %s, %s", new Object[] { localArrayList, str });
        if ((localp.zHY == 1) || (localp.qtA))
        {
          Log.w("MicroMsg.Multitalk.ILinkService", "hy: already in room or joining room!");
          AppMethodBeat.o(239153);
          return;
        }
        localp.zHs.amZ();
        localp.zHs.zHD = str;
        localp.zHs.zHE = str;
        localp.sIX = localp.zIG;
        localp.mgS = new String("wechat");
        localp.zHZ = p.a.zKr;
        localp.qtH = false;
        localp.qtA = true;
        localp.qtD = false;
        localp.zIP = p.b.zKu;
        localp.a(new p.32(localp, localArrayList));
        AppMethodBeat.o(239153);
      }
    });
    AppMethodBeat.o(239235);
  }
  
  final void elN()
  {
    AppMethodBeat.i(239250);
    this.zIg = new l.a()
    {
      private static ada bj(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(239159);
        ada localada = new ada();
        try
        {
          localada.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(239159);
          return localada;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(239159);
        }
        return null;
      }
      
      public final boolean czb()
      {
        return true;
      }
    };
    this.zHU.a(20, this.zIg);
    this.zIi = new l.a()
    {
      private static acr bk(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(239163);
        acr localacr = new acr();
        try
        {
          localacr.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(239163);
          return localacr;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(239163);
        }
        return null;
      }
      
      public final boolean czb()
      {
        return true;
      }
    };
    this.zHU.a(21, this.zIi);
    this.zIe = new l.a()
    {
      public final boolean czb()
      {
        return true;
      }
    };
    this.zHU.a(24, this.zIe);
    this.zIf = new l.a()
    {
      private static byte[] a(act paramAnonymousact)
      {
        AppMethodBeat.i(239169);
        if (paramAnonymousact != null) {
          try
          {
            paramAnonymousact = paramAnonymousact.toByteArray();
            AppMethodBeat.o(239169);
            return paramAnonymousact;
          }
          catch (IOException paramAnonymousact)
          {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousact, "hy: error when convert to byte array", new Object[0]);
          }
        }
        AppMethodBeat.o(239169);
        return new byte[0];
      }
      
      public final boolean czb()
      {
        return true;
      }
    };
    this.zHU.a(25, this.zIf);
    Object localObject2 = this.zHs;
    k.a local17 = new k.a()
    {
      public final void Q(final ArrayList<j> paramAnonymousArrayList)
      {
        AppMethodBeat.i(239173);
        Log.v("MicroMsg.Multitalk.ILinkService", "hy: current talking members are %s", new Object[] { paramAnonymousArrayList });
        p.this.aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239172);
            if (p.F(p.this) != 1)
            {
              Log.w("MicroMsg.Multitalk.ILinkService", "hy: onSpeakerListChanged but not in room!");
              AppMethodBeat.o(239172);
              return;
            }
            if (p.ac(p.this) != null) {
              p.ac(p.this).a(0, 0, "on talklist change", paramAnonymousArrayList);
            }
            AppMethodBeat.o(239172);
          }
        });
        AppMethodBeat.o(239173);
      }
    };
    synchronized (((k)localObject2).qst)
    {
      ((k)localObject2).qst.add(local17);
      ??? = this.zHs;
      localObject2 = new k.1((k)???);
      ((k)???).qsu = new Timer("ILink_check_member_change");
      ((k)???).qsu.schedule((TimerTask)localObject2, 1000L, 1000L);
      this.zIj = new l.a()
      {
        public final boolean czb()
        {
          return true;
        }
      };
      this.zHU.a(27, this.zIj);
      AppMethodBeat.o(239250);
      return;
    }
  }
  
  public final void elO()
  {
    AppMethodBeat.i(239256);
    if (this.zHY != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.zHY) });
      AppMethodBeat.o(239256);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.zHs.elF();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(239256);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      if (this.zIG.equals(localj.goe))
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(localj.qrD), localj.goe });
      }
      else
      {
        int i = localj.qrD;
        efj localefj = new efj();
        localefj.Lnt = i;
        localefj.NfF = 480;
        int j = QY(i);
        if ((j == 102) || (j == 101))
        {
          localefj.NfF = 240;
          localLinkedList2.add(localefj);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), localj.goe });
          break;
          localLinkedList1.add(localefj);
        }
      }
    }
    this.zIT.xuS = localLinkedList1;
    if (ac.eom().enw().zND) {}
    for (this.zIT.NfE = localLinkedList2;; this.zIT.NfE = null)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribe, videoMembers %s", new Object[] { localArrayList });
      m.a(this.zIT);
      AppMethodBeat.o(239256);
      return;
    }
  }
  
  public final t elQ()
  {
    return this.zHW;
  }
  
  public final List<String> elR()
  {
    AppMethodBeat.i(239267);
    Object localObject = this.zHs.elF();
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(239267);
      return null;
    }
    if (this.zHY != 1)
    {
      AppMethodBeat.o(239267);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      if (a(localj))
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(localj.qrD), localj.goe });
        localArrayList.add(localj.goe);
      }
    }
    AppMethodBeat.o(239267);
    return localArrayList;
  }
  
  public final Map<String, Integer> elS()
  {
    AppMethodBeat.i(239268);
    Object localObject = this.zHs.elF();
    HashMap localHashMap = new HashMap();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(239268);
      return null;
    }
    if (this.zHY != 1)
    {
      AppMethodBeat.o(239268);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      int i = m.EU(localj.qrD);
      if (i > 0)
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingEnergyMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(localj.qrD), localj.goe });
        localHashMap.put(localj.goe, Integer.valueOf(i));
      }
    }
    AppMethodBeat.o(239268);
    return localHashMap;
  }
  
  public final List<String> elT()
  {
    AppMethodBeat.i(239269);
    Object localObject = this.zHs.elF();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (this.zHY == 1))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        byte[] arrayOfByte = new byte[4];
        if (m.X(arrayOfByte, localj.qrD) >= 0)
        {
          int i = Util.byteArrayToInt(arrayOfByte);
          Log.d("MicroMsg.Multitalk.ILinkService", "netStatus: %d", new Object[] { Integer.valueOf(i) });
          if ((i != -1) && (i <= 3)) {
            localArrayList.add(localj.goe);
          }
        }
      }
    }
    AppMethodBeat.o(239269);
    return localArrayList;
  }
  
  final void elU()
  {
    AppMethodBeat.i(239274);
    n localn = n.zHO;
    this.zIK = n.elK();
    AppMethodBeat.o(239274);
  }
  
  public final void elV()
  {
    AppMethodBeat.i(239275);
    Log.i("MicroMsg.Multitalk.ILinkService", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.oD(21))
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
            AppMethodBeat.i(239206);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            Log.i("MicroMsg.Multitalk.ILinkService", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.oD(28)) {
              localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            }
            try
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference ret ".concat(String.valueOf(((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork))));
              p.this.zIU = paramAnonymousNetwork;
              if (p.this.zIW != null) {
                while (i < p.this.zIW.size())
                {
                  p.this.aE(((Integer)p.this.zIW.get(i)).intValue(), true);
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
                AppMethodBeat.o(239206);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
                AppMethodBeat.o(239206);
                return;
              }
              p.this.zIV = this;
              Log.i("MicroMsg.Multitalk.ILinkService", "networkcallback hashCode: " + p.this.zIV.hashCode());
              AppMethodBeat.o(239206);
            }
          }
        });
        AppMethodBeat.o(239275);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "missing the appropriate permissions");
        AppMethodBeat.o(239275);
        return;
      }
    }
    AppMethodBeat.o(239275);
  }
  
  public final int g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(239263);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.qtK)
    {
      if (m.e(EMethodGetQosPara, this.zHw.s2p, this.zHw.s2p.length) >= 0)
      {
        localObject1 = this.zHw;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).qrE = ((ByteBuffer)localObject2).get();
        ((a)localObject1).qrF = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = this.zHw;
        Log.d("ILink[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        Log.d("ILink[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).qrE + ", HWEnable:" + ((a)localObject1).qrF + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (this.qtK) {
        if (8 == this.zHw.qrE)
        {
          this.qtL = true;
          if (this.zHw.qrF == 0)
          {
            this.qtK = false;
            this.qtL = false;
          }
          if ((1 != this.zHw.cSkipFlag) && (this.qtK) && (this.qtL)) {
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
      if (this.qtL)
      {
        if ((this.zIQ == null) || (i != 0)) {
          break label898;
        }
        paramInt1 = this.zIQ.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if (paramInt1 >= 0) {
          paramInt1 = j;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(239263);
        return paramInt1;
        this.qtL = false;
        break;
        this.qtL = false;
        break;
        label470:
        if ((this.qtK) && (this.zIQ == null)) {
          this.zIQ = new h(this.zHw.cFps, this.zHw.iKbps, "video/avc");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject1 = this.zIQ;
          localObject2 = this.zHw;
          if ((((h)localObject1).zHw != null) && (((h)localObject1).qsc != null))
          {
            a locala = ((h)localObject1).zHw;
            locala.iKbps = ((a)localObject2).iKbps;
            locala.cFps = ((a)localObject2).cFps;
            locala.cIPeriod = ((a)localObject2).cIPeriod;
            locala.cResolution = ((a)localObject2).cResolution;
            locala.qrE = ((a)localObject2).qrE;
            locala.qrF = ((a)localObject2).qrF;
            locala.cSkipFlag = ((a)localObject2).cSkipFlag;
            locala.cIReqFlag = ((a)localObject2).cIReqFlag;
            locala.cRsvd1 = ((a)localObject2).cRsvd1;
            i = (int)(((h)localObject1).zHw.iKbps * 1.1D);
            if (((h)localObject1).m_br_kbps != i)
            {
              ((h)localObject1).SetBitRate(i);
              Log.i("ILink[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + ((h)localObject1).m_br_kbps + ", tuneBR:" + i);
              ((h)localObject1).m_br_kbps = i;
            }
            if ((1 == ((h)localObject1).zHw.cIReqFlag) && (h.frameID > 0))
            {
              if (((h)localObject1).qsc != null)
              {
                Log.v("ILink[HWEnc]", "steve: Sync frame request soon!");
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("request-sync", 0);
                ((h)localObject1).qsc.setParameters((Bundle)localObject2);
              }
              Log.i("ILink[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
            }
            if (((h)localObject1).zHw.cFps != ((h)localObject1).m_framerate) {
              ((h)localObject1).m_framerate = ((h)localObject1).zHw.cFps;
            }
          }
        }
        label854:
        i = 0;
        break label407;
        Log.e("MicroMsg.Multitalk.ILinkService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        this.qtL = false;
        paramInt1 = -1;
        continue;
        paramInt1 = m.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        continue;
        label898:
        paramInt1 = -1;
      }
      i = 0;
    }
  }
  
  public final void hg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239238);
    this.qtA = false;
    synchronized (this.zHU)
    {
      this.zHU.b(14, this.zIy);
      this.zHU.b(15, this.zIz);
      this.zHU.b(22, this.zIm);
      this.zHU.b(23, this.zIn);
      this.zIy = null;
      this.zIz = null;
      this.zIm = null;
      this.zIn = null;
      elL();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zHY = 1;
        AppMethodBeat.o(239238);
        return;
      }
    }
    this.zIF.bH(2, this.zII);
    AppMethodBeat.o(239238);
  }
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(239232);
    try
    {
      this.zHV.release();
      if ((paramBoolean) && (this.zHY == 1))
      {
        this.zHV.init();
        boolean bool1 = this.zHV.czm();
        boolean bool2 = this.zHV.aai();
        if ((bool1) && (bool2)) {
          Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive restart audio device OK!");
        }
      }
      Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(239232);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: " + paramBoolean + ", error:" + localThrowable);
      AppMethodBeat.o(239232);
    }
  }
  
  public final void y(long paramLong, String paramString)
  {
    AppMethodBeat.i(239234);
    this.zIG = paramString;
    this.zIH = paramLong;
    Log.i("MicroMsg.Multitalk.ILinkService", "set name=%s, uin=%d", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(239234);
  }
  
  public static enum a
  {
    final int cND;
    
    static
    {
      AppMethodBeat.i(239224);
      zKl = new a("ReasonInterrupted", 0, 0);
      zKm = new a("ReasonManual", 1, 1);
      zKn = new a("ReasonDevice", 2, 2);
      zKo = new a("ReasonInCommingCall", 3, 3);
      zKp = new a("ReasonSessionUpdateFailed", 4, 4);
      zKq = new a("ReasonWeappEnterBackground", 5, 5);
      zKr = new a("ReasonUnknown", 6, 100);
      zKs = new a[] { zKl, zKm, zKn, zKo, zKp, zKq, zKr };
      AppMethodBeat.o(239224);
    }
    
    private a(int paramInt)
    {
      this.cND = paramInt;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(239227);
      zKt = new b("ILinkMemberRoleUnknown", 0);
      zKu = new b("ILinkMemberRoleCreate", 1);
      zKv = new b("ILinkMemberRoleAccept", 2);
      zKw = new b("ILinkMemberRoleJoin", 3);
      zKx = new b[] { zKt, zKu, zKv, zKw };
      AppMethodBeat.o(239227);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p
 * JD-Core Version:    0.7.0.1
 */