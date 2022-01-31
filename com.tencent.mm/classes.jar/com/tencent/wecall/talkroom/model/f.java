package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  implements Handler.Callback, com.tencent.h.a.d, com.tencent.pb.common.b.b
{
  public static String[] BAR;
  public static List<Integer> BAn;
  private static int BAu;
  private static com.tencent.pb.talkroom.sdk.e Bdm;
  private int BAA;
  private int BAB;
  private long BAC;
  private boolean BAD;
  private int BAE;
  int BAF;
  public h BAG;
  b BAH;
  private talk.a BAI;
  private TimerTask BAJ;
  private TimerTask BAK;
  private Timer BAL;
  private TimerTask BAM;
  private Timer BAN;
  g BAO;
  private int BAP;
  private boolean BAQ;
  public String BAS;
  HashSet<Long> BAT;
  public boolean BAU;
  public boolean BAV;
  public boolean BAW;
  private short[] BAX;
  private int[] BAY;
  private short[] BAZ;
  f.f BAm;
  private Map<String, f.e> BAo;
  private final int BAp;
  private final int BAq;
  private final int BAr;
  private final int BAs;
  public final int BAt;
  private boolean BAv;
  private boolean BAw;
  private String BAx;
  public String BAy;
  private int BAz;
  private int[] BBa;
  private int BBb;
  public boolean BBc;
  public boolean BBd;
  private Runnable BBe;
  private com.tencent.pb.common.b.d BBf;
  private Runnable BBg;
  int Bda;
  private com.tencent.h.a.a ByT;
  Handler mHandler;
  boolean mIsMute;
  public int nTj;
  public String nuW;
  boolean odg;
  int state;
  public long tFh;
  boolean txk;
  
  static
  {
    AppMethodBeat.i(127947);
    Bdm = null;
    BAn = new ArrayList();
    BAu = 30000;
    BAR = new String[] { "GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other" };
    AppMethodBeat.o(127947);
  }
  
  public f()
  {
    AppMethodBeat.i(127883);
    this.BAo = new HashMap();
    this.BAp = 1;
    this.BAq = 2;
    this.BAr = 3;
    this.BAs = 4;
    this.BAt = 6;
    this.state = 0;
    this.txk = false;
    this.BAv = false;
    this.BAw = false;
    this.odg = false;
    this.BAz = 0;
    this.BAA = 0;
    this.BAB = 0;
    this.BAC = 0L;
    this.BAD = true;
    this.BAE = 0;
    this.BAF = -1;
    this.BAG = h.BBU;
    this.BAL = new Timer("TalkRoomService_HelloTimer");
    this.BAN = new Timer("TalkRoomService_talkDurationTimer");
    this.BAO = new g();
    this.BAP = 0;
    this.BAQ = false;
    this.BAS = null;
    this.BAT = new HashSet();
    this.BAU = false;
    this.BAV = true;
    this.BAW = true;
    this.BAX = null;
    this.BAY = null;
    this.BAZ = null;
    this.BBa = null;
    this.BBb = 0;
    this.mIsMute = false;
    this.BBc = false;
    this.BBd = true;
    this.BBe = new f.8(this);
    this.BBf = null;
    this.BBg = new f.9(this);
    com.tencent.pb.common.b.e.dTE().a(201, this);
    com.tencent.pb.common.b.e.dTE().a(202, this);
    com.tencent.pb.common.b.e.dTE().a(203, this);
    com.tencent.pb.common.b.e.dTE().a(204, this);
    com.tencent.pb.common.b.e.dTE().a(205, this);
    com.tencent.pb.common.b.e.dTE().a(206, this);
    com.tencent.pb.common.b.e.dTE().a(207, this);
    com.tencent.pb.common.b.e.dTE().a(208, this);
    com.tencent.pb.common.b.e.dTE().a(210, this);
    com.tencent.pb.common.b.e.dTE().a(209, this);
    com.tencent.pb.common.b.e.dTE().a(211, this);
    com.tencent.pb.common.b.e.dTE().a(212, this);
    com.tencent.pb.common.b.e.dTE().a(213, this);
    com.tencent.pb.common.b.e.dTE().a(214, this);
    com.tencent.pb.common.b.e.dTE().a(800, this);
    Object localObject = c.dXv();
    g localg = this.BAO;
    Throwable localThrowable = new Throwable("trace caller");
    try
    {
      localThrowable.getStackTrace();
      ((c)localObject).BAe = localg;
      localObject = new HandlerThread("TalkRoomService");
      ((HandlerThread)localObject).start();
      this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
      if (this.ByT == null) {
        this.ByT = ((com.tencent.h.a.a)com.tencent.h.f.axi("EventCenter"));
      }
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "syscall", "register", Boolean.TRUE });
      this.ByT.a(this, BAR);
      AppMethodBeat.o(127883);
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
  
  private boolean Et()
  {
    AppMethodBeat.i(127899);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Bdm;
      if (locale == null) {
        break label99;
      }
      this.BAG.tAv = locale.bSO();
      this.BAG.tAr = locale.bSP();
      bool = locale.bSM();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "stopRecord: ", localException });
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "stopRecord ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127899);
    return bool;
  }
  
  public static boolean KM()
  {
    AppMethodBeat.i(127938);
    try
    {
      bool = ((AudioManager)com.tencent.pb.common.c.d.tFk.getSystemService("audio")).isSpeakerphoneOn();
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "isSpeakerOn ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(127938);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "isSpeakerOn ", localException });
        boolean bool = false;
      }
    }
  }
  
  private static void KS()
  {
    AppMethodBeat.i(127937);
    try
    {
      AudioManager localAudioManager = (AudioManager)com.tencent.pb.common.c.d.tFk.getSystemService("audio");
      localAudioManager.setMode(0);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "resumeAudioConfig mode: ", Integer.valueOf(localAudioManager.getMode()), " isSpeaker: ", Boolean.valueOf(localAudioManager.isSpeakerphoneOn()) });
      AppMethodBeat.o(127937);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "resumeAudioConfig ", localThrowable });
      AppMethodBeat.o(127937);
    }
  }
  
  private void Kg()
  {
    AppMethodBeat.i(127887);
    this.BAo.remove(this.nuW);
    this.BAP = 0;
    this.mIsMute = false;
    setState(0);
    this.BAw = false;
    a(this.BAy, 0, 0L, null, null);
    this.BAy = null;
    this.Bda = 0;
    this.BAz = 0;
    this.BAA = 0;
    this.BAB = 0;
    this.BAD = true;
    this.BAV = true;
    this.BAC = 0L;
    this.BAE = 0;
    this.BAv = false;
    this.BBc = false;
    this.BBd = true;
    dXE();
    this.mHandler.removeMessages(1);
    if (this.BAH != null) {
      this.BAH.dXt();
    }
    dXJ();
    dXI();
    dXK();
    dXN();
    this.odg = false;
    this.BAU = false;
    AppMethodBeat.o(127887);
  }
  
  private static boolean Tr(int paramInt)
  {
    return paramInt != 1;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, com.tencent.wecall.talkroom.a.h paramh)
  {
    AppMethodBeat.i(127907);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRedirectResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt2 != 0) || (paramObject == null))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleRedirectResp err", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (b(paramh.groupId, paramh.nMZ, paramh.nNa, false)) {
        this.BAG.aa(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(127907);
      return;
    }
    paramObject = (a.aj)paramObject;
    if (!b(paramObject.groupId, paramObject.twP, paramObject.twQ, false))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleRedirectResp roomid error", Integer.valueOf(paramObject.twP), Integer.valueOf(this.nTj) });
      AppMethodBeat.o(127907);
      return;
    }
    this.BAG.aa(new String[] { "redirect", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
    a(paramObject.groupId, null, this.Bda, paramObject.twP, paramObject.twQ, paramObject.BeZ, paramObject.Bfb, paramObject.BdI, false, false);
    paramh = new byte[paramObject.Bfd.length];
    paramInt1 = 0;
    while (paramInt1 < paramObject.Bfd.length)
    {
      paramh[paramInt1] = ((byte)paramObject.Bfd[paramInt1]);
      paramInt1 += 1;
    }
    int[] arrayOfInt = new int[paramObject.Bfm.length];
    paramInt1 = 0;
    while (paramInt1 < paramObject.Bfm.length)
    {
      arrayOfInt[paramInt1] = paramObject.Bfm[paramInt1];
      paramInt1 += 1;
    }
    a(paramObject.Bfa, paramObject.Bfh, paramObject.Bfi);
    this.BAH.Close();
    a.av[] arrayOfav = paramObject.BeZ;
    a.as localas = paramObject.Ben;
    if ((paramObject.Bfc & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfav, localas, paramh, bool, paramObject.groupId, paramObject.twP, paramObject.twQ, paramObject.Bfj, paramObject.Bfk, paramObject.Bfl, arrayOfInt, paramObject.Bep);
      AppMethodBeat.o(127907);
      return;
    }
  }
  
  private void a(int paramInt, a.aa paramaa, com.tencent.wecall.talkroom.a.e parame)
  {
    AppMethodBeat.i(127908);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd", parame.nuW, Integer.valueOf(parame.nTj), Long.valueOf(parame.tFh), " errCode: ", Integer.valueOf(paramInt), " state: ", Integer.valueOf(this.state) });
    Object localObject = com.tencent.pb.common.c.b.J(new Integer[] { Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111) });
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
      h.Tt(((Integer)((Map)localObject).get(Integer.valueOf(paramInt))).intValue());
    }
    if (paramInt == 14255)
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), paramaa.groupId, Integer.valueOf(paramaa.twP), Long.valueOf(paramaa.twQ) });
      this.BAO.l(-14255, paramaa);
      AppMethodBeat.o(127908);
      return;
    }
    if (paramInt == 14256)
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), paramaa.groupId, Integer.valueOf(paramaa.twP), Long.valueOf(paramaa.twQ) });
      this.BAO.l(-14256, paramaa);
      AppMethodBeat.o(127908);
      return;
    }
    if ((paramInt != 0) && (paramInt != 14204))
    {
      if (!b(parame.nuW, parame.nTj, parame.tFh, Tr(parame.BCw)))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(paramInt), " enterScene.mGroupId: ", parame.nuW, " mGroupId: ", this.nuW, Integer.valueOf(parame.nTj), Integer.valueOf(this.nTj), Long.valueOf(parame.tFh), Long.valueOf(this.tFh) });
        AppMethodBeat.o(127908);
        return;
      }
      if (3 != this.state)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(paramInt), parame.nuW, Integer.valueOf(parame.nTj), Long.valueOf(parame.tFh) });
        AppMethodBeat.o(127908);
        return;
      }
      this.BAG.aa(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
      this.BAG.Tx(322);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(paramInt), parame.nuW, Integer.valueOf(parame.nTj), Long.valueOf(parame.tFh) });
      a(parame.nuW, parame.nTj, parame.tFh, true);
      if (paramInt == 14251)
      {
        this.BAO.l(-1000, null);
        AppMethodBeat.o(127908);
        return;
      }
      if (paramInt == 14252)
      {
        this.BAO.l(-1200, null);
        AppMethodBeat.o(127908);
        return;
      }
      if (paramInt == 14253)
      {
        parame = Integer.valueOf(60);
        if (paramaa != null) {
          parame = Integer.valueOf(paramaa.Bff);
        }
        this.BAO.l(-1500, parame);
        AppMethodBeat.o(127908);
        return;
      }
      this.BAO.l(-200, null);
      AppMethodBeat.o(127908);
      return;
    }
    if ((paramInt == 14204) && (this.state == 4))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", paramaa.groupId, Integer.valueOf(paramaa.twP), Long.valueOf(paramaa.twQ) });
      AppMethodBeat.o(127908);
      return;
    }
    if (!b(paramaa.groupId, paramaa.twP, paramaa.twQ, Tr(paramaa.BdS)))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", paramaa.groupId, " mGroupId: ", this.nuW, Integer.valueOf(paramaa.twP), Integer.valueOf(this.nTj), Long.valueOf(paramaa.twQ), Long.valueOf(this.tFh) });
      a(paramaa.groupId, paramaa.twP, paramaa.twQ, 111, false);
      h.Tt(-1110);
      AppMethodBeat.o(127908);
      return;
    }
    if (this.state != 3)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), paramaa.groupId, Integer.valueOf(paramaa.twP), Long.valueOf(paramaa.twQ) });
      AppMethodBeat.o(127908);
      return;
    }
    this.BAG.aa(new String[] { "enter", "resp", String.valueOf(paramInt), String.valueOf(this.state) });
    if ((paramaa.Bfa == null) || (paramaa.Bfa.length == 0))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt), paramaa.groupId, Integer.valueOf(paramaa.twP), Long.valueOf(paramaa.twQ) });
      h.Tt(-1605);
      this.BAG.tKh = 329;
      a(paramaa.groupId, paramaa.twP, paramaa.twQ, 116, true);
      this.BAO.l(-200, null);
      AppMethodBeat.o(127908);
      return;
    }
    this.nuW = paramaa.groupId;
    this.BAS = paramaa.groupId;
    this.nTj = paramaa.twP;
    this.tFh = paramaa.twQ;
    setState(4);
    a(paramaa.Bfa, paramaa.Bfh, paramaa.Bfi);
    a(paramaa.groupId, null, this.Bda, paramaa.twP, paramaa.twQ, paramaa.BeZ, paramaa.Bfb, paramaa.BdI, false, true);
    parame = this.BAO;
    localObject = new g.7(parame, c.dXv().axw(paramaa.groupId));
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      parame = new byte[paramaa.Bfd.length];
      paramInt = 0;
      while (paramInt < paramaa.Bfd.length)
      {
        parame[paramInt] = ((byte)paramaa.Bfd[paramInt]);
        paramInt += 1;
      }
      parame.handler.post((Runnable)localObject);
    }
    localObject = new int[paramaa.Bfm.length];
    paramInt = 0;
    while (paramInt < paramaa.Bfm.length)
    {
      localObject[paramInt] = paramaa.Bfm[paramInt];
      paramInt += 1;
    }
    a.av[] arrayOfav = paramaa.BeZ;
    a.as localas = paramaa.Ben;
    if ((paramaa.Bfc & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(0, arrayOfav, localas, parame, bool, paramaa.groupId, paramaa.twP, paramaa.twQ, paramaa.Bfj, paramaa.Bfk, paramaa.Bfl, (int[])localObject, paramaa.Bep);
      if (paramaa.Bfg != 0)
      {
        com.tencent.pb.common.c.c.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramaa.Bfg });
        BAu = paramaa.Bfg * 1000;
      }
      dXH();
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh) });
      AppMethodBeat.o(127908);
      return;
    }
  }
  
  private void a(int paramInt, a.ah paramah)
  {
    AppMethodBeat.i(127906);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch errCode: ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      this.BAO.fM(null);
      AppMethodBeat.o(127906);
      return;
    }
    paramah = paramah.Bfw;
    if ((paramah == null) || (paramah.length == 0))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch resp.groupInfoList is null" });
      AppMethodBeat.o(127906);
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
        a(localObject.groupId, null, 0, localObject.twP, localObject.twQ, localObject.BeZ, null, null, false, false);
        localArrayList.add(c.dXv().axw(localObject.groupId));
      }
      paramInt += 1;
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(localArrayList.size()) });
    this.BAO.fM(localArrayList);
    AppMethodBeat.o(127906);
  }
  
  /* Error */
  private void a(int paramInt1, a.av[] paramArrayOfav, a.as paramas, byte[] paramArrayOfByte1, boolean paramBoolean, String paramString, int paramInt2, long paramLong, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt5)
  {
    // Byte code:
    //   0: ldc_w 763
    //   3: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 287
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 765
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 407	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: aload 6
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: iload 7
    //   36: invokestatic 407	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_4
    //   42: lload 8
    //   44: invokestatic 589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 161	com/tencent/wecall/talkroom/model/f:state	I
    //   54: invokestatic 407	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 329	com/tencent/pb/common/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 439	com/tencent/wecall/talkroom/model/f:BAH	Lcom/tencent/wecall/talkroom/model/b;
    //   65: ifnull +94 -> 159
    //   68: aload_0
    //   69: aload_2
    //   70: aload_3
    //   71: aload 4
    //   73: iload 5
    //   75: iload 7
    //   77: lload 8
    //   79: iload 10
    //   81: iload 11
    //   83: aload 12
    //   85: aload 13
    //   87: iload 14
    //   89: invokespecial 768	com/tencent/wecall/talkroom/model/f:a	([Lcom/tencent/pb/common/b/a/a$av;Lcom/tencent/pb/common/b/a/a$as;[BZIJII[B[II)Z
    //   92: istore 15
    //   94: ldc_w 287
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 770
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iload 15
    //   111: invokestatic 363	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   114: aastore
    //   115: invokestatic 368	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: iload 15
    //   120: ifeq +39 -> 159
    //   123: ldc_w 763
    //   126: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore 16
    //   132: iconst_0
    //   133: istore 15
    //   135: ldc_w 287
    //   138: iconst_2
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: ldc_w 772
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload 16
    //   152: aastore
    //   153: invokestatic 368	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: goto -38 -> 118
    //   159: iload_1
    //   160: ifgt +61 -> 221
    //   163: aload_0
    //   164: getfield 190	com/tencent/wecall/talkroom/model/f:BAG	Lcom/tencent/wecall/talkroom/model/h;
    //   167: sipush 202
    //   170: invokevirtual 639	com/tencent/wecall/talkroom/model/h:Tx	(I)V
    //   173: ldc_w 287
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: ldc_w 774
    //   185: aastore
    //   186: invokestatic 368	com/tencent/pb/common/c/c:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: aload 6
    //   192: iload 7
    //   194: lload 8
    //   196: bipush 102
    //   198: iconst_1
    //   199: invokevirtual 659	com/tencent/wecall/talkroom/model/f:a	(Ljava/lang/String;IJIZ)Z
    //   202: pop
    //   203: aload_0
    //   204: getfield 208	com/tencent/wecall/talkroom/model/f:BAO	Lcom/tencent/wecall/talkroom/model/g;
    //   207: sipush -400
    //   210: aconst_null
    //   211: invokevirtual 622	com/tencent/wecall/talkroom/model/g:l	(ILjava/lang/Object;)V
    //   214: ldc_w 763
    //   217: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: aload_0
    //   222: getfield 302	com/tencent/wecall/talkroom/model/f:mHandler	Landroid/os/Handler;
    //   225: new 776	com/tencent/wecall/talkroom/model/f$4
    //   228: dup
    //   229: aload_0
    //   230: iload_1
    //   231: aload_2
    //   232: aload_3
    //   233: aload 4
    //   235: iload 5
    //   237: aload 6
    //   239: iload 7
    //   241: lload 8
    //   243: iload 10
    //   245: iload 11
    //   247: aload 12
    //   249: aload 13
    //   251: iload 14
    //   253: invokespecial 779	com/tencent/wecall/talkroom/model/f$4:<init>	(Lcom/tencent/wecall/talkroom/model/f;I[Lcom/tencent/pb/common/b/a/a$av;Lcom/tencent/pb/common/b/a/a$as;[BZLjava/lang/String;IJII[B[II)V
    //   256: ldc2_w 780
    //   259: invokevirtual 785	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   262: pop
    //   263: ldc_w 763
    //   266: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    //   270: astore 16
    //   272: goto -137 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	f
    //   0	275	1	paramInt1	int
    //   0	275	2	paramArrayOfav	a.av[]
    //   0	275	3	paramas	a.as
    //   0	275	4	paramArrayOfByte1	byte[]
    //   0	275	5	paramBoolean	boolean
    //   0	275	6	paramString	String
    //   0	275	7	paramInt2	int
    //   0	275	8	paramLong	long
    //   0	275	10	paramInt3	int
    //   0	275	11	paramInt4	int
    //   0	275	12	paramArrayOfByte2	byte[]
    //   0	275	13	paramArrayOfInt	int[]
    //   0	275	14	paramInt5	int
    //   92	42	15	bool	boolean
    //   130	21	16	localException1	Exception
    //   270	1	16	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	94	130	java/lang/Exception
    //   94	118	270	java/lang/Exception
  }
  
  public static void a(com.tencent.pb.talkroom.sdk.e parame)
  {
    Bdm = parame;
  }
  
  private void a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    this.nTj = paramInt;
    this.tFh = paramLong;
    this.nuW = paramString2;
    this.BAy = paramString1;
    this.BAx = paramString3;
  }
  
  private void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(127914);
    a(paramString, paramInt, paramLong, paramBoolean, true, true);
    AppMethodBeat.o(127914);
  }
  
  private static void a(String paramString, int paramInt, long paramLong, a.av[] paramArrayOfav)
  {
    AppMethodBeat.i(127911);
    if (paramArrayOfav == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "printMembersLog members is null groupId: ", paramString, "  roomid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong) });
      AppMethodBeat.o(127911);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfav.length;
    int i = 0;
    while (i < j)
    {
      a.av localav = paramArrayOfav[i];
      if (localav != null) {
        localStringBuffer.append(" memberId:" + localav.kJx + " uuid: " + localav.Bfy + " status: " + localav.status + "   mem.inviteTime:" + localav.Bgr + "  mem.reason: " + localav.aXG + "  mem.inviteuuid: " + localav.BgD + "\n");
      }
      i += 1;
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "printMembersLog groupId: ", paramString, "  romid: ", Integer.valueOf(paramInt), "  roomKey", Long.valueOf(paramLong), "  members.length: ", Integer.valueOf(paramArrayOfav.length), "  ", localStringBuffer.toString() });
    AppMethodBeat.o(127911);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, a.av[] paramArrayOfav, a.aw[] paramArrayOfaw, a.at paramat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127909);
    a(paramString1, paramInt2, paramLong, paramArrayOfav);
    c localc = c.dXv();
    Integer localInteger;
    boolean bool;
    label49:
    int i;
    long l;
    if (paramInt1 == 0)
    {
      localInteger = null;
      if ((this.nuW == null) || (!this.nuW.equals(paramString1))) {
        break label369;
      }
      bool = true;
      paramBoolean1 = localc.a(paramString1, paramString2, localInteger, paramInt2, paramLong, paramat, paramArrayOfav, paramArrayOfaw, paramBoolean1, bool);
      paramString2 = this.nuW;
      i = this.nTj;
      l = this.tFh;
      bool = b(paramString1, paramInt2, paramLong, false);
      if (paramArrayOfav == null) {
        break label375;
      }
    }
    label369:
    label375:
    for (paramInt1 = paramArrayOfav.length;; paramInt1 = 0)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange", paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Boolean.valueOf(paramBoolean1), " isCurrentRoom: ", Boolean.valueOf(bool), " members.length: ", Integer.valueOf(paramInt1), " isCallBackEngine: ", Boolean.valueOf(paramBoolean2), " mFirstGetAudioData: ", Boolean.valueOf(this.BAD) });
      if (c.dXv().cw(this.nuW, false))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.BAD), " mGroupId: ", this.nuW, " roomId: ", Integer.valueOf(paramInt2) });
        if (this.BAD)
        {
          this.BAD = false;
          this.odg = true;
          this.BAQ = k.dXX();
          this.BAB = this.BAz;
          dXM();
        }
      }
      if (paramArrayOfav != null) {
        break label380;
      }
      AppMethodBeat.o(127909);
      return;
      localInteger = Integer.valueOf(paramInt1);
      break;
      bool = false;
      break label49;
    }
    label380:
    if ((paramBoolean2) && (b(paramString1, paramInt2, paramLong, false)) && (paramArrayOfav.length > 0) && (this.BAH != null)) {
      a(paramArrayOfav);
    }
    AppMethodBeat.o(127909);
  }
  
  private void a(a.av[] paramArrayOfav)
  {
    AppMethodBeat.i(127910);
    if (paramArrayOfav == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "onMebersChangedToEngine members is null" });
      AppMethodBeat.o(127910);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfav.length];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfav.length)
    {
      arrayOfInt[i] = paramArrayOfav[i].kJx;
      localStringBuffer.append(paramArrayOfav[i].kJx);
      localStringBuffer.append(",");
      i += 1;
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", localStringBuffer.toString() });
    if (this.BAH == null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "onMebersChangedToEngine engine is null" });
      AppMethodBeat.o(127910);
      return;
    }
    this.BAH.OnMembersChanged(arrayOfInt);
    AppMethodBeat.o(127910);
  }
  
  private void a(a.o[] paramArrayOfo1, a.o[] paramArrayOfo2, int paramInt)
  {
    AppMethodBeat.i(127912);
    if (paramArrayOfo1 == null) {}
    for (int i = 0;; i = paramArrayOfo1.length)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRelayData addrs length: ", Integer.valueOf(i) });
      if ((paramArrayOfo1 != null) && (paramArrayOfo1.length > 0)) {
        break;
      }
      AppMethodBeat.o(127912);
      return;
    }
    this.BAY = new int[paramArrayOfo1.length];
    this.BAX = new short[paramArrayOfo1.length];
    this.BBa = new int[paramArrayOfo2.length];
    this.BAZ = new short[paramArrayOfo2.length];
    this.BBb = paramInt;
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleRelayData tcpStartTime: ", Integer.valueOf(this.BBb) });
    int j = paramArrayOfo1.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      a.o localo = paramArrayOfo1[paramInt];
      this.BAY[i] = localo.Bej;
      this.BAX[i] = ((short)localo.port);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleRelayData ip: ", Integer.valueOf(localo.Bej), " addr.port: ", Integer.valueOf(localo.port) });
      i += 1;
      paramInt += 1;
    }
    j = paramArrayOfo2.length;
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      paramArrayOfo1 = paramArrayOfo2[paramInt];
      this.BBa[i] = paramArrayOfo1.Bej;
      this.BAZ[i] = ((short)paramArrayOfo1.port);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleRelayData tcpIp: ", Integer.valueOf(paramArrayOfo1.Bej), " tcpAddr.port: ", Integer.valueOf(paramArrayOfo1.port) });
      i += 1;
      paramInt += 1;
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleRelayData", Arrays.toString(this.BAY), Arrays.toString(this.BAX), this.nuW, this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), Arrays.toString(this.BBa), Arrays.toString(this.BAZ), Integer.valueOf(this.BBb) });
    AppMethodBeat.o(127912);
  }
  
  private boolean a(a.av[] paramArrayOfav, a.as paramas, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4)
  {
    AppMethodBeat.i(127924);
    if (this.state != 4)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "dealWithInit state is error: ", Integer.valueOf(this.state) });
      AppMethodBeat.o(127924);
      return false;
    }
    paramBoolean = b(paramArrayOfav, paramas, paramArrayOfByte1, paramBoolean, paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4);
    AppMethodBeat.o(127924);
    return paramBoolean;
  }
  
  private void aCJ()
  {
    AppMethodBeat.i(127927);
    Et();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new f.5(this));
    if (i <= 0)
    {
      this.BAG.Tx(101);
      h.Tu(-2001);
      this.BAO.l(-500, null);
    }
    h localh;
    if (i > 0) {
      localh = this.BAG;
    }
    for (localh.BBV &= 0xFFFFFFFE;; localh.BBV |= 0x1)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "audioAdapter startRecord ret: ", Integer.valueOf(i) });
      AppMethodBeat.o(127927);
      return;
      localh = this.BAG;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(127898);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Bdm;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramb);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "startPlayer: ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramb });
        int i = j;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(127898);
    return i;
  }
  
  private static int b(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.c paramc)
  {
    AppMethodBeat.i(127900);
    j = -100;
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Bdm;
      i = j;
      if (locale != null) {
        i = locale.a(paramInt1, paramInt2, paramc);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "startRecord: ", paramc });
        int i = j;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(paramInt2), " ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(127900);
    return i;
  }
  
  private void b(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(127891);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendEnterGroupScence groupId: ", paramString1, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " enterType: ", Integer.valueOf(paramInt3), " isSenceCircle: ", Boolean.TRUE, " wXgroupId: ", paramString2 });
    if ((paramInt1 == 0) || (paramLong == 0L))
    {
      com.tencent.pb.common.c.c.e("TalkRoomService", new Object[] { "roomId or roomkey is 0..return." });
      AppMethodBeat.o(127891);
      return;
    }
    if (!Tr(paramInt3)) {
      this.BAG.dXT();
    }
    this.BAG.dXS();
    paramString1 = new com.tencent.wecall.talkroom.a.e(paramString1, paramInt1, paramLong, this.BAH.dXs(), paramInt2, paramInt3, paramString2);
    com.tencent.pb.common.b.e.dTE().a(paramString1);
    c(paramString1);
    AppMethodBeat.o(127891);
  }
  
  private boolean b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(127931);
    if (paramBoolean)
    {
      paramBoolean = com.tencent.pb.common.c.g.iN(paramString, this.nuW);
      AppMethodBeat.o(127931);
      return paramBoolean;
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "isCurrentRoom groupId: ", paramString, " mGroupId: ", this.nuW, "roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.nTj), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.tFh) });
    if ((com.tencent.pb.common.c.g.iN(paramString, this.nuW)) && (paramInt == this.nTj) && (paramLong == this.tFh))
    {
      AppMethodBeat.o(127931);
      return true;
    }
    AppMethodBeat.o(127931);
    return false;
  }
  
  private boolean b(a.av[] paramArrayOfav, a.as paramas, byte[] paramArrayOfByte1, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt4)
  {
    AppMethodBeat.i(127930);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "connectToCompenent myRoomMemId roomid:", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " groupId: ", this.nuW, " ip: ", Arrays.toString(this.BAY), " ports: ", Arrays.toString(this.BAX), " tcpIp: ", Arrays.toString(this.BBa), " tcpPorts: ", Arrays.toString(this.BAZ), " tcpStartTime: ", Integer.valueOf(this.BBb), " audio_encrypt_type: ", Integer.valueOf(paramInt2), " video_encrypt_type: ", Integer.valueOf(paramInt4) });
    Object localObject2 = com.tencent.pb.a.a.a.dTX();
    int i = -1;
    Object localObject1;
    if ((paramArrayOfav != null) && (paramArrayOfav.length > 0))
    {
      localObject1 = new int[paramArrayOfav.length];
      j = 0;
      while (j < paramArrayOfav.length)
      {
        localObject1[j] = paramArrayOfav[j].kJx;
        if (com.tencent.pb.common.c.g.equals(paramArrayOfav[j].Bfy, (String)localObject2)) {
          i = paramArrayOfav[j].kJx;
        }
        j += 1;
      }
      paramArrayOfav = (a.av[])localObject1;
    }
    for (int j = i;; j = -1)
    {
      int k = c.dXv().axr(this.nuW);
      this.BAG.kJx = j;
      for (;;)
      {
        try
        {
          localObject2 = this.BAH;
          locala = this.BAI;
          localObject3 = c.dXv();
          localObject1 = this.nuW;
          localObject3 = ((c)localObject3).axp((String)localObject1);
          if (localObject3 != null) {
            continue;
          }
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMyUuid TalkRoom is null  groupId: ", localObject1 });
          i = 0;
          localObject3 = this.BAY;
          arrayOfShort1 = this.BAX;
          arrayOfInt = this.BBa;
          arrayOfShort2 = this.BAZ;
          m = this.BBb;
          com.tencent.pb.common.c.c.i("simon:TalkRoomContext", new Object[] { "Open" });
          localObject1 = null;
          if (paramas == null) {
            continue;
          }
          paramas = new i(paramas.BfJ, paramas.fAb, paramas.fAc, paramas.BfK, paramas.BfL, paramas.BfM, paramas.BfN, paramas.BfO, paramas.BfP, paramas.BfQ, paramas.BfR, paramas.BfS);
          n = k.jN(com.tencent.pb.common.c.d.tFk);
          localObject1 = ((b)localObject2).BzZ;
          if (localObject1 != null) {
            continue;
          }
          paramInt1 = -1;
        }
        catch (Throwable paramArrayOfav)
        {
          talk.a locala;
          Object localObject3;
          short[] arrayOfShort1;
          int[] arrayOfInt;
          short[] arrayOfShort2;
          int m;
          int n;
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "connectToCompenent", paramArrayOfav });
          paramInt1 = -99999;
          continue;
          paramInt1 = ((b)localObject2).BzZ.Open(locala, paramas, i, j, paramInt1, paramLong, (int[])localObject3, arrayOfShort1, 0, paramArrayOfav, paramArrayOfByte1, paramBoolean, n, arrayOfInt, arrayOfShort2, m, paramInt2, paramInt3, paramArrayOfByte2, paramArrayOfInt, paramInt4);
          continue;
          paramArrayOfav.handler.post(paramas);
          continue;
          AppMethodBeat.o(127930);
          return false;
        }
        paramArrayOfav = this.BAO;
        paramas = new g.2(paramArrayOfav, paramInt1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          continue;
        }
        paramas.run();
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "connectToCompenent ret =", Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt1 < 0) {
          h.Tw(-3002);
        }
        if (paramInt1 == 0) {
          this.BAG.tKk = 1;
        }
        if (paramInt1 != 0) {
          continue;
        }
        AppMethodBeat.o(127930);
        return true;
        localObject3 = ((TalkRoom)localObject3).axo(com.tencent.pb.a.a.a.dTX());
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMyUuid talkRoomMember is null  groupId: ", localObject1 });
          i = 0;
        }
        else
        {
          localObject3 = ((d)localObject3).BAf;
          if (localObject3 == null)
          {
            com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getMyUuid voiceGroupMem is null  groupId: ", localObject1 });
            i = 0;
          }
          else
          {
            com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getMyUuid groupId: ", localObject1, " uuid: ", Integer.valueOf(((a.av)localObject3).wjE) });
            i = ((a.av)localObject3).wjE;
            continue;
            com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "voiceConf is null" });
            paramas = (a.as)localObject1;
          }
        }
      }
      paramArrayOfav = null;
    }
  }
  
  private boolean bV(int paramInt, String paramString)
  {
    AppMethodBeat.i(127892);
    if (paramInt == 100)
    {
      AppMethodBeat.o(127892);
      return true;
    }
    if (Tr(paramInt))
    {
      if (this.state == 0)
      {
        AppMethodBeat.o(127892);
        return true;
      }
      AppMethodBeat.o(127892);
      return false;
    }
    if (paramInt == 1)
    {
      boolean bool = axy(paramString);
      AppMethodBeat.o(127892);
      return bool;
    }
    AppMethodBeat.o(127892);
    return false;
  }
  
  private void c(com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(127935);
    this.mHandler.removeCallbacks(this.BBg);
    this.BBf = paramd;
    this.mHandler.postDelayed(this.BBg, 3000L);
    AppMethodBeat.o(127935);
  }
  
  private void cHI()
  {
    AppMethodBeat.i(127901);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "releaseConpent" });
    try
    {
      Et();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          dXG();
          AppMethodBeat.o(127901);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "releaseConpent ", localThrowable2 });
          AppMethodBeat.o(127901);
        }
        localThrowable1 = localThrowable1;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "releaseConpent ", localThrowable1 });
      }
    }
  }
  
  private int dXF()
  {
    AppMethodBeat.i(127894);
    if (this.BAC == 0L)
    {
      AppMethodBeat.o(127894);
      return 0;
    }
    int i = (int)((System.currentTimeMillis() - this.BAC) / 1000L);
    AppMethodBeat.o(127894);
    return i;
  }
  
  private boolean dXG()
  {
    AppMethodBeat.i(127897);
    try
    {
      com.tencent.pb.talkroom.sdk.e locale = Bdm;
      if (locale == null) {
        break label99;
      }
      this.BAG.tAC = locale.bSN();
      this.BAG.tAs = locale.bSQ();
      bool = locale.bSL();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "stopPlayer: ", localException });
        boolean bool = false;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "stopPlayer ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127897);
    return bool;
  }
  
  private void dXH()
  {
    AppMethodBeat.i(127919);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "hello timer start~~" });
    if (this.BAJ != null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "dealWithInit enter talkroom not first time" });
      AppMethodBeat.o(127919);
      return;
    }
    try
    {
      this.BAJ = new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(127871);
          if ((f.g(f.this) == 0) || (f.b(f.this) == null))
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.g(f.this)), f.b(f.this) });
            f.k(f.this);
            AppMethodBeat.o(127871);
            return;
          }
          f.a(f.this, f.j(f.this));
          AppMethodBeat.o(127871);
        }
      };
      this.BAL.schedule(this.BAJ, 0L, BAu);
      AppMethodBeat.o(127919);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "startNooper: ", localException });
      AppMethodBeat.o(127919);
    }
  }
  
  private void dXI()
  {
    AppMethodBeat.i(127920);
    try
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask" });
      if (this.BAK != null) {
        this.BAK.cancel();
      }
      this.BAK = null;
      AppMethodBeat.o(127920);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelHelloTimeOutTask: ", localException });
      }
    }
  }
  
  private void dXJ()
  {
    AppMethodBeat.i(127921);
    try
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelHelloTimerTask" });
      if (this.BAJ != null) {
        this.BAJ.cancel();
      }
      this.BAJ = null;
      AppMethodBeat.o(127921);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelHelloTimerTask: ", localException });
      }
    }
  }
  
  private void dXK()
  {
    AppMethodBeat.i(127922);
    try
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask" });
      if (this.BAM != null) {
        this.BAM.cancel();
      }
      this.BAM = null;
      AppMethodBeat.o(127922);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelTalkDurationTimerTask: ", localException });
      }
    }
  }
  
  private void dXL()
  {
    AppMethodBeat.i(127928);
    dXG();
    Object localObject = new AtomicInteger();
    AtomicInteger localAtomicInteger = new AtomicInteger();
    int i = b(talk.VOICE_SAMPLERATE, talk.VOICE_FRAME_DURATION, new f.6(this, (AtomicInteger)localObject, localAtomicInteger));
    if (i <= 0)
    {
      this.BAG.Tx(101);
      h.Tu(-2001);
      localObject = this.BAG;
      ((h)localObject).BBV |= 0x1;
      this.BAO.l(-500, null);
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "audioAdapter startPlayer ret: ", Integer.valueOf(i) });
    AppMethodBeat.o(127928);
  }
  
  private void dXM()
  {
    AppMethodBeat.i(127929);
    if (this.BAM != null)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkDurationTimerTask is null" });
      AppMethodBeat.o(127929);
      return;
    }
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.BAm, " mIsHoldOn: ", Boolean.valueOf(this.BBc) });
    this.BAM = new f.7(this);
    this.BAN.scheduleAtFixedRate(this.BAM, 1000L, 1000L);
    AppMethodBeat.o(127929);
  }
  
  private void dXN()
  {
    AppMethodBeat.i(127934);
    this.mHandler.removeCallbacks(this.BBg);
    this.BBf = null;
    AppMethodBeat.o(127934);
  }
  
  public static com.tencent.pb.talkroom.sdk.e dXO()
  {
    return Bdm;
  }
  
  static String[] fN(List<String> paramList)
  {
    AppMethodBeat.i(127889);
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
      AppMethodBeat.o(127889);
      return arrayOfString;
    }
    AppMethodBeat.o(127889);
    return new String[0];
  }
  
  private boolean fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(127895);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom clientGroupId: ", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(127895);
      return false;
    }
    com.tencent.wecall.talkroom.a.c localc = new com.tencent.wecall.talkroom.a.c(paramString, paramInt, this.Bda);
    boolean bool = com.tencent.pb.common.b.e.dTE().a(localc);
    this.BAG.aa(new String[] { "cancel", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, this.nTj, this.tFh, true);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127895);
    return bool;
  }
  
  private void n(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(127932);
    try
    {
      String str = c.dXv().m(paramString, paramInt, paramLong);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "addCallLog groupId: ", paramString, " mIsOutCall: ", Boolean.valueOf(this.txk), " mTalkDuration: ", Integer.valueOf(this.BAz), " msgKey: ", str });
      AppMethodBeat.o(127932);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleRoomExit: ", paramString });
      AppMethodBeat.o(127932);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.f G(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127905);
    com.tencent.pb.talkroom.sdk.f localf = new com.tencent.pb.talkroom.sdk.f();
    Object localObject1 = localf;
    if (this.odg)
    {
      localObject1 = localf;
      if (this.BAH == null) {}
    }
    try
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "receiveVideo" });
      localObject2 = this.BAH;
      localObject1 = new com.tencent.pb.talkroom.sdk.f();
      if ((paramArrayOfInt != null) && (((b)localObject2).BzZ != null)) {
        break label176;
      }
      com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "steve:receiveVideo null, imgBuffer:", paramArrayOfInt, ", engine:", ((b)localObject2).BzZ });
      paramArrayOfInt = (int[])localObject1;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "receiveVideo error: ", paramArrayOfInt });
        paramArrayOfInt = localf;
        continue;
        Object localObject3 = ((TalkRoom)localObject3).dXq().iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localav = (a.av)((Iterator)localObject3).next();
        } while ((localav == null) || (localav.kJx != i));
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[] { "getUsrNameByMemberId wxUserName:", localav.Bfy, " groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
        if (localav.Bfy == null) {
          break;
        }
        localObject2 = localav.Bfy;
        continue;
        int i = paramArrayOfInt.length;
      }
    }
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "receiveVideo finished, ", Boolean.valueOf(this.odg), " decInfo: ", paramArrayOfInt, " engine: ", this.BAH });
    localObject1 = paramArrayOfInt;
    AppMethodBeat.o(127905);
    return localObject1;
    label176:
    ((com.tencent.pb.talkroom.sdk.f)localObject1).ret = ((b)localObject2).BzZ.videoDecode(paramArrayOfInt);
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhs = paramArrayOfInt;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Bht = ((b)localObject2).BzZ.field_remoteImgLength;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhu = ((b)localObject2).BzZ.field_remoteImgWidth;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhv = ((b)localObject2).BzZ.field_remoteImgHeight;
    ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhw = (((b)localObject2).BzZ.field_remoteImgChannel & 0x3FFF);
    localObject3 = c.dXv();
    Object localObject2 = a.dXg().nuW;
    i = ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhw;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i) });
    }
    for (;;)
    {
      ((com.tencent.pb.talkroom.sdk.f)localObject1).Bhq = ((String)localObject2);
      if (paramArrayOfInt == null)
      {
        i = 0;
        com.tencent.pb.common.c.c.d("simon:TalkRoomContext", new Object[] { "steve:receiveVideo imgBuffer size:", Integer.valueOf(i), " MultiTalkVideoDecodeInfo: ", localObject1 });
        paramArrayOfInt = (int[])localObject1;
        break;
        localObject3 = ((c)localObject3).axp((String)localObject2);
        if (localObject3 == null)
        {
          com.tencent.pb.common.c.c.w("TalkRoomManager", new Object[] { "getUsrNameByMemberId talkRoom is null groupId: ", localObject2, " memberId: ", Integer.valueOf(i) });
          break label556;
        }
      }
      a.av localav;
      label556:
      localObject2 = "";
    }
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127903);
    int j = -1;
    int i = j;
    if (this.odg)
    {
      i = j;
      if (this.BAH == null) {}
    }
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "sendVideo ", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localb = this.BAH;
        if ((paramArrayOfByte != null) && (localb.BzZ != null)) {
          continue;
        }
        com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "steve:sendVideo null, buffer:", paramArrayOfByte, ", engine:", localb.BzZ });
        paramInt1 = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        b localb;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendVideo error: ", paramArrayOfByte });
        paramInt1 = -1;
        continue;
      }
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "sendVideo finished, ", Boolean.valueOf(this.odg), " ret: ", Integer.valueOf(paramInt1), " engine: ", this.BAH });
      i = paramInt1;
      AppMethodBeat.o(127903);
      return i;
      paramInt1 = localb.BzZ.SendVideo(paramArrayOfByte, paramShort, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final com.tencent.pb.talkroom.sdk.g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127904);
    com.tencent.pb.talkroom.sdk.g localg = new com.tencent.pb.talkroom.sdk.g();
    if ((this.odg) && (this.BAH != null)) {}
    for (;;)
    {
      try
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "videoTrans ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        b localb = this.BAH;
        if ((paramArrayOfByte == null) || (localb.BzZ == null))
        {
          com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "steve:videoTrans null, recordData:", paramArrayOfByte, ", engine:", localb.BzZ });
          paramArrayOfByte = null;
          com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "videoTrans finished, ", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.odg), " multiTalkVideoRGBinfo: ", paramArrayOfByte, " engine: ", this.BAH });
          AppMethodBeat.o(127904);
          return paramArrayOfByte;
        }
        paramInt1 = localb.BzZ.videoTrans(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
        paramArrayOfByte = new com.tencent.pb.talkroom.sdk.g();
        paramArrayOfByte.Bhx = paramArrayOfInt;
        paramArrayOfByte.Bhy = localb.BzZ.field_localImgWidth;
        paramArrayOfByte.Bhz = localb.BzZ.field_localImgHeight;
        paramArrayOfByte.ret = paramInt1;
        continue;
        paramArrayOfByte = localg;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "videoTrans error: ", paramArrayOfByte });
      }
    }
  }
  
  public final f.b a(String paramString1, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(127890);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "enterTalkRoom", paramString1, paramString2, Integer.valueOf(this.nTj), Integer.valueOf(paramInt1), Long.valueOf(this.tFh), Long.valueOf(paramLong), Integer.valueOf(paramInt3), "needConfirm", Boolean.FALSE });
    if (!com.tencent.pb.a.a.a.dTY())
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.dTY()), " isBindMobile: ", Boolean.valueOf(com.tencent.pb.a.a.a.dTZ()) });
      h.a(paramString1, "", this.nTj, this.tFh, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "noAuth" });
      paramString1 = f.b.BBC;
      AppMethodBeat.o(127890);
      return paramString1;
    }
    com.tencent.pb.common.b.h.isNetworkConnected();
    if ((Tr(paramInt3)) && (paramInt3 != 100) && (cMa()))
    {
      h.a(paramString1, "", this.nTj, this.tFh, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isBusy" });
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "enterTalkRoom isBusy" });
      paramString1 = f.b.BBG;
      AppMethodBeat.o(127890);
      return paramString1;
    }
    if (!bV(paramInt3, paramString1))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(paramInt3), " state: ", Integer.valueOf(this.state) });
      h.a(paramString1, "", this.nTj, this.tFh, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "isNotValidEnterState" });
      paramString1 = f.b.BBH;
      AppMethodBeat.o(127890);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom groupId is null" });
      h.a(paramString1, "", this.nTj, this.tFh, new String[] { "enter", "req", "false", String.valueOf(paramInt3), "groupIdnull" });
      paramString1 = f.b.BBI;
      AppMethodBeat.o(127890);
      return paramString1;
    }
    if (Tr(paramInt3))
    {
      this.BAG.reset();
      sb(false);
    }
    dXD();
    if (!cHL())
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom enterTalkRoom initEngine fail" });
      if (Tr(paramInt3))
      {
        h.a(paramString1, "", this.nTj, this.tFh, new String[] { "enter", "req", "false", "initEnginefail" });
        sb(false);
      }
      for (;;)
      {
        paramString1 = f.b.BBK;
        AppMethodBeat.o(127890);
        return paramString1;
        this.BAG.aa(new String[] { "enter", "req", "false", "initEnginefail" });
      }
    }
    this.nuW = paramString1;
    Object localObject;
    int i;
    long l;
    label699:
    label705:
    boolean bool;
    if (!Tr(paramInt3))
    {
      localObject = axx(paramString1);
      if (localObject == null)
      {
        i = 0;
        this.nTj = i;
        if (localObject != null) {
          break label869;
        }
        l = 0L;
        this.tFh = l;
        this.BAS = paramString1;
        this.Bda = paramInt2;
        setState(3);
        if (!Tr(paramInt3)) {
          break label892;
        }
        bool = true;
        label732:
        this.txk = bool;
        if (this.txk) {
          this.BAG.dXQ();
        }
        if ((!this.txk) || (c.dXv().cw(this.nuW, true))) {
          break label898;
        }
        localObject = new f.c(this);
        ((f.c)localObject).groupId = paramString1;
        ((f.c)localObject).nMZ = paramInt1;
        ((f.c)localObject).nNa = paramLong;
        ((f.c)localObject).BdS = paramInt3;
        ((f.c)localObject).BdL = paramInt2;
        ((f.c)localObject).BBM = paramString2;
        paramString1 = Message.obtain();
        paramString1.what = 3;
        paramString1.obj = localObject;
        this.mHandler.sendMessageDelayed(paramString1, 0L);
      }
    }
    for (;;)
    {
      paramString1 = f.b.BBB;
      AppMethodBeat.o(127890);
      return paramString1;
      i = ((f.e)localObject).nMZ;
      break;
      label869:
      l = ((f.e)localObject).nNa;
      break label699;
      this.nTj = paramInt1;
      this.tFh = paramLong;
      break label705;
      label892:
      bool = false;
      break label732;
      label898:
      b(paramString1, this.nTj, this.tFh, paramInt2, paramInt3, paramString2);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.pb.common.b.d paramd)
  {
    AppMethodBeat.i(127902);
    if (paramd != null) {
      paramString = Integer.valueOf(paramd.getType());
    }
    int i;
    for (;;)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT onNetSceneEnd errCode:", Integer.valueOf(paramInt2), " errType: ", Integer.valueOf(paramInt1), " scene.getType(): ", paramString });
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        paramString = com.tencent.pb.common.c.b.J(new Integer[] { Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(204), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(206), Integer.valueOf(-1522), Integer.valueOf(208), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542) });
        i = paramd.getType();
        if (paramString.containsKey(Integer.valueOf(i))) {
          h.Tt(((Integer)paramString.get(Integer.valueOf(i))).intValue());
        }
      }
      if (paramInt2 != -1) {
        break label1115;
      }
      try
      {
        if (paramd.getType() == 201)
        {
          paramString = (com.tencent.wecall.talkroom.a.d)paramd;
          if (com.tencent.pb.common.c.g.iN(this.BAy, paramString.BAy))
          {
            this.BAG.Tx(301);
            this.BAG.aa(new String[] { "create", "resp", "-1", String.valueOf(this.state) });
            fi(paramString.BAy, 1001);
            if (!paramString.BCv) {
              this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.BAO.l(-100, null);
          }
          AppMethodBeat.o(127902);
          return;
          paramString = "";
        }
        else if (paramd.getType() == 209)
        {
          paramString = (com.tencent.wecall.talkroom.a.g)paramd;
          this.BAO.fh(paramString.nuW, paramInt2);
          AppMethodBeat.o(127902);
          return;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "cancelCreateTalkRoom: ", paramString });
        AppMethodBeat.o(127902);
        return;
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if (!b(paramString.nuW, paramString.nTj, paramString.tFh, false)) {
        h.a(paramString.nuW, paramString.nTj, paramString.tFh, new String[] { "ack", "resp", "-1", String.valueOf(this.state) });
      }
      this.BAO.a(paramString.BCu, c.dXv().axw(paramString.nuW));
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if (b(paramString.nuW, paramString.nTj, paramString.tFh, false))
      {
        this.BAG.aa(new String[] { "add", "resp", "-1", String.valueOf(this.state) });
        this.BAO.l(-300, null);
      }
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((b(paramString.nuW, paramString.nTj, paramString.tFh, Tr(paramString.BCw))) && (this.state == 3))
      {
        this.BAG.Tx(302);
        this.BAO.l(-200, null);
      }
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 212)
    {
      this.BAO.fM(null);
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 213)
    {
      if (com.tencent.pb.common.c.g.equals(((com.tencent.wecall.talkroom.a.j)paramd).nuW, this.nuW))
      {
        this.BAG.aa(new String[] { "sendmsg", "resp", "-1", String.valueOf(this.state) });
        this.BAO.l(-700, null);
      }
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (b(paramString.groupId, paramString.nMZ, paramString.nNa, false)) {
        this.BAG.aa(new String[] { "redirect", "resp", "-1", String.valueOf(this.state) });
      }
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 214)
    {
      paramString = (l)paramd;
      if (b(paramString.nuW, paramString.nTj, paramString.tFh, false)) {
        this.BAO.l(-800, null);
      }
      AppMethodBeat.o(127902);
      return;
    }
    if (paramd.getType() == 800)
    {
      paramString = (com.tencent.wecall.talkroom.a.k)paramd;
      if (b(paramString.nuW, paramString.nTj, paramString.tFh, false)) {
        this.BAO.l(-1600, null);
      }
    }
    AppMethodBeat.o(127902);
    return;
    label1115:
    Object localObject1;
    Object localObject2;
    if (paramd.getType() == 201)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.d)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).BcY != null))
      {
        paramString = (a.z)((com.tencent.pb.common.b.d)localObject1).BcY;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.wecall.talkroom.a.d)localObject1).mType), ((com.tencent.wecall.talkroom.a.d)localObject1).BAy });
        if (((com.tencent.wecall.talkroom.a.d)localObject1).BCv) {
          break label2979;
        }
        i = 1;
        localObject2 = com.tencent.pb.common.c.b.J(new Integer[] { Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.Tt(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 14002)
        {
          BAn = null;
          if (paramInt2 == 0) {
            break label3246;
          }
          if (com.tencent.pb.common.c.g.iN(this.BAy, ((com.tencent.wecall.talkroom.a.d)localObject1).BAy)) {
            break label2985;
          }
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.BAy, " createScene.mClientGroupId: ", ((com.tencent.wecall.talkroom.a.d)localObject1).BAy, " errCode: ", Integer.valueOf(paramInt2) });
          if (i != 0) {
            this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
          }
        }
      }
    }
    label1404:
    if (paramd.getType() == 202)
    {
      paramString = (com.tencent.wecall.talkroom.a.e)paramd;
      if ((paramString != null) && (paramString.BcY != null)) {
        a(paramInt2, (a.aa)paramString.BcY, paramString);
      }
    }
    if (paramd.getType() == 204)
    {
      paramString = (com.tencent.wecall.talkroom.a.b)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        localObject1 = (a.x)paramString.BcY;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd", this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), " errCode: ", Integer.valueOf(paramInt2) });
        localObject2 = com.tencent.pb.common.c.b.J(new Integer[] { Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303) });
        if (((Map)localObject2).containsKey(Integer.valueOf(paramInt2))) {
          h.Tt(((Integer)((Map)localObject2).get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 == 0) {
          break label4176;
        }
        if (b(paramString.nuW, paramString.nTj, paramString.tFh, false))
        {
          this.BAG.aa(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          this.BAO.l(-300, null);
        }
      }
    }
    if (paramd.getType() == 203)
    {
      paramString = (com.tencent.wecall.talkroom.a.f)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd", ((a.ab)paramString.BcY).groupId, this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), " errCode: ", Integer.valueOf(paramInt2) });
        paramString = com.tencent.pb.common.c.b.J(new Integer[] { Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204) });
        if (paramString.containsKey(Integer.valueOf(paramInt2))) {
          h.Tt(((Integer)paramString.get(Integer.valueOf(paramInt2))).intValue());
        }
        if (paramInt2 != 0) {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(paramInt2) });
        }
      }
    }
    if (paramd.getType() == 205)
    {
      paramString = (m)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleHelloEnd", ((a.ak)paramString.BcY).groupId, this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        dXI();
        i = 0;
        if (paramInt2 != 14800) {
          break label4393;
        }
        i = -1401;
        label2072:
        if (i != 0)
        {
          this.BAG.Tx(324);
          h.Tt(i);
        }
      }
    }
    if (paramd.getType() == 206)
    {
      paramString = (com.tencent.wecall.talkroom.a.a)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd errCode is ", Integer.valueOf(paramInt2), " groupId: ", paramString.nuW, " roomid: ", Integer.valueOf(paramString.nTj), " roomKey: ", Long.valueOf(paramString.tFh) });
        if (paramInt2 != 18950) {
          break label4408;
        }
        if (!b(paramString.nuW, paramString.nTj, paramString.tFh, false)) {
          h.a(paramString.nuW, paramString.nTj, paramString.tFh, new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        }
        localObject1 = c.dXv().axw(paramString.nuW);
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", paramString.nuW, " multiTalkGroup: ", localObject1 });
        if (localObject1 != null) {
          this.BAO.a(paramString.BCu, (MultiTalkGroup)localObject1);
        }
      }
    }
    label2330:
    if (paramd.getType() == 207)
    {
      paramString = (com.tencent.wecall.talkroom.a.i)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        if (paramInt2 == 18100) {
          h.Tt(-1501);
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleRejectEnd  errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 208)
    {
      paramString = (com.tencent.wecall.talkroom.a.c)paramd;
      if ((paramString != null) && (paramString.BcY != null))
      {
        if (paramInt2 == 18300) {
          h.Tt(-1531);
        }
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCancelCreateEnd errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 209)
    {
      localObject1 = (com.tencent.wecall.talkroom.a.g)paramd;
      if ((localObject1 != null) && (((com.tencent.pb.common.b.d)localObject1).BcY != null))
      {
        paramString = (a.ac)((com.tencent.pb.common.b.d)localObject1).BcY;
        if (paramInt2 == 17900) {
          h.Tt(-1511);
        }
        if (paramInt2 == 0) {
          break label4814;
        }
        this.BAO.fh(((com.tencent.wecall.talkroom.a.g)localObject1).nuW, paramInt2);
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(paramInt2) });
      }
    }
    if (paramd.getType() == 210)
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "talkHoldonResp", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == 19100) {
        h.Tt(-1541);
      }
    }
    if (paramd.getType() == 211)
    {
      paramString = (com.tencent.wecall.talkroom.a.h)paramd;
      if (paramString != null) {
        a(paramInt1, paramInt2, paramd.BcY, paramString);
      }
    }
    if (paramd.getType() == 212) {
      a(paramInt2, (a.ah)paramd.BcY);
    }
    if (paramd.getType() == 213)
    {
      paramString = (com.tencent.wecall.talkroom.a.j)paramd;
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleSendMsg errCode: ", Integer.valueOf(paramInt2) });
      if (paramInt2 == 0) {
        break label4913;
      }
      if (com.tencent.pb.common.c.g.equals(paramString.nuW, this.nuW))
      {
        this.BAG.aa(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
        this.BAO.l(-700, null);
      }
    }
    label2771:
    if (paramd.getType() == 214)
    {
      paramString = (a.af)paramd.BcY;
      localObject1 = (l)paramd;
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup errCode: ", Integer.valueOf(paramInt2) });
      if (b(((l)localObject1).nuW, ((l)localObject1).nTj, ((l)localObject1).tFh, false)) {
        break label5014;
      }
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleSwitchVideoGroup isCurrentRoom is not same", ((l)localObject1).nuW, Integer.valueOf(((l)localObject1).nTj) });
    }
    for (;;)
    {
      if (paramd.getType() == 800)
      {
        paramString = (com.tencent.wecall.talkroom.a.k)paramd;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo errCode: ", Integer.valueOf(paramInt2) });
        if (!b(paramString.nuW, paramString.nTj, paramString.tFh, false))
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleSubscribeLargeVideo isCurrentRoom is not same", paramString.nuW, Integer.valueOf(paramString.nTj) });
          AppMethodBeat.o(127902);
          return;
          label2979:
          i = 0;
          break;
          label2985:
          if (paramInt2 != -1)
          {
            this.BAG.Tx(321);
            this.BAG.aa(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          if (this.state != 1)
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(paramInt2), ((com.tencent.wecall.talkroom.a.d)localObject1).BAy });
            if (i == 0) {
              break label1404;
            }
            this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1404;
          }
          a(this.nuW, this.nTj, this.tFh, true);
          if (paramInt2 == 14051) {
            this.BAO.l(-900, null);
          }
          for (;;)
          {
            if (i == 0) {
              break label3244;
            }
            this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break;
            if (paramInt2 == 14052) {
              this.BAO.l(-1100, null);
            } else if (paramInt2 == 14053) {
              this.BAO.l(-1300, paramString);
            } else if (paramInt2 == 14504) {
              this.BAO.l(-1400, null);
            } else {
              this.BAO.l(-100, null);
            }
          }
          label3244:
          break label1404;
          label3246:
          if (!com.tencent.pb.common.c.g.iN(this.BAy, paramString.BdG))
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.BAy, " resp.clientGroupId: ", paramString.BdG, Integer.valueOf(paramString.twP), Long.valueOf(paramString.twQ) });
            a(paramString.groupId, paramString.twP, paramString.twQ, 110, false);
            if (i == 0) {
              break label1404;
            }
            this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1404;
          }
          this.BAG.aa(new String[] { "create", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          if (this.state != 1)
          {
            h.Tt(-1003);
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), paramString.BdG, Integer.valueOf(paramString.twP), Long.valueOf(paramString.twQ) });
            if (i == 0) {
              break label1404;
            }
            this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            break label1404;
          }
          if ((paramString.Bfa == null) || (paramString.Bfa.length == 0))
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(paramInt2), paramString.BdG, Integer.valueOf(paramString.twP), Long.valueOf(paramString.twQ) });
            h.Tt(-1605);
            this.BAG.tKh = 329;
            a(paramString.groupId, paramString.twP, paramString.twQ, 116, true);
            if (i != 0) {
              this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
            }
            this.BAO.l(-100, null);
            break label1404;
          }
          a(paramString.BdG, paramString.twP, paramString.twQ, paramString.groupId, paramString.BdI.Bgc);
          this.BAS = paramString.groupId;
          this.Bda = paramString.BdL;
          setState(4);
          a(paramString.Bfa, paramString.Bfh, paramString.Bfi);
          a(paramString.groupId, paramString.BdG, paramString.BdL, paramString.twP, paramString.twQ, paramString.Bem, paramString.Bfb, paramString.BdI, false, true);
          if (this.BAO != null)
          {
            localObject1 = this.BAO;
            localObject2 = new g.6((g)localObject1, c.dXv().axw(paramString.groupId));
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label3811;
            }
            ((Runnable)localObject2).run();
          }
          for (;;)
          {
            localObject1 = new byte[paramString.Bfd.length];
            j = 0;
            while (j < paramString.Bfd.length)
            {
              localObject1[j] = ((byte)paramString.Bfd[j]);
              j += 1;
            }
            label3811:
            ((g)localObject1).handler.post((Runnable)localObject2);
          }
          localObject2 = new int[paramString.Bfm.length];
          int j = 0;
          while (j < paramString.Bfm.length)
          {
            localObject2[j] = paramString.Bfm[j];
            j += 1;
          }
          a.av[] arrayOfav = paramString.Bem;
          a.as localas = paramString.Ben;
          if ((paramString.Bfc & 0x2) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(0, arrayOfav, localas, (byte[])localObject1, bool, paramString.groupId, paramString.twP, paramString.twQ, paramString.Bfj, paramString.Bfk, paramString.Bfl, (int[])localObject2, paramString.Bep);
            if (paramString.Bfg != 0)
            {
              com.tencent.pb.common.c.c.i("TalkRoomService", new Object[] { "get helloFreqSeconds:" + paramString.Bfg });
              BAu = paramString.Bfg * 1000;
            }
            dXH();
            n(paramString.groupId, paramString.twP, paramString.twQ);
            if (i != 0)
            {
              localObject1 = new HashMap();
              ((Map)localObject1).put("result", Boolean.TRUE);
              ((Map)localObject1).put("shareUrl", new String(paramString.BdI.BfW, Charset.forName("utf-8")));
              ((Map)localObject1).put("smsShortUrl", new String(paramString.BdI.BfX, Charset.forName("utf-8")));
              ((Map)localObject1).put("groupId", paramString.groupId);
              this.ByT.b("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, localObject1);
            }
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCreateVoiceGroupEnd", this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh) });
            break;
          }
          label4176:
          if (((a.x)localObject1).BeZ == null)
          {
            i = 0;
            label4187:
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd  resp.members length: ", Integer.valueOf(i) });
            if (b(((a.x)localObject1).groupId, ((a.x)localObject1).twP, ((a.x)localObject1).twQ, false)) {
              break label4350;
            }
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", ((a.x)localObject1).groupId, this.nuW, " resp.roomid: ", Integer.valueOf(((a.x)localObject1).twP), Integer.valueOf(this.nTj) });
            h.Tt(-1308);
          }
          for (;;)
          {
            a(((a.x)localObject1).groupId, null, this.Bda, ((a.x)localObject1).twP, ((a.x)localObject1).twQ, ((a.x)localObject1).BeZ, null, ((a.x)localObject1).BdI, true, true);
            break;
            i = ((a.x)localObject1).BeZ.length;
            break label4187;
            label4350:
            this.BAG.aa(new String[] { "add", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          }
          label4393:
          if (paramInt2 != 14801) {
            break label2072;
          }
          i = -1402;
          break label2072;
          label4408:
          if (paramInt2 == 0) {
            this.BAv = true;
          }
          if (!cMa())
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd is working groupId: ", paramString.nuW });
            this.BAG.reset();
            sb(false);
            this.BAG.aa(new String[] { "ack", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
            this.txk = false;
            this.nuW = paramString.nuW;
            this.BAS = this.nuW;
            this.nTj = paramString.nTj;
            this.tFh = paramString.tFh;
            this.Bda = paramString.Bda;
            setState(2);
            this.BAC = System.currentTimeMillis();
            localObject1 = this.BAG;
            com.tencent.pb.common.c.c.d(h.TAG, new Object[] { "beginNotifyTime" });
            ((h)localObject1).BCk = System.currentTimeMillis();
            if (paramInt2 == 18900) {
              h.Tt(-1521);
            }
          }
          while (!com.tencent.pb.common.c.g.equals(paramString.nuW, this.nuW))
          {
            localObject1 = new f.e(this);
            ((f.e)localObject1).groupId = paramString.nuW;
            ((f.e)localObject1).nMZ = paramString.nTj;
            ((f.e)localObject1).nNa = paramString.tFh;
            this.BAo.put(paramString.nuW, localObject1);
            localObject1 = c.dXv().axw(paramString.nuW);
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", paramString.nuW, " multiTalkGroup: ", localObject1 });
            if (localObject1 == null) {
              break label4792;
            }
            paramString = this.BAO;
            localObject1 = new g.20(paramString, (MultiTalkGroup)localObject1);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label4779;
            }
            ((Runnable)localObject1).run();
            break;
          }
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handleAckEnd groupid same return ", this.nuW });
          break label2330;
          label4779:
          paramString.handler.post((Runnable)localObject1);
          break label2330;
          label4792:
          a(paramString.nuW, paramString.nTj, paramString.tFh, false, false, false);
          break label2330;
          label4814:
          localObject1 = c.dXv().axp(paramString.groupId);
          if (localObject1 != null)
          {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd" });
            a(paramString.groupId, null, ((TalkRoom)localObject1).dXj(), TalkRoom.dXk(), TalkRoom.cNV(), null, null, paramString.BdI, true, false);
          }
          for (;;)
          {
            this.BAO.fh(paramString.groupId, 0);
            break;
            a(paramString.groupId, null, 0, 0, 0L, null, null, paramString.BdI, true, false);
          }
          label4913:
          if (!com.tencent.pb.common.c.g.equals(paramString.nuW, this.nuW)) {
            break label2771;
          }
          this.BAG.aa(new String[] { "sendmsg", "resp", String.valueOf(paramInt2), String.valueOf(this.state) });
          paramString = this.BAO;
          localObject1 = new g.18(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            ((Runnable)localObject1).run();
            break label2771;
          }
          paramString.handler.post((Runnable)localObject1);
          break label2771;
          label5014:
          if (this.BAH != null)
          {
            localObject1 = new int[6];
            localObject1[0] = paramString.Bfo;
            localObject1[1] = paramString.Bfp;
            localObject1[2] = paramString.Bfq;
            localObject1[3] = paramString.Bfr;
            localObject1[4] = paramString.Bfs;
            localObject1[5] = paramString.Bft;
            com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject1[2]), Integer.valueOf(localObject1[3]), Integer.valueOf(localObject1[4]), Integer.valueOf(localObject1[5]) });
            localObject2 = this.BAH;
            if (((b)localObject2).BzZ != null) {
              break label5244;
            }
            com.tencent.pb.common.c.c.w("simon:TalkRoomContext", new Object[] { "steve:setMVSvrCfg null, pMVSvrCfg:", localObject1, ", engine:", ((b)localObject2).BzZ });
          }
          for (;;)
          {
            if (paramInt2 == 0)
            {
              localObject1 = this.BAO;
              paramString = new g.15((g)localObject1, paramString.Bfo);
              if (Looper.myLooper() == Looper.getMainLooper())
              {
                paramString.run();
                break;
                label5244:
                ((b)localObject2).BzZ.setMVSvrCfg((int[])localObject1, 6);
                continue;
              }
              ((g)localObject1).handler.post(paramString);
              break;
            }
          }
          if (paramInt2 == 24301)
          {
            this.BAO.l(-1700, Integer.valueOf(paramString.Bfv));
            continue;
          }
          this.BAO.l(-800, null);
          continue;
        }
        if (paramInt2 == 0)
        {
          paramString = this.BAO;
          paramd = new g.16(paramString);
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            paramd.run();
            AppMethodBeat.o(127902);
            return;
          }
          paramString.handler.post(paramd);
          AppMethodBeat.o(127902);
          return;
        }
        this.BAO.l(-1600, null);
      }
    }
    AppMethodBeat.o(127902);
  }
  
  public final void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(127915);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "closeVoiceGroup groupId: ", paramString, " mGroupId: ", this.nuW, " roomId: ", Integer.valueOf(paramInt), " mRoomId: ", Integer.valueOf(this.nTj), " roomKey: ", Long.valueOf(paramLong), " mRoomKey: ", Long.valueOf(this.tFh) });
    c.dXv().axq(paramString);
    if (paramBoolean1) {
      n(paramString, paramInt, paramLong);
    }
    this.BAo.remove(paramString);
    if (b(paramString, paramInt, paramLong, false))
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "closeVoiceGroup isCurrentRoom groupId: ", paramString, " roomId: ", Integer.valueOf(paramInt), " roomKey: ", Long.valueOf(paramLong) });
      sb(true);
      this.BAO.cx(paramString, paramBoolean2);
    }
    if (paramBoolean3)
    {
      paramString = c.dXv().axw(paramString);
      if (paramString != null) {
        this.BAO.g(paramString);
      }
    }
    AppMethodBeat.o(127915);
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(127893);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "rejectTalkRoom groupId: ", paramString, " mGroupId: ", this.nuW, " roomId: ", Integer.valueOf(paramInt1), " roomKey: ", Long.valueOf(paramLong), " reason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(127893);
      return false;
    }
    int i;
    boolean bool;
    if (1 == paramInt2)
    {
      i = 1;
      if ((3 == i) && (paramInt2 != 7)) {
        dXF();
      }
      com.tencent.wecall.talkroom.a.i locali = new com.tencent.wecall.talkroom.a.i(paramString, paramInt1, paramLong, paramInt2);
      bool = com.tencent.pb.common.b.e.dTE().a(locali);
      if (!b(paramString, paramInt1, paramLong, false)) {
        break label249;
      }
      this.BAG.aa(new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, false);
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "rejectTalkRoom ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(127893);
      return bool;
      i = 3;
      break;
      label249:
      h.a(paramString, paramInt1, paramLong, new String[] { "reject", "req", String.valueOf(bool), String.valueOf(this.state) });
    }
  }
  
  public final boolean a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(127896);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "exitTalkRoom: has exited" });
      AppMethodBeat.o(127896);
      return false;
    }
    com.tencent.wecall.talkroom.a.f localf = new com.tencent.wecall.talkroom.a.f(paramString, paramInt1, paramLong, paramInt2);
    boolean bool = com.tencent.pb.common.b.e.dTE().a(localf);
    this.BAG.aa(new String[] { "exit", "req", String.valueOf(bool), String.valueOf(this.state) });
    a(paramString, paramInt1, paramLong, paramBoolean);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "exitTalkRoom ret: ", Boolean.valueOf(bool) });
    AppMethodBeat.o(127896);
    return bool;
  }
  
  public final boolean aK(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127933);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "finishCurrentTalk groupId: ", paramString, " rejectReason: ", Integer.valueOf(paramInt1), " exitReason: ", Integer.valueOf(paramInt2) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(127933);
      return false;
    }
    if ((paramInt1 == 1) || (paramInt2 == 100)) {
      this.BAG.dXR();
    }
    int i = this.nTj;
    long l = this.tFh;
    int j = a.dXg().state;
    if (j.axD(paramString))
    {
      this.BAG.Tx(327);
      bool = a.dXg().fi(paramString, 1000);
      AppMethodBeat.o(127933);
      return bool;
    }
    if (j == 2)
    {
      bool = a.dXg().a(paramString, i, l, paramInt1);
      AppMethodBeat.o(127933);
      return bool;
    }
    com.tencent.pb.common.c.b.I(new Integer[] { Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108) }).contains(Integer.valueOf(paramInt2));
    boolean bool = a.dXg().a(paramString, i, l, paramInt2, true);
    AppMethodBeat.o(127933);
    return bool;
  }
  
  public final f.e axx(String paramString)
  {
    AppMethodBeat.i(127917);
    paramString = (f.e)this.BAo.get(paramString);
    AppMethodBeat.o(127917);
    return paramString;
  }
  
  public final boolean axy(String paramString)
  {
    AppMethodBeat.i(127918);
    if ((f.e)this.BAo.get(paramString) != null)
    {
      AppMethodBeat.o(127918);
      return true;
    }
    AppMethodBeat.o(127918);
    return false;
  }
  
  final boolean cHL()
  {
    AppMethodBeat.i(127925);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "initEngine", this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), Integer.valueOf(this.state) });
    try
    {
      localb = this.BAH;
      boolean bool = com.tencent.pb.common.a.a.BcB;
      if (bool) {
        break label131;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb;
        label131:
        String str;
        com.tencent.pb.talkroom.sdk.e locale;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "initEngine", localException });
        i = -99999;
        continue;
        i = localException.BzZ.field_capInfo.length;
      }
      AppMethodBeat.o(127925);
      return true;
    }
    if (i < 0)
    {
      h.Tw(-3001);
      this.BAG.Tx(201);
      this.BAH = null;
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "initEngine engine.protocalInit error", Integer.valueOf(i) });
      AppMethodBeat.o(127925);
      return false;
      str = com.tencent.pb.common.c.d.tFk.getDir("lib", 0).getAbsolutePath();
      locale = Bdm;
      if (locale == null) {
        break label369;
      }
    }
    label369:
    for (int i = locale.Lo();; i = 0)
    {
      int j = k.jN(com.tencent.pb.common.c.d.tFk);
      com.tencent.pb.common.c.c.i("simon:TalkRoomContext", new Object[] { "protocalInit netType:", Integer.valueOf(j), " cpuFlag:", Integer.valueOf(i), "libPath:", str });
      if (localb.BzZ == null)
      {
        i = -1;
        break;
      }
      j = localb.BzZ.init(j, i, str + "/");
      if (localb.BzZ.field_capInfo == null)
      {
        i = 0;
        com.tencent.pb.common.c.c.i("simon:TalkRoomContext", new Object[] { "protocalInit", Integer.valueOf(j), "field_capInfo length: ", Integer.valueOf(i) });
        i = j;
        break;
      }
    }
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(127916);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "state: ", Integer.valueOf(this.state) });
    if (this.state != 0)
    {
      AppMethodBeat.o(127916);
      return true;
    }
    AppMethodBeat.o(127916);
    return false;
  }
  
  public final int cw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127913);
    long l;
    int i;
    try
    {
      paramArrayOfByte = (a.p)com.google.a.a.e.a(new a.p(), paramArrayOfByte, paramArrayOfByte.length);
      if (paramArrayOfByte == null) {
        if ((!TextUtils.isEmpty(this.nuW)) || (!TextUtils.isEmpty(this.BAy)))
        {
          this.BAG.aa(new String[] { "notify", "pasrefail" });
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange groupChg null" });
          AppMethodBeat.o(127913);
          return -2;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        h.Tt(-1601);
        paramArrayOfByte = null;
        continue;
        h.a(this.nTj, this.tFh, new String[] { "notify", "pasrefail" });
      }
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange", this.nuW, Integer.valueOf(this.nTj), Long.valueOf(this.tFh), Long.valueOf(paramArrayOfByte.cpO), Integer.valueOf(paramArrayOfByte.Bek) });
      l = paramArrayOfByte.cpO;
      if (this.BAT.contains(Long.valueOf(l)))
      {
        i = 1;
        if (i == 0) {
          break label368;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT onVoiceGroupChange isMsgDouble error" });
        if (!b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false)) {
          break label324;
        }
        this.BAG.aa(new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.Bek) });
      }
      for (;;)
      {
        AppMethodBeat.o(127913);
        return -3;
        this.BAT.add(Long.valueOf(l));
        i = 0;
        break;
        label324:
        h.a(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, new String[] { "notify", "repeat", String.valueOf(paramArrayOfByte.Bek) });
      }
      label368:
      if (b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false)) {
        this.BAG.aa(new String[] { "notify", "succ", String.valueOf(paramArrayOfByte.Bek) });
      }
      if (paramArrayOfByte.Bek != 2) {
        break label472;
      }
    }
    a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, true, true);
    for (;;)
    {
      AppMethodBeat.o(127913);
      return 0;
      label472:
      Object localObject1;
      int j;
      if (paramArrayOfByte.Bek == 4)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, true, true);
        if ((paramArrayOfByte.Beo != 0) || (paramArrayOfByte.Bep != 0))
        {
          localObject1 = this.BAH;
          i = paramArrayOfByte.Beo;
          j = paramArrayOfByte.Bep;
          if ((com.tencent.pb.common.a.a.BcB) && (((b)localObject1).BzZ != null)) {
            ((b)localObject1).BzZ.SetAVEncryptType(i, j);
          }
        }
      }
      else if (paramArrayOfByte.Bek == 16)
      {
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, true, false);
      }
      else if (paramArrayOfByte.Bek == 1)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerCreateGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " roomId: ", Integer.valueOf(paramArrayOfByte.twP), " roomkey: ", Long.valueOf(paramArrayOfByte.twQ) });
        if (com.tencent.pb.a.a.a.dTY())
        {
          com.tencent.pb.a.a.a.dTZ();
          if ((cMa()) && (com.tencent.pb.common.c.g.equals(paramArrayOfByte.groupId, this.nuW))) {
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange return is same groupId: ", this.nuW });
          }
        }
        else
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT handlerCreateGroupChange isAuthed is false" });
          continue;
        }
        a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, false, true);
        localObject1 = paramArrayOfByte.groupId;
        i = paramArrayOfByte.twP;
        l = paramArrayOfByte.twQ;
        j = paramArrayOfByte.BdL;
        int k = paramArrayOfByte.Beq;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId is null" });
        }
        for (;;)
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerCreateGroupChange start ui" });
          break;
          paramArrayOfByte = new com.tencent.wecall.talkroom.a.a((String)localObject1, i, l, j, k);
          com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "CLTNOT ackTalkRoom groupId: ", localObject1, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(k), Boolean.valueOf(com.tencent.pb.common.b.e.dTE().a(paramArrayOfByte)) });
        }
      }
      else if (paramArrayOfByte.Bek == 8)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleCancelCreateVoiceGroupChange groupChg.groupId: ", paramArrayOfByte.groupId, " mGroupId: ", this.nuW });
        if (b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false))
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, true, false);
          a(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false, false, true);
        }
        else
        {
          a(paramArrayOfByte.groupId, null, paramArrayOfByte.BdL, paramArrayOfByte.twP, paramArrayOfByte.twQ, paramArrayOfByte.Bem, paramArrayOfByte.Bel, paramArrayOfByte.BdI, true, false);
        }
      }
      else
      {
        String str;
        if (paramArrayOfByte.Bek == 128)
        {
          localObject1 = paramArrayOfByte.groupId;
          str = this.nuW;
          if (paramArrayOfByte.Ber == null) {}
          for (i = 0;; i = paramArrayOfByte.Ber.length)
          {
            com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleMemberWhisper groupChg.groupChg.groupId: ", localObject1, " mGroupId: ", str, " groupChg.whisperBuf size: ", Integer.valueOf(i) });
            localObject1 = this.BAO;
            paramArrayOfByte = new g.17((g)localObject1, paramArrayOfByte.groupId, paramArrayOfByte.Ber);
            if (Looper.myLooper() != Looper.getMainLooper()) {
              break label1230;
            }
            paramArrayOfByte.run();
            break;
          }
          label1230:
          ((g)localObject1).handler.post(paramArrayOfByte);
        }
        else
        {
          Object localObject2;
          if (paramArrayOfByte.Bek == 256)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false)) {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoMember is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
            } else if (paramArrayOfByte.Ber == null) {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoMember whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
            } else {
              try
              {
                localObject1 = paramArrayOfByte.Ber;
                localObject1 = (a.r)com.google.a.a.e.a(new a.r(), (byte[])localObject1, localObject1.length);
                if ((localObject1 == null) || (((a.r)localObject1).Bev == null)) {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
                }
              }
              catch (com.google.a.a.d locald1)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoMember ", locald1 });
                  localObject2 = null;
                }
                paramArrayOfByte = new ArrayList();
                localObject2 = ((a.r)localObject2).Bev;
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
                com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handleVideoMember groupid: ", this.nuW, " roomId: ", Integer.valueOf(this.nTj), " videoUserNames: ", paramArrayOfByte });
                localObject2 = this.BAO;
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
          else if (paramArrayOfByte.Bek == 1024)
          {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false))
            {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleOtherDevice is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
            }
            else if ((this.state != 3) && (this.state != 4))
            {
              a(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, 1);
              this.BAO.l(-1400, null);
            }
          }
          else if (paramArrayOfByte.Bek == 512) {
            if (!b(paramArrayOfByte.groupId, paramArrayOfByte.twP, paramArrayOfByte.twQ, false)) {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoSubscribes is not same room ", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
            } else if (paramArrayOfByte.Ber == null) {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoSubscribes whisperBuf is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
            } else {
              try
              {
                localObject2 = paramArrayOfByte.Ber;
                localObject2 = (a.q)com.google.a.a.e.a(new a.q(), (byte[])localObject2, localObject2.length);
                if (localObject2 == null) {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoMember notify is null", paramArrayOfByte.groupId, Integer.valueOf(paramArrayOfByte.twP) });
                }
              }
              catch (com.google.a.a.d locald2)
              {
                for (;;)
                {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handleVideoSubscribes ", locald2 });
                  local1 = null;
                }
                paramArrayOfByte = this.BAO;
                g.1 local1 = new g.1(paramArrayOfByte, local1.Beu);
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
  
  final boolean dXD()
  {
    AppMethodBeat.i(127884);
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "initService" });
    com.tencent.pb.talkroom.sdk.e locale = Bdm;
    if (locale != null) {
      locale.bSJ();
    }
    this.BAH = new b();
    this.BAS = this.nuW;
    this.BAI = new f.1(this);
    AppMethodBeat.o(127884);
    return true;
  }
  
  public final void dXE()
  {
    AppMethodBeat.i(127886);
    try
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "stopHoldeOnPusher " });
      if (this.BBe != null) {
        this.mHandler.removeCallbacks(this.BBe);
      }
      AppMethodBeat.o(127886);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { " stopTimer: ", localThrowable });
      AppMethodBeat.o(127886);
    }
  }
  
  public final void fg(String paramString, int paramInt)
  {
    AppMethodBeat.i(127936);
    if ((com.tencent.pb.common.c.g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", paramString)) && (cMa()) && ((this.odg) || (this.BAw))) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(127936);
      return;
      switch (k.jN(com.tencent.pb.common.c.d.tFk))
      {
      }
      for (this.BAQ = false; (this.nTj == 0) || (this.tFh == 0L); this.BAQ = true)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendRedirect mRoomId valid(session ended)" });
        AppMethodBeat.o(127936);
        return;
      }
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendRedirect", this.nuW, Integer.valueOf(this.nTj) });
      this.BAG.dXS();
      paramString = new com.tencent.wecall.talkroom.a.h(this.nuW, this.nTj, this.tFh, c.dXv().axr(this.nuW));
      boolean bool = com.tencent.pb.common.b.e.dTE().a(paramString);
      this.BAG.aa(new String[] { "redirect", "req", String.valueOf(bool), String.valueOf(this.state) });
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendRedirect ret: ", Boolean.valueOf(bool) });
      AppMethodBeat.o(127936);
      return;
      paramString = this.BAH;
      paramInt = k.jN(com.tencent.pb.common.c.d.tFk);
      if ((!com.tencent.pb.common.a.a.BcB) || (paramString.BzZ == null))
      {
        AppMethodBeat.o(127936);
        return;
      }
      paramString.BzZ.onNetworkChange(paramInt);
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(127882);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127882);
      return true;
      paramMessage = paramMessage.obj;
      if (this.state == 4)
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerInviteTimeOut state: ", Integer.valueOf(this.state) });
      }
      else if (!(paramMessage instanceof d))
      {
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerInviteTimeOut obj is not GroupRoomInfo" });
      }
      else
      {
        paramMessage = (d)paramMessage;
        if (paramMessage.nuW == null)
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId is null" });
        }
        else
        {
          com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "handlerInviteTimeOut" });
          if ((paramMessage.nuW.equals(this.nuW)) && (paramMessage.nTj == this.nTj) && (paramMessage.tFh == this.tFh))
          {
            h.dXU();
            this.BAG.Tx(501);
            a(paramMessage.nuW, paramMessage.nTj, paramMessage.tFh, 7);
            com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerInviteTimeOut groupRoomInfo.mGroupId: ", paramMessage.nuW });
            continue;
            paramMessage = paramMessage.obj;
            if (this.state != 1)
            {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerCreateGroup state: ", Integer.valueOf(this.state) });
            }
            else if (!(paramMessage instanceof f.a))
            {
              com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
            }
            else
            {
              paramMessage = (f.a)paramMessage;
              if (com.tencent.pb.common.c.g.iN(paramMessage.groupId, this.nuW))
              {
                String str1 = paramMessage.groupId;
                Object localObject1 = paramMessage.BBv;
                a.ay localay = paramMessage.BBw;
                int i = paramMessage.BdL;
                int j = paramMessage.type;
                long l = paramMessage.BBx;
                String str2 = paramMessage.BBy;
                boolean bool = paramMessage.BBz;
                String str3 = paramMessage.BBA;
                this.BAG.dXS();
                Object localObject2 = c.dXv();
                paramMessage = "";
                localObject2 = ((c)localObject2).axp(str1);
                if (localObject2 != null) {
                  if (((TalkRoom)localObject2).BzX != null) {
                    break label618;
                  }
                }
                label618:
                for (paramMessage = "";; paramMessage = ((TalkRoom)localObject2).BzX.name)
                {
                  localObject1 = new com.tencent.wecall.talkroom.a.d(str1, (String[])localObject1, this.BAH.dXs(), paramMessage, localay, i, j, l, str2, bool, str3);
                  bool = com.tencent.pb.common.b.e.dTE().a((com.tencent.pb.common.b.d)localObject1);
                  this.BAG.aa(new String[] { "create", "req", String.valueOf(bool), String.valueOf(this.state) });
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "sendCreateSence groupId: ", str1, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(j), " playId: ", Long.valueOf(l), " name: ", paramMessage, " ret: ", Boolean.valueOf(bool) });
                  break;
                }
                paramMessage = paramMessage.obj;
                if (this.state != 3)
                {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerEnterGroup state: ", Integer.valueOf(this.state) });
                }
                else if (!(paramMessage instanceof f.c))
                {
                  com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "handlerCreateGroup obj is not CreateGroupObj" });
                }
                else
                {
                  paramMessage = (f.c)paramMessage;
                  if (b(paramMessage.groupId, paramMessage.nMZ, paramMessage.nNa, false))
                  {
                    b(paramMessage.groupId, paramMessage.nMZ, paramMessage.nNa, paramMessage.BdL, paramMessage.BdS, paramMessage.BBM);
                    continue;
                    com.tencent.pb.common.c.f.dTW();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(127885);
    this.BAG.groupId = this.nuW;
    this.BAG.BdG = this.BAy;
    if (com.tencent.pb.common.c.g.isEmpty(this.BAG.groupId)) {
      this.BAG.groupId = "";
    }
    if (com.tencent.pb.common.c.g.isEmpty(this.BAG.BdG)) {
      this.BAG.BdG = "";
    }
    this.BAG.tAo = 1;
    this.BAG.nMZ = this.nTj;
    this.BAG.nNa = this.tFh;
    com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "uninitService isUpload: ", Boolean.valueOf(paramBoolean) });
    cHI();
    Kg();
    int j = -99999;
    int i = j;
    if (this.BAH != null) {}
    try
    {
      this.BAP = this.BAH.dXu();
      i = this.BAH.Close();
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "uninitService mid", Integer.valueOf(i) });
      j = i;
      if (this.BAH == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        j = this.BAH.uninitLive();
        this.BAH = null;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "steve:uninitService set engine null!" });
        if (paramBoolean)
        {
          String str = this.BAG.dXP();
          if ((!TextUtils.isEmpty(this.BAG.groupId)) || (!TextUtils.isEmpty(this.BAG.BdG)))
          {
            h.axz(str);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0L);
          }
          this.BAG.reset();
          KS();
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", new Object[] { "uninitService end error", Integer.valueOf(j) });
        AppMethodBeat.o(127885);
        return;
        localThrowable = localThrowable;
        com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "uninitService", localThrowable });
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "uninitService 2", localException });
          j = i;
        }
      }
    }
  }
  
  public final void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(127926);
    try
    {
      Et();
      dXG();
      if (paramBoolean)
      {
        dXL();
        aCJ();
      }
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(127926);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "setRecordDevActive active: ", Boolean.valueOf(paramBoolean), localThrowable });
      AppMethodBeat.o(127926);
    }
  }
  
  final void setState(int paramInt)
  {
    AppMethodBeat.i(127888);
    com.tencent.pb.common.c.c.w("TalkRoomService", new Object[] { "setState newState: ", Integer.valueOf(paramInt) });
    if (this.state == paramInt)
    {
      AppMethodBeat.o(127888);
      return;
    }
    this.state = paramInt;
    this.BAO.onStateChanged(paramInt);
    AppMethodBeat.o(127888);
  }
  
  final class d
  {
    int nTj;
    String nuW;
    long tFh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f
 * JD-Core Version:    0.7.0.1
 */