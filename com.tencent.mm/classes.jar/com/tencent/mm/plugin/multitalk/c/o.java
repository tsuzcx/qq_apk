package com.tencent.mm.plugin.multitalk.c;

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
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.r;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.fki;
import com.tencent.mm.protocal.protobuf.fkj;
import com.tencent.mm.protocal.protobuf.fye;
import com.tencent.mm.protocal.protobuf.fyf;
import com.tencent.mm.protocal.protobuf.fyg;
import com.tencent.mm.protocal.protobuf.fyh;
import com.tencent.mm.protocal.protobuf.fyi;
import com.tencent.mm.protocal.protobuf.fyj;
import com.tencent.mm.protocal.protobuf.fyk;
import com.tencent.mm.protocal.protobuf.fyl;
import com.tencent.mm.protocal.protobuf.fym;
import com.tencent.mm.protocal.protobuf.fyo;
import com.tencent.mm.protocal.protobuf.fyp;
import com.tencent.mm.protocal.protobuf.fyy;
import com.tencent.mm.protocal.protobuf.fyz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
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
  public static boolean Ljy;
  public final j LiH;
  private a LiO;
  private b<ArrayList<i>> LjA;
  private k.a LjB;
  private k.a LjC;
  private k.a LjD;
  private k.a LjE;
  private k.a LjF;
  private k.a LjG;
  private k.a LjH;
  k.a LjI;
  k.a LjJ;
  public k.a LjK;
  public k.a LjL;
  private k.a LjM;
  private k.a LjN;
  private k.a LjO;
  private k.a LjP;
  private k.a LjQ;
  private k.a LjR;
  private k.a LjS;
  private k.a LjT;
  private k.a LjU;
  private k.a LjV;
  public k.a LjW;
  public k.a LjX;
  private k.a LjY;
  private k.a LjZ;
  private final q Ljo;
  public final k Ljp;
  private final e Ljq;
  public final s Ljr;
  private final h Ljs;
  int Ljt;
  a Lju;
  private int Ljv;
  private int Ljw;
  public int Ljx;
  private b<a> Ljz;
  private k.a Lka;
  private boolean Lkb;
  private b<String> Lkc;
  private c Lkd;
  String Lke;
  private long Lkf;
  public String Lkg;
  String Lkh;
  int Lki;
  private boolean Lkj;
  private boolean Lkk;
  private boolean Lkl;
  private LinkedList<fyy> Lkm;
  public b Lkn;
  public g Lko;
  LinkedList<afg> Lkp;
  private boolean Lkq;
  private fki Lkr;
  boolean Lks;
  public Network Lkt;
  public ConnectivityManager.NetworkCallback Lku;
  public LinkedList<Integer> Lkv;
  Object Lkw;
  public Map<Long, fyp> Lkx;
  private boolean mIsInit;
  int mRoomType;
  private MMHandler mainHandler;
  private final MMHandler rtv;
  String skr;
  public boolean wVD;
  boolean wVG;
  private long wVI;
  public boolean wVK;
  private int wVL;
  public boolean wVN;
  public boolean wVO;
  public boolean wVP;
  private boolean wVQ;
  private boolean wVR;
  private final int wVS;
  public Runnable wVT;
  private String wVl;
  private int wVn;
  String zKZ;
  
  static
  {
    AppMethodBeat.i(285896);
    Ljn = new o("INSTANCE");
    Lky = new o[] { Ljn };
    Ljy = false;
    EMethodGetQosPara = 25;
    AppMethodBeat.o(285896);
  }
  
  private o()
  {
    AppMethodBeat.i(285240);
    this.wVn = 0;
    this.mRoomType = 1;
    this.Ljv = 2;
    this.Ljw = 160;
    this.Ljx = 0;
    this.Lkd = null;
    this.wVI = -1L;
    this.wVK = false;
    this.wVL = 0;
    this.Lkg = "";
    this.Lkh = "";
    this.Lki = 4;
    this.Lkj = false;
    this.Lkk = false;
    this.Lkl = false;
    this.zKZ = null;
    this.Lkn = b.LlV;
    this.Lko = null;
    this.LiO = null;
    this.Lkp = null;
    this.Lkq = false;
    this.Lkr = null;
    this.Lks = true;
    this.Lkt = null;
    this.Lku = null;
    this.Lkv = new LinkedList();
    this.Lkw = new Object();
    this.mainHandler = new o.1(this, Looper.getMainLooper());
    this.Lkx = new ConcurrentHashMap();
    this.wVP = false;
    this.wVQ = false;
    this.wVR = false;
    this.wVS = -9999;
    this.wVT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284987);
        if ((o.F(o.this) == 0) && (!o.ae(o.this)))
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          o.a(o.this);
        }
        AppMethodBeat.o(284987);
      }
    };
    this.Ljo = new q();
    this.Ljp = new k();
    this.LiH = new j();
    this.Ljq = new e(this.LiH);
    this.Ljr = new s(this.LiH);
    this.Ljs = new h();
    this.Lkd = new c(ac.ggS());
    this.rtv = new MMHandler("ILink_voip_worker");
    this.Ljt = 0;
    this.skr = null;
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.j.a("com.tencent.mm", null, o.c.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      Log.v("MicroMsg.Multitalk.ILinkService", "hy: updatad device info %s", new Object[] { localObject });
      af.Ds((String)localObject);
    }
    for (;;)
    {
      this.wVD = false;
      this.mIsInit = false;
      this.Lkb = false;
      this.wVn = 0;
      this.mRoomType = 1;
      this.Ljv = 2;
      this.Ljw = 160;
      this.wVG = false;
      this.Lkc = null;
      this.Lko = null;
      this.wVN = false;
      this.wVO = false;
      this.LiO = new a();
      this.Lkn = b.LlV;
      this.Lkk = false;
      this.Lkp = null;
      this.Lkq = false;
      this.wVK = false;
      this.Lkr = new fki();
      this.Lkt = null;
      this.Lku = null;
      this.Lkv.clear();
      this.Lks = true;
      com.tencent.pb.common.b.e.jQX().a(214, this);
      AppMethodBeat.o(285240);
      return;
      Log.e("MicroMsg.Multitalk.ILinkService", "hy: can not get device info from mm");
    }
  }
  
  static void G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285356);
    l.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(285356);
  }
  
  static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(285346);
    paramInt = l.R(paramArrayOfByte, paramInt);
    AppMethodBeat.o(285346);
    return paramInt;
  }
  
  static int T(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(285366);
    paramInt = l.Q(paramArrayOfByte, paramInt);
    AppMethodBeat.o(285366);
    return paramInt;
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(285301);
    switch (43.LlH[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(285301);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(285301);
      return 0;
    case 4: 
      AppMethodBeat.o(285301);
      return 1;
    case 5: 
      AppMethodBeat.o(285301);
      return 6;
    case 6: 
      AppMethodBeat.o(285301);
      return 8;
    }
    AppMethodBeat.o(285301);
    return 7;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(285340);
    paramInt1 = l.a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(285340);
    return paramInt1;
  }
  
  public static t a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(285333);
    paramArrayOfByte = l.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(285333);
    return paramArrayOfByte;
  }
  
  private void a(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(285247);
    this.wVD = false;
    synchronized (this.Ljp)
    {
      this.Ljp.b(3, this.LjI);
      this.Ljp.b(4, this.LjJ);
      this.Ljp.b(22, this.LjK);
      this.Ljp.b(23, this.LjL);
      this.LjI = null;
      this.LjJ = null;
      this.LjK = null;
      this.LjL = null;
      ??? = this.LiH.geh();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Ljt = 1;
        AppMethodBeat.o(285247);
        return;
      }
    }
    if (paramInt2 == 15)
    {
      MMHandlerThread.postToMainThread(new c.10(this.Lkd));
      AppMethodBeat.o(285247);
      return;
    }
    this.Lkd.c(2, this.Lkg, null);
    AppMethodBeat.o(285247);
  }
  
  private void a(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285258);
    this.wVD = false;
    synchronized (this.Ljp)
    {
      this.Ljp.b(5, this.LjM);
      this.Ljp.b(6, this.LjN);
      this.Ljp.b(22, this.LjK);
      this.Ljp.b(23, this.LjL);
      this.Ljp.b(7, this.LjQ);
      this.LjM = null;
      this.LjN = null;
      this.LjK = null;
      this.LjL = null;
      this.LjQ = null;
      ??? = this.LiH.geh();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Ljt = 1;
        AppMethodBeat.o(285258);
        return;
      }
    }
    if ((paramInt2 == 18) && (paramArrayOfByte != null))
    {
      this.Lkd.c(11, this.Lkg, paramArrayOfByte);
      AppMethodBeat.o(285258);
      return;
    }
    this.Lkd.c(16, this.Lkg, null);
    AppMethodBeat.o(285258);
  }
  
  static boolean a(i parami)
  {
    AppMethodBeat.i(285350);
    if (l.Jf(parami.wTC) > 0)
    {
      AppMethodBeat.o(285350);
      return true;
    }
    AppMethodBeat.o(285350);
    return false;
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(285310);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.Lju = parama;
    if (this.wVD)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: current joining room. waiting for exiting after joining");
      this.wVG = true;
      AppMethodBeat.o(285310);
      return -9999;
    }
    if (this.Ljt == 0)
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(285310);
      return 0;
    }
    int i = l.Jg(a(parama));
    sw(180000L);
    AppMethodBeat.o(285310);
    return i;
  }
  
  private void b(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(285252);
    a(paramb, paramInt1, paramInt2, paramString, null);
    AppMethodBeat.o(285252);
  }
  
  private void c(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(285281);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger InviteSucc: %b %b %b %b %b", new Object[] { Boolean.valueOf(this.wVP), Boolean.valueOf(this.wVQ), Boolean.valueOf(this.wVR), Boolean.valueOf(this.Lkj), Boolean.valueOf(this.Lkk) });
    if ((this.wVP) && (this.wVR) && (this.wVQ) && (this.Lkj) && (!this.Lkk))
    {
      if (this.wVG)
      {
        f(paramb);
        AppMethodBeat.o(285281);
        return;
      }
      this.Ljr.drq();
      boolean bool1 = this.Ljq.drq();
      boolean bool2 = this.Ljq.hT(this.Lks);
      if ((bool1) && (bool2))
      {
        i = 0;
        n.abr(i);
        if (!bool1) {
          break label224;
        }
        i = 0;
        label173:
        n.abt(i);
        if (!bool2) {
          break label235;
        }
      }
      label224:
      label235:
      for (int i = 0;; i = this.Ljq.gef())
      {
        n.abs(i);
        if ((!bool1) || (!bool2)) {
          break label246;
        }
        b(paramb, 0, 0, "ok");
        this.Lkk = true;
        AppMethodBeat.o(285281);
        return;
        i = 1;
        break;
        i = this.Ljq.geg();
        break label173;
      }
      label246:
      e(paramb);
    }
    AppMethodBeat.o(285281);
  }
  
  private void drl()
  {
    AppMethodBeat.i(285291);
    this.LiH.wUq.clear();
    this.LiH.gei();
    this.Ljq.release();
    this.Ljr.release();
    synchronized (this.Ljp)
    {
      this.Ljp.b(24, this.LjB);
      this.Ljp.b(27, this.LjG);
      this.Ljp.b(25, this.LjC);
      this.Ljp.b(20, this.LjD);
      this.Ljp.b(31, this.LjH);
      this.LjB = null;
      this.LjC = null;
      this.LjD = null;
      this.LjE = null;
      this.LjG = null;
      this.LjH = null;
      AppMethodBeat.o(285291);
      return;
    }
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(285362);
    paramInt1 = l.d(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(285362);
    return paramInt1;
  }
  
  private void e(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(285284);
    this.Lkd.c(4, this.Lkg, null);
    a(paramb, -10086, -7, "start audio device failed");
    b(a.LlP);
    AppMethodBeat.o(285284);
  }
  
  private void f(b<ArrayList<i>> paramb)
  {
    AppMethodBeat.i(285289);
    Log.w("MicroMsg.Multitalk.ILinkService", "hy: require exit. try exit exit again");
    a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
    int i = b(this.Lju);
    if (this.Lkc != null)
    {
      if (i != 0) {
        break label82;
      }
      this.Lkc.a(0, 0, "ok", "");
    }
    for (;;)
    {
      this.wVG = false;
      this.Lkc = null;
      AppMethodBeat.o(285289);
      return;
      label82:
      this.Lkc.a(-10086, -17, "exit failed", "");
    }
  }
  
  private void geB()
  {
    AppMethodBeat.i(285375);
    Log.i("MicroMsg.Multitalk.ILinkService", "try to UnregisterCellularNetwork");
    ConnectivityManager localConnectivityManager;
    if (com.tencent.mm.compatible.util.d.rb(21))
    {
      localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (this.Lku != null) {
        Log.i("MicroMsg.Multitalk.ILinkService", "unregister networkcallback hashCode: " + this.Lku.hashCode());
      }
    }
    try
    {
      localConnectivityManager.unregisterNetworkCallback(this.Lku);
      this.Lku = null;
      this.Lkt = null;
      AppMethodBeat.o(285375);
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
  
  public static int gek()
  {
    AppMethodBeat.i(285352);
    int i = l.gek();
    AppMethodBeat.o(285352);
    return i;
  }
  
  private void geq()
  {
    AppMethodBeat.i(285264);
    synchronized (this.Ljp)
    {
      this.Ljp.b(8, this.LjR);
      this.Ljp.b(9, this.LjS);
      this.Ljp.b(11, this.LjT);
      this.Ljp.b(16, this.LjY);
      this.LjR = null;
      this.LjS = null;
      this.LjT = null;
      this.LjY = null;
      AppMethodBeat.o(285264);
      return;
    }
  }
  
  private void ger()
  {
    AppMethodBeat.i(285269);
    if ((this.mIsInit) || (this.Lkb))
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "uninitEngine called!");
      this.Ljo.ama(this.skr);
      this.LiH.aNi();
      this.Ljq.release();
      this.Ljr.release();
      this.Ljx = 0;
      Ljy = false;
      this.Ljp.nr(true);
      this.mIsInit = false;
      this.Lkb = false;
      m.Ljg.cuD();
      this.Lkj = false;
      this.Lkl = false;
      this.Lkk = false;
      this.wVD = false;
      if (this.Lkp != null)
      {
        this.Lkp.clear();
        this.Lkp = null;
      }
      geB();
      this.Lkt = null;
      this.Lku = null;
      this.Lkv.clear();
      this.Lks = true;
      drk();
      l.drj();
    }
    AppMethodBeat.o(285269);
  }
  
  private int gev()
  {
    AppMethodBeat.i(285326);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.TRUE });
    ger();
    this.Ljo.ama(this.skr);
    n.reset();
    this.skr = null;
    this.wVl = null;
    drl();
    this.mIsInit = false;
    this.Lkb = false;
    this.Lkk = false;
    this.wVD = false;
    m.Ljg.cuD();
    AppMethodBeat.o(285326);
    return 0;
  }
  
  private int kk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(285276);
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      Log.w("MicroMsg.Multitalk.ILinkService", "Expansions not yet installed, drop ILinkService#initWithSession()");
      AppMethodBeat.o(285276);
      return -2233;
    }
    IConfCallBack localIConfCallBack = this.Ljp.nr(false);
    int i = l.a(paramString1, paramString2, this.wVn, this.Ljv, this.Ljw, localIConfCallBack);
    this.LjE = new k.a()
    {
      public final boolean drh()
      {
        return true;
      }
    };
    this.Ljp.a(26, this.LjE);
    AppMethodBeat.o(285276);
    return i;
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(285296);
    this.rtv.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(285296);
  }
  
  private void sw(long paramLong)
  {
    AppMethodBeat.i(285318);
    m(this.wVT, paramLong);
    AppMethodBeat.o(285318);
  }
  
  final void Jk(int paramInt)
  {
    AppMethodBeat.i(286089);
    this.Lki = paramInt;
    l.Jh(paramInt);
    AppMethodBeat.o(286089);
  }
  
  public final void T(long paramLong, String paramString)
  {
    AppMethodBeat.i(285919);
    this.Lke = paramString;
    this.Lkf = paramLong;
    Log.i("MicroMsg.Multitalk.ILinkService", "set name=%s, uin=%d", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(285919);
  }
  
  public final int a(ArrayList<String> paramArrayList, String paramString, final b<Integer> paramb)
  {
    AppMethodBeat.i(285964);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fyj();
    ((c.a)localObject).otF = new fyk();
    ((c.a)localObject).funcId = 5949;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetsdkmode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      fyy localfyy = new fyy();
      localfyy.username = str;
      localLinkedList.add(localfyy);
    }
    paramArrayList = ((c.a)localObject).bEF();
    localObject = (fyj)c.b.b(paramArrayList.otB);
    ((fyj)localObject).abWl = localLinkedList;
    ((fyj)localObject).abWb = paramString;
    IPCRunCgi.a(paramArrayList, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(285080);
        Log.i("MicroMsg.Multitalk.ILinkService", "on invite result: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
        {
          Log.e("MicroMsg.Multitalk.ILinkService", "hy: getsdkmode fail, errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          AppMethodBeat.o(285080);
          return;
        }
        int i = ((fyk)c.c.b(paramAnonymousc.otC)).abWm;
        paramb.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, Integer.valueOf(i));
        Log.i("MicroMsg.Multitalk.ILinkService", "checkMultiTalkSDKMode svr sdkmode: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(285080);
      }
    });
    AppMethodBeat.o(285964);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(286132);
    if (paramd != null) {}
    Object localObject;
    for (paramString = Integer.valueOf(paramd.getType());; paramString = "")
    {
      Log.d("MicroMsg.Multitalk.ILinkService", "CLTNOT onNetSceneEnd errCode:", new Object[] { Integer.valueOf(paramInt2), " errType: ", Integer.valueOf(paramInt1), " scene.getType(): ", paramString });
      if (paramd.getType() != 214) {
        break label169;
      }
      paramString = (a.aj)paramd.ahcN;
      localObject = (com.tencent.wecall.talkroom.a.m)paramd;
      if (((com.tencent.wecall.talkroom.a.m)localObject).aics != 0) {
        break;
      }
      Log.d("MicroMsg.Multitalk.ILinkService", "handleSwitchVideoGroup, but old multitalk event");
      AppMethodBeat.o(286132);
      return;
    }
    if ((paramString.ahfm == 1) && (((com.tencent.wecall.talkroom.a.m)localObject).zZv == 103))
    {
      paramd = this.Lkd;
      localObject = ((com.tencent.wecall.talkroom.a.m)localObject).aict;
      paramInt1 = paramString.ahfn;
      paramd.Lix.aF((String)localObject, paramInt2, paramInt1);
    }
    label169:
    AppMethodBeat.o(286132);
  }
  
  public final void a(final b<String> paramb)
  {
    AppMethodBeat.i(285970);
    Log.i("MicroMsg.Multitalk.ILinkService", "steve: initsession : isInit :%b ", new Object[] { Boolean.valueOf(this.mIsInit) });
    if ((this.mIsInit) && (this.Ljt == 0)) {
      ger();
    }
    if (!this.mIsInit)
    {
      Object localObject = new c.a();
      ((c.a)localObject).otE = new fyh();
      ((c.a)localObject).otF = new fyi();
      ((c.a)localObject).funcId = 573;
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetauthcode";
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      localObject = ((c.a)localObject).bEF();
      ((fyh)c.b.b(((com.tencent.mm.am.c)localObject).otB)).abWj = 1;
      IPCRunCgi.a((com.tencent.mm.am.c)localObject, new IPCRunCgi.a()
      {
        public final void callback(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.am.c paramAnonymousc)
        {
          AppMethodBeat.i(285087);
          o.this.au(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(285119);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
              {
                Log.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
                AppMethodBeat.o(285119);
                return;
              }
              Object localObject = (fyi)c.c.b(paramAnonymousc.otC);
              String str = ((fyi)localObject).abWk.ZV();
              localObject = ((fyi)localObject).aath.ZV();
              o.h(o.this, new k.a()
              {
                public final boolean drh()
                {
                  return true;
                }
              });
              o.i(o.this, new k.a()
              {
                public final boolean drh()
                {
                  return true;
                }
              });
              o.o(o.this).a(1, o.B(o.this));
              o.o(o.this).a(2, o.D(o.this));
              int i = o.a(o.this, str, (String)localObject);
              if (i != 0)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "initEngine failed ret=%d", new Object[] { Integer.valueOf(i) });
                if (o.6.this.LkO != null) {
                  o.6.this.LkO.a(-10086, -3, "initengine failed", "");
                }
                AppMethodBeat.o(285119);
                return;
              }
              AppMethodBeat.o(285119);
            }
          });
          AppMethodBeat.o(285087);
        }
      });
      AppMethodBeat.o(285970);
      return;
    }
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285085);
        m.Ljg.duo();
        if (paramb != null) {
          paramb.a(0, 0, null, null);
        }
        AppMethodBeat.o(285085);
      }
    });
    AppMethodBeat.o(285970);
  }
  
  public final void aZ(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(286006);
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284979);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284979);
          return;
        }
        if (paramArrayList == null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284979);
          return;
        }
        if ((paramArrayList.size() == 1) && (!this.LlB))
        {
          o.this.geu();
          AppMethodBeat.o(284979);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label152:
        String str;
        Object localObject;
        int j;
        if (this.LlB)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          Iterator localIterator = paramArrayList.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = o.d(o.this).aMF(str);
          } while (localObject == null);
          j = ((i)localObject).wTC;
          localObject = new fkj();
          ((fkj)localObject).ZnB = j;
          ((fkj)localObject).abLl = i;
          int k = o.this.abo(j);
          if ((k != 102) && (k != 101)) {
            break label290;
          }
          ((fkj)localObject).abLl = 240;
          localLinkedList2.add(localObject);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUsername, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(j), str });
          break label152;
          i = 480;
          break;
          label290:
          localLinkedList1.add(localObject);
        }
        o.af(o.this).Ids = localLinkedList1;
        if (ac.ggS().ggc().Lpu) {}
        for (o.af(o.this).abLk = localLinkedList2;; o.af(o.this).abLk = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUsernames, videoMembers %s", new Object[] { o.af(o.this) });
          l.a(o.af(o.this));
          AppMethodBeat.o(284979);
          return;
        }
      }
    });
    AppMethodBeat.o(286006);
  }
  
  public final void abA(final int paramInt)
  {
    AppMethodBeat.i(285958);
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285082);
        l.abp(paramInt);
        AppMethodBeat.o(285082);
      }
    });
    AppMethodBeat.o(285958);
  }
  
  public final int abo(int paramInt)
  {
    AppMethodBeat.i(286029);
    paramInt = this.LiH.abo(paramInt);
    AppMethodBeat.o(286029);
    return paramInt;
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(285994);
    if (this.rtv.getSerialTag().equals(com.tencent.threadpool.j.a.jZB()))
    {
      paramRunnable.run();
      AppMethodBeat.o(285994);
      return;
    }
    this.rtv.post(paramRunnable);
    AppMethodBeat.o(285994);
  }
  
  final void b(b<ArrayList<i>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(285983);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger JoinSucc: %b %b %b", new Object[] { Boolean.valueOf(this.wVP), Boolean.valueOf(this.wVQ), Boolean.valueOf(this.wVR) });
    if ((this.wVP) && (this.wVR) && (this.wVQ))
    {
      if (this.wVG)
      {
        f(paramb);
        AppMethodBeat.o(285983);
        return;
      }
      this.Ljr.drq();
      boolean bool1 = this.Ljq.drq();
      boolean bool2 = this.Ljq.hT(this.Lks);
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      n.abr(i);
      if (bool1)
      {
        i = 0;
        n.abt(i);
        if (!bool2) {
          break label201;
        }
      }
      label201:
      for (i = 0;; i = this.Ljq.gef())
      {
        n.abs(i);
        if ((!bool1) || (!bool2)) {
          break label212;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(285983);
        return;
        i = this.Ljq.geg();
        break;
      }
      label212:
      e(paramb);
    }
    AppMethodBeat.o(285983);
  }
  
  public final void ba(final ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(286008);
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284968);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284968);
          return;
        }
        if (paramArrayList == null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284968);
          return;
        }
        if ((paramArrayList.size() == 1) && (!this.LlB))
        {
          o.this.geu();
          AppMethodBeat.o(284968);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label151:
        Integer localInteger;
        fkj localfkj;
        if (this.LlB)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          Iterator localIterator = paramArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label275;
          }
          localInteger = (Integer)localIterator.next();
          localfkj = new fkj();
          localfkj.ZnB = localInteger.intValue();
          localfkj.abLl = i;
          int j = o.this.abo(localInteger.intValue());
          if ((j != 102) && (j != 101)) {
            break label265;
          }
          localfkj.abLl = 240;
          localLinkedList2.add(localfkj);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localInteger });
          break label151;
          i = 480;
          break;
          label265:
          localLinkedList1.add(localfkj);
        }
        label275:
        o.af(o.this).Ids = localLinkedList1;
        if (ac.ggS().ggc().Lpu) {}
        for (o.af(o.this).abLk = localLinkedList2;; o.af(o.this).abLk = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUserMids, videoMembers %s", new Object[] { o.af(o.this) });
          l.a(o.af(o.this));
          AppMethodBeat.o(284968);
          return;
        }
      }
    });
    AppMethodBeat.o(286008);
  }
  
  public final void bk(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(286121);
    Log.i("MicroMsg.Multitalk.ILinkService", "start bindSocket " + paramInt + " ToNetwork " + this.Lkt + " rebind " + paramBoolean);
    if (paramInt == -1) {
      geB();
    }
    if (!paramBoolean) {
      this.Lkv.add(Integer.valueOf(paramInt));
    }
    if ((this.Lkt != null) && (com.tencent.mm.compatible.util.d.rb(23)))
    {
      FileDescriptor localFileDescriptor = new FileDescriptor();
      try
      {
        Field localField = FileDescriptor.class.getDeclaredField("descriptor");
        localField.setAccessible(true);
        localField.setInt(localFileDescriptor, paramInt);
        this.Lkt.bindSocket(localFileDescriptor);
        Log.d("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork success: network" + this.Lkt + "+socketfd" + paramInt);
        AppMethodBeat.o(286121);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork Error");
      }
    }
    AppMethodBeat.o(286121);
  }
  
  public final void c(b<ArrayList<i>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(285928);
    this.wVD = false;
    synchronized (this.Ljp)
    {
      this.Ljp.b(14, this.LjW);
      this.Ljp.b(15, this.LjX);
      this.Ljp.b(22, this.LjK);
      this.Ljp.b(23, this.LjL);
      this.LjW = null;
      this.LjX = null;
      this.LjK = null;
      this.LjL = null;
      geq();
      ??? = this.LiH.geh();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Ljt = 1;
        AppMethodBeat.o(285928);
        return;
      }
    }
    this.Lkd.c(2, this.Lkg, null);
    AppMethodBeat.o(285928);
  }
  
  public final void cc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285954);
    fye localfye = new fye();
    try
    {
      localfye.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.Multitalk.ILinkService", "got banner msg from wxgroupid %s sdkgroupid %s roomid %d seq %d status %d", new Object[] { localfye.abWb, localfye.abWc, Long.valueOf(localfye.ZnE), Long.valueOf(localfye.abWe), Integer.valueOf(localfye.abWf) });
      if (((localfye.abWc == null) || (localfye.abWc.equals(""))) && (localfye.abWf != 0))
      {
        AppMethodBeat.o(285954);
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(285954);
      return;
    }
    ac.ggS().gg(localfye.abWb, 2);
    paramArrayOfByte = this.Lkd;
    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onMultiTalkBannerChange:%s, status:%d, banner seq:%d", new Object[] { localfye.abWb, Integer.valueOf(localfye.abWf), Long.valueOf(localfye.abWe) });
    String str = localfye.abWb;
    if ((localfye.abWb == null) || (localfye.abWb == ""))
    {
      AppMethodBeat.o(285954);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "userName is null");
          AppMethodBeat.o(285954);
          return;
        }
        localObject2 = localfye.abWg;
        localObject3 = ac.ggO().aMP(str);
        if (localObject3 == null) {
          break label1588;
        }
        i = 1;
        if ((localfye.abWf != 0) && (localObject3 != null) && (((com.tencent.mm.bc.f)localObject3).field_ilinkRoomId != 0L) && (localfye.ZnE != ((com.tencent.mm.bc.f)localObject3).field_ilinkRoomId))
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that roomid not mathced wxgroupid %s roomid %d cached roomid %d", new Object[] { str, Long.valueOf(localfye.ZnE), Long.valueOf(((com.tencent.mm.bc.f)localObject3).field_ilinkRoomId) });
          AppMethodBeat.o(285954);
          return;
        }
        if ((localfye.abWf == 2) && (i == 0))
        {
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg change without banner wxgroupid %s roomid %d seq %d", new Object[] { str, Long.valueOf(localfye.ZnE), Long.valueOf(localfye.abWe) });
          AppMethodBeat.o(285954);
          return;
        }
        if ((paramArrayOfByte.Liz.containsKey(str)) && (localfye.abWe < ((Long)paramArrayOfByte.Liz.get(str)).longValue()))
        {
          if (localfye.abWf == 2)
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that expired wxgroupid %s roomid %d seq %d cached seq %d", new Object[] { str, Long.valueOf(localfye.ZnE), Long.valueOf(localfye.abWe), paramArrayOfByte.Liz.get(str) });
            AppMethodBeat.o(285954);
            return;
          }
          if ((localfye.abWf == 1) && (paramArrayOfByte.Liz != null) && (paramArrayOfByte.Liz.size() > 0))
          {
            paramArrayOfByte.Liz.remove(str);
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "remove bannerMsgTimeMap success at begin");
          }
          if ((localfye.abWf != 0) || (i != 1)) {
            break label817;
          }
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "get WxVoiceBannerEnd,dismiss bar!");
          if ((!ac.ggV().aNn(str)) && (ac.ggV().ggx().contains(str)) && (ac.ggV().kl(str, (String)localObject1)))
          {
            ac.ggS();
            com.tencent.mm.plugin.multitalk.model.p.aNk(str);
          }
          ac.ggS().aNj(str);
          ac.ggS().aNf(str);
          ac.ggV().aMV(str);
          ac.ggV().aNm(str);
          ac.ggV().ggx().remove(str);
          if ((paramArrayOfByte.Liz == null) || (paramArrayOfByte.Liz.size() <= 0)) {
            break label1581;
          }
          paramArrayOfByte.Liz.remove(str);
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "remove bannerMsgTimeMap success at end");
          AppMethodBeat.o(285954);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "parse  bannerinfo  failure! xml" + paramArrayOfByte.toString());
        AppMethodBeat.o(285954);
        return;
      }
      paramArrayOfByte.Liz.put(str, Long.valueOf(localfye.abWe));
      continue;
      label817:
      if (localfye.abWf == 1)
      {
        paramArrayOfByte = "";
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "The count of banner member is %d, groupid[%s]", new Object[] { Integer.valueOf(localfye.abWd.size()), str });
        localObject3 = localfye.abWd.iterator();
        int j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          fyz localfyz = (fyz)((Iterator)localObject3).next();
          if (!localfyz.abWu.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + localfyz.abWu.username + ",";
          }
          else
          {
            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", new Object[] { "" });
            j = 1;
          }
        }
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(paramArrayOfByte)));
        if (j == 0)
        {
          ac.ggV().aNm(str);
          ac.ggV().ggx().remove(str);
          if (i == 0)
          {
            if (!((String)localObject1).equals(localObject2)) {
              break label1099;
            }
            ac.ggS().c(str, (String)localObject2, false, false);
          }
        }
        for (;;)
        {
          ac.ggV().a(str, localfye);
          ac.ggR().LnJ.em(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
          AppMethodBeat.o(285954);
          return;
          ac.ggV().ggx().contains(str);
          break;
          label1099:
          if (j != 0) {
            ac.ggS().c(str, (String)localObject2, false, false);
          } else {
            ac.ggS().c(str, (String)localObject2, true, false);
          }
        }
      }
      if (localfye.abWf == 2)
      {
        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange!2,member size : " + localfye.abWd.size());
        paramArrayOfByte = "";
        localObject2 = localfye.abWd.iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (fyz)((Iterator)localObject2).next();
          if (!((fyz)localObject3).abWu.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + ((fyz)localObject3).abWu.username + ",";
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
          if ((!ac.ggV().aNn(str)) && (ac.ggV().ggx().contains(str)) && (ac.ggV().kl(str, (String)localObject1)))
          {
            ac.ggS();
            com.tencent.mm.plugin.multitalk.model.p.aNk(str);
          }
          ac.ggV().aNm(str);
          ac.ggV().ggx().remove(str);
        }
        for (;;)
        {
          ac.ggR().LnJ.em(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
          Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          paramArrayOfByte = ac.ggV();
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { str });
          localObject1 = ac.ggO().aMP(str);
          if (localObject1 == null) {
            break label1564;
          }
          if (((com.tencent.mm.bc.f)localObject1).field_ilinkRoomId == localfye.ZnE) {
            break;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bc.f)localObject1).field_roomId + "bannerinfo.roomid:" + localfye.ZnE);
          AppMethodBeat.o(285954);
          return;
          ac.ggV().ggx().contains(str);
        }
        if (!r.b(str, localfye))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(285954);
          return;
        }
        paramArrayOfByte.aNo(str);
        AppMethodBeat.o(285954);
        return;
        label1564:
        Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        paramArrayOfByte.a(str, localfye);
      }
      label1581:
      AppMethodBeat.o(285954);
      return;
      label1588:
      int i = 0;
    }
  }
  
  public final void d(b<ArrayList<i>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(285985);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger AcceptSucc: %b %b %b", new Object[] { Boolean.valueOf(this.wVP), Boolean.valueOf(this.wVQ), Boolean.valueOf(this.wVR) });
    if ((this.wVP) && (this.wVR) && (this.wVQ))
    {
      if (this.wVG)
      {
        f(paramb);
        AppMethodBeat.o(285985);
        return;
      }
      this.Ljr.drq();
      boolean bool1 = this.Ljq.drq();
      boolean bool2 = this.Ljq.hT(this.Lks);
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      n.abr(i);
      if (bool1)
      {
        i = 0;
        n.abt(i);
        if (!bool2) {
          break label201;
        }
      }
      label201:
      for (i = 0;; i = this.Ljq.gef())
      {
        n.abs(i);
        if ((!bool1) || (!bool2)) {
          break label212;
        }
        c(paramb, 0, 0, "ok");
        AppMethodBeat.o(285985);
        return;
        i = this.Ljq.geg();
        break;
      }
      label212:
      e(paramb);
    }
    AppMethodBeat.o(285985);
  }
  
  public final void drk()
  {
    this.wVP = false;
    this.wVQ = false;
    this.wVR = false;
  }
  
  public final void drn()
  {
    AppMethodBeat.i(286042);
    Log.i("MicroMsg.Multitalk.ILinkService", "hy: onCameraStop");
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284970);
        if (!o.ah(o.this))
        {
          AppMethodBeat.o(284970);
          return;
        }
        o.d(o.this, false);
        l.b(o.ag(o.this), o.ah(o.this), o.ai(o.this));
        AppMethodBeat.o(284970);
      }
    });
    AppMethodBeat.o(286042);
  }
  
  public final void e(ArrayList<String> paramArrayList, final boolean paramBoolean)
  {
    AppMethodBeat.i(286020);
    if (this.Ljt != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.Ljt) });
      AppMethodBeat.o(286020);
      return;
    }
    final ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = this.LiH.aMF((String)localObject);
        if (localObject != null) {
          localArrayList.add(Integer.valueOf(((i)localObject).wTC));
        }
      }
    }
    Log.i("MicroMsg.Multitalk.ILinkService", "subscribeScreenByUsernames, screen midlist:%s,memberName%s", new Object[] { localArrayList, paramArrayList });
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284971);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284971);
          return;
        }
        LinkedList localLinkedList1 = new LinkedList();
        LinkedList localLinkedList2 = new LinkedList();
        Object localObject1;
        Object localObject2;
        fkj localfkj;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            localfkj = new fkj();
            localfkj.ZnB = ((Integer)localObject2).intValue();
            localfkj.abLl = this.LlE;
            localLinkedList2.add(localfkj);
            Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localObject2 });
          }
        }
        if (paramBoolean)
        {
          localObject1 = o.d(o.this).geh();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (i)((Iterator)localObject1).next();
              if (o.u(o.this).equals(((i)localObject2).luk))
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(((i)localObject2).wTC), ((i)localObject2).luk });
              }
              else
              {
                int i = ((i)localObject2).wTC;
                localfkj = new fkj();
                localfkj.ZnB = i;
                localfkj.abLl = 480;
                int j = o.this.abo(i);
                if ((j == 102) || (j == 101))
                {
                  localfkj.abLl = 240;
                  localLinkedList2.add(localfkj);
                }
                for (;;)
                {
                  Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), ((i)localObject2).luk });
                  break;
                  localLinkedList1.add(localfkj);
                }
              }
            }
          }
        }
        o.af(o.this).Ids = localLinkedList1;
        if (ac.ggS().ggc().Lpu) {}
        for (o.af(o.this).abLk = localLinkedList2;; o.af(o.this).abLk = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeScreenByUserMids, videoMembers %s", new Object[] { o.af(o.this) });
          l.a(o.af(o.this));
          AppMethodBeat.o(284971);
          return;
        }
      }
    });
    AppMethodBeat.o(286020);
  }
  
  public final void geA()
  {
    AppMethodBeat.i(286111);
    Log.i("MicroMsg.Multitalk.ILinkService", "In networkRequestViaCellular");
    if (com.tencent.mm.compatible.util.d.rb(21))
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
            AppMethodBeat.i(285230);
            super.onAvailable(paramAnonymousNetwork);
            Object localObject = Parcel.obtain();
            paramAnonymousNetwork.writeToParcel((Parcel)localObject, 0);
            Log.i("MicroMsg.Multitalk.ILinkService", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramAnonymousNetwork.toString());
            if (com.tencent.mm.compatible.util.d.rb(28)) {
              localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            }
            try
            {
              Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference ret ".concat(String.valueOf(((ConnectivityManager)localObject).getMultipathPreference(paramAnonymousNetwork))));
              o.this.Lkt = paramAnonymousNetwork;
              if (o.this.Lkv != null) {
                while (i < o.this.Lkv.size())
                {
                  o.this.bk(((Integer)o.this.Lkv.get(i)).intValue(), true);
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
                AppMethodBeat.o(285230);
                return;
              }
              catch (Exception paramAnonymousNetwork)
              {
                Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
                AppMethodBeat.o(285230);
                return;
              }
              o.this.Lku = this;
              Log.i("MicroMsg.Multitalk.ILinkService", "networkcallback hashCode: " + o.this.Lku.hashCode());
              AppMethodBeat.o(285230);
            }
          }
        });
        AppMethodBeat.o(286111);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "missing the appropriate permissions");
        AppMethodBeat.o(286111);
        return;
      }
    }
    AppMethodBeat.o(286111);
  }
  
  public final com.tencent.mm.plugin.multitalk.b.b gep()
  {
    AppMethodBeat.i(285910);
    Object localObject = this.Ljq;
    if (((e)localObject).LiI == null)
    {
      ((e)localObject).LiI = new com.tencent.mm.plugin.multitalk.b.a();
      ac.ggS().LoD = ((e)localObject).LiI;
    }
    localObject = ((e)localObject).LiI;
    AppMethodBeat.o(285910);
    return localObject;
  }
  
  final void ges()
  {
    AppMethodBeat.i(285988);
    this.LjD = new k.a()
    {
      private static afq bw(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(285042);
        afq localafq = new afq();
        try
        {
          localafq.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(285042);
          return localafq;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(285042);
        }
        return null;
      }
      
      public final boolean drh()
      {
        return true;
      }
    };
    this.Ljp.a(20, this.LjD);
    this.LjF = new k.a()
    {
      private static afh bx(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(285018);
        afh localafh = new afh();
        try
        {
          localafh.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(285018);
          return localafh;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(285018);
        }
        return null;
      }
      
      public final boolean drh()
      {
        return true;
      }
    };
    this.Ljp.a(21, this.LjF);
    this.LjB = new k.a()
    {
      public final boolean drh()
      {
        return true;
      }
    };
    this.Ljp.a(24, this.LjB);
    this.LjC = new k.a()
    {
      private static byte[] a(afj paramAnonymousafj)
      {
        AppMethodBeat.i(285013);
        if (paramAnonymousafj != null) {
          try
          {
            paramAnonymousafj = paramAnonymousafj.toByteArray();
            AppMethodBeat.o(285013);
            return paramAnonymousafj;
          }
          catch (IOException paramAnonymousafj)
          {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousafj, "hy: error when convert to byte array", new Object[0]);
          }
        }
        AppMethodBeat.o(285013);
        return new byte[0];
      }
      
      public final boolean drh()
      {
        return true;
      }
    };
    this.Ljp.a(25, this.LjC);
    j localj = this.LiH;
    j.a local17 = new j.a()
    {
      public final void V(final ArrayList<i> paramAnonymousArrayList)
      {
        AppMethodBeat.i(285014);
        Log.v("MicroMsg.Multitalk.ILinkService", "hy: current talking members are %s", new Object[] { paramAnonymousArrayList });
        o.this.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(285083);
            if (o.F(o.this) != 1)
            {
              Log.w("MicroMsg.Multitalk.ILinkService", "hy: onSpeakerListChanged but not in room!");
              AppMethodBeat.o(285083);
              return;
            }
            if (o.ac(o.this) != null) {
              o.ac(o.this).a(0, 0, "on talklist change", paramAnonymousArrayList);
            }
            AppMethodBeat.o(285083);
          }
        });
        AppMethodBeat.o(285014);
      }
    };
    synchronized (localj.wUu)
    {
      localj.wUu.add(local17);
      ??? = this.LiH;
      ((j)???).wUv = com.tencent.threadpool.h.ahAA.b(((j)???).Ljb, 1000L, 1000L);
      this.LjG = new k.a()
      {
        public final boolean drh()
        {
          return true;
        }
      };
      this.Ljp.a(27, this.LjG);
      this.LjH = new k.a()
      {
        public final boolean drh()
        {
          return true;
        }
      };
      this.Ljp.a(31, this.LjH);
      AppMethodBeat.o(285988);
      return;
    }
  }
  
  public final void geu()
  {
    AppMethodBeat.i(286004);
    if (this.Ljt != 1)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.Ljt) });
      AppMethodBeat.o(286004);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.LiH.geh();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(286004);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      if (this.Lke.equals(locali.luk))
      {
        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(locali.wTC), locali.luk });
      }
      else
      {
        int i = locali.wTC;
        fkj localfkj = new fkj();
        localfkj.ZnB = i;
        localfkj.abLl = 480;
        int j = abo(i);
        if ((j == 102) || (j == 101))
        {
          localfkj.abLl = 240;
          localLinkedList2.add(localfkj);
        }
        for (;;)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), locali.luk });
          break;
          localLinkedList1.add(localfkj);
        }
      }
    }
    this.Lkr.Ids = localLinkedList1;
    if (ac.ggS().ggc().Lpu) {}
    for (this.Lkr.abLk = localLinkedList2;; this.Lkr.abLk = null)
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribe, videoMembers %s", new Object[] { localArrayList });
      l.a(this.Lkr);
      AppMethodBeat.o(286004);
      return;
    }
  }
  
  public final List<String> gew()
  {
    AppMethodBeat.i(286062);
    Object localObject = this.LiH.geh();
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(286062);
      return null;
    }
    if (this.Ljt != 1)
    {
      AppMethodBeat.o(286062);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      if (a(locali))
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(locali.wTC), locali.luk });
        localArrayList.add(locali.luk);
      }
    }
    AppMethodBeat.o(286062);
    return localArrayList;
  }
  
  public final Map<String, Integer> gex()
  {
    AppMethodBeat.i(286071);
    Object localObject = this.LiH.geh();
    HashMap localHashMap = new HashMap();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(286071);
      return null;
    }
    if (this.Ljt != 1)
    {
      AppMethodBeat.o(286071);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      int i = l.Jf(locali.wTC);
      if (i > 0)
      {
        Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingEnergyMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(locali.wTC), locali.luk });
        localHashMap.put(locali.luk, Integer.valueOf(i));
      }
    }
    AppMethodBeat.o(286071);
    return localHashMap;
  }
  
  public final List<String> gey()
  {
    AppMethodBeat.i(286081);
    Object localObject = this.LiH.geh();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (this.Ljt == 1))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        byte[] arrayOfByte = new byte[4];
        if (l.Y(arrayOfByte, locali.wTC) >= 0)
        {
          int i = Util.byteArrayToInt(arrayOfByte);
          Log.d("MicroMsg.Multitalk.ILinkService", "netStatus: %d", new Object[] { Integer.valueOf(i) });
          if ((i != -1) && (i <= 3)) {
            localArrayList.add(locali.luk);
          }
        }
      }
    }
    AppMethodBeat.o(286081);
    return localArrayList;
  }
  
  final void gez()
  {
    AppMethodBeat.i(286099);
    m localm = m.Ljg;
    this.Lki = m.gen();
    AppMethodBeat.o(286099);
  }
  
  public final int i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(286055);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.wVN)
    {
      if (l.d(EMethodGetQosPara, this.LiO.s2p, this.LiO.s2p.length) >= 0)
      {
        localObject1 = this.LiO;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).wTD = ((ByteBuffer)localObject2).get();
        ((a)localObject1).wTE = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = this.LiO;
        Log.d("ILink[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        Log.d("ILink[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).wTD + ", HWEnable:" + ((a)localObject1).wTE + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (this.wVN) {
        if (8 == this.LiO.wTD)
        {
          this.wVO = true;
          if (this.LiO.wTE == 0)
          {
            this.wVN = false;
            this.wVO = false;
          }
          if ((1 != this.LiO.cSkipFlag) && (this.wVN) && (this.wVO)) {
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
      if (this.wVO)
      {
        if ((this.Lko == null) || (i != 0)) {
          break label898;
        }
        paramInt1 = this.Lko.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if (paramInt1 >= 0) {
          paramInt1 = j;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(286055);
        return paramInt1;
        this.wVO = false;
        break;
        this.wVO = false;
        break;
        label470:
        if ((this.wVN) && (this.Lko == null)) {
          this.Lko = new g(this.LiO.cFps, this.LiO.iKbps, "video/avc");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject1 = this.Lko;
          localObject2 = this.LiO;
          if ((((g)localObject1).LiO != null) && (((g)localObject1).wUb != null))
          {
            a locala = ((g)localObject1).LiO;
            locala.iKbps = ((a)localObject2).iKbps;
            locala.cFps = ((a)localObject2).cFps;
            locala.cIPeriod = ((a)localObject2).cIPeriod;
            locala.cResolution = ((a)localObject2).cResolution;
            locala.wTD = ((a)localObject2).wTD;
            locala.wTE = ((a)localObject2).wTE;
            locala.cSkipFlag = ((a)localObject2).cSkipFlag;
            locala.cIReqFlag = ((a)localObject2).cIReqFlag;
            locala.cRsvd1 = ((a)localObject2).cRsvd1;
            i = (int)(((g)localObject1).LiO.iKbps * 1.1D);
            if (((g)localObject1).m_br_kbps != i)
            {
              ((g)localObject1).SetBitRate(i);
              Log.i("ILink[HWEnc]", "steve[QoS]: Update BR! frameID: " + g.frameID + ", new_br: " + ((g)localObject1).m_br_kbps + ", tuneBR:" + i);
              ((g)localObject1).m_br_kbps = i;
            }
            if ((1 == ((g)localObject1).LiO.cIReqFlag) && (g.frameID > 0))
            {
              if (((g)localObject1).wUb != null)
              {
                Log.v("ILink[HWEnc]", "steve: Sync frame request soon!");
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("request-sync", 0);
                ((g)localObject1).wUb.setParameters((Bundle)localObject2);
              }
              Log.i("ILink[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + g.frameID);
            }
            if (((g)localObject1).LiO.cFps != ((g)localObject1).m_framerate) {
              ((g)localObject1).m_framerate = ((g)localObject1).LiO.cFps;
            }
          }
        }
        label854:
        i = 0;
        break label407;
        Log.e("MicroMsg.Multitalk.ILinkService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        this.wVO = false;
        paramInt1 = -1;
        continue;
        paramInt1 = l.e(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        continue;
        label898:
        paramInt1 = -1;
      }
      i = 0;
    }
  }
  
  public final void nt(final boolean paramBoolean)
  {
    AppMethodBeat.i(286032);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      Log.i("MicroMsg.Multitalk.ILinkService", "onMicSwitch: %s", new Object[] { str });
      au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284978);
          l.b(paramBoolean, o.ah(o.this), o.ai(o.this));
          AppMethodBeat.o(284978);
        }
      });
      AppMethodBeat.o(286032);
      return;
    }
  }
  
  public final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(285904);
    try
    {
      this.Ljq.release();
      if ((paramBoolean) && (this.Ljt == 1))
      {
        this.Ljq.init();
        boolean bool1 = this.Ljq.drq();
        boolean bool2 = this.Ljq.hT(this.Lks);
        if ((bool1) && (bool2)) {
          Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive restart audio device OK!");
        }
      }
      Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(285904);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: " + paramBoolean + ", error:" + localObject);
      AppMethodBeat.o(285904);
    }
  }
  
  public final void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(286037);
    if ((this.Ljq.LiF != null) && (ac.ggS().LoD != null)) {
      ac.ggS().LoD.yJ(paramBoolean);
    }
    AppMethodBeat.o(286037);
  }
  
  public final void z(final Integer paramInteger)
  {
    AppMethodBeat.i(286011);
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284972);
        if (o.F(o.this) != 1)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284972);
          return;
        }
        if (paramInteger.intValue() < 0)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(o.F(o.this)) });
          AppMethodBeat.o(284972);
          return;
        }
        int i;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        fkj localfkj;
        if (this.LlB)
        {
          i = 640;
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          localfkj = new fkj();
          localfkj.ZnB = paramInteger.intValue();
          localfkj.abLl = i;
          i = o.this.abo(paramInteger.intValue());
          if ((i != 102) && (i != 101)) {
            break label291;
          }
          localLinkedList2.add(localfkj);
          label174:
          Log.i("MicroMsg.Multitalk.ILinkService", "subscribeOneByUserMid, videoMembers memberId:%d", new Object[] { paramInteger });
          o.af(o.this).Ids = localLinkedList1;
          if (!ac.ggS().ggc().Lpu) {
            break label301;
          }
          if ((i == 102) || (i == 101)) {
            localfkj.abLl = 240;
          }
        }
        label291:
        label301:
        for (o.af(o.this).abLk = localLinkedList2;; o.af(o.this).abLk = null)
        {
          Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeOneByUserMid, videoMembers %s", new Object[] { o.af(o.this) });
          l.a(o.af(o.this));
          AppMethodBeat.o(284972);
          return;
          i = 480;
          break;
          localLinkedList1.add(localfkj);
          break label174;
        }
      }
    });
    AppMethodBeat.o(286011);
  }
  
  public static enum a
  {
    final int eJM;
    
    static
    {
      AppMethodBeat.i(285084);
      LlN = new a("ReasonInterrupted", 0, 0);
      LlO = new a("ReasonManual", 1, 1);
      LlP = new a("ReasonDevice", 2, 2);
      LlQ = new a("ReasonInCommingCall", 3, 3);
      LlR = new a("ReasonSessionUpdateFailed", 4, 4);
      LlS = new a("ReasonWeappEnterBackground", 5, 5);
      LlT = new a("ReasonUnknown", 6, 100);
      LlU = new a[] { LlN, LlO, LlP, LlQ, LlR, LlS, LlT };
      AppMethodBeat.o(285084);
    }
    
    private a(int paramInt)
    {
      this.eJM = paramInt;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(285077);
      LlV = new b("ILinkMemberRoleUnknown", 0);
      LlW = new b("ILinkMemberRoleCreate", 1);
      LlX = new b("ILinkMemberRoleAccept", 2);
      LlY = new b("ILinkMemberRoleJoin", 3);
      LlZ = new b[] { LlV, LlW, LlX, LlY };
      AppMethodBeat.o(285077);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.o
 * JD-Core Version:    0.7.0.1
 */