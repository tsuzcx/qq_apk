package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.widget.VoipCallingService;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class t
{
  private static final com.tencent.mm.a.f<Integer, o.a> eka;
  public boolean cif;
  private boolean oTB;
  public ap oTJ;
  private n qwx;
  public String talker;
  public String txI;
  public u tyR;
  public VoipMgr tyS;
  public boolean tyT;
  public boolean tyU;
  private long tyV;
  public Map<Integer, Long> tyW;
  public int tyX;
  public long tyY;
  public long tyZ;
  public Point tza;
  public boolean tzb;
  public boolean tzc;
  public boolean tzd;
  public csp tze;
  public long tzf;
  public boolean tzg;
  List<t.a> tzh;
  
  static
  {
    AppMethodBeat.i(4642);
    eka = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(4642);
  }
  
  public t()
  {
    AppMethodBeat.i(4605);
    this.cif = false;
    this.tyT = false;
    this.tyU = false;
    this.talker = null;
    this.tyV = 0L;
    this.tyW = new HashMap();
    this.tyX = -1;
    this.tyY = 0L;
    this.tyZ = 0L;
    this.oTB = false;
    this.tzb = false;
    this.tzc = false;
    this.tzd = false;
    this.tze = null;
    this.tzf = 0L;
    this.txI = null;
    this.tzg = false;
    this.qwx = new t.1(this);
    this.oTJ = new ap(Looper.getMainLooper(), new t.3(this), true);
    this.tzh = null;
    this.tyR = new u();
    this.cif = false;
    this.tyT = false;
    this.tyU = false;
    this.talker = null;
    this.txI = null;
    com.tencent.mm.kernel.g.RK().a(this.qwx);
    AppMethodBeat.o(4605);
  }
  
  public static byte[] T(byte[] paramArrayOfByte, int paramInt)
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
  
  public static o.a aeF(String paramString)
  {
    AppMethodBeat.i(4615);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(4615);
      return null;
    }
    int i = paramString.hashCode();
    o.a locala = (o.a)eka.get(Integer.valueOf(i));
    if (locala != null)
    {
      AppMethodBeat.o(4615);
      return locala;
    }
    locala = new o.a();
    if (!locala.parse(paramString))
    {
      AppMethodBeat.o(4615);
      return null;
    }
    eka.f(Integer.valueOf(i), locala);
    AppMethodBeat.o(4615);
    return locala;
  }
  
  private static byte[] ai(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(4617);
    cja localcja = new cja();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      azb localazb = new azb();
      localazb.qsk = localInteger.intValue();
      localazb.xoy = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localazb);
    }
    localcja.xNc = localLinkedList;
    localcja.xNb = localLinkedList.size();
    try
    {
      paramMap = localcja.toByteArray();
      AppMethodBeat.o(4617);
      return paramMap;
    }
    catch (IOException paramMap)
    {
      ab.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
      AppMethodBeat.o(4617);
    }
    return null;
  }
  
  private static void bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140164);
    ab.b("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if (d.fv(26))
    {
      localObject = p.twZ;
      p.cMA();
      localObject = new Intent();
      ((Intent)localObject).putExtra("Voip_User", paramString);
      ((Intent)localObject).putExtra("Voip_VideoCall", paramBoolean);
      ((Intent)localObject).setClass(ah.getContext(), VoipForegroundService.class);
    }
    try
    {
      ah.getContext().startService((Intent)localObject);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
        try
        {
          ah.getContext().startForegroundService((Intent)localObject);
          paramString = p.twZ;
          p.cMC();
          i = 0;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      paramString = p.twZ;
      p.cMB();
    }
    AppMethodBeat.o(140164);
  }
  
  private static Map<Integer, Long> bu(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4616);
    if (bo.ce(paramArrayOfByte))
    {
      AppMethodBeat.o(4616);
      return null;
    }
    try
    {
      paramArrayOfByte = (cja)new cja().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(4616);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(4616);
      return null;
    }
    ab.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.xNb);
    LinkedList localLinkedList = paramArrayOfByte.xNc;
    if (localLinkedList.size() != paramArrayOfByte.xNb)
    {
      AppMethodBeat.o(4616);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.xNb)
    {
      localHashMap.put(Integer.valueOf(((azb)localLinkedList.get(i)).qsk), Long.valueOf(0xFFFFFFFF & ((azb)localLinkedList.get(i)).xoy));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.xNb)
    {
      AppMethodBeat.o(4616);
      return null;
    }
    AppMethodBeat.o(4616);
    return localHashMap;
  }
  
  private static String bv(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4618);
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
    AppMethodBeat.o(4618);
    return str1;
  }
  
  private static void cNS()
  {
    AppMethodBeat.i(4611);
    ux localux = new ux();
    localux.cLs.cut = 7;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(4611);
  }
  
  static void cNY()
  {
    AppMethodBeat.i(140165);
    ab.b("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    try
    {
      if (d.fv(26))
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClass(ah.getContext(), VoipForegroundService.class);
        ah.getContext().stopService((Intent)localObject);
        localObject = p.twZ;
        p.cMG();
      }
      AppMethodBeat.o(140165);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Voip.VoipService", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(140165);
    }
  }
  
  private static boolean eD(Context paramContext)
  {
    AppMethodBeat.i(4637);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ab.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ab.i("MicroMsg.Voip.VoipService", "is in backGround.");
        AppMethodBeat.o(4637);
        return false;
      }
    }
    if (((KeyguardManager)ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(4637);
      return false;
    }
    ab.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    AppMethodBeat.o(4637);
    return true;
  }
  
  public static float mW(boolean paramBoolean)
  {
    AppMethodBeat.i(4635);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.b.cLC();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((t)localObject).tyR.ttm.tvj.field_capInfo;
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
          ab.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ab.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(4635);
      return f2;
      f2 = f1;
      localObject = ((t)localObject).tyR.ttm.tvj.tAd;
    }
  }
  
  public final void HA(int paramInt)
  {
    AppMethodBeat.i(4631);
    this.tyR.HA(paramInt);
    AppMethodBeat.o(4631);
  }
  
  public final void Hk(int paramInt)
  {
    AppMethodBeat.i(4621);
    this.tyR.Hk(paramInt);
    AppMethodBeat.o(4621);
  }
  
  public final void Hm(int paramInt)
  {
    AppMethodBeat.i(4638);
    this.tyR.ttm.Hm(paramInt);
    AppMethodBeat.o(4638);
  }
  
  public final void Hy(int paramInt)
  {
    AppMethodBeat.i(4614);
    if ((this.tzh == null) || (this.tzh.isEmpty()))
    {
      AppMethodBeat.o(4614);
      return;
    }
    Iterator localIterator = this.tzh.iterator();
    while (localIterator.hasNext())
    {
      t.a locala = (t.a)localIterator.next();
      if ((locala != null) && (locala.tzj != null) && (locala.tzj.wQP == paramInt))
      {
        locala.cancelled = true;
        AppMethodBeat.o(4614);
        return;
      }
    }
    AppMethodBeat.o(4614);
  }
  
  public final void Hz(int paramInt)
  {
    AppMethodBeat.i(4624);
    ab.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.tyR.Hz(paramInt);
    AppMethodBeat.o(4624);
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4608);
    this.tzc = paramBoolean1;
    this.tzd = paramBoolean2;
    ab.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(4608);
  }
  
  public final int T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4620);
    int i = this.tyR.T(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(4620);
    return i;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4626);
    m localm = this.tyR.ttm.tvl;
    int i;
    if (localm.kJF == m.kJE)
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
      AppMethodBeat.o(4626);
      return -1;
      i = 0;
      break;
    }
    label68:
    if (!localm.ttm.tvj.cOG())
    {
      AppMethodBeat.o(4626);
      return -1;
    }
    paramInt1 = localm.ttm.tvj.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
    AppMethodBeat.o(4626);
    return paramInt1;
  }
  
  public final VoipMgr a(Context paramContext, PString paramPString, PBool paramPBool1, PBool paramPBool2, PInt paramPInt)
  {
    AppMethodBeat.i(4634);
    if (this.tyS != null)
    {
      ab.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
      paramPString.value = this.tyS.eaX;
      paramPBool1.value = this.tyS.txk;
      paramPBool2.value = this.tyS.txl;
      paramPInt.value = this.tyS.txa.mState;
      paramContext = this.tyS;
      AppMethodBeat.o(4634);
      return paramContext;
    }
    if (paramPString.value == null)
    {
      ab.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
      AppMethodBeat.o(4634);
      return null;
    }
    if ((!paramPBool1.value) && (!this.tyR.cMa()))
    {
      ab.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
      paramPString = paramPString.value;
      if (paramPBool2.value)
      {
        paramContext = bi.yOc;
        if (!paramPBool1.value) {
          break label191;
        }
      }
      label191:
      for (i = 1;; i = 0)
      {
        r.a(paramPString, paramContext, i, 4, ah.getContext().getString(2131304621));
        AppMethodBeat.o(4634);
        return null;
        paramContext = bi.yOb;
        break;
      }
    }
    this.tyS = new VoipMgr();
    paramPInt = this.tyS;
    paramPString = paramPString.value;
    boolean bool2 = paramPBool1.value;
    boolean bool3 = paramPBool2.value;
    ab.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramPString, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    paramPInt.txE = true;
    paramPInt.eaX = paramPString;
    paramPInt.txk = bool2;
    paramPInt.txl = bool3;
    paramPInt.txj = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramPInt.eaX);
    paramPInt.iMP = new ak(Looper.getMainLooper());
    paramPInt.txL = 0;
    paramPInt.txM = 0;
    boolean bool1;
    int j;
    if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      paramPInt.txm = bool1;
      if (!paramPInt.txl) {
        paramPInt.txm = false;
      }
      j = com.tencent.mm.plugin.voip.a.b.V(bool2, bool3);
      i = j;
      if (paramPInt.txm)
      {
        if (j != 0) {
          break label772;
        }
        i = 1;
      }
      label416:
      if (!bool2) {
        break label792;
      }
      paramPInt.txa = com.tencent.mm.plugin.voip.a.b.HP(i);
      label431:
      bool1 = com.tencent.mm.compatible.f.b.Md();
      bool2 = com.tencent.mm.compatible.f.b.Me();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          paramPString = com.tencent.mm.plugin.report.service.h.qsU;
          if (!paramPInt.txl) {
            break label805;
          }
          i = 0;
          label473:
          paramPString.e(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          paramPString = com.tencent.mm.plugin.report.service.h.qsU;
          if (!paramPInt.txl) {
            break label811;
          }
          i = 0;
          label519:
          paramPString.e(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        paramPString = null;
        paramPBool1 = null;
        if ((bool1) || (bool2)) {
          break label817;
        }
        paramPString = paramContext.getString(2131304738);
        paramPBool1 = paramContext.getString(2131304706);
        label585:
        com.tencent.mm.ui.base.h.a(paramContext, paramPString, paramPBool1, paramContext.getString(2131304709), true, new VoipMgr.15(paramPInt, paramContext));
      }
      ab.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.Ia().Ic();
      com.tencent.mm.compatible.b.g.KC().b(paramPInt);
      com.tencent.mm.compatible.b.g.KC().a(paramPInt);
      com.tencent.mm.compatible.b.g.KC().KE();
      paramPInt.cko = new com.tencent.mm.compatible.util.b(ah.getContext());
      paramPInt.cko.requestFocus();
      if (!paramPInt.txl) {
        break label865;
      }
      com.tencent.mm.plugin.voip.b.cLC().b(true, true, paramPInt.eaX);
      label693:
      if (!paramPInt.txk) {
        break label908;
      }
      com.tencent.mm.plugin.voip.b.cLC().tyR.cOe();
      if (!paramPInt.txl) {
        break label881;
      }
      paramContext = com.tencent.mm.plugin.voip.b.cLC();
      paramPString = paramPInt.txj.field_username;
    }
    for (int i = paramContext.tyR.dB(paramPString, 0);; i = paramContext.tyR.dB(paramPString, 1))
    {
      if (i >= 0) {
        break label908;
      }
      paramPInt.mU(false);
      paramContext = this.tyS;
      AppMethodBeat.o(4634);
      return paramContext;
      bool1 = false;
      break;
      label772:
      i = j;
      if (256 != j) {
        break label416;
      }
      i = 257;
      break label416;
      label792:
      paramPInt.txa = com.tencent.mm.plugin.voip.a.b.HO(i);
      break label431;
      label805:
      i = 1;
      break label473;
      label811:
      i = 1;
      break label519;
      label817:
      if (!bool1)
      {
        paramPString = paramContext.getString(2131304740);
        paramPBool1 = paramContext.getString(2131304707);
        break label585;
      }
      if (bool2) {
        break label585;
      }
      paramPString = paramContext.getString(2131304739);
      paramPBool1 = paramContext.getString(2131304708);
      break label585;
      label865:
      com.tencent.mm.plugin.voip.b.cLC().b(true, false, paramPInt.eaX);
      break label693;
      label881:
      paramContext = com.tencent.mm.plugin.voip.b.cLC();
      paramPString = paramPInt.txj.field_username;
    }
    label908:
    paramPInt.txb = new HeadsetPlugReceiver();
    paramPInt.txb.a(ah.getContext(), paramPInt.tyl);
    paramPString = com.tencent.mm.plugin.voip.b.cLC();
    paramContext = ah.getContext();
    paramPString = paramPString.tyR;
    paramPString.ttm.jpJ = paramContext;
    paramPString.ttm.tvk = paramPInt;
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.a.a.cPq();
    paramPInt.nLF = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    paramPInt.nLF.listen(paramPInt.nLG, 32);
    if (paramPInt.txl)
    {
      i = 0;
      label1021:
      com.tencent.mm.plugin.voip.b.cLC().ap(i, paramPInt.txk);
      if (!com.tencent.mm.compatible.b.g.KC().KN()) {
        break label1346;
      }
      i = 3;
      label1046:
      paramPInt.txp = i;
      paramPInt.txK = false;
      paramPInt.txs = paramPInt.txl;
      paramContext = "voip_recent_contact" + com.tencent.mm.model.r.Zn();
      paramPString = ah.getContext().getSharedPreferences("voip_plugin_prefs", 0);
      paramPBool1 = paramPString.getString(paramContext, null);
      if (paramPBool1 == null) {
        break label1401;
      }
      paramPBool1 = bo.P(paramPBool1.split(";"));
      if (paramPBool1 == null) {
        break label1401;
      }
      i = paramPBool1.size();
      if (!paramPBool1.contains(paramPInt.eaX)) {
        break label1381;
      }
      if (i > 1)
      {
        paramPBool1.remove(paramPInt.eaX);
        label1168:
        paramPBool1.add(0, paramPInt.eaX);
      }
      paramPBool1 = bo.d(paramPBool1, ";");
      paramPString.edit().putString(paramContext, paramPBool1).commit();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(paramPInt.tyn);
      com.tencent.mm.sdk.b.a.ymk.c(paramPInt.nLH);
      paramContext = paramPInt.txx;
      if (!paramContext.jOc.contains(paramPInt)) {
        paramContext.jOc.add(paramPInt);
      }
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.SCREEN_ON");
      paramContext.addAction("android.intent.action.SCREEN_OFF");
      paramContext.addAction("android.intent.action.USER_PRESENT");
      ah.getContext().registerReceiver(paramPInt.tyk, paramContext);
      paramPInt.mub = new SensorController(paramPInt.getContext());
      ab.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
      paramPInt.mub.a(paramPInt);
      break;
      i = 1;
      break label1021;
      label1346:
      if (com.tencent.mm.compatible.b.g.KC().KH())
      {
        i = 4;
        break label1046;
      }
      if (paramPInt.txl)
      {
        i = 1;
        break label1046;
      }
      i = 2;
      break label1046;
      label1381:
      if (4 != i) {
        break label1168;
      }
      paramPBool1.remove(i - 1);
      break label1168;
      label1401:
      paramPBool1 = new ArrayList();
      paramPBool1.add(0, paramPInt.eaX);
      paramPBool1 = bo.d(paramPBool1, ";");
      paramPString.edit().putString(paramContext, paramPBool1).commit();
    }
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(4633);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    long l = System.currentTimeMillis();
    paramContext = new ir();
    paramContext.cyf.cyi = false;
    paramContext.cyf.cyh = l;
    paramContext.cyf.cyg = localContext;
    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    ab.i("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.bXk.bLR) });
    int i;
    if ((d.iU(28)) || (Build.VERSION.CODENAME.equals("Q"))) {
      i = 1;
    }
    while ((!paramBoolean1) && (i != 0) && (!AppForegroundDelegate.bXk.bLR))
    {
      this.oTB = true;
      paramContext = new Intent();
      paramContext.putExtra("Voip_User", paramString);
      paramContext.putExtra("Voip_Outcall", false);
      paramContext.putExtra("Voip_VideoCall", paramBoolean2);
      paramContext.putExtra("Voip_LastPage_Hash", l);
      paramContext.setClass(ah.getContext(), VoipCallingService.class);
      if (Build.VERSION.SDK_INT >= 26)
      {
        try
        {
          ah.getContext().startService(paramContext);
          ab.i("MicroMsg.Voip.VoipService", "start service to pull notification instead of start activity");
          AppMethodBeat.o(4633);
          return;
        }
        catch (Exception paramString)
        {
          ah.getContext().startForegroundService(paramContext);
          ab.i("MicroMsg.Voip.VoipService", "start foreground service to pull notification instead of start activity");
        }
        i = 0;
        continue;
      }
      AppMethodBeat.o(4633);
      return;
    }
    paramContext = new Intent(localContext, VideoActivity.class);
    paramContext.putExtra("Voip_User", paramString);
    paramContext.putExtra("Voip_Outcall", paramBoolean1);
    paramContext.putExtra("Voip_VideoCall", paramBoolean2);
    paramContext.putExtra("Voip_LastPage_Hash", l);
    if (paramBoolean3)
    {
      paramContext.setFlags(603979776);
      paramContext.addFlags(268435456);
    }
    bF(paramString, paramBoolean2);
    localContext.startActivity(paramContext);
    AppMethodBeat.o(4633);
  }
  
  public final void aZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4609);
    ab.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((bo.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.tyV < 2000L) && (System.currentTimeMillis() - this.tyV > 0L)))
    {
      AppMethodBeat.o(4609);
      return;
    }
    if ((System.currentTimeMillis() - this.tyY < this.tyZ) && (System.currentTimeMillis() - this.tyY > 0L))
    {
      ab.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131304734, 2131304767, null);
      AppMethodBeat.o(4609);
      return;
    }
    this.tyV = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString) == null)
    {
      AppMethodBeat.o(4609);
      return;
    }
    a(paramContext, paramString, true, false, false);
    cNS();
    AppMethodBeat.o(4609);
  }
  
  public final void ah(int paramInt, long paramLong)
  {
    AppMethodBeat.i(4612);
    al.d(new t.2(this, paramInt, paramLong));
    AppMethodBeat.o(4612);
  }
  
  public final void ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4630);
    u localu = this.tyR;
    if (localu.tzl != null) {
      localu.tzl.aq(paramInt, paramBoolean);
    }
    AppMethodBeat.o(4630);
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: sipush 4619
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore 18
    //   9: lconst_0
    //   10: lstore 16
    //   12: lconst_0
    //   13: lstore 8
    //   15: lconst_0
    //   16: lstore 12
    //   18: lconst_0
    //   19: lstore 10
    //   21: ldc 251
    //   23: ldc_w 1177
    //   26: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   33: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   36: getfield 1180	com/tencent/mm/plugin/voip/model/k:tvn	[B
    //   39: invokestatic 1182	com/tencent/mm/plugin/voip/model/t:bu	([B)Ljava/util/Map;
    //   42: astore 24
    //   44: aload 24
    //   46: ifnonnull +332 -> 378
    //   49: ldc 251
    //   51: ldc_w 1184
    //   54: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: lconst_0
    //   58: lstore 14
    //   60: ldc 251
    //   62: new 351	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 1186
    //   69: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: lload 18
    //   74: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 1191
    //   80: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload 16
    //   85: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: ldc_w 1193
    //   91: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: lload 14
    //   96: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 1195	com/tencent/mm/protocal/protobuf/csl
    //   108: dup
    //   109: invokespecial 1196	com/tencent/mm/protocal/protobuf/csl:<init>	()V
    //   112: aload_1
    //   113: invokevirtual 1197	com/tencent/mm/protocal/protobuf/csl:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   116: checkcast 1195	com/tencent/mm/protocal/protobuf/csl
    //   119: astore 24
    //   121: iconst_0
    //   122: istore 5
    //   124: iload 5
    //   126: aload 24
    //   128: getfield 1200	com/tencent/mm/protocal/protobuf/csl:yaY	Ljava/util/LinkedList;
    //   131: invokevirtual 242	java/util/LinkedList:size	()I
    //   134: if_icmpge +1063 -> 1197
    //   137: aload 24
    //   139: getfield 1200	com/tencent/mm/protocal/protobuf/csl:yaY	Ljava/util/LinkedList;
    //   142: iload 5
    //   144: invokevirtual 370	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   147: checkcast 1202	com/tencent/mm/protocal/protobuf/csk
    //   150: astore 25
    //   152: ldc 251
    //   154: new 351	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 1204
    //   161: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload 25
    //   166: getfield 1207	com/tencent/mm/protocal/protobuf/csk:wMC	I
    //   169: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 25
    //   180: getfield 1207	com/tencent/mm/protocal/protobuf/csk:wMC	I
    //   183: iconst_1
    //   184: if_icmpne +462 -> 646
    //   187: new 1209	com/tencent/mm/protocal/protobuf/ctl
    //   190: dup
    //   191: invokespecial 1210	com/tencent/mm/protocal/protobuf/ctl:<init>	()V
    //   194: aload 25
    //   196: getfield 1214	com/tencent/mm/protocal/protobuf/csk:wtq	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   199: invokevirtual 1219	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   202: invokevirtual 1220	com/tencent/mm/protocal/protobuf/ctl:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   205: checkcast 1209	com/tencent/mm/protocal/protobuf/ctl
    //   208: astore_1
    //   209: aload_1
    //   210: ifnull +413 -> 623
    //   213: ldc 251
    //   215: new 351	java/lang/StringBuilder
    //   218: dup
    //   219: ldc_w 1222
    //   222: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload_1
    //   226: getfield 1225	com/tencent/mm/protocal/protobuf/ctl:jJS	I
    //   229: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: lload 8
    //   240: aload 25
    //   242: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   245: i2l
    //   246: lcmp
    //   247: ifge +1177 -> 1424
    //   250: aload 25
    //   252: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   255: i2l
    //   256: lstore 6
    //   258: lload 6
    //   260: lstore 8
    //   262: aload 25
    //   264: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   267: i2l
    //   268: lload 18
    //   270: lcmp
    //   271: ifle +360 -> 631
    //   274: ldc 251
    //   276: new 351	java/lang/StringBuilder
    //   279: dup
    //   280: ldc_w 1228
    //   283: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: aload 25
    //   288: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   291: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc_w 1230
    //   297: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: lload 18
    //   302: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 1232
    //   308: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: getfield 1225	com/tencent/mm/protocal/protobuf/ctl:jJS	I
    //   315: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 1234
    //   321: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   334: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   337: getfield 1238	com/tencent/mm/plugin/voip/model/k:tvm	Lcom/tencent/mm/plugin/voip/model/v;
    //   340: aload_1
    //   341: iconst_1
    //   342: invokevirtual 1243	com/tencent/mm/plugin/voip/model/v:a	(Lcom/tencent/mm/protocal/protobuf/ctl;I)V
    //   345: lload 6
    //   347: lstore 20
    //   349: lload 10
    //   351: lstore 22
    //   353: lload 12
    //   355: lstore 6
    //   357: iload 5
    //   359: iconst_1
    //   360: iadd
    //   361: istore 5
    //   363: lload 20
    //   365: lstore 8
    //   367: lload 6
    //   369: lstore 12
    //   371: lload 22
    //   373: lstore 10
    //   375: goto -251 -> 124
    //   378: aload 24
    //   380: invokeinterface 199 1 0
    //   385: invokeinterface 205 1 0
    //   390: astore 25
    //   392: lconst_0
    //   393: lstore 6
    //   395: aload 25
    //   397: invokeinterface 211 1 0
    //   402: ifeq +1029 -> 1431
    //   405: aload 25
    //   407: invokeinterface 215 1 0
    //   412: checkcast 162	java/lang/Integer
    //   415: astore 26
    //   417: aload 24
    //   419: aload 26
    //   421: invokeinterface 225 2 0
    //   426: checkcast 227	java/lang/Long
    //   429: astore 27
    //   431: aload 26
    //   433: invokevirtual 221	java/lang/Integer:intValue	()I
    //   436: tableswitch	default:+28 -> 464, 1:+68->504, 2:+78->514, 3:+88->524
    //   465: <illegal opcode>
    //   466: new 351	java/lang/StringBuilder
    //   469: dup
    //   470: ldc_w 1245
    //   473: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: aload 26
    //   478: invokevirtual 221	java/lang/Integer:intValue	()I
    //   481: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 1247
    //   487: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 27
    //   492: invokevirtual 1250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: goto -106 -> 395
    //   504: aload 27
    //   506: invokevirtual 1253	java/lang/Long:longValue	()J
    //   509: lstore 18
    //   511: goto -116 -> 395
    //   514: aload 27
    //   516: invokevirtual 1253	java/lang/Long:longValue	()J
    //   519: lstore 16
    //   521: goto -126 -> 395
    //   524: aload 27
    //   526: invokevirtual 1253	java/lang/Long:longValue	()J
    //   529: lstore 6
    //   531: goto -136 -> 395
    //   534: astore 24
    //   536: ldc 251
    //   538: aload 24
    //   540: ldc 253
    //   542: iconst_0
    //   543: anewarray 4	java/lang/Object
    //   546: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: aload_1
    //   550: invokestatic 1255	com/tencent/mm/plugin/voip/model/t:bv	([B)Ljava/lang/String;
    //   553: astore 24
    //   555: ldc 251
    //   557: new 351	java/lang/StringBuilder
    //   560: dup
    //   561: ldc_w 1257
    //   564: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   567: aload_1
    //   568: arraylength
    //   569: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 1259
    //   575: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 24
    //   580: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: sipush 4619
    //   592: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: iconst_0
    //   596: ireturn
    //   597: astore_1
    //   598: ldc 251
    //   600: ldc_w 1261
    //   603: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: ldc 251
    //   608: aload_1
    //   609: ldc 253
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: aconst_null
    //   619: astore_1
    //   620: goto -411 -> 209
    //   623: ldc 251
    //   625: ldc_w 1261
    //   628: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: lload 8
    //   633: lstore 20
    //   635: lload 12
    //   637: lstore 6
    //   639: lload 10
    //   641: lstore 22
    //   643: goto -286 -> 357
    //   646: aload 25
    //   648: getfield 1207	com/tencent/mm/protocal/protobuf/csk:wMC	I
    //   651: iconst_2
    //   652: if_icmpne +334 -> 986
    //   655: new 1263	com/tencent/mm/protocal/protobuf/cta
    //   658: dup
    //   659: invokespecial 1264	com/tencent/mm/protocal/protobuf/cta:<init>	()V
    //   662: aload 25
    //   664: getfield 1214	com/tencent/mm/protocal/protobuf/csk:wtq	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   667: invokevirtual 1219	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   670: invokevirtual 1265	com/tencent/mm/protocal/protobuf/cta:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   673: checkcast 1263	com/tencent/mm/protocal/protobuf/cta
    //   676: astore_1
    //   677: aload_1
    //   678: ifnull +285 -> 963
    //   681: ldc 251
    //   683: new 351	java/lang/StringBuilder
    //   686: dup
    //   687: ldc_w 1267
    //   690: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   693: aload_1
    //   694: getfield 1270	com/tencent/mm/protocal/protobuf/cta:jKs	I
    //   697: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: lload 12
    //   708: aload 25
    //   710: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   713: i2l
    //   714: lcmp
    //   715: ifge +702 -> 1417
    //   718: aload 25
    //   720: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   723: i2l
    //   724: lstore 6
    //   726: aload 25
    //   728: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   731: i2l
    //   732: lload 16
    //   734: lcmp
    //   735: ifle +174 -> 909
    //   738: ldc 251
    //   740: new 351	java/lang/StringBuilder
    //   743: dup
    //   744: ldc_w 1272
    //   747: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: aload 25
    //   752: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   755: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: ldc_w 1274
    //   761: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: lload 16
    //   766: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   769: ldc_w 1234
    //   772: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: aload_1
    //   782: getfield 1270	com/tencent/mm/protocal/protobuf/cta:jKs	I
    //   785: iconst_5
    //   786: if_icmpne +54 -> 840
    //   789: aload_0
    //   790: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   793: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   796: getfield 1238	com/tencent/mm/plugin/voip/model/k:tvm	Lcom/tencent/mm/plugin/voip/model/v;
    //   799: aload_1
    //   800: invokevirtual 1277	com/tencent/mm/plugin/voip/model/v:a	(Lcom/tencent/mm/protocal/protobuf/cta;)V
    //   803: lload 8
    //   805: lstore 20
    //   807: lload 10
    //   809: lstore 22
    //   811: goto -454 -> 357
    //   814: astore_1
    //   815: ldc 251
    //   817: ldc_w 1279
    //   820: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: ldc 251
    //   825: aload_1
    //   826: ldc 253
    //   828: iconst_0
    //   829: anewarray 4	java/lang/Object
    //   832: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: aconst_null
    //   836: astore_1
    //   837: goto -160 -> 677
    //   840: aload_1
    //   841: getfield 1270	com/tencent/mm/protocal/protobuf/cta:jKs	I
    //   844: iconst_1
    //   845: if_icmpne +28 -> 873
    //   848: aload_0
    //   849: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   852: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   855: getfield 1238	com/tencent/mm/plugin/voip/model/k:tvm	Lcom/tencent/mm/plugin/voip/model/v;
    //   858: aload_1
    //   859: invokevirtual 1281	com/tencent/mm/plugin/voip/model/v:b	(Lcom/tencent/mm/protocal/protobuf/cta;)V
    //   862: lload 8
    //   864: lstore 20
    //   866: lload 10
    //   868: lstore 22
    //   870: goto -513 -> 357
    //   873: ldc 251
    //   875: new 351	java/lang/StringBuilder
    //   878: dup
    //   879: ldc_w 1283
    //   882: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   885: aload_1
    //   886: getfield 1270	com/tencent/mm/protocal/protobuf/cta:jKs	I
    //   889: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   892: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: lload 8
    //   900: lstore 20
    //   902: lload 10
    //   904: lstore 22
    //   906: goto -549 -> 357
    //   909: ldc 251
    //   911: new 351	java/lang/StringBuilder
    //   914: dup
    //   915: ldc_w 1285
    //   918: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   921: aload 25
    //   923: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   926: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   929: ldc_w 1287
    //   932: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: lload 16
    //   937: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   940: ldc_w 1234
    //   943: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: lload 8
    //   954: lstore 20
    //   956: lload 10
    //   958: lstore 22
    //   960: goto -603 -> 357
    //   963: ldc 251
    //   965: ldc_w 1279
    //   968: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   971: lload 8
    //   973: lstore 20
    //   975: lload 12
    //   977: lstore 6
    //   979: lload 10
    //   981: lstore 22
    //   983: goto -626 -> 357
    //   986: lload 8
    //   988: lstore 20
    //   990: lload 12
    //   992: lstore 6
    //   994: lload 10
    //   996: lstore 22
    //   998: aload 25
    //   1000: getfield 1207	com/tencent/mm/protocal/protobuf/csk:wMC	I
    //   1003: iconst_3
    //   1004: if_icmpne -647 -> 357
    //   1007: new 1216	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1010: dup
    //   1011: invokespecial 1288	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1014: aload 25
    //   1016: getfield 1214	com/tencent/mm/protocal/protobuf/csk:wtq	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1019: invokevirtual 1219	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   1022: invokevirtual 1291	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:parseFrom	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1025: astore_1
    //   1026: lload 8
    //   1028: lstore 20
    //   1030: lload 12
    //   1032: lstore 6
    //   1034: lload 10
    //   1036: lstore 22
    //   1038: aload_1
    //   1039: ifnull -682 -> 357
    //   1042: lload 10
    //   1044: aload 25
    //   1046: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   1049: i2l
    //   1050: lcmp
    //   1051: ifge +359 -> 1410
    //   1054: aload 25
    //   1056: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   1059: i2l
    //   1060: lstore 6
    //   1062: aload 25
    //   1064: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   1067: i2l
    //   1068: lload 14
    //   1070: lcmp
    //   1071: ifle +93 -> 1164
    //   1074: ldc 251
    //   1076: new 351	java/lang/StringBuilder
    //   1079: dup
    //   1080: ldc_w 1293
    //   1083: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1086: aload 25
    //   1088: getfield 1226	com/tencent/mm/protocal/protobuf/csk:qsk	I
    //   1091: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1094: ldc_w 1295
    //   1097: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: lload 14
    //   1102: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1105: ldc_w 1234
    //   1108: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1114: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1117: aload_0
    //   1118: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   1121: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   1124: getfield 1238	com/tencent/mm/plugin/voip/model/k:tvm	Lcom/tencent/mm/plugin/voip/model/v;
    //   1127: aload_1
    //   1128: invokevirtual 1298	com/tencent/mm/plugin/voip/model/v:c	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)V
    //   1131: aload_0
    //   1132: getfield 98	com/tencent/mm/plugin/voip/model/t:tze	Lcom/tencent/mm/protocal/protobuf/csp;
    //   1135: ifnull +29 -> 1164
    //   1138: aload_1
    //   1139: invokevirtual 1302	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bv/b;
    //   1142: invokevirtual 1305	com/tencent/mm/bv/b:toByteArray	()[B
    //   1145: invokestatic 1309	com/tencent/mm/plugin/voip/a/a:by	([B)I
    //   1148: sipush 255
    //   1151: iand
    //   1152: iconst_1
    //   1153: if_icmpne +11 -> 1164
    //   1156: aload_0
    //   1157: getfield 98	com/tencent/mm/plugin/voip/model/t:tze	Lcom/tencent/mm/protocal/protobuf/csp;
    //   1160: iconst_1
    //   1161: putfield 1312	com/tencent/mm/protocal/protobuf/csp:yaX	I
    //   1164: lload 6
    //   1166: lstore 22
    //   1168: lload 8
    //   1170: lstore 20
    //   1172: lload 12
    //   1174: lstore 6
    //   1176: goto -819 -> 357
    //   1179: astore_1
    //   1180: ldc 251
    //   1182: aload_1
    //   1183: ldc 253
    //   1185: iconst_0
    //   1186: anewarray 4	java/lang/Object
    //   1189: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1192: aconst_null
    //   1193: astore_1
    //   1194: goto -168 -> 1026
    //   1197: lload 8
    //   1199: lload 18
    //   1201: lcmp
    //   1202: ifle +201 -> 1403
    //   1205: lload 12
    //   1207: lload 16
    //   1209: lcmp
    //   1210: ifle +186 -> 1396
    //   1213: lload 10
    //   1215: lload 14
    //   1217: lcmp
    //   1218: ifle +171 -> 1389
    //   1221: new 79	java/util/HashMap
    //   1224: dup
    //   1225: invokespecial 80	java/util/HashMap:<init>	()V
    //   1228: astore_1
    //   1229: aload_1
    //   1230: iconst_1
    //   1231: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1234: lload 8
    //   1236: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1239: invokeinterface 379 3 0
    //   1244: pop
    //   1245: aload_1
    //   1246: iconst_2
    //   1247: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1250: lload 12
    //   1252: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1255: invokeinterface 379 3 0
    //   1260: pop
    //   1261: aload_1
    //   1262: iconst_3
    //   1263: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: lload 10
    //   1268: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1271: invokeinterface 379 3 0
    //   1276: pop
    //   1277: aload_1
    //   1278: invokestatic 1314	com/tencent/mm/plugin/voip/model/t:ai	(Ljava/util/Map;)[B
    //   1281: astore_1
    //   1282: iload_2
    //   1283: aload_0
    //   1284: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   1287: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   1290: getfield 522	com/tencent/mm/plugin/voip/model/k:tvj	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1293: getfield 1317	com/tencent/mm/plugin/voip/model/v2protocal:nMZ	I
    //   1296: if_icmpne +77 -> 1373
    //   1299: lload_3
    //   1300: aload_0
    //   1301: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   1304: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   1307: getfield 522	com/tencent/mm/plugin/voip/model/k:tvj	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1310: getfield 1320	com/tencent/mm/plugin/voip/model/v2protocal:nNa	J
    //   1313: lcmp
    //   1314: ifne +59 -> 1373
    //   1317: aload_0
    //   1318: getfield 134	com/tencent/mm/plugin/voip/model/t:tyR	Lcom/tencent/mm/plugin/voip/model/u;
    //   1321: getfield 516	com/tencent/mm/plugin/voip/model/u:ttm	Lcom/tencent/mm/plugin/voip/model/k;
    //   1324: aload_1
    //   1325: putfield 1180	com/tencent/mm/plugin/voip/model/k:tvn	[B
    //   1328: ldc 251
    //   1330: new 351	java/lang/StringBuilder
    //   1333: dup
    //   1334: ldc_w 1322
    //   1337: invokespecial 356	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1340: lload 8
    //   1342: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1345: ldc_w 1324
    //   1348: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: lload 12
    //   1353: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1356: ldc_w 1324
    //   1359: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: lload 10
    //   1364: invokevirtual 1189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: ldc 251
    //   1375: ldc_w 1326
    //   1378: invokestatic 487	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1381: sipush 4619
    //   1384: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1387: iconst_0
    //   1388: ireturn
    //   1389: lload 14
    //   1391: lstore 10
    //   1393: goto -172 -> 1221
    //   1396: lload 16
    //   1398: lstore 12
    //   1400: goto -187 -> 1213
    //   1403: lload 18
    //   1405: lstore 8
    //   1407: goto -202 -> 1205
    //   1410: lload 10
    //   1412: lstore 6
    //   1414: goto -352 -> 1062
    //   1417: lload 12
    //   1419: lstore 6
    //   1421: goto -695 -> 726
    //   1424: lload 8
    //   1426: lstore 6
    //   1428: goto -1170 -> 258
    //   1431: lload 6
    //   1433: lstore 14
    //   1435: goto -1375 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1438	0	this	t
    //   0	1438	1	paramArrayOfByte	byte[]
    //   0	1438	2	paramInt	int
    //   0	1438	3	paramLong	long
    //   122	240	5	i	int
    //   256	1176	6	l1	long
    //   13	1412	8	l2	long
    //   19	1392	10	l3	long
    //   16	1402	12	l4	long
    //   58	1376	14	l5	long
    //   10	1387	16	l6	long
    //   7	1397	18	l7	long
    //   347	824	20	l8	long
    //   351	816	22	l9	long
    //   42	376	24	localObject1	Object
    //   534	5	24	localException	Exception
    //   553	26	24	str	String
    //   150	937	25	localObject2	Object
    //   415	62	26	localInteger	Integer
    //   429	96	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   105	121	534	java/lang/Exception
    //   187	209	597	java/io/IOException
    //   655	677	814	java/io/IOException
    //   1007	1026	1179	java/io/IOException
  }
  
  public final void b(csp paramcsp)
  {
    AppMethodBeat.i(4613);
    if ((!com.tencent.mm.m.f.Mz()) && (!eD(ah.getContext())))
    {
      ab.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.tze == null) && (this.oTJ.dtj()))
      {
        ab.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.tze = paramcsp;
        this.oTJ.ag(2000L, 2000L);
        this.tzf = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(500L, 4L, 1L, false);
        com.tencent.mm.plugin.voip.a.a.HL(0);
      }
      AppMethodBeat.o(4613);
      return;
    }
    String str = paramcsp.ybf;
    Object localObject = com.tencent.mm.model.r.Zn();
    int i = paramcsp.yaX;
    ab.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[] { localObject, str, Integer.valueOf(i), Integer.valueOf(paramcsp.wQP) });
    if (this.tyR.cMa())
    {
      u.a(paramcsp.wQP, paramcsp.wQQ, 2, null, null, str);
      ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramcsp.wQP);
      com.tencent.mm.plugin.report.service.h.qsU.a(11525, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.a.a.HL(0);
      AppMethodBeat.o(4613);
      return;
    }
    if (u.cOd())
    {
      u.a(paramcsp.wQP, paramcsp.wQQ, 3, null, null, str);
      ab.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramcsp.wQP);
      com.tencent.mm.plugin.report.service.h.qsU.a(11525, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.a.a.HL(0);
      AppMethodBeat.o(4613);
      return;
    }
    this.tyR.cOe();
    if (!this.tyR.a(paramcsp))
    {
      ab.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.h.qsU.a(11525, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.a.a.HL(0);
      AppMethodBeat.o(4613);
      return;
    }
    localObject = ah.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str) == null)
    {
      u.a(paramcsp.wQP, paramcsp.wQQ, 4, null, null, str);
      ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramcsp.wQP);
      com.tencent.mm.plugin.report.service.h.qsU.a(11525, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.qsU.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.a.a.HL(0);
      AppMethodBeat.o(4613);
      return;
    }
    if ((1 == i) || (i == 0)) {
      if (i != 0) {
        break label1198;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        a((Context)localObject, str, false, bool, true);
        if (this.tyR != null) {
          this.tyR.HB(paramcsp.wQP);
        }
        ab.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label1198:
          com.tencent.mm.plugin.voip.a.a.HL(2);
        }
      }
      u.a(paramcsp.wQP, paramcsp.wQQ, 1, this.tyR.ttm.tvj.field_peerId, this.tyR.ttm.tvj.field_capInfo, str);
      com.tencent.mm.plugin.report.service.h.qsU.a(11525, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(4613);
      return;
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(4607);
    ab.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.cif = paramBoolean1;
    if (paramBoolean2)
    {
      this.tyT = paramBoolean1;
      this.tyR.ttm.tvj.tAo = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.tyR.ttm.tvj.tBN.gfV = paramString;
      AppMethodBeat.o(4607);
      return;
      this.tyR.ttm.tvj.tAo = 1;
      this.tyU = paramBoolean1;
    }
  }
  
  public final void ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4610);
    ab.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((bo.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.tyV < 2000L) && (System.currentTimeMillis() - this.tyV > 0L)))
    {
      AppMethodBeat.o(4610);
      return;
    }
    if ((System.currentTimeMillis() - this.tyY < this.tyZ) && (System.currentTimeMillis() - this.tyY > 0L))
    {
      ab.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131304734, 2131304767, null);
      AppMethodBeat.o(4610);
      return;
    }
    this.tyV = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString) == null)
    {
      AppMethodBeat.o(4610);
      return;
    }
    a(paramContext, paramString, true, true, false);
    cNS();
    AppMethodBeat.o(4610);
  }
  
  public final int cLL()
  {
    AppMethodBeat.i(156770);
    int i = this.tyR.ttm.cLL();
    AppMethodBeat.o(156770);
    return i;
  }
  
  public final long cMb()
  {
    AppMethodBeat.i(156769);
    long l = this.tyR.ttm.cMb();
    AppMethodBeat.o(156769);
    return l;
  }
  
  public final void cNT()
  {
    AppMethodBeat.i(140161);
    this.oTB = false;
    Intent localIntent = new Intent();
    localIntent.setClass(ah.getContext(), VoipCallingService.class);
    ah.getContext().stopService(localIntent);
    AppMethodBeat.o(140161);
  }
  
  public final int cNU()
  {
    return this.tyR.ttm.tvj.nMZ;
  }
  
  public final long cNV()
  {
    return this.tyR.ttm.tvj.nNa;
  }
  
  public final void cNW()
  {
    AppMethodBeat.i(4625);
    ab.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.tyR.ttm.tvj.tBN.twn = 1;
    AppMethodBeat.o(4625);
  }
  
  public final boolean cNX()
  {
    bool2 = false;
    AppMethodBeat.i(4632);
    bool1 = bool2;
    try
    {
      if (this.tyR.ttm.tvj != null)
      {
        int i = this.tyR.ttm.tvj.tAL;
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
        ab.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(4632);
    return bool1;
  }
  
  public final void cNZ()
  {
    AppMethodBeat.i(4636);
    this.tyR.tzv.ag(1000L, 1000L);
    AppMethodBeat.o(4636);
  }
  
  public final void cOa()
  {
    AppMethodBeat.i(4639);
    this.tyR.ttm.tvl.cMq();
    AppMethodBeat.o(4639);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(4606);
    this.tyR.stop();
    this.tyR = null;
    com.tencent.mm.kernel.g.RK().b(this.qwx);
    super.finalize();
    AppMethodBeat.o(4606);
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(4640);
    ab.b("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      int i = (byte)j;
      this.tyR.ttm.tvj.setAppCmd(425, new byte[] { i }, 1);
      AppMethodBeat.o(4640);
      return;
    }
  }
  
  public final boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(4627);
    paramBoolean = this.tyR.mJ(paramBoolean);
    AppMethodBeat.o(4627);
    return paramBoolean;
  }
  
  public final int mO(boolean paramBoolean)
  {
    AppMethodBeat.i(4628);
    int i = this.tyR.mO(paramBoolean);
    AppMethodBeat.o(4628);
    return i;
  }
  
  public final int mP(boolean paramBoolean)
  {
    AppMethodBeat.i(4629);
    int i = this.tyR.mP(paramBoolean);
    AppMethodBeat.o(4629);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t
 * JD-Core Version:    0.7.0.1
 */