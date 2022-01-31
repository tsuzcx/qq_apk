package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private static List<ar> rfc;
  private static c rfe;
  private static boolean rff;
  com.tencent.mm.ai.f callback;
  private String dZZ;
  private u.a rfd;
  com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(36322);
    rfc = new LinkedList();
    rff = true;
    AppMethodBeat.o(36322);
  }
  
  public u()
  {
    AppMethodBeat.i(36305);
    this.dZZ = "";
    this.rfd = new u.a(this);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new b.a();
    ((b.a)localObject).fsX = new cev();
    ((b.a)localObject).fsY = new cew();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((b.a)localObject).funcId = 214;
    ((b.a)localObject).reqCmdId = 102;
    ((b.a)localObject).respCmdId = 1000000102;
    this.rr = ((b.a)localObject).ado();
    ((cev)this.rr.fsV.fta).wFQ = 256;
    this.dZZ = r.Zn();
    long l;
    byte[] arrayOfByte;
    if (rff)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.RM();
      localObject = com.tencent.mm.kernel.g.RL().cachePath + "ad_1100007";
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.e.i((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      rfe = (c)new c().parseFrom(arrayOfByte);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (rfe != null) {
        break label293;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.e.deleteFile((String)localObject);
        continue;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + rfe.rlL.size());
      }
    }
    rff = false;
    AppMethodBeat.o(36305);
  }
  
  public static void a(ar paramar)
  {
    AppMethodBeat.i(36320);
    if (!rfc.contains(paramar)) {
      rfc.add(paramar);
    }
    AppMethodBeat.o(36320);
  }
  
  private static boolean a(cdn paramcdn)
  {
    AppMethodBeat.i(36315);
    try
    {
      cdm localcdm1 = paramcdn.xOe;
      long l1 = paramcdn.Id;
      String str = bo.nullAsNil(paramcdn.pIw);
      long l2 = paramcdn.xOd;
      int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLimit"), 0);
      int j = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localcdm1.jKs == 8) || (localcdm1.jKs == 7)) && (!a.a(l1, paramcdn, i, j, k, true)))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + l1 + " " + localcdm1.xOa + " " + localcdm1.xNY + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramcdn);
        AppMethodBeat.o(36315);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + l1 + " " + localcdm1.xOa + " " + localcdm1.xNY + " actionLimit: " + i);
      if (!ag.cpk().a(l1, localcdm1.xCG, localcdm1.CreateTime, str))
      {
        cdm localcdm2 = paramcdn.xOf;
        j localj = new j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = localcdm1.CreateTime;
        localj.field_talker = localcdm1.xCG;
        localj.field_type = localcdm1.jKs;
        localj.field_curActionBuf = localcdm1.toByteArray();
        localj.field_refActionBuf = localcdm2.toByteArray();
        localj.field_clientId = str;
        if (d.fS(localcdm1.xOc, 2)) {}
        for (i = 1;; i = 0)
        {
          localj.field_isSilence = i;
          if ((localcdm1.jKs != 8) && (localcdm1.jKs != 7)) {
            break;
          }
          localj.field_commentSvrID = localcdm1.xOa;
          if (a.a(l1, paramcdn)) {
            break label548;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          AppMethodBeat.o(36315);
          return false;
        }
        localj.field_commentSvrID = localcdm1.xNY;
        boolean bool = ak.a(l1, paramcdn);
        if (!bool)
        {
          AppMethodBeat.o(36315);
          return false;
        }
        label548:
        ag.cpk().insert(localj);
        ag.cpk().z(l1, d.fS(localcdm1.xOc, 2));
        AppMethodBeat.o(36315);
        return true;
      }
      AppMethodBeat.o(36315);
      return false;
    }
    catch (Exception paramcdn)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcdn, "", new Object[0]);
      AppMethodBeat.o(36315);
    }
    return false;
  }
  
  private static boolean a(cdn paramcdn, cdm paramcdm, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(36316);
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramcdm.xOa + " " + paramcdm.xNY);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.cnX())
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(36316);
        return false;
      }
      if (!ag.cpk().a(paramLong1, paramcdm.xCG, paramcdm.CreateTime, paramString))
      {
        cdm localcdm = paramcdn.xOf;
        j localj = new j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = paramcdm.CreateTime;
        localj.field_talker = paramcdm.xCG;
        localj.field_type = paramcdm.jKs;
        localj.field_curActionBuf = paramcdm.toByteArray();
        localj.field_refActionBuf = localcdm.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = paramcdm.xNY;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramcdm.xOb);
        ak.c(paramLong1, paramcdn);
        aao();
        ag.cpk().insert(localj);
        AppMethodBeat.o(36316);
        return true;
      }
      AppMethodBeat.o(36316);
      return false;
    }
    catch (Exception paramcdn)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramcdn.getMessage());
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcdn, "", new Object[0]);
      AppMethodBeat.o(36316);
    }
    return false;
  }
  
  private static void aao()
  {
    AppMethodBeat.i(36319);
    Iterator localIterator = rfc.iterator();
    while (localIterator.hasNext())
    {
      ar localar = (ar)localIterator.next();
      if (localar != null) {
        localar.aao();
      }
    }
    AppMethodBeat.o(36319);
  }
  
  public static void b(ar paramar)
  {
    AppMethodBeat.i(36321);
    rfc.remove(paramar);
    AppMethodBeat.o(36321);
  }
  
  private static boolean b(cdn paramcdn, cdm paramcdm, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(36317);
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramcdm.xOa + " " + paramcdm.xNY);
      if (!ag.cpk().a(paramLong1, paramcdm.xCG, paramcdm.CreateTime, paramString))
      {
        cdm localcdm = paramcdn.xOf;
        paramcdn = new j();
        paramcdn.field_snsID = paramLong1;
        paramcdn.field_parentID = paramLong2;
        paramcdn.field_createTime = paramcdm.CreateTime;
        paramcdn.field_talker = paramcdm.xCG;
        paramcdn.field_type = paramcdm.jKs;
        paramcdn.field_curActionBuf = paramcdm.toByteArray();
        paramcdn.field_refActionBuf = localcdm.toByteArray();
        paramcdn.field_clientId = paramString;
        paramcdn.field_commentSvrID = paramcdm.xNY;
        paramString = new aur();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramcdm.xOb);
        paramString.parseFrom(aa.a(paramcdm.xOb));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.cNd);
        ag.cpk().insert(paramcdn);
        AppMethodBeat.o(36317);
        return true;
      }
      AppMethodBeat.o(36317);
      return false;
    }
    catch (Exception paramcdn)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramcdn.getMessage());
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcdn, "", new Object[0]);
      AppMethodBeat.o(36317);
    }
    return false;
  }
  
  public static void coA()
  {
    AppMethodBeat.i(36310);
    if (rfe == null)
    {
      AppMethodBeat.o(36310);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().cachePath + "ad_1100007";
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = rfe.toByteArray();
      com.tencent.mm.vfs.e.b((String)localObject, arrayOfByte, arrayOfByte.length);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + rfe.rlL.size());
      AppMethodBeat.o(36310);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(36310);
    }
  }
  
  public static void coB()
  {
    AppMethodBeat.i(36318);
    Iterator localIterator = rfc.iterator();
    while (localIterator.hasNext())
    {
      ar localar = (ar)localIterator.next();
      if (localar != null) {
        localar.aap();
      }
    }
    AppMethodBeat.o(36318);
  }
  
  public static void lC(long paramLong)
  {
    AppMethodBeat.i(36307);
    if (rfe == null) {
      rfe = new c();
    }
    rfe.rlL.add(Long.valueOf(paramLong));
    AppMethodBeat.o(36307);
  }
  
  public static void lD(long paramLong)
  {
    AppMethodBeat.i(36308);
    if (rfe != null) {
      rfe.rlL.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(36308);
  }
  
  public static boolean lE(long paramLong)
  {
    AppMethodBeat.i(36309);
    if (rfe == null)
    {
      AppMethodBeat.o(36309);
      return false;
    }
    if (rfe.rlL.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(36309);
      return true;
    }
    AppMethodBeat.o(36309);
    return false;
  }
  
  public static boolean lF(long paramLong)
  {
    AppMethodBeat.i(36314);
    try
    {
      boolean bool = a.a(paramLong, null, bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLimit"), 0), bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLikeTimeLimit"), 0), bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(36314);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(36314);
    }
    return true;
  }
  
  public final boolean a(ud paramud, com.tencent.mm.sdk.platformtools.ak paramak)
  {
    AppMethodBeat.i(36312);
    SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramud.wMD.getBuffer().toByteArray());
      paramud = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramud.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramud.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramud)
    {
      l locall;
      String[] arrayOfString;
      int i;
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramud, "", new Object[0]);
      AppMethodBeat.o(36312);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + com.tencent.mm.plugin.sns.data.i.lq(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.i.lq(localSnsObject.Id);
      locall = ag.cpj().abz(localSnsObject.Username);
      if (bo.isNullOrNil(locall.field_newerIds)) {
        break label374;
      }
      arrayOfString = locall.field_newerIds.split(",");
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
        paramud = paramud + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + locall.field_newerIds + " newer " + paramud);
        if (i != 0) {
          ag.cpj().gF(localSnsObject.Username, paramud);
        }
        while (ag.cpf().lR(localSnsObject.Id))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(36312);
          return false;
          label374:
          ag.cpj().gF(localSnsObject.Username, str);
        }
        com.tencent.mm.sdk.b.a.ymk.l(new rx());
        ag.bEf().post(new u.1(this, localSnsObject, paramak));
        AppMethodBeat.o(36312);
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
        paramud = str;
      }
    }
  }
  
  public final boolean b(ud paramud, com.tencent.mm.sdk.platformtools.ak paramak)
  {
    AppMethodBeat.i(36313);
    cdn localcdn;
    long l1;
    long l2;
    Object localObject1;
    label174:
    boolean bool;
    label189:
    Object localObject2;
    for (;;)
    {
      cdm localcdm;
      try
      {
        localcdn = (cdn)new cdn().parseFrom(paramud.wMD.getBuffer().toByteArray());
        l1 = localcdn.Id;
        l2 = localcdn.xOd;
        localcdm = localcdn.xOe;
        localObject1 = localcdn.pIw;
        paramud = (ud)localObject1;
        if (localObject1 == null) {
          paramud = "";
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localcdm.jKs + " " + l1 + " " + paramud);
        switch (localcdm.jKs)
        {
        case 9: 
          a(localcdn);
          if (d.fS(localcdm.xOc, 2)) {
            break label1167;
          }
          bool = true;
          ag.bEf().post(new u.2(this, bool, localcdm, paramak));
          AppMethodBeat.o(36313);
          return true;
        }
      }
      catch (Exception paramud)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramud, "", new Object[0]);
        AppMethodBeat.o(36313);
        return false;
      }
      paramud = ag.cpk().f(l1, localcdm.xNY, localcdm.jKs);
      if (paramud != null)
      {
        paramud.csp();
        bool = ag.cpk().update(paramud.systemRowid, paramud);
        ak.b(l1, localcdn);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(bool)));
        continue;
        paramud = ag.cpk().f(l1, localcdm.xOa, localcdm.jKs);
        if (paramud != null)
        {
          paramud.csp();
          bool = ag.cpk().update(paramud.systemRowid, paramud);
          ak.b(l1, localcdn);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool)));
          continue;
          paramud = ag.cpk();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool = paramud.fnw.execSQL("SnsComment", (String)localObject1);
          if (bool) {
            paramud.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool)));
          continue;
          paramud = ag.cpk();
          localObject1 = localcdm.xCG;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bo.wC((String)localObject1) + "'";
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool = paramud.fnw.execSQL("SnsComment", (String)localObject1);
          if (bool) {
            paramud.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool)));
          ak.b(l1, localcdn);
          continue;
          a(localcdn, localcdm, l1, l2, paramud);
          continue;
          b(localcdn, localcdm, l1, l2, paramud);
          continue;
          com.tencent.mm.plugin.sns.storage.i.lS(l1);
          paramud = ag.cpf().lZ(l1);
          localObject1 = paramud.csh();
          ((TimeLineObject)localObject1).dqG = 1;
          paramud.c((TimeLineObject)localObject1);
          ag.cpf().b(l1, paramud);
          continue;
          localObject2 = localcdm.wpo;
          if (m.ly(l1))
          {
            paramud = new m(l1, (btk)localObject2);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(paramud, 0);
          }
        }
      }
    }
    for (;;)
    {
      j localj;
      try
      {
        paramud = localcdn.xOe;
        localObject1 = bo.nullAsNil(localcdn.pIw);
        l2 = localcdn.xOd;
        int j = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLimit"), 0);
        int k = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyLikeTimeLimit"), 0);
        int m = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SnsAdNotifyCommentTimeLimit"), 0);
        if (localObject2 == null) {
          break label1064;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject1, Long.valueOf(l1), Integer.valueOf(((btk)localObject2).xGU), Integer.valueOf(paramud.xNY), Integer.valueOf(j) });
        if (((btk)localObject2).xGU == 0) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(955, 4);
        }
        if (ag.cpk().a(l1, paramud.xCG, paramud.CreateTime, (String)localObject1)) {
          break label174;
        }
        localObject2 = localcdn.xOf;
        localj = new j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = paramud.CreateTime;
        localj.field_talker = paramud.xCG;
        localj.field_type = paramud.jKs;
        localj.field_curActionBuf = paramud.toByteArray();
        localj.field_refActionBuf = ((cdm)localObject2).toByteArray();
        localj.field_clientId = ((String)localObject1);
        if (!d.fS(paramud.xOc, 2)) {
          break label1176;
        }
        i = 1;
        localj.field_isSilence = i;
        localj.field_commentSvrID = paramud.xOa;
        if (!ag.cpi().lR(l1)) {
          break label1138;
        }
        if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, localcdn, j, k, m, true))) {
          break label1085;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
      }
      catch (Exception paramud)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramud, "", new Object[0]);
      }
      break label174;
      label1064:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
      com.tencent.mm.plugin.report.service.h.qsU.cT(955, 3);
      continue;
      label1085:
      if (!a.a(l1, localcdn))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
        break label174;
      }
      label1138:
      ag.cpk().insert(localj);
      ag.cpk().z(l1, d.fS(paramud.xOc, 2));
      break label174;
      label1167:
      bool = false;
      break label189;
      break;
      label1176:
      int i = 0;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.kernel.g.RM();
    byte[] arrayOfByte = bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cev)this.rr.fsV.fta).wFR = localSKBuiltinBuffer_t;
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36306);
    return i;
  }
  
  public final int getType()
  {
    return 214;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36311);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36311);
      return;
    }
    cew localcew = (cew)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramArrayOfByte = localcew.wFU.jJv;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.rfd;
      paramString.mcO = paramArrayOfByte;
      paramString.mur.sendEmptyMessage(0);
      AppMethodBeat.o(36311);
      return;
    }
    if ((localcew.wFR != null) && (localcew.wFR.getBuffer() != null))
    {
      paramArrayOfByte = localcew.wFR.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ab.j(((cev)((com.tencent.mm.ai.b)paramq).fsV.fta).wFR.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(8195, bo.cg(paramq));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(36311);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */