package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.qn;
import com.tencent.mm.model.ap;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bug;
import com.tencent.mm.protocal.c.buh;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.ah.m
  implements com.tencent.mm.network.k
{
  private static List<ap> oqs = new LinkedList();
  private static c oqu;
  private static boolean oqv = true;
  private String diG = "";
  com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  private u.a oqt = new u.a(this);
  
  public u()
  {
    localObject = new b.a();
    ((b.a)localObject).ecH = new bug();
    ((b.a)localObject).ecI = new buh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((b.a)localObject).ecG = 214;
    ((b.a)localObject).ecJ = 102;
    ((b.a)localObject).ecK = 1000000102;
    this.dmK = ((b.a)localObject).Kt();
    ((bug)this.dmK.ecE.ecN).sIh = 256;
    this.diG = com.tencent.mm.model.q.Gj();
    long l;
    byte[] arrayOfByte;
    if (oqv)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.DQ();
      localObject = com.tencent.mm.kernel.g.DP().cachePath + "ad_1100007";
      y.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + (String)localObject);
      arrayOfByte = com.tencent.mm.vfs.e.c((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      oqu = (c)new c().aH(arrayOfByte);
      y.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (oqu != null) {
        break label270;
      }
      y.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.e.deleteFile((String)localObject);
        continue;
        y.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + oqu.owR.size());
      }
    }
    oqv = false;
  }
  
  private static void Hl()
  {
    Iterator localIterator = oqs.iterator();
    while (localIterator.hasNext())
    {
      ap localap = (ap)localIterator.next();
      if (localap != null) {
        localap.Hl();
      }
    }
  }
  
  public static void a(ap paramap)
  {
    if (!oqs.contains(paramap)) {
      oqs.add(paramap);
    }
  }
  
  private static boolean a(bsy parambsy)
  {
    for (;;)
    {
      try
      {
        bsx localbsx1 = parambsy.tJB;
        long l1 = parambsy.sGd;
        String str = bk.pm(parambsy.nde);
        long l2 = parambsy.tJA;
        i = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLimit"), 0);
        int j = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLikeTimeLimit"), 0);
        int k = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyCommentTimeLimit"), 0);
        if (((i > 0) || (j > 0) || (k > 0)) && ((localbsx1.hQR == 8) || (localbsx1.hQR == 7)) && (!a.a(l1, parambsy, i, j, k, true)))
        {
          y.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + l1 + " " + localbsx1.tJx + " " + localbsx1.tJu + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
          a.a(l1, parambsy);
          return false;
        }
        y.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + l1 + " " + localbsx1.tJx + " " + localbsx1.tJu + " actionLimit: " + i);
        if (!af.bDK().a(l1, localbsx1.tAY, localbsx1.mPL, str))
        {
          bsx localbsx2 = parambsy.tJC;
          j localj = new j();
          localj.field_snsID = l1;
          localj.field_parentID = l2;
          localj.field_createTime = localbsx1.mPL;
          localj.field_talker = localbsx1.tAY;
          localj.field_type = localbsx1.hQR;
          localj.field_curActionBuf = localbsx1.toByteArray();
          localj.field_refActionBuf = localbsx2.toByteArray();
          localj.field_clientId = str;
          if ((localbsx1.tJz & 0x2) == 0)
          {
            i = 0;
            localj.field_isSilence = i;
            if ((localbsx1.hQR == 8) || (localbsx1.hQR == 7))
            {
              localj.field_commentSvrID = localbsx1.tJx;
              if (!a.a(l1, parambsy))
              {
                y.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
                return false;
              }
            }
            else
            {
              localj.field_commentSvrID = localbsx1.tJu;
              if (!aj.a(l1, parambsy)) {
                return false;
              }
            }
            af.bDK().b(localj);
            parambsy = af.bDK();
            if ((localbsx1.tJz & 0x2) != 0)
            {
              bool = true;
              parambsy.u(l1, bool);
              return true;
            }
            boolean bool = false;
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception parambsy)
      {
        y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", parambsy, "", new Object[0]);
        return false;
      }
      int i = 1;
    }
  }
  
  private static boolean a(bsy parambsy, bsx parambsx, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      y.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + parambsx.tJx + " " + parambsx.tJu);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.bCv())
      {
        y.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        return false;
      }
      if (!af.bDK().a(paramLong1, parambsx.tAY, parambsx.mPL, paramString))
      {
        bsx localbsx = parambsy.tJC;
        j localj = new j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = parambsx.mPL;
        localj.field_talker = parambsx.tAY;
        localj.field_type = parambsx.hQR;
        localj.field_curActionBuf = parambsx.toByteArray();
        localj.field_refActionBuf = localbsx.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = parambsx.tJu;
        y.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + parambsx.tJy);
        aj.c(paramLong1, parambsy);
        Hl();
        af.bDK().b(localj);
        return true;
      }
    }
    catch (Exception parambsy)
    {
      y.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + parambsy.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", parambsy, "", new Object[0]);
    }
    return false;
  }
  
  public static void b(ap paramap)
  {
    oqs.remove(paramap);
  }
  
  private static boolean b(bsy parambsy, bsx parambsx, long paramLong1, long paramLong2, String paramString)
  {
    boolean bool = false;
    try
    {
      y.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + parambsx.tJx + " " + parambsx.tJu);
      if (!af.bDK().a(paramLong1, parambsx.tAY, parambsx.mPL, paramString))
      {
        bsx localbsx = parambsy.tJC;
        parambsy = new j();
        parambsy.field_snsID = paramLong1;
        parambsy.field_parentID = paramLong2;
        parambsy.field_createTime = parambsx.mPL;
        parambsy.field_talker = parambsx.tAY;
        parambsy.field_type = parambsx.hQR;
        parambsy.field_curActionBuf = parambsx.toByteArray();
        parambsy.field_refActionBuf = localbsx.toByteArray();
        parambsy.field_clientId = paramString;
        parambsy.field_commentSvrID = parambsx.tJu;
        paramString = new aoz();
        y.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + parambsx.tJy);
        paramString.aH(aa.a(parambsx.tJy));
        y.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.ceq);
        af.bDK().b(parambsy);
        bool = true;
      }
      return bool;
    }
    catch (Exception parambsy)
    {
      y.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + parambsy.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", parambsy, "", new Object[0]);
    }
    return false;
  }
  
  public static void bDa()
  {
    if (oqu == null) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    localObject = com.tencent.mm.kernel.g.DP().cachePath + "ad_1100007";
    y.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + (String)localObject);
    try
    {
      byte[] arrayOfByte = oqu.toByteArray();
      com.tencent.mm.vfs.e.b((String)localObject, arrayOfByte, arrayOfByte.length);
      y.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + oqu.owR.size());
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: " + (String)localObject, new Object[0]);
    }
  }
  
  public static void bDb()
  {
    Iterator localIterator = oqs.iterator();
    while (localIterator.hasNext())
    {
      ap localap = (ap)localIterator.next();
      if (localap != null) {
        localap.Hm();
      }
    }
  }
  
  public static void fX(long paramLong)
  {
    if (oqu == null) {
      oqu = new c();
    }
    oqu.owR.add(Long.valueOf(paramLong));
  }
  
  public static void fY(long paramLong)
  {
    if (oqu != null) {
      oqu.owR.remove(Long.valueOf(paramLong));
    }
  }
  
  public static boolean fZ(long paramLong)
  {
    if (oqu == null) {}
    while (!oqu.owR.contains(Long.valueOf(paramLong))) {
      return false;
    }
    return true;
  }
  
  public static boolean ga(long paramLong)
  {
    try
    {
      boolean bool = a.a(paramLong, null, bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLimit"), 0), bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLikeTimeLimit"), 0), bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
    }
    return true;
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    com.tencent.mm.kernel.g.DQ();
    byte[] arrayOfByte = bk.ZM(bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(8195, null)));
    bmk localbmk = new bmk();
    localbmk.bs(arrayOfByte);
    ((bug)this.dmK.ecE.ecN).sIi = localbmk;
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    buh localbuh = (buh)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    paramArrayOfByte = localbuh.sIl.hPT;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      y.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.oqt;
      paramString.jZU = paramArrayOfByte;
      paramString.jZV.sendEmptyMessage(0);
      return;
    }
    if ((localbuh.sIi != null) && (localbuh.sIi.tFM != null))
    {
      paramArrayOfByte = localbuh.sIi.tFM.toByteArray();
      paramq = com.tencent.mm.protocal.z.g(((bug)((com.tencent.mm.ah.b)paramq).ecE.ecN).sIi.tFM.toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().o(8195, bk.bG(paramq));
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final boolean a(qv paramqv, ah paramah)
  {
    bto localbto;
    boolean bool;
    String str;
    int j;
    try
    {
      localbto = (bto)new bto().aH(paramqv.sOB.tFM.toByteArray());
      paramqv = new String(localbto.tJU.tFM.toByteArray());
      if (paramqv.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label428;
      }
      if (paramqv.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label443;
      }
    }
    catch (Exception paramqv)
    {
      l locall;
      String[] arrayOfString;
      int i;
      y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramqv, "", new Object[0]);
      return false;
    }
    y.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localbto.sGd + " " + com.tencent.mm.plugin.sns.data.i.fN(localbto.sGd) + " isPhoto " + bool);
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.i.fN(localbto.sGd);
      locall = af.bDJ().OF(localbto.sxM);
      if (bk.bl(locall.field_newerIds)) {
        break label362;
      }
      arrayOfString = locall.field_newerIds.split(",");
      j = 0;
      i = 1;
      label178:
      if (j >= arrayOfString.length) {
        break label449;
      }
      if (!str.equals(arrayOfString[j])) {
        break label434;
      }
      i = 0;
      break label434;
    }
    for (;;)
    {
      if ((j < 2) && (j < arrayOfString.length) && (i != 0))
      {
        paramqv = paramqv + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        y.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localbto.sGd + " S: " + str + " list " + locall.field_newerIds + " newer " + paramqv);
        if (i != 0) {
          af.bDJ().eX(localbto.sxM, paramqv);
        }
        while (af.bDF().gl(localbto.sGd))
        {
          y.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          return false;
          label362:
          af.bDJ().eX(localbto.sxM, str);
        }
        com.tencent.mm.sdk.b.a.udP.m(new qn());
        af.aXq().post(new u.1(this, localbto, paramah));
        return true;
        label428:
        bool = true;
        break;
        label434:
        j += 1;
        break label178;
        label443:
        bool = false;
        break;
        label449:
        j = 0;
        paramqv = str;
      }
    }
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final boolean b(qv paramqv, ah paramah)
  {
    for (;;)
    {
      bsy localbsy;
      long l1;
      long l2;
      bsx localbsx1;
      Object localObject;
      boolean bool;
      try
      {
        localbsy = (bsy)new bsy().aH(paramqv.sOB.tFM.toByteArray());
        l1 = localbsy.sGd;
        l2 = localbsy.tJA;
        localbsx1 = localbsy.tJB;
        localObject = localbsy.nde;
        paramqv = (qv)localObject;
        if (localObject == null) {
          paramqv = "";
        }
        y.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localbsx1.hQR + " " + l1 + " " + paramqv);
        switch (localbsx1.hQR)
        {
        case 9: 
          a(localbsy);
          if ((localbsx1.tJz & 0x2) != 0) {
            break label1188;
          }
          bool = true;
          af.aXq().post(new u.2(this, bool, localbsx1, paramah));
          return true;
        }
      }
      catch (Exception paramqv)
      {
        y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramqv, "", new Object[0]);
        return false;
      }
      paramqv = af.bDK().d(l1, localbsx1.tJu, localbsx1.hQR);
      if (paramqv != null)
      {
        paramqv.bGn();
        bool = af.bDK().a(paramqv.ujK, paramqv);
        aj.b(l1, localbsy);
        y.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + bool);
        continue;
        paramqv = af.bDK().d(l1, localbsx1.tJx, localbsx1.hQR);
        label1188:
        if (paramqv != null)
        {
          paramqv.bGn();
          bool = af.bDK().a(paramqv.ujK, paramqv);
          aj.b(l1, localbsy);
          y.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + bool);
          continue;
          paramqv = af.bDK();
          localObject = " update SnsComment set commentflag = 2 where snsID = " + l1;
          y.i("MicroMsg.SnsCommentStorage", "set sns del " + (String)localObject);
          bool = paramqv.dXo.gk("SnsComment", (String)localObject);
          if (bool) {
            paramqv.doNotify();
          }
          y.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + bool);
          continue;
          paramqv = af.bDK();
          localObject = localbsx1.tAY;
          localObject = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bk.pl((String)localObject) + "'";
          y.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + (String)localObject);
          bool = paramqv.dXo.gk("SnsComment", (String)localObject);
          if (bool) {
            paramqv.doNotify();
          }
          y.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction " + bool);
          aj.b(l1, localbsy);
          continue;
          a(localbsy, localbsx1, l1, l2, paramqv);
          continue;
          b(localbsy, localbsx1, l1, l2, paramqv);
          continue;
          com.tencent.mm.plugin.sns.storage.i.gm(l1);
          paramqv = af.bDF().gt(l1);
          localObject = paramqv.bGe();
          ((bxk)localObject).cCu = 1;
          paramqv.c((bxk)localObject);
          af.bDF().b(l1, paramqv);
          continue;
          paramqv = localbsx1.swb;
          if (m.fT(l1))
          {
            paramqv = new m(l1, paramqv);
            com.tencent.mm.kernel.g.DQ();
            com.tencent.mm.kernel.g.DO().dJT.a(paramqv, 0);
          }
          j localj;
          for (;;)
          {
            try
            {
              paramqv = localbsy.tJB;
              localObject = bk.pm(localbsy.nde);
              l2 = localbsy.tJA;
              int j = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLimit"), 0);
              int k = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              y.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + paramqv.tJx + " " + paramqv.tJu + " actionLimit: " + j);
              if (af.bDK().a(l1, paramqv.tAY, paramqv.mPL, (String)localObject)) {
                break;
              }
              bsx localbsx2 = localbsy.tJC;
              localj = new j();
              localj.field_snsID = l1;
              localj.field_parentID = l2;
              localj.field_createTime = paramqv.mPL;
              localj.field_talker = paramqv.tAY;
              localj.field_type = paramqv.hQR;
              localj.field_curActionBuf = paramqv.toByteArray();
              localj.field_refActionBuf = localbsx2.toByteArray();
              localj.field_clientId = ((String)localObject);
              if ((paramqv.tJz & 0x2) != 0) {
                break label1085;
              }
              i = 0;
              localj.field_isSilence = i;
              localj.field_commentSvrID = paramqv.tJx;
              if (!af.bDI().gl(l1)) {
                break label1143;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, localbsy, j, k, m, true))) {
                break label1090;
              }
              y.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
            }
            catch (Exception paramqv)
            {
              y.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramqv, "", new Object[0]);
            }
            break;
            label1085:
            int i = 1;
          }
          label1090:
          if (!a.a(l1, localbsy))
          {
            y.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          }
          else
          {
            label1143:
            af.bDK().b(localj);
            localObject = af.bDK();
            if ((paramqv.tJz & 0x2) != 0) {}
            for (bool = true;; bool = false)
            {
              ((com.tencent.mm.plugin.sns.storage.k)localObject).u(l1, bool);
              break;
            }
            bool = false;
          }
        }
      }
    }
  }
  
  public final int getType()
  {
    return 214;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */