package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.efv;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.io.IOException;
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
  private static final f<Integer, p.a> gAU;
  private p FPE;
  public String GUy;
  public v GYS;
  public com.tencent.mm.plugin.voip.a GYT;
  public boolean GYU;
  public boolean GYV;
  public boolean GYW;
  private long GYX;
  public Map<Integer, Long> GYY;
  public int GYZ;
  public long GZa;
  public long GZb;
  public volatile b GZc;
  private Point GZd;
  public boolean GZe;
  boolean GZf;
  boolean GZg;
  public boolean GZh;
  public boolean GZi;
  private boolean GZj;
  public ett GZk;
  public long GZl;
  public boolean GZm;
  private a.a GZn;
  List<a> GZo;
  public HashMap<Long, Boolean> GZp;
  public boolean dya;
  public String talker;
  public MTimerHandler zNd;
  
  static
  {
    AppMethodBeat.i(115155);
    gAU = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(115155);
  }
  
  public u()
  {
    AppMethodBeat.i(115113);
    this.dya = false;
    this.GYU = false;
    this.GYV = false;
    this.GYW = false;
    this.talker = null;
    this.GYX = 0L;
    this.GYY = new HashMap();
    this.GYZ = -1;
    this.GZa = 0L;
    this.GZb = 0L;
    this.GZe = false;
    this.GZf = false;
    this.GZg = false;
    this.GZh = false;
    this.GZi = false;
    this.GZj = false;
    this.GZk = null;
    this.GZl = 0L;
    this.GUy = null;
    this.GZm = false;
    this.FPE = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(115109);
        Log.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        l locall;
        if ((u.a(u.this)) && (paramAnonymousInt == 4))
        {
          locall = u.this.GYS.GSZ;
          if (locall.GWg == 0) {
            locall.GWg = locall.GVV.Hau;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
          if (paramAnonymousInt != locall.GWg) {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + locall.GWg + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locall.GVV.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locall.GVV.ypO + ", roomkey=" + locall.GVV.ypH + "]");
          }
          epd localepd = new epd();
          localepd.NmY = 3;
          localepd.NmZ = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locall.GVV.SendRUDP(localepd.toByteArray(), localepd.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
          }
        }
        locall.GWg = paramAnonymousInt;
        u.this.GYS.fIz();
        AppMethodBeat.o(115109);
      }
    };
    this.GZn = new a.a()
    {
      public final void gX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(235666);
        Log.d("MicroMsg.Voip.VoipService", "simtype " + paramAnonymousInt1 + " reason " + paramAnonymousInt2);
        if ((paramAnonymousInt2 == 3) && (paramAnonymousInt1 == 1))
        {
          paramAnonymousInt1 = u.this.GYS.GSZ.GVV.handleCommand(2, null, 0);
          if (paramAnonymousInt1 < 0) {
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipService", "v2protocal handlecommand failed ret:".concat(String.valueOf(paramAnonymousInt1)));
          }
        }
        AppMethodBeat.o(235666);
      }
    };
    this.zNd = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(235668);
        Log.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (u.e(u.this) == null)
        {
          u.f(u.this);
          u.g(u.this).stopTimer();
          AppMethodBeat.o(235668);
          return false;
        }
        if (u.hB(MMApplicationContext.getContext()))
        {
          u.this.aN(u.e(u.this).LsZ, u.e(u.this).Lta);
          Log.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(u.e(u.this).LsZ), Long.valueOf(u.e(u.this).Lta), Integer.valueOf(u.e(u.this).CreateTime) });
          u.this.c(u.e(u.this));
          u.h(u.this);
          u.f(u.this);
          u.g(u.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 5L, 1L, false);
          AppMethodBeat.o(235668);
          return false;
        }
        if (System.currentTimeMillis() - u.i(u.this) < 60000L)
        {
          AppMethodBeat.o(235668);
          return true;
        }
        u.h(u.this);
        u.f(u.this);
        u.g(u.this).stopTimer();
        AppMethodBeat.o(235668);
        return false;
      }
    }, true);
    this.GZo = null;
    this.GZp = new HashMap();
    this.GYS = new v();
    this.dya = false;
    this.GYU = false;
    this.GYV = false;
    this.talker = null;
    this.GYW = false;
    this.GUy = null;
    com.tencent.mm.kernel.g.aAg().a(this.FPE);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).a(this.GZn);
    AppMethodBeat.o(115113);
  }
  
  public static p.a aUy(String paramString)
  {
    AppMethodBeat.i(115124);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    int i = paramString.hashCode();
    p.a locala = (p.a)gAU.get(Integer.valueOf(i));
    if (locala != null)
    {
      AppMethodBeat.o(115124);
      return locala;
    }
    locala = new p.a();
    if (!locala.parse(paramString))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    gAU.x(Integer.valueOf(i), locala);
    AppMethodBeat.o(115124);
    return locala;
  }
  
  private static byte[] aW(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(115126);
    efv localefv = new efv();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      cgg localcgg = new cgg();
      localcgg.Cya = localInteger.intValue();
      localcgg.MlT = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localcgg);
    }
    localefv.MXV = localLinkedList;
    localefv.MXU = localLinkedList.size();
    try
    {
      paramMap = localefv.toByteArray();
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
  
  public static byte[] ae(byte[] paramArrayOfByte, int paramInt)
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
  
  private int b(ett paramett)
  {
    int j = -1;
    boolean bool1 = true;
    AppMethodBeat.i(115120);
    Object localObject = z.aTY();
    String str2;
    int i;
    String str1;
    if (paramett != null)
    {
      str2 = paramett.NqS;
      k = paramett.NqJ;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", new Object[] { Integer.valueOf(paramett.LsZ), localObject, str2, this.GYS.GZH, Integer.valueOf(k), Boolean.valueOf(this.GYS.fGt()), Boolean.valueOf(this.GYS.GSZ.fGr()), Boolean.valueOf(this.GYS.GZE) });
      i = j;
      if (!this.GYS.fGt()) {
        break label634;
      }
      i = j;
      if (this.GYS.GSZ == null) {
        break label634;
      }
      i = j;
      if (!this.GYS.GSZ.fGr()) {
        break label634;
      }
      i = j;
      if (this.GYS.GZE) {
        break label634;
      }
      str1 = this.GYS.GZH;
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
      this.GYS.GZE = true;
      i = str1.compareTo((String)localObject);
      boolean bool3 = str1.contains("@");
      if ((i < 0) || (bool3))
      {
        i = 1;
        localObject = this.GYS.GSZ.GVV;
        ((v2protocal)localObject).Hcx |= 0x2;
        if (!this.GYT.fEZ()) {
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
      if ((this.GYT.fEZ()) && (k == 1))
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        this.GYS.GZt = false;
        fIg();
        this.GYS.GSZ.GVW.acQ(1);
      }
      paramett.NqJ = k;
      this.GYS.GZF = k;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", new Object[] { str1, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i == 2)
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
        this.GYS.GZG = true;
        if ((this.GYS.GSZ.GVV != null) && (this.GYS.GSZ.GVV.roomId != 0) && (this.GYS.GSZ.GVV.ypH != 0L) && (this.GYS.GSZ.GVV.roomId != paramett.LsZ)) {
          b(this.GYS.GSZ.GVV.roomId, this.GYS.GSZ.GVV.ypH, j);
        }
        if (k == 0) {
          label625:
          this.GYT.wQ(bool1);
        }
      }
      for (;;)
      {
        label634:
        if (this.GYS.GZE) {
          paramett.NqJ = this.GYS.GZF;
        }
        AppMethodBeat.o(115120);
        return i;
        i = 2;
        break;
        j = 1;
        break label350;
        bool1 = false;
        break label625;
        this.GYS.GZG = false;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
        continue;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", new Object[] { str1, Boolean.valueOf(bool2) });
        i = j;
      }
    }
  }
  
  private static Map<Integer, Long> cl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115125);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(115125);
      return null;
    }
    try
    {
      paramArrayOfByte = (efv)new efv().parseFrom(paramArrayOfByte);
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
    Log.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.MXU);
    LinkedList localLinkedList = paramArrayOfByte.MXV;
    if (localLinkedList.size() != paramArrayOfByte.MXU)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.MXU)
    {
      localHashMap.put(Integer.valueOf(((cgg)localLinkedList.get(i)).Cya), Long.valueOf(0xFFFFFFFF & ((cgg)localLinkedList.get(i)).MlT));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.MXU)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    AppMethodBeat.o(115125);
    return localHashMap;
  }
  
  private static String cm(byte[] paramArrayOfByte)
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
  
  private static void fHR()
  {
    AppMethodBeat.i(115119);
    zj localzj = new zj();
    localzj.efx.dKy = 7;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(115119);
  }
  
  public static boolean fIa()
  {
    return v2protocal.Haq;
  }
  
  public static boolean fIb()
  {
    return v2protocal.Har;
  }
  
  private void fIh()
  {
    AppMethodBeat.i(115146);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    if (com.tencent.mm.compatible.util.d.oD(26)) {}
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
      MMApplicationContext.getContext().stopService((Intent)localObject);
      localObject = q.GXY;
      q.fHg();
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
      this.GZj = false;
    }
    AppMethodBeat.o(115146);
  }
  
  private static boolean isAppOnForeground(Context paramContext)
  {
    AppMethodBeat.i(115150);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      Log.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        Log.i("MicroMsg.Voip.VoipService", "is in backGround.");
        AppMethodBeat.o(115150);
        return false;
      }
    }
    if (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(115150);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    AppMethodBeat.o(115150);
    return true;
  }
  
  public static float xg(boolean paramBoolean)
  {
    AppMethodBeat.i(115148);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.c.fFg();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((u)localObject).GYS.GSZ.GVV.field_capInfo;
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
      localObject = ((u)localObject).GYS.GSZ.GVV.Hay;
    }
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(235679);
    n localn = this.GYS.GSZ.GVX;
    if (localn.qrL == n.qrK)
    {
      AppMethodBeat.o(235679);
      return -1;
    }
    if (!localn.GSZ.GVV.fIZ())
    {
      AppMethodBeat.o(235679);
      return -1;
    }
    if (!localn.GSZ.fGz())
    {
      AppMethodBeat.o(235679);
      return -2;
    }
    paramInt1 = localn.GSZ.GVV.videoRorate90D(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(235679);
    return paramInt1;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115136);
    n localn = this.GYS.GSZ.GVX;
    int i;
    if (localn.qrL == n.qrK)
    {
      i = 1;
      if (paramBoolean) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      if ((j & i) == 0) {
        break label68;
      }
      AppMethodBeat.o(115136);
      return -1;
      i = 0;
      break;
    }
    label68:
    if (!localn.GSZ.GVV.fIZ())
    {
      AppMethodBeat.o(115136);
      return -1;
    }
    paramInt1 = localn.GSZ.GVV.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
    AppMethodBeat.o(115136);
    return paramInt1;
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(235670);
    this.GYS.a(paramContext, paramx);
    AppMethodBeat.o(235670);
  }
  
  public final void a(Context paramContext, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(235686);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      this.GYS.toUser = paramString;
      this.GYS.GZs = paramBoolean1;
      this.GYS.GZt = paramBoolean2;
      enB();
      long l = System.currentTimeMillis();
      Object localObject1 = new kv();
      ((kv)localObject1).dPV.dPY = false;
      ((kv)localObject1).dPV.dPX = l;
      ((kv)localObject1).dPV.dPW = paramContext;
      EventCenter.instance.publish((IEvent)localObject1);
      Log.printInfoStack("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.djR.cPB) });
      int i;
      Intent localIntent;
      Object localObject2;
      if ((com.tencent.mm.compatible.util.d.oF(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        String str1 = null;
        localIntent = new Intent(paramContext, VideoActivity.class);
        localIntent.putExtra("Voip_User", paramString);
        localIntent.putExtra("Voip_Outcall", paramBoolean1);
        localIntent.putExtra("Voip_VideoCall", paramBoolean2);
        localIntent.putExtra("Voip_LastPage_Hash", l);
        localIntent.putExtra("Voip_CallRoomKey", paramLong);
        String str2 = "";
        localObject2 = str1;
        localObject1 = str2;
        if (!paramBoolean1)
        {
          localObject2 = str1;
          localObject1 = str2;
          if (i != 0)
          {
            localObject2 = str1;
            localObject1 = str2;
            if (!AppForegroundDelegate.djR.cPB)
            {
              this.GZc = new b(paramBoolean2, paramString, paramBoolean3, paramLong);
              str1 = aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localIntent.getStringExtra("Voip_User")).field_username);
              localObject2 = new RemoteViews(MMApplicationContext.getPackageName(), 2131496857);
              ((RemoteViews)localObject2).setTextViewText(2131305549, str1);
              if (!localIntent.getBooleanExtra("Voip_VideoCall", true)) {
                break label490;
              }
              localObject1 = MMApplicationContext.getResources().getString(2131767315);
              ((RemoteViews)localObject2).setTextViewText(2131305550, (CharSequence)localObject1);
              ((RemoteViews)localObject2).setImageViewResource(2131305544, 2131235402);
              label382:
              ((RemoteViews)localObject2).setImageViewResource(2131310423, 2131235720);
              localObject1 = str1 + (String)localObject1;
            }
          }
        }
        if (paramBoolean3)
        {
          localIntent.setFlags(603979776);
          localIntent.addFlags(268435456);
        }
        if (localObject2 != null) {
          break label525;
        }
        e(paramString, paramBoolean2, paramLong);
        paramString = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.fJV();
      }
      for (;;)
      {
        com.tencent.mm.util.a.a(paramContext, localIntent, (RemoteViews)localObject2, (String)localObject1, VideoActivity.class.getCanonicalName(), com.tencent.mm.bq.a.glD());
        AppMethodBeat.o(235686);
        return;
        i = 0;
        break;
        label490:
        localObject1 = MMApplicationContext.getResources().getString(2131767314);
        ((RemoteViews)localObject2).setTextViewText(2131305550, (CharSequence)localObject1);
        ((RemoteViews)localObject2).setImageViewResource(2131305544, 2131235444);
        break label382;
        label525:
        paramString = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.fJU();
      }
    }
  }
  
  public final void aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115116);
    this.GZh = paramBoolean1;
    this.GZi = paramBoolean2;
    Log.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(115116);
  }
  
  public final int aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115129);
    int i = this.GYS.aH(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(115129);
    return i;
  }
  
  public final void aN(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(115121);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235667);
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if ((!com.tencent.mm.n.g.apP()) && (!u.hB(MMApplicationContext.getContext())))
        {
          Log.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
          AppMethodBeat.o(235667);
          return;
        }
        if (u.this.GYS.fIq())
        {
          Log.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
          if ((u.this.GYS.GSZ.GVV.roomId != paramInt) && (u.this.GYS.GSZ.GVV.ypH != paramLong))
          {
            Log.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(u.this.GYS.GSZ.GVV.roomId), Long.valueOf(u.this.GYS.GSZ.GVV.ypH) });
            u.this.GYS.a(paramInt, paramLong, 2, null, null, u.b(u.this));
          }
          AppMethodBeat.o(235667);
          return;
        }
        new com.tencent.mm.plugin.voip.model.a.e(paramInt, paramLong, "").fII();
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!u.c(u.this))
        {
          com.tencent.mm.plugin.voip.b.e.c(paramInt, paramLong, 1, 2);
          u.d(u.this);
        }
        AppMethodBeat.o(235667);
      }
    });
    AppMethodBeat.o(115121);
  }
  
  public final int aUA(String paramString)
  {
    AppMethodBeat.i(235673);
    int i = this.GYS.fU(paramString, 0);
    AppMethodBeat.o(235673);
    return i;
  }
  
  public final int aUz(String paramString)
  {
    AppMethodBeat.i(235672);
    int i = this.GYS.fU(paramString, 1);
    AppMethodBeat.o(235672);
    return i;
  }
  
  public final void adf(int paramInt)
  {
    AppMethodBeat.i(115130);
    this.GYS.adf(paramInt);
    AppMethodBeat.o(115130);
  }
  
  public final void adh(int paramInt)
  {
    AppMethodBeat.i(115151);
    this.GYS.GSZ.adh(paramInt);
    AppMethodBeat.o(115151);
  }
  
  public final void adm(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(115123);
    if ((this.GZo == null) || (this.GZo.isEmpty()))
    {
      AppMethodBeat.o(115123);
      return;
    }
    Object localObject1 = this.GZo.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (a)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((a)localObject2).GZr != null))
      {
        this.GZp.put(Long.valueOf(this.GYS.GSZ.GVV.ypH), Boolean.TRUE);
        if (((a)localObject2).GZr.LsZ == paramInt)
        {
          ((a)localObject2).cancelled = true;
          localObject2 = this.GYS.toUser;
          if (this.GYS.GZt)
          {
            localObject1 = ca.OqC;
            if (!this.GYS.GZs) {
              break label189;
            }
          }
          label189:
          for (paramInt = i;; paramInt = 0)
          {
            s.c((String)localObject2, (String)localObject1, paramInt, 4, MMApplicationContext.getContext().getString(2131767235));
            AppMethodBeat.o(115123);
            return;
            localObject1 = ca.OqB;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(115123);
  }
  
  public final void adn(int paramInt)
  {
    AppMethodBeat.i(115134);
    Log.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.GYS.adn(paramInt);
    AppMethodBeat.o(115134);
  }
  
  public final void ado(int paramInt)
  {
    AppMethodBeat.i(115141);
    v localv = this.GYS;
    if (localv.qtg != null) {
      localv.qtg.g(2131689973, false, paramInt);
    }
    AppMethodBeat.o(115141);
  }
  
  public final void adp(int paramInt)
  {
    AppMethodBeat.i(235690);
    k localk = k.GVq;
    k.a(this.GYS.GSZ.GVV, paramInt);
    this.GYS.GSZ.GVV.fIQ();
    AppMethodBeat.o(235690);
  }
  
  public final void adq(int paramInt)
  {
    AppMethodBeat.i(235691);
    this.GYS.adq(paramInt);
    AppMethodBeat.o(235691);
  }
  
  public final int b(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115132);
    paramInt1 = this.GYS.c(paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(115132);
    return paramInt1;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 1030
    //   3: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   21: ldc_w 292
    //   24: ldc_w 1032
    //   27: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   34: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   37: getfield 1035	com/tencent/mm/plugin/voip/model/l:GVZ	[B
    //   40: invokestatic 1037	com/tencent/mm/plugin/voip/model/u:cl	([B)Ljava/util/Map;
    //   43: astore 24
    //   45: aload 24
    //   47: ifnonnull +333 -> 380
    //   50: ldc_w 292
    //   53: ldc_w 1039
    //   56: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: lconst_0
    //   60: lstore 14
    //   62: ldc_w 292
    //   65: new 454	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 1041
    //   72: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: lload 18
    //   77: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc_w 1046
    //   83: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload 16
    //   88: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: ldc_w 1048
    //   94: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: lload 14
    //   99: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: new 1050	com/tencent/mm/protocal/protobuf/etp
    //   111: dup
    //   112: invokespecial 1051	com/tencent/mm/protocal/protobuf/etp:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 1052	com/tencent/mm/protocal/protobuf/etp:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   119: checkcast 1050	com/tencent/mm/protocal/protobuf/etp
    //   122: astore 24
    //   124: iconst_0
    //   125: istore 5
    //   127: lload 12
    //   129: lstore 6
    //   131: iload 5
    //   133: aload 24
    //   135: getfield 1055	com/tencent/mm/protocal/protobuf/etp:NqL	Ljava/util/LinkedList;
    //   138: invokevirtual 283	java/util/LinkedList:size	()I
    //   141: if_icmpge +1167 -> 1308
    //   144: aload 24
    //   146: getfield 1055	com/tencent/mm/protocal/protobuf/etp:NqL	Ljava/util/LinkedList;
    //   149: iload 5
    //   151: invokevirtual 472	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   154: checkcast 1057	com/tencent/mm/protocal/protobuf/eto
    //   157: astore 25
    //   159: ldc_w 292
    //   162: new 454	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 1059
    //   169: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 25
    //   174: getfield 1062	com/tencent/mm/protocal/protobuf/eto:Lms	I
    //   177: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 25
    //   188: getfield 1062	com/tencent/mm/protocal/protobuf/eto:Lms	I
    //   191: iconst_1
    //   192: if_icmpne +458 -> 650
    //   195: new 1064	com/tencent/mm/protocal/protobuf/euv
    //   198: dup
    //   199: invokespecial 1065	com/tencent/mm/protocal/protobuf/euv:<init>	()V
    //   202: aload 25
    //   204: getfield 1069	com/tencent/mm/protocal/protobuf/eto:KMS	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   207: invokevirtual 1074	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   210: invokevirtual 1075	com/tencent/mm/protocal/protobuf/euv:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   213: checkcast 1064	com/tencent/mm/protocal/protobuf/euv
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +412 -> 630
    //   221: ldc_w 292
    //   224: new 454	java/lang/StringBuilder
    //   227: dup
    //   228: ldc_w 1077
    //   231: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: getfield 1080	com/tencent/mm/protocal/protobuf/euv:oTW	I
    //   238: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: lload 8
    //   249: lstore 12
    //   251: lload 8
    //   253: aload 25
    //   255: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   258: i2l
    //   259: lcmp
    //   260: ifge +11 -> 271
    //   263: aload 25
    //   265: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   268: i2l
    //   269: lstore 12
    //   271: lload 12
    //   273: lstore 8
    //   275: aload 25
    //   277: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   280: i2l
    //   281: lload 18
    //   283: lcmp
    //   284: ifle +355 -> 639
    //   287: ldc_w 292
    //   290: new 454	java/lang/StringBuilder
    //   293: dup
    //   294: ldc_w 1083
    //   297: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: aload 25
    //   302: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   305: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 1085
    //   311: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 18
    //   316: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc_w 1087
    //   322: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: getfield 1080	com/tencent/mm/protocal/protobuf/euv:oTW	I
    //   329: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 1089
    //   335: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   348: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   351: getfield 1093	com/tencent/mm/plugin/voip/model/l:GVY	Lcom/tencent/mm/plugin/voip/model/w;
    //   354: aload_1
    //   355: iconst_1
    //   356: invokevirtual 1098	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/euv;I)V
    //   359: lload 10
    //   361: lstore 22
    //   363: iload 5
    //   365: iconst_1
    //   366: iadd
    //   367: istore 5
    //   369: lload 22
    //   371: lstore 10
    //   373: lload 12
    //   375: lstore 8
    //   377: goto -246 -> 131
    //   380: aload 24
    //   382: invokeinterface 240 1 0
    //   387: invokeinterface 246 1 0
    //   392: astore 25
    //   394: lconst_0
    //   395: lstore 6
    //   397: aload 25
    //   399: invokeinterface 252 1 0
    //   404: ifeq +1137 -> 1541
    //   407: aload 25
    //   409: invokeinterface 256 1 0
    //   414: checkcast 202	java/lang/Integer
    //   417: astore 26
    //   419: aload 24
    //   421: aload 26
    //   423: invokeinterface 266 2 0
    //   428: checkcast 268	java/lang/Long
    //   431: astore 27
    //   433: aload 26
    //   435: invokevirtual 262	java/lang/Integer:intValue	()I
    //   438: tableswitch	default:+26 -> 464, 1:+67->505, 2:+77->515, 3:+87->525
    //   465: aconst_null
    //   466: fload_2
    //   467: new 454	java/lang/StringBuilder
    //   470: dup
    //   471: ldc_w 1100
    //   474: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: aload 26
    //   479: invokevirtual 262	java/lang/Integer:intValue	()I
    //   482: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   485: ldc_w 1102
    //   488: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 27
    //   493: invokevirtual 1105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -105 -> 397
    //   505: aload 27
    //   507: invokevirtual 1108	java/lang/Long:longValue	()J
    //   510: lstore 18
    //   512: goto -115 -> 397
    //   515: aload 27
    //   517: invokevirtual 1108	java/lang/Long:longValue	()J
    //   520: lstore 16
    //   522: goto -125 -> 397
    //   525: aload 27
    //   527: invokevirtual 1108	java/lang/Long:longValue	()J
    //   530: lstore 6
    //   532: goto -135 -> 397
    //   535: astore 24
    //   537: ldc_w 292
    //   540: aload 24
    //   542: ldc_w 294
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: aload_1
    //   553: invokestatic 1110	com/tencent/mm/plugin/voip/model/u:cm	([B)Ljava/lang/String;
    //   556: astore 24
    //   558: ldc_w 292
    //   561: new 454	java/lang/StringBuilder
    //   564: dup
    //   565: ldc_w 1112
    //   568: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   571: aload_1
    //   572: arraylength
    //   573: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: ldc_w 1114
    //   579: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 24
    //   584: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc_w 1030
    //   596: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: iconst_0
    //   600: ireturn
    //   601: astore_1
    //   602: ldc_w 292
    //   605: ldc_w 1116
    //   608: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: ldc_w 292
    //   614: aload_1
    //   615: ldc_w 294
    //   618: iconst_0
    //   619: anewarray 4	java/lang/Object
    //   622: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   625: aconst_null
    //   626: astore_1
    //   627: goto -410 -> 217
    //   630: ldc_w 292
    //   633: ldc_w 1116
    //   636: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: lload 10
    //   641: lstore 22
    //   643: lload 8
    //   645: lstore 12
    //   647: goto -284 -> 363
    //   650: aload 25
    //   652: getfield 1062	com/tencent/mm/protocal/protobuf/eto:Lms	I
    //   655: iconst_2
    //   656: if_icmpne +426 -> 1082
    //   659: new 1118	com/tencent/mm/protocal/protobuf/euk
    //   662: dup
    //   663: invokespecial 1119	com/tencent/mm/protocal/protobuf/euk:<init>	()V
    //   666: aload 25
    //   668: getfield 1069	com/tencent/mm/protocal/protobuf/eto:KMS	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   671: invokevirtual 1074	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   674: invokevirtual 1120	com/tencent/mm/protocal/protobuf/euk:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   677: checkcast 1118	com/tencent/mm/protocal/protobuf/euk
    //   680: astore_1
    //   681: aload_1
    //   682: ifnull +380 -> 1062
    //   685: ldc_w 292
    //   688: new 454	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 1122
    //   695: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload_1
    //   699: getfield 1125	com/tencent/mm/protocal/protobuf/euk:oUv	I
    //   702: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   705: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: lload 10
    //   713: lstore 12
    //   715: lload 10
    //   717: aload 25
    //   719: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   722: i2l
    //   723: lcmp
    //   724: ifge +11 -> 735
    //   727: aload 25
    //   729: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   732: i2l
    //   733: lstore 12
    //   735: aload 25
    //   737: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   740: i2l
    //   741: lload 16
    //   743: lcmp
    //   744: ifle +263 -> 1007
    //   747: ldc_w 292
    //   750: new 454	java/lang/StringBuilder
    //   753: dup
    //   754: ldc_w 1127
    //   757: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   760: aload 25
    //   762: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   765: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   768: ldc_w 1129
    //   771: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: lload 16
    //   776: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   779: ldc_w 1089
    //   782: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload_1
    //   792: getfield 1125	com/tencent/mm/protocal/protobuf/euk:oUv	I
    //   795: iconst_5
    //   796: if_icmpne +57 -> 853
    //   799: aload_0
    //   800: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   803: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   806: getfield 1093	com/tencent/mm/plugin/voip/model/l:GVY	Lcom/tencent/mm/plugin/voip/model/w;
    //   809: aload_1
    //   810: invokevirtual 1132	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/euk;)V
    //   813: lload 12
    //   815: lstore 22
    //   817: lload 8
    //   819: lstore 12
    //   821: goto -458 -> 363
    //   824: astore_1
    //   825: ldc_w 292
    //   828: ldc_w 1134
    //   831: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: ldc_w 292
    //   837: aload_1
    //   838: ldc_w 294
    //   841: iconst_0
    //   842: anewarray 4	java/lang/Object
    //   845: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   848: aconst_null
    //   849: astore_1
    //   850: goto -169 -> 681
    //   853: aload_1
    //   854: getfield 1125	com/tencent/mm/protocal/protobuf/euk:oUv	I
    //   857: iconst_1
    //   858: if_icmpne +28 -> 886
    //   861: aload_0
    //   862: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   865: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   868: getfield 1093	com/tencent/mm/plugin/voip/model/l:GVY	Lcom/tencent/mm/plugin/voip/model/w;
    //   871: aload_1
    //   872: invokevirtual 1136	com/tencent/mm/plugin/voip/model/w:b	(Lcom/tencent/mm/protocal/protobuf/euk;)V
    //   875: lload 12
    //   877: lstore 22
    //   879: lload 8
    //   881: lstore 12
    //   883: goto -520 -> 363
    //   886: aload_1
    //   887: getfield 1125	com/tencent/mm/protocal/protobuf/euk:oUv	I
    //   890: bipush 6
    //   892: if_icmpne +78 -> 970
    //   895: aload_1
    //   896: getfield 1137	com/tencent/mm/protocal/protobuf/euk:KMS	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   899: invokevirtual 1141	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   902: invokevirtual 1144	com/tencent/mm/bw/b:toByteArray	()[B
    //   905: astore_1
    //   906: new 1146	com/tencent/mm/protocal/protobuf/eud
    //   909: dup
    //   910: invokespecial 1147	com/tencent/mm/protocal/protobuf/eud:<init>	()V
    //   913: aload_1
    //   914: invokevirtual 1148	com/tencent/mm/protocal/protobuf/eud:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   917: checkcast 1146	com/tencent/mm/protocal/protobuf/eud
    //   920: astore_1
    //   921: aload_1
    //   922: ifnull +17 -> 939
    //   925: aload_0
    //   926: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   929: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   932: getfield 1093	com/tencent/mm/plugin/voip/model/l:GVY	Lcom/tencent/mm/plugin/voip/model/w;
    //   935: aload_1
    //   936: invokevirtual 1151	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/eud;)V
    //   939: lload 12
    //   941: lstore 22
    //   943: lload 8
    //   945: lstore 12
    //   947: goto -584 -> 363
    //   950: astore_1
    //   951: ldc_w 292
    //   954: aload_1
    //   955: ldc_w 294
    //   958: iconst_0
    //   959: anewarray 4	java/lang/Object
    //   962: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   965: aconst_null
    //   966: astore_1
    //   967: goto -46 -> 921
    //   970: ldc_w 292
    //   973: new 454	java/lang/StringBuilder
    //   976: dup
    //   977: ldc_w 1153
    //   980: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   983: aload_1
    //   984: getfield 1125	com/tencent/mm/protocal/protobuf/euk:oUv	I
    //   987: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   990: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: lload 12
    //   998: lstore 22
    //   1000: lload 8
    //   1002: lstore 12
    //   1004: goto -641 -> 363
    //   1007: ldc_w 292
    //   1010: new 454	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc_w 1155
    //   1017: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1020: aload 25
    //   1022: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   1025: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: ldc_w 1157
    //   1031: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: lload 16
    //   1036: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1039: ldc_w 1089
    //   1042: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: lload 12
    //   1053: lstore 22
    //   1055: lload 8
    //   1057: lstore 12
    //   1059: goto -696 -> 363
    //   1062: ldc_w 292
    //   1065: ldc_w 1134
    //   1068: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1071: lload 10
    //   1073: lstore 22
    //   1075: lload 8
    //   1077: lstore 12
    //   1079: goto -716 -> 363
    //   1082: aload 25
    //   1084: getfield 1062	com/tencent/mm/protocal/protobuf/eto:Lms	I
    //   1087: iconst_3
    //   1088: if_icmpne +442 -> 1530
    //   1091: new 1071	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1094: dup
    //   1095: invokespecial 1158	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1098: aload 25
    //   1100: getfield 1069	com/tencent/mm/protocal/protobuf/eto:KMS	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1103: invokevirtual 1074	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   1106: invokevirtual 1161	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:parseFrom	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1109: astore_1
    //   1110: aload_1
    //   1111: ifnull +419 -> 1530
    //   1114: lload 6
    //   1116: aload 25
    //   1118: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   1121: i2l
    //   1122: lcmp
    //   1123: ifge +400 -> 1523
    //   1126: aload 25
    //   1128: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   1131: i2l
    //   1132: lstore 20
    //   1134: lload 20
    //   1136: lstore 6
    //   1138: lload 10
    //   1140: lstore 22
    //   1142: lload 8
    //   1144: lstore 12
    //   1146: aload 25
    //   1148: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   1151: i2l
    //   1152: lload 14
    //   1154: lcmp
    //   1155: ifle -792 -> 363
    //   1158: ldc_w 292
    //   1161: new 454	java/lang/StringBuilder
    //   1164: dup
    //   1165: ldc_w 1163
    //   1168: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1171: aload 25
    //   1173: getfield 1081	com/tencent/mm/protocal/protobuf/eto:Cya	I
    //   1176: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1179: ldc_w 1165
    //   1182: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: lload 14
    //   1187: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1190: ldc_w 1089
    //   1193: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1202: aload_0
    //   1203: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   1206: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   1209: getfield 1093	com/tencent/mm/plugin/voip/model/l:GVY	Lcom/tencent/mm/plugin/voip/model/w;
    //   1212: aload_1
    //   1213: invokevirtual 1168	com/tencent/mm/plugin/voip/model/w:c	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)V
    //   1216: lload 20
    //   1218: lstore 6
    //   1220: lload 10
    //   1222: lstore 22
    //   1224: lload 8
    //   1226: lstore 12
    //   1228: aload_0
    //   1229: getfield 130	com/tencent/mm/plugin/voip/model/u:GZk	Lcom/tencent/mm/protocal/protobuf/ett;
    //   1232: ifnull -869 -> 363
    //   1235: lload 20
    //   1237: lstore 6
    //   1239: lload 10
    //   1241: lstore 22
    //   1243: lload 8
    //   1245: lstore 12
    //   1247: aload_1
    //   1248: invokevirtual 1141	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   1251: invokevirtual 1144	com/tencent/mm/bw/b:toByteArray	()[B
    //   1254: invokestatic 1174	com/tencent/mm/plugin/voip/b/e:co	([B)I
    //   1257: sipush 255
    //   1260: iand
    //   1261: iconst_1
    //   1262: if_icmpne -899 -> 363
    //   1265: aload_0
    //   1266: getfield 130	com/tencent/mm/plugin/voip/model/u:GZk	Lcom/tencent/mm/protocal/protobuf/ett;
    //   1269: iconst_1
    //   1270: putfield 320	com/tencent/mm/protocal/protobuf/ett:NqJ	I
    //   1273: lload 20
    //   1275: lstore 6
    //   1277: lload 10
    //   1279: lstore 22
    //   1281: lload 8
    //   1283: lstore 12
    //   1285: goto -922 -> 363
    //   1288: astore_1
    //   1289: ldc_w 292
    //   1292: aload_1
    //   1293: ldc_w 294
    //   1296: iconst_0
    //   1297: anewarray 4	java/lang/Object
    //   1300: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: aconst_null
    //   1304: astore_1
    //   1305: goto -195 -> 1110
    //   1308: lload 8
    //   1310: lload 18
    //   1312: lcmp
    //   1313: ifle +203 -> 1516
    //   1316: lload 10
    //   1318: lload 16
    //   1320: lcmp
    //   1321: ifle +188 -> 1509
    //   1324: lload 6
    //   1326: lload 14
    //   1328: lcmp
    //   1329: ifle +173 -> 1502
    //   1332: new 107	java/util/HashMap
    //   1335: dup
    //   1336: invokespecial 108	java/util/HashMap:<init>	()V
    //   1339: astore_1
    //   1340: aload_1
    //   1341: iconst_1
    //   1342: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1345: lload 8
    //   1347: invokestatic 477	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1350: invokeinterface 481 3 0
    //   1355: pop
    //   1356: aload_1
    //   1357: iconst_2
    //   1358: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1361: lload 10
    //   1363: invokestatic 477	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1366: invokeinterface 481 3 0
    //   1371: pop
    //   1372: aload_1
    //   1373: iconst_3
    //   1374: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1377: lload 6
    //   1379: invokestatic 477	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1382: invokeinterface 481 3 0
    //   1387: pop
    //   1388: aload_1
    //   1389: invokestatic 1176	com/tencent/mm/plugin/voip/model/u:aW	(Ljava/util/Map;)[B
    //   1392: astore_1
    //   1393: iload_2
    //   1394: aload_0
    //   1395: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   1398: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   1401: getfield 376	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1404: getfield 421	com/tencent/mm/plugin/voip/model/v2protocal:roomId	I
    //   1407: if_icmpne +78 -> 1485
    //   1410: lload_3
    //   1411: aload_0
    //   1412: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   1415: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   1418: getfield 376	com/tencent/mm/plugin/voip/model/l:GVV	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1421: getfield 424	com/tencent/mm/plugin/voip/model/v2protocal:ypH	J
    //   1424: lcmp
    //   1425: ifne +60 -> 1485
    //   1428: aload_0
    //   1429: getfield 167	com/tencent/mm/plugin/voip/model/u:GYS	Lcom/tencent/mm/plugin/voip/model/v;
    //   1432: getfield 340	com/tencent/mm/plugin/voip/model/v:GSZ	Lcom/tencent/mm/plugin/voip/model/l;
    //   1435: aload_1
    //   1436: putfield 1035	com/tencent/mm/plugin/voip/model/l:GVZ	[B
    //   1439: ldc_w 292
    //   1442: new 454	java/lang/StringBuilder
    //   1445: dup
    //   1446: ldc_w 1178
    //   1449: invokespecial 459	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1452: lload 8
    //   1454: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1457: ldc_w 1180
    //   1460: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: lload 10
    //   1465: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1468: ldc_w 1180
    //   1471: invokevirtual 503	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: lload 6
    //   1476: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1479: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1485: ldc_w 292
    //   1488: ldc_w 1182
    //   1491: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1494: ldc_w 1030
    //   1497: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1500: iconst_0
    //   1501: ireturn
    //   1502: lload 14
    //   1504: lstore 6
    //   1506: goto -174 -> 1332
    //   1509: lload 16
    //   1511: lstore 10
    //   1513: goto -189 -> 1324
    //   1516: lload 18
    //   1518: lstore 8
    //   1520: goto -204 -> 1316
    //   1523: lload 6
    //   1525: lstore 20
    //   1527: goto -393 -> 1134
    //   1530: lload 10
    //   1532: lstore 22
    //   1534: lload 8
    //   1536: lstore 12
    //   1538: goto -1175 -> 363
    //   1541: lload 6
    //   1543: lstore 14
    //   1545: goto -1483 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1548	0	this	u
    //   0	1548	1	paramArrayOfByte	byte[]
    //   0	1548	2	paramInt	int
    //   0	1548	3	paramLong	long
    //   125	243	5	i	int
    //   129	1413	6	l1	long
    //   13	1522	8	l2	long
    //   16	1515	10	l3	long
    //   19	1518	12	l4	long
    //   60	1484	14	l5	long
    //   10	1500	16	l6	long
    //   7	1510	18	l7	long
    //   1132	394	20	l8	long
    //   361	1172	22	l9	long
    //   43	377	24	localObject1	Object
    //   535	6	24	localException	Exception
    //   556	27	24	str	String
    //   157	1015	25	localObject2	Object
    //   417	61	26	localInteger	Integer
    //   431	95	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   108	124	535	java/lang/Exception
    //   195	217	601	java/io/IOException
    //   659	681	824	java/io/IOException
    //   906	921	950	java/io/IOException
    //   1091	1110	1288	java/io/IOException
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(235671);
    this.GYS.b(paramContext, paramx);
    AppMethodBeat.o(235671);
  }
  
  public final void bL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115117);
    Log.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.GYX < 2000L) && (System.currentTimeMillis() - this.GYX > 0L)))
    {
      AppMethodBeat.o(115117);
      return;
    }
    if ((System.currentTimeMillis() - this.GZa < this.GZb) && (System.currentTimeMillis() - this.GZa > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131767357, 2131767391, null);
      AppMethodBeat.o(115117);
      return;
    }
    this.GYX = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString) == null)
    {
      AppMethodBeat.o(115117);
      return;
    }
    a(paramContext, paramString, this.GYS.GSZ.GVV.ypH, true, false, false);
    fHR();
    AppMethodBeat.o(115117);
  }
  
  public final void bM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115118);
    Log.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.GYX < 2000L) && (System.currentTimeMillis() - this.GYX > 0L)))
    {
      AppMethodBeat.o(115118);
      return;
    }
    if ((System.currentTimeMillis() - this.GZa < this.GZb) && (System.currentTimeMillis() - this.GZa > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131767357, 2131767391, null);
      AppMethodBeat.o(115118);
      return;
    }
    this.GYX = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString) == null)
    {
      AppMethodBeat.o(115118);
      return;
    }
    a(paramContext, paramString, this.GYS.GSZ.GVV.ypH, true, true, false);
    fHR();
    AppMethodBeat.o(115118);
  }
  
  public final int bhV()
  {
    AppMethodBeat.i(185953);
    n localn = this.GYS.GSZ.GVX;
    if (localn.GWB != null)
    {
      int i = localn.GWB.bhV();
      AppMethodBeat.o(185953);
      return i;
    }
    AppMethodBeat.o(185953);
    return 0;
  }
  
  public final void bk(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115140);
    v localv = this.GYS;
    if (localv.qtg != null) {
      localv.qtg.bl(paramInt, paramBoolean);
    }
    AppMethodBeat.o(115140);
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(235682);
    paramInt1 = this.GYS.c(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(235682);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235680);
    paramInt1 = this.GYS.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(235680);
    return paramInt1;
  }
  
  public final void c(ett paramett)
  {
    AppMethodBeat.i(115122);
    if (this.GYS.GSZ.GVV.Hcx != 0)
    {
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", new Object[] { Integer.valueOf(paramett.LsZ), Integer.valueOf(paramett.NqJ), Integer.valueOf(this.GYS.GSZ.GVV.roomId), Integer.valueOf(this.GYS.GSZ.GVV.Hcx) });
      AppMethodBeat.o(115122);
      return;
    }
    int j = paramett.NqJ;
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWO, false);
    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", new Object[] { Boolean.valueOf(bool) });
    int i = -1;
    if (bool) {
      i = b(paramett);
    }
    if (i == 1)
    {
      this.GYS.a(paramett.LsZ, paramett.Lta, 5, null, null, paramett.NqS);
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", new Object[] { Integer.valueOf(paramett.LsZ), Integer.valueOf(paramett.NqJ), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
    if ((!com.tencent.mm.n.g.apP()) && (!isAppOnForeground(MMApplicationContext.getContext())))
    {
      Log.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.GZk == null) && (this.zNd.stopped()))
      {
        Log.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.GZk = paramett;
        this.zNd.startTimer(2000L);
        this.GZl = System.currentTimeMillis();
        Log.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(this.GZk.LsZ), Long.valueOf(this.GZk.Lta), Integer.valueOf(this.GZk.CreateTime) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 4L, 1L, false);
        com.tencent.mm.plugin.voip.b.e.adG(0);
      }
      AppMethodBeat.o(115122);
      return;
    }
    String str = paramett.NqS;
    Object localObject = z.aTY();
    i = paramett.NqJ;
    Log.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", new Object[] { localObject, str, Integer.valueOf(i), Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.CreateTime) });
    if ((this.GYS.fGt()) && (!this.GYS.GZE))
    {
      this.GYS.a(paramett.LsZ, paramett.Lta, 2, null, null, str);
      Log.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramett.LsZ);
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.e.adG(0);
      AppMethodBeat.o(115122);
      return;
    }
    if (v.fIs())
    {
      this.GYS.a(paramett.LsZ, paramett.Lta, 3, null, null, str);
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramett.LsZ);
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.e.adG(0);
      AppMethodBeat.o(115122);
      return;
    }
    this.GYS.fIt();
    if (this.GYS.GZG)
    {
      if (this.GYS.GSZ.GVV.roomId != paramett.LsZ)
      {
        this.GYS.GSZ.GVv = true;
        this.GYS.GSZ.GVx = false;
        this.GYS.GSZ.GVw = false;
        this.GYS.GSZ.GVV.Hbk = 0;
        this.GYS.GSZ.GVV.Hbj = 0;
        this.GYS.GSZ.setStatus(3);
        this.GYS.GSZ.GVV.roomId = paramett.LsZ;
        this.GYS.GSZ.GVV.ypH = paramett.Lta;
        this.GYS.GSZ.GVV.ypO = 1;
        this.GYS.GSZ.GVW.acS(i);
      }
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", new Object[] { Integer.valueOf(this.GYS.GSZ.GVV.roomId), Integer.valueOf(paramett.LsZ) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!this.GYS.a(paramett))
    {
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.e.adG(0);
      AppMethodBeat.o(115122);
      return;
    }
    localObject = MMApplicationContext.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str) == null)
    {
      this.GYS.a(paramett.LsZ, paramett.Lta, 4, null, null, str);
      Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramett.LsZ);
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.e.adG(0);
      AppMethodBeat.o(115122);
      return;
    }
    if ((1 == i) || (i == 0)) {}
    for (;;)
    {
      try
      {
        long l = this.GYS.GSZ.GVV.ypH;
        if (i != 0) {
          continue;
        }
        bool = true;
        a((Context)localObject, str, l, false, bool, true);
        if (this.GYS != null) {
          this.GYS.ads(paramett.LsZ);
        }
        Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.e.adG(2);
        continue;
      }
      this.GYS.a(paramett.LsZ, paramett.Lta, 1, this.GYS.GSZ.GVV.field_peerId, this.GYS.GSZ.GVV.field_capInfo, str);
      com.tencent.mm.plugin.report.service.h.CyF.a(11525, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
      bool = false;
    }
  }
  
  public final boolean czl()
  {
    AppMethodBeat.i(258475);
    boolean bool = this.GYS.czl();
    AppMethodBeat.o(258475);
    return bool;
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(115115);
    Log.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.dya = paramBoolean1;
    if (paramBoolean2)
    {
      this.GYU = paramBoolean1;
      this.GYS.GSZ.GVV.HaK = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.GYS.GSZ.GVV.Hcw.jHj = paramString;
      AppMethodBeat.o(115115);
      return;
      this.GYS.GSZ.GVV.HaK = 1;
      this.GYV = paramBoolean1;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(235688);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if ((com.tencent.mm.compatible.util.d.oD(26)) && (!this.GZj))
    {
      localObject = q.GXY;
      q.fHa();
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
          paramString = q.GXY;
          q.fHc();
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
      this.GZj = true;
      paramString = q.GXY;
      q.fHb();
    }
    AppMethodBeat.o(235688);
  }
  
  public final void enB()
  {
    AppMethodBeat.i(162308);
    this.GZc = null;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162308);
  }
  
  public final long fGu()
  {
    AppMethodBeat.i(258473);
    long l = this.GYS.GSZ.fGu();
    AppMethodBeat.o(258473);
    return l;
  }
  
  public final int fHS()
  {
    AppMethodBeat.i(235674);
    this.GYS.fHS();
    AppMethodBeat.o(235674);
    return 0;
  }
  
  public final int fHT()
  {
    AppMethodBeat.i(235675);
    this.GYS.fHT();
    AppMethodBeat.o(235675);
    return 0;
  }
  
  public final int fHU()
  {
    return this.GYS.GSZ.GVV.roomId;
  }
  
  public final long fHV()
  {
    return this.GYS.GSZ.GVV.ypH;
  }
  
  public final void fHW()
  {
    AppMethodBeat.i(235677);
    n localn = this.GYS.GSZ.GVX;
    if (localn.qrH != null) {
      localn.qrH.de(true);
    }
    AppMethodBeat.o(235677);
  }
  
  public final void fHX()
  {
    AppMethodBeat.i(235678);
    n localn = this.GYS.GSZ.GVX;
    if (localn.qrH != null) {
      localn.qrH.de(false);
    }
    AppMethodBeat.o(235678);
  }
  
  public final void fHY()
  {
    AppMethodBeat.i(115135);
    Log.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.GYS.GSZ.GVV.Hcw.GXo = 1;
    AppMethodBeat.o(115135);
  }
  
  public final void fHZ()
  {
    AppMethodBeat.i(235681);
    Object localObject = this.GYS.GSZ.GVX;
    if ((((n)localObject).GSZ != null) && (((n)localObject).GSZ.GVV != null))
    {
      byte[] arrayOfByte = new byte[4];
      if (((n)localObject).GSZ.GVV.setAppCmd(n.GTO, arrayOfByte, 4) >= 0)
      {
        int i = Util.byteArrayToInt(arrayOfByte);
        int k = i >> 16;
        int m = i & 0xFFFF;
        int j = k;
        i = m;
        if (!v2protocal.Haq) {
          if (k < 1280)
          {
            j = k;
            i = m;
            if (m < 1280) {}
          }
          else
          {
            j = k >> 1;
            i = m >> 1;
          }
        }
        localObject = com.tencent.mm.plugin.voip.b.c.HgQ;
        com.tencent.mm.plugin.voip.b.c.ec(j, i);
      }
      AppMethodBeat.o(235681);
      return;
    }
    localObject = com.tencent.mm.plugin.voip.b.c.HgQ;
    com.tencent.mm.plugin.voip.b.c.clear();
    AppMethodBeat.o(235681);
  }
  
  public final int fIc()
  {
    return this.GYS.GSZ.GVX.GSZ.GVV.field_sendVideoLen;
  }
  
  public final int fId()
  {
    return this.GYS.GSZ.GVX.GSZ.GVV.field_recvVideoLen;
  }
  
  public final byte[] fIe()
  {
    return this.GYS.GSZ.GVV.HbP;
  }
  
  public final boolean fIf()
  {
    bool2 = false;
    AppMethodBeat.i(115143);
    bool1 = bool2;
    try
    {
      if (this.GYS.GSZ.GVV != null)
      {
        int i = this.GYS.GSZ.GVV.Hbp;
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
  
  public final void fIg()
  {
    AppMethodBeat.i(235687);
    b localb = this.GZc;
    if (localb != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "resetFullscreenIntent ");
      String str = this.GYS.toUser;
      boolean bool1 = this.GYS.GZs;
      boolean bool2 = this.GYS.GZt;
      long l = localb.ypH;
      enB();
      a(MMApplicationContext.getContext(), str, l, bool1, bool2, true);
      AppMethodBeat.o(235687);
      return;
    }
    Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
    AppMethodBeat.o(235687);
  }
  
  public final void fIi()
  {
    AppMethodBeat.i(235689);
    this.GYT = null;
    this.GZd = null;
    this.GZe = false;
    this.GZg = false;
    this.GZf = false;
    this.GZm = false;
    com.tencent.mm.plugin.voip.c.fFh().rX(true);
    AppMethodBeat.o(235689);
  }
  
  public final void fIj()
  {
    AppMethodBeat.i(115149);
    this.GYS.GZL.startTimer(1000L);
    AppMethodBeat.o(115149);
  }
  
  public final int fIk()
  {
    return this.GYS.GSZ.GVV.HaJ;
  }
  
  public final void fIl()
  {
    AppMethodBeat.i(115152);
    this.GYS.GSZ.GVX.fGP();
    AppMethodBeat.o(115152);
  }
  
  public final boolean fIm()
  {
    AppMethodBeat.i(235692);
    boolean bool = this.GYS.GSZ.GWj.fHP();
    AppMethodBeat.o(235692);
    return bool;
  }
  
  public final void fIn()
  {
    AppMethodBeat.i(235693);
    this.GYS.GSZ.GWj = new VoipScoreState();
    AppMethodBeat.o(235693);
  }
  
  public final VoipScoreState fIo()
  {
    return this.GYS.GSZ.GWj;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115114);
    this.GYS.stop();
    this.GYS = null;
    this.GYW = false;
    com.tencent.mm.kernel.g.aAg().b(this.FPE);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).b(this.GZn);
    super.finalize();
    AppMethodBeat.o(115114);
  }
  
  public final int jB(int paramInt1, int paramInt2)
  {
    n localn = this.GYS.GSZ.GVX;
    localn.GSZ.GVV.HbN = paramInt1;
    localn.GSZ.GVV.HbO = paramInt2;
    return 0;
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(115153);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.GYS.GSZ.GVV.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.cdW()) {
        this.GYS.GSZ.GVV.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
        break label164;
      }
      this.GYS.GSZ.GVV.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(115153);
      return;
    }
    this.GYS.GSZ.GVV.setAppCmd(441, arrayOfByte, 1);
    this.GYS.GSZ.GVV.setAppCmd(442, arrayOfByte, 1);
    label164:
    AppMethodBeat.o(115153);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(258474);
    this.GYS.stopRing();
    AppMethodBeat.o(258474);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(115142);
    Log.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
    this.GYW = false;
    fIh();
    enB();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    AppMethodBeat.o(115142);
  }
  
  public final boolean wS(boolean paramBoolean)
  {
    AppMethodBeat.i(115137);
    n localn = this.GYS.GSZ.GVX;
    if (localn.GWB != null)
    {
      paramBoolean = localn.GWB.wS(paramBoolean);
      AppMethodBeat.o(115137);
      return paramBoolean;
    }
    AppMethodBeat.o(115137);
    return false;
  }
  
  public final int xd(boolean paramBoolean)
  {
    AppMethodBeat.i(115138);
    l locall = this.GYS.GSZ;
    if (paramBoolean) {}
    for (int i = locall.GVV.setAppCmd(412);; i = locall.GVV.setAppCmd(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115138);
      return i;
    }
  }
  
  public final int xe(boolean paramBoolean)
  {
    AppMethodBeat.i(115139);
    l locall = this.GYS.GSZ;
    if (paramBoolean) {}
    for (int i = locall.GVV.setAppCmd(401);; i = locall.GVV.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115139);
      return i;
    }
  }
  
  public final void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(235685);
    v localv = this.GYS;
    if (localv.qtg != null) {
      localv.qtg.xw(paramBoolean);
    }
    AppMethodBeat.o(235685);
  }
  
  public final class a
  {
    ett GZr;
    boolean cancelled;
  }
  
  public final class b
  {
    public boolean GZs = false;
    public boolean GZt;
    private boolean GZu;
    public String toUser;
    public long ypH;
    
    public b(boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong)
    {
      this.GZt = paramBoolean1;
      this.toUser = paramString;
      this.GZu = paramBoolean2;
      this.ypH = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */