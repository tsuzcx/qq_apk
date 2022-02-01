package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.a.xa;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends q
  implements com.tencent.mm.network.m
{
  private static List<bc> JVN;
  private static com.tencent.mm.plugin.sns.j.c JVP;
  private static boolean JVQ;
  private a JVO;
  com.tencent.mm.an.i callback;
  private String iRj;
  d rr;
  
  static
  {
    AppMethodBeat.i(95647);
    JVN = new LinkedList();
    JVQ = true;
    AppMethodBeat.o(95647);
  }
  
  public v()
  {
    AppMethodBeat.i(95630);
    this.iRj = "";
    this.JVO = new a();
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new d.a();
    ((d.a)localObject).lBU = new eku();
    ((d.a)localObject).lBV = new ekv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((d.a)localObject).funcId = 214;
    ((d.a)localObject).lBW = 102;
    ((d.a)localObject).respCmdId = 1000000102;
    this.rr = ((d.a)localObject).bgN();
    ((eku)d.b.b(this.rr.lBR)).SfH = 256;
    this.iRj = com.tencent.mm.model.z.bcZ();
    long l;
    byte[] arrayOfByte;
    if (JVQ)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      localObject = com.tencent.mm.kernel.h.aHG().cachePath + "ad_1100007";
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = u.aY((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      JVP = (com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom(arrayOfByte);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (JVP != null) {
        break label293;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        u.deleteFile((String)localObject);
        continue;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + JVP.KeR.size());
      }
    }
    JVQ = false;
    AppMethodBeat.o(95630);
  }
  
  public static void QE(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (JVP == null) {
      JVP = new com.tencent.mm.plugin.sns.j.c();
    }
    JVP.KeR.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void QF(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (JVP != null) {
      JVP.KeR.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean QG(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (JVP == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (JVP.KeR.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean QH(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLimit"), 0), Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLikeTimeLimit"), 0), Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(95639);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(95639);
    }
    return true;
  }
  
  public static void a(bc parambc)
  {
    AppMethodBeat.i(95645);
    if (!JVN.contains(parambc)) {
      JVN.add(parambc);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(ejj paramejj)
  {
    AppMethodBeat.i(95640);
    try
    {
      eji localeji1 = paramejj.Ulv;
      long l1 = paramejj.Id;
      Object localObject = Util.nullAsNil(paramejj.lps);
      long l2 = paramejj.Ulu;
      int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLimit"), 0);
      int j = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localeji1.rWu == 8) || (localeji1.rWu == 7)) && (!a.a(l1, paramejj, i, j, k, true)))
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localeji1.Ulp + " " + localeji1.Uln + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramejj);
        AppMethodBeat.o(95640);
        return false;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localeji1.Ulp + " " + localeji1.Uln + " actionLimit: " + i);
      if (!aj.fON().a(l1, localeji1.TWw, localeji1.CreateTime, (String)localObject))
      {
        eji localeji2 = paramejj.Ulw;
        com.tencent.mm.plugin.sns.storage.h localh = new com.tencent.mm.plugin.sns.storage.h();
        localh.field_snsID = l1;
        localh.field_parentID = l2;
        localh.field_createTime = localeji1.CreateTime;
        localh.field_talker = localeji1.TWw;
        localh.field_type = localeji1.rWu;
        localh.field_curActionBuf = localeji1.toByteArray();
        localh.field_refActionBuf = localeji2.toByteArray();
        localh.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.ki(localeji1.Ulr, 2)) {}
        for (i = 1;; i = 0)
        {
          localh.field_isSilence = i;
          if ((localeji1.rWu != 8) && (localeji1.rWu != 7)) {
            break;
          }
          localh.field_commentSvrID = localeji1.Ulp;
          if (a.a(l1, paramejj)) {
            break label552;
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localh.field_snsID + " " + localh.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localh.field_commentSvrID = localeji1.Uln;
        boolean bool = an.a(l1, paramejj);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label552:
        if ((!Util.isNullOrNil(localeji1.Uls)) && (localeji1.Uls.get(0) != null))
        {
          paramejj = an.a((eju)localeji1.Uls.get(0));
          if (bj.hyV().VFH.bxK(paramejj.field_md5) == null)
          {
            bj.hyV().VFH.L(paramejj);
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVd, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.jGI;
              com.tencent.mm.emoji.loader.e.a(paramejj, null);
            }
          }
        }
        aj.fON().insert(localh);
        aj.fON().L(l1, com.tencent.mm.plugin.sns.ui.widget.e.ki(localeji1.Ulr, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramejj)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramejj, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(ejj paramejj, eji parameji, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + parameji.Ulp + " " + parameji.Uln);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.fNC())
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!aj.fON().a(paramLong1, parameji.TWw, parameji.CreateTime, paramString))
      {
        eji localeji = paramejj.Ulw;
        com.tencent.mm.plugin.sns.storage.h localh = new com.tencent.mm.plugin.sns.storage.h();
        localh.field_snsID = paramLong1;
        localh.field_parentID = paramLong2;
        localh.field_createTime = parameji.CreateTime;
        localh.field_talker = parameji.TWw;
        localh.field_type = parameji.rWu;
        localh.field_curActionBuf = parameji.toByteArray();
        localh.field_refActionBuf = localeji.toByteArray();
        localh.field_clientId = paramString;
        localh.field_commentSvrID = parameji.Uln;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + parameji.Ulq);
        an.d(paramLong1, paramejj);
        bex();
        aj.fON().insert(localh);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramejj)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramejj.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramejj, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  public static void b(bc parambc)
  {
    AppMethodBeat.i(95646);
    JVN.remove(parambc);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(ejj paramejj, eji parameji, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + parameji.Ulp + " " + parameji.Uln);
      if (!aj.fON().a(paramLong1, parameji.TWw, parameji.CreateTime, paramString))
      {
        eji localeji = paramejj.Ulw;
        paramejj = new com.tencent.mm.plugin.sns.storage.h();
        paramejj.field_snsID = paramLong1;
        paramejj.field_parentID = paramLong2;
        paramejj.field_createTime = parameji.CreateTime;
        paramejj.field_talker = parameji.TWw;
        paramejj.field_type = parameji.rWu;
        paramejj.field_curActionBuf = parameji.toByteArray();
        paramejj.field_refActionBuf = localeji.toByteArray();
        paramejj.field_clientId = paramString;
        paramejj.field_commentSvrID = parameji.Uln;
        paramString = new cje();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + parameji.Ulq);
        paramString.parseFrom(com.tencent.mm.platformtools.z.a(parameji.Ulq));
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.gbJ);
        aj.fON().insert(paramejj);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramejj)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramejj.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramejj, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  private static void bex()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = JVN.iterator();
    while (localIterator.hasNext())
    {
      bc localbc = (bc)localIterator.next();
      if (localbc != null) {
        localbc.bex();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void fOa()
  {
    AppMethodBeat.i(95635);
    if (JVP == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().cachePath + "ad_1100007";
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = JVP.toByteArray();
      u.f((String)localObject, arrayOfByte, arrayOfByte.length);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + JVP.KeR.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void fOb()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = JVN.iterator();
    while (localIterator.hasNext())
    {
      bc localbc = (bc)localIterator.next();
      if (localbc != null) {
        localbc.bey();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public final boolean a(abu paramabu, final MMHandler paramMMHandler)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramabu.SnH.Tkb.toByteArray());
      paramabu = new String(localSnsObject.ObjectDesc.Tkb.toByteArray());
      if (paramabu.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramabu.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramabu)
    {
      l locall;
      String[] arrayOfString;
      int i;
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabu, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + com.tencent.mm.plugin.sns.data.t.Qu(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.t.Qu(localSnsObject.Id);
      locall = aj.fOM().bbr(localSnsObject.Username);
      if (Util.isNullOrNil(locall.field_newerIds)) {
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
        paramabu = paramabu + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        Log.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + locall.field_newerIds + " newer " + paramabu);
        if (i != 0) {
          aj.fOM().lg(localSnsObject.Username, paramabu);
        }
        while (aj.fOI().Rc(localSnsObject.Id))
        {
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          aj.fOM().lg(localSnsObject.Username, str);
        }
        EventCenter.instance.publish(new xa());
        aj.etE().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(v.a(v.this)))
            {
              com.tencent.mm.kernel.h.aHH();
              if (!com.tencent.mm.kernel.h.aHE().aGM())
              {
                Log.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.h.aHH();
              Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(68377, null);
              com.tencent.mm.kernel.h.aHH();
              if ((Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(68400, null), 0) != localSnsObject.CreateTime) || ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().i(68377, localSnsObject.Username);
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().i(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().i(68418, com.tencent.mm.plugin.sns.data.t.Qu(localSnsObject.Id));
                com.tencent.mm.kernel.h.aHH();
                com.tencent.mm.kernel.h.aHG().aHp().i(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.k.h.u(1, com.tencent.mm.plugin.sns.data.t.Qu(localSnsObject.Id), 0);
              }
              localObject = v.JVN.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((bc)((Iterator)localObject).next()).bew();
              }
            }
            paramMMHandler.sendEmptyMessage(0);
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
        paramabu = str;
      }
    }
  }
  
  public final boolean b(abu paramabu, final MMHandler paramMMHandler)
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
    label972:
    label1110:
    Object localObject6;
    label1089:
    StringBuilder localStringBuilder;
    label1163:
    boolean bool2;
    for (;;)
    {
      long l2;
      final eji localeji;
      try
      {
        localObject3 = (ejj)new ejj().parseFrom(paramabu.SnH.Tkb.toByteArray());
        l1 = ((ejj)localObject3).Id;
        l2 = ((ejj)localObject3).Ulu;
        localeji = ((ejj)localObject3).Ulv;
        localObject1 = ((ejj)localObject3).lps;
        paramabu = (abu)localObject1;
        if (localObject1 == null) {
          paramabu = "";
        }
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localeji.rWu + " " + l1 + " " + paramabu);
        switch (localeji.rWu)
        {
        case 9: 
          a((ejj)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.ki(localeji.Ulr, 2)) {
            break label1731;
          }
          bool1 = true;
          aj.etE().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = v.JVN.iterator();
                while (localIterator.hasNext())
                {
                  bc localbc = (bc)localIterator.next();
                  Log.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localbc.bev();
                }
              }
              paramMMHandler.sendEmptyMessage(0);
              AppMethodBeat.o(95625);
            }
          });
          AppMethodBeat.o(95638);
          return true;
        }
      }
      catch (Exception paramabu)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabu, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramabu = aj.fON().i(l1, localeji.Uln, localeji.rWu);
      if (paramabu != null)
      {
        paramabu.fSx();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(aj.fON().update(paramabu.systemRowid, paramabu))));
      }
      else
      {
        an.c(l1, (ejj)localObject3);
        continue;
        paramabu = aj.fON().i(l1, localeji.Ulp, localeji.rWu);
        if (paramabu != null)
        {
          paramabu.fSx();
          bool1 = aj.fON().update(paramabu.systemRowid, paramabu);
          an.b(l1, (ejj)localObject3);
          Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramabu = aj.fON();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          Log.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramabu.lvy.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramabu.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramabu = aj.fON();
          localObject1 = localeji.TWw;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + Util.escapeSqlValue((String)localObject1) + "'";
          Log.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramabu.lvy.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramabu.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          an.b(l1, (ejj)localObject3);
          continue;
          a((ejj)localObject3, localeji, l1, l2, paramabu);
          continue;
          b((ejj)localObject3, localeji, l1, l2, paramabu);
          continue;
          com.tencent.mm.plugin.sns.storage.g.QZ(l1);
          paramabu = aj.fOI().Rd(l1);
          localObject1 = paramabu.getTimeLine();
          ((TimeLineObject)localObject1).showFlag = 1;
          paramabu.setTimeLine((TimeLineObject)localObject1);
          aj.fOI().b(l1, paramabu);
          continue;
          localObject1 = localeji.RJc;
          if (m.QA(l1))
          {
            paramabu = new m(l1, (dwf)localObject1);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramabu, 0);
          }
          for (;;)
          {
            try
            {
              paramabu = ((ejj)localObject3).Ulv;
              localObject4 = Util.nullAsNil(((ejj)localObject3).lps);
              l2 = ((ejj)localObject3).Ulu;
              int j = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLimit"), 0);
              int k = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1089;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((dwf)localObject1).Ucl), Integer.valueOf(((dwf)localObject1).Ucg), Integer.valueOf(paramabu.Uln), Integer.valueOf(j) });
              if ((((dwf)localObject1).Ucl == 0L) && (((dwf)localObject1).Ucg == 0)) {
                com.tencent.mm.plugin.report.service.h.IzE.el(955, 4);
              }
              if (aj.fON().a(l1, paramabu.TWw, paramabu.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((ejj)localObject3).Ulw;
              localObject1 = new com.tencent.mm.plugin.sns.storage.h();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID = l1;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_parentID = l2;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_createTime = paramabu.CreateTime;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker = paramabu.TWw;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type = paramabu.rWu;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_curActionBuf = paramabu.toByteArray();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_refActionBuf = ((eji)localObject5).toByteArray();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.ki(paramabu.Ulr, 2)) {
                break label1740;
              }
              i = 1;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence = i;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID = paramabu.Ulp;
              if (!aj.fOL().QY(l1)) {
                break label1163;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (ejj)localObject3, j, k, m, true))) {
                break label1110;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID);
            }
            catch (Exception paramabu)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabu, "", new Object[0]);
            }
            break;
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.h.IzE.el(955, 3);
          }
          if (!a.a(l1, (ejj)localObject3))
          {
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!Util.isNullOrNil(paramabu.Uls)) && (paramabu.Uls.get(0) != null))
            {
              localObject3 = an.a((eju)paramabu.Uls.get(0));
              if (bj.hyV().VFH.bxK(((EmojiInfo)localObject3).field_md5) == null)
              {
                bj.hyV().VFH.L((EmojiInfo)localObject3);
                if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVd, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.jGI;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            aj.fON().insert((IAutoDBItem)localObject1);
            aj.fON().L(l1, com.tencent.mm.plugin.sns.ui.widget.e.ki(paramabu.Ulr, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramabu = localObject6;
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
          String str = com.tencent.mm.plugin.sns.data.t.Qu(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramabu = localObject6;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramabu = localObject6;
          AdSnsInfo localAdSnsInfo = aj.fOL().QX(l1);
          if (localAdSnsInfo != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramabu = localObject6;
            localObject3 = localAdSnsInfo.getAdInfo();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramabu = (abu)localObject3;
            localObject1 = localAdSnsInfo.getAdXml();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabu = (abu)localObject3;
          bool2 = aj.fOL().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabu = (abu)localObject3;
          aj.fON().Rb(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabu = (abu)localObject3;
          com.tencent.mm.plugin.sns.storage.g.Ra(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabu = (abu)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (localAdSnsInfo != null) {
            break label1745;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabu = (abu)localObject3;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramabu = (abu)localObject3;
          localObject5 = str;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localThrowable.toString() + ", snsId=" + (String)localObject5);
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          k.a(3, l1, paramabu, (ADXml)localObject1);
          if (!bool1) {
            break;
          }
          k.a(4, l1, paramabu, (ADXml)localObject1);
        }
        catch (Throwable paramabu)
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramabu.toString() + ", snsId=" + (String)localObject5);
        }
      }
      break label178;
      label1731:
      bool1 = false;
      break label193;
      break;
      label1740:
      i = 0;
      break label972;
      label1745:
      boolean bool3 = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.h.aHH();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8195, null)));
    eae localeae = new eae();
    localeae.dc(arrayOfByte);
    ((eku)d.b.b(this.rr.lBR)).SfI = localeae;
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95631);
    return i;
  }
  
  public final int getType()
  {
    return 214;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95636);
    Log.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95636);
      return;
    }
    ekv localekv = (ekv)d.c.b(((d)params).lBS);
    paramArrayOfByte = localekv.SfL.rVy;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.JVO;
      paramString.wqP = paramArrayOfByte;
      paramString.wHD.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localekv.SfI != null) && (localekv.SfI.Tkb != null))
    {
      paramArrayOfByte = localekv.SfI.Tkb.toByteArray();
      params = ad.n(((eku)d.b.b(((d)params).lBR)).SfI.Tkb.toByteArray(), paramArrayOfByte);
      if ((params != null) && (params.length > 0))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().i(8195, Util.encodeHexString(params));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95636);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    MMHandler wHD;
    LinkedList<abu> wqP;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.wHD = new MMHandler()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.h.aHH();
          if (!com.tencent.mm.kernel.h.aHE().aGM())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((v.a.this.wqP == null) || (v.a.this.wqP.isEmpty()))
          {
            paramAnonymousMessage = v.this;
            ekv localekv = (ekv)d.c.b(paramAnonymousMessage.rr.lBS);
            eku localeku = (eku)d.b.b(paramAnonymousMessage.rr.lBR);
            byte[] arrayOfByte = localekv.SfI.Tkb.toByteArray();
            arrayOfByte = ad.n(localeku.SfI.Tkb.toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(8195, Util.encodeHexString(arrayOfByte));
            }
            localeku.SfI.dc(arrayOfByte);
            if ((localekv.Saq & localeku.SfH) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (abu)v.a.this.wqP.getFirst();
          Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.SnG);
          v.a.this.wqP.removeFirst();
          switch (paramAnonymousMessage.SnG)
          {
          default: 
            v.a.this.wHD.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            aj.fwa().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!v.this.a(paramAnonymousMessage, v.a.this.wHD)) {
                  v.a.this.wHD.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          aj.fwa().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!v.this.b(paramAnonymousMessage, v.a.this.wHD)) {
                v.a.this.wHD.sendEmptyMessage(0);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */