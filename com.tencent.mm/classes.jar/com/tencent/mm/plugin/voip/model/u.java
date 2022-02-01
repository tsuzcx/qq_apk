package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.j;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.fkx;
import com.tencent.mm.protocal.protobuf.fvs;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class u
{
  private static final com.tencent.mm.b.f<Integer, p.a> lNS;
  public MTimerHandler LoP;
  public v UBE;
  public com.tencent.mm.plugin.voip.a UBF;
  public boolean UBG;
  public boolean UBH;
  public boolean UBI;
  public boolean UBJ;
  private long UBK;
  public Map<Integer, Long> UBL;
  public int UBM;
  public long UBN;
  public long UBO;
  public volatile u.b UBP;
  private Point UBQ;
  public boolean UBR;
  boolean UBS;
  boolean UBT;
  public boolean UBU;
  public boolean UBV;
  public boolean UBW;
  public gaq UBX;
  public long UBY;
  public boolean UBZ;
  public com.tencent.mm.plugin.voip.floatcard.b UCa;
  private boolean UCb;
  List<a> UCc;
  public HashMap<Long, Boolean> UCd;
  public com.tencent.mm.plugin.voip.f.d UwR;
  public long UxU;
  public long Uxh;
  public String Uxv;
  public boolean huY;
  private p mPf;
  private a.a ozF;
  public String talker;
  private boolean wOe;
  
  static
  {
    AppMethodBeat.i(115155);
    lNS = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(115155);
  }
  
  public u()
  {
    AppMethodBeat.i(115113);
    this.huY = false;
    this.UBG = false;
    this.UBH = false;
    this.UBI = false;
    this.UBJ = false;
    this.talker = null;
    this.UBK = 0L;
    this.UBL = new HashMap();
    this.UBM = -1;
    this.UBN = 0L;
    this.UBO = 0L;
    this.UBR = false;
    this.UBS = false;
    this.UBT = false;
    this.UBU = false;
    this.UBV = false;
    this.wOe = false;
    this.UBW = true;
    this.UBX = null;
    this.UBY = 0L;
    this.Uxv = null;
    this.UBZ = false;
    this.Uxh = 0L;
    this.UxU = 0L;
    this.UCa = new com.tencent.mm.plugin.voip.floatcard.b();
    this.UCb = true;
    this.mPf = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(115109);
        Log.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        l locall;
        if ((u.a(u.this)) && (paramAnonymousInt == 4))
        {
          locall = u.this.UBE.UvO;
          if (locall.Uzf == 0) {
            locall.Uzf = locall.UyU.UDs;
          }
          MMApplicationContext.getContext();
          paramAnonymousInt = g.ibq();
          if (paramAnonymousInt != locall.Uzf) {
            g.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + locall.Uzf + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locall.UyU.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            g.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locall.UyU.JHb + ", roomkey=" + locall.UyU.Hnt + "]");
          }
          fvs localfvs = new fvs();
          localfvs.abTS = 3;
          localfvs.abTT = new com.tencent.mm.bx.b(arrayOfByte, 0, 1);
          locall.UyU.SendRUDP(localfvs.toByteArray(), localfvs.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            g.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
          }
        }
        locall.Uzf = paramAnonymousInt;
        u.this.UBE.hYP();
        AppMethodBeat.o(115109);
      }
    };
    this.ozF = new u.2(this);
    this.LoP = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(293316);
        Log.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (u.e(u.this) == null)
        {
          u.f(u.this);
          u.g(u.this).stopTimer();
          AppMethodBeat.o(293316);
          return false;
        }
        MMApplicationContext.getContext();
        if (u.hYI())
        {
          u.this.bh(u.e(u.this).Zvz, u.e(u.this).ZvA);
          Log.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(u.e(u.this).Zvz), Long.valueOf(u.e(u.this).ZvA), Integer.valueOf(u.e(u.this).CreateTime) });
          u.this.c(u.e(u.this));
          u.h(u.this);
          u.f(u.this);
          u.g(u.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 5L, 1L, false);
          AppMethodBeat.o(293316);
          return false;
        }
        if (System.currentTimeMillis() - u.i(u.this) < 60000L)
        {
          AppMethodBeat.o(293316);
          return true;
        }
        u.h(u.this);
        u.f(u.this);
        u.g(u.this).stopTimer();
        AppMethodBeat.o(293316);
        return false;
      }
    }, true);
    this.UCc = null;
    this.UCd = new HashMap();
    this.UBE = new v();
    this.Uxh = 0L;
    this.huY = false;
    this.UBG = false;
    this.UBH = false;
    this.talker = null;
    this.UBJ = false;
    this.UBI = false;
    this.Uxv = null;
    com.tencent.mm.kernel.h.baD().a(this.mPf);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class)).a(2, this.ozF);
    AppMethodBeat.o(115113);
  }
  
  public static float Gv(boolean paramBoolean)
  {
    AppMethodBeat.i(115148);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = SubCoreVoip.hVp();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((u)localObject).UBE.UvO.UyU.field_capInfo;
        f2 = f1;
        if (localObject != null)
        {
          f2 = f1;
          localObject = ByteBuffer.wrap((byte[])localObject);
          f2 = f1;
          if (((ByteBuffer)localObject).getInt() > 65535)
          {
            f2 = f1;
            ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
          }
          f2 = f1;
          ((ByteBuffer)localObject).getShort();
          f2 = f1;
          ((ByteBuffer)localObject).getShort();
          f2 = f1;
          float f3 = ((ByteBuffer)localObject).getInt() / 100.0F;
          if (f3 != 0.0F) {
            f1 = f3;
          }
          f2 = f1;
          Log.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(115148);
      return f2;
      f2 = f1;
      localObject = ((u)localObject).UBE.UvO.UyU.UDw;
    }
  }
  
  private static boolean S(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(293324);
    boolean bool2 = com.tencent.mm.compatible.e.b.dh(paramContext);
    boolean bool1;
    int i;
    if ((androidx.core.content.a.checkSelfPermission(paramContext, "android.permission.RECORD_AUDIO") == 0) && ((!paramBoolean) || (androidx.core.content.a.checkSelfPermission(paramContext, "android.permission.CAMERA") == 0)))
    {
      bool1 = true;
      if ((!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actx, d.a.acsJ)) || (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.acty, d.a.acsJ)) || (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actB, d.a.acsJ))) {
        break label170;
      }
      i = 1;
      label110:
      if ((!bool2) || (!bool1) || (i == 0)) {
        if (!paramBoolean) {
          break label175;
        }
      }
    }
    label170:
    label175:
    for (int j = 2;; j = 1)
    {
      paramContext = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.r(j, bool2, bool1);
      if ((!bool2) || (!bool1) || (i == 0)) {
        break label180;
      }
      AppMethodBeat.o(293324);
      return true;
      bool1 = false;
      break;
      i = 0;
      break label110;
    }
    label180:
    AppMethodBeat.o(293324);
    return false;
  }
  
  private void a(Context paramContext, Intent paramIntent, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(293325);
    Object localObject = new PString();
    PBool localPBool1 = new PBool();
    PBool localPBool2 = new PBool();
    PInt localPInt = new PInt();
    PLong localPLong = new PLong();
    ((PString)localObject).value = paramString;
    localPBool1.value = paramBoolean1;
    localPBool2.value = paramBoolean2;
    localPInt.value = com.tencent.mm.plugin.voip.f.k.bw(localPBool1.value, localPBool2.value);
    localPLong.value = paramLong;
    String str = ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aT(paramIntent);
    localObject = SubCoreVoip.hVp().a(paramContext, (PString)localObject, localPBool1, localPBool2, localPInt, localPLong, str);
    if (localObject != null)
    {
      this.UCa.k(new WeakReference(localObject));
      com.tencent.threadpool.h.ahAA.bk(new u.6(this, paramContext, paramIntent, paramLong, paramBoolean2, paramString));
    }
    AppMethodBeat.o(293325);
  }
  
  public static byte[] af(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 12;
    while (i < paramInt + 12)
    {
      arrayOfByte[(i - 12)] = paramArrayOfByte[i];
      i += 1;
    }
    return arrayOfByte;
  }
  
  private int b(gaq paramgaq)
  {
    int j = -1;
    boolean bool1 = true;
    AppMethodBeat.i(115120);
    Object localObject = z.bAM();
    String str2;
    int i;
    String str1;
    if (paramgaq != null)
    {
      str2 = paramgaq.abXZ;
      k = paramgaq.abXQ;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", new Object[] { Integer.valueOf(paramgaq.Zvz), localObject, str2, this.UBE.UCz, Integer.valueOf(k), Boolean.valueOf(this.UBE.hWB()), Boolean.valueOf(this.UBE.UvO.hWz()), Boolean.valueOf(this.UBE.UCw) });
      i = j;
      if (!this.UBE.hWB()) {
        break label634;
      }
      i = j;
      if (this.UBE.UvO == null) {
        break label634;
      }
      i = j;
      if (!this.UBE.UvO.hWz()) {
        break label634;
      }
      i = j;
      if (this.UBE.UCw) {
        break label634;
      }
      str1 = this.UBE.UCz;
      if ((str2 == null) || (str1 == null))
      {
        Log.e("MicroMsg.Voip.VoipService", "steve:[simucall] name null! myname:%s, remoteInviteName:%s, myInviteName:%s", new Object[] { localObject, str2, str1 });
        AppMethodBeat.o(115120);
        return -1;
      }
    }
    else
    {
      AppMethodBeat.o(115120);
      return -1;
    }
    boolean bool2 = str1.equals(str2);
    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]  mutualCalling:%s", new Object[] { Boolean.valueOf(bool2) });
    if (bool2)
    {
      this.UBE.UCw = true;
      i = str1.compareTo((String)localObject);
      boolean bool3 = str1.contains("@");
      if ((i < 0) || (bool3))
      {
        i = 1;
        localObject = this.UBE.UvO.UyU;
        ((v2protocal)localObject).UFO |= 0x2;
        if (!this.UBF.hVh()) {
          break label668;
        }
        j = 0;
        label350:
        if ((k != 1) && (j != 1)) {
          break label730;
        }
      }
    }
    label668:
    label730:
    for (int k = 1;; k = 0)
    {
      if ((this.UBF.hVh()) && (k == 1))
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        this.UBE.UvH = false;
        hYz();
        this.UBE.UvO.UyV.VQ(1);
      }
      paramgaq.abXQ = k;
      this.UBE.UCx = k;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", new Object[] { str1, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i == 2)
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
        this.UBE.UCy = true;
        if ((this.UBE.UvO.UyU != null) && (this.UBE.UvO.UyU.roomId != 0) && (this.UBE.UvO.UyU.Hnt != 0L) && (this.UBE.UvO.UyU.roomId != paramgaq.Zvz)) {
          d(this.UBE.UvO.UyU.roomId, this.UBE.UvO.UyU.Hnt, j);
        }
        if (k == 0) {
          label625:
          this.UBF.Gh(bool1);
        }
      }
      for (;;)
      {
        label634:
        if (this.UBE.UCw) {
          paramgaq.abXQ = this.UBE.UCx;
        }
        AppMethodBeat.o(115120);
        return i;
        i = 2;
        break;
        j = 1;
        break label350;
        bool1 = false;
        break label625;
        this.UBE.UCy = false;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
        continue;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", new Object[] { str1, Boolean.valueOf(bool2) });
        i = j;
      }
    }
  }
  
  public static p.a bfJ(String paramString)
  {
    AppMethodBeat.i(115124);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    int i = paramString.hashCode();
    p.a locala = (p.a)lNS.get(Integer.valueOf(i));
    if (locala != null)
    {
      AppMethodBeat.o(115124);
      return locala;
    }
    locala = new p.a();
    if (!locala.bfI(paramString))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    lNS.B(Integer.valueOf(i), locala);
    AppMethodBeat.o(115124);
    return locala;
  }
  
  private static byte[] bh(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(115126);
    fkx localfkx = new fkx();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      dfw localdfw = new dfw();
      localdfw.OzG = localInteger.intValue();
      localdfw.aaLu = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localdfw);
    }
    localfkx.abBZ = localLinkedList;
    localfkx.abBY = localLinkedList.size();
    try
    {
      paramMap = localfkx.toByteArray();
      AppMethodBeat.o(115126);
      return paramMap;
    }
    catch (IOException paramMap)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
      AppMethodBeat.o(115126);
    }
    return null;
  }
  
  private static Map<Integer, Long> cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115125);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(115125);
      return null;
    }
    try
    {
      paramArrayOfByte = (fkx)new fkx().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(115125);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    Log.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.abBY);
    LinkedList localLinkedList = paramArrayOfByte.abBZ;
    if (localLinkedList.size() != paramArrayOfByte.abBY)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.abBY)
    {
      localHashMap.put(Integer.valueOf(((dfw)localLinkedList.get(i)).OzG), Long.valueOf(0xFFFFFFFF & ((dfw)localLinkedList.get(i)).aaLu));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.abBY)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    AppMethodBeat.o(115125);
    return localHashMap;
  }
  
  private static String cG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115127);
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0".concat(String.valueOf(str3));
      }
      str1 = str1 + str2.toUpperCase();
      i += 1;
    }
    AppMethodBeat.o(115127);
    return str1;
  }
  
  private void hYA()
  {
    AppMethodBeat.i(115146);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    if (com.tencent.mm.compatible.util.d.rb(26)) {}
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
      MMApplicationContext.getContext().stopService((Intent)localObject);
      localObject = q.UBj;
      q.hXq();
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip.VoipService", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
    }
    if (i != 0) {
      this.wOe = false;
    }
    AppMethodBeat.o(115146);
  }
  
  public static boolean hYH()
  {
    if ((v2protocal.Ljx >= 900) && (!v2protocal.Ljy))
    {
      v2protocal.Ljy = true;
      return true;
    }
    return false;
  }
  
  private static void hYl()
  {
    AppMethodBeat.i(115119);
    acn localacn = new acn();
    localacn.ifU.hId = 7;
    localacn.publish();
    AppMethodBeat.o(115119);
  }
  
  public static void setRingSpeakerStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(293321);
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).setRingSpeakerStatus(paramBoolean);
    AppMethodBeat.o(293321);
  }
  
  public final boolean Gj(boolean paramBoolean)
  {
    AppMethodBeat.i(115137);
    n localn = this.UBE.UvO.UyW;
    if (localn.UzC != null)
    {
      paramBoolean = localn.UzC.Gj(paramBoolean);
      AppMethodBeat.o(115137);
      return paramBoolean;
    }
    AppMethodBeat.o(115137);
    return false;
  }
  
  public final int Gt(boolean paramBoolean)
  {
    AppMethodBeat.i(115138);
    l locall = this.UBE.UvO;
    if (paramBoolean) {}
    for (int i = locall.UyU.setAppCmd(412);; i = locall.UyU.setAppCmd(413))
    {
      if (i < 0) {
        g.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115138);
      return i;
    }
  }
  
  public final int Gu(boolean paramBoolean)
  {
    AppMethodBeat.i(115139);
    l locall = this.UBE.UvO;
    if (paramBoolean) {}
    for (int i = locall.UyU.setAppCmd(401);; i = locall.UyU.setAppCmd(402))
    {
      if (i < 0) {
        g.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115139);
      return i;
    }
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(293398);
    paramInt1 = this.UBE.a(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(293398);
    return paramInt1;
  }
  
  public final com.tencent.mm.plugin.voip.a a(Context paramContext, PString paramPString, PBool paramPBool1, PBool paramPBool2, PInt paramPInt, PLong paramPLong, String paramString)
  {
    AppMethodBeat.i(293452);
    if (this.UBF != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
      paramPString.value = this.UBF.getUserName();
      paramPBool1.value = this.UBF.hVi();
      paramPBool2.value = this.UBF.hVh();
      paramPInt.value = this.UBF.getState();
      paramContext = this.UBF;
      AppMethodBeat.o(293452);
      return paramContext;
    }
    Log.i("MicroMsg.Voip.VoipService", "pToUser before is %s and after is %s", new Object[] { paramPString.value, this.UBE.toUser });
    if (!paramPString.value.equals(this.UBE.toUser))
    {
      paramPInt = com.tencent.mm.plugin.voip.f.f.ULF;
      com.tencent.mm.plugin.voip.f.f.ibm();
    }
    if (com.tencent.mm.plugin.voip.f.f.ibf()) {
      paramPString.value = this.UBE.toUser;
    }
    paramPString.value = this.UBE.toUser;
    paramPBool2.value = this.UBE.UvH;
    if (paramPString.value == null)
    {
      Log.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
      AppMethodBeat.o(293452);
      return null;
    }
    if ((!paramPBool1.value) && (!this.UBE.hWB()))
    {
      Log.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
      paramPString = paramPString.value;
      if (paramPBool2.value)
      {
        paramContext = cc.adkp;
        if (!paramPBool1.value) {
          break label286;
        }
      }
      label286:
      for (int i = 1;; i = 0)
      {
        s.b(paramPString, paramContext, i, 4, MMApplicationContext.getContext().getString(b.g.voip_call_cancel_msg_from));
        AppMethodBeat.o(293452);
        return null;
        paramContext = cc.adko;
        break;
      }
    }
    if (com.tencent.mm.plugin.voip.f.h.ibz())
    {
      ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aDE(paramString);
      if (this.UBF == null)
      {
        paramContext = new IllegalStateException("setMgr() should be called in createVoIPMgr()");
        AppMethodBeat.o(293452);
        throw paramContext;
      }
    }
    else
    {
      this.UBF = new NewVoipMgr();
    }
    this.UBF.a(paramContext, paramPString.value, paramPBool1.value, paramPBool2.value, paramPLong.value);
    paramContext = this.UBF;
    AppMethodBeat.o(293452);
    return paramContext;
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(293370);
    this.UBE.a(paramContext, paramx);
    AppMethodBeat.o(293370);
  }
  
  public final void a(Context paramContext, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(293434);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    this.UBE.toUser = paramString;
    this.UBE.OEa = paramBoolean1;
    this.UBE.UvH = paramBoolean2;
    ggh();
    long l = System.currentTimeMillis();
    Log.printInfoStack("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.heY.eLx) });
    int i;
    if ((com.tencent.mm.compatible.util.d.rd(28)) || (Build.VERSION.CODENAME.equals("Q")))
    {
      i = 1;
      com.tencent.mm.plugin.voip.f.h.iby();
      if (!com.tencent.mm.plugin.voip.f.h.ibz()) {
        break label145;
      }
    }
    label145:
    for (Intent localIntent = ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aQ(localContext, paramString);; localIntent = new Intent(localContext, VideoActivity.class))
    {
      if (localIntent != null) {
        break label162;
      }
      AppMethodBeat.o(293434);
      return;
      i = 0;
      break;
    }
    label162:
    if (this.UwR == null) {
      this.UwR = new com.tencent.mm.plugin.voip.f.d();
    }
    localIntent.putExtra("Voip_User", paramString);
    localIntent.putExtra("Voip_Outcall", paramBoolean1);
    localIntent.putExtra("Voip_VideoCall", paramBoolean2);
    localIntent.putExtra("Voip_LastPage_Hash", l);
    localIntent.putExtra("Voip_CallRoomKey", paramLong);
    Object localObject = "";
    if ((!paramBoolean1) && (i != 0) && (!AppForegroundDelegate.heY.eLx))
    {
      this.UBP = new u.b(this, paramBoolean2, paramString, paramBoolean3, paramLong);
      String str = aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localIntent.getStringExtra("Voip_User")).field_username);
      if (com.tencent.mm.k.b.aQI())
      {
        localObject = new RemoteViews(MMApplicationContext.getPackageName(), b.e.voip_calling_notification);
        ((RemoteViews)localObject).setTextViewText(b.d.notification_name, str);
        if (localIntent.getBooleanExtra("Voip_VideoCall", true))
        {
          paramContext = MMApplicationContext.getResources().getString(b.g.voip_invited_video_tip);
          ((RemoteViews)localObject).setImageViewResource(b.d.notification_icon, b.c.video_call);
          ((RemoteViews)localObject).setTextViewText(b.d.notification_type, paramContext);
          Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(paramString, false, 20, null);
          ((RemoteViews)localObject).setImageViewBitmap(b.d.notification_avatar, localBitmap);
          ((RemoteViews)localObject).setImageViewResource(b.d.wechat_icon, b.c.wechat_appicon);
          str = str + paramContext;
          paramContext = (Context)localObject;
          localObject = str;
        }
      }
    }
    for (;;)
    {
      if (paramBoolean3)
      {
        localIntent.setFlags(603979776);
        localIntent.addFlags(268435456);
      }
      if ((Build.VERSION.SDK_INT >= 29) && (!AppForegroundDelegate.heY.eLx))
      {
        this.UxU = l;
        Log.i("MicroMsg.Voip.VoipService", "start channel ring, now:" + this.UxU);
      }
      if ((!paramBoolean1) && (S(localContext, paramBoolean2)) && (this.UCb) && (AppForegroundDelegate.heY.eLx))
      {
        if (com.tencent.mm.kernel.h.baz()) {
          bp(false, false);
        }
        a(localContext, localIntent, paramString, paramLong, paramBoolean1, paramBoolean2);
        label571:
        if ((com.tencent.mm.plugin.ringtone.c.gOj()) && (com.tencent.mm.compatible.util.l.isSamsung()))
        {
          localObject = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), com.tencent.mm.vfs.u.V(new File(com.tencent.mm.plugin.ringtone.d.aUu(paramString).gOC())));
          MMApplicationContext.getContext().grantUriPermission("com.android.systemui", (Uri)localObject, 1);
        }
        if (paramContext != null) {
          break label788;
        }
        e(paramString, paramBoolean2, paramLong);
        paramContext = com.tencent.mm.plugin.voip.f.f.ULF;
        com.tencent.mm.plugin.voip.f.f.ibj();
      }
      for (;;)
      {
        paramContext = com.tencent.mm.plugin.voip.d.i.UHA;
        com.tencent.mm.plugin.voip.d.i.Gy(paramBoolean1);
        AppMethodBeat.o(293434);
        return;
        paramContext = MMApplicationContext.getResources().getString(b.g.voip_invited_audio_tip);
        ((RemoteViews)localObject).setImageViewResource(b.d.notification_icon, b.c.voice_call);
        break;
        localObject = new RemoteViews(MMApplicationContext.getPackageName(), b.e.voip_calling_notification_simple);
        if (localIntent.getBooleanExtra("Voip_VideoCall", true)) {}
        for (paramContext = MMApplicationContext.getResources().getString(b.g.voip_invited_video_tip);; paramContext = MMApplicationContext.getResources().getString(b.g.voip_invited_audio_tip))
        {
          ((RemoteViews)localObject).setTextViewText(b.d.wechat_name, MMApplicationContext.getResources().getString(b.g.app_name));
          ((RemoteViews)localObject).setTextViewText(b.d.notification_context_text, paramContext);
          break;
        }
        this.UCb = false;
        com.tencent.mm.util.a.a(localContext, localIntent, paramContext, (String)localObject, localIntent.getComponent().getClassName(), com.tencent.mm.plugin.ringtone.d.aUv(paramString));
        break label571;
        label788:
        paramContext = com.tencent.mm.plugin.voip.f.f.ULF;
        com.tencent.mm.plugin.voip.f.f.ibi();
      }
      paramContext = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.a parama)
  {
    AppMethodBeat.i(293455);
    Log.i("MicroMsg.Voip.VoipService", "setMgr");
    this.UBF = parama;
    AppMethodBeat.o(293455);
  }
  
  public final void aqh(int paramInt)
  {
    AppMethodBeat.i(115130);
    this.UBE.aqh(paramInt);
    AppMethodBeat.o(115130);
  }
  
  public final boolean aqm(int paramInt)
  {
    AppMethodBeat.i(293419);
    boolean bool = this.UBE.aqm(paramInt);
    AppMethodBeat.o(293419);
    return bool;
  }
  
  public final void aqo(int paramInt)
  {
    AppMethodBeat.i(115151);
    this.UBE.UvO.aqo(paramInt);
    AppMethodBeat.o(115151);
  }
  
  public final void aqt(int paramInt)
  {
    AppMethodBeat.i(115134);
    Log.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.UBE.aqt(paramInt);
    AppMethodBeat.o(115134);
  }
  
  public final void aqu(int paramInt)
  {
    AppMethodBeat.i(293468);
    k localk = k.Uyp;
    k.a(this.UBE.UvO.UyU, paramInt);
    this.UBE.UvO.UyU.hZd();
    AppMethodBeat.o(293468);
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(293401);
    paramInt1 = this.UBE.UvO.UyW.a(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(293401);
    return paramInt1;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 1256
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore 18
    //   9: lconst_0
    //   10: lstore 16
    //   12: lconst_0
    //   13: lstore 8
    //   15: lconst_0
    //   16: lstore 10
    //   18: lconst_0
    //   19: lstore 12
    //   21: ldc_w 266
    //   24: ldc_w 1258
    //   27: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   34: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   37: getfield 1261	com/tencent/mm/plugin/voip/model/l:UyY	[B
    //   40: invokestatic 1263	com/tencent/mm/plugin/voip/model/u:cF	([B)Ljava/util/Map;
    //   43: astore 24
    //   45: aload 24
    //   47: ifnonnull +336 -> 383
    //   50: ldc_w 266
    //   53: ldc_w 1265
    //   56: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: lconst_0
    //   60: lstore 14
    //   62: ldc_w 266
    //   65: new 290	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 1267
    //   72: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: lload 18
    //   77: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc_w 1269
    //   83: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload 16
    //   88: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: ldc_w 1271
    //   94: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: lload 14
    //   99: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: new 1273	com/tencent/mm/protocal/protobuf/gam
    //   111: dup
    //   112: invokespecial 1274	com/tencent/mm/protocal/protobuf/gam:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 1275	com/tencent/mm/protocal/protobuf/gam:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   119: checkcast 1273	com/tencent/mm/protocal/protobuf/gam
    //   122: astore 24
    //   124: iconst_0
    //   125: istore 5
    //   127: lload 12
    //   129: lstore 6
    //   131: iload 5
    //   133: aload 24
    //   135: getfield 1278	com/tencent/mm/protocal/protobuf/gam:abXS	Ljava/util/LinkedList;
    //   138: invokevirtual 638	java/util/LinkedList:size	()I
    //   141: if_icmpge +1177 -> 1318
    //   144: aload 24
    //   146: getfield 1278	com/tencent/mm/protocal/protobuf/gam:abXS	Ljava/util/LinkedList;
    //   149: iload 5
    //   151: invokevirtual 677	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   154: checkcast 1280	com/tencent/mm/protocal/protobuf/gal
    //   157: astore 25
    //   159: ldc_w 266
    //   162: new 290	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 1282
    //   169: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 25
    //   174: getfield 1285	com/tencent/mm/protocal/protobuf/gal:Zmc	I
    //   177: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 25
    //   188: getfield 1285	com/tencent/mm/protocal/protobuf/gal:Zmc	I
    //   191: iconst_1
    //   192: if_icmpne +462 -> 654
    //   195: new 1287	com/tencent/mm/protocal/protobuf/gbs
    //   198: dup
    //   199: invokespecial 1288	com/tencent/mm/protocal/protobuf/gbs:<init>	()V
    //   202: aload 25
    //   204: getfield 1292	com/tencent/mm/protocal/protobuf/gal:YLa	Lcom/tencent/mm/protocal/protobuf/gol;
    //   207: getfield 1298	com/tencent/mm/protocal/protobuf/gol:aaxD	Lcom/tencent/mm/bx/b;
    //   210: getfield 1303	com/tencent/mm/bx/b:Op	[B
    //   213: invokevirtual 1304	com/tencent/mm/protocal/protobuf/gbs:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   216: checkcast 1287	com/tencent/mm/protocal/protobuf/gbs
    //   219: astore_1
    //   220: aload_1
    //   221: ifnull +413 -> 634
    //   224: ldc_w 266
    //   227: new 290	java/lang/StringBuilder
    //   230: dup
    //   231: ldc_w 1306
    //   234: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload_1
    //   238: getfield 1309	com/tencent/mm/protocal/protobuf/gbs:vhk	I
    //   241: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: lload 8
    //   252: lstore 12
    //   254: lload 8
    //   256: aload 25
    //   258: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   261: i2l
    //   262: lcmp
    //   263: ifge +11 -> 274
    //   266: aload 25
    //   268: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   271: i2l
    //   272: lstore 12
    //   274: lload 12
    //   276: lstore 8
    //   278: aload 25
    //   280: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   283: i2l
    //   284: lload 18
    //   286: lcmp
    //   287: ifle +356 -> 643
    //   290: ldc_w 266
    //   293: new 290	java/lang/StringBuilder
    //   296: dup
    //   297: ldc_w 1312
    //   300: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: aload 25
    //   305: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   308: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 1314
    //   314: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: lload 18
    //   319: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc_w 1316
    //   325: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: getfield 1309	com/tencent/mm/protocal/protobuf/gbs:vhk	I
    //   332: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 1318
    //   338: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   351: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   354: getfield 1322	com/tencent/mm/plugin/voip/model/l:UyX	Lcom/tencent/mm/plugin/voip/model/w;
    //   357: aload_1
    //   358: iconst_1
    //   359: invokevirtual 1327	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/gbs;I)V
    //   362: lload 10
    //   364: lstore 22
    //   366: iload 5
    //   368: iconst_1
    //   369: iadd
    //   370: istore 5
    //   372: lload 22
    //   374: lstore 10
    //   376: lload 12
    //   378: lstore 8
    //   380: goto -249 -> 131
    //   383: aload 24
    //   385: invokeinterface 597 1 0
    //   390: invokeinterface 603 1 0
    //   395: astore 25
    //   397: lconst_0
    //   398: lstore 6
    //   400: aload 25
    //   402: invokeinterface 608 1 0
    //   407: ifeq +1144 -> 1551
    //   410: aload 25
    //   412: invokeinterface 612 1 0
    //   417: checkcast 457	java/lang/Integer
    //   420: astore 26
    //   422: aload 24
    //   424: aload 26
    //   426: invokeinterface 622 2 0
    //   431: checkcast 624	java/lang/Long
    //   434: astore 27
    //   436: aload 26
    //   438: invokevirtual 618	java/lang/Integer:intValue	()I
    //   441: tableswitch	default:+27 -> 468, 1:+68->509, 2:+78->519, 3:+88->529
    //   469: aconst_null
    //   470: lconst_1
    //   471: new 290	java/lang/StringBuilder
    //   474: dup
    //   475: ldc_w 1329
    //   478: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   481: aload 26
    //   483: invokevirtual 618	java/lang/Integer:intValue	()I
    //   486: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   489: ldc_w 1331
    //   492: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 27
    //   497: invokevirtual 1334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: goto -106 -> 400
    //   509: aload 27
    //   511: invokevirtual 1337	java/lang/Long:longValue	()J
    //   514: lstore 18
    //   516: goto -116 -> 400
    //   519: aload 27
    //   521: invokevirtual 1337	java/lang/Long:longValue	()J
    //   524: lstore 16
    //   526: goto -126 -> 400
    //   529: aload 27
    //   531: invokevirtual 1337	java/lang/Long:longValue	()J
    //   534: lstore 6
    //   536: goto -136 -> 400
    //   539: astore 24
    //   541: ldc_w 266
    //   544: aload 24
    //   546: ldc_w 647
    //   549: iconst_0
    //   550: anewarray 4	java/lang/Object
    //   553: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: aload_1
    //   557: invokestatic 1339	com/tencent/mm/plugin/voip/model/u:cG	([B)Ljava/lang/String;
    //   560: astore 24
    //   562: ldc_w 266
    //   565: new 290	java/lang/StringBuilder
    //   568: dup
    //   569: ldc_w 1341
    //   572: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   575: aload_1
    //   576: arraylength
    //   577: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: ldc_w 1343
    //   583: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 24
    //   588: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: ldc_w 1256
    //   600: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   603: iconst_0
    //   604: ireturn
    //   605: astore_1
    //   606: ldc_w 266
    //   609: ldc_w 1345
    //   612: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: ldc_w 266
    //   618: aload_1
    //   619: ldc_w 647
    //   622: iconst_0
    //   623: anewarray 4	java/lang/Object
    //   626: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: aconst_null
    //   630: astore_1
    //   631: goto -411 -> 220
    //   634: ldc_w 266
    //   637: ldc_w 1345
    //   640: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: lload 10
    //   645: lstore 22
    //   647: lload 8
    //   649: lstore 12
    //   651: goto -285 -> 366
    //   654: aload 25
    //   656: getfield 1285	com/tencent/mm/protocal/protobuf/gal:Zmc	I
    //   659: iconst_2
    //   660: if_icmpne +429 -> 1089
    //   663: new 1347	com/tencent/mm/protocal/protobuf/gbh
    //   666: dup
    //   667: invokespecial 1348	com/tencent/mm/protocal/protobuf/gbh:<init>	()V
    //   670: aload 25
    //   672: getfield 1292	com/tencent/mm/protocal/protobuf/gal:YLa	Lcom/tencent/mm/protocal/protobuf/gol;
    //   675: getfield 1298	com/tencent/mm/protocal/protobuf/gol:aaxD	Lcom/tencent/mm/bx/b;
    //   678: getfield 1303	com/tencent/mm/bx/b:Op	[B
    //   681: invokevirtual 1349	com/tencent/mm/protocal/protobuf/gbh:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   684: checkcast 1347	com/tencent/mm/protocal/protobuf/gbh
    //   687: astore_1
    //   688: aload_1
    //   689: ifnull +380 -> 1069
    //   692: ldc_w 266
    //   695: new 290	java/lang/StringBuilder
    //   698: dup
    //   699: ldc_w 1351
    //   702: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   705: aload_1
    //   706: getfield 1354	com/tencent/mm/protocal/protobuf/gbh:vhJ	I
    //   709: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: lload 10
    //   720: lstore 12
    //   722: lload 10
    //   724: aload 25
    //   726: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   729: i2l
    //   730: lcmp
    //   731: ifge +11 -> 742
    //   734: aload 25
    //   736: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   739: i2l
    //   740: lstore 12
    //   742: aload 25
    //   744: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   747: i2l
    //   748: lload 16
    //   750: lcmp
    //   751: ifle +263 -> 1014
    //   754: ldc_w 266
    //   757: new 290	java/lang/StringBuilder
    //   760: dup
    //   761: ldc_w 1356
    //   764: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: aload 25
    //   769: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   772: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: ldc_w 1358
    //   778: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: lload 16
    //   783: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   786: ldc_w 1318
    //   789: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: aload_1
    //   799: getfield 1354	com/tencent/mm/protocal/protobuf/gbh:vhJ	I
    //   802: iconst_5
    //   803: if_icmpne +57 -> 860
    //   806: aload_0
    //   807: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   810: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   813: getfield 1322	com/tencent/mm/plugin/voip/model/l:UyX	Lcom/tencent/mm/plugin/voip/model/w;
    //   816: aload_1
    //   817: invokevirtual 1361	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/gbh;)V
    //   820: lload 12
    //   822: lstore 22
    //   824: lload 8
    //   826: lstore 12
    //   828: goto -462 -> 366
    //   831: astore_1
    //   832: ldc_w 266
    //   835: ldc_w 1363
    //   838: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: ldc_w 266
    //   844: aload_1
    //   845: ldc_w 647
    //   848: iconst_0
    //   849: anewarray 4	java/lang/Object
    //   852: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   855: aconst_null
    //   856: astore_1
    //   857: goto -169 -> 688
    //   860: aload_1
    //   861: getfield 1354	com/tencent/mm/protocal/protobuf/gbh:vhJ	I
    //   864: iconst_1
    //   865: if_icmpne +28 -> 893
    //   868: aload_0
    //   869: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   872: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   875: getfield 1322	com/tencent/mm/plugin/voip/model/l:UyX	Lcom/tencent/mm/plugin/voip/model/w;
    //   878: aload_1
    //   879: invokevirtual 1365	com/tencent/mm/plugin/voip/model/w:b	(Lcom/tencent/mm/protocal/protobuf/gbh;)V
    //   882: lload 12
    //   884: lstore 22
    //   886: lload 8
    //   888: lstore 12
    //   890: goto -524 -> 366
    //   893: aload_1
    //   894: getfield 1354	com/tencent/mm/protocal/protobuf/gbh:vhJ	I
    //   897: bipush 6
    //   899: if_icmpne +78 -> 977
    //   902: aload_1
    //   903: getfield 1366	com/tencent/mm/protocal/protobuf/gbh:YLa	Lcom/tencent/mm/protocal/protobuf/gol;
    //   906: getfield 1298	com/tencent/mm/protocal/protobuf/gol:aaxD	Lcom/tencent/mm/bx/b;
    //   909: invokevirtual 1367	com/tencent/mm/bx/b:toByteArray	()[B
    //   912: astore_1
    //   913: new 1369	com/tencent/mm/protocal/protobuf/gba
    //   916: dup
    //   917: invokespecial 1370	com/tencent/mm/protocal/protobuf/gba:<init>	()V
    //   920: aload_1
    //   921: invokevirtual 1371	com/tencent/mm/protocal/protobuf/gba:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   924: checkcast 1369	com/tencent/mm/protocal/protobuf/gba
    //   927: astore_1
    //   928: aload_1
    //   929: ifnull +17 -> 946
    //   932: aload_0
    //   933: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   936: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   939: getfield 1322	com/tencent/mm/plugin/voip/model/l:UyX	Lcom/tencent/mm/plugin/voip/model/w;
    //   942: aload_1
    //   943: invokevirtual 1374	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/gba;)V
    //   946: lload 12
    //   948: lstore 22
    //   950: lload 8
    //   952: lstore 12
    //   954: goto -588 -> 366
    //   957: astore_1
    //   958: ldc_w 266
    //   961: aload_1
    //   962: ldc_w 647
    //   965: iconst_0
    //   966: anewarray 4	java/lang/Object
    //   969: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   972: aconst_null
    //   973: astore_1
    //   974: goto -46 -> 928
    //   977: ldc_w 266
    //   980: new 290	java/lang/StringBuilder
    //   983: dup
    //   984: ldc_w 1376
    //   987: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   990: aload_1
    //   991: getfield 1354	com/tencent/mm/protocal/protobuf/gbh:vhJ	I
    //   994: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   997: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1003: lload 12
    //   1005: lstore 22
    //   1007: lload 8
    //   1009: lstore 12
    //   1011: goto -645 -> 366
    //   1014: ldc_w 266
    //   1017: new 290	java/lang/StringBuilder
    //   1020: dup
    //   1021: ldc_w 1378
    //   1024: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1027: aload 25
    //   1029: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   1032: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1035: ldc_w 1380
    //   1038: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: lload 16
    //   1043: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1046: ldc_w 1318
    //   1049: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1055: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1058: lload 12
    //   1060: lstore 22
    //   1062: lload 8
    //   1064: lstore 12
    //   1066: goto -700 -> 366
    //   1069: ldc_w 266
    //   1072: ldc_w 1363
    //   1075: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: lload 10
    //   1080: lstore 22
    //   1082: lload 8
    //   1084: lstore 12
    //   1086: goto -720 -> 366
    //   1089: aload 25
    //   1091: getfield 1285	com/tencent/mm/protocal/protobuf/gal:Zmc	I
    //   1094: iconst_3
    //   1095: if_icmpne +445 -> 1540
    //   1098: new 1294	com/tencent/mm/protocal/protobuf/gol
    //   1101: dup
    //   1102: invokespecial 1381	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   1105: aload 25
    //   1107: getfield 1292	com/tencent/mm/protocal/protobuf/gal:YLa	Lcom/tencent/mm/protocal/protobuf/gol;
    //   1110: getfield 1298	com/tencent/mm/protocal/protobuf/gol:aaxD	Lcom/tencent/mm/bx/b;
    //   1113: getfield 1303	com/tencent/mm/bx/b:Op	[B
    //   1116: invokevirtual 1385	com/tencent/mm/protocal/protobuf/gol:dg	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   1119: astore_1
    //   1120: aload_1
    //   1121: ifnull +419 -> 1540
    //   1124: lload 6
    //   1126: aload 25
    //   1128: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   1131: i2l
    //   1132: lcmp
    //   1133: ifge +400 -> 1533
    //   1136: aload 25
    //   1138: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   1141: i2l
    //   1142: lstore 20
    //   1144: lload 20
    //   1146: lstore 6
    //   1148: lload 10
    //   1150: lstore 22
    //   1152: lload 8
    //   1154: lstore 12
    //   1156: aload 25
    //   1158: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   1161: i2l
    //   1162: lload 14
    //   1164: lcmp
    //   1165: ifle -799 -> 366
    //   1168: ldc_w 266
    //   1171: new 290	java/lang/StringBuilder
    //   1174: dup
    //   1175: ldc_w 1387
    //   1178: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1181: aload 25
    //   1183: getfield 1310	com/tencent/mm/protocal/protobuf/gal:OzG	I
    //   1186: invokevirtual 672	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: ldc_w 1389
    //   1192: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: lload 14
    //   1197: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1200: ldc_w 1318
    //   1203: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload_0
    //   1213: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   1216: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   1219: getfield 1322	com/tencent/mm/plugin/voip/model/l:UyX	Lcom/tencent/mm/plugin/voip/model/w;
    //   1222: aload_1
    //   1223: invokevirtual 1392	com/tencent/mm/plugin/voip/model/w:c	(Lcom/tencent/mm/protocal/protobuf/gol;)V
    //   1226: lload 20
    //   1228: lstore 6
    //   1230: lload 10
    //   1232: lstore 22
    //   1234: lload 8
    //   1236: lstore 12
    //   1238: aload_0
    //   1239: getfield 140	com/tencent/mm/plugin/voip/model/u:UBX	Lcom/tencent/mm/protocal/protobuf/gaq;
    //   1242: ifnull -876 -> 366
    //   1245: lload 20
    //   1247: lstore 6
    //   1249: lload 10
    //   1251: lstore 22
    //   1253: lload 8
    //   1255: lstore 12
    //   1257: aload_1
    //   1258: getfield 1298	com/tencent/mm/protocal/protobuf/gol:aaxD	Lcom/tencent/mm/bx/b;
    //   1261: invokevirtual 1367	com/tencent/mm/bx/b:toByteArray	()[B
    //   1264: invokestatic 1396	com/tencent/mm/plugin/voip/f/g:cI	([B)I
    //   1267: sipush 255
    //   1270: iand
    //   1271: iconst_1
    //   1272: if_icmpne -906 -> 366
    //   1275: aload_0
    //   1276: getfield 140	com/tencent/mm/plugin/voip/model/u:UBX	Lcom/tencent/mm/protocal/protobuf/gaq;
    //   1279: iconst_1
    //   1280: putfield 450	com/tencent/mm/protocal/protobuf/gaq:abXQ	I
    //   1283: lload 20
    //   1285: lstore 6
    //   1287: lload 10
    //   1289: lstore 22
    //   1291: lload 8
    //   1293: lstore 12
    //   1295: goto -929 -> 366
    //   1298: astore_1
    //   1299: ldc_w 266
    //   1302: aload_1
    //   1303: ldc_w 647
    //   1306: iconst_0
    //   1307: anewarray 4	java/lang/Object
    //   1310: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1313: aconst_null
    //   1314: astore_1
    //   1315: goto -195 -> 1120
    //   1318: lload 8
    //   1320: lload 18
    //   1322: lcmp
    //   1323: ifle +203 -> 1526
    //   1326: lload 10
    //   1328: lload 16
    //   1330: lcmp
    //   1331: ifle +188 -> 1519
    //   1334: lload 6
    //   1336: lload 14
    //   1338: lcmp
    //   1339: ifle +173 -> 1512
    //   1342: new 115	java/util/HashMap
    //   1345: dup
    //   1346: invokespecial 116	java/util/HashMap:<init>	()V
    //   1349: astore_1
    //   1350: aload_1
    //   1351: iconst_1
    //   1352: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1355: lload 8
    //   1357: invokestatic 682	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1360: invokeinterface 686 3 0
    //   1365: pop
    //   1366: aload_1
    //   1367: iconst_2
    //   1368: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1371: lload 10
    //   1373: invokestatic 682	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1376: invokeinterface 686 3 0
    //   1381: pop
    //   1382: aload_1
    //   1383: iconst_3
    //   1384: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1387: lload 6
    //   1389: invokestatic 682	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1392: invokeinterface 686 3 0
    //   1397: pop
    //   1398: aload_1
    //   1399: invokestatic 1398	com/tencent/mm/plugin/voip/model/u:bh	(Ljava/util/Map;)[B
    //   1402: astore_1
    //   1403: iload_2
    //   1404: aload_0
    //   1405: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   1408: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   1411: getfield 232	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1414: getfield 539	com/tencent/mm/plugin/voip/model/v2protocal:roomId	I
    //   1417: if_icmpne +78 -> 1495
    //   1420: lload_3
    //   1421: aload_0
    //   1422: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   1425: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   1428: getfield 232	com/tencent/mm/plugin/voip/model/l:UyU	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1431: getfield 542	com/tencent/mm/plugin/voip/model/v2protocal:Hnt	J
    //   1434: lcmp
    //   1435: ifne +60 -> 1495
    //   1438: aload_0
    //   1439: getfield 190	com/tencent/mm/plugin/voip/model/u:UBE	Lcom/tencent/mm/plugin/voip/model/v;
    //   1442: getfield 226	com/tencent/mm/plugin/voip/model/v:UvO	Lcom/tencent/mm/plugin/voip/model/l;
    //   1445: aload_1
    //   1446: putfield 1261	com/tencent/mm/plugin/voip/model/l:UyY	[B
    //   1449: ldc_w 266
    //   1452: new 290	java/lang/StringBuilder
    //   1455: dup
    //   1456: ldc_w 1400
    //   1459: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1462: lload 8
    //   1464: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1467: ldc_w 1402
    //   1470: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: lload 10
    //   1475: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1478: ldc_w 1402
    //   1481: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: lload 6
    //   1486: invokevirtual 1108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1495: ldc_w 266
    //   1498: ldc_w 1404
    //   1501: invokestatic 533	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1504: ldc_w 1256
    //   1507: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1510: iconst_0
    //   1511: ireturn
    //   1512: lload 14
    //   1514: lstore 6
    //   1516: goto -174 -> 1342
    //   1519: lload 16
    //   1521: lstore 10
    //   1523: goto -189 -> 1334
    //   1526: lload 18
    //   1528: lstore 8
    //   1530: goto -204 -> 1326
    //   1533: lload 6
    //   1535: lstore 20
    //   1537: goto -393 -> 1144
    //   1540: lload 10
    //   1542: lstore 22
    //   1544: lload 8
    //   1546: lstore 12
    //   1548: goto -1182 -> 366
    //   1551: lload 6
    //   1553: lstore 14
    //   1555: goto -1493 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1558	0	this	u
    //   0	1558	1	paramArrayOfByte	byte[]
    //   0	1558	2	paramInt	int
    //   0	1558	3	paramLong	long
    //   125	246	5	i	int
    //   129	1423	6	l1	long
    //   13	1532	8	l2	long
    //   16	1525	10	l3	long
    //   19	1528	12	l4	long
    //   60	1494	14	l5	long
    //   10	1510	16	l6	long
    //   7	1520	18	l7	long
    //   1142	394	20	l8	long
    //   364	1179	22	l9	long
    //   43	380	24	localObject1	Object
    //   539	6	24	localException	Exception
    //   560	27	24	str	String
    //   157	1025	25	localObject2	Object
    //   420	62	26	localInteger	Integer
    //   434	96	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   108	124	539	java/lang/Exception
    //   195	220	605	java/io/IOException
    //   663	688	831	java/io/IOException
    //   913	928	957	java/io/IOException
    //   1098	1120	1298	java/io/IOException
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(293372);
    this.UBE.b(paramContext, paramx);
    AppMethodBeat.o(293372);
  }
  
  public final void bh(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(115121);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293312);
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!com.tencent.mm.k.h.aQH())
        {
          MMApplicationContext.getContext();
          if (!u.hYI())
          {
            Log.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
            AppMethodBeat.o(293312);
            return;
          }
        }
        if (u.this.UBE.hYK())
        {
          Log.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
          if ((u.this.UBE.UvO.UyU.roomId != paramInt) && (u.this.UBE.UvO.UyU.Hnt != paramLong))
          {
            Log.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(u.this.UBE.UvO.UyU.roomId), Long.valueOf(u.this.UBE.UvO.UyU.Hnt) });
            u.this.UBE.a(paramInt, paramLong, 2, null, null, u.b(u.this));
          }
          AppMethodBeat.o(293312);
          return;
        }
        new e(paramInt, paramLong, "").hYW();
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!u.c(u.this))
        {
          g.c(paramInt, paramLong, 1, 2);
          u.d(u.this);
        }
        AppMethodBeat.o(293312);
      }
    });
    AppMethodBeat.o(115121);
  }
  
  public final void bp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115116);
    this.UBU = paramBoolean1;
    this.UBV = paramBoolean2;
    Log.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(115116);
  }
  
  public final int bq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115129);
    int i = this.UBE.bq(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(115129);
    return i;
  }
  
  public final void c(gaq paramgaq)
  {
    AppMethodBeat.i(115122);
    if (this.UBE.UvO.UyU.UFO != 0)
    {
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", new Object[] { Integer.valueOf(paramgaq.Zvz), Integer.valueOf(paramgaq.abXQ), Integer.valueOf(this.UBE.UvO.UyU.roomId), Integer.valueOf(this.UBE.UvO.UyU.UFO) });
      AppMethodBeat.o(115122);
      return;
    }
    int j = paramgaq.abXQ;
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySa, false);
    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", new Object[] { Boolean.valueOf(bool) });
    int i = -1;
    if (bool) {
      i = b(paramgaq);
    }
    long l;
    if (i == 1)
    {
      this.UBE.a(paramgaq.Zvz, paramgaq.ZvA, 5, null, null, paramgaq.abXZ);
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", new Object[] { Integer.valueOf(paramgaq.Zvz), Integer.valueOf(paramgaq.abXQ), Integer.valueOf(j) });
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!com.tencent.mm.k.h.aQH())
    {
      MMApplicationContext.getContext();
      if (!AppForegroundDelegate.heY.eLx)
      {
        Log.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if ((this.UBX == null) && (this.LoP.stopped()))
        {
          Log.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
          this.UBX = paramgaq;
          this.LoP.startTimer(2000L);
          this.UBY = System.currentTimeMillis();
          Log.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(this.UBX.Zvz), Long.valueOf(this.UBX.ZvA), Integer.valueOf(this.UBX.CreateTime) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 4L, 1L, false);
          g.arb(0);
        }
        AppMethodBeat.o(115122);
        return;
      }
    }
    Object localObject1 = paramgaq.abXZ;
    Object localObject2 = z.bAM();
    i = paramgaq.abXQ;
    Log.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", new Object[] { localObject2, localObject1, Integer.valueOf(i), Integer.valueOf(paramgaq.Zvz), Long.valueOf(paramgaq.ZvA), Integer.valueOf(paramgaq.CreateTime) });
    if ((this.UBE.hWB()) && (!this.UBE.UCw))
    {
      this.UBE.a(paramgaq.Zvz, paramgaq.ZvA, 2, null, null, (String)localObject1);
      Log.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramgaq.Zvz);
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      j = paramgaq.abXQ;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(7) });
      g.arb(0);
      AppMethodBeat.o(115122);
      return;
    }
    if (v.hYM())
    {
      this.UBE.a(paramgaq.Zvz, paramgaq.ZvA, 3, null, null, (String)localObject1);
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramgaq.Zvz);
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      j = paramgaq.abXQ;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(7) });
      g.arb(0);
      AppMethodBeat.o(115122);
      return;
    }
    this.UBE.hYN();
    if (this.UBE.UCy)
    {
      if (this.UBE.UvO.UyU.roomId != paramgaq.Zvz)
      {
        this.UBE.UvO.Uyu = true;
        this.UBE.UvO.Uyw = false;
        this.UBE.UvO.Uyv = false;
        this.UBE.UvO.UyU.UEB = 0;
        this.UBE.UvO.UyU.UEA = 0;
        this.UBE.UvO.setStatus(3);
        this.UBE.UvO.UyU.roomId = paramgaq.Zvz;
        this.UBE.UvO.UyU.Hnt = paramgaq.ZvA;
        this.UBE.UvO.UyU.JHb = 1;
        this.UBE.UvO.UyV.VT(i);
      }
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", new Object[] { Integer.valueOf(this.UBE.UvO.UyU.roomId), Integer.valueOf(paramgaq.Zvz) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!this.UBE.a(paramgaq))
    {
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      j = paramgaq.abXQ;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(5), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(7) });
      g.arb(0);
      AppMethodBeat.o(115122);
      return;
    }
    localObject2 = MMApplicationContext.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1) == null)
    {
      this.UBE.a(paramgaq.Zvz, paramgaq.ZvA, 4, null, null, (String)localObject1);
      Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramgaq.Zvz);
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      j = paramgaq.abXQ;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(4), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(7) });
      g.arb(0);
      AppMethodBeat.o(115122);
      return;
    }
    if ((1 == i) || (i == 0)) {}
    for (;;)
    {
      try
      {
        l = this.UBE.UvO.UyU.Hnt;
        if (i != 0) {
          continue;
        }
        bool = true;
        a((Context)localObject2, (String)localObject1, l, false, bool, true);
        if (this.UBE != null) {
          this.UBE.aqw(paramgaq.Zvz);
        }
        Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        g.arb(2);
        continue;
      }
      this.UBE.a(paramgaq.Zvz, paramgaq.ZvA, 1, this.UBE.UvO.UyU.field_peerId, this.UBE.UvO.UyU.field_capInfo, (String)localObject1);
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      i = paramgaq.Zvz;
      l = paramgaq.ZvA;
      j = paramgaq.abXQ;
      MMApplicationContext.getContext();
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11525, true, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(1), Integer.valueOf(g.ibq()), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
      bool = false;
    }
  }
  
  public final void ch(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115117);
    Log.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.UBK < 2000L) && (System.currentTimeMillis() - this.UBK > 0L)))
    {
      AppMethodBeat.o(115117);
      return;
    }
    if ((System.currentTimeMillis() - this.UBN < this.UBO) && (System.currentTimeMillis() - this.UBN > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.k.a(paramContext, b.g.voip_server_not_available, b.g.voip_warnning_title, null);
      AppMethodBeat.o(115117);
      return;
    }
    this.UBK = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString) == null)
    {
      AppMethodBeat.o(115117);
      return;
    }
    a(paramContext, paramString, this.UBE.UvO.UyU.Hnt, true, false, false);
    hYl();
    AppMethodBeat.o(115117);
  }
  
  public final void ci(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115118);
    Log.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.UBK < 2000L) && (System.currentTimeMillis() - this.UBK > 0L)))
    {
      AppMethodBeat.o(115118);
      return;
    }
    if ((System.currentTimeMillis() - this.UBN < this.UBO) && (System.currentTimeMillis() - this.UBN > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.k.a(paramContext, b.g.voip_server_not_available, b.g.voip_warnning_title, null);
      AppMethodBeat.o(115118);
      return;
    }
    this.UBK = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString) == null)
    {
      AppMethodBeat.o(115118);
      return;
    }
    a(paramContext, paramString, this.UBE.UvO.UyU.Hnt, true, true, false);
    hYl();
    AppMethodBeat.o(115118);
  }
  
  public final int d(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115132);
    paramInt1 = this.UBE.e(paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(115132);
    return paramInt1;
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(115115);
    Log.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.huY = paramBoolean1;
    if (paramBoolean2)
    {
      this.UBG = paramBoolean1;
      this.UBE.UvO.UyU.UDI = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.UBE.UvO.UyU.UFN.psF = paramString;
      AppMethodBeat.o(115115);
      return;
      this.UBE.UvO.UyU.UDI = 1;
      this.UBH = paramBoolean1;
    }
  }
  
  public final boolean dro()
  {
    return (this.UwR == null) || (!this.UwR.ULz);
  }
  
  public final void e(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(293443);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if ((com.tencent.mm.compatible.util.d.rb(26)) && (!this.wOe))
    {
      localObject = q.UBj;
      q.hXk();
      localObject = new Intent();
      ((Intent)localObject).putExtra("isRecalled", false);
      ((Intent)localObject).putExtra("Voip_User", paramString);
      ((Intent)localObject).putExtra("Voip_CallRoomKey", paramLong);
      ((Intent)localObject).putExtra("Voip_VideoCall", paramBoolean);
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
    }
    try
    {
      MMApplicationContext.getContext().startService((Intent)localObject);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
        try
        {
          MMApplicationContext.getContext().startForegroundService((Intent)localObject);
          paramString = q.UBj;
          q.hXm();
          i = 0;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      this.wOe = true;
      paramString = q.UBj;
      q.hXl();
    }
    AppMethodBeat.o(293443);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115114);
    if (this.UwR != null)
    {
      this.UwR.hVY();
      this.UwR.ged();
      this.UwR = null;
    }
    this.UBE.stop();
    this.UBE = null;
    this.UBI = false;
    this.UBJ = false;
    this.UBJ = false;
    com.tencent.mm.kernel.h.baD().b(this.mPf);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class)).b(2, this.ozF);
    super.finalize();
    AppMethodBeat.o(115114);
  }
  
  public final int gdZ()
  {
    AppMethodBeat.i(369830);
    int i = this.UBE.UvO.gdZ();
    AppMethodBeat.o(369830);
    return i;
  }
  
  public final void ggh()
  {
    AppMethodBeat.i(162308);
    this.UBP = null;
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(41);
    AppMethodBeat.o(162308);
  }
  
  public final long hVw()
  {
    return this.UBE.UvO.UyU.Hnt;
  }
  
  public final long hWC()
  {
    AppMethodBeat.i(369829);
    long l = this.UBE.UvO.hWC();
    AppMethodBeat.o(369829);
    return l;
  }
  
  public final void hYB()
  {
    AppMethodBeat.i(293462);
    Log.i("MicroMsg.Voip.VoipService", "cleanMgr");
    this.Uxh = 0L;
    this.UBF = null;
    this.UBQ = null;
    this.UBR = false;
    this.UBT = false;
    this.UBS = false;
    this.UBZ = false;
    if (this.UwR != null)
    {
      this.UwR.ged();
      this.UwR = null;
    }
    SubCoreVoip.hVq().jb(true);
    AppMethodBeat.o(293462);
  }
  
  public final void hYC()
  {
    AppMethodBeat.i(115149);
    this.UBE.UCF.startTimer(1000L);
    AppMethodBeat.o(115149);
  }
  
  public final void hYD()
  {
    AppMethodBeat.i(115152);
    this.UBE.UvO.UyW.hWY();
    AppMethodBeat.o(115152);
  }
  
  public final boolean hYE()
  {
    AppMethodBeat.i(293487);
    boolean bool = this.UBE.UvO.Uzi.hYj();
    AppMethodBeat.o(293487);
    return bool;
  }
  
  public final void hYF()
  {
    AppMethodBeat.i(293493);
    this.UBE.UvO.Uzi = new VoipScoreState();
    AppMethodBeat.o(293493);
  }
  
  public final VoipScoreState hYG()
  {
    return this.UBE.UvO.Uzi;
  }
  
  public final void hYm()
  {
    AppMethodBeat.i(293352);
    if ((this.UCc == null) || (this.UCc.isEmpty()))
    {
      AppMethodBeat.o(293352);
      return;
    }
    Iterator localIterator = this.UCc.iterator();
    while (localIterator.hasNext()) {
      if ((a)localIterator.next() != null)
      {
        AppMethodBeat.o(293352);
        throw null;
      }
    }
    AppMethodBeat.o(293352);
  }
  
  public final int hYn()
  {
    AppMethodBeat.i(293375);
    com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGF);
    int i = this.UBE.hYn();
    AppMethodBeat.o(293375);
    return i;
  }
  
  public final int hYo()
  {
    AppMethodBeat.i(293377);
    com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGL);
    int i = this.UBE.hYo();
    AppMethodBeat.o(293377);
    return i;
  }
  
  public final int hYp()
  {
    AppMethodBeat.i(293379);
    Object localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGF);
    localObject = com.tencent.mm.plugin.voip.d.i.UHA;
    com.tencent.mm.plugin.voip.d.i.iag();
    int i = this.UBE.hYp();
    AppMethodBeat.o(293379);
    return i;
  }
  
  public final int hYq()
  {
    AppMethodBeat.i(293382);
    this.UBE.hYq();
    AppMethodBeat.o(293382);
    return 0;
  }
  
  public final int hYr()
  {
    return this.UBE.UvO.UyU.roomId;
  }
  
  public final void hYs()
  {
    AppMethodBeat.i(293390);
    n localn = this.UBE.UvO.UyW;
    if (localn.wTG != null) {
      localn.wTG.eq(true);
    }
    AppMethodBeat.o(293390);
  }
  
  public final void hYt()
  {
    AppMethodBeat.i(293392);
    n localn = this.UBE.UvO.UyW;
    if (localn.wTG != null) {
      localn.wTG.eq(false);
    }
    AppMethodBeat.o(293392);
  }
  
  public final void hYu()
  {
    AppMethodBeat.i(115135);
    Log.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.UBE.UvO.UyU.UFN.UAt = 1;
    AppMethodBeat.o(115135);
  }
  
  public final int hYv()
  {
    return this.UBE.UvO.UyW.UvO.UyU.field_sendVideoLen;
  }
  
  public final int hYw()
  {
    return this.UBE.UvO.UyW.UvO.UyU.field_recvVideoLen;
  }
  
  public final byte[] hYx()
  {
    return this.UBE.UvO.UyU.UFg;
  }
  
  public final boolean hYy()
  {
    bool2 = false;
    AppMethodBeat.i(115143);
    bool1 = bool2;
    try
    {
      if (this.UBE.UvO.UyU != null)
      {
        int i = this.UBE.UvO.UyU.UEG;
        bool1 = bool2;
        if ((i & 0x8) != 0) {
          bool1 = true;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(115143);
    return bool1;
  }
  
  public final void hYz()
  {
    AppMethodBeat.i(293438);
    u.b localb = this.UBP;
    if (localb != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "resetFullscreenIntent ");
      String str = this.UBE.toUser;
      boolean bool1 = this.UBE.OEa;
      boolean bool2 = this.UBE.UvH;
      long l = localb.Hnt;
      ggh();
      a(MMApplicationContext.getContext(), str, l, bool1, bool2, true);
      AppMethodBeat.o(293438);
      return;
    }
    Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
    AppMethodBeat.o(293438);
  }
  
  public final int mC(int paramInt1, int paramInt2)
  {
    n localn = this.UBE.UvO.UyW;
    localn.UvO.UyU.UFe = paramInt1;
    localn.UvO.UyU.UFf = paramInt2;
    return 0;
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(115142);
    Log.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
    this.UCb = true;
    com.tencent.mm.plugin.voip.d.d locald = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.hZO();
    com.tencent.threadpool.h.ahAA.bk(new u.5(this));
    this.UBI = false;
    this.UBJ = false;
    this.UBJ = false;
    this.UxU = 0L;
    hYA();
    ggh();
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
    AppMethodBeat.o(115142);
  }
  
  public final void yQ(boolean paramBoolean)
  {
    AppMethodBeat.i(115153);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.UBE.UvO.UyU.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.cTQ()) {
        this.UBE.UvO.UyU.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.cTX()) {
        break label164;
      }
      this.UBE.UvO.UyU.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(115153);
      return;
    }
    this.UBE.UvO.UyU.setAppCmd(441, arrayOfByte, 1);
    this.UBE.UvO.UyU.setAppCmd(442, arrayOfByte, 1);
    label164:
    AppMethodBeat.o(115153);
  }
  
  public final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */