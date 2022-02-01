package com.tencent.mm.plugin.multitalk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wxmm.IConfCallBack;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
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
  private aq hXp;
  private final aq krf;
  String lbB;
  private boolean mIsInit;
  boolean peA;
  private long peC;
  public boolean peE;
  private int peF;
  public boolean peH;
  public boolean peI;
  public boolean peJ;
  private boolean peK;
  private boolean peL;
  private final int peM;
  public Runnable peN;
  private String peg;
  private int pei;
  public int pej;
  public boolean pex;
  String rhB;
  private final r wmP;
  public final l wmQ;
  public final f wmR;
  public final t wmS;
  private final i wmT;
  int wmU;
  a wmV;
  private int wmW;
  private int wmX;
  private b<a> wmY;
  private b<ArrayList<j>> wmZ;
  public final k wmo;
  private a wms;
  private long wnA;
  String wnB;
  String wnC;
  int wnD;
  private boolean wnE;
  private boolean wnF;
  private boolean wnG;
  private LinkedList<dxw> wnH;
  public b wnI;
  public h wnJ;
  LinkedList<aas> wnK;
  private boolean wnL;
  private dlv wnM;
  public Map<Long, dxn> wnN;
  private l.a wna;
  private l.a wnb;
  private l.a wnc;
  private l.a wnd;
  private l.a wne;
  l.a wnf;
  l.a wng;
  public l.a wnh;
  public l.a wni;
  private l.a wnj;
  private l.a wnk;
  private l.a wnl;
  private l.a wnm;
  private l.a wnn;
  private l.a wno;
  private l.a wnp;
  private l.a wnq;
  private l.a wnr;
  private l.a wns;
  public l.a wnt;
  public l.a wnu;
  private l.a wnv;
  private l.a wnw;
  private b<String> wnx;
  private d wny;
  String wnz;
  
  static
  {
    AppMethodBeat.i(190704);
    wmO = new p("INSTANCE");
    wnO = new p[] { wmO };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(190704);
  }
  
  private p()
  {
    AppMethodBeat.i(190648);
    this.pei = 0;
    this.pej = 1;
    this.wmW = 2;
    this.wmX = 160;
    this.wny = null;
    this.peC = -1L;
    this.peE = false;
    this.peF = 0;
    this.wnB = "";
    this.wnC = "";
    this.wnD = 4;
    this.wnE = false;
    this.wnF = false;
    this.wnG = false;
    this.rhB = null;
    this.wnI = b.wpg;
    this.wnJ = null;
    this.wms = null;
    this.wnK = null;
    this.wnL = false;
    this.wnM = null;
    this.hXp = new aq(Looper.getMainLooper())
    {
      TelephonyManager peP;
      PhoneStateListener peQ;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(190522);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.peP == null)
          {
            this.peP = ((TelephonyManager)ak.getContext().getSystemService("phone"));
            this.peQ = new PhoneStateListener()
            {
              public final void onCallStateChanged(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(190521);
                super.onCallStateChanged(paramAnonymous2Int, paramAnonymous2String);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(190521);
                  return;
                  p.this.ad(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(190520);
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: hy: phone broken. exit room if in room");
                      p.a(p.this, p.a.wpb);
                      AppMethodBeat.o(190520);
                    }
                  });
                }
              }
            };
          }
          this.peP.listen(this.peQ, 32);
        }
        AppMethodBeat.o(190522);
      }
    };
    this.wnN = new ConcurrentHashMap();
    this.peJ = false;
    this.peK = false;
    this.peL = false;
    this.peM = -9999;
    this.peN = new p.27(this);
    this.wmP = new r();
    this.wmQ = new l();
    this.wmo = new k();
    this.wmR = new f(this.wmo);
    this.wmS = new t(this.wmo);
    this.wmT = new i();
    this.wny = new d(com.tencent.mm.plugin.multitalk.model.z.dtK());
    this.krf = new aq("ILink_voip_worker");
    this.wmU = 0;
    this.lbB = null;
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", null, p.c.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.Multitalk.ILinkService", "hy: updatad device info %s", new Object[] { localObject });
      com.tencent.mm.compatible.deviceinfo.ae.vE((String)localObject);
    }
    for (;;)
    {
      this.pex = false;
      this.mIsInit = false;
      this.pei = 0;
      this.pej = 1;
      this.wmW = 2;
      this.wmX = 160;
      this.peA = false;
      this.wnx = null;
      this.wnJ = null;
      this.peH = false;
      this.peI = false;
      this.wms = new a();
      this.wnI = b.wpg;
      this.wnF = false;
      this.wnK = null;
      this.wnL = false;
      this.peE = false;
      this.wnM = new dlv();
      AppMethodBeat.o(190648);
      return;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkService", "hy: can not get device info from mm");
    }
  }
  
  static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190683);
    paramInt = m.P(paramArrayOfByte, paramInt);
    AppMethodBeat.o(190683);
    return paramInt;
  }
  
  static int W(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190677);
    paramInt = m.U(paramArrayOfByte, paramInt);
    AppMethodBeat.o(190677);
    return paramInt;
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(190668);
    switch (36.woS[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(190668);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(190668);
      return 0;
    case 4: 
      AppMethodBeat.o(190668);
      return 1;
    case 5: 
      AppMethodBeat.o(190668);
      return 6;
    case 6: 
      AppMethodBeat.o(190668);
      return 8;
    }
    AppMethodBeat.o(190668);
    return 7;
  }
  
  public static u a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190676);
    paramArrayOfByte = m.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(190676);
    return paramArrayOfByte;
  }
  
  private void a(b<ArrayList<j>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(190651);
    this.pex = false;
    synchronized (this.wmQ)
    {
      this.wmQ.b(3, this.wnf);
      this.wmQ.b(4, this.wng);
      this.wmQ.b(21, this.wnh);
      this.wmQ.b(22, this.wni);
      this.wnf = null;
      this.wng = null;
      this.wnh = null;
      this.wni = null;
      ??? = this.wmo.drI();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wmU = 1;
        AppMethodBeat.o(190651);
        return;
      }
    }
    this.wny.bv(2, this.wnB);
    AppMethodBeat.o(190651);
  }
  
  static boolean a(j paramj)
  {
    AppMethodBeat.i(190678);
    if (m.Bm(paramj.pcE) == 1)
    {
      AppMethodBeat.o(190678);
      return true;
    }
    AppMethodBeat.o(190678);
    return false;
  }
  
  private void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(190667);
    this.krf.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(190667);
  }
  
  private int ase(String paramString)
  {
    AppMethodBeat.i(190658);
    IConfCallBack localIConfCallBack = this.wmQ.jH(false);
    int i = m.a(paramString, this.pei, this.wmW, this.wmX, localIConfCallBack);
    this.wnd = new p.8(this);
    this.wmQ.a(25, this.wnd);
    AppMethodBeat.o(190658);
    return i;
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(190669);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.wmV = parama;
    if (this.pex)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Multitalk.ILinkService", "hy: current joining room. waiting for exiting after joining");
      this.peA = true;
      AppMethodBeat.o(190669);
      return -9999;
    }
    if (this.wmU == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Multitalk.ILinkService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(190669);
      return 0;
    }
    int i = m.Bn(a(parama));
    cbr();
    AppMethodBeat.o(190669);
    return i;
  }
  
  private void b(b<ArrayList<j>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(190652);
    this.pex = false;
    synchronized (this.wmQ)
    {
      this.wmQ.b(5, this.wnj);
      this.wmQ.b(6, this.wnk);
      this.wmQ.b(21, this.wnh);
      this.wmQ.b(22, this.wni);
      this.wmQ.b(7, this.wnn);
      this.wnj = null;
      this.wnk = null;
      this.wnh = null;
      this.wni = null;
      this.wnn = null;
      ??? = this.wmo.drI();
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wmU = 1;
        AppMethodBeat.o(190652);
        return;
      }
    }
    this.wny.bv(16, this.wnB);
    AppMethodBeat.o(190652);
  }
  
  public static void bt(byte[] paramArrayOfByte)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(190655);
    dxc localdxc = new dxc();
    String str;
    try
    {
      localdxc.parseFrom(paramArrayOfByte);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "got banner msg from wxgroupid %s sdkgroupid %s roomid %d seq %d status %d", new Object[] { localdxc.Icy, localdxc.Icz, Long.valueOf(localdxc.Gsg), Long.valueOf(localdxc.IcB), Integer.valueOf(localdxc.IcC) });
      com.tencent.mm.plugin.multitalk.model.z.dtK().ey(localdxc.Icy, 2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "onMultiTalkBannerChange:%s, status:%d, banner seq:%d", new Object[] { localdxc.Icy, Integer.valueOf(localdxc.IcC), Long.valueOf(localdxc.IcB) });
      str = localdxc.Icy;
      if ((localdxc.Icy == null) || (localdxc.Icy == ""))
      {
        AppMethodBeat.o(190655);
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(190655);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (String)g.ajR().ajA().get(2, null);
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILink2MtCallBack", "userName is null");
          AppMethodBeat.o(190655);
          return;
        }
        localObject2 = localdxc.IcD;
        if (com.tencent.mm.plugin.multitalk.model.z.dtG().asp(str) == null) {
          break label1172;
        }
        i = 1;
        if ((localdxc.IcC == 0) && (i == 1))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "get WxVoiceBannerEnd,dismiss bar!");
          if ((!com.tencent.mm.plugin.multitalk.model.z.dtL().asI(str)) && (com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().contains(str)) && (com.tencent.mm.plugin.multitalk.model.z.dtL().ic(str, (String)localObject1)))
          {
            com.tencent.mm.plugin.multitalk.model.z.dtK();
            o.asE(str);
          }
          com.tencent.mm.plugin.multitalk.model.z.dtK().asD(str);
          com.tencent.mm.plugin.multitalk.model.z.dtL().asv(str);
          com.tencent.mm.plugin.multitalk.model.z.dtL().asH(str);
          com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().remove(str);
          AppMethodBeat.o(190655);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILink2MtCallBack", "parse  bannerinfo  failure! xml" + paramArrayOfByte.toString());
        AppMethodBeat.o(190655);
        return;
      }
      Object localObject3;
      if ((localdxc.IcC == 1) && (i == 0))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "The count of banner member is %d, groupid[%s]", new Object[] { Integer.valueOf(localdxc.IcA.size()), str });
        localObject3 = localdxc.IcA.iterator();
        paramArrayOfByte = "";
        i = j;
        while (((Iterator)localObject3).hasNext())
        {
          dxx localdxx = (dxx)((Iterator)localObject3).next();
          if (!localdxx.IcQ.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + localdxx.IcQ.username + ",";
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", new Object[] { "" });
            i = 1;
          }
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(paramArrayOfByte)));
        if (i == 0)
        {
          com.tencent.mm.plugin.multitalk.model.z.dtL().asH(str);
          com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().remove(str);
          if (!((String)localObject1).equals(localObject2)) {
            break label683;
          }
          com.tencent.mm.plugin.multitalk.model.z.dtK().d(str, (String)localObject2, false, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.multitalk.model.z.dtL().a(str, localdxc);
          com.tencent.mm.plugin.multitalk.model.z.dtJ().wqE.cW(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
          AppMethodBeat.o(190655);
          return;
          com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().contains(str);
          break;
          label683:
          if (i != 0) {
            com.tencent.mm.plugin.multitalk.model.z.dtK().d(str, (String)localObject2, false, false);
          } else {
            com.tencent.mm.plugin.multitalk.model.z.dtK().d(str, (String)localObject2, true, false);
          }
        }
      }
      if (localdxc.IcC == 2)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange!2,member size : " + localdxc.IcA.size());
        localObject2 = localdxc.IcA.iterator();
        paramArrayOfByte = "";
        i = k;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (dxx)((Iterator)localObject2).next();
          if (!((dxx)localObject3).IcQ.username.equals(localObject1))
          {
            paramArrayOfByte = paramArrayOfByte + ((dxx)localObject3).IcQ.username + ",";
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", new Object[] { "" });
            i = 1;
          }
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(paramArrayOfByte)));
        if (i == 0)
        {
          if ((!com.tencent.mm.plugin.multitalk.model.z.dtL().asI(str)) && (com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().contains(str)) && (com.tencent.mm.plugin.multitalk.model.z.dtL().ic(str, (String)localObject1)))
          {
            com.tencent.mm.plugin.multitalk.model.z.dtK();
            o.asE(str);
          }
          com.tencent.mm.plugin.multitalk.model.z.dtL().asH(str);
          com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().remove(str);
        }
        for (;;)
        {
          com.tencent.mm.plugin.multitalk.model.z.dtJ().wqE.cW(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange setWxUinAndUsrName:");
          paramArrayOfByte = com.tencent.mm.plugin.multitalk.model.z.dtL();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[] { str });
          localObject1 = com.tencent.mm.plugin.multitalk.model.z.dtG().asp(str);
          if (localObject1 == null) {
            break label1148;
          }
          if (((com.tencent.mm.bh.f)localObject1).field_ilinkRoomId == localdxc.Gsg) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + ((com.tencent.mm.bh.f)localObject1).field_roomId + "bannerinfo.roomid:" + localdxc.Gsg);
          AppMethodBeat.o(190655);
          return;
          com.tencent.mm.plugin.multitalk.model.z.dtL().dtw().contains(str);
        }
        if (!q.b(str, localdxc))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
          AppMethodBeat.o(190655);
          return;
        }
        paramArrayOfByte.asJ(str);
        AppMethodBeat.o(190655);
        return;
        label1148:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
        paramArrayOfByte.a(str, localdxc);
      }
      AppMethodBeat.o(190655);
      return;
      label1172:
      int i = 0;
    }
  }
  
  private void c(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(190660);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger InviteSucc: %b %b %b %b %b", new Object[] { Boolean.valueOf(this.peJ), Boolean.valueOf(this.peK), Boolean.valueOf(this.peL), Boolean.valueOf(this.wnE), Boolean.valueOf(this.wnF) });
    if ((this.peJ) && (this.peL) && (this.peK) && (this.wnE) && (!this.wnF))
    {
      if (this.peA)
      {
        f(paramb);
        AppMethodBeat.o(190660);
        return;
      }
      this.wmS.cbu();
      boolean bool1 = this.wmR.cbu();
      boolean bool2 = this.wmR.PO();
      if ((bool1) && (bool2))
      {
        i = 0;
        o.pdP = i;
        if (!bool1) {
          break label220;
        }
        i = 0;
        label169:
        o.pdR = i;
        if (!bool2) {
          break label231;
        }
      }
      label220:
      label231:
      for (int i = 0;; i = this.wmR.pcI.dhN)
      {
        o.pdQ = i;
        if ((!bool1) || (!bool2)) {
          break label245;
        }
        b(paramb, 0, 0, "ok");
        this.wnF = true;
        AppMethodBeat.o(190660);
        return;
        i = 1;
        break;
        i = this.wmR.drH();
        break label169;
      }
      label245:
      e(paramb);
    }
    AppMethodBeat.o(190660);
  }
  
  private void cbq()
  {
    AppMethodBeat.i(190665);
    this.wmo.pdr.clear();
    this.wmo.drJ();
    this.wmR.release();
    this.wmS.release();
    synchronized (this.wmQ)
    {
      this.wmQ.b(23, this.wna);
      this.wmQ.b(24, this.wnb);
      this.wmQ.b(19, this.wnc);
      this.wna = null;
      this.wnb = null;
      this.wnc = null;
      this.wnd = null;
      AppMethodBeat.o(190665);
      return;
    }
  }
  
  private void cbr()
  {
    AppMethodBeat.i(190673);
    ae(this.peN);
    AppMethodBeat.o(190673);
  }
  
  private void drL()
  {
    AppMethodBeat.i(190654);
    synchronized (this.wmQ)
    {
      this.wmQ.b(8, this.wno);
      this.wmQ.b(9, this.wnp);
      this.wmQ.b(11, this.wnq);
      this.wmQ.b(16, this.wnv);
      this.wno = null;
      this.wnp = null;
      this.wnq = null;
      this.wnv = null;
      AppMethodBeat.o(190654);
      return;
    }
  }
  
  private int drO()
  {
    AppMethodBeat.i(190674);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.TRUE });
    this.wmP.aaB(this.lbB);
    o.pdP = 0;
    o.pdQ = 0;
    o.pdR = 0;
    o.pdS = 0;
    o.pdT = 0;
    o.pdU = 0;
    o.pdV = 0;
    o.pdW = 0;
    o.pdX = 0;
    this.lbB = null;
    this.peg = null;
    cbq();
    this.mIsInit = false;
    this.wnF = false;
    this.pex = false;
    n.wmK.cdt();
    int i = m.cbo();
    AppMethodBeat.o(190674);
    return i;
  }
  
  private void e(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(190662);
    this.wny.bv(4, this.wnB);
    a(paramb, -10086, -7, "start audio device failed");
    b(a.wpa);
    AppMethodBeat.o(190662);
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(190682);
    paramInt1 = m.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(190682);
    return paramInt1;
  }
  
  private void f(b<ArrayList<j>> paramb)
  {
    AppMethodBeat.i(190663);
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Multitalk.ILinkService", "hy: require exit. try exit exit again");
    a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
    int i = b(this.wmV);
    if (this.wnx != null)
    {
      if (i != 0) {
        break label82;
      }
      this.wnx.a(0, 0, "ok", "");
    }
    for (;;)
    {
      this.peA = false;
      this.wnx = null;
      AppMethodBeat.o(190663);
      return;
      label82:
      this.wnx.a(-10086, -17, "exit failed", "");
    }
  }
  
  static void w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190681);
    m.v(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(190681);
  }
  
  final void Br(int paramInt)
  {
    AppMethodBeat.i(190684);
    this.wnD = paramInt;
    m.Bo(paramInt);
    AppMethodBeat.o(190684);
  }
  
  public final void Lb(final int paramInt)
  {
    AppMethodBeat.i(190656);
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190540);
        m.KY(paramInt);
        AppMethodBeat.o(190540);
      }
    });
    AppMethodBeat.o(190656);
  }
  
  public final void a(final b<String> paramb)
  {
    AppMethodBeat.i(190657);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: initsession : isInit :%b ", new Object[] { Boolean.valueOf(this.mIsInit) });
    if (!this.mIsInit)
    {
      b.a locala = new b.a();
      locala.hQF = new dxf();
      locala.hQG = new dxg();
      locala.funcId = 573;
      locala.uri = "/cgi-bin/micromsg-bin/voipmtgetauthcode";
      locala.hQH = 0;
      locala.respCmdId = 0;
      IPCRunCgi.a(locala.aDS(), new IPCRunCgi.a()
      {
        public final void a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(190547);
          p.this.ad(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190546);
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hQE.hQJ == null))
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
                AppMethodBeat.o(190546);
                return;
              }
              String str = ((dxg)paramAnonymousb.hQE.hQJ).IcG.fjO();
              p.g(p.this, new l.a()
              {
                public final boolean cbm()
                {
                  return true;
                }
              });
              p.h(p.this, new l.a()
              {
                public final boolean cbm()
                {
                  return true;
                }
              });
              p.m(p.this).a(1, p.z(p.this));
              p.m(p.this).a(2, p.A(p.this));
              int i = p.d(p.this, str);
              if (i != 0)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "initEngine failed ret=", new Object[] { Integer.valueOf(i) });
                if (p.6.this.wod != null)
                {
                  if (-2 == i)
                  {
                    p.6.this.wod.a(0, 0, null, null);
                    AppMethodBeat.o(190546);
                    return;
                  }
                  p.6.this.wod.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
                }
                AppMethodBeat.o(190546);
                return;
              }
              AppMethodBeat.o(190546);
            }
          });
          AppMethodBeat.o(190547);
        }
      });
      AppMethodBeat.o(190657);
      return;
    }
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190548);
        n.wmK.cds();
        if (paramb != null) {
          paramb.a(0, 0, null, null);
        }
        AppMethodBeat.o(190548);
      }
    });
    AppMethodBeat.o(190657);
  }
  
  public final void aT(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(224112);
    if (this.wmU != 1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.wmU) });
      AppMethodBeat.o(224112);
      return;
    }
    final ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = this.wmo.asd((String)localObject);
        if (localObject != null) {
          localArrayList.add(Integer.valueOf(((j)localObject).pcE));
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "subscribeScreenByUsernames, screen midlist:%s,memberName%s", new Object[] { localArrayList, paramArrayList });
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190616);
        if (p.C(p.this) != 1)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(p.C(p.this)) });
          AppMethodBeat.o(190616);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            dlw localdlw = new dlw();
            localdlw.Gsd = localInteger.intValue();
            localdlw.HTz = this.woQ;
            localLinkedList.add(localdlw);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localInteger });
          }
        }
        p.ad(p.this).HTy = localLinkedList;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeScreenByUserMids, videoMembers %s", new Object[] { p.ad(p.this) });
        m.a(p.ad(p.this));
        AppMethodBeat.o(190616);
      }
    });
    AppMethodBeat.o(224112);
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(190666);
    if (this.krf.getSerialTag().equals(com.tencent.e.j.a.gau()))
    {
      paramRunnable.run();
      AppMethodBeat.o(190666);
      return;
    }
    this.krf.post(paramRunnable);
    AppMethodBeat.o(190666);
  }
  
  public final void al(final ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(190672);
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190615);
        if (p.C(p.this) != 1)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(p.C(p.this)) });
          AppMethodBeat.o(190615);
          return;
        }
        if (paramArrayList == null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", new Object[] { Integer.valueOf(p.C(p.this)) });
          AppMethodBeat.o(190615);
          return;
        }
        if ((paramArrayList.size() == 1) && (!this.woO))
        {
          p.this.drN();
          AppMethodBeat.o(190615);
          return;
        }
        if (this.woO) {}
        LinkedList localLinkedList;
        for (int i = 640;; i = 160)
        {
          localLinkedList = new LinkedList();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            dlw localdlw = new dlw();
            localdlw.Gsd = localInteger.intValue();
            localdlw.HTz = i;
            localLinkedList.add(localdlw);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", new Object[] { localInteger });
          }
        }
        p.ad(p.this).udf = localLinkedList;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUserMids, videoMembers %s", new Object[] { p.ad(p.this) });
        m.a(p.ad(p.this));
        AppMethodBeat.o(190615);
      }
    });
    AppMethodBeat.o(190672);
  }
  
  public final int asf(String paramString)
  {
    AppMethodBeat.i(190671);
    int i = -1;
    paramString = this.wmo.asd(paramString);
    if (paramString != null) {
      i = paramString.pcE;
    }
    AppMethodBeat.o(190671);
    return i;
  }
  
  final void b(b<ArrayList<j>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(190659);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger JoinSucc: %b %b %b", new Object[] { Boolean.valueOf(this.peJ), Boolean.valueOf(this.peK), Boolean.valueOf(this.peL) });
    if ((this.peJ) && (this.peL) && (this.peK))
    {
      if (this.peA)
      {
        f(paramb);
        AppMethodBeat.o(190659);
        return;
      }
      this.wmS.cbu();
      boolean bool1 = this.wmR.cbu();
      boolean bool2 = this.wmR.PO();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      o.pdP = i;
      if (bool1)
      {
        i = 0;
        o.pdR = i;
        if (!bool2) {
          break label197;
        }
      }
      label197:
      for (i = 0;; i = this.wmR.pcI.dhN)
      {
        o.pdQ = i;
        if ((!bool1) || (!bool2)) {
          break label211;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(190659);
        return;
        i = this.wmR.drH();
        break;
      }
      label211:
      e(paramb);
    }
    AppMethodBeat.o(190659);
  }
  
  public final void cbp()
  {
    this.peJ = false;
    this.peK = false;
    this.peL = false;
  }
  
  public final void d(b<ArrayList<j>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(190661);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger AcceptSucc: %b %b %b", new Object[] { Boolean.valueOf(this.peJ), Boolean.valueOf(this.peK), Boolean.valueOf(this.peL) });
    if ((this.peJ) && (this.peL) && (this.peK))
    {
      if (this.peA)
      {
        f(paramb);
        AppMethodBeat.o(190661);
        return;
      }
      this.wmS.cbu();
      boolean bool1 = this.wmR.cbu();
      boolean bool2 = this.wmR.PO();
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2) {
          i = 0;
        }
      }
      o.pdP = i;
      if (bool1)
      {
        i = 0;
        o.pdR = i;
        if (!bool2) {
          break label193;
        }
      }
      label193:
      for (i = 0;; i = this.wmR.pcI.dhN)
      {
        o.pdQ = i;
        if ((!bool1) || (!bool2)) {
          break label207;
        }
        gE(0, 0);
        AppMethodBeat.o(190661);
        return;
        i = this.wmR.drH();
        break;
      }
      label207:
      e(paramb);
    }
    AppMethodBeat.o(190661);
  }
  
  final void drM()
  {
    AppMethodBeat.i(190664);
    this.wnc = new l.a()
    {
      private static abb aS(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(190577);
        abb localabb = new abb();
        try
        {
          localabb.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(190577);
          return localabb;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(190577);
        }
        return null;
      }
      
      public final boolean cbm()
      {
        return true;
      }
    };
    this.wmQ.a(19, this.wnc);
    this.wne = new l.a()
    {
      private static aat aT(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(190581);
        aat localaat = new aat();
        try
        {
          localaat.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(190581);
          return localaat;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(190581);
        }
        return null;
      }
      
      public final boolean cbm()
      {
        return true;
      }
    };
    this.wmQ.a(20, this.wne);
    this.wna = new l.a()
    {
      public final boolean cbm()
      {
        return true;
      }
    };
    this.wmQ.a(23, this.wna);
    this.wnb = new l.a()
    {
      private static byte[] a(aav paramAnonymousaav)
      {
        AppMethodBeat.i(190587);
        if (paramAnonymousaav != null) {
          try
          {
            paramAnonymousaav = paramAnonymousaav.toByteArray();
            AppMethodBeat.o(190587);
            return paramAnonymousaav;
          }
          catch (IOException paramAnonymousaav)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousaav, "hy: error when convert to byte array", new Object[0]);
          }
        }
        AppMethodBeat.o(190587);
        return new byte[0];
      }
      
      public final boolean cbm()
      {
        return true;
      }
    };
    this.wmQ.a(24, this.wnb);
    Object localObject2 = this.wmo;
    k.a local17 = new k.a()
    {
      public final void J(final ArrayList<j> paramAnonymousArrayList)
      {
        AppMethodBeat.i(190591);
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.Multitalk.ILinkService", "hy: current talking members are %s", new Object[] { paramAnonymousArrayList });
        p.this.ad(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190590);
            if (p.C(p.this) != 1)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Multitalk.ILinkService", "hy: onSpeakerListChanged but not in room!");
              AppMethodBeat.o(190590);
              return;
            }
            if (p.Y(p.this) != null) {
              p.Y(p.this).a(0, 0, "on talklist change", paramAnonymousArrayList);
            }
            AppMethodBeat.o(190590);
          }
        });
        AppMethodBeat.o(190591);
      }
    };
    synchronized (((k)localObject2).pdt)
    {
      ((k)localObject2).pdt.add(local17);
      ??? = this.wmo;
      localObject2 = new k.1((k)???);
      ((k)???).pdu = new Timer("ILink_check_member_change");
      ((k)???).pdu.schedule((TimerTask)localObject2, 1000L, 1000L);
      AppMethodBeat.o(190664);
      return;
    }
  }
  
  public final void drN()
  {
    AppMethodBeat.i(190670);
    if (this.wmU != 1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", new Object[] { Integer.valueOf(this.wmU) });
      AppMethodBeat.o(190670);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.wmo.drI();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(190670);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      if (this.wnz.equals(localj.fIQ))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", new Object[] { Integer.valueOf(localj.pcE), localj.fIQ });
      }
      else
      {
        int i = localj.pcE;
        dlw localdlw = new dlw();
        localdlw.Gsd = i;
        localdlw.HTz = 160;
        localLinkedList.add(localdlw);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", new Object[] { Integer.valueOf(i), localj.fIQ });
      }
    }
    this.wnM.udf = localLinkedList;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "hy: subscribe, videoMembers %s", new Object[] { localArrayList });
    m.a(this.wnM);
    AppMethodBeat.o(190670);
  }
  
  public final List<String> drP()
  {
    AppMethodBeat.i(190679);
    Object localObject = this.wmo.drI();
    ArrayList localArrayList = new ArrayList();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      AppMethodBeat.o(190679);
      return null;
    }
    if (this.wmU != 1)
    {
      AppMethodBeat.o(190679);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      if (a(localj))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Multitalk.ILinkService", "getTalkingMember, memberId:%d,memberName:%s", new Object[] { Integer.valueOf(localj.pcE), localj.fIQ });
        localArrayList.add(localj.fIQ);
      }
    }
    AppMethodBeat.o(190679);
    return localArrayList;
  }
  
  public final List<String> drQ()
  {
    AppMethodBeat.i(190680);
    Object localObject = this.wmo.drI();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (this.wmU == 1))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        byte[] arrayOfByte = new byte[4];
        if (m.V(arrayOfByte, localj.pcE) >= 0)
        {
          int i = bu.bF(arrayOfByte);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Multitalk.ILinkService", "netStatus: %d", new Object[] { Integer.valueOf(i) });
          if ((i != -1) && (i <= 3)) {
            localArrayList.add(localj.fIQ);
          }
        }
      }
    }
    AppMethodBeat.o(190680);
    return localArrayList;
  }
  
  public final void e(final ArrayList<j> paramArrayList, final String paramString)
  {
    AppMethodBeat.i(190650);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkInvite. %s, %s", new Object[] { paramArrayList, paramString });
    this.wnB = paramString;
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190572);
        p localp = p.this;
        ArrayList localArrayList = paramArrayList;
        String str = paramString;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "steve:  enter inviteSync. %s, %s", new Object[] { localArrayList, str });
        if ((localp.wmU == 1) || (localp.pex))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Multitalk.ILinkService", "hy: already in room or joining room!");
          AppMethodBeat.o(190572);
          return;
        }
        localp.wmo.Zm();
        localp.wmo.wmz = str;
        localp.wmo.wmA = str;
        localp.rhB = localp.wnz;
        localp.lbB = new String("wechat");
        localp.wmV = p.a.wpe;
        localp.peE = false;
        localp.pex = true;
        localp.peA = false;
        localp.wnI = p.b.wph;
        localp.a(new p.32(localp, localArrayList));
        AppMethodBeat.o(190572);
      }
    });
    AppMethodBeat.o(190650);
  }
  
  public final int g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(190675);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.peH)
    {
      if (m.e(EMethodGetQosPara, this.wms.s2p, this.wms.s2p.length) >= 0)
      {
        localObject1 = this.wms;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).pcF = ((ByteBuffer)localObject2).get();
        ((a)localObject1).pcG = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = this.wms;
        com.tencent.mm.sdk.platformtools.ae.d("ILink[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        com.tencent.mm.sdk.platformtools.ae.d("ILink[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).pcF + ", HWEnable:" + ((a)localObject1).pcG + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (this.peH) {
        if (8 == this.wms.pcF)
        {
          this.peI = true;
          if (this.wms.pcG == 0)
          {
            this.peH = false;
            this.peI = false;
          }
          if ((1 != this.wms.cSkipFlag) && (this.peH) && (this.peI)) {
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
      if (this.peI)
      {
        if ((this.wnJ == null) || (i != 0)) {
          break label898;
        }
        paramInt1 = this.wnJ.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        if (paramInt1 >= 0) {
          paramInt1 = j;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(190675);
        return paramInt1;
        this.peI = false;
        break;
        this.peI = false;
        break;
        label470:
        if ((this.peH) && (this.wnJ == null)) {
          this.wnJ = new h(this.wms.cFps, this.wms.iKbps, "video/avc");
        }
        for (;;)
        {
          i = 0;
          break;
          localObject1 = this.wnJ;
          localObject2 = this.wms;
          if ((((h)localObject1).wms != null) && (((h)localObject1).pdc != null))
          {
            a locala = ((h)localObject1).wms;
            locala.iKbps = ((a)localObject2).iKbps;
            locala.cFps = ((a)localObject2).cFps;
            locala.cIPeriod = ((a)localObject2).cIPeriod;
            locala.cResolution = ((a)localObject2).cResolution;
            locala.pcF = ((a)localObject2).pcF;
            locala.pcG = ((a)localObject2).pcG;
            locala.cSkipFlag = ((a)localObject2).cSkipFlag;
            locala.cIReqFlag = ((a)localObject2).cIReqFlag;
            locala.cRsvd1 = ((a)localObject2).cRsvd1;
            i = (int)(((h)localObject1).wms.iKbps * 1.1D);
            if (((h)localObject1).m_br_kbps != i)
            {
              ((h)localObject1).SetBitRate(i);
              com.tencent.mm.sdk.platformtools.ae.i("ILink[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + ((h)localObject1).m_br_kbps + ", tuneBR:" + i);
              ((h)localObject1).m_br_kbps = i;
            }
            if ((1 == ((h)localObject1).wms.cIReqFlag) && (h.frameID > 0))
            {
              if (((h)localObject1).pdc != null)
              {
                com.tencent.mm.sdk.platformtools.ae.v("ILink[HWEnc]", "steve: Sync frame request soon!");
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("request-sync", 0);
                ((h)localObject1).pdc.setParameters((Bundle)localObject2);
              }
              com.tencent.mm.sdk.platformtools.ae.i("ILink[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
            }
            if (((h)localObject1).wms.cFps != ((h)localObject1).m_framerate) {
              ((h)localObject1).m_framerate = ((h)localObject1).wms.cFps;
            }
          }
        }
        label854:
        i = 0;
        break label407;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        this.peI = false;
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
  
  public final void gE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190653);
    this.pex = false;
    synchronized (this.wmQ)
    {
      this.wmQ.b(14, this.wnt);
      this.wmQ.b(15, this.wnu);
      this.wmQ.b(21, this.wnh);
      this.wmQ.b(22, this.wni);
      this.wnt = null;
      this.wnu = null;
      this.wnh = null;
      this.wni = null;
      drL();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wmU = 1;
        AppMethodBeat.o(190653);
        return;
      }
    }
    this.wny.bv(2, this.wnB);
    AppMethodBeat.o(190653);
  }
  
  public final void oL(boolean paramBoolean)
  {
    AppMethodBeat.i(190647);
    try
    {
      this.wmR.release();
      if ((paramBoolean) && (this.wmU == 1))
      {
        this.wmR.init();
        boolean bool1 = this.wmR.cbu();
        boolean bool2 = this.wmR.PO();
        if ((bool1) && (bool2)) {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive restart audio device OK!");
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(190647);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: " + paramBoolean + ", error:" + localThrowable);
      AppMethodBeat.o(190647);
    }
  }
  
  public final void u(long paramLong, String paramString)
  {
    AppMethodBeat.i(190649);
    this.wnz = paramString;
    this.wnA = paramLong;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkService", "set name=%s, uin=%d", new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(190649);
  }
  
  public static enum a
  {
    final int czw;
    
    static
    {
      AppMethodBeat.i(190639);
      woY = new a("ReasonInterrupted", 0, 0);
      woZ = new a("ReasonManual", 1, 1);
      wpa = new a("ReasonDevice", 2, 2);
      wpb = new a("ReasonInCommingCall", 3, 3);
      wpc = new a("ReasonSessionUpdateFailed", 4, 4);
      wpd = new a("ReasonWeappEnterBackground", 5, 5);
      wpe = new a("ReasonUnknown", 6, 100);
      wpf = new a[] { woY, woZ, wpa, wpb, wpc, wpd, wpe };
      AppMethodBeat.o(190639);
    }
    
    private a(int paramInt)
    {
      this.czw = paramInt;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(190642);
      wpg = new b("ILinkMemberRoleUnknown", 0);
      wph = new b("ILinkMemberRoleCreate", 1);
      wpi = new b("ILinkMemberRoleAccept", 2);
      wpj = new b("ILinkMemberRoleJoin", 3);
      wpk = new b[] { wpg, wph, wpi, wpj };
      AppMethodBeat.o(190642);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p
 * JD-Core Version:    0.7.0.1
 */