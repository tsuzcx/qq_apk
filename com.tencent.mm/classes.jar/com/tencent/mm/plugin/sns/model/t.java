package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static List<au> xRU;
  private static com.tencent.mm.plugin.sns.i.c xRW;
  private static boolean xRX;
  com.tencent.mm.ak.g callback;
  private String fnC;
  com.tencent.mm.ak.b rr;
  private a xRV;
  
  static
  {
    AppMethodBeat.i(95647);
    xRU = new LinkedList();
    xRX = true;
    AppMethodBeat.o(95647);
  }
  
  public t()
  {
    AppMethodBeat.i(95630);
    this.fnC = "";
    this.xRV = new a();
    ac.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hvt = new dbe();
    ((com.tencent.mm.ak.b.a)localObject).hvu = new dbf();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 214;
    ((com.tencent.mm.ak.b.a)localObject).reqCmdId = 102;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 1000000102;
    this.rr = ((com.tencent.mm.ak.b.a)localObject).aAz();
    ((dbe)this.rr.hvr.hvw).Ekh = 256;
    this.fnC = u.axw();
    long l;
    byte[] arrayOfByte;
    if (xRX)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.agS();
      localObject = com.tencent.mm.kernel.g.agR().cachePath + "ad_1100007";
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.i.aU((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      xRW = (com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom(arrayOfByte);
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (xRW != null) {
        break label293;
      }
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.i.deleteFile((String)localObject);
        continue;
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + xRW.yay.size());
      }
    }
    xRX = false;
    AppMethodBeat.o(95630);
  }
  
  public static void a(au paramau)
  {
    AppMethodBeat.i(95645);
    if (!xRU.contains(paramau)) {
      xRU.add(paramau);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(czv paramczv)
  {
    AppMethodBeat.i(95640);
    try
    {
      czu localczu1 = paramczv.FJh;
      long l1 = paramczv.Id;
      Object localObject = bs.nullAsNil(paramczv.hkN);
      long l2 = paramczv.FJg;
      int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLimit"), 0);
      int j = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localczu1.ndI == 8) || (localczu1.ndI == 7)) && (!a.a(l1, paramczv, i, j, k, true)))
      {
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localczu1.FJb + " " + localczu1.FIZ + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramczv);
        AppMethodBeat.o(95640);
        return false;
      }
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localczu1.FJb + " " + localczu1.FIZ + " actionLimit: " + i);
      if (!af.dHW().a(l1, localczu1.Fwn, localczu1.CreateTime, (String)localObject))
      {
        czu localczu2 = paramczv.FJi;
        j localj = new j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = localczu1.CreateTime;
        localj.field_talker = localczu1.Fwn;
        localj.field_type = localczu1.ndI;
        localj.field_curActionBuf = localczu1.toByteArray();
        localj.field_refActionBuf = localczu2.toByteArray();
        localj.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(localczu1.FJd, 2)) {}
        for (i = 1;; i = 0)
        {
          localj.field_isSilence = i;
          if ((localczu1.ndI != 8) && (localczu1.ndI != 7)) {
            break;
          }
          localj.field_commentSvrID = localczu1.FJb;
          if (a.a(l1, paramczv)) {
            break label548;
          }
          ac.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localj.field_commentSvrID = localczu1.FIZ;
        boolean bool = aj.a(l1, paramczv);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label548:
        if ((!bs.gY(localczu1.FJe)) && (localczu1.FJe.get(0) != null))
        {
          paramczv = aj.a((dag)localczu1.FJe.get(0));
          if (az.faZ().GXZ.aOT(paramczv.field_md5) == null)
          {
            az.faZ().GXZ.K(paramczv);
            if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaC, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.fOZ;
              com.tencent.mm.emoji.loader.e.a(paramczv, null);
            }
          }
        }
        af.dHW().insert(localj);
        af.dHW().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.hJ(localczu1.FJd, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramczv)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramczv, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(czv paramczv, czu paramczu, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramczu.FJb + " " + paramczu.FIZ);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.dGQ())
      {
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!af.dHW().a(paramLong1, paramczu.Fwn, paramczu.CreateTime, paramString))
      {
        czu localczu = paramczv.FJi;
        j localj = new j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = paramczu.CreateTime;
        localj.field_talker = paramczu.Fwn;
        localj.field_type = paramczu.ndI;
        localj.field_curActionBuf = paramczu.toByteArray();
        localj.field_refActionBuf = localczu.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = paramczu.FIZ;
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramczu.FJc);
        aj.c(paramLong1, paramczv);
        ayB();
        af.dHW().insert(localj);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramczv)
    {
      ac.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramczv.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramczv, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  private static void ayB()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = xRU.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if (localau != null) {
        localau.ayB();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void b(au paramau)
  {
    AppMethodBeat.i(95646);
    xRU.remove(paramau);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(czv paramczv, czu paramczu, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramczu.FJb + " " + paramczu.FIZ);
      if (!af.dHW().a(paramLong1, paramczu.Fwn, paramczu.CreateTime, paramString))
      {
        czu localczu = paramczv.FJi;
        paramczv = new j();
        paramczv.field_snsID = paramLong1;
        paramczv.field_parentID = paramLong2;
        paramczv.field_createTime = paramczu.CreateTime;
        paramczv.field_talker = paramczu.Fwn;
        paramczv.field_type = paramczu.ndI;
        paramczv.field_curActionBuf = paramczu.toByteArray();
        paramczv.field_refActionBuf = localczu.toByteArray();
        paramczv.field_clientId = paramString;
        paramczv.field_commentSvrID = paramczu.FIZ;
        paramString = new bjl();
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramczu.FJc);
        paramString.parseFrom(z.a(paramczu.FJc));
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.dBN);
        af.dHW().insert(paramczv);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramczv)
    {
      ac.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramczv.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramczv, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  public static void dHm()
  {
    AppMethodBeat.i(95635);
    if (xRW == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().cachePath + "ad_1100007";
    ac.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = xRW.toByteArray();
      com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
      ac.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + xRW.yay.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void dHn()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = xRU.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if (localau != null) {
        localau.ayC();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public static void xi(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (xRW == null) {
      xRW = new com.tencent.mm.plugin.sns.i.c();
    }
    xRW.yay.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void xj(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (xRW != null) {
      xRW.yay.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean xk(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (xRW == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (xRW.yay.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean xl(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLimit"), 0), bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLikeTimeLimit"), 0), bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(95639);
      return bool;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(95639);
    }
    return true;
  }
  
  public final boolean a(xv paramxv, final ao paramao)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramxv.ErM.getBuffer().toByteArray());
      paramxv = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramxv.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramxv.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramxv)
    {
      com.tencent.mm.plugin.sns.storage.n localn;
      String[] arrayOfString;
      int i;
      ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxv, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    ac.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + com.tencent.mm.plugin.sns.data.q.wW(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.q.wW(localSnsObject.Id);
      localn = af.dHV().auY(localSnsObject.Username);
      if (bs.isNullOrNil(localn.field_newerIds)) {
        break label374;
      }
      arrayOfString = localn.field_newerIds.split(",");
      j = 0;
      i = 1;
      label184:
      if (j >= arrayOfString.length) {
        break label473;
      }
      if (!str.equals(arrayOfString[j])) {
        break label458;
      }
      i = 0;
      break label458;
    }
    for (;;)
    {
      if ((j < 2) && (j < arrayOfString.length) && (i != 0))
      {
        paramxv = paramxv + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        ac.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + localn.field_newerIds + " newer " + paramxv);
        if (i != 0) {
          af.dHV().jC(localSnsObject.Username, paramxv);
        }
        while (af.dHR().xC(localSnsObject.Id))
        {
          ac.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          af.dHV().jC(localSnsObject.Username, str);
        }
        com.tencent.mm.sdk.b.a.GpY.l(new ua());
        af.cMM().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(t.a(t.this)))
            {
              com.tencent.mm.kernel.g.agS();
              if (!com.tencent.mm.kernel.g.agP().afY())
              {
                ac.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.g.agS();
              Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(68377, null);
              com.tencent.mm.kernel.g.agS();
              if ((bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(68400, null), 0) != localSnsObject.CreateTime) || ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agR().agA().set(68377, localSnsObject.Username);
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agR().agA().set(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agR().agA().set(68418, com.tencent.mm.plugin.sns.data.q.wW(localSnsObject.Id));
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agR().agA().set(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.j.g.r(1, com.tencent.mm.plugin.sns.data.q.wW(localSnsObject.Id), 0);
              }
              localObject = t.aXA().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((au)((Iterator)localObject).next()).ayA();
              }
            }
            paramao.sendEmptyMessage(0);
            AppMethodBeat.o(95624);
          }
        });
        AppMethodBeat.o(95637);
        return true;
        label452:
        bool = true;
        break;
        label458:
        j += 1;
        break label184;
        label467:
        bool = false;
        break;
        label473:
        j = 0;
        paramxv = str;
      }
    }
  }
  
  public final boolean b(xv paramxv, final ao paramao)
  {
    AppMethodBeat.i(95638);
    Object localObject3;
    long l1;
    Object localObject1;
    label178:
    final boolean bool1;
    label193:
    Object localObject4;
    Object localObject5;
    int i;
    label973:
    label1111:
    Object localObject6;
    label1090:
    StringBuilder localStringBuilder;
    label1164:
    boolean bool2;
    for (;;)
    {
      long l2;
      final czu localczu;
      try
      {
        localObject3 = (czv)new czv().parseFrom(paramxv.ErM.getBuffer().toByteArray());
        l1 = ((czv)localObject3).Id;
        l2 = ((czv)localObject3).FJg;
        localczu = ((czv)localObject3).FJh;
        localObject1 = ((czv)localObject3).hkN;
        paramxv = (xv)localObject1;
        if (localObject1 == null) {
          paramxv = "";
        }
        ac.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localczu.ndI + " " + l1 + " " + paramxv);
        switch (localczu.ndI)
        {
        case 9: 
          a((czv)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(localczu.FJd, 2)) {
            break label1732;
          }
          bool1 = true;
          af.cMM().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = t.aXA().iterator();
                while (localIterator.hasNext())
                {
                  au localau = (au)localIterator.next();
                  ac.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localau.ayz();
                }
              }
              paramao.sendEmptyMessage(0);
              AppMethodBeat.o(95625);
            }
          });
          AppMethodBeat.o(95638);
          return true;
        }
      }
      catch (Exception paramxv)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxv, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramxv = af.dHW().h(l1, localczu.FIZ, localczu.ndI);
      if (paramxv != null)
      {
        paramxv.dMd();
        bool1 = af.dHW().update(paramxv.systemRowid, paramxv);
        aj.b(l1, (czv)localObject3);
        ac.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(bool1)));
        continue;
        paramxv = af.dHW().h(l1, localczu.FJb, localczu.ndI);
        if (paramxv != null)
        {
          paramxv.dMd();
          bool1 = af.dHW().update(paramxv.systemRowid, paramxv);
          aj.b(l1, (czv)localObject3);
          ac.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramxv = af.dHW();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          ac.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramxv.hpA.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramxv.doNotify();
          }
          ac.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramxv = af.dHW();
          localObject1 = localczu.Fwn;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bs.aLh((String)localObject1) + "'";
          ac.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramxv.hpA.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramxv.doNotify();
          }
          ac.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          aj.b(l1, (czv)localObject3);
          continue;
          a((czv)localObject3, localczu, l1, l2, paramxv);
          continue;
          b((czv)localObject3, localczu, l1, l2, paramxv);
          continue;
          com.tencent.mm.plugin.sns.storage.i.xD(l1);
          paramxv = af.dHR().xK(l1);
          localObject1 = paramxv.dLV();
          ((TimeLineObject)localObject1).exP = 1;
          paramxv.f((TimeLineObject)localObject1);
          af.dHR().b(l1, paramxv);
          continue;
          localObject1 = localczu.DQr;
          if (l.xe(l1))
          {
            paramxv = new l(l1, (cob)localObject1);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramxv, 0);
          }
          for (;;)
          {
            try
            {
              paramxv = ((czv)localObject3).FJh;
              localObject4 = bs.nullAsNil(((czv)localObject3).hkN);
              l2 = ((czv)localObject3).FJg;
              int j = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLimit"), 0);
              int k = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1090;
              }
              ac.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((cob)localObject1).FBm), Integer.valueOf(((cob)localObject1).FBh), Integer.valueOf(paramxv.FIZ), Integer.valueOf(j) });
              if ((((cob)localObject1).FBm == 0L) && (((cob)localObject1).FBh == 0)) {
                com.tencent.mm.plugin.report.service.h.wUl.dB(955, 4);
              }
              if (af.dHW().a(l1, paramxv.Fwn, paramxv.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((czv)localObject3).FJi;
              localObject1 = new j();
              ((j)localObject1).field_snsID = l1;
              ((j)localObject1).field_parentID = l2;
              ((j)localObject1).field_createTime = paramxv.CreateTime;
              ((j)localObject1).field_talker = paramxv.Fwn;
              ((j)localObject1).field_type = paramxv.ndI;
              ((j)localObject1).field_curActionBuf = paramxv.toByteArray();
              ((j)localObject1).field_refActionBuf = ((czu)localObject5).toByteArray();
              ((j)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.hJ(paramxv.FJd, 2)) {
                break label1741;
              }
              i = 1;
              ((j)localObject1).field_isSilence = i;
              ((j)localObject1).field_commentSvrID = paramxv.FJb;
              if (!af.dHU().xC(l1)) {
                break label1164;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (czv)localObject3, j, k, m, true))) {
                break label1111;
              }
              ac.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
            }
            catch (Exception paramxv)
            {
              ac.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxv, "", new Object[0]);
            }
            break;
            ac.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.h.wUl.dB(955, 3);
          }
          if (!a.a(l1, (czv)localObject3))
          {
            ac.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!bs.gY(paramxv.FJe)) && (paramxv.FJe.get(0) != null))
            {
              localObject3 = aj.a((dag)paramxv.FJe.get(0));
              if (az.faZ().GXZ.aOT(((EmojiInfo)localObject3).field_md5) == null)
              {
                az.faZ().GXZ.K((EmojiInfo)localObject3);
                if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaC, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.fOZ;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            af.dHW().insert((com.tencent.mm.sdk.e.c)localObject1);
            af.dHW().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.hJ(paramxv.FJd, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramxv = localObject6;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          String str = com.tencent.mm.plugin.sns.data.q.wW(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramxv = localObject6;
          ac.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramxv = localObject6;
          com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(l1);
          if (locale != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramxv = localObject6;
            localObject3 = locale.dFQ();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramxv = (xv)localObject3;
            localObject1 = locale.dFR();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxv = (xv)localObject3;
          bool2 = af.dHU().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxv = (xv)localObject3;
          af.dHW().xF(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxv = (xv)localObject3;
          com.tencent.mm.plugin.sns.storage.i.xE(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxv = (xv)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (locale != null) {
            break label1746;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxv = (xv)localObject3;
          ac.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramxv = (xv)localObject3;
          localObject5 = str;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localThrowable.toString() + ", snsId=" + (String)localObject5);
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          com.tencent.mm.plugin.sns.data.h.a(3, l1, paramxv, (com.tencent.mm.plugin.sns.storage.b)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.h.a(4, l1, paramxv, (com.tencent.mm.plugin.sns.storage.b)localObject1);
        }
        catch (Throwable paramxv)
        {
          ac.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramxv.toString() + ", snsId=" + (String)localObject5);
        }
      }
      break label178;
      label1732:
      bool1 = false;
      break label193;
      break;
      label1741:
      i = 0;
      break label973;
      label1746:
      boolean bool3 = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.g.agS();
    byte[] arrayOfByte = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((dbe)this.rr.hvr.hvw).Eki = localSKBuiltinBuffer_t;
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95631);
    return i;
  }
  
  public final int getType()
  {
    return 214;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95636);
    ac.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95636);
      return;
    }
    dbf localdbf = (dbf)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramArrayOfByte = localdbf.Ekl.ncM;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      ac.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.xRV;
      paramString.qrS = paramArrayOfByte;
      paramString.qJF.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localdbf.Eki != null) && (localdbf.Eki.getBuffer() != null))
    {
      paramArrayOfByte = localdbf.Eki.getBuffer().toByteArray();
      paramq = ad.k(((dbe)((com.tencent.mm.ak.b)paramq).hvr.hvw).Eki.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(8195, bs.cx(paramq));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95636);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    ao qJF;
    LinkedList<xv> qrS;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.qJF = new ao()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.g.agS();
          if (!com.tencent.mm.kernel.g.agP().afY())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((t.a.this.qrS == null) || (t.a.this.qrS.isEmpty()))
          {
            paramAnonymousMessage = t.this;
            dbf localdbf = (dbf)paramAnonymousMessage.rr.hvs.hvw;
            dbe localdbe = (dbe)paramAnonymousMessage.rr.hvr.hvw;
            byte[] arrayOfByte = localdbf.Eki.getBuffer().toByteArray();
            arrayOfByte = ad.k(localdbe.Eki.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().agA().set(8195, bs.cx(arrayOfByte));
            }
            localdbe.Eki.setBuffer(arrayOfByte);
            if ((localdbf.EfS & localdbe.Ekh) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (xv)t.a.this.qrS.getFirst();
          ac.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.ErL);
          t.a.this.qrS.removeFirst();
          switch (paramAnonymousMessage.ErL)
          {
          default: 
            t.a.this.qJF.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            af.dvq().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!t.this.a(paramAnonymousMessage, t.a.this.qJF)) {
                  t.a.this.qJF.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          af.dvq().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!t.this.b(paramAnonymousMessage, t.a.this.qJF)) {
                t.a.this.qJF.sendEmptyMessage(0);
              }
              AppMethodBeat.o(95627);
            }
          });
          AppMethodBeat.o(95628);
        }
      };
      AppMethodBeat.o(95629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */