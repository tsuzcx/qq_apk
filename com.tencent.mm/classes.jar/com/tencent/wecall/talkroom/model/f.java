package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.au;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.p;
import com.tencent.pb.common.b.a.a.q;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
  implements Handler.Callback, com.tencent.g.a.d, com.tencent.pb.common.b.b
{
  private static com.tencent.pb.talkroom.sdk.e wFM = null;
  public static List<Integer> xdF = new ArrayList();
  private static int xdM = 30000;
  public static String[] xek = { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
  public String kWU;
  boolean lFT = false;
  public int lvU;
  Handler mHandler;
  boolean mIsMute = false;
  boolean pSc = false;
  int state = 0;
  int wFA;
  private com.tencent.g.a.a xcn;
  f.f xdE;
  private Map<String, f.e> xdG = new HashMap();
  private final int xdH = 1;
  private final int xdI = 2;
  private final int xdJ = 3;
  private final int xdK = 4;
  public final int xdL = 6;
  private boolean xdN = false;
  private boolean xdO = false;
  private String xdP;
  public String xdQ;
  public long xdR;
  private int xdS = 0;
  private int xdT = 0;
  private int xdU = 0;
  private long xdV = 0L;
  private boolean xdW = true;
  private int xdX = 0;
  int xdY = -1;
  public h xdZ = h.xfn;
  b xea;
  private talk.a xeb;
  private TimerTask xec;
  private TimerTask xed;
  private Timer xee = new Timer("TalkRoomService_HelloTimer");
  private TimerTask xef;
  private Timer xeg = new Timer("TalkRoomService_talkDurationTimer");
  g xeh = new g();
  private int xei = 0;
  private boolean xej = false;
  public String xel = null;
  HashSet<Long> xem = new HashSet();
  public boolean xen = false;
  public boolean xeo = true;
  public boolean xep = true;
  private short[] xeq = null;
  private int[] xer = null;
  private short[] xes = null;
  private int[] xet = null;
  private int xeu = 0;
  public boolean xev = false;
  public boolean xew = true;
  private Runnable xex = new f.8(this);
  private com.tencent.pb.common.b.d xey = null;
  private Runnable xez = new Runnable()
  {
    public final void run()
    {
      Object localObject2 = null;
      int i = f.a(f.this);
      if (f.t(f.this) == null) {}
      for (Object localObject1 = null;; localObject1 = Integer.valueOf(f.t(f.this).getType()))
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "beginSenceCircle state: ", Integer.valueOf(i), " mCircleScene: ", localObject1, " mIsAck: ", Boolean.valueOf(f.u(f.this)) });
        if (f.t(f.this) != null) {
          break;
        }
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        return;
      }
      if (!f.this.bPW())
      {
        f.w(f.this).removeCallbacks(f.v(f.this));
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
        return;
      }
      localObject1 = localObject2;
      if (f.t(f.this) != null)
      {
        localObject1 = localObject2;
        if (f.t(f.this).getType() == 202)
        {
          localObject1 = localObject2;
          if (f.a(f.this) == 3)
          {
            com.tencent.wecall.talkroom.a.e locale = (com.tencent.wecall.talkroom.a.e)f.t(f.this);
            localObject1 = localObject2;
            if (f.a(f.this, locale.kWU, locale.lvU, locale.xdR, f.Kz(locale.xfP)))
            {
              localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "beginSenceCircle enter" });
            }
          }
        }
      }
      if (localObject1 != null)
      {
        com.tencent.pb.common.b.e.cNS().a((com.tencent.pb.common.b.d)localObject1);
        return;
      }
      f.w(f.this).removeCallbacks(f.v(f.this));
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
    }
  };
  
  public f()
  {
    com.tencent.pb.common.b.e.cNS().a(201, this);
    com.tencent.pb.common.b.e.cNS().a(202, this);
    com.tencent.pb.common.b.e.cNS().a(203, this);
    com.tencent.pb.common.b.e.cNS().a(204, this);
    com.tencent.pb.common.b.e.cNS().a(205, this);
    com.tencent.pb.common.b.e.cNS().a(206, this);
    com.tencent.pb.common.b.e.cNS().a(207, this);
    com.tencent.pb.common.b.e.cNS().a(208, this);
    com.tencent.pb.common.b.e.cNS().a(210, this);
    com.tencent.pb.common.b.e.cNS().a(209, this);
    com.tencent.pb.common.b.e.cNS().a(211, this);
    com.tencent.pb.common.b.e.cNS().a(212, this);
    com.tencent.pb.common.b.e.cNS().a(213, this);
    com.tencent.pb.common.b.e.cNS().a(214, this);
    com.tencent.pb.common.b.e.cNS().a(800, this);
    Object localObject = c.cRC();
    g localg = this.xeh;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).xdw = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      if (this.xcn == null) {
        this.xcn = ((com.tencent.g.a.a)com.tencent.g.f.agr("EventCenter"));
      }
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.valueOf(true) });
      this.xcn.a(this, xek);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "setTalkServerCallback caller stack: ", localThrowable });
      }
    }
  }
  
  private static boolean Ky(int paramInt)
  {
    return paramInt != 1;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.lpD, paramh.lpE, false)) {
        this.xdZ.R(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      return;
    }
    paramObject = (a.aj)paramObject;
    if (!b(paramObject.groupId, paramObject.pRI, paramObject.pRJ, false))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.pRI), Integer.valueOf(this.lvU) });
      return;
    }
    this.xdZ.R(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.wFA, paramObject.pRI, paramObject.pRJ, paramObject.wHz, paramObject.wHB, paramObject.wGh, false, false);
    paramh = new byte[paramObject.wHD.length];
    paramInt1 = 0;
    while (paramInt1 < paramObject.wHD.length)
    {
      paramh[paramInt1] = ((byte)paramObject.wHD[paramInt1]);
      paramInt1 += 1;
    }
    int[] arrayOfInt = new int[paramObject.wHM.length];
    paramInt1 = 0;
    while (paramInt1 < paramObject.wHM.length)
    {
      arrayOfInt[paramInt1] = paramObject.wHM[paramInt1];
      paramInt1 += 1;
    }
    a(paramObject.wHA, paramObject.wHH, paramObject.wHI);
    this.xea.Close();
    a.av[] arrayOfav = paramObject.wHz;
    a.as localas = paramObject.wGM;
    if ((paramObject.wHC & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfav, localas, paramh, bool, paramObject.groupId, paramObject.pRI, paramObject.pRJ, paramObject.wHJ, paramObject.wHK, paramObject.wHL, arrayOfInt, paramObject.wGO);
      return;
    }
  }
  
  private void a(int paramInt, a.aa paramaa, com.tencent.wecall.talkroom.a.e parame)
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.kWU, Integer.valueOf(parame.lvU), Long.valueOf(parame.xdR), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.b.C(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.KA(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramaa.groupId, Integer.valueOf(paramaa.pRI), Long.valueOf(paramaa.pRJ) });
      this.xeh.i(-14255, paramaa);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramaa.groupId, Integer.valueOf(paramaa.pRI), Long.valueOf(paramaa.pRJ) });
      this.xeh.i(-14256, paramaa);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.kWU, parame.lvU, parame.xdR, Ky(parame.xfP)))
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.kWU, " mGroupId: ", this.kWU, Integer.valueOf(parame.lvU), Integer.valueOf(this.lvU), Long.valueOf(parame.xdR), Long.valueOf(this.xdR) });
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.kWU, Integer.valueOf(parame.lvU), Long.valueOf(parame.xdR) });
        return;
      }
      this.xdZ.R(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.xdZ.KE(322);
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.kWU, Integer.valueOf(parame.lvU), Long.valueOf(parame.xdR) });
      a(parame.kWU, parame.lvU, parame.xdR, true);
      if (paramInt == 14251)
      {
        this.xeh.i(-1000, null);
        return;
      }
      if (paramInt == 14252)
      {
        this.xeh.i(-1200, null);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramaa != null) {
          parame = Integer.valueOf(paramaa.wHF);
        }
        this.xeh.i(-1500, parame);
        return;
      }
      this.xeh.i(-200, null);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramaa.groupId, Integer.valueOf(paramaa.pRI), Long.valueOf(paramaa.pRJ) });
      return;
    }
    if (!b(paramaa.groupId, paramaa.pRI, paramaa.pRJ, Ky(paramaa.wGr)))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramaa.groupId, " mGroupId: ", this.kWU, Integer.valueOf(paramaa.pRI), Integer.valueOf(this.lvU), Long.valueOf(paramaa.pRJ), Long.valueOf(this.xdR) });
      a(paramaa.groupId, paramaa.pRI, paramaa.pRJ, 111, false);
      h.KA(-1110);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramaa.groupId, Integer.valueOf(paramaa.pRI), Long.valueOf(paramaa.pRJ) });
      return;
    }
    this.xdZ.R(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramaa.wHA == null) || (paramaa.wHA.length == 0))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramaa.groupId, Integer.valueOf(paramaa.pRI), Long.valueOf(paramaa.pRJ) });
      h.KA(-1605);
      this.xdZ.qdu = 329;
      a(paramaa.groupId, paramaa.pRI, paramaa.pRJ, 116, true);
      this.xeh.i(-200, null);
      return;
    }
    this.kWU = paramaa.groupId;
    this.xel = paramaa.groupId;
    this.lvU = paramaa.pRI;
    this.xdR = paramaa.pRJ;
    setState(4);
    a(paramaa.wHA, paramaa.wHH, paramaa.wHI);
    a(paramaa.groupId, null, this.wFA, paramaa.pRI, paramaa.pRJ, paramaa.wHz, paramaa.wHB, paramaa.wGh, false, true);
    parame = this.xeh;
    localObject = new g.7(parame, c.cRC().agB(paramaa.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramaa.wHD.length];
      paramInt = 0;
      while (paramInt < paramaa.wHD.length)
      {
        parame[paramInt] = ((byte)paramaa.wHD[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramaa.wHM.length];
    paramInt = 0;
    while (paramInt < paramaa.wHM.length)
    {
      localObject[paramInt] = paramaa.wHM[paramInt];
      paramInt += 1;
    }
    a.av[] arrayOfav = paramaa.wHz;
    a.as localas = paramaa.wGM;
    if ((paramaa.wHC & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfav, localas, parame, bool, paramaa.groupId, paramaa.pRI, paramaa.pRJ, paramaa.wHJ, paramaa.wHK, paramaa.wHL, (int[])localObject, paramaa.wGO);
      if (paramaa.wHG != 0)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramaa.wHG });
        xdM = paramaa.wHG * 1000;
      }
      cRP();
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR) });
      return;
    }
  }
  
  private void a(int paramInt, a.ah paramah)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.xeh.eD(null);
      return;
    }
    paramah = paramah.wHW;
    if ((paramah == null) || (paramah.length == 0))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramah.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramah[paramInt];
      if (localObject != null)
      {
        a(localObject.groupId, null, 0, localObject.pRI, localObject.pRJ, localObject.wHz, null, null, false, false);
        localArrayList.add(c.cRC().agB(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.xeh.eD(localArrayList);
  }
  
  private void a(int paramInt1, a.av[] paramArrayOfav, a.as paramas, byte[] paramArrayOfByte1, boolean paramBoolean, String paramString, int paramInt2, long paramLong, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt5)
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "dealWithInit", Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(this.state) });
    if (this.xea != null) {
      for (;;)
      {
        try
        {
          if (this.state != 4)
          {
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
            bool = false;
          }
        }
        catch (Exception localException1)
        {
          boolean bool = false;
        }
        try
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "dealWithInit ret: ", Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          return;
        }
        catch (Exception localException2)
        {
          break label163;
        }
        bool = a(paramArrayOfav, paramas, paramArrayOfByte1, paramBoolean, paramInt2, paramLong, paramInt3, paramInt4, paramArrayOfByte2, paramArrayOfInt, paramInt5);
        continue;
        label163:
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "dealWithInit ", localException1 });
      }
    }
    if (paramInt1 <= 0)
    {
      this.xdZ.KE(202);
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom dealWithInit fail" });
      a(paramString, paramInt2, paramLong, 102, true);
      this.xeh.i(-400, null);
      return;
    }
    this.mHandler.postDelayed(new f.4(this, paramInt1, paramArrayOfav, paramas, paramArrayOfByte1, paramBoolean, paramString, paramInt2, paramLong, paramInt3, paramInt4, paramArrayOfByte2, paramArrayOfInt, paramInt5), 50L);
  }
  
  public static void a(com.tencent.pb.talkroom.sdk.e parame)
  {
    wFM = parame;
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.lvU = paramInt;
    this.xdR = paramLong;
    this.kWU = paramString2;
    this.xdQ = paramString1;
    this.xdP = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw, a.at paramat, boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc;
    Object localObject2;
    label66:
    boolean bool;
    if (paramArrayOfav == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString1, "  roomid: ", Integer.valueOf(paramInt2), "  roomKey", Long.valueOf(paramLong) });
      localc = c.cRC();
      if (paramInt1 != 0) {
        break label690;
      }
      localObject2 = null;
      if ((this.kWU == null) || (!this.kWU.equals(paramString1))) {
        break label699;
      }
      bool = true;
      label87:
      com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup groupId: ", paramString1, " isActive: ", Boolean.valueOf(bool) });
      if (!TextUtils.isEmpty(paramString1)) {
        break label1281;
      }
    }
    label1281:
    for (String str = paramString2;; str = paramString1)
    {
      if (TextUtils.isEmpty(str)) {
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "newOrUpdateGroup invalid groupId" });
      }
      long l;
      label196:
      label456:
      Object localObject1;
      for (paramBoolean1 = false;; paramBoolean1 = false)
      {
        paramString2 = this.kWU;
        int i = this.lvU;
        l = this.xdR;
        bool = b(paramString1, paramInt2, paramLong, false);
        if (paramArrayOfav == null) {
          break label1157;
        }
        paramInt1 = paramArrayOfav.length;
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.xdW) });
        if (c.cRC().bS(this.kWU, false))
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.xdW), " mGroupId: ", this.kWU, " roomId: ", Integer.valueOf(paramInt2) });
          if (this.xdW)
          {
            this.xdW = false;
            this.lFT = true;
            this.xej = k.cSa();
            this.xdU = this.xdS;
            if (this.xef == null) {
              break label1162;
            }
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
          }
        }
        label451:
        if (paramArrayOfav != null) {
          break label1233;
        }
        return;
        localObject1 = new StringBuffer();
        int j = paramArrayOfav.length;
        i = 0;
        while (i < j)
        {
          localObject2 = paramArrayOfav[i];
          if (localObject2 != null) {
            ((StringBuffer)localObject1).append(" memberId:" + ((a.av)localObject2).iEo + " uuid: " + ((a.av)localObject2).wHY + " status: " + ((a.av)localObject2).status + "   mem.inviteTime:" + ((a.av)localObject2).wIR + "  mem.reason: " + ((a.av)localObject2).aQw + "  mem.inviteuuid: " + ((a.av)localObject2).wJd + "\n");
          }
          i += 1;
        }
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString1, "  romid: ", Integer.valueOf(paramInt2), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfav.length), "  ", ((StringBuffer)localObject1).toString() });
        break;
        label690:
        localObject2 = Integer.valueOf(paramInt1);
        break label66;
        label699:
        bool = false;
        break label87;
        if (j.agI(paramString2)) {
          localc.xdv.put(paramString2, str);
        }
        localObject1 = (TalkRoom)localc.xdu.get(str);
        if ((TextUtils.isEmpty(paramString2)) || (localObject1 == null) || (paramat == null) || (paramat.bNM == 100)) {
          break label792;
        }
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "newOrUpdateGroup clientGroupId is not empty , room is not null" });
      }
      label792:
      if (localObject1 == null) {
        if (j.agI(paramString2))
        {
          localObject1 = (TalkRoom)localc.xdu.get(paramString2);
          label820:
          localObject3 = localObject1;
          if (localObject1 != null) {
            localc.xdu.put(str, localObject1);
          }
        }
      }
      for (Object localObject3 = localObject1;; localObject3 = localObject1)
      {
        if ((localObject3 != null) && (bool))
        {
          paramInt1 = j.cRY();
          l = j.cRZ();
          com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "check current active group roomId: ", Integer.valueOf(paramInt1), " and roomKey: ", Long.valueOf(paramLong) });
          if ((paramInt1 != 0) && (paramInt1 != paramInt2))
          {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "diff roomId: ", Integer.valueOf(paramInt1), " -> ", Integer.valueOf(paramInt2) });
            paramBoolean1 = false;
            break;
          }
          if ((0L != l) && (l != paramLong))
          {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "diff roomKey: ", Long.valueOf(l), " -> ", Long.valueOf(paramLong) });
            paramBoolean1 = false;
            break;
          }
        }
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup create groupId: ", str });
          paramString2 = TalkRoom.a(str, paramString2, (Integer)localObject2, paramInt2, paramLong, paramat, paramArrayOfav, paramArrayOfaw);
          localc.xdu.put(str, paramString2);
        }
        for (;;)
        {
          if ((localc.xdw != null) && (paramBoolean1)) {
            localc.xdw.g(localc.agB(str));
          }
          c.cRD();
          paramBoolean1 = true;
          break;
          com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "newOrUpdateGroup update groupId: ", str });
          TalkRoom.a(localObject3, str, paramString2, (Integer)localObject2, paramInt2, paramLong, paramat, paramArrayOfav, paramArrayOfaw);
        }
        label1157:
        paramInt1 = 0;
        break label196;
        label1162:
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.xdE, " mIsHoldOn: ", Boolean.valueOf(this.xev) });
        this.xef = new f.7(this);
        this.xeg.scheduleAtFixedRate(this.xef, 1000L, 1000L);
        break label451;
        label1233:
        if ((!paramBoolean2) || (!b(paramString1, paramInt2, paramLong, false)) || (paramArrayOfav.length <= 0) || (this.xea == null)) {
          break label456;
        }
        a(paramArrayOfav);
        return;
        break label820;
      }
    }
  }
  
  private void a(a.av[] paramArrayOfav)
  {
    if (paramArrayOfav == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfav.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfav.length)
    {
      arrayOfInt[i] = paramArrayOfav[i].iEo;
      localStringBuffer.append(paramArrayOfav[i].iEo);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.xea == null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      return;
    }
    this.xea.OnMembersChanged(arrayOfInt);
  }
  
  private void a(a.o[] paramArrayOfo1, a.o[] paramArrayOfo2, int paramInt)
  {
    if (paramArrayOfo1 == null) {}
    for (int i = 0;; i = paramArrayOfo1.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfo1 != null) && (paramArrayOfo1.length > 0)) {
        break;
      }
      return;
    }
    this.xer = new int[paramArrayOfo1.length];
    this.xeq = new short[paramArrayOfo1.length];
    this.xet = new int[paramArrayOfo2.length];
    this.xes = new short[paramArrayOfo2.length];
    this.xeu = paramInt;
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.xeu) });
    int j = paramArrayOfo1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.o localo = paramArrayOfo1[paramInt];
      this.xer[i] = localo.wGI;
      this.xeq[i] = ((short)localo.port);
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleRelayData ip: ", Integer.valueOf(localo.wGI), " addr.port: ", Integer.valueOf(localo.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfo2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfo1 = paramArrayOfo2[paramInt];
      this.xet[i] = paramArrayOfo1.wGI;
      this.xes[i] = ((short)paramArrayOfo1.port);
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", Integer.valueOf(paramArrayOfo1.wGI), " tcpAddr.port: ", Integer.valueOf(paramArrayOfo1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.xer), Arrays.toString(this.xeq), this.kWU, this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), Arrays.toString(this.xet), Arrays.toString(this.xes), Integer.valueOf(this.xeu) });
  }
  
  private boolean a(a.av[] paramArrayOfav, a.as paramas, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4)
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.kWU, " ip: ", Arrays.toString(this.xer), " ports: ", Arrays.toString(this.xeq), " tcpIp: ", Arrays.toString(this.xet), " tcpPorts: ", Arrays.toString(this.xes), " tcpStartTime: ", Integer.valueOf(this.xeu), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.cOl();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfav != null) && (paramArrayOfav.length > 0))
    {
      localObject1 = new int[paramArrayOfav.length];
      j = 0;
      while (j < paramArrayOfav.length)
      {
        localObject1[j] = paramArrayOfav[j].iEo;
        if (com.tencent.pb.common.c.g.equals(paramArrayOfav[j].wHY, (String)localObject2)) {
          i = paramArrayOfav[j].iEo;
        }
        j += 1;
      }
      paramArrayOfav = (a.av[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.cRC().agx(this.kWU);
      this.xdZ.iEo = j;
      for (;;)
      {
        try
        {
          localObject2 = this.xea;
          talk.a locala = this.xeb;
          localObject3 = c.cRC();
          localObject1 = this.kWU;
          localObject3 = ((c)localObject3).agw((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.xer;
          short[] arrayOfShort1 = this.xeq;
          int[] arrayOfInt = this.xet;
          short[] arrayOfShort2 = this.xes;
          int m = this.xeu;
          com.tencent.pb.common.c.c.d("simon:TalkRoomContext", new Object[] { "Open" });
          localObject1 = null;
          if (paramas == null) {
            continue;
          }
          paramas = new i(paramas.wIj, paramas.ejU, paramas.ejV, paramas.wIk, paramas.wIl, paramas.wIm, paramas.wIn, paramas.wIo, paramas.wIp, paramas.wIq, paramas.wIr, paramas.wIs);
          int n = k.ij(com.tencent.pb.common.c.d.pZI);
          paramInt1 = ((b)localObject2).xdr.Open(locala, paramas, i, j, paramInt1, paramLong, (int[])localObject3, arrayOfShort1, 0, paramArrayOfav, paramArrayOfByte1, paramBoolean, n, arrayOfInt, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4);
        }
        catch (Throwable paramArrayOfav)
        {
          Object localObject3;
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "connectToCompenent", paramArrayOfav });
          paramInt1 = -99999;
          continue;
          paramArrayOfav.handler.post(paramas);
          continue;
        }
        paramArrayOfav = this.xeh;
        paramas = new g.2(paramArrayOfav, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramas.run();
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.KD(-3002);
        }
        if (paramInt1 == 0) {
          this.xdZ.qdx = 1;
        }
        if (paramInt1 != 0) {
          break label800;
        }
        return true;
        localObject3 = ((TalkRoom)localObject3).agv(com.tencent.pb.a.a.a.cOl());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).xdx;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.av)localObject3).sqW) });
            i = ((a.av)localObject3).sqW;
            continue;
            com.tencent.pb.common.c.c.x("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramas = (a.as)localObject1;
          }
        }
      }
      label800:
      return false;
      paramArrayOfav = null;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = wFM;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramb);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "startPlayer: ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramb });
        int i = j;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    return i;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.c paramc)
  {
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = wFM;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramc);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "startRecord: ", paramc });
        int i = j;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    return i;
  }
  
  private void b(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "sendEnterGroupScence groupId: ", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " enterType: ", Integer.valueOf(paramInt3), " isSenceCircle: ", Boolean.valueOf(true), " wXgroupId: ", paramString2 });
    if ((paramInt1 == 0) || (paramLong == 0L))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "roomId or roomkey is 0..return." });
      return;
    }
    h localh;
    if (!Ky(paramInt3))
    {
      localh = this.xdZ;
      com.tencent.pb.common.c.c.d(h.TAG, new Object[] { "endAnswerTime", Long.valueOf(localh.xfD) });
      if (localh.xfD != 0L) {
        break label246;
      }
    }
    label246:
    for (localh.lqT = 0L;; localh.lqT = (System.currentTimeMillis() - localh.xfD))
    {
      this.xdZ.cRW();
      paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.xea.cRA(), paramInt2, paramInt3, paramString2);
      com.tencent.pb.common.b.e.cNS().a(paramString1);
      this.mHandler.removeCallbacks(this.xez);
      this.xey = paramString1;
      this.mHandler.postDelayed(this.xez, 3000L);
      return;
    }
  }
  
  private boolean b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {
      paramBoolean = com.tencent.pb.common.c.g.gK(paramString, this.kWU);
    }
    do
    {
      return paramBoolean;
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.kWU, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.lvU), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.xdR) });
      if ((!com.tencent.pb.common.c.g.gK(paramString, this.kWU)) || (paramInt != this.lvU)) {
        break;
      }
      paramBoolean = bool;
    } while (paramLong == this.xdR);
    return false;
  }
  
  private boolean cRN()
  {
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = wFM;
      if (locale == null) {
        break label87;
      }
      this.xdZ.pVa = locale.bkN();
      this.xdZ.pUQ = locale.bkQ();
      bool = locale.bkL();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "stopPlayer: ", localException });
        label87:
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "stopPlayer ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  private void cRP()
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.xec != null)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      return;
    }
    try
    {
      this.xec = new TimerTask()
      {
        public final void run()
        {
          if ((f.g(f.this) == 0) || (f.b(f.this) == null))
          {
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.g(f.this)), f.b(f.this) });
            f.k(f.this);
            return;
          }
          f.a(f.this, f.j(f.this));
        }
      };
      this.xee.schedule(this.xec, 0L, xdM);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "startNooper: ", localException });
    }
  }
  
  private void cRQ()
  {
    try
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.xed != null) {
        this.xed.cancel();
      }
      this.xed = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelHelloTimeOutTask: ", localException });
      }
    }
  }
  
  private void cRR()
  {
    try
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.xec != null) {
        this.xec.cancel();
      }
      this.xec = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelHelloTimerTask: ", localException });
      }
    }
  }
  
  private void cRS()
  {
    cRN();
    Object localObject = new AtomicInteger();
    AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new f.6(this, (AtomicInteger)localObject, localAtomicInteger));
    if (i <= 0)
    {
      this.xdZ.KE(101);
      h.KB(-2001);
      localObject = this.xdZ;
      ((h)localObject).xfo |= 0x1;
      this.xeh.i(-500, null);
    }
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
  }
  
  public static com.tencent.pb.talkroom.sdk.e cRT()
  {
    return wFM;
  }
  
  private boolean dZ(String paramString, int paramInt)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.wFA);
    boolean bool = com.tencent.pb.common.b.e.cNS().a(localc);
    this.xdZ.R(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.lvU, this.xdR, true);
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  static String[] eE(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      String[] arrayOfString = new String[paramList.size()];
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        arrayOfString[i] = ((String)paramList.next());
        i += 1;
      }
      return arrayOfString;
    }
    return new String[0];
  }
  
  private void h(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = c.cRC();
        if ((paramInt == 0) && (paramLong == 0L))
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", paramString });
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.pSc), " mTalkDuration: ", Integer.valueOf(this.xdS), " msgKey: ", localObject1 });
          return;
        }
        localObject2 = ((c)localObject2).agw(paramString);
        if (localObject2 == null)
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoom is null,groupId: ", paramString });
          continue;
        }
        localObject2 = ((TalkRoom)localObject2).agv(com.tencent.pb.a.a.a.cOl());
      }
      catch (Throwable paramString)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
        return;
      }
      if (localObject2 == null)
      {
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMsgKeyByGroupId talkRoomMember is null,groupId: ", paramString });
      }
      else
      {
        localObject2 = ((d)localObject2).xdx;
        if (localObject2 == null)
        {
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", paramString });
        }
        else
        {
          localObject1 = new StringBuffer();
          ((StringBuffer)localObject1).append(paramString);
          ((StringBuffer)localObject1).append(",");
          ((StringBuffer)localObject1).append(paramInt);
          ((StringBuffer)localObject1).append(",");
          ((StringBuffer)localObject1).append(paramLong);
          ((StringBuffer)localObject1).append(",");
          ((StringBuffer)localObject1).append(((a.av)localObject2).wIT);
          com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "getMsgKeyByGroupId msgKey is", ((StringBuffer)localObject1).toString() });
          localObject1 = ((StringBuffer)localObject1).toString();
        }
      }
    }
  }
  
  private void startRecord()
  {
    uh();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new f.5(this));
    if (i <= 0)
    {
      this.xdZ.KE(101);
      h.KB(-2001);
      this.xeh.i(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.xdZ;
    }
    for (localh.xfo &= 0xFFFFFFFE;; localh.xfo |= 0x1)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      return;
      localh = this.xdZ;
    }
  }
  
  private boolean uh()
  {
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = wFM;
      if (locale == null) {
        break label87;
      }
      this.xdZ.pUT = locale.bkO();
      this.xdZ.pUP = locale.bkP();
      bool = locale.bkM();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "stopRecord: ", localException });
        label87:
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "stopRecord ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean ys()
  {
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.d.pZI.getSystemService("audio")).isSpeakerphoneOn();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "isSpeakerOn ret: ", Boolean.valueOf(bool) });
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "isSpeakerOn ", localException });
        boolean bool = false;
      }
    }
  }
  
  public final f.b a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.lvU), Integer.valueOf(paramInt1), Long.valueOf(this.xdR), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.valueOf(false) });
    if (!com.tencent.pb.a.a.a.cOm())
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cOm()), " isBindMobile: ", Boolean.valueOf(true) });
      h.a(paramString1, "", this.lvU, this.xdR, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      return f.b.xeV;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((Ky(paramInt3)) && (paramInt3 != 100) && (bPW()))
    {
      h.a(paramString1, "", this.lvU, this.xdR, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      return f.b.xeZ;
    }
    boolean bool;
    if (paramInt3 == 100) {
      bool = true;
    }
    while (!bool)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.lvU, this.xdR, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      return f.b.xfa;
      if (Ky(paramInt3))
      {
        if (this.state == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (paramInt3 == 1) {
        bool = agD(paramString1);
      } else {
        bool = false;
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.lvU, this.xdR, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      return f.b.xfb;
    }
    if (Ky(paramInt3))
    {
      cRO();
      oo(false);
    }
    cRL();
    if (!bMH())
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (Ky(paramInt3))
      {
        h.a(paramString1, "", this.lvU, this.xdR, new String[] { "enter", "req", "false", "initEnginefail" });
        oo(false);
      }
      for (;;)
      {
        return f.b.xfd;
        this.xdZ.R(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.kWU = paramString1;
    Object localObject;
    int i;
    long l;
    if (!Ky(paramInt3))
    {
      localObject = agC(paramString1);
      if (localObject == null)
      {
        i = 0;
        this.lvU = i;
        if (localObject != null) {
          break label865;
        }
        l = 0L;
        label703:
        this.xdR = l;
        label709:
        this.xel = paramString1;
        this.wFA = paramInt2;
        setState(3);
        if (!Ky(paramInt3)) {
          break label888;
        }
        bool = true;
        label736:
        this.pSc = bool;
        if (this.pSc) {
          this.xdZ.cRV();
        }
        if ((!this.pSc) || (c.cRC().bS(this.kWU, true))) {
          break label894;
        }
        localObject = new f.c(this);
        ((f.c)localObject).groupId = paramString1;
        ((f.c)localObject).lpD = paramInt1;
        ((f.c)localObject).lpE = paramLong;
        ((f.c)localObject).wGr = paramInt3;
        ((f.c)localObject).wGk = paramInt2;
        ((f.c)localObject).xff = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      return f.b.xeU;
      i = ((f.e)localObject).lpD;
      break;
      label865:
      l = ((f.e)localObject).lpE;
      break label703;
      this.lvU = paramInt1;
      this.xdR = paramLong;
      break label709;
      label888:
      bool = false;
      break label736;
      label894:
      b(paramString1, this.lvU, this.xdR, paramInt2, paramInt3, paramString2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.pb.common.b.d paramd)
  {
    int i;
    if (paramd != null)
    {
      paramString = Integer.valueOf(paramd.getType());
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT onNetSceneEnd errCode:", Integer.valueOf(paramInt2), " errType: ", Integer.valueOf(paramInt1), " scene.getType(): ", paramString });
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        paramString = com.tencent.pb.common.c.b.C(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.KA(((Integer)paramString.get(Integer.valueOf(i))).intValue());
        }
      }
      if (paramInt2 != -1) {
        break label1043;
      }
    }
    label1043:
    label1332:
    label5182:
    for (;;)
    {
      try
      {
        if (paramd.getType() == 201)
        {
          paramString = (com.tencent.wecall.talkroom.a.d)paramd;
          if (com.tencent.pb.common.c.g.gK(this.xdQ, paramString.xdQ))
          {
            this.xdZ.KE(301);
            this.xdZ.R(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            dZ(paramString.xdQ, 1001);
            if (!paramString.xfO) {
              this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.xeh.i(-100, null);
          }
          return;
          paramString = "";
          break;
        }
        if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.xeh.dY(paramString.kWU, paramInt2);
          return;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "cancelCreateTalkRoom: ", paramString });
        return;
      }
      if (paramd.getType() == 206)
      {
        paramString = (com.tencent.wecall.talkroom.a.a)paramd;
        if (!b(paramString.kWU, paramString.lvU, paramString.xdR, false)) {
          h.a(paramString.kWU, paramString.lvU, paramString.xdR, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
        }
        this.xeh.a(paramString.xfN, c.cRC().agB(paramString.kWU));
        return;
      }
      if (paramd.getType() == 204)
      {
        paramString = (com.tencent.wecall.talkroom.a.b)paramd;
        if (b(paramString.kWU, paramString.lvU, paramString.xdR, false))
        {
          this.xdZ.R(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
          this.xeh.i(-300, null);
        }
      }
      else if (paramd.getType() == 202)
      {
        paramString = (com.tencent.wecall.talkroom.a.e)paramd;
        if ((b(paramString.kWU, paramString.lvU, paramString.xdR, Ky(paramString.xfP))) && (this.state == 3))
        {
          this.xdZ.KE(302);
          this.xeh.i(-200, null);
        }
      }
      else
      {
        if (paramd.getType() == 212)
        {
          this.xeh.eD(null);
          return;
        }
        if (paramd.getType() == 213)
        {
          if (com.tencent.pb.common.c.g.equals(((com.tencent.wecall.talkroom.a.j)paramd).kWU, this.kWU))
          {
            this.xdZ.R(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
            this.xeh.i(-700, null);
          }
        }
        else if (paramd.getType() == 211)
        {
          paramString = (com.tencent.wecall.talkroom.a.h)paramd;
          if (b(paramString.groupId, paramString.lpD, paramString.lpE, false)) {
            this.xdZ.R(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
          }
        }
        else if (paramd.getType() == 214)
        {
          paramString = (l)paramd;
          if (b(paramString.kWU, paramString.lvU, paramString.xdR, false)) {
            this.xeh.i(-800, null);
          }
        }
        else if (paramd.getType() == 800)
        {
          paramString = (com.tencent.wecall.talkroom.a.k)paramd;
          if (b(paramString.kWU, paramString.lvU, paramString.xdR, false))
          {
            this.xeh.i(-1600, null);
            return;
            Object localObject1;
            Object localObject2;
            if (paramd.getType() == 201)
            {
              localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
              if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).wFx != null))
              {
                paramString = (a.z)((com.tencent.pb.common.b.d)localObject1).wFx;
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).xdQ });
                if (((com.tencent.wecall.talkroom.a.d)localObject1).xfO) {
                  break label2901;
                }
                i = 1;
                localObject2 = com.tencent.pb.common.c.b.C(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
                if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
                  h.KA(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
                }
                if (paramInt2 != 14002)
                {
                  xdF = null;
                  if (paramInt2 == 0) {
                    break label3168;
                  }
                  if (com.tencent.pb.common.c.g.gK(this.xdQ, ((com.tencent.wecall.talkroom.a.d)localObject1).xdQ)) {
                    break label2907;
                  }
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.xdQ, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).xdQ, " errCode: ", Integer.valueOf(paramInt2) });
                  if (i != 0) {
                    this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                  }
                }
              }
            }
            if (paramd.getType() == 202)
            {
              paramString = (com.tencent.wecall.talkroom.a.e)paramd;
              if ((paramString != null) && (paramString.wFx != null)) {
                a(paramInt2, (a.aa)paramString.wFx, paramString);
              }
            }
            if (paramd.getType() == 204)
            {
              paramString = (com.tencent.wecall.talkroom.a.b)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                localObject1 = (a.x)paramString.wFx;
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), " errCode: ", Integer.valueOf(paramInt2) });
                localObject2 = com.tencent.pb.common.c.b.C(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303) });
                if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
                  h.KA(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
                }
                if (paramInt2 == 0) {
                  break label4099;
                }
                if (b(paramString.kWU, paramString.lvU, paramString.xdR, false))
                {
                  this.xdZ.R(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
                  this.xeh.i(-300, null);
                }
              }
            }
            if (paramd.getType() == 203)
            {
              paramString = (com.tencent.wecall.talkroom.a.f)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ab)paramString.wFx).groupId, this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), " errCode: ", Integer.valueOf(paramInt2) });
                paramString = com.tencent.pb.common.c.b.C(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
                if (paramString.containsKey(Integer.valueOf(paramInt2))) {
                  h.KA(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
                }
                if (paramInt2 != 0) {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
                }
              }
            }
            if (paramd.getType() == 205)
            {
              paramString = (m)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.ak)paramString.wFx).groupId, this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
                cRQ();
                i = 0;
                if (paramInt2 != 14800) {
                  break label4316;
                }
                i = -1401;
                label2000:
                if (i != 0)
                {
                  this.xdZ.KE(324);
                  h.KA(i);
                }
              }
            }
            if (paramd.getType() == 206)
            {
              paramString = (com.tencent.wecall.talkroom.a.a)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.kWU, " roomid: ", Integer.valueOf(paramString.lvU), " roomKey: ", Long.valueOf(paramString.xdR) });
                if (paramInt2 != 18950) {
                  break label4331;
                }
                if (!b(paramString.kWU, paramString.lvU, paramString.xdR, false)) {
                  h.a(paramString.kWU, paramString.lvU, paramString.xdR, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
                }
                localObject1 = c.cRC().agB(paramString.kWU);
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.kWU, " multiTalkGroup: ", localObject1 });
                if (localObject1 != null) {
                  this.xeh.a(paramString.xfN, (MultiTalkGroup)localObject1);
                }
              }
            }
            label2258:
            if (paramd.getType() == 207)
            {
              paramString = (com.tencent.wecall.talkroom.a.i)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                if (paramInt2 == 18100) {
                  h.KA(-1501);
                }
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
              }
            }
            if (paramd.getType() == 208)
            {
              paramString = (com.tencent.wecall.talkroom.a.c)paramd;
              if ((paramString != null) && (paramString.wFx != null))
              {
                if (paramInt2 == 18300) {
                  h.KA(-1531);
                }
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
              }
            }
            if (paramd.getType() == 209)
            {
              localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
              if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).wFx != null))
              {
                paramString = (a.ac)((com.tencent.pb.common.b.d)localObject1).wFx;
                if (paramInt2 == 17900) {
                  h.KA(-1511);
                }
                if (paramInt2 == 0) {
                  break label4734;
                }
                this.xeh.dY(((com.tencent.wecall.talkroom.a.g)localObject1).kWU, paramInt2);
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
              }
            }
            if (paramd.getType() == 210)
            {
              com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
              if (paramInt2 == 19100) {
                h.KA(-1541);
              }
            }
            if (paramd.getType() == 211)
            {
              paramString = (com.tencent.wecall.talkroom.a.h)paramd;
              if (paramString != null) {
                a(paramInt1, paramInt2, paramd.wFx, paramString);
              }
            }
            if (paramd.getType() == 212) {
              a(paramInt2, (a.ah)paramd.wFx);
            }
            if (paramd.getType() == 213)
            {
              paramString = (com.tencent.wecall.talkroom.a.j)paramd;
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
              if (paramInt2 == 0) {
                break label4833;
              }
              if (com.tencent.pb.common.c.g.equals(paramString.kWU, this.kWU))
              {
                this.xdZ.R(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
                this.xeh.i(-700, null);
              }
            }
            if (paramd.getType() == 214)
            {
              paramString = (a.af)paramd.wFx;
              localObject1 = (l)paramd;
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
              if (b(((l)localObject1).kWU, ((l)localObject1).lvU, ((l)localObject1).xdR, false)) {
                break label4934;
              }
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((l)localObject1).kWU, Integer.valueOf(((l)localObject1).lvU) });
            }
            for (;;)
            {
              if (paramd.getType() != 800) {
                break label5182;
              }
              paramString = (com.tencent.wecall.talkroom.a.k)paramd;
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
              if (b(paramString.kWU, paramString.lvU, paramString.xdR, false)) {
                break label5184;
              }
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.kWU, Integer.valueOf(paramString.lvU) });
              return;
              label2901:
              i = 0;
              break;
              label2907:
              if (paramInt2 != -1)
              {
                this.xdZ.KE(321);
                this.xdZ.R(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
              }
              if (this.state != 1)
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).xdQ });
                if (i == 0) {
                  break label1332;
                }
                this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                break label1332;
              }
              a(this.kWU, this.lvU, this.xdR, true);
              if (paramInt2 == 14051) {
                this.xeh.i(-900, null);
              }
              for (;;)
              {
                if (i == 0) {
                  break label3166;
                }
                this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                break;
                if (paramInt2 == 14052) {
                  this.xeh.i(-1100, null);
                } else if (paramInt2 == 14053) {
                  this.xeh.i(-1300, paramString);
                } else if (paramInt2 == 14504) {
                  this.xeh.i(-1400, null);
                } else {
                  this.xeh.i(-100, null);
                }
              }
              label3166:
              break label1332;
              label3168:
              if (!com.tencent.pb.common.c.g.gK(this.xdQ, paramString.wGf))
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.xdQ, " resp.clientGroupId: ", paramString.wGf, Integer.valueOf(paramString.pRI), Long.valueOf(paramString.pRJ) });
                a(paramString.groupId, paramString.pRI, paramString.pRJ, 110, false);
                if (i == 0) {
                  break label1332;
                }
                this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                break label1332;
              }
              this.xdZ.R(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
              if (this.state != 1)
              {
                h.KA(-1003);
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.wGf, Integer.valueOf(paramString.pRI), Long.valueOf(paramString.pRJ) });
                if (i == 0) {
                  break label1332;
                }
                this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                break label1332;
              }
              if ((paramString.wHA == null) || (paramString.wHA.length == 0))
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.wGf, Integer.valueOf(paramString.pRI), Long.valueOf(paramString.pRJ) });
                h.KA(-1605);
                this.xdZ.qdu = 329;
                a(paramString.groupId, paramString.pRI, paramString.pRJ, 116, true);
                if (i != 0) {
                  this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                }
                this.xeh.i(-100, null);
                break label1332;
              }
              a(paramString.wGf, paramString.pRI, paramString.pRJ, paramString.groupId, paramString.wGh.wIC);
              this.xel = paramString.groupId;
              this.wFA = paramString.wGk;
              setState(4);
              a(paramString.wHA, paramString.wHH, paramString.wHI);
              a(paramString.groupId, paramString.wGf, paramString.wGk, paramString.pRI, paramString.pRJ, paramString.wGL, paramString.wHB, paramString.wGh, false, true);
              if (this.xeh != null)
              {
                localObject1 = this.xeh;
                localObject2 = new g.6((g)localObject1, c.cRC().agB(paramString.groupId));
                if (Looper.myLooper() != Looper.getMainLooper()) {
                  break label3733;
                }
                ((Runnable)localObject2).run();
              }
              for (;;)
              {
                localObject1 = new byte[paramString.wHD.length];
                j = 0;
                while (j < paramString.wHD.length)
                {
                  localObject1[j] = ((byte)paramString.wHD[j]);
                  j += 1;
                }
                ((g)localObject1).handler.post((Runnable)localObject2);
              }
              localObject2 = new int[paramString.wHM.length];
              int j = 0;
              while (j < paramString.wHM.length)
              {
                localObject2[j] = paramString.wHM[j];
                j += 1;
              }
              a.av[] arrayOfav = paramString.wGL;
              a.as localas = paramString.wGM;
              if ((paramString.wHC & 0x2) != 0) {}
              for (boolean bool = true;; bool = false)
              {
                a(0, arrayOfav, localas, (byte[])localObject1, bool, paramString.groupId, paramString.pRI, paramString.pRJ, paramString.wHJ, paramString.wHK, paramString.wHL, (int[])localObject2, paramString.wGO);
                if (paramString.wHG != 0)
                {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.wHG });
                  xdM = paramString.wHG * 1000;
                }
                cRP();
                h(paramString.groupId, paramString.pRI, paramString.pRJ);
                if (i != 0)
                {
                  localObject1 = new HashMap();
                  ((Map)localObject1).put("result", Boolean.valueOf(true));
                  ((Map)localObject1).put("shareUrl", new String(paramString.wGh.wIw, Charset.forName("utf-8")));
                  ((Map)localObject1).put("smsShortUrl", new String(paramString.wGh.wIx, Charset.forName("utf-8")));
                  ((Map)localObject1).put("groupId", paramString.groupId);
                  this.xcn.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
                }
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR) });
                break;
              }
              if (((a.x)localObject1).wHz == null)
              {
                i = 0;
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
                if (b(((a.x)localObject1).groupId, ((a.x)localObject1).pRI, ((a.x)localObject1).pRJ, false)) {
                  break label4273;
                }
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.x)localObject1).groupId, this.kWU, " resp.roomid: ", Integer.valueOf(((a.x)localObject1).pRI), Integer.valueOf(this.lvU) });
                h.KA(-1308);
              }
              for (;;)
              {
                a(((a.x)localObject1).groupId, null, this.wFA, ((a.x)localObject1).pRI, ((a.x)localObject1).pRJ, ((a.x)localObject1).wHz, null, ((a.x)localObject1).wGh, true, true);
                break;
                i = ((a.x)localObject1).wHz.length;
                break label4110;
                this.xdZ.R(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
              }
              label4316:
              if (paramInt2 != 14801) {
                break label2000;
              }
              i = -1402;
              break label2000;
              label4331:
              if (paramInt2 == 0) {
                this.xdN = true;
              }
              if (!bPW())
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.kWU });
                cRO();
                oo(false);
                this.xdZ.R(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
                this.pSc = false;
                this.kWU = paramString.kWU;
                this.xel = this.kWU;
                this.lvU = paramString.lvU;
                this.xdR = paramString.xdR;
                this.wFA = paramString.wFA;
                setState(2);
                this.xdV = System.currentTimeMillis();
                localObject1 = this.xdZ;
                com.tencent.pb.common.c.c.d(h.TAG, new Object[] { "beginNotifyTime" });
                ((h)localObject1).xfD = System.currentTimeMillis();
                if (paramInt2 == 18900) {
                  h.KA(-1521);
                }
              }
              while (!com.tencent.pb.common.c.g.equals(paramString.kWU, this.kWU))
              {
                localObject1 = new f.e(this);
                ((f.e)localObject1).groupId = paramString.kWU;
                ((f.e)localObject1).lpD = paramString.lvU;
                ((f.e)localObject1).lpE = paramString.xdR;
                this.xdG.put(paramString.kWU, localObject1);
                localObject1 = c.cRC().agB(paramString.kWU);
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.kWU, " multiTalkGroup: ", localObject1 });
                if (localObject1 == null) {
                  break label4712;
                }
                paramString = this.xeh;
                localObject1 = new g.20(paramString, (MultiTalkGroup)localObject1);
                if (Looper.myLooper() != Looper.getMainLooper()) {
                  break label4699;
                }
                ((Runnable)localObject1).run();
                break;
              }
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.kWU });
              break label2258;
              label4699:
              paramString.handler.post((Runnable)localObject1);
              break label2258;
              label4712:
              a(paramString.kWU, paramString.lvU, paramString.xdR, false, false, false);
              break label2258;
              label4734:
              localObject1 = c.cRC().agw(paramString.groupId);
              if (localObject1 != null)
              {
                com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
                a(paramString.groupId, null, ((TalkRoom)localObject1).cRt(), TalkRoom.cRu(), TalkRoom.bRe(), null, null, paramString.wGh, true, false);
              }
              for (;;)
              {
                this.xeh.dY(paramString.groupId, 0);
                break;
                a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.wGh, true, false);
              }
              label4833:
              if (!com.tencent.pb.common.c.g.equals(paramString.kWU, this.kWU)) {
                break label2699;
              }
              this.xdZ.R(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
              paramString = this.xeh;
              localObject1 = new g.18(paramString);
              if (Looper.myLooper() == Looper.getMainLooper())
              {
                ((Runnable)localObject1).run();
                break label2699;
              }
              paramString.handler.post((Runnable)localObject1);
              break label2699;
              label4934:
              if (this.xea != null)
              {
                localObject1 = new int[6];
                localObject1[0] = paramString.wHO;
                localObject1[1] = paramString.wHP;
                localObject1[2] = paramString.wHQ;
                localObject1[3] = paramString.wHR;
                localObject1[4] = paramString.wHS;
                localObject1[5] = paramString.wHT;
                com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
                this.xea.xdr.setMVSvrCfg((int[])localObject1, 6);
              }
              if (paramInt2 == 0)
              {
                localObject1 = this.xeh;
                paramString = new g.15((g)localObject1, paramString.wHO);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                  paramString.run();
                } else {
                  ((g)localObject1).handler.post(paramString);
                }
              }
              else if (paramInt2 == 24301)
              {
                this.xeh.i(-1700, Integer.valueOf(paramString.wHV));
              }
              else
              {
                this.xeh.i(-800, null);
              }
            }
          }
        }
      }
    }
    label2699:
    label3733:
    label4273:
    label5184:
    if (paramInt2 == 0)
    {
      paramString = this.xeh;
      paramd = new g.16(paramString);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        paramd.run();
        return;
      }
      paramString.handler.post(paramd);
      return;
    }
    label4099:
    label4110:
    this.xeh.i(-1600, null);
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.kWU, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.lvU), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.xdR) });
    Object localObject1 = c.cRC();
    for (;;)
    {
      try
      {
        localObject1 = ((c)localObject1).agw(paramString);
        if (localObject1 != null) {
          continue;
        }
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "handleRoomExit assert failed: current TalkRoom MUST exists" });
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[] { "handleRoomExit: ", localThrowable });
        continue;
        String str = localThrowable.wJL;
        continue;
        str.handler.post((Runnable)localObject2);
        continue;
      }
      if (paramBoolean1) {
        h(paramString, paramInt, paramLong);
      }
      this.xdG.remove(paramString);
      if (b(paramString, paramInt, paramLong, false))
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
        oo(true);
        localObject1 = this.xeh;
        localObject2 = new g.8((g)localObject1, paramString, paramBoolean2);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        ((Runnable)localObject2).run();
      }
      if (paramBoolean3)
      {
        paramString = c.cRC().agB(paramString);
        if (paramString != null) {
          this.xeh.g(paramString);
        }
      }
      return;
      localObject2 = ((TalkRoom)localObject1).agv(com.tencent.pb.a.a.a.cOl());
      if (localObject2 != null)
      {
        ((d)localObject2).xdx.status = 20;
        ((d)localObject2).xdx.iEo = -1;
      }
      if (((TalkRoom)localObject1).wJL != null) {
        continue;
      }
      localObject1 = "";
      com.tencent.pb.common.c.c.d("tagorewang:TalkRoom", new Object[] { "resetRoomTempInfo groupId: ", localObject1 });
      c.cRD();
    }
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.kWU, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i;
    boolean bool;
    if (1 == paramInt2)
    {
      i = 1;
      if ((3 == i) && (paramInt2 != 7) && (this.xdV != 0L)) {
        System.currentTimeMillis();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.cNS().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label239;
      }
      this.xdZ.R(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, false);
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "rejectTalkRoom ret: ", Boolean.valueOf(bool) });
      return bool;
      i = 3;
      break;
      label239:
      h.a(paramString, paramInt1, paramLong, new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "exitTalkRoom: has exited" });
      return false;
    }
    com.tencent.wecall.talkroom.a.f localf = new com.tencent.wecall.talkroom.a.f(paramString, paramInt1, paramLong, paramInt2);
    boolean bool = com.tencent.pb.common.b.e.cNS().a(localf);
    this.xdZ.R(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public final f.e agC(String paramString)
  {
    return (f.e)this.xdG.get(paramString);
  }
  
  public final boolean agD(String paramString)
  {
    return (f.e)this.xdG.get(paramString) != null;
  }
  
  public final boolean at(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100))
    {
      localObject = this.xdZ;
      com.tencent.pb.common.c.c.d(h.TAG, new Object[] { "endCancelCreate", Long.valueOf(System.currentTimeMillis() - ((h)localObject).xfB), Long.valueOf(((h)localObject).xfq) });
      if (((h)localObject).xfq <= 0L)
      {
        ((h)localObject).qdB = 1;
        if (((h)localObject).xfB != 0L) {
          break label195;
        }
      }
    }
    int i;
    long l;
    int j;
    label195:
    for (((h)localObject).qdC = 0L;; ((h)localObject).qdC = (System.currentTimeMillis() - ((h)localObject).xfB))
    {
      i = this.lvU;
      l = this.xdR;
      j = a.cRq().state;
      if (!j.agI(paramString)) {
        break;
      }
      this.xdZ.KE(327);
      return a.cRq().dZ(paramString, 1000);
    }
    if (j == 2) {
      return a.cRq().a(paramString, i, l, paramInt1);
    }
    Object localObject = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < 7)
    {
      ((List)localObject).add(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }[paramInt1]);
      paramInt1 += 1;
    }
    ((List)localObject).contains(Integer.valueOf(paramInt2));
    return a.cRq().a(paramString, i, l, paramInt2, true);
  }
  
  final boolean bMH()
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "initEngine", this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), Integer.valueOf(this.state) });
    try
    {
      localb = this.xea;
      boolean bool = com.tencent.pb.common.a.a.wFa;
      if (bool) {
        break label119;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb;
        label119:
        String str;
        com.tencent.pb.talkroom.sdk.e locale;
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "initEngine", localException });
        i = -99999;
        continue;
        i = localException.xdr.field_capInfo.length;
      }
    }
    if (i < 0)
    {
      h.KD(-3001);
      this.xdZ.KE(201);
      this.xea = null;
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      return false;
      str = com.tencent.pb.common.c.d.pZI.getDir("lib", 0).getAbsolutePath();
      locale = wFM;
      if (locale == null) {
        break label338;
      }
    }
    label338:
    for (int i = locale.yR();; i = 0)
    {
      int j = k.ij(com.tencent.pb.common.c.d.pZI);
      com.tencent.pb.common.c.c.d("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(j), " cpuFlag:", Integer.valueOf(i), "libPath:", str });
      j = localb.xdr.init(j, i, str + "/");
      if (localb.xdr.field_capInfo == null)
      {
        i = 0;
        com.tencent.pb.common.c.c.d("simon:TalkRoomContext", new Object[] { "protocalInit", Integer.valueOf(j), "field_capInfo length: ", Integer.valueOf(i) });
        i = j;
        break;
      }
      return true;
    }
  }
  
  public final boolean bPW()
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "state: ", Integer.valueOf(this.state) });
    return this.state != 0;
  }
  
  public final int bU(byte[] paramArrayOfByte)
  {
    long l;
    int i;
    try
    {
      paramArrayOfByte = (a.p)com.google.a.a.e.a(new a.p(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.kWU)) || (!TextUtils.isEmpty(this.xdQ)))
        {
          this.xdZ.R(new String[] { "notify", "pasrefail" });
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange groupChg null" });
          return -2;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        h.KA(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.lvU, this.xdR, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange", this.kWU, Integer.valueOf(this.lvU), Long.valueOf(this.xdR), Long.valueOf(paramArrayOfByte.bIt), Integer.valueOf(paramArrayOfByte.wGJ) });
      l = paramArrayOfByte.bIt;
      if (this.xem.contains(Long.valueOf(l)))
      {
        i = 1;
        if (i == 0) {
          break label350;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error" });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false)) {
          break label306;
        }
        this.xdZ.R(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.wGJ) });
      }
      for (;;)
      {
        return -3;
        this.xem.add(Long.valueOf(l));
        i = 0;
        break;
        label306:
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.wGJ) });
      }
      label350:
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false)) {
        this.xdZ.R(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.wGJ) });
      }
      if (paramArrayOfByte.wGJ != 2) {
        break label448;
      }
    }
    a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, true, true);
    for (;;)
    {
      return 0;
      label448:
      Object localObject1;
      int j;
      if (paramArrayOfByte.wGJ == 4)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, true, true);
        if ((paramArrayOfByte.wGN != 0) || (paramArrayOfByte.wGO != 0))
        {
          localObject1 = this.xea;
          i = paramArrayOfByte.wGN;
          j = paramArrayOfByte.wGO;
          if (com.tencent.pb.common.a.a.wFa) {
            ((b)localObject1).xdr.SetAVEncryptType(i, j);
          }
        }
      }
      else if (paramArrayOfByte.wGJ == 16)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, true, false);
      }
      else if (paramArrayOfByte.wGJ == 1)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.pRI), " roomkey: ", Long.valueOf(paramArrayOfByte.pRJ) });
        if (!com.tencent.pb.a.a.a.cOm())
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
        }
        else if ((bPW()) && (com.tencent.pb.common.c.g.equals(paramArrayOfByte.groupId, this.kWU)))
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.kWU });
        }
        else
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, false, true);
          localObject1 = paramArrayOfByte.groupId;
          i = paramArrayOfByte.pRI;
          l = paramArrayOfByte.pRJ;
          j = paramArrayOfByte.wGk;
          int k = paramArrayOfByte.wGP;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
          }
          for (;;)
          {
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
            break;
            paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, i, l, j, k);
            com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(k), Boolean.valueOf(com.tencent.pb.common.b.e.cNS().a(paramArrayOfByte)) });
          }
        }
      }
      else if (paramArrayOfByte.wGJ == 8)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.kWU });
        if (b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false))
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, true, false);
          a(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false, false, true);
        }
        else
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.wGk, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, paramArrayOfByte.wGL, paramArrayOfByte.wGK, paramArrayOfByte.wGh, true, false);
        }
      }
      else
      {
        String str;
        if (paramArrayOfByte.wGJ == 128)
        {
          localObject1 = paramArrayOfByte.groupId;
          str = this.kWU;
          if (paramArrayOfByte.wGQ == null) {}
          for (i = 0;; i = paramArrayOfByte.wGQ.length)
          {
            com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(i) });
            localObject1 = this.xeh;
            paramArrayOfByte = new g.17((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.wGQ);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label1194;
            }
            paramArrayOfByte.run();
            break;
          }
          label1194:
          ((g)localObject1).handler.post(paramArrayOfByte);
        }
        else
        {
          Object localObject2;
          if (paramArrayOfByte.wGJ == 256)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false)) {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
            } else if (paramArrayOfByte.wGQ == null) {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
            } else {
              try
              {
                localObject1 = paramArrayOfByte.wGQ;
                localObject1 = (a.r)com.google.a.a.e.a(new a.r(), (byte[])localObject1, localObject1.length);
                if ((localObject1 == null) || (((a.r)localObject1).wGU == null)) {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
                }
              }
              catch (com.google.a.a.d locald1)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoMember ", locald1 });
                  localObject2 = null;
                }
                paramArrayOfByte = new ArrayList();
                localObject2 = ((a.r)localObject2).wGU;
                j = localObject2.length;
                i = 0;
                while (i < j)
                {
                  str = localObject2[i];
                  if (str != null) {
                    paramArrayOfByte.add(str);
                  }
                  i += 1;
                }
                com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.kWU, " roomId: ", Integer.valueOf(this.lvU), " videoUserNames: ", paramArrayOfByte });
                localObject2 = this.xeh;
                paramArrayOfByte = new g.11((g)localObject2, paramArrayOfByte);
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                  paramArrayOfByte.run();
                  continue;
                }
                ((g)localObject2).handler.post(paramArrayOfByte);
              }
            }
          }
          else if (paramArrayOfByte.wGJ == 1024)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false))
            {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
            }
            else if ((this.state != 3) && (this.state != 4))
            {
              a(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, 1);
              this.xeh.i(-1400, null);
            }
          }
          else if (paramArrayOfByte.wGJ == 512) {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.pRI, paramArrayOfByte.pRJ, false)) {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
            } else if (paramArrayOfByte.wGQ == null) {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
            } else {
              try
              {
                localObject2 = paramArrayOfByte.wGQ;
                localObject2 = (a.q)com.google.a.a.e.a(new a.q(), (byte[])localObject2, localObject2.length);
                if (localObject2 == null) {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.pRI) });
                }
              }
              catch (com.google.a.a.d locald2)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                  local1 = null;
                }
                paramArrayOfByte = this.xeh;
                g.1 local1 = new g.1(paramArrayOfByte, local1.wGT);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                  local1.run();
                } else {
                  paramArrayOfByte.handler.post(local1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  final boolean cRL()
  {
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = wFM;
    if (locale != null) {
      locale.bkJ();
    }
    this.xea = new b();
    this.xel = this.kWU;
    this.xeb = new f.1(this);
    return true;
  }
  
  public final void cRM()
  {
    try
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.xex != null) {
        this.mHandler.removeCallbacks(this.xex);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { " stopTimer: ", localThrowable });
    }
  }
  
  public final void cRO()
  {
    h localh = this.xdZ;
    com.tencent.pb.common.c.c.d(h.TAG, new Object[] { "reset" });
    localh.xfD = 0L;
    localh.xfC = 0L;
    localh.xfB = 0L;
    localh.groupId = "";
    localh.wGf = "";
    localh.pUM = 1;
    localh.lpD = 0;
    localh.lpE = 0L;
    localh.iEo = -1;
    localh.qdu = 0;
    localh.qdB = 0;
    localh.qdx = 0;
    localh.lqU = 0;
    localh.xfo = 0;
    localh.xfp = 0;
    localh.xfq = 0L;
    localh.xfr = 0L;
    localh.xfs = 0;
    localh.xft = 0;
    localh.xfu = 0;
    localh.xfv = 0L;
    localh.qdC = 0L;
    localh.lqT = 0L;
    localh.qdH = 0;
    localh.qdI = 0;
    localh.netType = -1;
    localh.xfw = 0;
    localh.xfx = 0;
    localh.xfy = "";
    localh.deviceModel = "";
    localh.xfz = -1;
    localh.qdN = "";
    localh.xfA.setLength(0);
    localh.pVa = -1;
    localh.pUT = 0;
    localh.pUP = 0;
    localh.pUQ = 0;
  }
  
  public final void dX(String paramString, int paramInt)
  {
    if ((com.tencent.pb.common.c.g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (bPW()) && ((this.lFT) || (this.xdO))) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      switch (k.ij(com.tencent.pb.common.c.d.pZI))
      {
      }
      for (this.xej = false; (this.lvU == 0) || (this.xdR == 0L); this.xej = true)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        return;
      }
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "sendRedirect", this.kWU, Integer.valueOf(this.lvU) });
      this.xdZ.cRW();
      paramString = new com.tencent.wecall.talkroom.a.h(this.kWU, this.lvU, this.xdR, c.cRC().agx(this.kWU));
      boolean bool = com.tencent.pb.common.b.e.cNS().a(paramString);
      this.xdZ.R(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      return;
      paramString = this.xea;
      paramInt = k.ij(com.tencent.pb.common.c.d.pZI);
    } while (!com.tencent.pb.common.a.a.wFa);
    paramString.xdr.onNetworkChange(paramInt);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = paramMessage.obj;
      if (this.state == 4)
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerInviteTimeOut state: ", Integer.valueOf(this.state) });
      }
      else if (!(paramMessage instanceof d))
      {
        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerInviteTimeOut obj is not GroupRoomInfo" });
      }
      else
      {
        paramMessage = (d)paramMessage;
        if (paramMessage.kWU == null)
        {
          com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.kWU.equals(this.kWU)) && (paramMessage.lvU == this.lvU) && (paramMessage.xdR == this.xdR))
          {
            h.cRX();
            this.xdZ.KE(501);
            a(paramMessage.kWU, paramMessage.lvU, paramMessage.xdR, 7);
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.kWU });
            continue;
            paramMessage = paramMessage.obj;
            if (this.state != 1)
            {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerCreateGroup state: ", Integer.valueOf(this.state) });
            }
            else if (!(paramMessage instanceof f.a))
            {
              com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
            }
            else
            {
              paramMessage = (f.a)paramMessage;
              if (com.tencent.pb.common.c.g.gK(paramMessage.groupId, this.kWU))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.xeO;
                a.ay localay = paramMessage.xeP;
                int i = paramMessage.wGk;
                int j = paramMessage.type;
                long l = paramMessage.xeQ;
                String str2 = paramMessage.xeR;
                boolean bool = paramMessage.xeS;
                String str3 = paramMessage.xeT;
                this.xdZ.cRW();
                Object localObject2 = c.cRC();
                paramMessage = "";
                localObject2 = ((c)localObject2).agw(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).xdp != null) {
                    break label608;
                  }
                }
                label608:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).xdp.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.xea.cRA(), paramMessage, localay, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.cNS().a((com.tencent.pb.common.b.d)localObject1);
                  this.xdZ.R(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "sendCreateSence groupId: ", str1, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(j), " playId: ", Long.valueOf(l), " name: ", paramMessage, " ret: ", Boolean.valueOf(bool) });
                  break;
                }
                paramMessage = paramMessage.obj;
                if (this.state != 3)
                {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerEnterGroup state: ", Integer.valueOf(this.state) });
                }
                else if (!(paramMessage instanceof f.c))
                {
                  com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
                }
                else
                {
                  paramMessage = (f.c)paramMessage;
                  if (b(paramMessage.groupId, paramMessage.lpD, paramMessage.lpE, false))
                  {
                    b(paramMessage.groupId, paramMessage.lpD, paramMessage.lpE, paramMessage.wGk, paramMessage.wGr, paramMessage.xff);
                    continue;
                    com.tencent.pb.common.c.f.cOk();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public final void oo(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   4: aload_0
    //   5: getfield 516	com/tencent/wecall/talkroom/model/f:kWU	Ljava/lang/String;
    //   8: putfield 2067	com/tencent/wecall/talkroom/model/h:groupId	Ljava/lang/String;
    //   11: aload_0
    //   12: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   15: aload_0
    //   16: getfield 705	com/tencent/wecall/talkroom/model/f:xdQ	Ljava/lang/String;
    //   19: putfield 2068	com/tencent/wecall/talkroom/model/h:wGf	Ljava/lang/String;
    //   22: aload_0
    //   23: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   26: getfield 2067	com/tencent/wecall/talkroom/model/h:groupId	Ljava/lang/String;
    //   29: invokestatic 2212	com/tencent/pb/common/c/g:isEmpty	(Ljava/lang/String;)Z
    //   32: ifeq +13 -> 45
    //   35: aload_0
    //   36: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   39: ldc_w 1404
    //   42: putfield 2067	com/tencent/wecall/talkroom/model/h:groupId	Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   49: getfield 2068	com/tencent/wecall/talkroom/model/h:wGf	Ljava/lang/String;
    //   52: invokestatic 2212	com/tencent/pb/common/c/g:isEmpty	(Ljava/lang/String;)Z
    //   55: ifeq +13 -> 68
    //   58: aload_0
    //   59: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   62: ldc_w 1404
    //   65: putfield 2068	com/tencent/wecall/talkroom/model/h:wGf	Ljava/lang/String;
    //   68: aload_0
    //   69: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   72: iconst_1
    //   73: putfield 2071	com/tencent/wecall/talkroom/model/h:pUM	I
    //   76: aload_0
    //   77: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   80: aload_0
    //   81: getfield 386	com/tencent/wecall/talkroom/model/f:lvU	I
    //   84: putfield 2072	com/tencent/wecall/talkroom/model/h:lpD	I
    //   87: aload_0
    //   88: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   91: aload_0
    //   92: getfield 517	com/tencent/wecall/talkroom/model/f:xdR	J
    //   95: putfield 2073	com/tencent/wecall/talkroom/model/h:lpE	J
    //   98: ldc_w 276
    //   101: iconst_2
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: ldc_w 2214
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: iload_1
    //   114: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   117: aastore
    //   118: invokestatic 318	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: ldc_w 276
    //   124: iconst_1
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 2216
    //   133: aastore
    //   134: invokestatic 318	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_0
    //   138: invokespecial 1341	com/tencent/wecall/talkroom/model/f:uh	()Z
    //   141: pop
    //   142: aload_0
    //   143: invokespecial 1203	com/tencent/wecall/talkroom/model/f:cRN	()Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 140	com/tencent/wecall/talkroom/model/f:xdG	Ljava/util/Map;
    //   151: aload_0
    //   152: getfield 516	com/tencent/wecall/talkroom/model/f:kWU	Ljava/lang/String;
    //   155: invokeinterface 1807 2 0
    //   160: pop
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 201	com/tencent/wecall/talkroom/model/f:xei	I
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 228	com/tencent/wecall/talkroom/model/f:mIsMute	Z
    //   171: aload_0
    //   172: iconst_0
    //   173: invokevirtual 556	com/tencent/wecall/talkroom/model/f:setState	(I)V
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 158	com/tencent/wecall/talkroom/model/f:xdO	Z
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 705	com/tencent/wecall/talkroom/model/f:xdQ	Ljava/lang/String;
    //   186: iconst_0
    //   187: lconst_0
    //   188: aconst_null
    //   189: aconst_null
    //   190: invokespecial 1677	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: aconst_null
    //   195: putfield 705	com/tencent/wecall/talkroom/model/f:xdQ	Ljava/lang/String;
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 388	com/tencent/wecall/talkroom/model/f:wFA	I
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 162	com/tencent/wecall/talkroom/model/f:xdS	I
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 164	com/tencent/wecall/talkroom/model/f:xdT	I
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 166	com/tencent/wecall/talkroom/model/f:xdU	I
    //   218: aload_0
    //   219: iconst_1
    //   220: putfield 170	com/tencent/wecall/talkroom/model/f:xdW	Z
    //   223: aload_0
    //   224: iconst_1
    //   225: putfield 214	com/tencent/wecall/talkroom/model/f:xeo	Z
    //   228: aload_0
    //   229: lconst_0
    //   230: putfield 168	com/tencent/wecall/talkroom/model/f:xdV	J
    //   233: aload_0
    //   234: iconst_0
    //   235: putfield 172	com/tencent/wecall/talkroom/model/f:xdX	I
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 156	com/tencent/wecall/talkroom/model/f:xdN	Z
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 230	com/tencent/wecall/talkroom/model/f:xev	Z
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 232	com/tencent/wecall/talkroom/model/f:xew	Z
    //   253: aload_0
    //   254: invokevirtual 2218	com/tencent/wecall/talkroom/model/f:cRM	()V
    //   257: aload_0
    //   258: getfield 291	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   261: iconst_1
    //   262: invokevirtual 2221	android/os/Handler:removeMessages	(I)V
    //   265: aload_0
    //   266: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   269: ifnull +24 -> 293
    //   272: aload_0
    //   273: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   276: astore 4
    //   278: getstatic 1882	com/tencent/pb/common/a/a:wFa	Z
    //   281: ifeq +12 -> 293
    //   284: aload 4
    //   286: getfield 1032	com/tencent/wecall/talkroom/model/b:xdr	Lcom/tencent/mm/plugin/multi/talk;
    //   289: aconst_null
    //   290: putfield 1914	com/tencent/mm/plugin/multi/talk:field_capInfo	[B
    //   293: aload_0
    //   294: invokespecial 1330	com/tencent/wecall/talkroom/model/f:cRR	()V
    //   297: aload_0
    //   298: invokespecial 1618	com/tencent/wecall/talkroom/model/f:cRQ	()V
    //   301: ldc_w 276
    //   304: iconst_1
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 2223
    //   313: aastore
    //   314: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_0
    //   318: getfield 757	com/tencent/wecall/talkroom/model/f:xef	Ljava/util/TimerTask;
    //   321: ifnull +11 -> 332
    //   324: aload_0
    //   325: getfield 757	com/tencent/wecall/talkroom/model/f:xef	Ljava/util/TimerTask;
    //   328: invokevirtual 1193	java/util/TimerTask:cancel	()Z
    //   331: pop
    //   332: aload_0
    //   333: aconst_null
    //   334: putfield 757	com/tencent/wecall/talkroom/model/f:xef	Ljava/util/TimerTask;
    //   337: aload_0
    //   338: getfield 291	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   341: aload_0
    //   342: getfield 244	com/tencent/wecall/talkroom/model/f:xez	Ljava/lang/Runnable;
    //   345: invokevirtual 1134	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   348: aload_0
    //   349: aconst_null
    //   350: putfield 241	com/tencent/wecall/talkroom/model/f:xey	Lcom/tencent/pb/common/b/d;
    //   353: aload_0
    //   354: iconst_0
    //   355: putfield 160	com/tencent/wecall/talkroom/model/f:lFT	Z
    //   358: aload_0
    //   359: iconst_0
    //   360: putfield 212	com/tencent/wecall/talkroom/model/f:xen	Z
    //   363: ldc_w 1074
    //   366: istore_3
    //   367: iload_3
    //   368: istore_2
    //   369: aload_0
    //   370: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   373: ifnull +45 -> 418
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   381: invokevirtual 2226	com/tencent/wecall/talkroom/model/b:cRB	()I
    //   384: putfield 201	com/tencent/wecall/talkroom/model/f:xei	I
    //   387: aload_0
    //   388: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   391: invokevirtual 430	com/tencent/wecall/talkroom/model/b:Close	()I
    //   394: istore_2
    //   395: ldc_w 276
    //   398: iconst_2
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: ldc_w 2228
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: iload_2
    //   411: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: aload_0
    //   419: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   422: ifnull +301 -> 723
    //   425: aload_0
    //   426: getfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   429: invokevirtual 2231	com/tencent/wecall/talkroom/model/b:uninitLive	()I
    //   432: istore_3
    //   433: iload_3
    //   434: istore_2
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 424	com/tencent/wecall/talkroom/model/f:xea	Lcom/tencent/wecall/talkroom/model/b;
    //   440: iload_1
    //   441: ifeq +129 -> 570
    //   444: aload_0
    //   445: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   448: invokevirtual 2234	com/tencent/wecall/talkroom/model/h:cRU	()Ljava/lang/String;
    //   451: astore 4
    //   453: aload_0
    //   454: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   457: getfield 2067	com/tencent/wecall/talkroom/model/h:groupId	Ljava/lang/String;
    //   460: invokestatic 729	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifeq +16 -> 479
    //   466: aload_0
    //   467: getfield 181	com/tencent/wecall/talkroom/model/f:xdZ	Lcom/tencent/wecall/talkroom/model/h;
    //   470: getfield 2068	com/tencent/wecall/talkroom/model/h:wGf	Ljava/lang/String;
    //   473: invokestatic 729	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   476: ifne +26 -> 502
    //   479: aload 4
    //   481: invokestatic 2237	com/tencent/wecall/talkroom/model/h:agE	(Ljava/lang/String;)V
    //   484: aload_0
    //   485: getfield 291	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   488: iconst_4
    //   489: invokevirtual 2221	android/os/Handler:removeMessages	(I)V
    //   492: aload_0
    //   493: getfield 291	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   496: iconst_4
    //   497: lconst_0
    //   498: invokevirtual 2241	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   501: pop
    //   502: aload_0
    //   503: invokevirtual 1450	com/tencent/wecall/talkroom/model/f:cRO	()V
    //   506: getstatic 1024	com/tencent/pb/common/c/d:pZI	Landroid/content/Context;
    //   509: ldc_w 1376
    //   512: invokevirtual 1381	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   515: checkcast 1383	android/media/AudioManager
    //   518: astore 4
    //   520: aload 4
    //   522: iconst_0
    //   523: invokevirtual 2244	android/media/AudioManager:setMode	(I)V
    //   526: ldc_w 276
    //   529: iconst_4
    //   530: anewarray 4	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: ldc_w 2246
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: aload 4
    //   543: invokevirtual 2249	android/media/AudioManager:getMode	()I
    //   546: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: dup
    //   551: iconst_2
    //   552: ldc_w 2251
    //   555: aastore
    //   556: dup
    //   557: iconst_3
    //   558: aload 4
    //   560: invokevirtual 1386	android/media/AudioManager:isSpeakerphoneOn	()Z
    //   563: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   566: aastore
    //   567: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   570: ldc_w 276
    //   573: iconst_2
    //   574: anewarray 4	java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: ldc_w 2253
    //   582: aastore
    //   583: dup
    //   584: iconst_1
    //   585: iload_2
    //   586: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: aastore
    //   590: invokestatic 318	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   593: return
    //   594: astore 4
    //   596: ldc_w 276
    //   599: iconst_2
    //   600: anewarray 4	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: ldc_w 2255
    //   608: aastore
    //   609: dup
    //   610: iconst_1
    //   611: aload 4
    //   613: aastore
    //   614: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: goto -475 -> 142
    //   620: astore 4
    //   622: ldc_w 276
    //   625: iconst_2
    //   626: anewarray 4	java/lang/Object
    //   629: dup
    //   630: iconst_0
    //   631: ldc_w 2255
    //   634: aastore
    //   635: dup
    //   636: iconst_1
    //   637: aload 4
    //   639: aastore
    //   640: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: goto -496 -> 147
    //   646: astore 4
    //   648: ldc_w 276
    //   651: iconst_2
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: ldc_w 2257
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: aload 4
    //   665: aastore
    //   666: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   669: goto -337 -> 332
    //   672: astore 4
    //   674: ldc_w 276
    //   677: iconst_2
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: ldc_w 2259
    //   686: aastore
    //   687: dup
    //   688: iconst_1
    //   689: aload 4
    //   691: aastore
    //   692: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: iload_3
    //   696: istore_2
    //   697: goto -302 -> 395
    //   700: astore 4
    //   702: ldc_w 276
    //   705: iconst_2
    //   706: anewarray 4	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: ldc_w 2261
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: aload 4
    //   719: aastore
    //   720: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   723: goto -288 -> 435
    //   726: astore 4
    //   728: ldc_w 276
    //   731: iconst_2
    //   732: anewarray 4	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: ldc_w 2263
    //   740: aastore
    //   741: dup
    //   742: iconst_1
    //   743: aload 4
    //   745: aastore
    //   746: invokestatic 520	com/tencent/pb/common/c/c:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   749: goto -179 -> 570
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	this	f
    //   0	752	1	paramBoolean	boolean
    //   368	329	2	i	int
    //   366	330	3	j	int
    //   276	283	4	localObject	Object
    //   594	18	4	localThrowable1	Throwable
    //   620	18	4	localThrowable2	Throwable
    //   646	18	4	localException1	Exception
    //   672	18	4	localThrowable3	Throwable
    //   700	18	4	localException2	Exception
    //   726	18	4	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   137	142	594	java/lang/Throwable
    //   142	147	620	java/lang/Throwable
    //   301	332	646	java/lang/Exception
    //   376	395	672	java/lang/Throwable
    //   425	433	700	java/lang/Exception
    //   506	570	726	java/lang/Throwable
  }
  
  public final void op(boolean paramBoolean)
  {
    try
    {
      uh();
      cRN();
      if (paramBoolean)
      {
        cRS();
        startRecord();
      }
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean), localThrowable });
    }
  }
  
  final void setState(int paramInt)
  {
    com.tencent.pb.common.c.c.x("TalkRoomService", new Object[] { "setState newState: ", Integer.valueOf(paramInt) });
    if (this.state == paramInt) {
      return;
    }
    this.state = paramInt;
    g localg = this.xeh;
    g.9 local9 = new g.9(localg, paramInt);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local9.run();
      return;
    }
    localg.handler.post(local9);
  }
  
  final class d
  {
    String kWU;
    int lvU;
    long xdR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */