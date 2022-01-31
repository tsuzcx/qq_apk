package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.mm.h.a.ik;
import com.tencent.mm.h.a.td;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.protocal.c.cci;
import com.tencent.mm.protocal.c.cef;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{
  private static final com.tencent.mm.a.f<Integer, n.a> dss = new com.tencent.mm.a.f(5);
  public boolean bBq = false;
  public am mtV = new am(Looper.getMainLooper(), new r.3(this), true);
  private n nIV = new com.tencent.mm.network.n.a()
  {
    public final void et(int paramAnonymousInt)
    {
      y.d("MicroMsg.Voip.VoipService", "network status change from " + paramAnonymousInt);
      if ((r.a(r.this)) && (paramAnonymousInt == 4))
      {
        localObject = r.this.pTq.pNq;
        if (((j)localObject).pQo == 0) {
          ((j)localObject).pQo = ((j)localObject).pQe.pUy;
        }
        paramAnonymousInt = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
        if (paramAnonymousInt != ((j)localObject).pQo) {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + ((j)localObject).pQo + " to " + paramAnonymousInt);
        }
      }
      try
      {
        byte[] arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)paramAnonymousInt);
        int i = ((j)localObject).pQe.setAppCmd(301, arrayOfByte, 4);
        if (i < 0) {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + ((j)localObject).pQe.lpL + ", roomkey=" + ((j)localObject).pQe.lpE + "]");
        }
        cci localcci = new cci();
        localcci.tRC = 3;
        localcci.tRD = new com.tencent.mm.bv.b(arrayOfByte, 0, 1);
        ((j)localObject).pQe.SendRUDP(localcci.toByteArray(), localcci.toByteArray().length);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
        }
      }
      ((j)localObject).pQo = paramAnonymousInt;
      Object localObject = r.this.pTq;
      new com.tencent.mm.plugin.voip.model.a.h(((s)localObject).pNq.pQe.lpD, ((s)localObject).pNq.pQe.lpE, ((s)localObject).pNq.pQe.lpL, 0, 0, null).bRB();
    }
  };
  public String pSz = null;
  public boolean pTA = false;
  public boolean pTB = false;
  public boolean pTC = false;
  public cfe pTD = null;
  public long pTE = 0L;
  List<r.a> pTF = null;
  public s pTq = new s();
  public o pTr;
  public boolean pTs = false;
  public boolean pTt = false;
  private long pTu = 0L;
  public Map<Integer, Long> pTv = new HashMap();
  public int pTw = -1;
  public long pTx = 0L;
  public long pTy = 0L;
  public Point pTz;
  public String talker = null;
  
  public r()
  {
    com.tencent.mm.kernel.g.DO().a(this.nIV);
  }
  
  private static byte[] O(Map<Integer, Long> paramMap)
  {
    bwr localbwr = new bwr();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ata localata = new ata();
      localata.nFi = localInteger.intValue();
      localata.toF = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localata);
    }
    localbwr.tIO = localLinkedList;
    localbwr.tIN = localLinkedList.size();
    try
    {
      paramMap = localbwr.toByteArray();
      return paramMap;
    }
    catch (IOException paramMap)
    {
      y.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
    }
    return null;
  }
  
  public static n.a PZ(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    int i;
    n.a locala;
    do
    {
      return localObject;
      i = paramString.hashCode();
      locala = (n.a)dss.get(Integer.valueOf(i));
      localObject = locala;
    } while (locala != null);
    Object localObject = new n.a();
    if (!((n.a)localObject).parse(paramString)) {
      return null;
    }
    dss.f(Integer.valueOf(i), localObject);
    return localObject;
  }
  
  public static byte[] S(byte[] paramArrayOfByte, int paramInt)
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
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    long l = System.currentTimeMillis();
    paramContext = new ik();
    paramContext.bQF.bQI = false;
    paramContext.bQF.bQH = l;
    paramContext.bQF.bQG = localContext;
    com.tencent.mm.sdk.b.a.udP.m(paramContext);
    y.i("MicroMsg.Voip.VoipService", "start VideoActivity");
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
    localContext.startActivity(paramContext);
  }
  
  private static Map<Integer, Long> aT(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      return null;
    }
    try
    {
      paramArrayOfByte = (bwr)new bwr().aH(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    y.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.tIN);
    LinkedList localLinkedList = paramArrayOfByte.tIO;
    if (localLinkedList.size() != paramArrayOfByte.tIN) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.tIN)
    {
      localHashMap.put(Integer.valueOf(((ata)localLinkedList.get(i)).nFi), Long.valueOf(0xFFFFFFFF & ((ata)localLinkedList.get(i)).toF));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.tIN) {
      return null;
    }
    return localHashMap;
  }
  
  private static String aU(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0" + str3;
      }
      str1 = str1 + str2.toUpperCase();
      i += 1;
    }
    return str1;
  }
  
  private static void bRb()
  {
    td localtd = new td();
    localtd.ccJ.bNb = 7;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public static void bRk() {}
  
  public static void bRl() {}
  
  private static boolean dR(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      y.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        y.i("MicroMsg.Voip.VoipService", "is in backGround.");
        return false;
      }
    }
    if (((KeyguardManager)ae.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      return false;
    }
    y.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    return true;
  }
  
  public static float ka(boolean paramBoolean)
  {
    float f1 = 0.7476636F;
    f2 = f1;
    try
    {
      Object localObject = com.tencent.mm.plugin.voip.b.bPx();
      if (paramBoolean) {
        f2 = f1;
      }
      for (localObject = ((r)localObject).pTq.pNq.pQe.field_capInfo;; localObject = ((r)localObject).pTq.pNq.pQe.pUC)
      {
        f2 = f1;
        if (localObject == null) {
          break;
        }
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
        y.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
        return f1;
        f2 = f1;
      }
      return f2;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
    }
  }
  
  public final void Aj(int paramInt)
  {
    if ((this.pTF == null) || (this.pTF.isEmpty())) {}
    r.a locala;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.pTF.iterator();
      }
      locala = (r.a)localIterator.next();
    } while ((locala == null) || (locala.pTH == null) || (locala.pTH.sST != paramInt));
    locala.cancelled = true;
  }
  
  public final void Ak(int paramInt)
  {
    y.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.pTq.pNq.pQe.pUN = Math.abs(paramInt);
  }
  
  public final void Al(int paramInt)
  {
    s locals = this.pTq;
    if ((locals.pTJ != null) && (paramInt > 0)) {
      locals.pTJ.o(paramInt, 0, false);
    }
  }
  
  public final void Am(int paramInt)
  {
    j localj = this.pTq.pNq;
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + paramInt + " app 1");
    try
    {
      Object localObject = new byte[4];
      localObject[0] = ((byte)paramInt);
      localj.pQe.setJNIAppCmd(2, (byte[])localObject, 4);
      localObject = new cef();
      ((cef)localObject).tTm = paramInt;
      ((cef)localObject).tTn = 1;
      cci localcci = new cci();
      localcci.tRC = 4;
      localcci.tRD = new com.tencent.mm.bv.b(((cef)localObject).toByteArray(), 0, 1);
      localj.pQe.SendRUDP(localcci.toByteArray(), localcci.toByteArray().length);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
    }
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.pTB = paramBoolean1;
    this.pTC = paramBoolean2;
    y.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public final int I(boolean paramBoolean1, boolean paramBoolean2)
  {
    s locals = this.pTq;
    locals.bRw();
    if (!locals.pTV.crl()) {
      locals.pTV.stopTimer();
    }
    m localm = locals.pNq.pQe.pWi;
    localm.pRB = System.currentTimeMillis();
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + localm.pRB);
    y.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + paramBoolean1);
    if (!locals.pNq.bPV())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + locals.pNq.mStatus);
      return -1;
    }
    if (locals.pNq.pQe.lpD == 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      return -1;
    }
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zI() + "accept invite, roomid:" + locals.pNq.pQe.lpD);
    locals.pTU.S(50000L, 50000L);
    locals.pNq.pQe.pWi.bQm();
    new com.tencent.mm.plugin.voip.model.a.b(1, locals.pNq.pQe.netType, locals.pNq.pQe.lpD, locals.pNq.pQe.field_peerId, locals.pNq.pQe.field_capInfo, locals.pNq.pQe.lpE, paramBoolean1, paramBoolean2).bRB();
    locals.pNq.setStatus(4);
    locals.pNq.pQg.iEu = 1;
    locals.pNq.bWb = true;
    return 0;
  }
  
  public final void Qa(String paramString)
  {
    int i = 0;
    while (i < 2)
    {
      ai.l(new r.4(this, paramString), 1000L);
      i += 1;
    }
  }
  
  public final void T(int paramInt, long paramLong)
  {
    ai.d(new r.2(this, paramInt, paramLong));
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    l locall = this.pTq.pNq.pQg;
    int i;
    if (locall.iEu == l.iEt)
    {
      i = 1;
      if (paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int j = 1;; j = 0)
    {
      if ((j & i) == 0) {
        break label56;
      }
      return -1;
      i = 0;
      break;
    }
    label56:
    if (!locall.pNq.pQe.isInited) {
      return -1;
    }
    return locall.pNq.pQe.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
  }
  
  public final void a(cfe paramcfe)
  {
    if ((!com.tencent.mm.m.f.zR()) && (!dR(ae.getContext())))
    {
      y.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.pTD == null) && (this.mtV.crl()))
      {
        y.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.pTD = paramcfe;
        this.mtV.S(2000L, 2000L);
        this.pTE = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.nFQ.a(500L, 4L, 1L, false);
      }
      return;
    }
    String str = paramcfe.tTO;
    Object localObject1 = com.tencent.mm.model.q.Gj();
    int j = paramcfe.tTG;
    y.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[] { localObject1, str, Integer.valueOf(j), Integer.valueOf(paramcfe.sST) });
    if (this.pTq.bPW())
    {
      s.a(paramcfe.sST, paramcfe.sSU, 2, null, null, str);
      y.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramcfe.sST);
      com.tencent.mm.plugin.report.service.h.nFQ.a(11525, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(7) });
      return;
    }
    if (s.bRq())
    {
      s.a(paramcfe.sST, paramcfe.sSU, 3, null, null, str);
      y.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramcfe.sST);
      com.tencent.mm.plugin.report.service.h.nFQ.a(11525, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(7) });
      return;
    }
    this.pTq.bRr();
    localObject1 = this.pTq;
    int i;
    if (((s)localObject1).pNq.bPW())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + ((s)localObject1).pNq.mStatus);
      i = 0;
    }
    while (i == 0)
    {
      y.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.h.nFQ.a(11525, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(7) });
      return;
      if (paramcfe == null)
      {
        i = 0;
      }
      else
      {
        ((s)localObject1).pNq.pQe.pWi.pRf = paramcfe.tTG;
        y.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + ((s)localObject1).pNq.pQe.pWi.pRf);
        if (((s)localObject1).pNq.pQe.isInited)
        {
          com.tencent.mm.plugin.voip.a.a.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zI() + "v2protocal already init.");
          ((s)localObject1).pNq.pQe.kb(false);
          ((s)localObject1).pNq.pQe.reset();
        }
        Object localObject2 = ((s)localObject1).pNq;
        ((j)localObject2).pQj = paramcfe;
        ((j)localObject2).pQe.lFA = ((j)localObject2).pQj.tTO;
        ((j)localObject2).pQe.lpD = ((j)localObject2).pQj.sST;
        ((j)localObject2).pQe.lpE = ((j)localObject2).pQj.sSU;
        ((j)localObject2).pQe.lpL = 1;
        ((j)localObject2).pQe.pUz = 0;
        ((j)localObject2).mStatus = 3;
        if ((d.bSl()) || (com.tencent.mm.r.a.Bv()) || (d.bSo()))
        {
          y.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
          if (d.bSl())
          {
            s.a(paramcfe.sST, paramcfe.sSU, 2, null, null, paramcfe.tTO);
            i = 0;
          }
          else
          {
            ((s)localObject1).bRt();
            if (paramcfe.tTG == 0)
            {
              i = 1;
              label1050:
              localObject2 = paramcfe.tTO;
              if (i == 0) {
                break label1093;
              }
            }
            label1093:
            for (localObject1 = bi.uBQ;; localObject1 = bi.uBP)
            {
              q.a((String)localObject2, (String)localObject1, 0, 6, ae.getContext().getString(a.e.voip_callfrom_reject_msg));
              break;
              i = 0;
              break label1050;
            }
          }
        }
        else if (((s)localObject1).pNq.pQe.bMo() < 0)
        {
          com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
          i = 0;
        }
        else
        {
          if (v2protocal.pWk != null) {
            v2protocal.pWk.a(((s)localObject1).pNq);
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(11524, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          ((s)localObject1).pNq.pQf.bQF();
          i = 1;
        }
      }
    }
    localObject1 = ae.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str) == null)
    {
      s.a(paramcfe.sST, paramcfe.sSU, 4, null, null, str);
      y.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramcfe.sST);
      com.tencent.mm.plugin.report.service.h.nFQ.a(11525, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(7) });
      return;
    }
    if ((1 == j) || (j == 0)) {
      if (j != 0) {
        break label1652;
      }
    }
    label1652:
    for (boolean bool = true;; bool = false)
    {
      a((Context)localObject1, str, false, bool, true);
      if (this.pTq != null)
      {
        localObject1 = this.pTq;
        ((s)localObject1).pTK = paramcfe.sST;
        if (!((s)localObject1).pTV.crl()) {
          ((s)localObject1).pTV.stopTimer();
        }
        ((s)localObject1).pTV.S(70000L, 70000L);
      }
      y.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      s.a(paramcfe.sST, paramcfe.sSU, 1, this.pTq.pNq.pQe.field_peerId, this.pTq.pNq.pQe.field_capInfo, str);
      com.tencent.mm.plugin.report.service.h.nFQ.a(11525, true, true, new Object[] { Integer.valueOf(paramcfe.sST), Long.valueOf(paramcfe.sSU), Integer.valueOf(paramcfe.tTG), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext())), Long.valueOf(System.currentTimeMillis()) });
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    y.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.bBq = paramBoolean1;
    if (paramBoolean2)
    {
      this.pTs = paramBoolean1;
      this.pTq.pNq.pQe.pUM = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.pTq.pNq.pQe.pWi.eQa = paramString;
      return;
      this.pTq.pNq.pQe.pUM = 1;
      this.pTt = paramBoolean1;
    }
  }
  
  public final void aP(Context paramContext, String paramString)
  {
    y.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + paramString);
    if ((bk.bl(paramString)) || (System.currentTimeMillis() - this.pTu < 2000L)) {}
    do
    {
      return;
      if (System.currentTimeMillis() - this.pTx < this.pTy)
      {
        y.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
        com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_server_not_available, a.e.voip_warnning_title, null);
        return;
      }
      this.pTu = System.currentTimeMillis();
    } while (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString) == null);
    a(paramContext, paramString, true, false, false);
    bRb();
  }
  
  public final void aQ(Context paramContext, String paramString)
  {
    y.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + paramString);
    if ((bk.bl(paramString)) || (System.currentTimeMillis() - this.pTu < 2000L)) {}
    do
    {
      return;
      if (System.currentTimeMillis() - this.pTx < this.pTy)
      {
        y.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
        com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_server_not_available, a.e.voip_warnning_title, null);
        return;
      }
      this.pTu = System.currentTimeMillis();
    } while (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString) == null);
    a(paramContext, paramString, true, true, false);
    bRb();
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 18
    //   3: lconst_0
    //   4: lstore 16
    //   6: lconst_0
    //   7: lstore 8
    //   9: lconst_0
    //   10: lstore 12
    //   12: lconst_0
    //   13: lstore 10
    //   15: ldc 206
    //   17: ldc_w 1008
    //   20: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   27: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   30: getfield 1011	com/tencent/mm/plugin/voip/model/j:pQi	[B
    //   33: invokestatic 1013	com/tencent/mm/plugin/voip/model/r:aT	([B)Ljava/util/Map;
    //   36: astore 24
    //   38: aload 24
    //   40: ifnonnull +335 -> 375
    //   43: ldc 206
    //   45: ldc_w 1015
    //   48: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: lconst_0
    //   52: lstore 14
    //   54: ldc 206
    //   56: new 349	java/lang/StringBuilder
    //   59: dup
    //   60: ldc_w 1017
    //   63: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: lload 18
    //   68: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: ldc_w 1019
    //   74: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: lload 16
    //   79: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 1021
    //   85: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: lload 14
    //   90: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: new 1023	com/tencent/mm/protocal/c/cfa
    //   102: dup
    //   103: invokespecial 1024	com/tencent/mm/protocal/c/cfa:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 1025	com/tencent/mm/protocal/c/cfa:aH	([B)Lcom/tencent/mm/bv/a;
    //   110: checkcast 1023	com/tencent/mm/protocal/c/cfa
    //   113: astore 24
    //   115: iconst_0
    //   116: istore 5
    //   118: iload 5
    //   120: aload 24
    //   122: getfield 1028	com/tencent/mm/protocal/c/cfa:tTH	Ljava/util/LinkedList;
    //   125: invokevirtual 197	java/util/LinkedList:size	()I
    //   128: if_icmpge +1065 -> 1193
    //   131: aload 24
    //   133: getfield 1028	com/tencent/mm/protocal/c/cfa:tTH	Ljava/util/LinkedList;
    //   136: iload 5
    //   138: invokevirtual 368	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   141: checkcast 1030	com/tencent/mm/protocal/c/cez
    //   144: astore 25
    //   146: ldc 206
    //   148: new 349	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 1032
    //   155: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 25
    //   160: getfield 1035	com/tencent/mm/protocal/c/cez:sOA	I
    //   163: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 25
    //   174: getfield 1035	com/tencent/mm/protocal/c/cez:sOA	I
    //   177: iconst_1
    //   178: if_icmpne +458 -> 636
    //   181: new 1037	com/tencent/mm/protocal/c/cga
    //   184: dup
    //   185: invokespecial 1038	com/tencent/mm/protocal/c/cga:<init>	()V
    //   188: aload 25
    //   190: getfield 1042	com/tencent/mm/protocal/c/cez:szp	Lcom/tencent/mm/protocal/c/bmk;
    //   193: getfield 1047	com/tencent/mm/protocal/c/bmk:tFM	Lcom/tencent/mm/bv/b;
    //   196: getfield 1050	com/tencent/mm/bv/b:oY	[B
    //   199: invokevirtual 1051	com/tencent/mm/protocal/c/cga:aH	([B)Lcom/tencent/mm/bv/a;
    //   202: checkcast 1037	com/tencent/mm/protocal/c/cga
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +406 -> 613
    //   210: ldc 206
    //   212: new 349	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 1053
    //   219: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload_1
    //   223: getfield 1056	com/tencent/mm/protocal/c/cga:hQq	I
    //   226: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: lload 8
    //   237: aload 25
    //   239: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   242: i2l
    //   243: lcmp
    //   244: ifge +1170 -> 1414
    //   247: aload 25
    //   249: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   252: i2l
    //   253: lstore 6
    //   255: lload 6
    //   257: lstore 8
    //   259: aload 25
    //   261: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   264: i2l
    //   265: lload 18
    //   267: lcmp
    //   268: ifle +353 -> 621
    //   271: ldc 206
    //   273: new 349	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1059
    //   280: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload 25
    //   285: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   288: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 1061
    //   294: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: lload 18
    //   299: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   302: ldc_w 1063
    //   305: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: getfield 1056	com/tencent/mm/protocal/c/cga:hQq	I
    //   312: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: ldc_w 1065
    //   318: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   331: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   334: getfield 1069	com/tencent/mm/plugin/voip/model/j:pQh	Lcom/tencent/mm/plugin/voip/model/t;
    //   337: aload_1
    //   338: iconst_1
    //   339: invokevirtual 1074	com/tencent/mm/plugin/voip/model/t:a	(Lcom/tencent/mm/protocal/c/cga;I)V
    //   342: lload 6
    //   344: lstore 20
    //   346: lload 10
    //   348: lstore 22
    //   350: lload 12
    //   352: lstore 6
    //   354: iload 5
    //   356: iconst_1
    //   357: iadd
    //   358: istore 5
    //   360: lload 20
    //   362: lstore 8
    //   364: lload 6
    //   366: lstore 12
    //   368: lload 22
    //   370: lstore 10
    //   372: goto -254 -> 118
    //   375: aload 24
    //   377: invokeinterface 148 1 0
    //   382: invokeinterface 154 1 0
    //   387: astore 25
    //   389: lconst_0
    //   390: lstore 6
    //   392: aload 25
    //   394: invokeinterface 160 1 0
    //   399: ifeq +1022 -> 1421
    //   402: aload 25
    //   404: invokeinterface 164 1 0
    //   409: checkcast 166	java/lang/Integer
    //   412: astore 26
    //   414: aload 24
    //   416: aload 26
    //   418: invokeinterface 180 2 0
    //   423: checkcast 182	java/lang/Long
    //   426: astore 27
    //   428: aload 26
    //   430: invokevirtual 173	java/lang/Integer:intValue	()I
    //   433: tableswitch	default:+27 -> 460, 1:+67->500, 2:+77->510, 3:+87->520
    //   461: <illegal opcode>
    //   462: new 349	java/lang/StringBuilder
    //   465: dup
    //   466: ldc_w 1076
    //   469: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload 26
    //   474: invokevirtual 173	java/lang/Integer:intValue	()I
    //   477: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: ldc_w 1078
    //   483: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 27
    //   488: invokevirtual 1081	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -105 -> 392
    //   500: aload 27
    //   502: invokevirtual 1084	java/lang/Long:longValue	()J
    //   505: lstore 18
    //   507: goto -115 -> 392
    //   510: aload 27
    //   512: invokevirtual 1084	java/lang/Long:longValue	()J
    //   515: lstore 16
    //   517: goto -125 -> 392
    //   520: aload 27
    //   522: invokevirtual 1084	java/lang/Long:longValue	()J
    //   525: lstore 6
    //   527: goto -135 -> 392
    //   530: astore 24
    //   532: ldc 206
    //   534: aload 24
    //   536: ldc 208
    //   538: iconst_0
    //   539: anewarray 4	java/lang/Object
    //   542: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: aload_1
    //   546: invokestatic 1086	com/tencent/mm/plugin/voip/model/r:aU	([B)Ljava/lang/String;
    //   549: astore 24
    //   551: ldc 206
    //   553: new 349	java/lang/StringBuilder
    //   556: dup
    //   557: ldc_w 1088
    //   560: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   563: aload_1
    //   564: arraylength
    //   565: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: ldc_w 1090
    //   571: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 24
    //   576: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: astore_1
    //   588: ldc 206
    //   590: ldc_w 1092
    //   593: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: ldc 206
    //   598: aload_1
    //   599: ldc 208
    //   601: iconst_0
    //   602: anewarray 4	java/lang/Object
    //   605: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   608: aconst_null
    //   609: astore_1
    //   610: goto -404 -> 206
    //   613: ldc 206
    //   615: ldc_w 1092
    //   618: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: lload 8
    //   623: lstore 20
    //   625: lload 12
    //   627: lstore 6
    //   629: lload 10
    //   631: lstore 22
    //   633: goto -279 -> 354
    //   636: aload 25
    //   638: getfield 1035	com/tencent/mm/protocal/c/cez:sOA	I
    //   641: iconst_2
    //   642: if_icmpne +337 -> 979
    //   645: new 1094	com/tencent/mm/protocal/c/cfp
    //   648: dup
    //   649: invokespecial 1095	com/tencent/mm/protocal/c/cfp:<init>	()V
    //   652: aload 25
    //   654: getfield 1042	com/tencent/mm/protocal/c/cez:szp	Lcom/tencent/mm/protocal/c/bmk;
    //   657: getfield 1047	com/tencent/mm/protocal/c/bmk:tFM	Lcom/tencent/mm/bv/b;
    //   660: getfield 1050	com/tencent/mm/bv/b:oY	[B
    //   663: invokevirtual 1096	com/tencent/mm/protocal/c/cfp:aH	([B)Lcom/tencent/mm/bv/a;
    //   666: checkcast 1094	com/tencent/mm/protocal/c/cfp
    //   669: astore_1
    //   670: aload_1
    //   671: ifnull +285 -> 956
    //   674: ldc 206
    //   676: new 349	java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w 1098
    //   683: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload_1
    //   687: getfield 1101	com/tencent/mm/protocal/c/cfp:hQR	I
    //   690: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: lload 12
    //   701: aload 25
    //   703: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   706: i2l
    //   707: lcmp
    //   708: ifge +699 -> 1407
    //   711: aload 25
    //   713: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   716: i2l
    //   717: lstore 6
    //   719: aload 25
    //   721: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   724: i2l
    //   725: lload 16
    //   727: lcmp
    //   728: ifle +174 -> 902
    //   731: ldc 206
    //   733: new 349	java/lang/StringBuilder
    //   736: dup
    //   737: ldc_w 1103
    //   740: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   743: aload 25
    //   745: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   748: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: ldc_w 1105
    //   754: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: lload 16
    //   759: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   762: ldc_w 1065
    //   765: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: aload_1
    //   775: getfield 1101	com/tencent/mm/protocal/c/cfp:hQR	I
    //   778: iconst_5
    //   779: if_icmpne +54 -> 833
    //   782: aload_0
    //   783: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   786: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   789: getfield 1069	com/tencent/mm/plugin/voip/model/j:pQh	Lcom/tencent/mm/plugin/voip/model/t;
    //   792: aload_1
    //   793: invokevirtual 1108	com/tencent/mm/plugin/voip/model/t:a	(Lcom/tencent/mm/protocal/c/cfp;)V
    //   796: lload 8
    //   798: lstore 20
    //   800: lload 10
    //   802: lstore 22
    //   804: goto -450 -> 354
    //   807: astore_1
    //   808: ldc 206
    //   810: ldc_w 1110
    //   813: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   816: ldc 206
    //   818: aload_1
    //   819: ldc 208
    //   821: iconst_0
    //   822: anewarray 4	java/lang/Object
    //   825: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   828: aconst_null
    //   829: astore_1
    //   830: goto -160 -> 670
    //   833: aload_1
    //   834: getfield 1101	com/tencent/mm/protocal/c/cfp:hQR	I
    //   837: iconst_1
    //   838: if_icmpne +28 -> 866
    //   841: aload_0
    //   842: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   845: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   848: getfield 1069	com/tencent/mm/plugin/voip/model/j:pQh	Lcom/tencent/mm/plugin/voip/model/t;
    //   851: aload_1
    //   852: invokevirtual 1112	com/tencent/mm/plugin/voip/model/t:b	(Lcom/tencent/mm/protocal/c/cfp;)V
    //   855: lload 8
    //   857: lstore 20
    //   859: lload 10
    //   861: lstore 22
    //   863: goto -509 -> 354
    //   866: ldc 206
    //   868: new 349	java/lang/StringBuilder
    //   871: dup
    //   872: ldc_w 1114
    //   875: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   878: aload_1
    //   879: getfield 1101	com/tencent/mm/protocal/c/cfp:hQR	I
    //   882: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   885: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: lload 8
    //   893: lstore 20
    //   895: lload 10
    //   897: lstore 22
    //   899: goto -545 -> 354
    //   902: ldc 206
    //   904: new 349	java/lang/StringBuilder
    //   907: dup
    //   908: ldc_w 1116
    //   911: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   914: aload 25
    //   916: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   919: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   922: ldc_w 1118
    //   925: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: lload 16
    //   930: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   933: ldc_w 1065
    //   936: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: lload 8
    //   947: lstore 20
    //   949: lload 10
    //   951: lstore 22
    //   953: goto -599 -> 354
    //   956: ldc 206
    //   958: ldc_w 1110
    //   961: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: lload 8
    //   966: lstore 20
    //   968: lload 12
    //   970: lstore 6
    //   972: lload 10
    //   974: lstore 22
    //   976: goto -622 -> 354
    //   979: lload 8
    //   981: lstore 20
    //   983: lload 12
    //   985: lstore 6
    //   987: lload 10
    //   989: lstore 22
    //   991: aload 25
    //   993: getfield 1035	com/tencent/mm/protocal/c/cez:sOA	I
    //   996: iconst_3
    //   997: if_icmpne -643 -> 354
    //   1000: new 1044	com/tencent/mm/protocal/c/bmk
    //   1003: dup
    //   1004: invokespecial 1119	com/tencent/mm/protocal/c/bmk:<init>	()V
    //   1007: aload 25
    //   1009: getfield 1042	com/tencent/mm/protocal/c/cez:szp	Lcom/tencent/mm/protocal/c/bmk;
    //   1012: getfield 1047	com/tencent/mm/protocal/c/bmk:tFM	Lcom/tencent/mm/bv/b;
    //   1015: getfield 1050	com/tencent/mm/bv/b:oY	[B
    //   1018: invokevirtual 1123	com/tencent/mm/protocal/c/bmk:bt	([B)Lcom/tencent/mm/protocal/c/bmk;
    //   1021: astore_1
    //   1022: lload 8
    //   1024: lstore 20
    //   1026: lload 12
    //   1028: lstore 6
    //   1030: lload 10
    //   1032: lstore 22
    //   1034: aload_1
    //   1035: ifnull -681 -> 354
    //   1038: lload 10
    //   1040: aload 25
    //   1042: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   1045: i2l
    //   1046: lcmp
    //   1047: ifge +353 -> 1400
    //   1050: aload 25
    //   1052: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   1055: i2l
    //   1056: lstore 6
    //   1058: aload 25
    //   1060: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   1063: i2l
    //   1064: lload 14
    //   1066: lcmp
    //   1067: ifle +93 -> 1160
    //   1070: ldc 206
    //   1072: new 349	java/lang/StringBuilder
    //   1075: dup
    //   1076: ldc_w 1125
    //   1079: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1082: aload 25
    //   1084: getfield 1057	com/tencent/mm/protocal/c/cez:nFi	I
    //   1087: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: ldc_w 1127
    //   1093: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: lload 14
    //   1098: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1101: ldc_w 1065
    //   1104: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: aload_0
    //   1114: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   1117: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   1120: getfield 1069	com/tencent/mm/plugin/voip/model/j:pQh	Lcom/tencent/mm/plugin/voip/model/t;
    //   1123: aload_1
    //   1124: invokevirtual 1130	com/tencent/mm/plugin/voip/model/t:c	(Lcom/tencent/mm/protocal/c/bmk;)V
    //   1127: aload_0
    //   1128: getfield 88	com/tencent/mm/plugin/voip/model/r:pTD	Lcom/tencent/mm/protocal/c/cfe;
    //   1131: ifnull +29 -> 1160
    //   1134: aload_1
    //   1135: getfield 1047	com/tencent/mm/protocal/c/bmk:tFM	Lcom/tencent/mm/bv/b;
    //   1138: invokevirtual 1131	com/tencent/mm/bv/b:toByteArray	()[B
    //   1141: invokestatic 1135	com/tencent/mm/plugin/voip/a/a:aX	([B)I
    //   1144: sipush 255
    //   1147: iand
    //   1148: iconst_1
    //   1149: if_icmpne +11 -> 1160
    //   1152: aload_0
    //   1153: getfield 88	com/tencent/mm/plugin/voip/model/r:pTD	Lcom/tencent/mm/protocal/c/cfe;
    //   1156: iconst_1
    //   1157: putfield 812	com/tencent/mm/protocal/c/cfe:tTG	I
    //   1160: lload 6
    //   1162: lstore 22
    //   1164: lload 8
    //   1166: lstore 20
    //   1168: lload 12
    //   1170: lstore 6
    //   1172: goto -818 -> 354
    //   1175: astore_1
    //   1176: ldc 206
    //   1178: aload_1
    //   1179: ldc 208
    //   1181: iconst_0
    //   1182: anewarray 4	java/lang/Object
    //   1185: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: aconst_null
    //   1189: astore_1
    //   1190: goto -168 -> 1022
    //   1193: lload 8
    //   1195: lload 18
    //   1197: lcmp
    //   1198: ifle +195 -> 1393
    //   1201: lload 12
    //   1203: lload 16
    //   1205: lcmp
    //   1206: ifle +180 -> 1386
    //   1209: lload 10
    //   1211: lload 14
    //   1213: lcmp
    //   1214: ifle +165 -> 1379
    //   1217: new 71	java/util/HashMap
    //   1220: dup
    //   1221: invokespecial 72	java/util/HashMap:<init>	()V
    //   1224: astore_1
    //   1225: aload_1
    //   1226: iconst_1
    //   1227: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1230: lload 8
    //   1232: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1235: invokeinterface 377 3 0
    //   1240: pop
    //   1241: aload_1
    //   1242: iconst_2
    //   1243: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: lload 12
    //   1248: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1251: invokeinterface 377 3 0
    //   1256: pop
    //   1257: aload_1
    //   1258: iconst_3
    //   1259: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1262: lload 10
    //   1264: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1267: invokeinterface 377 3 0
    //   1272: pop
    //   1273: aload_1
    //   1274: invokestatic 1137	com/tencent/mm/plugin/voip/model/r:O	(Ljava/util/Map;)[B
    //   1277: astore_1
    //   1278: iload_2
    //   1279: aload_0
    //   1280: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   1283: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   1286: getfield 491	com/tencent/mm/plugin/voip/model/j:pQe	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1289: getfield 688	com/tencent/mm/plugin/voip/model/v2protocal:lpD	I
    //   1292: if_icmpne +77 -> 1369
    //   1295: lload_3
    //   1296: aload_0
    //   1297: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   1300: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   1303: getfield 491	com/tencent/mm/plugin/voip/model/j:pQe	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1306: getfield 719	com/tencent/mm/plugin/voip/model/v2protocal:lpE	J
    //   1309: lcmp
    //   1310: ifne +59 -> 1369
    //   1313: aload_0
    //   1314: getfield 120	com/tencent/mm/plugin/voip/model/r:pTq	Lcom/tencent/mm/plugin/voip/model/s;
    //   1317: getfield 485	com/tencent/mm/plugin/voip/model/s:pNq	Lcom/tencent/mm/plugin/voip/model/j;
    //   1320: aload_1
    //   1321: putfield 1011	com/tencent/mm/plugin/voip/model/j:pQi	[B
    //   1324: ldc 206
    //   1326: new 349	java/lang/StringBuilder
    //   1329: dup
    //   1330: ldc_w 1139
    //   1333: invokespecial 354	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1336: lload 8
    //   1338: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1341: ldc_w 1141
    //   1344: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: lload 12
    //   1349: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1352: ldc_w 1141
    //   1355: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: lload 10
    //   1360: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: ldc 206
    //   1371: ldc_w 1143
    //   1374: invokestatic 292	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1377: iconst_0
    //   1378: ireturn
    //   1379: lload 14
    //   1381: lstore 10
    //   1383: goto -166 -> 1217
    //   1386: lload 16
    //   1388: lstore 12
    //   1390: goto -181 -> 1209
    //   1393: lload 18
    //   1395: lstore 8
    //   1397: goto -196 -> 1201
    //   1400: lload 10
    //   1402: lstore 6
    //   1404: goto -346 -> 1058
    //   1407: lload 12
    //   1409: lstore 6
    //   1411: goto -692 -> 719
    //   1414: lload 8
    //   1416: lstore 6
    //   1418: goto -1163 -> 255
    //   1421: lload 6
    //   1423: lstore 14
    //   1425: goto -1371 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1428	0	this	r
    //   0	1428	1	paramArrayOfByte	byte[]
    //   0	1428	2	paramInt	int
    //   0	1428	3	paramLong	long
    //   116	243	5	i	int
    //   253	1169	6	l1	long
    //   7	1408	8	l2	long
    //   13	1388	10	l3	long
    //   10	1398	12	l4	long
    //   52	1372	14	l5	long
    //   4	1383	16	l6	long
    //   1	1393	18	l7	long
    //   344	823	20	l8	long
    //   348	815	22	l9	long
    //   36	379	24	localObject1	Object
    //   530	5	24	localException	Exception
    //   549	26	24	str	String
    //   144	939	25	localObject2	Object
    //   412	61	26	localInteger	Integer
    //   426	95	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   99	115	530	java/lang/Exception
    //   181	206	587	java/io/IOException
    //   645	670	807	java/io/IOException
    //   1000	1022	1175	java/io/IOException
  }
  
  public final int bPH()
  {
    l locall = this.pTq.pNq.pQg;
    if (locall.pQB != null) {
      return locall.pQB.bPH();
    }
    return 0;
  }
  
  public final int bRc()
  {
    s locals = this.pTq;
    y.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (locals.pNq.pQe.lpD == 0)
    {
      locals.pNq.pQg.bQl();
      locals.reset();
      return 0;
    }
    locals.pNq.pQe.pWi.pQU = locals.pNq.bPU();
    return locals.bRu();
  }
  
  public final int bRd()
  {
    return this.pTq.pNq.pQe.lpD;
  }
  
  public final long bRe()
  {
    return this.pTq.pNq.pQe.lpE;
  }
  
  public final long bRf()
  {
    return this.pTq.pNq.pQe.pUM;
  }
  
  public final boolean bRg()
  {
    return this.pTq.pNq.bQc();
  }
  
  public final boolean bRh()
  {
    return this.pTq.pNq.bQd();
  }
  
  public final void bRi()
  {
    y.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.pTq.pNq.pQe.pWi.pRg = 1;
  }
  
  public final boolean bRj()
  {
    s locals = this.pTq;
    if (locals.pTJ != null) {
      return locals.pTJ.amn();
    }
    return true;
  }
  
  public final boolean bRm()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.pTq.pNq.pQe != null)
      {
        int i = this.pTq.pNq.pQe.pVj;
        bool1 = bool2;
        if ((i & 0x8) != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
    }
    return false;
  }
  
  public final void bRn()
  {
    this.pTq.pTT.S(1000L, 1000L);
  }
  
  public final void bRo()
  {
    l locall = this.pTq.pNq.pQg;
    y.l("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { locall.iEq });
    synchronized (locall.iEx)
    {
      if (locall.iEq != null)
      {
        y.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
        locall.iEq.uh();
        locall.iEq = null;
      }
      return;
    }
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    s locals = this.pTq;
    if ((locals.pTJ != null) && (paramInt1 > 0)) {
      locals.pTJ.o(paramInt1, paramInt2, true);
    }
  }
  
  protected final void finalize()
  {
    this.pTq.stop();
    this.pTq = null;
    com.tencent.mm.kernel.g.DO().b(this.nIV);
    super.finalize();
  }
  
  public final void hH(boolean paramBoolean)
  {
    y.l("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      int i = (byte)j;
      this.pTq.pNq.pQe.setAppCmd(425, new byte[] { i }, 1);
      return;
    }
  }
  
  public final boolean jQ(boolean paramBoolean)
  {
    l locall = this.pTq.pNq.pQg;
    if (locall.pQB != null) {
      return locall.pQB.jQ(paramBoolean);
    }
    return false;
  }
  
  public final int jY(boolean paramBoolean)
  {
    j localj = this.pTq.pNq;
    if (paramBoolean) {}
    for (int i = localj.pQe.um(412);; i = localj.pQe.um(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + i);
      }
      return i;
    }
  }
  
  public final int jZ(boolean paramBoolean)
  {
    j localj = this.pTq.pNq;
    if (paramBoolean) {}
    for (int i = localj.pQe.um(401);; i = localj.pQe.um(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + i);
      }
      return i;
    }
  }
  
  public final void l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    s locals = this.pTq;
    if ((locals.pTJ != null) && (paramInt1 > 0)) {
      locals.pTJ.n(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void stopRing()
  {
    s locals = this.pTq;
    if (locals.pTJ != null) {
      locals.pTJ.stop();
    }
  }
  
  public final void zY(int paramInt)
  {
    this.pTq.pNq.zY(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */